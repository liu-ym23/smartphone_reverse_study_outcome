package com.bytedance.ee.bear.bitable.card.view.stage;

import com.bytedance.ee.bear.bitable.BitableAsyncRequestBiz;
import com.bytedance.ee.bear.bitable.BitableAsyncResponse;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardCloseReason;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.StageType;
import com.bytedance.ee.bear.bitable.card.viewmodel.BitableCardViewModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements qq4.b, com.bytedance.ee.bear.bitable.card.view.stage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableCardViewModel f208742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gp4.h f208743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.stage.b f208744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cp4.a f208745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f208746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.model.stmodel.field.c f208747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public dp4.a<List<String>> f208748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.larksuite.component.universe_design.menu.c f208749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public cp4.b f208750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f208751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f208752k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f208753a = null;

        static {
            f208753a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h("StageFieldPresenter", "markStepStop result " + ((BitableAsyncResponse) r100).getResult());
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f208754a = null;

        static {
            f208754a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("StageFieldPresenter", (Throwable) r100, false);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f208755a = null;

        static {
            f208755a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h("StageFieldPresenter", "revertStep result " + ((BitableAsyncResponse) r100).getResult());
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f208756a = null;

        static {
            f208756a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("StageFieldPresenter", (Throwable) r100, false);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f208757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.bitable.card.model.stmodel.field.d f208758b;

        public f(o r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101) {
            this.f208757a = r100;
            this.f208758b = r101;
        }

        /* JADX WARN: Type inference failed for: r1v5, types: [V, java.util.List] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BitableAsyncResponse r101 = (BitableAsyncResponse) r100;
            tt5.a.h("StageFieldPresenter", "markStepDone result " + r101.getResult());
            Integer r102 = r101.getResult();
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.intValue() != 0) goto L71;
            o r103 = this.f208757a;
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r104 = this.f208758b;
            r103.getClass();
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r105 = null;
            if (r104.getType() != StageType.Default) goto L38;
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r106 = r103.f208747f;
            if (r106 == null) goto L13;
            List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r107 = r106.f207153n;
        L14:
            List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r108 = r107;
            if (r108 != null) goto L17;
        L20:
            boolean r109 = true;
        L21:
            if (r109 == true) goto L38;
            Iterator<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r110 = r107.iterator();
            int r111 = 0;
        L25:
            if (r110.hasNext() == false) goto L30;
            if (Intrinsics.areEqual(r110.next().f207141a, r104.f207141a) == true) goto L31;
            r111 = r111 + 1;
        L31:
            if (r111 < 0) goto L38;
            if (r111 >= (r107.size() - 1)) goto L38;
            if (((com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) ListProtector.get(r107, r111 + 1)).getType() != StageType.EndDone) goto L38;
            boolean r112 = true;
        L39:
            if (r112 == false) goto L72;
            o r113 = this.f208757a;
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r114 = r113.f208747f;
            if (r114 == null) goto L55;
            List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r115 = r114.f207153n;
            if (r115 == null) goto L55;
            Iterator<T> r116 = r115.iterator();
        L46:
            if (r116.hasNext() == false) goto L54;
            r105 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) r116.next();
            if (r105.getType() != StageType.EndDone) goto L50;
            boolean r117 = true;
        L51:
            if (r117 == false) goto L46;
        L50:
            r117 = false;
            goto L51
        L54:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L55:
            if (r105 == null) goto L62;
            dp4.a<List<String>> r118 = r113.f208748g;
            if (r118 == null) goto L59;
            r118.f469598l = CollectionsKt.listOf(r105.f207141a);
        L59:
            com.bytedance.ee.bear.bitable.card.view.stage.b r119 = r113.f208744c;
            if (r119 == null) goto L62;
            r119.N00();
        L62:
            this.f208757a.f208742a.notifyViewGuardChanged(true);
            com.bytedance.ee.util.ui.j.d(new p(this.f208757a), 50);
            return;
        L72:
            return;
        L30:
            r111 = -1;
            goto L31
        L17:
            if (r108.isEmpty() == true) goto L20;
            r109 = false;
            goto L21
        L13:
            r107 = null;
        L38:
            r112 = false;
            goto L39
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f208759a = null;

        static {
            f208759a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("StageFieldPresenter", (Throwable) r100, false);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T> f208760a = null;

        static {
            f208760a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h("StageFieldPresenter", "revertStep result " + ((BitableAsyncResponse) r100).getResult());
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<T> f208761a = null;

        static {
            f208761a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("StageFieldPresenter", (Throwable) r100, false);
        }
    }

    static {
    }

    @Override // qq4.b
    public final void b(EFieldUIType r100, String r101) {
    }

    @Override // qq4.b
    public final void d(String r100) {
    }

    @Override // qq4.b
    public final int getCurrentRecordIndex() {
        return 0;
    }

    @Override // qq4.b
    public final void k(String r100, String r101) {
    }

    @Override // qq4.b
    public final boolean o(String r100) {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final void f() {
        this.f208743b.q0().l("stage_rollback", "none");
        Integer r100 = i();
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r101 = this.f208747f;
        Object r102 = null;
        if (r101 == null) goto L5;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r103 = r101.f207153n;
    L6:
        if (r100 == null) goto L33;
        if (r103 == null) goto L33;
        if (r100.intValue() >= r103.size()) goto L33;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r104 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) ListProtector.get(r103, r100.intValue());
        BitableCardViewModel r105 = this.f208742a;
        cp4.b r106 = this.f208750i;
        if (r106 == null) goto L14;
        String r107 = r106.f464658b;
    L15:
        if (r106 == null) goto L17;
        String r108 = r106.f464660d;
    L18:
        BitableAsyncRequestBiz r109 = BitableAsyncRequestBiz.Stage;
        Pair[] r110 = new Pair[4];
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r111 = this.f208747f;
        if (r111 == null) goto L21;
        String r112 = r111.f478255b;
    L22:
        r110[0] = TuplesKt.to("fieldId", r112);
        cp4.b r113 = this.f208750i;
        if (r113 == null) goto L27;
        cp4.c r114 = r113.f464664h;
        if (r114 == null) goto L27;
        String r115 = r114.f464684b;
    L28:
        r110[1] = TuplesKt.to("viewId", r115);
        cp4.a r116 = this.f208745d;
        if (r116 == null) goto L31;
        r102 = r116.f464635b;
    L31:
        r110[2] = TuplesKt.to("recordId", r102);
        r110[3] = TuplesKt.to("optionId", r104.f207141a);
        this.f208751j.add(r105.fetchCommonAsyncRequest(r107, r108, r109, "revertStep", null, MapsKt.mapOf(r110)).subscribe(h.f208760a, i.f208761a));
        return;
    L27:
        r115 = null;
        goto L28
    L21:
        r112 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L14:
        r107 = null;
    L33:
        StringBuilder r117 = new StringBuilder("revertStep current select index is invalid ");
        r117.append(r100);
        r117.append(' ');
        if (r103 == null) goto L36;
        r102 = Integer.valueOf(r103.size());
    L36:
        r117.append(r102);
        tt5.a.d("StageFieldPresenter", r117.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final void g() {
        this.f208743b.q0().l("stage_suspend", "none");
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r100 = this.f208747f;
        String r101 = null;
        if (r100 == null) goto L15;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r102 = r100.f207153n;
        if (r102 == null) goto L15;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (((com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) r105).getType() != StageType.EndCancel) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L8;
        r103.add(r105);
        goto L8
    L12:
        r106 = false;
    L16:
        if (r103 == null) goto L18;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r107 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) CollectionsKt.firstOrNull(r103);
    L19:
        if (r107 != null) goto L22;
        tt5.a.d("StageFieldPresenter", "cancel step option is null");
        return;
    L22:
        BitableCardViewModel r108 = this.f208742a;
        cp4.b r109 = this.f208750i;
        if (r109 == null) goto L25;
        String r110 = r109.f464658b;
    L26:
        if (r109 == null) goto L28;
        String r111 = r109.f464660d;
    L29:
        BitableAsyncRequestBiz r112 = BitableAsyncRequestBiz.Stage;
        Pair[] r113 = new Pair[4];
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r114 = this.f208747f;
        if (r114 == null) goto L32;
        String r115 = r114.f478255b;
    L33:
        r113[0] = TuplesKt.to("fieldId", r115);
        cp4.b r116 = this.f208750i;
        if (r116 == null) goto L38;
        cp4.c r117 = r116.f464664h;
        if (r117 == null) goto L38;
        String r118 = r117.f464684b;
    L39:
        r113[1] = TuplesKt.to("viewId", r118);
        cp4.a r119 = this.f208745d;
        if (r119 == null) goto L42;
        r101 = r119.f464635b;
    L42:
        r113[2] = TuplesKt.to("recordId", r101);
        r113[3] = TuplesKt.to("optionId", r107.f207141a);
        this.f208751j.add(r108.fetchCommonAsyncRequest(r110, r111, r112, "markStageCanceled", null, MapsKt.mapOf(r113)).subscribe(b.f208753a, c.f208754a));
        return;
    L38:
        r118 = null;
        goto L39
    L32:
        r115 = null;
        goto L33
    L28:
        r111 = null;
        goto L29
    L25:
        r110 = null;
        goto L26
    L18:
        r107 = null;
    L15:
        r103 = null;
        goto L16
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final Integer i() {
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r100 = this.f208747f;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r101 = null;
        if (r100 == null) goto L5;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r102 = r100.f207153n;
    L6:
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r103 = r102;
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return null;
    L15:
        Integer r105 = this.f208746e;
        if (r105 == null) goto L18;
    L17:
        int r106 = r105.intValue();
    L23:
        if (r106 < r102.size()) goto L26;
        tt5.a.d("StageFieldPresenter", "currentViewSelectStageIndex reset index");
        return 0;
    L26:
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r107 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) ListProtector.get(r102, r106);
        if (r107.getType() == StageType.Default) goto L48;
        if (r107.getType() != StageType.EndDone) goto L46;
        ListIterator<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r108 = r102.listIterator(r102.size());
    L32:
        if (r108.hasPrevious() == false) goto L39;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r109 = r108.previous();
        if (r109.getType() != StageType.Default) goto L36;
        boolean r110 = true;
    L37:
        if (r110 == false) goto L32;
        r101 = r109;
        goto L39
    L36:
        r110 = false;
    L39:
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r111 = r101;
        if (r111 != null) goto L44;
        tt5.a.d("StageFieldPresenter", "currentViewSelectStageIndex no default option");
        return 0;
    L44:
        return Integer.valueOf(r102.indexOf(r111));
    L46:
        return 0;
    L48:
        return Integer.valueOf(r106);
    L18:
        r105 = j();
        if (r105 != null) goto L17;
        r106 = 0;
        goto L23
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final Integer j() {
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r100 = this.f208747f;
        if (r100 == null) goto L5;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r101 = r100.f207153n;
    L6:
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return null;
    L15:
        dp4.a<List<String>> r104 = this.f208748g;
        if (r104 == null) goto L36;
        List<String> r105 = r104.f469598l;
        if (r105 == null) goto L36;
        String r106 = (String) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L36;
        Iterator<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r107 = r101.iterator();
        int r108 = 0;
    L24:
        if (r107.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(r107.next().f207141a, r106) == true) goto L30;
        r108 = r108 + 1;
    L30:
        if (r108 < 0) goto L34;
        return Integer.valueOf(r108);
    L34:
        return 0;
    L29:
        r108 = -1;
    L36:
        return 0;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final void l() {
        this.f208743b.q0().l("stage_recover", "none");
        BitableCardViewModel r100 = this.f208742a;
        cp4.b r101 = this.f208750i;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f464658b;
    L6:
        if (r101 == null) goto L8;
        String r104 = r101.f464660d;
    L9:
        BitableAsyncRequestBiz r105 = BitableAsyncRequestBiz.Stage;
        Pair[] r106 = new Pair[3];
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r107 = this.f208747f;
        if (r107 == null) goto L12;
        String r108 = r107.f478255b;
    L13:
        r106[0] = TuplesKt.to("fieldId", r108);
        cp4.b r109 = this.f208750i;
        if (r109 == null) goto L18;
        cp4.c r110 = r109.f464664h;
        if (r110 == null) goto L18;
        String r111 = r110.f464684b;
    L19:
        r106[1] = TuplesKt.to("viewId", r111);
        cp4.a r112 = this.f208745d;
        if (r112 == null) goto L22;
        r102 = r112.f464635b;
    L22:
        r106[2] = TuplesKt.to("recordId", r102);
        this.f208751j.add(r100.fetchCommonAsyncRequest(r103, r104, r105, "markStageRecover", null, MapsKt.mapOf(r106)).subscribe(d.f208755a, e.f208756a));
        return;
    L18:
        r111 = null;
        goto L19
    L12:
        r108 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final void r() {
        com.bytedance.ee.bear.bitable.card.view.stage.b r100 = this.f208744c;
        if (r100 == null) goto L5;
        r100.start();
    L5:
        BitableAnalytic r101 = this.f208743b.q0();
        Map r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to("tab_type", "stage"), TuplesKt.to("source", "stage")});
        r101.getClass();
        HashMap r103 = new HashMap();
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, BrowserDependency.UrlClickType.CARD);
        r103.putAll(r102);
        r101.t("ccm_bitable_card_view", r103);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final com.larksuite.component.universe_design.menu.c c() {
        return this.f208749h;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final com.bytedance.ee.bear.bitable.card.model.stmodel.field.c e() {
        return this.f208747f;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final cp4.a getCurrentRecord() {
        return this.f208745d;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final com.bytedance.ee.bear.bitable.card.view.stage.b getView() {
        return this.f208744c;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final dp4.a<List<String>> m() {
        return this.f208748g;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final void a(com.larksuite.component.universe_design.menu.c r100) {
        this.f208749h = r100;
    }

    @Override // lq4.b
    public final void h(int r100) {
        this.f208746e = Integer.valueOf(r100);
        com.bytedance.ee.bear.bitable.card.view.stage.b r101 = this.f208744c;
        if (r101 == null) goto L6;
        r101.N00();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.stage.a
    public final void n(com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r110) {
        Intrinsics.checkNotNullParameter(r110, "option");
        this.f208743b.q0().l("stage_node_complete", "none");
        if (this.f208752k == false) goto L5;
        tt5.a.h("StageFieldPresenter", "markStageRecover requesting");
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        tt5.a.h("StageFieldPresenter", "markStepDone requesting");
        return;
    L9:
        BitableCardViewModel r101 = this.f208742a;
        cp4.b r102 = this.f208750i;
        String r103 = null;
        if (r102 == null) goto L12;
        String r104 = r102.f464658b;
    L13:
        if (r102 == null) goto L15;
        String r105 = r102.f464660d;
    L16:
        BitableAsyncRequestBiz r106 = BitableAsyncRequestBiz.Stage;
        Pair[] r111 = new Pair[5];
        if (r102 == null) goto L19;
        String r107 = r102.f464657a;
    L20:
        r111[0] = TuplesKt.to("stackViewId", r107);
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r108 = this.f208747f;
        if (r108 == null) goto L23;
        String r109 = r108.f478255b;
    L24:
        r111[1] = TuplesKt.to("fieldId", r109);
        cp4.b r112 = this.f208750i;
        if (r112 == null) goto L29;
        cp4.c r113 = r112.f464664h;
        if (r113 == null) goto L29;
        String r114 = r113.f464684b;
    L30:
        r111[2] = TuplesKt.to("viewId", r114);
        cp4.a r115 = this.f208745d;
        if (r115 == null) goto L33;
        r103 = r115.f464635b;
    L33:
        r111[3] = TuplesKt.to("recordId", r103);
        r111[4] = TuplesKt.to("optionId", r110.f207141a);
        this.f208751j.add(r101.fetchCommonAsyncRequest(r104, r105, r106, "markStepDone", null, MapsKt.mapOf(r111)).subscribe(new f(this, r110), g.f208759a));
        return;
    L29:
        r114 = null;
        goto L30
    L23:
        r109 = null;
        goto L24
    L19:
        r107 = null;
        goto L20
    L15:
        r105 = null;
        goto L16
    L12:
        r104 = null;
        goto L13
    L5:
        this.f208752k = true;
        com.bytedance.ee.util.ui.j.d(new q(this), 300);
        r100 = false;
        goto L6
    }

    public final void q(cp4.b r110) {
        Intrinsics.checkNotNullParameter(r110, "stTable");
        ECardCloseReason.a r100 = ECardCloseReason.Companion;
        String r101 = r110.A;
        r100.getClass();
        ECardCloseReason[] r102 = ECardCloseReason.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        dp4.a<List<String>> r105 = null;
        Object r106 = null;
        r105 = null;
        if (r104 >= r103) goto L9;
        ECardCloseReason r107 = r102[r104];
        if (Intrinsics.areEqual(r107.getValue(), r101) == true) goto L10;
        r104 = r104 + 1;
    L10:
        if (r107 == null) goto L18;
        com.bytedance.ee.bear.bitable.card.view.stage.b r111 = this.f208744c;
        if (r111 == null) goto L14;
        r111.stop();
    L14:
        com.bytedance.ee.bear.bitable.card.view.stage.b r112 = this.f208744c;
        if (r112 == null) goto L89;
        r112.GT(UIHelper.getString(R.string.Bitable_Relation_FieldWasDeleted_Mobile));
        return;
    L89:
        return;
    L18:
        this.f208745d = null;
        this.f208747f = null;
        this.f208750i = r110;     // Catch: Exception -> L76
        List<cp4.a> r108 = r110.f464668l;     // Catch: Exception -> L76
        if (r108 == null) goto L22;
        cp4.a r109 = (cp4.a) CollectionsKt.firstOrNull(r108);     // Catch: Exception -> L76
    L23:
        this.f208745d = r109;     // Catch: Exception -> L76
        if (r110.f464666j == null) goto L36;
        if (r109 == null) goto L36;
        List<dp4.a> r113 = r109.f464646m;     // Catch: Exception -> L76
        if (r113 == null) goto L36;
        Iterator<T> r114 = r113.iterator();     // Catch: Exception -> L76
    L30:
        if (r114.hasNext() == false) goto L34;
        Object r115 = r114.next();     // Catch: Exception -> L76
        if (Intrinsics.areEqual(((dp4.a) r115).f469587a.f478255b, r110.f464666j) == false) goto L30;
    L35:
        dp4.a r116 = (dp4.a) r115;     // Catch: Exception -> L76
        goto L36
    L34:
        r115 = null;
    L36:
        String[] r117 = r110.f464662f;     // Catch: Exception -> L76
        boolean r118 = true;
        if (r117 != null) goto L39;
    L45:
        if (r118 == true) goto L54;
        Map<String, fp4.g> r119 = r110.f464665i;     // Catch: Exception -> L76
        if (r119 == null) goto L49;
        fp4.g r120 = r119.get(r117[0]);     // Catch: Exception -> L76
    L51:
        if ((r120 instanceof com.bytedance.ee.bear.bitable.card.model.stmodel.field.c) == false) goto L53;
        this.f208747f = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.c) r120;     // Catch: Exception -> L76
        goto L54
    L53:
        tt5.a.d("StageFieldPresenter", "currentField is not StageField!");     // Catch: Exception -> L76
        goto L54
    L49:
        r120 = null;
    L54:
        cp4.a r121 = this.f208745d;     // Catch: Exception -> L76
        if (r121 == null) goto L69;
        List<dp4.a> r122 = r121.f464646m;     // Catch: Exception -> L76
        if (r122 == null) goto L69;
        Iterator<T> r123 = r122.iterator();     // Catch: Exception -> L76
    L60:
        if (r123.hasNext() == false) goto L68;
        Object r124 = r123.next();     // Catch: Exception -> L76
        String r125 = ((dp4.a) r124).f469587a.f478255b;     // Catch: Exception -> L76
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.c r126 = this.f208747f;     // Catch: Exception -> L76
        if (r126 == null) goto L64;
        String r127 = r126.f478255b;     // Catch: Exception -> L76
    L66:
        if (Intrinsics.areEqual(r125, r127) == false) goto L60;
        r106 = r124;
        goto L68
    L64:
        r127 = null;
    L68:
        r105 = (dp4.a) r106;     // Catch: Exception -> L76
    L69:
        this.f208748g = r105;     // Catch: Exception -> L76
        com.bytedance.ee.bear.bitable.card.view.stage.b r128 = this.f208744c;     // Catch: Exception -> L76
        if (r128 == null) goto L72;
        r128.kJ();     // Catch: Exception -> L76
    L72:
        com.bytedance.ee.bear.bitable.card.view.stage.b r129 = this.f208744c;     // Catch: Exception -> L76
        if (r129 == null) goto L90;
        r129.N00();     // Catch: Exception -> L76
        return;
    L90:
        return;
    L39:
        if (r117.length != 0) goto L41;
        boolean r130 = true;
    L42:
        if (r130 == true) goto L45;
        r118 = false;
        goto L45
    L41:
        r130 = false;
        goto L42
    L22:
        r109 = null;
    L76:
        e = move-exception;
        tt5.a.f("StageFieldPresenter", e, false);
        return;
    L9:
        r107 = null;
        goto L10
    }

    public o(BitableCardViewModel r100, gp4.h r101) {
        Intrinsics.checkNotNullParameter(r100, "cardViewModel");
        Intrinsics.checkNotNullParameter(r101, "cardDelegate");
        this.f208742a = r100;
        this.f208743b = r101;
        this.f208751j = new CompositeDisposable();
    }

    @Override // qq4.b
    public final boolean p(String r100, String r101) {
        if (r100 == null) goto L10;
        cp4.a r102 = this.f208745d;
        if (r102 == null) goto L6;
        String r103 = r102.f464635b;
    L8:
        if (Intrinsics.areEqual(r103, r100) == false) goto L10;
        return true;
    L6:
        r103 = null;
    L10:
        return false;
    }
}
