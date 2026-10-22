package xm;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f564530b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f564531a;

    public static final class a {
    }

    public final View getTagView() {
        return getChildAt(0);
    }

    static {
        f564530b = new int[]{R.attr.state_checked};
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f564531a);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f564531a;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        if (this.f564531a == false) goto L5;
        FrameLayout.mergeDrawableStates(r101, f564530b);
    L5:
        return r101;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f564531a == r100) goto L6;
        this.f564531a = r100;
        refreshDrawableState();
        return;
    }
}
