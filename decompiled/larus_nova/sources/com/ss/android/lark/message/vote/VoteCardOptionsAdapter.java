package com.ss.android.lark.message.vote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public class VoteCardOptionsAdapter extends LarkRecyclerViewBaseAdapter<ViewHolder, irb.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f432269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f432270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f432271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f432272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f432273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f432274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public trb.a f432275g;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(9195)
        UDCheckBox mCheckBox;

        @BindView(9259)
        TextView mContentTv;

        @BindView(9571)
        RelativeLayout mItemLayout;

        @BindView(9897)
        TextView mNumberTv;

        @BindView(9991)
        TextView mPollTv;

        @BindView(10022)
        ProgressBar mProgressBar;

        @BindView(10514)
        View mVoteResultLayout;

        public ViewHolder(View r100) {
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewHolder f432276a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            ViewHolder r100 = this.f432276a;
            if (r100 == null) goto L7;
            this.f432276a = null;
            r100.mNumberTv = null;
            r100.mContentTv = null;
            r100.mPollTv = null;
            r100.mProgressBar = null;
            r100.mItemLayout = null;
            r100.mVoteResultLayout = null;
            r100.mCheckBox = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public ViewHolder_ViewBinding(ViewHolder r100, View r101) {
            this.f432276a = r100;
            r100.mNumberTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.number_tv, "field 'mNumberTv'", TextView.class);
            r100.mContentTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.content_tv, "field 'mContentTv'", TextView.class);
            r100.mPollTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.poll_tv, "field 'mPollTv'", TextView.class);
            r100.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(r101, R.id.progressbar, "field 'mProgressBar'", ProgressBar.class);
            r100.mItemLayout = (RelativeLayout) Utils.findRequiredViewAsType(r101, R.id.item_layout, "field 'mItemLayout'", RelativeLayout.class);
            r100.mVoteResultLayout = Utils.findRequiredView(r101, R.id.vote_result_layout, "field 'mVoteResultLayout'");
            r100.mCheckBox = (UDCheckBox) Utils.findRequiredViewAsType(r101, R.id.checkbox, "field 'mCheckBox'", UDCheckBox.class);
        }
    }

    public interface a {
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    public VoteCardOptionsAdapter(Context r100) {
        this.f432269a = r100;
        this.f432273e = UIUtils.getColor(r100, R.color.primary_fill_default);
        this.f432274f = UIUtils.getColor(r100, R.color.text_title);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r112 = (ViewHolder) r110;
        irb.a r100 = getItem(r111);
        if (r100.f495552e == true) goto L5;
    L7:
        r112.mNumberTv.setTextColor(this.f432274f);
        r112.mNumberTv.setTypeface(null, 0);
        r112.mContentTv.setTextColor(this.f432274f);
        r112.mContentTv.setTypeface(null, 0);
        r112.mPollTv.setTextColor(this.f432274f);
    L9:
        if (this.f432270b != 1) goto L11;
        r112.mCheckBox.setType(UDCheckBox.CheckBoxType.RADIO);
    L13:
        if (r100.f495552e == false) goto L18;
        if (r100.f495551d == true) goto L18;
        r112.mCheckBox.setVisibility(0);
        r112.mCheckBox.setChecked(true);
    L21:
        r112.mNumberTv.setText(r100.f495553f);
        r112.mContentTv.setText(r100.f495554g);
        if (r100.f495551d == false) goto L36;
        r112.mVoteResultLayout.setVisibility(0);
        r112.mProgressBar.setProgress(r100.f495555h);
        r112.mProgressBar.setMax(r100.f495556i);
        int r101 = r100.f495556i;
        if (r101 == 0) goto L26;
        float r102 = (r100.f495555h / r101) * 100.0f;
    L28:
        if (r102 < 0.1d) goto L30;
        String r103 = String.format("%.1f", new Object[]{Float.valueOf(r102)});
    L31:
        int r104 = r100.f495555h;
        HashMap r105 = new HashMap();
        r105.put("vote_num", String.valueOf(r104));
        r105.put(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, r103);
        if (r104 <= 1) goto L34;
        int r106 = R.string.Lark_Legacy_VoteOptionResults;
    L35:
        r112.mPollTv.setText(UIHelper.mustacheFormat(r106, r105));
    L37:
        r112.itemView.setEnabled(!r100.f495551d);
        r112.itemView.setOnClickListener(new com.ss.android.lark.message.vote.a(this, r112, r100, r111));
        TextView r113 = r112.mNumberTv;
        LarkFont r107 = LarkFont.BODY1;
        zz7.a.d(r113, r107);
        zz7.a.d(r112.mContentTv, r107);
        zz7.a.d(r112.mPollTv, LarkFont.CAPTION2);
        return;
    L34:
        r106 = R.string.Lark_Legacy_VoteOptionResult;
        goto L35
    L30:
        r103 = String.format("%04.1f", new Object[]{Float.valueOf(r102)});
        goto L31
    L26:
        r102 = 0.0f;
        goto L28
    L36:
        r112.mVoteResultLayout.setVisibility(8);
    L18:
        if (r100.f495551d == false) goto L20;
        r112.mCheckBox.setVisibility(8);
        goto L21
    L20:
        r112.mCheckBox.setVisibility(0);
        r112.mCheckBox.setChecked(false);
        goto L21
    L11:
        r112.mCheckBox.setType(UDCheckBox.CheckBoxType.CHECK_BOX);
        goto L13
    L5:
        if (r100.f495551d == false) goto L7;
        r112.mNumberTv.setTextColor(this.f432273e);
        r112.mNumberTv.setTypeface(null, 1);
        r112.mContentTv.setTextColor(this.f432273e);
        r112.mContentTv.setTypeface(null, 1);
        r112.mPollTv.setTextColor(this.f432273e);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new ViewHolder(LayoutInflater.from(this.f432269a).inflate(R.layout.vote_card_option_item_layout, r100, false));
    }
}
