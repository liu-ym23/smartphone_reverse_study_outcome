package com.ss.android.lark.vote.message.cell;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vote.message.content.VoteOption;
import com.ss.android.lark.vote.message.content.VoteUser;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ?2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002?@B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\tJ\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u000fJ\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0002J\u001e\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0012H\u0002J\u000e\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\tJ\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\t02J\u0010\u0010;\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\rJ\u000e\u0010<\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010=\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/ss/android/lark/vote/message/cell/VoteOptionsAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/vote/message/cell/VoteOptionsAdapter$ViewHolder;", "Lcom/ss/android/lark/vote/message/content/VoteOption;", "<init>", "()V", "mContext", "Landroid/content/Context;", "mMinPickNum", "", "mMaxPickNum", "voteId", "chatId", "", "isRealName", "", "voteInitiator", "maxAvatarNum", "", "voteTopic", "renderReadyTrackingEnabled", "isSelectedOption", "Landroidx/lifecycle/MutableLiveData;", "isSingleBot", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "setChatId", "setIsRealName", "setMinPickNum", "minPickNum", "setMaxAvatarNum", "setContext", PerfLog.PARAM_KEY_CONTEXT_ID, "setInitiator", "initiator", "setIsSingleBot", "setRenderReadyTrackingEnabled", "enabled", "createAvatarView", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "createNumberView", "Landroid/widget/TextView;", "addVoterView", "userList", "", "Lcom/ss/android/lark/vote/message/content/VoteUser;", "createEllipsizeView", "Landroid/view/View;", "userNum", "setMaxPickNum", "maxPickNum", "getNumOfSelectedOptionLiveData", "getSelectedItem", "setVoteTopic", "setVoteId", "getItemId", "setItemDisplaySize", "Companion", "ViewHolder", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoteOptionsAdapter extends LarkRecyclerViewBaseAdapter<ViewHolder, VoteOption> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f445188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f445189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f445190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f445191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f445192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f445193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f445194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f445195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f445196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Boolean> f445197j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f445198k;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0005R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/ss/android/lark/vote/message/cell/VoteOptionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mContentTv", "Landroid/widget/TextView;", "getMContentTv", "()Landroid/widget/TextView;", "setMContentTv", "(Landroid/widget/TextView;)V", "mPollTv", "getMPollTv", "setMPollTv", "mProgressBar", "Landroid/widget/ProgressBar;", "getMProgressBar", "()Landroid/widget/ProgressBar;", "setMProgressBar", "(Landroid/widget/ProgressBar;)V", "mVoteResultLayout", "getMVoteResultLayout", "()Landroid/view/View;", "setMVoteResultLayout", "mVoterListLayout", "Landroid/widget/LinearLayout;", "getMVoterListLayout", "()Landroid/widget/LinearLayout;", "setMVoterListLayout", "(Landroid/widget/LinearLayout;)V", "mCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getMCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setMCheckBox", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(DataLoaderHelper.DATALOADER_KEY_INT_DISABLE_FILEPATH_CHECK)
        public UDCheckBox mCheckBox;

        @BindView(9081)
        public TextView mContentTv;

        @BindView(9667)
        public TextView mPollTv;

        @BindView(9695)
        public ProgressBar mProgressBar;

        @BindView(10131)
        public View mVoteResultLayout;

        @BindView(10136)
        public LinearLayout mVoterListLayout;

        public final UDCheckBox T3() {
            UDCheckBox r100 = this.mCheckBox;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
            return null;
        }

        public final TextView U3() {
            TextView r100 = this.mContentTv;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mContentTv");
            return null;
        }

        public final LinearLayout V3() {
            LinearLayout r100 = this.mVoterListLayout;
            if (r100 == null) goto L5;
            return r100;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("mVoterListLayout");
            return null;
        }

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public final class ViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewHolder f445199a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            ViewHolder r100 = this.f445199a;
            if (r100 == null) goto L7;
            this.f445199a = null;
            r100.mContentTv = null;
            r100.mPollTv = null;
            r100.mProgressBar = null;
            r100.mVoteResultLayout = null;
            r100.mVoterListLayout = null;
            r100.mCheckBox = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public ViewHolder_ViewBinding(ViewHolder r100, View r101) {
            this.f445199a = r100;
            r100.mContentTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.content_tv, "field 'mContentTv'", TextView.class);
            r100.mPollTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.poll_tv, "field 'mPollTv'", TextView.class);
            r100.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(r101, R.id.progressbar, "field 'mProgressBar'", ProgressBar.class);
            r100.mVoteResultLayout = Utils.findRequiredView(r101, R.id.vote_result_layout, "field 'mVoteResultLayout'");
            r100.mVoterListLayout = (LinearLayout) Utils.findRequiredViewAsType(r101, R.id.voter_list, "field 'mVoterListLayout'", LinearLayout.class);
            r100.mCheckBox = (UDCheckBox) Utils.findRequiredViewAsType(r101, R.id.checkbox, "field 'mCheckBox'", UDCheckBox.class);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    public final List<Long> A2() {
        Iterable r100 = this.items;
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (((VoteOption) r103).isSelected() == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(Long.valueOf(((VoteOption) r105.next()).getOptionIndex()));
        goto L10
    L12:
        return r104;
    }

    public final LKUIRoundedImageView2 z2() {
        int r100 = (int) j08.d.a(this.f445188a, 24.0f);
        Context r101 = this.f445188a;
        Intrinsics.checkNotNull(r101);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(r100, (int) j08.d.a(r101, 24.0f));
        r102.rightMargin = UIHelper.dp2px(7.0f);
        r102.topMargin = UIHelper.dp2px(8.0f);
        Context r103 = this.f445188a;
        Intrinsics.checkNotNull(r103);
        LKUIRoundedImageView2 r104 = new LKUIRoundedImageView2(r103, null, 0, 6, null);
        r104.setBackgroundColor(UIHelper.getColor(R.color.udtoken_message_card_bg_light_neutral));
        r104.setLayoutParams(new ViewGroup.MarginLayoutParams(r102));
        r104.setOval(true);
        return r104;
    }

    public VoteOptionsAdapter() {
        this.f445191d = "";
        this.f445197j = new MutableLiveData(Boolean.FALSE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r100 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r100, "holder");
        VoteOption r101 = (VoteOption) getItem(r111);
        this.f445197j.setValue(Boolean.valueOf(!((ArrayList) A2()).isEmpty()));
        if (r101.isEnable() == false) goto L5;
    L11:
        r100.U3().setTypeface(null, 0);
        r100.U3().setTextColor(UIUtils.getColor(this.f445188a, R.color.text_title));
        TextView r102 = r100.mPollTv;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mPollTv");
        r102 = null;
    L15:
        r102.setTextColor(UIUtils.getColor(this.f445188a, R.color.text_title));
    L16:
        zz7.a.d(r100.U3(), LarkFont.BODY2);
        if (this.f445189b != 1) goto L19;
        r100.T3().setType(UDCheckBox.CheckBoxType.RADIO);
    L20:
        UDCheckBox r103 = r100.T3();
        if (this.f445198k == false) goto L23;
        boolean r104 = false;
    L25:
        if (r104 == false) goto L27;
        int r105 = 0;
    L28:
        r103.setVisibility(r105);
        r100.U3().setText(r101.getContent());
        LinearLayout r106 = r100.V3();
        if (this.f445192e == true) goto L31;
    L37:
        boolean r107 = false;
    L38:
        if (r107 == false) goto L40;
        int r108 = 0;
    L41:
        r106.setVisibility(r108);
        r100.V3().removeAllViews();
        ArrayList<VoteUser> r109 = r101.getUsers();
        if (this.f445194g > 0) goto L44;
    L53:
        Log.i("VoteOptionsAdapter", "position: " + r111 + ", is_real_name: " + this.f445192e + ", vote_option_enable: " + r101.isEnable() + " max_avatar: " + this.f445194g);
        r100.V3().setOnClickListener(new h(this, r101));
        View r112 = r100.mVoteResultLayout;
        if (r112 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mVoteResultLayout");
        r112 = null;
    L58:
        if (r101.isEnable() == true) goto L60;
    L63:
        boolean r113 = true;
    L64:
        if (r113 == false) goto L66;
        int r114 = 0;
    L67:
        r112.setVisibility(r114);
        if (r101.isEnable() == true) goto L70;
    L77:
        ProgressBar r115 = r100.mProgressBar;
        if (r115 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mProgressBar");
        r115 = null;
    L81:
        r115.setMax((int) r101.getTotalNum());
        ProgressBar r116 = r100.mProgressBar;
        if (r116 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mProgressBar");
        r116 = null;
    L85:
        r116.setProgress((int) r101.getSelectedNum());
        if (r101.getTotalNum() == 0) goto L88;
        float r117 = (r101.getSelectedNum() / r101.getTotalNum()) * 100;
    L89:
        StringCompanionObject r118 = StringCompanionObject.INSTANCE;
        boolean r119 = true;
        String r120 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r117)}, 1));
        long r121 = r101.getSelectedNum();
        HashMap r122 = new HashMap();
        r122.put("vote_num", String.valueOf(r121));
        r122.put(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, r120);
        if (r121 <= 1) goto L92;
        String r123 = UIHelper.getQuantityString(R.plurals.Lark_IM_Poll_Result_NumberOfVotes_Text, (int) r121);
    L93:
        String r124 = UIHelper.mustacheFormat(r123, r122);
        TextView r125 = r100.mPollTv;
        if (r125 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mPollTv");
        r125 = null;
    L97:
        r125.setText(r124 + ' ' + ((String) r122.get(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE)) + '%');
        r100.T3().setVisibility(8);
        ViewGroup.LayoutParams r126 = r100.U3().getLayoutParams();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) r126).setMargins(0, 0, 0, 0);
    L98:
        r100.itemView.setEnabled(r101.isEnable());
        if (this.f445189b != 1) goto L107;
        View r127 = r100.itemView;
        if (r101.isEnable() == true) goto L103;
    L105:
        r119 = false;
    L106:
        r127.setEnabled(r119);
        goto L107
    L103:
        if (r101.isSelected() == true) goto L105;
    L107:
        r100.T3().setChecked(r101.isSelected());
        Log.i("VoteOptionsAdapter", "is_checked: " + r101.isSelected());
        r100.itemView.setOnClickListener(new i(r101, r100, this, r111));
        return;
    L92:
        r123 = UIHelper.getQuantityString(R.plurals.Lark_IM_Poll_Result_NumberOfVotes_Text, (int) r121);
        goto L93
    L88:
        r117 = 0.0f;
        goto L89
    L70:
        if (this.f445198k == true) goto L77;
        View r128 = r100.mVoteResultLayout;
        if (r128 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mVoteResultLayout");
        r128 = null;
    L76:
        r128.setVisibility(8);
        r119 = true;
        goto L98
    L66:
        r114 = 8;
        goto L67
    L60:
        if (this.f445198k == true) goto L63;
        r113 = false;
        goto L64
    L44:
        if ((!r109.isEmpty()) == false) goto L53;
        if (r109.size() <= (this.f445194g - 1)) goto L52;
        Log.i("VoteOptionsAdapter", r101.getContent() + ", addAvatarEllipsizeView, voterNum: " + r109.size() + " max_avatar: " + this.f445194g);
        y2(r100, CollectionsKt.take(r109, this.f445194g - 1));
        LinearLayout r129 = r100.V3();
        int r130 = (((int) r101.getSelectedNum()) - this.f445194g) + 1;
        if (r130 <= 99) goto L50;
        LKUIRoundedImageView2 r131 = z2();
        int r132 = (int) j08.b.a(this.f445188a, 4.0f);
        r131.setPadding(r132, r132, r132, r132);
        Drawable r133 = UIHelper.getDrawable(R.drawable.ud_icon_more_outlined);
        DrawableCompat.setTint(r133, UIHelper.getColor(R.color.icon_n2));
        r131.setImageDrawable(r133);
        View r134 = r131;
    L51:
        r129.addView(r134);
        goto L53
    L50:
        int r135 = (int) j08.b.a(this.f445188a, 24.0f);
        Context r136 = this.f445188a;
        Intrinsics.checkNotNull(r136);
        LinearLayout.LayoutParams r137 = new LinearLayout.LayoutParams(r135, (int) j08.b.a(r136, 24.0f));
        r137.rightMargin = UIHelper.dp2px(7.0f);
        r137.topMargin = UIHelper.dp2px(8.0f);
        TextView r138 = new TextView(this.f445188a);
        r138.setLayoutParams(r137);
        r138.setTextSize(10.0f);
        r138.setGravity(17);
        r138.setTextColor(UIHelper.getColor(R.color.text_caption));
        r138.setBackground(UIHelper.getDrawable(R.drawable.lark_vote_number_view));
        r138.setText(Marker.ANY_NON_NULL_MARKER + r130);
        r134 = r138;
        goto L51
    L52:
        Log.i("VoteOptionsAdapter", r101.getContent() + ", addAvatar, voterNum: " + r109.size());
        y2(r100, r109);
        goto L53
    L40:
        r108 = 8;
        goto L41
    L31:
        if (r101.isEnable() == false) goto L35;
        if (this.f445198k == false) goto L37;
    L35:
        if (r101.getSelectedNum() <= 0) goto L37;
        r107 = true;
        goto L38
    L27:
        r105 = 8;
        goto L28
    L23:
        r104 = r101.isEnable();
        goto L25
    L19:
        r100.T3().setType(UDCheckBox.CheckBoxType.CHECK_BOX);
        goto L20
    L5:
        if (r101.isSelected() == false) goto L11;
        r100.U3().setTypeface(null, 1);
        r100.U3().setTextColor(UIUtils.getColor(this.f445188a, R.color.primary_fill_default));
        TextView r139 = r100.mPollTv;
        if (r139 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPollTv");
        r139 = null;
    L10:
        r139.setTextColor(UIUtils.getColor(this.f445188a, R.color.primary_fill_default));
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(this.f445188a).inflate(R.layout.lark_vote_card_option_item_layout, r100, false));
    }

    public final void y2(ViewHolder r100, List<VoteUser> r101) {
        Log.i("VoteOptionsAdapter", "add_avatar, voter_num: " + r101.size());
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AvatarImage r104 = AvatarImage.Builder.obtain(((VoteUser) ListProtector.get(r101, r103)).getAvatarKey(), ((VoteUser) ListProtector.get(r101, r103)).getUserId(), UIHelper.dp2px(24.0f), UIHelper.dp2px(24.0f)).build();
        LKUIRoundedImageView2 r105 = z2();
        if (this.f445196i == false) goto L7;
        int r106 = nbc.a.f518599a;
        Intrinsics.checkNotNullParameter(r105, "avatarView");
        r105.getDrawable();
        nbc.a r107 = new nbc.a();
        int r108 = t5b.a.f544650a;
        r105.setTag(R.id.chat_message_render_ready_provider, r107);
    L7:
        ImageLoader.with(this.f445188a).load(r104).override(UIHelper.dp2px(24.0f), UIHelper.dp2px(24.0f)).into(r105);
        r100.V3().addView(r105);
        r103 = r103 + 1;
        goto L3
    }
}
