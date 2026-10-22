package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import am2.x;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.api.SingingHotResultRankType;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.utils.i1;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.sei.n;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.GradientTextView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvRoomSingEndedFeedbackViewV1;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/a;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "", "setSingerAvatar", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "viewModel", "setKtvRoomViewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomSingEndedFeedbackViewV1 extends ConstraintLayout implements View.OnClickListener, a {
    public KtvRoomViewModel a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final GradientTextView h;
    public final GradientTextView i;
    public n j;
    public boolean k;

    public KtvRoomSingEndedFeedbackViewV1(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvRoomSingEndedFeedbackViewV1(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static String R5(n r5) {
        if (r5 != null) goto L4;
    L6:
        if (r5 != null) goto L11;
        return null;
    L11:
        return String.valueOf(r5.d());
    L4:
        if (r5.d() != 0) goto L6;
        return "99+";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setSingerAvatar(IBaseUser r2) {
        FrescoLoader r0 = FrescoLoader.with(getContext());
        if (r2 == null) goto L5;
        k r3 = r2.getAvatarThumbKt();
    L6:
        FrescoLoader r4 = r0.load(r3);
        if (r4 == null) goto L12;
        FrescoLoader r5 = r4.roundAsCircle();
        if (r5 == null) goto L13;
        r5.into(this.b);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public final void F5(com.bytedance.android.livesdk.ktvimpl.base.sei.a r17) {
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r1 = r17;
        String r3 = null;
        if ((r1 instanceof n) == true) goto L5;
        r1 = null;
    L5:
        n r2 = (n) r1;
        this.j = r2;
        if (r2 == null) goto L8;
        IBaseUser r4 = r2.i();
    L9:
        setSingerAvatar(r4);
        TextView r5 = this.c;
        n r6 = this.j;
        if (r6 == null) goto L14;
        IBaseUser r7 = r6.i();
        if (r7 == null) goto L14;
        String r8 = r7.getNickName();
    L15:
        r5.setText(r8);
        TextView r9 = this.d;
        Object[] r10 = new Object[1];
        n r11 = this.j;
        if (r11 == null) goto L18;
        String r12 = r11.g();
    L19:
        r10[0] = r12;
        r9.setText(s1.C(2131918525, r10));
        TextView r13 = this.f;
        Object[] r14 = new Object[1];
        n r15 = this.j;
        if (r15 == null) goto L22;
        Long r16 = Long.valueOf(r15.b());
    L23:
        r14[0] = r16;
        r13.setText(s1.C(2131918520, r14));
        TextView r18 = this.g;
        n r19 = this.j;
        if (r19 != null) goto L26;
    L28:
        String r20 = s1.B(2131918529);
    L29:
        r18.setText(r20);
        GradientTextView r21 = this.h;
        n r22 = this.j;
        if (r22 == null) goto L32;
        String r23 = String.valueOf(r22.c());
    L33:
        r21.setText(r23);
        this.i.setText(R5(this.j));
        this.e.setVisibility(8);
        n r24 = this.j;
        if (r24 == null) goto L36;
        IBaseUser r25 = r24.i();
    L37:
        KtvRoomViewModel r26 = this.a;
        String r27 = "";
        if (r26 == null) goto L45;
        if (r25 == null) goto L42;
        String r28 = r25.getIdString();
        if (r28 == null) goto L42;
    L43:
        r26.getSingerFollowState(r28);
    L42:
        r28 = "";
    L45:
        if (this.k == true) goto L70;
        KtvRoomViewModel r29 = this.a;
        if (r29 == null) goto L68;
        n r30 = this.j;
        if (r30 == null) goto L68;
        if (r30.i() == null) goto L68;
        Long r31 = KtvLoggerHelper.a;
        String r32 = r29.getUserType();
        IBaseUser r33 = r30.i();
        if (r33 == null) goto L57;
        String r34 = r33.getIdString();
        if (r34 == null) goto L57;
        r3 = r34;
    L57:
        String r35 = r29.getToUserType(r30.i());
        String r36 = String.valueOf(r30.f());
        String r110 = r30.g();
        if (r110 != null) goto L60;
        r110 = "";
    L60:
        String r111 = String.valueOf(r30.c());
        String r112 = String.valueOf(r30.b());
        String r37 = R5(r30);
        if (r37 != null) goto L63;
        r37 = "99+";
    L63:
        Intrinsics.checkNotNullParameter(r32, "userType");
        Intrinsics.checkNotNullParameter(r35, "toUserType");
        Intrinsics.checkNotNullParameter(r36, "songId");
        Intrinsics.checkNotNullParameter(r110, "songName");
        Intrinsics.checkNotNullParameter(r111, "hot");
        Intrinsics.checkNotNullParameter(r112, "contributeCount");
        Intrinsics.checkNotNullParameter(r37, "dailyRank");
        Intrinsics.checkNotNullParameter(BDLocationException.ERROR_TIMEOUT, "isPublishGuide");
        Pair[] r113 = new Pair[11];
        r113[0] = TuplesKt.to("live_type", "voice_live");
        r113[1] = TuplesKt.to("function_type", KtvLoggerHelper.H(j.c()));
        r113[2] = TuplesKt.to("user_type", r32);
        if (r3 == null) goto L67;
        r27 = r3;
    L67:
        r113[3] = TuplesKt.to("to_user_id", r27);
        r113[4] = TuplesKt.to("to_user_type", r35);
        r113[5] = TuplesKt.to("song_id", r36);
        r113[6] = TuplesKt.to("song_name", r110);
        r113[7] = TuplesKt.to("hotscore", r111);
        r113[8] = TuplesKt.to("contribute_ucnt", r112);
        r113[9] = TuplesKt.to("daily_rank", r37);
        r113[10] = TuplesKt.to("is_publish_guide", BDLocationException.ERROR_TIMEOUT);
        j0.l().sendLog("ktv_hotscore_result_show", MapsKt.hashMapOf(r113), new Object[]{IRoom.class, x.class});
    L68:
        this.k = true;
        return;
    L70:
        return;
    L36:
        r25 = null;
        goto L37
    L32:
        r23 = null;
        goto L33
    L26:
        if (r19.e() != SingingHotResultRankType.DAILY_RANK.ordinal()) goto L28;
        r20 = s1.B(2131918521);
        goto L29
    L22:
        r16 = null;
        goto L23
    L18:
        r12 = null;
    L14:
        r8 = null;
        goto L15
    L8:
        r4 = null;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        String r0 = null;
        if (r13 == null) goto L5;
        Integer r14 = Integer.valueOf(r13.getId());
    L6:
        if (r14 != null) goto L9;
    L37:
        if (r14 != null) goto L40;
    L42:
        if (r14 != null) goto L45;
    L51:
        if (r14 != null) goto L54;
    L56:
        if (r14 != null) goto L59;
        return;
    L59:
        if (r14.intValue() != 2131386539) goto L74;
    L60:
        KtvRoomViewModel r15 = this.a;
        if (r15 == null) goto L75;
        n r1 = this.j;
        if (r1 == null) goto L65;
        int r2 = r1.e();
    L66:
        r15.openKtvSingingRank(r2);
        return;
    L65:
        r2 = SingingHotResultRankType.DAILY_RANK.ordinal();
        goto L66
    L75:
        return;
    L74:
        return;
    L54:
        if (r14.intValue() != 2131386545) goto L56;
    L45:
        if (r14.intValue() != 2131386536) goto L51;
    L47:
        if (((Boolean) h.Q5.getValue(null, h.a[353(0x161, float:4.95E-43)])).booleanValue() == true) goto L71;
        KtvRoomViewModel r16 = this.a;
        if (r16 == null) goto L72;
        r16.openSingleContributionRank(this.j);
        return;
    L72:
        return;
    L71:
        return;
    L40:
        if (r14.intValue() != 2131386537) goto L42;
    L9:
        if (r14.intValue() != 2131386542) goto L37;
        KtvRoomViewModel r17 = this.a;
        if (r17 == null) goto L68;
        n r3 = this.j;
        String r4 = "";
        if (r3 == null) goto L18;
        IBaseUser r5 = r3.i();
        if (r5 == null) goto L18;
        String r6 = r5.getIdString();
        if (r6 == null) goto L18;
    L19:
        r17.followSinger(r6);
        n r7 = this.j;
        if (r7 == null) goto L69;
        Long r8 = KtvLoggerHelper.a;
        String r9 = r17.getUserType();
        IBaseUser r10 = r7.i();
        if (r10 == null) goto L26;
        String r11 = r10.getIdString();
        if (r11 == null) goto L26;
        r0 = r11;
    L26:
        String r18 = r17.getToUserType(r7.i());
        String r12 = String.valueOf(r7.f());
        String r19 = r7.g();
        if (r19 != null) goto L29;
        r19 = "";
    L29:
        String r20 = String.valueOf(r7.c());
        String r21 = String.valueOf(r7.b());
        String r22 = R5(r7);
        if (r22 != null) goto L32;
        r22 = "99+";
    L32:
        Intrinsics.checkNotNullParameter(r9, "userType");
        Intrinsics.checkNotNullParameter(r18, "toUserType");
        Intrinsics.checkNotNullParameter(r12, "songId");
        Intrinsics.checkNotNullParameter(r19, "songName");
        Intrinsics.checkNotNullParameter(r20, "hot");
        Intrinsics.checkNotNullParameter(r21, "contributeCount");
        Intrinsics.checkNotNullParameter(r22, "dailyRank");
        Pair[] r23 = new Pair[10];
        r23[0] = TuplesKt.to("live_type", "voice_live");
        r23[1] = TuplesKt.to("function_type", KtvLoggerHelper.H(j.c()));
        r23[2] = TuplesKt.to("user_type", r9);
        if (r0 == null) goto L36;
        r4 = r0;
    L36:
        r23[3] = TuplesKt.to("to_user_id", r4);
        r23[4] = TuplesKt.to("to_user_type", r18);
        r23[5] = TuplesKt.to("song_id", r12);
        r23[6] = TuplesKt.to("song_name", r19);
        r23[7] = TuplesKt.to("hotscore", r20);
        r23[8] = TuplesKt.to("contribute_ucnt", r21);
        r23[9] = TuplesKt.to("daily_rank", r22);
        j0.l().sendLog("ktv_hotscore_result_follow", MapsKt.hashMapOf(r23), new Object[]{IRoom.class, x.class});
        return;
    L69:
        return;
    L18:
        r6 = "";
        goto L19
    L68:
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public final void p0(boolean r3) {
        if (r3 == true) goto L5;
        this.e.setVisibility(0);
        this.e.setText(s1.B(2131918523));
        this.e.setClickable(true);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.e, "alpha", new float[]{0.0f, 1.0f});
        r4.setDuration(300);
        r4.start();
        return;
    L5:
        this.e.setText(s1.B(2131918524));
        this.e.setClickable(false);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public void setKtvRoomViewModel(KtvRoomViewModel r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super/*android.view.ViewGroup*/.onVisibilityChanged(r2, r3);
        if (r3 != 8) goto L6;
        this.k = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvRoomSingEndedFeedbackViewV1(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        ViewGroup.inflate(r4, 2131566536, this);
        this.b = findViewById(2131386541);
        this.c = (TextView) findViewById(2131386544);
        this.d = (TextView) findViewById(2131386546);
        TextView r7 = (TextView) findViewById(2131386542);
        this.e = r7;
        r7.setOnClickListener(this);
        TextView r8 = (TextView) findViewById(2131386536);
        this.f = r8;
        r8.setOnClickListener(this);
        TextView r9 = (TextView) findViewById(2131386539);
        this.g = r9;
        r9.setOnClickListener(this);
        GradientTextView r10 = findViewById(2131386537);
        this.h = r10;
        r10.setOnClickListener(this);
        r10.x(ColorProtector.parseColor("#FF7B43"), ColorProtector.parseColor("#FFC163"));
        int r11 = i1.a;
        Drawable r12 = s1.m(2131252157);
        int r1 = (int) s1.e(18.0f);
        r12.setBounds(0, 0, r1, r1);
        r10.setCompoundDrawablePadding((int) s1.e(5.0f));
        r10.setCompoundDrawables(r12, null, null, null);
        GradientTextView r13 = findViewById(2131386545);
        this.i = r13;
        r13.setOnClickListener(this);
        r13.x(ColorProtector.parseColor("#FF7B43"), ColorProtector.parseColor("#FFC163"));
    }

    public /* synthetic */ KtvRoomSingEndedFeedbackViewV1(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
