package com.ss.android.lark.keyboard.biz.voice.inject;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.base.r;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.editor.input.ChatEditorEnable;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.utils.j;
import com.ss.android.lark.keyboard.widget.l;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceInnerEndPlugin implements wnb.b<VoiceInnerEndPlugin>, wnb.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final b f428559t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wnb.c f428562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadTopic f428563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public wnb.d f428564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f428565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.keyboard.biz.voice.inject.d f428566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f428567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f428568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f428569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile com.ss.android.lark.keyboard.biz.voice.inject.a f428570k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ExecutorService f428571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f428572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f428573n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f428574o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f428575p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f428576q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f428577r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f428578s;

    public final class a implements qob.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceInnerEndPlugin f428579a;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin$a$a, reason: collision with other inner class name */
        public static final class C5079a extends j4b.a.f {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public final /* synthetic */ int f428580s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public final /* synthetic */ String f428581t;

            @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback, n6b.b
            public final /* bridge */ /* synthetic */ void h(MessageInfo r100) {
                s(r100);
            }

            @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
            public final void s(MessageInfo r100) {
                Intrinsics.checkNotNullParameter(r100, "preMessageInfo");
                super.s(r100);
                AudioContent r101 = (AudioContent) r100.getMessage().getContent();
                r101.setDuration(this.f428580s);
                r101.setLocalFilePath(this.f428581t);
                r101.setRecognizeFinished(false);
                r101.setNeedHideText(true);
                r101.setFileState(AudioContent.AudioState.DOWNLOAD);
            }

            public C5079a(q4b.a r100, int r101, String r102) {
                this.f428580s = r101;
                this.f428581t = r102;
                super((j4b.a) r100);
            }
        }

        public static final class b extends MonitorMessageSendCallback {

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public final /* synthetic */ int f428582r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public final /* synthetic */ String f428583s;

            @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback, n6b.b
            public final /* bridge */ /* synthetic */ void h(MessageInfo r100) {
                s(r100);
            }

            @Override // com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback
            public final void s(MessageInfo r100) {
                Intrinsics.checkNotNullParameter(r100, "preMessageInfo");
                super.s(r100);
                AudioContent r101 = (AudioContent) r100.getMessage().getContent();
                r101.setDuration(this.f428582r);
                r101.setLocalFilePath(this.f428583s);
                r101.setRecognizeFinished(true);
                r101.setNeedHideText(true);
                r101.setFileState(AudioContent.AudioState.DOWNLOAD);
            }

            public b(VoiceInnerEndPlugin r100, int r101, String r102) {
                this.f428582r = r101;
                this.f428583s = r102;
                wnb.d r103 = r100.f428564e;
                ChatChatter r104 = null;
                if (r103 == null) goto L5;
                Chat r105 = r103.f560490e;
            L6:
                if (r103 == null) goto L8;
                r104 = r103.f560491f;
            L8:
                if (r105 == null) goto L14;
                if (r104 == null) goto L14;
                this.f416402d = r105;
                if (r105.isGroup() == false) goto L13;
                this.f416405g = Scene.Group;
            L13:
                this.f416403e = r104;
                p(new n4b.a(r105));
                return;
            L14:
                Log.e("VoiceInnerEndPlugin", "chat or chatter not initialized");
                return;
            L5:
                r105 = null;
                goto L6
            }
        }

        @Override // qob.a
        public final void i() {
        }

        @Override // qob.a
        public final String getChatId() {
            wnb.d r100 = this.f428579a.f428564e;
            if (r100 == null) goto L5;
            String r101 = r100.f560489d;
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        @Override // qob.a
        public final com.ss.android.lark.keyboard.b n() {
            return this.f428579a.n();
        }

        @Override // qob.a
        public final PartialReplyInfo c() {
            return com.ss.android.lark.keyboard.a.c(n());
        }

        @Override // qob.a
        public final String d() {
            return com.ss.android.lark.keyboard.a.b(n());
        }

        @Override // qob.a
        public final Message.PartialReplyInfo f() {
            return ReplyActionUtils.e(com.ss.android.lark.keyboard.a.c(n()));
        }

        @Override // qob.a
        public final String h() {
            return com.ss.android.lark.keyboard.a.d(n());
        }

        @Override // qob.a
        public final String k() {
            return ChatCoreModule.a().getLanguageDependency().getLanguageSetting().toString();
        }

        public a(VoiceInnerEndPlugin r100) {
            this.f428579a = r100;
        }

        @Override // qob.a
        public final com.ss.android.lark.chat.entity.message.Message a(m5b.d r100) {
            wnb.d r101 = this.f428579a.f428564e;
            if (r101 == null) goto L7;
            q4b.a r102 = r101.f560493h;
            if (r102 == null) goto L7;
            return r102.a(r100);
        L7:
            return null;
        }

        @Override // qob.a
        public final void b(m5b.d r100) {
            wnb.d r101 = this.f428579a.f428564e;
            if (r101 == null) goto L8;
            q4b.a r102 = r101.f560493h;
            if (r102 == null) goto L9;
            r102.b(r100);
            return;
        L9:
            return;
        }

        @Override // qob.a
        public final void g(m5b.d r100) {
            wnb.d r101 = this.f428579a.f428564e;
            if (r101 == null) goto L8;
            q4b.a r102 = r101.f560493h;
            if (r102 == null) goto L9;
            r102.g(r100);
            return;
        L9:
            return;
        }

        @Override // qob.a
        public final void m(String r100) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            wnb.d r101 = this.f428579a.f428564e;
            if (r101 == null) goto L8;
            Function1<String, Unit> r102 = r101.f560494i;
            if (r102 == null) goto L9;
            r102.invoke(r100);
            return;
        L9:
            return;
        }

        @Override // qob.a
        public final void p(com.ss.android.lark.chat.entity.message.Message r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "fileName");
        }

        @Override // qob.a
        public final MonitorMessageSendCallback l(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "strFileName");
            Intrinsics.checkNotNullParameter(r101, "cid");
            wnb.d r103 = this.f428579a.f428564e;
            if (r103 == null) goto L5;
            q4b.a r104 = r103.f560493h;
        L7:
            if ((r104 instanceof j4b.a) == false) goto L11;
            return new C5079a(r104, r102, r100);
        L11:
            return new b(this.f428579a, r102, r100);
        L5:
            r104 = null;
            goto L7
        }

        @Override // qob.a
        public final void j(com.ss.android.lark.chat.entity.message.Message r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r102, "fileName");
            Intrinsics.checkNotNullParameter(r103, "cid");
        }

        @Override // qob.a
        public final void o(String r100, String r101, String r102, RichText r103) {
            Intrinsics.checkNotNullParameter(r100, "rootMsgId");
            Intrinsics.checkNotNullParameter(r101, "parentMsgId");
            Intrinsics.checkNotNullParameter(r102, "content");
            Intrinsics.checkNotNullParameter(r103, "richText");
        }

        @Override // qob.a
        public final com.ss.android.lark.chat.entity.message.Message e(String r100, String r101, String r110, String r111, Message.PartialReplyInfo r112) {
            Intrinsics.checkNotNullParameter(r100, "rootMsgId");
            Intrinsics.checkNotNullParameter(r101, "parentMsgId");
            Intrinsics.checkNotNullParameter(r110, "fileName");
            Intrinsics.checkNotNullParameter(r111, "cid");
            wnb.d r102 = this.f428579a.f428564e;
            if (r102 == null) goto L7;
            q4b.a r103 = r102.f560493h;
            if (r103 == null) goto L7;
            return r103.e(r100, r101, r110, r111, r112);
        L7:
            return null;
        }
    }

    public static final class b implements wnb.b.a<VoiceInnerEndPlugin> {
        public b() {
        }
    }

    public static final class c implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceInnerEndPlugin f428584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f428585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EditText f428586c;

        public c(VoiceInnerEndPlugin r100, Fragment r101, EditText r102) {
            this.f428584a = r100;
            this.f428585b = r101;
            this.f428586c = r102;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (this.f428584a.f428572m == false) goto L5;
            return;
        L5:
            if (this.f428585b.isResumed() == true) goto L8;
            return;
        L8:
            if (this.f428584a.r() == true) goto L12;
            this.f428584a.t(this.f428585b, this.f428586c);
            return;
        L12:
            if (Intrinsics.areEqual(r100, this.f428586c) == true) goto L14;
        L19:
            VoiceInnerEndPlugin r102 = this.f428584a;
            View.OnTouchListener r103 = null;
            boolean r104 = false;
            if (r102.f428573n == false) goto L35;
            if (r102.f428574o == true) goto L29;
            ViewGroup r105 = r102.o();
            if (r105 == null) goto L26;
            int r106 = r105.getChildCount();
        L27:
            if (r106 <= 0) goto L29;
            this.f428584a.k(0);
            goto L29
        L26:
            r106 = 0;
        L29:
            EditText r107 = this.f428586c;
            fya.a r108 = this.f428584a.p();
            if (r108 == null) goto L32;
            r103 = r108.D0(this.f428586c);
        L32:
            r107.setOnTouchListener(r103);
            return;
        L35:
            if (this.f428586c.getVisibility() != 0) goto L37;
            boolean r109 = true;
        L38:
            if (r109 == true) goto L40;
        L52:
            this.f428584a.t(this.f428585b, this.f428586c);
            return;
        L40:
            if (Intrinsics.areEqual(r100, this.f428586c) == false) goto L52;
            if (r101 == true) goto L52;
            Editable r110 = this.f428586c.getEditableText();
            if (r110 != null) goto L45;
        L46:
            r104 = true;
        L47:
            if (r104 == false) goto L52;
            this.f428584a.k(4);
            EditText r111 = this.f428586c;
            fya.a r112 = this.f428584a.p();
            if (r112 == null) goto L51;
            r103 = r112.D0(this.f428586c);
        L51:
            r111.setOnTouchListener(r103);
            return;
        L45:
            if (r110.length() != 0) goto L47;
        L37:
            r109 = false;
            goto L38
        L14:
            if (this.f428584a.s() == false) goto L19;
            if (this.f428584a.q().f428601i == false) goto L19;
            this.f428584a.t(this.f428585b, this.f428586c);
        }
    }

    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceInnerEndPlugin f428587a;

        public d(VoiceInnerEndPlugin r100) {
            this.f428587a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            int r109 = r100.getMeasuredHeight();
            if (r109 <= 0) goto L10;
            VoiceInnerEndPlugin r110 = this.f428587a;
            r110.f428575p = r109;
            ViewGroup r111 = r110.o();
            if (r111 == null) goto L7;
            int r112 = r111.getVisibility();
        L8:
            r110.k(r112);
            return;
        L7:
            r112 = 8;
            goto L8
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceInnerEndPlugin f428588a;

        public e(VoiceInnerEndPlugin r100) {
            this.f428588a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VoiceInnerEndPlugin r101 = this.f428588a;
            if (r101.r() == false) goto L27;
            wnb.d r102 = r101.f428564e;
            if (r102 == null) goto L28;
            Fragment r103 = r102.f560486a;
            if (r103 != null) goto L12;
            return;
        L12:
            if (r101.f428573n == false) goto L14;
            r101.m(r103, true);
            return;
        L14:
            View r104 = r103.getView();
            if ((r104 instanceof ViewGroup) == false) goto L17;
            ViewGroup r105 = (ViewGroup) r104;
        L18:
            if (r105 == null) goto L23;
            ViewGroup r106 = (ViewGroup) r105.findViewWithTag("flow_chat_message_list_view_observer");
            if (r106 == null) goto L23;
            int r107 = xob.a.f564691a;
            Context r108 = r103.requireContext();
            String r109 = r101.f428560a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r109, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r109), new Pair("click", "switch_voice_input"), new Pair(PickerReporterConstants.KEY.TARGET, "im_chat_voice_msg_view"), new Pair("keyboard_status", xob.a.a(r108))});
            r101.l(r103, r106);
            return;
        L23:
            Log.e("VoiceInnerEndPlugin", "voice start aborted: root view is null");
            return;
        L17:
            r105 = null;
            goto L18
        L28:
            return;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f428589a;

        public f(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f428589a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f428589a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements fya.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceInnerEndPlugin f428590a;

        @Override // fya.a.b
        public final String a() {
            VoiceInnerEndPlugin r100 = this.f428590a;
            com.ss.android.lark.biz.im.api.extension.chat_window.h r101 = r100.f428560a.f410100e;
            String r102 = null;
            if (r101 == null) goto L7;
            MutableLiveData<Chat> r103 = r101.f410103c;
            if (r103 == null) goto L7;
            Chat r104 = r103.getValue();
        L8:
            if (r104 == null) goto L10;
            String r105 = r104.getLastMessageId();
        L11:
            String r106 = "";
            if (r105 != null) goto L14;
            r105 = "";
        L14:
            com.ss.android.lark.biz.im.api.extension.chat_window.h r107 = r100.f428560a.f410100e;
            if (r107 == null) goto L17;
            String r108 = r107.f410102b;
        L18:
            if (r108 != null) goto L20;
            r108 = "";
        L20:
            boolean r109 = true;
            if (r108.length() != 0) goto L23;
            boolean r110 = true;
        L25:
            if (r110 == true) goto L47;
            ThreadTopic r111 = r100.f428563d;
            if (r111 == null) goto L47;
            String r112 = r111.getLastMsgId();
            if (r112 == null) goto L34;
            r106 = r112;
        L34:
            if (r106.length() == 0) goto L38;
            r109 = false;
        L38:
            if (r109 == false) goto L43;
            StringBuilder r113 = new StringBuilder("threadTopic.lastMsgId is empty, chatId=");
            if (r104 == null) goto L42;
            r102 = r104.getId();
        L42:
            r113.append(r102);
            r113.append(", threadId=");
            r113.append(r108);
            r113.append(", contextQueryMsgId=");
            r113.append(r105);
            Log.w("VoiceInnerEndPlugin", r113.toString());
            return r105;
        L43:
            StringBuilder r114 = new StringBuilder("return thread.lastMsgId, chatId=");
            if (r104 == null) goto L46;
            r102 = r104.getId();
        L46:
            r114.append(r102);
            r114.append(", threadId=");
            r114.append(r108);
            r114.append(", contextQueryMsgId=");
            r114.append(r106);
            Log.i("VoiceInnerEndPlugin", r114.toString());
            return r106;
        L47:
            StringBuilder r115 = new StringBuilder("threadTopic is empty, return chat.lastMessageId, chatId=");
            if (r104 == null) goto L50;
            r102 = r104.getId();
        L50:
            r115.append(r102);
            r115.append(", contextQueryMsgId=");
            r115.append(r105);
            Log.i("VoiceInnerEndPlugin", r115.toString());
            return r105;
        L23:
            r110 = false;
            goto L25
        L17:
            r108 = null;
            goto L18
        L10:
            r105 = null;
        L7:
            r104 = null;
            goto L8
        }

        @Override // fya.a.b
        public final String getChatId() {
            return this.f428590a.f428560a.f410098c.getId();
        }

        public g(VoiceInnerEndPlugin r100) {
            this.f428590a = r100;
        }
    }

    public static final class h implements fya.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceInnerEndPlugin f428591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f428592b;

        @Override // fya.a.c
        public final void onCancel() {
            VoiceInnerEndPlugin r100 = this.f428591a;
            r100.getClass();
            r100.u("onExternalCancel", new VoiceInnerEndPlugin$onExternalCancel$1(r100));
        }

        @Override // fya.a.c
        public final void b(final byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
            final VoiceInnerEndPlugin r101 = this.f428591a;
            r101.getClass();
            r101.u("onExternalChunk", new VoiceInnerEndPlugin$onExternalChunk$1(r100, r101));
        }

        @Override // fya.a.c
        public final void c(boolean r100) {
            this.f428591a.f428567h = r100;
        }

        @Override // fya.a.c
        public final void e(fya.a.AbstractC5966a r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if ((r100 instanceof fya.a.AbstractC5966a.c) == false) goto L6;
            int r101 = xob.a.f564691a;
            Context r102 = this.f428592b.requireContext();
            String r103 = this.f428591a.f428560a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r103), new Pair("click", "press_voice_input"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("keyboard_status", xob.a.a(r102))});
            return;
        }

        public h(VoiceInnerEndPlugin r100, Fragment r101) {
            this.f428591a = r100;
            this.f428592b = r101;
        }

        @Override // fya.a.c
        public final void a(byte[] r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
            Intrinsics.checkNotNullParameter(r101, "content");
            VoiceInnerEndPlugin.g(this.f428591a, r101);
        }

        @Override // fya.a.c
        public final void d(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "content");
            VoiceInnerEndPlugin r102 = this.f428591a;
            r102.f428567h = r101;
            VoiceInnerEndPlugin.g(r102, r100);
        }
    }

    static {
        f428559t = new b();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final void onDestroy() {
        this.f428572m = true;
        n().e().of(this).a();
        this.f428574o = false;
        View r100 = this.f428565f;
        if (r100 == null) goto L5;
        r100.setOnClickListener(null);
    L5:
        com.ss.android.lark.keyboard.biz.voice.inject.d r101 = this.f428566g;
        if (r101 == null) goto L9;
        this.f428566g = null;
        n().L().c().removeTextChangedListener(r101);
    L9:
        ViewGroup r102 = (ViewGroup) this.f428578s.getValue();
        if (r102 == null) goto L13;
        r102.setOnLongClickListener(null);
    L13:
        if (s() == false) goto L32;
        VoiceInputPreviewDelegate r103 = q();
        r103.f428601i = false;
        r103.f428603k = false;
        r103.f428602j = VoiceInputPreviewDelegate.PreviewOriginMode.INPUT_UNFOCUSED;
        r103.f428604l = "";
        r103.a(true);
        CoroutineScopeKt.cancel$default(r103.f428597e, null, 1, null);
    L32:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        com.ss.android.lark.keyboard.biz.voice.inject.a r105 = this.f428570k;     // Catch: Throwable -> L21
        if (r105 == null) goto L18;
        r105.a();     // Catch: Throwable -> L21
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L21
    L23:
        this.f428570k = null;
        Result.m9449constructorimpl(this.f428571l.shutdownNow());     // Catch: Throwable -> L26
    L28:
        this.f428564e = null;
        EditText r107 = n().L().c();
        r107.setOnFocusChangeListener(null);
        Map<View, View.OnTouchListener> r108 = l.f431053a;
        Intrinsics.checkNotNullParameter(r107, "view");
        l.f431053a.remove(r107);
        r107.setOnTouchListener(null);
        return;
    L26:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L18:
        r106 = null;
    L21:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    @Override // wnb.b
    public final View a() {
        ViewGroup r100 = null;
        View r101 = LayoutInflater.from(this.f428560a.f410096a.requireContext()).inflate(R.layout.item_icon_button_voice, null);
        r101.setOnClickListener(new e(this));
        this.f428565f = r101;
        ViewGroup r102 = (ViewGroup) this.f428578s.getValue();
        if (r102 != null) goto L5;
    L16:
        n().e().of(this).c(ChatEditorEnable.class, new VoiceInnerEndPlugin$getPluginView$2(this));
        if (r() == false) goto L61;
        fya.a r103 = p();
        if (r103 != null) goto L21;
    L23:
        boolean r104 = false;
    L24:
        if (r104 == false) goto L61;
        wnb.d r105 = this.f428564e;
        if (r105 == null) goto L61;
        Fragment r106 = r105.f560486a;
        if (r106 == null) goto L61;
        View r107 = r106.getView();
        if ((r107 instanceof ViewGroup) == false) goto L35;
        r100 = (ViewGroup) r107;
    L35:
        if (r100 == null) goto L60;
        ViewGroup r108 = (ViewGroup) r100.findViewWithTag("flow_chat_message_list_view_observer");
        if (r108 == null) goto L60;
        this.f428573n = true;
        fya.a r109 = p();
        if (r109 == null) goto L42;
        r109.v5(true);
    L42:
        this.f428574o = true;
        KeyboardUtils.hideKeyboard(this.f428560a.f410096a.requireContext());
        View r110 = this.f428565f;
        if (r110 == null) goto L47;
        ImageView r111 = (ImageView) r110.findViewById(R.id.ivVoice);
        if (r111 == null) goto L47;
        r111.setImageResource(R.drawable.ic_keyboard_btn);
    L47:
        v(r108, r106);
        ViewGroup r112 = (ViewGroup) this.f428578s.getValue();
        if (r112.isLaidOut() == true) goto L50;
    L59:
        r112.addOnLayoutChangeListener(new com.ss.android.lark.keyboard.biz.voice.inject.e(this));
        goto L61
    L50:
        if (r112.isLayoutRequested() == true) goto L59;
        if (this.f428572m == true) goto L61;
        if (this.f428573n == false) goto L61;
        if (this.f428574o == false) goto L61;
        this.f428574o = false;
        k(0);
    L60:
        Log.e("VoiceInnerEndPlugin", "voice init aborted: root view is null");
        goto L61
    L21:
        if (r103.y3() != true) goto L23;
        r104 = true;
    L61:
        j();
        if (this.f428566g != null) goto L66;
        EditText r113 = n().L().c();
        com.ss.android.lark.keyboard.biz.voice.inject.d r114 = new com.ss.android.lark.keyboard.biz.voice.inject.d(this);
        this.f428566g = r114;
        r113.addTextChangedListener(r114);
    L66:
        if (s() == false) goto L69;
        n().e().of(this).c(q.b.class, new VoiceInnerEndPlugin$bindSendActionWatcher$1(this));
    L69:
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        if (r102.isLaidOut() == true) goto L7;
    L15:
        r102.addOnLayoutChangeListener(new d(this));
        goto L16
    L7:
        if (r102.isLayoutRequested() == true) goto L15;
        int r115 = r102.getMeasuredHeight();
        if (r115 <= 0) goto L16;
        this.f428575p = r115;
        ViewGroup r116 = o();
        if (r116 == null) goto L13;
        int r117 = r116.getVisibility();
    L14:
        k(r117);
        goto L16
    L13:
        r117 = 8;
        goto L14
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(0, 0, UIHelper.dp2px(12.0f), 0);
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f428562c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final void j() {
        wnb.d r100 = this.f428564e;
        if (r100 != null) goto L5;
        return;
    L5:
        Fragment r101 = r100.f560486a;
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = r101.getView();
        View.OnTouchListener r103 = null;
        if ((r102 instanceof ViewGroup) == false) goto L11;
        ViewGroup r104 = (ViewGroup) r102;
    L12:
        if (r104 == null) goto L49;
        ViewGroup r105 = (ViewGroup) r104.findViewWithTag("flow_chat_message_list_view_observer");
        if (r105 == null) goto L49;
        EditText r106 = n().L().c();
        if (r() == true) goto L21;
        t(r101, r106);
        return;
    L21:
        if (this.f428573n == false) goto L26;
        fya.a r107 = p();
        if (r107 == null) goto L25;
        r103 = r107.D0(r106);
    L25:
        r106.setOnTouchListener(r103);
    L47:
        r106.setOnFocusChangeListener(new c(this, r101, r106));
        return;
    L26:
        boolean r108 = false;
        if (r106.getVisibility() != 0) goto L29;
        boolean r109 = true;
    L30:
        if (r109 == false) goto L44;
        if (r106.hasFocus() == true) goto L44;
        Editable r110 = r106.getEditableText();
        if (r110 != null) goto L36;
    L37:
        r108 = true;
    L38:
        if (r108 == false) goto L44;
        v(r105, r101);
        k(4);
        fya.a r111 = p();
        if (r111 == null) goto L42;
        r103 = r111.D0(r106);
    L42:
        r106.setOnTouchListener(r103);
        goto L47
    L36:
        if (r110.length() != 0) goto L38;
    L44:
        if (s() == false) goto L46;
        q().a(true);
    L46:
        t(r101, r106);
        goto L47
    L29:
        r109 = false;
    L49:
        Log.e("VoiceInnerEndPlugin", "voice start aborted: root view is null");
        return;
    L11:
        r104 = null;
        goto L12
    }

    public final com.ss.android.lark.keyboard.b n() {
        com.ss.android.lark.keyboard.b r100 = this.f428561b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    public final ViewGroup o() {
        return (ViewGroup) this.f428577r.getValue();
    }

    public final fya.a p() {
        return (fya.a) this.f428568i.getValue();
    }

    public final VoiceInputPreviewDelegate q() {
        return (VoiceInputPreviewDelegate) this.f428576q.getValue();
    }

    public final boolean r() {
        com.ss.android.lark.keyboard.keyboard2.b r100 = n().L();
        if ((r100 instanceof FlowChatKeyboardEditor) == false) goto L5;
        FlowChatKeyboardEditor r101 = (FlowChatKeyboardEditor) r100;
    L6:
        boolean r102 = false;
        if (r101 == null) goto L12;
        if (r101.f428751y == true) goto L12;
        r102 = true;
    L12:
        return !r102;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean s() {
        fya.a r100 = p();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.z5() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEnd;
    }

    @Override // wnb.b
    public final wnb.b.a<VoiceInnerEndPlugin> getKey() {
        return f428559t;
    }

    public VoiceInnerEndPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428560a = r100;
        this.f428567h = true;
        this.f428568i = LazyKt.lazy(new VoiceInnerEndPlugin$voiceInputExtension$2(this));
        this.f428569j = LazyKt.lazy(new VoiceInnerEndPlugin$attachmentExtension$2(this));
        this.f428571l = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("VoiceInnerEndPlugin"));
        this.f428576q = LazyKt.lazy(new VoiceInnerEndPlugin$voiceInputPreviewDelegate$2(this));
        this.f428577r = LazyKt.lazy(new VoiceInnerEndPlugin$touchSpeakViewContainer$2(this));
        this.f428578s = LazyKt.lazy(new VoiceInnerEndPlugin$etContainer$2(this));
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428562c = r100;
    }

    @Override // wnb.a
    public final void f(wnb.d r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f428564e = r100;
    }

    public final void k(int r100) {
        ViewGroup r101 = (ViewGroup) this.f428578s.getValue();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.getMeasuredHeight();
    L6:
        if (r103 <= 0) goto L8;
        this.f428575p = r103;
    L8:
        ViewGroup r104 = o();
        if (r104 == null) goto L11;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L12:
        if (r105 == null) goto L16;
        int r106 = r105.height;
        int r107 = this.f428575p;
        if (r106 == r107) goto L16;
        r105.height = r107;
        r104.setLayoutParams(r105);
    L16:
        ViewGroup r108 = o();
        if (r108 == null) goto L19;
        r108.setVisibility(r100);
    L19:
        ViewGroup r109 = (ViewGroup) this.f428578s.getValue();
        if (r109 != null) goto L22;
        return;
    L22:
        if (o().getVisibility() != 0) goto L24;
        boolean r110 = true;
    L26:
        if ((!r110) == true) goto L29;
        r102 = 8;
    L29:
        r109.setVisibility(r102);
        return;
    L24:
        r110 = false;
        goto L26
    L11:
        r105 = null;
        goto L12
    L5:
        r103 = 0;
        goto L6
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428561b = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(final VoiceInnerEndPlugin r310, String r311) {
        final com.ss.android.lark.keyboard.biz.voice.inject.a r100 = r310.f428570k;
        Object r101 = null;
        r310.f428570k = null;
        long r102 = System.currentTimeMillis();
        if (r310.f428567h == true) goto L67;
        String r103 = StringsKt.trim(r311).toString();
        if (r103.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L11;
        return;
    L11:
        if (r310.s() == false) goto L29;
        wnb.d r105 = r310.f428564e;
        if (r105 == null) goto L16;
        Fragment r106 = r105.f560486a;
        if (r106 == null) goto L16;
    L17:
        boolean r107 = r310.f428573n;
        r310.u("previewVoiceText_cancelVoice", new VoiceInnerEndPlugin$onExternalStop$1(r310, r100));
        r310.m(r106, false);
        VoiceInputPreviewDelegate r108 = r310.q();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r103, "recognitionText");
        r108.a(true);
        EditText r109 = r108.f428593a.L().c();
        r108.f428601i = true;
        if (r107 == false) goto L20;
        VoiceInputPreviewDelegate.PreviewOriginMode r110 = VoiceInputPreviewDelegate.PreviewOriginMode.VOICE_MODE;
    L21:
        r108.f428602j = r110;
        r108.f428603k = false;
        r108.f428605m = true;
        ExtensionEditTextCompatKt.p(r109, com.ss.android.lark.widget.richtext.c.c(r103));     // Catch: Throwable -> L26
        fya.a.d r111 = r108.b();     // Catch: Throwable -> L26
        if (r111 == null) goto L25;
        String r112 = r108.f428593a.v().l().getKey().getTag();     // Catch: Throwable -> L26
        ImmersiveVoiceInputComponent.a r113 = ImmersiveVoiceInputComponent.f430093a;     // Catch: Throwable -> L26
        r111.a(r109, Intrinsics.areEqual(r112, "ImmersiveVoiceKeyboardKey"));     // Catch: Throwable -> L26
    L25:
        r108.f428605m = false;
        r108.f428604l = r108.c();
        r109.clearFocus();
        r108.f428600h = BuildersKt.launch$default(r108.f428597e, null, null, new VoiceInputPreviewDelegate$startPreview$2(r108, r109, r103, null), 3, null);
        return;
    L26:
        th = move-exception;
        r108.f428605m = false;
        throw th;
    L20:
        r110 = VoiceInputPreviewDelegate.PreviewOriginMode.INPUT_UNFOCUSED;
    L16:
        r106 = r310.f428560a.f410096a;
        goto L17
    L29:
        wxa.a r114 = (wxa.a) r310.f428569j.getValue();
        if (r114 == null) goto L32;
        List<UplinkFileEntity> r115 = r114.q1();
    L33:
        if (r115 != null) goto L36;
        r115 = CollectionsKt.emptyList();
    L36:
        if (r115.isEmpty() == true) goto L39;
        r101 = Long.valueOf(r102);
    L39:
        Long r116 = r101;
        wnb.d r117 = r310.f428564e;
        if (r117 == null) goto L43;
        Fragment r118 = r117.f560486a;
        if (r118 == null) goto L43;
    L45:
        if (j.a(r310.n(), r118, "VoiceInnerEndPlugin", r103, r116, new r(null, false, true, null, null, null, false, null, null, 8388603)) == true) goto L72;
        if (r100 == null) goto L48;
        String r119 = com.ss.android.lark.keyboard.a.d(r310.n());
        String r120 = com.ss.android.lark.keyboard.a.b(r310.n());
        RichText r121 = com.ss.android.lark.widget.richtext.c.c(r103);
        PartialReplyInfo r122 = com.ss.android.lark.keyboard.a.c(r310.n());
        Intrinsics.checkNotNullParameter(r119, "rootMsgId");
        Intrinsics.checkNotNullParameter(r120, "parentMsgId");
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r121, "richText");
        m5b.e r123 = new m5b.e(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
        r123.f512232j = r119;
        r123.f512233k = r120;
        r123.f512226d = r100.f428620l;
        r123.f512224b = r100.f428614f;
        r100.f428610b.g(new m5b.d("", r103, r121, r122, r123));
    L48:
        if (r100 == null) goto L73;
        k.a.a(r310.n().e(), q.a.f429311a);
        return;
    L73:
        return;
    L72:
        return;
    L43:
        r118 = r310.f428560a.f410096a;
        goto L45
    L32:
        r115 = null;
        goto L33
    L7:
        r104 = false;
        goto L8
    L67:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L55
        if (r100 == null) goto L53;
        r100.f428620l = Long.valueOf(r102);     // Catch: Throwable -> L55
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L55
    L53:
        Object r125 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L55
    L57:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L60;
        Log.e("VoiceInnerEndPlugin", "setSendWithQueueId failed", r126);
    L60:
        wnb.d r127 = r310.f428564e;
        if (r127 == null) goto L64;
        Fragment r128 = r127.f560486a;
        if (r128 == null) goto L64;
    L65:
        j.a(r310.n(), r128, "VoiceInnerEndPlugin", null, Long.valueOf(r102), null);
        r310.u("onExternalStop", new VoiceInnerEndPlugin$stopAndSendSession$1(r310, r100));
        return;
    L64:
        r128 = r310.f428560a.f410096a;
    L55:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    }

    public final void l(Fragment r100, ViewGroup r101) {
        if (r() == true) goto L5;
        return;
    L5:
        this.f428574o = false;
        this.f428573n = true;
        fya.a r102 = p();
        if (r102 == null) goto L8;
        r102.v5(true);
    L8:
        KeyboardUtils.hideKeyboard(this.f428560a.f410096a.requireContext());
        View r103 = this.f428565f;
        if (r103 == null) goto L13;
        ImageView r104 = (ImageView) r103.findViewById(R.id.ivVoice);
        if (r104 == null) goto L13;
        r104.setImageResource(R.drawable.ic_keyboard_btn);
    L13:
        v(r101, r100);
        k(0);
    }

    public final void m(Fragment r100, boolean r101) {
        this.f428574o = false;
        if (this.f428573n == false) goto L7;
        this.f428573n = false;
        fya.a r102 = p();
        if (r102 == null) goto L7;
        r102.v5(false);
    L7:
        if (r100 != null) goto L24;
    L16:
        u("onExternalCancel", new VoiceInnerEndPlugin$onExternalCancel$1(this));
        k(8);
        View r103 = this.f428565f;
        if (r103 == null) goto L21;
        ImageView r104 = (ImageView) r103.findViewById(R.id.ivVoice);
        if (r104 == null) goto L21;
        r104.setImageResource(R.drawable.ic_mic_btn);
    L21:
        if (r101 == false) goto L26;
        KeyboardUtils.showKeyboard(n().L().c());
        return;
    L26:
        return;
    L24:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        fya.a r106 = p();     // Catch: Throwable -> L14
        if (r106 == null) goto L11;
        r106.w5(r100);     // Catch: Throwable -> L14
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L14
        goto L16
    L11:
        r107 = null;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void t(Fragment r100, EditText r101) {
        fya.a r102 = p();
        if (r102 == null) goto L5;
        r102.w5(r100);
    L5:
        k(8);
        Map<View, View.OnTouchListener> r103 = l.f431053a;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setOnTouchListener((View.OnTouchListener) ((LinkedHashMap) l.f431053a).get(r101));
    }

    public final void u(String r100, Function0<Unit> r101) {
        if (this.f428572m == false) goto L7;
        Log.w("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial ignored: destroyed, task=".concat(r100));
        return;
    L7:
        if (this.f428571l.isShutdown() == false) goto L17;
        Log.w("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial ignored: executor shutdown, task=".concat(r100));
        return;
    L17:
        this.f428571l.execute(new f(r101));     // Catch: Throwable -> L12 RejectedExecutionException -> L14
    L20:
        return;
    L14:
        e = move-exception;
        Log.w("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial rejected, task=".concat(r100), e);
        return;
    L12:
        th = move-exception;
        Log.e("VoiceInnerEndPlugin", "safeExecuteOnVoiceSerial failed, task=".concat(r100), th);
    }

    public final void v(ViewGroup r100, Fragment r101) {
        if (r() == true) goto L5;
        return;
    L5:
        fya.a r102 = p();
        if (r102 == null) goto L9;
        r102.A5(r100, r101, o(), new g(this), new h(this, r101));
        return;
    }
}
