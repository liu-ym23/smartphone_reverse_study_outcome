package com.larus.xbridge.custom;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.util.Base64;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.entity.LoadParams;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes32.dex */
public final class s1 extends bx7.c {

    public static final class a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "media.getVideoThumbnail";
    }

    public s1() {
    }

    public static final Object f(s1 r110, String r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof MediaGetVideoThumbnailMethod$getVideoFrameBase64$1) == false) goto L7;
        MediaGetVideoThumbnailMethod$getVideoFrameBase64$1 r100 = (MediaGetVideoThumbnailMethod$getVideoFrameBase64$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        File r115 = (File) r100.L$1;
        Bitmap r116 = (Bitmap) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L39:
        ByteArrayOutputStream r117 = new ByteArrayOutputStream();
        if (r116 == null) goto L42;
        Boxing.boxBoolean(r116.compress(Bitmap.CompressFormat.PNG, 100, r117));
    L42:
        byte[] r118 = Base64.encode(r117.toByteArray(), 0);
        r117.close();
        Intrinsics.checkNotNull(r118);
        return new Pair(new String(r118, Charsets.UTF_8), r115.getAbsolutePath());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        int r119 = l4a.a.f507355a;
        String r120 = l4a.a.a(AppHost.f326268a.getApplication(), UriProtector.parse(r111));
        MediaMetadataRetriever r103 = new MediaMetadataRetriever();     // Catch: Exception -> L17
        r103.setDataSource(r120);     // Catch: Exception -> L17
        Bitmap r121 = r103.getFrameAtTime();     // Catch: Exception -> L17
    L19:
        if (r121 == null) goto L44;
        int r104 = r121.getWidth();
        int r105 = r121.getHeight();
        float r106 = Math.max(r104, r105);
        float r107 = Math.min(r104, r105);
        if (r106 > 0.0f) goto L23;
    L25:
        float r108 = 1.0f;
    L27:
        if (r121.isRecycled() == false) goto L29;
    L35:
        Intrinsics.checkNotNullParameter(LoadParams.ImageFormat.PNG, "formatSuffix");
        File r109 = aa9.a.f2357a.d(DocCallbackImpl.KEY_THUMBNAIL, "image_" + UUID.randomUUID() + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
        r100.L$0 = r121;
        r100.L$1 = r109;
        r100.label = 1;
        if (BuildersKt.withContext(Dispatchers.getIO(), new MediaGetVideoThumbnailMethod$convertImageToJpeg$2(r109, r121, null), r100) == r114) goto L50;
        r116 = r121;
        r115 = r109;
        goto L39
    L50:
        return r114;
    L29:
        if (r108 <= 1.0f) goto L35;
        Matrix r122 = new Matrix();     // Catch: Exception -> L33
        float r123 = 1.0f / r108;     // Catch: Exception -> L33
        r122.setScale(r123, r123);     // Catch: Exception -> L33
        Bitmap r124 = Bitmap.createBitmap(r121, 0, 0, r121.getWidth(), r121.getHeight(), r122, true);     // Catch: Exception -> L33
        r124.setConfig(com.larus.utils.z0.b(r121.getConfig()));     // Catch: Exception -> L33
        r121 = r124;
    L33:
        e = move-exception;
        FLogger.f375446a.e("MediaGetVideoThumbnailMethod", "compressBitmapByMatrix error: " + e.getMessage());
        goto L35
    L23:
        if (r107 <= 0.0f) goto L25;
        float r125 = 480;
        r108 = Math.max(Math.max(r106 / r125, r107 / r125), 1.0f);
        goto L27
    L44:
        return null;
    L17:
        e = move-exception;
        FLogger.f375446a.e("MediaGetVideoThumbnailMethod", "getVideoFrameBase64 error: " + e.getMessage());
        r121 = null;
    L7:
        r100 = new MediaGetVideoThumbnailMethod$getVideoFrameBase64$1(r110, r112);
        goto L8
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        String r102 = cx7.a.d(r100, "filePath", "");
        if (r102 != null) goto L5;
    L8:
        boolean r111 = true;
    L10:
        if (r111 == false) goto L13;
        bx7.c.c(this, r101, -3, null, 12);
        return;
    L13:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new MediaGetVideoThumbnailMethod$handle$1(this, r102, r101, null), 2, null);
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r111 = false;
        goto L10
    }
}
