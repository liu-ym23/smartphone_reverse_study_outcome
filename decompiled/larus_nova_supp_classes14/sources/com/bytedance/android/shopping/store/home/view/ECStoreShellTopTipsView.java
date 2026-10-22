package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreShellTopTipsView;", "Landroid/widget/FrameLayout;", "", "value", "c", "F", "getCollapse", "()F", "setCollapse", "(F)V", "collapse", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreShellTopTipsView extends FrameLayout {
    public final FrameLayout a;
    public final FrameLayout b;
    public float c;

    public static final class a {
    }

    static {
    }

    public ECStoreShellTopTipsView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStoreShellTopTipsView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final float getCollapse() {
        return this.c;
    }

    public final void setCollapse(float r2) {
        if (this.c == r2) goto L10;
        this.c = r2;
        if (r2 >= 0.1f) goto L7;
        this.a.setAlpha(1.0f);
    L8:
        FrameLayout r3 = this.b;
        float r0 = this.c;
        r3.setAlpha(r0 * r0);
        return;
    L7:
        this.a.setAlpha(0.0f);
        goto L8
    }

    public ECStoreShellTopTipsView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout.inflate(r2, 2131560972, this);
        this.a = (FrameLayout) findViewById(2131371138);
        this.b = (FrameLayout) findViewById(2131371134);
        TextView r5 = (TextView) findViewById(2131371140);
        TextView r6 = (TextView) findViewById(2131371136);
    }

    public /* synthetic */ ECStoreShellTopTipsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
