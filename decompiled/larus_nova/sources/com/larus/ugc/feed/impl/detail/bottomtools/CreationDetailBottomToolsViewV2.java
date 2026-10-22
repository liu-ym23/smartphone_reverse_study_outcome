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
import com.larus.ugc.feed.impl.databinding.LarusCreationDetailBottomToolsLayoutV2KmpBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/ugc/feed/impl/databinding/LarusCreationDetailBottomToolsLayoutV2KmpBinding;", "bindAction", "", "likeAction", "Lkotlin/Function0;", "makeSameAction", "Lkotlin/Function1;", "", "commentAction", "setMakeSameContent", "isCustomContent", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "ignoreDynamicInfo", "bindCreationLikeState", "state", "Lcom/larus/ugc/feed/api/detail/state/CreationDetailBottomToolsUiState;", "updateCommentCount", "commentCount", "", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsViewV2 extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f374766b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCreationDetailBottomToolsLayoutV2KmpBinding f374767a;

    public CreationDetailBottomToolsViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public CreationDetailBottomToolsViewV2(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.larus_creation_detail_bottom_tools_layout_v2_kmp, this);
        int r112 = R.id.comment_container;
        ConstraintLayout r100 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.comment_container);
        if (r100 == null) goto L23;
        r112 = R.id.creation_make_same_container;
        RoundConstraintLayout r101 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.creation_make_same_container);
        if (r101 == null) goto L23;
        r112 = R.id.ic_comment_img;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_comment_img)) == null) goto L23;
        r112 = R.id.ic_like_img;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_like_img);
        if (r102 == null) goto L23;
        r112 = R.id.ic_make_same_img;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_make_same_img);
        if (r103 == null) goto L23;
        r112 = R.id.like_container;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.like_container);
        if (r104 == null) goto L23;
        r112 = R.id.tv_comment_count;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.tv_comment_count)) == null) goto L23;
        r112 = R.id.tv_like_count;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_like_count);
        if (r105 == null) goto L23;
        r112 = R.id.tv_make_same_tips;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_make_same_tips);
        if (r106 == null) goto L23;
        this.f374767a = new LarusCreationDetailBottomToolsLayoutV2KmpBinding(this, r100, r101, r102, r103, r104, r105, r106);
        setClickable(true);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }
}
