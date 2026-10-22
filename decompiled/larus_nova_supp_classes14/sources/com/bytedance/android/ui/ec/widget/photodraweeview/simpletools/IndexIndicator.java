package com.bytedance.android.ui.ec.widget.photodraweeview.simpletools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.apm.constant.UploadTypeInf;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u00162\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0006\u0010\"\u001a\u00020\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/simpletools/IndexIndicator;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IIndicatorView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "STR_NUM_FORMAT", "", "value", UploadTypeInf.COUNT, "getCount", "()I", "setCount", "(I)V", "currentPos", "getCurrentPos", "setCurrentPos", "onAttach", "", "position", "adapter", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionPagerAdapter;", "onDataChanged", "onPageSelected", "onTransitionBegin", "state", "onTransitionChanged", "factor", "", "onTransitionEnd", "updateUI", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IndexIndicator extends AppCompatTextView implements IIndicatorView {
    private final String STR_NUM_FORMAT;
    private int count;
    private int currentPos;

    public IndexIndicator(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public IndexIndicator(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionChanged(int r1, float r2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateUI() {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        setText(String.format(Locale.getDefault(), this.STR_NUM_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(this.currentPos + 1), Integer.valueOf(this.count)}, 2)));
    }

    public final int getCount() {
        return this.count;
    }

    public final int getCurrentPos() {
        return this.currentPos;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onDataChanged(TransitionPagerAdapter<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        setCount(r2.getItemCount());
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onPageSelected(int r1) {
        setCurrentPos(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionBegin(int r2) {
        if (r2 != 0) goto L4;
    L5:
        ExtensionsKt.gone(this);
        return;
    L4:
        if (r2 == 3) goto L5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public void onTransitionEnd(int r2) {
        if (r2 != 0) goto L4;
    L5:
        ExtensionsKt.visible(this);
        return;
    L4:
        if (r2 == 1) goto L5;
    }

    public final void setCount(int r1) {
        this.count = r1;
        updateUI();
    }

    public final void setCurrentPos(int r1) {
        this.currentPos = r1;
        updateUI();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onAttach(int r2, TransitionPagerAdapter<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        setCurrentPos(r2);
        setCount(r3.getItemCount());
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView
    public void onDetach(int r2, TransitionPagerAdapter<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        IIndicatorView.DefaultImpls.onDetach(this, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IndexIndicator(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.STR_NUM_FORMAT = "%s/%s";
        setTextSize(14.0f);
        setTextColor(-1);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        setPadding(ExtensionsKt.getDp(5), 0, ExtensionsKt.getDp(5), 0);
        r5.bottomMargin = ExtensionsKt.getDp(16);
        r5.rightMargin = ExtensionsKt.getDp(16);
        r5.gravity = 8388693;
        Unit r6 = Unit.INSTANCE;
        setLayoutParams(r5);
    }

    public /* synthetic */ IndexIndicator(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
