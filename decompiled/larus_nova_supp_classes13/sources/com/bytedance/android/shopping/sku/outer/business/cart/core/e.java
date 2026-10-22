package com.bytedance.android.shopping.sku.outer.business.cart.core;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAddCartChain;
import com.bytedance.android.shopping.sku.common.monitor.chain.SkuYataAptChain;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ SkuOuterAddToCartHelper a;
    public final /* synthetic */ String b;
    public final /* synthetic */ th3.a c;

    public e(SkuOuterAddToCartHelper r1, String r2, th3.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String, th3.c] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void accept(Object r39) {
        th3.c r2 = (th3.c) r39;
    L140:
        e = e;
        String r10 = "log_id";
        String r8 = "error_msg";
        String r33 = "";
        String r7 = "error_code";
        String r6 = "is_new_api";
    L142:
        String r3 = this.a.c.f();
        if (r3 != null) goto L145;
    L148:
        boolean r5 = true;
    L149:
        if (r5 == true) goto L151;
        int r4 = b.a;
        b.b(null, this.a.c.f(), false);
        ?? r9 = 0;
    L152:
        this.a.c(r9);
        this.a.f.b(r9, e);
        mh3.a r11 = this.a.a;
        if (r11 == null) goto L160;
        com.bytedance.android.shopping.sku.common.monitor.error.a r12 = r11.c;
        if (r12 == null) goto L160;
        SkuErrorMonitorType r13 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        String r14 = "加购遭遇异常:" + e.getMessage();
        JSONObject r15 = new JSONObject();
        r15.put(r7, String.valueOf(r2.a));
        String r16 = r2.b;
        if (r16 != null) goto L159;
        r16 = r33;
    L159:
        r15.put(r8, r16);
        r15.put(r6, 1);
        r15.put(r10, r2.d);
        Unit r17 = Unit.INSTANCE;
        r12.a(r13, r14, r15);
    L160:
        mh3.a r18 = this.a.a;
        if (r18 != null) goto L163;
        return;
    L163:
        if (r18.e == null) goto L189;
        SkuYataAddCartChain.b(null, e);
        return;
    L189:
        return;
    L151:
        int r19 = b.a;
        r9 = 0;
        b.a(null, Integer.valueOf(this.a.c.e()), this.a.c.c(), this.a.c.d());
        goto L152
    L145:
        if (r3.length() == 0) goto L148;
        r5 = false;
        goto L149
    L166:
        if (r2.a == 0) goto L180;
        String r34 = "log_id";
        String r35 = "is_new_api";
        String r36 = "error_msg";
        String r37 = "error_code";
        r33 = "";
        String r20 = this.a.c.f();     // Catch: Exception -> L138
        if (r20 != null) goto L73;
    L76:
        boolean r21 = true;
    L77:
        if (r21 == true) goto L79;
        int r22 = b.a;     // Catch: Exception -> L138
        b.b(r2.i, this.a.c.f(), false);     // Catch: Exception -> L138
    L80:
        this.a.c(r2.b);     // Catch: Exception -> L138
        Map<String, Object> r23 = this.a.c.g();     // Catch: Exception -> L138
        if (r23 != null) goto L83;
    L101:
        this.a.f.b(r2, null);     // Catch: Exception -> L138
        if (r2.a == 0) goto L124;
        mh3.a r24 = this.a.a;     // Catch: Exception -> L138
        if (r24 == null) goto L124;
        com.bytedance.android.shopping.sku.common.monitor.error.a r25 = r24.c;     // Catch: Exception -> L138
        if (r25 == null) goto L124;
        SkuErrorMonitorType r26 = SkuErrorMonitorType.ADD_CART_API_ERROR;     // Catch: Exception -> L138
        String r0 = "code:" + r2.a + "   msg:" + r2.b;     // Catch: Exception -> L138
        JSONObject r27 = new JSONObject();     // Catch: Exception -> L138
        r7 = r37;
        r27.put(r7, String.valueOf(r2.a));     // Catch: Exception -> L122
        String r28 = r2.b;     // Catch: Exception -> L122
        if (r28 != null) goto L112;
        r28 = r33;
    L112:
        r8 = r36;
        r27.put(r8, r28);     // Catch: Exception -> L120
        r6 = r35;
        r27.put(r6, 1);     // Catch: Exception -> L118
        r10 = r34;
        r27.put(r10, r2.d);     // Catch: Exception -> L130
        Unit r29 = Unit.INSTANCE;     // Catch: Exception -> L130
        r25.a(r26, r0, r27);     // Catch: Exception -> L130
    L125:
        mh3.a r1 = this.a.a;     // Catch: Exception -> L130
        if (r1 != null) goto L128;
    L132:
        mh3.a r30 = this.a.a;     // Catch: Exception -> L130
        if (r30 == null) goto L186;
        SkuYataAptChain r31 = r30.f;     // Catch: Exception -> L130
        if (r31 == null) goto L187;
        r31.b(this.c, r2);     // Catch: Exception -> L130
        return;
    L187:
        return;
    L186:
        return;
    L128:
        if (r1.e == null) goto L132;
        SkuYataAddCartChain.b(r2, null);     // Catch: Exception -> L130
    L130:
        e = e;
    L118:
        e = e;
        r10 = r34;
    L120:
        e = e;
        r10 = r34;
        r6 = r35;
    L122:
        e = e;
        r10 = r34;
        r6 = r35;
        r8 = r36;
    L124:
        r10 = r34;
        r6 = r35;
        r8 = r36;
        r7 = r37;
        goto L125
    L83:
        if ((!r23.isEmpty()) != true) goto L101;
        Map<String, Object> r32 = this.a.c.g();     // Catch: Exception -> L138
        if (r32 == null) goto L87;
        Object r38 = r32.get("buy_to_add");     // Catch: Exception -> L138
    L89:
        if ((r38 instanceof Map) == true) goto L91;
        r38 = null;
    L91:
        Map r40 = (Map) r38;     // Catch: Exception -> L138
        if (r40 == null) goto L101;
        if ((!r40.isEmpty()) != true) goto L101;
        Object r41 = r40.get("fail_toast");     // Catch: Exception -> L138
        if ((r41 instanceof String) == true) goto L98;
        r41 = null;
    L98:
        String r42 = (String) r41;     // Catch: Exception -> L138
        if (TextUtils.isEmpty(r42) == true) goto L101;
        SkuCommonToast.c(r42);     // Catch: Exception -> L138
        goto L101
    L87:
        r38 = null;
        goto L89
    L79:
        int r43 = b.a;     // Catch: Exception -> L138
        b.a(r2.i, Integer.valueOf(this.a.c.e()), this.a.c.c(), this.a.c.d());     // Catch: Exception -> L138
        goto L80
    L73:
        if (r20.length() == 0) goto L76;
        r21 = false;
        goto L77
    L180:
        LinkedHashMap r110 = new LinkedHashMap();     // Catch: Exception -> L68
        Map<String, Object> r111 = this.a.c.g();     // Catch: Exception -> L68
        if (r111 == null) goto L9;
        r110.putAll(r111);     // Catch: Exception -> L140
    L9:
        r110.put("add_cart_opt_live", this.a.c.d.getAddCartOptLive());     // Catch: Exception -> L68
        Function0<Unit> r112 = this.a.g;     // Catch: Exception -> L68
        if (r112 == null) goto L12;
        Unit r113 = (Unit) r112.invoke();     // Catch: Exception -> L140
    L12:
        EventBus r114 = EventBus.getDefault();     // Catch: Exception -> L68
        int r115 = r2.e;     // Catch: Exception -> L68
        String r116 = this.a.c.a.j();     // Catch: Exception -> L68
        String r210 = this.a.c.d();     // Catch: Exception -> L68
        Integer r117 = Integer.valueOf(this.a.c.e());     // Catch: Exception -> L68
        String r44 = this.a.c.c();     // Catch: Exception -> L68
        if (r44 != null) goto L15;
        String r118 = "";
    L16:
        List<CartNumWithBusinessLine> r45 = r2.g;     // Catch: Exception -> L68
        String r119 = this.a.c.a();     // Catch: Exception -> L68
        String r211 = this.a.c.a.c();     // Catch: Exception -> L68
        this.a.c.d.isSchemaOpen();     // Catch: Exception -> L68
        View r46 = this.a.d;     // Catch: Exception -> L68
        if (r46 == null) goto L19;
        sh3.c.a(r46);     // Catch: Exception -> L140
    L19:
        c r47 = this.a.c;     // Catch: Exception -> L68
        r33 = "";
        float[] r48 = r47.g;     // Catch: Exception -> L66
        r34 = "log_id";
        r35 = "is_new_api";
        r36 = "error_msg";
        r37 = "error_code";
        r114.post(new hl.b(r115, r116, r117, r118, r45, r119, r211, null, r110, null, r210, Integer.valueOf(r47.c), r2.h, this.a.c.d.getRoomId(), false, r2.c, r2.f, r48, 66176));     // Catch: Exception -> L138
        EventBus.getDefault().post(new hl.d(r2.e));     // Catch: Exception -> L138
        SkuOuterAddToCartHelper r49 = this.a;     // Catch: Exception -> L138
        SkuOuterAddToCartHelper.a(r49, this.b, r49.c.c(), r2.c, Integer.valueOf(this.a.c.e()));     // Catch: Exception -> L138
        String r50 = this.a.c.f();     // Catch: Exception -> L138
        if (r50 != null) goto L30;
    L33:
        boolean r51 = true;
    L34:
        if (r51 == true) goto L36;
        int r52 = b.a;     // Catch: Exception -> L138
        b.b(r2.i, this.a.c.f(), true);     // Catch: Exception -> L138
    L38:
        if (this.a.c.c != 1) goto L41;
        SkuCommonToast.c("添加成功，在购物车等你");     // Catch: Exception -> L138
    L41:
        Map<String, Object> r53 = this.a.c.g();     // Catch: Exception -> L138
        if (r53 == null) goto L101;
        if ((!r53.isEmpty()) != true) goto L101;
        Map<String, Object> r54 = this.a.c.g();     // Catch: Exception -> L138
        if (r54 == null) goto L48;
        Object r55 = r54.get("buy_to_add");     // Catch: Exception -> L138
    L50:
        if ((r55 instanceof Map) == true) goto L52;
        r55 = null;
    L52:
        Map r56 = (Map) r55;     // Catch: Exception -> L138
        if (r56 == null) goto L101;
        if ((!r56.isEmpty()) != true) goto L101;
        Object r57 = r56.get("success_toast");     // Catch: Exception -> L138
        if ((r57 instanceof String) == true) goto L59;
        r57 = null;
    L59:
        String r58 = (String) r57;     // Catch: Exception -> L138
        if (TextUtils.isEmpty(r58) == true) goto L101;
        SkuCommonToast.c(r58);     // Catch: Exception -> L138
        goto L101
    L48:
        r55 = null;
        goto L50
    L36:
        int r59 = b.a;     // Catch: Exception -> L138
        b.a(r2.i, Integer.valueOf(this.a.c.e()), this.a.c.c(), this.a.c.d());     // Catch: Exception -> L138
        goto L38
    L30:
        if (r50.length() == 0) goto L33;
        r51 = false;
    L62:
        e = e;
    L63:
        r36 = "error_msg";
        r37 = "error_code";
    L139:
        r10 = r34;
        r6 = r35;
        r8 = r36;
        r7 = r37;
    L64:
        e = e;
    L65:
        r35 = "is_new_api";
    L66:
        e = e;
        r34 = "log_id";
        goto L65
    L15:
        r118 = r44;
    L68:
        e = e;
        r34 = "log_id";
        r35 = "is_new_api";
        r36 = "error_msg";
        r37 = "error_code";
        r33 = "";
    L138:
        e = e;
        goto L139
    }
}
