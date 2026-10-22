package com.larus.ugc.feed.impl.detail.bottomtools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.nova.R;
import com.larus.ugc.feed.impl.databinding.LarusCreationDetailBottomToolsLayoutKmpBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000fJ\"\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/ugc/feed/impl/databinding/LarusCreationDetailBottomToolsLayoutKmpBinding;", "bindAction", "", "likeAction", "Lkotlin/Function0;", "makeSameAction", "Lkotlin/Function1;", "", "setMakeSameContent", "isCustomContent", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "ignoreDynamicInfo", "bindCreationLikeState", "state", "Lcom/larus/ugc/feed/api/detail/state/CreationDetailBottomToolsUiState;", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f374764b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCreationDetailBottomToolsLayoutKmpBinding f374765a;

    public CreationDetailBottomToolsView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public CreationDetailBottomToolsView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110);
        LayoutInflater.from(r100).inflate(R.layout.larus_creation_detail_bottom_tools_layout_kmp, this);
        int r101 = R.id.creation_like_container;
        RoundConstraintLayout r102 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.creation_like_container);
        if (r102 == null) goto L17;
        r101 = R.id.creation_make_same_container;
        RoundConstraintLayout r103 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.creation_make_same_container);
        if (r103 == null) goto L17;
        r101 = R.id.ic_like_img;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_like_img);
        if (r104 == null) goto L17;
        r101 = R.id.ic_make_same_img;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_make_same_img);
        if (r105 == null) goto L17;
        r101 = R.id.tv_like_count;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_like_count);
        if (r106 == null) goto L17;
        r101 = R.id.tv_make_same_tips;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_make_same_tips);
        if (r107 == null) goto L17;
        this.f374765a = new LarusCreationDetailBottomToolsLayoutKmpBinding(this, r102, r103, r104, r105, r106, r107);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
    }
}
