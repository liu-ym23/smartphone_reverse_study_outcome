package com.larus.uaigc.chat.markdown.image.component;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.share.ShareScene;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.b1;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.message.CreationTaskType;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.uaigc.chat.markdown.helper.j0;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationShareService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class ImageOperatorComponent implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f371097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f371098b;

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final View a() {
        return this.f371097a.a();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> b() {
        return this.f371097a.b();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final Function1<Continuation<? super Message>, Object> c() {
        return this.f371097a.c();
    }

    @Override // com.larus.uaigc.chat.markdown.image.component.d
    public final String getLogTag() {
        return this.f371097a.getLogTag();
    }

    public ImageOperatorComponent(d r100) {
        Intrinsics.checkNotNullParameter(r100, "depend");
        this.f371097a = r100;
    }

    public final Object d(Message r100, ImageInfo r101, JSONObject r102, Continuation<? super df8.a> r110) {
        if ((r110 instanceof ImageOperatorComponent$generateImageItemInfo$1) == false) goto L7;
        ImageOperatorComponent$generateImageItemInfo$1 r103 = (ImageOperatorComponent$generateImageItemInfo$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        int r107 = r103.I$0;
        ImageItem r108 = (ImageItem) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L63:
        return new df8.a(r107, r108, null, (Map) r111);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r109 = r103.I$0;
        ImageItem r112 = (ImageItem) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L31:
        return new df8.a(r109, r112, null, (Map) r111);
    L16:
        ResultKt.throwOnFailure(r111);
        if (r100 != null) goto L19;
        return null;
    L19:
        if (r101 != null) goto L22;
        return null;
    L22:
        if (com.larus.bmhome.chat.bean.d.k(r100) == false) goto L32;
        if (r102 == null) goto L25;
        int r113 = r102.optInt("position");
    L26:
        int r114 = r113 - 1;
        r112 = j0.g(r101);
        Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> r115 = b();
        r103.L$0 = r112;
        r103.I$0 = r114;
        r103.label = 1;
        r111 = r115.invoke(r100, r103);
        if (r111 != r105) goto L29;
        return r105;
    L29:
        r109 = r114;
        goto L31
    L25:
        r113 = 1;
        goto L26
    L32:
        Map<String, CreationTask> r116 = j0.c(dp8.e.c(r100));
        if (r116 == null) goto L37;
        Collection<CreationTask> r117 = r116.values();
        if (r117 == null) goto L37;
        List r118 = CollectionsKt.toList(r117);
    L38:
        if (r118 != null) goto L40;
        r118 = CollectionsKt.emptyList();
    L40:
        Iterator r119 = r118.iterator();
        int r120 = 0;
    L42:
        if (r119.hasNext() == false) goto L57;
        CreationTask r121 = (CreationTask) r119.next();
        if (r121 == null) goto L52;
        CreationAsset r122 = r121.asset;
        if (r122 == null) goto L52;
        UserCreationImage r123 = r122.imageContent;
        if (r123 == null) goto L52;
        ImageInfo r124 = r123.f365014a;
        if (r124 == null) goto L52;
        String r125 = r124.f364802e;
    L54:
        if (Intrinsics.areEqual(r125, r101.f364802e) == true) goto L55;
        r120 = r120 + 1;
        goto L42
    L55:
        int r126 = r120;
    L58:
        r108 = j0.g(r101);
        Function2<Message, Continuation<? super Map<String, ? extends Object>>, Object> r127 = b();
        r103.L$0 = r108;
        r103.I$0 = r126;
        r103.label = 2;
        r111 = r127.invoke(r100, r103);
        if (r111 != r105) goto L61;
        return r105;
    L61:
        r107 = r126;
    L52:
        r125 = null;
        goto L54
    L57:
        r126 = -1;
    L37:
        r118 = null;
    L7:
        r103 = new ImageOperatorComponent$generateImageItemInfo$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(ImageInfo r210, JSONObject r211, String r212, @CreationTaskType Integer r213, Continuation<? super Unit> r214) {
        if ((r214 instanceof ImageOperatorComponent$saveImage$1) == false) goto L7;
        ImageOperatorComponent$saveImage$1 r100 = (ImageOperatorComponent$saveImage$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ImageOperatorComponent$saveImage$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L21;
        if (r105 == 2) goto L20;
        if (r105 == 3) goto L19;
        if (r105 == 4) goto L18;
        if (r105 != 5) goto L17;
        Message r106 = (Message) r102.L$2;
        Integer r107 = (Integer) r102.L$1;
        JSONObject r108 = (JSONObject) r102.L$0;
        ResultKt.throwOnFailure(r103);
        String r110 = null;
    L140:
        df8.a r111 = (df8.a) r103;
        if (r111 == null) goto L163;
        com.larus.uaigc.chat.image.event.b r109 = com.larus.uaigc.chat.image.event.b.f370831a;
        ImageShareClickMethod r112 = ImageShareClickMethod.OverviewClick;
        if (r107 == null) goto L145;
        String r113 = DataConverterKt.h(r107.intValue());
    L146:
        if (r108 == null) goto L148;
        Integer r114 = Boxing.boxInt(r108.optInt("position"));
    L149:
        if (r108 == null) goto L151;
        String r115 = r108.optString("creation_task_id");
    L152:
        if (r108 == null) goto L154;
        String r116 = r108.optString("creation_id");
    L155:
        if (r106 == null) goto L157;
        String r215 = com.larus.im.bean.message.a.r(r106);
    L158:
        if (r106 == null) goto L160;
        String r216 = com.larus.im.bean.message.a.s(r106);
    L161:
        r109.getClass();
        com.larus.uaigc.chat.image.event.b.f(r112, r111, r113, r114, r115, r116, r215, r216, r108);
        goto L163
    L160:
        r216 = r110;
        goto L161
    L157:
        r215 = r110;
        goto L158
    L154:
        r116 = r110;
        goto L155
    L151:
        r115 = r110;
        goto L152
    L148:
        r114 = r110;
        goto L149
    L145:
        r113 = r110;
    L163:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        Integer r117 = (Integer) r102.L$2;
        JSONObject r118 = (JSONObject) r102.L$1;
        ImageInfo r119 = (ImageInfo) r102.L$0;
        ResultKt.throwOnFailure(r103);
        r108 = r118;
        r110 = null;
        r107 = r117;
    L137:
        r106 = (Message) r103;
        r102.L$0 = r108;
        r102.L$1 = r107;
        r102.L$2 = r106;
        r102.label = 5;
        r103 = d(r106, r119, r108, r102);
        if (r103 != r104) goto L140;
        return r104;
    L19:
        String r120 = (String) r102.L$4;
        Integer r121 = (Integer) r102.L$3;
        final String r122 = (String) r102.L$2;
        JSONObject r123 = (JSONObject) r102.L$1;
        ImageInfo r124 = (ImageInfo) r102.L$0;
        ResultKt.throwOnFailure(r103);
        Integer r125 = r121;
        ImageInfo r126 = r124;
        JSONObject r127 = r123;
    L99:
        Message r128 = (Message) r103;
        if (r127 == null) goto L102;
        String r129 = r127.optString("creation_task_id");
    L103:
        ICreationMetadataService.Companion r130 = ICreationMetadataService.f373916a;
        if (r127 == null) goto L106;
        String r131 = Boxing.boxInt(r127.optInt("position")).toString();
    L107:
        final UserCreationFromIM r132 = r130.I(r128, r129, r131);
        Map<String, String> r133 = r130.L(r132, r129);
        if (r125 == null) goto L115;
        String r134 = DataConverterKt.h(r125.intValue());
        if ((!StringsKt.isBlank(r134)) == true) goto L113;
        r134 = null;
    L113:
        if (r134 == null) goto L115;
    L125:
        IFlowSdkDepend r135 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r135 == null) goto L132;
        r135.D0();
        b1 r136 = b1.f346144a;
        r136.c("chat_thumbnail_download");
        if (r120 != null) goto L130;
        String r137 = "";
    L131:
        r136.d(r137);
        goto L132
    L130:
        r137 = r120;
    L132:
        ImageDownloadLoadingMgr r138 = ImageDownloadLoadingMgr.f295963a;
        ImageDownloadLoadingMgr.b(r120, r133, new ImageOperatorComponent$saveImage$3(r132, r129, r122, null), new e(r132, r122), true, new ImageOperatorComponent$saveImage$5(r120, r134, r126, null));
        r107 = r125;
    L133:
        r119 = r126;
        Function1<Continuation<? super Message>, Object> r139 = c();
        r102.L$0 = r119;
        r102.L$1 = r127;
        r102.L$2 = r107;
        r110 = null;
        r102.L$3 = null;
        r102.L$4 = null;
        r102.label = 4;
        r103 = r139.invoke(r102);
        if (r103 != r104) goto L136;
        return r104;
    L136:
        r108 = r127;
    L115:
        if (r128 == null) goto L121;
        String r140 = ap8.a.b(r128);
        if (r140 == null) goto L121;
        if ((!StringsKt.isBlank(r140)) == false) goto L121;
    L122:
        if (r140 != null) goto L124;
        r134 = "image";
        goto L125
    L124:
        r134 = r140;
    L121:
        r140 = null;
        goto L122
    L106:
        r131 = null;
        goto L107
    L102:
        r129 = null;
        goto L103
    L20:
        r120 = (String) r102.L$4;
        r107 = (Integer) r102.L$3;
        String r141 = (String) r102.L$2;
        r127 = (JSONObject) r102.L$1;
        r126 = (ImageInfo) r102.L$0;
        ResultKt.throwOnFailure(r103);
        String r142 = r141;
    L94:
        if (((Boolean) r103).booleanValue() == false) goto L133;
        Function1<Continuation<? super Message>, Object> r143 = c();
        r102.L$0 = r126;
        r102.L$1 = r127;
        r102.L$2 = r142;
        r102.L$3 = r107;
        r102.L$4 = r120;
        r102.label = 3;
        r103 = r143.invoke(r102);
        if (r103 != r104) goto L98;
        return r104;
    L98:
        r125 = r107;
        r122 = r142;
        goto L99
    L21:
        ResultKt.throwOnFailure(r103);
    L56:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r103);
        z2 r144 = z2.f365865a;
        v1 r145 = r144.getCreationShareSettings().a();
        boolean r146 = false;
        if (r145 != null) goto L25;
    L27:
        boolean r147 = false;
    L28:
        if (r147 == false) goto L57;
        v1 r148 = r144.getCreationShareSettings().a();
        if (r148 != null) goto L32;
    L34:
        boolean r149 = false;
    L35:
        if (r149 == false) goto L41;
        if (r213 != null) goto L39;
    L49:
        boolean r150 = true;
    L51:
        if (r150 == false) goto L57;
        r102.label = 1;
        if (f(r210, r211, r212, true, r213, true, r102) != r104) goto L56;
        return r104;
    L39:
        if (r213.intValue() != 5) goto L49;
    L50:
        r150 = false;
        goto L51
    L41:
        if (r213 != null) goto L44;
    L45:
        if (r213 == null) goto L49;
        if (r213.intValue() == 1) goto L50;
    L44:
        if (r213.intValue() == 5) goto L50;
    L32:
        if (r148.f() != true) goto L34;
        r149 = true;
    L57:
        if (r210 == null) goto L61;
        Image r151 = r210.f364798a;
        if (r151 == null) goto L61;
        String r152 = r151.f364791a;
    L62:
        if (r152 != null) goto L64;
    L65:
        r146 = true;
    L66:
        if (r146 == false) goto L69;
        FLogger.f375446a.e(getLogTag(), "doSaveImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L69:
        Context r153 = a().getContext();
        if ((r153 instanceof FragmentActivity) == false) goto L72;
        FragmentActivity r154 = (FragmentActivity) r153;
    L73:
        if (r154 != null) goto L78;
        Activity r155 = AppHost.f326268a.a().getCurrentActivity();
        if ((r155 instanceof FragmentActivity) == false) goto L77;
        r154 = (FragmentActivity) r155;
        goto L78
    L77:
        r154 = null;
    L78:
        if (r154 != null) goto L81;
        FLogger.f375446a.e(getLogTag(), "no activity");
        return Unit.INSTANCE;
    L81:
        r102.L$0 = r210;
        r102.L$1 = r211;
        r142 = r212;
        r102.L$2 = r142;
        r102.L$3 = r213;
        r102.L$4 = r152;
        r102.label = 2;
        SafeContinuation r156 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
        if (Build.VERSION.SDK_INT <= 29) goto L84;
    L86:
        Result.Companion r157 = Result.Companion;
        r156.resumeWith(Result.m9449constructorimpl(Boxing.boxBoolean(true)));
    L87:
        Object r158 = r156.getOrThrow();
        if (r158 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L90;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L90:
        if (r158 != r104) goto L92;
        return r104;
    L92:
        r127 = r211;
        r126 = r210;
        r120 = r152;
        r103 = r158;
        r107 = r213;
        goto L94
    L84:
        if (ContextCompat.checkSelfPermission(r154, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L86;
        i2.f365748b.a(r154, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new f(r156));
        goto L87
    L72:
        r154 = null;
        goto L73
    L64:
        if (r152.length() != 0) goto L66;
    L61:
        r152 = null;
        goto L62
    L25:
        if (r145.b() != true) goto L27;
        r147 = true;
    L7:
        r100 = new ImageOperatorComponent$saveImage$1(this, r214);
        goto L8
    }

    public final Object f(ImageInfo r410, JSONObject r411, String r412, boolean r413, @CreationTaskType Integer r414, boolean r415, Continuation<? super Unit> r416) {
        JSONObject r100 = r411;
        if ((r416 instanceof ImageOperatorComponent$shareImage$1) == false) goto L7;
        ImageOperatorComponent$shareImage$1 r101 = (ImageOperatorComponent$shareImage$1) r416;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r105 = true;
        String r110 = "";
        switch(r101.label) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r103);
        ImageOperatorComponent r111 = this;
    L270:
        r111.f371098b = false;
        return Unit.INSTANCE;
    L13:
        Integer r106 = (Integer) r101.L$1;
        JSONObject r107 = (JSONObject) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r111 = this;
        Object r108 = r104;
    L260:
        df8.a r109 = (df8.a) r103;
        if (r109 == null) goto L267;
        com.larus.uaigc.chat.image.event.b r112 = com.larus.uaigc.chat.image.event.b.f370831a;
        ImageShareClickMethod r113 = ImageShareClickMethod.OverviewClick;
        if (r106 == null) goto L265;
        String r114 = DataConverterKt.h(r106.intValue());
    L266:
        r112.a(r113, r109, r114, r107);
        Unit r115 = Unit.INSTANCE;
        goto L267
    L265:
        r114 = null;
    L267:
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 10;
        if (DelayKt.delay(500, r101) != r108) goto L270;
        return r108;
    L14:
        ImageOperatorComponent r116 = (ImageOperatorComponent) r101.L$3;
        Integer r117 = (Integer) r101.L$2;
        JSONObject r118 = (JSONObject) r101.L$1;
        ImageInfo r119 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r111 = this;
        JSONObject r120 = r118;
        r108 = r104;
        ImageOperatorComponent r121 = r116;
        Object r122 = null;
    L256:
        r101.L$0 = r120;
        r101.L$1 = r117;
        r101.L$2 = r122;
        r101.L$3 = r122;
        r101.label = 9;
        r103 = r121.d((Message) r103, r119, r120, r101);
        if (r103 != r108) goto L259;
        return r108;
    L259:
        r106 = r117;
        r107 = r120;
        goto L260
    L15:
        ICreationMetadataService.Companion r123 = (ICreationMetadataService.Companion) r101.L$8;
        com.larus.bmhome.share.panel.h r124 = (com.larus.bmhome.share.panel.h) r101.L$7;
        Context r125 = (Context) r101.L$6;
        ICreationShareService.Companion r126 = (ICreationShareService.Companion) r101.L$5;
        String r127 = (String) r101.L$4;
        String r128 = (String) r101.L$3;
        Integer r129 = (Integer) r101.L$2;
        r120 = (JSONObject) r101.L$1;
        ImageInfo r130 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L16:
        com.larus.bmhome.share.panel.h r210 = r124;
        Context r131 = r125;
        ICreationShareService.Companion r132 = r126;
        String r211 = r127;
        String r133 = r128;
        Message r134 = (Message) r103;
        if (r120 == null) goto L127;
        String r135 = Boxing.boxInt(r120.optInt("position")).toString();
    L128:
        if (r120 == null) goto L130;
        String r136 = r120.optString("creation_task_id");
    L131:
        ICreationShareService.a.a(r132, r131, r133, null, null, r210, null, r123.I(r134, r136, r135), r129, r211, 140);
        Unit r137 = Unit.INSTANCE;
        r111 = this;
        r101 = r101;
        r119 = r130;
        Integer r138 = r129;
        r104 = r104;
    L252:
        Function1<Continuation<? super Message>, Object> r139 = c();
        r101 = r101;
        r101.L$0 = r119;
        r101.L$1 = r120;
        r101.L$2 = r138;
        r101.L$3 = r111;
        r122 = null;
        r101.L$4 = null;
        r101.L$5 = null;
        r101.L$6 = null;
        r101.L$7 = null;
        r101.L$8 = null;
        r101.label = 8;
        r103 = r139.invoke(r101);
        r108 = r104;
        if (r103 != r108) goto L255;
        return r108;
    L255:
        r117 = r138;
        r121 = r111;
        goto L256
    L130:
        r136 = null;
        goto L131
    L127:
        r135 = null;
        goto L128
    L17:
        com.larus.uaigc.chat.image.event.b r140 = (com.larus.uaigc.chat.image.event.b) r101.L$11;
        ImageShareClickMethod r141 = (ImageShareClickMethod) r101.L$10;
        df8.a r142 = (df8.a) r101.L$9;
        Integer r143 = (Integer) r101.L$8;
        JSONObject r144 = (JSONObject) r101.L$7;
        Context r145 = (Context) r101.L$6;
        ICreationShareService.Companion r146 = (ICreationShareService.Companion) r101.L$5;
        String r147 = (String) r101.L$4;
        String r148 = (String) r101.L$3;
        Integer r149 = (Integer) r101.L$2;
        JSONObject r150 = (JSONObject) r101.L$1;
        ImageInfo r151 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
        ImageInfo r152 = r151;
        Object r153 = r103;
        com.larus.uaigc.chat.image.event.b r154 = r140;
        JSONObject r155 = r150;
        String r310 = r147;
        Integer r156 = r143;
    L18:
        String r157 = r310;
        r124 = r154.c(r141, r142, r156, r144, (Message) r153);
        r127 = r157;
        r125 = r145;
        r126 = r146;
        r129 = r149;
        r128 = r148;
        r130 = r152;
        r120 = r155;
    L121:
        r123 = ICreationMetadataService.f373916a;
        Function1<Continuation<? super Message>, Object> r158 = c();
        r101.L$0 = r130;
        r101.L$1 = r120;
        r101.L$2 = r129;
        r101.L$3 = r128;
        r101.L$4 = r127;
        r101.L$5 = r126;
        r101.L$6 = r125;
        r101.L$7 = r124;
        r101.L$8 = r123;
        r101.L$9 = null;
        r101.L$10 = null;
        r101.L$11 = null;
        r101.label = 7;
        r103 = r158.invoke(r101);
        if (r103 != r104) goto L16;
        return r104;
    L19:
        Context r159 = (Context) r101.L$6;
        ICreationShareService.Companion r160 = (ICreationShareService.Companion) r101.L$5;
        String r161 = (String) r101.L$4;
        String r162 = (String) r101.L$3;
        Integer r163 = (Integer) r101.L$2;
        JSONObject r164 = (JSONObject) r101.L$1;
        ImageInfo r165 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r148 = r162;
        r149 = r163;
        r144 = r164;
        r145 = r159;
        ImageInfo r166 = r165;
        r146 = r160;
    L106:
        df8.a r167 = (df8.a) r103;
        if (r167 == null) goto L120;
        r154 = com.larus.uaigc.chat.image.event.b.f370831a;
        ImageShareClickMethod r168 = ImageShareClickMethod.OverviewClick;
        if (r149 == null) goto L111;
        String r169 = DataConverterKt.h(r149.intValue());
    L112:
        if (r169 == null) goto L115;
        r110 = r169;
    L115:
        r156 = Boxing.boxInt(ap8.a.d(r110));
        Function1<Continuation<? super Message>, Object> r170 = c();
        r101.L$0 = r166;
        r101.L$1 = r144;
        r101.L$2 = r149;
        r101.L$3 = r148;
        r101.L$4 = r161;
        r101.L$5 = r146;
        r101.L$6 = r145;
        r101.L$7 = r144;
        r101.L$8 = r156;
        r101.L$9 = r167;
        r101.L$10 = r168;
        r101.L$11 = r154;
        r152 = r166;
        r101.label = 6;
        r153 = r170.invoke(r101);
        if (r153 != r104) goto L118;
        return r104;
    L118:
        r155 = r144;
        r310 = r161;
        r142 = r167;
        r141 = r168;
        goto L18
    L111:
        r169 = null;
        goto L112
    L120:
        r126 = r146;
        r129 = r149;
        r130 = r166;
        r124 = null;
        JSONObject r311 = r144;
        r127 = r161;
        r125 = r145;
        r128 = r148;
        r120 = r311;
        goto L121
    L20:
        ImageOperatorComponent r171 = (ImageOperatorComponent) r101.L$7;
        Context r172 = (Context) r101.L$6;
        ICreationShareService.Companion r173 = (ICreationShareService.Companion) r101.L$5;
        String r174 = (String) r101.L$4;
        String r175 = (String) r101.L$3;
        Integer r176 = (Integer) r101.L$2;
        JSONObject r177 = (JSONObject) r101.L$1;
        ImageInfo r178 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L102:
        r101.L$0 = r178;
        r101.L$1 = r177;
        r101.L$2 = r176;
        r101.L$3 = r175;
        r101.L$4 = r174;
        r101.L$5 = r173;
        r101.L$6 = r172;
        Context r417 = r172;
        r101.L$7 = null;
        r101.label = 5;
        r103 = r171.d((Message) r103, r178, null, r101);
        if (r103 != r104) goto L105;
        return r104;
    L105:
        r148 = r175;
        r144 = r177;
        r166 = r178;
        r146 = r173;
        r161 = r174;
        r149 = r176;
        r145 = r417;
        goto L106
    L21:
        boolean r179 = r101.Z$0;
        Message r180 = (Message) r101.L$4;
        r138 = (Integer) r101.L$3;
        String r181 = (String) r101.L$2;
        JSONObject r182 = (JSONObject) r101.L$1;
        ImageInfo r183 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
        ImageInfo r184 = r183;
        r111 = this;
    L143:
        df8.a r185 = (df8.a) r103;
        if (r185 == null) goto L152;
        com.larus.uaigc.chat.image.event.b r186 = com.larus.uaigc.chat.image.event.b.f370831a;
        ImageShareClickMethod r187 = ImageShareClickMethod.OverviewClick;
        if (r138 == null) goto L148;
        String r188 = DataConverterKt.h(r138.intValue());
    L149:
        if (r188 != null) goto L151;
        r188 = "";
    L151:
        com.larus.bmhome.share.panel.h r212 = r186.c(r187, r185, Boxing.boxInt(ap8.a.d(r188)), r182, r180);
    L153:
        Context r189 = a().getContext();
        if ((r189 instanceof FragmentActivity) == false) goto L156;
        FragmentActivity r190 = (FragmentActivity) r189;
    L157:
        if (r190 != null) goto L162;
        Activity r191 = AppHost.f326268a.a().getCurrentActivity();
        if ((r191 instanceof FragmentActivity) == false) goto L161;
        r190 = (FragmentActivity) r191;
        goto L162
    L161:
        r190 = null;
    L162:
        if (r190 == null) goto L250;
        FragmentManager r192 = r190.getSupportFragmentManager();
        if (r192 == null) goto L250;
        if (r180 != null) goto L167;
    L169:
        boolean r193 = false;
    L170:
        if (r193 == false) goto L174;
        Image r194 = r184.f364800c;
        if (r194 == null) goto L177;
        String r195 = r194.f364791a;
    L178:
        if (r195 == null) goto L182;
        r110 = r195;
    L182:
        if (r110.length() != 0) goto L184;
        boolean r196 = true;
    L185:
        if (r196 == false) goto L191;
        Image r197 = r184.f364799b;
        if (r197 == null) goto L189;
        String r198 = bz9.a.b(r197);
    L190:
        r110 = r198;
        goto L191
    L189:
        r198 = null;
    L191:
        String r199 = String.valueOf(r110);
        IFlowSdkDepend r200 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r200 == null) goto L250;
        r200.r0();
        e2 r201 = e2.f346164a;
        Image r202 = r184.f364798a;
        if (r202 == null) goto L196;
        String r203 = r202.f364791a;
    L197:
        String r213 = String.valueOf(r203);
        Image r204 = r184.f364806i;
        if (r204 == null) goto L200;
        String r214 = r204.f364791a;
    L201:
        if (r180 != null) goto L203;
    L205:
        r105 = false;
    L206:
        if (r105 == true) goto L211;
        Image r205 = r184.f364801d;
        if (r205 == null) goto L211;
        String r215 = r205.f364791a;
    L212:
        ShareScene r216 = ShareScene.IMAGE_VIEWER_REPORT;
        Image r206 = r184.f364800c;
        if (r206 == null) goto L215;
        long r217 = r206.f364794d;
    L216:
        if (r206 == null) goto L218;
        long r218 = r206.f364793c;
    L220:
        if (r179 == false) goto L222;
        String r207 = "download";
    L223:
        sq9.i r208 = new sq9.i(r207, r181, null, 4);
        ICreationMetadataService.Companion r209 = ICreationMetadataService.f373916a;
        if (r182 == null) goto L226;
        String r219 = Boxing.boxInt(r182.optInt("position")).toString();
    L227:
        if (r182 == null) goto L229;
        String r220 = r182.optString("creation_task_id");
    L230:
        Map<String, String> r312 = r209.L(r209.I(r180, r220, r219), null);
        Image r221 = r184.f364798a;
        if (r221 == null) goto L234;
        String r222 = r221.f364795e;
        if (r222 == null) goto L234;
    L248:
        String r313 = r222;
    L249:
        r201.Z0(r192, new sq9.j(null, r199, r213, r214, r215, null, r212, r216, r218, r217, r208, r312, 0, null, r138, null, r313, 45089));
        Unit r223 = Unit.INSTANCE;
    L251:
        r119 = r184;
        r120 = r182;
    L234:
        Image r224 = r184.f364800c;
        if (r224 == null) goto L237;
        r222 = r224.f364795e;
    L238:
        if (r222 != null) goto L248;
        Image r225 = r184.f364799b;
        if (r225 == null) goto L242;
        r222 = r225.f364795e;
    L243:
        if (r222 != null) goto L248;
        Image r226 = r184.f364806i;
        if (r226 == null) goto L247;
        r222 = r226.f364795e;
        goto L248
    L247:
        r313 = null;
        goto L249
    L242:
        r222 = null;
        goto L243
    L237:
        r222 = null;
        goto L238
    L229:
        r220 = null;
        goto L230
    L226:
        r219 = null;
        goto L227
    L222:
        r207 = "share";
        goto L223
    L218:
        r218 = -1;
        goto L220
    L215:
        r217 = -1;
    L211:
        r215 = null;
        goto L212
    L203:
        if (ap8.a.c(r180) != true) goto L205;
    L200:
        r214 = null;
        goto L201
    L196:
        r203 = null;
        goto L197
    L184:
        r196 = false;
    L177:
        r195 = null;
        goto L178
    L174:
        Image r227 = r184.f364800c;
        if (r227 == null) goto L177;
        r195 = bz9.a.b(r227);
        goto L178
    L167:
        if (com.larus.bmhome.chat.bean.d.a0(r180) != true) goto L169;
        r193 = true;
    L250:
        r101 = r101;
        r104 = r104;
        goto L251
    L156:
        r190 = null;
        goto L157
    L148:
        r188 = null;
        goto L149
    L152:
        r212 = null;
        goto L153
    L22:
        r179 = r101.Z$0;
        ImageOperatorComponent r228 = (ImageOperatorComponent) r101.L$5;
        Message r229 = (Message) r101.L$4;
        Integer r230 = (Integer) r101.L$3;
        String r1100 = (String) r101.L$2;
        JSONObject r1101 = (JSONObject) r101.L$1;
        r184 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r111 = this;
        ImageOperatorComponent r231 = r228;
        r180 = r229;
        r138 = r230;
        r181 = r1100;
        r182 = r1101;
    L140:
        r101.L$0 = r184;
        r101.L$1 = r182;
        r101.L$2 = r181;
        r101.L$3 = r138;
        r101.L$4 = r180;
        r101.L$5 = null;
        r101.Z$0 = r179;
        r101.label = 3;
        r103 = r231.d((Message) r103, r184, r182, r101);
        if (r103 != r104) goto L143;
        return r104;
    L23:
        r179 = r101.Z$0;
        Integer r232 = (Integer) r101.L$3;
        String r233 = (String) r101.L$2;
        JSONObject r234 = (JSONObject) r101.L$1;
        ImageInfo r1102 = (ImageInfo) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Integer r235 = r232;
        r100 = r234;
    L136:
        Message r236 = (Message) r103;
        Function1<Continuation<? super Message>, Object> r237 = c();
        r101.L$0 = r1102;
        r101.L$1 = r100;
        r101.L$2 = r233;
        r101.L$3 = r235;
        r101.L$4 = r236;
        r111 = this;
        r101.L$5 = r111;
        r101.Z$0 = r179;
        r101.label = 2;
        Object r238 = r237.invoke(r101);
        if (r238 != r104) goto L139;
        return r104;
    L139:
        r184 = r1102;
        r182 = r100;
        r180 = r236;
        r103 = r238;
        r181 = r233;
        r138 = r235;
        r231 = r111;
        goto L140
    L24:
        ResultKt.throwOnFailure(r103);
        if (r410 == null) goto L29;
        Image r239 = r410.f364798a;
        if (r239 == null) goto L29;
        String r240 = r239.f364791a;
    L30:
        if (r240 != null) goto L32;
    L35:
        boolean r241 = true;
    L36:
        if (r241 == false) goto L40;
        FLogger.f375446a.e(getLogTag(), "doShareImage error because imageUrl is null or empty");
        return Unit.INSTANCE;
    L40:
        if (this.f371098b == false) goto L43;
        FLogger.f375446a.i(getLogTag(), "doShareImage return because isSharing is true");
        return Unit.INSTANCE;
    L43:
        this.f371098b = true;
        if (r415 == true) goto L132;
        z2 r242 = z2.f365865a;
        v1 r1103 = r242.getCreationShareSettings().a();
        if (r1103 != null) goto L48;
    L50:
        boolean r1104 = false;
    L51:
        if (r1104 == false) goto L76;
        v1 r243 = r242.getCreationShareSettings().a();
        if (r243 != null) goto L55;
    L57:
        boolean r244 = false;
    L58:
        if (r244 == false) goto L64;
        if (r414 != null) goto L62;
    L72:
        boolean r245 = true;
    L74:
        if (r245 == false) goto L76;
    L62:
        if (r414.intValue() != 5) goto L72;
    L73:
        r245 = false;
        goto L74
    L64:
        if (r414 != null) goto L67;
    L68:
        if (r414 == null) goto L72;
        if (r414.intValue() == 1) goto L73;
    L67:
        if (r414.intValue() == 5) goto L73;
    L55:
        if (r243.f() != true) goto L57;
        r244 = true;
    L76:
        if (r410 == null) goto L81;
        Image r246 = r410.f364798a;
        if (r246 == null) goto L81;
        r174 = r246.f364795e;
        if (r174 == null) goto L81;
    L98:
        ICreationShareService.Companion r247 = ICreationShareService.f373931a;
        Context r1105 = a().getContext();
        Function1<Continuation<? super Message>, Object> r1106 = c();
        r101.L$0 = r410;
        r101.L$1 = r100;
        r101.L$2 = r414;
        r101.L$3 = r240;
        r101.L$4 = r174;
        r101.L$5 = r247;
        r101.L$6 = r1105;
        r101.L$7 = this;
        r101.label = 4;
        Object r248 = r1106.invoke(r101);
        if (r248 != r104) goto L101;
        return r104;
    L101:
        r178 = r410;
        r171 = this;
        r177 = r100;
        r172 = r1105;
        r176 = r414;
        r173 = r247;
        r175 = r240;
        r103 = r248;
    L81:
        if (r410 == null) goto L85;
        Image r249 = r410.f364800c;
        if (r249 == null) goto L85;
        r174 = r249.f364795e;
    L86:
        if (r174 != null) goto L98;
        if (r410 == null) goto L91;
        Image r250 = r410.f364799b;
        if (r250 == null) goto L91;
        r174 = r250.f364795e;
    L92:
        if (r174 != null) goto L98;
        if (r410 == null) goto L97;
        Image r251 = r410.f364806i;
        if (r251 == null) goto L97;
        r174 = r251.f364795e;
    L97:
        r174 = null;
    L91:
        r174 = null;
    L85:
        r174 = null;
        goto L86
    L48:
        if (r1103.e() != true) goto L50;
        r1104 = true;
    L132:
        Function1<Continuation<? super Message>, Object> r252 = c();
        r101.L$0 = r410;
        r101.L$1 = r100;
        r101.L$2 = r412;
        r101.L$3 = r414;
        r101.Z$0 = r413;
        r101.label = 1;
        Object r253 = r252.invoke(r101);
        if (r253 != r104) goto L135;
        return r104;
    L135:
        r1102 = r410;
        r179 = r413;
        r103 = r253;
        r235 = r414;
        r233 = r412;
        goto L136
    L32:
        if (r240.length() == 0) goto L35;
        r241 = false;
    L29:
        r240 = null;
        goto L30
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new ImageOperatorComponent$shareImage$1(this, r416);
        goto L8
    }
}
