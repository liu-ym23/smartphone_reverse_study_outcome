package com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.android.ec.model.g;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 l2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006:\u0001lB\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020)H\u0016J\f\u0010>\u001a\u00020;*\u00020)H\u0002J\u0014\u0010?\u001a\u00020;2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030'H\u0016J\u0010\u0010>\u001a\u00020;*\u0006\u0012\u0002\b\u00030'H\u0002J\b\u0010A\u001a\u00020\u001bH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016J\n\u0010E\u001a\u0004\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020\bH\u0016J\r\u0010G\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010HJ\u001c\u0010I\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020L0K\u0012\u0004\u0012\u00020L0JH\u0016J\b\u0010M\u001a\u00020;H\u0016J\b\u0010N\u001a\u00020;H\u0016J\b\u0010O\u001a\u00020;H\u0016J\b\u0010P\u001a\u00020;H\u0016J\b\u0010Q\u001a\u00020;H\u0002J\b\u0010R\u001a\u00020;H\u0002J\b\u0010S\u001a\u00020;H\u0002J\u0010\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020\fH\u0002J\b\u0010V\u001a\u00020\bH\u0016J\b\u0010W\u001a\u00020\bH\u0016J\u0018\u0010X\u001a\u00020;2\u0006\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020\u0014H\u0016J\b\u0010[\u001a\u00020;H\u0016J\b\u0010\\\u001a\u00020;H\u0016J\b\u0010]\u001a\u00020;H\u0016J\u0010\u0010^\u001a\u00020;2\u0006\u0010_\u001a\u00020\u001eH\u0016J\u0010\u0010`\u001a\u00020;2\u0006\u0010_\u001a\u00020\u001eH\u0016J\u0010\u0010a\u001a\u00020;2\u0006\u0010_\u001a\u00020#H\u0016J\u0010\u0010b\u001a\u00020;2\u0006\u0010_\u001a\u00020#H\u0016J\b\u0010c\u001a\u00020\u001bH\u0002J\u0010\u0010d\u001a\u00020;2\u0006\u0010e\u001a\u00020DH\u0016J\u0010\u0010f\u001a\u00020;2\u0006\u0010e\u001a\u00020DH\u0016J\u0011\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010i\u001a\u00020;2\u0006\u0010h\u001a\u00020\u0004H\u0096\u0001R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\u001f\u0010 R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b$\u0010 R\u0014\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u0018\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\bk\u0010 ¨\u0006m"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/FuncKeyboardComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$IFuncKeyboardComponentCallbacks;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/View$OnAttachStateChangeListener;", "enableFuncKeyboard", "", "<init>", "(Z)V", "mCurrentChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "mCurrentChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "mOpenApp", "Lcom/ss/android/lark/biz/im/api/OpenApp;", "mBannedReasons", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/BannedKeyboardReason;", "Lkotlin/collections/HashMap;", "getMBannedReasons", "()Ljava/util/HashMap;", "mBannedReasons$delegate", "Lkotlin/Lazy;", "mLastTotalHeight", "", "mStatusListeners", "", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$IFuncKeyboardStatusListener;", "getMStatusListeners", "()Ljava/util/List;", "mStatusListeners$delegate", "mControlStatusListeners", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$OnKeyboardControlStatusChangeListener;", "getMControlStatusListeners", "mControlStatusListeners$delegate", "mContentPlugin", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardContent;", "mKeyboardSwitcher", "Lcom/ss/android/lark/keyboard/base/IKeyboardSwitcherPlugin;", "isCreated", "mSwitcherContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMSwitcherContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMSwitcherContainer", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mMenuContainer", "Landroid/widget/FrameLayout;", "getMMenuContainer", "()Landroid/widget/FrameLayout;", "setMMenuContainer", "(Landroid/widget/FrameLayout;)V", "mRootContainer", "getMRootContainer", "setMRootContainer", "registerKeyboardSwitcher", "", "name", "keyboardSwitcher", "attachToFuncKeyboard", "registerFuncKeyboardContent", "contentPlugin", "getKeyboardType", "isKeyboardEnable", "getContainerView", "Landroid/view/View;", "getRootView", "hasView", "getLayoutResId", "()Ljava/lang/Integer;", "provideWidgetExport", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onPause", "onStop", "initView", "addGlobalLayoutListener", "removeGlobalLayoutListener", "setupKeyboardEnable", "chat", "needHideKeyBoard", "isKeyboardBanned", "bannedKeyboardShown", "reason", "banReason", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "showKeyboard", "onGlobalLayout", "addKeyboardStatusListener", "listener", "removeKeyboardStatusListener", "registerKeyboardControlStatusChangeListener", "unRegisterKeyboardControlStatusChangeListener", "getFuncKeyboardTotalHeight", "onViewAttachedToWindow", BaseSwitches.V, "onViewDetachedFromWindow", "registerCallback", "callback", "unregisterCallback", "callbacks", "getCallbacks", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FuncKeyboardComponent extends ChatBaseComponent implements IFuncKeyboardComponent, oxa.c<IFuncKeyboardComponent.a>, ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f412002s = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ oxa.a<IFuncKeyboardComponent.a> f412003l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Chat f412004m;

    @BindView(10635)
    public FrameLayout mMenuContainer;

    @BindView(10206)
    public ConstraintLayout mRootContainer;

    @BindView(g.STATUS_COMMERCE_PERMISSION_DENIED)
    public ConstraintLayout mSwitcherContainer;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ChatChatter f412005n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f412006o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f412007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f412008q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f412009r;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FuncKeyboardComponent f412010a;

        public b(FuncKeyboardComponent r100) {
            this.f412010a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            i7b.a r101 = (i7b.a) r100;
            Intrinsics.checkNotNullParameter(r101, "initData");
            PerfLog.start("func_keyboard_init_with_data", "");
            FuncKeyboardComponent r102 = this.f412010a;
            r102.f412004m = r101.f488506f;
            r102.f412005n = r101.f488507g;
            if (r102.G0() == false) goto L5;
            this.f412010a.hideKeyboard();
        L5:
            FuncKeyboardComponent r103 = this.f412010a;
            Chat r104 = r103.f412004m;
            Iterator r105 = r103.f412003l.f527095a.iterator();
        L7:
            if (r105.hasNext() == false) goto L9;
            ((IFuncKeyboardComponent.a) r105.next()).b();
            goto L7
        L9:
            PerfLog.end("func_keyboard_init_with_data", "");
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FuncKeyboardComponent f412011a;

        public c(FuncKeyboardComponent r100) {
            this.f412011a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Chat) r100) == null) goto L6;
            FuncKeyboardComponent r101 = this.f412011a;
            int r102 = FuncKeyboardComponent.f412002s;
            r101.getClass();
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final boolean v0() {
        return true;
    }

    public final ConstraintLayout F0() {
        ConstraintLayout r100 = this.mRootContainer;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
        return null;
    }

    public final boolean G0() {
        int r100 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.f412048a;
        Chat r101 = this.f412004m;
        ChatChatter r102 = this.f412005n;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L24;
        if (r101 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L24;
        if (r101 != null) goto L18;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == true) goto L24;
        boolean r106 = false;
    L25:
        if (r106 == true) goto L31;
        int r107 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.f412120d;
        if (com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C4795a.a((HashMap) this.f412006o.getValue()) == true) goto L32;
        return false;
    L32:
        return true;
    L31:
        return true;
    L18:
        if (r101.isFrozen() == false) goto L20;
        r105 = true;
        goto L21
    L11:
        if (r101.isChatable() == false) goto L14;
        r104 = false;
    L24:
        r106 = true;
        goto L25
    L5:
        if (r102.isDimission() == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.b
    public final View getRootView() {
        if (this.mRootContainer != null) goto L7;
        return null;
    L7:
        return F0();
    }

    @Override // com.ss.android.lark.scaffold.Component, com.ss.android.lark.framework.larkwidget.Widget
    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(IFuncKeyboardComponent.class, this));
    }

    public FuncKeyboardComponent() {
        this.f412003l = new oxa.a();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.f412006o = LazyKt.lazy(r100, FuncKeyboardComponent$mBannedReasons$2.INSTANCE);
        this.f412008q = LazyKt.lazy(r100, FuncKeyboardComponent$mStatusListeners$2.INSTANCE);
        this.f412009r = LazyKt.lazy(r100, FuncKeyboardComponent$mControlStatusListeners$2.INSTANCE);
    }

    public final void E0() {
        ConstraintLayout r100 = F0();
        if (r100.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101.isAlive() == false) goto L9;
        Log.d("FuncKeyboardComponent", "observer " + r101 + " add global layout " + this);
        r101.addOnGlobalLayoutListener(this);
        return;
    }

    public final void H0() {
        ConstraintLayout r100 = F0();
        if (r100.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101.isAlive() == false) goto L9;
        Log.d("FuncKeyboardComponent", "observer " + r101 + " remove global layout " + this);
        r101.removeOnGlobalLayoutListener(this);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void I() {
        if (G0() == false) goto L5;
        return;
    L5:
        F0().setVisibility(0);
        Iterator r100 = ((List) this.f412009r.getValue()).iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        IFuncKeyboardComponent.c r101 = (IFuncKeyboardComponent.c) r100.next();
        int r102 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.f412120d;
        r101.a(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C4795a.b((HashMap) this.f412006o.getValue()));
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void hideKeyboard() {
        F0().setVisibility(8);
        Iterator r100 = ((List) this.f412009r.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IFuncKeyboardComponent.c r101 = (IFuncKeyboardComponent.c) r100.next();
        int r102 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.f412120d;
        r101.a(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C4795a.b((HashMap) this.f412006o.getValue()));
        goto L4
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final void onCreate() {
        super.onCreate();
        PerfLog.start("func_keyboard_init", "");
        View r100 = this.f425740e;
        if (r100 == null) goto L7;
        ButterKnife.bind(this, r100);
        E0();
        F0().addOnAttachStateChangeListener(this);
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(D0(), this, new b(this));
        C0().observe(this, new c(this));
        PerfLog.end("func_keyboard_init", "");
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final void onDestroy() {
        H0();
        F0().removeOnAttachStateChangeListener(this);
        super.onDestroy();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (F0().getVisibility() != 8) goto L5;
        int r100 = 0;
    L7:
        if (r100 == this.f412007p) goto L15;
        Iterator r101 = ((List) this.f412008q.getValue()).iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        ((IFuncKeyboardComponent.b) r101.next()).b(r100);
        goto L10
    L12:
        this.f412007p = r100;
        return;
    L15:
        return;
    L5:
        Log.d("FuncKeyboardComponent", "func keyboard total height = " + F0().getHeight());
        r100 = F0().getHeight();
        goto L7
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final Integer r0() {
        return Integer.valueOf(R.layout.chat_window_component_func_keyboard);
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final void onPause() {
        super.onPause();
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final void onStop() {
        super.onStop();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void FE(KeyboardWrapperConfigurator.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((List) this.f412008q.getValue()).add(r100);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void aV(KeyboardWrapperConfigurator.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((List) this.f412008q.getValue()).remove(r100);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void f6(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r100) {
        Intrinsics.checkNotNullParameter("banned_select", "reason");
        Intrinsics.checkNotNullParameter(r100, "banReason");
        ((HashMap) this.f412006o.getValue()).put("banned_select", r100);
        if (G0() == false) goto L5;
        hideKeyboard();
        return;
    L5:
        I();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        E0();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        H0();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void pL(KeyboardWrapperConfigurator.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((List) this.f412009r.getValue()).remove(r100);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void rk(KeyboardWrapperConfigurator.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((List) this.f412009r.getValue()).add(r100);
    }
}
