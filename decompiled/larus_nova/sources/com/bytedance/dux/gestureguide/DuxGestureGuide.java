package com.bytedance.dux.gestureguide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/dux/gestureguide/DuxGestureGuide;", "Landroid/widget/FrameLayout;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setBackGround", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxGestureGuide extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f205176a = 0;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxGestureGuide f205178a;

        public a(DuxGestureGuide r100) {
            this.f205178a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DuxGestureGuide r101 = this.f205178a;
            int r102 = DuxGestureGuide.f205176a;
            r101.getClass();
            n.e(r101);
        }
    }

    public static final class b {
    }

    static {
    }

    public DuxGestureGuide(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxGestureGuide(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void setBackGround(Drawable r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setBackgroundColor(getContext().getResources().getColor(R.color.dux_gesture_guide_background, null));
    L6:
        if (r100 == null) goto L9;
        setBackground(r100);
        return;
    L9:
        return;
    L5:
        setBackgroundColor(getContext().getResources().getColor(R.color.dux_gesture_guide_background));
        goto L6
    }

    public DuxGestureGuide(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOnClickListener(new a(this));
        addOnAttachStateChangeListener(new AnonymousClass2(this));
    }

    public /* synthetic */ DuxGestureGuide(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
