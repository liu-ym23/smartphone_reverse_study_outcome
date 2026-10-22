package di8;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.nestedmenu.NestedMenuScene;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedMenuScene f468768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f468770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f468771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f468772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z0 f468773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o0 f468774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f468775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<com.larus.bmhome.chat.nestedmenu.c, Unit> f468776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<com.larus.bmhome.chat.nestedmenu.c, Unit> f468777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f468778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ReplyOption f468779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final t1a.b f468780m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (this.f468768a == r101.f468768a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468769b, r101.f468769b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f468770c, r101.f468770c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468771d, r101.f468771d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f468772e, r101.f468772e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468773f, r101.f468773f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f468774g, r101.f468774g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f468775h, r101.f468775h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f468776i, r101.f468776i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f468777j, r101.f468777j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f468778k, r101.f468778k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f468779l, r101.f468779l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f468780m, r101.f468780m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f468768a.hashCode() * 31;
        String r101 = this.f468769b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((r100 + r103) * 31) + this.f468770c.hashCode()) * 31) + this.f468771d.hashCode()) * 31) + this.f468772e.hashCode()) * 31;
        z0 r105 = this.f468773f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((((r104 + r106) * 31) + this.f468774g.hashCode()) * 31) + this.f468775h.hashCode()) * 31) + this.f468776i.hashCode()) * 31;
        Function1<com.larus.bmhome.chat.nestedmenu.c, Unit> r108 = this.f468777j;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function0<Unit> r111 = this.f468778k;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        ReplyOption r114 = this.f468779l;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        t1a.b r117 = this.f468780m;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuConfig(scene=" + this.f468768a + ", enterFrom=" + this.f468769b + ", hostView=" + this.f468770c + ", sourceView=" + this.f468771d + ", popupHostView=" + this.f468772e + ", actionBarItem=" + this.f468773f + ", uiConfig=" + this.f468774g + ", sectionOrder=" + this.f468775h + ", onClick=" + this.f468776i + ", onUnEnableClick=" + this.f468777j + ", onPopupDismiss=" + this.f468778k + ", replyOption=" + this.f468779l + ", hostVContext=" + this.f468780m + ')';
    }

    public c0(NestedMenuScene r310, String r311, View r312, View r313, View r314, z0 r315, o0 r316, Function1 r317, Function1 r318, Function0 r319, ReplyOption r410, t1a.b r411, int r412) {
        if ((r412 & 16) == 0) goto L5;
        View r100 = r312;
    L7:
        if ((r412 & 64) == 0) goto L9;
        o0 r101 = new o0(false, false, null, false, null, 0, 0, false, null, null, null, null, null, null, false, false, null, null, null, 33554431);
    L11:
        if ((r412 & 128) == 0) goto L13;
        List<String> r110 = h0.f468793a;
    L15:
        if ((r412 & 512) == 0) goto L17;
        Function1 r111 = null;
    L19:
        if ((r412 & 1024) == 0) goto L21;
        Function0 r112 = null;
    L23:
        if ((r412 & 2048) == 0) goto L25;
        ReplyOption r113 = null;
    L27:
        if ((r412 & 4096) == 0) goto L29;
        t1a.b r114 = null;
    L30:
        this(r310, r311, r312, r313, r100, r315, r101, r110, r317, r111, r112, r113, r114);
        return;
    L29:
        r114 = r411;
        goto L30
    L25:
        r113 = r410;
        goto L27
    L21:
        r112 = r319;
        goto L23
    L17:
        r111 = r318;
        goto L19
    L13:
        r110 = null;
        goto L15
    L9:
        r101 = r316;
        goto L11
    L5:
        r100 = r314;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(NestedMenuScene r100, String r101, View r102, View r103, View r104, z0 r105, o0 r106, List<String> r107, Function1<? super com.larus.bmhome.chat.nestedmenu.c, Unit> r110, Function1<? super com.larus.bmhome.chat.nestedmenu.c, Unit> r111, Function0<Unit> r112, ReplyOption r113, t1a.b r114) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "hostView");
        Intrinsics.checkNotNullParameter(r103, "sourceView");
        Intrinsics.checkNotNullParameter(r104, "popupHostView");
        Intrinsics.checkNotNullParameter(r106, "uiConfig");
        Intrinsics.checkNotNullParameter(r107, "sectionOrder");
        Intrinsics.checkNotNullParameter(r110, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f468768a = r100;
        this.f468769b = r101;
        this.f468770c = r102;
        this.f468771d = r103;
        this.f468772e = r104;
        this.f468773f = r105;
        this.f468774g = r106;
        this.f468775h = r107;
        this.f468776i = r110;
        this.f468777j = r111;
        this.f468778k = r112;
        this.f468779l = r113;
        this.f468780m = r114;
    }
}
