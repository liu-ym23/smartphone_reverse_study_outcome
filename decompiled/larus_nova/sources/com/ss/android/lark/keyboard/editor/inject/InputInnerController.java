package com.ss.android.lark.keyboard.editor.inject;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.biz.attachment.inject.AttachmentInnerTopPlugin;
import com.ss.android.lark.keyboard.biz.mention.inject.h;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.ime.ImeStateDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class InputInnerController implements wnb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.b f428776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f428777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f428778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f428779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<wnb.b.a<?>, wnb.b<?>> f428780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<wnb.b.a<?>, View> f428781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<wnb.b.a<?>, Direction> f428782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<wnb.b.a<?>> f428783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f428784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f428785j;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputInnerController f428786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f428787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f428788c;

        public a(InputInnerController r100, ViewGroup r101, View r102) {
            this.f428786a = r100;
            this.f428787b = r101;
            this.f428788c = r102;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            InputInnerController r109 = this.f428786a;
            ViewGroup r110 = this.f428787b;
            View r111 = this.f428788c;
            r109.getClass();
            int r112 = r110.getHeight();
            int r113 = 0;
            if (r112 <= 0) goto L5;
            boolean r114 = true;
        L6:
            if (r114 == true) goto L9;
            r113 = 8;
        L9:
            r111.setVisibility(r113);
            return;
        L5:
            r114 = false;
            goto L6
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f428789a = null;

        static {
            int[] r100 = new int[InputInnerVisibilityMode.values().length];
            r100[InputInnerVisibilityMode.ALWAYS_GONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[InputInnerVisibilityMode.ALWAYS_VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[InputInnerVisibilityMode.DYNAMIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f428789a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputInnerController f428790a;

        public c(InputInnerController r100) {
            this.f428790a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.c.d(this.f428790a.f428784i);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // wnb.c
    public final void a(wnb.b.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Direction r101 = (Direction) ((LinkedHashMap) this.f428782g).get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        ViewGroup r102 = (ViewGroup) ((Map) this.f428785j.getValue()).get(r101);
        if (r102 != null) goto L8;
        return;
    L8:
        View r103 = (View) ((LinkedHashMap) this.f428781f).get(r100);
        if (r103 != null) goto L11;
        return;
    L11:
        wnb.b r104 = (wnb.b) ((LinkedHashMap) this.f428780e).get(r100);
        if (r104 == null) goto L14;
        InputInnerVisibilityMode r105 = r104.d();
    L16:
        if (r105 != InputInnerVisibilityMode.ALWAYS_GONE) goto L20;
        r103.setVisibility(8);
        return;
    L20:
        if (r101 != Direction.InnerTop) goto L23;
        h(r100, r103, r102);
        return;
    L23:
        r103.setVisibility(0);
        g(r101, r102);
        return;
    L14:
        r105 = null;
        goto L16
    }

    @Override // wnb.c
    public final void b(wnb.b.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Direction r101 = (Direction) ((LinkedHashMap) this.f428782g).get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        ViewGroup r102 = (ViewGroup) ((Map) this.f428785j.getValue()).get(r101);
        if (r102 != null) goto L8;
        return;
    L8:
        View r103 = (View) ((LinkedHashMap) this.f428781f).get(r100);
        if (r103 != null) goto L11;
        return;
    L11:
        wnb.b r104 = (wnb.b) ((LinkedHashMap) this.f428780e).get(r100);
        if (r104 == null) goto L14;
        InputInnerVisibilityMode r105 = r104.d();
    L16:
        if (r105 != InputInnerVisibilityMode.ALWAYS_VISIBLE) goto L20;
        r103.setVisibility(0);
        return;
    L20:
        if (r101 != Direction.InnerTop) goto L23;
        e(r100, r103, r102);
        return;
    L23:
        r103.setVisibility(8);
        g(r101, r102);
        return;
    L14:
        r105 = null;
        goto L16
    }

    public final <E extends wnb.b<E>> E d(wnb.b.a<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = ((LinkedHashMap) this.f428780e).get(r100);
        if ((r101 instanceof wnb.b) == true) goto L7;
        return null;
    L7:
        return (E) r101;
    }

    @Override // wnb.c
    public final void c(boolean r110, Direction r111) {
        Intrinsics.checkNotNullParameter(r111, "direction");
        Map<wnb.b.a<?>, Direction> r100 = this.f428782g;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L11;
        Map.Entry r104 = (Map.Entry) r102.next();
        if (((Direction) r104.getValue()) == r111) goto L9;
        r103 = false;
    L9:
        if (r103 == false) goto L3;
        r101.put(r104.getKey(), r104.getValue());
        goto L3
    L11:
        Set r105 = r101.keySet();
        ViewGroup r106 = (ViewGroup) ((Map) this.f428785j.getValue()).get(r111);
        if (r106 != null) goto L14;
        return;
    L14:
        Iterator r107 = r105.iterator();
        boolean r108 = false;
    L16:
        if (r107.hasNext() == false) goto L49;
        wnb.b.a<?> r109 = (wnb.b.a) r107.next();
        View r112 = (View) ((LinkedHashMap) this.f428781f).get(r109);
        if (r112 == null) goto L16;
        wnb.b r113 = (wnb.b) ((LinkedHashMap) this.f428780e).get(r109);
        if (r113 == null) goto L16;
        InputInnerVisibilityMode r114 = r113.d();
        int r115 = 8;
        if (r111 == Direction.InnerTop) goto L25;
        int r116 = b.f428789a[r114.ordinal()];
        if (r116 == 1) goto L45;
        if (r116 == 2) goto L44;
        if (r116 != 3) goto L43;
        boolean r117 = r110;
    L46:
        if (r117 == false) goto L48;
        r115 = 0;
    L48:
        r112.setVisibility(r115);
        goto L16
    L43:
        throw new NoWhenBranchMatchedException();
    L44:
        r117 = true;
        goto L46
    L45:
        r117 = false;
        goto L46
    L25:
        int r118 = b.f428789a[r114.ordinal()];
        if (r118 == 1) goto L35;
        if (r118 == 2) goto L34;
        if (r118 != 3) goto L33;
        if (r110 == false) goto L31;
        h(r109, r112, r106);
    L36:
        r108 = true;
        goto L16
    L31:
        e(r109, r112, r106);
        goto L36
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        h(r109, r112, r106);
        goto L36
    L35:
        r112.setVisibility(8);
        goto L36
    L49:
        if (r108 == false) goto L51;
        g(Direction.InnerTop, r106);
        return;
    L51:
        g(r111, r106);
    }

    public final void f(wnb.b.a<?> r100, boolean r101) {
        if (Intrinsics.areEqual(r100, h.f428459d) == false) goto L10;
        k.a.a(this.f428784i, new com.ss.android.lark.keyboard.editor.inject.a(r101));
        ImeStateDetail r102 = this.f428776a.z().getImeState().b();
        ImeStateDetail r103 = this.f428776a.z().getPanelState().b();
        if (r102.isShowOrExit() == false) goto L7;
    L8:
        k.a.a(this.f428784i, new k2b.a(r101));
        goto L10
    L7:
        if (r103.isShowOrExit() == true) goto L8;
    L10:
        if (Intrinsics.areEqual(r100, AttachmentInnerTopPlugin.f428282i) == false) goto L13;
        k.a.a(this.f428784i, new znb.a(r101));
        return;
    }

    public final void g(Direction r100, ViewGroup r101) {
        if (r100 != Direction.Top) goto L5;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L17;
        return;
    L17:
        r101.post(new c(this));
        return;
    L5:
        if (r100 == Direction.TopExpand) goto L14;
        if (r100 == Direction.TopMiddle) goto L14;
        if (r100 == Direction.InnerTop) goto L14;
        if (r100 == Direction.InnerBottom) goto L14;
        r102 = false;
        goto L15
    }

    public final void e(wnb.b.a<?> r100, View r101, ViewGroup r102) {
        boolean r103 = Intrinsics.areEqual(CollectionsKt.lastOrNull(this.f428783h), r100);
        r101.setVisibility(8);
        ((ArrayList) this.f428783h).remove(r100);
        if (r103 == false) goto L5;
        f(r100, false);
    L5:
        if (r103 == false) goto L12;
        wnb.b.a<?> r104 = (wnb.b.a) CollectionsKt.lastOrNull(this.f428783h);
        if (r104 == null) goto L12;
        View r105 = (View) ((LinkedHashMap) this.f428781f).get(r104);
        if (r105 == null) goto L11;
        r105.setVisibility(0);
    L11:
        f(r104, true);
    L12:
        g(Direction.InnerTop, r102);
    }

    public final void h(wnb.b.a<?> r100, View r101, ViewGroup r102) {
        wnb.b.a<?> r103 = (wnb.b.a) CollectionsKt.lastOrNull(this.f428783h);
        if (r103 != null) goto L5;
    L10:
        ((ArrayList) this.f428783h).remove(r100);
        ((ArrayList) this.f428783h).add(r100);
        r101.setVisibility(0);
        f(r100, true);
        g(Direction.InnerTop, r102);
        return;
    L5:
        if (Intrinsics.areEqual(r103, r100) == true) goto L10;
        View r104 = (View) ((LinkedHashMap) this.f428781f).get(r103);
        if (r104 == null) goto L9;
        r104.setVisibility(8);
    L9:
        f(r103, false);
        goto L10
    }

    public InputInnerController(final ViewGroup r110, final ViewGroup r111, final ViewGroup r112, final ViewGroup r113, final ViewGroup r114, final ViewGroup r210, final ViewGroup r211, final ViewGroup r212, View r213, com.ss.android.lark.keyboard.b r214) {
        Intrinsics.checkNotNullParameter(r110, "inputTopContainer");
        Intrinsics.checkNotNullParameter(r111, "inputTopExpandContainer");
        Intrinsics.checkNotNullParameter(r112, "inputTopMiddleContainer");
        Intrinsics.checkNotNullParameter(r113, "inputInnerStartContainer");
        Intrinsics.checkNotNullParameter(r114, "inputInnerTopContainer");
        Intrinsics.checkNotNullParameter(r210, "inputInnerEndContainer");
        Intrinsics.checkNotNullParameter(r211, "inputInnerEndVerticalContainer");
        Intrinsics.checkNotNullParameter(r212, "inputInnerBottomContainer");
        Intrinsics.checkNotNullParameter(r213, "inputInnerTopContainerDivider");
        Intrinsics.checkNotNullParameter(r214, ObricActionBarTrackType.KEY_BOARD);
        this.f428776a = r214;
        this.f428777b = r110;
        this.f428778c = r111;
        this.f428779d = r112;
        this.f428780e = new LinkedHashMap();
        this.f428781f = new LinkedHashMap();
        this.f428782g = new LinkedHashMap();
        this.f428783h = new ArrayList();
        k r115 = r214.e();
        this.f428784i = r115;
        this.f428785j = LazyKt.lazy(new InputInnerController$directionRegions$2(r110, r111, r112, r113, r114, r210, r211, r212));
        r114.addOnLayoutChangeListener(new a(this, r114, r213));
        r115.of(this).c(com.ss.android.lark.keyboard.editor.inject.a.class, new AnonymousClass2(this));
    }
}
