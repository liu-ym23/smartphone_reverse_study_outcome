package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.j;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PDPBusinessFlags;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.video.f;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VH;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.z;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.o;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.p;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.q;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.i;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.TopNavigationComponentV1;
import com.bytedance.android.shopping.prepurchase.business.pdp.e;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.h;
import com.facebook.common.references.CloseableReference;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.d0;
import vg3.e0;
import vg3.i0;
import vg3.k0;
import vg3.l;
import vg3.m;
import vg3.s;
import vg3.w;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeaderComponent extends b0 implements l {
    public static final /* synthetic */ int o = 0;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.l i;
    public final List<com.bytedance.android.shopping.anchorv4.vm.c> j;
    public final EventDependencyImpl k;
    public final Lazy l;
    public final List<Function1<Boolean, Unit>> m;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<o> n;

    public final class EventDependencyImpl implements n {
        public final /* synthetic */ HeaderComponent a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final CommonMeta a() {
            return this.a.O1().d().getData().a().a();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final void d() {
            Intrinsics.checkNotNullParameter("product_detail_capture", "eventName");
            this.a.Z1(w.class, new HeaderComponent$EventDependencyImpl$track$1("product_detail_capture", null));
        }

        public EventDependencyImpl(HeaderComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final void b(String r15, Map<String, ? extends Object> r16, boolean r17, boolean r18, String r19, View r20, String r21, PageFinder r22) {
            this.a.Z1(w.class, new HeaderComponent$EventDependencyImpl$track$2(r16, r21, r15, r18, r19, r22, r20, r17, null));
        }
    }

    public final class HeaderDependencyV2 implements u {
        public final Lazy a;
        public final Lazy b;
        public final /* synthetic */ HeaderComponent c;

        public final class a implements r {
            public final /* synthetic */ HeaderDependencyV2 a;

            /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.HeaderComponent$HeaderDependencyV2$a$a, reason: collision with other inner class name */
            public static final class C0163a implements p {
                public final /* synthetic */ a a;

                @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.p
                public final Boolean d() {
                    return Boolean.valueOf(this.a.a.d());
                }

                public C0163a(a r1) {
                    this.a = r1;
                }
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final String getSessionId() {
                return this.a.c.O1().f().a.b;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final ActionContext n0() {
                return this.a.c.O1().e().r().a.r0;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final n o0() {
                return this.a.c.k;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final q p0() {
                HeaderComponent r1 = this.a.c;
                return new a(r1, r1.k);
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final p q0() {
                return new C0163a(this);
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final ng3.a r0() {
                return new com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.q(this.a.c.O1());
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final GalleryVO s0() {
                com.bytedance.android.shopping.prepurchase.business.pdp.repository.n r0 = (com.bytedance.android.shopping.prepurchase.business.pdp.repository.n) this.a.c.O1().d().getData().a.a();
                if (r0 != null) goto L7;
                return null;
            L7:
                return r0.I;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final String v0() {
                return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.c.O1())).a.getNativeParams().getPdpEventTransparentId();
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final f x0() {
                HeaderComponent r0 = this.a.c;
                int r2 = HeaderComponent.o;
                vg3.a r1 = (vg3.a) r0.N1(vg3.a.class);
                if (r1 != null) goto L7;
                return null;
            L7:
                return r1.e();
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final String y0() {
                return ((com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.b) this.a.V()).a.H1();
            }

            public a(HeaderDependencyV2 r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final void k0(String r2) {
                Intrinsics.checkNotNullParameter(r2, "sliceId");
                com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.a.c.i;
                if (r0 == null) goto L6;
                r0.k0(r2);
                return;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final j t0(FragmentActivity r3) {
                Intrinsics.checkNotNullParameter(r3, "activity");
                HeaderComponent r4 = this.a.c;
                int r1 = HeaderComponent.o;
                vg3.u r5 = (vg3.u) r4.N1(vg3.u.class);
                if (r5 == null) goto L5;
                h r6 = r5.C();
            L6:
                v r2 = this.a.c.O1().e().r().F0();
                if (r6 == null) goto L12;
                if (r2 != null) goto L11;
                return null;
            L11:
                return new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.a(r2, r6);
            L12:
                return null;
            L5:
                r6 = null;
                goto L6
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final com.bytedance.android.ecom.arch.slice.action.p u0(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "activity");
                return this.a.c.O1().e().r().B();
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final void w0(boolean r1) {
                com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r2 = this.a.c.i;
                if (r2 == null) goto L6;
                r2.r9();
                return;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final void l0(int r2, String r3) {
                com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.a.c.i;
                if (r0 == null) goto L6;
                r0.l0(r2, r3);
                return;
            }

            @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r
            public final boolean m0(Boolean r2, boolean r3) {
                com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.a.c.i;
                if (r0 != null) goto L5;
            L7:
                return false;
            L5:
                if (r0.m0(r2, r3) != true) goto L7;
                return true;
            }
        }

        public static final class b<T> implements g {
            public final /* synthetic */ com.bytedance.android.shopping.anchorv4.vm.h a;

            public b(com.bytedance.android.shopping.anchorv4.vm.h r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
            public final void onChanged(Object r2) {
                float r3 = ((Number) r2).floatValue();
                this.a.S2(r3);
            }
        }

        public static final class c<T> implements g {
            public final /* synthetic */ com.bytedance.android.shopping.anchorv4.vm.h a;

            public c(com.bytedance.android.shopping.anchorv4.vm.h r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
            public final void onChanged(Object r2) {
                boolean r3 = ((Boolean) r2).booleanValue();
                this.a.b2(r3);
            }
        }

        public static final class d implements com.bytedance.android.shopping.anchorv4.containers.g {
            public final /* synthetic */ HeaderDependencyV2 a;

            public final void a() {
            }

            public final RecyclerView getRecyclerView() {
                return null;
            }

            public d(HeaderDependencyV2 r1) {
                this.a = r1;
            }

            public final void b(boolean r4, boolean r5, boolean r6) {
                HeaderComponent r0 = this.a.c;
                int r2 = HeaderComponent.o;
                vg3.u r1 = (vg3.u) r0.N1(vg3.u.class);
                if (r1 == null) goto L6;
                r1.v0(new k0(r4, r6, r5));
                return;
            }
        }

        public static final class e extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
            public final /* synthetic */ com.bytedance.android.ec.core.anchorv3.q c;

            @Override // java.lang.Runnable
            public final void run() {
                this.c.a();
            }

            public e(com.bytedance.android.ec.core.anchorv3.q r1, String r2) {
                this.c = r1;
                super(r2);
            }
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void a() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean l() {
            return false;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final r P() {
            return new a(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final int R() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            d0 r1 = (d0) r0.N1(d0.class);
            if (r1 == null) goto L9;
            com.bytedance.android.shopping.prepurchase.arch.container.state.d r3 = r1.R();
            if (r3 == null) goto L9;
            Integer r4 = (Integer) r3.a();
            if (r4 == null) goto L9;
            return r4.intValue();
        L9:
            return 0;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean S() {
            return this.c.O1().d().q0().a() instanceof k.d.c;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final String U() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            s r1 = (s) r0.N1(s.class);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.E1();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final x V() {
            return (com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.b) this.b.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final int W4() {
            AnchorV4HeadV2VO r0 = (AnchorV4HeadV2VO) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.c.O1().d().getData().v.getValue()).a();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getChangeKeyPosition();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean b() {
            return this.c.P1().b().isAtLeast(Lifecycle.State.RESUMED);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean b0() {
            return ((k) this.c.O1().d().q0().a()) instanceof k.d.a;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final AnchorV4Param c() {
            return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.c.O1())).a;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean d() {
            return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.c.O1())).b.a;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final com.bytedance.android.shopping.anchorv4.perf.monitor.c d0() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            y r1 = (y) r0.N1(y.class);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.V();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final f e() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            vg3.a r1 = (vg3.a) r0.N1(vg3.a.class);
            if (r1 == null) goto L5;
            AnchorV4PlayerStateManager r3 = r1.e();
        L6:
            Intrinsics.checkNotNull(r3);
            return r3;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final vg3.c e0() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            vg3.a r1 = (vg3.a) r0.N1(vg3.a.class);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.v();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void f() {
            HeaderComponent r0 = this.c;
            HeaderComponent$HeaderDependencyV2$logClickMainImg$1 r2 = new HeaderComponent$HeaderDependencyV2$logClickMainImg$1(null);
            int r3 = HeaderComponent.o;
            r0.Z1(w.class, r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final Map<String, Object> getEventParams() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            i r1 = (i) r0.N1(i.class);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.u1();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final LifecycleOwner getLifecycleOwner() {
            return com.bytedance.android.shopping.prepurchase.arch.container.state.f.a(this.c);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final String getSessionId() {
            return this.c.O1().f().a.b;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final LinkedTreeMap<String, Object> getTrackMeta() {
            PageMeta r0 = (PageMeta) this.c.O1().d().getData().b.a();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getTrackMeta();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final CloseableReference<Bitmap> h0() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            s r1 = (s) r0.N1(s.class);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.s0();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final Boolean i0() {
            HeaderComponent r0 = this.c;
            int r2 = HeaderComponent.o;
            vg3.a r1 = (vg3.a) r0.N1(vg3.a.class);
            if (r1 == null) goto L7;
            AnchorV4PlayerStateManager r3 = r1.e();
            if (r3 == null) goto L7;
            return r3.n();
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean isExpanded() {
            Boolean r0 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.c.O1())).b.d.a();
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.booleanValue();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.w j0() {
            return (com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.header.c) this.a.getValue();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final com.bytedance.android.shopping.anchorv4.containers.g k0() {
            return new d(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final AnchorV4HeadV2VO m0() {
            return (AnchorV4HeadV2VO) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.c.O1().d().getData().v.getValue()).a();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean n() {
            return this.c.O1().b().e0();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean oa() {
            com.bytedance.android.shopping.prepurchase.business.pdp.repository.n r0 = (com.bytedance.android.shopping.prepurchase.business.pdp.repository.n) this.c.O1().d().getData().a.a();
            if (r0 == null) goto L5;
            SmallVideoWindowVO r1 = r0.p;
        L6:
            if (r1 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final CommonMeta r0() {
            return this.c.O1().d().getData().a().a();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean r9() {
            PdpDataStore r0 = this.c.O1().d().getData();
            boolean r1 = this.c.a2().getNativeParams().getFullMode();
            com.bytedance.android.shopping.prepurchase.business.pdp.repository.n r2 = (com.bytedance.android.shopping.prepurchase.business.pdp.repository.n) r0.a.a();
            if (r2 == null) goto L9;
            PlayBackEntryVO r3 = r2.s;
            if (r3 == null) goto L9;
            if (r3.enablePlayBackEntryDraggable(Boolean.valueOf(r1)) != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final boolean n0() {
            return c().getNativeParams().getFullMode();
        }

        public HeaderDependencyV2(HeaderComponent r1) {
            this.c = r1;
            this.a = LazyKt.lazy(new HeaderComponent$HeaderDependencyV2$impressionService$2(this));
            this.b = LazyKt.lazy(new HeaderComponent$HeaderDependencyV2$headerSKUDependency$2(this));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void T(com.bytedance.android.shopping.anchorv4.vm.h r6) {
            Intrinsics.checkNotNullParameter(r6, "listener");
            com.bytedance.android.shopping.prepurchase.business.pdp.a r0 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.c.O1())).b;
            r0.c.b(this.c, com.bytedance.android.shopping.prepurchase.arch.container.state.j.a(), new b(r6));
            com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r0.d, this.c, new c(r6));
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void W(com.bytedance.android.shopping.anchorv4.vm.c r2) {
            Intrinsics.checkNotNullParameter(r2, "headViewStatusListener");
            ((ArrayList) this.c.j).add(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void X(HeadRecyclerView r5) {
            HeaderComponent r0 = this.c;
            HeaderComponent$HeaderDependencyV2$setInterceptHandler$1 r2 = new HeaderComponent$HeaderDependencyV2$setInterceptHandler$1(r5, null);
            int r6 = HeaderComponent.o;
            r0.Z1(d0.class, r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void Y(int r3) {
            Iterator r0 = ((ArrayList) this.c.j).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).Y8(r3);
            goto L4
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void a0(Boolean r3) {
            Iterator<T> r0 = this.c.m.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((Function1) r0.next()).invoke(r3);
            goto L4
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void c0(boolean r3) {
            Iterator r0 = ((ArrayList) this.c.j).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).a9(r3);
            goto L4
        L6:
            Iterator r4 = ((ArrayList) this.c.j).iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            ((com.bytedance.android.shopping.anchorv4.vm.c) r4.next()).X8();
            goto L8
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void p0(z r2) {
            Intrinsics.checkNotNullParameter(r2, "floatVideoHandler");
            this.c.n.g(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void Z(com.bytedance.android.ec.core.anchorv3.q r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "pdpTask");
            e r0 = new e(r4, "header_task@" + r4.getClass());
            if (r5 == false) goto L5;
            this.c.O1().b().n0(r0);
            return;
        L5:
            this.c.O1().b().e1(r0);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void f0(int r3, Bitmap r4) {
            Intrinsics.checkNotNullParameter(r4, "bitmap");
            Iterator<T> r0 = this.c.j.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).W8(r3, r4);
            goto L4
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void l0(Integer r6, int r7) {
            Iterator r0 = ((ArrayList) this.c.j).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).b9(false, r6, Integer.valueOf(r7), true);
            goto L4
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void q0(int r3, Bitmap r4) {
            Iterator<T> r0 = this.c.j.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).Z8(r3, r4);
            goto L4
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void o0(String r5, Map<String, Object> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "eventName");
            Intrinsics.checkNotNullParameter(r6, "param");
            HeaderComponent r0 = this.c;
            HeaderComponent$HeaderDependencyV2$track$1 r2 = new HeaderComponent$HeaderDependencyV2$track$1(r6, r5, r7, null);
            int r8 = HeaderComponent.o;
            r0.Z1(w.class, r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
        public final void g0(String r14, Map<String, ? extends Object> r15, String r16, View r17, boolean r18, boolean r19, String r20) {
            Intrinsics.checkNotNullParameter(r14, "eventName");
            HeaderComponent r10 = this.c;
            HeaderComponent$HeaderDependencyV2$track$2 r12 = new HeaderComponent$HeaderDependencyV2$track$2(r15, r17, r16, r14, r19, r20, r18, null);
            int r1 = HeaderComponent.o;
            r10.Z1(w.class, r12);
        }
    }

    public final class a implements q, n {
        public final /* synthetic */ n a;
        public final /* synthetic */ HeaderComponent b;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final CommonMeta a() {
            return this.a.a();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final void b(String r11, Map<String, ? extends Object> r12, boolean r13, boolean r14, String r15, View r16, String r17, PageFinder r18) {
            this.a.b(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
        public final void d() {
            Intrinsics.checkNotNullParameter("product_detail_capture", "eventName");
            this.a.d();
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.q
        public final boolean c() {
            Boolean r0 = ((e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.b.O1())).b.d.a();
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.booleanValue();
        }

        public a(HeaderComponent r2, EventDependencyImpl r3) {
            Intrinsics.checkNotNullParameter(r3, "eventDependency");
            this.b = r2;
            this.a = r3;
        }
    }

    public static final class b<T> implements g {
        public final /* synthetic */ HeaderComponent a;

        public b(HeaderComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            AnchorV4HeadV2VO r6 = (AnchorV4HeadV2VO) r5;
            LinkedHashMap r0 = new LinkedHashMap();
            if (r6 == null) goto L16;
            List<HeaderContentModel> r7 = r6.getCells();
            if (r7 == null) goto L16;
            Iterator<T> r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L16;
            HeaderContentModel r1 = (HeaderContentModel) r8.next();
            HeaderMediaModel r2 = r1.getMedia();
            if (r2 == null) goto L8;
            if (r2.getSupportPreview() != true) goto L8;
            String r3 = r1.getMedia().getFindSameUrl();
            if (r3 == null) goto L8;
            r0.put(Integer.valueOf(r1.getMedia().getPreviewIndex()), r3);
        L16:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r9 = this.a.i;
            if (r9 == null) goto L29;
            r9.w5(r0);
            return;
        }
    }

    public static final class c<T> implements g {
        public final /* synthetic */ HeaderComponent a;

        public c(HeaderComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            GalleryVO r3 = (GalleryVO) r2;
            if (r3 == null) goto L10;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.a.i;
            if (r0 == null) goto L9;
            r0.l9(r3);
            return;
        L9:
            return;
        }
    }

    public static final class d<T> implements g {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            CommonMeta r4 = (CommonMeta) r3;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.getProductDeleted() == true) goto L15;
            int r0 = r73.b.a;
            PDPBusinessFlags r5 = r4.getPdpBusinessFlags();
            if (r5 == null) goto L11;
            Integer r6 = r5.getEnablePDPOptimize();
        L12:
            r73.b.b = r6;
            return;
        L11:
            r6 = null;
            goto L12
        }
    }

    @Override // vg3.l
    public final float B1() {
        Lazy r0 = PdpAB.a;
        if (PdpAB.c != 1) goto L5;
        int r1 = com.bytedance.android.shopping.extensions.b.b(340);
    L7:
        return r1;
    L5:
        int r2 = AnchorV4TabArea.i;
        r1 = AnchorV4TabArea.i;
        goto L7
    }

    @Override // vg3.l
    public final float I1() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.n9();
    }

    @Override // vg3.l
    public final boolean J() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.J();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{d0.class, vg3.u.class, e0.class, vg3.a.class, s.class, y.class, vg3.e.class, m.class, w.class, i0.class, vg3.u.class, i.class});
    }

    @Override // vg3.l
    public final HeaderDependencyV2.a P() {
        HeaderDependencyV2 r0 = (HeaderDependencyV2) this.l.getValue();
        r0.getClass();
        return new HeaderDependencyV2.a(r0);
    }

    @Override // vg3.l
    public final boolean a() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // vg3.l
    public final List<ECUrlModel> c() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // vg3.l
    public final String f() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // vg3.l
    public final RecyclerView k1() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b.m;
    }

    @Override // vg3.l
    public final Rect m9() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m9();
    }

    @Override // vg3.l
    public final boolean s() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.s() != true) goto L7;
        return true;
    }

    public HeaderComponent() {
        this.j = new ArrayList();
        this.k = new EventDependencyImpl(this);
        this.l = LazyKt.lazy(new HeaderComponent$headerDependency$2(this));
        this.m = new ArrayList();
        this.n = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, l.class, this, false, 12);
        O1().e().r().J1(l.class, this);
        Z1(d0.class, new HeaderComponent$onAttach$1(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().v.getValue(), this, new b(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().x.getValue(), this, new c(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(O1().d().getData().a(), this, d.a);
        Z1(e0.class, new HeaderComponent$onAttach$5(this, null));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(O1().e(), "pdp_update_head_tab_fold", true, new HeaderComponent$registerEvents$1(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(O1().e(), "PDPPlayerControl", false, new HeaderComponent$registerEvents$2(this));
        com.bytedance.android.shopping.prepurchase.arch.container.ability.g.b(O1().e(), "PDPChangeHeaderTabViewHiddenStatus", false, new HeaderComponent$registerEvents$3(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // vg3.l
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d L0() {
        return this.n;
    }

    @Override // vg3.l
    public final void B0(TopNavigationComponentV1.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.j).add(r2);
    }

    @Override // vg3.l
    public final void D(Function1<? super Result<Rect>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.D(r2);
        return;
    }

    @Override // vg3.l
    public final void G1(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.m).add(r2);
    }

    @Override // vg3.l
    public final void m1(TopNavigationComponentV1.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.j).remove(r2);
    }

    @Override // vg3.l
    public final AnchorV4HeadV2VH n(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        AnchorV4HeadV2VH r0 = new AnchorV4HeadV2VH(r3.getContext(), (HeaderDependencyV2) this.l.getValue());
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r4 = r0.n;
        if (r4 == null) goto L7;
        this.i = r4;
        SlcContext r5 = O1().e().r().a;
        Intrinsics.checkNotNullParameter(r5, "slcRenderContext");
        r0.m.h.b = r5;
        return r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.IHeaderOuterAbilityV2");
    }

    @Override // vg3.l
    public final void t(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.t(r2);
        return;
    }

    @Override // vg3.l
    public final void x(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.p r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.x(r2);
        return;
    }

    @Override // vg3.l
    public final void z5(boolean r2) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.b.p = r2;
        return;
    }

    @Override // vg3.l
    public final void z(View r2, String r3, Map<String, ? extends Object> r4, Map<String, ? extends Object> r5) {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.l r0 = this.i;
        if (r0 == null) goto L6;
        r0.z(r2, r3, r4, r5);
        return;
    }
}
