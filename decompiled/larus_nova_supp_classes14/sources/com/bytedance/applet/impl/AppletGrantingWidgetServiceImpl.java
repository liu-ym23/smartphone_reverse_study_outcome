package com.bytedance.applet.impl;

import android.content.Context;
import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.applet.grantingV2.StrategyType;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.larus.bmhome.chat.api.IAppletGrantingWidgetService;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J&\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J0\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"\u0018\u00010!j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"\u0018\u0001`#2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001dH\u0002¨\u0006("}, d2 = {"Lcom/bytedance/applet/impl/AppletGrantingWidgetServiceImpl;", "Lcom/larus/bmhome/chat/api/IAppletGrantingWidgetService;", "<init>", "()V", "bindData", "Lcom/larus/bmhome/chat/api/CardModel;", "permissionData", "", "msgData", "Lcom/larus/bmhome/chat/api/MsgData;", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/larus/bmhome/chat/api/Delegate;", "unbindData", "", "onExpose", "onUnexpose", "operateResult", "agree", "", "weakReference", "Landroid/content/Context;", "cardModel", "onNewMessageInput", "latestMsgID", "transformCardData", "cardData", "Lcom/bytedance/ai/applet/granting/AppletGrantingCardData;", "transformGrantingType", "Lcom/larus/bmhome/chat/api/PermissionType;", "grantingType", "Lcom/bytedance/ai/applet/granting/GrantingType;", "traceInfoWithMessageId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "transformToGrantingCardData", "transformToGrantingType", "permissionType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletGrantingWidgetServiceImpl implements IAppletGrantingWidgetService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public AppletGrantingWidgetServiceImpl() {
    }

    public static HashMap f(com.larus.bmhome.chat.api.r0 r2) {
        if (StringsKt.isBlank(r2.a) == true) goto L5;
        HashMap r0 = r2.g;
        if (r0 == null) goto L9;
        HashMap r1 = new HashMap(r0);
    L10:
        r1.putIfAbsent("message_id", r2.a);
        return r1;
    L9:
        r1 = new HashMap();
        goto L10
    L5:
        return r2.g;
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "latestMsgID");
        McpGrantingManager.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "latestMsgID");
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "onNewMessageInput: latestMsgID=".concat(r4));
        McpGrantingManager.d("new_message", r4);
    }

    public final void d(com.larus.bmhome.chat.api.r0 r11) {
        Intrinsics.checkNotNullParameter(r11, "msgData");
        McpGrantingManager r1 = McpGrantingManager.a;
        u2.b r12 = new u2.b(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f, f(r11));
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "msgData");
        String r0 = r12.a;
        com.bytedance.ai.utils.g r2 = com.bytedance.ai.utils.g.a;
        r2.i("McpGrantingManagerV2", "onExpose: " + r12.f + ": msg: " + r0 + ", card: " + r12.c);
        com.bytedance.ai.applet.grantingV2.f r13 = (com.bytedance.ai.applet.grantingV2.f) McpGrantingManager.b.get(r0);
        if (r13 != null) goto L5;
        r2.e("McpGrantingManagerV2", "onExpose: No context found for msgID: " + r0);
        return;
    L5:
        com.bytedance.ai.applet.grantingV2.i r3 = r13.g;
        if (r3 != null) goto L8;
        r2.w("McpGrantingManagerV2", "exposeTracking: No strategy found");
        return;
    L8:
        StrategyType r4 = r3.g();
        int[] r5 = McpGrantingManager.a.a;
        int r6 = r5[r4.ordinal()];
        if (r6 != 1) goto L11;
        Object r7 = r3.a();
        String r8 = null;
        if ((r7 instanceof u2.k) == false) goto L57;
        u2.k r9 = (u2.k) r7;
    L58:
        if (r9 == null) goto L60;
        r8 = r9.c();
    L60:
        com.bytedance.ai.monitor.b.b("doubao_apps_system_auth_card_show", new com.bytedance.ai.applet.grantingV2.q(McpGrantingManager.h(r8), r13));
        return;
    L57:
        r9 = null;
        goto L58
    L11:
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L18;
        if (r6 == 4) goto L18;
        if (r6 == 5) goto L18;
        throw new NoWhenBranchMatchedException();
    L18:
        int r10 = r5[r3.g().ordinal()];
        if (r10 == 2) goto L26;
        if (r10 == 3) goto L25;
        if (r10 == 4) goto L24;
        if (r10 == 5) goto L24;
        String r14 = "";
    L27:
        String r15 = r3.c().c();
        if (r15 != null) goto L30;
    L52:
        String r16 = "requesting";
    L53:
        com.bytedance.ai.monitor.b.b("doubao_apps_agreement_card_show", new com.bytedance.ai.applet.grantingV2.r(r14, r13, r16));
        return;
    L30:
        switch(r15.hashCode()) {
            case -682587753: goto L50;
            case 280295099: goto L47;
            case 664583344: goto L44;
            case 854280074: goto L41;
            case 1085547216: goto L37;
            case 1100137118: goto L35;
            case 2084348283: goto L33;
            default: goto L52;
        };
    L35:
        String r17 = "revoked";
    L51:
        r15.equals(r17);
        goto L52
    L50:
        r17 = "pending";
        goto L51
    L33:
        if (r15.equals("refused_by_history") == false) goto L52;
    L39:
        r16 = "rejected";
        goto L53
    L37:
        if (r15.equals("refused") == true) goto L39;
    L41:
        if (r15.equals("granted_without_system") == false) goto L52;
    L49:
        r16 = "authorized";
        goto L53
    L44:
        if (r15.equals("granted_by_history") == true) goto L49;
    L47:
        if (r15.equals("granted") == true) goto L49;
    L24:
        r14 = "login";
        goto L27
    L25:
        r14 = "privacy";
        goto L27
    L26:
        r14 = "aweme_login";
        goto L27
    }

    public final void e(com.larus.bmhome.chat.api.r0 r11) {
        Intrinsics.checkNotNullParameter(r11, "msgData");
        McpGrantingManager r1 = McpGrantingManager.a;
        u2.b r12 = new u2.b(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f, f(r11));
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "msgData");
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "onUnexpose:" + r12.f + ": msg: " + r12.a + ", card: " + r12.c);
    }

    public final void b(boolean r17, WeakReference<Context> r18, com.larus.bmhome.chat.api.f r19) {
        Intrinsics.checkNotNullParameter(r18, "weakReference");
        Intrinsics.checkNotNullParameter(r19, "cardModel");
        McpGrantingManager r2 = McpGrantingManager.a;
        com.larus.bmhome.chat.api.u0 r3 = r19.b;
        l r6 = new l();
        com.larus.bmhome.chat.api.r0 r4 = r19.a;
        u2.a r5 = new u2.a(new u2.b(r4.a, r4.b, r4.c, r4.d, r4.e, r4.f, f(r4)), r6, r19.c, r19.d, r19.e, r19.f, r19.g, r19.h, r19.i, r19.j, r19.k);
        r2.getClass();
        McpGrantingManager.j(r17, r18, r5);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.applet.impl.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.bytedance.applet.impl.j] */
    public final com.larus.bmhome.chat.api.f c(String r20, com.larus.bmhome.chat.api.r0 r21, final WeakReference<com.larus.bmhome.chat.api.k> r22) {
        Intrinsics.checkNotNullParameter(r20, "permissionData");
        Intrinsics.checkNotNullParameter(r21, "msgData");
        Intrinsics.checkNotNullParameter(r22, "delegate");
        McpGrantingManager r4 = McpGrantingManager.a;
        u2.b r1 = new u2.b(r21.a, r21.b, r21.c, r21.d, r21.e, r21.f, f(r21));
        ?? r5 = new i(r22, this);
        ?? r7 = new j(r22);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r20, "grantingData");
        Intrinsics.checkNotNullParameter(r1, "msgData");
        Intrinsics.checkNotNullParameter(r5, "callback");
        String r2 = r1.a;
        if (StringsKt.isBlank(r2) == false) goto L6;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "bindData: msgID is blank: " + r2);
    L94:
        return null;
    L6:
        if (StringsKt.isBlank(r20) == false) goto L8;
        boolean r9 = true;
    L10:
        if (r9 == false) goto L95;
    L27:
        u2.e r14 = null;
    L28:
        if (r14 != null) goto L30;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "bindData: grantingData is null or blank");
        goto L94
    L30:
        List r0 = r14.h();
        if (r0 != null) goto L33;
    L36:
        boolean r3 = true;
    L37:
        if (r3 == false) goto L39;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "bindData: granting list is empty.");
        goto L94
    L39:
        String r6 = r1.a;
        List r8 = r14.h();
        if (r8 != null) goto L42;
        r8 = CollectionsKt.emptyList();
    L42:
        u2.f r10 = com.bytedance.ai.applet.grantingV2.v.a(CollectionsKt.sortedWith(r8, new com.bytedance.ai.applet.grantingV2.u()), null, r14.b());
        if (r10 != null) goto L46;
    L57:
        boolean r11 = false;
    L88:
        if (r11 == false) goto L90;
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "the card " + r1.a + " has expired");
        goto L94
    L90:
        List r12 = r14.h();
        if (r12 != null) goto L93;
        r12 = CollectionsKt.emptyList();
    L93:
        com.bytedance.ai.applet.grantingV2.f r13 = new com.bytedance.ai.applet.grantingV2.f(r14, CollectionsKt.sortedWith(r12, new com.bytedance.ai.applet.grantingV2.u()), McpGrantingManager.c(r1, r14), r5, r7);
        McpGrantingManager.b.put(r2, r13);
        McpGrantingManager.l(r13, true);
        goto L94
    L46:
        if (com.bytedance.ai.applet.grantingV2.g.c(r10.c()) == true) goto L49;
    L50:
        boolean r15 = false;
    L52:
        if (r15 == false) goto L54;
        u2.e r16 = u2.e.a(r14, "expired", null, 191);
    L56:
        if (com.bytedance.ai.applet.grantingV2.g.b(r10, r16.b()) == false) goto L57;
        com.bytedance.ai.applet.grantingV2.h r17 = McpGrantingManager.e(r10);
        if (r17 == null) goto L86;
        com.bytedance.ai.applet.grantingV2.i r18 = r17.b(r10, r16.b());
        if (r18 == null) goto L86;
        Pair r19 = r18.b(McpGrantingManager.c(r1, r16));
        u2.a r110 = (u2.a) r19.getFirst();
        String r111 = (String) r19.getSecond();
        if (r111 != null) goto L66;
    L69:
        boolean r112 = true;
    L70:
        if (r112 == false) goto L72;
        String r113 = r10.e();
    L73:
        u2.e r23 = com.bytedance.ai.applet.grantingV2.v.c(r16, u2.f.a(r10, null, r113, 15));
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "handleExpiredCardOnBind: render expired card, msgID=" + r6 + ", shouldExpireByHistory=" + r15);
        r5.a(r6, r110);
        if (r15 == true) goto L82;
        if (r111 != null) goto L77;
    L80:
        boolean r114 = true;
    L81:
        if (r114 == false) goto L82;
    L85:
        McpGrantingManager.b.remove(r6);
    L87:
        r11 = true;
        goto L88
    L77:
        if (r111.length() == 0) goto L80;
        r114 = false;
    L82:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r24 = AppletRuntimeManager.d;
        if (r24 == null) goto L85;
        r24.t(r6, r1.c, com.bytedance.ai.applet.base.gson.e.c(r23), new com.bytedance.ai.applet.grantingV2.n(r6));
        goto L85
    L72:
        r113 = r111;
        goto L73
    L66:
        if (r111.length() == 0) goto L69;
        r112 = false;
    L86:
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "handleExpiredCardOnBind: Failed to create expired strategy for msgID=" + r6);
        goto L87
    L54:
        r16 = r14;
        goto L56
    L49:
        if (com.bytedance.ai.applet.grantingV2.g.b(r10, r14.b()) == true) goto L50;
        r15 = !r7.a(r6);
        goto L52
    L33:
        if (r0.isEmpty() == true) goto L36;
        r3 = false;
        goto L37
    L95:
        Lazy r25 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L23 JsonSyntaxException -> L25
        JsonObject r26 = (JsonObject) com.bytedance.ai.applet.base.gson.e.a(r20, JsonObject.class);     // Catch: Exception -> L23 JsonSyntaxException -> L25
        if (r26.has("cardStatus") == true) goto L15;
    L17:
        boolean r27 = false;
    L18:
        u2.e r28 = (u2.e) GsonProtectorUtils.fromJson(com.bytedance.ai.applet.base.gson.c.a(), r26, u2.e.class);     // Catch: Exception -> L23 JsonSyntaxException -> L25
        if (r27 == false) goto L21;
    L20:
        r14 = r28;
        goto L28
    L21:
        r28 = u2.e.a(r28, "expired", null, 191);     // Catch: Exception -> L23 JsonSyntaxException -> L25
    L15:
        if (r26.get("cardStatus").isJsonNull() == true) goto L17;
        r27 = true;
    L23:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "parseGrantingData Exception: " + e.getMessage());
    L25:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "parseGrantingData JsonSyntaxException: " + e.getMessage());
        goto L27
    L8:
        r9 = false;
        goto L10
    }
}
