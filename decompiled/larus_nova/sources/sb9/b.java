package sb9;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.s2;
import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.j0;
import com.larus.home.impl.main.side_bar.view.d2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.Message;
import com.larus.platform.exp.o;
import ic8.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uc9.b0;
import wc9.e;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f541260a = 0;

    static {
    }

    public b() {
    }

    public static boolean a(j0 r100, j0 r101) {
        boolean r102 = o.a();
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        SideBarItemType r103 = r100.f344506a;
        SideBarItemType r104 = SideBarItemType.CONVERSATION;
        if (r103 != r104) goto L195;
        if (r101.f344506a != r104) goto L195;
        wh8.a r105 = r100.f344507b;
        wh8.a r106 = r101.f344507b;
        if (r100.f344514i != r101.f344514i) goto L196;
        int r107 = s2.f308566a;
        Message r108 = null;
        if (r105 == null) goto L12;
        e r109 = r105.f559708a;
    L13:
        if (r106 == null) goto L15;
        e r110 = r106.f559708a;
    L16:
        if (r109 == null) goto L18;
        String r111 = r109.f559200c;
    L19:
        if (r110 == null) goto L21;
        String r112 = r110.f559200c;
    L23:
        if (Intrinsics.areEqual(r111, r112) == false) goto L197;
        if (r102 == false) goto L37;
        if (r105 == null) goto L29;
        e r113 = r105.f559708a;
        if (r113 == null) goto L29;
        Boolean r114 = r113.a();
    L30:
        if (r106 == null) goto L34;
        e r115 = r106.f559708a;
        if (r115 == null) goto L34;
        Boolean r116 = r115.a();
    L36:
        if (Intrinsics.areEqual(r114, r116) == true) goto L37;
        return false;
    L34:
        r116 = null;
    L29:
        r114 = null;
    L37:
        if (r105 == null) goto L39;
        e r117 = r105.f559708a;
    L40:
        if (r106 == null) goto L42;
        e r118 = r106.f559708a;
    L43:
        if (r117 == null) goto L45;
        Integer r119 = r117.f559202e;
    L46:
        if (r118 == null) goto L48;
        Integer r120 = r118.f559202e;
    L50:
        if (Intrinsics.areEqual(r119, r120) == false) goto L199;
        if (r105 == null) goto L53;
        e r121 = r105.f559708a;
    L54:
        if (r106 == null) goto L56;
        e r122 = r106.f559708a;
    L57:
        if (r121 == null) goto L59;
        Integer r123 = r121.f559210m;
    L60:
        if (r122 == null) goto L62;
        Integer r124 = r122.f559210m;
    L64:
        if (Intrinsics.areEqual(r123, r124) == false) goto L74;
        if (r121 == null) goto L67;
        Integer r125 = r121.f559209l;
    L68:
        if (r122 == null) goto L70;
        Integer r126 = r122.f559209l;
    L72:
        if (Intrinsics.areEqual(r125, r126) == false) goto L74;
        boolean r127 = true;
    L75:
        if (r127 == false) goto L200;
        if (r105 == null) goto L80;
        e r128 = r105.f559708a;
        if (r128 == null) goto L80;
        IconImage r129 = r128.f559199b;
    L81:
        if (r106 == null) goto L85;
        e r130 = r106.f559708a;
        if (r130 == null) goto L85;
        IconImage r131 = r130.f559199b;
    L87:
        if (s2.a(r129, r131) == false) goto L201;
        if (r105 == null) goto L90;
        IconImage r132 = r105.f559716i;
    L91:
        if (r106 == null) goto L93;
        IconImage r133 = r106.f559716i;
    L95:
        if (s2.a(r132, r133) == false) goto L202;
        if (r105 == null) goto L98;
        e r134 = r105.f559708a;
    L99:
        if (r106 == null) goto L101;
        e r135 = r106.f559708a;
    L103:
        if (n.x(r134, r135, r102) == false) goto L203;
        if (r105 == null) goto L106;
        BotModel r136 = r105.f559709b;
    L107:
        if (r106 == null) goto L109;
        BotModel r137 = r106.f559709b;
    L110:
        if (r137 == null) goto L117;
        if (r136 == null) goto L118;
        boolean r138 = Intrinsics.areEqual(r136.getBotId(), r137.getBotId());
        boolean r139 = !b0.a(r136.getTagList(), r137.getTagList());
        if (r138 == false) goto L118;
        if (r139 == true) goto L117;
    L118:
        boolean r140 = false;
    L119:
        if (r140 == false) goto L204;
        if (r105 == null) goto L122;
        BotModel r141 = r105.f559709b;
    L123:
        if (r106 == null) goto L125;
        BotModel r142 = r106.f559709b;
    L126:
        if (r142 == null) goto L133;
        if (r141 == null) goto L134;
        boolean r143 = Intrinsics.areEqual(r141.getBotStatus(), r142.getBotStatus());
        boolean r144 = Intrinsics.areEqual(r141.getBotRecommendStatus(), r142.getBotRecommendStatus());
        if (r143 == false) goto L134;
        if (r144 == true) goto L133;
    L134:
        boolean r145 = false;
    L135:
        if (r145 == false) goto L205;
        if (r105 == null) goto L138;
        Integer r146 = r105.f559717j;
    L139:
        if (r106 == null) goto L141;
        Integer r147 = r106.f559717j;
    L143:
        if (Intrinsics.areEqual(r146, r147) == false) goto L206;
        if (r105 == null) goto L146;
        Message r148 = r105.f559710c;
    L147:
        if (r106 == null) goto L149;
        r108 = r106.f559710c;
    L149:
        if (r148 != null) goto L152;
        if (r108 != null) goto L152;
    L190:
        boolean r149 = true;
    L192:
        if (r149 == false) goto L207;
        return true;
    L207:
        return false;
    L152:
        if (r148 == null) goto L191;
        if (r108 == null) goto L191;
        if (Intrinsics.areEqual(r148.getMessageId(), r108.getMessageId()) == false) goto L191;
        if (r148.getMessageStatus() != r108.getMessageStatus()) goto L191;
        if (r148.getMessageStatusLocal() != r108.getMessageStatusLocal()) goto L191;
        String r150 = r148.getConversationId();
        String r151 = r108.getConversationId();
        if (r150 != null) goto L164;
    L167:
        boolean r152 = true;
    L168:
        if (r152 == true) goto L172;
        d2 r153 = d2.f345076a;
        if (d2.a(r150) == null) goto L172;
        boolean r154 = true;
    L173:
        if (r151 != null) goto L175;
    L178:
        boolean r155 = true;
    L179:
        if (r155 == true) goto L183;
        d2 r156 = d2.f345076a;
        if (d2.a(r151) == null) goto L183;
        boolean r157 = true;
    L185:
        if (d.R(r148) != d.R(r108)) goto L188;
        if (r154 != r157) goto L188;
        boolean r158 = true;
    L189:
        if (r158 == false) goto L191;
    L188:
        r158 = false;
    L183:
        r157 = false;
        goto L185
    L175:
        if (StringsKt.isBlank(r151) == true) goto L178;
        r155 = false;
    L172:
        r154 = false;
        goto L173
    L164:
        if (StringsKt.isBlank(r150) == true) goto L167;
        r152 = false;
    L191:
        r149 = false;
        goto L192
    L146:
        r148 = null;
        goto L147
    L206:
        return false;
    L141:
        r147 = null;
        goto L143
    L138:
        r146 = null;
        goto L139
    L205:
        return false;
    L133:
        r145 = true;
        goto L135
    L125:
        r142 = null;
        goto L126
    L122:
        r141 = null;
        goto L123
    L204:
        return false;
    L117:
        r140 = true;
        goto L119
    L109:
        r137 = null;
        goto L110
    L106:
        r136 = null;
        goto L107
    L203:
        return false;
    L101:
        r135 = null;
        goto L103
    L98:
        r134 = null;
        goto L99
    L202:
        return false;
    L93:
        r133 = null;
        goto L95
    L90:
        r132 = null;
        goto L91
    L201:
        return false;
    L85:
        r131 = null;
    L80:
        r129 = null;
        goto L81
    L200:
        return false;
    L70:
        r126 = null;
        goto L72
    L67:
        r125 = null;
    L74:
        r127 = false;
        goto L75
    L62:
        r124 = null;
        goto L64
    L59:
        r123 = null;
        goto L60
    L56:
        r122 = null;
        goto L57
    L53:
        r121 = null;
        goto L54
    L199:
        return false;
    L48:
        r120 = null;
        goto L50
    L45:
        r119 = null;
        goto L46
    L42:
        r118 = null;
        goto L43
    L39:
        r117 = null;
        goto L40
    L197:
        return false;
    L21:
        r112 = null;
        goto L23
    L18:
        r111 = null;
        goto L19
    L15:
        r110 = null;
        goto L16
    L12:
        r109 = null;
        goto L13
    L196:
        return false;
    L195:
        return Intrinsics.areEqual(r100, r101);
    }

    public static boolean b(j0 r100, j0 r101) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        SideBarItemType r102 = r100.f344506a;
        SideBarItemType r103 = SideBarItemType.CONVERSATION;
        if (r102 != r103) goto L20;
        if (r101.f344506a != r103) goto L20;
        wh8.a r104 = r100.f344507b;
        String r105 = null;
        if (r104 == null) goto L11;
        e r106 = r104.f559708a;
        if (r106 == null) goto L11;
        String r107 = r106.f559198a;
    L12:
        wh8.a r108 = r101.f344507b;
        if (r108 == null) goto L18;
        e r109 = r108.f559708a;
        if (r109 == null) goto L18;
        r105 = r109.f559198a;
    L18:
        return Intrinsics.areEqual(r107, r105);
    L11:
        r107 = null;
    L20:
        if (r102 != r101.f344506a) goto L22;
        return true;
    L22:
        return false;
    }
}
