package com.ss.android.lark.message.vote.message;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.message.vote.VoteCardOptionsAdapter;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.g;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class VoteMessageCell implements r5b.d<VoteContentVO>, u5b.a<VoteContentVO> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f432294b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.message.vote.c f432295a;

    public static class VoteMessageViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public trb.b f432296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public trb.a f432297b;

        @BindView(DataLoaderHelper.DATALOADER_KEY_ENABLE_NOTIFY_ERROR)
        public TextView mActionBtn;

        @BindView(9034)
        public TextView mActualParticipantNumberTv;

        @BindView(9896)
        public TextView mNumberOfParticipantsTv;

        @BindView(9915)
        public RecyclerView mOptionsRv;

        @BindView(10168)
        public TextView mSelectType;

        @BindView(10338)
        public View mTitleLayout;

        @BindView(10342)
        public TextView mTitleTv;

        @BindView(10513)
        public View mVoteIcon;

        public final TextView a() {
            return this.mActionBtn;
        }

        public final TextView b() {
            return this.mActualParticipantNumberTv;
        }

        public final TextView c() {
            return this.mNumberOfParticipantsTv;
        }

        public final RecyclerView d() {
            return this.mOptionsRv;
        }

        public final TextView e() {
            return this.mSelectType;
        }

        public final View f() {
            return this.mTitleLayout;
        }

        public final TextView g() {
            return this.mTitleTv;
        }

        public final trb.a h() {
            return this.f432297b;
        }

        public final trb.b i() {
            return this.f432296a;
        }

        public VoteMessageViewHolder(View r100) {
            ButterKnife.bind(this, r100);
            TextView r101 = this.mSelectType;
            LarkFont r102 = LarkFont.CAPTION0;
            zz7.a.d(r101, r102);
            zz7.a.d(this.mTitleTv, LarkFont.HEADLINE);
            zz7.a.d(this.mNumberOfParticipantsTv, r102);
            zz7.a.d(this.mActualParticipantNumberTv, r102);
            zz7.a.d(this.mActionBtn, LarkFont.BODY2);
            zz7.a.a(this.mVoteIcon, 16);
            ViewGroup.LayoutParams r103 = this.mActionBtn.getLayoutParams();
            r103.height = zz7.b.g(this.mActionBtn.getContext(), 32);
            this.mActionBtn.setLayoutParams(r103);
        }
    }

    public class VoteMessageViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VoteMessageViewHolder f432298a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            VoteMessageViewHolder r100 = this.f432298a;
            if (r100 == null) goto L7;
            this.f432298a = null;
            r100.mTitleLayout = null;
            r100.mTitleTv = null;
            r100.mVoteIcon = null;
            r100.mSelectType = null;
            r100.mOptionsRv = null;
            r100.mNumberOfParticipantsTv = null;
            r100.mActualParticipantNumberTv = null;
            r100.mActionBtn = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public VoteMessageViewHolder_ViewBinding(VoteMessageViewHolder r100, View r101) {
            this.f432298a = r100;
            r100.mTitleLayout = Utils.findRequiredView(r101, R.id.title_layout, "field 'mTitleLayout'");
            r100.mTitleTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.title_tv, "field 'mTitleTv'", TextView.class);
            r100.mVoteIcon = Utils.findRequiredView(r101, R.id.vote_icon, "field 'mVoteIcon'");
            r100.mSelectType = (TextView) Utils.findRequiredViewAsType(r101, R.id.select_type_tv, "field 'mSelectType'", TextView.class);
            r100.mOptionsRv = (RecyclerView) Utils.findRequiredViewAsType(r101, R.id.options_rv, "field 'mOptionsRv'", RecyclerView.class);
            r100.mNumberOfParticipantsTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.number_of_participants_tv, "field 'mNumberOfParticipantsTv'", TextView.class);
            r100.mActualParticipantNumberTv = (TextView) Utils.findRequiredViewAsType(r101, R.id.actual_participant_number_tv, "field 'mActualParticipantNumberTv'", TextView.class);
            r100.mActionBtn = (TextView) Utils.findRequiredViewAsType(r101, R.id.action_btn, "field 'mActionBtn'", TextView.class);
        }
    }

    public class a implements qrb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoteMessageViewHolder f432299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VoteMessageCell f432300b;

        public final void a(irb.b r110) {
            com.ss.android.lark.message.vote.c r100 = this.f432300b.f432295a;
            VoteMessageViewHolder r101 = this.f432299a;
            r100.getClass();
            if (r101 == null) goto L40;
            if (r110 == null) goto L43;
            List<irb.a> r102 = r110.f495559c;
            if (CollectionUtils.isEmpty(r102) == true) goto L44;
            TextView r103 = r101.g();
            TextView r104 = r101.e();
            View r105 = r101.f();
            RecyclerView r106 = r101.d();
            RecyclerView.ItemAnimator r107 = r106.getItemAnimator();
            if ((r107 instanceof DefaultItemAnimator) == false) goto L12;
            ((DefaultItemAnimator) r107).setSupportsChangeAnimations(false);
            r107.setAddDuration(0);
            r107.setChangeDuration(0);
            r107.setMoveDuration(0);
            r107.setRemoveDuration(0);
        L12:
            TextView r108 = r101.c();
            TextView r111 = r101.b();
            trb.b r112 = r101.i();
            trb.a r113 = r101.h();
            TextView r114 = r101.a();
            if (r100.f432285b == false) goto L19;
            r105.setVisibility(0);
            r103.setText((CharSequence) ListProtector.get(r110.f495557a, 0));
            if (r110.f495558b <= 1) goto L17;
            String r109 = UIUtils.getString(r100.f432284a, R.string.Lark_Legacy_MultipleSelection);
        L18:
            r104.setText(r109);
        L21:
            if (r100.f432286c == false) goto L27;
            r106.setVisibility(0);
            if (r106.getAdapter() != null) goto L25;
            VoteCardOptionsAdapter r115 = new VoteCardOptionsAdapter(r100.f432284a);
            r106.setLayoutManager(new LinearLayoutManager(r100.f432284a, 1, false));
            r106.setAdapter(r115);
        L26:
            r115.resetAll(r102);
            r115.f432270b = r110.f495558b;
            r115.f432272d = new com.ss.android.lark.message.vote.b(r100, r110, r114);
            r115.f432275g = r113;
        L28:
            r114.setVisibility(0);
            r114.setEnabled(false);
            r114.setOnClickListener(new trb.d(r100, r114, r112, r110, r115));
            if (TextUtils.isEmpty(r110.f495560d) == false) goto L31;
            r114.setVisibility(8);
        L33:
            if (r100.f432287d == true) goto L35;
            r111.setVisibility(8);
            r108.setVisibility(8);
            return;
        L35:
            if (TextUtils.isEmpty(r110.f495560d) == false) goto L37;
            r111.setVisibility(0);
            r111.setText(((String) ListProtector.get(r110.f495557a, 1)) + ((String) ListProtector.get(r110.f495557a, 2)));
            r108.setVisibility(0);
            r108.setText(((String) ListProtector.get(r110.f495557a, 3)) + ((String) ListProtector.get(r110.f495557a, 4)));
            return;
        L37:
            r111.setVisibility(8);
            r108.setVisibility(8);
            return;
        L31:
            r114.setVisibility(0);
            r114.setText((CharSequence) ListProtector.get(r110.f495557a, 1));
            r114.setTextColor(UIUtils.getColor(r100.f432284a, R.color.text_placeholder));
            goto L33
        L25:
            r115 = (VoteCardOptionsAdapter) r106.getAdapter();
            goto L26
        L27:
            r115 = new VoteCardOptionsAdapter(r100.f432284a);
            r106.setVisibility(8);
            goto L28
        L17:
            r109 = UIUtils.getString(r100.f432284a, R.string.Lark_Legacy_SingleSelectionInfo);
            goto L18
        L19:
            r105.setVisibility(8);
            goto L21
        L44:
            return;
        L43:
            return;
        }

        public a(VoteMessageCell r100, VoteMessageViewHolder r101) {
            this.f432300b = r100;
            this.f432299a = r101;
        }
    }

    public VoteMessageCell() {
    }

    @Override // r5b.d
    public final void f(View r100) {
    }

    @Override // u5b.a
    public final u5b.c i(v5b.c<VoteContentVO> r100) {
        return null;
    }

    static {
        f432294b = UIHelper.dp2px(12.0f);
    }

    @Override // r5b.d
    public final Class c() {
        return VoteContentVO.class;
    }

    @Override // r5b.d
    public final View a(LayoutInflater r100, ViewGroup r101) {
        if (this.f432295a != null) goto L6;
        com.ss.android.lark.message.vote.c.a r102 = new com.ss.android.lark.message.vote.c.a(r100.getContext());
        r102.f432289b = true;
        r102.f432290c = true;
        r102.f432291d = true;
        this.f432295a = new com.ss.android.lark.message.vote.c(r102);
    L6:
        return r100.inflate(R.layout.vote_card_content_item_layout, r101, false);
    }

    @Override // u5b.a
    public final BubbleStyle d(v5b.c<VoteContentVO> r100, View r101) {
        BubbleStyle.a(112, r101.findViewById(R.id.title_layout), new int[]{0, 0, 0, f432294b});
        return BubbleStyle.f415420h;
    }

    @Override // r5b.d
    public final void e(View r100, int r101, v5b.c<VoteContentVO> r102) {
        VoteContentVO r103 = (VoteContentVO) r102.b();
        if (r103 != null) goto L5;
        return;
    L5:
        if (((RichText) r103.f432293b.getValue()) == null) goto L16;
        VoteMessageViewHolder r104 = (VoteMessageViewHolder) r100.getTag();
        if (r104 != null) goto L10;
        r104 = new VoteMessageViewHolder(r100);
        r100.setTag(r104);
    L10:
        r104.f432296a = new com.ss.android.lark.message.vote.message.a(this, r102);
        r104.f432297b = new b(r102);
        trb.c r105 = new trb.c((RichText) r103.f432293b.getValue(), new a(this, r104));
        RichText r106 = r105.f547320a;
        if (r106 == null) goto L17;
        g.b(r106, r105.f547323d);
        return;
    L17:
        return;
    }
}
