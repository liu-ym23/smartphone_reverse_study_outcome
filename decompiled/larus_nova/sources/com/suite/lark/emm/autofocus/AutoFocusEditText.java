package com.suite.lark.emm.autofocus;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.emm.design.edittext.SCEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0002%&B\u001d\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0014J\u0010\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0013H\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/suite/lark/emm/autofocus/AutoFocusEditText;", "Lcom/suite/lark/emm/design/edittext/SCEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "keyboardSelectionDependency", "Lcom/suite/lark/emm/autofocus/AutoFocusEditText$KeyboardSelectionDependency;", "globalFocusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "isRequestingFocus", "", "isAutoFocusEnabled", "onAttachedToWindow", "", "setAutoFocusEnabled", "enabled", "registerFocusListener", "unregisterFocusListener", "createFocusListener", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "isVisible", "view", "enableKeyboardSelection", "handleKeyEvent", "keyCode", "event", "Landroid/view/KeyEvent;", "onDetachedFromWindow", "Companion", "KeyboardSelectionDependency", "enterprise-mobility-management-design-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoFocusEditText extends SCEditText {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f460422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public aoc.a f460423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f460424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f460425e;

    public static final class a {
    }

    public interface b {
        void onNext();

        void onPrev();

        void onSelect();
    }

    public static final class c implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoFocusEditText f460426a;

        public c(AutoFocusEditText r100) {
            this.f460426a = r100;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r100, int r101, KeyEvent r102) {
            AutoFocusEditText r103 = this.f460426a;
            r103.getClass();
            if (AutoFocusEditText.b(r103) == true) goto L6;
            Log.i("AutoFocusEditText", "handleKeyEvent, but invisible");
            return false;
        L6:
            StringBuilder r104 = new StringBuilder("handleKeyEvent, ");
            if (r102 == null) goto L9;
            Integer r105 = Integer.valueOf(r102.getAction());
        L10:
            r104.append(r105);
            Log.i("AutoFocusEditText", r104.toString());
            AutoFocusEditText r106 = this.f460426a;
            Intrinsics.checkNotNull(r102);
            r106.getClass();
            if (r102.getAction() == 0) goto L14;
            return false;
        L14:
            if (r101 != 19) goto L16;
            b r107 = r106.f460422b;
            if (r107 == null) goto L31;
            r107.onPrev();
        L31:
            return true;
        L16:
            if (r101 != 20) goto L18;
        L25:
            b r108 = r106.f460422b;
            if (r108 == null) goto L31;
            r108.onNext();
            goto L31
        L18:
            if (r101 == 61) goto L25;
            if (r101 != 66) goto L34;
            b r109 = r106.f460422b;
            if (r109 == null) goto L31;
            r109.onSelect();
            goto L31
        L34:
            return false;
        L9:
            r105 = null;
            goto L10
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AutoFocusEditText f460427a;

        public d(AutoFocusEditText r100) {
            this.f460427a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f460427a.requestFocus();     // Catch: Throwable -> L4
            this.f460427a.getViewTreeObserver().addOnGlobalFocusChangeListener(this.f460427a.f460423c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c() {
        if (aoc.b.a() == false) goto L10;
        Boolean r100 = ExternalKeyboardUtils.f285887a;
        if (ExternalKeyboardUtils.b(false) == false) goto L10;
        Log.i("AutoFocusEditText", "registerFocusListener");
        if (this.f460423c != null) goto L9;
        this.f460423c = new aoc.a(this);
    L9:
        post(new d(this));
        return;
    L10:
        Log.i("AutoFocusEditText", "registerFocusListener is not required");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("AutoFocusEditText", "onAttachedToWindow isAutoFocusEnabled: " + this.f460425e);
        if (this.f460425e == false) goto L6;
        c();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("AutoFocusEditText", "unregisterFocusListener");
        aoc.a r100 = this.f460423c;
        if (r100 == null) goto L6;
        getViewTreeObserver().removeOnGlobalFocusChangeListener(r100);
        return;
    }

    public AutoFocusEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static boolean b(View r100) {
        if (r100 != null) goto L4;
    L11:
        return false;
    L4:
        if (r100.isShown() == false) goto L11;
        Rect r101 = new Rect();
        if (r100.getGlobalVisibleRect(r101) == false) goto L11;
        if (r101.isEmpty() == true) goto L11;
        return true;
    }

    public final void a(b r100) {
        if (this.f460425e == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.f460422b, r100) == false) goto L8;
        return;
    L8:
        this.f460422b = r100;
        if (r100 == null) goto L11;
        setOnKeyListener(new c(this));
        return;
    L11:
        setOnKeyListener(null);
    }

    public final void setAutoFocusEnabled(boolean r100) {
        if (this.f460425e != r100) goto L5;
        return;
    L5:
        this.f460425e = r100;
        if (isAttachedToWindow() == false) goto L13;
        if (r100 == false) goto L9;
        c();
        return;
    L9:
        Log.i("AutoFocusEditText", "unregisterFocusListener");
        aoc.a r101 = this.f460423c;
        if (r101 == null) goto L15;
        getViewTreeObserver().removeOnGlobalFocusChangeListener(r101);
        return;
    L15:
        return;
    }

    public AutoFocusEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f460425e = true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (this.f460425e == true) goto L5;
        return;
    L5:
        if (aoc.b.a() == false) goto L16;
        Boolean r102 = ExternalKeyboardUtils.f285887a;
        if (ExternalKeyboardUtils.b(false) == true) goto L9;
        return;
    L9:
        if (this.f460423c == null) goto L19;
        Log.i("AutoFocusEditText", "onVisibilityChanged visibility is " + r101);
        getViewTreeObserver().removeOnGlobalFocusChangeListener(this.f460423c);
        if (r101 != 0) goto L18;
        getViewTreeObserver().addOnGlobalFocusChangeListener(this.f460423c);
        return;
    L18:
        return;
    L19:
        return;
    }

    public AutoFocusEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f460425e = true;
    }
}
