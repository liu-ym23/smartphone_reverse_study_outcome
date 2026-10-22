package de8;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.bean.BotRecommendMobInfo;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.ChatUserContextParam;
import com.larus.bmhome.chat.model.repo.UserSettingRepoDelegate;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.k;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements t1a.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c f468084s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f468085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f468086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f468087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecommendFrom f468088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SearchMobParam f468089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f468090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f468091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f468092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f468093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f468094j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f468095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f468096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BotRecommendMobInfo f468097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f468098n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f468099o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f468100p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f468101q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f468102r;

    public static final class a {
        public static c a(Bundle r100) {
            return c.c(c.f468084s, r100, 0, 32766);
        }
    }

    public c() {
        this(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f468085a, r101.f468085a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468086b, r101.f468086b) == true) goto L15;
        return false;
    L15:
        if (this.f468087c == r101.f468087c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468088d, r101.f468088d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f468089e, r101.f468089e) == true) goto L24;
        return false;
    L24:
        if (this.f468090f == r101.f468090f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f468091g, r101.f468091g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f468092h, r101.f468092h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f468093i, r101.f468093i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f468094j, r101.f468094j) == true) goto L39;
        return false;
    L39:
        if (this.f468095k == r101.f468095k) goto L42;
        return false;
    L42:
        if (this.f468096l == r101.f468096l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f468097m, r101.f468097m) == true) goto L48;
        return false;
    L48:
        if (this.f468098n == r101.f468098n) goto L51;
        return false;
    L51:
        if (this.f468099o == r101.f468099o) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f468085a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bundle r104 = this.f468086b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f468087c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        RecommendFrom r110 = this.f468088d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        SearchMobParam r113 = this.f468089e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f468090f == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.f468091g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f468092h;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f468093i;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.f468094j;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        if (this.f468095k == false) goto L45;
        int r130 = 1231;
    L46:
        int r131 = (r129 + r130) * 31;
        if (this.f468096l == false) goto L49;
        int r132 = 1231;
    L50:
        int r133 = (r131 + r132) * 31;
        BotRecommendMobInfo r134 = this.f468097m;
        if (r134 == null) goto L54;
        r101 = r134.hashCode();
    L54:
        int r135 = (r133 + r101) * 31;
        long r136 = this.f468098n;
        int r137 = (r135 + ((int) (r136 ^ (r136 >>> 32)))) * 31;
        if (this.f468099o == true) goto L59;
        r107 = 1237;
    L59:
        return r137 + r107;
    L49:
        r132 = 1237;
        goto L50
    L45:
        r130 = 1237;
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
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
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatArgumentData(arguments=" + this.f468085a + ", currentArgument=" + this.f468086b + ", skipRefresh=" + this.f468087c + ", recommendFrom=" + this.f468088d + ", searchMobParam=" + this.f468089e + ", bgImgOpen=" + this.f468090f + ", bgImgUrlStr=" + this.f468091g + ", bgImgColorStr=" + this.f468092h + ", bgVideoModel=" + this.f468093i + ", immerseOrientation=" + this.f468094j + ", shouldShowImeOnce=" + this.f468095k + ", isUnreadDotEnable=" + this.f468096l + ", mobSegmentRecommendBot=" + this.f468097m + ", uniqueChatKey=" + this.f468098n + ", syncSidebarSelection=" + this.f468099o + ')';
    }

    public final boolean w() {
        List r100 = CollectionsKt.listOf(new String[]{ChatLandingChannel.COLD_PURE_CHAT.getChannel(), ChatLandingChannel.COLD_MULTI_CHAT.getChannel(), ChatLandingChannel.COLD_VIDEO_CHAT.getChannel()});
        Bundle r101 = this.f468086b;
        String r102 = "";
        if (r101 == null) goto L9;
        String r103 = r101.getString("landing_channel", "");
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        return r100.contains(r102);
    }

    static {
        f468084s = new c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
    }

    public final boolean B() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L5;
        long r101 = r100.getLong("target_middle_msg_local_index", -1);
    L7:
        if (r101 == (-1)) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = -1;
        goto L7
    }

    public final boolean C() {
        if (((Boolean) this.f468102r.getValue()).booleanValue() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f468090f == false) goto L11;
        if (o0.d(this.f468091g) == false) goto L11;
        if (o0.d(this.f468092h) == false) goto L11;
        return true;
    }

    public final boolean E() {
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L19;
        Bundle r102 = this.f468086b;
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r102.getInt("argBotType") != 4) goto L14;
        r103 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r100.getInt("argBotConversationType") != 6) goto L7;
        r101 = true;
        goto L8
    }

    public final ChatPassThroughParams b() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L5;
        ChatPassThroughParams r101 = k.a(r100);
    L6:
        Bundle r102 = this.f468086b;
        if (r102 == null) goto L9;
        String r103 = r102.getString("argCommerceFunctionScene");
    L10:
        if (r103 != null) goto L12;
    L17:
        r103 = null;
    L18:
        Bundle r104 = this.f468086b;
        if (r104 == null) goto L25;
        ChatUserContextParam r105 = (ChatUserContextParam) r104.getParcelable("argLarkUserContext");
        if (r105 == null) goto L25;
        if (r105.isNotEmpty() == false) goto L25;
    L26:
        if (r101 != null) goto L28;
        ChatPassThroughParams r110 = new ChatPassThroughParams(null, false, false, null, 15, null);
    L29:
        if (r103 != null) goto L33;
        if (r101 == null) goto L32;
        r103 = r101.getFlowFunctionScene();
        goto L33
    L32:
        String r111 = null;
    L35:
        if (r105 != null) goto L39;
        if (r101 == null) goto L38;
        r105 = r101.getUserContextParam();
        goto L39
    L38:
        ChatUserContextParam r112 = null;
    L40:
        ChatPassThroughParams r106 = ChatPassThroughParams.copy$default(r110, r111, false, false, r112, 6, null);
        if (r106.isNotEmpty() == true) goto L43;
        return null;
    L43:
        return r106;
    L39:
        r112 = r105;
    L33:
        r111 = r103;
        goto L35
    L28:
        r110 = r101;
    L25:
        r105 = null;
        goto L26
    L12:
        if (r103.length() <= 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
    L14:
        r107 = false;
        goto L15
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final String d() {
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("from_activity_module");
    }

    public final String e() {
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("from_activity_name");
    }

    public final String f() {
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("argBotId");
    }

    public final String g() {
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("argConversationId");
    }

    public final String h() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L5;
        String r101 = r100.getString("argConversationId", "");
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
        Bundle r103 = this.f468086b;
        if (r103 != null) goto L22;
        return null;
    L22:
        return r103.getString("argConversationId", "");
    L14:
        if (z2.f365865a.d1() != this.f468101q) goto L24;
        UserSettingRepoDelegate r104 = UserSettingRepoDelegate.f307761b;
        if (Intrinsics.areEqual(r104.c(), Boolean.TRUE) == false) goto L24;
        return r104.Y1();
    L24:
        return "";
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final String i() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L6;
        String r101 = r100.getString("create_sub_conv_collection_id");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String k() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L5;
        String r101 = r100.getString("enter_method");
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L19;
        Bundle r103 = this.f468086b;
        if (r103 == null) goto L26;
        String r104 = r103.getString("enter_chat_method");
        if (r104 != null) goto L25;
        return "";
    L25:
        return r104;
    L26:
        return "";
    L19:
        Bundle r105 = this.f468086b;
        if (r105 == null) goto L27;
        r104 = r105.getString("enter_method");
        if (r104 != null) goto L25;
        return "";
    L27:
        return "";
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final long l() {
        Bundle r100 = this.f468085a;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getLong("enter_session", -1);
    }

    public final Integer m() {
        if (o0.d(this.f468092h) == true) goto L5;
        return null;
    L5:
        if (C() == false) goto L13;
        return Integer.valueOf(Color.parseColor(this.f468092h));
    L8:
        FLogger.f375446a.e(c.class.getSimpleName(), "bgPickedColor is not formatted");
        return null;
    L13:
        return null;
    }

    public final boolean n() {
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getBoolean("argIsHalfScreen", false);
    }

    public final String o() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L6;
        String r101 = r100.getString("open_comment_id", null);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String p() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L5;
        String r101 = r100.getString("argPreviousPage");
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L19;
        Bundle r103 = this.f468086b;
        if (r103 == null) goto L26;
        String r104 = r103.getString("previous_page");
        if (r104 != null) goto L25;
        return "";
    L25:
        return r104;
    L26:
        return "";
    L19:
        Bundle r105 = this.f468086b;
        if (r105 == null) goto L27;
        r104 = r105.getString("argPreviousPage");
        if (r104 != null) goto L25;
        return "";
    L27:
        return "";
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final String q() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L5;
        String r101 = r100.getString("argPushContentId", "");
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String r() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L6;
        String r101 = r100.getString("push_open_url");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String t() {
        Bundle r100 = this.f468086b;
        if (r100 == null) goto L8;
        String r101 = r100.getString("target_scroll_message_id", null);
        if (r101 == null) goto L8;
        return r101;
    L8:
        Bundle r102 = this.f468086b;
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.getString("target_message_id", null);
    }

    public final boolean v() {
        Bundle r100 = this.f468086b;
        String r101 = "";
        if (r100 == null) goto L9;
        String r102 = r100.getString("auto_open_plus_camera", "");
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        return Intrinsics.areEqual(r101, "1");
    }

    public final boolean z() {
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getBoolean("is_in_immers_fragment", false);
    }

    public final boolean A() {
        return Intrinsics.areEqual("selfshare_open", k());
    }

    public final boolean D() {
        if (C() == false) goto L10;
        Integer r100 = this.f468094j;
        if (r100 == null) goto L10;
        if (r100.intValue() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public final ChatPageContext a() {
        ChatPassThroughParams r100 = b();
        LinkedHashMap r101 = new LinkedHashMap();
        boolean r102 = false;
        if (r100 == null) goto L16;
        String r103 = r100.getFlowFunctionScene();
        if (r103 == null) goto L16;
        if (r103.length() <= 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L16;
        r101.put("x-flow-function-scene", r103);
        goto L16
    L9:
        r104 = false;
    L16:
        if ((!r101.isEmpty()) == false) goto L18;
        LinkedHashMap r105 = r101;
    L19:
        Bundle r106 = this.f468086b;
        if (r106 == null) goto L32;
        String r107 = r106.getString(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID);
        if (r107 == null) goto L32;
        if (r107.length() <= 0) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L30;
        r107 = null;
    L30:
        if (r107 == null) goto L32;
        Map r109 = MapsKt.mapOf(TuplesKt.to(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r107));
    L33:
        Bundle r110 = this.f468086b;
        if (r110 == null) goto L42;
        String r111 = r110.getString("conversation_mode_key_override");
        if (r111 == null) goto L42;
        if (r111.length() <= 0) goto L40;
        r102 = true;
    L40:
        if (r102 == false) goto L42;
        String r112 = r111;
    L43:
        if (r100 == null) goto L49;
        ChatUserContextParam r113 = r100.getUserContextParam();
        if (r113 == null) goto L49;
        if (r113.isNotEmpty() == false) goto L49;
        ChatUserContextParam r114 = r113;
    L50:
        ChatPageContext r115 = new ChatPageContext(r105, r109, r114, null, null, r112, 24, null);
        if (r115.isNotEmpty() == true) goto L53;
        return null;
    L53:
        return r115;
    L49:
        r114 = null;
    L42:
        r112 = null;
        goto L43
    L26:
        r108 = false;
    L32:
        r109 = null;
        goto L33
    L18:
        r105 = null;
        goto L19
    }

    public final long s() {
        if (wi8.d.a().b() == true) goto L5;
        return -1;
    L5:
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L8;
        return -1;
    L8:
        return r100.getLong("red_dot_entry_read_message_index", -1);
    }

    public final boolean x() {
        if (wi8.d.a().a() == true) goto L5;
        return false;
    L5:
        Bundle r100 = this.f468086b;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.getBoolean("is_from_chat_list", false) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean y() {
        if (wi8.d.a().b() == true) goto L5;
        return false;
    L5:
        Bundle r100 = this.f468086b;
        String r101 = null;
        if (r100 == null) goto L8;
        String r102 = r100.getString("is_from_push", "false");
    L9:
        boolean r103 = Intrinsics.areEqual(r102, "true");
        Bundle r104 = this.f468086b;
        if (r104 == null) goto L12;
        r101 = r104.getString("push_content_type", "");
    L12:
        if (r103 == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r101, "im_push") == false) goto L18;
        return true;
    L18:
        return false;
    L8:
        r102 = null;
        goto L9
    }

    public final Bundle j() {
        return this.f468086b;
    }

    public final boolean u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = r();
        boolean r102 = true;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L24;
        return false;
    L24:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        Uri r105 = UriProtector.parse(r101);     // Catch: Throwable -> L17
        if (r105 == null) goto L11;
        String r106 = UriProtector.getQueryParameter(r105, r100);     // Catch: Throwable -> L17
    L12:
        if (r106 != null) goto L15;
        r102 = false;
    L15:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L17
    L19:
        Boolean r108 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r107) == false) goto L23;
        r107 = r108;
    L23:
        return ((Boolean) r107).booleanValue();
    L11:
        r106 = null;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L5:
        r103 = false;
        goto L6
    }

    public static c c(c r210, Bundle r211, long r212, int r213) {
        if ((r213 & 1) == 0) goto L5;
        Bundle r100 = r210.f468085a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        Bundle r101 = r210.f468086b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        boolean r102 = r210.f468087c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        RecommendFrom r103 = r210.f468088d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        SearchMobParam r104 = r210.f468089e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        boolean r105 = r210.f468090f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r110 = r210.f468091g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r111 = r210.f468092h;
    L35:
        if ((r213 & 256) == 0) goto L37;
        String r112 = r210.f468093i;
    L39:
        if ((r213 & 512) == 0) goto L41;
        Integer r113 = r210.f468094j;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        boolean r114 = r210.f468095k;
    L47:
        if ((r213 & 2048) == 0) goto L49;
        boolean r115 = r210.f468096l;
    L51:
        if ((r213 & 4096) == 0) goto L53;
        BotRecommendMobInfo r116 = r210.f468097m;
    L54:
        RecommendFrom r117 = r103;
        if ((r213 & 8192) == 0) goto L57;
        long r118 = r210.f468098n;
    L59:
        if ((r213 & 16384) == 0) goto L61;
        boolean r106 = r210.f468099o;
    L62:
        r210.getClass();
        return new c(r100, r101, r102, r117, r104, r105, r110, r111, r112, r113, r114, r115, r116, r118, r106);
    L61:
        r106 = false;
        goto L62
    L57:
        r118 = r212;
        goto L59
    L53:
        r116 = null;
        goto L54
    L49:
        r115 = false;
        goto L51
    L45:
        r114 = false;
        goto L47
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = null;
        goto L35
    L29:
        r110 = null;
        goto L31
    L25:
        r105 = false;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public c(Bundle r100, Bundle r101, boolean r110, RecommendFrom r111, SearchMobParam r112, boolean r113, String r114, String r115, String r116, Integer r117, boolean r118, boolean r119, BotRecommendMobInfo r210, long r211, boolean r212) {
        this.f468085a = r100;
        this.f468086b = r101;
        this.f468087c = r110;
        this.f468088d = r111;
        this.f468089e = r112;
        this.f468090f = r113;
        this.f468091g = r114;
        this.f468092h = r115;
        this.f468093i = r116;
        this.f468094j = r117;
        this.f468095k = r118;
        this.f468096l = r119;
        this.f468097m = r210;
        this.f468098n = r211;
        this.f468099o = r212;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("share_to_chat_text");
    L6:
        boolean r104 = true;
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        if (r101 == null) goto L22;
        String r106 = r101.getString(ReferenceMessage.KEY_REFERENCE_TEXT);
    L23:
        if (r106 != null) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == false) goto L19;
        if (r101 == null) goto L33;
        r102 = r101.getString("auto_send_text");
    L33:
        if (r102 != null) goto L35;
    L38:
        boolean r108 = true;
    L39:
        if (r108 == true) goto L19;
        if (z2.f365865a.getRouterConfig().b() == true) goto L19;
    L42:
        this.f468100p = r104;
        this.f468101q = 2;
        this.f468102r = LazyKt.lazy(new b());
        return;
    L35:
        if (r102.length() == 0) goto L38;
        r108 = false;
    L19:
        r104 = false;
        goto L42
    L25:
        if (r106.length() == 0) goto L28;
        r107 = false;
        goto L29
    L22:
        r106 = null;
        goto L23
    L15:
        if (z2.f365865a.getRouterConfig().b() == false) goto L42;
        if (u("share_to_chat_text") == true) goto L19;
    L9:
        if (r103.length() == 0) goto L12;
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public /* synthetic */ c(Bundle r210, Bundle r211, boolean r212, RecommendFrom r213, SearchMobParam r214, boolean r215, String r216, String r217, String r218, Integer r310, boolean r311, boolean r312, BotRecommendMobInfo r313, long r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        Bundle r100 = null;
    L7:
        if ((r315 & 2) == 0) goto L9;
        Bundle r101 = null;
    L11:
        if ((r315 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r315 & 8) == 0) goto L17;
        RecommendFrom r103 = null;
    L19:
        if ((r315 & 16) == 0) goto L21;
        SearchMobParam r104 = null;
    L23:
        if ((r315 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r315 & 512) == 0) goto L41;
        Integer r113 = null;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        boolean r114 = false;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        boolean r106 = true;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        BotRecommendMobInfo r115 = null;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        long r116 = SystemClock.elapsedRealtime();
    L59:
        if ((r315 & 16384) == 0) goto L61;
        boolean r117 = true;
    L62:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r115, r116, r117);
        return;
    L61:
        r117 = false;
        goto L62
    L57:
        r116 = r314;
        goto L59
    L53:
        r115 = r313;
        goto L55
    L49:
        r106 = r312;
        goto L51
    L45:
        r114 = r311;
        goto L47
    L41:
        r113 = r310;
        goto L43
    L37:
        r112 = r218;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
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
}
