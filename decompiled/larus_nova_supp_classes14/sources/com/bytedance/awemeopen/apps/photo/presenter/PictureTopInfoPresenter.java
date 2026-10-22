package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxTextView;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.AvatarModel;
import com.bytedance.awemeopen.apps.framework.utils.IconSettingUtils;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.apps.photo.viewmodel.AosPictureDetailViewModel;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiItemAnchorInfo;
import com.bytedance.awemeopen.bizmodels.feed.poi.PoiItemAnchorTag;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfigBuilder;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PictureTopInfoPresenter extends f04.a<Unit> {
    public static final /* synthetic */ int s = 0;
    public final a14.a d;
    public final Lazy e;
    public final AoImageView f;
    public final AoImageView g;
    public final DuxTextView h;
    public final DuxTextView i;
    public final ViewGroup j;
    public final AoImageView k;
    public final DuxTextView l;
    public final View m;
    public final DuxTextView n;
    public boolean o;
    public boolean p;
    public final y24.d q;
    public final c r;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AvatarModel.FollowStatus.values().length];
            r0[AvatarModel.FollowStatus.UNSHOWFOLLOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AvatarModel.FollowStatus.MYSELF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements y24.c {
        public final /* synthetic */ PictureTopInfoPresenter a;

        public c(PictureTopInfoPresenter r1) {
            this.a = r1;
        }

        public final void a(String r1, int r2) {
            User r3 = this.a.d.a.f();
            if (r3 == null) goto L5;
            String r4 = r3.u();
        L7:
            if (Intrinsics.areEqual(r1, r4) == false) goto L10;
            this.a.r();
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    static {
    }

    @Override // f04.a
    public final void k() {
        this.q.r2(this.r);
    }

    public final void r() {
        AosPictureDetailViewModel r0 = this.d.c;
        if (AosExtConfig.b.A().a == true) goto L6;
        AvatarModel.FollowStatus r1 = AvatarModel.FollowStatus.UNSHOWFOLLOW;
    L12:
        r0.updateFollowStatus(r1);
        return;
    L6:
        if (com.bytedance.awemeopen.apps.framework.utils.p0.e(this.d.a.r().b) == false) goto L9;
        r1 = AvatarModel.FollowStatus.MYSELF;
        goto L12
    L9:
        if (this.q.E1(this.d.a) == true) goto L11;
        r1 = AvatarModel.FollowStatus.UNFOLLOWED;
        goto L12
    L11:
        r1 = AvatarModel.FollowStatus.FOLLOWED;
        goto L12
    }

    public static final String m(PictureTopInfoPresenter r0) {
        User r1 = r0.d.a.f();
        if (r1 == null) goto L6;
        String r2 = r1.u();
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    }

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
    @Override // f04.a
    public final void j(Unit r34) {
        Intrinsics.checkNotNullParameter(r34, "unit");
        x54.b.d(this.f);
        JSONObject r2 = null;
        if (((Boolean) IconSettingUtils.a.getValue()).booleanValue() == false) goto L5;
        x54.b.a(this.g);
    L29:
        x54.b.d(this.h);
        x54.b.d(this.i);
        this.q.R2(this.r);
        AppCompatTextView r1 = this.h;
        int r4 = com.bytedance.awemeopen.apps.framework.utils.d0.d(this.d.getActivity());
        Resources r6 = Resources.getSystem();
        r1.setMaxWidth(r4 - MathKt.roundToInt(TypedValue.applyDimension(1, 252, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()))));
        AppCompatTextView r3 = this.h;
        User r5 = this.d.a.f();
        if (r5 == null) goto L32;
        CharSequence r7 = r5.t();
    L33:
        r3.setText(r7);
        User r8 = this.d.a.f();
        if (r8 == null) goto L40;
        t14.a r9 = r8.a();
        if (r9 == null) goto L40;
        List r10 = r9.g();
        if (r10 == null) goto L40;
        AoImageView r11 = this.f;
        com.bytedance.awemeopen.infra.base.image.b r12 = new com.bytedance.awemeopen.infra.base.image.b(r10);
        ImageView.ScaleType r13 = ImageView.ScaleType.CENTER_CROP;
        r12.r = true;
        r12.m = r13;
        r12.b(2131231554);
        r11.j(r12);
    L40:
        this.d.c.observeFollowStatus(new p0(this));
        this.i.setOnClickListener(new q0(this));
        this.f.setOnClickListener(new r0(this));
        this.h.setOnClickListener(new s0(this));
        this.g.setOnClickListener(new t0(this));
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L158;
        s14.d r14 = this.d.a.d();
        if (r14 == null) goto L158;
        com.bytedance.awemeopen.bizmodels.feed.poi.t r15 = this.d.a.C();
        if (r15 == null) goto L158;
        com.bytedance.awemeopen.bizmodels.feed.poi.k r16 = r15.e();
        if (r16 == null) goto L158;
        com.bytedance.awemeopen.bizmodels.feed.poi.m r17 = r16.a();
        if (r17 == null) goto L158;
        PoiItemAnchorInfo r18 = r17.a();
        if (r18 == null) goto L158;
        Integer r19 = r14.getType();
        if (r19 == null) goto L158;
        if (r19.intValue() != 2) goto L158;
        String r20 = this.d.a.c();
        CharSequence r21 = r15.f();
        if (r21 != null) goto L64;
        r21 = "";
    L64:
        CharSequence r22 = r18.getPoiType();
        PoiItemAnchorTag r23 = r18.getSuffix();
        if (r23 == null) goto L68;
        String r24 = r23.getContent();
        if (r24 == null) goto L68;
    L69:
        r18.getPoiIconUrl();
        Integer r25 = r14.getType();
        Intrinsics.checkNotNull(r25);
        r25.intValue();
        Intrinsics.checkNotNullParameter(r20, "aid");
        Intrinsics.checkNotNullParameter(r21, "poiName");
        Intrinsics.checkNotNullParameter(r24, "suffix");
        this.l.setText(r22);
        this.n.setText(r21);
        if (com.bytedance.awemeopen.apps.framework.utils.n0.c(this.k.getContext()) == false) goto L72;
        this.k.setBackgroundResource(2131231566);
    L73:
        x54.b.d(this.l);
        x54.b.d(this.m);
        x54.b.d(this.n);
        x54.b.d(this.j);
        x54.b.d(this.k);
        ConstraintSet r26 = new ConstraintSet();
        ConstraintLayout r27 = i(2131382300);
        r26.clone(r27);
        r26.clear(2131382309, 4);
        r26.connect(2131382309, 3, 2131363744, 4);
        r26.applyTo(r27);
        this.j.setOnClickListener(new v0(this));
        a14.a r28 = this.d;
        r14.c r29 = r28.a;
        String r30 = r28.c.sceneId();
        if (r29 == null) goto L158;
        AosPictureDetailConfig r31 = this.d.c.getPageConfig();
        if (r31 == null) goto L80;
        String r32 = r31.getHostEnterFrom();
        if (r32 == null) goto L80;
    L81:
        Map r33 = r29.b0();
        com.bytedance.awemeopen.bizmodels.feed.poi.t r35 = r29.C();
        if (r35 == null) goto L87;
        String r36 = r35.d();
        if (r36 == null) goto L87;
        String r37 = r36;
    L88:
        d14.a r38 = b14.a.a;
        t24.a r39 = b14.a.a(t24.a.class);
        r14.a0 r40 = r29.d;
        if (r40 == null) goto L91;
        String r41 = r40.a();
    L92:
        if (r41 != null) goto L94;
        r41 = "";
    L94:
        User r110 = r29.f();
        if (r110 == null) goto L98;
        String r111 = r110.u();
        if (r111 == null) goto L98;
    L99:
        String r112 = r29.c();
        String r113 = r29.r().c;
        if (r113 != null) goto L102;
        r113 = "";
    L102:
        User r114 = r29.f();
        if (r114 == null) goto L105;
        int r115 = r114.m();
    L106:
        s14.d r116 = r29.d();
        if (r116 == null) goto L112;
        String r117 = r116.d();
        if (r117 == null) goto L112;
        String r118 = r117;
    L113:
        AosPictureDetailConfig r119 = this.d.c.getPageConfig();
        if (r119 == null) goto L116;
        JSONObject r210 = r119.getHostExtraParams();
    L117:
        String r211 = n(r29);
        s14.d r120 = r29.d();
        if (r120 == null) goto L122;
        Integer r121 = r120.getType();
        if (r121 == null) goto L122;
        int r212 = r121.intValue();
    L123:
        t24.a.a.b(r39, r41, r111, r112, r113, r115, r37, r118, "", r30, r32, "", r211, r212, false, r33, r210, o(r29), p(r29), r30, "click_label", false, 4198400);
        t24.a r42 = b14.a.a(t24.a.class);
        r14.a0 r43 = r29.d;
        if (r43 == null) goto L126;
        String r44 = r43.a();
    L127:
        if (r44 != null) goto L129;
        r44 = "";
    L129:
        User r122 = r29.f();
        if (r122 == null) goto L133;
        String r123 = r122.u();
        if (r123 == null) goto L133;
    L134:
        String r124 = r29.c();
        String r125 = r29.r().c;
        if (r125 != null) goto L137;
        r125 = "";
    L137:
        User r126 = r29.f();
        if (r126 == null) goto L140;
        int r127 = r126.m();
    L141:
        s14.d r128 = r29.d();
        if (r128 == null) goto L147;
        String r129 = r128.d();
        if (r129 == null) goto L147;
        String r130 = r129;
    L148:
        AosPictureDetailConfig r45 = this.d.c.getPageConfig();
        if (r45 == null) goto L151;
        r2 = r45.getHostExtraParams();
    L151:
        JSONObject r213 = r2;
        String r214 = n(r29);
        s14.d r46 = r29.d();
        if (r46 == null) goto L156;
        Integer r47 = r46.getType();
        if (r47 == null) goto L156;
        int r215 = r47.intValue();
    L157:
        t24.a.a.i(r42, r44, r123, r124, r125, r127, r37, r130, "", r30, r32, "", r214, r215, false, r33, r213, o(r29), p(r29), r30, "click_label", false, 4198400);
    L156:
        r215 = 2;
    L147:
        r130 = "";
        goto L148
    L140:
        r127 = 0;
    L133:
        r123 = "";
        goto L134
    L126:
        r44 = null;
    L122:
        r212 = 2;
        goto L123
    L116:
        r210 = null;
    L112:
        r118 = "";
        goto L113
    L105:
        r115 = 0;
    L98:
        r111 = "";
        goto L99
    L91:
        r41 = null;
    L87:
        r37 = "";
    L80:
        r32 = "";
        goto L81
    L72:
        this.k.setBackgroundResource(2131231567);
    L68:
        r24 = "";
    L158:
        r();
        return;
    L32:
        r7 = null;
        goto L33
    L5:
        x54.b.d(this.g);
        if (((Boolean) IconSettingUtils.b.getValue()).booleanValue() == false) goto L17;
        this.g.j(new com.bytedance.awemeopen.infra.base.image.b(2131231575));
        AoImageView r48 = this.g;
        Resources r49 = Resources.getSystem();
        int r50 = MathKt.roundToInt(TypedValue.applyDimension(1, 32, WindowDisplayMetricsOverride.apply(r49, r49.getDisplayMetrics())));
        if (r48 == null) goto L10;
        ViewGroup.LayoutParams r51 = r48.getLayoutParams();
    L11:
        if (r51 == null) goto L14;
        r51.width = r50;
    L14:
        if (r48 == null) goto L29;
        r48.requestLayout();
        goto L29
    L10:
        r51 = null;
        goto L11
    L17:
        if (com.bytedance.awemeopen.apps.framework.utils.n0.c(this.g.getContext()) == false) goto L19;
        this.g.j(new com.bytedance.awemeopen.infra.base.image.b(2131231570));
    L20:
        AoImageView r52 = this.g;
        Resources r53 = Resources.getSystem();
        int r54 = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r53, r53.getDisplayMetrics())));
        if (r52 == null) goto L23;
        ViewGroup.LayoutParams r55 = r52.getLayoutParams();
    L24:
        if (r55 == null) goto L27;
        r55.width = r54;
    L27:
        if (r52 == null) goto L29;
        r52.requestLayout();
        goto L29
    L23:
        r55 = null;
        goto L24
    L19:
        this.g.j(new com.bytedance.awemeopen.infra.base.image.b(2131231571));
        goto L20
    }

    public final String n(r14.c r2) {
        s14.d r3 = r2.d();
        if (r3 == null) goto L14;
        Integer r4 = r3.getType();
        if (r4 == null) goto L18;
        int r5 = r4.intValue();
        if (r5 != 13010) goto L9;
        return "poi_product";
    L9:
        if (r5 == 13012) goto L11;
        return "poi";
    L11:
        return "poi_combo";
    L18:
        return "";
    L14:
        return "";
    }

    public final String o(r14.c r1) {
        s14.d r2 = r1.d();
        if (r2 == null) goto L5;
        String r3 = r2.c();
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public final String p(r14.c r1) {
        s14.d r2 = r1.d();
        if (r2 == null) goto L7;
        Integer r3 = r2.getType();
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L8:
        if (r4 != null) goto L11;
        return "";
    L11:
        return r4;
    L7:
        r4 = null;
        goto L8
    }

    public PictureTopInfoPresenter(a14.a r2, final Function0<? extends n54.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = LazyKt.lazy(PictureTopInfoPresenter$enableTopPoi$2.INSTANCE);
        AoImageView r4 = i(2131382307);
        this.f = i(2131382299);
        this.g = i(2131382296);
        this.h = (DuxTextView) i(2131382309);
        this.i = (DuxTextView) i(2131382302);
        this.j = (ViewGroup) i(2131382308);
        this.k = i(2131382304);
        this.l = (DuxTextView) i(2131382305);
        this.m = i(2131382303);
        this.n = (DuxTextView) i(2131382306);
        d14.a r0 = b14.a.a;
        this.q = b14.a.a(y24.d.class);
        this.r = new c(this);
        r4.setOnClickListener(new u0(this, r3));
    }

    public final void q(View r14, boolean r15) {
        if (com.bytedance.awemeopen.apps.framework.utils.y.a(r14) == false) goto L5;
        return;
    L5:
        AosPictureDetailConfig r16 = this.d.c.getPageConfig();
        r14.c r0 = this.d.a;
        if (r0 == null) goto L8;
        String r1 = r0.c();
    L9:
        if (r16 == null) goto L11;
        String r2 = r16.getEnterAid();
    L13:
        if (Intrinsics.areEqual(r1, r2) == false) goto L15;
        String r3 = PinchEnterMethod.CLICK;
    L16:
        String r11 = r3;
        int r4 = vz3.a.a;
        Activity r5 = this.d.getActivity();
        a14.a r6 = this.d;
        r14.c r7 = r6.a;
        String r8 = r6.c.sceneId();
        if (r16 == null) goto L19;
        String r9 = r16.getPreviousPage();
    L20:
        if (r16 == null) goto L22;
        JSONObject r12 = r16.getHostExtraParams();
    L23:
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r7, "aweme");
        boolean r10 = true;
        if (r7.f() != null) goto L26;
        AoLogger.c("AuthorPageHelper", new Object[]{"forwardToAuthorPage author null"});
        return;
    L26:
        String r17 = r7.r().b;
        if (r17 != null) goto L29;
    L32:
        boolean r13 = true;
    L33:
        if (r13 == false) goto L38;
        User r18 = r7.f();
        if (r18 == null) goto L37;
        r17 = r18.u();
        goto L38
    L37:
        r17 = null;
    L38:
        String r19 = r7.u();
        if (r19 != null) goto L41;
    L46:
        r10 = false;
    L47:
        if (r10 == false) goto L49;
        String r20 = new JSONObject(r19).optString("host_user_profile");
    L50:
        ProfilePageConfigBuilder.Companion.getClass();
        ProfilePageConfigBuilder r21 = new ProfilePageConfigBuilder();
        if (r8 != null) goto L53;
        String r22 = "";
    L54:
        ProfilePageConfigBuilder r23 = r21.withSceneId(r22);
        if (r17 != null) goto L57;
        r17 = "";
    L57:
        ProfilePageConfigBuilder r110 = r23.withOpenId(r17).withAid(r7.c());
        r14.a0 r24 = r7.d;
        if (r24 == null) goto L60;
        String r25 = r24.a();
    L61:
        ProfilePageConfigBuilder r111 = r110.withFromReqId(r25);
        if (r20 != null) goto L64;
        r20 = "";
    L64:
        ProfilePageConfigBuilder r112 = r111.withUserProfile(r20).withIsLiveType(com.bytedance.awemeopen.apps.framework.utils.v.b(r7)).withHideLongPressTab(false).withActionType(r11);
        if (r12 != null) goto L67;
        JSONObject r26 = new JSONObject();
    L68:
        vz3.a.a(r5, r112.withHostExtraParams(r26).build(), null);
        AosEventReporter r113 = AosEventReporter.a;
        if (r8 != null) goto L71;
        r8 = "";
    L71:
        String r27 = r7.c();
        if (r15 == false) goto L74;
        String r28 = "click_head";
    L75:
        String r29 = r28;
        User r30 = r7.f();
        if (r30 == null) goto L81;
        String r31 = r30.u();
        if (r31 == null) goto L81;
        String r32 = r31;
    L82:
        if (r15 == false) goto L84;
        AosEventReporter.EnterPersonalDetail r114 = AosEventReporter.EnterPersonalDetail.click_avatar;
    L85:
        if (r9 != null) goto L87;
        String r33 = "";
    L88:
        r113.getClass();
        AosEventReporter.w(r8, "", r7, r27, r29, r32, r114, r33, false, r11, r12);
        return;
    L87:
        r33 = r9;
        goto L88
    L84:
        r114 = AosEventReporter.EnterPersonalDetail.click_name;
    L81:
        r32 = "";
        goto L82
    L74:
        r28 = "click_name";
        goto L75
    L67:
        r26 = r12;
        goto L68
    L60:
        r25 = null;
        goto L61
    L53:
        r22 = r8;
        goto L54
    L49:
        r20 = null;
        goto L50
    L41:
        if (r19.length() <= 0) goto L43;
        boolean r34 = true;
    L44:
        if (r34 != true) goto L46;
    L43:
        r34 = false;
        goto L44
    L29:
        if (r17.length() == 0) goto L32;
        r13 = false;
        goto L33
    L22:
        r12 = null;
        goto L23
    L19:
        r9 = null;
        goto L20
    L15:
        r3 = "draw";
        goto L16
    L11:
        r2 = null;
        goto L13
    L8:
        r1 = null;
        goto L9
    }
}
