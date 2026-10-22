package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailImageIndicator;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "Lkotlin/Function0;", "", "closeListener", "setCloseListener", "", "isVisible", "setIndexVisible", "", "value", "e", "I", "getCount", "()I", "setCount", "(I)V", "count", "f", "getCurrentPos", "setCurrentPos", "currentPos", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailImageIndicator extends ConstraintLayout implements IIndicatorView {
    public final TextView a;
    public Function0<Unit> b;
    public boolean c;
    public final String d;
    public int e;
    public int f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AnchorV4DetailImageIndicator a;

        public a(AnchorV4DetailImageIndicator r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.b;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public AnchorV4DetailImageIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4DetailImageIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onDataChanged(TransitionPagerAdapter<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
    }

    public final void onTransitionChanged(int r1, float r2) {
    }

    public final void R5() {
        TextView r0 = this.a;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        r0.setText(String.format(Locale.getDefault(), this.d, Arrays.copyOf(new Object[]{Integer.valueOf(this.f + 1), Integer.valueOf(this.e)}, 2)));
    }

    public final int getCount() {
        return this.e;
    }

    public final int getCurrentPos() {
        return this.f;
    }

    public final void onPageSelected(int r1) {
        setCurrentPos(r1);
    }

    public final void onTransitionBegin(int r2) {
        if (r2 != 0) goto L4;
    L5:
        this.a.setVisibility(8);
        return;
    L4:
        if (r2 == 3) goto L5;
    }

    public final void onTransitionEnd(int r2) {
        if (r2 == 0) goto L6;
        if (r2 == 1) goto L6;
        return;
    L6:
        if (this.c == false) goto L10;
        this.a.setVisibility(0);
        return;
    }

    public final void setCloseListener(Function0<Unit> r1) {
        this.b = r1;
    }

    public final void setCount(int r1) {
        this.e = r1;
        R5();
    }

    public final void setCurrentPos(int r1) {
        this.f = r1;
        R5();
    }

    public final void setIndexVisible(boolean r3) {
        if (r3 == false) goto L4;
        this.a.setVisibility(0);
    L5:
        this.c = r3;
        return;
    L4:
        this.a.setVisibility(8);
        goto L5
    }

    public final void onAttach(int r2, TransitionPagerAdapter<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        IIndicatorView.DefaultImpls.onAttach(this, r2, r3);
    }

    public final void onDetach(int r2, TransitionPagerAdapter<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4DetailImageIndicator(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = "%s/%s";
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131564711, this, true);
        ImageView r5 = (ImageView) findViewById(2131376107);
        this.a = (TextView) findViewById(2131390775);
        r5.setOnClickListener(new a(this));
    }

    public /* synthetic */ AnchorV4DetailImageIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
