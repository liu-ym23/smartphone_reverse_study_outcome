package com.larus.bmhome.chat.nestedmenu.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.nestedmenu.NestedMenuPopupStrategy;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.menu.CreateMenuV2;
import com.larus.bmhome.view.screenmenu.MenuItemType;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.skydoves.balloon.Balloon;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.j0;
import di8.k0;
import di8.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;
import wa8.n0;

/* JADX INFO: loaded from: classes25.dex */
public final class NestedMenuPopup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f308273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends q> f308274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<q.a, Unit> f308275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<q.a, Unit> f308276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<List<? extends q>, Unit> f308277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f308278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Balloon f308279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Balloon f308280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CreateMenuV2 f308281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f308282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f308283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f308284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PopupShowMethod f308285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f308286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f308287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f308288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f308289q;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/ui/NestedMenuPopup$PopupShowMethod;", "", "<init>", "(Ljava/lang/String;I)V", "ALIGN_TOP", "DROP_DOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PopupShowMethod extends Enum<PopupShowMethod> {
        public static final PopupShowMethod ALIGN_TOP = null;
        public static final PopupShowMethod DROP_DOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PopupShowMethod[] f308290a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f308291b = null;

        public static EnumEntries<PopupShowMethod> getEntries() {
            return f308291b;
        }

        static {
            PopupShowMethod r100 = new PopupShowMethod("ALIGN_TOP", 0);
            ALIGN_TOP = r100;
            PopupShowMethod r101 = new PopupShowMethod("DROP_DOWN", 1);
            DROP_DOWN = r101;
            PopupShowMethod[] r102 = {r100, r101};
            f308290a = r102;
            f308291b = EnumEntriesKt.enumEntries(r102);
        }

        public static PopupShowMethod[] values() {
            return (PopupShowMethod[]) f308290a.clone();
        }

        public static PopupShowMethod valueOf(String r100) {
            return (PopupShowMethod) r27.a.a(PopupShowMethod.class, r100);
        }

        public PopupShowMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/ui/NestedMenuPopup$PopupVerticalSide;", "", "<init>", "(Ljava/lang/String;I)V", "ABOVE", "BELOW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PopupVerticalSide extends Enum<PopupVerticalSide> {
        public static final PopupVerticalSide ABOVE = null;
        public static final PopupVerticalSide BELOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PopupVerticalSide[] f308292a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f308293b = null;

        public static EnumEntries<PopupVerticalSide> getEntries() {
            return f308293b;
        }

        static {
            PopupVerticalSide r100 = new PopupVerticalSide("ABOVE", 0);
            ABOVE = r100;
            PopupVerticalSide r101 = new PopupVerticalSide("BELOW", 1);
            BELOW = r101;
            PopupVerticalSide[] r102 = {r100, r101};
            f308292a = r102;
            f308293b = EnumEntriesKt.enumEntries(r102);
        }

        public static PopupVerticalSide[] values() {
            return (PopupVerticalSide[]) f308292a.clone();
        }

        public static PopupVerticalSide valueOf(String r100) {
            return (PopupVerticalSide) r27.a.a(PopupVerticalSide.class, r100);
        }

        public PopupVerticalSide(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PopupShowMethod f308294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f308295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f308296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f308297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f308298e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f308294a == r101.f308294a) goto L12;
            return false;
        L12:
            if (this.f308295b == r101.f308295b) goto L15;
            return false;
        L15:
            if (this.f308296c == r101.f308296c) goto L18;
            return false;
        L18:
            if (this.f308297d == r101.f308297d) goto L21;
            return false;
        L21:
            if (this.f308298e == r101.f308298e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f308294a.hashCode() * 31) + this.f308295b) * 31) + this.f308296c) * 31) + this.f308297d) * 31) + this.f308298e;
        }

        public final String toString() {
            return "PopupPlacement(showMethod=" + this.f308294a + ", businessXOff=" + this.f308295b + ", businessYOff=" + this.f308296c + ", rawXOff=" + this.f308297d + ", rawYOff=" + this.f308298e + ')';
        }

        public a(PopupShowMethod r100, int r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "showMethod");
            this.f308294a = r100;
            this.f308295b = r101;
            this.f308296c = r102;
            this.f308297d = r103;
            this.f308298e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PopupVerticalSide f308299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f308300b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f308299a == r101.f308299a) goto L12;
            return false;
        L12:
            if (this.f308300b == r101.f308300b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f308299a.hashCode() * 31) + this.f308300b;
        }

        public final String toString() {
            return "PopupVerticalSlot(side=" + this.f308299a + ", maxHeight=" + this.f308300b + ')';
        }

        public b(PopupVerticalSide r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "side");
            this.f308299a = r100;
            this.f308300b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CreateMenuV2 f308301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f308302b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f308301a, r101.f308301a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f308302b, r101.f308302b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f308301a.hashCode() * 31) + this.f308302b.hashCode();
        }

        public final String toString() {
            return "PreparedMenuView(menu=" + this.f308301a + ", view=" + this.f308302b + ')';
        }

        public c(CreateMenuV2 r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, TplType.MENU);
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f308301a = r100;
            this.f308302b = r101;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308303a = null;

        static {
            int[] r100 = new int[PopupVerticalSide.values().length];
            r100[PopupVerticalSide.ABOVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PopupVerticalSide.BELOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f308303a = r100;
        }
    }

    public final void b() {
        if (this.f308286n == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f308274b.iterator();
    L6:
        final q.a r101 = null;
        if (r100.hasNext() == false) goto L22;
        Object r102 = r100.next();
        q r103 = (q) r102;
        boolean r104 = false;
        if ((r103 instanceof q.a) == false) goto L20;
        q.a r105 = (q.a) r103;
        if (Intrinsics.areEqual(r105.f308354a, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL) == false) goto L20;
        d0 r106 = r105.f308356c;
        if (g(r106) == false) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r107 == false) goto L20;
        r104 = true;
        goto L20
    L15:
        if (i(r106) == false) goto L17;
        r107 = true;
    L20:
        if (r104 == false) goto L6;
    L24:
        if ((r102 instanceof q.a) == false) goto L26;
        r101 = (q.a) r102;
    L26:
        if (r101 != null) goto L28;
        return;
    L28:
        final CreateMenuV2 r108 = this.f308281i;
        if (r108 != null) goto L31;
        return;
    L31:
        final int r109 = this.f308274b.indexOf(r101);
        if (r109 >= 0) goto L34;
        return;
    L34:
        this.f308286n = true;
        r108.G(r109);
        r108.post(new i(r108, r109, this, r101));
        return;
    L22:
        r102 = null;
        goto L24
    }

    public final CreateMenu.a.C4119a d() {
        CreateMenu.a.C4119a r100 = CreateMenuV2.f317058s;
        Integer r101 = Integer.valueOf(i5.q());
        r101.intValue();
        c0 r102 = this.f308273a;
        if (r102.f468774g.f468809a == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L14;
        int r104 = r101.intValue();
        CreateMenu.a.C4119a r105 = CreateMenuV2.f317058s;
        return new CreateMenu.a.C4119a(r105.f317048a, r105.f317049b, r105.f317050c, r105.f317051d, r105.f317052e, r105.f317053f, r104, r105.f317055h, r105.f317056i, r105.f317057j);
    L14:
        return CreateMenuV2.f317058s;
    L5:
        if (Intrinsics.areEqual(r102.f468769b, "fork_conv") == false) goto L7;
        r103 = true;
        goto L8
    }

    public final Integer k() {
        b r100 = this.f308289q;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.f308300b);
    L6:
        Integer r102 = this.f308273a.f468774g.f468821m;
        if (r101 == null) goto L13;
        if (r102 != null) goto L12;
        return r101;
    L12:
        return Integer.valueOf(Math.min(r101.intValue(), r102.intValue()));
    L13:
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean o() {
        boolean r100 = false;
        if (this.f308274b.isEmpty() == false) goto L5;
        return false;
    L5:
        List<? extends q> r101 = this.f308274b;
        c r102 = e(this, r101, true, true, this.f308273a.f468774g.f468821m, 4);
        r102.f308302b.measure(0, 0);
        Integer r103 = Integer.valueOf(r102.f308301a.getMeasuredHeight());
        if (r103.intValue() <= 0) goto L8;
        boolean r104 = true;
    L9:
        b r105 = null;
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        int r106 = r103.intValue();
    L16:
        int r107 = r106 + r102.f308302b.getPaddingBottom();
        if (this.f308288p == false) goto L63;
        c0 r108 = this.f308273a;
        o0 r109 = r108.f468774g;
        if (r109.f468830v == false) goto L22;
        View r110 = r108.f468771d;
    L23:
        View r111 = r109.f468827s;
        if (r110.isAttachedToWindow() == false) goto L63;
        if (r111 != null) goto L27;
    L29:
        boolean r112 = false;
    L30:
        if (r112 == false) goto L63;
        Rect r113 = m(r110);
        Rect r114 = new Rect();
        Rect r115 = new Rect();
        if (this.f308273a.f468774g.f468830v == false) goto L35;
        boolean r116 = f(r110, r114);
    L37:
        if (this.f308273a.f468774g.f468830v == false) goto L39;
        boolean r117 = f(r111, r115);
    L41:
        if (r113.isEmpty() == true) goto L63;
        if (r116 == false) goto L63;
        if (r117 == false) goto L63;
        if (this.f308273a.f468774g.f468830v == false) goto L48;
        int r118 = RangesKt.coerceAtLeast(r113.bottom - r114.bottom, 0);
    L50:
        if (this.f308273a.f468774g.f468830v == false) goto L52;
        int r119 = RangesKt.coerceAtLeast(r115.bottom - r113.top, 0);
    L54:
        if (this.f308273a.f468774g.f468830v == false) goto L57;
        if (r107 <= r118) goto L58;
    L59:
        if (r100 == false) goto L61;
        b r120 = new b(PopupVerticalSide.BELOW, r118 + i5.Q());
    L62:
        r105 = r120;
        goto L63
    L61:
        r120 = new b(PopupVerticalSide.ABOVE, r119 + i5.Q());
    L58:
        r100 = true;
        goto L59
    L57:
        if (r118 < r119) goto L59;
    L52:
        r119 = RangesKt.coerceAtLeast(r114.top - r113.top, 0);
        goto L54
    L48:
        r118 = RangesKt.coerceAtLeast(r113.bottom - r114.bottom, 0);
        goto L50
    L39:
        r117 = true;
        goto L41
    L35:
        r116 = r110.getGlobalVisibleRect(r114);
        goto L37
    L27:
        if (r111.isAttachedToWindow() != true) goto L29;
        r112 = true;
        goto L30
    L22:
        r110 = r108.f468772e;
    L63:
        this.f308289q = r105;
        Integer r121 = k();
        if (r121 != null) goto L66;
    L68:
        final View r122 = r102.f308302b;
    L69:
        this.f308281i = r102.f308301a;
        this.f308282j = r122;
        com.larus.bmhome.view.screenmenu.d r123 = com.larus.bmhome.view.screenmenu.d.f317270a;
        com.larus.bmhome.view.screenmenu.d.b(this.f308273a.f468772e);
        c0 r124 = this.f308273a;
        o0 r125 = r124.f468774g;
        View r126 = r125.f468827s;
        if (r126 != null) goto L72;
        View r127 = r124.f468772e;
    L73:
        final Balloon r128 = c(this, r122, r127, null, r125.f468828t, new j(this), 4);
        r102.f308301a.setOnMenuSizeChangedListener(new k(r128, this, r122));
        View r129 = r128.f406022e.getContentView();
        r129.getViewTreeObserver().addOnPreDrawListener(new p(r129, this, r128));
        p(r128, r122, true);
        this.f308279g = r128;
        this.f308277e.invoke(r101);
        b();
        return true;
    L72:
        r127 = r126;
        goto L73
    L66:
        if (r102.f308302b.getMeasuredHeight() <= r121.intValue()) goto L68;
        r122 = j(r102.f308301a, r101);
        goto L69
    L15:
        r106 = RangesKt.coerceAtLeast((r102.f308302b.getMeasuredHeight() - r102.f308302b.getPaddingTop()) - r102.f308302b.getPaddingBottom(), 0);
        goto L16
    L8:
        r104 = false;
        goto L9
    }

    public static boolean g(d0 r100) {
        String r101 = n0.a();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
    L13:
        r102 = false;
    L14:
        if (r102 == true) goto L16;
    L18:
        return r102;
    L16:
        if (i(r100) == false) goto L18;
        return false;
    L11:
        if (Intrinsics.areEqual(r100.getCenter().f468761i, r101) == false) goto L13;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L9
    }

    public static boolean h(d0 r100) {
        if (g(r100) == false) goto L5;
        return true;
    L5:
        di8.n0 r101 = r100.getSubMenu();
        if (r101 == null) goto L34;
        Map<String, List<d0>> r102 = r101.f468807a;
        if (r102 == null) goto L34;
        Collection<List<d0>> r103 = r102.values();
        if (r103 == null) goto L34;
        Collection<List<d0>> r104 = r103;
        if (r104.isEmpty() == true) goto L31;
        Iterator<T> r105 = r104.iterator();
    L16:
        if (r105.hasNext() == false) goto L31;
        List r106 = (List) r105.next();
        if ((r106 instanceof Collection) == true) goto L20;
    L22:
        Iterator r107 = r106.iterator();
    L24:
        if (r107.hasNext() == false) goto L28;
        if (h((d0) r107.next()) == false) goto L24;
        boolean r108 = true;
    L29:
        if (r108 == false) goto L16;
        boolean r109 = true;
    L32:
        if (r109 != true) goto L34;
        return true;
    L28:
        r108 = false;
        goto L29
    L20:
        if (r106.isEmpty() == false) goto L22;
    L31:
        r109 = false;
    L34:
        return false;
    }

    public static boolean i(d0 r100) {
        di8.n0 r101 = r100.getSubMenu();
        if (r101 != null) goto L5;
        return false;
    L5:
        Collection<List<d0>> r102 = r101.f468807a.values();
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L37;
        List r104 = (List) r103.next();
        if ((r104 instanceof Collection) == true) goto L16;
    L18:
        Iterator r105 = r104.iterator();
    L20:
        if (r105.hasNext() == false) goto L24;
        if (h((d0) r105.next()) == false) goto L20;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L12;
        return true;
    L24:
        r106 = false;
        goto L25
    L16:
        if (r104.isEmpty() == false) goto L18;
    L37:
        return false;
    L8:
        if (r102.isEmpty() == false) goto L10;
        return false;
    }

    public static Rect m(View r100) {
        Rect r101 = new Rect();
        r100.getWindowVisibleDisplayFrame(r101);
        i0.f375410a.getClass();
        int r102 = RangesKt.coerceAtLeast(i0.g(), 0);
        int r103 = RangesKt.coerceAtLeast(i0.e(), 0);
        int r104 = r101.left;
        int r105 = r101.right;
        int r106 = m0.f375450a;
        return new Rect(r104, r102, r105, RangesKt.coerceAtLeast((m0.a(r100.getContext()) - r103) - i5.h(), r102));
    }

    public final void a(View r100) {
        o0 r101 = this.f308273a.f468774g;
        boolean r102 = r101.f468829u;
        boolean r103 = r101.f468830v;
        if (r102 == true) goto L6;
        if (r103 == true) goto L6;
        return;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        View r104 = r101.f468827s;
        Rect r105 = new Rect();
        Rect r106 = new Rect();
        if (r104 == null) goto L13;
        boolean r107 = true;
        if (r104.getGlobalVisibleRect(r106) != true) goto L13;
    L14:
        if (r107 == false) goto L16;
        r104.getWindowVisibleDisplayFrame(r105);
    L16:
        if (r102 == false) goto L19;
        if (r107 == false) goto L19;
        int r108 = RangesKt.coerceIn(r106.left - r105.left, 0, r100.getPaddingLeft());
    L20:
        if (r103 == false) goto L23;
        if (r107 == false) goto L23;
        int r109 = RangesKt.coerceIn(r105.right - r106.right, 0, r100.getPaddingRight());
    L24:
        r100.setPadding(r108, r100.getPaddingTop(), r109, r100.getPaddingBottom());
        return;
    L23:
        r109 = r100.getPaddingRight();
    L19:
        r108 = r100.getPaddingLeft();
    L13:
        r107 = false;
        goto L14
    }

    public final void s(View r100) {
        Balloon r101 = this.f308279g;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.f406022e.getContentView().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        a r102 = l(r100, r101.m(), r101.l(), this.f308285m);
        this.f308285m = r102.f308294a;
        Triple<View, Integer, Integer> r103 = n(this.f308273a.f468772e, r102.f308297d, r102.f308298e);
        if (r103 != null) goto L8;
        return;
    L8:
        r101.update(r103.getFirst(), r103.getSecond().intValue(), r103.getThird().intValue());
    }

    public final boolean update(List<? extends q> r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        boolean r101 = false;
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        this.f308274b = r100;
        boolean r102 = Intrinsics.areEqual(this.f308287o, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r102 == true) goto L13;
        this.f308284l++;
        Balloon r103 = this.f308280h;
        if (r103 == null) goto L10;
        r103.h();
    L10:
        this.f308280h = null;
        this.f308287o = null;
        CreateMenuV2 r104 = this.f308281i;
        if (r104 == null) goto L13;
        CreateMenu.a.C4119a r105 = CreateMenuV2.f317058s;
        r104.H(false, null);
    L13:
        CreateMenuV2 r106 = this.f308281i;
        if (r106 != null) goto L16;
        return false;
    L16:
        View r107 = j(r106, r100);
        this.f308282j = r107;
        if (this.f308289q == null) goto L25;
        Balloon r108 = this.f308279g;
        if (r108 != null) goto L21;
    L23:
        if (r101 == false) goto L25;
        s(r107);
        goto L25
    L21:
        if (r108.f406024g != true) goto L23;
        r101 = true;
    L25:
        r107.requestLayout();
        r107.invalidate();
        Balloon r109 = this.f308279g;
        if (r109 == null) goto L32;
        PopupWindow r110 = r109.f406022e;
        if (r110 == null) goto L32;
        View r111 = r110.getContentView();
        if (r111 == null) goto L32;
        r111.requestLayout();
    L32:
        Balloon r112 = this.f308279g;
        if (r112 == null) goto L39;
        PopupWindow r113 = r112.f406022e;
        if (r113 == null) goto L39;
        View r114 = r113.getContentView();
        if (r114 == null) goto L39;
        r114.invalidate();
    L39:
        if (r102 == false) goto L41;
    L43:
        return true;
    L41:
        if (this.f308280h != null) goto L43;
        b();
        goto L43
    }

    public static boolean f(View r100, Rect r101) {
        if (r100.isAttachedToWindow() == true) goto L5;
    L11:
        return false;
    L5:
        if (r100.getWidth() <= 0) goto L11;
        if (r100.getHeight() <= 0) goto L11;
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        int r103 = r102[0];
        r101.set(r103, r102[1], r100.getWidth() + r103, r102[1] + r100.getHeight());
        return true;
    }

    public final View j(CreateMenuV2 r510, List r511) {
        final LinkedHashMap r100 = new LinkedHashMap();
        List r101 = r511;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
        boolean r104 = false;
        int r110 = 0;
    L3:
        ViewGroup.LayoutParams r105 = null;
        if (r103.hasNext() == false) goto L17;
        Object r106 = r103.next();
        int r107 = r110 + 1;
        if (r110 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        q r108 = (q) r106;
        if ((r108 instanceof q.a) == false) goto L12;
        r100.put(Integer.valueOf(r110), r108);
        l0 r109 = l0.b(((q.a) r108).f308357d, r110, null, false, -2);
    L14:
        r102.add(r109);
        r110 = r107;
        goto L3
    L12:
        if ((r108 instanceof q.b) == false) goto L16;
        r109 = new l0(r110, 0, null, null, null, null, null, null, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, MenuItemType.SECTION_DIVIDER, null, null, null, null, null, null, null, Integer.valueOf(((q.b) r108).f308358a), null, null, null, null, false, -33554434, 125);
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        o0 r111 = this.f308273a.f468774g;
        int r112 = r111.f468819k;
        int r113 = r111.f468820l;
        Integer r114 = k();
        CreateMenu.a.C4119a r115 = d();
        Integer r116 = Integer.valueOf(r112);
        Integer r117 = Integer.valueOf(r113);
        Function2<? super Integer, ? super String, Unit> r118 = new com.larus.bmhome.chat.nestedmenu.ui.b(r100, this);
        Function2<? super Integer, ? super View, Unit> r119 = new g(r100, this);
        Function1<? super Integer, Unit> r120 = new h(r100, this);
        CreateMenu.a.C4119a r121 = CreateMenuV2.f317058s;
        int r122 = i5.Q();
        r510.getClass();
        Intrinsics.checkNotNullParameter(r102, "items");
        Intrinsics.checkNotNullParameter(r115, "config");
        Intrinsics.checkNotNullParameter(r120, "listener");
        ViewParent r123 = r510.getParent();
        if ((r123 instanceof ViewGroup) == false) goto L20;
        ViewGroup r124 = (ViewGroup) r123;
    L21:
        if (r124 != null) goto L23;
    L29:
        ViewGroup r125 = r124;
        if (r125 == null) goto L32;
        ViewParent r126 = r125.getParent();
    L34:
        if ((r126 instanceof ViewGroup) == false) goto L36;
        ViewGroup r127 = (ViewGroup) r126;
    L37:
        if (r127 == null) goto L39;
        int r128 = r127.indexOfChild(r125);
    L40:
        if (r125 == null) goto L42;
        r105 = r125.getLayoutParams();
    L42:
        if (r125 == null) goto L44;
        r125.removeView(r510);
    L44:
        if (r127 == null) goto L47;
        if (r125 == null) goto L47;
        r127.removeView(r125);
    L47:
        int r129 = r128;
        ViewGroup.LayoutParams r512 = r105;
        ViewGroup r513 = r127;
        View r130 = r510.B(r102, r122, true, false, null, r116, r117, r114, r115, r118, r119, r120);
        if (r512 == null) goto L51;
        r130.setLayoutParams(r512);
    L51:
        if (r513 == null) goto L54;
        if (r129 < 0) goto L54;
        r513.addView(r130, r129);
    L54:
        o0 r131 = this.f308273a.f468774g;
        if (r131.f468822n == false) goto L59;
        Function1<View, Unit> r132 = r131.f468823o;
        if (r132 == null) goto L59;
        r132.invoke(r130);
    L59:
        a(r130);
        return r130;
    L39:
        r128 = -1;
        goto L40
    L36:
        r127 = null;
        goto L37
    L32:
        r126 = null;
        goto L34
    L23:
        if ((r124 instanceof FrameLayout) == false) goto L26;
        r104 = true;
    L26:
        if (r104 == false) goto L29;
        ViewGroup r133 = r124;
        List<CreateMenuV2.l> r134 = r510.K(r102, false, null, r116, r117, r115, r118, r119, r120);
        r510.D(r133, r122, r114);
        r510.L(r134);
        r133.requestLayout();
        r133.invalidate();
        r510.n();
        r130 = r133;
        goto L54
    L20:
        r124 = null;
        goto L21
    }

    public final Triple<View, Integer, Integer> n(View r100, int r101, int r110) {
        View r102 = this.f308273a.f468770c.getRootView();
        if (r102.isAttachedToWindow() == true) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 != null) goto L14;
        return null;
    L14:
        int[] r104 = new int[2];
        r100.getLocationOnScreen(r104);
        int[] r105 = new int[2];
        r102.getLocationOnScreen(r105);
        return new Triple(r102, Integer.valueOf((r104[0] - r105[0]) + r101), Integer.valueOf((((r104[1] + r100.getHeight()) - r105[1]) - r102.getHeight()) + r110));
    L5:
        if (r102.getWindowToken() == null) goto L7;
        r103 = true;
        goto L9
    }

    public final void p(Balloon r100, View r101, boolean r102) {
        if (r102 == false) goto L4;
        PopupShowMethod r103 = this.f308285m;
    L5:
        a r104 = l(r101, r101.getMeasuredWidth(), r101.getMeasuredHeight(), r103);
        if (r102 == false) goto L8;
        this.f308285m = r104.f308294a;
    L8:
        q(r100, this.f308273a.f468772e, r104.f308297d, r104.f308298e);
        return;
    L4:
        r103 = null;
        goto L5
    }

    public final boolean r(q.a r110, View r111, boolean r112) {
        di8.n0 r100 = r110.f308356c.getSubMenu();
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = com.larus.bmhome.chat.nestedmenu.ui.a.f308317a;
        int r102 = this.f308273a.f468774g.f468818j;
        LinkedHashMap<String, List<d0>> r103 = r110.f308355b;
        Intrinsics.checkNotNullParameter(r100, "subMenu");
        LinkedHashMap<String, List<d0>> r104 = new LinkedHashMap();
        Iterator<T> r105 = r100.f468808b.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        String r106 = (String) r105.next();
        List<d0> r107 = r100.f468807a.get(r106);
        if (r107 == null) goto L7;
        r104.put(r106, r107);
        goto L7
    L11:
        Iterator<Map.Entry<String, List<d0>>> r108 = r100.f468807a.entrySet().iterator();
    L13:
        if (r108.hasNext() == false) goto L17;
        Map.Entry<String, List<d0>> r109 = r108.next();
        String r113 = r109.getKey();
        List<d0> r114 = r109.getValue();
        if (r104.containsKey(r113) == true) goto L13;
        r104.put(r113, r114);
        goto L13
    L17:
        if (r103 != null) goto L19;
        r103 = r104;
    L19:
        List<? extends q> r115 = com.larus.bmhome.chat.nestedmenu.ui.a.a(r104, r102, r103);
        if (((ArrayList) r115).isEmpty() == false) goto L23;
        return false;
    L23:
        if (this.f308273a.f468768a != NestedMenuScene.SETTINGS) goto L25;
        boolean r116 = true;
    L26:
        c r117 = e(this, r115, false, r116, null, 20);
        CreateMenuV2 r118 = r117.f308301a;
        CreateMenuV2 r119 = this.f308281i;
        if (r119 == null) goto L32;
        int r120 = r119.getCurrentMenuWidth();
        int r121 = r118.getCurrentMenuWidth();
        if (r121 != r120) goto L32;
        r118.setMenuWidth(r121 + i5.c());
    L32:
        final int r122 = this.f308284l + 1;
        this.f308284l = r122;
        Balloon r123 = this.f308280h;
        if (r123 == null) goto L35;
        r123.h();
    L35:
        String r124 = r110.f308354a;
        this.f308287o = r124;
        if (r112 == true) goto L38;
    L96:
        Balloon r125 = c(this, r117.f308302b, null, this.f308281i, new o(this), new com.larus.bmhome.chat.nestedmenu.ui.c(this, r122), 2);
        View r126 = r117.f308302b;
        View r127 = this.f308273a.f468772e;
        if (r111.isAttachedToWindow() == true) goto L99;
    L120:
        p(r125, r126, false);
    L121:
        this.f308280h = r125;
        CreateMenuV2 r128 = this.f308281i;
        if (r128 == null) goto L124;
        r128.H(true, new com.larus.bmhome.chat.nestedmenu.ui.d(this));
    L124:
        this.f308277e.invoke(r115);
        return true;
    L99:
        if (r127.isAttachedToWindow() == false) goto L120;
        r126.measure(0, 0);
        int[] r129 = new int[2];
        int[] r130 = new int[2];
        r111.getLocationOnScreen(r129);
        r127.getLocationOnScreen(r130);
        Function1<View, Integer> r131 = this.f308273a.f468774g.f468825q;
        if (r131 == null) goto L104;
        int r132 = r131.invoke(r126).intValue();
    L105:
        View r133 = this.f308282j;
        if (r133 != null) goto L108;
    L115:
        int r134 = (r129[1] - r130[1]) + r126.getPaddingBottom();
        if (r127.getResources().getConfiguration().getLayoutDirection() != 1) goto L118;
        int r135 = -1;
    L119:
        q(r125, r127, r135 * (((r127.getMeasuredWidth() / 2) - (r126.getMeasuredWidth() / 2)) + r132), ((-r126.getMeasuredHeight()) - r127.getMeasuredHeight()) + r134);
        goto L121
    L118:
        r135 = 1;
        goto L119
    L108:
        if (r133.isAttachedToWindow() == false) goto L115;
        if (r133.getWidth() <= 0) goto L115;
        if (r126.getMeasuredWidth() <= 0) goto L115;
        int[] r136 = new int[2];
        r127.getLocationOnScreen(r136);
        int[] r137 = new int[2];
        r133.getLocationOnScreen(r137);
        r132 = (r137[0] + (r126.getMeasuredWidth() / 2)) - (r136[0] + (r127.getWidth() / 2));
        goto L115
    L104:
        r132 = 0;
        goto L105
    L38:
        if (Intrinsics.areEqual(r124, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL) == false) goto L96;
        di8.n0 r138 = r110.f308356c.getSubMenu();
        if (r138 == null) goto L96;
        List<d0> r139 = r138.f468807a.get(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r139 != null) goto L46;
        r139 = CollectionsKt.emptyList();
    L46:
        ArrayList r140 = new ArrayList();
        Iterator<T> r141 = r139.iterator();
    L47:
        com.larus.bmhome.chat.nestedmenu.b.C4065b r142 = null;
        if (r141.hasNext() == false) goto L61;
        Object r143 = r141.next();
        f0 r144 = ((d0) r143).c();
        if ((r144 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L52;
        com.larus.bmhome.chat.nestedmenu.b r145 = (com.larus.bmhome.chat.nestedmenu.b) r144;
    L53:
        if (r145 == null) goto L55;
        r142 = r145.f308229a;
    L55:
        if (r142 == null) goto L57;
        boolean r146 = true;
    L58:
        if (r146 == false) goto L47;
        r140.add(r143);
        goto L47
    L57:
        r146 = false;
        goto L58
    L52:
        r145 = null;
        goto L53
    L61:
        if (r140.isEmpty() == true) goto L96;
        List<d0> r147 = r110.f308355b.get(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r147 != null) goto L66;
        r147 = CollectionsKt.emptyList();
    L66:
        List<d0> r148 = r147;
        if ((r148 instanceof Collection) == true) goto L69;
    L71:
        Iterator<T> r149 = r148.iterator();
        int r150 = 0;
    L73:
        if (r149.hasNext() == false) goto L88;
        f0 r151 = ((d0) r149.next()).c();
        if ((r151 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L77;
        com.larus.bmhome.chat.nestedmenu.b r152 = (com.larus.bmhome.chat.nestedmenu.b) r151;
    L78:
        if (r152 == null) goto L80;
        com.larus.bmhome.chat.nestedmenu.b.C4065b r153 = r152.f308229a;
    L81:
        if (r153 == null) goto L83;
        boolean r154 = true;
    L84:
        if (r154 == false) goto L73;
        r150 = r150 + 1;
        if (r150 >= 0) goto L73;
        CollectionsKt.throwCountOverflow();
        goto L73
    L83:
        r154 = false;
        goto L84
    L80:
        r153 = null;
        goto L81
    L77:
        r152 = null;
    L88:
        NestedMenuScene r155 = this.f308273a.f468768a;
        NestedMenuScene r156 = NestedMenuScene.SETTINGS;
        String r157 = "setting";
        if (r155 != r156) goto L91;
        String r158 = "setting";
    L92:
        if (r155 == r156) goto L95;
        r157 = "action_bar_model_selector";
    L95:
        int r159 = r140.size();
        JSONObject r160 = new JSONObject();
        Intrinsics.checkNotNullParameter(r158, "currentPage");
        Intrinsics.checkNotNullParameter(r157, "menuEntry");
        Intrinsics.checkNotNullParameter(r160, "params");
        r160.put("current_page", r158);
        r160.put("menu_entry", r157);
        r160.put("folded_model_count", r159);
        r160.put("max_visible_model_count", r150);
        TrackParams r161 = new TrackParams().merge(r160);
        by7.a r162 = new by7.a("model_selector_more_click");
        r162.f21463a.merge(r161);
        r162.b();
        goto L96
    L91:
        r158 = "chat";
        goto L92
    L69:
        if (r148.isEmpty() == false) goto L71;
        r150 = 0;
        goto L88
    L25:
        r116 = false;
        goto L26
    }

    public final a l(View r210, int r211, int r212, PopupShowMethod r213) {
        int r100 = 0;
        r210.measure(0, 0);
        View r101 = this.f308273a.f468772e;
        int[] r102 = new int[2];
        r101.getLocationOnScreen(r102);
        Integer r103 = Integer.valueOf(r211);
        if (r103.intValue() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L11;
        int r105 = r103.intValue();
    L12:
        Integer r106 = Integer.valueOf(r212);
        if (r106.intValue() <= 0) goto L15;
        boolean r110 = true;
    L16:
        if (r110 == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L21;
        int r107 = r106.intValue();
    L23:
        if (r101.getResources().getConfiguration().getLayoutDirection() != 1) goto L25;
        int r111 = -1;
    L26:
        o0 r112 = this.f308273a.f468774g;
        View r113 = r112.f468827s;
        NestedMenuPopupStrategy r114 = r112.f468824p;
        NestedMenuPopupStrategy r115 = NestedMenuPopupStrategy.ALIGN_TOP;
        if (r114 != r115) goto L113;
        if (r113 == null) goto L113;
        if (r113.isAttachedToWindow() == false) goto L113;
        if (r101.isAttachedToWindow() == false) goto L113;
        if (this.f308273a.f468774g.f468830v == false) goto L71;
        Rect r108 = new Rect();
        boolean r116 = f(r113, r108);
        int r109 = r108.bottom;
        CreateMenuV2 r117 = this.f308281i;
        if (r117 == null) goto L46;
        Integer r118 = Integer.valueOf(r117.getMeasuredHeight());
        if (r118.intValue() <= 0) goto L40;
        boolean r119 = true;
    L41:
        if (r119 == true) goto L44;
        r118 = null;
    L44:
        if (r118 == null) goto L46;
        int r120 = r118.intValue();
    L47:
        int r121 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(com.larus.utils.i.c(r101.getContext()) - r109, r120 / 2), 0);
        Rect r122 = new Rect();
        if (r116 == true) goto L50;
    L68:
        int r123 = r113.getBottom() + r121;
    L69:
        int r214 = r123;
        int r124 = -i5.e0();
        return new a(PopupShowMethod.ALIGN_TOP, r124, r214, r111 * (((r101.getMeasuredWidth() / 2) - (r105 / 2)) + r124), ((-r107) - r101.getMeasuredHeight()) + r214);
    L50:
        if (f(this.f308273a.f468771d, r122) == false) goto L68;
        b r125 = this.f308289q;
        if (r125 == null) goto L54;
        PopupVerticalSide r126 = r125.f308299a;
    L55:
        if (r126 != null) goto L57;
        int r127 = -1;
    L58:
        if (r127 == (-1)) goto L66;
        if (r127 != 1) goto L61;
        int r128 = r109 - r120;
    L67:
        r123 = ((r128 - r102[1]) + r107) - r210.getPaddingTop();
        goto L69
    L61:
        if (r127 == 2) goto L66;
        throw new NoWhenBranchMatchedException();
    L66:
        r128 = r122.bottom;
        goto L67
    L57:
        r127 = d.f308303a[r126.ordinal()];
        goto L58
    L54:
        r126 = null;
        goto L55
    L40:
        r119 = false;
    L46:
        r120 = RangesKt.coerceAtLeast((r107 - r210.getPaddingTop()) - r210.getPaddingBottom(), 0);
        goto L47
    L71:
        Rect r129 = m(r101);
        Rect r130 = new Rect();
        Rect r131 = new Rect();
        if (r129.isEmpty() == true) goto L113;
        if (r101.getGlobalVisibleRect(r130) == false) goto L113;
        if (r113.getGlobalVisibleRect(r131) == false) goto L113;
        int r132 = r210.getPaddingLeft();
        int r133 = r210.getPaddingTop();
        int r134 = RangesKt.coerceAtLeast(r105 - r210.getPaddingRight(), r132);
        int r135 = r134 - r132;
        int r136 = RangesKt.coerceAtLeast(r107 - r210.getPaddingBottom(), r133) - r133;
        o0 r137 = this.f308273a.f468774g;
        if (r137.f468830v == false) goto L81;
        int r138 = r131.right - r135;
    L84:
        int r139 = r129.left;
        int r140 = r105 / 2;
        int r215 = ((RangesKt.coerceIn(r138, r139, RangesKt.coerceAtLeast(r129.right - r135, r139)) - r130.centerX()) + r140) - r132;
        int r141 = RangesKt.coerceAtLeast(r129.bottom - r130.bottom, 0);
        int r142 = RangesKt.coerceAtLeast(r130.top - r129.top, 0);
        b r143 = this.f308289q;
        if (r143 == null) goto L87;
        PopupVerticalSide r144 = r143.f308299a;
    L88:
        if (r144 != null) goto L90;
        int r145 = -1;
    L92:
        if (r145 == (-1)) goto L102;
        if (r145 != 1) goto L96;
        int r146 = r130.top;
    L109:
        int r147 = r146 - r136;
    L111:
        int r216 = ((r147 - r130.top) + r107) - r133;
        return new a(PopupShowMethod.ALIGN_TOP, r215, r216, r111 * (((r101.getMeasuredWidth() / 2) - r140) + r215), ((-r107) - r101.getMeasuredHeight()) + r216);
    L96:
        if (r145 != 2) goto L99;
        r147 = r130.bottom;
        goto L111
    L99:
        throw new NoWhenBranchMatchedException();
    L102:
        if ((r210.getPaddingBottom() + r136) > r141) goto L105;
        r147 = r130.bottom;
        goto L111
    L105:
        if ((r136 + r133) > r142) goto L107;
        r146 = r130.top;
        goto L109
    L107:
        if (r141 < r142) goto L110;
        r146 = r129.bottom - r210.getPaddingBottom();
        goto L109
    L110:
        r147 = r129.top + r133;
        goto L111
    L90:
        r145 = d.f308303a[r144.ordinal()];
        goto L92
    L87:
        r144 = null;
        goto L88
    L81:
        if (r137.f468829u == false) goto L83;
        r138 = r131.left;
        goto L84
    L83:
        r138 = r131.centerX() - (r135 / 2);
    L113:
        Function1<View, Integer> r148 = this.f308273a.f468774g.f468825q;
        if (r148 == null) goto L116;
        r100 = r148.invoke(r210).intValue();
    L116:
        Function0<Integer> r149 = this.f308273a.f468774g.f468826r;
        if (r149 == null) goto L119;
        int r150 = r149.invoke().intValue();
    L120:
        int r217 = r100;
        int r218 = r150;
        a r151 = new a(PopupShowMethod.ALIGN_TOP, r217, r218, r111 * (((r101.getMeasuredWidth() / 2) - (r105 / 2)) + r100), ((-r107) - r101.getMeasuredHeight()) + r150);
        NestedMenuPopupStrategy r152 = this.f308273a.f468774g.f468824p;
        if (r152 != r115) goto L124;
        return r151;
    L124:
        if (r152 != NestedMenuPopupStrategy.DROP_DOWN) goto L127;
        int r219 = r100;
        int r220 = r150;
        int r221 = r100;
        return new a(PopupShowMethod.DROP_DOWN, r219, r220, r221, -r150);
    L127:
        if (r213 == null) goto L132;
        PopupShowMethod r153 = PopupShowMethod.DROP_DOWN;
        if (r213 != r153) goto L137;
        int r222 = r100;
        int r223 = r150;
        int r224 = r100;
        return new a(r153, r222, r223, r224, -r150);
    L137:
        return r151;
    L132:
        int r154 = r210.getMeasuredHeight();
        Resources r155 = r101.getResources();
        int r156 = WindowDisplayMetricsOverride.apply(r155, r155.getDisplayMetrics()).heightPixels;
        int r157 = r102[1];
        int r158 = r156 - (r101.getHeight() + r157);
        if (r158 >= (r154 + r150)) goto L135;
        if (r158 >= r157) goto L135;
        return r151;
    L135:
        int r225 = r100;
        int r226 = r150;
        int r227 = r100;
        return new a(PopupShowMethod.DROP_DOWN, r225, r226, r227, -r150);
    L119:
        r150 = i5.E();
        goto L120
    L25:
        r111 = 1;
        goto L26
    L21:
        r107 = r210.getMeasuredHeight();
        goto L23
    L15:
        r110 = false;
        goto L16
    L11:
        r105 = r210.getMeasuredWidth();
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    public final void q(Balloon r100, View r101, int r102, int r103) {
        Triple<View, Integer, Integer> r104 = n(r101, r102, r103);
        if (r104 != null) goto L5;
        return;
    L5:
        r100.x(r104.getFirst(), r104.getSecond().intValue(), r104.getThird().intValue());
    }

    public NestedMenuPopup(c0 r100, List r101, di8.i0 r102, j0 r103, k0 r104, di8.l0 r105) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "nodes");
        Intrinsics.checkNotNullParameter(r102, "onItemClick");
        Intrinsics.checkNotNullParameter(r103, "onUnEnableClick");
        Intrinsics.checkNotNullParameter(r104, "onNodesShown");
        Intrinsics.checkNotNullParameter(r105, "onDismiss");
        this.f308273a = r100;
        this.f308274b = r101;
        this.f308275c = r102;
        this.f308276d = r103;
        this.f308277e = r104;
        this.f308278f = r105;
        if (Intrinsics.areEqual(r100.f468769b, "fork_conv") == false) goto L15;
        o0 r106 = r100.f468774g;
        if (r106.f468824p != NestedMenuPopupStrategy.ALIGN_TOP) goto L15;
        if (r106.f468827s == null) goto L15;
        if (r106.f468830v == false) goto L11;
    L14:
        boolean r107 = true;
    L16:
        this.f308288p = r107;
        return;
    L11:
        if (r106.f468816h == null) goto L15;
        if (r106.f468829u == true) goto L14;
    L15:
        r107 = false;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [com.larus.bmhome.chat.nestedmenu.ui.l] */
    public static c e(final NestedMenuPopup r510, List r511, boolean r512, boolean r513, Integer r514, int r515) {
        if ((r515 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r515 & 16) == 0) goto L9;
        Integer r110 = r510.f308273a.f468774g.f468821m;
    L10:
        r510.getClass();
        CreateMenuV2 r101 = new CreateMenuV2(r510.f308273a.f468770c.getContext());
        final LinkedHashMap r102 = new LinkedHashMap();
        List r103 = r511;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
        int r111 = 0;
    L12:
        if (r105.hasNext() == false) goto L25;
        Object r106 = r105.next();
        int r107 = r111 + 1;
        if (r111 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        q r108 = (q) r106;
        if ((r108 instanceof q.a) == false) goto L20;
        r102.put(Integer.valueOf(r111), r108);
        l0 r109 = l0.b(((q.a) r108).f308357d, r111, null, false, -2);
    L22:
        r104.add(r109);
        r111 = r107;
        goto L12
    L20:
        if ((r108 instanceof q.b) == false) goto L24;
        r109 = new l0(r111, 0, null, null, null, null, null, null, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, MenuItemType.SECTION_DIVIDER, null, null, null, null, null, null, null, Integer.valueOf(((q.b) r108).f308358a), null, null, null, null, false, -33554434, 125);
        goto L22
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        o0 r112 = r510.f308273a.f468774g;
        int r113 = r112.f468819k;
        int r114 = r112.f468820l;
        CreateMenu.a.C4119a r115 = r510.d();
        View r116 = CreateMenuV2.C(r101, r104, 0, r512, Integer.valueOf(r113), Integer.valueOf(r114), r110, r115, new l(r102, r510), new m(r102, r510), new n(r102, r510), 26);
        if (r100 == false) goto L32;
        o0 r117 = r510.f308273a.f468774g;
        if (r117.f468822n == false) goto L32;
        Function1<View, Unit> r118 = r117.f468823o;
        if (r118 == null) goto L32;
        r118.invoke(r116);
    L32:
        r510.a(r116);
        return new c(r101, r116);
    L9:
        r110 = r514;
        goto L10
    L5:
        r100 = r513;
        goto L7
    }

    public static Balloon c(final NestedMenuPopup r100, View r110, View r111, CreateMenuV2 r112, Function0 r113, Function0 r114, int r115) {
        if ((r115 & 2) == 0) goto L5;
        r111 = r100.f308273a.f468772e;
    L5:
        View r116 = r112;
        if ((r115 & 4) == 0) goto L8;
        r116 = r100.f308273a.f468774g.f468827s;
    L8:
        final View r101 = r116;
        if ((r115 & 8) == 0) goto L11;
        r113 = null;
    L11:
        final Function0 r102 = r113;
        Boolean r117 = r100.f308273a.f468774g.f468833y;
        if (r117 == null) goto L14;
        boolean r118 = r117.booleanValue();
    L15:
        com.larus.bmhome.view.screenmenu.d r119 = com.larus.bmhome.view.screenmenu.d.f317270a;
        final boolean r103 = r118;
        final View r104 = r111;
        Function1 r105 = new e(r100, r103, r102, r101, r104);
        return com.larus.bmhome.view.screenmenu.d.a(r119, r111, r110, r118, null, r105, null, r114, 40);
    L14:
        r118 = nda.d.a().sa();
        goto L15
    }
}
