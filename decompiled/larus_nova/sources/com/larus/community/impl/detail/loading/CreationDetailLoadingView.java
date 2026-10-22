package com.larus.community.impl.detail.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailLoadingLayoutBinding;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/community/impl/detail/loading/CreationDetailLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailLoadingLayoutBinding;", DyPayConstant.KEY_SHOW_LOADING, "", "showError", "hide", "bindAction", "retryAction", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailLoadingView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f329362b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCreationDetailLoadingLayoutBinding f329363a;

    public CreationDetailLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public CreationDetailLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_creation_detail_loading_layout, this);
        int r102 = R.id.load_more_error_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.load_more_error_icon)) == null) goto L13;
        r102 = R.id.load_more_error_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(this, R.id.load_more_error_text)) == null) goto L13;
        r102 = R.id.loading_error_layout;
        ConstraintLayout r103 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.loading_error_layout);
        if (r103 == null) goto L13;
        r102 = R.id.loading_icon;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_icon);
        if (r104 == null) goto L13;
        this.f329363a = new LarusCommunityCreationDetailLoadingLayoutBinding(this, r103, r104);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
