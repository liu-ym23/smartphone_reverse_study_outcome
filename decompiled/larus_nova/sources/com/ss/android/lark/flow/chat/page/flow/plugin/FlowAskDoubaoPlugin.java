package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.text.Editable;
import android.widget.EditText;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.inputstate.InputStateController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowAskDoubaoPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c implements ggb.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IMessageListComponent f422732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IKeyboardComponent f422733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f422734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineScope f422735j;

    public interface a {
        @SdkCall(50113)
        RucketJob<PullDoubaoChatterResponse> getDoubaoChatter(PullDoubaoChatterRequest r100);
    }

    public static final class b implements IMessageListComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowAskDoubaoPlugin f422736a;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final /* synthetic */ void A9() {
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void B9(ChatChatter r100) {
            Intrinsics.checkNotNullParameter(r100, "chatChatter");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void e(BasePageStore r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void w9(ThreadTopic r100) {
            Intrinsics.checkNotNullParameter(r100, "threadTopic");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final /* synthetic */ void x9() {
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void z9(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void y9() {
            IMessageListComponent r100 = this.f422736a.f422732g;
            if (r100 == null) goto L8;
            mya.h r101 = r100.j5();
            if (r101 == null) goto L9;
            r101.a(ggb.a.class, this.f422736a);
            return;
        L9:
            return;
        }

        public b(FlowAskDoubaoPlugin r100) {
            this.f422736a = r100;
        }
    }

    @Override // ggb.a
    public final void m() {
        IKeyboardComponent r100 = this.f422733h;
        cya.d r101 = null;
        if (r100 == null) goto L7;
        com.ss.android.lark.keyboard.b r102 = r100.n();
        if (r102 == null) goto L7;
        com.ss.android.lark.keyboard.keyboard2.b r103 = r102.L();
    L9:
        if ((r103 instanceof FlowChatKeyboardEditor) == false) goto L11;
        FlowChatKeyboardEditor r104 = (FlowChatKeyboardEditor) r103;
    L12:
        if (r104 == null) goto L14;
        r101 = r104.a();
    L14:
        if (r101 != null) goto L17;
        Log.e(TitlebarViewModel.LOG_TAG, "exitAskDoubaoMode, controller is null ");
        return;
    L17:
        InputStateController r105 = (InputStateController) r101;
        if (r105.d().a() != 2) goto L21;
        r105.pop();
        return;
    L21:
        return;
    L11:
        r104 = null;
    L7:
        r103 = null;
        goto L9
    }

    public FlowAskDoubaoPlugin() {
        this.f422735j = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        CoroutineScopeKt.cancel$default(this.f422735j, null, 1, null);
    }

    public static final Object F(FlowAskDoubaoPlugin r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof FlowAskDoubaoPlugin$insertAtDoubao$1) == false) goto L7;
        FlowAskDoubaoPlugin$insertAtDoubao$1 r102 = (FlowAskDoubaoPlugin$insertAtDoubao$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        Chatter r107 = null;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L13
    L28:
        PullDoubaoChatterResponse r108 = (PullDoubaoChatterResponse) r104;     // Catch: Exception -> L13
    L31:
        if (r108 == null) goto L33;
        r107 = r108.doubao;
    L33:
        com.ss.android.lark.chat.entity.chatter.Chatter r109 = com.ss.android.lark.parser.internal.j.a(r107);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r110 = r100.f422734i;
        if (r110 == null) goto L57;
        ChatWindowOpenViewModel r111 = r110.c();
        if (r111 == null) goto L57;
        MutableLiveData<Chat> r112 = r111.getChat();
        if (r112 == null) goto L57;
        if (r112.getValue() == null) goto L57;
        String r113 = r109.getId();
        String r114 = m.b(r109, ChatterNameDisplayRule.ALIAS_NAME, false);
        String r115 = m.b(r109, ChatterNameDisplayRule.NAME, false);
        IKeyboardComponent r116 = r100.f422733h;
        if (r116 == null) goto L62;
        com.ss.android.lark.keyboard.b r117 = r116.n();
        if (r117 == null) goto L62;
        com.ss.android.lark.keyboard.keyboard2.b r118 = r117.L();
        if (r118 == null) goto L62;
        EditText r119 = r118.c();
        if (r119 == null) goto L62;
        Intrinsics.checkNotNull(r114);
        Intrinsics.checkNotNull(r115);
        ExtensionEditTextCompatKt.j(r119, r113, r114, r115, false, false, true);
        Editable r120 = r119.getText();
        if (r120 == null) goto L61;
        r119.setSelection(r120.length());
    L61:
        return Unit.INSTANCE;
    L62:
        return Unit.INSTANCE;
    L57:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r121 = r100.f422734i;
        if (r121 == null) goto L23;
        v r122 = w.a(r121);
        if (r122 == null) goto L23;
        b38.b r123 = r122.y();
        if (r123 == null) goto L23;
        a r124 = (a) r123.create(a.class);
    L24:
        PullDoubaoChatterRequest.Builder r125 = new PullDoubaoChatterRequest.Builder().sync_data_strategy(SyncDataStrategy.LOCAL);
        CoroutineDispatcher r126 = Dispatchers.getIO();     // Catch: Exception -> L13
        FlowAskDoubaoPlugin$insertAtDoubao$response$1 r127 = new FlowAskDoubaoPlugin$insertAtDoubao$response$1(r124, r125, null);     // Catch: Exception -> L13
        r102.label = 1;     // Catch: Exception -> L13
        r104 = BuildersKt.withContext(r126, r127, r102);     // Catch: Exception -> L13
        if (r104 != r105) goto L28;
        return r105;
    L23:
        r124 = null;
    L30:
        r108 = null;
    L7:
        r102 = new FlowAskDoubaoPlugin$insertAtDoubao$1(r100, r101);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f422734i = r100;
        this.f422733h = (IKeyboardComponent) r100.a(IKeyboardComponent.class);
        IMessageListComponent r102 = (IMessageListComponent) r100.a(IMessageListComponent.class);
        if (r102 == null) goto L6;
        this.f422732g = r102;
        r102.m(new b(this));
        return;
    }

    @Override // ggb.a
    public final void q(String r110, int r111, PartialReplyInfo r112, boolean r113, final boolean r114, final boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "messageId");
        IMessageListComponent r100 = this.f422732g;
        if (r100 == null) goto L57;
        final MessageInfo r116 = r100.getMessageInfoById(r110);
        if (r116 == null) goto L57;
        if (r112 == null) goto L14;
        RichText r101 = r112.getContent();
        if (r101 == null) goto L14;
        RichTextExtraInfo r102 = r101.getExtraInfo();
        if (r102 == null) goto L14;
        boolean r103 = Intrinsics.areEqual(r102.isPartialReplySelectTextEmpty(), Boolean.TRUE);
    L15:
        if (r103 == false) goto L18;
        Log.e(TitlebarViewModel.LOG_TAG, "onReplyMessage: isPartialReplySelectTextEmpty is true, stops reply message and returns null");
        return;
    L18:
        IKeyboardComponent r104 = this.f422733h;
        VoiceInnerEndPlugin r105 = null;
        if (r104 == null) goto L23;
        com.ss.android.lark.keyboard.b r106 = r104.n();
        if (r106 == null) goto L23;
        com.ss.android.lark.keyboard.keyboard2.b r107 = r106.L();
    L25:
        if ((r107 instanceof FlowChatKeyboardEditor) == false) goto L27;
        FlowChatKeyboardEditor r108 = (FlowChatKeyboardEditor) r107;
    L29:
        if (r108 == null) goto L39;
        VoiceInnerEndPlugin.b r109 = VoiceInnerEndPlugin.f428559t;
        wnb.b r117 = r108.H();
        if (r117 == null) goto L39;
        if ((r117 instanceof VoiceInnerEndPlugin) == false) goto L35;
        r105 = (VoiceInnerEndPlugin) r117;
    L35:
        if (r105 == null) goto L39;
        if (r105.f428573n != true) goto L39;
        final boolean r118 = true;
    L40:
        if (r118 == false) goto L43;
        if (r115 == false) goto L43;
        r113 = true;
    L43:
        IKeyboardComponent r119 = this.f422733h;
        if (r119 == null) goto L50;
        com.ss.android.lark.keyboard.b r120 = r119.n();
        if (r120 == null) goto L50;
        com.ss.android.lark.keyboard.ime.a r121 = r120.z();
        if (r121 == null) goto L50;
        boolean r122 = r121.y();
    L51:
        if (r122 == false) goto L53;
        r113 = false;
    L53:
        IKeyboardComponent r123 = this.f422733h;
        if (r123 == null) goto L59;
        r123.PE(r116, r111, r112, false, r113, new FlowAskDoubaoPlugin$askDoubao$1(r115, r118, this, r114, r116));
        return;
    L59:
        return;
    L50:
        r122 = false;
    L39:
        r118 = false;
        goto L40
    L27:
        r108 = null;
    L23:
        r107 = null;
    L14:
        r103 = false;
    L57:
        Log.e(TitlebarViewModel.LOG_TAG, "onReEditMessage: get msg by id returns null");
    }
}
