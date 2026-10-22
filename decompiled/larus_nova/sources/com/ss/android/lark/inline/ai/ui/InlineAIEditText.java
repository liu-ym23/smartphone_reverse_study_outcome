package com.ss.android.lark.inline.ai.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ss.android.lark.inline.ai.ui.richtext.InlineAiRichTextMovementMethod;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0014J\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u001b\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/InlineAIEditText;", "Lcom/ss/android/lark/keyboard/edittext2/widget/RichTextFunctionEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "editTextFunction", "Lcom/ss/android/lark/inline/ai/ui/view/IEditTextFunction;", "actionOnTouchFinish", "Lkotlin/Function0;", "", "setEditTextFunction", "onSelectionChanged", "start", "end", "getEditTextContent", "", "onFocusChanged", "focused", "", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "setupAtEditor", "doOnTouchFinish", "action", "doOnTouchFinish$inline_ai_impl_release", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InlineAIEditText extends RichTextFunctionEditText {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.lark.inline.ai.ui.view.b f427419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f427420g;

    public static final class a {
    }

    static {
    }

    public InlineAIEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InlineAIEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Object getEditTextContent() {
        com.ss.android.lark.inline.ai.ui.view.b r100 = this.f427419f;
        if (r100 == null) goto L7;
        Object r101 = r100.t(this);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return String.valueOf(getText());
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Log.d("InlineAIEditText", "onTouchEvent: called");
        boolean r101 = super.onTouchEvent(r100);
        this.f427420g.invoke();
        return r101;
    }

    public final void setEditTextFunction(com.ss.android.lark.inline.ai.ui.view.b r100) {
        Intrinsics.checkNotNullParameter(r100, "editTextFunction");
        this.f427419f = r100;
        addTextChangedListener(r100);
        setFilters(getFilters());
        setKeyListener(getKeyListener());
    }

    @Override // com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText, android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        Log.i("InlineAIEditText", "onSelectionChanged " + r100 + ", " + r101);
    }

    public InlineAIEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (new bmb.a().f19670b.isCurrentEnable("ccm.knowledge.inline_ai_mention_all_enable") == false) goto L5;
        com.ss.android.lark.keyboard.edittext2.edittors.a.C5088a r103 = com.ss.android.lark.keyboard.edittext2.edittors.a.f428974e;
        q(r103);
        setMovementMethod(new InlineAiRichTextMovementMethod(this));
        ArrayList r104 = new ArrayList();
        r104.add(new com.ss.android.lark.inline.ai.ui.richtext.c());
        ((com.ss.android.lark.keyboard.edittext2.edittors.a) q(r103)).W(r104);
    L5:
        this.f427420g = InlineAIEditText$actionOnTouchFinish$1.INSTANCE;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        super.onFocusChanged(r100, r101, r102);
        Log.i("InlineAIEditText", "onFocusChanged " + r100);
        com.ss.android.lark.inline.ai.ui.view.b r103 = this.f427419f;
        if (r103 == null) goto L6;
        r103.B(this, r100);
        return;
    }

    public /* synthetic */ InlineAIEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
