package com.larus.doc.impl.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.doc.impl.chat.a;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;
import va8.o;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/impl/view/InterceptTouchFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chatContainerBounds", "Landroid/graphics/Rect;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "requestChatInputFocus", "", "isTouchInChatContainer", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InterceptTouchFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f331586a;

    public InterceptTouchFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InterceptTouchFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = super.dispatchTouchEvent(r100);
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        if (r102 == true) goto L9;
    L21:
        return r101;
    L9:
        if (getId() != R.id.doc_chat_input_container) goto L11;
    L12:
        FLogger.f375446a.i("[CORE_INPUT]", "dispatchTouchEvent: " + r100 + ", keyboard show");
        Fragment r103 = a.a();
        if (r103 == null) goto L21;
        b r104 = s1a.a.g(r103);
        if (r104 == null) goto L21;
        o r105 = (o) r104.getAbility(o.class);
        if (r105 == null) goto L21;
        if (r105.hh() == true) goto L21;
        r105.CJ(true, r100, true);
        goto L21
    L11:
        if (getId() != R.id.doc_chat_input_container_v2) goto L21;
    L5:
        if (r100.getActionMasked() != 0) goto L7;
        r102 = true;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (getId() != R.id.doc_fragment_container) goto L20;
        if (r100 == null) goto L9;
        View r101 = getRootView().findViewById(R.id.doc_chat_input_container_v2);
        if (r101 == null) goto L9;
        r101.getGlobalVisibleRect(this.f331586a);
        int[] r102 = new int[2];
        getLocationOnScreen(r102);
        boolean r103 = this.f331586a.contains(r102[0] + ((int) r100.getX()), r102[1] + ((int) r100.getY()));
    L11:
        if (r103 == true) goto L20;
        FLogger.f375446a.i("[CORE_INPUT]", "onInterceptTouchEvent: " + r100 + ", clear focus");
        Fragment r104 = a.a();
        if (r104 == null) goto L20;
        b r105 = s1a.a.g(r104);
        if (r105 == null) goto L20;
        o r106 = (o) r105.getAbility(o.class);
        if (r106 == null) goto L20;
        r106.CJ(false, null, false);
    L9:
        r103 = false;
    L20:
        return super.onInterceptTouchEvent(r100);
    }

    public InterceptTouchFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f331586a = new Rect();
    }

    public /* synthetic */ InterceptTouchFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
