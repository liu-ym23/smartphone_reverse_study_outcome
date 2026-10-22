package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnLayout;
import com.bytedance.android.ec.model.response.ECFloatWindowDetailInfo;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.ECFloatPanelExpandedUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public View a;
    public ECNetImageView b;
    public ECNetImageView c;
    public ImageButton d;
    public LinearLayout e;
    public lk2.b f;
    public final Context g;
    public final LiveRoomParams h;
    public final Function0<Boolean> i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0109a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0109a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a.a(this.a);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            a.a(this.a);
        }
    }

    public final void e() {
        if (this.a == null) goto L5;
        return;
    L5:
        View r0 = th.a.c(this.g, 2131560930, null, false);
        this.a = r0;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        r0.setBackground(null);
        View r1 = this.a;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r2 = this.a;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        this.b = r2.findViewById(2131376506);
        View r3 = this.a;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        this.c = r3.findViewById(2131376682);
        View r4 = this.a;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L20:
        this.d = (ImageButton) r4.findViewById(2131375994);
        View r5 = this.a;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L23:
        this.e = (LinearLayout) r5.findViewById(2131377474);
        View r6 = this.a;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L26:
        r6.findViewById(2131377515).setOnClickListener(new ViewOnClickListenerC0109a(this));
        ImageButton r7 = this.d;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L29:
        r7.setOnClickListener(new b(this));
    }

    public final Context getContext() {
        return this.g;
    }

    public static final void a(a r3) {
        if (((Boolean) r3.i.invoke()).booleanValue() == false) goto L14;
        ECFloatPanelExpandedUtils.b(!ECFloatPanelExpandedUtils.a());
        lk2.b r0 = r3.f;
        if (r0 == null) goto L8;
        ECFloatWindowDetailInfo r1 = r0.b;
    L9:
        r3.f(r1);
        lk2.b r2 = r3.f;
        boolean r4 = ECFloatPanelExpandedUtils.a();
        if (r2 == null) goto L15;
        oh.a.b("recordSizeInfoClickEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.b(r3, r2, r4));
        return;
    L15:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void b(lk2.b r17) {
        boolean r1 = !Intrinsics.areEqual(r17, this.f);
        this.f = r17;
        if (r17 == null) goto L97;
        ECFloatWindowDetailInfo r7 = r17.b;
        if (r7 == null) goto L98;
        e();
        if (r1 == false) goto L21;
        ECFloatWindowColumnLayout r2 = r7.getLayout();
        if (r2 == null) goto L21;
        View r3 = this.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        int r5 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r2.getLeftMargin()));
        View r8 = this.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        int r9 = r8.getPaddingTop();
        int r4 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r2.getRightMargin()));
        View r10 = this.a;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L20:
        r3.setPadding(r5, r9, r4, r10.getPaddingBottom());
    L21:
        ECNetImageView r6 = this.b;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("ivProductCover");
    L24:
        ECLiveImageUtils.ECNetImageInfo r11 = new ECLiveImageUtils.ECNetImageInfo();
        String r12 = r7.getImage();
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        r11.url = r12;
        r11.height = -3;
        r11.width = (int) UIUtils.dip2Px(this.g, 24.0f);
        r11.autoScaleOneSide = true;
        r11.disableFade = true;
        r11.disablePlaceholder = true;
        r11.roundDp = 2;
        Unit r13 = Unit.INSTANCE;
        ECLiveImageUtils.b(r6, r11);
        ECNetImageView r14 = this.c;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivTitle");
    L30:
        ECLiveImageUtils.ECNetImageInfo r15 = new ECLiveImageUtils.ECNetImageInfo();
        ECUrlModel r16 = r7.getTitleImage();
        String r18 = null;
        if (r16 == null) goto L33;
        String r19 = r16.getFirstUrl();
    L34:
        if (r19 != null) goto L36;
        r19 = "";
    L36:
        r15.url = r19;
        r15.height = -3;
        r15.width = (int) UIUtils.dip2Px(this.g, 52.0f);
        r15.autoScaleOneSide = true;
        r15.disableFade = true;
        r15.disablePlaceholder = true;
        ECLiveImageUtils.b(r14, r15);
        final ECFloatWindowDetailInfo r20 = r17.b;
        if (r20 == null) goto L92;
        Integer r0 = r17.getType();
        int r110 = 0;
        if (r0 != null) goto L43;
    L45:
        final boolean r21 = false;
    L46:
        LinearLayout r22 = this.e;
        if (r22 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L49:
        r22.removeAllViewsInLayout();
        final StringBuilder r111 = new StringBuilder();
        List r23 = r20.getColumnInfos();
        if (r23 == null) goto L54;
        ECFloatWindowColumnInfo r24 = (ECFloatWindowColumnInfo) CollectionsKt.firstOrNull(r23);
        if (r24 == null) goto L54;
        String r25 = r24.getTitle();
    L55:
        if (r25 != null) goto L57;
        String r112 = "";
    L58:
        List r26 = r20.getColumnInfos();
        if (r26 == null) goto L63;
        ECFloatWindowColumnInfo r27 = (ECFloatWindowColumnInfo) CollectionsKt.lastOrNull(r26);
        if (r27 == null) goto L63;
        r18 = r27.getTitle();
    L63:
        if (r18 != null) goto L65;
        r18 = "";
    L65:
        LinearLayout r113 = this.e;
        if (r113 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L68:
        r113.addView(d(r112, r18, true, r21, r20.getLayout().getCenterMargin()));
        r111.append(r112);
        r111.append(",");
        r111.append(r18);
        List r28 = r20.getColumnInfos();
        if (r28 == null) goto L74;
        ECFloatWindowColumnInfo r29 = (ECFloatWindowColumnInfo) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L74;
        List r30 = r29.getElements();
        if (r30 == null) goto L74;
    L75:
        List r31 = r20.getColumnInfos();
        if (r31 == null) goto L81;
        ECFloatWindowColumnInfo r32 = (ECFloatWindowColumnInfo) CollectionsKt.lastOrNull(r31);
        if (r32 == null) goto L81;
        List r33 = r32.getElements();
        if (r33 == null) goto L81;
    L82:
        int r34 = r30.size();
    L83:
        if (r110 >= r34) goto L88;
        if (r110 >= r33.size()) goto L87;
        UtilityKotlinExtentionsKt.f(CollectionsKt.getOrNull(r30, r110), CollectionsKt.getOrNull(r33, r110), new ECFloatWindowPanelViewManager$bindContent$1(this, r21, r20, r111));
    L87:
        r110 = r110 + 1;
        goto L83
    L88:
        LinearLayout r35 = this.e;
        if (r35 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L91:
        r35.setContentDescription(r111);
    L81:
        r33 = CollectionsKt.emptyList();
    L74:
        r30 = CollectionsKt.emptyList();
        goto L75
    L57:
        r112 = r25;
    L54:
        r25 = null;
        goto L55
    L43:
        if (r0.intValue() != 2) goto L45;
        r21 = true;
    L92:
        f(r7);
        return;
    L33:
        r19 = null;
        goto L34
    L98:
        return;
    }

    public final void f(ECFloatWindowDetailInfo r4) {
        if (ECFloatPanelExpandedUtils.a() == false) goto L11;
        ImageButton r0 = this.d;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L7:
        r0.setRotation(180.0f);
        LinearLayout r1 = this.e;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L10:
        r1.setVisibility(0);
    L18:
        View r2 = this.a;
        if (r2 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        View r3 = r2.findViewById(2131377515);
        if (r3 == null) goto L34;
        StringBuilder r5 = new StringBuilder();
        if (r4 == null) goto L27;
        String r6 = r4.getTitle();
        if (r6 == null) goto L27;
    L28:
        r5.append(r6);
        r5.append(' ');
        if (ECFloatPanelExpandedUtils.a() == false) goto L31;
        String r7 = "收起";
    L32:
        r5.append(r7);
        r3.setContentDescription(r5.toString());
        return;
    L31:
        r7 = "展开";
    L27:
        r6 = "商品信息";
        goto L28
    L34:
        return;
    L11:
        ImageButton r8 = this.d;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L14:
        r8.setRotation(0.0f);
        LinearLayout r9 = this.e;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L17:
        r9.setVisibility(8);
        goto L18
    }

    public a(Context r2, LiveRoomParams r3, Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "canToggle");
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }

    public final View d(String r11, String r12, boolean r13, boolean r14, int r15) {
        FrameLayout r0 = new FrameLayout(this.g);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) UIUtils.dip2Px(r0.getContext(), 20.0f)));
        float r1 = (float) Math.ceil(r11.length() * 11.25f);
        r0.addView(c(r11, r13, false, r14, r1, r15));
        r0.addView(c(r12, r13, true, r14, r1, r15));
        r0.setTag(Boolean.valueOf(r13));
        return r0;
    }

    public final TextView c(String r5, boolean r6, boolean r7, boolean r8, float r9, int r10) {
        TextView r0 = new TextView(this.g);
        if (r6 == false) goto L5;
        r0.setTextColor((int) 3221225471L);
    L6:
        if (r6 == false) goto L8;
        float r11 = 10.0f;
    L9:
        r0.setTextSize(1, r11);
        r0.setText(r5);
        r0.setSingleLine();
        if (r7 == false) goto L12;
        int r12 = 21;
    L13:
        r0.setGravity(r12);
        if (r7 == false) goto L18;
        if (r8 == false) goto L17;
        r9 = (96.0f - r9) - r10;
    L21:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams((int) UIUtils.dip2Px(r0.getContext(), r9), -1);
        if (r7 == false) goto L24;
        r13.gravity = 5;
    L24:
        Unit r14 = Unit.INSTANCE;
        r0.setLayoutParams(r13);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        return r0;
    L17:
        r9 = 52.0f;
        goto L21
    L18:
        if (r8 == true) goto L21;
        r9 = 34.0f;
        goto L21
    L12:
        r12 = 16;
        goto L13
    L8:
        r11 = 11.0f;
        goto L9
    L5:
        r0.setTextColor(-1);
        goto L6
    }
}
