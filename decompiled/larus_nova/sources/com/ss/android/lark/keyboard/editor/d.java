package com.ss.android.lark.keyboard.editor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.inputstate.InputStateController;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends BaseChatEditor<FlowChatKeyboardEditor> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f428756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Chatter f428757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f428758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final KeyboardViewModel f428759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ChatWindowKeyboard.a> f428760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f428761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f428762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zxa.a f428763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i f428764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Fragment f428765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f428766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FlowChatKeyboardEditor f428767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final g f428768n;

    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f428769a = null;

        static {
            f428769a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.keyboard.event.c
        public final String getTag() {
            return com.ss.android.lark.keyboard.event.c.a.a(this);
        }
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final String getName() {
        return "input_richtext_shrink";
    }

    public final FlowChatKeyboardEditor d() {
        if (this.f428767m != null) goto L6;
        Chat r100 = this.f428759e.getCurrentChat();
        f r101 = new f(this, r100);
        e r102 = new e(this);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.IInputStateRepo");
        final InputStateController r103 = new InputStateController(this);
        String r104 = r100.getId();
        boolean r105 = this.f428762h;
        Fragment r106 = this.f428765k;
        FlowChatKeyboardEditor r107 = new FlowChatKeyboardEditor(r101, r102, r104, this.f428766l, r105, r106);
        Function1<FlowChatKeyboardEditor, Unit> r108 = new FlowChatEditorV2$createPluginImpl$1(r103, this);
        Intrinsics.checkNotNullParameter(r108, "action");
        r107.f428748v.add(r108);
        this.f428767m = r107;
    L6:
        return this.f428767m;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.chat_window.d
    public final /* bridge */ /* synthetic */ Object getPlugin() {
        return d();
    }

    public final Context getContext() {
        return this.f428756b;
    }

    @Override // com.ss.android.lark.keyboard.editor.BaseChatEditor, cya.f
    public final void b(cya.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f428761g == false) goto L6;
        super.b(r100);
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.BaseChatEditor, cya.f
    public final Object a(boolean r100, Continuation<? super cya.h> r101) {
        if (this.f428761g == false) goto L7;
        return BaseChatEditor.c(this, r100, r101);
    L7:
        return new cya.b();
    }

    public d(Context r100, ChatChatter r101, LifecycleOwner r102, KeyboardViewModel r103, List r104, boolean r105, c r106, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.e r107, Fragment r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        Intrinsics.checkNotNullParameter(r104, "callbacks");
        Intrinsics.checkNotNullParameter(r106, "hintInjector");
        Intrinsics.checkNotNullParameter(r110, "applyInsetFragment");
        super(r103);
        this.f428756b = r100;
        this.f428757c = r101;
        this.f428758d = r102;
        this.f428759e = r103;
        this.f428760f = r104;
        this.f428761g = true;
        this.f428762h = r105;
        this.f428763i = r106;
        this.f428764j = r107;
        this.f428765k = r110;
        this.f428766l = r111;
        this.f428768n = new g(this);
    }
}
