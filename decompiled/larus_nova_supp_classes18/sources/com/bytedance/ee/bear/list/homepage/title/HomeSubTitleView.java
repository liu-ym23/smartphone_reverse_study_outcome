package com.bytedance.ee.bear.list.homepage.title;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import bd5.g;
import bd5.h;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.ui.l;
import h18.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wc5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0012\u0010(\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\u0006\u0010*\u001a\u00020\u001bJ\u000e\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001bJ\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u00020\u001e2\b\b\u0001\u00103\u001a\u00020\bJ\u000e\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\bJ\u0012\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/list/homepage/title/HomeSubTitleView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mDelegate", "Lcom/bytedance/ee/bear/list/homepage/IHomeSubMenuView$ViewDelegate;", "mTitle", "", "mTvTitle", "Landroid/widget/TextView;", "mIvFilter", "Landroidx/appcompat/widget/AppCompatImageView;", "mIvSwitch", "mFilterState", "Lcom/bytedance/ee/bear/list/homepage/title/SubMenuView$FilterState;", "mIsShowGrid", "", "mOffline", "initView", "", "showFilterDesc", "desc", "showGrid", "isGrid", "setOffline", OperationName.OPERATION_OFFLINE_AVAILABLE, "hideGrid", "setFilterState", "filterState", "showSortDesc", "hideFilter", "isFilterVisible", "setFilterVisible", "visible", "setTitle", "text", "setTextSize", "textSize", "", "setTextColor", "color", "setTextStyle", "style", "setViewDelegate", "viewDelegate", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HomeSubTitleView extends LinearLayout implements f {
    public Context a;
    public f.a b;
    public String c;
    public TextView d;
    public AppCompatImageView e;
    public AppCompatImageView f;
    public SubMenuView.FilterState g;
    public boolean h;
    public boolean i;

    public HomeSubTitleView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "mContext");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HomeSubTitleView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        this(r3, r4, 4, 0);
    }

    @Override // wc5.f
    public final void a(String r1) {
    }

    public final Context getMContext() {
        return this.a;
    }

    @Override // wc5.f
    public final void b(boolean r2) {
        this.h = r2;
        AppCompatImageView r3 = this.f;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r3 = null;
    L6:
        if (this.h == false) goto L8;
        int r0 = 2131254229;
    L9:
        r3.setImageResource(r0);
        return;
    L8:
        r0 = 2131253870;
        goto L9
    }

    @Override // wc5.f
    public void setFilterState(SubMenuView.FilterState r6) {
        Intrinsics.checkNotNullParameter(r6, "filterState");
        this.g = r6;
        int r1 = 2131102416;
        ImageView r3 = null;
        if (r6 != SubMenuView.FilterState.DEFAULT) goto L13;
        if (this.i == true) goto L8;
        r1 = 2131102419;
    L8:
        AppCompatImageView r7 = this.e;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r7 = null;
    L11:
        r7.setBackgroundDrawable(null);
    L27:
        ImageView r8 = this.e;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
    L31:
        l.c(r3, r1);
        return;
    L30:
        r3 = r8;
        goto L31
    L13:
        if (this.i == true) goto L16;
        r1 = 2131106273;
    L16:
        AppCompatImageView r9 = this.e;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r9 = null;
    L19:
        r9.setBackgroundDrawable(getResources().getDrawable(2131243704));
        if (this.i == false) goto L22;
        int r10 = 2131106270;
    L23:
        View r0 = this.e;
        if (r0 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r0 = null;
    L26:
        l.b(r0, r10);
        goto L27
    L22:
        r10 = 2131106271;
        goto L23
    }

    public final void setFilterVisible(boolean r2) {
        ImageView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    public final void setMContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // wc5.f
    public void setOffline(boolean r1) {
        this.i = r1;
        setFilterState(this.g);
    }

    public final void setTextColor(int r3) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r0 = null;
    L5:
        r0.setTextColor(getResources().getColor(r3));
    }

    public final void setTextSize(float r2) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r0 = null;
    L5:
        r0.setTextSize(r2);
    }

    public final void setTextStyle(int r3) {
        int r0 = e.a;
        Typeface r1 = e.a(this.a);
        TextView r2 = this.d;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r2 = null;
    L5:
        r2.setTypeface(r1, r3);
    }

    @Override // wc5.f
    public void setTitle(String r2) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r1) {
        this.b = r1;
    }

    public HomeSubTitleView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "mContext");
        super(r4, r5, r6);
        this.a = r4;
        this.g = SubMenuView.FilterState.DEFAULT;
        if (r5 == null) goto L8;
        TypedArray r7 = getContext().obtainStyledAttributes(r5, new int[]{2130974574});
        String r8 = r7.getString(0);
        if (r8 != null) goto L7;
        r8 = getResources().getString(2131887928);
    L7:
        this.c = r8;
        r7.recycle();
    L8:
        View r9 = LayoutInflater.from(this.a).inflate(2131563502, this, true);
        l.b(this, 2131100548);
        TextView r10 = (TextView) r9.findViewById(2131391606);
        this.d = r10;
        ImageView r11 = null;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
        r10 = null;
    L11:
        String r0 = this.c;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mTitle");
        r0 = null;
    L14:
        r10.setText(r0);
        this.e = r9.findViewById(2131376241);
        AppCompatImageView r12 = r9.findViewById(2131376649);
        this.f = r12;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r12 = null;
    L18:
        if (this.h == false) goto L20;
        int r1 = 2131254229;
    L21:
        r12.setImageResource(r1);
        ImageView r13 = this.f;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r13 = null;
    L24:
        l.c(r13, 2131102419);
        ImageView r14 = this.e;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r14 = null;
    L27:
        r14.setOnClickListener(new g(this));
        ImageView r15 = this.f;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
    L31:
        r11.setOnClickListener(new h(this));
        return;
    L30:
        r11 = r15;
        goto L31
    L20:
        r1 = 2131253870;
        goto L21
    }

    public /* synthetic */ HomeSubTitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
