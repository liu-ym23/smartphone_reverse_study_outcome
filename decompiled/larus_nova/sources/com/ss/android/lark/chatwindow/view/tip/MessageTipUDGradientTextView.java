package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.keyframes.model.KFFeatureEffect;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.gradient.UDGradientDrawableKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/tip/MessageTipUDGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", KFFeatureEffect.GRADIENT_JSON_FIELD, "Lcom/larksuite/component/universe_design/gradient/UDGradientDrawable;", "boundsRect", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageTipUDGradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larksuite.component.universe_design.gradient.a f417085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f417086b;

    public MessageTipUDGradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MessageTipUDGradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f417086b.set(0, 0, getWidth(), getHeight());
        com.larksuite.component.universe_design.gradient.a r100 = this.f417085a;
        Rect r101 = this.f417086b;
        r100.setBounds(r101);
        int r102 = r110.saveLayer(r101.left, r101.top, r101.right, r101.bottom, null);
        super.onDraw(r110);
        r100.b((PorterDuffXfermode) UDGradientDrawableKt.f285024a.getValue());
        r100.draw(r110);
        r110.restoreToCount(r102);
        r100.b(null);
    }

    public MessageTipUDGradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = com.larksuite.component.universe_design.gradient.b.f285036a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larksuite.component.universe_design.gradient.a r104 = new com.larksuite.component.universe_design.gradient.a(ArraysKt.toIntArray(new Integer[]{Integer.valueOf(UDColorUtils.getColor(r100, R.color.ai_dynamic_line_0)), Integer.valueOf(UDColorUtils.getColor(r100, R.color.ai_dynamic_line_1)), Integer.valueOf(UDColorUtils.getColor(r100, R.color.ai_dynamic_line_1)), Integer.valueOf(UDColorUtils.getColor(r100, R.color.ai_dynamic_line_0))}));
        r104.mutate();
        this.f417085a = r104;
        this.f417086b = new Rect();
    }

    public /* synthetic */ MessageTipUDGradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
