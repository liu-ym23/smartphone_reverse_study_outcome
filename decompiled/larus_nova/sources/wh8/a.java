package wh8;

import com.alipay.sdk.m.u.i;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.showcase.Case;
import com.larus.utils.p0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f559708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BotModel f559709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Message f559710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f559711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f559712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecommendFrom f559713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f559714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f559715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IconImage f559716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f559717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Case f559718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f559719l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f559708a, r101.f559708a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559709b, r101.f559709b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f559710c, r101.f559710c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f559711d, r101.f559711d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f559712e, r101.f559712e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f559713f, r101.f559713f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f559714g, r101.f559714g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f559715h, r101.f559715h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f559716i, r101.f559716i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f559717j, r101.f559717j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f559718k, r101.f559718k) == true) goto L42;
        return false;
    L42:
        if (this.f559719l == r101.f559719l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        e r100 = this.f559708a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        BotModel r104 = this.f559709b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Message r107 = this.f559710c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f559711d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f559712e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        RecommendFrom r116 = this.f559713f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f559714g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f559715h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        IconImage r125 = this.f559716i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f559717j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Case r131 = this.f559718k;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        int r132 = (r130 + r101) * 31;
        if (this.f559719l == false) goto L49;
        int r133 = 1231;
    L51:
        return r132 + r133;
    L49:
        r133 = 1237;
        goto L51
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
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
        return "ConversationData(conversation=" + this.f559708a + ", botModel=" + this.f559709b + ", message=" + this.f559710c + ", senderName=" + this.f559711d + ", requestId=" + this.f559712e + ", recommendFrom=" + this.f559713f + ", recommendBotType=" + this.f559714g + ", relatedCvsId=" + this.f559715h + ", secondIconImage=" + this.f559716i + ", loadMoreStatus=" + this.f559717j + ", caseData=" + this.f559718k + ", isLoadingFooter=" + this.f559719l + ')';
    }

    public final String b() {
        e r100 = this.f559708a;
        boolean r101 = false;
        if (r100 == null) goto L10;
        Integer r102 = r100.f559219v;
        if (r102 == null) goto L10;
        if (r102.intValue() != 6) goto L10;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L23;
        int r104 = p0.f375454a;
        String r105 = p0.a(this.f559708a.f559200c);
        if (r105 == null) goto L16;
        return r105;
    L16:
        BotModel r106 = this.f559709b;
        if (r106 == null) goto L19;
        String r107 = r106.getName();
    L20:
        String r108 = p0.a(r107);
        if (r108 == null) goto L23;
        return r108;
    L19:
        r107 = null;
    L23:
        BotModel r109 = this.f559709b;
        if (r109 == null) goto L31;
        Integer r110 = r109.getBotType();
        if (r110 == null) goto L31;
        if (r110.intValue() != 4) goto L31;
        r101 = true;
    L31:
        if (r101 == false) goto L39;
        int r111 = p0.f375454a;
        BotModel r112 = this.f559709b;
        if (r112 == null) goto L35;
        String r113 = r112.getName();
    L36:
        String r114 = p0.a(r113);
        if (r114 == null) goto L39;
        return r114;
    L35:
        r113 = null;
    L39:
        return null;
    L10:
        r103 = false;
        goto L12
    }

    public final boolean c() {
        e r100 = this.f559708a;
        if (r100 == null) goto L10;
        Integer r101 = r100.f559219v;
        if (r101 == null) goto L10;
        if (r101.intValue() != 6) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L25;
        BotModel r103 = this.f559709b;
        if (r103 == null) goto L20;
        Integer r104 = r103.getBotType();
        if (r104 == null) goto L20;
        if (r104.intValue() != 4) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L26;
        return false;
    L26:
        return true;
    L20:
        r105 = false;
        goto L21
    L25:
        return true;
    L10:
        r102 = false;
        goto L11
    }

    public final String d() {
        StringBuilder r100 = new StringBuilder("ConversationData{");
        e r101 = this.f559708a;
        Long r102 = null;
        if (r101 == null) goto L10;
        StringBuilder r103 = new StringBuilder("conv(");
        String r104 = r101.f559200c;
        if (r104 == null) goto L7;
        String r105 = StringsKt.take(r104, 4);
    L8:
        r103.append(r105);
        r103.append(",id=");
        r103.append(r101.f559198a);
        r103.append(",status=");
        r103.append(r101.f559217t);
        r103.append(",botType=");
        r103.append(r101.f559219v);
        r103.append(",type=");
        r103.append(r101.f559207j);
        r103.append(",badge=");
        r103.append(r101.f559209l);
        r103.append('_');
        r103.append(r101.f559210m);
        r103.append(",pin=");
        r103.append(r101.f559202e);
        r103.append(",updateTime=");
        r103.append(r101.f559201d);
        r103.append('_');
        r103.append(r101.f559218u);
        r103.append("), ");
        r100.append(r103.toString());
        goto L10
    L7:
        r105 = null;
    L10:
        if (this.f559709b == null) goto L25;
        StringBuilder r106 = new StringBuilder("bot(");
        BotModel r107 = this.f559709b;
        if (r107 == null) goto L14;
        String r108 = r107.getBotId();
    L15:
        r106.append(r108);
        r106.append('_');
        BotModel r109 = this.f559709b;
        if (r109 == null) goto L18;
        Integer r110 = r109.getBotType();
    L19:
        r106.append(r110);
        r106.append('_');
        BotModel r111 = this.f559709b;
        if (r111 == null) goto L22;
        Integer r112 = r111.getBotStatus();
    L23:
        r106.append(r112);
        r106.append("), ");
        r100.append(r106.toString());
        goto L25
    L22:
        r112 = null;
        goto L23
    L18:
        r110 = null;
        goto L19
    L14:
        r108 = null;
    L25:
        if (this.f559710c == null) goto L39;
        StringBuilder r113 = new StringBuilder("msg=(");
        Message r114 = this.f559710c;
        if (r114 == null) goto L29;
        String r115 = r114.getMessageId();
    L30:
        r113.append(r115);
        r113.append(',');
        Message r116 = this.f559710c;
        if (r116 == null) goto L33;
        Integer r117 = Integer.valueOf(r116.getMessageStatusLocal());
    L34:
        r113.append(r117);
        r113.append(',');
        Message r118 = this.f559710c;
        if (r118 == null) goto L37;
        r102 = Long.valueOf(r118.getCreateTime());
    L37:
        r113.append(r102);
        r113.append("), ");
        r100.append(r113.toString());
        goto L39
    L33:
        r117 = null;
        goto L34
    L29:
        r115 = null;
    L39:
        if (this.f559718k == null) goto L41;
        r100.append("caseData, ");
    L41:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public static a a(a r110, e r111, Message r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        e r100 = r110.f559708a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        BotModel r101 = r110.f559709b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Message r102 = r110.f559710c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r103 = r110.f559711d;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r104 = r110.f559712e;
    L23:
        if ((r113 & 32) == 0) goto L25;
        RecommendFrom r105 = r110.f559713f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        Integer r114 = r110.f559714g;
    L31:
        if ((r113 & 128) == 0) goto L33;
        String r115 = r110.f559715h;
    L35:
        if ((r113 & 256) == 0) goto L37;
        IconImage r116 = r110.f559716i;
    L39:
        if ((r113 & 512) == 0) goto L41;
        Integer r117 = r110.f559717j;
    L43:
        if ((r113 & 1024) == 0) goto L45;
        Case r118 = r110.f559718k;
    L47:
        if ((r113 & 2048) == 0) goto L49;
        boolean r119 = r110.f559719l;
    L50:
        r110.getClass();
        return new a(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, r118, r119);
    L49:
        r119 = false;
        goto L50
    L45:
        r118 = null;
        goto L47
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = null;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public a(e r100, BotModel r101, Message r102, String r103, String r104, RecommendFrom r105, Integer r106, String r107, IconImage r108, Integer r110, Case r111, boolean r112) {
        this.f559708a = r100;
        this.f559709b = r101;
        this.f559710c = r102;
        this.f559711d = r103;
        this.f559712e = r104;
        this.f559713f = r105;
        this.f559714g = r106;
        this.f559715h = r107;
        this.f559716i = r108;
        this.f559717j = r110;
        this.f559718k = r111;
        this.f559719l = r112;
    }

    public /* synthetic */ a(e r110, BotModel r111, Message r112, String r210, String r211, RecommendFrom r212, Integer r213, String r214, IconImage r215, Integer r216, Case r217, boolean r218, int r219) {
        if ((r219 & 2) == 0) goto L5;
        BotModel r100 = null;
    L7:
        if ((r219 & 4) == 0) goto L9;
        Message r101 = null;
    L11:
        if ((r219 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r219 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r219 & 32) == 0) goto L21;
        RecommendFrom r104 = null;
    L23:
        if ((r219 & 64) == 0) goto L25;
        Integer r113 = null;
    L27:
        if ((r219 & 128) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r219 & 256) == 0) goto L33;
        IconImage r115 = null;
    L35:
        if ((r219 & 512) == 0) goto L37;
        Integer r116 = null;
    L39:
        if ((r219 & 1024) == 0) goto L41;
        Case r117 = null;
    L43:
        if ((r219 & 2048) == 0) goto L45;
        boolean r118 = false;
    L46:
        this(r110, r100, r101, r102, r103, r104, r113, r114, r115, r116, r117, r118);
        return;
    L45:
        r118 = r218;
        goto L46
    L41:
        r117 = r217;
        goto L43
    L37:
        r116 = r216;
        goto L39
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
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
        r100 = r111;
        goto L7
    }
}
