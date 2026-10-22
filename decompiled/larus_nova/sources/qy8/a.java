package qy8;

import com.bytedance.applet.debugger.AppletDebuggerHostFragment;
import com.larus.bmhome.chat.g4;
import com.larus.chat.ChatTitleBarIcon;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f535204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f535205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f535206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f535207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f535208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<ChatTitleBarIcon> f535209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g4 f535210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f535211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f535212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f535213j;

    public a() {
        this(null, null, null, null, false, null, null, null, null, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f535204a, r101.f535204a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535205b, r101.f535205b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f535206c, r101.f535206c) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f535207d, r101.f535207d) == true) goto L30;
        return false;
    L30:
        if (this.f535208e == r101.f535208e) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(null, null) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f535209f, r101.f535209f) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f535210g, r101.f535210g) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f535211h, r101.f535211h) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f535212i, r101.f535212i) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f535213j, r101.f535213j) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f535204a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f r104 = this.f535205b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((r103 + r105) * 31) + 0) * 31) + 0) * 31) + 0) * 31;
        d r107 = this.f535206c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        b r110 = this.f535207d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f535208e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (((((r112 + r113) * 31) + 0) * 31) + 0) * 31;
        Set<ChatTitleBarIcon> r115 = this.f535209f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        g4 r118 = this.f535210g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Boolean r121 = this.f535211h;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Set<String> r124 = this.f535212i;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Boolean r127 = this.f535213j;
        if (r127 == null) goto L43;
        r101 = r127.hashCode();
    L43:
        return r126 + r101;
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatHostConfig(backInterceptor=" + this.f535204a + ", createSubCvsInterceptor=" + this.f535205b + ", conversationChangeListener=null, searchInterceptor=null, sideNavInterceptor=null, linkInterceptor=" + this.f535206c + ", artifactInterceptor=" + this.f535207d + ", enableMobilePreviewEnhancement=" + this.f535208e + ", pageSizeSlotProvider=null, titleBarIconAnimationProgressProvider=null, titleBarVisibleIcons=" + this.f535209f + ", titleBarConfig=" + this.f535210g + ", userPromptHoverEverytimeOverride=" + this.f535211h + ", bottomPanelVisibleItems=" + this.f535212i + ", imageSkipDownscaleOverride=" + this.f535213j + ')';
    }

    public a(c r100, AppletDebuggerHostFragment.d r101, d r102, b r103, boolean r104, Set r105, g4 r106, Boolean r110, Boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 32) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 64) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 128) == 0) goto L18;
        r104 = false;
    L18:
        if ((r112 & 1024) == 0) goto L21;
        r105 = null;
    L21:
        if ((r112 & 2048) == 0) goto L24;
        r106 = null;
    L24:
        if ((r112 & 4096) == 0) goto L27;
        r110 = null;
    L27:
        if ((r112 & 16384) == 0) goto L29;
        r111 = null;
    L29:
        this.f535204a = r100;
        this.f535205b = r101;
        this.f535206c = r102;
        this.f535207d = r103;
        this.f535208e = r104;
        this.f535209f = r105;
        this.f535210g = r106;
        this.f535211h = r110;
        this.f535212i = null;
        this.f535213j = r111;
    }
}
