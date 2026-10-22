package com.bytedance.android.shopping.inflow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import te3.a;
import te3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/inflow/widget/AnchorV3SearchEditView;", "Landroid/widget/FrameLayout;", "", "getLayoutId", "Lne3/a;", "searchInfo", "Lne3/a;", "getSearchInfo", "()Lne3/a;", "setSearchInfo", "(Lne3/a;)V", "Lte3/b;", "searchParams", "Lte3/b;", "getSearchParams", "()Lte3/b;", "setSearchParams", "(Lte3/b;)V", "Lte3/a;", "logAction", "Lte3/a;", "getLogAction", "()Lte3/a;", "setLogAction", "(Lte3/a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorV3SearchEditView extends FrameLayout {
    public AnchorV3SearchEditView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV3SearchEditView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public int getLayoutId() {
        return 2131560654;
    }

    public final a getLogAction() {
        return null;
    }

    public final ne3.a getSearchInfo() {
        return null;
    }

    public final b getSearchParams() {
        return null;
    }

    public final void setLogAction(a r1) {
    }

    public final void setSearchInfo(ne3.a r1) {
    }

    public final void setSearchParams(b r1) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        TextView r0 = (TextView) findViewById(2131362738);
    }

    public AnchorV3SearchEditView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ AnchorV3SearchEditView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
