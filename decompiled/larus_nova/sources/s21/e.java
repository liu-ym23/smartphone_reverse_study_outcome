package s21;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.revlink.impl.pk.ui.h;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.t5;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements t21.a {
    public Runnable A;
    public String B;
    public long C;
    public final a D;
    public final LayoutInflater E;
    public final ViewGroup F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f540253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f540254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VHeadView f540255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VHeadView f540256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f540257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PkTagsContainerView f540258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f540259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f540260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f540261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f540262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Button f540263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k f540264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f540265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f540266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<? extends IBattleRivalTag> f540267o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f540268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f540269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Long f540270r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<? extends t5> f540271s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Boolean f540272t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f540273u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f540274v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<String, Long> f540275w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f540276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Boolean f540277y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Boolean f540278z;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f540279a;

        public a(e r100) {
            this.f540279a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            r21.a r111 = (r21.a) r110;
            if (r111 == null) goto L213;
            e r100 = this.f540279a;
            r100.getClass();
            if ((!Intrinsics.areEqual(r111.f535714a, r100.f540264l)) == false) goto L13;
            k r101 = r111.f535714a;
            VHeadView r102 = r100.f540255c;
            if (r102 == null) goto L12;
            if (r101 != null) goto L11;
            r102.setImageResource(0);
            goto L12
        L11:
            a1.x(r102, r101, r102.getWidth(), r102.getHeight(), R.drawable.ttlive_ic_default_head_small);
        L12:
            r100.f540264l = r111.f535714a;
        L13:
            String r103 = "";
            if ((!Intrinsics.areEqual(r111.f535715b, r100.f540265m)) == false) goto L23;
            String r104 = r111.f535715b;
            TextView r105 = r100.f540257e;
            if (r105 == null) goto L21;
            if (r104 != null) goto L20;
            r104 = "";
        L20:
            r105.setText(r104);
        L21:
            r100.f540265m = r111.f535715b;
        L23:
            if ((!Intrinsics.areEqual(r111.f535716c, r100.f540266n)) == false) goto L50;
            Integer r106 = r111.f535716c;
            if (r106 != null) goto L28;
        L35:
            if (r106 != null) goto L38;
        L45:
            VHeadView r107 = r100.f540256d;
            if (r107 == null) goto L48;
            r107.setVisibility(8);
        L48:
            r100.f540266n = r111.f535716c;
            goto L50
        L38:
            if (r106.intValue() != 2) goto L45;
            VHeadView r108 = r100.f540256d;
            if (r108 == null) goto L42;
            r108.setImageResource(R.drawable.ttlive_gender_female_icon);
        L42:
            VHeadView r109 = r100.f540256d;
            if (r109 == null) goto L48;
            r109.setVisibility(0);
            goto L48
        L28:
            if (r106.intValue() != 1) goto L35;
            VHeadView r112 = r100.f540256d;
            if (r112 == null) goto L32;
            r112.setImageResource(R.drawable.ttlive_gender_male_icon);
        L32:
            VHeadView r113 = r100.f540256d;
            if (r113 == null) goto L48;
            r113.setVisibility(0);
        L50:
            if ((!Intrinsics.areEqual(r111.f535717d, r100.f540267o)) == false) goto L64;
            List<IBattleRivalTag> r114 = r111.f535717d;
            if (r114 == null) goto L59;
            PkTagsContainerView r115 = r100.f540258f;
            if (r115 == null) goto L56;
            r115.setOldTag(true);
        L56:
            PkTagsContainerView r116 = r100.f540258f;
            if (r116 == null) goto L62;
            PkTagsContainerView.f(r116, r114, false, null, 9, "", 32);
        L62:
            r100.f540267o = r111.f535717d;
            goto L64
        L59:
            PkTagsContainerView r117 = r100.f540258f;
            if (r117 == null) goto L62;
            r117.f97015c = 0;
        L64:
            if ((!Intrinsics.areEqual(r111.f535718e, r100.f540268p)) == false) goto L66;
        L69:
            Integer r118 = r111.f535718e;
            Integer r119 = r111.f535719f;
            Context r120 = r100.f540253a;
            if (r120 == null) goto L92;
            if (r119 != null) goto L77;
            TextView r121 = r100.f540260h;
            if (r121 == null) goto L92;
            r121.setText("");
            goto L92
        L77:
            if (r118 != null) goto L80;
        L81:
            if (r118 != null) goto L84;
        L86:
            TextView r122 = r100.f540260h;
            if (r122 == null) goto L92;
            r122.setText(r120.getResources().getString(R.string.ttlive_interact_pk_user_list_audience_info, new Object[]{IESUIUtils.getDisplayCountChinese(r119.intValue())}));
            goto L92
        L84:
            if (r118.intValue() != 105) goto L86;
        L89:
            TextView r123 = r100.f540260h;
            if (r123 == null) goto L92;
            r123.setText(r120.getResources().getString(R.string.ttlive_interact_pk_user_list_audience_info, new Object[]{IESUIUtils.getDisplayCountChinese(r119.intValue())}));
            goto L92
        L80:
            if (r118.intValue() == 1) goto L89;
        L92:
            r100.f540268p = r111.f535718e;
            r100.f540269q = r111.f535719f;
            r100.f540270r = r111.f535720g;
        L94:
            if ((!Intrinsics.areEqual(r111.f535722i, r100.f540271s)) == false) goto L96;
        L103:
            List<t5> r124 = r111.f535722i;
            String r125 = r111.f535732s;
            if ((s1.y() - UtilityKotlinExtentionsKt.i(180)) <= UtilityKotlinExtentionsKt.i(230)) goto L106;
            boolean r126 = true;
        L107:
            List<t5> r127 = r124;
            if (r127 != null) goto L110;
        L113:
            boolean r128 = true;
        L114:
            if (r128 == false) goto L122;
            TextView r129 = r100.f540261i;
            if (r129 == null) goto L118;
            r129.setVisibility(8);
        L118:
            TextView r130 = r100.f540262j;
            if (r130 == null) goto L142;
            r130.setVisibility(8);
        L142:
            r100.f540271s = r111.f535722i;
            r100.f540272t = r111.f535723j;
            r100.f540273u = r111.f535724k;
            r100.f540274v = r111.f535725l;
            r100.B = r111.f535732s;
        L144:
            if ((!Intrinsics.areEqual(r111.f535731r, r100.A)) == false) goto L146;
        L153:
            Runnable r131 = r111.f535731r;
            Map<String, Long> r132 = r111.f535726m;
            String r133 = r111.f535727n;
            Boolean r134 = r111.f535728o;
            Boolean r135 = r111.f535729p;
            d r136 = new d(r100, r131);
            Button r137 = r100.f540263k;
            if (r137 == null) goto L157;
            r137.setOnClickListener(r136);
        L157:
            if (TextUtils.isEmpty(r133) == true) goto L168;
            Button r138 = r100.f540263k;
            if (r138 == null) goto L161;
            r138.setText(r133);
        L161:
            Button r139 = r100.f540263k;
            if (r139 == null) goto L164;
            r139.setBackgroundResource(R.color.transparent);
        L164:
            Button r140 = r100.f540263k;
            if (r140 == null) goto L211;
            r140.setTextColor(ColorProtector.parseColor("#80161823"));
        L211:
            r100.A = r111.f535731r;
            r100.f540275w = r111.f535726m;
            r100.f540276x = r111.f535727n;
            r100.f540277y = r111.f535728o;
            r100.f540278z = r111.f535729p;
            return;
        L168:
            if (r132 == null) goto L192;
            if (r132.containsKey(String.valueOf(7)) != true) goto L192;
            if (Intrinsics.areEqual(r134, Boolean.TRUE) == false) goto L182;
            Button r141 = r100.f540263k;
            if (r141 == null) goto L176;
            r141.setBackgroundResource(R.drawable.ttlive_bg_anchor_link_cancel_available);
        L176:
            Button r142 = r100.f540263k;
            if (r142 == null) goto L179;
            r142.setText(R.string.ttlive_anchor_link_canel_apply_new);
        L179:
            Button r143 = r100.f540263k;
            if (r143 == null) goto L211;
            r143.setTextColor(s1.h(R.color.ttlive_anchor_link_btn));
            goto L211
        L182:
            Button r144 = r100.f540263k;
            if (r144 == null) goto L185;
            r144.setBackgroundResource(R.drawable.ttlive_bg_live_red_btn);
        L185:
            Button r145 = r100.f540263k;
            if (r145 == null) goto L188;
            r145.setText(R.string.ttlive_anchor_link_apply_join_theme2);
        L188:
            Button r146 = r100.f540263k;
            if (r146 == null) goto L211;
            r146.setTextColor(ColorProtector.parseColor("#ffffff"));
        L192:
            if (Intrinsics.areEqual(r135, Boolean.TRUE) == false) goto L202;
            Button r147 = r100.f540263k;
            if (r147 == null) goto L196;
            r147.setBackgroundResource(R.drawable.ttlive_bg_anchor_link_cancel_available);
        L196:
            Button r148 = r100.f540263k;
            if (r148 == null) goto L199;
            r148.setText(R.string.ttlive_anchor_link_cancel_invite);
        L199:
            Button r149 = r100.f540263k;
            if (r149 == null) goto L211;
            r149.setTextColor(s1.h(R.color.ttlive_anchor_link_btn));
            goto L211
        L202:
            Button r150 = r100.f540263k;
            if (r150 == null) goto L205;
            r150.setBackgroundResource(R.drawable.ttlive_bg_live_red_btn);
        L205:
            Button r151 = r100.f540263k;
            if (r151 == null) goto L208;
            r151.setText(R.string.ttlive_anchor_link_invite_link_theme2);
        L208:
            Button r152 = r100.f540263k;
            if (r152 == null) goto L211;
            r152.setTextColor(ColorProtector.parseColor("#ffffff"));
            goto L211
        L146:
            if ((!Intrinsics.areEqual(r111.f535726m, r100.f540275w)) == true) goto L153;
            if ((!Intrinsics.areEqual(r111.f535727n, r100.f540276x)) == true) goto L153;
            if ((!Intrinsics.areEqual(r111.f535728o, r100.f540277y)) == true) goto L153;
            if ((!Intrinsics.areEqual(r111.f535729p, r100.f540278z)) == true) goto L153;
            return;
        L122:
            if (r124.size() < 1) goto L135;
            if (r126 == false) goto L125;
            int r153 = 10;
        L126:
            TextView r154 = r100.f540261i;
            if (r154 == null) goto L129;
            r154.setVisibility(0);
        L129:
            TextView r155 = r100.f540262j;
            if (r155 == null) goto L132;
            r155.setVisibility(0);
        L132:
            String r156 = ((t5) ListProtector.get(r124, 0)).getNickName();
            if (r156.length() <= r153) goto L137;
            r156 = r156.substring(0, r153 - 1) + "...";
        L137:
            if (r124.size() <= 1) goto L139;
            com.bytedance.live.kmp.util.c r157 = com.bytedance.live.kmp.util.c.f255167a;
            int r158 = w11.a.f557889a;
            r103 = com.bytedance.live.kmp.util.c.a(R.string.ttlive_anchor_link_info_new_room_status_n_other_suffix, new Object[]{Integer.valueOf(r124.size())});
        L139:
            SpannableStringBuilder r159 = new SpannableStringBuilder(s1.C(R.string.ttlive_anchor_link_info_new_room_status, new Object[]{r156}) + r103 + r125);
            r159.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#161823")), 2, r156.length() + 2, 33);
            TextView r160 = r100.f540262j;
            if (r160 == null) goto L142;
            r160.setText(r159);
            goto L142
        L125:
            r153 = 6;
            goto L126
        L135:
            r156 = "";
            goto L137
        L110:
            if (r127.isEmpty() == true) goto L113;
            r128 = false;
            goto L114
        L106:
            r126 = false;
            goto L107
        L96:
            if ((!Intrinsics.areEqual(r111.f535723j, r100.f540272t)) == true) goto L103;
            if ((!Intrinsics.areEqual(r111.f535724k, r100.f540273u)) == true) goto L103;
            if ((!Intrinsics.areEqual(r111.f535725l, r100.f540274v)) == true) goto L103;
            if ((!Intrinsics.areEqual(r111.f535732s, r100.B)) == false) goto L144;
        L66:
            if ((!Intrinsics.areEqual(r111.f535719f, r100.f540269q)) == true) goto L69;
            if ((!Intrinsics.areEqual(r111.f535720g, r100.f540270r)) == false) goto L94;
        }
    }

    @Override // t21.a
    public final h.a a() {
        Context r100 = this.f540253a;
        Intrinsics.checkNotNull(r100);
        return new h.a(r100);
    }

    @Override // t21.a
    public final void init() {
        View r100 = this.E.inflate(R.layout.ttlive_item_anchor_link_theme2, this.F, false);
        this.f540254b = r100;
        Button r101 = null;
        if (r100 == null) goto L5;
        Context r102 = r100.getContext();
    L6:
        this.f540253a = r102;
        View r103 = this.f540254b;
        if (r103 == null) goto L9;
        VHeadView r104 = (VHeadView) r103.findViewById(R.id.iv_avatar);
    L10:
        this.f540255c = r104;
        View r105 = this.f540254b;
        if (r105 == null) goto L13;
        VHeadView r106 = (VHeadView) r105.findViewById(R.id.iv_gender);
    L14:
        this.f540256d = r106;
        View r107 = this.f540254b;
        if (r107 == null) goto L17;
        TextView r108 = (TextView) r107.findViewById(R.id.tv_nick_name);
    L18:
        this.f540257e = r108;
        View r109 = this.f540254b;
        if (r109 == null) goto L21;
        PkTagsContainerView r110 = (PkTagsContainerView) r109.findViewById(R.id.tags_container);
    L22:
        this.f540258f = r110;
        View r111 = this.f540254b;
        if (r111 == null) goto L25;
        ViewGroup r112 = (ViewGroup) r111.findViewById(R.id.audience_num_container);
    L26:
        this.f540259g = r112;
        View r113 = this.f540254b;
        if (r113 == null) goto L29;
        TextView r114 = (TextView) r113.findViewById(R.id.tv_audience);
    L30:
        this.f540260h = r114;
        View r115 = this.f540254b;
        if (r115 == null) goto L33;
        TextView r116 = (TextView) r115.findViewById(R.id.view_link_info_split);
    L34:
        this.f540261i = r116;
        View r117 = this.f540254b;
        if (r117 == null) goto L37;
        TextView r118 = (TextView) r117.findViewById(R.id.view_link_info);
    L38:
        this.f540262j = r118;
        View r119 = this.f540254b;
        if (r119 == null) goto L41;
        r101 = (Button) r119.findViewById(R.id.bt_invite_or_apply);
    L41:
        this.f540263k = r101;
        ViewGroup r120 = this.f540259g;
        if (r120 == null) goto L44;
        r120.setVisibility(0);
    L44:
        PkTagsContainerView r121 = this.f540258f;
        if (r121 == null) goto L48;
        r121.setVisibility(0);
        return;
    L48:
        return;
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r112 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // t21.a
    public final View getView() {
        return this.f540254b;
    }

    @Override // t21.a
    public final void b(MutableLiveData r100) {
        Intrinsics.checkNotNullParameter(r100, "uiStateLiveData");
        a r101 = this.D;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        x.e(r100, r101);
        return;
    }

    public e(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.E = r100;
        this.F = r101;
        this.D = new a(this);
    }
}
