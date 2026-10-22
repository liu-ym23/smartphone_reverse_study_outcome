package com.larus.bmhome.chat.cell.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ed8.h;
import ed8.i;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u001f\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/cell/view/MessageInboxContainerView;", "Lcom/larus/bmhome/chat/cell/view/AbstractMessageBoxContainerView;", "Lcom/larus/bmhome/chat/cell/view/IUpdateMessageHolderDraw;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getLayoutId", "", "needDrawGap", "", "gapColor", "Ljava/lang/Integer;", "gapDrawPaint", "Landroid/graphics/Paint;", "getGapDrawPaint", "()Landroid/graphics/Paint;", "gapDrawPaint$delegate", "Lkotlin/Lazy;", "baseCompositeBox", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawGap", "findView", "needDrawGapBackground", "need", "color", "(ZLjava/lang/Integer;)V", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageInboxContainerView extends AbstractMessageBoxContainerView implements h {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f297866s = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f297867p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f297868q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public g f297869r;

    @Override // com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView
    public int getLayoutId() {
        return R.layout.larus_view_base_message_in_v2;
    }

    private final Paint getGapDrawPaint() {
        return (Paint) this.f297868q.getValue();
    }

    public MessageInboxContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        g r101 = this.f297869r;
        if (r101 != null) goto L5;
    L20:
        super.onDraw(r100);
        return;
    L5:
        if (r101.getHeight() >= getHeight()) goto L20;
        Integer r102 = this.f297867p;
        if (r102 == null) goto L20;
        int r103 = r102.intValue();
        g r104 = this.f297869r;
        int r105 = 0;
        if (r104 == null) goto L11;
        int r106 = r104.getLeft();
    L12:
        float r107 = r106;
        g r108 = this.f297869r;
        if (r108 == null) goto L15;
        r105 = r108.getHeight();
    L15:
        float r109 = r105;
        g r110 = this.f297869r;
        if (r110 == null) goto L18;
        Number r111 = Integer.valueOf(r110.getWidth());
    L19:
        RectF r112 = new RectF(r107, r109, r111.floatValue() + r107, getHeight());
        getGapDrawPaint().setColor(r103);
        r100.drawRect(r112, getGapDrawPaint());
        goto L20
    L18:
        r111 = Float.valueOf(0.0f);
        goto L19
    L11:
        r106 = 0;
        goto L12
    }

    public MessageInboxContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f297868q = LazyKt.lazy(new i());
    }

    @Override // ed8.h
    public final void o5(boolean r100, Integer r101) {
        this.f297867p = r101;
        if (r100 == false) goto L13;
        setWillNotDraw(false);
        invalidate();
        if (this.f297869r != null) goto L19;
        Iterator<View> r102 = ViewGroupKt.getChildren(this).iterator();
    L9:
        if (r102.hasNext() == false) goto L20;
        View r103 = r102.next();
        if ((r103 instanceof g) == false) goto L9;
        this.f297869r = (g) r103;
        return;
    L20:
        return;
    L19:
        return;
    L13:
        setWillNotDraw(true);
    }

    @Override // com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        U5();
        super.onMeasure(r100, r101);
    }
}
