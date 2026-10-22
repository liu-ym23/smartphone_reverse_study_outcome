package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class SettingGroupDividerDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f284008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f284009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f284012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f284013f;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return UIUtils.dp2px(this.f284008a, 0.5f);
    }

    public SettingGroupDividerDrawable(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f284008a = r100;
        this.f284010c = UIUtils.getColor(r100, R.color.bg_body);
        invalidateSelf();
        this.f284011d = UIUtils.getColor(r100, R.color.line_divider_default);
        invalidateSelf();
        this.f284009b = UIUtils.dp2px(r100, 16.0f);
        invalidateSelf();
        this.f284012e = new Rect();
        this.f284013f = LazyKt.lazy(SettingGroupDividerDrawable$paint$2.INSTANCE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        ((Paint) this.f284013f.getValue()).setColor(this.f284010c);
        r100.drawRect(getBounds(), (Paint) this.f284013f.getValue());
        ((Paint) this.f284013f.getValue()).setColor(this.f284011d);
        if (this.f284012e.isEmpty() == false) goto L5;
        return;
    L5:
        if (getBounds().contains(this.f284012e) == false) goto L9;
        r100.drawRect(this.f284012e, (Paint) this.f284013f.getValue());
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        int r101 = r100.left + this.f284009b;
        int r102 = r100.right + 0;
        this.f284012e.set(r101, r100.top, r102, r100.bottom);
    }
}
