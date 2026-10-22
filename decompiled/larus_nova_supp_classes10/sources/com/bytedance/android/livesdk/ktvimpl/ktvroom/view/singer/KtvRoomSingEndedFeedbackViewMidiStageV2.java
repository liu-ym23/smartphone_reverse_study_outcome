package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.widget.GradientTextView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.model.KtvLabelTextConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvRoomSingEndedFeedbackViewMidiStageV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "viewModel", "", "setKtvRoomViewModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomSingEndedFeedbackViewMidiStageV2 extends ConstraintLayout implements View.OnClickListener, com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a {
    public static final String m = null;
    public static final String n = null;
    public KtvRoomViewModel a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final HSImageView e;
    public final GradientTextView f;
    public final GradientTextView g;
    public final HSImageView h;
    public final View i;
    public final View j;
    public final KtvLabelTextConfig k;
    public h l;

    public static final class a {
    }

    public KtvRoomSingEndedFeedbackViewMidiStageV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvRoomSingEndedFeedbackViewMidiStageV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public final void p0(boolean r1) {
    }

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getObjectTosPath());
        r0.append("/obj/live-ios-resource/live_ktv_midi_feedback_unhigh_bg_mv.png");
        m = r0.toString();
        n = "https://" + r2.getObjectTosPath() + "/obj/live-ios-resource/live_ktv_midi_feedback_highscore_bg_mv.png";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public final void F5(com.bytedance.android.livesdk.ktvimpl.base.sei.a r6) {
        String r1 = null;
        if ((r6 instanceof h) == true) goto L5;
        r6 = null;
    L5:
        this.l = (h) r6;
        FrescoLoader r7 = FrescoLoader.with(getContext());
        h r0 = this.l;
        if (r0 == null) goto L8;
        String r2 = r0.b();
    L9:
        FrescoLoader r8 = r7.load(r2);
        if (r8 == null) goto L14;
        FrescoLoader r9 = r8.roundAsCircle();
        if (r9 == null) goto L14;
        r9.into(this.b);
    L14:
        HSImageView r10 = this.b;
        if (r10 == null) goto L17;
        r10.setOnClickListener(this);
    L17:
        h r11 = this.l;
        if (r11 == null) goto L20;
        float r12 = r11.g();
    L21:
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        String r13 = String.format("%.1f ", Arrays.copyOf(new Object[]{Float.valueOf(r12)}, 1));
        h r4 = this.l;
        if (r4 == null) goto L24;
        Boolean r5 = Boolean.valueOf(r4.l());
    L25:
        GradientTextView r14 = this.f;
        if (r14 == null) goto L28;
        r14.setText(r13);
    L28:
        TextView r15 = this.d;
        if (r15 == null) goto L35;
        h r16 = this.l;
        if (r16 == null) goto L33;
        String r17 = r16.e();
    L34:
        r15.setText(r17);
        goto L35
    L33:
        r17 = null;
    L35:
        TextView r18 = this.c;
        if (r18 == null) goto L42;
        Object[] r19 = new Object[1];
        h r20 = this.l;
        if (r20 == null) goto L40;
        r1 = r20.j();
    L40:
        r19[0] = r1;
        r18.setText(s1.C(2131918526, r19));
    L42:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L66;
        HSImageView r21 = this.e;
        if (r21 == null) goto L46;
        r21.setVisibility(0);
    L46:
        HSImageView r22 = this.e;
        Uri r23 = UriProtector.parse(this.k.getKtvFeedbackTagUrl());
        if (r22 == null) goto L51;
        if (r23 == null) goto L51;
        r22.setImageURI(r23);
    L51:
        HSImageView r24 = this.h;
        int r25 = qy.a.a;
        ImageLoader.bindImage(r24, qy.a.a(n), 0, s1.f(6.0f));
        GradientTextView r26 = this.f;
        if (r26 == null) goto L54;
        r26.x(ColorProtector.parseColor("#F8BA72"), ColorProtector.parseColor("#F27A3E"));
    L54:
        GradientTextView r27 = this.g;
        if (r27 == null) goto L57;
        r27.x(ColorProtector.parseColor("#F8BA72"), ColorProtector.parseColor("#F27A3E"));
    L57:
        TextView r28 = this.c;
        if (r28 == null) goto L60;
        r28.setTextColor(ColorProtector.parseColor("#FF9852"));
    L60:
        View r29 = this.i;
        if (r29 == null) goto L63;
        r29.setBackground(getResources().getDrawable(2131249341));
    L63:
        View r30 = this.j;
        if (r30 == null) goto L85;
        r30.setBackground(getResources().getDrawable(2131249342));
        return;
    L85:
        return;
    L66:
        HSImageView r31 = this.e;
        if (r31 == null) goto L69;
        r31.setVisibility(8);
    L69:
        HSImageView r32 = this.h;
        int r33 = qy.a.a;
        ImageLoader.bindImage(r32, qy.a.a(m), 0, s1.f(6.0f));
        GradientTextView r34 = this.f;
        if (r34 == null) goto L72;
        r34.x(ColorProtector.parseColor("#E963FF"), ColorProtector.parseColor("#F190C9"));
    L72:
        GradientTextView r35 = this.g;
        if (r35 == null) goto L75;
        r35.x(ColorProtector.parseColor("#DE89FF"), ColorProtector.parseColor("#EB00FF"));
    L75:
        TextView r36 = this.c;
        if (r36 == null) goto L78;
        r36.setTextColor(ColorProtector.parseColor("#DB75FF"));
    L78:
        View r37 = this.i;
        if (r37 == null) goto L81;
        r37.setBackground(getResources().getDrawable(2131249343));
    L81:
        View r38 = this.j;
        if (r38 == null) goto L87;
        r38.setBackground(getResources().getDrawable(2131249344));
        return;
    L87:
        return;
    L24:
        r5 = null;
        goto L25
    L20:
        r12 = 0.0f;
        goto L21
    L8:
        r2 = null;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (r2 == null) goto L4;
        Integer r3 = Integer.valueOf(r2.getId());
    L5:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.intValue() != 2131386541) goto L18;
        KtvRoomViewModel r4 = this.a;
        if (r4 == null) goto L19;
        h r0 = this.l;
        if (r0 == null) goto L15;
        String r1 = r0.k();
        if (r1 == null) goto L15;
    L16:
        r4.showSingerUserProfiler(r1);
        return;
    L15:
        r1 = "";
        goto L16
    L19:
        return;
    L18:
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a
    public void setKtvRoomViewModel(KtvRoomViewModel r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvRoomSingEndedFeedbackViewMidiStageV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = (KtvLabelTextConfig) vm2.h.w4.getValue(null, vm2.h.a[281(0x119, float:3.94E-43)]);
        ViewGroup.inflate(r2, 2131566535, this);
        this.b = findViewById(2131386541);
        this.c = (TextView) findViewById(2131386546);
        this.d = (TextView) findViewById(2131377055);
        this.e = findViewById(2131377049);
        this.f = findViewById(2131377050);
        this.g = findViewById(2131377053);
        this.h = findViewById(2131377051);
        this.i = findViewById(2131392588);
        this.j = findViewById(2131392589);
    }

    public /* synthetic */ KtvRoomSingEndedFeedbackViewMidiStageV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
