package com.bytedance.locallife.dito.common.request;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.common.sonic.SonicJsonParser;
import com.bytedance.locallife.dito.utils.s;
import com.google.gson.Gson;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB5\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/dito/common/request/DitoChunkData;", "Lcom/bytedance/locallife/dito/common/request/ChunkData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/Gson;", "gson", "Ljava/lang/Class;", "clazz", "covert", "(Lcom/google/gson/Gson;Ljava/lang/Class;)Ljava/lang/Object;", "defaultGson$delegate", "Lkotlin/Lazy;", "getDefaultGson", "()Lcom/google/gson/Gson;", "defaultGson", "", "index", "Ljava/io/InputStream;", "originStream", "", DBDefinition.MIME_TYPE, "", "", "extra", "<init>", "(ILjava/io/InputStream;Ljava/lang/String;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoChunkData extends ChunkData {
    public static final a Companion = null;
    private static final String TAG = null;
    private static final boolean enableSIMD = false;
    private static final boolean enableSIMDDiff = false;
    private final Lazy defaultGson$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        TAG = "DitoChunkData";
        enableSIMD = com.bytedance.locallife.dito.common.experiment.b.a();
        enableSIMDDiff = com.bytedance.locallife.dito.common.experiment.b.b();
    }

    private final Gson getDefaultGson() {
        return (Gson) this.defaultGson$delegate.getValue();
    }

    public static final /* synthetic */ boolean access$getEnableSIMD$cp() {
        return enableSIMD;
    }

    public static final /* synthetic */ boolean access$getEnableSIMDDiff$cp() {
        return enableSIMDDiff;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    @Override // com.bytedance.locallife.dito.common.request.ChunkData
    public <T> T covert(Gson r210, Class<T> r211) {
        Intrinsics.checkNotNullParameter(r211, "clazz");
        if (r210 != null) goto L5;
        Gson r100 = getDefaultGson();
    L7:
        if (getData() == null) goto L13;
        T r101 = (T) getData();
        if (r101 != null) goto L12;
        return null;
    L12:
        return r101;
    L13:
        int r102 = s.f258715a;
        InputStream r103 = getInputStream();
        String r104 = getCharset();
        int r110 = 0;
        if (r103 != null) goto L141;
    L53:
        String r105 = "";
    L54:
        String r106 = r105;
        boolean r107 = true;
        if (r106 != null) goto L57;
    L60:
        boolean r108 = true;
    L61:
        if (r108 == false) goto L83;
        String r109 = "input stream is " + getInputStream().getClass().getName() + ", charset: " + getCharset();
        if ((getInputStream() instanceof ByteArrayInputStream) == false) goto L82;
        Field[] r111 = ByteArrayInputStream.class.getDeclaredFields();
        int r112 = r111.length;
    L65:
        if (r110 >= r112) goto L70;
        Field r113 = r111[r110];
        if (Intrinsics.areEqual(r113.getName(), "count") == true) goto L71;
        r110 = r110 + 1;
    L71:
        if (r113 != null) goto L146;
    L74:
        if (r113 == null) goto L76;
        Object r114 = r113.get(getInputStream());     // Catch: Throwable -> L79
    L77:
        r109 = "input stream count: " + r114 + ", charset: " + getCharset();     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        r109 = "failed to get input stream count: " + th + ", charset: " + getCharset();
        goto L82
    L76:
        r114 = null;
        goto L77
    L146:
        r113.setAccessible(true);     // Catch: Throwable -> L79
        goto L74
    L70:
        r113 = null;
    L82:
        throw new IllegalStateException("inputStream is empty, chunkIndex: " + getIndex() + ", mimeType: " + getMimeType() + ", " + r109 + ", extra: " + getExtra());
    L83:
        long r115 = System.currentTimeMillis();
    L131:
        th = move-exception;
        getInputStream().close();
        throw th;
    L133:
        e = move-exception;
        throw new Exception("response:" + r106, e);     // Catch: Throwable -> L131
    L86:
        if (enableSIMD == false) goto L100;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L92
        setData(SonicJsonParser.parseJson(r100, r106, r211));     // Catch: Throwable -> L92
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L90
    L95:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L131 Exception -> L133
        if (r118 == null) goto L98;
        rq6.a.f538927a.b(TAG, "sonic json parse error,content:" + r106 + ",e:" + r118.getMessage());     // Catch: Throwable -> L131 Exception -> L133
        setData(r100.fromJson(r106, r211));     // Catch: Throwable -> L131 Exception -> L133
        com.bytedance.crash.d.d(r118, "sonic json parse error:" + r118.getMessage() + ",content:" + r106);     // Catch: Throwable -> L131 Exception -> L133
    L98:
        boolean r119 = r107;
        long r120 = r115;
        boolean r121 = false;
    L126:
        getInputStream().close();
        rq6.a.f538927a.c(TAG, "poi chunk parse,useSIMD:" + r119 + ",useSIMDDiff:" + r121 + ",cost:" + (System.currentTimeMillis() - r120));
        T r122 = (T) getData();
        if (r122 != null) goto L130;
        return null;
    L130:
        return r122;
    L90:
        th = th;
    L94:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L131 Exception -> L133
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131 Exception -> L133
    L92:
        th = th;
        r107 = false;
        goto L94
    L100:
        if (enableSIMDDiff == true) goto L160;
        r120 = r115;
        setData(r100.fromJson(r106, r211));     // Catch: Throwable -> L131 Exception -> L133
        r121 = false;
    L125:
        r119 = false;
        goto L126
    L160:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L117
        Object r125 = SonicJsonParser.parseJson(r100, r106, r211);     // Catch: Throwable -> L117
        Object r126 = r100.fromJson(r106, r211);     // Catch: Throwable -> L117
        int r127 = aq6.f.f15904a;     // Catch: Throwable -> L114
        Intrinsics.checkNotNullParameter(r100, "gson");     // Catch: Throwable -> L114
        Intrinsics.checkNotNullParameter(r100, "gson");     // Catch: Throwable -> L114
        Map r128 = aq6.f.a(r100);     // Catch: Throwable -> L114
        rq6.a r129 = rq6.a.f538927a;     // Catch: Throwable -> L114
        String r130 = TAG;     // Catch: Throwable -> L114
        StringBuilder r131 = new StringBuilder();     // Catch: Throwable -> L114
        r120 = r115;
        r131.append("sonic diff mode,result:");     // Catch: Throwable -> L112
        r131.append(r128);     // Catch: Throwable -> L112
        r129.c(r130, r131.toString());     // Catch: Throwable -> L112
        if ((!r128.isEmpty()) == true) goto L148;
    L108:
        setData(r126);     // Catch: Throwable -> L110
        Object r132 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L110
        r121 = true;
    L120:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);     // Catch: Throwable -> L131 Exception -> L133
        if (r133 == null) goto L125;
        rq6.a.f538927a.b(TAG, "sonic json json error,content:" + r106 + ",e:" + r133.getMessage());     // Catch: Throwable -> L131 Exception -> L133
        setData(r100.fromJson(r106, r211));     // Catch: Throwable -> L131 Exception -> L133
        com.bytedance.crash.d.d(r133, "sonic json diff error:" + r133.getMessage() + ",content:" + r106);     // Catch: Throwable -> L131 Exception -> L133
    L110:
        th = th;
    L116:
        r121 = true;
    L119:
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L131 Exception -> L133
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L131 Exception -> L133
        goto L120
    L148:
        r129.b(r130, "diffResult:" + r128 + "\nsonicData:" + r125 + ",\ngsonData:" + r126 + ",\ncontent:" + r106);     // Catch: Throwable -> L110
        Throwable r135 = new Throwable("diffResult not equal");     // Catch: Throwable -> L110
        StringBuilder r136 = new StringBuilder();     // Catch: Throwable -> L110
        r136.append("sonic json diff error:");     // Catch: Throwable -> L110
        r136.append(r128);     // Catch: Throwable -> L110
        r136.append(",\ncontent:");     // Catch: Throwable -> L110
        r136.append(r106);     // Catch: Throwable -> L110
        com.bytedance.crash.d.d(r135, r136.toString());     // Catch: Throwable -> L110
    L112:
        th = th;
    L114:
        th = th;
        r120 = r115;
    L117:
        th = th;
        r120 = r115;
        r121 = false;
        goto L119
    L57:
        if (r106.length() == 0) goto L60;
        r108 = false;
        goto L61
    L141:
        if (r104 == null) goto L53;
        ByteArrayOutputStream r137 = new ByteArrayOutputStream();     // Catch: Throwable -> L28 IOException -> L30
        byte[] r138 = new byte[8192];     // Catch: Throwable -> L28 IOException -> L30
    L18:
        int r139 = r103.read(r138, 0, 8192);     // Catch: Throwable -> L28 IOException -> L30
        if (r139 == (-1)) goto L144;
        r137.write(r138, 0, r139);     // Catch: Throwable -> L28 IOException -> L30
    L144:
        r103.close();     // Catch: IOException -> L24
    L38:
        if (r137 == null) goto L53;
        if (Charset.isSupported(r104) == true) goto L43;
        r104 = "UTF-8";
    L43:
        r105 = r137.toString(r104);     // Catch: UnsupportedEncodingException -> L51
        goto L54
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: UnsupportedEncodingException -> L51
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        r103.close();     // Catch: IOException -> L34
    L37:
        r137 = null;
        goto L38
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: UnsupportedEncodingException -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        r103.close();     // Catch: IOException -> L47
    L166:
        throw th;     // Catch: UnsupportedEncodingException -> L51
    L47:
        e = move-exception;
        e.printStackTrace();     // Catch: UnsupportedEncodingException -> L51
        throw th;     // Catch: UnsupportedEncodingException -> L51
    L5:
        r100 = r210;
        goto L7
    }

    public DitoChunkData(int r100, InputStream r101, String r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "originStream");
        Intrinsics.checkNotNullParameter(r103, "extra");
        super(r100, r101, r102, r103);
        this.defaultGson$delegate = LazyKt.lazy(DitoChunkData$defaultGson$2.INSTANCE);
    }
}
