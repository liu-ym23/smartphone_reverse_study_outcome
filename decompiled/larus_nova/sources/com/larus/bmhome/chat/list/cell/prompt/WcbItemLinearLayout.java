package com.larus.bmhome.chat.list.cell.prompt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/prompt/WcbItemLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickX", "", "getClickX", "()F", "setClickX", "(F)V", "clickY", "getClickY", "setClickY", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "addIconToItem", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "promptUIConfig", "Lcom/larus/bmhome/chat/layout/item/PromptUIConfig;", "(Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;Lcom/larus/bmhome/chat/layout/item/PromptUIConfig;)Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WcbItemLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f305532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f305533b;

    public WcbItemLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WcbItemLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getClickX() {
        return this.f305532a;
    }

    public final float getClickY() {
        return this.f305533b;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f305532a = r100.getX();
        this.f305533b = r100.getY();
        return super.onTouchEvent(r100);
    }

    public final void setClickX(float r100) {
        this.f305532a = r100;
    }

    public final void setClickY(float r100) {
        this.f305533b = r100;
    }

    public WcbItemLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ WcbItemLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
