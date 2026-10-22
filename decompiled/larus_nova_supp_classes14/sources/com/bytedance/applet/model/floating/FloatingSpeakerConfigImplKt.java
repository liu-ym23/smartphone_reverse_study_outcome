package com.bytedance.applet.model.floating;

import android.app.Activity;
import android.os.Looper;
import android.view.Window;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.media.MediaResourceManager;
import com.larus.utils.t0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FloatingSpeakerConfigImplKt {
    public static z a;
    public static final g2.a b = null;
    public static final int c = 0;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final int h = 0;
    public static Job i;

    public static final class a implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ kotlinx.coroutines.i<List<Message>> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            kotlinx.coroutines.i<List<Message>> r3 = this.a;
            Result.Companion r0 = Result.Companion;
            r3.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
        }

        public final void onSuccess(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.applet.model.floating.f] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.applet.model.floating.o] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.bytedance.applet.model.floating.r] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.applet.model.floating.d] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.applet.model.floating.s] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.applet.model.floating.t] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.applet.model.floating.u] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.applet.model.floating.v] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.applet.model.floating.w] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.applet.model.floating.x] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.applet.model.floating.y] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.bytedance.applet.model.floating.e] */
    static {
        b = new g2.a(new d(), new s(), new t(), new u(), new v(), new w(), new x(), new y(), new e(), new f(), new o(), new r());
        c = 500;
        d = CommentScene.COMMENTSCENE_NO_AWEME;
        e = "asr_input";
        f = "user_input";
        g = "bot_resp";
        h = 8000;
    }

    public static final void e() {
        z r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        a = null;
        if (r0.b == false) goto L9;
        fa9.e.a.f("voice_input", r0.a);
        return;
    L9:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if (r1 == null) goto L18;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L19;
        r2.clearFlags(128);
        return;
    L19:
        return;
    L18:
        return;
    L15:
        t0.a.post(new g());
    }

    public static final void b(Message r1) {
        if (com.larus.media.o.a() == false) goto L10;
        MediaResourceManager.a r0 = new MediaResourceManager.a();
        if (r1 == null) goto L7;
        String r2 = r1.getLocalMessageId();
    L8:
        r0.b = r2;
        r0.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        Lazy r3 = MediaResourceManager.a;
        MediaResourceManager.d(r0);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static final void c(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FloatingSpeakerConfigImplKt$deleteOnNoAudioContent$1(r7, null), 3, null);
    }

    public static final Object a(String r9, Continuation r10) {
        if ((r10 instanceof FloatingSpeakerConfigImplKt$initChatData$1) == false) goto L7;
        FloatingSpeakerConfigImplKt$initChatData$1 r0 = (FloatingSpeakerConfigImplKt$initChatData$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        JSONArray r12 = (JSONArray) r0.L$1;
        JSONObject r4 = (JSONObject) r0.L$0;
        ResultKt.throwOnFailure(r11);
        JSONObject r5 = r4;
    L18:
        Iterator r13 = ((List) r11).iterator();
    L20:
        if (r13.hasNext() == false) goto L53;
        Message r6 = (Message) r13.next();
        String r7 = r6.getContent();
        if (r7 != null) goto L24;
    L27:
        boolean r8 = true;
    L28:
        if (r8 == true) goto L20;
        if (com.larus.bmhome.chat.bean.d.G0(r6) == false) goto L38;
        if (r6.getContentType() != 1) goto L38;
        if (r6.getSourceFromAsr() == false) goto L38;
        JSONObject r14 = new JSONObject();
        r14.put("type", e);
        r14.put("data", r6.getContent());
        r14.put("time", String.valueOf(r6.getCreateTime()));
        r12.put(r14);
    L38:
        if (com.larus.bmhome.chat.bean.d.G0(r6) == false) goto L47;
        if (r6.getMessageStatusLocal() != 11) goto L47;
        if (r6.getContentType() == 1) goto L47;
        if (r6.getSourceFromAsr() == false) goto L47;
        JSONObject r15 = new JSONObject();
        r15.put("type", f);
        r15.put("data", r6.getContent());
        r15.put("time", String.valueOf(r6.getCreateTime()));
        r12.put(r15);
    L47:
        if (com.larus.bmhome.chat.bean.d.G0(r6) == true) goto L20;
        String r16 = r6.getContent();
        if (r16 == null) goto L20;
        if (r16.length() > h) goto L20;
        JSONObject r17 = new JSONObject();
        r17.put("type", g);
        JSONObject r18 = new JSONObject();
        r18.put("content", r16);
        r18.put("content_type", r6.getContentType());
        Unit r19 = Unit.INSTANCE;
        r17.put("data", r18.toString());
        r17.put("time", String.valueOf(r6.getCreateTime()));
        r12.put(r17);
        goto L20
    L24:
        if (r7.length() == 0) goto L27;
        r8 = false;
        goto L28
    L53:
        r5.put("chat_context", r12);
        ISettingRepoService r20 = zh8.a.c;
        r5.put("asr_language", r20.S0());
        r5.put("model", r20.Z(r20.S0()));
        r5.put("speech_language", r20.Q0());
        Object r21 = r5;
    L54:
        return r21;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        JSONObject r110 = new JSONObject();
        JSONArray r22 = new JSONArray();
        r0.L$0 = r110;
        r0.L$1 = r22;
        r0.label = 1;
        Object r23 = d(r9, null, r0);
        r21 = r2;
        if (r23 == r2) goto L54;
        r5 = r110;
        r11 = r23;
        r12 = r22;
    L7:
        r0 = new FloatingSpeakerConfigImplKt$initChatData$1(r10);
        goto L8
    }

    public static final Object d(String r23, wc9.e r24, Continuation<? super List<Message>> r25) {
        if ((r25 instanceof FloatingSpeakerConfigImplKt$getMessageList$1) == false) goto L7;
        FloatingSpeakerConfigImplKt$getMessageList$1 r1 = (FloatingSpeakerConfigImplKt$getMessageList$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        MessageListRequest r4 = (MessageListRequest) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L34:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r5 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r6 = r0;
        String r7 = r5;
    L21:
        wc9.e r9 = (wc9.e) r6;
    L23:
        String r12 = r7;
        if (r9 == null) goto L28;
        Integer r10 = r9.j;
        if (r10 == null) goto L28;
        int r13 = r10.intValue();
    L29:
        int r11 = ChatMessageReceiverModel.P;
        MessageListRequest r14 = new MessageListRequest(r12, r13, 0, ((Number) com.larus.im.internal.core.message.utils.h.a.getValue()).intValue(), Long.MIN_VALUE, null, false, 100, null);
        r1.L$0 = r14;
        r1.label = 2;
        kotlinx.coroutines.j r15 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r1), 1);
        r15.C();
        com.larus.im.d.e().getMessageListFromLocal(r14, new a(r15));
        r0 = r15.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L32:
        if (r0 != r8) goto L34;
        return r8;
    L28:
        r13 = 0;
        goto L29
    L16:
        ResultKt.throwOnFailure(r0);
        if (r24 != null) goto L22;
        IConversationRepoService r16 = zh8.a.b;
        r7 = r23;
        r1.L$0 = r7;
        r1.label = 1;
        r6 = IConversationRepoService.a.c(r16, r23, false, null, r1, 6);
        if (r6 != r8) goto L21;
        return r8;
    L22:
        r7 = r23;
        r9 = r24;
    L7:
        r1 = new FloatingSpeakerConfigImplKt$getMessageList$1(r25);
        goto L8
    }
}
