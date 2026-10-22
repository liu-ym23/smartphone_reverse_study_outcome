package com.ss.android.lark.vote.message.cell;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.android.ttcjpaysdk.base.h5.jsb.JSBMediaUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.vote.v1.VoteStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.message.params.n;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewKtKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vote.message.content.VoteContent;
import com.ss.android.lark.vote.message.content.VoteOption;
import com.ss.android.lark.vote.message.entity.VoteContentVO;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VoteMessageCell implements r5b.d<VoteContentVO>, u5b.a<VoteContentVO> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f445151h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5b.a f445152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f445153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VoteMessageViewHolder f445154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f445155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f445156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f445157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f445158g;

    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020HJ\b\u0010N\u001a\u00020HH\u0002J\u0018\u0010O\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010P\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010Q\u001a\u00020R2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010S\u001a\u00020R2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010T\u001a\u00020R2\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010U\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010V\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010W\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010X\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010Y\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010Z\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010[\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010\\\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^H\u0002J.\u0010`\u001a\u00020H2\u0006\u0010a\u001a\u00020b2\u0006\u0010I\u001a\u00020J2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020e0d2\u0006\u0010_\u001a\u00020^H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001e\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020\u00038\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR\u001e\u0010>\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR\u001e\u0010A\u001a\u00020B8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006f"}, d2 = {"Lcom/ss/android/lark/vote/message/cell/VoteMessageCell$VoteMessageViewHolder;", "", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/vote/message/cell/VoteMessageCell;Landroid/view/View;)V", "mTitleTv", "Landroid/widget/TextView;", "getMTitleTv", "()Landroid/widget/TextView;", "setMTitleTv", "(Landroid/widget/TextView;)V", "mVoteIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getMVoteIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "setMVoteIcon", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "mOptionsRv", "Landroidx/recyclerview/widget/RecyclerView;", "getMOptionsRv", "()Landroidx/recyclerview/widget/RecyclerView;", "setMOptionsRv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mNumberOfParticipantsTv", "getMNumberOfParticipantsTv", "setMNumberOfParticipantsTv", "mActualParticipantNumberTv", "getMActualParticipantNumberTv", "setMActualParticipantNumberTv", "participantNumberLayout", "Landroid/widget/LinearLayout;", "getParticipantNumberLayout", "()Landroid/widget/LinearLayout;", "setParticipantNumberLayout", "(Landroid/widget/LinearLayout;)V", "mActionBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "getMActionBtn", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setMActionBtn", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "mItemShowMore", "getMItemShowMore", "()Landroid/view/View;", "setMItemShowMore", "(Landroid/view/View;)V", "mItemShowMoreTv", "Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "getMItemShowMoreTv", "()Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;", "setMItemShowMoreTv", "(Lcom/larksuite/component/universe_design/shadow/UDShadowLayout;)V", "mVoteCellMessageLayout", "Lcom/ss/android/lark/vote/message/cell/MaxHeightConstrainLayout;", "getMVoteCellMessageLayout", "()Lcom/ss/android/lark/vote/message/cell/MaxHeightConstrainLayout;", "setMVoteCellMessageLayout", "(Lcom/ss/android/lark/vote/message/cell/MaxHeightConstrainLayout;)V", "mCloseVoteBtn", "getMCloseVoteBtn", "setMCloseVoteBtn", "mRetransmitBtn", "getMRetransmitBtn", "setMRetransmitBtn", "mBottomOperateContainer", "Landroid/view/ViewGroup;", "getMBottomOperateContainer", "()Landroid/view/ViewGroup;", "setMBottomOperateContainer", "(Landroid/view/ViewGroup;)V", "onBind", "", "voteContent", "Lcom/ss/android/lark/vote/message/content/VoteContent;", "chatId", "", "onRecycle", "initDisplaySize", "bindActionBtn", "bindVoteIcon", "shouldShowActionBtn", "", "isVoteClose", "isInitiator", "bindRetransmit", "bindExpectVoteNum", "bindActualVoteNum", "bindTitleTags", "bindVoteIsFinished", "bindBtnPosition", "bindShowMore", "bindVoteOption", "calculateMaxAvatarNum", "", "cellWidth", "setOptionAdapter", "adapter", "Lcom/ss/android/lark/vote/message/cell/VoteOptionsAdapter;", "voteOptionList", "", "Lcom/ss/android/lark/vote/message/content/VoteOption;", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class VoteMessageViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoteMessageCell f445159a;

        @BindView(8877)
        public UDButton mActionBtn;

        @BindView(8891)
        public TextView mActualParticipantNumberTv;

        @BindView(8980)
        public ViewGroup mBottomOperateContainer;

        @BindView(9040)
        public TextView mCloseVoteBtn;

        @BindView(9336)
        public View mItemShowMore;

        @BindView(9337)
        public UDShadowLayout mItemShowMoreTv;

        @BindView(9605)
        public TextView mNumberOfParticipantsTv;

        @BindView(9608)
        public RecyclerView mOptionsRv;

        @BindView(9724)
        public TextView mRetransmitBtn;

        @BindView(JSBMediaUtil.TT_CJ_PAY_CHOOSE_MEDIA_FROM_ALBUM)
        public TextView mTitleTv;

        @BindView(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_LOUDNESS_STRATEGY_3_LOWER_LIMIT_LEVEL)
        public MaxHeightConstrainLayout mVoteCellMessageLayout;

        @BindView(10124)
        public AppCompatImageView mVoteIcon;

        @BindView(9621)
        public LinearLayout participantNumberLayout;

        public final UDButton b() {
            UDButton r100 = this.mActionBtn;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mActionBtn");
            return null;
        }

        public final TextView c() {
            TextView r100 = this.mActualParticipantNumberTv;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mActualParticipantNumberTv");
            return null;
        }

        public final TextView d() {
            TextView r100 = this.mCloseVoteBtn;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mCloseVoteBtn");
            return null;
        }

        public final TextView e() {
            TextView r100 = this.mNumberOfParticipantsTv;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mNumberOfParticipantsTv");
            return null;
        }

        public final RecyclerView f() {
            RecyclerView r100 = this.mOptionsRv;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mOptionsRv");
            return null;
        }

        public final TextView g() {
            TextView r100 = this.mRetransmitBtn;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mRetransmitBtn");
            return null;
        }

        public final TextView h() {
            TextView r100 = this.mTitleTv;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mTitleTv");
            return null;
        }

        public final MaxHeightConstrainLayout i() {
            MaxHeightConstrainLayout r100 = this.mVoteCellMessageLayout;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mVoteCellMessageLayout");
            return null;
        }

        public static boolean j(VoteContent r100) {
            return Intrinsics.areEqual(((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d(), String.valueOf(r100.getInitiator()));
        }

        public static boolean k(VoteContent r100) {
            if (r100.getStatus() != VoteStatus.CLOSE) goto L5;
            return true;
        L5:
            return false;
        }

        public final int a(int r100) {
            float r101 = r100;
            View r102 = this.f445159a.f445157f;
            View r103 = null;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            r102 = null;
        L5:
            float r104 = r101 - j08.b.a(r102.getContext(), 24.0f);
            View r105 = this.f445159a.f445157f;
            if (r105 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            r105 = null;
        L8:
            float r106 = r104 + j08.b.a(r105.getContext(), 7.0f);
            View r107 = this.f445159a.f445157f;
            if (r107 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        L13:
            return (int) (r106 / j08.b.a(r103.getContext(), 31.0f));
        L11:
            r103 = r107;
            goto L13
        }

        public final boolean m(VoteContent r100) {
            if (this.f445159a.f445155d == false) goto L8;
            if (r100.getStatus() != VoteStatus.OPEN) goto L8;
            return false;
        L8:
            if (j(r100) == false) goto L16;
            if (r100.isVoted() == true) goto L12;
        L13:
            return true;
        L12:
            if (k(r100) == true) goto L13;
            return false;
        L16:
            if (k(r100) == false) goto L19;
            return false;
        L19:
            return !r100.isVoted();
        }

        public VoteMessageViewHolder(VoteMessageCell r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f445159a = r100;
            ButterKnife.bind(this, r101);
            zz7.a.d(h(), LarkFont.HEADLINE);
            TextView r102 = e();
            LarkFont r103 = LarkFont.CAPTION0;
            zz7.a.d(r102, r103);
            zz7.a.d(c(), r103);
            zz7.a.d(b(), LarkFont.BODY0);
            AppCompatImageView r104 = this.mVoteIcon;
            UDShadowLayout r105 = null;
            if (r104 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mVoteIcon");
            r104 = null;
        L6:
            zz7.a.a(r104, 16);
            ViewGroup.LayoutParams r106 = b().getLayoutParams();
            r106.height = zz7.b.g(b().getContext(), 32);
            b().setLayoutParams(r106);
            MaxHeightConstrainLayout r107 = i();
            View[] r108 = new View[2];
            View r109 = this.mItemShowMore;
            if (r109 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mItemShowMore");
            r109 = null;
        L10:
            r108[0] = r109;
            UDShadowLayout r110 = this.mItemShowMoreTv;
            if (r110 == null) goto L13;
            r105 = r110;
        L14:
            r108[1] = r105;
            r107.f445148a = CollectionsKt.listOf(r108);
            i().f445149b = CollectionsKt.listOf(new TextView[]{e(), c(), d(), g(), b()});
            return;
        L13:
            Intrinsics.throwUninitializedPropertyAccessException("mItemShowMoreTv");
            goto L14
        }

        public final void l(final VoteContent r110, final String r111) {
            Intrinsics.checkNotNullParameter(r110, "voteContent");
            Intrinsics.checkNotNullParameter(r111, "chatId");
            View r100 = this.mItemShowMore;
            AppCompatImageView r101 = null;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mItemShowMore");
            r100 = null;
        L6:
            int r102 = 8;
            r100.setVisibility(8);
            UDShadowLayout r103 = this.mItemShowMoreTv;
            if (r103 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mItemShowMoreTv");
            r103 = null;
        L10:
            r103.setVisibility(8);
            UDShadowLayout r104 = this.mItemShowMoreTv;
            if (r104 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mItemShowMoreTv");
            r104 = null;
        L14:
            r104.setOnClickListener(new d(this, r110, this.f445159a));
            TextView r105 = d();
            final VoteMessageCell r106 = this.f445159a;
            r105.setOnClickListener(new VoteMessageCell$VoteMessageViewHolder$bindVoteIsFinished$1(this, r110, r106));
            h().setText(r110.getTopic());
            h().setTextColor(UIHelper.getColor(R.color.text_title));
            UDTagsDrawable.d.a r107 = new UDTagsDrawable.d.a(h().getContext());
            StringBuilder r108 = new StringBuilder();
            if (r110.getMaxPickNum() <= 1) goto L17;
            r108.append(UIHelper.getString(R.string.Lark_IM_Poll_Detail_MultipleAnswers_Label));
        L18:
            r107.f285353c = r108.toString();
            r107.f285354d = UIHelper.getColor(R.color.udtoken_tag_text_s_indigo);
            r107.a(UIHelper.getColor(R.color.udtoken_tag_bg_indigo));
            SpannableStringBuilder r109 = new SpannableStringBuilder(r108);
            UDTagsDrawable.a r112 = new UDTagsDrawable.a(h().getContext());
            r112.a(r107.b());
            r112.f285330d = UIHelper.dp2px(16.0f);
            UDTagsDrawable r113 = r112.b();
            if (r113 == null) goto L21;
            r109.setSpan(new com.ss.android.lark.vote.message.cell.a(r113), 0, r109.length(), 33);
        L21:
            UDTagsDrawable.d.a r114 = new UDTagsDrawable.d.a(h().getContext());
            StringBuilder r115 = new StringBuilder();
            if (r110.getRealName() == false) goto L24;
            r115.append(UIHelper.getString(R.string.Lark_IM_Poll_Detail_NonAnonymous_Label));
        L25:
            r114.f285353c = r115.toString();
            r114.f285354d = UIHelper.getColor(R.color.udtoken_tag_text_s_indigo);
            r114.a(UIHelper.getColor(R.color.udtoken_tag_bg_indigo));
            SpannableStringBuilder r116 = new SpannableStringBuilder(r115);
            UDTagsDrawable.a r117 = new UDTagsDrawable.a(h().getContext());
            r117.a(r114.b());
            r117.f285330d = UIHelper.dp2px(16.0f);
            UDTagsDrawable r118 = r117.b();
            if (r118 == null) goto L28;
            r116.setSpan(new com.ss.android.lark.vote.message.cell.a(r118), 0, r116.length(), 33);
        L28:
            h().setText(new SpannableStringBuilder(r110.getTopic()).append(tb2.c.DEFAULT_TEXT).append(r109).append(tb2.c.DEFAULT_TEXT).append(r116).append(" "));
            TextView r119 = g();
            final VoteMessageCell r120 = this.f445159a;
            r119.setOnClickListener(new VoteMessageCell$VoteMessageViewHolder$bindRetransmit$1(this, r110, r120));
            Log.i("VoteMessageCell", "expectVoteNum: " + r110.getExpectVoteNum() + ", actualVoteNum: " + r110.getActualVoteNum());
            LinearLayout r121 = this.participantNumberLayout;
            if (r121 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("participantNumberLayout");
            r121 = null;
        L33:
            if (r110.isVoted() == false) goto L35;
        L40:
            boolean r122 = true;
        L41:
            if (r122 == false) goto L43;
            int r123 = 0;
        L44:
            r121.setVisibility(r123);
            TextView r124 = e();
            if (r110.isVoted() == false) goto L47;
        L52:
            boolean r125 = true;
        L53:
            if (r125 == false) goto L55;
            int r126 = 0;
        L56:
            r124.setVisibility(r126);
            e().setText(UIHelper.mustacheFormat(R.string.Lark_IM_Poll_Result_ExpectedParticipants_Text, "num", String.valueOf(r110.getExpectVoteNum())));
            TextView r127 = c();
            if (r110.isVoted() == false) goto L59;
        L64:
            boolean r128 = true;
        L65:
            if (r128 == false) goto L67;
            int r129 = 0;
        L68:
            r127.setVisibility(r129);
            LinearLayout r130 = this.participantNumberLayout;
            if (r130 != null) goto L73;
            Intrinsics.throwUninitializedPropertyAccessException("participantNumberLayout");
            r130 = null;
        L73:
            if (r110.isVoted() == false) goto L75;
        L80:
            boolean r131 = true;
        L81:
            if (r131 == false) goto L83;
            int r132 = 0;
        L84:
            r130.setVisibility(r132);
            c().setText(UIHelper.mustacheFormat(R.string.Lark_IM_Poll_Result_ActualParticipants_Text, "num", String.valueOf(r110.getActualVoteNum())));
            List<VoteOption> r133 = r110.getOptions();
            Log.i("VoteMessageCell", "vote_option_size: " + r133.size());
            VoteContent r134 = (VoteContent) ((Map) this.f445159a.f445156e.getValue()).get(String.valueOf(r110.getVoteId()));
            if (r110.isVoted() == true) goto L97;
            Log.i("VoteMessageCell", "restore old selected info, option_list_size: " + r133.size());
            if (r134 == null) goto L97;
            List<VoteOption> r135 = r134.getOptions();
            if (r135 == null) goto L97;
            Iterator<T> r136 = r135.iterator();
            int r137 = 0;
        L92:
            if (r136.hasNext() == false) goto L97;
            Object r138 = r136.next();
            int r139 = r137 + 1;
            if (r137 >= 0) goto L96;
            CollectionsKt.throwIndexOverflow();
        L96:
            ((VoteOption) ListProtector.get(r133, r137)).setSelected(((VoteOption) r138).isSelected());
            r137 = r139;
        L97:
            ((Map) this.f445159a.f445156e.getValue()).put(String.valueOf(r110.getVoteId()), r110);
            List<VoteOption> r140 = r133;
            if (CollectionUtils.isEmpty(r140) == true) goto L121;
            f().setVisibility(0);
            if (f().getAdapter() != null) goto L103;
            VoteOptionsAdapter r141 = new VoteOptionsAdapter();
            f().setAdapter(r141);
        L104:
            f().setLayoutManager(new LinearLayoutManager(this.f445159a.f445152a.getContext(), 1, false));
            int r142 = i().getMeasuredWidth();
            if (r142 <= 0) goto L109;
            VoteMessageCell r143 = this.f445159a;
            if (r142 == r143.f445158g) goto L109;
            r143.f445158g = r142;
        L109:
            int r144 = this.f445159a.f445158g;
            Log.i("VoteMessageCell", "set_adapter_cell_width: " + r144);
            if (r144 == (-1)) goto L112;
            r141.f445194g = a(r144);
        L112:
            r141.f445198k = this.f445159a.f445155d;
            r110.getMinPickNum();
            r141.f445189b = r110.getMaxPickNum();
            FragmentActivity r145 = this.f445159a.f445152a.getContext();
            Intrinsics.checkNotNullParameter(r145, PerfLog.PARAM_KEY_CONTEXT_ID);
            r141.f445188a = r145;
            n r146 = (n) this.f445159a.f445152a.d0(n.class);
            if (r146 != null) goto L115;
        L117:
            boolean r147 = false;
        L118:
            r141.f445196i = r147;
            r141.f445190c = r110.getVoteId();
            r141.f445195h = r110.getTopic();
            String r148 = this.f445159a.f445153b;
            Intrinsics.checkNotNullParameter(r148, "chatId");
            r141.f445191d = r148;
            r141.f445192e = r110.getRealName();
            r141.f445193f = r110.getInitiator();
            r141.diff(r140);
            VoteMessageCell r149 = this.f445159a;
            r149.getClass();
            r141.f445197j.removeObservers(r149.f445152a.getContext());
            r141.f445197j.observe(this.f445159a.f445152a.getContext(), new f(r110, this));
            if (r142 > 0) goto L121;
            ViewKtKt.a(i(), new e(this, this.f445159a, r141));
            goto L121
        L115:
            if (r146.f410371a != true) goto L117;
            r147 = true;
            goto L118
        L103:
            RecyclerView.Adapter r150 = f().getAdapter();
            Intrinsics.checkNotNull(r150, "null cannot be cast to non-null type com.ss.android.lark.vote.message.cell.VoteOptionsAdapter");
            r141 = (VoteOptionsAdapter) r150;
        L121:
            d().setVisibility(8);
            g().setVisibility(8);
            if (m(r110) == false) goto L124;
            d().setVisibility(8);
            g().setVisibility(8);
        L143:
            ViewGroup r151 = this.mBottomOperateContainer;
            if (r151 != null) goto L148;
            Intrinsics.throwUninitializedPropertyAccessException("mBottomOperateContainer");
            r151 = null;
        L148:
            if (d().getVisibility() != 0) goto L150;
            boolean r152 = true;
        L151:
            if (r152 == false) goto L153;
        L159:
            boolean r153 = true;
        L160:
            if (r153 == false) goto L162;
            int r154 = 0;
        L163:
            r151.setVisibility(r154);
            UDButton r155 = b();
            if (m(r110) == false) goto L166;
            r102 = 0;
        L166:
            r155.setVisibility(r102);
            if (m(r110) == false) goto L173;
            b().setTextColor(UIHelper.getColor(R.color.text_disable));
            if (r110.getStatus() != VoteStatus.OPEN) goto L171;
            b().setText(UIHelper.getString(R.string.Lark_IM_Poll_Detail_SelectAndVote_Button));
            b().setEnabled(true);
        L172:
            UDButton r156 = b();
            final VoteMessageCell r157 = this.f445159a;
            r156.setOnClickListener(new VoteMessageCell$VoteMessageViewHolder$bindActionBtn$1(r157, this, r110, r111));
            goto L173
        L171:
            b().setText(UIHelper.getString(R.string.Lark_IM_Poll_Result_PollEnded_Button));
            ViewGroup.LayoutParams r158 = b().getLayoutParams();
            Intrinsics.checkNotNull(r158, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r159 = (ConstraintLayout.LayoutParams) r158;
            ((ViewGroup.MarginLayoutParams) r159).topMargin = UIHelper.dp2px(16.0f);
            b().setLayoutParams(r159);
            b().setEnabled(false);
        L173:
            AppCompatImageView r160 = this.mVoteIcon;
            if (r160 != null) goto L177;
            Intrinsics.throwUninitializedPropertyAccessException("mVoteIcon");
            r160 = null;
        L177:
            AppCompatImageView r161 = this.mVoteIcon;
            if (r161 == null) goto L180;
            r101 = r161;
        L181:
            r160.setImageTintList(AppCompatResources.getColorStateList(r101.getContext(), R.color.udtoken_message_card_text_indigo));
            return;
        L180:
            Intrinsics.throwUninitializedPropertyAccessException("mVoteIcon");
            goto L181
        L162:
            r154 = 8;
            goto L163
        L153:
            if (g().getVisibility() != 0) goto L155;
            boolean r162 = true;
        L156:
            if (r162 == true) goto L159;
            r153 = false;
            goto L160
        L155:
            r162 = false;
            goto L156
        L150:
            r152 = false;
            goto L151
        L124:
            TextView r163 = d();
            if (j(r110) == true) goto L127;
        L129:
            boolean r164 = false;
        L130:
            if (r164 == false) goto L132;
            int r165 = 0;
        L133:
            r163.setVisibility(r165);
            TextView r166 = g();
            if (j(r110) == true) goto L136;
        L138:
            boolean r167 = false;
        L139:
            if (r167 == false) goto L141;
            int r168 = 0;
        L142:
            r166.setVisibility(r168);
            goto L143
        L141:
            r168 = 8;
            goto L142
        L136:
            if (k(r110) == true) goto L138;
            r167 = true;
            goto L139
        L132:
            r165 = 8;
            goto L133
        L127:
            if (k(r110) == true) goto L129;
            r164 = true;
            goto L130
        L83:
            r132 = 8;
            goto L84
        L75:
            if (this.f445159a.f445155d == true) goto L80;
            if (r110.getStatus() == VoteStatus.CLOSE) goto L80;
            r131 = false;
            goto L81
        L67:
            r129 = 8;
            goto L68
        L59:
            if (this.f445159a.f445155d == true) goto L64;
            if (r110.getStatus() == VoteStatus.CLOSE) goto L64;
            r128 = false;
            goto L65
        L55:
            r126 = 8;
            goto L56
        L47:
            if (this.f445159a.f445155d == true) goto L52;
            if (r110.getStatus() == VoteStatus.CLOSE) goto L52;
            r125 = false;
            goto L53
        L43:
            r123 = 8;
            goto L44
        L35:
            if (this.f445159a.f445155d == true) goto L40;
            if (r110.getStatus() == VoteStatus.CLOSE) goto L40;
            r122 = false;
            goto L41
        L24:
            r115.append(UIHelper.getString(R.string.Lark_IM_Poll_Detail_Anonymous_Label));
            goto L25
        L17:
            r108.append(UIHelper.getString(R.string.Lark_IM_Poll_Detail_SingleAnswer_Label));
            goto L18
        }
    }

    public final class VoteMessageViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VoteMessageViewHolder f445187a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            VoteMessageViewHolder r100 = this.f445187a;
            if (r100 == null) goto L7;
            this.f445187a = null;
            r100.mTitleTv = null;
            r100.mVoteIcon = null;
            r100.mOptionsRv = null;
            r100.mNumberOfParticipantsTv = null;
            r100.mActualParticipantNumberTv = null;
            r100.participantNumberLayout = null;
            r100.mActionBtn = null;
            r100.mItemShowMore = null;
            r100.mItemShowMoreTv = null;
            r100.mVoteCellMessageLayout = null;
            r100.mCloseVoteBtn = null;
            r100.mRetransmitBtn = null;
            r100.mBottomOperateContainer = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public VoteMessageViewHolder_ViewBinding(VoteMessageViewHolder r100, View r101) {
            this.f445187a = r100;
            r100.mTitleTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.title_tv, "field 'mTitleTv'", TextView.class);
            r100.mVoteIcon = (AppCompatImageView) Utils.findRequiredViewAsType(r101, R.id.vote_icon, "field 'mVoteIcon'", AppCompatImageView.class);
            r100.mOptionsRv = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.options_rv, "field 'mOptionsRv'", RecyclerView.class);
            r100.mNumberOfParticipantsTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.number_of_participants_tv, "field 'mNumberOfParticipantsTv'", TextView.class);
            r100.mActualParticipantNumberTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.actual_participant_number_tv, "field 'mActualParticipantNumberTv'", TextView.class);
            r100.participantNumberLayout = (LinearLayout) Utils.findRequiredViewAsType(r101, R.id.participant_number_layout, "field 'participantNumberLayout'", LinearLayout.class);
            r100.mActionBtn = (UDButton) Utils.findRequiredViewAsType(r101, R.id.action_btn, "field 'mActionBtn'", UDButton.class);
            r100.mItemShowMore = Utils.findRequiredView(r101, R.id.item_show_more, "field 'mItemShowMore'");
            r100.mItemShowMoreTv = (UDShadowLayout) Utils.findRequiredViewAsType(r101, R.id.item_show_more_text, "field 'mItemShowMoreTv'", UDShadowLayout.class);
            r100.mVoteCellMessageLayout = (MaxHeightConstrainLayout) Utils.findRequiredViewAsType(r101, R.id.vote_cell_message, "field 'mVoteCellMessageLayout'", MaxHeightConstrainLayout.class);
            r100.mCloseVoteBtn = (TextView) Utils.findRequiredViewAsType(r101, R.id.close_vote, "field 'mCloseVoteBtn'", TextView.class);
            r100.mRetransmitBtn = (TextView) Utils.findRequiredViewAsType(r101, R.id.retransmit_vote, "field 'mRetransmitBtn'", TextView.class);
            r100.mBottomOperateContainer = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.bottom_operate_container, "field 'mBottomOperateContainer'", ViewGroup.class);
        }
    }

    public static final class a {
    }

    @Override // u5b.a
    public final u5b.c i(v5b.c<VoteContentVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageVO");
        return null;
    }

    static {
        f445151h = UIHelper.dp2px(12.0f);
        UIHelper.dp2px(4.0f);
    }

    @Override // r5b.d
    public final Class<VoteContentVO> c() {
        return VoteContentVO.class;
    }

    public VoteMessageCell(r5b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "messageContext");
        this.f445152a = r100;
        this.f445153b = "";
        this.f445156e = LazyKt.lazy(VoteMessageCell$oldVoteContentMap$2.INSTANCE);
        this.f445158g = -1;
    }

    @Override // r5b.d
    public final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Object r101 = r100.getTag();
        if ((r101 instanceof VoteMessageViewHolder) == false) goto L8;
        VoteMessageViewHolder r102 = (VoteMessageViewHolder) r101;
        RecyclerView.Adapter r103 = r102.f().getAdapter();
        if ((r103 instanceof VoteOptionsAdapter) == false) goto L9;
        VoteMessageCell r104 = r102.f445159a;
        r104.getClass();
        ((VoteOptionsAdapter) r103).f445197j.removeObservers(r104.f445152a.getContext());
        return;
    L9:
        return;
    }

    @Override // r5b.d
    public final View a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        View r102 = r100.inflate(R.layout.lark_vote_card_content_item_layout, r101, false);
        this.f445157f = r102;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L6:
        return r102;
    }

    @Override // u5b.a
    public final BubbleStyle d(v5b.c<VoteContentVO> r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "messageVO");
        Intrinsics.checkNotNullParameter(r101, "bubbleView");
        BubbleStyle.a(2, r101.findViewById(R.id.title_layout), new int[]{0, 0, 0, f445151h});
        return BubbleStyle.f415420h;
    }

    @Override // r5b.d
    public final void e(View r110, int r111, v5b.c<VoteContentVO> r112) {
        Intrinsics.checkNotNullParameter(r110, "itemView");
        Intrinsics.checkNotNullParameter(r112, "message");
        int r113 = s5b.a.f540770a;
        Chatter.ChatterType r100 = null;
        if (r110 == null) goto L5;
        r110.setTag(R.id.chat_message_mask_region_provider, null);
    L5:
        int r101 = t5b.a.f544650a;
        if (r110 == null) goto L9;
        r110.setTag(R.id.chat_message_render_ready_provider, null);
    L9:
        if (((VoteContentVO) r112.b()) != null) goto L11;
        return;
    L11:
        Object r102 = mbc.a.f512860a;
        if (r110 == null) goto L14;
        r110.setTag(R.id.chat_message_mask_region_provider, r102);
    L14:
        VoteContent r114 = (VoteContent) ((VoteContentVO) r112.b()).f553338a;
        this.f445153b = r112.getChatId();
        boolean r103 = false;
        if (this.f445152a.d() == false) goto L22;
        y6b.b r115 = r112.a();
        if (r115 == null) goto L20;
        r100 = r115.f566461j;
    L20:
        if (r100 != Chatter.ChatterType.BOT) goto L22;
        boolean r116 = true;
    L23:
        this.f445155d = r116;
        n r117 = (n) this.f445152a.d0(n.class);
        if (r117 != null) goto L26;
    L28:
        boolean r118 = false;
    L29:
        if (r118 == false) goto L61;
        List<VoteOption> r119 = r114.getOptions();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator<T> r120 = r119.iterator();
    L32:
        if (r120.hasNext() == false) goto L45;
        VoteOption r105 = (VoteOption) r120.next();
        if (r114.getRealName() == true) goto L36;
    L42:
        int r106 = 0;
    L43:
        r104.add(Integer.valueOf(r106));
        goto L32
    L36:
        if (r105.isEnable() == false) goto L40;
        if (this.f445155d == false) goto L42;
    L40:
        if (r105.getSelectedNum() <= 0) goto L42;
        r106 = r105.getUsers().size();
        goto L43
    L45:
        if (r104.isEmpty() == true) goto L56;
        Iterator r121 = r104.iterator();
    L49:
        if (r121.hasNext() == false) goto L56;
        if (((Number) r121.next()).intValue() <= 0) goto L53;
        boolean r107 = true;
    L54:
        if (r107 == false) goto L49;
        r103 = true;
        goto L56
    L53:
        r107 = false;
    L56:
        if (r103 == false) goto L61;
        Object r122 = new nbc.b(r104);
        if (r110 == null) goto L61;
        r110.setTag(R.id.chat_message_render_ready_provider, r122);
    L61:
        if (r110.getTag() != null) goto L63;
        VoteMessageViewHolder r123 = new VoteMessageViewHolder(this, r110);
        this.f445154c = r123;
        r110.setTag(r123);
        VoteMessageViewHolder r124 = this.f445154c;
        Intrinsics.checkNotNull(r124);
        r124.l(r114, this.f445153b);
        return;
    L63:
        Object r125 = r110.getTag();
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type com.ss.android.lark.vote.message.cell.VoteMessageCell.VoteMessageViewHolder");
        this.f445154c = (VoteMessageViewHolder) r125;
        Object r126 = r110.getTag();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type com.ss.android.lark.vote.message.cell.VoteMessageCell.VoteMessageViewHolder");
        ((VoteMessageViewHolder) r126).l(r114, this.f445153b);
        return;
    L26:
        if (r117.f410371a != true) goto L28;
        r118 = true;
    L22:
        r116 = false;
        goto L23
    }
}
