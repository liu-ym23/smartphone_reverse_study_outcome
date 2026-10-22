package com.bytedance.ee.bear.middleground.comment.adapter.aside;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapterHelper;
import com.bytedance.ee.bear.middleground.comment.adapter.ReactionViewHolder;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.x;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.w;
import com.bytedance.ee.bear.middleground.comment.input.AsideInputComment;
import com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlFragmentV2;
import com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlPadFragment;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.middleground.comment.widget.SmartReplyPreview;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.edittext.UDEditText;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003OPQBk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001fJ\b\u0010(\u001a\u00020\u0013H\u0014J\u0012\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\u0006H\u0014J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0012H\u0016J&\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0016J\u0018\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0012H\u0016J$\u00106\u001a\u00020\u00132\n\u00101\u001a\u000607R\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u00102\u001a\u00020\u0012H\u0002J\u001c\u0010:\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u000209H\u0014J\u001c\u0010<\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u000209H\u0014J$\u0010=\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u0002092\u0006\u00102\u001a\u00020\u0012H\u0014J\u001c\u0010>\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u000209H\u0014J$\u0010?\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u0002092\u0006\u00102\u001a\u00020\u0012H\u0014J\u001c\u0010@\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u0010A\u001a\u000209H\u0014J\u0012\u0010B\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u0001J\u001c\u0010C\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u000209H\u0014J\u0012\u0010D\u001a\u00020\u00132\n\u00101\u001a\u00060ER\u00020\u0001J\u001c\u0010F\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u000209H\u0014J$\u0010G\u001a\u00020\u00132\n\u00101\u001a\u00060ER\u00020\u00012\u0006\u00108\u001a\u0002092\u0006\u00102\u001a\u00020\u0012H\u0014J\u001c\u0010H\u001a\u00020\u00132\n\u00101\u001a\u00060;R\u00020\u00012\u0006\u00108\u001a\u000209H\u0014J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J<\u0010K\u001a\u00020\u00132\n\u00101\u001a\u00060ER\u00020\u00012\u0006\u00108\u001a\u0002092\u0006\u0010L\u001a\u00020M2\u0006\u00102\u001a\u00020\u00122\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "userIds", "", "", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "language", "avoidKeyboard", "Lkotlin/Function1;", "", "", "clickLink", "Lkotlin/Function0;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "isInEditStatus", "", "()Z", "setInEditStatus", "(Z)V", "skipContentClick", "editInputRequest", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;", "setEditInputRequest", "request", "commentControlCallback", "Lcom/bytedance/ee/bear/middleground/comment/permission/CommentCollaboratorControlFragmentV2$ICommentControlCallback;", "getCommentControlCallback", "()Lcom/bytedance/ee/bear/middleground/comment/permission/CommentCollaboratorControlFragmentV2$ICommentControlCallback;", "setCommentControlCallback", "(Lcom/bytedance/ee/bear/middleground/comment/permission/CommentCollaboratorControlFragmentV2$ICommentControlCallback;)V", "updateImageSize", "isSameSpaceInner", ResourceData.KEY_URL, "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "setEditInputComment", "Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter$AsideContentViewHolder;", "item", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "setCommentImageList", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "setSmartAIReplyPreview", "setTranslateContent", "setTranslateIcon", "setContent", "setReaction", "commentDetail", "setContentClick", "setMore", "setQuoteClick", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$QuoteViewHolder;", "setBackGround", "bindQuoteMenu", "clickSmartAIReplyPreview", "getUiState", "Lcom/bytedance/ee/bear/middleground/comment/export/UiState;", "showCardMoreMenuList", "cardAdapter", "Lcom/bytedance/ee/bear/middleground/comment/export/ICardAdapter;", "participantList", "AsideContentViewHolder", "AsideQuoteViewHolder", "AsideNewInputViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsideCommentCardAdapter extends CardAdapter2 {
    private final y actionControl;
    private final Function1<Integer, Unit> avoidKeyboard;
    private CommentCollaboratorControlFragmentV2.b commentControlCallback;
    private final z commentListeners;
    private CommentInputRequest editInputRequest;
    private boolean isInEditStatus;
    private boolean skipContentClick;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter$AsideContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter;Landroid/view/View;)V", "inputContainer", "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "inputComment", "Lcom/bytedance/ee/bear/middleground/comment/input/AsideInputComment;", "showInput", "", "item", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "position", "", "hideInput", "bySend", "", "initInputComment", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AsideContentViewHolder extends CardAdapter2.ContentViewHolder {
        public static final /* synthetic */ int z = 0;
        public final ViewGroup w;
        public AsideInputComment x;
        public final /* synthetic */ AsideCommentCardAdapter y;

        public final void Y3(boolean r5) {
            this.w.setVisibility(8);
            AsideInputComment r0 = this.x;
            if (r0 == null) goto L5;
            r0.j0 = null;
        L5:
            boolean r1 = true;
            if (r0 != null) goto L8;
        L10:
            boolean r2 = false;
        L11:
            if (r2 == false) goto L31;
            tt5.a.h(CardAdapter2.TAG, "hideInput, so dismiss inputComment");
            AsideInputComment r3 = this.x;
            if (r3 != null) goto L15;
            return;
        L15:
            if (AsideCommentCardAdapter.access$getConfig(this.y).r.isKeyboardShowing() == true) goto L17;
        L28:
            r1 = false;
        L29:
            r3.d(r5, r1);
            return;
        L17:
            if (AsideCommentCardAdapter.access$getConfig(this.y).getActivity().getCurrentFocus() == null) goto L29;
            AsideInputComment r4 = this.x;
            if (r4 == null) goto L25;
            UDEditText r6 = r4.e();
            if (r6 == null) goto L25;
            if (r6.hasFocus() != true) goto L25;
            boolean r7 = true;
        L26:
            if (r7 == false) goto L28;
        L25:
            r7 = false;
            goto L26
        L31:
            return;
        L8:
            if (r0.isShowing() != true) goto L10;
            r2 = true;
            goto L11
        }

        public AsideContentViewHolder(AsideCommentCardAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.y = r2;
            super(r2, r3);
            SmartReplyPreview r4 = this.r;
            if (r4 == null) goto L5;
            r4.setCloseBtnVisible(true);
        L5:
            this.w = (ViewGroup) r3.findViewById(2131375355);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter$AsideNewInputViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter;Landroid/view/View;)V", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AsideNewInputViewHolder extends CardAdapter2.ContentViewHolder {
        public AsideNewInputViewHolder(AsideCommentCardAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            super(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter$AsideQuoteViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$QuoteViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/aside/AsideCommentCardAdapter;Landroid/view/View;)V", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AsideQuoteViewHolder extends CardAdapter2.QuoteViewHolder {
        public AsideQuoteViewHolder(AsideCommentCardAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            super(r2, r3);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CardAdapter2.QuoteViewHolder b;
        public final /* synthetic */ AsideCommentCardAdapter c;
        public final /* synthetic */ CommentBean.CommentDetail d;

        public a(boolean r1, CardAdapter2.QuoteViewHolder r2, AsideCommentCardAdapter r3, CommentBean.CommentDetail r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (this.a == true) goto L6;
            Toast.showText(((RecyclerView.ViewHolder) this.b).itemView.getContext(), 2131889183);
            return;
        L6:
            AsideCommentCardAdapter.access$getCommentListeners$p(this.c).o0().invoke();
            y r1 = AsideCommentCardAdapter.access$getActionControl$p(this.c);
            String r2 = this.d.getComment_id();
            int r3 = this.d.getCommentType();
            boolean r4 = this.d.isWholeComment();
            boolean r5 = true;
            if (this.d.getCommentType() == 1) goto L10;
            r5 = false;
        L10:
            x.a(r1, r2, r3, r4, r5, false, r10, 16);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AsideCommentCardAdapter a;

        public b(AsideCommentCardAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getOnClickEmpty();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ AsideCommentCardAdapter a;

        public c(AsideCommentCardAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(CardAdapter2.TAG, "skipContentClick is " + AsideCommentCardAdapter.access$getSkipContentClick$p(this.a));
            if (AsideCommentCardAdapter.access$getSkipContentClick$p(this.a) == true) goto L7;
            Function0<Unit> r3 = this.a.getOnClickEmpty();
            if (r3 == null) goto L7;
            r3.invoke();
        L7:
            AsideCommentCardAdapter.access$setSkipContentClick$p(this.a, false);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AsideCommentCardAdapter a;

        public d(AsideCommentCardAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getOnClickEmpty();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ AsideCommentCardAdapter a;

        public e(AsideCommentCardAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getOnClickEmpty();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ AsideCommentCardAdapter a;

        public f(AsideCommentCardAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getOnClickEmpty();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ AsideCommentCardAdapter a;

        public g(AsideCommentCardAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getOnClickEmpty();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2.ContentViewHolder a;
        public final /* synthetic */ AsideCommentCardAdapter b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public h(CardAdapter2.ContentViewHolder r1, AsideCommentCardAdapter r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            SmartReplyPreview r4 = this.a.r;
            if (r4 == null) goto L5;
            r4.setVisibility(8);
        L5:
            y r5 = AsideCommentCardAdapter.access$getActionControl$p(this.b);
            CommentBean.CommentDetail r0 = this.c;
            r5.D(r0, r0.getReply_id());
        }
    }

    public static final class i implements CommentCollaboratorControlPadFragment.b {
        public final /* synthetic */ AsideCommentCardAdapter a;

        @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlPadFragment.b
        public final void onDismiss() {
            CommentCollaboratorControlFragmentV2.b r0 = this.a.getCommentControlCallback();
            if (r0 == null) goto L6;
            r0.onDismiss();
            return;
        }

        public i(AsideCommentCardAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.permission.CommentCollaboratorControlPadFragment.b
        public final void a(int r3) {
            tt5.a.h(CardAdapter2.TAG, "onVisibilityUpdated: " + r3);
            CommentCollaboratorControlFragmentV2.b r0 = this.a.getCommentControlCallback();
            if (r0 == null) goto L5;
            r0.a(r3);
        L5:
            CommentBean r1 = AsideCommentCardAdapter.access$getCommentBean(this.a);
            if (r1 == null) goto L11;
            CommentBean.Extra r2 = r1.getExtra();
            if (r2 == null) goto L12;
            r2.setVisibility(r3);
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setBackGround(CardAdapter2.ContentViewHolder r2, CommentBean.CommentDetail r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void updateImageSize() {
        FrameLayout r0 = getConfig().d;
        if (r0 == null) goto L5;
        int r1 = r0.getWidth();
    L6:
        CardAdapter2.a r2 = CardAdapter2.Companion;
        r2.getClass();
        setImageSize(((r1 - CardAdapter2.access$getCOMMENT_IMAGE_OUTER_SPACE_WIDTH$cp()) - (getImageItemMargin() * 2)) / 3);
        if (getConfig().C == true) goto L9;
        return;
    L9:
        if (getConfig().getActivity().getResources().getConfiguration().orientation != 2) goto L13;
        int r3 = getImageSize();
        r2.getClass();
        setImageSize(Math.min(r3, CardAdapter2.access$getCOMMENT_MAX_IMAGE_SIZE$cp()));
        return;
    L13:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final CommentCollaboratorControlFragmentV2.b getCommentControlCallback() {
        return this.commentControlCallback;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2, com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public w getUiState() {
        return this.uiState;
    }

    public final boolean isInEditStatus() {
        return this.isInEditStatus;
    }

    public static final /* synthetic */ y access$getActionControl$p(AsideCommentCardAdapter r0) {
        return r0.actionControl;
    }

    public static final /* synthetic */ Function1 access$getAvoidKeyboard$p(AsideCommentCardAdapter r0) {
        return r0.avoidKeyboard;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.comment.card.d access$getCardDataViewModel(AsideCommentCardAdapter r0) {
        return r0.getCardDataViewModel();
    }

    public static final /* synthetic */ CommentBean access$getCommentBean(AsideCommentCardAdapter r0) {
        return r0.getCommentBean();
    }

    public static final /* synthetic */ z access$getCommentListeners$p(AsideCommentCardAdapter r0) {
        return r0.commentListeners;
    }

    public static final /* synthetic */ p access$getConfig(AsideCommentCardAdapter r0) {
        return r0.getConfig();
    }

    public static final /* synthetic */ CommentInputRequest access$getEditInputRequest$p(AsideCommentCardAdapter r0) {
        return r0.editInputRequest;
    }

    public static final /* synthetic */ SharePermissionViewModel access$getSharePermissionViewModel(AsideCommentCardAdapter r0) {
        return r0.getSharePermissionViewModel();
    }

    public static final /* synthetic */ boolean access$getSkipContentClick$p(AsideCommentCardAdapter r0) {
        return r0.skipContentClick;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public boolean isSameSpaceInner(String r2) {
        boolean r3 = super.isSameSpaceInner(r2);
        if (r3 == false) goto L5;
        this.skipContentClick = true;
    L5:
        return r3;
    }

    public final void setCommentControlCallback(CommentCollaboratorControlFragmentV2.b r1) {
        this.commentControlCallback = r1;
    }

    public final void setContentClick(CardAdapter2.ContentViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(new b(this));
        r3.f.setOnClickListener(new c(this));
        r3.a.setOnClickListener(new d(this));
    }

    public final void setEditInputRequest(CommentInputRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.editInputRequest = r2;
    }

    public final void setInEditStatus(boolean r1) {
        this.isInEditStatus = r1;
    }

    public final void setQuoteClick(CardAdapter2.QuoteViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(new e(this));
        r3.d.setOnClickListener(new f(this));
        r3.j.setOnClickListener(new g(this));
    }

    public static final /* synthetic */ void access$setEditInputRequest$p(AsideCommentCardAdapter r0, CommentInputRequest r1) {
        r0.editInputRequest = r1;
    }

    public static final /* synthetic */ void access$setSkipContentClick$p(AsideCommentCardAdapter r0, boolean r1) {
        r0.skipContentClick = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void clickSmartAIReplyPreview(CardAdapter2.ContentViewHolder r2, CommentBean.CommentDetail r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        super.clickSmartAIReplyPreview(r2, r3);
        Function0<Unit> r4 = getOnClickEmpty();
        if (r4 == null) goto L6;
        r4.invoke();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof AsideNewInputViewHolder) == false) goto L8;
        CommentBean.CommentDetail r0 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(this.commentDetails, r7);
        if (r0 != null) goto L7;
        return;
    L7:
        AsideNewInputViewHolder r1 = (AsideNewInputViewHolder) r6;
        r1.d.setText(r0.getName());
        r1.p.setVisibility(8);
        r1.p.setOnClickListener(null);
        setAvatar((CardAdapter2.ContentViewHolder) r6, r0);
        r1.f.setVisibility(8);
    L10:
        if ((r6 instanceof AsideContentViewHolder) == false) goto L13;
        setEditInputComment((AsideContentViewHolder) r6, (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r7), r7);
        return;
    L13:
        return;
    L8:
        super.onBindViewHolder(r6, r7);
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != CardAdapterHelper.ItemType.PART_CONTENT.getType()) goto L6;
        return new AsideContentViewHolder(this, LayoutInflater.from(getConfig().getActivity()).inflate(2131558725, r4, false));
    L6:
        if (r5 != CardAdapterHelper.ItemType.REVISION_CONTENT.getType()) goto L9;
        return new CardAdapter2.RevisionViewHolder(this, LayoutInflater.from(getConfig().getActivity()).inflate(2131558725, r4, false));
    L9:
        if (r5 != CardAdapterHelper.ItemType.QUOTE.getType()) goto L12;
        return new AsideQuoteViewHolder(this, LayoutInflater.from(getConfig().getActivity()).inflate(2131558727, r4, false));
    L12:
        if (r5 != CardAdapterHelper.ItemType.ASIDE_NEW_INPUT.getType()) goto L15;
        return new AsideNewInputViewHolder(this, LayoutInflater.from(getConfig().getActivity()).inflate(2131558725, r4, false));
    L15:
        return super.onCreateViewHolder(r4, r5);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setCommentImageList(CardAdapter2.ContentViewHolder r2, CommentBean.CommentDetail r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r3.isEditStatus() == false) goto L5;
        r2.q.setVisibility(8);
        return;
    L5:
        super.setCommentImageList(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setMore(CardAdapter2.ContentViewHolder r4, CommentBean.CommentDetail r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        CommentBean r0 = getCommentBean();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        r4.g.setVisibility(8);
        return;
    L9:
        super.setMore(r4, r5);
        return;
    L5:
        if (r0.isNewInput() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setReaction(CardAdapter2.ContentViewHolder r3, CommentBean.CommentDetail r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "commentDetail");
        if (r4.isEditStatus() == false) goto L5;
        r3.h.setVisibility(8);
        return;
    L5:
        r3.h.setVisibility(0);
        super.setReaction(r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setSmartAIReplyPreview(CardAdapter2.ContentViewHolder r3, CommentBean.CommentDetail r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "item");
        super.setSmartAIReplyPreview(r3, r4);
        SmartReplyPreview r0 = r3.r;
        if (r0 == null) goto L5;
        r0.setCloseBtnClickListener(new h(r3, this, r4));
    L5:
        SmartReplyPreview r5 = r3.r;
        if (r5 == null) goto L9;
        r5.setLongClickable(false);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setTranslateIcon(CardAdapter2.ContentViewHolder r2, CommentBean.CommentDetail r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r3.isEditStatus() == false) goto L5;
        r2.b.setVisibility(8);
        return;
    L5:
        super.setTranslateIcon(r2, r3);
    }

    private final void setEditInputComment(final AsideContentViewHolder r22, CommentBean.CommentDetail r23, final int r24) {
        boolean r4 = false;
        if (r23.isEditStatus() == false) goto L55;
        this.isInEditStatus = true;
        this.uiState.a = r23.getReply_id();
        this.uiState.b = Integer.valueOf(r24);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "item");
        if (r22.x != null) goto L15;
        p r11 = access$getConfig(r22.y);
        z r12 = access$getCommentListeners$p(r22.y);
        t r5 = access$getCardDataViewModel(r22.y).c;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataControl");
        t r13 = null;
    L11:
        CommentInputRequest r15 = new CommentInputRequest();
        com.bytedance.ee.bear.middleground.comment.adapter.aside.a r19 = new com.bytedance.ee.bear.middleground.comment.adapter.aside.a();
        Function1 r20 = access$getAvoidKeyboard$p(r22.y);
        SharePermissionViewModel r6 = access$getSharePermissionViewModel(r22.y);
        if (r6 != null) goto L14;
        r6 = new SharePermissionViewModel(access$getConfig(r22.y));
    L14:
        final AsideCommentCardAdapter r7 = r22.y;
        Function1<String, Unit> r14 = new AsideCommentCardAdapter$AsideContentViewHolder$initInputComment$2(r7);
        final AsideCommentCardAdapter r8 = r22.y;
        r22.x = new AsideInputComment(r11, r12, r13, r14, r15, new AsideCommentCardAdapter$AsideContentViewHolder$initInputComment$3(r8), new AsideCommentCardAdapter$AsideContentViewHolder$initInputComment$4(r22), r6, r19, r20);
        goto L15
    L10:
        r13 = r5;
    L15:
        r22.w.setVisibility(0);
        AsideInputComment r9 = r22.x;
        if (r9 == null) goto L20;
        CommentInputRequest r10 = r9.j;
        if (r10 == null) goto L20;
        String r16 = r10.comment_id;
    L22:
        if (TextUtils.equals(r16, r23.getComment_id()) == true) goto L33;
        AsideInputComment r17 = r22.x;
        if (r17 != null) goto L26;
    L28:
        boolean r18 = false;
    L29:
        if (r18 == false) goto L33;
        tt5.a.h(CardAdapter2.TAG, "showInput, but comment_id is not same, so dismiss inputComment");
        AsideInputComment r21 = r22.x;
        if (r21 == null) goto L33;
        kf5.a.a(r21, false, false, 3);
        goto L33
    L26:
        if (r17.isShowing() != true) goto L28;
        r18 = true;
    L33:
        CommentInputRequest r25 = access$getEditInputRequest$p(r22.y);
        AsideInputComment r110 = r22.x;
        if (r110 == null) goto L42;
        if (r25 == null) goto L37;
        access$setEditInputRequest$p(r22.y, null);
    L41:
        r110.p(r25);
        goto L42
    L37:
        tt5.a.k(CardAdapter2.TAG, "createInputRequest when edit: commentBean is null");
        int r3 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a;
        CommentBean r26 = access$getCommentBean(r22.y);
        if (r26 != null) goto L40;
        r26 = new CommentBean();
    L40:
        r25 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a(r26, access$getConfig(r22.y), 1, r23, r23.getContent(), r22.y.getBizParam(), null, null, 448);
    L42:
        AsideInputComment r27 = r22.x;
        if (r27 == null) goto L45;
        final AsideCommentCardAdapter r28 = r22.y;
        r27.j0 = new AsideCommentCardAdapter$AsideContentViewHolder$showInput$1(r28, r24, r22);
    L45:
        m.a(new com.bytedance.ee.bear.middleground.comment.adapter.aside.b(r22));
        AsideInputComment r29 = r22.x;
        if (r29 != null) goto L48;
    L50:
        if (r4 == true) goto L59;
        AsideInputComment r30 = r22.x;
        if (r30 == null) goto L60;
        kf5.a.b(r30, false, false, false, false, false, 31);
        return;
    L60:
        return;
    L59:
        return;
    L48:
        if (r29.isShowing() != true) goto L50;
        r4 = true;
    L20:
        r16 = null;
        goto L22
    L55:
        if (TextUtils.equals(this.uiState.a, r23.getReply_id()) == false) goto L57;
        w r2 = this.uiState;
        r2.a = null;
        r2.b = null;
    L57:
        this.isInEditStatus = false;
        int r31 = AsideContentViewHolder.z;
        r22.Y3(false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void bindQuoteMenu(CardAdapter2.QuoteViewHolder r4, CommentBean.CommentDetail r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        super.bindQuoteMenu(r4, r5, r6);
        String r7 = getConfig().O;
        boolean r0 = true;
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L34;
        CommentBean r9 = getCommentBean();
        if (r9 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r10 == true) goto L35;
        CommentBean r11 = getCommentBean();
        if (r11 != null) goto L20;
    L22:
        r0 = false;
    L23:
        if (r0 == false) goto L36;
        y r12 = this.actionControl;
        String r1 = r5.getUser_id();
        CommentBean r2 = getCommentBean();
        if (r2 == null) goto L27;
        List<String> r3 = r2.getParticipantList();
    L28:
        boolean r13 = r12.t(r1, r3);
        r4.e.setVisibility(0);
        ImageView r14 = r4.e;
        if (r13 == false) goto L31;
        int r15 = 2131102419;
    L32:
        l.c(r14, r15);
        r4.e.setOnClickListener(new a(r13, r4, this, r5));
        return;
    L31:
        r15 = 2131102416;
        goto L32
    L27:
        r3 = null;
        goto L28
    L36:
        return;
    L20:
        if (r11.isNewInput() == true) goto L22;
    L35:
        return;
    L13:
        if (r9.getCommentType() != 2) goto L15;
        r10 = true;
        goto L16
    L34:
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r8 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void onBindViewHolder(RecyclerView.ViewHolder r5, int r6, List<Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r7, "payloads");
        super.onBindViewHolder(r5, r6, r7);
        if (r7.isEmpty() == true) goto L22;
        if ((r5 instanceof CardAdapter2.QuoteViewHolder) == true) goto L22;
        if ((r5 instanceof CardAdapter2.PlaceHolderViewHolder) == true) goto L22;
        if ((r5 instanceof ReactionViewHolder) == true) goto L22;
        Bundle r0 = new Bundle();
        Iterator<Object> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        Object r1 = r8.next();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.os.Bundle");
        r0.putAll((Bundle) r1);
        goto L13
    L15:
        CommentBean.CommentDetail r9 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r6);
        if ((r5 instanceof AsideContentViewHolder) == false) goto L22;
        AsideContentViewHolder r2 = (AsideContentViewHolder) r5;
        r2.u = r9;
        int r3 = CommentDiffUtils.a;
        if (r0.getInt("EDITSTATUS", 0) != 1) goto L20;
        CardAdapter2.ContentViewHolder r4 = (CardAdapter2.ContentViewHolder) r5;
        setContent(r4, r9, r6);
        setReaction(r4, r9);
        setMore(r4, r9);
        setTranslateIcon(r4, r9);
        setTranslateContent(r4, r9, r6);
        setSmartAIReplyPreview(r4, r9);
        setCommentImageList(r4, r9);
    L20:
        setEditInputComment(r2, r9, r6);
    L22:
        if ((r5 instanceof AsideQuoteViewHolder) == false) goto L25;
        setQuoteClick((CardAdapter2.QuoteViewHolder) r5);
        return;
    L25:
        if ((r5 instanceof AsideContentViewHolder) == false) goto L27;
    L28:
        setContentClick((CardAdapter2.ContentViewHolder) r5);
        return;
    L27:
        if ((r5 instanceof CardAdapter2.RevisionViewHolder) == true) goto L28;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setContent(CardAdapter2.ContentViewHolder r2, CommentBean.CommentDetail r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r3.isEditStatus() == false) goto L5;
        r2.f.setVisibility(8);
        return;
    L5:
        super.setContent(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void setTranslateContent(CardAdapter2.ContentViewHolder r2, CommentBean.CommentDetail r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r3.isEditStatus() == false) goto L5;
        r2.a.setVisibility(8);
        return;
    L5:
        super.setTranslateContent(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2
    public void showCardMoreMenuList(CardAdapter2.QuoteViewHolder r8, CommentBean.CommentDetail r9, ICardAdapter r10, int r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r10, "cardAdapter");
        CommentBean r13 = getCommentBean();
        int r0 = 0;
        if (r13 == null) goto L7;
        boolean r1 = true;
        if (r13.isNewInput() != true) goto L7;
    L8:
        if (r1 == false) goto L15;
        int r14 = CommentCollaboratorControlPadFragment.n;
        CommentBean r15 = getCommentBean();
        if (r15 == null) goto L14;
        CommentBean.Extra r16 = r15.getExtra();
        if (r16 == null) goto L14;
        r0 = r16.getVisibility();
    L14:
        FragmentActivity r17 = getConfig().getActivity();
        View r18 = ((RecyclerView.ViewHolder) r8).itemView;
        sbb.e r19 = getConfig().k;
        Intrinsics.checkNotNullParameter(r19, "pageType");
        new CommentCollaboratorControlPadFragment(r0, r17, r18, r19).S90(getConfig().g, new i(this));
        return;
    L15:
        this.actionControl.y(((RecyclerView.ViewHolder) r8).itemView, r9, this, r11, r12, false);
        return;
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsideCommentCardAdapter(p r14, List<String> r15, z r16, y r17, SharePermissionViewModel r18, com.bytedance.ee.bear.middleground.comment.card.d r19, String r20, Function1<? super Integer, Unit> r21, Function0<Unit> r22) {
        Intrinsics.checkNotNullParameter(r14, "config");
        Intrinsics.checkNotNullParameter(r15, "userIds");
        Intrinsics.checkNotNullParameter(r16, "commentListeners");
        Intrinsics.checkNotNullParameter(r17, "actionControl");
        Intrinsics.checkNotNullParameter(r19, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r20, "language");
        Intrinsics.checkNotNullParameter(r21, "avoidKeyboard");
        super(r14, r15, r16, r17, r18, r19, r20, r22);
        this.commentListeners = r16;
        this.actionControl = r17;
        this.avoidKeyboard = r21;
    }
}
