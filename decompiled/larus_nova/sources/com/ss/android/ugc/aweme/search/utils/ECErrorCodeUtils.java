package com.ss.android.ugc.aweme.search.utils;

import com.bytedance.android.chunkstreamprediction.network.ChunkDataException;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/ECErrorCodeUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECErrorCodeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECErrorCodeUtils f453403a = null;

    private ECErrorCodeUtils() {
    }

    static {
        f453403a = new ECErrorCodeUtils();
    }

    public static int a(Throwable r100) {
        Throwable r101 = r100;
    L4:
        if (r101 == null) goto L6;
        Throwable r102 = r101.getCause();
    L7:
        if (r102 == null) goto L18;
        if (r101 == null) goto L10;
        Throwable r103 = r101.getCause();
    L12:
        if ((r103 instanceof IllegalStateException) == true) goto L18;
        if (r101 != null) goto L15;
        r101 = null;
        goto L4
    L15:
        r101 = r101.getCause();
        goto L4
    L10:
        r103 = null;
    L18:
        if ((r101 instanceof NetworkNotAvailabeException) == false) goto L26;
        String r104 = r101.getMessage();
        if (r104 != null) goto L22;
    L24:
        int r105 = -10002;
    L55:
        if (r105 == 10000) goto L58;
        return r105;
    L58:
        if ((r101 instanceof JsonSyntaxException) == false) goto L61;
        return PerfPhotoViewMonitor.ErrorReason.PIC_LOAD_MODEL_FROM_SERVER;
    L61:
        if ((r101 instanceof MalformedJsonException) == false) goto L64;
        return PerfPhotoViewMonitor.ErrorReason.PIC_DOWNLOAD_ORIGIN_FAILED;
    L64:
        if ((r101 instanceof IOException) == false) goto L99;
        String r106 = r101.getMessage();
        if (r106 != null) goto L68;
        return 10000;
    L68:
        if (StringsKt.contains$default(r106, "missing CR", false, 2, null) == false) goto L71;
        return PerfPhotoViewMonitor.ErrorReason.PIC_DOWNLOAD_MIDDLE_FAILED;
    L71:
        if (StringsKt.contains$default(r106, "Premature EOF", false, 2, null) == false) goto L74;
        return PerfPhotoViewMonitor.ErrorReason.PIC_LOAD_MEDIA_COVER_FAILED;
    L74:
        if (StringsKt.contains$default(r106, "Chunk header too long", false, 2, null) == false) goto L77;
        return -20006;
    L77:
        if (StringsKt.contains$default(r106, "stream is closed", false, 2, null) == false) goto L80;
        return -20007;
    L80:
        if (StringsKt.contains$default(r106, "Bogus chunk size", false, 2, null) == false) goto L83;
        return -20008;
    L83:
        if (StringsKt.contains$default(r106, "missing LF", false, 2, null) == false) goto L85;
    L97:
        return -20009;
    L85:
        if (StringsKt.contains$default(r106, "Chunk header not end with CRLF", false, 2, null) == true) goto L97;
        if (StringsKt.contains$default(r106, "LF should be proceeded by CR", false, 2, null) == false) goto L91;
        return -20010;
    L91:
        if (StringsKt.contains$default(r106, "Chunk header is not hex string", false, 2, null) == false) goto L94;
        return -20011;
    L94:
        if (StringsKt.contains$default(r106, "Download file too large", false, 2, null) == false) goto L96;
        return -20012;
    L96:
        return -20013;
    L99:
        if ((r100 instanceof ChunkDataException) == false) goto L122;
        return PerfPhotoViewMonitor.ErrorReason.PIC_LOAD_LOCAL_FILE_FAILED;
    L122:
        return 10000;
    L22:
        if (StringsKt.contains$default(r104, "from search self check", false, 2, null) != true) goto L24;
        r105 = -10001;
        goto L55
    L26:
        if ((r101 instanceof CronetIOException) == false) goto L40;
        String r107 = r101.getMessage();
        if (r107 != null) goto L30;
    L54:
        r105 = 10000;
        goto L55
    L30:
        if (StringsKt.contains$default(r107, "PROXY_CONNECTION_FAILED", false, 2, null) == false) goto L33;
        r105 = -10003;
        goto L55
    L33:
        if (StringsKt.contains$default(r107, "HTTP2_PROTOCOL_ERROR", false, 2, null) == false) goto L36;
        r105 = -10004;
        goto L55
    L36:
        if (StringsKt.contains$default(r107, "TTNET_APP_TIMED_OUT", false, 2, null) == false) goto L38;
        r105 = -10005;
        goto L55
    L38:
        r105 = -10006;
        goto L55
    L40:
        if ((r101 instanceof CdnCacheVerifyException) == false) goto L43;
        r105 = -10008;
        goto L55
    L43:
        if ((r101 instanceof ClientProtocolException) == false) goto L46;
        r105 = -10009;
        goto L55
    L46:
        if ((r101 instanceof NoHttpResponseException) == false) goto L49;
        r105 = -10011;
        goto L55
    L49:
        if ((r101 instanceof NotAllowApiHttpException) == false) goto L52;
        r105 = -10012;
        goto L55
    L52:
        if ((r101 instanceof NotAllowUseNetworkException) == false) goto L54;
        r105 = -10013;
        goto L55
    L6:
        r102 = null;
        goto L7
    }
}
