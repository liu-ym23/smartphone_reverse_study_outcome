package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class UIConfigHelper$updateUIByLayout$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConstraintSet $constraintSet;
    final /* synthetic */ Map $moduleIdMap;

    public UIConfigHelper$updateUIByLayout$2(Map r1, ConstraintSet r2) {
        this.$moduleIdMap = r1;
        this.$constraintSet = r2;
        super(0);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper$updateUIByLayout$2$$special$$inlined$runCatching$lambda$1] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m924invoke() {
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L13
        ?? r22 = new UIConfigHelper$updateUIByLayout$2$$special$$inlined$runCatching$lambda$1(this);     // Catch: Throwable -> L13
        Class r5 = INVOKESTATIC_com_bytedance_android_livesdk_livecommerce_promotion_card_utils_UIConfigHelper$updateUIByLayout$2_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("androidx.constraintlayout.widget.ConstraintSet$Constraint");     // Catch: Throwable -> L13
        Field r1 = r5.getDeclaredField("leftToLeft");     // Catch: Throwable -> L13
        String r21 = "leftToLeft";
        r1.setAccessible(true);     // Catch: Throwable -> L13
        Field r4 = r5.getDeclaredField("leftToRight");     // Catch: Throwable -> L13
        String r24 = "leftToRight";
        r4.setAccessible(true);     // Catch: Throwable -> L13
        Field r3 = r5.getDeclaredField("rightToLeft");     // Catch: Throwable -> L13
        String r25 = "rightToLeft";
        r3.setAccessible(true);     // Catch: Throwable -> L13
        Field r2 = r5.getDeclaredField("rightToRight");     // Catch: Throwable -> L13
        String r26 = "rightToRight";
        r2.setAccessible(true);     // Catch: Throwable -> L13
        Field r0 = r5.getDeclaredField("topToTop");     // Catch: Throwable -> L13
        String r27 = "topToTop";
        r0.setAccessible(true);     // Catch: Throwable -> L13
        Field r15 = r5.getDeclaredField("topToBottom");     // Catch: Throwable -> L13
        String r28 = "topToBottom";
        r15.setAccessible(true);     // Catch: Throwable -> L13
        Field r14 = r5.getDeclaredField("bottomToTop");     // Catch: Throwable -> L13
        String r29 = "bottomToTop";
        r14.setAccessible(true);     // Catch: Throwable -> L13
        Field r13 = r5.getDeclaredField("bottomToBottom");     // Catch: Throwable -> L13
        String r30 = "bottomToBottom";
        r13.setAccessible(true);     // Catch: Throwable -> L13
        Field r12 = r5.getDeclaredField("startToEnd");     // Catch: Throwable -> L13
        String r31 = "startToEnd";
        r12.setAccessible(true);     // Catch: Throwable -> L13
        Field r11 = r5.getDeclaredField("startToStart");     // Catch: Throwable -> L13
        String r32 = "startToStart";
        r11.setAccessible(true);     // Catch: Throwable -> L13
        Field r10 = r5.getDeclaredField("endToStart");     // Catch: Throwable -> L13
        String r33 = "endToStart";
        r10.setAccessible(true);     // Catch: Throwable -> L13
        Field r9 = r5.getDeclaredField("endToEnd");     // Catch: Throwable -> L13
        String r34 = "endToEnd";
        r9.setAccessible(true);     // Catch: Throwable -> L13
        Field r8 = r5.getDeclaredField("leftMargin");     // Catch: Throwable -> L13
        String r35 = "leftMargin";
        r8.setAccessible(true);     // Catch: Throwable -> L13
        Field r7 = r5.getDeclaredField("rightMargin");     // Catch: Throwable -> L13
        String r36 = "rightMargin";
        r7.setAccessible(true);     // Catch: Throwable -> L13
        Field r23 = r7;
        Field r16 = r5.getDeclaredField("startMargin");     // Catch: Throwable -> L13
        String r37 = "startMargin";
        r16.setAccessible(true);     // Catch: Throwable -> L13
        Field r19 = r16;
        Field r17 = r5.getDeclaredField("endMargin");     // Catch: Throwable -> L13
        String r38 = "endMargin";
        r17.setAccessible(true);     // Catch: Throwable -> L13
        Field r18 = r17;
        Field r39 = r5.getDeclaredField("topMargin");     // Catch: Throwable -> L13
        String r310 = "topMargin";
        r39.setAccessible(true);     // Catch: Throwable -> L13
        Field r110 = r39;
        Field r40 = r5.getDeclaredField("bottomMargin");     // Catch: Throwable -> L13
        String r41 = "bottomMargin";
        r40.setAccessible(true);     // Catch: Throwable -> L13
        Field r6 = r5.getDeclaredField("visibility");     // Catch: Throwable -> L13
        String r111 = "visibility";
        r6.setAccessible(true);     // Catch: Throwable -> L13
        UIConfigHelper$updateUIByLayout$2 r42 = this;
        Field r210 = r6;
        Iterator r43 = r42.$moduleIdMap.entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (r43.hasNext() == false) goto L11;
        Map.Entry r44 = (Map.Entry) r43.next();     // Catch: Throwable -> L13
        Iterator r45 = r43;
        ConstraintSet.Constraint r46 = r42.$constraintSet.getParameters(((Number) r44.getValue()).intValue());     // Catch: Throwable -> L13
        if (r46 == null) goto L10;
        int r47 = r1.getInt(r46);     // Catch: Throwable -> L13
        Field r48 = r1;
        ?? r49 = r22;
        String r50 = r49.invoke(r47);     // Catch: Throwable -> L13
        String r51 = r49.invoke(r4.getInt(r46));     // Catch: Throwable -> L13
        Field r410 = r4;
        String r52 = r49.invoke(r3.getInt(r46));     // Catch: Throwable -> L13
        Field r411 = r3;
        String r53 = r49.invoke(r2.getInt(r46));     // Catch: Throwable -> L13
        Field r412 = r2;
        String r54 = r49.invoke(r0.getInt(r46));     // Catch: Throwable -> L13
        Field r413 = r0;
        String r55 = r49.invoke(r15.getInt(r46));     // Catch: Throwable -> L13
        Field r414 = r15;
        String r112 = r49.invoke(r14.getInt(r46));     // Catch: Throwable -> L13
        Field r415 = r14;
        String r113 = r49.invoke(r13.getInt(r46));     // Catch: Throwable -> L13
        Field r56 = r13;
        String r114 = r49.invoke(r12.getInt(r46));     // Catch: Throwable -> L13
        Field r57 = r12;
        String r115 = r49.invoke(r11.getInt(r46));     // Catch: Throwable -> L13
        Field r58 = r11;
        String r116 = r49.invoke(r10.getInt(r46));     // Catch: Throwable -> L13
        Field r59 = r10;
        String r117 = r49.invoke(r9.getInt(r46));     // Catch: Throwable -> L13
        int r60 = r8.getInt(r46);     // Catch: Throwable -> L13
        Field r510 = r8;
        Field r61 = r23;
        Field r211 = r9;
        int r62 = r61.getInt(r46);     // Catch: Throwable -> L13
        Field r63 = r19;
        int r64 = r63.getInt(r46);     // Catch: Throwable -> L13
        Field r65 = r18;
        int r66 = r65.getInt(r46);     // Catch: Throwable -> L13
        Field r67 = r110;
        int r68 = r67.getInt(r46);     // Catch: Throwable -> L13
        int r69 = r40.getInt(r46);     // Catch: Throwable -> L13
        Field r610 = r40;
        Field r70 = r210;
        int r71 = r70.getInt(r46);     // Catch: Throwable -> L13
        int r212 = com.bytedance.android.ec.sdk.helper.j.a;     // Catch: Throwable -> L13
        r210 = r70;
        JSONObject r72 = new JSONObject();     // Catch: Throwable -> L13
        r72.put("modelName", ((PromotionCardModuleName) r44.getKey()).getModuleName());     // Catch: Throwable -> L13
        String r73 = r21;
        r72.put(r73, r50);     // Catch: Throwable -> L13
        String r74 = r24;
        r72.put(r74, r51);     // Catch: Throwable -> L13
        String r75 = r25;
        r72.put(r75, r52);     // Catch: Throwable -> L13
        String r76 = r26;
        r72.put(r76, r53);     // Catch: Throwable -> L13
        String r77 = r27;
        r72.put(r77, r54);     // Catch: Throwable -> L13
        String r78 = r28;
        r72.put(r78, r55);     // Catch: Throwable -> L13
        String r79 = r29;
        r72.put(r79, r112);     // Catch: Throwable -> L13
        String r118 = r30;
        r72.put(r118, r113);     // Catch: Throwable -> L13
        String r119 = r31;
        r72.put(r119, r114);     // Catch: Throwable -> L13
        String r120 = r32;
        r72.put(r120, r115);     // Catch: Throwable -> L13
        String r121 = r33;
        r72.put(r121, r116);     // Catch: Throwable -> L13
        String r122 = r34;
        r72.put(r122, r117);     // Catch: Throwable -> L13
        String r123 = r35;
        r72.put(r123, r60);     // Catch: Throwable -> L13
        r29 = r79;
        String r80 = r36;
        r72.put(r80, r62);     // Catch: Throwable -> L13
        r36 = r80;
        String r81 = r37;
        r72.put(r81, r64);     // Catch: Throwable -> L13
        r37 = r81;
        String r82 = r38;
        r72.put(r82, r66);     // Catch: Throwable -> L13
        String r83 = r310;
        r72.put(r83, r68);     // Catch: Throwable -> L13
        String r85 = r41;
        r72.put(r85, r69);     // Catch: Throwable -> L13
        String r86 = r111;
        r72.put(r86, r71);     // Catch: Throwable -> L13
        Unit r87 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r111 = r86;
        com.bytedance.android.ec.sdk.helper.j.a("UIConfigHelper", r72.toString(), null, null);     // Catch: Throwable -> L13
        r28 = r78;
        r27 = r77;
        r26 = r76;
        r21 = r73;
        r25 = r75;
        r24 = r74;
        r41 = r85;
        r35 = r123;
        r34 = r122;
        r33 = r121;
        r32 = r120;
        r31 = r119;
        r30 = r118;
        r310 = r83;
        r38 = r82;
        r9 = r211;
        r43 = r45;
        r1 = r48;
        r4 = r410;
        r3 = r411;
        r2 = r412;
        r0 = r413;
        r15 = r414;
        r14 = r415;
        r13 = r56;
        r12 = r57;
        r11 = r58;
        r10 = r59;
        r22 = r49;
        r8 = r510;
        r23 = r61;
        r19 = r63;
        r18 = r65;
        r110 = r67;
        r40 = r610;
        r42 = this;
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m924invoke();
        return Unit.INSTANCE;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdk_livecommerce_promotion_card_utils_UIConfigHelper$updateUIByLayout$2_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }
}
