package com.bytedance.ee.bear.office.list.selectpanel;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.export.space.h;
import com.bytedance.ee.bear.office.export.space.j;
import com.bytedance.ee.bear.office.export.space.k;
import com.bytedance.ee.bear.office.list.OfficeListPageMenuCapabilityRegistry;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressActionContextFactory;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuAction;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuItemState;
import com.bytedance.ee.bear.office.list.adapter.a0;
import com.bytedance.ee.bear.office.list.adapter.b0;
import com.bytedance.ee.bear.office.list.adapter.c0;
import com.bytedance.ee.bear.office.list.adapter.i0;
import com.bytedance.ee.bear.office.list.adapter.v;
import com.bytedance.ee.bear.office.list.adapter.x;
import com.bytedance.ee.bear.office.list.adapter.z;
import com.bytedance.ee.bear.office.list.i;
import com.bytedance.ee.bear.office.list.m;
import com.bytedance.ee.bear.office.list.menuconfig.OfficeLongPressMenuConfigComposer;
import com.bytedance.ee.bear.office.list.o;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeSelectPanelHostDelegate {
    public static final /* synthetic */ int u = 0;
    public final Fragment a;
    public final Function0<OfficeSpaceTab> b;
    public final Function0<String> c;
    public final Function0<Unit> d;
    public f e;
    public final Lazy f;
    public final Lazy g;
    public v h;
    public OfficeLongPressActionContextFactory.b i;
    public long j;
    public String k;
    public String l;
    public Fragment m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public String r;
    public ed5.e s;
    public int t;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeLongPressMenuAction.values().length];
            r0[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[OfficeLongPressMenuAction.RENAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements x {
        public final /* synthetic */ OfficeSelectPanelHostDelegate a;
        public final /* synthetic */ Document b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;

        public c(OfficeSelectPanelHostDelegate r1, Document r2, boolean r3, String r4, String r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // com.bytedance.ee.bear.office.list.adapter.x
        public final void a(OfficeLongPressMenuAction r19, z r20) {
            Intrinsics.checkNotNullParameter(r19, "action");
            Intrinsics.checkNotNullParameter(r20, "availability");
            OfficeSelectPanelHostDelegate r3 = this.a;
            Document r4 = this.b;
            boolean r5 = this.c;
            String r6 = this.d;
            String r7 = this.e;
            int r8 = this.f;
            OfficeLongPressActionContextFactory.b r9 = r3.i;
            if (r9 != null) goto L6;
            return;
        L6:
            if (r8 == r3.n) goto L8;
        L40:
            tt5.a.h("OfficeSelectPanelHost", "drop select panel availability update. action=" + r19);
            return;
        L8:
            if (Intrinsics.areEqual(r3.k, r6) == false) goto L40;
            if (Intrinsics.areEqual(r3.l, r7) == false) goto L40;
            if (r9.a.n != r3.h) goto L40;
            if (r3.a.isAdded() == false) goto L40;
            if (r3.a.getView() == null) goto L40;
            List<b0> r10 = r9.b.c(r9.a);
            ArrayList r15 = new ArrayList();
            Iterator r11 = ((ArrayList) r10).iterator();
        L19:
            boolean r12 = true;
            if (r11.hasNext() == false) goto L27;
            Object r13 = r11.next();
            if (((b0) r13).e != OfficeLongPressMenuItemState.HIDDEN) goto L25;
            r12 = false;
        L25:
            if (r12 == false) goto L19;
            r15.add(r13);
            goto L19
        L27:
            List<b0> r14 = r9.b.d(r9.a);
            ArrayList r16 = new ArrayList();
            Iterator r17 = ((ArrayList) r14).iterator();
        L29:
            if (r17.hasNext() == false) goto L36;
            Object r18 = r17.next();
            if (((b0) r18).e == OfficeLongPressMenuItemState.HIDDEN) goto L33;
            boolean r110 = true;
        L34:
            if (r110 == false) goto L29;
            r16.add(r18);
            goto L29
        L33:
            r110 = false;
            goto L34
        L36:
            int r21 = OfficeLongPressMenuConfigComposer.a;
            com.bytedance.ee.bear.widgets.menuconfig.c r22 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
            List r111 = OfficeLongPressMenuConfigComposer.a(com.bytedance.ee.bear.widgets.menuconfig.c.b, r15, r16);
            a0 r112 = r9.a;
            c0 r113 = r9.b;
            Intrinsics.checkNotNullParameter(r112, "menuContext");
            Intrinsics.checkNotNullParameter(r113, "menuRules");
            Intrinsics.checkNotNullParameter(r15, "mainSpecs");
            Intrinsics.checkNotNullParameter(r16, "moreSpecs");
            OfficeLongPressActionContextFactory.b r23 = new OfficeLongPressActionContextFactory.b(r112, r113, r15, r16, r111);
            r3.i = r23;
            e r24 = (e) r3.f.getValue();
            List<b0> r25 = r23.c;
            List<b0> r26 = r23.d;
            List<com.bytedance.ee.bear.office.list.menuconfig.a> r27 = r23.e;
            r24.getClass();
            List<com.bytedance.ee.bear.office.list.selectpanel.d> r28 = e.b(r25, r26, r27);
            StringBuilder r29 = new StringBuilder("refresh select panel availability. action=");
            r29.append(r19);
            r29.append(", availability=");
            r29.append(r20);
            r29.append(", items=");
            ArrayList r1 = (ArrayList) r28;
            r29.append(r1.size());
            tt5.a.h("OfficeSelectPanelHost", r29.toString());
            if (r1.isEmpty() == false) goto L39;
            r3.f(false);
        L39:
            r3.i(CollectionsKt.listOf(r4), r28, r5);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ OfficeSelectPanelHostDelegate b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Fragment d;
        public final /* synthetic */ OfficeSpaceTab e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Document g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ h i;
        public final /* synthetic */ boolean j;

        public d(int r1, OfficeSelectPanelHostDelegate r2, String r3, Fragment r4, OfficeSpaceTab r5, int r6, Document r7, boolean r8, h r9, boolean r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }

        public final void a() {
            int r0 = this.a;
            OfficeSelectPanelHostDelegate r1 = this.b;
            if (r0 == r1.n) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r1.l, this.c) == false) goto L40;
            OfficeSelectPanelHostDelegate r2 = this.b;
            if (r2.m == this.d) goto L9;
            return;
        L9:
            if (r2.a.isAdded() == true) goto L11;
            return;
        L11:
            if (this.b.a.getView() == null) goto L43;
            OfficeListPageMenuCapabilityRegistry r3 = OfficeListPageMenuCapabilityRegistry.a;
            String r4 = (String) this.b.c.invoke();
            OfficeSpaceTab r5 = this.e;
            Fragment r6 = this.d;
            r3.getClass();
            i r7 = OfficeListPageMenuCapabilityRegistry.b(r4, r5, r6);
            j r8 = null;
            if (r7 == null) goto L20;
            m r9 = r7.g;
            if (r9 == null) goto L20;
            Function0<OfficeLongPressActionContextFactory> r10 = r9.a;
            if (r10 == null) goto L20;
            OfficeLongPressActionContextFactory r11 = (OfficeLongPressActionContextFactory) r10.invoke();
        L21:
            if (r11 != null) goto L24;
            tt5.a.h("OfficeSelectPanelHost", "select panel long press capability still missing, attempt=" + this.f);
            this.b.m(this.e, this.g, this.h, this.i, this.j, this.c, this.a);
            return;
        L24:
            Function0<Boolean> r12 = r7.f;
            if (r12 == null) goto L29;
            boolean r13 = true;
            if (((Boolean) r12.invoke()).booleanValue() != true) goto L29;
        L30:
            OfficeSelectPanelHostDelegate r14 = this.b;
            Document r15 = this.g;
            OfficeSpaceTab r16 = this.e;
            h r17 = this.i;
            if ((r17 instanceof com.bytedance.ee.bear.office.export.space.e) == false) goto L33;
            com.bytedance.ee.bear.office.export.space.e r18 = (com.bytedance.ee.bear.office.export.space.e) r17;
        L35:
            if ((r17 instanceof j) == false) goto L37;
            r8 = (j) r17;
        L37:
            r14.getClass();
            boolean r19 = OfficeSelectPanelHostDelegate.a(r15, r16, r13, r18, r8, r17);
            OfficeSelectPanelHostDelegate r20 = this.b;
            r20.o = 0;
            r20.j(this.e, this.g, r7, r13, this.i, r19, this.c, this.a);
            return;
        L33:
            r18 = null;
        L29:
            r13 = false;
        L20:
            r11 = null;
            goto L21
        L43:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c() {
        this.t = 0;
        ed5.e r1 = this.s;
        if (r1 == null) goto L5;
        r1.c10(0);
    L5:
        this.s = null;
    }

    public final void e() {
        this.p = false;
        this.q = false;
        this.r = null;
        f(true);
        ((com.bytedance.ee.bear.office.list.selectpanel.b) this.g.getValue()).a();
        c();
    }

    public final void d() {
        boolean r2 = false;
        if (this.p == false) goto L6;
        this.p = false;
        r2 = true;
    L6:
        if (r2 == false) goto L8;
        b(true);
    L9:
        ((com.bytedance.ee.bear.office.list.selectpanel.b) this.g.getValue()).a();
        c();
        return;
    L8:
        f(true);
        goto L9
    }

    public final Context l() {
        View r0 = this.a.getView();
        if (r0 == null) goto L7;
        Context r1 = r0.getContext();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.a.getContext();
    }

    public final void b(boolean r4) {
        this.i = null;
        this.j = 0;
        this.k = null;
        if (r4 == false) goto L6;
        this.l = null;
        this.m = null;
        return;
    }

    public final void f(boolean r2) {
        this.p = false;
        this.q = false;
        v r0 = this.h;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.h = null;
        b(r2);
    }

    public final void o(String r4) {
        Context r0 = l();
        if (r0 == null) goto L14;
        if (r4 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L14;
        UDToast.a r2 = UDToast.build(r0);
        r2.g(r4);
        r2.b.d = -1;
        r2.h();
        return;
    L6:
        if (StringsKt.isBlank(r4) == true) goto L9;
        r1 = false;
    L14:
        tt5.a.h("OfficeSelectPanelHost", "skip select panel toast, context missing or message empty");
    }

    public final void g(ed5.a r17, Fragment r18) {
        Intrinsics.checkNotNullParameter(r17, "state");
        this.n++;
        boolean r4 = false;
        if (this.a.isAdded() == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        List<com.bytedance.ee.bear.office.list.selectpanel.d> r5 = null;
        if (r2 == true) goto L12;
        tt5.a.h("OfficeSelectPanelHost", "skip select panel render, host ui unavailable");
        f(true);
        c();
        this.r = null;
        return;
    L12:
        int r8 = this.n;
        this.m = r18;
        String r3 = (String) this.c.invoke();
        r17.getClass();
        ArrayList r6 = new ArrayList(r17.c);
        OfficeSpaceTab r7 = (OfficeSpaceTab) this.b.invoke();
        OfficeListPageMenuCapabilityRegistry.a.getClass();
        i r0 = OfficeListPageMenuCapabilityRegistry.b(r3, r7, r18);
        if (r0 == null) goto L22;
        Function0<Boolean> r10 = r0.f;
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 != true) goto L22;
        boolean r15 = true;
    L23:
        Document r12 = (Document) CollectionsKt.singleOrNull(r6);
        if (r12 == null) goto L26;
        String r1 = n(r12, r7, r15, r3, r18);
    L27:
        this.l = r1;
        h r9 = com.bytedance.ee.bear.office.export.space.m.a(r3);
        if ((r9 instanceof com.bytedance.ee.bear.office.export.space.e) == false) goto L30;
        com.bytedance.ee.bear.office.export.space.e r13 = (com.bytedance.ee.bear.office.export.space.e) r9;
    L32:
        if ((r9 instanceof j) == false) goto L34;
        j r14 = (j) r9;
    L36:
        if (r6.size() < 2) goto L38;
        boolean r16 = false;
    L43:
        if (r6.size() != 1) goto L48;
        if (r0 == null) goto L46;
        this.o = 0;
    L46:
        j(r7, (Document) CollectionsKt.first(r6), r0, r15, r9, r16, this.l, r8);
        return;
    L48:
        boolean r19 = r15;
        this.o = 0;
        this.l = null;
        if (r6.isEmpty() == true) goto L51;
    L56:
        f(r6.isEmpty());
    L57:
        f r20 = this.e;
        if (r20 != null) goto L64;
        Context r21 = l();
        if (r21 != null) goto L63;
        r20 = null;
        goto L64
    L63:
        f r22 = new f(r21, new OfficeSelectPanelHostDelegate$getRuleOrNull$2(this));
        this.e = r22;
        r20 = r22;
    L64:
        if (r20 == null) goto L66;
        r5 = r20.d(r7, r6);
    L66:
        if (r5 != null) goto L68;
        r5 = CollectionsKt.emptyList();
    L68:
        i(r6, r5, r19);
        k(r7, r6, r5);
        return;
    L51:
        if (this.q == false) goto L54;
        this.q = false;
        r4 = true;
    L54:
        if (r4 == false) goto L56;
        b(true);
        goto L57
    L38:
        Document r110 = (Document) CollectionsKt.firstOrNull(r6);
        if (r110 == null) goto L41;
        r16 = a(r110, r7, r15, r13, r14, r9);
        goto L43
    L41:
        r16 = r9 instanceof k;
        goto L43
    L34:
        r14 = null;
        goto L36
    L30:
        r13 = null;
        goto L32
    L26:
        r1 = null;
        goto L27
    L17:
        if (((Boolean) r10.invoke()).booleanValue() != true) goto L19;
        r11 = true;
    L22:
        r15 = false;
        goto L23
    L5:
        if (this.a.getView() == null) goto L7;
        r2 = true;
        goto L8
    }

    public final void h(OfficeSpaceTab r5, Document r6, boolean r7) {
        f r0 = this.e;
        List<com.bytedance.ee.bear.office.list.selectpanel.d> r1 = null;
        if (r0 != null) goto L9;
        Context r2 = l();
        if (r2 != null) goto L8;
        r0 = null;
        goto L9
    L8:
        f r3 = new f(r2, new OfficeSelectPanelHostDelegate$getRuleOrNull$2(this));
        this.e = r3;
        r0 = r3;
    L9:
        if (r0 == null) goto L11;
        r1 = r0.d(r5, CollectionsKt.listOf(r6));
    L11:
        if (r1 != null) goto L13;
        r1 = CollectionsKt.emptyList();
    L13:
        i(CollectionsKt.listOf(r6), r1, r7);
    }

    public final void i(List<? extends Document> r7, List<com.bytedance.ee.bear.office.list.selectpanel.d> r8, boolean r9) {
        if (this.a.isAdded() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L11;
        tt5.a.h("OfficeSelectPanelHost", "skip select panel ui render, host ui unavailable");
        c();
        return;
    L11:
        OfficeSelectPanelDialog r2 = null;
        if (r8.isEmpty() == true) goto L27;
        Fragment r1 = this.m;
        if ((r1 instanceof ed5.e) == false) goto L17;
        ed5.e r3 = (ed5.e) r1;
    L18:
        if (r3 != null) goto L28;
        OfficeListPageMenuCapabilityRegistry r4 = OfficeListPageMenuCapabilityRegistry.a;
        String r5 = (String) this.c.invoke();
        OfficeSpaceTab r6 = (OfficeSpaceTab) this.b.invoke();
        Fragment r10 = this.m;
        r4.getClass();
        i r11 = OfficeListPageMenuCapabilityRegistry.b(r5, r6, r10);
        if (r11 == null) goto L23;
        ed5.d r12 = r11.b();
    L25:
        if ((r12 instanceof ed5.e) == false) goto L27;
        r3 = (ed5.e) r12;
        goto L28
    L23:
        r12 = null;
    L28:
        ed5.e r13 = this.s;
        if (r13 == r3) goto L37;
        if (r13 == null) goto L33;
        r13.c10(0);
    L33:
        this.s = r3;
        int r14 = this.t;
        if (r14 <= 0) goto L37;
        if (r3 == null) goto L37;
        r3.c10(r14);
    L37:
        final com.bytedance.ee.bear.office.list.selectpanel.b r15 = (com.bytedance.ee.bear.office.list.selectpanel.b) this.g.getValue();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r7, "documents");
        Intrinsics.checkNotNullParameter(r8, "items");
        r15.f = CollectionsKt.toList(r7);
        r15.g = r9;
        if (r8.isEmpty() == false) goto L40;
        r15.a();
        return;
    L40:
        FragmentManager r16 = r15.a.getChildFragmentManager();
        Fragment r17 = r16.findFragmentByTag("OfficeSelectPanelDialog");
        if ((r17 instanceof OfficeSelectPanelDialog) == false) goto L43;
        r2 = (OfficeSelectPanelDialog) r17;
    L43:
        if (r2 != null) goto L51;
        r2 = r15.e;
        if (r2 != null) goto L51;
        r2 = new OfficeSelectPanelDialog();
        r2.d = new OfficeSelectPanelController$render$current$1$1(r15);
        r2.e = r15.c;
        r2.f = r15.d;
        r15.e = r2;
        FragmentTransaction r18 = r16.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r18, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "OfficeSelectPanelDialog", 0) == true) goto L50;
        r18 = r18.add(r2, "OfficeSelectPanelDialog");
    L50:
        r18.commitAllowingStateLoss();
    L51:
        r2.d = new OfficeSelectPanelController$render$1(r15);
        r2.e = r15.c;
        r2.f = r15.d;
        r2.update(r8);
        return;
    L17:
        r3 = null;
    L27:
        r3 = null;
        goto L28
    L5:
        if (this.a.getView() == null) goto L7;
        r0 = true;
        goto L8
    }

    public final void k(OfficeSpaceTab r16, List<? extends Document> r17, List<com.bytedance.ee.bear.office.list.selectpanel.d> r18) {
        String r2 = null;
        if (r18.isEmpty() == false) goto L6;
        this.r = null;
        return;
    L6:
        String r1 = r16.name() + '|' + CollectionsKt.joinToString$default(r17, ",", null, null, 0, null, OfficeSelectPanelHostDelegate$reportSelectPanelViewIfNeeded$signature$1$1.INSTANCE, 30, null) + '|' + CollectionsKt.joinToString$default(r18, ",", null, null, 0, null, OfficeSelectPanelHostDelegate$reportSelectPanelViewIfNeeded$signature$1$2.INSTANCE, 30, null);
        if (Intrinsics.areEqual(r1, this.r) == false) goto L9;
        return;
    L9:
        this.r = r1;
        i0 r4 = i0.a;
        Document r3 = (Document) CollectionsKt.firstOrNull(r17);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r16, "tab");
        String r5 = i0.a(r16);
        if (r3 == null) goto L12;
        String r6 = r3.d;
    L13:
        if (r3 == null) goto L15;
        int r7 = r3.getType();
    L16:
        int r8 = r7;
        if (r3 == null) goto L19;
        String r9 = r3.F;
    L21:
        if (r3 == null) goto L23;
        r2 = t0.m(r3);
    L23:
        JSONObject r10 = i0.c(r4, r5, r6, r8, r9, null, null, r2, 48);
        r10.put("current_page", "ai_space_list");
        i0.e("ccm_space_list_operation_panel_view", r10);
        return;
    L19:
        r9 = null;
        goto L21
    L15:
        r7 = sbb.e.e.b;
        goto L16
    L12:
        r6 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSelectPanelHostDelegate(Fragment r2, Function0<? extends OfficeSpaceTab> r3, Function0<String> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "tabProvider");
        Intrinsics.checkNotNullParameter(r4, "runtimeIdProvider");
        Intrinsics.checkNotNullParameter(r5, "requestExitSelection");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = LazyKt.lazy(OfficeSelectPanelHostDelegate$longPressBridge$2.INSTANCE);
        this.g = LazyKt.lazy(new OfficeSelectPanelHostDelegate$controller$2(this));
    }

    public static String n(Document r3, OfficeSpaceTab r4, boolean r5, String r6, Fragment r7) {
        String r0 = r3.d;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L13;
        r0 = r3.c;
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        if (r7 == null) goto L15;
        String r8 = String.valueOf(System.identityHashCode(r7));
    L16:
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        StringBuilder r9 = new StringBuilder();
        if (r6 != null) goto L21;
        r6 = "";
    L21:
        r9.append(r6);
        r9.append('_');
        r9.append(r4.name());
        r9.append('_');
        r9.append(r5);
        r9.append('_');
        r9.append(r8);
        r9.append('_');
        r9.append(r0);
        r9.append('_');
        r9.append(r3.getType());
        r9.append('_');
        r9.append(r3.M1);
        return r9.toString();
    L15:
        r8 = null;
        goto L16
    L8:
        r2 = false;
        goto L9
    }

    public static boolean a(Document r1, OfficeSpaceTab r2, boolean r3, com.bytedance.ee.bear.office.export.space.e r4, j r5, h r6) {
        int r0 = com.bytedance.ee.bear.office.list.selectpanel.c.a;
        Intrinsics.checkNotNullParameter(r1, "document");
        OfficeSpaceItem r7 = o.a(r1, CollectionsKt.emptyList());
        if (r4 != null) goto L9;
        if (r5 == null) goto L8;
        return r5.Sp(OfficeSpaceLongPressAction.ASK_DOUBAO, r7, com.bytedance.ee.bear.office.list.selectpanel.c.a(r2, r3));
    L8:
        return r6 instanceof k;
    L9:
        return r4.Jk(r7);
    }

    public final void m(OfficeSpaceTab r15, Document r16, boolean r17, h r18, boolean r19, String r20, int r21) {
        int r0 = this.o;
        if (r0 < 3) goto L5;
        return;
    L5:
        Fragment r4 = this.m;
        int r6 = r0 + 1;
        this.o = r6;
        View r12 = this.a.getView();
        if (r12 == null) goto L9;
        r12.postDelayed(new d(r21, this, r20, r4, r15, r6, r16, r17, r18, r19), 120);
        return;
    }

    public final void j(OfficeSpaceTab r23, Document r24, i r25, boolean r26, h r27, boolean r28, String r29, int r30) {
        OfficeLongPressActionContextFactory r1 = null;
        if (r25 == null) goto L5;
        m r2 = r25.g;
    L6:
        if (r2 == null) goto L10;
        Function0<OfficeLongPressActionContextFactory> r3 = r2.a;
        if (r3 == null) goto L10;
        r1 = (OfficeLongPressActionContextFactory) r3.invoke();
    L10:
        OfficeLongPressActionContextFactory r9 = r1;
        if (r9 != null) goto L14;
        m(r23, r24, r26, r27, r28, r29, r30);
        f(false);
        h(r23, r24, r26);
        return;
    L14:
        String r4 = n(r24, r23, r26, (String) this.c.invoke(), r25.a());
        long r10 = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(this.k, r4) == false) goto L28;
        OfficeLongPressActionContextFactory.b r5 = this.i;
        if (r5 == null) goto L28;
        long r6 = this.j;
        if (r6 > 0) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L28;
        Intrinsics.checkNotNull(r5);
        boolean r8 = false;
    L39:
        e r0 = (e) this.f.getValue();
        List<b0> r11 = r5.c;
        List<b0> r12 = r5.d;
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r13 = r5.e;
        r0.getClass();
        List<com.bytedance.ee.bear.office.list.selectpanel.d> r14 = e.b(r11, r12, r13);
        if (((ArrayList) r14).isEmpty() == false) goto L42;
        f(r8);
    L42:
        i(CollectionsKt.listOf(r24), r14, r26);
        k(r23, CollectionsKt.listOf(r24), r14);
        return;
    L21:
        if ((r10 - r6) > 30000) goto L24;
        r7 = false;
    L28:
        if (this.i == null) goto L30;
        tt5.a.h("OfficeSelectPanelHost", "rebuild select panel long press context, selectedKeyChanged=" + (true ^ Intrinsics.areEqual(this.k, r4)));
    L30:
        f(false);
        this.k = r4;
        OfficeSpaceItem r15 = (OfficeSpaceItem) r2.g.invoke(r24);
        if (r15 != null) goto L34;
        m(r23, r24, r26, r27, r28, r29, r30);
        h(r23, r24, r26);
        return;
    L34:
        Context r16 = l();
        if (r16 != null) goto L38;
        tt5.a.h("OfficeSelectPanelHost", "skip create select panel long press context, host context missing");
        f(false);
        return;
    L38:
        OfficeSpaceEventSource r17 = com.bytedance.ee.bear.office.list.selectpanel.c.a(r23, r26);
        boolean r18 = ((Boolean) r2.e.invoke()).booleanValue();
        Function0<Boolean> r19 = r2.f;
        boolean r20 = r25.e;
        c r21 = new c(this, r24, r26, r4, r29, r30);
        int r22 = OfficeLongPressActionContextFactory.h;
        r8 = false;
        OfficeLongPressActionContextFactory.b r31 = r9.b(r16, r23, r24, r15, r17, r27, r28, r18, r19, r20, null, r21);
        this.i = r31;
        this.j = r10;
        this.h = r31.a.n;
        r5 = r31;
        goto L39
    L5:
        r2 = null;
        goto L6
    }
}
