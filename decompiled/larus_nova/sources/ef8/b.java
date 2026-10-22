package ef8;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.helper.PopMenuPanelTrigger;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f472530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0.a f472531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q0 f472532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final by7.e f472533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Long> f472534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final df8.a f472535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SearchImageInfo f472536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CustomMarkdownTextView f472537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f472538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AiGenVideoContentData f472539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final UplinkFileEntity f472540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f472541l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f472530a, r101.f472530a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472531b, r101.f472531b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f472532c, r101.f472532c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f472533d, r101.f472533d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f472534e, r101.f472534e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f472535f, r101.f472535f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f472536g, r101.f472536g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f472537h, r101.f472537h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f472538i, r101.f472538i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f472539j, r101.f472539j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f472540k, r101.f472540k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f472541l, r101.f472541l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f472530a.hashCode() * 31;
        q0.a r101 = this.f472531b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        q0 r105 = this.f472532c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        by7.e r108 = this.f472533d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Function0<Long> r111 = this.f472534e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        df8.a r114 = this.f472535f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        SearchImageInfo r117 = this.f472536g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        CustomMarkdownTextView r120 = this.f472537h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        a r123 = this.f472538i;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        AiGenVideoContentData r126 = this.f472539j;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        UplinkFileEntity r129 = this.f472540k;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        JSONObject r132 = this.f472541l;
        if (r132 == null) goto L47;
        r102 = r132.hashCode();
    L47:
        return r131 + r102;
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
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
        return "MenuContext(data=" + this.f472530a + ", modelProvider=" + this.f472531b + ", adapter=" + this.f472532c + ", trackNode=" + this.f472533d + ", getChatUniqueKey=" + this.f472534e + ", imageItemInfo=" + this.f472535f + ", awemeImageItem=" + this.f472536g + ", markdownView=" + this.f472537h + ", groupAbility=" + this.f472538i + ", videoInfo=" + this.f472539j + ", attachmentEntity=" + this.f472540k + ", extraParams=" + this.f472541l + ')';
    }

    public final BotModel a() {
        q0.a r100 = this.f472531b;
        if (r100 == null) goto L7;
        y r101 = r100.u0();
        if (r101 == null) goto L7;
        return r101.j0();
    L7:
        return null;
    }

    public final long b() {
        Function0<Long> r100 = this.f472534e;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.invoke().longValue();
    }

    public final wc9.e c() {
        q0.a r100 = this.f472531b;
        if (r100 == null) goto L7;
        y r101 = r100.u0();
        if (r101 == null) goto L7;
        return r101.h();
    L7:
        return null;
    }

    public /* synthetic */ b(Message r110, q0.a r111, q0 r112, by7.e r210, Function0 r211, df8.a r212, SearchImageInfo r213, PopMenuPanelTrigger.c r214, AiGenVideoContentData r215, UplinkFileEntity r216, JSONObject r217, int r218) {
        if ((r218 & 8) == 0) goto L5;
        by7.e r100 = null;
    L7:
        if ((r218 & 16) == 0) goto L9;
        Function0 r101 = null;
    L11:
        if ((r218 & 32) == 0) goto L13;
        df8.a r102 = null;
    L15:
        if ((r218 & 64) == 0) goto L17;
        SearchImageInfo r113 = null;
    L19:
        if ((r218 & 256) == 0) goto L21;
        PopMenuPanelTrigger.c r114 = null;
    L23:
        if ((r218 & 512) == 0) goto L25;
        AiGenVideoContentData r115 = null;
    L27:
        if ((r218 & 1024) == 0) goto L29;
        UplinkFileEntity r116 = null;
    L31:
        if ((r218 & 2048) == 0) goto L33;
        JSONObject r117 = null;
    L34:
        this(r110, r111, r112, r100, r101, r102, r113, null, r114, r115, r116, r117);
        return;
    L33:
        r117 = r217;
        goto L34
    L29:
        r116 = r216;
        goto L31
    L25:
        r115 = r215;
        goto L27
    L21:
        r114 = r214;
        goto L23
    L17:
        r113 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public b(Message r100, q0.a r101, q0 r102, by7.e r103, Function0<Long> r104, df8.a r105, SearchImageInfo r106, CustomMarkdownTextView r107, a r110, AiGenVideoContentData r111, UplinkFileEntity r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f472530a = r100;
        this.f472531b = r101;
        this.f472532c = r102;
        this.f472533d = r103;
        this.f472534e = r104;
        this.f472535f = r105;
        this.f472536g = r106;
        this.f472537h = r107;
        this.f472538i = r110;
        this.f472539j = r111;
        this.f472540k = r112;
        this.f472541l = r113;
    }
}
