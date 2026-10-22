package tj0;

import android.graphics.Bitmap;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tf0.o;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f546387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompositeDisposable f546388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a f546389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.c f546390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> f546391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final uj0.d f546392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o.a f546393g;

    public static String a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100) {
        return "micseat_" + r100.f79080f + '_' + r100.f79078d.f546164f;
    }

    public g(uj0.d r100, o.a r101) {
        Intrinsics.checkNotNullParameter(r100, "micseatRender");
        this.f546392f = r100;
        this.f546393g = r101;
    }

    public final void b(List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "structs");
        if (this.f546387a == true) goto L5;
        return;
    L5:
        List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r100 = this.f546391e;
        if (r100 != null) goto L8;
        r100 = CollectionsKt.emptyList();
    L8:
        Intrinsics.checkNotNullParameter(r110, "micseatStructs");
        List r101 = CollectionsKt.sortedWith(r110, new com.bytedance.android.live.liveinteract.videotalk.avatarmix.b());
        List<com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r102 = r100;
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        r103.put(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r105), r105);
        goto L10
    L12:
        List r106 = r101;
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r106, 10)), 16));
        Iterator r108 = r106.iterator();
    L14:
        if (r108.hasNext() == false) goto L16;
        Object r109 = r108.next();
        r107.put(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r109), r109);
        goto L14
    L16:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r106.iterator();
    L18:
        if (r113.hasNext() == false) goto L22;
        Object r114 = r113.next();
        if ((true ^ r103.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r114))) == false) goto L18;
        r112.add(r114);
        goto L18
    L22:
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r102.iterator();
    L24:
        if (r116.hasNext() == false) goto L28;
        Object r117 = r116.next();
        if ((!r107.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r117))) == false) goto L24;
        r115.add(r117);
        goto L24
    L28:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r106.iterator();
    L30:
        if (r119.hasNext() == false) goto L34;
        Object r120 = r119.next();
        if (r103.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r120)) == false) goto L30;
        r118.add(r120);
        goto L30
    L34:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r118.iterator();
    L36:
        if (r122.hasNext() == false) goto L40;
        Object r123 = r122.next();
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r124 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r123;
        Object r125 = r103.get(a(r124));
        Intrinsics.checkNotNull(r125);
        if ((!com.bytedance.android.live.liveinteract.videotalk.avatarmix.c.a(r124, (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r125)) == false) goto L36;
        r121.add(r123);
        goto L36
    L40:
        ArrayList r126 = new ArrayList();
        Iterator r127 = r106.iterator();
    L42:
        if (r127.hasNext() == false) goto L46;
        Object r128 = r127.next();
        if (r103.keySet().contains(a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r128)) == false) goto L42;
        r126.add(r128);
        goto L42
    L46:
        ArrayList r129 = new ArrayList();
        Iterator r130 = r126.iterator();
    L48:
        if (r130.hasNext() == false) goto L52;
        Object r131 = r130.next();
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r132 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r131;
        Object r133 = r103.get(a(r132));
        Intrinsics.checkNotNull(r133);
        if (com.bytedance.android.live.liveinteract.videotalk.avatarmix.c.a(r132, (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r133) == false) goto L48;
        r129.add(r131);
        goto L48
    L52:
        Intrinsics.checkNotNullParameter(r112, "added");
        Intrinsics.checkNotNullParameter(r115, "removed");
        Intrinsics.checkNotNullParameter(r121, CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED);
        Intrinsics.checkNotNullParameter(r129, "unchanged");
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r134 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r112);
        if (r134 == null) goto L55;
        r134.f79081g = true;
    L55:
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r135 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r115);
        if (r135 == null) goto L58;
        r135.f79081g = true;
    L58:
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r136 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r121);
        if (r136 == null) goto L61;
        r136.f79081g = true;
    L61:
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r137 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) CollectionsKt.lastOrNull(r129);
        if (r137 == null) goto L65;
        r137.f79081g = true;
    L65:
        if ((!r112.isEmpty()) == false) goto L67;
    L72:
        boolean r138 = true;
    L73:
        if (r138 == true) goto L76;
        if (r111 == true) goto L76;
        return;
    L76:
        Iterator r139 = r115.iterator();
    L78:
        if (r139.hasNext() == false) goto L80;
        this.f546392f.a((com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r139.next());
        goto L78
    L80:
        List r140 = CollectionsKt.minus(r110, r115);
        CompositeDisposable r141 = this.f546388b;
        if (r141 == null) goto L83;
        r141.clear();
        this.f546388b = null;
    L83:
        this.f546388b = new CompositeDisposable();
        RxUtilKt.c(Observable.fromIterable(r140).concatMapSingle(new d(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.f546386a), this.f546388b);
        this.f546391e = r110;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a r142 = this.f546389c;
        if (r142 == null) goto L106;
        Intrinsics.checkNotNullParameter(r110, "structs");
        Iterator<T> r143 = r142.f79072a.keySet().iterator();
    L87:
        if (r143.hasNext() == false) goto L106;
        String r144 = (String) r143.next();
        if (r110.isEmpty() == true) goto L97;
        Iterator<T> r145 = r110.iterator();
    L93:
        if (r145.hasNext() == false) goto L97;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r146 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r145.next();
        int r147 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.f79071b;
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C1233a.a(r146), r144) == false) goto L93;
        boolean r148 = false;
    L98:
        if (r148 == false) goto L87;
        Pair<String, Bitmap> r149 = r142.f79072a.remove(r144);
        if (r149 == null) goto L87;
        r149.getSecond().recycle();
        int r150 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r149.getFirst()) == false) goto L87;
        String r151 = r149.getFirst();
        MemoryCache<CacheKey, CloseableImage> r152 = ImagePipelineFactory.getInstance().getImagePipeline().getBitmapMemoryCache();
        if (r152 == null) goto L87;
        r152.removeAll(new com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.b(r151));
    L97:
        r148 = true;
    L106:
        o.a r153 = this.f546393g;
        if (r153 == null) goto L157;
        r153.f();
        return;
    L157:
        return;
    L67:
        if ((!r115.isEmpty()) == true) goto L72;
        if ((!r121.isEmpty()) == true) goto L72;
        r138 = false;
        goto L73
    }
}
