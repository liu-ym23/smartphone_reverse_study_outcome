package com.story.ai.biz.comment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.comments.impl.databinding.LarusCommentListItemLikeLayoutBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.r5;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ2\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\rJ\u001a\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bH\u0002J\u001a\u0010\u001d\u001a\u00020\u001e2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/story/ai/biz/comment/view/CommentLikeView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/comments/impl/databinding/LarusCommentListItemLikeLayoutBinding;", "lastLikeState", "", "Ljava/lang/Boolean;", "lastCommentId", "", "useImmerse", "setLikeState", "commentId", "likeNum", "", "isLike", "withAnimation", "showLikeAnim", "", "animFinishCallback", "Lkotlin/Function0;", "showUnLikeAnim", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentLikeView extends RelativeLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f459948d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommentListItemLikeLayoutBinding f459949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f459950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f459951c;

    public CommentLikeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentLikeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public CommentLikeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_comment_list_item_like_layout, this);
        int r103 = R.id.img_like_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.img_like_icon);
        if (r104 == null) goto L9;
        r103 = R.id.tv_like_size;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_like_size);
        if (r105 == null) goto L9;
        this.f459949a = new LarusCommentListItemLikeLayoutBinding(this, r104, r105);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ CommentLikeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.story.ai.biz.comment.view.z] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean a(String r210, long r211, boolean r212, boolean r213, boolean r214) {
        FLogger r100 = FLogger.f375446a;
        r100.d("CommentLikeView", "likeNum: " + r211 + ", isLike: " + r212 + ", withAnimation: " + r214);
        if (r211 <= 0) goto L14;
        LarusCommentListItemLikeLayoutBinding r110 = this.f459949a;
        if (r110 == null) goto L9;
        TextView r111 = r110.f325661c;
        if (r111 == null) goto L9;
        r111.setVisibility(0);
    L9:
        LarusCommentListItemLikeLayoutBinding r112 = this.f459949a;
        if (r112 == null) goto L19;
        TextView r113 = r112.f325661c;
        if (r113 == null) goto L19;
        int r114 = r5.f552608a;
        r113.setText(r5.a(getContext(), r211));
    L19:
        LarusCommentListItemLikeLayoutBinding r101 = this.f459949a;
        if (r101 == null) goto L28;
        TextView r102 = r101.f325661c;
        if (r102 == null) goto L28;
        if (r212 == false) goto L26;
        TypedArray r115 = getContext().obtainStyledAttributes(android.R.style.Theme, new int[]{R.attr.danger_50});
    L27:
        int r116 = r115.getColor(0, 0);
        r115.recycle();
        r102.setTextColor(r116);
        goto L28
    L26:
        r115 = getContext().obtainStyledAttributes(android.R.style.Theme, new int[]{R.attr.neutral_70});
    L28:
        String r103 = this.f459951c;
        if (r103 != null) goto L31;
    L37:
        this.f459951c = r210;
        this.f459950b = Boolean.valueOf(r212);
        LarusCommentListItemLikeLayoutBinding r104 = this.f459949a;
        if (r104 == null) goto L47;
        AppCompatImageView r105 = r104.f325660b;
        if (r105 == null) goto L47;
        if (r212 == false) goto L43;
        int r106 = R.drawable.larus_comment_like_hart_red;
    L46:
        r105.setImageResource(r106);
        goto L47
    L43:
        if (r213 == false) goto L45;
        r106 = R.drawable.larus_comment_like_hart_disable_dark;
        goto L46
    L45:
        r106 = R.drawable.larus_comment_like_hart_disable;
    L47:
        if (r214 == false) goto L58;
        if (r212 == false) goto L55;
        r100.d("CommentLikeView", "showLikeAnim");
        LarusCommentListItemLikeLayoutBinding r107 = this.f459949a;
        if (r107 == null) goto L59;
        AppCompatImageView r108 = r107.f325660b;
        if (r108 == null) goto L61;
        final Function0 r109 = null;
        ?? r117 = new z(r109);
        AnimationSet r118 = new AnimationSet(false);
        ScaleAnimation r119 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        r119.setDuration(250);
        r119.setStartOffset(0);
        r119.setInterpolator(new DecelerateInterpolator());
        r119.setFillAfter(true);
        ScaleAnimation r120 = new ScaleAnimation(1.0f, 0.8333f, 1.0f, 0.8333f, 1, 0.5f, 1, 0.5f);
        r120.setDuration(100);
        r120.setStartOffset(250);
        r120.setInterpolator(new DecelerateInterpolator());
        r120.setFillAfter(true);
        r118.setFillAfter(true);
        r118.addAnimation(r119);
        r118.addAnimation(r120);
        r118.setAnimationListener(new a0(r117));
        r108.startAnimation(r118);
        return true;
    L61:
        return true;
    L59:
        return true;
    L55:
        r100.d("CommentLikeView", "showUnLikeAnim");
        return true;
    L58:
        return true;
    L31:
        if (Intrinsics.areEqual(r103, r210) == false) goto L37;
        Boolean r121 = this.f459950b;
        if (r121 == null) goto L37;
        if (Intrinsics.areEqual(r121, Boolean.valueOf(r212)) == false) goto L37;
        return false;
    L14:
        LarusCommentListItemLikeLayoutBinding r122 = this.f459949a;
        if (r122 == null) goto L19;
        TextView r123 = r122.f325661c;
        if (r123 == null) goto L19;
        r123.setVisibility(8);
        goto L19
    }
}
