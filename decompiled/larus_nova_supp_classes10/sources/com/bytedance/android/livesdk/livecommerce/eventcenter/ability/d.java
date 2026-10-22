package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECAddCartMotionImageLayout;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_list_show_add_cart_motion", description = "显示加购动画", service = {"LiveBase"})
public final class d extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {
    public final /* synthetic */ tg2.a a;

    @Override // tg2.b
    public final void logE(String r2) {
        this.a.logE(r2);
    }

    public d() {
        this.a = new tg2.a("AddCartMotion");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r25, JSONObject r26, Object r27, il2.a r28, final com.bytedance.android.livesdk.livecommerce.ability.e r29) {
        JSONObject r2 = r26;
        if (r25 == null) goto L214;
        if (r2 == null) goto L214;
        String r8 = r2.optString("animation_image_url");
        String r3 = r2.optString("room_id");
        String r4 = r2.optString("room_unique_key");
        int r5 = r2.optInt("coordinate_mode", 0);
        if (r5 == 0) goto L11;
        if (r5 == 1) goto L10;
        boolean r6 = false;
        boolean r7 = false;
    L12:
        int r9 = 0;
    L13:
        float r10 = (float) r2.optDouble("source_loc_x", -1.0d);
        float r14 = (float) r2.optDouble("source_loc_y", -1.0d);
        float r13 = (float) r2.optDouble("destination_loc_x", -1.0d);
        float r11 = (float) r2.optDouble("destination_loc_y", -1.0d);
        float r15 = 0;
        if (r13 >= r15) goto L16;
    L17:
        PromotionListController.T.getClass();
        com.bytedance.android.shopping.ligo.context.b<?> r12 = PromotionListController.a.c(r3, r4).J;
        if (r12 == null) goto L53;
        String r18 = (String) r12.d("cart_icon_loc");
        if (r18 == null) goto L53;
        List r16 = StringsKt.split$default(r18, new String[]{","}, false, 0, 6, null);
        if (r16.size() != 2) goto L53;
        fh2.a r17 = PromotionListController.a.b(r3, r4);
        if (r17 == null) goto L53;
        float[] r19 = new float[2];
        String r20 = (String) ListProtector.get(r16, 0);
        if (r20 == null) goto L51;
        Float r21 = StringsKt.toFloatOrNull(StringsKt.trim(r20).toString());
        if (r21 == null) goto L31;
        float r22 = r21.floatValue();
    L32:
        r19[0] = r22;
        String r23 = (String) ListProtector.get(r16, 1);
        if (r23 == null) goto L49;
        Float r24 = StringsKt.toFloatOrNull(StringsKt.trim(r23).toString());
        if (r24 == null) goto L37;
        float r30 = r24.floatValue();
    L38:
        r19[1] = r30;
        float[] r31 = ((LivePromotionListFragment) r17).Y90(r19, 1);
        if (r31 == null) goto L53;
        Float r110 = ArraysKt.getOrNull(r31, 0);
        if (r110 == null) goto L43;
        float r111 = r110.floatValue();
    L44:
        Float r32 = ArraysKt.getOrNull(r31, 1);
        if (r32 == null) goto L47;
        r13 = r111;
        r11 = r32.floatValue();
    L55:
        if (r13 >= r15) goto L57;
    L58:
        fh2.a r33 = PromotionListController.a.b(r3, r4);
        if (r33 == null) goto L71;
        View r34 = ((LivePromotionListFragment) r33).En();
        if (r34 == null) goto L71;
        float[] r35 = wj2.d.a(r34);
        Float r112 = ArraysKt.getOrNull(r35, 0);
        if (r112 == null) goto L65;
        float r113 = r112.floatValue();
    L66:
        Float r36 = ArraysKt.getOrNull(r35, 1);
        if (r36 == null) goto L69;
        float r114 = r36.floatValue();
    L70:
        r13 = r113;
        r11 = r114;
        goto L71
    L69:
        r114 = -1.0f;
        goto L70
    L65:
        r113 = -1.0f;
    L71:
        r7 = false;
    L73:
        if (r10 < r15) goto L211;
        if (r14 < r15) goto L211;
        if (r13 < r15) goto L211;
        if (r11 < r15) goto L211;
        if (r6 == false) goto L94;
        PromotionListController.T.getClass();
        fh2.a r37 = PromotionListController.a.b(r3, r4);
        if (r37 == null) goto L94;
        float[] r38 = ((LivePromotionListFragment) r37).Y90(new float[]{r10, r14}, r9);
        if (r38 == null) goto L94;
        Float r115 = ArraysKt.getOrNull(r38, 0);
        if (r115 == null) goto L89;
        r10 = r115.floatValue();
    L90:
        Float r39 = ArraysKt.getOrNull(r38, 1);
        if (r39 == null) goto L93;
        float r40 = r39.floatValue();
    L95:
        if (r7 == false) goto L108;
        PromotionListController.T.getClass();
        fh2.a r41 = PromotionListController.a.b(r3, r4);
        if (r41 == null) goto L108;
        float[] r42 = ((LivePromotionListFragment) r41).Y90(new float[]{r13, r11}, r9);
        if (r42 == null) goto L108;
        Float r43 = ArraysKt.getOrNull(r42, 0);
        if (r43 == null) goto L103;
        r13 = r43.floatValue();
    L104:
        Float r44 = ArraysKt.getOrNull(r42, 1);
        if (r44 == null) goto L107;
        r11 = r44.floatValue();
        goto L108
    L107:
        r11 = 0.0f;
        goto L108
    L103:
        r13 = 0.0f;
    L108:
        long r45 = r2.optLong("delay", 0);
        Float r0 = Float.valueOf((float) r2.optDouble("anim_layout_width", 0.0d));
        if (r0.floatValue() <= r15) goto L111;
        boolean r1 = true;
    L112:
        if (r1 == true) goto L115;
        r0 = null;
    L115:
        Float r46 = Float.valueOf((float) r2.optDouble("anim_layout_height", 0.0d));
        if (r46.floatValue() <= r15) goto L118;
        boolean r47 = true;
    L119:
        if (r47 == false) goto L121;
        Float r116 = r46;
    L123:
        if ((r27 instanceof View) == true) goto L125;
        r27 = null;
    L125:
        View r48 = (View) r27;
        if (r48 == null) goto L164;
        JSONArray r49 = r2.optJSONArray("scale_x");
        if (r49 == null) goto L139;
        ArrayList r50 = new ArrayList();
        int r51 = r49.length();
        int r117 = 0;
    L130:
        if (r117 >= r51) goto L138;
        int r210 = r51;
        Object r52 = r49.get(r117);
        JSONArray r118 = r49;
        if ((r52 instanceof Double) == true) goto L134;
        r52 = null;
    L134:
        Double r53 = (Double) r52;
        Float r211 = r0;
        if (r53 == null) goto L137;
        r50.add(Float.valueOf((float) r53.doubleValue()));
    L137:
        r117 = r117 + 1;
        r51 = r210;
        r49 = r118;
        r0 = r211;
        goto L130
    L138:
        Float r212 = r0;
    L140:
        JSONArray r54 = r2.optJSONArray("scale_y");
        if (r54 == null) goto L152;
        ArrayList r55 = new ArrayList();
        int r56 = r54.length();
        int r57 = 0;
    L143:
        if (r57 >= r56) goto L151;
        Object r119 = r54.get(r57);
        JSONArray r213 = r54;
        if ((r119 instanceof Double) == true) goto L147;
        r119 = null;
    L147:
        Double r120 = (Double) r119;
        int r58 = r56;
        long r214 = r45;
        if (r120 == null) goto L150;
        r55.add(Float.valueOf((float) r120.doubleValue()));
    L150:
        r57 = r57 + 1;
        r56 = r58;
        r45 = r214;
        r54 = r213;
        goto L143
    L151:
        long r215 = r45;
    L153:
        if (r50 != null) goto L157;
        if (r55 != null) goto L157;
        AnimatorSet r59 = null;
    L163:
        AnimatorSet r60 = r59;
    L165:
        StringBuilder r61 = new StringBuilder("show add cart motion from (");
        r61.append(r10);
        r61.append(", ");
        r61.append(r40);
        r61.append(") to (");
        r61.append(r13);
        r61.append(", ");
        r61.append(r11);
        r61.append("), delay ");
        long r62 = r215;
        r61.append(r62);
        r61.append(", animateLayout ");
        r61.append(r48);
        String r63 = r61.toString();
        tg2.a r64 = this.a;
        r64.getClass();
        dm.a.b r65 = dm.a.a;
        dm.a.a(r64.b).i(r63);
        if (r8 != null) goto L168;
    L171:
        boolean r66 = true;
    L172:
        if (r66 == true) goto L207;
        float[] r67 = {r10, r40};
        float[] r68 = {r13, r11};
        Function0<Unit> r69 = new LiveAddCartMotionAbility$execute$6(this, r29);
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r67, "sourceLocation");
        Intrinsics.checkNotNullParameter(r68, "destinationLocation");
        if (r8 != null) goto L176;
    L179:
        boolean r70 = true;
    L180:
        if (r70 == true) goto L189;
        if (r8 != null) goto L183;
    L186:
        boolean r71 = true;
    L187:
        if (r71 == true) goto L189;
        ECAddCartMotionImageLayout r121 = new ECAddCartMotionImageLayout(r25, null, 6, 0);
        Intrinsics.checkNotNullParameter(r8, "imgUrl");
        com.bytedance.android.ec.core.imagex.h0.e(r121.a, r8, new com.bytedance.android.ec.core.imagex.r("ec_live", "list_add_cart_view"), null, null, 120);
        View r122 = r121;
        char r72 = 0;
    L190:
        float r73 = r67[r72];
        float r74 = r67[1];
        float r123 = r68[r72];
        float r75 = r68[1];
        Object r76 = r25.getSystemService("window");
        if ((r76 instanceof WindowManager) == true) goto L193;
        r76 = null;
    L193:
        WindowManager r77 = (WindowManager) r76;
        if (r70 == false) goto L196;
        float r78 = 10.0f;
    L197:
        int r79 = vf4.a.a(r25, r78);
        WindowManager.LayoutParams r124 = new WindowManager.LayoutParams();
        r124.width = r79;
        r124.height = r79;
        float r80 = r79 / 2.0f;
        r124.x = (int) (r73 - r80);
        r124.y = (int) ((r74 - eh.b.b(r25)) - r80);
        r124.flags = 664;
        r124.format = -3;
        r124.gravity = 8388659;
        r124.type = 99;
        if (r122 != null) goto L200;
        r122 = th.a.d(r25, 2131560777, null, 4);
    L200:
        if (r77 == null) goto L203;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r122, r124);
        r77.addView(r122, r124);
    L203:
        if (r75 >= r74) goto L205;
        TypeEvaluator r81 = new ti2.f(new PointF((r73 + r123) / 2.0f, (float) (((double) r75) - (((double) (r74 - r75)) * 0.3d))));
    L206:
        ValueAnimator r82 = ValueAnimator.ofObject(r81, new Object[]{new PointF(r73, r74), new PointF(r123, r75)});
        View r83 = r122;
        r82.addUpdateListener(new ti2.b(r77, r83, r124, r79, r25));
        ObjectAnimator r85 = ObjectAnimator.ofFloat(r83, "scaleX", new float[]{1.0f, 0.7f});
        ObjectAnimator r86 = ObjectAnimator.ofFloat(r83, "scaleY", new float[]{1.0f, 0.7f});
        ObjectAnimator r87 = ObjectAnimator.ofFloat(r83, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator r88 = ObjectAnimator.ofFloat(r83, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r89 = new AnimatorSet();
        r89.setStartDelay(r62);
        r89.play(r87);
        r89.setDuration(200);
        AnimatorSet r90 = new AnimatorSet();
        r90.playTogether(new Animator[]{r82, r85, r86});
        r90.setDuration(600);
        AnimatorSet r91 = new AnimatorSet();
        r91.play(r88);
        r91.setDuration(150);
        r91.addListener(new ti2.c(r69));
        AnimatorSet r92 = new AnimatorSet();
        r92.setInterpolator(new DecelerateInterpolator());
        r92.addListener(new ti2.d(r83, r77));
        r92.playSequentially(new Animator[]{r89, r90, r91});
        r92.start();
        return;
    L205:
        r81 = new ti2.e();
        goto L206
    L196:
        r78 = 26.0f;
        goto L197
    L183:
        if (r8.length() == 0) goto L186;
        r71 = false;
    L189:
        r72 = 0;
        r122 = null;
        goto L190
    L176:
        if (r8.length() == 0) goto L179;
        r70 = false;
        goto L180
    L207:
        int r93 = ECSdk.a;
        IECCommonService r94 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r94 == null) goto L224;
        r94.addCartMotion(r25, new float[]{r10, r40}, new float[]{r13, r11}, r62, r48, r212, r116, null, r60, Boolean.TRUE, new LiveAddCartMotionAbility$execute$7(this, r29));
        return;
    L224:
        return;
    L168:
        if (r8.length() == 0) goto L171;
        r66 = false;
    L157:
        ArrayList r95 = new ArrayList();
        if (r50 == null) goto L160;
        float[] r96 = CollectionsKt.toFloatArray(r50);
        r95.add(ObjectAnimator.ofFloat(r48, "scaleX", Arrays.copyOf(r96, r96.length)));
    L160:
        if (r55 == null) goto L162;
        float[] r97 = CollectionsKt.toFloatArray(r55);
        r95.add(ObjectAnimator.ofFloat(r48, "scaleY", Arrays.copyOf(r97, r97.length)));
    L162:
        r59 = new AnimatorSet();
        r59.playTogether(r95);
        Unit r98 = Unit.INSTANCE;
        goto L163
    L152:
        r215 = r45;
        r55 = null;
        goto L153
    L139:
        r212 = r0;
        r50 = null;
        goto L140
    L164:
        r212 = r0;
        r215 = r45;
        r116 = r116;
        r60 = null;
        goto L165
    L121:
        r116 = null;
        goto L123
    L118:
        r47 = false;
        goto L119
    L111:
        r1 = false;
        goto L112
    L93:
        r40 = 0.0f;
        goto L95
    L89:
        r10 = 0.0f;
    L94:
        r40 = r14;
    L211:
        if (r29 == null) goto L226;
        b(r29, "wrong coordinate point");
        return;
    L226:
        return;
    L57:
        if (r11 >= r15) goto L71;
    L47:
        r13 = r111;
        r11 = -1.0f;
        goto L55
    L43:
        r111 = -1.0f;
        goto L44
    L37:
        r30 = -1.0f;
        goto L38
    L49:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L31:
        r22 = -1.0f;
        goto L32
    L51:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L53:
        r11 = r11;
        r13 = r13;
        goto L55
    L16:
        if (r11 >= r15) goto L73;
    L10:
        r6 = true;
        r7 = true;
        r9 = 1;
        goto L13
    L11:
        r6 = r2.optBoolean("from_live_ligo_jsb_method");
        r7 = r6;
    L214:
        if (r29 == null) goto L228;
        b(r29, "context is null or params is null");
        return;
    }
}
