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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.image.UDAvatar;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001EBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001fH\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020/2\b\b\u0001\u00102\u001a\u00020\u001fH\u0002J\u001c\u00103\u001a\u00020-2\b\b\u0001\u00104\u001a\u00020\u001f2\b\b\u0001\u00105\u001a\u00020\u001fH\u0002J\u001c\u00106\u001a\u00020\u00122\n\u00107\u001a\u000608R\u00020\u00012\u0006\u00109\u001a\u00020&H\u0014J&\u0010:\u001a\u00020\u00122\u0006\u00107\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016J\u0018\u0010:\u001a\u00020\u00122\u0006\u00107\u001a\u00020(2\u0006\u0010;\u001a\u00020\u001fH\u0016J\u0018\u0010?\u001a\u00020\u00122\b\u0010@\u001a\u0004\u0018\u00010\u00062\u0006\u0010A\u001a\u00020\u001fJ\b\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006F"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/bitablediscuss/BitableDiscussListAdapter;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "userIds", "", "", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "language", "clickLink", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getCommentListeners", "()Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "getActionControl", "()Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "heightLightReplyId", "getHeightLightReplyId", "()Ljava/lang/String;", "setHeightLightReplyId", "(Ljava/lang/String;)V", "heightLightType", "", "bitableFunction", "Lcom/bytedance/ee/bear/middleground/comment/export/bitablecomment/IBitableDiscussFunction;", "getBitableFunction", "()Lcom/bytedance/ee/bear/middleground/comment/export/bitablecomment/IBitableDiscussFunction;", "getCommentVisibility", "commentDetail", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "getReplyGradientDrawableWithFraction", "Landroid/graphics/drawable/Drawable;", "fraction", "", "getColorWithAlpha", "alpha", "baseColor", "getGradientDrawable", "startColor", "endColor", "setBackGround", "holder", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "item", "onBindViewHolder", "position", "payloads", "", "", "heightLightComment", "replyId", ResourceData.KEY_TYPE, "canReplayComment", "", "replayComment", "BitableDiscussContentViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public CommentBean.CommentDetail.BitableExtraEntity w;
        public final ImageView x;
        public final ImageView y;
        public final FrameLayout z;

        public final boolean Z3() {
            CommentBean.CommentDetail.BitableExtraEntity r0 = this.w;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.isMainComment() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.e.a
        public final void R0(float r3) {
            Drawable r4 = BitableDiscussListAdapter.access$getReplyGradientDrawableWithFraction(this.C, 1 - r3);
            Intrinsics.checkNotNullParameter(r4, "bgDrawable");
            this.z.setBackground(r4);
        }

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2.ContentViewHolder
        public final void X3(int r2) {
            if (Z3() == false) goto L5;
            super.X3(r2);
            return;
        L5:
            GridLayoutManager r3 = this.q.getLayoutManager();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            r3.setSpanCount(2);
        }

        public final void Y3(boolean r9) {
            ImageView r0 = this.y;
            if (Z3() == false) goto L5;
            int r1 = 0;
        L6:
            r0.setVisibility(r1);
            this.y.setOnClickListener(new d(this, this.C));
            ImageView r2 = this.x;
            CommentBean.CommentDetail.BitableExtraEntity r3 = this.w;
            boolean r4 = true;
            if (r3 != null) goto L9;
        L11:
            boolean r5 = false;
        L13:
            if ((!r5) == true) goto L15;
        L17:
            int r6 = 8;
        L18:
            r2.setVisibility(r6);
            this.x.setOnClickListener(new c(this.C));
            if ((this.c instanceof UDAvatar) == false) goto L35;
            if (Z3() == false) goto L23;
            int r7 = 32;
        L24:
            com.bytedance.ee.bear.appsetting.c r8 = com.bytedance.ee.bear.appsetting.c.a.a;
            Application r10 = LarkContext.getApplication();
            r8.getClass();
            if (((dn4.a) k.b(((v) k.a(r10, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r10, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.bitable.comment_avatar_size_fix_enable") == false) goto L29;
            UDAvatar r11 = this.c;
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
            if (r11.getAvatarSize() == n.d(r7)) goto L30;
            UDAvatar r12 = this.c;
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
            r12.setAvatarSize(n.d(r7));
        L31:
            if (r9 == true) goto L33;
            if (r4 == false) goto L35;
        L33:
            this.c.requestLayout();
        L30:
            r4 = false;
            goto L31
        L29:
            UDAvatar r13 = this.c;
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.larksuite.component.universe_design.image.UDAvatar");
            r13.setAvatarSize(n.d(r7));
            goto L30
        L23:
            r7 = 24;
        L35:
            if (Z3() == false) goto L37;
            int r14 = 16;
        L39:
            if (Z3() == false) goto L41;
            int r15 = 8;
        L42:
            ((RecyclerView.ViewHolder) this).itemView.setPadding(n.d(r15), n.d(r14), n.d(8), 0);
            return;
        L41:
            r15 = 52;
            goto L42
        L37:
            r14 = 4;
            goto L39
        L15:
            if (Z3() == false) goto L17;
            r6 = 0;
            goto L18
        L9:
            if (r3.getVisibility() != 0) goto L11;
            r5 = true;
            goto L13
        L5:
            r1 = 8;
            goto L6
        }

        public BitableDiscussContentViewHolder(BitableDiscussListAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.C = r2;
            super(r2, r3);
            this.x = (ImageView) r3.findViewById(2131391038);
            this.y = (ImageView) r3.findViewById(2131391039);
            this.z = (FrameLayout) r3.findViewById(2131367868);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BitableDiscussListAdapter a;
        public final /* synthetic */ Ref.ObjectRef<CommentBean.CommentDetail> b;

        public a(BitableDiscussListAdapter r1, Ref.ObjectRef<CommentBean.CommentDetail> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (BitableDiscussListAdapter.access$canReplayComment(this.a) == false) goto L6;
            BitableDiscussListAdapter.access$replayComment(this.a, (CommentBean.CommentDetail) this.b.element);
            return;
        }
    }

    private final ye5.a getBitableFunction() {
        y r0 = this.actionControl;
        if ((r0 instanceof BitableDiscussFunction) == true) goto L5;
        return null;
    L5:
        return (ye5.a) r0;
    }

    private final boolean canReplayComment() {
        ye5.a r0 = getBitableFunction();
        if (r0 == null) goto L7;
        LiveData<Boolean> r1 = r0.getCommentAble();
        if (r1 == null) goto L7;
        boolean r2 = Intrinsics.areEqual(r1.getValue(), Boolean.TRUE);
    L8:
        if (r2 == true) goto L11;
        return false;
    L11:
        if (((Boolean) this.commentListeners.T().d.invoke()).booleanValue() == false) goto L15;
        this.commentListeners.T().c.invoke();
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
        r2 = false;
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

    public static final /* synthetic */ boolean access$canReplayComment(BitableDiscussListAdapter r0) {
        return r0.canReplayComment();
    }

    public static final /* synthetic */ ye5.a access$getBitableFunction(BitableDiscussListAdapter r0) {
        return r0.getBitableFunction();
    }

    public static final /* synthetic */ p access$getConfig(BitableDiscussListAdapter r0) {
        return r0.getConfig();
    }

    private final Drawable getReplyGradientDrawableWithFraction(float r4) {
        return getGradientDrawable(getColorWithAlpha(r4, 2131105567), getColorWithAlpha(r4 * 0.5f, 2131105567));
    }

    private final void replayComment(CommentBean.CommentDetail r29) {
        String r0 = "@" + r29.getName();
        int r5 = 0;
        bo4.a r1 = new bo4.a(0, r0.length(), 0, -1, r29.getUser_id(), null, r0, null, null, null, null, "", null, null, 0, false, null, false, false, "", "", null, null, null, 0);
        StringBuilder r2 = new StringBuilder();
        bo4.a[] r4 = {r1};
        StringBuilder r3 = new StringBuilder(r0);
        int r6 = 1;
    L3:
        r6 = r6 - 1;
        if (r6 < 0) goto L6;
        db5.f.c(r3, r4[r6]);
        goto L3
    L6:
        r2.append(r3.toString());
        r2.append(' ');
        String r7 = r2.toString();
        CommentInputRequest r8 = new CommentInputRequest();
        r8.comment_id = r29.getComment_id();
        r8.is_whole = r29.isWholeComment();
        r8.show_comment_image = getConfig().F;
        r8.show_insert_image = getConfig().E;
        r8.doc_url = getConfig().j;
        r8.keyboard_pop = true;
        r8.show_voice = true;
        if (r29.isWholeComment() == true) goto L10;
        r5 = 2;
    L10:
        r8.type = r5;
        r8.canUseBlankContent = true;
        r8.directional_reply_id = r29.getReply_id();
        r8.content = r7;
        r8.bizParams = getBizParam();
        r8.visibilityBean = new VisibilityBean(getCommentVisibility(r29));
        getConfig().d0.g("addition_click", r29.getComment_id(), r29.getReply_id(), MapsKt.mapOf(TuplesKt.to(ResourceData.KEY_TYPE, "discussion")));
        this.commentListeners.T().b.invoke(r8);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2, com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public int getCommentVisibility(CommentBean.CommentDetail r2) {
        if (r2 == null) goto L7;
        CommentBean.CommentDetail.BitableExtraEntity r0 = r2.getBitableExtra();
        if (r0 == null) goto L7;
        return r0.getVisibility();
    L7:
        return super.getCommentVisibility(r2);
    }

    public final void setHeightLightReplyId(String r1) {
        this.heightLightReplyId = r1;
    }

    public static final /* synthetic */ Drawable access$getReplyGradientDrawableWithFraction(BitableDiscussListAdapter r0, float r1) {
        return r0.getReplyGradientDrawableWithFraction(r1);
    }

    public static final /* synthetic */ void access$replayComment(BitableDiscussListAdapter r0, CommentBean.CommentDetail r1) {
        r0.replayComment(r1);
    }

    private final int getColorWithAlpha(float r3, int r4) {
        return ColorUtils.c((int) (r3 * 255), ResourcesCompat.getColor(getConfig().getActivity().getResources(), r4, getConfig().getActivity().getTheme()));
    }

    private final Drawable getGradientDrawable(int r6, int r7) {
        GradientDrawable r0 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r6, r7});
        float r1 = n.d(8);
        r0.setCornerRadii(new float[]{r1, r1, r1, r1, r1, r1, r1, r1});
        return r0;
    }

    public final void heightLightComment(String r1, int r2) {
        this.heightLightReplyId = r1;
        this.heightLightType = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        Object r1 = ListProtector.get(this.commentDetails, r8);
        r0.element = r1;
        boolean r2 = r7 instanceof BitableDiscussContentViewHolder;
        if (r2 == false) goto L5;
        BitableDiscussContentViewHolder r3 = (BitableDiscussContentViewHolder) r7;
        String r4 = ((CommentBean.CommentDetail) r1).getComment_id();
        String r5 = ((CommentBean.CommentDetail) r0.element).getReply_id();
        r3.w = ((CommentBean.CommentDetail) r0.element).getBitableExtra();
        r3.A = r4;
        r3.B = r5;
    L5:
        super.onBindViewHolder(r7, r8);
        boolean r9 = false;
        if (r2 == false) goto L8;
        ((BitableDiscussContentViewHolder) r7).Y3(false);
        r7.itemView.setOnClickListener(new a(this, r0));
    L8:
        String[] r10 = ((CommentBean.CommentDetail) r0.element).getMessageIds();
        if (r10 != null) goto L11;
    L15:
        r9 = true;
    L16:
        if (r9 == false) goto L18;
        return;
    L18:
        if (((CommentBean.CommentDetail) r0.element).getReadStatus() != 1) goto L22;
        this.actionControl.g(ArraysKt.toList(((CommentBean.CommentDetail) r0.element).getMessageIds()));
        ((CommentBean.CommentDetail) r0.element).setReadStatus(2);
        return;
    L22:
        return;
    L11:
        if (r10.length != 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L16;
    L13:
        r11 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != CardAdapterHelper.ItemType.PART_CONTENT.getType()) goto L7;
        return new BitableDiscussContentViewHolder(this, LayoutInflater.from(getConfig().getActivity()).inflate(2131559203, r4, false));
    L7:
        return super.onCreateViewHolder(r4, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setBackGround(CardAdapter2.ContentViewHolder r4, CommentBean.CommentDetail r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        if ((r4 instanceof BitableDiscussContentViewHolder) == true) goto L5;
        super.setBackGround(r4, r5);
        return;
    L5:
        if (TextUtils.equals(r5.getReply_id(), this.heightLightReplyId) == false) goto L13;
        int r6 = this.heightLightType;
        if (r6 != 1) goto L10;
        BitableDiscussContentViewHolder r7 = (BitableDiscussContentViewHolder) r4;
        Drawable r8 = getGradientDrawable(ResourcesCompat.getColor(getConfig().getActivity().getResources(), 2131108869, getConfig().getActivity().getTheme()), getColorWithAlpha(0.5f, 2131108869));
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "bgDrawable");
        r7.z.setBackground(r8);
        return;
    L10:
        if (r6 != 2) goto L12;
        BitableDiscussContentViewHolder r9 = (BitableDiscussContentViewHolder) r4;
        Drawable r10 = getReplyGradientDrawableWithFraction(1.0f);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "bgDrawable");
        r9.z.setBackground(r10);
        return;
    L12:
        ((BitableDiscussContentViewHolder) r4).z.setBackgroundResource(2131106781);
        return;
    L13:
        ((BitableDiscussContentViewHolder) r4).z.setBackgroundResource(2131106781);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List<Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        super.onBindViewHolder(r4, r5, r6);
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        if ((r4 instanceof BitableDiscussContentViewHolder) == false) goto L16;
        Bundle r0 = new Bundle();
        Iterator<Object> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        Object r1 = r7.next();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.os.Bundle");
        r0.putAll((Bundle) r1);
        goto L8
    L10:
        CommentBean.CommentDetail r8 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r5);
        int r9 = CommentDiffUtils.a;
        if (r0.getInt("IS_MAIN_DISCUSS", 0) != 1) goto L17;
        BitableDiscussContentViewHolder r10 = (BitableDiscussContentViewHolder) r4;
        String r11 = r8.getComment_id();
        String r2 = r8.getReply_id();
        r10.w = r8.getBitableExtra();
        r10.A = r11;
        r10.B = r2;
        r10.Y3(true);
        return;
    L17:
        return;
    }

    public BitableDiscussListAdapter(p r2, List<String> r3, z r4, y r5, SharePermissionViewModel r6, com.bytedance.ee.bear.middleground.comment.card.d r7, String r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "userIds");
        Intrinsics.checkNotNullParameter(r4, "commentListeners");
        Intrinsics.checkNotNullParameter(r5, "actionControl");
        Intrinsics.checkNotNullParameter(r7, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r8, "language");
        super(r2, r3, r4, r5, r6, r7, r8, r9);
        this.commentListeners = r4;
        this.actionControl = r5;
        this.heightLightType = -1;
    }
}
