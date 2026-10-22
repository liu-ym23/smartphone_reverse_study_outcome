package com.larus.camera.impl.utils.album;

import android.content.Context;
import com.larus.camera.contract.CameraServiceDiffContract;
import com.larus.home.impl.sdk.c1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.FastSendFromCameraScene;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kq9.o;
import kq9.q;

/* JADX INFO: loaded from: classes26.dex */
public final class FastPhotoPickerInCameraManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FastPhotoPickerInCameraManager f322716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f322717b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f322718c;

    public FastPhotoPickerInCameraManager() {
    }

    static {
        f322716a = new FastPhotoPickerInCameraManager();
        f322717b = LazyKt.lazy(new f());
    }

    public static q a() {
        return (q) f322717b.getValue();
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        CameraServiceDiffContract r101 = CameraServiceDiffContract.f321477b;
        Boolean r102 = r101.isHideSlideAlbumEntrance();
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L5;
        return false;
    L5:
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L10;
        r104.S();
        if (c1.f346148a.a() != true) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        return false;
    L13:
        FLogger.f375446a.i("FastSendImageInCameraManager", "isFastSendInCameraBottom conversationId=" + r100 + " bottomScene=" + a().f505658b);
        if (Intrinsics.areEqual(r101.isHideSlideAlbumEntrance(), r103) == false) goto L16;
        return false;
    L16:
        int r106 = a().f505658b;
        if (r106 != FastSendFromCameraScene.DEFAULT.getScene()) goto L20;
        return false;
    L20:
        if (r106 != FastSendFromCameraScene.MAIN_BOT.getScene()) goto L24;
        return com.larus.bmhome.utils.i.g(r100);
    L24:
        if (r106 != FastSendFromCameraScene.OTHER_BOT.getScene()) goto L28;
        return !com.larus.bmhome.utils.i.g(r100);
    L28:
        if (r106 != FastSendFromCameraScene.ALL.getScene()) goto L30;
        return true;
    L30:
        return false;
    L10:
        r105 = false;
        goto L11
    }

    public final Object b(Context r100, String r101, String r102, Continuation<? super Boolean> r110) {
        if ((r110 instanceof FastPhotoPickerInCameraManager$isFromAlbumThumb$1) == false) goto L7;
        FastPhotoPickerInCameraManager$isFromAlbumThumb$1 r103 = (FastPhotoPickerInCameraManager$isFromAlbumThumb$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r101 = (String) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L31:
        if (((Boolean) r111).booleanValue() == true) goto L34;
        FLogger.f375446a.i("FastSendImageInCameraManager", "isFromAlbumThumb no images");
        return Boxing.boxBoolean(false);
    L34:
        o r107 = a().f505659c;
        if (r107 == null) goto L37;
        int r108 = r107.f505653c;
    L38:
        if (r108 > 0) goto L41;
        FLogger.f375446a.i("FastSendImageInCameraManager", "isFromAlbumThumb showCount 0");
        return Boxing.boxBoolean(false);
    L41:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("isFastSendFromAlbumThumb conversationId=");
        r112.append(r101);
        r112.append(" scene=");
        Integer r113 = null;
        if (r107 == null) goto L44;
        Integer r114 = Boxing.boxInt(r107.f505651a);
    L45:
        r112.append(r114);
        r109.i("FastSendImageInCameraManager", r112.toString());
        if (r107 == null) goto L48;
        r113 = Boxing.boxInt(r107.f505651a);
    L48:
        int r115 = FastSendFromCameraScene.DEFAULT.getScene();
        if (r113 != null) goto L52;
    L55:
        int r116 = FastSendFromCameraScene.MAIN_BOT.getScene();
        if (r113 != null) goto L59;
    L62:
        int r117 = FastSendFromCameraScene.OTHER_BOT.getScene();
        if (r113 != null) goto L66;
    L69:
        int r118 = FastSendFromCameraScene.ALL.getScene();
        if (r113 == null) goto L77;
        if (r113.intValue() != r118) goto L77;
        return Boxing.boxBoolean(true);
    L77:
        return Boxing.boxBoolean(false);
    L66:
        if (r113.intValue() != r117) goto L69;
        return Boxing.boxBoolean(!com.larus.bmhome.utils.i.g(r101));
    L59:
        if (r113.intValue() != r116) goto L62;
        return Boxing.boxBoolean(com.larus.bmhome.utils.i.g(r101));
    L52:
        if (r113.intValue() != r115) goto L55;
        return Boxing.boxBoolean(false);
    L44:
        r114 = null;
        goto L45
    L37:
        r108 = 0;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (Intrinsics.areEqual(r102, "chat_action_bar") == false) goto L18;
        FLogger.f375446a.i("FastSendImageInCameraManager", "isFromAlbumThumb click action_bar");
        return Boxing.boxBoolean(false);
    L18:
        k2 r119 = k2.f365755a;
        if (g3.a.e() == false) goto L21;
    L23:
        boolean r120 = false;
    L24:
        if (r120 == true) goto L27;
        FLogger.f375446a.i("FastSendImageInCameraManager", "isFromAlbumThumb no permission");
        return Boxing.boxBoolean(false);
    L27:
        AlbumThumbListManager r121 = AlbumThumbListManager.f322715a;
        r103.L$0 = r101;
        r103.label = 1;
        r111 = r121.b(r100, r103);
        if (r111 != r105) goto L31;
        return r105;
    L21:
        if (g3.a.d() == false) goto L23;
        r120 = true;
    L7:
        r103 = new FastPhotoPickerInCameraManager$isFromAlbumThumb$1(this, r110);
        goto L8
    }
}
