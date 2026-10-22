package sp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.model.LinkTableDataModelManager;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.databinding.BitableCardStackLinkTableBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.j;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import sa5.w;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends FrameLayout implements sp4.a, ocb.a, w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f542835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gp4.h f542836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cp4.b f542837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitableCardStackLinkTableBinding f542838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final sp4.c f542839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BitableCardViewModel f542840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final pcb.a f542841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f542842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f542843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f542844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f542845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f542846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final tp4.a f542847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h> f542848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h f542849o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public g f542850p;

    public static final class a implements com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f542851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f542852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f542853c;

        /* JADX INFO: renamed from: sp4.d$a$a, reason: collision with other inner class name */
        public static final class RunnableC7635a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f542854a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h f542855b;

            public RunnableC7635a(d r100, com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h r101) {
                this.f542854a = r100;
                this.f542855b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h> r100 = this.f542854a.f542848n;     // Catch: Throwable -> L4
                ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L4
                r101.add(this.f542855b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f542856a;

            /* JADX INFO: renamed from: sp4.d$a$b$a, reason: collision with other inner class name */
            public static final class RunnableC7636a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h f542857a;

                public RunnableC7636a(com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h r100) {
                    this.f542857a = r100;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f542857a.b();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public b(d r100) {
                this.f542856a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r100 = ((ArrayList) this.f542856a.f542848n).iterator();     // Catch: Throwable -> L7
            L4:
                if (r100.hasNext() == false) goto L16;
                j.c(new RunnableC7636a((com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h) r100.next()));     // Catch: Throwable -> L7
                goto L4
            L16:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f542858a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h f542859b;

            public c(d r100, com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h r101) {
                this.f542858a = r100;
                this.f542859b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h> r100 = this.f542858a.f542848n;     // Catch: Throwable -> L4
                ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L4
                r101.remove(this.f542859b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g
        public final boolean d() {
            d r100 = this.f542851a;
            if (r100.f542843i == true) goto L5;
        L7:
            return false;
        L5:
            if (r100.f542844j == true) goto L7;
            return true;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g
        public final void e() {
            j.c(new b(this.f542851a));
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g
        public final void b(com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            j.c(new RunnableC7635a(this.f542851a, r100));
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g
        public final void f(com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            j.c(new c(this.f542851a, r100));
        }

        public a(d r100, String r101, String r102) {
            this.f542851a = r100;
            this.f542852b = r101;
            this.f542853c = r102;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.g
        public final void c(Object r100, String r101, List<? extends cp4.a> r102) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Intrinsics.checkNotNullParameter(r101, "editType");
            Intrinsics.checkNotNullParameter(r102, "inputValue");
            d r103 = this.f542851a;
            r103.f542840f.editRecord(r103.f542837c, this.f542852b, this.f542853c, r101, r100);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f542860a = null;

        static {
            f542860a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f542861a;

        public c(d r100) {
            this.f542861a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f542861a.f542839e.onBackPressed();
        }
    }

    /* JADX INFO: renamed from: sp4.d$d, reason: collision with other inner class name */
    public static final class C7637d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f542862c;

        public C7637d(d r100) {
            this.f542862c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f542862c.f542839e.l();
        }
    }

    public static final class e {
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f542863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f542864b;

        public f(d r100, String r101) {
            this.f542863a = r100;
            this.f542864b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f542863a.d(this.f542864b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f542865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f542866b;

        public g(d r100, String r101) {
            this.f542865a = r100;
            this.f542866b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f542865a.d(this.f542866b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f542867a;

        public h(d r100) {
            this.f542867a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            if (ku5.c.k(this.f542867a.f542835a) == true) goto L5;
            this.f542867a.f542844j = r101;
        L5:
            j.c(new sp4.e(this.f542867a, r101));
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f542868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f542869b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h f542870a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f542871b;

            public a(com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h r100, int r101) {
                this.f542870a = r100;
                this.f542871b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f542870a.c(this.f542871b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public i(d r100, int r101) {
            this.f542868a = r100;
            this.f542869b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h> r100 = this.f542868a.f542848n;     // Catch: Throwable -> L7
            int r101 = this.f542869b;     // Catch: Throwable -> L7
            Iterator r102 = ((ArrayList) r100).iterator();     // Catch: Throwable -> L7
        L4:
            if (r102.hasNext() == false) goto L16;
            j.c(new a((com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.h) r102.next(), r101));     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
    }

    @Override // sp4.a
    public final void b() {
        boolean r100 = true;
        if (this.f542839e.f207860d.d() == true) goto L6;
        r100 = false;
    L6:
        if (r100 == false) goto L8;
        this.f542838d.f210702b.setVisibility(0);
        return;
    L8:
        this.f542838d.f210702b.setVisibility(8);
    }

    @Override // sp4.a
    public final void s() {
        this.f542838d.f210704d.requestLayout();
        this.f542838d.f210704d.invalidate();
    }

    @Override // sp4.a
    public final void F(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BitableNativeViewData r101 = r100.f538848a.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        sp4.c r102 = this.f542839e;
        r102.getClass();
        com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.b r103 = new com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.b(r102);
        r103.f482820a = new com.bytedance.ee.bear.bitable.card.view.cell.linktable.presenter.c(r102);
        this.f542838d.f210704d.j(this.f542836b.getActivity(), r101, r103, r100.f538849b, true);
        this.f542838d.f210706f.c(r100.f538848a.getToolBarData(), r103);
    }

    @Override // sp4.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f542838d.f210705e.setLeftText(r100);
    }

    public final void c(String r100) {
        tt5.a.h("LinkTableFullScreenView", "checkRecordOrFieldDeleted, isVisible: " + this.f542842h);
        if (this.f542842h == true) goto L5;
        this.f542850p = new g(this, r100);
        return;
    L5:
        if (com.bytedance.ee.bear.bitable.c.u() == false) goto L7;
        j.c(new f(this, r100));
        return;
    L7:
        d(r100);
    }

    public final void d(String r100) {
        if (this.f542845k == true) goto L9;
        this.f542845k = true;
        tt5.a.h("LinkTableFullScreenView", "handleRecordOrFieldDeleted");
        if (r100 == null) goto L7;
        UDToast.show(this.f542836b.getActivity(), r100);
    L7:
        BitableCardViewModel r101 = this.f542840f;
        cp4.b r102 = this.f542837c;
        r101.backwardTable(r102.f464658b, r102.f464660d, r102.f464675s);
        return;
    }

    public final void e(cp4.b r110) {
        this.f542837c = r110;
        cp4.a r100 = r110.c();
        String r101 = "";
        if (r100 == null) goto L6;
        String r102 = r100.f464635b;
        if (r102 == null) goto L6;
    L7:
        String r103 = r110.F;
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        cp4.a r104 = r110.e(r102);
        if (r104 != null) goto L13;
    L72:
        tt5.a.h("LinkTableFullScreenView", "updateData, record is null or deleted");
        c(null);
        return;
    L13:
        if (r104.f464643j == false) goto L72;
        List<dp4.a> r105 = r104.f464646m;
        if (r105 == null) goto L25;
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((dp4.a) r107).f469587a.f478255b, r103) == false) goto L19;
    L24:
        dp4.a r108 = (dp4.a) r107;
    L27:
        if ((r108 instanceof dp4.a) == true) goto L30;
        r108 = null;
    L30:
        if (r108 == null) goto L36;
        fp4.g r109 = r108.f469587a;
        if (r109 == null) goto L36;
        FieldCompositeType r111 = r109.f478257d;
        if (r111 == null) goto L36;
        EFieldUIType r112 = r111.getUiType();
    L37:
        tt5.a.h("LinkTableFullScreenView", "updateData, recordId: " + r102 + ", fieldId: " + r103 + ", fieldType: " + r112);
        boolean r113 = false;
        if (r112 != EFieldUIType.SINGLE_LINK) goto L40;
    L43:
        boolean r114 = true;
    L44:
        if (r114 == true) goto L47;
        tt5.a.h("LinkTableFullScreenView", "updateData, !isLinkField");
        c(null);
        return;
    L47:
        if (r108 != null) goto L50;
        tt5.a.h("LinkTableFullScreenView", "updateData, cell is null");
        c(UIHelper.mustacheFormat(R.string.Bitable_LinkField_LinkedFieldDeleted_Toast, "fieldName", this.f542846l));
        return;
    L50:
        this.f542843i = r108.b();
        fp4.g r115 = r108.f469587a;
        if ((r115 instanceof fp4.d) == false) goto L53;
        fp4.d r116 = (fp4.d) r115;
    L54:
        if (r116 != null) goto L57;
        tt5.a.h("LinkTableFullScreenView", "updateData, linkField is null");
        c(null);
        return;
    L57:
        String r117 = r116.f478256c;
        if (r117 == null) goto L61;
        r101 = r117;
    L61:
        this.f542846l = r101;
        List r118 = (List) r108.f469598l;
        if (r118 != null) goto L64;
        r118 = new ArrayList();
    L64:
        Iterator r119 = r118.iterator();
    L66:
        if (r119.hasNext() == false) goto L70;
        if (((cp4.a) r119.next()).f464643j == true) goto L66;
        r113 = true;
        goto L66
    L70:
        tt5.a.h("LinkTableFullScreenView", "updateData recordId: " + r102 + ", linkRecordListSize: " + r118.size() + ", ");
        tp4.a r120 = this.f542847m;
        rp4.a r121 = new rp4.a();
        r121.f538844a = r116;
        r121.f538845b = r104;
        ((ArrayList) r121.f538846c).addAll(r118);
        r121.f538847d = r113;
        r120.g(r121);
        sp4.c r122 = this.f542839e;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r110, "stTable");
        r122.f542833t = r110;
        return;
    L53:
        r116 = null;
        goto L54
    L40:
        if (r112 == EFieldUIType.DUPLEX_LINK) goto L43;
        r114 = false;
    L36:
        r112 = null;
        goto L37
    L23:
        r107 = null;
        goto L24
    L25:
        r108 = null;
    L6:
        r102 = "";
        goto L7
    }

    public final void setUserVisibleHint(boolean r100) {
        StringBuilder r101 = new StringBuilder("setUserVisibleHint, isVisible: ");
        r101.append(r100);
        r101.append(", mPendingRecordOrFieldDeletedTask: $");
        if (this.f542850p == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        tt5.a.h("LinkTableFullScreenView", r101.toString());
        this.f542842h = r100;
        g r103 = this.f542850p;
        if (r103 == null) goto L10;
        r103.run();
        this.f542850p = null;
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r100) {
        this.f542838d.f210704d.getGridView().getViewContext().b();
        return false;
    }

    public d(Context r110, gp4.h r111, cp4.b r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "cardDelegate");
        Intrinsics.checkNotNullParameter(r112, "mCurrentTable");
        super(r110);
        this.f542835a = r110;
        this.f542836b = r111;
        this.f542837c = r112;
        this.f542842h = true;
        String r113 = "";
        this.f542846l = "";
        this.f542848n = new ArrayList();
        h r100 = new h(this);
        this.f542849o = r100;
        tt5.a.h("LinkTableFullScreenView", "init");
        Fragment r101 = r111.getFragment();
        BitableCardViewModel r102 = (BitableCardViewModel) q.a(r101, BitableCardViewModel.class);
        this.f542840f = r102;
        LinkTableDataModelManager r103 = (LinkTableDataModelManager) q.a(r101, LinkTableDataModelManager.class);
        BitableCardStackLinkTableBinding r104 = BitableCardStackLinkTableBinding.a(LayoutInflater.from(r110), this);
        this.f542838d = r104;
        r102.getLandscape().observe(r101, r100);
        pcb.a r105 = pcb.a.AbstractC7181a.b(r111.getActivity());
        this.f542841g = r105;
        r105.c(this);
        r111.c(this);
        cp4.b r106 = this.f542837c;
        String r107 = r106.f464660d;
        if (r107 != null) goto L5;
        r107 = "";
    L5:
        cp4.a r108 = r106.c();
        if (r108 == null) goto L9;
        String r109 = r108.f464635b;
        if (r109 == null) goto L9;
    L10:
        String r114 = this.f542837c.F;
        if (r114 == null) goto L14;
        r113 = r114;
    L14:
        a r115 = new a(this, r113, r109);
        tp4.a r116 = r103.createLinkTableDataModel(r107, r109, r113, MobileViewContainerType.LinkedCellTable);
        this.f542847m = r116;
        sp4.c r117 = new sp4.c(r110, r111, r115, r116, this);
        this.f542839e = r117;
        e(this.f542837c);
        r117.k();
        r104.f210701a.setOnClickListener(b.f542860a);
        m.u(r104.f210705e, StatusBarUtil.getStatusBarHeight(r110), false);
        r104.f210705e.setLeftClickListener(new c(this));
        r104.f210702b.setOnClickListener(new C7637d(this));
        return;
    L9:
        r109 = "";
        goto L10
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        j.c(new i(this, r101));
    }
}
