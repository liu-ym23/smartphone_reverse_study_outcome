package yc9;

import com.larus.im.bean.message.MsgFeedbackType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f567264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f567265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MsgFeedbackType f567266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f567267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f567268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f567269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f567270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f567271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f567272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f567273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Integer f567274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f567275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f567276m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f567264a, r101.f567264a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f567265b, r101.f567265b) == true) goto L15;
        return false;
    L15:
        if (this.f567266c == r101.f567266c) goto L18;
        return false;
    L18:
        if (this.f567267d == r101.f567267d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f567268e, r101.f567268e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f567269f, r101.f567269f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f567270g, r101.f567270g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f567271h, r101.f567271h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f567272i, r101.f567272i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f567273j, r101.f567273j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f567274k, r101.f567274k) == true) goto L42;
        return false;
    L42:
        if (this.f567275l == r101.f567275l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f567276m, r101.f567276m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f567264a.hashCode() * 31) + this.f567265b.hashCode()) * 31) + this.f567266c.hashCode()) * 31) + this.f567267d) * 31;
        List<Integer> r101 = this.f567268e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f567269f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f567270g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f567271h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f567272i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f567273j;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Integer r120 = this.f567274k;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        if (this.f567275l == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (r122 + r123) * 31;
        String r125 = this.f567276m;
        if (r125 == null) goto L39;
        r102 = r125.hashCode();
    L39:
        return r124 + r102;
    L33:
        r123 = 1237;
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
        return "FeedbackMessageRequest(conversationId=" + this.f567264a + ", messageId=" + this.f567265b + ", feedbackType=" + this.f567266c + ", feedbackDislikeDetailType=" + this.f567267d + ", feedbackDislikeDetailTypes=" + this.f567268e + ", feedbackDetailContent=" + this.f567269f + ", feedbackSource=" + this.f567270g + ", scene=" + this.f567271h + ", entityId=" + this.f567272i + ", entityType=" + this.f567273j + ", conversationType=" + this.f567274k + ", skipCheckLocalMessage=" + this.f567275l + ", extra=" + this.f567276m + ')';
    }

    public static m a(m r110, List r111) {
        String r100 = r110.f567264a;
        String r101 = r110.f567265b;
        MsgFeedbackType r102 = r110.f567266c;
        int r103 = r110.f567267d;
        String r104 = r110.f567269f;
        Integer r105 = r110.f567270g;
        String r106 = r110.f567271h;
        String r107 = r110.f567272i;
        String r112 = r110.f567273j;
        Integer r113 = r110.f567274k;
        boolean r114 = r110.f567275l;
        String r115 = r110.f567276m;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "feedbackType");
        return new m(r100, r101, r102, r103, r111, r104, r105, r106, r107, r112, r113, r114, r115);
    }

    public m(String r100, String r101, MsgFeedbackType r102, int r103, List<Integer> r104, String r105, Integer r106, String r107, String r110, String r111, Integer r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "feedbackType");
        this.f567264a = r100;
        this.f567265b = r101;
        this.f567266c = r102;
        this.f567267d = r103;
        this.f567268e = r104;
        this.f567269f = r105;
        this.f567270g = r106;
        this.f567271h = r107;
        this.f567272i = r110;
        this.f567273j = r111;
        this.f567274k = r112;
        this.f567275l = r113;
        this.f567276m = r114;
    }

    public /* synthetic */ m(String r110, String r111, MsgFeedbackType r112, int r210, List r211, String r212, Integer r213, String r214, String r215, String r216, Integer r217, boolean r218, String r219, int r310) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r310 & 4) == 0) goto L9;
        MsgFeedbackType r101 = MsgFeedbackType.MsgFeedbackTypeDefault;
    L11:
        if ((r310 & 8) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r310 & 16) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r310 & 32) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r310 & 64) == 0) goto L25;
        Integer r105 = 0;
    L27:
        if ((r310 & 128) == 0) goto L29;
        String r113 = null;
    L31:
        if ((r310 & 256) == 0) goto L33;
        String r114 = null;
    L35:
        if ((r310 & 512) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r310 & 1024) == 0) goto L41;
        Integer r116 = null;
    L43:
        if ((r310 & 2048) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r310 & 4096) == 0) goto L49;
        String r118 = null;
    L50:
        this(r100, r111, r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118);
        return;
    L49:
        r118 = r219;
        goto L50
    L45:
        r117 = r218;
        goto L47
    L41:
        r116 = r217;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
