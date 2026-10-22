package com.ss.android.lark.feed.cardcomponent.avatar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.imageview.LKUIBadgeView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.feed.app.view.AdvanceAvatarView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&J<\u0010(\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010.\u001a\u00020-J\u001a\u0010/\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010&J\f\u00103\u001a\u00020\u0005*\u000204H\u0002J\f\u00103\u001a\u00020\u0005*\u00020\u0005H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/avatar/FeedCardAvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "avatarSize", "", "<init>", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "urgentBackground", "Landroid/view/View;", "avatarView", "Lcom/ss/android/lark/feed/app/view/AdvanceAvatarView;", "decorateAvatarView", "Lcom/larksuite/component/decoration/avatar/DecoratedAvatar;", "badgeView", "Lcom/larksuite/component/ui/imageview/LKUIBadgeView;", "miniIconView", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "miniAvatarView", "decorationViewIndex", "init", "", "createUrgentBackgroundView", "createDecorateAvatarView", "bindDecorateAvatarView", "imageKey", "", "createBadgeView", "bindBadgeView", "remindUIInfo", "Lcom/ss/android/lark/feed/app/viewentity/RemindUIInfo;", "createThreadIconView", "createThreadMiniAvatarView", "bindThreadMiniAvatarView", "avatarModel", "Lcom/larksuite/component/ui/avatar/AvatarModel;", "bindAvatarView", "bindAvatar", "miniAvatarModel", "Lcom/larksuite/component/ui/badge/miniicon/MiniIconModel;", "decorateImageKey", "isUrgent", "", "isShowBadge", "bindMiniIcon", "miniIconDrawable", "Landroid/graphics/drawable/Drawable;", "miniIconModel", "dp2px", "", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCardAvatarView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<Boolean> f420846i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f420847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdvanceAvatarView f420848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DecoratedAvatar f420849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LKUIBadgeView f420850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LKUIRoundedImageView2 f420851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AdvanceAvatarView f420852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f420853g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f420854h;

    public static final class a {
    }

    static {
        f420846i = LazyKt.lazy(FeedCardAvatarView$Companion$feedAvatarRollbackEnabled$2.INSTANCE);
    }

    public FeedCardAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f420854h = 48;
        AdvanceAvatarView r103 = new AdvanceAvatarView(r100);
        r103.setId(R.id.open_feed_avatar);
        r103.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(b.g(r100, r102), b.g(r100, r102));
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        r104.leftToLeft = 0;
        r104.setMargins(UIHelper.dp2px(16.0f), 0, 0, 0);
        r103.setLayoutParams(r104);
        this.f420848b = r103;
        this.f420854h = r102;
        this.f420853g++;
        addView(r103);
        View r105 = new View(r100);
        r105.setBackgroundResource(R.drawable.urgent_avatar_bg);
        this.f420847a = r105;
        int r106 = (UIHelper.dp2px(52.0f) + b.g(r100, this.f420854h)) - UIHelper.dp2px(48);
        ConstraintLayout.LayoutParams r107 = new ConstraintLayout.LayoutParams(r106, r106);
        r107.topToTop = 0;
        r107.bottomToBottom = 0;
        r107.leftToLeft = 0;
        r107.setMarginStart(UIHelper.dp2px(14.0f));
        addView(this.f420847a, r107);
        View r108 = this.f420847a;
        if (r108 == null) goto L6;
        r108.setVisibility(8);
        return;
    }
}
