package qu1;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import com.bytedance.android.livesdk.dynamicstrategy.impl.express.parse.ExpressNodeType;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru1.c;
import tu1.d;
import tu1.e;
import tu1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, c> f534838a = null;

    static {
        f534838a = new HashMap();
    }

    @JvmStatic
    public static final Object a(String r210, Map<String, ? extends Object> r211) {
        Intrinsics.checkNotNullParameter(r210, "expressString");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        c r100 = f534838a.get(r210);
        if (r100 != null) goto L182;
        Intrinsics.checkNotNullParameter(r210, "expressString");
        Set<String> r101 = d.f547601a.keySet();
        int r102 = f.f547603a;
        Intrinsics.checkNotNullParameter(r210, "content");
        Intrinsics.checkNotNullParameter(r101, "keywords");
        ArrayList r103 = new ArrayList();
        int r110 = 0;
        int r111 = 0;
    L6:
        if (r110 >= r210.length()) goto L31;
        if (r210.charAt(r110) == ' ') goto L9;
        Iterator<T> r112 = r101.iterator();
    L14:
        if (r112.hasNext() == false) goto L23;
        Object r113 = r112.next();
        String r114 = (String) r113;
        if ((r114.length() + r110) <= r210.length()) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == false) goto L14;
    L24:
        String r115 = (String) r113;
        if (r115 != null) goto L26;
        r110 = r110 + 1;
        goto L6
    L26:
        if (r110 == r111) goto L28;
        r103.add(new e(r210.substring(r111, r110)));
    L28:
        r103.add(new e(r115));
        r111 = r115.length() + r110;
    L29:
        r110 = r111;
        goto L6
    L18:
        if (Intrinsics.areEqual(r210.substring(r110, r114.length() + r110), r114) == false) goto L20;
        r104 = true;
        goto L21
    L23:
        r113 = null;
        goto L24
    L9:
        if (r110 == r111) goto L11;
        r103.add(new e(r210.substring(r111, r110)));
    L11:
        r111 = r110 + 1;
        goto L29
    L31:
        if (r110 == r111) goto L33;
        r103.add(new e(r210.substring(r111, r110)));
    L33:
        Map<String, ExpressNodeType> r105 = d.f547601a;
        int r106 = tu1.a.f547593a;
        Intrinsics.checkNotNullParameter(r103, BitableAnalytic.LocationClickType.WORDS);
        Intrinsics.checkNotNullParameter(r105, "keywords");
        ArrayList r107 = new ArrayList();
        Iterator r108 = r103.iterator();
    L35:
        if (r108.hasNext() == false) goto L84;
        e r109 = (e) r108.next();
        char r116 = r109.f547602a.charAt(0);
        if ('0' <= r116) goto L40;
    L60:
        tu1.b r117 = null;
    L61:
        if (r117 != null) goto L62;
        String r118 = r109.f547602a;
        int r119 = r118.hashCode();
        if (r119 == 3569038) goto L72;
        if (r119 == 97196323) goto L69;
    L74:
        tu1.b r120 = null;
    L75:
        if (r120 != null) goto L76;
        ExpressNodeType r121 = r105.get(r109.f547602a);
        if (r121 == null) goto L80;
        tu1.b r122 = new tu1.b(r121, r109.f547602a);
    L81:
        if (r122 != null) goto L82;
        r107.add(new tu1.b(ExpressNodeType.PARAM, r109.f547602a));
        goto L35
    L82:
        r107.add(r122);
        goto L35
    L80:
        r122 = null;
        goto L81
    L76:
        r107.add(r120);
        goto L35
    L69:
        if (r118.equals("false") == false) goto L74;
        r120 = new tu1.b(ExpressNodeType.CONST_BOOLEAN, Boolean.FALSE);
        goto L75
    L72:
        if (r118.equals("true") == false) goto L74;
        r120 = new tu1.b(ExpressNodeType.CONST_BOOLEAN, Boolean.TRUE);
        goto L75
    L62:
        r107.add(r117);
        goto L35
    L40:
        if ('9' < r116) goto L60;
        String r123 = r109.f547602a;
        char r124 = r123.charAt(r123.length() - 1);
        if (r124 != 'l') goto L45;
        r117 = new tu1.b(ExpressNodeType.CONST_LONG, Long.valueOf(CastLongProtector.parseLong(r109.f547602a)));
        goto L61
    L45:
        if (r124 != 'd') goto L48;
        r117 = new tu1.b(ExpressNodeType.CONST_DOUBLE, Double.valueOf(CastDoubleProtector.parseDouble(r109.f547602a)));
        goto L61
    L48:
        if (r124 != 'f') goto L51;
        r117 = new tu1.b(ExpressNodeType.CONST_FLOAT, Float.valueOf(CastFloatProtector.parseFloat(r109.f547602a)));
        goto L61
    L51:
        if (StringsKt.indexOf$default(r109.f547602a, '.', 0, false, 6, null) <= 0) goto L53;
        r117 = new tu1.b(ExpressNodeType.CONST_FLOAT, Float.valueOf(CastFloatProtector.parseFloat(r109.f547602a)));
        goto L61
    L53:
        long r125 = CastLongProtector.parseLong(r109.f547602a);
        if (r125 >= Integer.MIN_VALUE) goto L56;
    L58:
        tu1.b r126 = new tu1.b(ExpressNodeType.CONST_LONG, Long.valueOf(r125));
    L59:
        r117 = r126;
        goto L61
    L56:
        if (r125 > Integer.MAX_VALUE) goto L58;
        r126 = new tu1.b(ExpressNodeType.CONST_INT, Integer.valueOf((int) r125));
        goto L59
    L84:
        int r127 = tu1.c.f547598a;
        Intrinsics.checkNotNullParameter(r107, "nodes");
        tu1.c.a r128 = new tu1.c.a();
        Iterator r129 = r107.iterator();
    L86:
        if (r129.hasNext() == false) goto L171;
        tu1.b r130 = (tu1.b) r129.next();
        if (r128.f547600a.isEmpty() == false) goto L90;
        tu1.b r131 = null;
    L92:
        if (r130.c() == true) goto L93;
        if (r130.b() == true) goto L114;
        ExpressNodeType r132 = r130.f547594a;
        if (r132 != ExpressNodeType.LEFT_BRACKET) goto L157;
        boolean r133 = true;
    L158:
        if (r133 == true) goto L159;
        if (r132 != ExpressNodeType.RIGHT_BRACKET) goto L163;
        boolean r134 = true;
    L164:
        if (r134 == false) goto L86;
        if (((LinkedList) r128.f547600a).removeFirstOccurrence(tu1.c.a.f547599b) == false) goto L169;
        r128.a();
        goto L86
    L169:
        throw new SimpleExpressException("express parse failed, remove barrage error", null, 2, null);
    L163:
        r134 = false;
        goto L164
    L159:
        ((LinkedList) r128.f547600a).push(tu1.c.a.f547599b);
        goto L86
    L157:
        r133 = false;
        goto L158
    L114:
        if (r131 == null) goto L118;
        if (r131.c() == false) goto L118;
        r128.b(r130);
    L118:
        if (r131 == null) goto L153;
        if (r131.b() == false) goto L153;
        ExpressNodeType r135 = r131.f547594a;
        ExpressNodeType r136 = ExpressNodeType.OPERATOR_COMPARE;
        if (r135 != r136) goto L125;
        char r137 = 2;
    L131:
        ExpressNodeType r138 = r130.f547594a;
        if (r138 != r136) goto L135;
        char r139 = 2;
    L141:
        if (r137 >= r139) goto L142;
        Intrinsics.checkNotNullParameter(r130, "node");
        tu1.b r140 = (tu1.b) ((LinkedList) r128.f547600a).peek();
        if (r140 == null) goto L151;
        tu1.b r141 = r140.f547597d;
        if (r141 == null) goto L149;
        r130.f547596c = r141;
        r140.f547597d = null;
        ((LinkedList) r128.f547600a).push(r130);
        goto L86
    L149:
        throw new SimpleExpressException("express parse failed, rob not full node", null, 2, null);
    L151:
        throw new SimpleExpressException("express parse failed, rob null node", null, 2, null);
    L142:
        r128.b(r130);
        goto L86
    L135:
        if (r138 != ExpressNodeType.OPERATOR_AND) goto L137;
    L140:
        r139 = 1;
        goto L141
    L137:
        if (r138 == ExpressNodeType.OPERATOR_OR) goto L140;
        r139 = 0;
        goto L141
    L125:
        if (r135 != ExpressNodeType.OPERATOR_AND) goto L127;
    L130:
        r137 = 1;
        goto L131
    L127:
        if (r135 == ExpressNodeType.OPERATOR_OR) goto L130;
        r137 = 0;
    L153:
        throw new SimpleExpressException("express parse failed, error node is " + r130 + ", last node is " + r131, null, 2, null);
    L93:
        if (r131 == null) goto L105;
        if (r131.b() == false) goto L105;
        Intrinsics.checkNotNullParameter(r130, "node");
        tu1.b r142 = (tu1.b) ((LinkedList) r128.f547600a).peek();
        if (r142 == null) goto L104;
        if (r142.f547597d != null) goto L102;
        r142.f547597d = r130;
        r128.a();
        goto L86
    L102:
        throw new SimpleExpressException("express parse failed, hang full node", null, 2, null);
    L104:
        throw new SimpleExpressException("express parse failed, hang null node", null, 2, null);
    L105:
        if (r131 != null) goto L107;
    L111:
        Intrinsics.checkNotNullParameter(r130, "node");
        ((LinkedList) r128.f547600a).push(r130);
        goto L86
    L107:
        if (r131.c() == false) goto L111;
        throw new SimpleExpressException("express parse failed, error node is " + r130 + ", last node is " + r131, null, 2, null);
    L90:
        r131 = (tu1.b) ((LinkedList) r128.f547600a).peek();
        goto L92
    L171:
        if (((LinkedList) r128.f547600a).size() != 1) goto L181;
        if (r128.f547600a.isEmpty() == false) goto L175;
        tu1.b r143 = null;
    L176:
        if (r143 == null) goto L179;
        int r144 = ru1.b.f539249a;
        Intrinsics.checkNotNullParameter(r143, RootDescription.ROOT_ELEMENT);
        ArrayList r145 = new ArrayList();
        ru1.b.a(r143, r145);
        c r146 = new c(r145);
        f534838a.put(r210, r146);
        r100 = r146;
        goto L182
    L179:
        throw new SimpleExpressException("express parse failed, stack root is null", null, 2, null);
    L175:
        r143 = (tu1.b) ((LinkedList) r128.f547600a).peek();
        goto L176
    L181:
        throw new SimpleExpressException("express parse failed, result stack size is " + ((LinkedList) r128.f547600a).size(), null, 2, null);
    L182:
        Intrinsics.checkNotNullParameter(r100, "operationSet");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        a r147 = new a();
        Intrinsics.checkNotNullParameter(r147, "runEnvironment");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r148 = r100.f539250a.iterator();
    L184:
        if (r148.hasNext() == false) goto L187;
        ((su1.e) r148.next()).a(r147, r211);
        goto L184
    L187:
        if (((LinkedList) r147.f534837a).size() != 1) goto L191;
        return ((LinkedList) r147.f534837a).peek();
    L191:
        throw new SimpleExpressException("express execute failed, stack size is " + ((LinkedList) r147.f534837a).size(), null, 2, null);
    }
}
