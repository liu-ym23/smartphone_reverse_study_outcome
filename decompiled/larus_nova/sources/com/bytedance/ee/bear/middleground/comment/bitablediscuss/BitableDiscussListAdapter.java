package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapterHelper;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001EBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001fH\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020/2\b\b\u0001\u00102\u001a\u00020\u001fH\u0002J\u001c\u00103\u001a\u00020-2\b\b\u0001\u00104\u001a\u00020\u001f2\b\b\u0001\u00105\u001a\u00020\u001fH\u0002J\u001c\u00106\u001a\u00020\u00122\n\u00107\u001a\u000608R\u00020\u00012\u0006\u00109\u001a\u00020&H\u0014J&\u0010:\u001a\u00020\u00122\u0006\u00107\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016J\u0018\u0010:\u001a\u00020\u00122\u0006\u00107\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001fH\u0016J\u0018\u0010?\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00062\u0006\u0010A\u001a\u00020\u001fJ\b\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006F"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussListAdapter;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "userIds", "", "", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "language", "clickLink", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getCommentListeners", "()Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "getActionControl", "()Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "heightLightReplyId", "getHeightLightReplyId", "()Ljava/lang/String;", "setHeightLightReplyId", "(Ljava/lang/String;)V", "heightLightType", "", "bitableFunction", "Lcom/bytedance/ee/bear/middleground/comment/export/bitablecomment/IBitableDiscussFunction;", "getBitableFunction", "()Lcom/bytedance/ee/bear/middleground/comment/export/bitablecomment/IBitableDiscussFunction;", "getCommentVisibility", "commentDetail", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "getReplyGradientDrawableWithFraction", "Landroid/graphics/drawable/Drawable;", "fraction", "", "getColorWithAlpha", "alpha", "baseColor", "getGradientDrawable", "startColor", "endColor", "setBackGround", "holder", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", MapController.ITEM_LAYER_TAG, "onBindViewHolder", "position", "payloads", "", "", "heightLightComment", "replyId", "type", "canReplayComment", "", "replayComment", "BitableDiscussContentViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDiscussListAdapter extends CardAdapter2 {
    private final y actionControl;
    private ye5.a bitableFunction;
    private final z commentListeners;
    private String heightLightReplyId;
    private int heightLightType;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00142\b\b\u0001\u0010%\u001a\u00020\u001fJ\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussListAdapter$BitableDiscussContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "Lcom/bytedance/ee/bear/middleground/comment/extension/addins/BitableDiscussAdapterAddin$IBackgroundAnimalHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussListAdapter;Landroid/view/View;)V", "bitableExtraEntity", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$BitableExtraEntity;", "optPrivate", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "optShare", "contentWrapper", "Landroid/widget/FrameLayout;", "commentId", "", "replyId", "applyData", "", "initView", "forceUpdateLayout", "", "isMainComment", "isPrivate", "setOptPrivate", "setOptShare", "initAvator", "updateLayoutCount", "imageSize", "", "setPadding", "setBackGroundDrawable", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "setBackgroundResource", "resid", "onAnimalUpdate", "fraction", "", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BitableDiscussContentViewHolder extends CardAdapter2.ContentViewHolder implements com.bytedance.ee.bear.middleground.comment.extension.addins.e.a {
        public String A;
        public String B;
        public final /* synthetic */ BitableDiscussListAdapter C;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public CommentBean.CommentDetail.BitableExtraEntity f230676w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final ImageView f230677x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final ImageView f230678y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final FrameLayout f230679z;

        public final boolean Z3() {
            CommentBean.CommentDetail.BitableExtraEntity r100 = this.f230676w;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.isMainComment() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.e.a
        public final void R0(float r100) {
            Drawable r101 = BitableDiscussListAdapter.access$getReplyGradientDrawableWithFraction(this.C, 1 - r100);
            Intrinsics.checkNotNullParameter(r101, "bgDrawable");
            this.f230679z.setBackground(r101);
        }

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2.ContentViewHolder
        public final void X3(int r100) {
            if (Z3() == false) goto L5;
            super.X3(r100);
            return;
        L5:
            RecyclerView.LayoutManager r101 = this.f230152q.getLayoutManager();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            ((GridLayoutManager) r101).setSpanCount(2);
        }

        public final void Y3(boolean r100) {
            ImageView r101 = this.f230678y;
            if (Z3() == false) goto L5;
            int r102 = 0;
        L6:
            r101.setVisibility(r102);
            this.f230678y.setOnClickListener(new d(this, this.C));
            ImageView r103 = this.f230677x;
            CommentBean.CommentDetail.BitableExtraEntity r104 = this.f230676w;
            boolean r105 = true;
            if (r104 != null) goto L9;
        L11:
            boolean r106 = false;
        L13:
            if ((!r106) == true) goto L15;
        L17:
            int r107 = 8;
        L18:
            r103.setVisibility(r107);
            this.f230677x.setOnClickListener(new c(this.C));
            if ((this.f230138c instanceof UDAvatar) == false) goto L35;
            if (Z3() == false) goto L23;
            int r108 = 32;
        L24:
            com.bytedance.ee.bear.appsetting.c r109 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
            Application r110 = LarkContext.getApplication();
            r109.getClass();
            if (((dn4.a) k.b(((v) k.a(r110, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r110, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.bitable.comment_avatar_size_fix_enable") == false) goto L29;
            ImageView r111 = this.f230138c;
            Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
            if (((UDAvatar) r111).getAvatarSize() == n.d(r108)) goto L30;
            ImageView r112 = this.f230138c;
            Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
            ((UDAvatar) r112).setAvatarSize(n.d(r108));
        L31:
            if (r100 == true) goto L33;
            if (r105 == false) goto L35;
        L33:
            this.f230138c.requestLayout();
        L30:
            r105 = false;
            goto L31
        L29:
            ImageView r113 = this.f230138c;
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
            ((UDAvatar) r113).setAvatarSize(n.d(r108));
            goto L30
        L23:
            r108 = 24;
        L35:
            if (Z3() == false) goto L37;
            int r114 = 16;
        L39:
            if (Z3() == false) goto L41;
            int r115 = 8;
        L42:
            this.itemView.setPadding(n.d(r115), n.d(r114), n.d(8), 0);
            return;
        L41:
            r115 = 52;
            goto L42
        L37:
            r114 = 4;
            goto L39
        L15:
            if (Z3() == false) goto L17;
            r107 = 0;
            goto L18
        L9:
            if (r104.getVisibility() != 0) goto L11;
            r106 = true;
            goto L13
        L5:
            r102 = 8;
            goto L6
        }

        public BitableDiscussContentViewHolder(BitableDiscussListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.C = r100;
            super(r100, r101);
            this.f230677x = (ImageView) r101.findViewById(R.id.tv_opt_private);
            this.f230678y = (ImageView) r101.findViewById(R.id.tv_opt_share);
            this.f230679z = (FrameLayout) r101.findViewById(R.id.content_wrapper);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableDiscussListAdapter f230680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<CommentBean.CommentDetail> f230681b;

        public a(BitableDiscussListAdapter r100, Ref.ObjectRef<CommentBean.CommentDetail> r101) {
            this.f230680a = r100;
            this.f230681b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (BitableDiscussListAdapter.access$canReplayComment(this.f230680a) == false) goto L6;
            BitableDiscussListAdapter.access$replayComment(this.f230680a, this.f230681b.element);
            return;
        }
    }

    private final ye5.a getBitableFunction() {
        y r100 = this.actionControl;
        if ((r100 instanceof BitableDiscussFunction) == true) goto L5;
        return null;
    L5:
        return (ye5.a) r100;
    }

    private final boolean canReplayComment() {
        ye5.a r100 = getBitableFunction();
        if (r100 == null) goto L7;
        LiveData<Boolean> r101 = r100.getCommentAble();
        if (r101 == null) goto L7;
        boolean r102 = Intrinsics.areEqual(r101.getValue(), Boolean.TRUE);
    L8:
        if (r102 == true) goto L11;
        return false;
    L11:
        if (this.commentListeners.T().f230086d.invoke().booleanValue() == false) goto L15;
        this.commentListeners.T().f230085c.invoke();
        return false;
    L15:
        if (ku5.c.k(getConfig().getActivity()) == false) goto L17;
        return true;
    L17:
        if (getConfig().getActivity().getResources().getConfiguration().orientation != 2) goto L21;
        return false;
    L21:
        return true;
    L7:
        r102 = false;
        goto L8
    }

    public final y getActionControl() {
        return this.actionControl;
    }

    public final z getCommentListeners() {
        return this.commentListeners;
    }

    public final String getHeightLightReplyId() {
        return this.heightLightReplyId;
    }

    public static final /* synthetic */ boolean access$canReplayComment(BitableDiscussListAdapter r100) {
        return r100.canReplayComment();
    }

    public static final /* synthetic */ ye5.a access$getBitableFunction(BitableDiscussListAdapter r100) {
        return r100.getBitableFunction();
    }

    public static final /* synthetic */ p access$getConfig(BitableDiscussListAdapter r100) {
        return r100.getConfig();
    }

    private final Drawable getReplyGradientDrawableWithFraction(float r100) {
        return getGradientDrawable(getColorWithAlpha(r100, R.color.primary_pri_50), getColorWithAlpha(r100 * 0.5f, R.color.primary_pri_50));
    }

    private final void replayComment(CommentBean.CommentDetail r210) {
        String r100 = "@" + r210.getName();
        int r101 = 0;
        bo4.a r102 = new bo4.a(0, r100.length(), 0, -1, r210.getUser_id(), null, r100, null, null, null, null, "", null, null, 0, false, null, false, false, "", "", null, null, null, 0);
        StringBuilder r103 = new StringBuilder();
        bo4.a[] r104 = {r102};
        StringBuilder r105 = new StringBuilder(r100);
        int r106 = 1;
    L3:
        r106 = r106 - 1;
        if (r106 < 0) goto L6;
        db5.f.c(r105, r104[r106]);
        goto L3
    L6:
        r103.append(r105.toString());
        r103.append(' ');
        String r107 = r103.toString();
        CommentInputRequest r108 = new CommentInputRequest();
        r108.comment_id = r210.getComment_id();
        r108.is_whole = r210.isWholeComment();
        r108.show_comment_image = getConfig().F;
        r108.show_insert_image = getConfig().E;
        r108.doc_url = getConfig().f232234j;
        r108.keyboard_pop = true;
        r108.show_voice = true;
        if (r210.isWholeComment() == true) goto L10;
        r101 = 2;
    L10:
        r108.type = r101;
        r108.canUseBlankContent = true;
        r108.directional_reply_id = r210.getReply_id();
        r108.content = r107;
        r108.bizParams = getBizParam();
        r108.visibilityBean = new VisibilityBean(getCommentVisibility(r210));
        getConfig().f232225d0.g("addition_click", r210.getComment_id(), r210.getReply_id(), MapsKt.mapOf(TuplesKt.to("type", "discussion")));
        this.commentListeners.T().f230084b.invoke(r108);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2, com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public int getCommentVisibility(CommentBean.CommentDetail r100) {
        if (r100 == null) goto L7;
        CommentBean.CommentDetail.BitableExtraEntity r101 = r100.getBitableExtra();
        if (r101 == null) goto L7;
        return r101.getVisibility();
    L7:
        return super.getCommentVisibility(r100);
    }

    public final void setHeightLightReplyId(String r100) {
        this.heightLightReplyId = r100;
    }

    public static final /* synthetic */ Drawable access$getReplyGradientDrawableWithFraction(BitableDiscussListAdapter r100, float r101) {
        return r100.getReplyGradientDrawableWithFraction(r101);
    }

    public static final /* synthetic */ void access$replayComment(BitableDiscussListAdapter r100, CommentBean.CommentDetail r101) {
        r100.replayComment(r101);
    }

    private final int getColorWithAlpha(float r100, int r101) {
        return ColorUtils.c((int) (r100 * 255), ResourcesCompat.getColor(getConfig().getActivity().getResources(), r101, getConfig().getActivity().getTheme()));
    }

    private final Drawable getGradientDrawable(int r100, int r101) {
        GradientDrawable r102 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r100, r101});
        float r103 = n.d(8);
        r102.setCornerRadii(new float[]{r103, r103, r103, r103, r103, r103, r103, r103});
        return r102;
    }

    public final void heightLightComment(String r100, int r101) {
        this.heightLightReplyId = r100;
        this.heightLightType = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = ListProtector.get(this.commentDetails, r101);
        r102.element = r103;
        boolean r104 = r100 instanceof BitableDiscussContentViewHolder;
        if (r104 == false) goto L5;
        BitableDiscussContentViewHolder r105 = (BitableDiscussContentViewHolder) r100;
        String r106 = ((CommentBean.CommentDetail) r103).getComment_id();
        String r107 = ((CommentBean.CommentDetail) r102.element).getReply_id();
        r105.f230676w = ((CommentBean.CommentDetail) r102.element).getBitableExtra();
        r105.A = r106;
        r105.B = r107;
    L5:
        super.onBindViewHolder(r100, r101);
        boolean r108 = false;
        if (r104 == false) goto L8;
        ((BitableDiscussContentViewHolder) r100).Y3(false);
        r100.itemView.setOnClickListener(new a(this, r102));
    L8:
        String[] r109 = ((CommentBean.CommentDetail) r102.element).getMessageIds();
        if (r109 != null) goto L11;
    L15:
        r108 = true;
    L16:
        if (r108 == false) goto L18;
        return;
    L18:
        if (((CommentBean.CommentDetail) r102.element).getReadStatus() != 1) goto L22;
        this.actionControl.g(ArraysKt.toList(((CommentBean.CommentDetail) r102.element).getMessageIds()));
        ((CommentBean.CommentDetail) r102.element).setReadStatus(2);
        return;
    L22:
        return;
    L11:
        if (r109.length != 0) goto L13;
        boolean r110 = true;
    L14:
        if (r110 == false) goto L16;
    L13:
        r110 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != CardAdapterHelper.ItemType.PART_CONTENT.getType()) goto L7;
        return new BitableDiscussContentViewHolder(this, LayoutInflater.from(getConfig().getActivity()).inflate(R.layout.bottom_panel_comment_card_content, r100, false));
    L7:
        return super.onCreateViewHolder(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setBackGround(CardAdapter2.ContentViewHolder r100, CommentBean.CommentDetail r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof BitableDiscussContentViewHolder) == true) goto L5;
        super.setBackGround(r100, r101);
        return;
    L5:
        if (TextUtils.equals(r101.getReply_id(), this.heightLightReplyId) == false) goto L13;
        int r102 = this.heightLightType;
        if (r102 != 1) goto L10;
        BitableDiscussContentViewHolder r103 = (BitableDiscussContentViewHolder) r100;
        Drawable r104 = getGradientDrawable(ResourcesCompat.getColor(getConfig().getActivity().getResources(), R.color.ud_Y50, getConfig().getActivity().getTheme()), getColorWithAlpha(0.5f, R.color.ud_Y50));
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "bgDrawable");
        r103.f230679z.setBackground(r104);
        return;
    L10:
        if (r102 != 2) goto L12;
        BitableDiscussContentViewHolder r105 = (BitableDiscussContentViewHolder) r100;
        Drawable r106 = getReplyGradientDrawableWithFraction(1.0f);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "bgDrawable");
        r105.f230679z.setBackground(r106);
        return;
    L12:
        ((BitableDiscussContentViewHolder) r100).f230679z.setBackgroundResource(R.color.translate);
        return;
    L13:
        ((BitableDiscussContentViewHolder) r100).f230679z.setBackgroundResource(R.color.translate);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        super.onBindViewHolder(r100, r101, r102);
        if (r102.isEmpty() == false) goto L5;
        return;
    L5:
        if ((r100 instanceof BitableDiscussContentViewHolder) == false) goto L16;
        Bundle r103 = new Bundle();
        Iterator<Object> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.os.Bundle");
        r103.putAll((Bundle) r105);
        goto L8
    L10:
        CommentBean.CommentDetail r106 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r101);
        int r107 = CommentDiffUtils.f231330a;
        if (r103.getInt("IS_MAIN_DISCUSS", 0) != 1) goto L17;
        BitableDiscussContentViewHolder r108 = (BitableDiscussContentViewHolder) r100;
        String r109 = r106.getComment_id();
        String r110 = r106.getReply_id();
        r108.f230676w = r106.getBitableExtra();
        r108.A = r109;
        r108.B = r110;
        r108.Y3(true);
        return;
    L17:
        return;
    }

    public BitableDiscussListAdapter(p r100, List<String> r101, z r102, y r103, SharePermissionViewModel r104, com.bytedance.ee.bear.middleground.comment.card.d r105, String r106, Function0<Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "userIds");
        Intrinsics.checkNotNullParameter(r102, "commentListeners");
        Intrinsics.checkNotNullParameter(r103, "actionControl");
        Intrinsics.checkNotNullParameter(r105, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r106, "language");
        super(r100, r101, r102, r103, r104, r105, r106, r107);
        this.commentListeners = r102;
        this.actionControl = r103;
        this.heightLightType = -1;
    }
}
