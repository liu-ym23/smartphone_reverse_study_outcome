package com.ss.android.lark.keyboard.editor;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.x;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.dto.draft.ScheduleDraftInfo;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.base.o;
import com.ss.android.lark.keyboard.base.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import mob.a;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BaseChatEditor<T extends mob.a> implements com.ss.android.lark.biz.im.api.extension.chat_window.d<T>, cya.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyboardViewModel f428724a;

    public static final class a {
    }

    public static final class b implements KeyboardViewModel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<a7b.a> f428725a;

        public b(j r100) {
            this.f428725a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel.b
        public final void a(a7b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f428725a.resumeWith(Result.m9449constructorimpl(r100));
        }
    }

    static {
    }

    @Override // cya.f
    public Object a(boolean r100, Continuation<? super cya.h> r101) {
        return c(this, r100, r101);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final void isEnable() {
    }

    public BaseChatEditor(KeyboardViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardViewModel");
        this.f428724a = r100;
    }

    @Override // cya.f
    public void b(cya.h r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        n r111 = r110.f465978a;
        Set<RichTextElement.RichTextTag> r100 = x.f416747a;
        Intrinsics.checkNotNullParameter(r111, "params");
        Object r101 = r111.a(cya.b.f465971h);
        Boolean r102 = Boolean.TRUE;
        boolean r103 = Intrinsics.areEqual(r101, r102);
        Intrinsics.checkNotNullParameter(r111, "params");
        boolean r104 = Intrinsics.areEqual(r111.a(com.ss.android.lark.keyboard.inputstate.d.f429430h), r102);
        Log.i("Flow_KB_BaseChatEditor", "saveDraft: clearGeneralDraft == " + r103 + ", clearScheduleDraft=" + r104);
        if (r103 == false) goto L5;
        this.f428724a.clearChatGeneralDraft();
    L5:
        if (r104 == false) goto L7;
        this.f428724a.clearChatScheduleDraft();
    L7:
        KeyboardViewModel r105 = this.f428724a;
        Intrinsics.checkNotNullParameter(r111, "params");
        Draft r106 = new Draft();
        ReEditInfo r107 = (ReEditInfo) r111.a(ReEditInfo.Companion);
        cya.i r108 = (cya.i) r111.a(cya.i.f465980h);
        cya.a r109 = (cya.a) r111.a(cya.a.f465968c);
        o r112 = (o) r111.a(o.f428239f);
        QueryStatusInfo r113 = (QueryStatusInfo) r111.a(QueryStatusInfo.Companion);
        StringBuilder r114 = new StringBuilder("parseDraftFromParams: reEditInfo is null ? ");
        boolean r115 = true;
        if (r107 != null) goto L10;
        boolean r116 = true;
    L11:
        r114.append(r116);
        r114.append(" , replyInfo is null ? ");
        if (r108 != null) goto L14;
        boolean r117 = true;
    L15:
        r114.append(r117);
        r114.append(" , editInfo is null ? ");
        if (r109 != null) goto L18;
        boolean r118 = true;
    L19:
        r114.append(r118);
        r114.append(" , scheduleSendInfo is null ? ");
        if (r112 != null) goto L22;
        boolean r119 = true;
    L23:
        r114.append(r119);
        r114.append(",queryStatusInfo is null ? ");
        if (r113 != null) goto L26;
        boolean r120 = true;
    L27:
        r114.append(r120);
        Log.i("KeyboardEditUtils", r114.toString());
        PartialReplyInfo r121 = null;
        if (r109 == null) goto L30;
        RichText r122 = r109.f465969a;
    L31:
        r106.contentRichText = r122;
        if (r109 == null) goto L34;
        RichText r123 = r109.f465969a;
    L35:
        r106.postRichText = r123;
        if (r109 == null) goto L38;
        String r124 = r109.f465970b;
    L39:
        r106.title = r124;
        if (r108 == null) goto L42;
        String r125 = r108.f465981a;
    L43:
        r106.messageId = r125;
        if (r107 == null) goto L46;
        r106.type = 6;
        r106.reEditMessageId = r107.getMessageId();
    L46:
        if (r112 == null) goto L61;
        r106.type = 7;
        ScheduleDraftInfo r126 = new ScheduleDraftInfo();
        r126.setScheduleSendTime(r112.f428240a);
        r126.setScheduleMessageId(r112.f428243d);
        r126.setPreScheduleMessage(r112.f428244e);
        r106.scheduleDraftInfo = r126;
        p r127 = r112.f428242c;
        if (r127 != null) goto L50;
    L52:
        r115 = false;
    L53:
        if (r115 == false) goto L61;
        String r128 = "";
        r106.messageId = "";
        if (r127 == null) goto L60;
        String r129 = r127.f428247c;
        if (r129 == null) goto L60;
        r128 = r129;
    L60:
        r106.threadId = r128;
        goto L61
    L50:
        if (r127.f428245a != 2) goto L52;
    L61:
        if (r108 == null) goto L63;
        r121 = r108.f465987g;
    L63:
        r106.partialReplyInfo = r121;
        r106.queryStatusInfo = r113;
        Intrinsics.checkNotNullParameter(r111, "params");
        Boolean r130 = (Boolean) r111.a(cya.h.f465975d);
        if (r130 == null) goto L66;
        boolean r131 = r130.booleanValue();
    L67:
        r105.saveAllDraft(r106, r131, false);
        return;
    L66:
        r131 = false;
        goto L67
    L42:
        r125 = null;
        goto L43
    L38:
        r124 = null;
        goto L39
    L34:
        r123 = null;
        goto L35
    L30:
        r122 = null;
        goto L31
    L26:
        r120 = false;
        goto L27
    L22:
        r119 = false;
        goto L23
    L18:
        r118 = false;
        goto L19
    L14:
        r117 = false;
        goto L15
    L10:
        r116 = false;
        goto L11
    }

    public static /* synthetic */ <T extends mob.a> Object c(BaseChatEditor<T> r100, boolean r101, Continuation<? super cya.h> r102) {
        if ((r102 instanceof BaseChatEditor$loadInputState$1) == false) goto L7;
        BaseChatEditor$loadInputState$1 r103 = (BaseChatEditor$loadInputState$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        BaseChatEditor r108 = (BaseChatEditor) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L20:
        return x.c((a7b.a) r105);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        r103.label = 1;
        j r109 = new j(IntrinsicsKt.intercepted(r103), 1);
        r109.C();
        r100.f428724a.resetChatDraft(r101, new b(r109));
        r105 = r109.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L17:
        if (r105 != r106) goto L20;
        return r106;
    L7:
        r103 = new BaseChatEditor$loadInputState$1(r100, r102);
        goto L8
    }
}
