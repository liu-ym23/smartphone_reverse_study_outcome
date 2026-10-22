package com.bytedance.awemeopen.apps.framework.comment.view.holder;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.j;
import com.bytedance.awemeopen.apps.framework.comment.util.e;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.d;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.f;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.g;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.h;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.k;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.l;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.m;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BuryView2;
import com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.DiggNewView2;
import com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import com.bytedance.awemeopen.apps.framework.utils.f0;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import com.bytedance.awemeopen.bizmodels.comment.CommentImageStruct;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfigBuilder;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.search.serviceapi.AoSearchService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;
import sy3.i;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/BaseCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class BaseCommentViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int B = 0;
    public final int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f194271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentPageParam f194272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f194273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AoImageView f194274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f194275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f194276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f194277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f194278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MentionTextView f194279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f194280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f194281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f194282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o14.a f194283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f194284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h f194285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f194286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewStub f194287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AoImageView f194288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f194289s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f194290t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f194291u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewStub f194292v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AoImageView f194293w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f194294x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f194295y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f194296z;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCommentViewHolder f194297a;

        public a(BaseCommentViewHolder r100) {
            this.f194297a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.m
        public final void a(o14.a r100, com.bytedance.awemeopen.apps.framework.comment.view.diggbury.a r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            Intrinsics.checkNotNullParameter(r101, "param");
            this.f194297a.f194271a.k(r101.f194228a, r101.f194231d);
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.m
        public final void b(o14.a r100, com.bytedance.awemeopen.apps.framework.comment.view.diggbury.a r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            Intrinsics.checkNotNullParameter(r101, "param");
            this.f194297a.f194271a.k(r101.f194228a, r101.f194231d);
        }
    }

    public static final class b implements com.bytedance.awemeopen.infra.base.image.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCommentViewHolder f194298a;

        @Override // com.bytedance.awemeopen.infra.base.image.a
        public final void onFail() {
            this.f194298a.f194294x = true;
        }

        @Override // com.bytedance.awemeopen.infra.base.image.a
        public final void onSuccess() {
            this.f194298a.f194294x = false;
        }

        public b(BaseCommentViewHolder r100) {
            this.f194298a = r100;
        }
    }

    public static final class c implements com.bytedance.awemeopen.infra.base.image.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCommentViewHolder f194299a;

        @Override // com.bytedance.awemeopen.infra.base.image.a
        public final void onFail() {
            AoImageView r100 = this.f194299a.f194288r;
            Intrinsics.checkNotNull(r100);
            r100.setBackgroundResource(R.color.aos_bg_tertiary);
            AoImageView r101 = this.f194299a.f194288r;
            Intrinsics.checkNotNull(r101);
            r101.setImageResource(R.drawable.aos_aweme_comment_img_comment_gif_emoji_retry);
            this.f194299a.f194289s = true;
        }

        @Override // com.bytedance.awemeopen.infra.base.image.a
        public final void onSuccess() {
            this.f194299a.f194289s = false;
        }

        public c(BaseCommentViewHolder r100) {
            this.f194299a = r100;
        }
    }

    public abstract String U3();

    public final void T3(o14.a r110) {
        Intrinsics.checkNotNullParameter(r110, "comment");
        this.f194283m = r110;
        boolean r100 = true;
        if (this.f194273c.f543876a == false) goto L10;
        if (r110.q() != 1) goto L10;
        if (r110.d() > 0) goto L10;
        r110.s(1);
    L10:
        if (this.f194273c.f543877b == false) goto L13;
        this.f194274d.post(new sy3.b(this));
    L13:
        if (this.f194273c.f543876a == false) goto L19;
        View r101 = this.itemView;
        o14.a r102 = this.f194283m;
        Intrinsics.checkNotNull(r102);
        h r103 = new h(r101, r102, this.f194284n);
        this.f194285o = r103;
        r103.a(this.f194281k);
        if (x54.b.c(this.f194282l) == false) goto L19;
        h r104 = this.f194285o;
        if (r104 == null) goto L19;
        r104.a(this.f194282l);
    L19:
        User r105 = r110.o();
        final t14.a r106 = null;
        if (r105 == null) goto L22;
        t14.a r107 = r105.a();
    L23:
        AoImageView r108 = this.f194274d;
        if (r107 == null) goto L30;
        List<String> r109 = r107.g();
        if (r109 == null) goto L30;
        if ((!r109.isEmpty()) != true) goto L30;
        boolean r111 = true;
    L32:
        if (r111 == false) goto L34;
        List<String> r112 = r107.g();
        Intrinsics.checkNotNull(r112);
        com.bytedance.awemeopen.infra.base.image.b r113 = new com.bytedance.awemeopen.infra.base.image.b(r112);
    L35:
        r113.b(R.drawable.aos_ic_img_signin_defaultavatar);
        r113.f198623d = r108;
        r113.f198632m = ImageView.ScaleType.CENTER_CROP;
        r113.f198637r = true;
        r108.j(r113);
        TextView r114 = this.f194275e;
        String r115 = "";
        if (r105 == null) goto L38;
        String r116 = r105.t();
    L39:
        r114.setText(r116);
        Intrinsics.checkNotNullParameter(r110, "comment");
        String r117 = r110.g();
        if (r117 != null) goto L42;
    L45:
        boolean r118 = true;
    L47:
        if (r118 == false) goto L60;
        User r119 = r110.o();
        if (r119 == null) goto L51;
        String r120 = r119.u();
    L52:
        d14.a r121 = b14.a.f16924a;
        com.bytedance.awemeopen.bizmodels.user.c r122 = ((k34.b) b14.a.a(k34.b.class)).getAccessToken();
        if (r122 == null) goto L55;
        String r123 = r122.f198218b;
    L57:
        if (Intrinsics.areEqual(r120, r123) == false) goto L59;
        r110.t();
        goto L60
    L59:
        this.f194276f.setVisibility(8);
    L78:
        Intrinsics.checkNotNullParameter(r110, "comment");
        TextView r124 = this.f194278h;
        if (r124 == null) goto L91;
        ViewParent r125 = r124.getParent();
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r126 = (ViewGroup) r125;
        String r127 = r110.k();
        if (r127 != null) goto L84;
    L87:
        boolean r128 = true;
    L88:
        if (r128 == false) goto L90;
        x54.b.a(r126);
        goto L91
    L90:
        r124.setText(r127);
        x54.b.d(r126);
        goto L91
    L84:
        if (r127.length() == 0) goto L87;
        r128 = false;
    L91:
        String r129 = U3();
        if (TextUtils.isEmpty(r129) == true) goto L96;
        this.f194279i.setText(r129);
        this.f194279i.setVisibility(0);
        v04.b.a(this.f194279i);
        h r130 = this.f194285o;
        if (r130 == null) goto L97;
        r130.a(this.f194279i);
    L97:
        o14.a r131 = this.f194283m;
        Intrinsics.checkNotNull(r131);
        if (com.bytedance.awemeopen.infra.util.d.a(r131.m()) == true) goto L109;
        MentionTextView r132 = this.f194279i;
        r132.setSpanColor(r132.getResources().getColor(R.color.aos_color_eba825_90));
        this.f194279i.setOnSpanClickListener(new sy3.a(this));
        o14.a r133 = this.f194283m;
        Intrinsics.checkNotNull(r133);
        List r134 = e.b(r133, this.f194279i.getContext());
        this.f194272b.getClass();
        ArrayList r135 = new ArrayList();
        Iterator r136 = r134.iterator();
    L101:
        if (r136.hasNext() == false) goto L108;
        Object r137 = r136.next();
        if (((TextExtraStruct) r137).getType() == 5) goto L105;
        boolean r138 = true;
    L106:
        if (r138 == false) goto L101;
        r135.add(r137);
        goto L101
    L105:
        r138 = false;
        goto L106
    L108:
        this.f194279i.y(r135, null);
    L109:
        Y3(r110, false);
        this.f194294x = false;
        this.f194289s = false;
        o14.a r139 = this.f194283m;
        if (r139 == null) goto L119;
        List<CommentImageStruct> r140 = r139.f();
        if (r140 == null) goto L119;
        CommentImageStruct r141 = (CommentImageStruct) CollectionsKt.firstOrNull(r140);
        if (r141 == null) goto L119;
        r106 = r141.getOriginUrl();
        if (r106 != null) goto L119;
        r106 = r141.getCropUrl();
    L119:
        if (r106 != null) goto L121;
        AoImageView r142 = this.f194293w;
        if (r142 == null) goto L148;
        x54.b.a(r142);
    L148:
        AoImageView r143 = this.f194293w;
        if (r143 != null) goto L151;
    L153:
        boolean r144 = false;
    L154:
        if (r144 == false) goto L158;
        AoImageView r145 = this.f194288r;
        if (r145 == null) goto L190;
        x54.b.a(r145);
    L190:
        AoImageView r146 = this.f194293w;
        if (r146 != null) goto L193;
    L195:
        boolean r147 = false;
    L196:
        if (r147 == true) goto L206;
        AoImageView r148 = this.f194288r;
        if (r148 != null) goto L200;
    L202:
        boolean r149 = false;
    L203:
        if (r149 == true) goto L206;
        x54.b.a(this.f194286p);
    L209:
        Intrinsics.checkNotNullParameter(r110, "comment");
        this.f194281k.setVisibility(0);
        this.f194281k.setText(k0.a(this.itemView.getContext(), r110.c() * 1000));
        if (this.f194272b.f194088n == true) goto L224;
        int r150 = f0.f197695a;
        if (f0.a(this.f194279i.getContext()) == true) goto L244;
        ImageView r151 = this.f194277g;
        if (r151 == null) goto L216;
        r151.setImageResource(R.drawable.aweme_comment_icon_reply_to_reply_simplified_light);
    L216:
        o14.a r152 = this.f194283m;
        if (r152 != null) goto L219;
    L221:
        boolean r153 = false;
    L222:
        if (r153 == true) goto L244;
        this.f194276f.setTextColor(this.f194279i.getContext().getResources().getColor(R.color.aos_text_reverse3));
        this.f194276f.setBackgroundResource(R.drawable.aos_comment_tag_style_follow_new_light);
        goto L244
    L219:
        if (r152.h() != 1) goto L221;
        r153 = true;
    L244:
        h r154 = this.f194285o;
        if (r154 != null) goto L247;
    L260:
        List<TextExtraStruct> r155 = r110.m();
        if (r155 != null) goto L263;
    L265:
        boolean r156 = false;
    L266:
        if (r156 == false) goto L282;
        AoSearchService r157 = (AoSearchService) j64.a.a(AoSearchService.class);
        if (r157 != null) goto L270;
    L272:
        r100 = false;
    L273:
        if (r100 == false) goto L283;
        this.f194272b.getClass();
        return;
    L283:
        return;
    L270:
        if (r157.isAvailable() != true) goto L272;
    L282:
        return;
    L263:
        if ((!r155.isEmpty()) != true) goto L265;
        r156 = true;
        goto L266
    L247:
        if (r154.f194253f == true) goto L260;
        r154.f194254g = r154.f194249b.p();
        r154.b();
        if (r154.f194249b.p() == false) goto L257;
        Iterator r158 = ((ArrayList) r154.f194251d).iterator();
    L252:
        if (r158.hasNext() == false) goto L254;
        x54.b.a((View) r158.next());
        goto L252
    L254:
        DuxTextView r159 = r154.f194252e;
        if (r159 == null) goto L260;
        r154.c(r159);
        x54.b.d(r159);
        goto L260
    L257:
        DuxTextView r160 = r154.f194252e;
        if (r160 == null) goto L260;
        x54.b.a(r160);
        goto L260
    L224:
        this.itemView.setBackground(this.f194279i.getContext().getDrawable(R.drawable.aos_comment_bg_layout_light));
        this.f194275e.setTextColor(this.f194279i.getContext().getResources().getColor(R.color.aos_text_tertiary_light));
        o14.a r161 = this.f194283m;
        if (r161 != null) goto L227;
    L229:
        boolean r162 = false;
    L230:
        if (r162 == true) goto L232;
        this.f194276f.setTextColor(this.f194279i.getContext().getResources().getColor(R.color.aos_text_reverse3));
        this.f194276f.setBackgroundResource(R.drawable.aos_comment_tag_style_follow_new_light);
    L232:
        int r163 = f0.f197695a;
        if (f0.a(this.f194279i.getContext()) == false) goto L237;
        ImageView r164 = this.f194277g;
        if (r164 == null) goto L240;
        r164.setImageResource(R.drawable.aweme_comment_icon_reply_to_reply_simplified_dark);
    L240:
        TextView r165 = this.f194278h;
        if (r165 == null) goto L243;
        r165.setTextColor(this.f194279i.getContext().getResources().getColor(R.color.aos_text_tertiary_light));
    L243:
        MentionTextView r166 = this.f194279i;
        r166.setTextColor(r166.getContext().getResources().getColor(R.color.aos_text_primary_light));
        this.f194281k.setTextColor(this.f194279i.getContext().getResources().getColor(R.color.aos_text_quaternary_light));
        this.f194282l.setTextColor(this.f194279i.getContext().getResources().getColor(R.color.aos_text_tertiary_light));
        goto L244
    L237:
        ImageView r167 = this.f194277g;
        if (r167 == null) goto L240;
        r167.setImageResource(R.drawable.aweme_comment_icon_reply_to_reply_simplified_light);
        goto L240
    L227:
        if (r161.h() != 1) goto L229;
        r162 = true;
        goto L230
    L200:
        if (x54.b.c(r148) != true) goto L202;
        r149 = true;
    L206:
        x54.b.d(this.f194286p);
        h r168 = this.f194285o;
        if (r168 == null) goto L209;
        r168.a(this.f194286p);
        goto L209
    L193:
        if (x54.b.c(r146) != true) goto L195;
        r147 = true;
        goto L196
    L158:
        o14.a r169 = this.f194283m;
        if (r169 == null) goto L169;
        q14.a r170 = r169.e();
        if (r170 == null) goto L169;
        t14.a r171 = r170.a();
        if (r171 == null) goto L169;
        List<String> r172 = r171.g();
        if (r172 == null) goto L169;
        if ((!r172.isEmpty()) != true) goto L169;
        boolean r173 = true;
    L170:
        if (r173 == true) goto L172;
        AoImageView r174 = this.f194288r;
        if (r174 == null) goto L190;
        x54.b.a(r174);
        goto L190
    L172:
        if (this.f194288r != null) goto L179;
        View r175 = this.f194287q.inflate();
        Intrinsics.checkNotNull(r175, "null cannot be cast to non-null type com.bytedance.awemeopen.infra.base.image.AoImageView");
        AoImageView r176 = (AoImageView) r175;
        this.f194288r = r176;
        if (r176 == null) goto L176;
        r176.setBackgroundColor(y54.a.a().getResources().getColor(R.color.aos_const_text_inverse));
    L176:
        AoImageView r177 = this.f194288r;
        if (r177 == null) goto L179;
        r177.setOnClickListener(new sy3.d(this));
    L179:
        AoImageView r178 = this.f194288r;
        if (r178 == null) goto L182;
        x54.b.d(r178);
    L182:
        o14.a r179 = this.f194283m;
        if (r179 == null) goto L190;
        q14.a r180 = r179.e();
        if (r180 == null) goto L190;
        X3(r180);
    L169:
        r173 = false;
        goto L170
    L151:
        if (x54.b.c(r143) != true) goto L153;
        r144 = true;
        goto L154
    L121:
        if (this.f194293w != null) goto L125;
        View r181 = this.f194292v.inflate();
        Intrinsics.checkNotNull(r181, "null cannot be cast to non-null type com.bytedance.awemeopen.infra.base.image.AoImageView");
        AoImageView r182 = (AoImageView) r181;
        this.f194293w = r182;
        if (r182 == null) goto L125;
        r182.setOnClickListener(new sy3.c(this, r106));
    L125:
        AoImageView r183 = this.f194293w;
        if (r183 == null) goto L148;
        x54.b.d(r183);
        int r184 = r106.h();
        int r185 = r106.c();
        if (r184 <= 0) goto L143;
        if (r185 <= 0) goto L143;
        Integer r186 = Integer.valueOf(r184);
        Integer r187 = Integer.valueOf(r185);
        if (r186 == null) goto L144;
        if (r187 == null) goto L144;
        Pair r188 = TuplesKt.to(Integer.valueOf(this.f194296z), Integer.valueOf(this.f194296z));
        Pair r189 = TuplesKt.to(Integer.valueOf(this.A), Integer.valueOf(this.f194296z));
        Pair r190 = TuplesKt.to(Integer.valueOf(this.f194296z), Integer.valueOf(this.A));
        if (r186.intValue() >= r187.intValue()) goto L138;
        com.bytedance.awemeopen.apps.framework.comment.util.c.b(r183, ((Number) r189.getFirst()).intValue(), ((Number) r189.getSecond()).intValue());
        goto L144
    L138:
        if (r186.intValue() <= r187.intValue()) goto L141;
        com.bytedance.awemeopen.apps.framework.comment.util.c.b(r183, ((Number) r190.getFirst()).intValue(), ((Number) r190.getSecond()).intValue());
        goto L144
    L141:
        if (Intrinsics.areEqual(r186, r187) == false) goto L144;
        com.bytedance.awemeopen.apps.framework.comment.util.c.b(r183, ((Number) r188.getFirst()).intValue(), ((Number) r188.getSecond()).intValue());
    L144:
        W3(r106);
    L143:
        ViewGroup.LayoutParams r191 = r183.getLayoutParams();
        r191.width = this.f194290t;
        r183.setLayoutParams(r191);
        goto L144
    L96:
        this.f194279i.setVisibility(8);
        goto L97
    L55:
        r123 = null;
        goto L57
    L51:
        r120 = null;
    L60:
        this.f194276f.setVisibility(0);
        User r192 = r110.o();
        if (r192 == null) goto L63;
        String r193 = r192.x();
    L65:
        if (TextUtils.isEmpty(r193) == false) goto L67;
        this.f194276f.setText(r110.g());
    L74:
        if (r110.h() != 1) goto L76;
        this.f194276f.setBackgroundResource(R.drawable.comment_tag_style_author);
    L77:
        this.f194276f.setTextColor(this.f194279i.getContext().getResources().getColor(R.color.aos_const_text_inverse));
        goto L78
    L76:
        this.f194276f.setBackgroundResource(R.drawable.aos_comment_tag_style_follow_new);
        goto L77
    L67:
        TextView r194 = this.f194276f;
        User r195 = r110.o();
        if (r195 == null) goto L72;
        String r196 = r195.x();
        if (r196 == null) goto L72;
        r115 = r196;
    L72:
        r194.setText(r115);
        goto L74
    L63:
        r193 = null;
        goto L65
    L42:
        if (r117.length() == 0) goto L45;
        r118 = false;
        goto L47
    L38:
        r116 = "";
        goto L39
    L34:
        r113 = new com.bytedance.awemeopen.infra.base.image.b(R.drawable.aos_ic_img_signin_defaultavatar);
    L30:
        r111 = false;
        goto L32
    L22:
        r107 = null;
        goto L23
    }

    public final void V3(String r100) {
        if (this.f194273c.f543877b == true) goto L5;
        return;
    L5:
        Context r101 = this.itemView.getContext();
        if ((r101 instanceof Activity) == false) goto L8;
        Activity r102 = (Activity) r101;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        CommentPageParam r103 = this.f194272b;
        if (r103.f194090p == false) goto L14;
        return;
    L14:
        if (r103.f194091q == true) goto L64;
        String r104 = r103.f194085k;
        if (r104 != null) goto L19;
    L24:
        boolean r105 = false;
    L25:
        if (r105 == true) goto L61;
        String r106 = null;
    L35:
        ProfilePageConfigBuilder.Companion.getClass();
        ProfilePageConfigBuilder r107 = new ProfilePageConfigBuilder();
        String r108 = this.f194272b.f194081g;
        String r109 = "";
        if (r108 != null) goto L38;
        r108 = "";
    L38:
        ProfilePageConfigBuilder r110 = r107.withSceneId(r108);
        if (r100 != null) goto L41;
        String r111 = "";
    L42:
        ProfilePageConfigBuilder r112 = r110.withOpenId(r111);
        o14.a r113 = this.f194283m;
        if (r113 == null) goto L46;
        String r114 = r113.b();
        if (r114 == null) goto L46;
    L47:
        ProfilePageConfigBuilder r115 = r112.withAid(r114);
        String r116 = this.f194272b.f194082h;
        if (r116 != null) goto L50;
        r116 = "";
    L50:
        ProfilePageConfigBuilder r117 = r115.withFromReqId(r116);
        if (r106 != null) goto L53;
        r106 = "";
    L53:
        ProfilePageConfigBuilder r118 = r117.withUserProfile(r106).withIsLiveType(false).withHideLongPressTab(false);
        String r119 = this.f194272b.f194093s;
        if (r119 == null) goto L57;
        r109 = r119;
    L57:
        ProfilePageConfigBuilder r120 = r118.withActionType(r109);
        JSONObject r121 = new JSONObject();
        r121.put("host_enter_from", this.f194272b.f194092r);
        ProfilePageConfig r122 = r120.withHostCommonParams(r121).withHideRecently(!Intrinsics.areEqual(r100, this.f194272b.f194076b)).build();
        int r123 = vz3.a.f557701a;
        vz3.a.a(r102, r122, null);
        return;
    L46:
        r114 = "";
        goto L47
    L41:
        r111 = r100;
        goto L42
    L61:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L31
        r106 = new JSONObject(this.f194272b.f194085k).optString("host_user_profile");     // Catch: Throwable -> L31
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L29:
        Throwable th10 = th;
    L33:
        Result.Companion r125 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L31:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L33
    L19:
        if (r104.length() <= 0) goto L21;
        boolean r126 = true;
    L22:
        if (r126 != true) goto L24;
        r105 = true;
        goto L25
    L21:
        r126 = false;
        goto L22
    L64:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void W3(t14.a r100) {
        if (this.f194295y != null) goto L5;
        this.f194295y = new b(this);
    L5:
        List<String> r101 = r100.g();
        List<String> r102 = r101;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L17;
        b r104 = this.f194295y;
        if (r104 == null) goto L21;
        r104.onFail();
        return;
    L21:
        return;
    L17:
        com.bytedance.awemeopen.infra.base.image.b r105 = new com.bytedance.awemeopen.infra.base.image.b(r101);
        r105.f198641v = true;
        r105.f198624e = this.f194295y;
        ColorDrawable r106 = new ColorDrawable();
        r106.setColor(this.f194279i.getContext().getResources().getColor(R.color.aos_bg_placeholder_default));
        r105.f198627h = 0;
        r105.f198626g = r106;
        r105.f198632m = ImageView.ScaleType.CENTER_CROP;
        AoImageView r107 = this.f194293w;
        if (r107 == null) goto L22;
        r107.j(r105);
        return;
    L22:
        return;
    L8:
        if (r102.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public final void X3(q14.a r100) {
        if (r100 == null) goto L16;
        t14.a r101 = r100.a();
        if (r101 == null) goto L17;
        List<String> r102 = r101.g();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.f194291u != null) goto L14;
        this.f194291u = new c(this);
    L14:
        com.bytedance.awemeopen.infra.base.image.b r103 = new com.bytedance.awemeopen.infra.base.image.b(r102);
        r103.f198641v = true;
        r103.f198624e = this.f194291u;
        r103.f198632m = ImageView.ScaleType.CENTER_CROP;
        AoImageView r104 = this.f194288r;
        Intrinsics.checkNotNull(r104);
        r104.j(r103);
        return;
    L17:
        return;
    }

    public final void Y3(o14.a r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "comment");
        d r101 = this.f194284n;
        if (r101 == null) goto L14;
        if (r100 == null) goto L14;
        r101.f194241g = r100;
        r101.f194242h = r100.d();
        DiggNewView2 r102 = r101.f194239e;
        if (r102 == null) goto L9;
        r102.b(r100.r(), false, r101.f194242h);
    L9:
        BuryView2 r103 = r101.f194240f;
        if (r103 == null) goto L12;
        r103.b(r100.p(), false, 0);
    L12:
        if (r110 == false) goto L14;
        r101.f194244j = false;
    L14:
        if (r110 == false) goto L31;
        final h r104 = this.f194285o;
        if (r104 != null) goto L18;
        return;
    L18:
        if (r104.f194249b.p() == false) goto L22;
        if (r104.f194254g == false) goto L22;
        return;
    L22:
        if (r104.f194249b.p() == true) goto L27;
        if (r104.f194254g == true) goto L27;
        return;
    L27:
        if (r104.f194249b.p() == false) goto L29;
        r104.f194253f = true;
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r111.setDuration(200);
        r111.addUpdateListener(new g(r104));
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r104.f194252e, "alpha", new float[]{0.0f, 1.0f});
        r105.setDuration(200);
        AnimatorSet r106 = new AnimatorSet();
        r106.playTogether(new Animator[]{r111, r105});
        r106.addListener(new com.bytedance.awemeopen.apps.framework.comment.view.diggbury.j(r104));
        r106.addListener(new com.bytedance.awemeopen.apps.framework.comment.view.diggbury.i(r104));
        r106.start();
        return;
    L29:
        r104.f194253f = true;
        ValueAnimator r112 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r112.setDuration(200);
        r112.addUpdateListener(new com.bytedance.awemeopen.apps.framework.comment.view.diggbury.e(r104));
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r107.setDuration(200);
        r107.addUpdateListener(new f(r104));
        AnimatorSet r108 = new AnimatorSet();
        r108.playTogether(new Animator[]{r107, r112});
        r108.addListener(new l(r104));
        r108.addListener(new k(r104));
        r108.start();
        return;
    }

    public BaseCommentViewHolder(View r100, j r101, CommentPageParam r110, i r111) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "pageParam");
        Intrinsics.checkNotNullParameter(r111, "commentViewConfig");
        super(r100);
        this.f194271a = r101;
        this.f194272b = r110;
        this.f194273c = r111;
        this.f194274d = (AoImageView) r100.findViewById(R.id.avatar);
        this.f194275e = (TextView) r100.findViewById(R.id.title);
        this.f194276f = (TextView) r100.findViewById(R.id.style);
        this.f194277g = (ImageView) r100.findViewById(R.id.reply_to_img);
        this.f194278h = (TextView) r100.findViewById(R.id.reply_to);
        this.f194279i = (MentionTextView) r100.findViewById(R.id.content);
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.digg_bury_container);
        this.f194280j = r102;
        this.f194281k = (TextView) r100.findViewById(R.id.time);
        TextView r103 = (TextView) r100.findViewById(R.id.reply);
        this.f194282l = r103;
        this.f194286p = r100.findViewById(R.id.view_stubs);
        this.f194287q = (ViewStub) r100.findViewById(R.id.gif_emoji_view_stub);
        Resources r104 = Resources.getSystem();
        this.f194290t = MathKt.roundToInt(TypedValue.applyDimension(1, 100, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        Resources r105 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 180, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        this.f194292v = (ViewStub) r100.findViewById(R.id.image_view_stub);
        if (r111.f543876a == false) goto L51;
        d r106 = new d(r100.getContext(), r110, r111);
        this.f194284n = r106;
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        DiggNewView2 r112 = r106.f194239e;
        ViewParent r107 = null;
        if (r112 == null) goto L7;
        ViewParent r113 = r112.getParent();
    L9:
        if (r113 != null) goto L16;
        BuryView2 r114 = r106.f194240f;
        if (r114 == null) goto L13;
        r107 = r114.getParent();
    L13:
        if (r107 != null) goto L16;
        boolean r115 = false;
    L17:
        if (r115 == true) goto L50;
        r106.f194238d = r102;
        DiggNewView2 r108 = new DiggNewView2(r106.f194235a);
        r106.f194239e = r108;
        r108.setId(R.id.aos_comment_digg_view);
        DiggNewView2 r109 = r106.f194239e;
        if (r109 == null) goto L23;
        r109.setClipChildren(false);
    L23:
        DiggNewView2 r116 = r106.f194239e;
        if (r116 == null) goto L26;
        r116.setPadding(x54.a.a(4), 0, x54.a.a(2), 0);
    L26:
        ViewGroup r117 = r106.f194238d;
        if (r117 == null) goto L29;
        r117.addView(r106.f194239e, -2, x54.a.a(32));
    L29:
        DiggNewView2 r118 = r106.f194239e;
        if (r118 == null) goto L32;
        r118.setOnClickListener(r106);
    L32:
        BuryView2 r119 = new BuryView2(r106.f194235a);
        r106.f194240f = r119;
        r119.setId(R.id.aos_comment_bury_view);
        BuryView2 r120 = r106.f194240f;
        if (r120 == null) goto L36;
        r120.setClipChildren(false);
    L36:
        BuryView2 r121 = r106.f194240f;
        if (r121 == null) goto L39;
        r121.setPadding(x54.a.a(6), 0, x54.a.a(6), 0);
    L39:
        ViewGroup r122 = r106.f194238d;
        if (r122 == null) goto L42;
        r122.addView(r106.f194240f, -2, x54.a.a(32));
    L42:
        BuryView2 r123 = r106.f194240f;
        if (r123 == null) goto L45;
        r123.setOnClickListener(r106);
    L45:
        ViewGroup r124 = r106.f194238d;
        if (r124 == null) goto L49;
        r124.setVisibility(0);
    L49:
        r106.f194244j = false;
    L50:
        a r125 = new a(this);
        Intrinsics.checkNotNullParameter(r125, "clickListener");
        r106.f194243i = r125;
    L16:
        r115 = true;
        goto L17
    L7:
        r113 = null;
    L51:
        r100.setOnLongClickListener(new sy3.e(this));
        if (AosExtConfig.f193138b.getCommentConfig().f1846f == true) goto L54;
    L56:
        x54.b.a(r103);
    L57:
        Resources r126 = Resources.getSystem();
        this.f194296z = MathKt.roundToInt(TypedValue.applyDimension(1, 166, WindowDisplayMetricsOverride.apply(r126, r126.getDisplayMetrics())));
        Resources r127 = Resources.getSystem();
        this.A = MathKt.roundToInt(TypedValue.applyDimension(1, 124, WindowDisplayMetricsOverride.apply(r127, r127.getDisplayMetrics())));
        return;
    L54:
        if (r110.f194089o == true) goto L56;
        r100.setOnClickListener(new sy3.f(this));
        x54.b.d(r103);
        goto L57
    }
}
