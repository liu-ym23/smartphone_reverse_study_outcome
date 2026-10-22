package com.larus.home.impl.main.side_bar.view.group.render;

import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.auth.AuthConstants;
import com.larus.bmhome.chat.manager.ChatListScreenMenuManager;
import com.larus.home.impl.main.side_bar.data.ComponentTypeEnum;
import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.d1;
import com.larus.home.impl.main.side_bar.data.y0;
import com.larus.home.impl.main.side_bar.view.d2;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyScene;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.m2;
import tx9.o3;

/* JADX INFO: loaded from: classes29.dex */
public final class j0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f345649h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.b f345650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f345651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f345652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f345653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f345654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<String> f345655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<String> f345656g;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f345657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f345658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f345659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f345660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f345661e;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f345657a, r101.f345657a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f345658b, r101.f345658b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f345659c, r101.f345659c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f345660d, r101.f345660d) == true) goto L21;
            return false;
        L21:
            if (this.f345661e == r101.f345661e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f345657a.hashCode() * 31;
            String r101 = this.f345658b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f345659c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f345660d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return ((r107 + r102) * 31) + this.f345661e;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "MobInfo(botId=" + this.f345657a + ", isDeleteIcon=" + this.f345658b + ", isBlueHighlight=" + this.f345659c + ", noticeType=" + this.f345660d + ", noticeCount=" + this.f345661e + ')';
        }

        public /* synthetic */ b(int r100) {
            this("", null, null, null, 0);
        }

        public b(String r100, String r101, String r102, String r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "botId");
            this.f345657a = r100;
            this.f345658b = r101;
            this.f345659c = r102;
            this.f345660d = r103;
            this.f345661e = r104;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345662a = null;

        static {
            int[] r100 = new int[SideBarItemType.values().length];
            r100[SideBarItemType.CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SideBarItemType.SHOW_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SideBarItemType.QUICK_ACCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f345662a = r100;
        }
    }

    static {
    }

    public final String g() {
        String r100 = this.f345654e;
        if (Intrinsics.areEqual(r100, "pinned") == false) goto L6;
        return "pin";
    L6:
        if (Intrinsics.areEqual(r100, "archived") == false) goto L9;
        return "archive_chat";
    L9:
        return this.f345651b.f344490a;
    }

    public static b c(com.larus.home.impl.main.side_bar.data.j0 r100) {
        int r101 = 0;
        if (r100.f344506a != SideBarItemType.CONVERSATION) goto L5;
        wh8.a r102 = r100.f344507b;
        if (r102 == null) goto L9;
        int r103 = y0.a(r102, false);
    L10:
        wh8.a r104 = r100.f344507b;
        if (r104 == null) goto L15;
        BotModel r105 = r104.f559709b;
        if (r105 == null) goto L15;
        String r106 = r105.getBotId();
    L16:
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        String r107 = r106;
        if (r100.f344514i == false) goto L21;
        String r108 = "1";
    L22:
        wh8.a r109 = r100.f344507b;
        if (r109 == null) goto L25;
        wc9.e r110 = r109.f559708a;
    L27:
        if (ic8.n.r(r110) == false) goto L29;
        String r111 = "1";
    L30:
        if (r103 <= 0) goto L32;
        String r112 = "number_dot";
    L34:
        return new b(r107, r111, r108, r112, r103);
    L32:
        r112 = null;
        goto L34
    L29:
        r111 = "0";
        goto L30
    L25:
        r110 = null;
        goto L27
    L21:
        r108 = "0";
    L15:
        r106 = null;
        goto L16
    L9:
        r103 = 0;
        goto L10
    L5:
        return new b(r101);
    }

    public final String a(com.larus.home.impl.main.side_bar.data.j0 r100) {
        SideBarItemType r101 = r100.f344506a;
        int r102 = c.f345662a[r101.ordinal()];
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L7;
        return "check_all";
    L7:
        if (r102 != 3) goto L22;
        ll9.t r103 = r100.f344510e;
        if (r103 != null) goto L19;
        return null;
    L19:
        return r103.f509776c;
    L22:
        return null;
    L14:
        if (this.f345652c == ComponentTypeEnum.MAIN_BOT.getType()) goto L21;
        return "bot_chat";
    L21:
        return this.f345653d;
    }

    public final JSONObject b(com.larus.home.impl.main.side_bar.data.j0 r100, String r101) {
        String r102 = "-";
        boolean r103 = true;
        String r104 = null;
        if (r101 != null) goto L5;
    L13:
        wh8.a r105 = r100.f344507b;
        if (r105 == null) goto L25;
        wc9.e r106 = r105.f559708a;
        if (r106 == null) goto L25;
        String r107 = r106.I;
        if (r107 == null) goto L25;
        if (r107.length() > 0) goto L23;
        r103 = false;
    L23:
        if (r103 == false) goto L25;
        r104 = r107;
    L25:
        if (r104 != null) goto L27;
        r101 = "-";
    L28:
        JSONObject r108 = new JSONObject();
        r108.put("group_by", this.f345655f.invoke());
        r108.put(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, this.f345656g.invoke());
        String r109 = this.f345654e;
        switch(r109.hashCode()) {
            case -988146728: goto L42;
            case -309310695: goto L38;
            case 3314286: goto L35;
            case 740154499: goto L32;
            default: goto L43;
        };
    L43:
        r102 = this.f345654e;
    L44:
        r108.put("group_id", r102);
        r108.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r101);
        return r108;
    L32:
        if (r109.equals("conversation") == true) goto L44;
    L35:
        if (r109.equals("lark") == true) goto L44;
    L38:
        if (r109.equals(SlashMentionConfig.SLASH_CONTENT_PROJECT) == false) goto L43;
        r102 = r101;
        goto L44
    L42:
        if (r109.equals("pinned") == true) goto L44;
    L27:
        r101 = r104;
        goto L28
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
    L7:
        r110 = false;
        goto L8
    }

    public final void f(int r210, com.larus.home.impl.main.side_bar.data.j0 r310) {
        Intrinsics.checkNotNullParameter(r310, MapController.ITEM_LAYER_TAG);
        SideBarItemType r100 = r310.f344506a;
        SideBarItemType r101 = SideBarItemType.CONVERSATION;
        if (r100 != r101) goto L5;
    L9:
        b r102 = c(r310);
        String r103 = this.f345650a.getCurrentPage();
        String r104 = this.f345650a.b();
        String r105 = this.f345650a.getEnterMethod();
        String r106 = "direct_show";
        if (r310.f344506a != r101) goto L17;
        Integer r107 = this.f345651b.f344492c;
        if (r107 == null) goto L17;
        if ((r210 + 1) <= r107.intValue()) goto L17;
        r106 = "click_check_all";
    L17:
        m2.a(r103, r104, r105, r106, g(), this.f345651b.f344491b, a(r310), Integer.valueOf(r210), r102.f345657a, r102.f345659c, r102.f345658b, Integer.valueOf(r102.f345661e), r102.f345660d, null, null, null, false, false, b(r310, null), 2851584);
        if (r310.f344506a != r101) goto L137;
        String r108 = this.f345650a.getCurrentPage();
        String r110 = this.f345650a.b();
        String r109 = this.f345650a.getEnterMethod();
        String r111 = r102.f345657a;
        int r112 = ChatListScreenMenuManager.f306626a;
        String r113 = ChatListScreenMenuManager.g(r310.f344507b);
        wh8.a r114 = r310.f344507b;
        if (r114 == null) goto L24;
        BotModel r115 = r114.f559709b;
        if (r115 == null) goto L24;
        Integer r211 = r115.getBotType();
    L25:
        String r212 = AccountService.f365697a.getUserId();
        JSONObject r116 = b(r310, null);
        r116.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, g());
        r116.put("index", r210);
        r116.put("red_dot_cnt", r102.f345661e);
        wh8.a r117 = r310.f344507b;
        if (r117 == null) goto L30;
        wc9.e r118 = r117.f559708a;
        if (r118 == null) goto L30;
        String r119 = r118.f559198a;
    L31:
        r116.put("conversation_id", r119);
        int r120 = r102.f345661e;
        wh8.a r121 = r310.f344507b;
        if (r121 == null) goto L34;
        Message r122 = r121.f559710c;
    L36:
        if (r122 == null) goto L81;
        List<Block> r123 = r122.getContentBlock();
        if (r123 == null) goto L81;
        List<Block> r124 = r123;
        if ((r124 instanceof Collection) == true) goto L42;
    L44:
        Iterator<T> r125 = r124.iterator();
    L46:
        if (r125.hasNext() == false) goto L78;
        Block r126 = (Block) r125.next();
        if (r126.getBlockType() != BlockType.BLOCK_TYPE_QUICK_REPLY.getValue()) goto L74;
        BlockContent r127 = r126.getContent();
        if (r127 == null) goto L59;
        QuickReplyBlock r128 = r127.getQuickReplyBlock();
        if (r128 == null) goto L59;
        Integer r129 = r128.getScene();
        int r130 = QuickReplyScene.SCENE_COMPUTER_USE_AGENT_ASK_HUMAN.getValue();
        if (r129 == null) goto L59;
        if (r129.intValue() != r130) goto L59;
        boolean r131 = true;
    L60:
        if (r131 == false) goto L74;
        BlockContent r132 = r126.getContent();
        if (r132 == null) goto L71;
        QuickReplyBlock r133 = r132.getQuickReplyBlock();
        if (r133 == null) goto L71;
        Integer r134 = r133.getStatus();
        int r135 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        if (r134 == null) goto L71;
        if (r134.intValue() != r135) goto L71;
        boolean r136 = true;
    L72:
        if (r136 == true) goto L74;
        boolean r137 = true;
    L75:
        if (r137 == false) goto L46;
        boolean r138 = true;
    L79:
        if (r138 != true) goto L81;
        boolean r139 = true;
    L82:
        wh8.a r140 = r310.f344507b;
        if (r140 == null) goto L87;
        wc9.e r141 = r140.f559708a;
        if (r141 == null) goto L87;
        String r142 = r141.f559198a;
    L88:
        if (r142 != null) goto L91;
        r142 = "";
    L91:
        if (r142.length() <= 0) goto L93;
        boolean r143 = true;
    L94:
        if (r143 == false) goto L98;
        d2 r144 = d2.f345076a;
        if (d2.a(r142) == null) goto L98;
        boolean r145 = true;
    L99:
        if (r139 == true) goto L126;
        if (r145 == true) goto L126;
        if (r122 != null) goto L104;
    L106:
        boolean r146 = false;
    L107:
        if (r146 == true) goto L125;
        if (r122 != null) goto L110;
    L112:
        boolean r147 = false;
    L113:
        if (r147 == true) goto L125;
        if (r122 != null) goto L117;
    L119:
        boolean r148 = false;
    L120:
        if (r148 == false) goto L122;
        String r149 = "reply_tail";
    L127:
        r116.put("status_type", r149);
        com.larus.home.impl.main.side_bar.view.adapter.t0 r150 = com.larus.home.impl.main.side_bar.view.adapter.t0.f345021a;
        wh8.a r151 = r310.f344507b;
        if (r151 == null) goto L132;
        wc9.e r152 = r151.f559708a;
        if (r152 == null) goto L132;
        String r153 = r152.f559198a;
    L133:
        r150.getClass();
        r116.put("is_scheduled_task", com.larus.home.impl.main.side_bar.view.adapter.t0.c(r153));
        r116.put("is_navigation_sidebar", "1");
        r116.put("tab_position", this.f345651b.f344491b);
        r116.put("is_blue_highlight", r102.f345659c);
        r116.put("is_delete_icon", r102.f345658b);
        o3.c(r111, r113, r108, r109, null, r110, null, null, null, null, null, null, null, null, r212, null, null, null, r211, r116, null, 5177249);
        return;
    L132:
        r153 = null;
        goto L133
    L122:
        if (r120 <= 0) goto L124;
        r149 = "unread";
        goto L127
    L124:
        r149 = "-";
        goto L127
    L117:
        if (r122.getMessageStatusLocal() != 22) goto L119;
        r148 = true;
        goto L120
    L110:
        if (r122.getMessageStatusLocal() != 24) goto L112;
        r147 = true;
    L125:
        r149 = "replying";
        goto L127
    L104:
        if (r122.getMessageStatusLocal() != 20) goto L106;
        r146 = true;
    L126:
        r149 = "ask_human";
    L98:
        r145 = false;
        goto L99
    L93:
        r143 = false;
    L87:
        r142 = null;
    L71:
        r136 = false;
    L59:
        r131 = false;
    L74:
        r137 = false;
    L78:
        r138 = false;
        goto L79
    L42:
        if (r124.isEmpty() == false) goto L44;
    L81:
        r139 = false;
        goto L82
    L34:
        r122 = null;
    L30:
        r119 = null;
    L24:
        r211 = null;
        goto L25
    L137:
        return;
    L5:
        if (r100 == SideBarItemType.SHOW_ALL) goto L9;
        if (r100 == SideBarItemType.QUICK_ACCESS) goto L9;
    }

    public final void d(int r100, com.larus.home.impl.main.side_bar.data.j0 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        e(r100, r101, r102, null);
    }

    public final void e(int r310, com.larus.home.impl.main.side_bar.data.j0 r311, String r312, String r313) {
        b r100 = c(r311);
        String r101 = this.f345650a.getCurrentPage();
        String r102 = this.f345650a.b();
        String r103 = this.f345650a.getEnterMethod();
        String r104 = "direct_show";
        if (r311.f344506a == SideBarItemType.CONVERSATION) goto L5;
    L4:
        String r105 = r104;
        String r110 = g();
        Integer r111 = this.f345651b.f344491b;
        if (r312 != null) goto L22;
        SideBarItemType r106 = r311.f344506a;
        int r107 = c.f345662a[r106.ordinal()];
        if (r107 != 1) goto L15;
    L20:
        String r108 = "click_cell";
    L21:
        String r112 = r108;
    L23:
        String r113 = a(r311);
        String r114 = r100.f345657a;
        String r109 = r100.f345659c;
        String r115 = r100.f345658b;
        int r116 = r100.f345661e;
        String r117 = r100.f345660d;
        JSONObject r210 = b(r311, r313);
        m2.b(null, null, r101, r102, r103, r105, r110, r111, r113, Integer.valueOf(r310), r112, r114, r109, r115, Integer.valueOf(r116), r117, null, null, null, null, false, false, null, r210, null, 19857410);
        return;
    L15:
        if (r107 != 2) goto L17;
        r108 = "check_all";
        goto L21
    L17:
        if (r107 == 3) goto L20;
        r108 = null;
        goto L21
    L22:
        r112 = r312;
        goto L23
    L5:
        Integer r118 = this.f345651b.f344492c;
        if (r118 == null) goto L4;
        if ((r310 + 1) <= r118.intValue()) goto L4;
        r104 = "click_check_all";
        goto L4
    }

    public j0(com.larus.home.impl.main.side_bar.view.b r100, d1 r101, int r102, String r103, String r104, Function0<String> r105, Function0<String> r106) {
        Intrinsics.checkNotNullParameter(r100, "contentBridge");
        Intrinsics.checkNotNullParameter(r101, "sideBarTabInfo");
        Intrinsics.checkNotNullParameter(r104, "sectionId");
        Intrinsics.checkNotNullParameter(r105, "groupByProvider");
        Intrinsics.checkNotNullParameter(r106, "sortTypeProvider");
        this.f345650a = r100;
        this.f345651b = r101;
        this.f345652c = r102;
        this.f345653d = r103;
        this.f345654e = r104;
        this.f345655f = r105;
        this.f345656g = r106;
    }
}
