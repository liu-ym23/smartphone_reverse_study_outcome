package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.store.tabkit.TabKitAbilityConfig;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rk3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/CustomTopItemConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lrk3/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomTopItemConstraintLayout extends ConstraintLayout implements c {
    public CustomTopItemConstraintLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomTopItemConstraintLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // rk3.c
    public TabKitFragment getTabkitFragment() {
        return c.a.a(this);
    }

    public TabKitViewModel getViewModel() {
        TabKitFragment r0 = getTabkitFragment();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        TabKitViewModel r0 = getViewModel();
        if (r0 == null) goto L9;
        TabKitAbilityConfig r1 = r0.getAbilityConfig();
        if (r1 == null) goto L9;
        if (r1.b("disable_new_top_bar") != true) goto L9;
        super.onMeasure(r3, r4);
        return;
    L9:
        View r2 = findViewById(2131388475);
        r2.measure(r3, r4);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r2.getMeasuredWidth(), View.MeasureSpec.getMode(r3)), r4);
    }

    public CustomTopItemConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CustomTopItemConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
