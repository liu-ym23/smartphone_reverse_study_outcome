package com.suite.lark.platform.component;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.SeekBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/suite/lark/platform/component/AudioSeekBar;", "Landroid/widget/SeekBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "touchDownX", "", ECSaasScrollViewController.SEARCH_SCROLL_STATE_DRAGGING, "", "touchSlop", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "widget-biz-chatkeyboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSeekBar extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f460472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f460473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f460474c;

    public AudioSeekBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public AudioSeekBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public AudioSeekBar(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L30;
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L11;
        return true;
    L11:
        if (this.f460473b == true) goto L13;
        setPressed(false);
        return true;
    L13:
        return super.onTouchEvent(r100);
    L17:
        if (this.f460473b == false) goto L19;
    L22:
        this.f460473b = true;
        return super.onTouchEvent(r100);
    L19:
        if (Math.abs(r100.getX() - this.f460472a) > this.f460474c) goto L22;
        return true;
    L25:
        if (this.f460473b == true) goto L27;
        setPressed(false);
        performClick();
        return true;
    L27:
        return super.onTouchEvent(r100);
    L30:
        this.f460472a = r100.getX();
        this.f460473b = false;
        setPressed(true);
        super.onTouchEvent(r100);
        return true;
    }

    public AudioSeekBar(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
        this.f460474c = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ AudioSeekBar(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = R.attr.seekBarStyle;
    L8:
        this(r100, r101, r102, 0);
    }
}
