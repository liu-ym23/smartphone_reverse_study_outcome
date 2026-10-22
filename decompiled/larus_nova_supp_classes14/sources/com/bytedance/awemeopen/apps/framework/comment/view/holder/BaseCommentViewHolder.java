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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
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
import com.bytedance.awemeopen.apps.framework.utils.f0;
import com.bytedance.awemeopen.apps.framework.utils.k0;
import com.bytedance.awemeopen.bizmodels.comment.CommentImageStruct;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfigBuilder;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.search.serviceapi.AoSearchService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/holder/BaseCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class BaseCommentViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int B = 0;
    public final int A;
    public final j a;
    public final CommentPageParam b;
    public final i c;
    public final AoImageView d;
    public final TextView e;
    public final TextView f;
    public final ImageView g;
    public final TextView h;
    public final MentionTextView i;
    public final ViewGroup j;
    public final TextView k;
    public final TextView l;
    public o14.a m;
    public final d n;
    public h o;
    public final View p;
    public final ViewStub q;
    public AoImageView r;
    public boolean s;
    public final int t;
    public c u;
    public final ViewStub v;
    public AoImageView w;
    public boolean x;
    public b y;
    public final int z;

    public static final class a implements m {
        public final /* synthetic */ BaseCommentViewHolder a;

        public a(BaseCommentViewHolder r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.m
        public final void a(o14.a r2, com.bytedance.awemeopen.apps.framework.comment.view.diggbury.a r3) {
            Intrinsics.checkNotNullParameter(r2, "comment");
            Intrinsics.checkNotNullParameter(r3, "param");
            this.a.a.k(r3.a, r3.d);
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.m
        public final void b(o14.a r2, com.bytedance.awemeopen.apps.framework.comment.view.diggbury.a r3) {
            Intrinsics.checkNotNullParameter(r2, "comment");
            Intrinsics.checkNotNullParameter(r3, "param");
            this.a.a.k(r3.a, r3.d);
        }
    }

    public static final class b implements com.bytedance.awemeopen.infra.base.image.a {
        public final /* synthetic */ BaseCommentViewHolder a;

        public final void onFail() {
            this.a.x = true;
        }

        public final void onSuccess() {
            this.a.x = false;
        }

        public b(BaseCommentViewHolder r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.bytedance.awemeopen.infra.base.image.a {
        public final /* synthetic */ BaseCommentViewHolder a;

        public final void onFail() {
            AoImageView r0 = this.a.r;
            Intrinsics.checkNotNull(r0);
            r0.setBackgroundResource(2131100244);
            AoImageView r1 = this.a.r;
            Intrinsics.checkNotNull(r1);
            r1.setImageResource(2131231375);
            this.a.s = true;
        }

        public final void onSuccess() {
            this.a.s = false;
        }

        public c(BaseCommentViewHolder r1) {
            this.a = r1;
        }
    }

    public abstract String U3();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v74, types: [android.view.View, com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView] */
    /* JADX WARN: Type inference failed for: r1v87, types: [android.widget.TextView, com.bytedance.awemeopen.apps.framework.feed.desc.MentionTextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void T3(o14.a r15) {
        Intrinsics.checkNotNullParameter(r15, "comment");
        this.m = r15;
        boolean r2 = true;
        if (this.c.a == false) goto L10;
        if (r15.q() != 1) goto L10;
        if (r15.d() > 0) goto L10;
        r15.s(1);
    L10:
        if (this.c.b == false) goto L13;
        this.d.post(new sy3.b(this));
    L13:
        if (this.c.a == false) goto L19;
        View r3 = ((RecyclerView.ViewHolder) this).itemView;
        o14.a r4 = this.m;
        Intrinsics.checkNotNull(r4);
        h r1 = new h(r3, r4, this.n);
        this.o = r1;
        r1.a(this.k);
        if (x54.b.c(this.l) == false) goto L19;
        h r5 = this.o;
        if (r5 == null) goto L19;
        r5.a(this.l);
    L19:
        User r6 = r15.o();
        final t14.a r7 = null;
        if (r6 == null) goto L22;
        t14.a r8 = r6.a();
    L23:
        AoImageView r9 = this.d;
        if (r8 == null) goto L30;
        List r10 = r8.g();
        if (r10 == null) goto L30;
        if ((!r10.isEmpty()) != true) goto L30;
        boolean r11 = true;
    L32:
        if (r11 == false) goto L34;
        List r12 = r8.g();
        Intrinsics.checkNotNull(r12);
        com.bytedance.awemeopen.infra.base.image.b r13 = new com.bytedance.awemeopen.infra.base.image.b(r12);
    L35:
        r13.b(2131231483);
        r13.d = r9;
        r13.m = ImageView.ScaleType.CENTER_CROP;
        r13.r = true;
        r9.j(r13);
        TextView r14 = this.e;
        String r16 = "";
        if (r6 == null) goto L38;
        String r17 = r6.t();
    L39:
        r14.setText(r17);
        Intrinsics.checkNotNullParameter(r15, "comment");
        String r18 = r15.g();
        if (r18 != null) goto L42;
    L45:
        boolean r19 = true;
    L47:
        if (r19 == false) goto L60;
        User r20 = r15.o();
        if (r20 == null) goto L51;
        String r21 = r20.u();
    L52:
        d14.a r22 = b14.a.a;
        com.bytedance.awemeopen.bizmodels.user.c r23 = b14.a.a(k34.b.class).getAccessToken();
        if (r23 == null) goto L55;
        String r24 = r23.b;
    L57:
        if (Intrinsics.areEqual(r21, r24) == false) goto L59;
        r15.t();
        goto L60
    L59:
        this.f.setVisibility(8);
    L78:
        Intrinsics.checkNotNullParameter(r15, "comment");
        TextView r25 = this.h;
        if (r25 == null) goto L91;
        ViewParent r26 = r25.getParent();
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r27 = (ViewGroup) r26;
        String r28 = r15.k();
        if (r28 != null) goto L84;
    L87:
        boolean r29 = true;
    L88:
        if (r29 == false) goto L90;
        x54.b.a(r27);
        goto L91
    L90:
        r25.setText(r28);
        x54.b.d(r27);
        goto L91
    L84:
        if (r28.length() == 0) goto L87;
        r29 = false;
    L91:
        CharSequence r30 = U3();
        if (TextUtils.isEmpty(r30) == true) goto L96;
        this.i.setText(r30);
        this.i.setVisibility(0);
        v04.b.a(this.i);
        h r31 = this.o;
        if (r31 == null) goto L97;
        r31.a(this.i);
    L97:
        o14.a r32 = this.m;
        Intrinsics.checkNotNull(r32);
        if (com.bytedance.awemeopen.infra.util.d.a(r32.m()) == true) goto L109;
        ?? r33 = this.i;
        r33.setSpanColor(r33.getResources().getColor(2131100246));
        this.i.setOnSpanClickListener(new sy3.a(this));
        o14.a r34 = this.m;
        Intrinsics.checkNotNull(r34);
        List r35 = e.b(r34, this.i.getContext());
        this.b.getClass();
        ArrayList r36 = new ArrayList();
        Iterator r37 = r35.iterator();
    L101:
        if (r37.hasNext() == false) goto L108;
        Object r38 = r37.next();
        if (((TextExtraStruct) r38).getType() == 5) goto L105;
        boolean r39 = true;
    L106:
        if (r39 == false) goto L101;
        r36.add(r38);
        goto L101
    L105:
        r39 = false;
        goto L106
    L108:
        this.i.y(r36, null);
    L109:
        Y3(r15, false);
        this.x = false;
        this.s = false;
        o14.a r40 = this.m;
        if (r40 == null) goto L119;
        List r41 = r40.f();
        if (r41 == null) goto L119;
        CommentImageStruct r42 = (CommentImageStruct) CollectionsKt.firstOrNull(r41);
        if (r42 == null) goto L119;
        r7 = r42.getOriginUrl();
        if (r7 != null) goto L119;
        r7 = r42.getCropUrl();
    L119:
        if (r7 != null) goto L121;
        AoImageView r43 = this.w;
        if (r43 == null) goto L148;
        x54.b.a(r43);
    L148:
        AoImageView r44 = this.w;
        if (r44 != null) goto L151;
    L153:
        boolean r45 = false;
    L154:
        if (r45 == false) goto L158;
        AoImageView r46 = this.r;
        if (r46 == null) goto L190;
        x54.b.a(r46);
    L190:
        AoImageView r47 = this.w;
        if (r47 != null) goto L193;
    L195:
        boolean r48 = false;
    L196:
        if (r48 == true) goto L206;
        AoImageView r49 = this.r;
        if (r49 != null) goto L200;
    L202:
        boolean r50 = false;
    L203:
        if (r50 == true) goto L206;
        x54.b.a(this.p);
    L209:
        Intrinsics.checkNotNullParameter(r15, "comment");
        this.k.setVisibility(0);
        this.k.setText(k0.a(((RecyclerView.ViewHolder) this).itemView.getContext(), r15.c() * 1000));
        if (this.b.n == true) goto L224;
        int r0 = f0.a;
        if (f0.a(this.i.getContext()) == true) goto L244;
        ImageView r51 = this.g;
        if (r51 == null) goto L216;
        r51.setImageResource(2131231787);
    L216:
        o14.a r52 = this.m;
        if (r52 != null) goto L219;
    L221:
        boolean r53 = false;
    L222:
        if (r53 == true) goto L244;
        this.f.setTextColor(this.i.getContext().getResources().getColor(2131100342));
        this.f.setBackgroundResource(2131231400);
        goto L244
    L219:
        if (r52.h() != 1) goto L221;
        r53 = true;
    L244:
        h r54 = this.o;
        if (r54 != 0) goto L247;
    L260:
        List r110 = r15.m();
        if (r110 != null) goto L263;
    L265:
        boolean r111 = false;
    L266:
        if (r111 == false) goto L282;
        AoSearchService r112 = j64.a.a(AoSearchService.class);
        if (r112 != null) goto L270;
    L272:
        r2 = false;
    L273:
        if (r2 == false) goto L283;
        this.b.getClass();
        return;
    L283:
        return;
    L270:
        if (r112.isAvailable() != true) goto L272;
    L282:
        return;
    L263:
        if ((!r110.isEmpty()) != true) goto L265;
        r111 = true;
        goto L266
    L247:
        if (r54.f == true) goto L260;
        r54.g = r54.b.p();
        r54.b();
        if (r54.b.p() == false) goto L257;
        Iterator r55 = ((ArrayList) r54.d).iterator();
    L252:
        if (r55.hasNext() == false) goto L254;
        x54.b.a((View) r55.next());
        goto L252
    L254:
        ?? r56 = r54.e;
        if (r56 == 0) goto L260;
        r54.c(r56);
        x54.b.d(r56);
        goto L260
    L257:
        AppCompatTextView r57 = r54.e;
        if (r57 == null) goto L260;
        x54.b.a(r57);
        goto L260
    L224:
        ((RecyclerView.ViewHolder) this).itemView.setBackground(this.i.getContext().getDrawable(2131231398));
        this.e.setTextColor(this.i.getContext().getResources().getColor(2131100344));
        o14.a r58 = this.m;
        if (r58 != null) goto L227;
    L229:
        boolean r59 = false;
    L230:
        if (r59 == true) goto L232;
        this.f.setTextColor(this.i.getContext().getResources().getColor(2131100342));
        this.f.setBackgroundResource(2131231400);
    L232:
        int r60 = f0.a;
        if (f0.a(this.i.getContext()) == false) goto L237;
        ImageView r61 = this.g;
        if (r61 == null) goto L240;
        r61.setImageResource(2131231786);
    L240:
        TextView r62 = this.h;
        if (r62 == null) goto L243;
        r62.setTextColor(this.i.getContext().getResources().getColor(2131100344));
    L243:
        AppCompatTextView r63 = this.i;
        r63.setTextColor(r63.getContext().getResources().getColor(2131100337));
        this.k.setTextColor(this.i.getContext().getResources().getColor(2131100339));
        this.l.setTextColor(this.i.getContext().getResources().getColor(2131100344));
        goto L244
    L237:
        ImageView r64 = this.g;
        if (r64 == null) goto L240;
        r64.setImageResource(2131231787);
        goto L240
    L227:
        if (r58.h() != 1) goto L229;
        r59 = true;
        goto L230
    L200:
        if (x54.b.c(r49) != true) goto L202;
        r50 = true;
    L206:
        x54.b.d(this.p);
        h r65 = this.o;
        if (r65 == null) goto L209;
        r65.a(this.p);
        goto L209
    L193:
        if (x54.b.c(r47) != true) goto L195;
        r48 = true;
        goto L196
    L158:
        o14.a r66 = this.m;
        if (r66 == null) goto L169;
        q14.a r67 = r66.e();
        if (r67 == null) goto L169;
        t14.a r68 = r67.a();
        if (r68 == null) goto L169;
        List r69 = r68.g();
        if (r69 == null) goto L169;
        if ((!r69.isEmpty()) != true) goto L169;
        boolean r70 = true;
    L170:
        if (r70 == true) goto L172;
        AoImageView r71 = this.r;
        if (r71 == null) goto L190;
        x54.b.a(r71);
        goto L190
    L172:
        if (this.r != null) goto L179;
        AoImageView r72 = this.q.inflate();
        Intrinsics.checkNotNull(r72, "null cannot be cast to non-null type com.bytedance.awemeopen.infra.base.image.AoImageView");
        AoImageView r73 = r72;
        this.r = r73;
        if (r73 == null) goto L176;
        r73.setBackgroundColor(y54.a.a().getResources().getColor(2131100271));
    L176:
        AoImageView r74 = this.r;
        if (r74 == null) goto L179;
        r74.setOnClickListener(new sy3.d(this));
    L179:
        AoImageView r75 = this.r;
        if (r75 == null) goto L182;
        x54.b.d(r75);
    L182:
        o14.a r76 = this.m;
        if (r76 == null) goto L190;
        q14.a r77 = r76.e();
        if (r77 == null) goto L190;
        X3(r77);
    L169:
        r70 = false;
        goto L170
    L151:
        if (x54.b.c(r44) != true) goto L153;
        r45 = true;
        goto L154
    L121:
        if (this.w != null) goto L125;
        AoImageView r78 = this.v.inflate();
        Intrinsics.checkNotNull(r78, "null cannot be cast to non-null type com.bytedance.awemeopen.infra.base.image.AoImageView");
        AoImageView r79 = r78;
        this.w = r79;
        if (r79 == null) goto L125;
        r79.setOnClickListener(new sy3.c(this, r7));
    L125:
        AoImageView r80 = this.w;
        if (r80 == null) goto L148;
        x54.b.d(r80);
        int r81 = r7.h();
        int r82 = r7.c();
        if (r81 <= 0) goto L143;
        if (r82 <= 0) goto L143;
        Integer r83 = Integer.valueOf(r81);
        Integer r84 = Integer.valueOf(r82);
        if (r83 == null) goto L144;
        if (r84 == null) goto L144;
        Pair r85 = TuplesKt.to(Integer.valueOf(this.z), Integer.valueOf(this.z));
        Pair r113 = TuplesKt.to(Integer.valueOf(this.A), Integer.valueOf(this.z));
        Pair r114 = TuplesKt.to(Integer.valueOf(this.z), Integer.valueOf(this.A));
        if (r83.intValue() >= r84.intValue()) goto L138;
        com.bytedance.awemeopen.apps.framework.comment.util.c.b(r80, ((Number) r113.getFirst()).intValue(), ((Number) r113.getSecond()).intValue());
        goto L144
    L138:
        if (r83.intValue() <= r84.intValue()) goto L141;
        com.bytedance.awemeopen.apps.framework.comment.util.c.b(r80, ((Number) r114.getFirst()).intValue(), ((Number) r114.getSecond()).intValue());
        goto L144
    L141:
        if (Intrinsics.areEqual(r83, r84) == false) goto L144;
        com.bytedance.awemeopen.apps.framework.comment.util.c.b(r80, ((Number) r85.getFirst()).intValue(), ((Number) r85.getSecond()).intValue());
    L144:
        W3(r7);
    L143:
        ViewGroup.LayoutParams r86 = r80.getLayoutParams();
        r86.width = this.t;
        r80.setLayoutParams(r86);
        goto L144
    L96:
        this.i.setVisibility(8);
        goto L97
    L55:
        r24 = null;
        goto L57
    L51:
        r21 = null;
    L60:
        this.f.setVisibility(0);
        User r87 = r15.o();
        if (r87 == null) goto L63;
        String r88 = r87.x();
    L65:
        if (TextUtils.isEmpty(r88) == false) goto L67;
        this.f.setText(r15.g());
    L74:
        if (r15.h() != 1) goto L76;
        this.f.setBackgroundResource(2131233332);
    L77:
        this.f.setTextColor(this.i.getContext().getResources().getColor(2131100271));
        goto L78
    L76:
        this.f.setBackgroundResource(2131231399);
        goto L77
    L67:
        TextView r89 = this.f;
        User r90 = r15.o();
        if (r90 == null) goto L72;
        String r91 = r90.x();
        if (r91 == null) goto L72;
        r16 = r91;
    L72:
        r89.setText(r16);
        goto L74
    L63:
        r88 = null;
        goto L65
    L42:
        if (r18.length() == 0) goto L45;
        r19 = false;
        goto L47
    L38:
        r17 = "";
        goto L39
    L34:
        r13 = new com.bytedance.awemeopen.infra.base.image.b(2131231483);
    L30:
        r11 = false;
        goto L32
    L22:
        r8 = null;
        goto L23
    }

    public final void V3(String r9) {
        if (this.c.b == true) goto L5;
        return;
    L5:
        Context r0 = ((RecyclerView.ViewHolder) this).itemView.getContext();
        if ((r0 instanceof Activity) == false) goto L8;
        Activity r1 = (Activity) r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        CommentPageParam r2 = this.b;
        if (r2.p == false) goto L14;
        return;
    L14:
        if (r2.q == true) goto L64;
        String r3 = r2.k;
        if (r3 != null) goto L19;
    L24:
        boolean r4 = false;
    L25:
        if (r4 == true) goto L61;
        String r5 = null;
    L35:
        ProfilePageConfigBuilder.Companion.getClass();
        ProfilePageConfigBuilder r6 = new ProfilePageConfigBuilder();
        String r7 = this.b.g;
        String r8 = "";
        if (r7 != null) goto L38;
        r7 = "";
    L38:
        ProfilePageConfigBuilder r10 = r6.withSceneId(r7);
        if (r9 != null) goto L41;
        String r11 = "";
    L42:
        ProfilePageConfigBuilder r12 = r10.withOpenId(r11);
        o14.a r13 = this.m;
        if (r13 == null) goto L46;
        String r14 = r13.b();
        if (r14 == null) goto L46;
    L47:
        ProfilePageConfigBuilder r15 = r12.withAid(r14);
        String r16 = this.b.h;
        if (r16 != null) goto L50;
        r16 = "";
    L50:
        ProfilePageConfigBuilder r17 = r15.withFromReqId(r16);
        if (r5 != null) goto L53;
        r5 = "";
    L53:
        ProfilePageConfigBuilder r18 = r17.withUserProfile(r5).withIsLiveType(false).withHideLongPressTab(false);
        String r19 = this.b.s;
        if (r19 == null) goto L57;
        r8 = r19;
    L57:
        ProfilePageConfigBuilder r20 = r18.withActionType(r8);
        JSONObject r21 = new JSONObject();
        r21.put("host_enter_from", this.b.r);
        ProfilePageConfig r22 = r20.withHostCommonParams(r21).withHideRecently(!Intrinsics.areEqual(r9, this.b.b)).build();
        int r23 = vz3.a.a;
        vz3.a.a(r1, r22, null);
        return;
    L46:
        r14 = "";
        goto L47
    L41:
        r11 = r9;
        goto L42
    L61:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L31
        r5 = new JSONObject(this.b.k).optString("host_user_profile");     // Catch: Throwable -> L31
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L29:
        Throwable th = th;
    L33:
        Result.Companion r25 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        th = move-exception;
        th = th;
        r5 = null;
        goto L33
    L19:
        if (r3.length() <= 0) goto L21;
        boolean r26 = true;
    L22:
        if (r26 != true) goto L24;
        r4 = true;
        goto L25
    L21:
        r26 = false;
        goto L22
    L64:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void W3(t14.a r5) {
        if (this.y != null) goto L5;
        this.y = new b(this);
    L5:
        List r6 = r5.g();
        List r0 = r6;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L17;
        b r7 = this.y;
        if (r7 == null) goto L21;
        r7.onFail();
        return;
    L21:
        return;
    L17:
        com.bytedance.awemeopen.infra.base.image.b r2 = new com.bytedance.awemeopen.infra.base.image.b(r6);
        r2.v = true;
        r2.e = this.y;
        ColorDrawable r8 = new ColorDrawable();
        r8.setColor(this.i.getContext().getResources().getColor(2131100239));
        r2.h = 0;
        r2.g = r8;
        r2.m = ImageView.ScaleType.CENTER_CROP;
        AoImageView r9 = this.w;
        if (r9 == null) goto L22;
        r9.j(r2);
        return;
    L22:
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public final void X3(q14.a r2) {
        if (r2 == null) goto L16;
        t14.a r3 = r2.a();
        if (r3 == null) goto L17;
        List r4 = r3.g();
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.u != null) goto L14;
        this.u = new c(this);
    L14:
        com.bytedance.awemeopen.infra.base.image.b r0 = new com.bytedance.awemeopen.infra.base.image.b(r4);
        r0.v = true;
        r0.e = this.u;
        r0.m = ImageView.ScaleType.CENTER_CROP;
        AoImageView r5 = this.r;
        Intrinsics.checkNotNull(r5);
        r5.j(r0);
        return;
    L17:
        return;
    }

    public final void Y3(o14.a r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "comment");
        d r0 = this.n;
        if (r0 == null) goto L14;
        if (r9 == null) goto L14;
        r0.g = r9;
        r0.h = r9.d();
        DiggNewView2 r2 = r0.e;
        if (r2 == null) goto L9;
        r2.b(r9.r(), false, r0.h);
    L9:
        BuryView2 r3 = r0.f;
        if (r3 == null) goto L12;
        r3.b(r9.p(), false, 0);
    L12:
        if (r10 == false) goto L14;
        r0.j = false;
    L14:
        if (r10 == false) goto L31;
        final h r11 = this.o;
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.b.p() == false) goto L22;
        if (r11.g == false) goto L22;
        return;
    L22:
        if (r11.b.p() == true) goto L27;
        if (r11.g == true) goto L27;
        return;
    L27:
        if (r11.b.p() == false) goto L29;
        r11.f = true;
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r12.setDuration(200);
        r12.addUpdateListener(new g(r11));
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r11.e, "alpha", new float[]{0.0f, 1.0f});
        r5.setDuration(200);
        AnimatorSet r4 = new AnimatorSet();
        r4.playTogether(new Animator[]{r12, r5});
        r4.addListener(new com.bytedance.awemeopen.apps.framework.comment.view.diggbury.j(r11));
        r4.addListener(new com.bytedance.awemeopen.apps.framework.comment.view.diggbury.i(r11));
        r4.start();
        return;
    L29:
        r11.f = true;
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r13.setDuration(200);
        r13.addUpdateListener(new com.bytedance.awemeopen.apps.framework.comment.view.diggbury.e(r11));
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r6.setDuration(200);
        r6.addUpdateListener(new f(r11));
        AnimatorSet r7 = new AnimatorSet();
        r7.playTogether(new Animator[]{r6, r13});
        r7.addListener(new l(r11));
        r7.addListener(new k(r11));
        r7.start();
        return;
    }

    public BaseCommentViewHolder(View r8, j r9, CommentPageParam r10, i r11) {
        Intrinsics.checkNotNullParameter(r8, "itemView");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "pageParam");
        Intrinsics.checkNotNullParameter(r11, "commentViewConfig");
        super(r8);
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r8.findViewById(2131363623);
        this.e = (TextView) r8.findViewById(2131388772);
        this.f = (TextView) r8.findViewById(2131387495);
        this.g = (ImageView) r8.findViewById(2131384365);
        this.h = (TextView) r8.findViewById(2131384364);
        this.i = (MentionTextView) r8.findViewById(2131367794);
        ViewGroup r12 = (ViewGroup) r8.findViewById(2131369091);
        this.j = r12;
        this.k = (TextView) r8.findViewById(2131388654);
        TextView r0 = (TextView) r8.findViewById(2131384339);
        this.l = r0;
        this.p = r8.findViewById(2131392598);
        this.q = (ViewStub) r8.findViewById(2131373653);
        Resources r2 = Resources.getSystem();
        this.t = MathKt.roundToInt(TypedValue.applyDimension(1, 100, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        Resources r3 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 180, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        this.v = (ViewStub) r8.findViewById(2131375103);
        if (r11.a == false) goto L51;
        d r1 = new d(r8.getContext(), r10, r11);
        this.n = r1;
        Intrinsics.checkNotNullParameter(r12, "container");
        DiggNewView2 r13 = r1.e;
        ViewParent r4 = null;
        if (r13 == null) goto L7;
        ViewParent r14 = r13.getParent();
    L9:
        if (r14 != null) goto L16;
        BuryView2 r15 = r1.f;
        if (r15 == null) goto L13;
        r4 = r15.getParent();
    L13:
        if (r4 != null) goto L16;
        boolean r16 = false;
    L17:
        if (r16 == true) goto L50;
        r1.d = r12;
        DiggNewView2 r17 = new DiggNewView2(r1.a);
        r1.e = r17;
        r17.setId(2131363065);
        DiggNewView2 r18 = r1.e;
        if (r18 == null) goto L23;
        r18.setClipChildren(false);
    L23:
        DiggNewView2 r19 = r1.e;
        if (r19 == null) goto L26;
        r19.setPadding(x54.a.a(4), 0, x54.a.a(2), 0);
    L26:
        ViewGroup r20 = r1.d;
        if (r20 == null) goto L29;
        r20.addView(r1.e, -2, x54.a.a(32));
    L29:
        DiggNewView2 r21 = r1.e;
        if (r21 == null) goto L32;
        r21.setOnClickListener(r1);
    L32:
        BuryView2 r22 = new BuryView2(r1.a);
        r1.f = r22;
        r22.setId(2131363064);
        BuryView2 r23 = r1.f;
        if (r23 == null) goto L36;
        r23.setClipChildren(false);
    L36:
        BuryView2 r24 = r1.f;
        if (r24 == null) goto L39;
        r24.setPadding(x54.a.a(6), 0, x54.a.a(6), 0);
    L39:
        ViewGroup r25 = r1.d;
        if (r25 == null) goto L42;
        r25.addView(r1.f, -2, x54.a.a(32));
    L42:
        BuryView2 r26 = r1.f;
        if (r26 == null) goto L45;
        r26.setOnClickListener(r1);
    L45:
        ViewGroup r27 = r1.d;
        if (r27 == null) goto L49;
        r27.setVisibility(0);
    L49:
        r1.j = false;
    L50:
        a r28 = new a(this);
        Intrinsics.checkNotNullParameter(r28, "clickListener");
        r1.i = r28;
    L16:
        r16 = true;
        goto L17
    L7:
        r14 = null;
    L51:
        r8.setOnLongClickListener(new sy3.e(this));
        if (AosExtConfig.b.getCommentConfig().f == true) goto L54;
    L56:
        x54.b.a(r0);
    L57:
        Resources r29 = Resources.getSystem();
        this.z = MathKt.roundToInt(TypedValue.applyDimension(1, 166, WindowDisplayMetricsOverride.apply(r29, r29.getDisplayMetrics())));
        Resources r30 = Resources.getSystem();
        this.A = MathKt.roundToInt(TypedValue.applyDimension(1, 124, WindowDisplayMetricsOverride.apply(r30, r30.getDisplayMetrics())));
        return;
    L54:
        if (r10.o == true) goto L56;
        r8.setOnClickListener(new sy3.f(this));
        x54.b.d(r0);
        goto L57
    }
}
