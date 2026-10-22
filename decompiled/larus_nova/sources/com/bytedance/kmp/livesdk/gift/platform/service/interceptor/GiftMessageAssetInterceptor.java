package com.bytedance.kmp.livesdk.gift.platform.service.interceptor;

import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.j;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class GiftMessageAssetInterceptor implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f252454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f252455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f252456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f252457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Long, List<yh6.c>> f252458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f252459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f252460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f252461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f252462i;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Pair<List<Long>, yh6.c>> f252463a;

        public a() {
            this.f252463a = new ArrayList();
        }
    }

    public static final class b {
    }

    public static final class c implements IAssetsManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftMessageAssetInterceptor f252464a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public c(GiftMessageAssetInterceptor r100) {
            this.f252464a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends e> r110) {
            Intrinsics.checkNotNullParameter(r110, "assetsModels");
            StringBuilder r100 = new StringBuilder("onSyncAssetsListSuccess, assetIdList = ");
            List<? extends e> r111 = r110;
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator<T> r112 = r111.iterator();
        L4:
            if (r112.hasNext() == false) goto L6;
            r101.add(Long.valueOf(((e) r112.next()).getId()));
            goto L4
        L6:
            r100.append(GsonProtectorUtils.toJson(l97.a.f508113a, r101));
            jy0.b.a("GiftMessageAssetInterceptor", r100.toString());
            Iterator r113 = ((LinkedHashMap) this.f252464a.f252458e).entrySet().iterator();
        L7:
            boolean r102 = true;
            if (r113.hasNext() == false) goto L45;
            long r103 = ((Number) ((Map.Entry) r113.next()).getKey()).longValue();
            if (this.f252464a.f252461h.G1(r103) == null) goto L26;
            List r104 = (List) ((LinkedHashMap) this.f252464a.f252458e).get(Long.valueOf(r103));
            if (r104 == null) goto L25;
            Iterator r105 = r104.iterator();
        L15:
            if (r105.hasNext() == false) goto L25;
            yh6.c r106 = (yh6.c) r105.next();
            StringBuilder r107 = new StringBuilder("insert message， giftId = ");
            if ((r106 instanceof o7) == true) goto L19;
            yh6.c r108 = null;
        L20:
            o7 r109 = (o7) r108;
            if (r109 == null) goto L23;
            long r114 = r109.getGiftId();
        L24:
            r107.append(r114);
            jy0.b.a("GiftMessageAssetInterceptor", r107.toString());
            this.f252464a.f252462i.insert(r106, true);
            goto L15
        L23:
            r114 = -1;
            goto L24
        L19:
            r108 = r106;
        L25:
            boolean r115 = true;
        L27:
            List r116 = (List) ((LinkedHashMap) this.f252464a.f252458e).get(Long.valueOf(r103));
            if (r116 == null) goto L30;
            int r117 = r116.size();
        L32:
            if (r117 > ((Number) this.f252464a.f252456c.getValue()).intValue()) goto L35;
            r102 = false;
        L35:
            if (r115 == true) goto L39;
            if (this.f252464a.a() == false) goto L7;
            if (r102 == false) goto L7;
        L39:
            if (r102 == false) goto L41;
            jy0.b.a("GiftMessageAssetInterceptor", "cached message count over limit: effectId = " + r103);
        L41:
            List r118 = (List) ((LinkedHashMap) this.f252464a.f252458e).get(Long.valueOf(r103));
            if (r118 == null) goto L44;
            r118.clear();
        L44:
            r113.remove();
            goto L7
        L30:
            r117 = 0;
            goto L32
        L26:
            r115 = false;
            goto L27
        L45:
            GiftMessageAssetInterceptor r119 = this.f252464a;
            a r120 = r119.f252457d;
            j r121 = r119.f252461h;
            f r122 = r119.f252462i;
            r120.getClass();
            Intrinsics.checkNotNullParameter(r121, "assetManager");
            Iterator r123 = ((ArrayList) r120.f252463a).iterator();     // Catch: Error -> L69
            HashSet r124 = new HashSet();     // Catch: Error -> L69
        L47:
            if (r123.hasNext() == false) goto L105;
            Pair r125 = (Pair) r123.next();     // Catch: Error -> L69
            if (r125.getFirst() == null) goto L67;
            if (r125.getSecond() == null) goto L67;
            Iterator r126 = ((Iterable) r125.getFirst()).iterator();     // Catch: Error -> L69
            boolean r127 = true;
        L55:
            if (r126.hasNext() == false) goto L64;
            long r128 = ((Number) r126.next()).longValue();     // Catch: Error -> L69
            if (r124.contains(Long.valueOf(r128)) == true) goto L55;
            if (r121 == null) goto L60;
            e r129 = r121.G1(r128);     // Catch: Error -> L69
        L61:
            if (r129 != null) goto L62;
            r127 = false;
            goto L55
        L62:
            r124.add(Long.valueOf(r128));     // Catch: Error -> L69
            goto L55
        L60:
            r129 = null;
            goto L61
        L64:
            if (r127 == false) goto L47;
            if (r122 == null) goto L47;
            r122.insert((yh6.c) r125.getSecond(), true);     // Catch: Error -> L69
            r123.remove();     // Catch: Error -> L69
        L67:
            r123.remove();     // Catch: Error -> L69
            goto L47
        L105:
            return;
        L69:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
    }

    public final boolean a() {
        return ((Boolean) this.f252455b.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (((Boolean) this.f252454a.getValue()).booleanValue() == true) goto L7;
        this.f252461h.T(this.f252459f);
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (((Boolean) this.f252454a.getValue()).booleanValue() == true) goto L7;
        this.f252461h.l0(this.f252459f);
        return;
    }

    public GiftMessageAssetInterceptor(g r100, j r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "assetService");
        Intrinsics.checkNotNullParameter(r102, "messageService");
        this.f252460g = r100;
        this.f252461h = r101;
        this.f252462i = r102;
        this.f252454a = LazyKt.lazy(GiftMessageAssetInterceptor$interceptorOpt$2.INSTANCE);
        this.f252455b = LazyKt.lazy(GiftMessageAssetInterceptor$memoryFixed$2.INSTANCE);
        this.f252456c = LazyKt.lazy(GiftMessageAssetInterceptor$pendingMessagePerEffectIdLimit$2.INSTANCE);
        this.f252457d = new a();
        this.f252458e = new LinkedHashMap();
        this.f252459f = new c(this);
    }
}
