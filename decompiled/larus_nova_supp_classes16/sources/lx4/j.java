package lx4;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.wikiv2.home.banner.WikiSpaceListParser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends lx4.a implements h.a, m0 {
    public final NetService b;
    public final com.bytedance.ee.bear.route.h c;
    public final lx4.e d;
    public final m e;
    public final b0 f;
    public final h0 g;
    public final h h;
    public final i i;
    public final lx4.d j;
    public boolean k;
    public List<String> l;
    public final ArrayList<Integer> m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ Document b;

        public b(j r1, Document r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Document r4 = (Document) r3;
            j r5 = this.a;
            Document r0 = this.b;
            if (r5.k == true) goto L7;
            r5.e.e(r5);
            r5.c.u5(r0.p);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            tt5.a.e("WikiAutoTestImpl", "error!", (Throwable) r4, false);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ j a;

        public d(j r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            DocumentListInfo r7 = (DocumentListInfo) r6;
            j r0 = this.a;
            Intrinsics.checkNotNull(r7);
            if (r0.k == true) goto L23;
            ArrayList r1 = r7.getDocumentList();
            r0.j.c.addAll(r1);
            lx4.d r2 = r0.j;
            String r3 = r7.getLastLabel();
            String r4 = "";
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r2.d = r3;
            lx4.d r5 = r0.j;
            String r8 = r7.getNextId();
            if (r8 != null) goto L11;
            r8 = "";
        L11:
            r5.getClass();
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r5.e = r8;
            lx4.d r9 = r0.j;
            String r10 = r7.getCheckId();
            if (r10 == null) goto L15;
            r4 = r10;
        L15:
            r9.getClass();
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r9.f = r4;
            lx4.d r11 = r0.j;
            r11.g = r7.isHasMore();
            lx4.d r12 = r0.j;
            boolean r13 = true;
            if ((r12.b + 1) < r12.c.size()) goto L18;
            r13 = false;
        L18:
            if (r13 == false) goto L20;
            r0.l();
            return;
        L20:
            r0.q(null);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ j a;

        public e(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.f("WikiAutoTestImpl", (Throwable) r3, false);
            this.a.q(null);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void e() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void i(DocException r1, Map r2) {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void j() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void c() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void h() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // lx4.g
    public final void l() {
    L2:
        lx4.d r0 = this.j;
        boolean r2 = true;
        if ((r0.b + 1) < r0.c.size()) goto L5;
        r2 = false;
    L5:
        Document r1 = null;
        if (r2 == false) goto L24;
        lx4.d r3 = this.j;
        if (r3.c.size() == 0) goto L18;
        int r4 = r3.b;
        if (r4 >= 0) goto L13;
        r3.a(0);
    L15:
        if (r3.b >= r3.c.size()) goto L18;
        r1 = (Document) ListProtector.get(r3.c, r3.b);
        goto L18
    L13:
        r3.a(r4 + 1);
    L18:
        if (r1 == null) goto L2;
        if (this.m.contains(Integer.valueOf(r1.getType())) == false) goto L2;
        Flowable.just(r1).observeOn(fo5.d.d()).subscribe(new b(this, r1), c.a);
        return;
    L24:
        if (this.j.g == false) goto L26;
        HashMap<String, String> r5 = new HashMap();
        r5.put("check_id", this.j.f);
        r5.put("next_id", this.j.e);
        r5.put("next_id", this.j.d);
        q(r5);
        return;
    L26:
        q(null);
    }

    public final void p() {
        tt5.a.h("WikiAutoTestImpl", BatterySceneData.OPT_START);
        this.k = false;
        this.h.a();
        ((f) this.d).getClass();
        new WeakReference(this);
        q(null);
    }

    public final void r() {
        tt5.a.h("WikiAutoTestImpl", "stop");
        this.k = true;
        ((f) this.d).getClass();
        new WeakReference(null);
        this.h.getClass();
    }

    @Override // lx4.h.a
    public final void dismiss() {
        r();
    }

    @Override // lx4.a
    public final boolean n() {
        return this.k;
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void m(Map<String, String> r7) {
        o(false, 2, 1);
    }

    public final void q(HashMap<String, String> r8) {
        if (this.k == false) goto L6;
        return;
    L6:
        if (r8 == null) goto L8;
        i r1 = this.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter("/space/api/wiki/v2/search/get_recent/", "url");
        Intrinsics.checkNotNullParameter(r8, "params");
        NetService.d r5 = r1.a.Vc(new WikiSpaceListParser());
        Intrinsics.checkNotNullParameter("/space/api/wiki/v2/search/get_recent/", "url");
        Intrinsics.checkNotNullParameter(r8, "params");
        r1.g += 20;
        NetService.f r9 = new NetService.f("/space/api/wiki/v2/search/get_recent/");
        r9.c = 2;
        r9.b(r1.d, Integer.toString(r1.g, CharsKt.checkRadix(10)));
        r9.b(r1.e, r1.f);
        tt5.a.h(r1.b, "mCurPageLength  " + r1.g);
        Flowable r10 = r5.a(r9);
    L9:
        r10.observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
        return;
    L8:
        i r11 = this.i;
        NetService.d r2 = r11.a.Vc(new WikiSpaceListParser());
        NetService.f r3 = new NetService.f(r11.c);
        r3.c = 2;
        r3.b(r11.d, DiagramData$RESULT.FAIL);
        r3.b(r11.e, r11.f);
        r10 = r2.a(r3);
        goto L9
    }

    public j(Context r2, NetService r3, com.bytedance.ee.bear.route.h r4, f r5, m r6, b0 r7, h0 r8) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mNetService");
        Intrinsics.checkNotNullParameter(r4, "mRouterService");
        Intrinsics.checkNotNullParameter(r5, "mDebugServiceImp");
        Intrinsics.checkNotNullParameter(r6, "mDocWebService");
        Intrinsics.checkNotNullParameter(r7, "mInfoProvideService");
        Intrinsics.checkNotNullParameter(r8, "mLoginService");
        super(r4);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        sbb.e r9 = sbb.e.g;
        this.l = CollectionsKt.listOf(new String[]{r9.getType(), sbb.e.h.getType(), sbb.e.i.getType()});
        ArrayList<Integer> r10 = new ArrayList();
        this.m = r10;
        h r11 = new h(r2, this);
        this.h = r11;
        this.i = new i(r3);
        this.j = new lx4.d(r11);
        r10.add(Integer.valueOf(r9.b));
    }
}
