package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/common_ui/view/DotsIndicator;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linearLayout", "Landroid/widget/LinearLayout;", "dotsSize", "dotsSpacing", "dots", "", "Landroid/widget/ImageView;", "init", "", "addDots", "size", "initIndex", "addDot", "clearDots", "refreshDotColor", "index", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DotsIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f328229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f328231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ImageView> f328232d;

    public DotsIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DotsIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(int r100) {
        int r101 = this.f328232d.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r102 != r100) goto L6;
        ((ImageView) ListProtector.get(this.f328232d, r102)).setImageResource(R.drawable.larus_icon_selected);
    L7:
        r102 = r102 + 1;
        goto L3
    L6:
        ((ImageView) ListProtector.get(this.f328232d, r102)).setImageResource(R.drawable.larus_icon_unselected);
        goto L7
    }

    public DotsIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        AppHost.Companion r103 = AppHost.f326268a;
        LinearLayout r104 = null;
        this.f328230b = r103.getApplication().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8));
        this.f328231c = r103.getApplication().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_3, null, R.dimen.larus_dp_3));
        this.f328232d = new ArrayList();
        LinearLayout r105 = new LinearLayout(getContext());
        this.f328229a = r105;
        r105.setOrientation(0);
        LinearLayout r106 = this.f328229a;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
    L6:
        addView(r104, -2, -2);
        if (r101 == null) goto L10;
        getContext().obtainStyledAttributes(r101, new int[0]).recycle();
        return;
    L10:
        return;
    L5:
        r104 = r106;
        goto L6
    }

    public /* synthetic */ DotsIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
