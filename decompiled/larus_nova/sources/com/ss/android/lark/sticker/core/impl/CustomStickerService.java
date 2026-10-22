package com.ss.android.lark.sticker.core.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.CreateCustomizedStickersRequest;
import com.bytedance.lark.pb.im.v1.CreateCustomizedStickersResponse;
import com.bytedance.lark.pb.im.v1.DeleteCustomizedStickersRequest;
import com.bytedance.lark.pb.im.v1.DeleteCustomizedStickersResponse;
import com.bytedance.lark.pb.im.v1.GetCustomizedStickersRequest;
import com.bytedance.lark.pb.im.v1.GetCustomizedStickersResponse;
import com.bytedance.lark.pb.im.v1.ImageKeyData;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.upload.k;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.sticker.core.model.StickerFileInfo;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$deleteStickers$2$1;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$getCustomStickers$2$1;
import com.ss.android.lark.sticker_office.ui.custom_sticker.panel.OfficeCustomStickerModel$uploadStickers$2$1;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class CustomStickerService extends c0c.c implements e6c.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f440792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f440793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a6c.a f440794d;

    public static final class a {
    }

    static {
    }

    @Override // e6c.c
    public final StickerFileInfo Uc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        List<String> r101 = CollectionsKt.listOf(r100);
        HashMap r102 = new HashMap();
        String r103 = this.f440793c;
        if (TextUtils.isEmpty("") == true) goto L5;
        LarkContext.getApplication();
        r103 = com.ss.android.lark.sticker.core.utils.c.b("");
    L5:
        Map<String, c6c.a> r104 = this.f440794d.a(r103, r101);
        if (r104 == null) goto L15;
        Iterator<c6c.a> r105 = r104.values().iterator();
    L10:
        if (r105.hasNext() == false) goto L15;
        c6c.a r106 = r105.next();
        if (r106 == null) goto L10;
        StickerFileInfo r107 = new StickerFileInfo();
        String r108 = r106.f22630a;
        r107.setKey(r108);
        r107.setFilePath(r106.f22631b);
        r107.setUrl(r106.f22631b);
        r102.put(r108, r107);
    L15:
        return (StickerFileInfo) r102.get(r100);
    }

    @Override // e6c.c
    public final Sticker y(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        GetCustomizedStickersRequest.Builder r100 = new GetCustomizedStickersRequest.Builder().sync_data_strategy(SyncDataStrategy.LOCAL);
        l r101 = this.f440792b;
        Intrinsics.checkNotNull(r100);
        GetCustomizedStickersResponse r102 = (GetCustomizedStickersResponse) t.c(r101.h(new com.bytedance.lark.rustclient.api.d(r100, GetCustomizedStickersResponse.ADAPTER, Command.GET_CUSTOMIZED_STICKERS, null, null, null, null, 248)).execute(), null);
        if (r102 == null) goto L5;
        List<Sticker> r103 = d6c.b.b(r102.stickers);
    L6:
        List<Sticker> r104 = r103;
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        return null;
    L15:
        Iterator<Sticker> r106 = r103.iterator();
    L17:
        if (r106.hasNext() == false) goto L21;
        Sticker r107 = r106.next();
        if (TextUtils.equals(r107.getOriginImageKey(), r110) == false) goto L17;
        return r107;
    L21:
        return null;
    L9:
        if (r104.isEmpty() == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Inject
    public CustomStickerService(m r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "rustClient");
        super(r100);
        this.f440792b = r101;
        LarkContext.getApplication();
        this.f440793c = com.ss.android.lark.sticker.core.utils.c.a();
        a6c.b.f1983a.getClass();
        this.f440794d = ((a6c.b) ClaymoreServiceLoader.loadFirst(a6c.b.class)).getResourceDependency();
    }

    public static final ErrorResult m(CustomStickerService r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof ErrorResult) == false) goto L6;
        return (ErrorResult) r101;
    L6:
        if ((r101 instanceof Exception) == false) goto L8;
        Exception r102 = (Exception) r101;
    L12:
        if (r101 == null) goto L15;
        String r103 = r101.getMessage();
        if (r103 == null) goto L15;
    L17:
        return new ErrorResult(r103, r102);
    L15:
        r103 = "";
        goto L17
    L8:
        if (r101 == null) goto L10;
        r102 = new Exception(r101);
        goto L12
    L10:
        r102 = null;
        goto L12
    }

    @Override // e6c.c
    public final void cf(List r110, final OfficeCustomStickerModel$deleteStickers$2$1 r111) {
        Intrinsics.checkNotNullParameter(r110, "stickerList");
        Intrinsics.checkNotNullParameter(r111, "callback");
        List<com.bytedance.lark.pb.im.v1.Sticker> r112 = d6c.a.b(r110);
        DeleteCustomizedStickersRequest.Builder r100 = new DeleteCustomizedStickersRequest.Builder().stickers(r112);
        final IGetDataCallback<List<? extends Sticker>> r113 = new CustomStickerService$getAPIDataReadyCallback$1(this, r111);
        l r114 = this.f440792b;
        Intrinsics.checkNotNull(r100);
        t.a(r114.h(new com.bytedance.lark.rustclient.api.d(r100, DeleteCustomizedStickersResponse.ADAPTER, Command.DELETE_CUSTOMIZED_STICKERS, null, null, null, null, 248)).a(), new CustomStickerService$deleteStickers$1(r113), new CustomStickerService$deleteStickers$2(r113), new CustomStickerService$deleteStickers$3(r113, this));
    }

    @Override // e6c.c
    public final void de(boolean r110, final OfficeCustomStickerModel$getCustomStickers$2$1 r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        GetCustomizedStickersRequest.Builder r100 = new GetCustomizedStickersRequest.Builder();
        if (r110 == false) goto L5;
        r100.sync_data_strategy(SyncDataStrategy.LOCAL);
    L6:
        t.a(this.f440792b.h(new com.bytedance.lark.rustclient.api.d(r100, GetCustomizedStickersResponse.ADAPTER, Command.GET_CUSTOMIZED_STICKERS, null, null, null, null, 248)).a(), new CustomStickerService$getCustomStickers$1(r111), new CustomStickerService$getCustomStickers$2(r111), new CustomStickerService$getCustomStickers$3(r111, this));
        return;
    L5:
        r100.sync_data_strategy(SyncDataStrategy.FORCE_SERVER);
        goto L6
    }

    @Override // e6c.c
    public final void n0(final List<? extends Sticker> r110, final IGetDataCallback<Boolean> r111) {
        Intrinsics.checkNotNullParameter(r110, "stickerList");
        Intrinsics.checkNotNullParameter(r111, "callback");
        CreateCustomizedStickersRequest.Builder r100 = new CreateCustomizedStickersRequest.Builder().type(CreateCustomizedStickersRequest.Type.KEY).stickers(d6c.a.b(r110));
        final long r101 = SystemClock.elapsedRealtime();
        final Function1<ErrorResult, Unit> r112 = new CustomStickerService$putStickers$errorHandler$1(r101, r110, r111);
        l r113 = this.f440792b;
        Intrinsics.checkNotNull(r100);
        t.a(r113.h(new com.bytedance.lark.rustclient.api.d(r100, CreateCustomizedStickersResponse.ADAPTER, Command.CREATE_CUSTOMIZED_STICKERS, null, null, null, null, 248)).a(), new CustomStickerService$putStickers$1(r101, r110, r111), new CustomStickerService$putStickers$2(r112), new CustomStickerService$putStickers$3(r112, this));
    }

    @Override // e6c.c
    public final void Pa(List r110, boolean r111, OfficeCustomStickerModel$uploadStickers$2$1 r112) {
        Intrinsics.checkNotNullParameter(r110, "stickerUrls");
        Intrinsics.checkNotNullParameter(r112, "callback");
        ArrayList r100 = new ArrayList();
        Iterator r101 = r110.iterator();
    L4:
        if (r101.hasNext() == false) goto L19;
        String r102 = (String) r101.next();
        com.ss.android.lark.image.uploader.entity.b.a r103 = new com.ss.android.lark.image.uploader.entity.b.a();
        r103.c(r102);
        com.ss.android.lark.image.uploader.entity.b r104 = r103.b();
        int r105 = alb.b.a(r104);
        if (r105 == (-10002)) goto L7;
        VFSFile r106 = VFSFiles.c(VFSFiles.f444819b).i(r102);
        if (r105 != 0) goto L11;
        if (alb.c.a(r104, null) != 0) goto L15;
        r100.add(r102);
        goto L4
    L15:
        r112.onError(new ErrorResult(3, r106.getName()));
        return;
    L11:
        Exception r107 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        String r108 = r106.getName();
        String r109 = r106.getName();
        ErrorResult r113 = new ErrorResult(0);
        ErrorResult.access$002(r113, 1);
        ErrorResult.access$102(r113, -9999);
        ErrorResult.access$202(r113, 0);
        ErrorResult.access$302(r113, r107);
        ErrorResult.access$402(r113, "");
        ErrorResult.access$502(r113, r109);
        ErrorResult.access$602(r113, r108);
        ErrorResult.access$702(r113, "");
        ErrorResult.access$802(r113, 0);
        ErrorResult.access$902(r113, null);
        ErrorResult.access$1002(r113, null);
        ErrorResult.access$1102(r113, null);
        r112.onError(r113);
        return;
    L7:
        Exception r114 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ErrorResult r115 = new ErrorResult(0);
        ErrorResult.access$002(r115, 2);
        ErrorResult.access$102(r115, -9999);
        ErrorResult.access$202(r115, 0);
        ErrorResult.access$302(r115, r114);
        ErrorResult.access$402(r115, "");
        ErrorResult.access$502(r115, "file not exist");
        ErrorResult.access$602(r115, "");
        ErrorResult.access$702(r115, "");
        ErrorResult.access$802(r115, 0);
        ErrorResult.access$902(r115, null);
        ErrorResult.access$1002(r115, null);
        ErrorResult.access$1102(r115, null);
        r112.onError(r115);
        return;
    L19:
        if (r100.size() != 0) goto L22;
        r112.onError(new ErrorResult(2, "no result"));
        return;
    L22:
        long r116 = SystemClock.elapsedRealtime();
        ArrayList r117 = new ArrayList();
        Iterator r118 = r100.iterator();
    L24:
        if (r118.hasNext() == false) goto L26;
        String r119 = (String) r118.next();
        com.ss.android.lark.image.uploader.entity.b.a r120 = new com.ss.android.lark.image.uploader.entity.b.a();
        r120.c(r119);
        r120.a(Biz.Messenger);
        r120.d(Scene.Chat);
        r120.f426404d = 3;
        Intrinsics.checkNotNullParameter("StickerUpload", "page");
        r120.f426405e = "StickerUpload";
        r120.f426407g = r111;
        r117.add(r120.b());
        goto L24
    L26:
        e r121 = new e(r116, r117, r112);
        flb.a.C5924a r122 = new flb.a.C5924a();
        r122.f477764b = true;
        flb.a r123 = new flb.a(r122.f477763a, true);
        int r124 = ykb.a.f568290b;
        ykb.a r125 = ykb.a.C8350a.a(LarkContext.getApplication());
        Intrinsics.checkNotNullParameter(r117, "imageList");
        ImageUploadTask r126 = r125.f568291a;
        r126.getClass();
        Intrinsics.checkNotNullParameter(r117, "imageList");
        r126.f426376b.addAll(r117);
        r125.f568291a.f426378d = r123;
        r125.a(r121);
        r125.f568291a.f426381g = new k();
        r125.c();
    }

    @Override // e6c.c
    public final void saveImage2Stickers(String r110, String r111, final IGetDataCallback<Boolean> r112) {
        Intrinsics.checkNotNullParameter(r110, "imageKey");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r112, "callback");
        ArrayList r100 = new ArrayList();
        r100.add(new ImageKeyData.Builder().image_key(r110).message_id(r111).build());
        CreateCustomizedStickersRequest.Builder r101 = new CreateCustomizedStickersRequest.Builder().type(CreateCustomizedStickersRequest.Type.IMAGE_KEY_V1).image_infos(r100);
        final long r113 = SystemClock.elapsedRealtime();
        final Function1<ErrorResult, Unit> r102 = new CustomStickerService$saveImage2Stickers$errorHandler$1(r113, r112);
        l r114 = this.f440792b;
        Intrinsics.checkNotNull(r101);
        t.a(r114.h(new com.bytedance.lark.rustclient.api.d(r101, CreateCustomizedStickersResponse.ADAPTER, Command.CREATE_CUSTOMIZED_STICKERS, null, null, null, null, 248)).a(), new AnonymousClass1(r113, r112), new AnonymousClass2(r102), new AnonymousClass3(r102, this));
    }
}
