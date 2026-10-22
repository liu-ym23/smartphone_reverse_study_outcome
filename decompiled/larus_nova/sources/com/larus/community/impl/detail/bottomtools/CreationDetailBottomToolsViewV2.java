package com.larus.community.impl.detail.bottomtools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailBottomToolsLayoutV2Binding;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.r5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007JN\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailBottomToolsLayoutV2Binding;", "bindAction", "", "likeAction", "Lkotlin/Function0;", "makeSameAction", "Lkotlin/Function1;", "", "shareAction", "commentAction", "setShareActionVisible", "visible", "", "iconRes", "", "setMakeSameActionVisible", "setMakeSameContent", "isCustomContent", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "ignoreDynamicInfo", "bindCreationLikeState", "likeState", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "updateCommentCount", "commentCount", "", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsViewV2 extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f329218b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCreationDetailBottomToolsLayoutV2Binding f329219a;

    public CreationDetailBottomToolsViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void R5(long r100) {
        TextView r101 = this.f329219a.f329040i;
        if (r100 > 0) goto L5;
        String r102 = getResources().getString(R.string.larus_botsComment_comment_title);
    L6:
        r101.setText(r102);
        ConstraintLayout r103 = this.f329219a.f329033b;
        if (r100 > 0) goto L9;
        int r104 = j0.f375426a;
        String r105 = j0.d(R.string.larus_accessibility_creationFeed_comment);
    L10:
        r103.setContentDescription(r105);
        return;
    L9:
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        int r107 = j0.f375426a;
        r105 = String.format(j0.d(R.string.larus_accessibility_creationFeedDetail_commentCounts), Arrays.copyOf(new Object[]{Long.valueOf(r100)}, 1));
        goto L10
    L5:
        int r108 = r5.f552608a;
        r102 = r5.a(getContext(), r100);
        goto L6
    }

    public final void setMakeSameActionVisible(boolean r100) {
        RoundConstraintLayout r101 = this.f329219a.f329034c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public CreationDetailBottomToolsViewV2(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.larus_community_creation_detail_bottom_tools_layout_v2, this);
        int r112 = R.id.comment_container;
        ConstraintLayout r100 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.comment_container);
        if (r100 == null) goto L27;
        r112 = R.id.creation_make_same_container;
        RoundConstraintLayout r101 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.creation_make_same_container);
        if (r101 == null) goto L27;
        r112 = R.id.ic_comment_img;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_comment_img)) == null) goto L27;
        r112 = R.id.ic_like_img;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_like_img);
        if (r102 == null) goto L27;
        r112 = R.id.ic_make_same_img;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_make_same_img);
        if (r103 == null) goto L27;
        r112 = R.id.ic_share_img;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_share_img);
        if (r104 == null) goto L27;
        r112 = R.id.like_container;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.like_container);
        if (r105 == null) goto L27;
        r112 = R.id.share_container;
        RoundConstraintLayout r106 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.share_container);
        if (r106 == null) goto L27;
        r112 = R.id.tv_comment_count;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_comment_count);
        if (r107 == null) goto L27;
        r112 = R.id.tv_like_count;
        TextView r113 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_like_count);
        if (r113 == null) goto L27;
        r112 = R.id.tv_make_same_tips;
        TextView r114 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_make_same_tips);
        if (r114 == null) goto L27;
        this.f329219a = new LarusCommunityCreationDetailBottomToolsLayoutV2Binding(this, r100, r101, r102, r103, r104, r105, r106, r107, r113, r114);
        setClickable(true);
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }
}
