package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.util.LruCache;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.QuickReplyScene;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import tx9.x1;

/* JADX INFO: loaded from: classes26.dex */
public final class QuickReplyVMDependencyImpl implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, String> f309560b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f309561a;

    public static final class a {
    }

    static {
        f309560b = new LruCache(100);
    }

    public QuickReplyVMDependencyImpl() {
        this.f309561a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c
    public final void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vmData");
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.b(r100);
    }

    public static String f(QuickReplyItem r100, boolean r101) {
        String r102 = r100.getSchemaPayload();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = StringsKt.trim(r102).toString();
    L6:
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r105 = ICommerceMembershipService.a.a();
        if (r105 == null) goto L45;
        String r106 = r105.A(r104);
        if (r106 == null) goto L45;
        if (r101 == true) goto L48;
        String r107 = f309560b.get(r106);
        if (r107 == null) goto L48;
        return r107;
    L48:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L17
        Object r109 = Result.m9449constructorimpl(UriProtector.parse(r106));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r109) == false) goto L22;
        r109 = null;
    L22:
        Uri r110 = (Uri) r109;
        if (r110 != null) goto L46;
    L42:
        String r111 = r106;
    L43:
        f309560b.put(r106, r111);
        return r111;
    L46:
        Object r112 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r110, "subs_purchase_id"));     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r112) == false) goto L32;
        r112 = null;
    L32:
        String r113 = (String) r112;
        if (r113 == null) goto L42;
        if (r113.length() <= 0) goto L37;
        boolean r114 = true;
    L38:
        if (r114 == false) goto L40;
        r103 = r113;
    L40:
        if (r103 == null) goto L42;
        r111 = y0.g(r110, "subs_purchase_id", r103 + "_mills" + System.currentTimeMillis()).toString();
        goto L43
    L37:
        r114 = false;
    L27:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L45:
        return null;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object e(b r110, Continuation<? super ReferenceInfo> r111) {
        if ((r111 instanceof QuickReplyVMDependencyImpl$buildReferenceInfo$1) == false) goto L7;
        QuickReplyVMDependencyImpl$buildReferenceInfo$1 r100 = (QuickReplyVMDependencyImpl$buildReferenceInfo$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        ?? r106 = r105;
    L43:
        ReferenceInfo r107 = ((ReferenceMessage) r102).getReferenceInfo();
        if (r107 != null) goto L53;
        ?? r108 = r106;
    L48:
        if (r108 != 0) goto L50;
        return null;
    L50:
        return new ReferenceInfo(null, null, r108, 0, null, null, null, null, 251, null);
    L53:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r109 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L18
        r104 = r109;
    L30:
        Object r112 = Result.m9449constructorimpl((Message) r102);     // Catch: Throwable -> L18
        ?? r113 = r104;
    L34:
        if (Result.m9455isFailureimpl(r112) == false) goto L36;
        r112 = null;
    L36:
        Message r114 = (Message) r112;
        ?? r115 = r113;
    L38:
        if (r114 == null) goto L47;
        ReferenceMessage.Companion r116 = ReferenceMessage.Companion;
        r100.L$0 = r115;
        r100.label = 2;
        r102 = r116.b(r114, null, r100);
        if (r102 != r103) goto L42;
        return r103;
    L42:
        r106 = r115;
        goto L43
    L47:
        r108 = r115;
        goto L48
    L20:
        ResultKt.throwOnFailure(r102);
        String r117 = r110.f309564b;
        if (r117 != null) goto L23;
    L25:
        String r118 = null;
    L26:
        if (r118 == null) goto L37;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L18
        IChatRepoService r120 = zh8.a.f572196a;     // Catch: Throwable -> L18
        r100.L$0 = r118;     // Catch: Throwable -> L18
        r100.label = 1;     // Catch: Throwable -> L18
        r102 = r120.E1(r118, r100);     // Catch: Throwable -> L18
        r104 = r118;
        if (r102 != r103) goto L30;
        return r103;
    L37:
        r114 = null;
        r115 = r118;
        goto L38
    L23:
        if ((!StringsKt.isBlank(r117)) == false) goto L25;
        r118 = r117;
    L18:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r113 = r104;
    L7:
        r100 = new QuickReplyVMDependencyImpl$buildReferenceInfo$1(this, r111);
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c
    public final void a(b r210, QuickReplyItem r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, "vmData");
        Intrinsics.checkNotNullParameter(r211, MapController.ITEM_LAYER_TAG);
        int r100 = com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.f309562a;
        Intrinsics.checkNotNullParameter(r210, "vmData");
        Intrinsics.checkNotNullParameter(r211, MapController.ITEM_LAYER_TAG);
        JSONObject r101 = new JSONObject();
        String r102 = r210.f309564b;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.put(MusicAppletPage.KEY_MESSAGE_ID, r102);
        String r104 = r210.f309565c;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r101.put("bot_id", r104);
        r101.put("sug_card_type", "inner_message_button");
        long r105 = r210.f309567e;
        long r106 = 0;
        if (r105 <= 0) goto L12;
        r106 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r105, 0);
    L12:
        r101.put("load_sug_time", String.valueOf(r106));
        Map<String, String> r107 = r211.getExtraParams();
        String r108 = null;
        if (r107 == null) goto L15;
        String r109 = r107.get("item_id");
    L16:
        r101.put("item_id", r109);
        String r110 = r211.getText();
        if (r110 != null) goto L19;
        r110 = "";
    L19:
        r101.put("item_content", r110);
        r101.put("prompt_position", r212);
        String r111 = r210.f309566d;
        if (r111 != null) goto L22;
        r111 = "";
    L22:
        boolean r112 = false;
        if (r111.length() != 0) goto L25;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L29;
        r111 = "chat";
    L29:
        r101.put("current_page", r111);
        Map<String, String> r114 = r211.getExtraParams();
        if (r114 == null) goto L44;
        String r115 = r114.get("source");
        if (r115 == null) goto L44;
        String r116 = StringsKt.trim(r115).toString();
        if (r116 == null) goto L44;
        if (r116.length() <= 0) goto L38;
        boolean r117 = true;
    L39:
        if (r117 == true) goto L42;
        r116 = null;
    L42:
        if (r116 == null) goto L44;
        r101.put("suggested_type", r116);
        goto L44
    L38:
        r117 = false;
    L44:
        o r118 = o.f365780a;
        r118.reportEvent("show_suggested_prompt_single_question", r101);
        String r119 = com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.a(r210);
        if (r119 == null) goto L59;
        String r120 = r211.getText();
        if (r120 == null) goto L57;
        String r121 = StringsKt.trim(r120).toString();
        if (r121 == null) goto L57;
        if (r121.length() <= 0) goto L54;
        boolean r122 = true;
    L55:
        if (r122 == false) goto L57;
        String r123 = r121;
    L58:
        x1.f(r119, "query_suggest", "query_suggest_button", r123, null, null, 112);
        goto L59
    L54:
        r122 = false;
    L57:
        r123 = null;
    L59:
        Map<String, String> r124 = r211.getExtraParams();
        if (r124 == null) goto L62;
        String r125 = r124.get("source");
    L64:
        if (Intrinsics.areEqual(r125, "cta_button") == false) goto L113;
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r126 = ICommerceMembershipService.a.a();
        if (r126 == null) goto L113;
        String r127 = f(r211, true);
        if (r127 == null) goto L113;
        uz8.c r128 = r126.z(r127);
        if (r128 == null) goto L75;
        String r129 = r128.f552209a;
    L77:
        if (o0.d(r129) == false) goto L81;
        if (r128 == null) goto L80;
        String r130 = r128.f552209a;
    L82:
        String r131 = r130;
    L84:
        if (r128 == null) goto L86;
        String r132 = r128.f552210b;
    L87:
        if (r128 == null) goto L89;
        String r133 = r128.f552211c;
    L90:
        if (r128 == null) goto L92;
        String r134 = r128.f552212d;
    L93:
        if (r128 == null) goto L95;
        String r135 = r128.f552214f;
    L97:
        if (r128 == null) goto L99;
        String r136 = r128.f552213e;
    L100:
        if (r128 == null) goto L102;
        String r137 = r128.f552218j;
    L103:
        if (r128 == null) goto L105;
        String r213 = r128.f552219k;
    L106:
        if (r128 == null) goto L108;
        String r214 = r128.f552220l;
    L109:
        if (r128 == null) goto L111;
        String r215 = r128.f552221m;
    L112:
        ICommerceMembershipService.b.b(r126, r131, "chat", r132, r133, r134, r135, null, r136, r137, r213, r214, r215, 64);
        goto L113
    L111:
        r215 = null;
        goto L112
    L108:
        r214 = null;
        goto L109
    L105:
        r213 = null;
        goto L106
    L102:
        r137 = null;
        goto L103
    L99:
        r136 = null;
        goto L100
    L95:
        r135 = null;
        goto L97
    L92:
        r134 = null;
        goto L93
    L89:
        r133 = null;
        goto L90
    L86:
        r132 = null;
        goto L87
    L80:
        r131 = null;
        goto L84
    L81:
        r130 = "answer_quota_limit";
        goto L82
    L75:
        r129 = null;
    L113:
        Integer r138 = r211.getActionType();
        int r139 = ActionType.CUA_ASK_REPLY.getValue();
        if (r138 != null) goto L117;
    L118:
        int r140 = ActionType.CUA_ASK_SKIP.getValue();
        if (r138 != null) goto L122;
    L124:
        int r141 = ActionType.CUA_REQUEST_ACTION_BROWSER_OPERATION.getValue();
        if (r138 != null) goto L128;
    L129:
        int r142 = ActionType.CUA_REQUEST_ACTION_SKIP.getValue();
        if (r138 != null) goto L133;
    L134:
        int r143 = ActionType.CUA_REQUEST_ACTION_PIP_OPERATION.getValue();
        if (r138 != null) goto L138;
    L139:
        int r144 = ActionType.CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT.getValue();
        if (r138 != null) goto L143;
    L145:
        int r145 = ActionType.CUA_WARN_ALLOW.getValue();
        if (r138 != null) goto L149;
    L150:
        int r146 = ActionType.CUA_WARN_REFUSE.getValue();
        if (r138 != null) goto L154;
    L155:
        int r147 = ActionType.CUA_ALWAYS_ALLOW.getValue();
        if (r138 != null) goto L159;
    L161:
        int r148 = ActionType.CUA_AUTHORIZE_FOLDER_ALLOW.getValue();
        if (r138 != null) goto L165;
    L166:
        int r149 = ActionType.CUA_AUTHORIZE_FOLDER_SELECT.getValue();
        if (r138 != null) goto L170;
    L171:
        int r150 = ActionType.CUA_AUTHORIZE_FOLDER_REFUSE.getValue();
        if (r138 != null) goto L175;
    L181:
        if (r103.length() <= 0) goto L183;
        r112 = true;
    L183:
        if (r112 == false) goto L185;
        r108 = r103;
    L185:
        if (r108 == null) goto L189;
        JSONObject r151 = new JSONObject();
        r151.put("current_page", "chat");
        r151.put("button_name", r211.getText());
        r151.put("request_type", r108);
        Unit r152 = Unit.INSTANCE;
        r118.reportEvent("in_task_share_folder_permission_option_show", r151);
        return;
    L189:
        return;
    L175:
        if (r138.intValue() != r150) goto L181;
    L176:
        r103 = "interaction.authorize_folder";
        goto L181
    L170:
        if (r138.intValue() == r149) goto L176;
    L165:
        if (r138.intValue() == r148) goto L176;
    L159:
        if (r138.intValue() != r147) goto L161;
    L177:
        r103 = "interaction.warn";
        goto L181
    L154:
        if (r138.intValue() == r146) goto L177;
    L149:
        if (r138.intValue() == r145) goto L177;
    L143:
        if (r138.intValue() != r144) goto L145;
    L178:
        r103 = "interaction.request_action";
        goto L181
    L138:
        if (r138.intValue() == r143) goto L178;
    L133:
        if (r138.intValue() == r142) goto L178;
    L128:
        if (r138.intValue() == r141) goto L178;
    L122:
        if (r138.intValue() != r140) goto L124;
    L179:
        r103 = "interaction.ask";
        goto L181
    L117:
        if (r138.intValue() == r139) goto L179;
    L62:
        r125 = null;
        goto L64
    L25:
        r113 = false;
        goto L27
    L15:
        r109 = null;
        goto L16
    }

    public static final Object d(QuickReplyVMDependencyImpl r210, b r211, QuickReplyItem r212, Continuation r213) {
        b r100 = r211;
        r210.getClass();
        if ((r213 instanceof QuickReplyVMDependencyImpl$sendQuickReply$1) == false) goto L7;
        QuickReplyVMDependencyImpl$sendQuickReply$1 r101 = (QuickReplyVMDependencyImpl$sendQuickReply$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r101.I$0;
        MessageStatus r107 = (MessageStatus) r101.L$6;
        Map r108 = (Map) r101.L$5;
        String r109 = (String) r101.L$4;
        String r110 = (String) r101.L$3;
        String r111 = (String) r101.L$2;
        u1 r112 = (u1) r101.L$1;
        b r113 = (b) r101.L$0;
        ResultKt.throwOnFailure(r103);
        MessageStatus r114 = r107;
        r100 = r113;
        Map r115 = r108;
        String r116 = r109;
        String r117 = r110;
        u1 r118 = r112;
    L59:
        if (r106 == 0) goto L61;
        boolean r119 = true;
    L62:
        u1.a.f(r118, r111, r117, r116, r115, null, r114, null, r119, (ReferenceInfo) r103, "sendFuncChannel", null, r100.f309572j, null, false, 27048);
        return Unit.INSTANCE;
    L61:
        r119 = false;
        goto L62
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        String r120 = r212.getText();
        if (r120 == null) goto L65;
        String r121 = StringsKt.trim(r120).toString();
        if (r121 == null) goto L65;
        if (r121.length() <= 0) goto L21;
        boolean r122 = true;
    L22:
        Integer r123 = null;
        if (r122 == false) goto L25;
        r111 = r121;
    L26:
        if (r111 == null) goto L65;
        String r124 = r100.f309563a;
        if (r124 == null) goto L67;
        if ((!StringsKt.isBlank(r124)) == true) goto L34;
        r124 = null;
    L34:
        if (r124 == null) goto L67;
        u1 r125 = zh8.a.f572196a.u1();
        Map<String, String> r126 = r212.getExtraParams();
        if (r126 != null) goto L39;
        r126 = MapsKt.emptyMap();
    L39:
        Map r127 = MapsKt.toMutableMap(r126);
        QuickReplyBlock r128 = r100.f309571i;
        if (r128 == null) goto L42;
        r123 = r128.getScene();
    L42:
        int r129 = QuickReplyScene.SCENE_ANSWER_POST_OPTION.getValue();
        if (r123 != null) goto L46;
    L48:
        int r130 = QuickReplyScene.SCENE_ASWEER_INNER_OPTION.getValue();
        if (r123 != null) goto L52;
    L54:
        MessageStatus r131 = MessageStatus.MessageStatus_AVAILABLE;
        r101.L$0 = r100;
        r101.L$1 = r125;
        r101.L$2 = r111;
        r101.L$3 = r124;
        r116 = "quick_reply";
        r101.L$4 = "quick_reply";
        r101.L$5 = r127;
        r101.L$6 = r131;
        r101.I$0 = 0;
        r101.label = 1;
        Object r132 = r210.e(r100, r101);
        if (r132 == r104) goto L68;
        r115 = r127;
        r114 = r131;
        r118 = r125;
        r117 = r124;
        r103 = r132;
        r106 = 0;
        goto L59
    L68:
        return r104;
    L52:
        if (r123.intValue() != r130) goto L54;
        r127.put("is_from_click_softlink", "true");
        goto L54
    L46:
        if (r123.intValue() != r129) goto L48;
        r127.put("is_from_click_option", "true");
    L67:
        return Unit.INSTANCE;
    L25:
        r111 = null;
        goto L26
    L21:
        r122 = false;
    L65:
        return Unit.INSTANCE;
    L7:
        r101 = new QuickReplyVMDependencyImpl$sendQuickReply$1(r210, r213);
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c
    public final void b(b r110, QuickReplyItem r111, int r112, Context r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, "vmData");
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.c(r110, r111, r112);
        Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> r100 = r110.f309569g;
        if (r100 == null) goto L5;
        Boolean r115 = r100.invoke(r110.f309564b, r110.f309571i, r110.f309573k, r111, Integer.valueOf(r112), Integer.valueOf(r114));
    L7:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == false) goto L9;
        return;
    L9:
        Integer r116 = r111.getActionType();
        boolean r117 = false;
        if (r116 == null) goto L25;
        int r118 = r116.intValue();
        String r101 = r111.getSchemaPayload();
        if (r101 == null) goto L14;
        String r102 = StringsKt.trim(r101).toString();
    L16:
        if (r118 < ActionType.OPERATION.getValue()) goto L25;
        if (r102 != null) goto L19;
    L22:
        boolean r119 = true;
    L23:
        if (r119 == true) goto L25;
        boolean r120 = true;
    L27:
        if (r120 == false) goto L64;
        String r121 = r111.getSchemaPayload();
        if (r121 == null) goto L31;
        String r122 = StringsKt.trim(r121).toString();
    L32:
        if (r122 != null) goto L34;
    L37:
        boolean r103 = true;
    L39:
        if (r103 == true) goto L59;
        if (r113 == null) goto L59;
        Map<String, String> r104 = r111.getExtraParams();
        if (r104 == null) goto L45;
        String r105 = r104.get("source");
    L47:
        if (Intrinsics.areEqual(r105, "cta_button") == false) goto L56;
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r106 = ICommerceMembershipService.a.a();
        if (r106 == null) goto L56;
        String r107 = f(r111, false);
        if (r107 == null) goto L56;
        SmartRouter.buildRoute(r113, r107).d();
        r106.w(r107, null);
        r117 = true;
    L56:
        if (r117 == false) goto L58;
        FLogger.f375446a.i("QuickReplyVMDependency", "open membership url, msgId=" + r110.f309564b + ", actionType=" + r111.getActionType());
        return;
    L58:
        FLogger.f375446a.i("QuickReplyVMDependency", "open url, msgId=" + r110.f309564b + ", actionType=" + r111.getActionType());
        SmartRouter.buildRoute(r113, r122).d();
        return;
    L45:
        r105 = null;
    L59:
        FLogger r123 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("skip open url, msgId=");
        r108.append(r110.f309564b);
        r108.append(", actionType=");
        r108.append(r111.getActionType());
        r108.append(", hasContext=");
        if (r113 == null) goto L62;
        r117 = true;
    L62:
        r108.append(r117);
        r123.i("QuickReplyVMDependency", r108.toString());
        return;
    L34:
        if (r122.length() == 0) goto L37;
        r103 = false;
        goto L39
    L31:
        r122 = null;
        goto L32
    L64:
        Integer r124 = r111.getActionType();
        int r125 = ActionType.SEND_NEW_MSG.getValue();
        if (r124 != null) goto L68;
    L69:
        int r126 = ActionType.SEND_NEW_MSG_WITH_REPLY.getValue();
        if (r124 != null) goto L73;
    L75:
        FLogger.f375446a.i("QuickReplyVMDependency", "unsupported actionType=" + r111.getActionType());
        return;
    L73:
        if (r124.intValue() != r126) goto L75;
    L76:
        BuildersKt.launch$default(this.f309561a, null, null, new QuickReplyVMDependencyImpl$onItemClick$1(this, r110, r111, null), 3, null);
        return;
    L68:
        if (r124.intValue() == r125) goto L76;
    L19:
        if (r102.length() == 0) goto L22;
        r119 = false;
        goto L23
    L14:
        r102 = null;
    L25:
        r120 = false;
        goto L27
    L5:
        r115 = null;
        goto L7
    }
}
