package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/HideKeyboardLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scrollThreshold", "", "startClickTime", "", "startX", "startY", "hasHiddenInThisTouch", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HideKeyboardLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f435630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f435631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f435632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f435633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f435634e;

    public static final class a {
    }

    static {
    }

    public HideKeyboardLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HideKeyboardLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f435634e == false) goto L5;
        return;
    L5:
        this.f435634e = true;
        int r100 = bwb.b.f21271a;     // Catch: Exception -> L16
        MmUiLogScene r101 = MmUiLogScene.FOUNDATION;     // Catch: Exception -> L16
        bwb.b.b(r101, ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "hide keyboard", null, 8);     // Catch: Exception -> L16
        View r102 = getRootView().findFocus();     // Catch: Exception -> L16
        if (r102 == null) goto L9;
        bwb.b.b(r101, ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "clear focus, view=".concat(r102.getClass().getSimpleName()), null, 8);     // Catch: Exception -> L16
        r102.clearFocus();     // Catch: Exception -> L16
    L9:
        Object r103 = getContext().getSystemService("input_method");     // Catch: Exception -> L16
        if ((r103 instanceof InputMethodManager) == false) goto L12;
        InputMethodManager r104 = (InputMethodManager) r103;     // Catch: Exception -> L16
    L13:
        if (r104 == null) goto L21;
        r104.hideSoftInputFromWindow(getWindowToken(), 0);     // Catch: Exception -> L16
        return;
    L21:
        return;
    L12:
        r104 = null;
    L16:
        e = move-exception;
        int r105 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "error=" + e.getMessage(), null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f435631b = System.currentTimeMillis();
        this.f435632c = r100.getX();
        this.f435633d = r100.getY();
        this.f435634e = false;
    L30:
        return super.dispatchTouchEvent(r100);
    L27:
        e = move-exception;
        int r102 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "dispatchTouchEvent", String.valueOf(e), null);
        return false;
    L5:
        if (r101 == 1) goto L20;
        if (r101 == 2) goto L13;
        if (r101 != 3) goto L30;
        this.f435634e = false;
        goto L30
    L13:
        if (this.f435634e == true) goto L30;
        float r103 = Math.abs(r100.getX() - this.f435632c);
        float r104 = Math.abs(r100.getY() - this.f435633d);
        float r105 = this.f435630a;
        if (r103 <= r105) goto L17;
    L18:
        a();
        goto L30
    L17:
        if (r104 <= r105) goto L30;
    L20:
        if (this.f435634e == true) goto L30;
        if ((System.currentTimeMillis() - this.f435631b) >= 200) goto L30;
        a();
        goto L30
    }

    public HideKeyboardLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f435630a = UIUtils.dp2px(r100, 5.0f);
    }

    public /* synthetic */ HideKeyboardLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
