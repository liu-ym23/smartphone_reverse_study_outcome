package com.larus.bmhome.view.textview.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.platform.service.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import st8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0000H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006!"}, d2 = {"Lcom/larus/bmhome/view/textview/impl/GestureTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downListener", "Lkotlin/Function0;", "", "getDownListener", "()Lkotlin/jvm/functions/Function0;", "setDownListener", "(Lkotlin/jvm/functions/Function0;)V", "clickX", "", "getClickX", "()F", "setClickX", "(F)V", "clickY", "getClickY", "setClickY", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "asTextView", "getContainer", "Landroid/widget/FrameLayout;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class GestureTextView extends AppCompatTextView implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Boolean> f317434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f317435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f317436c;

    public GestureTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GestureTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // st8.a
    public final View l5() {
        return null;
    }

    public FrameLayout getContainer() {
        ViewParent r100 = getParent();
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof FrameLayout) == false) goto L8;
        FrameLayout r101 = (FrameLayout) r100;
    L9:
        if (r101 != null) goto L12;
        g.f365738a.ensureNotReachHere(new IllegalStateException("this view must use FrameLayout as parent. current parent is " + r100), "");
        return null;
    L12:
        return r101;
    L8:
        r101 = null;
        goto L9
    }

    @Override // st8.a
    public float getClickX() {
        return this.f317435b;
    }

    @Override // st8.a
    public float getClickY() {
        return this.f317436c;
    }

    public Function0<Boolean> getDownListener() {
        return this.f317434a;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getAction() != 0) goto L9;
        setClickX(r100.getX());
        setClickY(r100.getY());
    L9:
        if (r100.getAction() != 0) goto L18;
        Function0<Boolean> r102 = getDownListener();
        if (r102 != null) goto L13;
    L15:
        if (r101 == false) goto L18;
        return true;
    L13:
        if (r102.invoke().booleanValue() != true) goto L15;
        r101 = true;
    L18:
        return super.onTouchEvent(r100);
    }

    public void setClickX(float r100) {
        this.f317435b = r100;
    }

    public void setClickY(float r100) {
        this.f317436c = r100;
    }

    public void setDownListener(Function0<Boolean> r100) {
        this.f317434a = r100;
    }

    public GestureTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ GestureTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
