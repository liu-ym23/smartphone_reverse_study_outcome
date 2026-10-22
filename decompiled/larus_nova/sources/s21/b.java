package s21;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoView;
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
public final class b implements t21.a {
    public Boolean A;
    public Boolean B;
    public Boolean C;
    public Runnable D;
    public String E;
    public long F;
    public final a G;
    public final LayoutInflater H;
    public final ViewGroup I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f540224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f540225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VHeadView f540226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VHeadView f540227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f540228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PkTagsContainerView f540229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f540230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f540231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f540232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f540233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnchorLinkInfoView f540234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Button f540235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f540236m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f540237n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f540238o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<? extends IBattleRivalTag> f540239p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f540240q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f540241r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Long f540242s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Boolean f540243t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<? extends t5> f540244u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f540245v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f540246w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Boolean f540247x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map<String, Long> f540248y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f540249z;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f540250a;

        public a(b r100) {
            this.f540250a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            r21.a r100 = (r21.a) r110;
            if (r100 == null) goto L267;
            b r101 = this.f540250a;
            r101.getClass();
            if ((!Intrinsics.areEqual(r100.f535714a, r101.f540236m)) == false) goto L13;
            k r102 = r100.f535714a;
            VHeadView r103 = r101.f540226c;
            if (r103 == null) goto L12;
            if (r102 != null) goto L11;
            r103.setImageResource(0);
            goto L12
        L11:
            a1.x(r103, r102, r103.getWidth(), r103.getHeight(), R.drawable.ttlive_ic_default_head_small);
        L12:
            r101.f540236m = r100.f535714a;
        L13:
            String r104 = "";
            if ((!Intrinsics.areEqual(r100.f535715b, r101.f540237n)) == false) goto L23;
            String r105 = r100.f535715b;
            TextView r106 = r101.f540228e;
            if (r106 == null) goto L21;
            if (r105 != null) goto L20;
            r105 = "";
        L20:
            r106.setText(r105);
        L21:
            r101.f540237n = r100.f535715b;
        L23:
            if ((!Intrinsics.areEqual(r100.f535716c, r101.f540238o)) == false) goto L50;
            Integer r107 = r100.f535716c;
            if (r107 != null) goto L28;
        L35:
            if (r107 != null) goto L38;
        L45:
            VHeadView r108 = r101.f540227d;
            if (r108 == null) goto L48;
            r108.setVisibility(8);
        L48:
            r101.f540238o = r100.f535716c;
            goto L50
        L38:
            if (r107.intValue() != 2) goto L45;
            VHeadView r109 = r101.f540227d;
            if (r109 == null) goto L42;
            r109.setImageResource(R.drawable.ttlive_gender_female_icon);
        L42:
            VHeadView r111 = r101.f540227d;
            if (r111 == null) goto L48;
            r111.setVisibility(0);
            goto L48
        L28:
            if (r107.intValue() != 1) goto L35;
            VHeadView r112 = r101.f540227d;
            if (r112 == null) goto L32;
            r112.setImageResource(R.drawable.ttlive_gender_male_icon);
        L32:
            VHeadView r113 = r101.f540227d;
            if (r113 == null) goto L48;
            r113.setVisibility(0);
        L50:
            if ((!Intrinsics.areEqual(r100.f535717d, r101.f540239p)) == false) goto L64;
            List<IBattleRivalTag> r114 = r100.f535717d;
            if (r114 == null) goto L59;
            PkTagsContainerView r115 = r101.f540229f;
            if (r115 == null) goto L56;
            r115.setOldTag(true);
        L56:
            PkTagsContainerView r116 = r101.f540229f;
            if (r116 == null) goto L62;
            PkTagsContainerView.f(r116, r114, false, null, 9, "", 32);
        L62:
            r101.f540239p = r100.f535717d;
            goto L64
        L59:
            PkTagsContainerView r117 = r101.f540229f;
            if (r117 == null) goto L62;
            r117.f97015c = 0;
        L64:
            if ((!Intrinsics.areEqual(r100.f535718e, r101.f540240q)) == false) goto L66;
        L71:
            Integer r118 = r100.f535718e;
            Integer r119 = r100.f535719f;
            Long r120 = r100.f535720g;
            Boolean r121 = r100.f535721h;
            Context r122 = r101.f540224a;
            if (r122 == null) goto L119;
            if (r119 == null) goto L113;
            if (r120 == null) goto L113;
            TextView r123 = r101.f540233j;
            if (r123 == null) goto L81;
            r123.setText(r122.getResources().getString(R.string.ttlive_interact_pk_user_list_audience_num, new Object[]{IESUIUtils.getDisplayCountChinese(r119.intValue())}));
        L81:
            if (Intrinsics.areEqual(r121, Boolean.TRUE) == false) goto L119;
            if (r118 != null) goto L86;
        L87:
            if (r118 != null) goto L90;
        L92:
            if (r118 == null) goto L119;
            if (r118.intValue() != 2) goto L119;
            b51.b r124 = b51.b.f17721c0;
            r124.getClass();
            if (((Boolean) b51.b.f17738t.getValue(r124, b51.b.f17716a[18])).booleanValue() == false) goto L101;
            TextView r125 = r101.f540233j;
            if (r125 == null) goto L104;
            r125.setText(r122.getResources().getString(R.string.ttlive_interact_pk_user_list_follow_audience_info, new Object[]{IESUIUtils.getDisplayCountChinese(r119.intValue()), IESUIUtils.getDisplayCountChinese(r120.longValue())}));
        L104:
            ImageView r126 = r101.f540232i;
            if (r126 == null) goto L119;
            r126.setVisibility(8);
            goto L119
        L101:
            TextView r127 = r101.f540233j;
            if (r127 == null) goto L104;
            r127.setText(r122.getResources().getString(R.string.ttlive_interact_pk_user_list_audience_info, new Object[]{IESUIUtils.getDisplayCountChinese(r119.intValue())}));
            goto L104
        L90:
            if (r118.intValue() != 105) goto L92;
        L107:
            TextView r128 = r101.f540233j;
            if (r128 == null) goto L110;
            r128.setText(r122.getResources().getString(R.string.ttlive_interact_pk_user_list_audience_info, new Object[]{IESUIUtils.getDisplayCountChinese(r119.intValue())}));
        L110:
            ImageView r129 = r101.f540232i;
            if (r129 == null) goto L119;
            r129.setVisibility(8);
            goto L119
        L86:
            if (r118.intValue() == 1) goto L107;
        L113:
            TextView r130 = r101.f540233j;
            if (r130 == null) goto L116;
            r130.setText("");
        L116:
            ImageView r131 = r101.f540232i;
            if (r131 == null) goto L119;
            r131.setVisibility(0);
        L119:
            r101.f540240q = r100.f535718e;
            r101.f540241r = r100.f535719f;
            r101.f540242s = r100.f535720g;
            r101.f540243t = r100.f535721h;
        L121:
            if ((!Intrinsics.areEqual(r100.f535722i, r101.f540244u)) == false) goto L123;
        L130:
            List<t5> r132 = r100.f535722i;
            String r133 = r100.f535732s;
            AnchorLinkInfoView r134 = r101.f540234k;
            if (r134 == null) goto L135;
            VHeadView r135 = r134.getIvAnchorAvatar1();
            if (r135 == null) goto L135;
            int r136 = 8;
            r135.setVisibility(8);
        L136:
            AnchorLinkInfoView r137 = r101.f540234k;
            if (r137 == null) goto L141;
            VHeadView r138 = r137.getIvAnchorAvatar2();
            if (r138 == null) goto L141;
            r138.setVisibility(r136);
        L141:
            AnchorLinkInfoView r139 = r101.f540234k;
            if (r139 == null) goto L146;
            VHeadView r140 = r139.getIvAnchorAvatar3();
            if (r140 == null) goto L146;
            r140.setVisibility(r136);
        L146:
            if (r132 != null) goto L148;
        L186:
            AnchorLinkInfoView r141 = r101.f540234k;
            if (r141 == null) goto L189;
            r141.setVisibility(8);
        L189:
            r101.f540244u = r100.f535722i;
            r101.f540245v = r100.f535723j;
            r101.f540246w = r100.f535724k;
            r101.f540247x = r100.f535725l;
            r101.E = r100.f535732s;
        L191:
            if ((!Intrinsics.areEqual(r100.f535731r, r101.D)) == false) goto L193;
        L202:
            Runnable r142 = r100.f535731r;
            Map<String, Long> r143 = r100.f535726m;
            String r144 = r100.f535727n;
            Boolean r145 = r100.f535728o;
            Boolean r146 = r100.f535729p;
            Boolean r147 = r100.f535730q;
            s21.a r148 = new s21.a(r101, r142);
            Button r149 = r101.f540235l;
            if (r149 == null) goto L206;
            r149.setOnClickListener(r148);
        L206:
            if (TextUtils.isEmpty(r144) == true) goto L217;
            Button r150 = r101.f540235l;
            if (r150 == null) goto L210;
            r150.setText(r144);
        L210:
            Button r151 = r101.f540235l;
            if (r151 == null) goto L213;
            r151.setBackgroundResource(R.color.transparent);
        L213:
            Button r152 = r101.f540235l;
            if (r152 == null) goto L265;
            r152.setTextColor(ColorProtector.parseColor("#80161823"));
        L265:
            r101.D = r100.f535731r;
            r101.f540248y = r100.f535726m;
            r101.f540249z = r100.f535727n;
            r101.A = r100.f535728o;
            r101.B = r100.f535729p;
            r101.C = r100.f535730q;
            return;
        L217:
            if (r143 != null) goto L219;
        L240:
            Boolean r153 = Boolean.TRUE;
            if (Intrinsics.areEqual(r146, r153) == false) goto L251;
            Button r154 = r101.f540235l;
            if (r154 == null) goto L245;
            r154.setBackgroundResource(R.drawable.ttlive_bg_anchor_link_cancel_available);
        L245:
            Button r155 = r101.f540235l;
            if (r155 == null) goto L248;
            r155.setText(R.string.ttlive_anchor_link_cancel_invite);
        L248:
            Button r156 = r101.f540235l;
            if (r156 == null) goto L265;
            r156.setTextColor(s1.h(R.color.ttlive_anchor_link_btn));
            goto L265
        L251:
            Button r157 = r101.f540235l;
            if (r157 == null) goto L255;
            r157.setBackgroundResource(R.drawable.ttlive_bg_live_red_btn);
        L255:
            if (Intrinsics.areEqual(r147, r153) == false) goto L259;
            Button r158 = r101.f540235l;
            if (r158 == null) goto L262;
            r158.setText(R.string.ttlive_anchor_link_invite_join);
        L262:
            Button r159 = r101.f540235l;
            if (r159 == null) goto L265;
            r159.setTextColor(ColorProtector.parseColor("#ffffff"));
            goto L265
        L259:
            Button r160 = r101.f540235l;
            if (r160 == null) goto L262;
            r160.setText(R.string.ttlive_anchor_link_invite_link);
            goto L262
        L219:
            if (r143.containsKey(String.valueOf(7)) != true) goto L240;
            if (Intrinsics.areEqual(r145, Boolean.TRUE) == false) goto L231;
            Button r161 = r101.f540235l;
            if (r161 == null) goto L225;
            r161.setBackgroundResource(R.drawable.ttlive_bg_anchor_link_cancel_available);
        L225:
            Button r162 = r101.f540235l;
            if (r162 == null) goto L228;
            r162.setText(R.string.ttlive_anchor_link_canel_apply_new);
        L228:
            Button r163 = r101.f540235l;
            if (r163 == null) goto L265;
            r163.setTextColor(s1.h(R.color.ttlive_anchor_link_btn));
            goto L265
        L231:
            Button r164 = r101.f540235l;
            if (r164 == null) goto L234;
            r164.setBackgroundResource(R.drawable.ttlive_bg_live_red_btn);
        L234:
            Button r165 = r101.f540235l;
            if (r165 == null) goto L237;
            r165.setText(R.string.ttlive_anchor_link_apply_join);
        L237:
            Button r166 = r101.f540235l;
            if (r166 == null) goto L265;
            r166.setTextColor(ColorProtector.parseColor("#ffffff"));
            goto L265
        L193:
            if ((!Intrinsics.areEqual(r100.f535726m, r101.f540248y)) == true) goto L202;
            if ((!Intrinsics.areEqual(r100.f535727n, r101.f540249z)) == true) goto L202;
            if ((!Intrinsics.areEqual(r100.f535728o, r101.A)) == true) goto L202;
            if ((!Intrinsics.areEqual(r100.f535729p, r101.B)) == true) goto L202;
            if ((!Intrinsics.areEqual(r100.f535730q, r101.C)) == true) goto L202;
            return;
        L148:
            if (r132.size() == 0) goto L186;
            if (r132.size() < 1) goto L177;
            AnchorLinkInfoView r167 = r101.f540234k;
            if (r167 == null) goto L155;
            r167.setVisibility(0);
        L155:
            AnchorLinkInfoView r168 = r101.f540234k;
            if (r168 == null) goto L160;
            VHeadView r169 = r168.getIvAnchorAvatar1();
            if (r169 == null) goto L160;
            r169.setVisibility(0);
        L160:
            AnchorLinkInfoView r170 = r101.f540234k;
            if (r170 == null) goto L163;
            VHeadView r171 = r170.getIvAnchorAvatar1();
        L164:
            k r172 = ((t5) ListProtector.get(r132, 0)).getAvatarThumb();
            AnchorLinkInfoView r173 = r101.f540234k;
            if (r173 == null) goto L169;
            VHeadView r174 = r173.getIvAnchorAvatar1();
            if (r174 == null) goto L169;
            int r175 = r174.getWidth();
        L170:
            AnchorLinkInfoView r176 = r101.f540234k;
            if (r176 == null) goto L175;
            VHeadView r177 = r176.getIvAnchorAvatar1();
            if (r177 == null) goto L175;
            int r178 = r177.getHeight();
        L176:
            a1.x(r171, r172, r175, r178, R.drawable.ttlive_ic_default_head_small);
            String r179 = c.a(((t5) ListProtector.get(r132, 0)).getNickName(), 10);
        L179:
            if (r132.size() <= 1) goto L181;
            com.bytedance.live.kmp.util.c r180 = com.bytedance.live.kmp.util.c.f255167a;
            int r181 = w11.a.f557889a;
            r104 = com.bytedance.live.kmp.util.c.a(R.string.ttlive_anchor_link_info_new_room_status_n_other_suffix, new Object[]{Integer.valueOf(r132.size())});
        L181:
            SpannableStringBuilder r182 = new SpannableStringBuilder(s1.C(R.string.ttlive_anchor_link_info_new_room_status, new Object[]{r179}) + r104 + r133);
            r182.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#161823")), 2, r179.length() + 2, 33);
            AnchorLinkInfoView r183 = r101.f540234k;
            if (r183 == null) goto L189;
            TextView r184 = r183.getTvAnchorLinkInfo();
            if (r184 == null) goto L189;
            r184.setText(r182);
        L175:
            r178 = 0;
        L169:
            r175 = 0;
            goto L170
        L163:
            r171 = null;
            goto L164
        L177:
            r179 = "";
        L135:
            r136 = 8;
            goto L136
        L123:
            if ((!Intrinsics.areEqual(r100.f535723j, r101.f540245v)) == true) goto L130;
            if ((!Intrinsics.areEqual(r100.f535724k, r101.f540246w)) == true) goto L130;
            if ((!Intrinsics.areEqual(r100.f535725l, r101.f540247x)) == true) goto L130;
            if ((!Intrinsics.areEqual(r100.f535732s, r101.E)) == false) goto L191;
        L66:
            if ((!Intrinsics.areEqual(r100.f535719f, r101.f540241r)) == true) goto L71;
            if ((!Intrinsics.areEqual(r100.f535720g, r101.f540242s)) == true) goto L71;
            if ((!Intrinsics.areEqual(r100.f535721h, r101.f540243t)) == false) goto L121;
        }
    }

    @Override // t21.a
    public final h.a a() {
        Context r100 = this.f540224a;
        Intrinsics.checkNotNull(r100);
        return new h.a(r100);
    }

    @Override // t21.a
    public final void init() {
        View r100 = this.H.inflate(R.layout.ttlive_item_anchor_link, this.I, false);
        this.f540225b = r100;
        Button r101 = null;
        if (r100 == null) goto L5;
        Context r102 = r100.getContext();
    L6:
        this.f540224a = r102;
        View r103 = this.f540225b;
        if (r103 == null) goto L9;
        VHeadView r104 = (VHeadView) r103.findViewById(R.id.iv_avatar);
    L10:
        this.f540226c = r104;
        View r105 = this.f540225b;
        if (r105 == null) goto L13;
        VHeadView r106 = (VHeadView) r105.findViewById(R.id.iv_gender);
    L14:
        this.f540227d = r106;
        View r107 = this.f540225b;
        if (r107 == null) goto L17;
        TextView r108 = (TextView) r107.findViewById(R.id.tv_nick_name);
    L18:
        this.f540228e = r108;
        View r109 = this.f540225b;
        if (r109 == null) goto L21;
        PkTagsContainerView r110 = (PkTagsContainerView) r109.findViewById(R.id.tags_container);
    L22:
        this.f540229f = r110;
        View r111 = this.f540225b;
        if (r111 == null) goto L25;
        ViewGroup r112 = (ViewGroup) r111.findViewById(R.id.location_container);
    L26:
        this.f540230g = r112;
        View r113 = this.f540225b;
        if (r113 == null) goto L29;
        ImageView r114 = (ImageView) r113.findViewById(R.id.iv_location);
    L29:
        View r115 = this.f540225b;
        if (r115 == null) goto L32;
        TextView r116 = (TextView) r115.findViewById(R.id.tv_distance);
    L32:
        View r117 = this.f540225b;
        if (r117 == null) goto L35;
        ViewGroup r118 = (ViewGroup) r117.findViewById(R.id.audience_num_container);
    L36:
        this.f540231h = r118;
        View r119 = this.f540225b;
        if (r119 == null) goto L39;
        ImageView r120 = (ImageView) r119.findViewById(R.id.iv_audience);
    L40:
        this.f540232i = r120;
        View r121 = this.f540225b;
        if (r121 == null) goto L43;
        TextView r122 = (TextView) r121.findViewById(R.id.tv_audience);
    L44:
        this.f540233j = r122;
        View r123 = this.f540225b;
        if (r123 == null) goto L47;
        AnchorLinkInfoView r124 = (AnchorLinkInfoView) r123.findViewById(R.id.view_link_info);
    L48:
        this.f540234k = r124;
        View r125 = this.f540225b;
        if (r125 == null) goto L51;
        r101 = (Button) r125.findViewById(R.id.bt_invite_or_apply);
    L51:
        this.f540235l = r101;
        ViewGroup r126 = this.f540231h;
        if (r126 == null) goto L54;
        r126.setVisibility(0);
    L54:
        PkTagsContainerView r127 = this.f540229f;
        if (r127 == null) goto L57;
        r127.setVisibility(0);
    L57:
        ViewGroup r128 = this.f540230g;
        if (r128 == null) goto L61;
        r128.setVisibility(8);
        return;
    L61:
        return;
    L47:
        r124 = null;
        goto L48
    L43:
        r122 = null;
        goto L44
    L39:
        r120 = null;
        goto L40
    L35:
        r118 = null;
        goto L36
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
        return this.f540225b;
    }

    @Override // t21.a
    public final void b(MutableLiveData r100) {
        Intrinsics.checkNotNullParameter(r100, "uiStateLiveData");
        Intrinsics.checkNotNull(r100);
        x.e(r100, this.G);
    }

    public b(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.H = r100;
        this.I = r101;
        this.G = new a(this);
    }
}
