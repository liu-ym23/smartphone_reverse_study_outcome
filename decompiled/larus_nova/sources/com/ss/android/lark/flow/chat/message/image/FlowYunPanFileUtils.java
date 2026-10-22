package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.util.LruCache;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowYunPanFileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowYunPanFileUtils f422568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f422569b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f422570c = null;

    public FlowYunPanFileUtils() {
    }

    static {
        f422568a = new FlowYunPanFileUtils();
        f422569b = LazyKt.lazy(FlowYunPanFileUtils$yunPanImageLocalPathCache$2.INSTANCE);
        f422570c = LazyKt.lazy(FlowYunPanFileUtils$yunPanCoverLocalPathCache$2.INSTANCE);
    }

    public static final Object b(String r100, Continuation r101) {
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        ((com.bytedance.ee.drive.preview.f) k.a(LarkContext.getApplication(), com.bytedance.ee.drive.preview.f.class)).y7().fetchDriveImagePreview(r100, new j(r102));
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L5:
        return r103;
    }

    public static final PolarisFileWrapper c(String r100, FlowYunPanCoverType r101) {
        boolean r102 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L20;
        String r104 = r100 + '_' + r101.getType();
        Lazy r105 = f422570c;
        String r106 = (String) ((LruCache) r105.getValue()).get(r104);
        if (r106 != null) goto L11;
    L14:
        if (r102 == true) goto L20;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106);
        if (r107.exists() == true) goto L22;
        ((LruCache) r105.getValue()).remove(r104);
        goto L20
    L22:
        return r107;
    L11:
        if (r106.length() == 0) goto L14;
        r102 = false;
    L20:
        return null;
    L5:
        r103 = false;
        goto L6
    }

    public final Object f(String r100, String r101, Continuation<? super File> r110) {
        if ((r110 instanceof FlowYunPanFileUtils$driveDownloadImageWithFile$1) == false) goto L7;
        FlowYunPanFileUtils$driveDownloadImageWithFile$1 r102 = (FlowYunPanFileUtils$driveDownloadImageWithFile$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L27:
        String r112 = (String) r111;
        if (TextUtils.isEmpty(r112) == false) goto L30;
        return null;
    L30:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r112);
        if (r106.exists() == true) goto L33;
        return null;
    L33:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Log.i("FlowYunPanFileUtils", "driveDownloadImageWithFile, token: " + r100.hashCode() + ", localPath: " + r101);
        boolean r107 = false;
        if (r100.length() != 0) goto L17;
        boolean r113 = true;
    L18:
        if (r113 == false) goto L20;
    L34:
        Log.e("FlowYunPanFileUtils", "token or localPath is empty, token: " + r100.hashCode() + ", localPath: " + r101);
        return null;
    L20:
        if (r101.length() != 0) goto L22;
        r107 = true;
    L22:
        if (r107 == true) goto L34;
        CoroutineDispatcher r114 = Dispatchers.getIO();
        FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1 r108 = new FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1(r100, r101, null);
        r102.label = 1;
        r111 = BuildersKt.withContext(r114, r108, r102);
        if (r111 != r104) goto L27;
        return r104;
    L17:
        r113 = false;
    L7:
        r102 = new FlowYunPanFileUtils$driveDownloadImageWithFile$1(this, r110);
        goto L8
    }

    public static final Object a(FlowYunPanFileUtils r210, String r211, final String r212, Continuation r213) {
        r210.getClass();
        if ((r213 instanceof FlowYunPanFileUtils$driveDownloadImageInner$1) == false) goto L7;
        FlowYunPanFileUtils$driveDownloadImageInner$1 r100 = (FlowYunPanFileUtils$driveDownloadImageInner$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L21:
        return (String) r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r211;
        r100.L$1 = r212;
        r100.label = 1;
        final kotlinx.coroutines.j r107 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r107.C();
        DrivePriority$DownloadPriority r108 = DrivePriority$DownloadPriority.DEFAULT;
        r108.getPriority();
        DownloadRequestInfo.DownloadType r109 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r110 = DriveBizScene.DriveBizScene_UNKNOWN;
        int r111 = r108.getPriority();
        DownloadRequestInfo.DownloadType r112 = DownloadRequestInfo.DownloadType.IMG;
        DriveBizScene r113 = DriveBizScene.DriveBizScene_IM;
        FlowYunPanFileUtils$driveDownloadImageInner$1 r214 = r100;
        DownloadRequestInfo r114 = new DownloadRequestInfo(r212, r211, "", FileInfoPuller.CALLER_EXPLORER, r111, "", r112, "", 0, false, "", 2, new FlowYunPanFileUtils$driveDownloadImageInner$downloadFilePath$1$requestInfo$1$1(r107, r212), null, false, null, null, r113, null);
        ((com.bytedance.ee.bear.drive.sdk.service.f) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().g(r114);
        r102 = r107.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(r214);
    L18:
        if (r102 != r103) goto L21;
        return r103;
    L7:
        r100 = new FlowYunPanFileUtils$driveDownloadImageInner$1(r210, r213);
        goto L8
    }

    public final Object e(Context r110, String r111, boolean r112, Continuation<? super File> r113) {
        if ((r113 instanceof FlowYunPanFileUtils$downloadYunPanPictureWithFile$1) == false) goto L7;
        FlowYunPanFileUtils$downloadYunPanPictureWithFile$1 r100 = (FlowYunPanFileUtils$downloadYunPanPictureWithFile$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L18:
        File r107 = (File) r102;
        Log.i("FlowYunPanFileUtils", "downloadYunPanPictureWithFile, token: " + r106.hashCode() + ", total cost: " + (System.currentTimeMillis() - r105));
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        long r114 = System.currentTimeMillis();
        CoroutineDispatcher r108 = Dispatchers.getIO();
        FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1 r109 = new FlowYunPanFileUtils$downloadYunPanPictureWithFile$file$1(r111, r112, r114, r110, null);
        r100.L$0 = r111;
        r100.J$0 = r114;
        r100.label = 1;
        r102 = BuildersKt.withContext(r108, r109, r100);
        if (r102 != r103) goto L17;
        return r103;
    L17:
        r106 = r111;
        r105 = r114;
    L7:
        r100 = new FlowYunPanFileUtils$downloadYunPanPictureWithFile$1(this, r113);
        goto L8
    }

    public final Object d(Context r110, String r111, FlowYunPanCoverType r112, boolean r113, Continuation<? super File> r114) {
        if ((r114 instanceof FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1) == false) goto L7;
        FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1 r100 = (FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L18:
        File r107 = (File) r102;
        Log.i("FlowYunPanFileUtils", "downloadYunPanPictureCoverFile, token: " + r106.hashCode() + ", total cost: " + (System.currentTimeMillis() - r105));
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        long r108 = System.currentTimeMillis();
        CoroutineDispatcher r109 = Dispatchers.getIO();
        FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1 r115 = new FlowYunPanFileUtils$downloadYunPanPictureCoverFile$file$1(r111, r112, r113, r110, null);
        r100.L$0 = r111;
        r100.J$0 = r108;
        r100.label = 1;
        r102 = BuildersKt.withContext(r109, r115, r100);
        if (r102 != r103) goto L17;
        return r103;
    L17:
        r105 = r108;
        r106 = r111;
    L7:
        r100 = new FlowYunPanFileUtils$downloadYunPanPictureCoverFile$1(this, r114);
        goto L8
    }
}
