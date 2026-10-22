package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import j4c.l;
import j4c.s;
import j4c.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tJ\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J)\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0096\u0001J\u0011\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0096\u0001J\u0011\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0096\u0001J\u0011\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0096\u0001J\u0011\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-H\u0096\u0001J\u0019\u0010.\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0016H\u0096\u0001J\u0011\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u000202H\u0096\u0001J\u0011\u00103\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\u0013\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u000106H\u0096\u0001J\t\u00107\u001a\u00020\u001aH\u0096\u0001J\u0019\u00108\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tH\u0096\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u00109\u001a\u00020:X\u0096\u000f¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006?"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/DefaultLeftComponentView;", "Landroid/widget/RelativeLayout;", "Lcom/ss/android/lark/search/ui/result/view/ILeftViewDelegateDependency;", "Lcom/ss/android/lark/search/ui/result/view/ILeftViewDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "viewDelegate", "Lcom/ss/android/lark/search/ui/result/view/LeftViewDelegate;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/ss/android/lark/search/ui/result/view/LeftViewDelegate;)V", "getViewDelegate", "()Lcom/ss/android/lark/search/ui/result/view/LeftViewDelegate;", "applyStyle", "style", "mContext", "getMContext", "()Landroid/content/Context;", "avatarContainer", "Landroid/view/ViewGroup;", "getAvatarContainer", "()Landroid/view/ViewGroup;", "avatar", "", "avatarModel", "Lcom/larksuite/component/ui/avatar/AvatarModel;", "avatarPadding", "left", "top", "right", "bottom", "avatarScaleType", "scaleTYpe", "Landroid/widget/ImageView$ScaleType;", "avatarShape", "isOval", "", "avatarSizeAdjust", "size", "", IAllianceService.CONTENT_TYPE_BADGE, "badgeModel", "Lcom/larksuite/component/ui/badge/BadgeModel;", "bindAvatar", "parent", "medal", "medalModel", "Lcom/ss/android/lark/chat/entity/chatter/AvatarMedal;", "miniAvatar", "miniIcon", "miniIconModel", "Lcom/larksuite/component/ui/badge/miniicon/MiniIconModel;", "resetAllViews", "setStyle", "bindAvatarView", "Lcom/ss/android/lark/search/ui/result/view/IBindAvatarView;", "getBindAvatarView", "()Lcom/ss/android/lark/search/ui/result/view/IBindAvatarView;", "setBindAvatarView", "(Lcom/ss/android/lark/search/ui/result/view/IBindAvatarView;)V", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultLeftComponentView extends RelativeLayout implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f440333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f440334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DefaultLeftComponentView f440335c;

    public DefaultLeftComponentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DefaultLeftComponentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DefaultLeftComponentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public l getBindAvatarView() {
        return this.f440333a.f497423b;
    }

    @Override // j4c.s
    public ViewGroup getAvatarContainer() {
        return this.f440335c;
    }

    @Override // j4c.s
    public Context getMContext() {
        return this.f440334b;
    }

    public final w getViewDelegate() {
        return this.f440333a;
    }

    public void setBindAvatarView(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        w r101 = this.f440333a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        r101.f497423b = r100;
        s r102 = r101.f497422a;
        if (r102 == null) goto L8;
        ViewGroup r103 = r102.getAvatarContainer();
        if (r103 == null) goto L9;
        r100.a(r102.getMContext(), r103);
        return;
    L9:
        return;
    }

    public DefaultLeftComponentView(Context r100, AttributeSet r101, int r102, int r103) {
        w r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r104 = new w();
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "viewDelegate");
        super(r100, r101, r102);
        this.f440333a = r104;
        r104.f497422a = this;
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "parent");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "parent");
        r104.f497423b.a(r100, this);
        if (r101 == null) goto L14;
        int r105 = r101.getStyleAttribute();
        Context r106 = getContext();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        r104.f497423b.b(r106, r105);
    L14:
        this.f440334b = r100;
        this.f440335c = this;
    }
}
