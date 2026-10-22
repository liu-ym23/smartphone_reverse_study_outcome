package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.caverock.androidsvg.SVG;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OkHttpClient f238723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f238724b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, a> f238725c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Job> f238726d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f238727e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f238728f = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f238729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f238730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f238731c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f238729a, r101.f238729a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.f238730b, r101.f238730b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f238731c, r101.f238731c) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f238729a.hashCode() * 31) + Float.floatToIntBits(this.f238730b)) * 31) + Float.floatToIntBits(this.f238731c);
        }

        public final String toString() {
            return "SvgCacheData(drawable=" + this.f238729a + ", width=" + this.f238730b + ", height=" + this.f238731c + ')';
        }

        public a(Drawable r100, float r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "drawable");
            this.f238729a = r100;
            this.f238730b = r101;
            this.f238731c = r102;
        }
    }

    public j() {
    }

    static {
        f238724b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f238725c = new LruCache(100);
        f238726d = new ConcurrentHashMap();
        f238727e = PThreadExecutorsUtils.newFixedThreadPool(8, new DefaultThreadFactory("ker/SvgLoader"));
        f238728f = new ConcurrentHashMap();
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        TimeUnit r101 = TimeUnit.MILLISECONDS;
        f238723a = r100.connectTimeout(10000, r101).readTimeout(10000, r101).writeTimeout(10000, r101).build();
    }

    public static h b(InputStream r110) {
        XmlPullParserFactory r100 = XmlPullParserFactory.newInstance();     // Catch: Exception -> L34
        r100.setNamespaceAware(true);     // Catch: Exception -> L34
        XmlPullParser r101 = r100.newPullParser();     // Catch: Exception -> L34
        Float r102 = null;
        r101.setInput(r110, null);     // Catch: Exception -> L34
        int r111 = r101.getEventType();     // Catch: Exception -> L34
    L4:
        if (r111 == 1) goto L37;
        if (r111 != 2) goto L32;
        if (StringsKt.equals(r101.getName(), "svg", true) == false) goto L32;
        String r112 = r101.getAttributeValue(null, "width");     // Catch: Exception -> L34
        String r103 = r101.getAttributeValue(null, "height");     // Catch: Exception -> L34
        String r104 = r101.getAttributeValue(null, "viewBox");     // Catch: Exception -> L34
        if (r112 == null) goto L12;
        Float r113 = StringsKt.toFloatOrNull(r112);     // Catch: Exception -> L34
    L13:
        if (r103 == null) goto L15;
        r102 = StringsKt.toFloatOrNull(r103);     // Catch: Exception -> L34
    L15:
        if (r113 == null) goto L17;
        if (r102 == null) goto L17;
    L24:
        if (r113 == null) goto L26;
        float r114 = r113.floatValue();     // Catch: Exception -> L34
    L27:
        if (r102 == null) goto L29;
        float r105 = r102.floatValue();     // Catch: Exception -> L34
    L30:
        return new h(r114, r105);
    L29:
        r105 = 0.0f;
        goto L30
    L26:
        r114 = 0.0f;
    L17:
        if (r104 == null) goto L24;
        List r106 = StringsKt.split$default(r104, new char[]{' ', ','}, false, 0, 6, null);     // Catch: Exception -> L34
        if (r106 == null) goto L24;
        if (r106.size() < 4) goto L24;
        r113 = StringsKt.toFloatOrNull((String) ListProtector.get(r106, 2));     // Catch: Exception -> L34
        r102 = StringsKt.toFloatOrNull((String) ListProtector.get(r106, 3));     // Catch: Exception -> L34
        goto L24
    L12:
        r113 = null;
    L32:
        r111 = r101.next();     // Catch: Exception -> L34
    L37:
        return new h(0.0f, 0.0f);
    L34:
        e = move-exception;
        tt5.a.e("SvgLoader", "Error parsing SVG dimensions", e, false);
        goto L37
    }

    public static final void a(AppCompatImageView r110, String r111, i r112) {
        Response r100 = f238723a.newCall(new Request.Builder().url(r111).build()).execute();
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    L4:
        if (r100.isSuccessful() == false) goto L20;
        ResponseBody r101 = r100.body();     // Catch: Throwable -> L21
        if (r101 == null) goto L17;
        InputStream r102 = r101.byteStream();     // Catch: Throwable -> L21
        if (r102 == null) goto L17;
        byte[] r103 = ByteStreamsKt.readBytes(r102);     // Catch: Throwable -> L12
        ByteArrayInputStream r104 = new ByteArrayInputStream(r103);     // Catch: Throwable -> L12
        ByteArrayInputStream r105 = new ByteArrayInputStream(r103);     // Catch: Throwable -> L12
        PictureDrawable r113 = new PictureDrawable(SVG.d(r104).g(null));     // Catch: Throwable -> L12
        h r114 = b(r105);     // Catch: Throwable -> L12
        f238725c.put(r111, new a(r113, r114.f238721a, r114.f238722b));     // Catch: Throwable -> L12
        com.bytedance.ee.util.ui.m.a(new l(r112, r110, r111, r113, r114));     // Catch: Throwable -> L12
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L21
        goto L17
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L17:
        CloseableKt.closeFinally(r100, null);
        return;
    L20:
        throw new Exception("HTTP error: " + r100.code());     // Catch: Throwable -> L21
    }
}
