package wc8;

import android.util.LruCache;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f559187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, ConcurrentHashMap<String, a>> f559188b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, IMMetaInfo.InsertTextReference> f559189c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, RichMediaMeta> f559190d = null;

    public b() {
    }

    static {
        f559187a = new b();
        f559188b = new LruCache(20);
        f559189c = new LruCache(30);
        f559190d = new LruCache(30);
    }

    public static RichMediaMeta e(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "parseCallback");
        if (r100 != null) goto L5;
        return null;
    L5:
        LruCache<String, RichMediaMeta> r102 = f559190d;
        RichMediaMeta r103 = r102.get(r100);
        if (r103 != null) goto L11;
        RichMediaMeta r104 = (RichMediaMeta) r101.invoke(r100);
        if (r104 == null) goto L12;
        r102.put(r100, r104);
        return r104;
    L12:
        return null;
    L11:
        return r103;
    }

    public static IMMetaInfo.InsertTextReference f(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "parseCallback");
        if (r100 != null) goto L5;
        return null;
    L5:
        LruCache<String, IMMetaInfo.InsertTextReference> r102 = f559189c;
        IMMetaInfo.InsertTextReference r103 = r102.get(r100);
        if (r103 != null) goto L11;
        IMMetaInfo.InsertTextReference r104 = (IMMetaInfo.InsertTextReference) r101.invoke(r100);
        if (r104 == null) goto L12;
        r102.put(r100, r104);
        return r104;
    L12:
        return null;
    L11:
        return r103;
    }

    public final synchronized String b(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "valueId");     // Catch: Throwable -> L17
        Iterator<Map.Entry<String, ConcurrentHashMap<String, a>>> r102 = f559188b.snapshot().entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        String r103 = null;
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, ConcurrentHashMap<String, a>> r104 = r102.next();     // Catch: Throwable -> L17
        if (r104.getValue().get(r100) == null) goto L6;
        a r105 = r104.getValue().get(r100);     // Catch: Throwable -> L17
        if (r105 == null) goto L4;
        r103 = r105.f559184a;     // Catch: Throwable -> L17
        goto L6
    L12:
        if (r103 == null) goto L14;
        FLogger.f375446a.d("TextContentCacheUtils", "getDataValue success✅✅ source:" + r101 + " valueId:" + r100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return r103;
    L14:
        FLogger.f375446a.d("TextContentCacheUtils", "getDataValue failed❌❌ source:" + r101 + " valueId:" + r100);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized a d(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "messageId");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r101, "valueId");     // Catch: Throwable -> L10
        ConcurrentHashMap<String, a> r102 = f559188b.get(r100);     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        a r103 = r102.get(r101);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r103;
    L7:
        r103 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized RichMediaMeta g(String r100, String r101) {
        monitor-enter(this);
        Iterator<Map.Entry<String, ConcurrentHashMap<String, a>>> r102 = f559188b.snapshot().entrySet().iterator();     // Catch: Throwable -> L17
    L4:
        RichMediaMeta r103 = null;
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, ConcurrentHashMap<String, a>> r104 = r102.next();     // Catch: Throwable -> L17
        if (r104.getValue().get(r100) == null) goto L6;
        a r105 = r104.getValue().get(r100);     // Catch: Throwable -> L17
        if (r105 == null) goto L4;
        r103 = r105.f559186c;     // Catch: Throwable -> L17
        goto L6
    L12:
        if (r103 == null) goto L14;
        FLogger.f375446a.d("TextContentCacheUtils", "getRichMediaMeta success✅✅ source:" + r101 + " valueId:" + r100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return r103;
    L14:
        FLogger.f375446a.d("TextContentCacheUtils", "getRichMediaMeta failed❌❌ source:" + r101 + " valueId:" + r100);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r100, String r101, a r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "messageId");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r101, "valueId");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r102, "cache");     // Catch: Throwable -> L9
        LruCache<String, ConcurrentHashMap<String, a>> r103 = f559188b;     // Catch: Throwable -> L9
        ConcurrentHashMap<String, a> r104 = r103.get(r100);     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        r104.put(r101, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        r103.put(r100, new ConcurrentHashMap(MapsKt.mapOf(TuplesKt.to(r101, r102))));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized String c(String r100, String r101, String r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "valueId");     // Catch: Throwable -> L24
        if (r100 != null) goto L9;
        String r103 = b(r101, r102);     // Catch: Throwable -> L24
        monitor-exit(this);
        return r103;
    L9:
        ConcurrentHashMap<String, a> r104 = f559188b.get(r100);     // Catch: Throwable -> L24
        if (r104 == null) goto L15;
        a r105 = r104.get(r101);     // Catch: Throwable -> L24
        if (r105 == null) goto L15;
        String r106 = r105.f559184a;     // Catch: Throwable -> L24
    L16:
        if (r102 != null) goto L19;
        monitor-exit(this);
        return r106;
    L19:
        if (r106 == null) goto L21;
        FLogger.f375446a.d("TextContentCacheUtils", "getDataValue success✅✅ source:" + r102 + " valueId:" + r101);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return r106;
    L21:
        FLogger.f375446a.d("TextContentCacheUtils", "getDataValue failed❌❌ source:" + r102 + " valueId:" + r101);     // Catch: Throwable -> L24
    L15:
        r106 = null;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized RichMediaMeta h(String r100, String r101, String r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "valueId");     // Catch: Throwable -> L20
        if (r100 != null) goto L9;
        RichMediaMeta r103 = g(r101, r102);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r103;
    L9:
        ConcurrentHashMap<String, a> r104 = f559188b.get(r100);     // Catch: Throwable -> L20
        if (r104 == null) goto L14;
        a r105 = r104.get(r101);     // Catch: Throwable -> L20
        if (r105 == null) goto L14;
        RichMediaMeta r106 = r105.f559186c;     // Catch: Throwable -> L20
    L15:
        if (r106 == null) goto L17;
        FLogger.f375446a.d("TextContentCacheUtils", "getRichMediaMeta success✅✅ source:" + r102 + " valueId:" + r101);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return r106;
    L17:
        FLogger.f375446a.d("TextContentCacheUtils", "getRichMediaMeta failed❌❌ source:" + r102 + " valueId:" + r101);     // Catch: Throwable -> L20
    L14:
        r106 = null;
    L20:
        th = move-exception;
        throw th;
    }
}
