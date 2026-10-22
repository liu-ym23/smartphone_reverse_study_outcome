package com.larus.community.impl.detail.bottomtools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailBottomToolsLayoutBinding;
import com.larus.nova.R;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.r5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0003\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0014J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailBottomToolsLayoutBinding;", "bindAction", "", "likeAction", "Lkotlin/Function0;", "makeSameAction", "Lkotlin/Function1;", "", "shareAction", "setShareActionVisible", "visible", "", "iconRes", "", "setMakeSameActionVisible", "setMakeSameContent", "isCustomContent", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "ignoreDynamicInfo", "bindCreationLikeState", "likeState", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f329216b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCreationDetailBottomToolsLayoutBinding f329217a;

    public CreationDetailBottomToolsView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

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
    public final void S5(CreationLikeState r110) {
        Intrinsics.checkNotNullParameter(r110, "likeState");
        Animation r100 = this.f329217a.f329027e.getAnimation();
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f329217a.f329027e.setAnimation(null);
        TextView r101 = this.f329217a.f329030h;
        if (((int) r110.getLikeCount()) != 0) goto L8;
        String r102 = getContext().getString(R.string.larus_creation_detail_btn_like);
    L9:
        r101.setText(r102);
        AppCompatImageView r103 = this.f329217a.f329027e;
        if (r110.getLiked() == false) goto L12;
        int r104 = R.drawable.larus_community_ic_like_hart;
    L13:
        r103.setImageResource(r104);
        if (r110.getLiked() == true) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r110.getShowAnimation(), Boolean.TRUE) == false) goto L20;
        AppCompatImageView r105 = this.f329217a.f329027e;
        AnimationSet r106 = new AnimationSet(false);
        ScaleAnimation r107 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        r107.setDuration(250);
        r107.setStartOffset(0);
        r107.setInterpolator(new DecelerateInterpolator());
        r107.setFillAfter(true);
        ScaleAnimation r111 = new ScaleAnimation(1.0f, 0.8333f, 1.0f, 0.8333f, 1, 0.5f, 1, 0.5f);
        r111.setDuration(100);
        r111.setStartOffset(250);
        r111.setInterpolator(new DecelerateInterpolator());
        r111.setFillAfter(true);
        r106.setFillAfter(true);
        r106.addAnimation(r107);
        r106.addAnimation(r111);
        r106.setAnimationListener(new s());
        r105.startAnimation(r106);
        return;
    L20:
        return;
    L12:
        r104 = R.drawable.larus_ic_like_hart_cancel;
        goto L13
    L8:
        int r108 = r5.f552608a;
        r102 = r5.a(getContext(), r110.getLikeCount());
        goto L9
    }

    public final void setMakeSameActionVisible(boolean r100) {
        RoundConstraintLayout r101 = this.f329217a.f329025c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public CreationDetailBottomToolsView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.larus_community_creation_detail_bottom_tools_layout, this);
        int r112 = R.id.creation_like_container;
        RoundConstraintLayout r100 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.creation_like_container);
        if (r100 == null) goto L21;
        r112 = R.id.creation_make_same_container;
        RoundConstraintLayout r101 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.creation_make_same_container);
        if (r101 == null) goto L21;
        r112 = R.id.creation_share_container;
        RoundConstraintLayout r102 = (RoundConstraintLayout) ViewBindings.findChildViewById(this, R.id.creation_share_container);
        if (r102 == null) goto L21;
        r112 = R.id.ic_like_img;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_like_img);
        if (r103 == null) goto L21;
        r112 = R.id.ic_make_same_img;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_make_same_img);
        if (r104 == null) goto L21;
        r112 = R.id.ic_share_img;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ic_share_img);
        if (r105 == null) goto L21;
        r112 = R.id.tv_like_count;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_like_count);
        if (r106 == null) goto L21;
        r112 = R.id.tv_make_same_tips;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_make_same_tips);
        if (r107 == null) goto L21;
        this.f329217a = new LarusCommunityCreationDetailBottomToolsLayoutBinding(this, r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }

    public final void R5(final Function0<Unit> r100, final Function1<? super String, Unit> r101, final Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "likeAction");
        Intrinsics.checkNotNullParameter(r101, "makeSameAction");
        e1.d(this.f329217a.f329024b, new p(r100));
        e1.d(this.f329217a.f329026d, new q(r102));
        e1.d(this.f329217a.f329025c, new r(r101));
    }

    public final void T5(boolean r100, UserCreation r101, boolean r102) {
        if (r100 == false) goto L4;
        this.f329217a.f329031i.setText(R.string.larus_creation_tag_customize);
        this.f329217a.f329028f.setImageResource(R.drawable.larus_square_pencil_ai);
        return;
    L4:
        String r103 = null;
        if (r102 == true) goto L20;
        if (r101 == null) goto L10;
        CreationDynamicInfo r104 = r101.f364994h;
        if (r104 == null) goto L10;
        String r105 = r104.f364913c;
    L12:
        if (o0.d(r105) == false) goto L20;
        TextView r106 = this.f329217a.f329031i;
        if (r101 == null) goto L18;
        CreationDynamicInfo r107 = r101.f364994h;
        if (r107 == null) goto L18;
        String r108 = r107.f364913c;
    L19:
        r106.setText(r108);
    L21:
        if (r101 == null) goto L28;
        CreationDynamicInfo r109 = r101.f364994h;
        if (r109 == null) goto L28;
        TplInfo r110 = r109.f364915e;
        if (r110 == null) goto L28;
        r103 = r110.f364972a;
    L28:
        if (Intrinsics.areEqual(r103, TplType.AI_REPLICA) == false) goto L30;
        int r111 = R.drawable.larus_ic_use_replica_template;
    L31:
        this.f329217a.f329028f.setImageResource(r111);
        return;
    L30:
        r111 = R.drawable.larus_community_ic_use_template;
    L18:
        r108 = null;
    L10:
        r105 = null;
    L20:
        this.f329217a.f329031i.setText(R.string.larus_discoverTab_showcaseScreen_btn_try);
        goto L21
    }
}
