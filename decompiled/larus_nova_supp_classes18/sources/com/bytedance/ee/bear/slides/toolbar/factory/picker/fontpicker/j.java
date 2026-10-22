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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public static final OkHttpClient a = null;
    public static final CoroutineScope b = null;
    public static final LruCache<String, a> c = null;
    public static final ConcurrentHashMap<String, Job> d = null;
    public static final ExecutorService e = null;
    public static final ConcurrentHashMap<String, Boolean> f = null;

    public static final class a {
        public final Drawable a;
        public final float b;
        public final float c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c);
        }

        public final String toString() {
            return "SvgCacheData(drawable=" + this.a + ", width=" + this.b + ", height=" + this.c + ')';
        }

        public a(Drawable r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public j() {
    }

    static {
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c = new LruCache(100);
        d = new ConcurrentHashMap();
        e = PThreadExecutorsUtils.newFixedThreadPool(8, new DefaultThreadFactory("ker/SvgLoader"));
        f = new ConcurrentHashMap();
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        a = r0.connectTimeout(10000, r1).readTimeout(10000, r1).writeTimeout(10000, r1).build();
    }

    public static h b(InputStream r14) {
        XmlPullParserFactory r2 = XmlPullParserFactory.newInstance();     // Catch: Exception -> L34
        r2.setNamespaceAware(true);     // Catch: Exception -> L34
        XmlPullParser r3 = r2.newPullParser();     // Catch: Exception -> L34
        Float r4 = null;
        r3.setInput(r14, null);     // Catch: Exception -> L34
        int r15 = r3.getEventType();     // Catch: Exception -> L34
    L4:
        if (r15 == 1) goto L37;
        if (r15 != 2) goto L32;
        if (StringsKt.equals(r3.getName(), "svg", true) == false) goto L32;
        String r16 = r3.getAttributeValue(null, "width");     // Catch: Exception -> L34
        String r6 = r3.getAttributeValue(null, "height");     // Catch: Exception -> L34
        String r8 = r3.getAttributeValue(null, "viewBox");     // Catch: Exception -> L34
        if (r16 == null) goto L12;
        Float r17 = StringsKt.toFloatOrNull(r16);     // Catch: Exception -> L34
    L13:
        if (r6 == null) goto L15;
        r4 = StringsKt.toFloatOrNull(r6);     // Catch: Exception -> L34
    L15:
        if (r17 == null) goto L17;
        if (r4 == null) goto L17;
    L24:
        if (r17 == null) goto L26;
        float r18 = r17.floatValue();     // Catch: Exception -> L34
    L27:
        if (r4 == null) goto L29;
        float r5 = r4.floatValue();     // Catch: Exception -> L34
    L30:
        return new h(r18, r5);
    L29:
        r5 = 0.0f;
        goto L30
    L26:
        r18 = 0.0f;
    L17:
        if (r8 == null) goto L24;
        List r7 = StringsKt.split$default(r8, new char[]{' ', ','}, false, 0, 6, null);     // Catch: Exception -> L34
        if (r7 == null) goto L24;
        if (r7.size() < 4) goto L24;
        r17 = StringsKt.toFloatOrNull((String) ListProtector.get(r7, 2));     // Catch: Exception -> L34
        r4 = StringsKt.toFloatOrNull((String) ListProtector.get(r7, 3));     // Catch: Exception -> L34
        goto L24
    L12:
        r17 = null;
    L32:
        r15 = r3.next();     // Catch: Exception -> L34
    L37:
        return new h(0.0f, 0.0f);
    L34:
        e = move-exception;
        tt5.a.e("SvgLoader", "Error parsing SVG dimensions", e, false);
        goto L37
    }

    public static final void a(AppCompatImageView r12, String r13, i r14) {
        Response r1 = a.newCall(new Request.Builder().url(r13).build()).execute();
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L4:
        if (r1.isSuccessful() == false) goto L20;
        ResponseBody r0 = r1.body();     // Catch: Throwable -> L21
        if (r0 == null) goto L17;
        InputStream r2 = r0.byteStream();     // Catch: Throwable -> L21
        if (r2 == null) goto L17;
        byte[] r3 = ByteStreamsKt.readBytes(r2);     // Catch: Throwable -> L12
        ByteArrayInputStream r4 = new ByteArrayInputStream(r3);     // Catch: Throwable -> L12
        ByteArrayInputStream r5 = new ByteArrayInputStream(r3);     // Catch: Throwable -> L12
        PictureDrawable r10 = new PictureDrawable(SVG.d(r4).g(null));     // Catch: Throwable -> L12
        h r11 = b(r5);     // Catch: Throwable -> L12
        c.put(r13, new a(r10, r11.a, r11.b));     // Catch: Throwable -> L12
        com.bytedance.ee.util.ui.m.a(new l(r14, r12, r13, r10, r11));     // Catch: Throwable -> L12
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L21
        goto L17
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L17:
        CloseableKt.closeFinally(r1, null);
        return;
    L20:
        throw new Exception("HTTP error: " + r1.code());     // Catch: Throwable -> L21
    }
}
