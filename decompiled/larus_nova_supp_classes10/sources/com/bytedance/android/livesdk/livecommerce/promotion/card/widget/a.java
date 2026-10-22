package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPingGroup;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.RemoteGroupHeadImageOptView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends FrameLayout implements ij2.a {
    public ECUIPromotion a;
    public final RelativeLayout b;
    public final ImageView c;
    public final TextView d;
    public View e;
    public View f;
    public StringBuilder g;
    public final b h;
    public final LivePromotionCardArgs i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.card.widget.a$a, reason: collision with other inner class name */
    public static final class C0087a {
    }

    static {
    }

    @Override // ij2.a
    public String getType() {
        return "ping_group_widget";
    }

    @Override // ij2.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.g;
        if (r0 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r0);
    }

    @Override // ij2.a
    public final void release() {
        this.i.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(this.h);
    }

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C0143a.b(this);
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C0143a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setImageOpt(ECUIPingGroup r14) {
        int r0 = (int) ((r14.getJoined() / r14.getGroupSize()) * 100);
        this.b.removeAllViews();
        List r2 = r14.getAvatarList();
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L7:
        if (r3 != 0) goto L13;
        this.c.setVisibility(0);
        this.b.setVisibility(8);
        ViewGroup.LayoutParams r15 = this.d.getLayoutParams();
        if (r15 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r15).leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(17.0f));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        Object r12 = null;
        if (r3 > 2) goto L39;
        if (r0 == 100) goto L39;
        this.c.setVisibility(0);
        this.b.setVisibility(0);
        List r16 = r14.getAvatarList();
        if (r16 != null) goto L19;
    L34:
        ViewGroup.LayoutParams r17 = this.d.getLayoutParams();
        if (r17 == null) goto L38;
        ((ViewGroup.MarginLayoutParams) r17).leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(27.0f));
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        if ((!r16.isEmpty()) == true) goto L22;
        r16 = null;
    L22:
        if (r16 == null) goto L34;
        this.e = LayoutInflater.from(getContext()).inflate(2131564753, this, false);
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)));
        View r4 = this.e;
        if (r4 == null) goto L26;
        r4.setLayoutParams(r1);
    L26:
        View r5 = this.e;
        if (r5 == null) goto L29;
        r5.setTranslationX(UtilityKotlinExtentionsKt.c(Float.valueOf(10.0f)));
    L29:
        this.b.addView(this.e);
        View r6 = this.e;
        if ((r6 instanceof RemoteGroupHeadImageOptView) == false) goto L33;
        r12 = r6;
    L33:
        ECLiveImageUtils.j((RemoteGroupHeadImageOptView) r12, (String) ListProtector.get(r16, 0));
    L39:
        if (r3 >= 2) goto L42;
        if (r3 != 2) goto L89;
        if (r0 >= 100) goto L42;
        return;
    L89:
        return;
    L42:
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        List r7 = r14.getAvatarList();
        if (r7 != null) goto L45;
    L60:
        List r18 = r14.getAvatarList();
        if (r18 != null) goto L63;
    L81:
        ViewGroup.LayoutParams r19 = this.d.getLayoutParams();
        if (r19 == null) goto L86;
        ((ViewGroup.MarginLayoutParams) r19).leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(27.0f));
        return;
    L86:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L63:
        if (r18.size() <= 1) goto L65;
        boolean r8 = true;
    L66:
        if (r8 == true) goto L69;
        r18 = null;
    L69:
        if (r18 == null) goto L81;
        this.f = LayoutInflater.from(getContext()).inflate(2131564753, this, false);
        RelativeLayout.LayoutParams r9 = new RelativeLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)));
        View r10 = this.f;
        if (r10 == null) goto L73;
        r10.setLayoutParams(r9);
    L73:
        View r11 = this.f;
        if (r11 == null) goto L76;
        r11.setTranslationX(UtilityKotlinExtentionsKt.c(Float.valueOf(10.0f)));
    L76:
        this.b.addView(this.f);
        View r13 = this.f;
        if ((r13 instanceof RemoteGroupHeadImageOptView) == false) goto L80;
        r12 = r13;
    L80:
        ECLiveImageUtils.j((RemoteGroupHeadImageOptView) r12, (String) ListProtector.get(r18, 1));
        goto L81
    L65:
        r8 = false;
        goto L66
    L45:
        if ((!r7.isEmpty()) == true) goto L48;
        r7 = null;
    L48:
        if (r7 == null) goto L60;
        View r20 = LayoutInflater.from(getContext()).inflate(2131564753, this, false);
        this.e = r20;
        if (r20 == 0) goto L59;
        ((RemoteGroupHeadImageOptView) r20).setClip(false);
        RelativeLayout.LayoutParams r21 = new RelativeLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)));
        View r22 = this.e;
        if (r22 == null) goto L54;
        r22.setLayoutParams(r21);
    L54:
        this.b.addView(this.e);
        Object r23 = this.e;
        if ((r23 instanceof RemoteGroupHeadImageOptView) == true) goto L57;
        r23 = null;
    L57:
        ECLiveImageUtils.j((RemoteGroupHeadImageOptView) r23, (String) ListProtector.get(r7, 0));
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.view.RemoteGroupHeadImageOptView");
    L5:
        r3 = 0;
        goto L7
    }

    private final void setText(ECUIPingGroup r9) {
        int r0 = (int) ((r9.getJoined() / r9.getGroupSize()) * 100);
        String r4 = "";
        boolean r5 = true;
        if (r9.getJoined() > 2) goto L8;
        if (r0 < 100) goto L6;
        r4 = getContext().getResources().getString(2131896529);
    L25:
        if (r4.length() > 0) goto L28;
        r5 = false;
    L28:
        if (r5 == false) goto L33;
        this.d.setText(r4);
        StringBuilder r10 = this.g;
        if (r10 == null) goto L34;
        r10.append(r4);
        return;
    L34:
        return;
    L33:
        return;
    L6:
        r4 = getContext().getResources().getString(2131896535, new Object[]{String.valueOf(r9.getGroupSize()), ""});
        goto L25
    L8:
        if (r9.getJoined() <= 2) goto L13;
        if (r0 > 80) goto L13;
        r4 = getContext().getResources().getString(2131896534, new Object[]{String.valueOf(r9.getJoined()), String.valueOf(r9.getGroupSize())});
    L13:
        if (81 > r0) goto L17;
        if (100 <= r0) goto L17;
        r4 = getContext().getResources().getString(2131896531, new Object[]{String.valueOf(r9.getJoined()), String.valueOf(r9.getGroupSize() - r9.getJoined())});
    L17:
        if (r0 < 100) goto L25;
        if (TextUtils.isEmpty(r9.getTime()) == false) goto L21;
    L23:
        r4 = getContext().getResources().getString(2131896529);
        goto L25
    L21:
        if (r9.isShowTime() == false) goto L23;
        r4 = getContext().getResources().getString(2131896530, new Object[]{r9.getTime()});
        goto L25
    }

    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2.a;
        this.g = new StringBuilder();
        ECUIPromotion r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r4 = r3.getCampaign();
        if (r4 == null) goto L11;
        ECUIPingGroup r5 = r4.groupData;
        if (r5 == null) goto L12;
        setText(r5);
        setImageOpt(r5);
        this.i.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(this.h);
        return;
    L12:
        return;
    }

    public a(Context r3, LivePromotionCardArgs r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "argument");
        super(r3, null, 0);
        this.i = r4;
        this.h = new b(this);
        View r5 = LayoutInflater.from(r3).inflate(2131564752, this, true);
        RelativeLayout r6 = (RelativeLayout) r5.findViewById(2131384706);
        this.b = (RelativeLayout) r5.findViewById(2131384690);
        this.c = (ImageView) r5.findViewById(2131376655);
        this.d = (TextView) r5.findViewById(2131390715);
    }

    public static final void c(a r10, long r11) {
        ECUIPromotion r0 = r10.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r1 = r0.getCampaign();
        ECUIPromotion r2 = r10.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L8:
        ECUICampaign r3 = r2.getCampaign();
        if (r3 == null) goto L11;
        ECUIPingGroup r4 = r3.groupData;
    L12:
        if (r1 == null) goto L32;
        if (r4 == null) goto L33;
        long r5 = r1.endTime - r11;
        if (r5 > 0) goto L17;
        String r12 = "00:00:00";
    L30:
        r4.setTime(r12);
        r10.setText(r4);
        return;
    L17:
        StringBuilder r6 = new StringBuilder();
        long r7 = r5 / 86400000;
        if (r7 <= 0) goto L20;
        r5 = r5 - (86400000 * r7);
        r6.append(r7);
        r6.append("天");
    L20:
        long r8 = r5 / 3600000;
        long r9 = r5 - (3600000 * r8);
        if (r8 > 9) goto L23;
        r6.append(0);
    L23:
        r6.append(r8);
        r6.append(":");
        long r13 = r9 / 60000;
        long r14 = r9 - (60000 * r13);
        if (r13 > 9) goto L26;
        r6.append(0);
    L26:
        r6.append(r13);
        r6.append(":");
        long r15 = r14 / 1000;
        if (r15 > 9) goto L29;
        r6.append(0);
    L29:
        r6.append(r15);
        r12 = r6.toString();
        goto L30
    L33:
        return;
    L32:
        return;
    L11:
        r4 = null;
        goto L12
    }
}
