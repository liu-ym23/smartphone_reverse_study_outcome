package com.bytedance.applet.impl;

import android.app.Application;
import android.content.Context;
import com.bytedance.ai.api.model.output.AIOutputContentType;
import com.bytedance.applet.context.ContextManager;
import com.bytedance.applet.event.EventDispatcher;
import com.bytedance.applet.event.EventDispatcher$a;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.applet.utils.PendingPushMessageQueue;
import com.bytedance.applet.utils.SuspendReceiveMessage;
import com.bytedance.applet.utils.WidgetContentManager;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletHostMessageServiceImpl implements r4.h {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AIOutputContentType.values().length];
            r0[AIOutputContentType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AIOutputContentType.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public AppletHostMessageServiceImpl() {
    }

    public final j2.a j(j2.b r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        AIOutputContentType r0 = r5.getType();
        int r1 = b.a[r0.ordinal()];
        int r2 = 1;
        if (r1 != 1) goto L5;
        r2 = 100;
    L10:
        MessageUtils r3 = MessageUtils.a;
        String r6 = r5.b;
        r3.getClass();
        com.larus.bmhome.chat.model.repo.a2 r7 = MessageUtils.c(r6, r2, null, null);
        return new j2.a(r7.b(), r7.a(), r7.c(), r7.d());
    L5:
        if (r1 == 2) goto L10;
        throw new NoWhenBranchMatchedException();
    }

    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        ContextManager.a.getClass();
        ContextManager.d(r2, r3);
    }

    public final Object e(String r2, Continuation<? super String> r3) {
        return MessageUtils.a.g(r2, r3);
    }

    public final void g(Map<String, String> r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r9.isEmpty() == false) goto L5;
        String r11 = null;
    L9:
        FLogger.a.d("AppletHostMessageServiceImpl", "createLocalMsg content " + r11);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AppletHostMessageServiceImpl$createLocalMsg$1(r11, r10, null), 3, null);
        return;
    L5:
        String r0 = r9.get("appletId");
        String r2 = r9.get("widgetName");
        String r12 = r9.get("widgetData");
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        JSONObject r4 = new JSONObject();
        r4.put("applet_id", r0);
        r4.put("response_for_model", "");
        r4.put("widget_data", r12);
        r4.put("widget_id", r2);
        r11 = r4.toString();
        goto L9
    }

    public final Object h(j2.b r20, Continuation<? super Boolean> r21) {
        if ((r21 instanceof AppletHostMessageServiceImpl$syncBotReply$1) == false) goto L7;
        AppletHostMessageServiceImpl$syncBotReply$1 r2 = (AppletHostMessageServiceImpl$syncBotReply$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        String r15 = "createMessage type:";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        j2.b r0 = (j2.b) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r5 = "AppletServiceImpl";
        r15 = r15;
    L38:
        Boolean r6 = (Boolean) r1;
        FLogger.a.d(r5, r15 + r0.getType().name() + "  receiveMsgResult " + r6);
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SuspendReceiveMessage r7 = (SuspendReceiveMessage) r2.L$2;
        String r8 = (String) r2.L$1;
        j2.b r9 = (j2.b) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r5 = "AppletServiceImpl";
    L27:
        boolean r10 = ((Boolean) r1).booleanValue();
        FLogger.a.d(r5, r15 + r9.getType().name() + " saveBotResult " + r10);
        if (r10 == true) goto L34;
        r7.getClass();
        EventDispatcher r11 = EventDispatcher.a;
        SuspendReceiveMessage.a r12 = r7.c;
        Intrinsics.checkNotNullParameter(r12, "listener");
        EventDispatcher.h.remove(r12);
        Function1<? super Boolean, Unit> r14 = r7.a;
        if (r14 == null) goto L33;
        r14.invoke(Boolean.FALSE);
    L33:
        return Boxing.boxBoolean(false);
    L34:
        r2.L$0 = r9;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 2;
        r1 = r7.a(r8, r2);
        if (r1 != r13) goto L37;
        return r13;
    L37:
        r0 = r9;
        goto L38
    L16:
        ResultKt.throwOnFailure(r1);
        int r16 = wf9.b.a;
        String r17 = com.flow.kmp.common.util.i.a();
        SuspendReceiveMessage r18 = new SuspendReceiveMessage();
        EventDispatcher r19 = EventDispatcher.a;
        SuspendReceiveMessage.a r22 = r18.c;
        Intrinsics.checkNotNullParameter(r22, "listener");
        EventDispatcher.h.add(r22);
        int r23 = b.a[r20.getType().ordinal()];
        if (r23 == 1) goto L22;
        if (r23 != 2) goto L21;
        int r24 = 1;
    L23:
        MessageUtils r25 = MessageUtils.a;
        String r26 = r20.d;
        String r27 = r20.f;
        String r28 = r20.e;
        String r110 = r20.b;
        List<String> r29 = r20.h;
        boolean r30 = r20.g;
        Map r31 = r20.c;
        List<String> r111 = r20.i;
        r2.L$0 = r20;
        r2.L$1 = r17;
        r2.L$2 = r18;
        r2.label = 1;
        r25.getClass();
        r7 = r18;
        r5 = "AppletServiceImpl";
        Object r32 = r25.b(r26, r27, r28, CollectionsKt.listOf(MessageUtils.c(r110, r24, r31, r17)), r29, r30, r111, r2);
        if (r32 != r13) goto L26;
        return r13;
    L26:
        r9 = r20;
        r8 = r17;
        r1 = r32;
        goto L27
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r24 = 100;
    L7:
        r2 = new AppletHostMessageServiceImpl$syncBotReply$1(this, r21);
        goto L8
    }

    public final void k(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "botId");
        EventDispatcher r1 = EventDispatcher.a;
        Intrinsics.checkNotNullParameter(r5, "botId");
        EventDispatcher$a r0 = EventDispatcher.k(r5);
        boolean r2 = true;
        r0.b = true;
        r0.c = true;
        jw3.c r3 = jw3.c.a;
        jw3.a r4 = jw3.c.a();
        if (r4 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        r0.d = r7;
        if (r6 != null) goto L11;
    L14:
        if (r2 == true) goto L17;
        ((ConcurrentHashMap) EventDispatcher.f).put(r6, r5);
        return;
    L17:
        return;
    L11:
        if (r6.length() == 0) goto L14;
        r2 = false;
        goto L14
    L5:
        if (r4.k() != true) goto L7;
        r7 = true;
        goto L8
    }

    public final void l(String r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "conversationId");
        Intrinsics.checkNotNullParameter(r19, "msg");
        com.larus.bmhome.chat.model.repo.u1 r1 = zh8.a.a.u1();
        MessageStatus r7 = MessageStatus.MessageStatus_INVISIBLE;
        com.larus.bmhome.chat.model.repo.u1.a.f(r1, r19, r18, "", MapsKt.mapOf(TuplesKt.to("hidden_force_context", CommentScene.COMMENTSCENE_NO_AWEME)), new y(), r7, null, false, null, "utils#sendTextMessage", null, null, null, false, 27528);
    }

    public static final void n(Ref.ObjectRef<Application.ActivityLifecycleCallbacks> r1, Ref.ObjectRef<String> r2, Application r3) {
        Application.ActivityLifecycleCallbacks r0 = (Application.ActivityLifecycleCallbacks) r1.element;
        if (r0 == null) goto L5;
        r3.unregisterActivityLifecycleCallbacks(r0);
    L5:
        r1.element = null;
        r2.element = null;
    }

    public final Object a(Context r11, String r12, Continuation<? super Boolean> r13) {
        if ((r13 instanceof AppletHostMessageServiceImpl$clearContext$1) == false) goto L7;
        AppletHostMessageServiceImpl$clearContext$1 r0 = (AppletHostMessageServiceImpl$clearContext$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L19:
        boolean r15 = ub8.d.a((ub8.b) r14);
    L22:
        return Boxing.boxBoolean(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (NetworkUtils.isNetworkAvailable(r11) == false) goto L20;
        IConversationRepoService r16 = zh8.a.b;
        IConversationRepoService.a.f(r16, r12, false, false, OmniBreakReason.OmniBreakReason_CLEAR_CONTEXT, 6);
        r0.label = 1;
        r14 = r16.n(r12, 3, "applet_service", r0);
        if (r14 != r2) goto L19;
        return r2;
    L20:
        r15 = false;
    L7:
        r0 = new AppletHostMessageServiceImpl$clearContext$1(this, r13);
        goto L8
    }

    public final void m(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "conversationId");
        Intrinsics.checkNotNullParameter(r12, "prompt");
        Intrinsics.checkNotNullParameter(r13, "extraData");
        FLogger r0 = FLogger.a;
        r0.i("AppletHostMessageServiceImpl", "sendFollowUpMessage, conversationId: " + r11 + ", prompt: " + r12 + ", extraData: " + r13);
        if (StringsKt.isBlank(r12) == false) goto L6;
        r0.w("AppletHostMessageServiceImpl", "sendFollowUpMessage skip, prompt is blank");
        return;
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppletHostMessageServiceImpl$sendFollowUpMessage$1(r11, r12, r13, this, null), 3, null);
    }

    public final Object c(String r7, int r8, String r9, String r10, Continuation<? super Boolean> r11) {
        return MessageUtils.a.m(r7, r8, r9, r10, r11);
    }

    public final void d(String r2, String r3, String r4, Map<String, String> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        Intrinsics.checkNotNullParameter(r4, "botID");
        MessageUtils.a.getClass();
        MessageUtils.l(r2, r3, r4, r5, r6);
    }

    public final Object f(String r7, String r8, String r9, String r10, Continuation<? super Boolean> r11) {
        WidgetContentManager r0 = WidgetContentManager.a;
        if (r9 != null) goto L6;
        r9 = "";
    L6:
        return r0.c(r7, r8, r9, r10, r11);
    }

    public final void i(String r7, String r8, String r9, List<j2.a> r10, List<String> r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r7, "botId");
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        Intrinsics.checkNotNullParameter(r10, "messageContents");
        Map<String, List<PendingPushMessageQueue.a>> r0 = PendingPushMessageQueue.a;
        List<j2.a> r13 = r10;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        j2.a r1 = (j2.a) r14.next();
        r3.add(new com.larus.bmhome.chat.model.repo.a2(r1.b(), r1.a(), r1.c(), r1.d()));
        goto L4
    L6:
        PendingPushMessageQueue.b(r7, r8, r9, r3, r11, r12);
    }
}
