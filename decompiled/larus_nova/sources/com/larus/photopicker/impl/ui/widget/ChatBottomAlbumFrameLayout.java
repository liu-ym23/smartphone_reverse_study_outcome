package com.larus.photopicker.impl.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/photopicker/impl/ui/widget/ChatBottomAlbumFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialX", "", "isIntercepting", "", "enableIntercepting", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "interceptHorizontalMove", "", "intercept", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBottomAlbumFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f364172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f364173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f364174c;

    public ChatBottomAlbumFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatBottomAlbumFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(boolean r100) {
        if (this.f364174c != r100) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ChatBottomAlbumFrameLayout", "[interceptHorizontalMove] intercept:" + r100);
        this.f364174c = r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f364174c == false) goto L5;
        int r101 = r100.getAction();
        if (r101 != 0) goto L9;
        this.f364173b = false;
        this.f364172a = r100.getX();
    L17:
        if (this.f364173b == false) goto L20;
        return true;
    L20:
        return super.dispatchTouchEvent(r100);
    L9:
        if (r101 != 2) goto L17;
        if (Math.abs(r100.getX() - this.f364172a) <= 50.0f) goto L17;
        this.f364173b = true;
        return true;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    public ChatBottomAlbumFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f364174c = true;
    }

    public /* synthetic */ ChatBottomAlbumFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
