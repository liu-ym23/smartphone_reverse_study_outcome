package com.larus.bmhome.chat.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.InputDialog;
import com.larus.common_ui.dialog.y0;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.R;
import com.larus.platform.api.z3;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import tx9.f3;
import tx9.w3;

/* JADX INFO: loaded from: classes25.dex */
public final class ChatListScreenMenuManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f306626a = 0;

    public static final class a implements com.larus.common_ui.dialog.p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f306627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f306628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ConversationModel f306629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ConversationChangeModel f306630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ wh8.a f306631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ t0 f306632f;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            int r100 = ChatListScreenMenuManager.f306626a;
            ChatListScreenMenuManager.c(this.f306627a, this.f306628b, this.f306629c, this.f306630d, this.f306631e, this.f306632f, true);
        }

        public a(Context r100, FragmentManager r101, ConversationModel r102, ConversationChangeModel r103, wh8.a r104, t0 r105) {
            this.f306627a = r100;
            this.f306628b = r101;
            this.f306629c = r102;
            this.f306630d = r103;
            this.f306631e = r104;
            this.f306632f = r105;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.u {
        public b() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    public static final class c implements y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConversationModel f306633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wc9.e f306634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BotModel f306635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t0 f306636d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ by7.e f306637e;

        @Override // com.larus.common_ui.dialog.y0
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            ConversationModel r101 = this.f306633a;
            if (r101 == null) goto L5;
            r101.updateConversationName(this.f306634b.f559198a, r100);
        L5:
            int r102 = com.larus.bmhome.chat.trace.i0.f310221a;
            int r103 = ChatListScreenMenuManager.f306626a;
            JSONObject r104 = ChatListScreenMenuManager.h(this.f306634b, this.f306635c, this.f306636d);
            by7.e r105 = this.f306637e;
            Intrinsics.checkNotNullParameter(r104, "params");
            com.larus.bmhome.chat.trace.i0.a("edit_chat_name", r104, r105);
        }

        public c(ConversationModel r100, wc9.e r101, BotModel r102, t0 r103, by7.e r104) {
            this.f306633a = r100;
            this.f306634b = r101;
            this.f306635c = r102;
            this.f306636d = r103;
            this.f306637e = r104;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wc9.e f306638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BotModel f306639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t0 f306640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ by7.e f306641d;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            int r100 = com.larus.bmhome.chat.trace.i0.f310221a;
            int r101 = ChatListScreenMenuManager.f306626a;
            JSONObject r102 = ChatListScreenMenuManager.h(this.f306638a, this.f306639b, this.f306640c);
            by7.e r103 = this.f306641d;
            Intrinsics.checkNotNullParameter(r102, "params");
            com.larus.bmhome.chat.trace.i0.a("cancel_edit_chat_name", r102, r103);
        }

        public d(wc9.e r100, BotModel r101, t0 r102, by7.e r103) {
            this.f306638a = r100;
            this.f306639b = r101;
            this.f306640c = r102;
            this.f306641d = r103;
        }
    }

    public static final class e implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f306642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f306643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ wh8.a f306644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f306645d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f306646e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Fragment f306647f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ wc9.e f306648g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ View f306649h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ t0 f306650i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ x0 f306651j;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r110) {
            this.f306642a.removeOnAttachStateChangeListener(this);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f306643b), null, null, new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1(this.f306644c, this.f306645d, this.f306646e, this.f306647f, this.f306648g, this.f306649h, this.f306643b, this.f306650i, this.f306651j, null), 3, null);
        }

        public e(View r100, LifecycleOwner r101, wh8.a r102, View r103, View r104, Fragment r105, wc9.e r106, View r107, t0 r108, x0 r110) {
            this.f306642a = r100;
            this.f306643b = r101;
            this.f306644c = r102;
            this.f306645d = r103;
            this.f306646e = r104;
            this.f306647f = r105;
            this.f306648g = r106;
            this.f306649h = r107;
            this.f306650i = r108;
            this.f306651j = r110;
        }
    }

    static {
    }

    public ChatListScreenMenuManager() {
    }

    public static JSONObject b(wc9.e r100) {
        JSONObject r101 = new JSONObject();
        r101.put("object_type", "chat");
        if (r100 == null) goto L14;
        String r102 = r100.I;
        if (r102 == null) goto L14;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L14;
    L15:
        r101.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r102);
        return r101;
    L9:
        r103 = false;
    L14:
        r102 = "-";
        goto L15
    }

    public static boolean e(wh8.a r100) {
        if (r100 == null) goto L8;
        BotModel r101 = r100.f559709b;
        if (r101 == null) goto L8;
        BotCreatorInfo r102 = r101.getBotCreatorInfo();
        if (r102 == null) goto L8;
        String r103 = r102.getId();
    L10:
        return Intrinsics.areEqual(r103, AccountService.f365697a.getUserId());
    L8:
        r103 = null;
        goto L10
    }

    public static Integer f(wh8.a r100) {
        if (r100 == null) goto L6;
        BotModel r101 = r100.f559709b;
        if (r101 == null) goto L6;
        return r101.getBotType();
    L6:
        return null;
    }

    public static String g(wh8.a r100) {
        ChatControlTrace r101 = ChatControlTrace.f309996b;
        if (r100 == null) goto L7;
        wc9.e r102 = r100.f559708a;
        if (r102 == null) goto L7;
        Integer r103 = r102.f559219v;
    L9:
        return r101.g(r103, f(r100), e(r100));
    L7:
        r103 = null;
        goto L9
    }

    public static void a(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    public static JSONObject h(wc9.e r100, BotModel r101, t0 r102) {
        JSONObject r103 = new JSONObject();
        String r104 = null;
        if (r101 == null) goto L5;
        String r105 = r101.getBotId();
    L6:
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r103.put("bot_id", r105);
        r103.put("conversation_id", r100.f559198a);
        r103.put("object_type", "chat");
        String r106 = r100.I;
        if (r106 != null) goto L11;
    L18:
        r106 = "-";
    L19:
        r103.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r106);
        ChatControlTrace r107 = ChatControlTrace.f309996b;
        Integer r108 = r100.f559219v;
        if (r101 == null) goto L22;
        Integer r109 = r101.getBotType();
    L23:
        if (r101 == null) goto L27;
        BotCreatorInfo r110 = r101.getBotCreatorInfo();
        if (r110 == null) goto L27;
        String r111 = r110.getId();
    L28:
        r103.put("chat_type", r107.g(r108, r109, Intrinsics.areEqual(r111, AccountService.f365697a.getUserId())));
        if (r102 == null) goto L31;
        String r112 = r102.f306842a;
    L32:
        if (r112 == null) goto L34;
        r103.put("click_from", r102.f306842a);
    L34:
        if (r102 == null) goto L36;
        String r113 = r102.f306843b;
    L37:
        if (r113 == null) goto L39;
        r103.put("current_page", r102.f306843b);
    L39:
        if (r102 == null) goto L41;
        r104 = r102.f306846e;
    L41:
        if (r104 == null) goto L43;
        r103.put("is_navigation_sidebar", r102.f306846e);
    L43:
        return r103;
    L36:
        r113 = null;
        goto L37
    L31:
        r112 = null;
    L27:
        r111 = null;
        goto L28
    L22:
        r109 = null;
        goto L23
    L11:
        if (r106.length() <= 0) goto L13;
        boolean r114 = true;
    L14:
        if (r114 == true) goto L17;
        r106 = null;
    L17:
        if (r106 != null) goto L19;
    L13:
        r114 = false;
        goto L14
    L5:
        r105 = null;
        goto L6
    }

    public static void c(final Context r310, FragmentManager r311, ConversationModel r312, final ConversationChangeModel r313, final wh8.a r314, t0 r315, boolean r316) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "manager");
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("deleteConversation started conversationId=");
        if (r314 == null) goto L7;
        wc9.e r102 = r314.f559708a;
        if (r102 == null) goto L7;
        String r103 = r102.f559198a;
    L8:
        r101.append(r103);
        r101.append(" confirmed=");
        r101.append(r316);
        r101.append(" clickFrom=");
        if (r315 == null) goto L11;
        String r104 = r315.f306842a;
    L12:
        r101.append(r104);
        r100.i("ChatListScreenMenuManager", r101.toString());
        if (NetworkUtils.isNetworkAvailable(r310) == false) goto L228;
        if (r314 == null) goto L16;
        wc9.e r105 = r314.f559708a;
    L18:
        if (ic8.n.D(r105) == false) goto L35;
        if (r314 == null) goto L28;
        wc9.e r106 = r314.f559708a;
        if (r106 == null) goto L28;
        Integer r107 = r106.f559203f;
        if (r107 == null) goto L28;
        if (r107.intValue() != 1) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == true) goto L35;
        if (r316 == true) goto L35;
        if (r311.isStateSaved() == true) goto L231;
        CommonDialog.a r109 = new CommonDialog.a();
        r109.i(r310.getString(R.string.larus_deleteChat_modalTitle_delete));
        r109.g(r310.getString(R.string.larus_deleteChat_modalDesc_historyCleared));
        CommonDialog.a.f(r109, new a(r310, r311, r312, r313, r314, r315), r310.getString(R.string.larus_bot_delete_chat_double_confirmation_delete), false, 12);
        CommonDialog.a.e(r109, new b(), r310.getString(R.string.larus_bot_delete_chat_double_confirmation_cancel), 4);
        a(r109.a(), r311);
        return;
    L231:
        return;
    L28:
        r108 = false;
    L35:
        StringBuilder r110 = new StringBuilder("deleteConversation step01 isSocialScene=");
        if (r314 == null) goto L40;
        wc9.e r111 = r314.f559708a;
        if (r111 == null) goto L40;
        Boolean r112 = Boolean.valueOf(ve8.c.a(r111));
    L41:
        r110.append(r112);
        r110.append("isChatOnly=");
        if (r314 == null) goto L44;
        wc9.e r113 = r314.f559708a;
    L45:
        r110.append(ic8.n.m(r113));
        r100.i("ChatListScreenMenuManager", r110.toString());
        com.larus.audio.p0 r114 = AudioServiceDelegate.f288288a.getAudioConfig();
        if (r314 == null) goto L48;
        BotModel r115 = r314.f559709b;
    L50:
        if (r114.n(r115) == false) goto L52;
        String r116 = "1";
    L53:
        if (r314 == null) goto L59;
        wc9.e r117 = r314.f559708a;
        if (r117 == null) goto L59;
        if (ve8.c.a(r117) != true) goto L59;
        boolean r118 = true;
    L60:
        if (r118 == false) goto L63;
        if (r312 == null) goto L229;
        ConversationModel.delete$default(r312, r314.f559708a, null, 2, null);
    L229:
        r100.i("ChatListScreenMenuManager", "deleteConversation ended");
        return;
    L63:
        if (r314 == null) goto L65;
        wc9.e r119 = r314.f559708a;
    L67:
        if (ic8.n.m(r119) == false) goto L69;
        CommonDialog.a r120 = new CommonDialog.a();
        r120.i(r310.getString(R.string.larus_only_chat_cell_del_title));
        r120.g(r310.getString(R.string.larus_only_chat_cell_del_content));
        CommonDialog.a.f(r120, new v(r312), r310.getString(R.string.larus_delete_bot_double_confirmation_delete), false, 12);
        CommonDialog.a.e(r120, new w(), r310.getString(R.string.larus_phone_change_toast_cancel), 4);
        r120.f327197z = false;
        a(r120.a(), r311);
        goto L229
    L69:
        if (r314 == null) goto L73;
        BotModel r121 = r314.f559709b;
        if (r121 == null) goto L73;
        String r122 = r121.getBotId();
    L75:
        if (r122 != null) goto L77;
        String r123 = "";
    L78:
        if (r314 == null) goto L82;
        wc9.e r124 = r314.f559708a;
        if (r124 == null) goto L82;
        String r125 = r124.f559198a;
    L83:
        ChatControlTrace r126 = ChatControlTrace.f309996b;
        if (r314 == null) goto L88;
        wc9.e r127 = r314.f559708a;
        if (r127 == null) goto L88;
        Integer r128 = r127.f559219v;
    L89:
        String r129 = r126.g(r128, f(r314), e(r314));
        if (r315 == null) goto L92;
        String r130 = r315.f306842a;
    L93:
        if (r315 == null) goto L95;
        String r131 = r315.f306843b;
    L96:
        if (r315 == null) goto L98;
        String r210 = r315.f306845d;
    L99:
        if (r314 == null) goto L101;
        String r211 = r314.f559712e;
    L102:
        if (r315 == null) goto L104;
        String r212 = r315.f306846e;
    L105:
        if (r314 == null) goto L114;
        wc9.e r132 = r314.f559708a;
        if (r132 == null) goto L114;
        Integer r133 = r132.f559217t;
        if (r133 == null) goto L114;
        if (r133.intValue() != 8) goto L114;
        boolean r134 = true;
    L115:
        if (r134 == false) goto L117;
        String r135 = "archived";
    L118:
        String r213 = r135;
        if (r314 == null) goto L121;
        wc9.e r136 = r314.f559708a;
    L122:
        f3.a(r123, r125, r129, r130, r131, b(r136), r210, r116, r211, r212, r213, 64);
        StringBuilder r137 = new StringBuilder("deleteConversation step02 conversationType=");
        if (r314 == null) goto L127;
        wc9.e r138 = r314.f559708a;
        if (r138 == null) goto L127;
        Integer r139 = r138.f559207j;
    L128:
        r137.append(r139);
        r137.append("isLocal=");
        if (r314 == null) goto L133;
        wc9.e r140 = r314.f559708a;
        if (r140 == null) goto L133;
        Integer r141 = r140.f559203f;
    L134:
        r137.append(r141);
        r100.i("ChatListScreenMenuManager", r137.toString());
        if (r314 == null) goto L144;
        wc9.e r142 = r314.f559708a;
        if (r142 == null) goto L144;
        Integer r143 = r142.f559207j;
        if (r143 == null) goto L144;
        if (r143.intValue() != 3) goto L144;
        boolean r144 = true;
    L145:
        if (r144 == false) goto L154;
        Lazy r145 = q3.f365794a;
        z3 r146 = q3.a();
        if (r146 == null) goto L154;
        BotModel r147 = r314.f559709b;
        if (r147 == null) goto L154;
        final String r148 = r147.getBotId();
        if (r148 == null) goto L154;
        r146.n(new com.larus.bmhome.chat.manager.e(r148));
    L154:
        if (r314 == null) goto L163;
        wc9.e r149 = r314.f559708a;
        if (r149 == null) goto L163;
        Integer r150 = r149.f559203f;
        if (r150 == null) goto L163;
        if (r150.intValue() != 1) goto L163;
        boolean r151 = true;
    L164:
        if (r151 == false) goto L171;
        if (r312 == null) goto L181;
        BotModel r152 = r314.f559709b;
        if (r152 == null) goto L169;
        String r153 = r152.getBotId();
    L170:
        r312.deleteRecommendBot(r153, new m(r313, r314, r310));
        goto L181
    L169:
        r153 = null;
    L181:
        if (r314 == null) goto L187;
        wc9.e r154 = r314.f559708a;
        if (r154 == null) goto L187;
        if (ic8.n.r(r154) != true) goto L187;
        boolean r155 = true;
    L188:
        if (r155 == true) goto L229;
        if (r314 == null) goto L193;
        BotModel r156 = r314.f559709b;
        if (r156 == null) goto L193;
        String r157 = r156.getBotId();
    L194:
        if (r157 != null) goto L196;
        String r158 = "";
    L197:
        if (r315 == null) goto L199;
        String r159 = r315.f306842a;
    L200:
        if (r314 == null) goto L204;
        BotModel r160 = r314.f559709b;
        if (r160 == null) goto L204;
        String r161 = r160.getBgImgUrl();
    L206:
        if (com.larus.utils.o0.d(r161) == false) goto L208;
        String r162 = "1";
    L209:
        if (r315 == null) goto L211;
        String r214 = r315.f306845d;
    L212:
        if (r314 == null) goto L214;
        String r215 = r314.f559712e;
    L215:
        if (r315 == null) goto L217;
        String r163 = r315.f306843b;
    L218:
        if (r315 == null) goto L220;
        String r164 = r315.f306844c;
    L221:
        if (r315 == null) goto L223;
        String r165 = r315.f306846e;
    L224:
        if (r315 == null) goto L226;
        by7.e r216 = r315.f306847f;
    L227:
        w3.a(r158, r159, r163, r162, r164, null, r214, r215, null, null, null, r116, r165, r216, 81120);
        goto L229
    L226:
        r216 = null;
        goto L227
    L223:
        r165 = null;
        goto L224
    L220:
        r164 = null;
        goto L221
    L217:
        r163 = null;
        goto L218
    L214:
        r215 = null;
        goto L215
    L211:
        r214 = null;
        goto L212
    L208:
        r162 = "0";
    L204:
        r161 = null;
        goto L206
    L199:
        r159 = null;
        goto L200
    L196:
        r158 = r157;
    L193:
        r157 = null;
    L187:
        r155 = false;
        goto L188
    L171:
        if (r312 == null) goto L181;
        if (r314 == null) goto L174;
        wc9.e r166 = r314.f559708a;
    L175:
        if (r314 == null) goto L179;
        BotModel r167 = r314.f559709b;
        if (r167 == null) goto L179;
        String r168 = r167.getBotId();
    L180:
        r312.delete(r166, r168);
    L179:
        r168 = null;
        goto L180
    L174:
        r166 = null;
    L163:
        r151 = false;
    L144:
        r144 = false;
    L133:
        r141 = null;
    L127:
        r139 = null;
        goto L128
    L121:
        r136 = null;
        goto L122
    L117:
        r135 = "normal";
    L114:
        r134 = false;
        goto L115
    L104:
        r212 = null;
        goto L105
    L101:
        r211 = null;
        goto L102
    L98:
        r210 = null;
        goto L99
    L95:
        r131 = null;
        goto L96
    L92:
        r130 = null;
    L88:
        r128 = null;
    L82:
        r125 = null;
        goto L83
    L77:
        r123 = r122;
    L73:
        r122 = null;
        goto L75
    L65:
        r119 = null;
    L59:
        r118 = false;
        goto L60
    L52:
        r116 = "0";
        goto L53
    L48:
        r115 = null;
        goto L50
    L44:
        r113 = null;
    L40:
        r112 = null;
        goto L41
    L16:
        r105 = null;
        goto L18
    L228:
        r100.i("ChatListScreenMenuManager", "deleteConversation step04 network disabled");
        t19.s.f544207a.getClass();
        t19.s.b(r310, R.string.larus_remove_recent_chat_failed, false);
        goto L229
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    public static void d(Context r110, FragmentManager r111, wc9.e r112, BotModel r113, ConversationModel r210, t0 r211, by7.e r212, String r213) {
        List<? extends InputFilter> r114 = CollectionsKt.emptyList();
        Boolean r115 = Boolean.TRUE;
        String r116 = r110.getString(R.string.larus_edit_chat_name);
        Intrinsics.checkNotNullParameter(r116, "title");
        if (r213 != null) goto L8;
        String r100 = r112.f559200c;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        String r117 = r100;
    L9:
        c r118 = new c(r210, r112, r113, r211, r212);
        Intrinsics.checkNotNullParameter(r118, "listener");
        d r101 = new d(r112, r113, r211, r212);
        Intrinsics.checkNotNullParameter(r101, "listener");
        InputDialog r102 = new InputDialog();
        r102.f327265e = r115;
        r102.f327266f = r116;
        r102.f327267g = r117;
        r102.f327271k = null;
        r102.f327272l = r118;
        r102.f327273m = null;
        r102.f327274n = r101;
        r102.f327268h = 40;
        r102.f327269i = r114;
        r102.f327270j = false;
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, null, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r111, r102, r103) == false) goto L17;
    L14:
        int r104 = com.larus.bmhome.chat.trace.i0.f310221a;
        JSONObject r105 = h(r112, r113, r211);
        Intrinsics.checkNotNullParameter(r105, "params");
        com.larus.bmhome.chat.trace.i0.a("click_edit_chat_name", r105, r212);
        return;
    L17:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        r102.show(r111, null);
        goto L14
    L8:
        r117 = r213;
        goto L9
    }

    public static void i(final View r110, final FragmentManager r210, final x0 r211, final Function0 r212, final ConversationModel r213, final ConversationChangeModel r214, final wh8.a r215, final u0 r216, final t0 r217, final Fragment r218) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r210, "manager");
        Intrinsics.checkNotNullParameter(r211, "screenMenu");
        Intrinsics.checkNotNullParameter(r212, "menuViewHolder");
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("showScreenMenu ");
        BotModel r102 = null;
        if (r215 == null) goto L5;
        String r103 = r215.d();
    L6:
        r101.append(r103);
        r100.i("ChatListScreenMenuManager", r101.toString());
        r110.setPressed(false);
        r110.invalidate();
        Drawable r104 = r110.getBackground();
        r110.setBackgroundResource(v19.c.b(R.attr.larus_white_bg_item_single_radius12_normal, r110.getContext(), R.drawable.larus_white_bg_item_single_radius12_normal));
        Bitmap r111 = Bitmap.createBitmap(r110.getWidth(), r110.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r111);
        List<Integer> r106 = r216.f306856d;
        if (r106 != null) goto L9;
        r106 = CollectionsKt.emptyList();
    L9:
        List r107 = CollectionsKt.distinct(r106);
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L11:
        if (r109.hasNext() == false) goto L18;
        View r112 = r110.findViewById(((Number) r109.next()).intValue());
        if (r112 == null) goto L15;
        Pair r113 = TuplesKt.to(r112, Float.valueOf(r112.getAlpha()));
    L16:
        if (r113 == null) goto L11;
        r108.add(r113);
        goto L11
    L15:
        r113 = null;
        goto L16
    L18:
        Iterator r114 = r108.iterator();
    L20:
        if (r114.hasNext() == false) goto L59;
        ((View) ((Pair) r114.next()).component1()).setAlpha(0.0f);
        goto L20
    L59:
        r110.draw(r105);     // Catch: Throwable -> L52
        Iterator r115 = r108.iterator();
    L25:
        if (r115.hasNext() == false) goto L27;
        Pair r116 = (Pair) r115.next();
        ((View) r116.component1()).setAlpha(((Number) r116.component2()).floatValue());
        goto L25
    L27:
        r110.setBackground(r104);
        com.larus.audio.p0 r117 = AudioServiceDelegate.f288288a.getAudioConfig();
        if (r215 == null) goto L31;
        r102 = r215.f559709b;
    L31:
        if (r117.n(r102) == false) goto L33;
        String r118 = "1";
    L34:
        final String r119 = r118;
        if (r215 != null) goto L37;
    L39:
        final boolean r120 = false;
    L40:
        if (r215 == null) goto L49;
        wc9.e r121 = r215.f559708a;
        if (r121 == null) goto L49;
        Integer r122 = r121.f559217t;
        if (r122 == null) goto L49;
        if (r122.intValue() != 8) goto L49;
        final boolean r123 = true;
    L50:
        r211.i(new n(r216, r110));
        r211.j(r110, r216.f306854b, r111, new o(r212, r215, r218, r216, r123, r120, r110, r211, r217, r119, r213, r210, r214));
        return;
    L49:
        r123 = false;
        goto L50
    L37:
        if (r215.c() != true) goto L39;
        r120 = true;
        goto L40
    L33:
        r118 = "0";
    L52:
        th = move-exception;
        Iterator r124 = r108.iterator();
    L55:
        if (r124.hasNext() == false) goto L57;
        Pair r125 = (Pair) r124.next();
        ((View) r125.component1()).setAlpha(((Number) r125.component2()).floatValue());
        goto L55
    L57:
        r110.setBackground(r104);
        throw th;
    L5:
        r103 = null;
        goto L6
    }
}
