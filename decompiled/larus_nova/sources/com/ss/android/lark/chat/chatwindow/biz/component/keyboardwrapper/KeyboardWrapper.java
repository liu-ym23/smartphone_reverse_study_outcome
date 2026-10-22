package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.chat.chatwindow.biz.component.threadkeyboard.IThreadKeyboardComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class KeyboardWrapper implements IKeyboardWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f412112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IKeyboardComponent f412113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IFuncKeyboardComponent f412114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IThreadKeyboardComponent f412115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f412116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f412117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f412118g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void I() {
        int r100 = this.f412116e;
        if (r100 != 0) goto L5;
        IKeyboardComponent r101 = this.f412113b;
        if (r101 == null) goto L23;
        r101.I();
        return;
    L23:
        return;
    L5:
        if (r100 != 1) goto L7;
        IFuncKeyboardComponent r102 = this.f412114c;
        if (r102 == null) goto L21;
        r102.I();
        return;
    L21:
        return;
    L7:
        if (r100 != 2) goto L24;
        IThreadKeyboardComponent r103 = this.f412115d;
        if (r103 == null) goto L19;
        r103.yY();
        return;
    L19:
        return;
    }

    public final ArrayList<IKeyboardWrapper.a> a() {
        return (ArrayList) this.f412117f.getValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void hideKeyboard() {
        int r100 = this.f412116e;
        if (r100 != 0) goto L5;
        IKeyboardComponent r101 = this.f412113b;
        if (r101 == null) goto L23;
        r101.hideKeyboard();
        return;
    L23:
        return;
    L5:
        if (r100 != 1) goto L7;
        IFuncKeyboardComponent r102 = this.f412114c;
        if (r102 == null) goto L21;
        r102.hideKeyboard();
        return;
    L21:
        return;
    L7:
        if (r100 != 2) goto L24;
        IThreadKeyboardComponent r103 = this.f412115d;
        if (r103 == null) goto L19;
        r103.Av();
        return;
    L19:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final int d0() {
        return this.f412116e;
    }

    public final Context getContext() {
        return this.f412112a;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void i0(final Function0 r100) {
        IKeyboardComponent r101 = this.f412113b;
        final int r102 = 0;
        if (r101 == null) goto L5;
        r101.GA(false);
    L5:
        Function0<Unit> r103 = new KeyboardWrapper$changeToKeyboard$2(r100, this, r102);
        int r104 = this.f412116e;
        if (r104 != 0) goto L8;
        r103.invoke();
        return;
    L8:
        IFuncKeyboardComponent r105 = this.f412114c;
        View r106 = null;
        if (r105 == null) goto L11;
        View r107 = r105.getRootView();
    L12:
        IKeyboardComponent r108 = this.f412113b;
        if (r108 == null) goto L15;
        View r109 = r108.getRootView();
    L16:
        IThreadKeyboardComponent r110 = this.f412115d;
        if (r110 == null) goto L19;
        r106 = r110.getRootView();
    L19:
        if (r107 == null) goto L28;
        if (r109 == null) goto L28;
        if (r106 == null) goto L28;
        Iterator<T> r111 = a().iterator();
    L25:
        if (r111.hasNext() == false) goto L27;
        ((IKeyboardWrapper.a) r111.next()).a(r104, 0);
        goto L25
    L27:
        r107.setVisibility(8);
        r106.setVisibility(8);
        r109.setVisibility(0);
        r109.setTranslationY(0.0f);
        r109.setAlpha(1.0f);
        r109.post(new d(this, r103, r104));
        return;
    L28:
        r103.invoke();
        return;
    L15:
        r109 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void l0(KeyboardWrapperConfigurator.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        a().add(r100);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void r(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r100) {
        Intrinsics.checkNotNullParameter("banned_select", "key");
        Intrinsics.checkNotNullParameter(r100, "banReason");
        int r101 = this.f412116e;
        if (r101 != 0) goto L5;
        IKeyboardComponent r102 = this.f412113b;
        if (r102 == null) goto L23;
        r102.f6(r100);
        return;
    L23:
        return;
    L5:
        if (r101 != 1) goto L7;
        IFuncKeyboardComponent r103 = this.f412114c;
        if (r103 == null) goto L21;
        r103.f6(r100);
        return;
    L21:
        return;
    L7:
        if (r101 != 2) goto L24;
        IThreadKeyboardComponent r104 = this.f412115d;
        if (r104 == null) goto L19;
        r104.b40();
        return;
    L19:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void start(Function1 r100) {
        this.f412116e = 0;
        if (r100 == null) goto L6;
        r100.invoke(0);
        return;
    }

    public KeyboardWrapper(Context r100, IKeyboardComponent r101, IFuncKeyboardComponent r102, IThreadKeyboardComponent r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f412112a = r100;
        this.f412113b = r101;
        this.f412114c = r102;
        this.f412115d = r103;
        this.f412117f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, KeyboardWrapper$listeners$2.INSTANCE);
        this.f412118g = LazyKt.lazy(LazyThreadSafetyMode.NONE, new KeyboardWrapper$animators$2(this));
    }
}
