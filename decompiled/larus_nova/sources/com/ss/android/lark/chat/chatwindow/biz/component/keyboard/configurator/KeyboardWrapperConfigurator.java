package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator;

import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorKey;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.IKeyboardTopExtendComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapperComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.threadkeyboard.IThreadKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner;
import com.ss.android.lark.keyboard.event.ForceHeightChange;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@ConfiguratorKey(ConfiguratorType.KEYBOARD_WRAPPER)
public final class KeyboardWrapperConfigurator implements l3c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f412049a = 0;

    public static final class a {
    }

    public static final class b implements IKeyboardWrapper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IKeyboardComponent f412050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f412051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IFuncKeyboardComponent f412052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f412053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f412054e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ IThreadKeyboardComponent f412055f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ f f412056g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ IKeyboardTopExtendComponent f412057h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Lazy<com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a> f412058i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ IMessageListComponent f412059j;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper.a
        public final void b(int r100) {
            IMessageListComponent r101 = this.f412059j;
            if (r101 == null) goto L5;
            r101.MH(ScrollScene.KEYBOARD_TYPE_CHANGE);
        L5:
            if (r100 != 0) goto L15;
            IKeyboardTopExtendComponent r102 = this.f412057h;
            if (r102 == null) goto L9;
            r102.Id();
        L9:
            IKeyboardComponent r103 = this.f412050a;
            if (r103 == null) goto L16;
            com.ss.android.lark.keyboard.b r104 = r103.n();
            if (r104 == null) goto L17;
            k r105 = r104.e();
            ForceHeightChange.Factory r106 = ForceHeightChange.f429286c;
            int r107 = com.ss.android.lark.c.a(r104);
            r106.getClass();
            ForceHeightChange r108 = r106.a();
            r108.f429288a = r107;
            k.a.a(r105, r108);
            return;
        L17:
            return;
        L16:
            return;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper.a
        public final void a(int r100, int r101) {
            if (r100 != r101) goto L5;
            return;
        L5:
            if (r101 != 0) goto L7;
            IKeyboardComponent r102 = this.f412050a;
            if (r102 == null) goto L60;
            e r103 = this.f412051b;
            Intrinsics.checkNotNullParameter(r102, "<this>");
            if (r103 == null) goto L57;
            r102.F20(r103);
        L57:
            com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r104 = this.f412058i.getValue();
            Intrinsics.checkNotNullParameter(r102, "<this>");
            if (r104 == null) goto L60;
            r102.lD(r104);
        L60:
            IFuncKeyboardComponent r105 = this.f412052c;
            if (r105 == null) goto L68;
            d r106 = this.f412053d;
            Intrinsics.checkNotNullParameter(r105, "<this>");
            if (r106 == null) goto L65;
            r105.aV(r106);
        L65:
            c r107 = this.f412054e;
            Intrinsics.checkNotNullParameter(r105, "<this>");
            if (r107 == null) goto L68;
            r105.pL(r107);
        L68:
            IThreadKeyboardComponent r108 = this.f412055f;
            if (r108 == null) goto L76;
            r108.l(this.f412056g);
            return;
        L76:
            return;
        L7:
            if (r101 != 1) goto L9;
            IKeyboardComponent r109 = this.f412050a;
            if (r109 == null) goto L38;
            e r110 = this.f412051b;
            Intrinsics.checkNotNullParameter(r109, "<this>");
            if (r110 == null) goto L35;
            r109.qk(r110);
        L35:
            com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r111 = this.f412058i.getValue();
            Intrinsics.checkNotNullParameter(r109, "<this>");
            if (r111 == null) goto L38;
            r109.lS(r111);
        L38:
            IFuncKeyboardComponent r112 = this.f412052c;
            if (r112 == null) goto L46;
            d r113 = this.f412053d;
            Intrinsics.checkNotNullParameter(r112, "<this>");
            if (r113 == null) goto L43;
            r112.FE(r113);
        L43:
            c r114 = this.f412054e;
            Intrinsics.checkNotNullParameter(r112, "<this>");
            if (r114 == null) goto L46;
            r112.rk(r114);
        L46:
            IThreadKeyboardComponent r115 = this.f412055f;
            if (r115 == null) goto L49;
            r115.l(this.f412056g);
        L49:
            IKeyboardTopExtendComponent r116 = this.f412057h;
            if (r116 == null) goto L74;
            r116.gt();
            return;
        L74:
            return;
        L9:
            if (r101 != 2) goto L77;
            IKeyboardComponent r117 = this.f412050a;
            if (r117 == null) goto L19;
            com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r118 = this.f412058i.getValue();
            Intrinsics.checkNotNullParameter(r117, "<this>");
            if (r118 == null) goto L16;
            r117.lS(r118);
        L16:
            e r119 = this.f412051b;
            Intrinsics.checkNotNullParameter(r117, "<this>");
            if (r119 == null) goto L19;
            r117.qk(r119);
        L19:
            IFuncKeyboardComponent r120 = this.f412052c;
            if (r120 == null) goto L27;
            d r121 = this.f412053d;
            Intrinsics.checkNotNullParameter(r120, "<this>");
            if (r121 == null) goto L24;
            r120.aV(r121);
        L24:
            c r122 = this.f412054e;
            Intrinsics.checkNotNullParameter(r120, "<this>");
            if (r122 == null) goto L27;
            r120.pL(r122);
        L27:
            IThreadKeyboardComponent r123 = this.f412055f;
            if (r123 == null) goto L72;
            r123.m(this.f412056g);
            return;
        L72:
            return;
        }

        public b(IKeyboardComponent r100, e r101, IFuncKeyboardComponent r102, d r103, c r104, IThreadKeyboardComponent r105, f r106, IKeyboardTopExtendComponent r107, Lazy<com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a> r108, IMessageListComponent r110) {
            this.f412050a = r100;
            this.f412051b = r101;
            this.f412052c = r102;
            this.f412053d = r103;
            this.f412054e = r104;
            this.f412055f = r105;
            this.f412056g = r106;
            this.f412057h = r107;
            this.f412058i = r108;
            this.f412059j = r110;
        }
    }

    public static final class c implements IFuncKeyboardComponent.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IKeyboardTopExtendComponent f412060a;

        public c(IKeyboardTopExtendComponent r100) {
            this.f412060a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent.c
        public final void a(boolean r100) {
            if (r100 == true) goto L6;
            IKeyboardTopExtendComponent r101 = this.f412060a;
            if (r101 == null) goto L10;
            r101.wC();
            return;
        L10:
            return;
        L6:
            IKeyboardTopExtendComponent r102 = this.f412060a;
            if (r102 == null) goto L12;
            r102.fb();
            return;
        }
    }

    public static final class d implements IFuncKeyboardComponent.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageListAnimationContainer f412061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMessageListComponent f412062b;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent.b
        public final void b(int r100) {
            MessageListAnimationContainer r101 = this.f412061a;
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            if (r102 == null) goto L12;
            ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
            r103.bottomMargin = r100;
            r101.setLayoutParams(r103);
            IMessageListComponent r104 = this.f412062b;
            if ((r104 instanceof IMessageListComponentInner) == false) goto L7;
            IMessageListComponentInner r105 = (IMessageListComponentInner) r104;
        L8:
            if (r105 == null) goto L13;
            r105.XE();
            return;
        L13:
            return;
        L7:
            r105 = null;
            goto L8
        L12:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        public d(MessageListAnimationContainer r100, IMessageListComponent r101) {
            this.f412061a = r100;
            this.f412062b = r101;
        }
    }

    public static final class e implements IKeyboardComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IKeyboardTopExtendComponent f412063a;

        public e(IKeyboardTopExtendComponent r100) {
            this.f412063a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent.a
        public final void a(boolean r100) {
            if (r100 == true) goto L6;
            IKeyboardTopExtendComponent r101 = this.f412063a;
            if (r101 == null) goto L10;
            r101.wC();
            return;
        L10:
            return;
        L6:
            IKeyboardTopExtendComponent r102 = this.f412063a;
            if (r102 == null) goto L12;
            r102.fb();
            return;
        }
    }

    public static final class f implements com.ss.android.lark.biz.im.api.extension.chat_window.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IKeyboardTopExtendComponent f412064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMessageListComponent f412065b;

        public f(IKeyboardTopExtendComponent r100, IMessageListComponent r101) {
            this.f412064a = r100;
            this.f412065b = r101;
        }
    }

    static {
    }

    @Inject
    public KeyboardWrapperConfigurator() {
    }

    @Override // l3c.c
    public final void a(l3c.f r110) {
        Intrinsics.checkNotNullParameter(r110, "rt");
        IKeyboardWrapperComponent r100 = (IKeyboardWrapperComponent) r110.a(IKeyboardWrapperComponent.class);
        if (r100 != null) goto L6;
        Log.w("KeyboardWrapperConfigurator", "keyboardWrapperComponent == null");
        return;
    L6:
        IKeyboardWrapper r101 = r100.wA();
        final MessageListAnimationContainer r102 = (MessageListAnimationContainer) ViewCompat.requireViewById(r110.getFragment().requireView(), R.id.msg_lis_anim_container);
        final IMessageListComponent r111 = (IMessageListComponent) r110.a(IMessageListComponent.class);
        IKeyboardTopExtendComponent r112 = (IKeyboardTopExtendComponent) r110.a(IKeyboardTopExtendComponent.class);
        final IKeyboardComponent r103 = (IKeyboardComponent) r110.a(IKeyboardComponent.class);
        IFuncKeyboardComponent r104 = (IFuncKeyboardComponent) r110.a(IFuncKeyboardComponent.class);
        IThreadKeyboardComponent r105 = (IThreadKeyboardComponent) r110.a(IThreadKeyboardComponent.class);
        final e r106 = new e(r112);
        c r107 = new c(r112);
        d r108 = new d(r102, r111);
        f r113 = new f(r112, r111);
        final Lazy r114 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new KeyboardWrapperConfigurator$configure$keyboardEventHandler$2(r102, r111));
        r101.start(new KeyboardWrapperConfigurator$configure$1(r103, r106, r114));
        r101.l0(new b(r103, r106, r104, r108, r107, r105, r113, r112, r114, r111));
    }
}
