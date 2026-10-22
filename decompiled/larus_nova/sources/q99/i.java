package q99;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.applet.aibridge.p;
import com.larus.bmhome.chat.component.list.l4;
import com.larus.bmhome.chat.component.list.n4;
import com.larus.bmhome.chat.component.list.o4;
import com.larus.bmhome.chat.component.list.s4;
import com.larus.bmhome.chat.component.list.t4;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f532152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f532153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f532154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f532155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<String> f532156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f532157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f532158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<LifecycleOwner> f532159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<FragmentManager> f532160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f532161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f532162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<String> f532163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f532164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Context> f532165n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function1<Message, Boolean> f532166o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function2<String, e, JSONObject> f532167p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o99.a f532168q;

    public i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f532152a, r101.f532152a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f532153b, r101.f532153b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f532154c, r101.f532154c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f532155d, r101.f532155d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f532156e, r101.f532156e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f532157f, r101.f532157f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f532158g, r101.f532158g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f532159h, r101.f532159h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f532160i, r101.f532160i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f532161j, r101.f532161j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f532162k, r101.f532162k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f532163l, r101.f532163l) == true) goto L45;
        return false;
    L45:
        if (this.f532164m == r101.f532164m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f532165n, r101.f532165n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f532166o, r101.f532166o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f532167p, r101.f532167p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f532168q, r101.f532168q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f532152a.hashCode() * 31) + this.f532153b.hashCode()) * 31;
        String r101 = this.f532154c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f532155d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function0<String> r108 = this.f532156e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((r107 + r109) * 31) + this.f532157f.hashCode()) * 31) + this.f532158g.hashCode()) * 31;
        Function0<LifecycleOwner> r111 = this.f532159h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Function0<FragmentManager> r114 = this.f532160i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        List<String> r117 = this.f532161j;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f532162k;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Function0<String> r123 = this.f532163l;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        if (this.f532164m == false) goto L37;
        int r126 = 1231;
    L38:
        int r127 = (r125 + r126) * 31;
        Function0<Context> r128 = this.f532165n;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (((((r127 + r129) * 31) + this.f532166o.hashCode()) * 31) + this.f532167p.hashCode()) * 31;
        o99.a r131 = this.f532168q;
        if (r131 == null) goto L47;
        r102 = r131.hashCode();
    L47:
        return r130 + r102;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = 1237;
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
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
        return "FlowFeedbackHost(pageKey=" + this.f532152a + ", businessScene=" + this.f532153b + ", conversationId=" + this.f532154c + ", callId=" + this.f532155d + ", currentSectionIdProvider=" + this.f532156e + ", activeChecker=" + this.f532157f + ", inputChecker=" + this.f532158g + ", lifecycleOwnerProvider=" + this.f532159h + ", fragmentManagerProvider=" + this.f532160i + ", popupDisplayPageNames=" + this.f532161j + ", popupNotificationBusiness=" + this.f532162k + ", popupAvatarUrlProvider=" + this.f532163l + ", dislikePanelDisableCopyButton=" + this.f532164m + ", contextProvider=" + this.f532165n + ", canShowLikeOrDislike=" + this.f532166o + ", mobParamsProvider=" + this.f532167p + ", feedbackListener=" + this.f532168q + ')';
    }

    public final String a() {
        Function0<String> r100 = this.f532156e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.invoke();
    }

    public final boolean b() {
        return this.f532157f.invoke().booleanValue();
    }

    public i(String r210, String r211, String r212, String r213, l4 r214, n4 r215, o4 r216, Function0 r217, Function0 r218, List r310, String r311, Function0 r312, s4 r313, t4 r314, Function2 r315, o99.a r316, int r317) {
        if ((r317 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r317 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r317 & 16) == 0) goto L13;
        l4 r102 = null;
    L15:
        if ((r317 & 32) == 0) goto L17;
        Function0<Boolean> r103 = new p();
    L19:
        if ((r317 & 64) == 0) goto L21;
        Function0<Boolean> r104 = new zb8.c();
    L23:
        if ((r317 & 128) == 0) goto L25;
        Function0 r110 = null;
    L27:
        if ((r317 & 256) == 0) goto L29;
        Function0 r111 = null;
    L31:
        if ((r317 & 512) == 0) goto L33;
        List r112 = null;
    L35:
        if ((r317 & 1024) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r317 & 2048) == 0) goto L41;
        Function0 r114 = null;
    L43:
        if ((r317 & 8192) == 0) goto L45;
        s4 r115 = null;
    L47:
        if ((r317 & 16384) == 0) goto L49;
        Function1<Message, Boolean> r105 = new g();
    L51:
        if ((r317 & 32768) == 0) goto L53;
        Function2 r116 = new h();
    L55:
        if ((r317 & 65536) == 0) goto L57;
        o99.a r117 = null;
    L58:
        Intrinsics.checkNotNullParameter(r210, "pageKey");
        Intrinsics.checkNotNullParameter(r211, "businessScene");
        Intrinsics.checkNotNullParameter(r103, "activeChecker");
        Intrinsics.checkNotNullParameter(r104, "inputChecker");
        Intrinsics.checkNotNullParameter(r105, "canShowLikeOrDislike");
        Intrinsics.checkNotNullParameter(r116, "mobParamsProvider");
        this.f532152a = r210;
        this.f532153b = r211;
        this.f532154c = r100;
        this.f532155d = r101;
        this.f532156e = r102;
        this.f532157f = r103;
        this.f532158g = r104;
        this.f532159h = r110;
        this.f532160i = r111;
        this.f532161j = r112;
        this.f532162k = r113;
        this.f532163l = r114;
        this.f532164m = false;
        this.f532165n = r115;
        this.f532166o = r105;
        this.f532167p = r116;
        this.f532168q = r117;
        return;
    L57:
        r117 = r316;
        goto L58
    L53:
        r116 = r315;
        goto L55
    L49:
        r105 = r314;
        goto L51
    L45:
        r115 = r313;
        goto L47
    L41:
        r114 = r312;
        goto L43
    L37:
        r113 = r311;
        goto L39
    L33:
        r112 = r310;
        goto L35
    L29:
        r111 = r218;
        goto L31
    L25:
        r110 = r217;
        goto L27
    L21:
        r104 = r216;
        goto L23
    L17:
        r103 = r215;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
