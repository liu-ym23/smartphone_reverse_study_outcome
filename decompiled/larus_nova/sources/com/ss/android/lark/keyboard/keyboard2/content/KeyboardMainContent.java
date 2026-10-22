package com.ss.android.lark.keyboard.keyboard2.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Region;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.KeyboardChangeBounds;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenu;
import com.ss.android.lark.keyboard.keyboard2.KeyboardRootContainer;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardMainContent implements IKeyboardContent {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f429511m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f429512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f429513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f429514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f429515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f429516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f429517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f429518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f429519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f429520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f429521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<Pair<Function1<Transition, Transition>, Boolean>> f429522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f429523l;

    public static final class a implements IKeyboardContent.a {
        @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent.a
        public final String getTag() {
            return "MainContent";
        }

        public a() {
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f429524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KeyboardMainContent f429525b;

        public b(int r100, KeyboardMainContent r101) {
            this.f429524a = r100;
            this.f429525b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            com.ss.android.lark.keyboard.ime.b r109 = com.ss.android.lark.keyboard.ime.b.f429377a;
            final int r110 = this.f429524a;
            final KeyboardMainContent r111 = this.f429525b;
            Function0<String> r112 = new KeyboardMainContent$handleImeHeight$3$1(r110, r111);
            r109.getClass();
            com.ss.android.lark.keyboard.ime.b.a("KeyboardMainContent", r112);
        }
    }

    static {
        f429511m = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onCreate() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onDestroy() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onShow() {
    }

    public final com.ss.android.lark.keyboard.b e() {
        com.ss.android.lark.keyboard.b r100 = this.f429512a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    public final Region f() {
        Region r100 = new Region();
        ViewGroup r101 = this.f429520i;
        r100.set(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom());
        return r100;
    }

    public final void g() {
        this.f429516e.setVisibility(8);
    }

    public final void h() {
        this.f429520i.setVisibility(8);
    }

    public final void l() {
        this.f429520i.setVisibility(0);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onHide() {
        k.a.a(e().e(), new com.ss.android.lark.keyboard.event.b(InputSupportType.Text));
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.ViewInitStrategy a() {
        return IKeyboardContent.ViewInitStrategy.Lazy;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.a getKey() {
        return this.f429513b;
    }

    public KeyboardMainContent(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f429513b = f429511m;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.kb_content_main, null, false);
        this.f429514c = r101;
        this.f429515d = r101.findViewById(R.id.ime_wrapper_delegate_view);
        this.f429516e = (ViewGroup) r101.findViewById(R.id.menu_wrapper);
        this.f429517f = (ViewGroup) r101.findViewById(R.id.middle_container);
        this.f429518g = (ViewGroup) r101.findViewById(R.id.top_insets);
        this.f429519h = (ViewGroup) r101.findViewById(R.id.bottom_insets);
        this.f429520i = (ViewGroup) r101.findViewById(R.id.right_insets);
        this.f429521j = (ViewGroup) r101.findViewById(R.id.left_insets);
        this.f429522k = new ArrayList();
    }

    public static final String d(KeyboardMainContent r100) {
        View r101 = r100.f429514c.getRootView();
        Integer r102 = null;
        if (r101 == null) goto L5;
        View r103 = r101.findViewById(android.R.id.content);
    L6:
        StringBuilder r104 = new StringBuilder("delegate[h=");
        r104.append(r100.f429515d.getHeight());
        r104.append(", top=");
        r104.append(r100.f429515d.getTop());
        r104.append(", bottom=");
        r104.append(r100.f429515d.getBottom());
        r104.append(", measuredH=");
        r104.append(r100.f429515d.getMeasuredHeight());
        r104.append("], main[h=");
        r104.append(r100.f429514c.getHeight());
        r104.append(", top=");
        r104.append(r100.f429514c.getTop());
        r104.append(", bottom=");
        r104.append(r100.f429514c.getBottom());
        r104.append("], content[h=");
        if (r103 == null) goto L9;
        Integer r105 = Integer.valueOf(r103.getHeight());
    L10:
        r104.append(r105);
        r104.append(", bottom=");
        if (r103 == null) goto L13;
        Integer r106 = Integer.valueOf(r103.getBottom());
    L14:
        r104.append(r106);
        r104.append("], root[h=");
        View r107 = r100.f429514c.getRootView();
        if (r107 == null) goto L17;
        Integer r108 = Integer.valueOf(r107.getHeight());
    L18:
        r104.append(r108);
        r104.append(", bottom=");
        View r109 = r100.f429514c.getRootView();
        if (r109 == null) goto L21;
        r102 = Integer.valueOf(r109.getBottom());
    L21:
        r104.append(r102);
        r104.append(']');
        return r104.toString();
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f429514c;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void c(final int r100) {
        com.ss.android.lark.keyboard.ime.b r101 = com.ss.android.lark.keyboard.ime.b.f429377a;
        Function0<String> r102 = new KeyboardMainContent$handleImeHeight$1(r100, this);
        r101.getClass();
        com.ss.android.lark.keyboard.ime.b.a("KeyboardMainContent", r102);
        View r103 = this.f429515d;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L7;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        r105.height = r100;
        r103.setLayoutParams(r105);
        this.f429515d.addOnLayoutChangeListener(new b(r100, this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void i(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f429522k.add(TuplesKt.to(r100, Boolean.TRUE));
        if (this.f429523l == true) goto L13;
        this.f429523l = true;
        com.ss.android.lark.keyboard.b r101 = e();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if ((r101 instanceof BasicKeyboard) == false) goto L8;
        KeyboardRootContainer r102 = ((BasicKeyboard) r101).f429436b;
    L9:
        if (r102 == null) goto L12;
        r102.addOnLayoutChangeListener(new d(this));
        return;
    L12:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final Transition j(KeyboardChangeBounds r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
        Iterator<Pair<Function1<Transition, Transition>, Boolean>> r101 = this.f429522k.iterator();
        Transition r102 = r100;
    L4:
        if (r101.hasNext() == false) goto L6;
        r102 = r101.next().getFirst().invoke(r100);
        goto L4
    L6:
        CollectionsKt.removeAll(this.f429522k, KeyboardMainContent$onOverrideNextKeyboardTransition$2.INSTANCE);
        return r102;
    }

    public final void k(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429512a = r100;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        com.ss.android.lark.keyboard.keyboard2.b r101 = e().L();
        if ((r101 instanceof com.ss.android.lark.keyboard.base.c) == false) goto L6;
        ((com.ss.android.lark.keyboard.base.c) r101).onConfigurationChanged(r100);
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onActivityResult(int r100, int r101, Intent r102) {
        if (r101 != (-1)) goto L26;
        if (r102 == null) goto L26;
        com.ss.android.lark.keyboard.keyboard2.d r103 = e().H();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r102, "data");
        if ((r103 instanceof KeyboardMenu) == false) goto L22;
        KeyboardMenu r104 = (KeyboardMenu) r103;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "data");
        Collection r105 = ((LinkedHashMap) r104.f429466d).values();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L10:
        if (r107.hasNext() == false) goto L12;
        r106.add(((KeyboardMenu.b) r107.next()).f429477a);
        goto L10
    L12:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r106.iterator();
    L14:
        if (r109.hasNext() == false) goto L18;
        Object r110 = r109.next();
        if ((r110 instanceof com.ss.android.lark.keyboard.base.b) == false) goto L14;
        r108.add(r110);
        goto L14
    L18:
        Iterator r111 = r108.iterator();
    L20:
        if (r111.hasNext() == false) goto L22;
        ((com.ss.android.lark.keyboard.base.b) r111.next()).e(r100, r102);
    L22:
        com.ss.android.lark.keyboard.keyboard2.b r112 = e().L();
        if ((r112 instanceof com.ss.android.lark.keyboard.base.b) == false) goto L35;
        ((com.ss.android.lark.keyboard.base.b) r112).e(r100, r102);
        return;
    L35:
        return;
    L26:
        Log.i("KeyboardMainContent", "handleActivityResult: result code is not result ok");
    }
}
