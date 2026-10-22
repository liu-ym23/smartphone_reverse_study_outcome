package com.obric.miniapp.intent;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class QueryPrivilegedImageOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QueryPrivilegedImageOperation f397683a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/miniapp/intent/QueryPrivilegedImageOperation$PrivilegedImageException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PrivilegedImageException extends RuntimeException {
        private final String code;

        public final String getCode() {
            return this.code;
        }

        public PrivilegedImageException(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "message");
            super(r101);
            this.code = r100;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f397684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f397685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f397686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f397687d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f397684a == r101.f397684a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397685b, r101.f397685b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f397686c, r101.f397686c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f397687d, r101.f397687d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f397684a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((((r100 * 31) + this.f397685b.hashCode()) * 31) + this.f397686c.hashCode()) * 31) + this.f397687d.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "QueryResult(success=" + this.f397684a + ", content=" + this.f397685b + ", errorCode=" + this.f397686c + ", errorMessage=" + this.f397687d + ')';
        }

        public a(boolean r100, JSONObject r101, String r102, String r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = new JSONObject();
        L6:
            if ((r104 & 4) == 0) goto L9;
            r102 = "";
        L9:
            if ((r104 & 8) == 0) goto L11;
            r103 = "";
        L11:
            Intrinsics.checkNotNullParameter(r101, "content");
            Intrinsics.checkNotNullParameter(r102, "errorCode");
            Intrinsics.checkNotNullParameter(r103, "errorMessage");
            this.f397684a = r100;
            this.f397685b = r101;
            this.f397686c = r102;
            this.f397687d = r103;
        }
    }

    static {
        f397683a = new QueryPrivilegedImageOperation();
    }

    public QueryPrivilegedImageOperation() {
    }

    public static String c(Bitmap r100, int r101) {
        if (r101 <= 0) goto L7;
        int r102 = Math.max(r100.getWidth(), r100.getHeight());
        if (r102 <= r101) goto L7;
        float r103 = r101 / r102;
        Bitmap r104 = Bitmap.createScaledBitmap(r100, RangesKt.coerceAtLeast((int) (r100.getWidth() * r103), 1), RangesKt.coerceAtLeast((int) (r100.getHeight() * r103), 1), true);
    L34:
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L26
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L11:
        if (r104.compress(Bitmap.CompressFormat.JPEG, 86, r105) == false) goto L20;
        String r106 = "data:image/jpeg;base64," + Base64.encodeToString(r105.toByteArray(), 2);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L26
        if (r104 == r100) goto L17;
        r104.recycle();
    L17:
        r100.recycle();
        return r106;
    L20:
        throw new PrivilegedImageException("ENCODE_IMAGE_FAILED", "encode image failed");     // Catch: Throwable -> L21
    L26:
        th = move-exception;
        if (r104 == r100) goto L29;
        r104.recycle();
    L29:
        r100.recycle();
        throw th;
    L7:
        r104 = r100;
        goto L34
    }

    public static a e(String r100, String r101) {
        return new a(false, null, r100, r101, 2);
    }

    public static String g(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
        return "";
    L5:
        String r102 = r100.optString(r101);
        Intrinsics.checkNotNull(r102);
        if ((!StringsKt.isBlank(r102)) == true) goto L9;
        r102 = null;
    L9:
        if (r102 != null) goto L12;
        return "";
    L12:
        return r102;
    }

    public final Object d(JSONObject r110, Continuation<? super a> r111) {
        if ((r111 instanceof QueryPrivilegedImageOperation$execute$1) == false) goto L7;
        QueryPrivilegedImageOperation$execute$1 r100 = (QueryPrivilegedImageOperation$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L25:
        a r113 = (a) r112;
        if (r113 == null) goto L28;
        return r113;
    L28:
        return e("READ_TIMEOUT", "query privileged image timeout");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        String r104 = g(r110, "package_name");
        if (StringsKt.isBlank(r104) == true) goto L17;
        String r105 = g(r110, "uri");
        if (StringsKt.isBlank(r105) == true) goto L21;
        boolean r106 = r110.optBoolean("is_video", false);
        int r107 = RangesKt.coerceAtLeast(r110.optInt(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE, 0), 0);
        long r114 = TimeUnit.SECONDS.toMillis(10);
        QueryPrivilegedImageOperation$execute$2 r108 = new QueryPrivilegedImageOperation$execute$2(r106, r104, r105, r107, null);
        r100.label = 1;
        r112 = TimeoutKt.c(r114, r108, r100);
        if (r112 != r102) goto L25;
        return r102;
    L21:
        return e("MISSING_URI", "uri is required");
    L17:
        return e("MISSING_PACKAGE_NAME", "package_name is required");
    L7:
        r100 = new QueryPrivilegedImageOperation$execute$1(this, r111);
        goto L8
    }

    public final Object f(String r100, String r101, Continuation<? super AssetFileDescriptor> r102) {
        if ((r102 instanceof QueryPrivilegedImageOperation$openPrivilegedAssetFile$1) == false) goto L7;
        QueryPrivilegedImageOperation$openPrivilegedAssetFile$1 r103 = (QueryPrivilegedImageOperation$openPrivilegedAssetFile$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        UriFileAccessSession r108 = (UriFileAccessSession) r105;
        if (r108.f396183a != 0) goto L25;
        AssetFileDescriptor r109 = r108.f396185c;
        if (r109 == null) goto L23;
        return r109;
    L23:
        throw new PrivilegedImageException("OPEN_URI_FAILED", "open uri failed");
    L25:
        throw new PrivilegedImageException("OPEN_URI_FAILED", "open uri failed: status=" + r108.f396183a + ", message=" + r108.f396184b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        AtomicCapabilitySdk r110 = AtomicCapabilitySdk.INSTANCE;
        Uri r111 = UriProtector.parse(r101);
        r103.label = 1;
        r105 = r110.openFileDescriptorPrivileged(r100, r111, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new QueryPrivilegedImageOperation$openPrivilegedAssetFile$1(this, r102);
        goto L8
    }

    public static final Object a(QueryPrivilegedImageOperation r110, String r111, String r112, int r113, Continuation r114) {
        r110.getClass();
        if ((r114 instanceof QueryPrivilegedImageOperation$encodeImage$1) == false) goto L7;
        QueryPrivilegedImageOperation$encodeImage$1 r100 = (QueryPrivilegedImageOperation$encodeImage$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r115 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        int r104 = 1;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        int r116 = r100.I$0;
        BitmapFactory.Options r117 = (BitmapFactory.Options) r100.L$0;
        ResultKt.throwOnFailure(r115);
    L34:
        Closeable r118 = (Closeable) r115;
        Bitmap r119 = BitmapFactory.decodeStream(((AssetFileDescriptor) r118).createInputStream(), null, r117);     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r118, null);
        if (r119 == null) goto L41;
        return c(r119, r116);
    L41:
        throw new PrivilegedImageException("DECODE_IMAGE_FAILED", "decode image failed");
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        CloseableKt.closeFinally(r118, th);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r113 = r100.I$0;
        BitmapFactory.Options r120 = (BitmapFactory.Options) r100.L$2;
        r112 = (String) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r115);
    L20:
        Closeable r121 = (Closeable) r115;
        BitmapFactory.decodeStream(((AssetFileDescriptor) r121).createInputStream(), null, r120);     // Catch: Throwable -> L47
        CloseableKt.closeFinally(r121, null);
        BitmapFactory.Options r122 = new BitmapFactory.Options();
        int r106 = r120.outWidth;
        int r123 = r120.outHeight;
        if (r113 <= 0) goto L30;
        if (r106 <= 0) goto L30;
        if (r123 <= 0) goto L30;
    L28:
        if (Math.max(r106 / r104, r123 / r104) <= (r113 * 2)) goto L30;
        r104 = r104 * 2;
    L30:
        r122.inSampleSize = r104;
        r100.L$0 = r122;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.I$0 = r113;
        r100.label = 2;
        Object r124 = r110.f(r105, r112, r100);
        if (r124 == r102) goto L62;
        r117 = r122;
        r115 = r124;
        r116 = r113;
        goto L34
    L62:
        return r102;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        CloseableKt.closeFinally(r121, th);
        throw th;
    L16:
        ResultKt.throwOnFailure(r115);
        BitmapFactory.Options r125 = new BitmapFactory.Options();
        r125.inJustDecodeBounds = true;
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.L$2 = r125;
        r100.I$0 = r113;
        r100.label = 1;
        Object r107 = r110.f(r111, r112, r100);
        if (r107 == r102) goto L61;
        r105 = r111;
        r120 = r125;
        r115 = r107;
        goto L20
    L61:
        return r102;
    L7:
        r100 = new QueryPrivilegedImageOperation$encodeImage$1(r110, r114);
        goto L8
    }

    public static final Object b(QueryPrivilegedImageOperation r100, String r101, String r110, int r111, Continuation r112) {
        r100.getClass();
        if ((r112 instanceof QueryPrivilegedImageOperation$encodeVideoFirstFrame$1) == false) goto L7;
        QueryPrivilegedImageOperation$encodeVideoFirstFrame$1 r102 = (QueryPrivilegedImageOperation$encodeVideoFirstFrame$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r113 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r111 = r102.I$0;
        ResultKt.throwOnFailure(r113);
    L17:
        Closeable r114 = (Closeable) r113;
        AssetFileDescriptor r106 = (AssetFileDescriptor) r114;     // Catch: Throwable -> L34
        MediaMetadataRetriever r107 = new MediaMetadataRetriever();     // Catch: Throwable -> L34
    L31:
        th = move-exception;
        r107.release();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L20:
        if (r106.getLength() < 0) goto L22;
        r107.setDataSource(r106.getFileDescriptor(), r106.getStartOffset(), r106.getLength());     // Catch: Throwable -> L31
    L23:
        Bitmap r108 = r107.getFrameAtTime(0, 2);     // Catch: Throwable -> L31
        r107.release();     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r114, null);
        if (r108 == null) goto L30;
        return c(r108, r111);
    L30:
        throw new PrivilegedImageException("DECODE_VIDEO_FRAME_FAILED", "decode video frame failed");
    L22:
        r107.setDataSource(r106.getFileDescriptor());     // Catch: Throwable -> L31
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r102.I$0 = r111;
        r102.label = 1;
        r113 = r100.f(r101, r110, r102);
        if (r113 != r104) goto L17;
        return r104;
    L7:
        r102 = new QueryPrivilegedImageOperation$encodeVideoFirstFrame$1(r100, r112);
        goto L8
    }
}
