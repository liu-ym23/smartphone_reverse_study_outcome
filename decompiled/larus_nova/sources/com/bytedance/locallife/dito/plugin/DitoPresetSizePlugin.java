package com.bytedance.locallife.dito.plugin;

import android.util.LruCache;
import androidx.lifecycle.Observer;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.core.AbsDitoPlugin;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.dito.data.DitoStyle;
import com.bytedance.locallife.dito.data.p;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.utils.j;
import com.bytedance.locallife.dito.utils.l;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/dito/plugin/DitoPresetSizePlugin;", "Lcom/bytedance/locallife/dito/core/AbsDitoPlugin;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoPresetSizePlugin extends AbsDitoPlugin {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.locallife.dito.config.g f258603f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LruCache<String, b> f258604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f258605e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/dito/plugin/DitoPresetSizePlugin$b;", "", "", "width", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "updateAt", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("height")
        private final Integer height;

        @SerializedName("updateAt")
        private final Long updateAt;

        @SerializedName("width")
        private final Integer width;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.height, r101.height) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.updateAt, r101.updateAt) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.width;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.height;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.updateAt;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ComponentCacheData(width=" + this.width + ", height=" + this.height + ", updateAt=" + this.updateAt + ')';
        }

        public final Integer a() {
            return this.height;
        }

        public final Long b() {
            return this.updateAt;
        }

        public b(Integer r100, Integer r101, Long r102) {
            this.width = r100;
            this.height = r101;
            this.updateAt = r102;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPresetSizePlugin f258606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.ugc.aweme.compat.nullable.Observer<com.bytedance.locallife.dito.data.b> f258607b;

        public c(DitoPresetSizePlugin r100, f r101) {
            this.f258606a = r100;
            this.f258607b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            p r101 = (p) r100;
            this.f258606a.e().k().removeObserver(this.f258607b);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPresetSizePlugin f258608a;

        public d(DitoPresetSizePlugin r100) {
            this.f258608a = r100;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.b r101 = (com.bytedance.locallife.dito.data.b) r100;
            DitoPresetSizePlugin r102 = this.f258608a;
            BaseDitoView<?> r103 = r101.f258195a;
            BaseDitoModel<?> r104 = r101.f258196b;
            com.bytedance.locallife.dito.config.g r105 = DitoPresetSizePlugin.f258603f;
            if (r105 == null) goto L7;
            boolean r106 = r105.b(r102.g(), r103, r104);
            boolean r107 = true;
            if (r106 == true) goto L9;
        L8:
            r107 = false;
        L9:
            String r108 = null;
            b r109 = null;
            if (r107 == false) goto L23;
            DitoPresetSizePlugin r110 = this.f258608a;
            BaseDitoView<?> r111 = r101.f258195a;
            BaseDitoModel<?> r112 = r101.f258196b;
            if (r105 == null) goto L14;
            String r113 = r105.a(r110.g(), r111, r112);
        L15:
            DitoPresetSizePlugin r114 = this.f258608a;
            BaseDitoView<?> r115 = r101.f258195a;
            r114.getClass();
            if (r115.L() == false) goto L19;
            r109 = new b(Integer.valueOf(com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r115.getWidth()))), Integer.valueOf(com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r115.getHeight()))), Long.valueOf(System.currentTimeMillis()));
        L19:
            if (j.i(r113) == false) goto L22;
            if (r109 == null) goto L22;
            this.f258608a.f258604d.put(r113, r109);
            rq6.a.f538927a.a("DitoPresetSizePlugin", "update cache " + r113 + ' ' + r109 + ", cacheSize: " + this.f258608a.f258604d.size());
            return;
        L22:
            rq6.a.f538927a.d("DitoPresetSizePlugin", "failed to update cache, invalid key(" + r113 + ") or value(" + r109 + ')');
            return;
        L14:
            r110.getClass();
            r113 = null;
            goto L15
        L23:
            rq6.a r116 = rq6.a.f538927a;
            StringBuilder r117 = new StringBuilder("not update cache: ");
            BaseDitoModel<?> r118 = r101.f258196b;
            if (r118 == null) goto L26;
            r108 = r118.f258493b.f258222b;
        L26:
            r117.append(r108);
            r117.append(", cause not enable");
            r116.a("DitoPresetSizePlugin", r117.toString());
            return;
        L7:
            r102.getClass();
            goto L8
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPresetSizePlugin f258609a;

        public e(DitoPresetSizePlugin r100) {
            this.f258609a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            t r101 = (t) r100;
            if (this.f258609a.f258604d.size() <= 0) goto L6;
            ThreadPoolHelper.c().submit(new com.bytedance.locallife.dito.plugin.f(this.f258609a));
            return;
        }
    }

    public static final class f<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPresetSizePlugin f258610a;

        public f(DitoPresetSizePlugin r100) {
            this.f258610a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            com.bytedance.locallife.dito.data.b r100 = (com.bytedance.locallife.dito.data.b) r210;
            DitoPresetSizePlugin r101 = this.f258610a;
            BaseDitoView<?> r102 = r100.f258195a;
            BaseDitoModel<?> r103 = r100.f258196b;
            com.bytedance.locallife.dito.config.g r104 = DitoPresetSizePlugin.f258603f;
            int r105 = 0;
            if (r104 != null) goto L5;
            r101.getClass();
        L8:
            boolean r106 = false;
        L9:
            if (r106 == false) goto L103;
            DitoPresetSizePlugin r107 = this.f258610a;
            com.bytedance.locallife.dito.model.b r108 = null;
            if (r107.f258605e == true) goto L60;
            long r109 = System.currentTimeMillis();
            if (r107.f258605e == true) goto L59;
            DitoPageInfo r110 = j.a(r107.g());
            if (r110 == null) goto L18;
            String r111 = r110.getPageId();
        L19:
            if (r111 != null) goto L21;
        L24:
            boolean r112 = true;
        L25:
            if (r112 == true) goto L59;
            Dito r113 = Dito.f257280a;
            Intrinsics.checkNotNullParameter(r113, "<this>");
            gq6.a r114 = l.e(r113);
            if (r114 == null) goto L30;
            r114.f();
            en6.j r115 = en6.j.f473173a;
        L31:
            if (r115 == null) goto L33;
            String r116 = r115.a(r111);
        L34:
            if (r116 != null) goto L36;
        L39:
            boolean r117 = true;
        L40:
            if (r117 == true) goto L59;
            Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L57
            long r119 = System.currentTimeMillis() - l.k().getPresetSizeCachePeriod();     // Catch: Throwable -> L57
            Iterator r120 = ((Map) r107.g().f258047m.fromJson(r116, new com.bytedance.locallife.dito.plugin.e().getType())).entrySet().iterator();     // Catch: Throwable -> L57
        L44:
            if (r120.hasNext() == false) goto L55;
            Map.Entry r121 = (Map.Entry) r120.next();     // Catch: Throwable -> L57
            Long r122 = ((b) r121.getValue()).b();     // Catch: Throwable -> L57
            if (r122 == null) goto L48;
            long r123 = r122.longValue();     // Catch: Throwable -> L57
        L50:
            if (r123 <= r119) goto L52;
            boolean r124 = true;
        L53:
            if (r124 == false) goto L44;
            r107.f258604d.put((String) r121.getKey(), (b) r121.getValue());     // Catch: Throwable -> L57
            goto L44
        L52:
            r124 = false;
            goto L53
        L48:
            r123 = 0;
            goto L50
        L55:
            r107.f258605e = true;     // Catch: Throwable -> L57
            rq6.a.f538927a.a("DitoPresetSizePlugin", "init cache: " + r107.f258604d.size());     // Catch: Throwable -> L57
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
        L57:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L59
        L36:
            if (r116.length() == 0) goto L39;
            r117 = false;
            goto L40
        L33:
            r116 = null;
            goto L34
        L30:
            r115 = null;
            goto L31
        L21:
            if (r111.length() == 0) goto L24;
            r112 = false;
            goto L25
        L18:
            r111 = null;
        L59:
            long r126 = System.currentTimeMillis() - r109;
            rq6.a.f538927a.a("DitoPresetSizePlugin", "init cache used: " + r126);
        L60:
            DitoPresetSizePlugin r127 = this.f258610a;
            BaseDitoView<?> r128 = r100.f258195a;
            BaseDitoModel<?> r129 = r100.f258196b;
            com.bytedance.locallife.dito.config.g r130 = DitoPresetSizePlugin.f258603f;
            if (r130 == null) goto L63;
            String r131 = r130.a(r127.g(), r128, r129);
        L65:
            if (j.i(r131) == false) goto L104;
            b r132 = this.f258610a.f258604d.get(r131);
            if (r132 == null) goto L71;
            Integer r133 = r132.a();
            if (r133 == null) goto L71;
            r105 = r133.intValue();
        L71:
            if (r105 <= 0) goto L105;
            r100.f258195a.z(r132.a());     // Catch: Throwable -> L91
            BaseDitoModel<?> r134 = r100.f258196b;     // Catch: Throwable -> L91
            if (r134 == null) goto L77;
            DitoNode r135 = r134.f258493b.f258221a;     // Catch: Throwable -> L91
            if (r135 == null) goto L77;
            DitoStyle r136 = r135.getStyle();     // Catch: Throwable -> L91
        L78:
            if (r136 == null) goto L83;
            DitoNode r137 = r100.f258196b.f258493b.f258221a;     // Catch: Throwable -> L91
            if (r137 == null) goto L83;
            r137.setStyle(DitoStyle.copy$default(r136, false, null, null, null, null, null, null, null, null, null, r132.a(), false, null, 7167, null));     // Catch: Throwable -> L91
        L83:
            BaseDitoModel<?> r138 = r100.f258196b;     // Catch: Throwable -> L91
            if (r138 == null) goto L86;
            r108 = r138.f258498g;     // Catch: Throwable -> L91
        L86:
            if (r108 == null) goto L89;
            r108.f258508h = true;     // Catch: Throwable -> L91
        L89:
            rq6.a.f538927a.a("DitoPresetSizePlugin", "use cache " + r131 + ' ' + r132);     // Catch: Throwable -> L91
            return;
        L77:
            r136 = null;
        L91:
            th = move-exception;
            rq6.a.f538927a.b("DitoPresetSizePlugin", "parse preset size cache error " + th);
            return;
        L105:
            return;
        L104:
            return;
        L63:
            r127.getClass();
            r131 = null;
            goto L65
        L103:
            return;
        L5:
            if (r104.b(r101.g(), r102, r103) != true) goto L8;
            r106 = true;
            goto L9
        }
    }

    static {
        Dito r100 = Dito.f257280a;
        f258603f = (com.bytedance.locallife.dito.config.g) Dito.a().a(com.bytedance.locallife.dito.config.g.class);
    }

    public DitoPresetSizePlugin() {
        this.f258604d = new LruCache(30);
    }

    @Override // com.bytedance.locallife.dito.core.AbsDitoPlugin
    public final void h() {
        super.h();
        f r100 = new f(this);
        e().k().observeForever(r100);
        Dito r101 = Dito.f257280a;
        if (l.k().getDisableUsePresetHeightCacheAfterFmp() == false) goto L5;
        e().k0().observeForever(new c(this, r100));
    L5:
        e().n().observeForever(new d(this));
        e().h0().observeForever(new e(this));
    }
}
