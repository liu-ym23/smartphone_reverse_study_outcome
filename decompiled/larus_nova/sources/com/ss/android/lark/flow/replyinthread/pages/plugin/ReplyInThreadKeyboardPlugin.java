package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ReplyInThreadKeyboardPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f423979m = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f423980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IMessageListComponent f423981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IKeyboardComponent f423982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ITitlebarComponent f423983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zhb.a f423984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f423985l;

    public static final class a {
    }

    static {
    }

    public ReplyInThreadKeyboardPlugin() {
        this.f423985l = LazyKt.lazy(new ReplyInThreadKeyboardPlugin$draftService$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f423980g = r100;
        ActivityResultCaller r102 = r100.getFragment();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r103 = null;
        if ((r102 instanceof zhb.a) == false) goto L5;
        zhb.a r104 = (zhb.a) r102;
    L6:
        this.f423984k = r104;
        if (r104 == null) goto L11;
        ThreadTopic r105 = r104.N1();
        if (r105 == null) goto L11;
        r105.getId();
    L11:
        this.f423981h = (IMessageListComponent) r100.a(IMessageListComponent.class);
        this.f423982i = (IKeyboardComponent) r100.a(IKeyboardComponent.class);
        this.f423983j = (ITitlebarComponent) r100.a(ITitlebarComponent.class);
        boolean r106 = false;
        if (KeyboardVoiceFGUtils.c() == false) goto L29;
        IKeyboardComponent r107 = this.f423982i;
        if (r107 == null) goto L24;
        com.ss.android.lark.keyboard.b r108 = r107.n();
        if (r108 == null) goto L24;
        com.ss.android.lark.keyboard.keyboard2.content.c r109 = r108.v();
        if (r109 == null) goto L24;
        IKeyboardContent r110 = r109.l();
        if (r110 == null) goto L24;
        IKeyboardContent.a r111 = r110.getKey();
        if (r111 == null) goto L24;
        String r112 = r111.getTag();
    L25:
        ImmersiveVoiceInputComponent.a r113 = ImmersiveVoiceInputComponent.f430093a;
        if (Intrinsics.areEqual(r112, "ImmersiveVoiceKeyboardKey") == false) goto L29;
        boolean r114 = false;
    L30:
        zhb.a r115 = this.f423984k;
        if (r115 != null) goto L33;
    L35:
        boolean r116 = false;
    L36:
        if (r116 == false) goto L52;
        zhb.a r117 = this.f423984k;
        if (r117 != null) goto L40;
    L42:
        if (r106 == true) goto L53;
        if (r114 == false) goto L54;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r118 = this.f423980g;
        if (r118 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L48:
        View r119 = r103.getFragment().getView();
        if (r119 == null) goto L55;
        r119.postDelayed(new com.ss.android.lark.flow.replyinthread.pages.plugin.a(this), 200);
        return;
    L55:
        return;
    L47:
        r103 = r118;
        goto L48
    L54:
        return;
    L53:
        return;
    L40:
        if (r117.io() != true) goto L42;
        r106 = true;
        goto L42
    L52:
        return;
    L33:
        if (r115.hE() != true) goto L35;
        r116 = true;
    L24:
        r112 = null;
    L29:
        r114 = true;
        goto L30
    L5:
        r104 = null;
        goto L6
    }
}
