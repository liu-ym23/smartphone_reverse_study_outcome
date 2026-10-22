package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/RelativeLayoutWithLastMotion;", "Landroid/widget/RelativeLayout;", "Lcom/larus/common_ui/widget/ILastMotionView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastMotionDelegate", "Lcom/larus/common_ui/widget/LastMotionViewDelegate;", "lastMotionX", "", "getLastMotionX", "()Ljava/lang/Float;", "lastMotionY", "getLastMotionY", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RelativeLayoutWithLastMotion extends RelativeLayout implements z19.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z19.r f304866a;

    public RelativeLayoutWithLastMotion(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RelativeLayoutWithLastMotion(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // z19.j
    public Float getLastMotionX() {
        return this.f304866a.f569704a;
    }

    @Override // z19.j
    public Float getLastMotionY() {
        return this.f304866a.f569705b;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f304866a.a(r100);
        return super.onTouchEvent(r100);
    }

    public RelativeLayoutWithLastMotion(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f304866a = new z19.r();
    }

    public /* synthetic */ RelativeLayoutWithLastMotion(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
