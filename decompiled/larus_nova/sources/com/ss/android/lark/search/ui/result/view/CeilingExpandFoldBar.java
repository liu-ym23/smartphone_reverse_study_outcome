package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/CeilingExpandFoldBar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "view", "Landroid/view/View;", "expandFoldBtnListener", "Lcom/ss/android/lark/search/ui/result/view/CeilingExpandFoldBar$IOnClickExpandFoldBtnListener;", "showDepartmentDetail", "", "tvExpandFold", "Landroid/widget/TextView;", "ivIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "llExpandFold", "Landroid/widget/LinearLayout;", "expandDrawable", "Landroid/graphics/drawable/Drawable;", "foldDrawable", "initView", "", "resetStatus", "setOnClickExpandFoldBtnListener", "listener", "IOnClickExpandFoldBtnListener", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CeilingExpandFoldBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f440324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f440325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f440326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f440327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f440328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f440329f;

    public interface a {
    }

    public CeilingExpandFoldBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CeilingExpandFoldBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnClickExpandFoldBtnListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public CeilingExpandFoldBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f440328e = UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_addnew_outlined, UIHelper.getColor(R.color.icon_n2));
        this.f440329f = UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_no_outlined, UIHelper.getColor(R.color.icon_n2));
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ceiling_expand_fold_bar, this, true);
        this.f440326c = (TextView) r103.findViewById(R.id.tv_expand_fold_department);
        this.f440327d = (AppCompatImageView) r103.findViewById(R.id.iv_icon);
        LinearLayout r104 = (LinearLayout) r103.findViewById(R.id.ll_expand_fold);
        this.f440324a = r103;
        r104.setOnClickListener(new c(this));
    }

    public /* synthetic */ CeilingExpandFoldBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
