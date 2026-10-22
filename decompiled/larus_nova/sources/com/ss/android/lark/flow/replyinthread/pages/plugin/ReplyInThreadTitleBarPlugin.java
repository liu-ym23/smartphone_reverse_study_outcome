package com.ss.android.lark.flow.replyinthread.pages.plugin;

import androidx.activity.result.ActivityResultCaller;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.t3;

/* JADX INFO: loaded from: classes36.dex */
public final class ReplyInThreadTitleBarPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f424006p = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f424007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i7b.a f424008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IMessageListComponent f424009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IKeyboardComponent f424010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ITitlebarComponent f424011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zhb.a f424012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f424013m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f424014n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f424015o;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f424016a = null;

        static {
            int[] r100 = new int[TitleBarActionKey.values().length];
            r100[TitleBarActionKey.FORWARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TitleBarActionKey.SETTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f424016a = r100;
        }
    }

    static {
    }

    public final boolean F() {
        IMessageListComponent r100 = this.f424009i;
        if (r100 == null) goto L10;
        MessageInfo r101 = r100.getTopicMessageInfo();
        if (r101 == null) goto L10;
        Message r102 = r101.getMessage();
        if (r102 == null) goto L10;
        Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r103 = r102.getDisabledAction();
        if (r103 == null) goto L10;
    L11:
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r104 = r103.get(Integer.valueOf(com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Action.TRANSMIT.getValue()));
        if (r104 == null) goto L15;
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode r105 = r104.display_mode;
        if (r105 == null) goto L15;
    L16:
        if (r104 == null) goto L20;
        Integer r106 = r104.code;
        if (r106 == null) goto L20;
        int r107 = r106.intValue();
    L22:
        if (r105 == com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.DISABLE) goto L24;
        return false;
    L24:
        if (r107 != 311150) goto L32;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r108 = this.f424007g;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r108 = null;
    L28:
        FlowToast.c(r108.getContext(), R.string.Lark_IM_MessageRestrictedCantForward_Hover);
        return true;
    L32:
        return false;
    L20:
        r107 = -1;
    L15:
        r105 = com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior.DisplayMode.MODE_UNSPECIFIED;
    L10:
        r103 = MapsKt.emptyMap();
        goto L11
    }

    public final boolean H() {
        i7b.a r100 = this.f424008h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatInitData");
        r100 = null;
    L5:
        Chat r101 = r100.f488506f;
        w4b.c.p r102 = ChatCoreModule.a().getProfile();
        if (r102 == null) goto L9;
        r102.getClass();
    L9:
        if (com.ss.android.lark.chat.utils.k.d(r101) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public ReplyInThreadTitleBarPlugin() {
        this.f424013m = "";
        this.f424014n = LazyKt.lazy(new ReplyInThreadTitleBarPlugin$settingsAction$2(this));
        this.f424015o = LazyKt.lazy(new ReplyInThreadTitleBarPlugin$forwardAction$2(this));
    }

    public final s5c.d G() {
        Map<String, Object> r100 = ChatParamUtils.e();
        IMessageListComponent r101 = this.f424009i;
        if (r101 == null) goto L7;
        MessageInfo r102 = r101.getTopicMessageInfo();
        if (r102 == null) goto L7;
        Map<String, ? extends Object> r103 = ChatParamUtils.g(r102.getMessage());
    L9:
        return s5c.d.b.a(t3.f570376c.a(this.f424013m), r100).plus(r103);
    L7:
        r103 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v25, types: [com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$onCreate$2] */
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
    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f424007g = r100;
        this.f424008h = r101;
        ActivityResultCaller r102 = r100.getFragment();
        if ((r102 instanceof zhb.a) == false) goto L5;
        zhb.a r103 = (zhb.a) r102;
    L6:
        this.f424012l = r103;
        if (r103 == null) goto L12;
        ThreadTopic r104 = r103.N1();
        if (r104 == null) goto L12;
        String r105 = r104.getId();
        if (r105 == null) goto L12;
    L13:
        this.f424013m = r105;
        this.f424009i = (IMessageListComponent) r100.a(IMessageListComponent.class);
        this.f424010j = (IKeyboardComponent) r100.a(IKeyboardComponent.class);
        this.f424011k = (ITitlebarComponent) r100.a(ITitlebarComponent.class);
        IMessageListComponent r106 = this.f424009i;
        if (r106 == null) goto L16;
        r106.m(new ReplyInThreadTitleBarPlugin$onCreate$1(this));
    L16:
        ITitlebarComponent r107 = this.f424011k;
        if (r107 == 0) goto L19;
        r107.xD(new ReplyInThreadTitleBarPlugin$onCreate$2(this));
    L19:
        ITitlebarComponent r108 = this.f424011k;
        if (r108 == null) goto L22;
        r108.updateTitle();
    L22:
        ITitlebarComponent r109 = this.f424011k;
        if (r109 == null) goto L27;
        FlowTitleBarComponent.RightAreaImpl r110 = r109.F00();
        if (r110 == null) goto L27;
        r110.e(TitleBarActionKey.SETTING);
    L27:
        zhb.a r111 = this.f424012l;
        if (r111 == null) goto L56;
        List<TitleBarActionKey> r112 = r111.sr();
        if (r112 == null) goto L75;
        Iterator<T> r113 = r112.iterator();
    L33:
        if (r113.hasNext() == false) goto L76;
        TitleBarActionKey r114 = (TitleBarActionKey) r113.next();
        int r115 = b.f424016a[r114.ordinal()];
        boolean r116 = true;
        if (r115 != 1) goto L37;
        ITitlebarComponent r117 = this.f424011k;
        if (r117 == null) goto L33;
        FlowTitleBarComponent.RightAreaImpl r118 = r117.F00();
        if (r118 == null) goto L33;
        r118.a((ReplyInThreadTitleBarPlugin$forwardAction$2.a) this.f424015o.getValue());
        goto L33
    L37:
        if (r115 != 2) goto L33;
        zhb.a r119 = this.f424012l;
        if (r119 != null) goto L42;
    L44:
        r116 = false;
    L45:
        if (r116 == false) goto L33;
        ITitlebarComponent r120 = this.f424011k;
        if (r120 == null) goto L33;
        FlowTitleBarComponent.RightAreaImpl r121 = r120.F00();
        if (r121 == null) goto L33;
        r121.a((ReplyInThreadTitleBarPlugin$settingsAction$2.a) this.f424014n.getValue());
        goto L33
    L42:
        if (r119.E80() == true) goto L44;
    L76:
        return;
    L75:
        return;
    L56:
        return;
    L12:
        r105 = "";
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public static void I(ReplyInThreadTitleBarPlugin r100, String r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = 0;
    L8:
        r100.getClass();
        ViewUtils.runOnUiThread(new p(r101, r100, r102));
    }
}
