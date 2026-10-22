package dq;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.expr.error.SlcExprException;
import com.bytedance.android.ecom.arch.slice.expr.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cq.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f469622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<Object> f469623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f469624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f469625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zp.a f469626e;

    public final int b() {
        cq.a r100 = this.f469624c.f469620a;
        int r101 = this.f469622a;
        this.f469622a = r101 + 1;
        byte r102 = r100.b(r101);
        cq.a r103 = this.f469624c.f469620a;
        int r104 = this.f469622a;
        this.f469622a = r104 + 1;
        int r105 = r102 << 8;
        return r105 | (r103.b(r104) & UByte.MAX_VALUE);
    }

    public final Object c() {
        return ListProtector.get(this.f469624c.f469621b, b());
    }

    public final Object d() {
    L3:
        int r100 = this.f469622a;
        cq.a r101 = this.f469624c.f469620a;
        int r102 = 1;
        if (r100 >= r101.f464758b) goto L296;
        this.f469622a = r100 + 1;
        byte r103 = r101.b(r100);
        if (r103 != 0) goto L7;
        a r104 = this.f469624c;
        List<Object> r105 = r104.f469621b;
        cq.a r106 = r104.f469620a;
        int r107 = this.f469622a;
        this.f469622a = r107 + 1;
        this.f469623b.f464759a.add(ListProtector.get(r105, r106.b(r107)));
        goto L3
    L7:
        if (r103 != 1) goto L9;
        this.f469623b.f464759a.add(c());
        goto L3
    L9:
        if (r103 != 2) goto L11;
        this.f469623b.f464759a.add(Boolean.TRUE);
        goto L3
    L11:
        if (r103 != 3) goto L12;
        this.f469623b.f464759a.add(Boolean.FALSE);
        goto L3
    L12:
        Object r108 = null;
        Object r109 = null;
        r109 = null;
        Object r110 = null;
        r110 = null;
        Object r111 = null;
        String r112 = null;
        Map r113 = null;
        r108 = null;
        r108 = null;
        r108 = null;
        r108 = null;
        if (r103 != 4) goto L15;
        this.f469623b.f464759a.add(null);
        goto L3
    L15:
        if (r103 != 5) goto L17;
        this.f469623b.f464759a.add(0L);
        goto L3
    L17:
        if (r103 != 91) goto L19;
        cq.a r114 = this.f469624c.f469620a;
        int r115 = this.f469622a;
        this.f469622a = r115 + 1;
        byte r116 = r114.b(r115);
        c<Object> r117 = this.f469623b;
        int r118 = r117.f464759a.size();
        List<Object> r119 = r117.f464759a.subList(r118 - r116, r118);
        ArrayList r120 = new ArrayList(r119);
        r119.clear();
        this.f469623b.f464759a.add(r120);
        goto L3
    L19:
        if (r103 != 92) goto L21;
        ArrayList<Object> r121 = this.f469623b.f464759a;
        Object r122 = ListProtector.remove(r121, r121.size() - 1);
        ArrayList<Object> r123 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(aq.b.l(ListProtector.remove(r123, r123.size() - 1), r122));
        goto L3
    L21:
        switch(r103) {
            case 11: goto L37;
            case 12: goto L32;
            case 13: goto L31;
            case 14: goto L30;
            default: goto L22;
        };
    L30:
        this.f469623b.f464759a.add(this.f469625d.get(MapController.ITEM_LAYER_TAG));
        goto L3
    L31:
        this.f469623b.f464759a.add(this.f469625d.get("data"));
        goto L3
    L32:
        Map<String, Object> r124 = this.f469625d;
        Object r125 = c();
        if (r125 == null) goto L36;
        this.f469623b.f464759a.add(r124.get((String) r125));
        goto L3
    L36:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L37:
        Map<String, Object> r126 = this.f469625d;
        a r127 = this.f469624c;
        List<Object> r128 = r127.f469621b;
        cq.a r129 = r127.f469620a;
        int r130 = this.f469622a;
        this.f469622a = r130 + 1;
        Object r131 = ListProtector.get(r128, r129.b(r130));
        if (r131 == null) goto L41;
        this.f469623b.f464759a.add(r126.get((String) r131));
        goto L3
    L41:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L22:
        int r132 = 0;
        switch(r103) {
            case 25: goto L258;
            case 26: goto L257;
            case 27: goto L256;
            case 28: goto L255;
            case 29: goto L254;
            case 30: goto L250;
            case 31: goto L221;
            case 32: goto L212;
            case 33: goto L199;
            case 34: goto L189;
            case 35: goto L125;
            case 36: goto L118;
            case 37: goto L111;
            case 38: goto L104;
            case 39: goto L97;
            case 40: goto L90;
            case 41: goto L77;
            case 42: goto L60;
            case 43: goto L42;
            default: goto L24;
        };
    L42:
        cq.a r133 = this.f469624c.f469620a;
        int r134 = this.f469622a;
        this.f469622a = r134 + 1;
        byte r135 = r133.b(r134);
        c<Object> r136 = this.f469623b;
        int r137 = r136.f464759a.size();
        List<Object> r138 = r136.f464759a.subList(r137 - r135, r137);
        int r139 = aq.a.f15876a;
        if (r138.isEmpty() == true) goto L59;
        ArrayList r140 = new ArrayList();
        int r141 = r138.size();
        boolean r142 = false;
    L46:
        if (r132 >= r141) goto L57;
        Object r143 = ListProtector.get(r138, r132);
        if ((r143 instanceof List) == false) goto L51;
        r140.addAll((Collection) r143);
    L55:
        r142 = true;
    L56:
        r132 = r132 + 1;
        goto L46
    L51:
        if ((r143 instanceof Object[]) == false) goto L53;
        r140.addAll(ArraysKt.asList((Object[]) r143));
        goto L55
    L53:
        if (r143 == null) goto L56;
        r140.add(r143);
        goto L55
    L57:
        if (r142 == false) goto L59;
        r109 = r140;
    L59:
        r138.clear();
        this.f469623b.f464759a.add((E) r109);
        goto L3
    L60:
        cq.a r144 = this.f469624c.f469620a;
        int r145 = this.f469622a;
        this.f469622a = r145 + 1;
        byte r146 = r144.b(r145);
        c<Object> r147 = this.f469623b;
        int r148 = r147.f464759a.size();
        List<Object> r149 = r147.f464759a.subList(r148 - r146, r148);
        int r150 = aq.a.f15876a;
        if (r149.isEmpty() == true) goto L76;
        Object r151 = ListProtector.get(r149, 0);
        if ((r151 instanceof List) == false) goto L67;
        ArrayList r152 = new ArrayList((Collection) r151);
    L70:
        if (r152 == null) goto L76;
        int r153 = r149.size();
    L73:
        if (r102 >= r153) goto L75;
        r152.add(ListProtector.get(r149, r102));
        r102 = r102 + 1;
        goto L73
    L75:
        r110 = r152;
        goto L76
    L67:
        if ((r151 instanceof Object[]) == false) goto L69;
        r152 = new ArrayList(ArraysKt.asList((Object[]) r151));
        goto L70
    L69:
        r152 = null;
    L76:
        r149.clear();
        this.f469623b.f464759a.add((E) r110);
        goto L3
    L77:
        cq.a r154 = this.f469624c.f469620a;
        int r155 = this.f469622a;
        this.f469622a = r155 + 1;
        byte r156 = r154.b(r155);
        c<Object> r157 = this.f469623b;
        int r158 = r157.f464759a.size();
        List<Object> r159 = r157.f464759a.subList(r158 - r156, r158);
        int r160 = aq.a.f15876a;
        if (r159.isEmpty() == true) goto L89;
        r111 = ListProtector.get(r159, 0);
        if ((r111 instanceof String) == false) goto L89;
        String r161 = ((String) r111).trim();
        if (r161.length() != 9) goto L89;
        if (r161.charAt(0) != '#') goto L89;
        StringBuilder r162 = new StringBuilder();
        r162.append(String.valueOf('#') + r161.substring(7, 9));
        r162.append(r161.substring(1, 7));
        r111 = r162.toString();
    L89:
        r159.clear();
        this.f469623b.f464759a.add((E) r111);
        goto L3
    L90:
        cq.a r163 = this.f469624c.f469620a;
        int r164 = this.f469622a;
        this.f469622a = r164 + 1;
        byte r165 = r163.b(r164);
        c<Object> r166 = this.f469623b;
        int r167 = r166.f464759a.size();
        List<Object> r168 = r166.f464759a.subList(r167 - r165, r167);
        int r169 = aq.a.f15876a;
        if (r168.isEmpty() == false) goto L305;
        Double r170 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
    L96:
        r168.clear();
        this.f469623b.f464759a.add(r170);
        goto L3
    L305:
        r170 = Double.valueOf(Math.abs(aq.b.u(ListProtector.get(r168, 0))));     // Catch: Throwable -> L95
    L95:
        r170 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
        goto L96
    L97:
        cq.a r171 = this.f469624c.f469620a;
        int r172 = this.f469622a;
        this.f469622a = r172 + 1;
        byte r173 = r171.b(r172);
        c<Object> r174 = this.f469623b;
        int r175 = r174.f464759a.size();
        List<Object> r176 = r174.f464759a.subList(r175 - r173, r175);
        int r177 = aq.a.f15876a;
        if (r176.isEmpty() == false) goto L309;
        Object r178 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
    L103:
        r176.clear();
        this.f469623b.f464759a.add(r178);
        goto L3
    L309:
        r178 = Long.valueOf((long) aq.b.u(ListProtector.get(r176, 0)));     // Catch: Throwable -> L102
    L102:
        r178 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
        goto L103
    L104:
        cq.a r179 = this.f469624c.f469620a;
        int r180 = this.f469622a;
        this.f469622a = r180 + 1;
        byte r181 = r179.b(r180);
        c<Object> r182 = this.f469623b;
        int r183 = r182.f464759a.size();
        List<Object> r184 = r182.f464759a.subList(r183 - r181, r183);
        int r185 = aq.a.f15876a;
        if (r184.isEmpty() == false) goto L303;
        Object r186 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
    L110:
        r184.clear();
        this.f469623b.f464759a.add(r186);
        goto L3
    L303:
        r186 = Long.valueOf(Math.round(aq.b.u(ListProtector.get(r184, 0))));     // Catch: Throwable -> L109
    L109:
        r186 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
        goto L110
    L111:
        cq.a r187 = this.f469624c.f469620a;
        int r188 = this.f469622a;
        this.f469622a = r188 + 1;
        byte r189 = r187.b(r188);
        c<Object> r190 = this.f469623b;
        int r191 = r190.f464759a.size();
        List<Object> r192 = r190.f464759a.subList(r191 - r189, r191);
        int r193 = aq.a.f15876a;
        if (r192.isEmpty() == false) goto L307;
        Double r194 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
    L117:
        r192.clear();
        this.f469623b.f464759a.add(r194);
        goto L3
    L307:
        r194 = Double.valueOf(Math.floor(aq.b.u(ListProtector.get(r192, 0))));     // Catch: Throwable -> L116
    L116:
        r194 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
        goto L117
    L118:
        cq.a r195 = this.f469624c.f469620a;
        int r196 = this.f469622a;
        this.f469622a = r196 + 1;
        byte r197 = r195.b(r196);
        c<Object> r198 = this.f469623b;
        int r199 = r198.f464759a.size();
        List<Object> r200 = r198.f464759a.subList(r199 - r197, r199);
        int r201 = aq.a.f15876a;
        if (r200.isEmpty() == false) goto L301;
        Double r202 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
    L124:
        r200.clear();
        this.f469623b.f464759a.add(r202);
        goto L3
    L301:
        r202 = Double.valueOf(Math.ceil(aq.b.u(ListProtector.get(r200, 0))));     // Catch: Throwable -> L123
    L123:
        r202 = Double.valueOf(DoubleCompanionObject.INSTANCE.getNaN());
        goto L124
    L125:
        cq.a r203 = this.f469624c.f469620a;
        int r204 = this.f469622a;
        this.f469622a = r204 + 1;
        byte r205 = r203.b(r204);
        c<Object> r206 = this.f469623b;
        int r207 = r206.f464759a.size();
        List<Object> r208 = r206.f464759a.subList(r207 - r205, r207);
        int r209 = aq.a.f15876a;
        if (r208.size() != 2) goto L188;
        String r210 = cq.b.a(ListProtector.get(r208, 0));
        if (r210 == null) goto L136;
        StringBuilder r211 = new StringBuilder();
        int r212 = r210.length();
        int r213 = 0;
    L130:
        if (r213 >= r212) goto L135;
        char r214 = r210.charAt(r213);
        if ((!CharsKt.isWhitespace(r214)) == false) goto L134;
        r211.append(r214);
    L134:
        r213 = r213 + 1;
        goto L130
    L135:
        String r215 = r211.toString();
    L137:
        String r216 = cq.b.a(ListProtector.get(r208, 1));
        if (r216 == null) goto L146;
        StringBuilder r217 = new StringBuilder();
        int r218 = r216.length();
        int r219 = 0;
    L140:
        if (r219 >= r218) goto L145;
        char r220 = r216.charAt(r219);
        if ((!CharsKt.isWhitespace(r220)) == false) goto L144;
        r217.append(r220);
    L144:
        r219 = r219 + 1;
        goto L140
    L145:
        r112 = r217.toString();
    L146:
        if (r215 != null) goto L148;
    L151:
        boolean r221 = true;
    L152:
        if (r221 == true) goto L186;
        if (r112 != null) goto L155;
    L158:
        if (r102 != 0) goto L186;
        List r1100 = StringsKt.split$default(r215, new String[]{"."}, false, 0, 6, null);
        List r222 = StringsKt.split$default(r112, new String[]{"."}, false, 0, 6, null);
        int r223 = Math.max(r1100.size(), r222.size());
        int r224 = 0;
    L160:
        if (r224 >= r223) goto L183;
        Object r225 = "0";
        if (r224 >= 0) goto L164;
    L166:
        Object r1101 = "0";
    L167:
        String r1102 = (String) r1101;
        Float r1103 = StringsKt.toFloatOrNull(r1102);
        if (r1103 == null) goto L170;
        float r1104 = r1103.floatValue();
    L171:
        if (r224 >= 0) goto L173;
    L175:
        String r226 = (String) r225;
        Float r1105 = StringsKt.toFloatOrNull(r226);
        if (r1105 == null) goto L178;
        float r227 = r1105.floatValue();
    L180:
        if (r1104 != r227) goto L181;
        r224 = r224 + 1;
        goto L160
    L181:
        int r228 = Integer.valueOf(Float.compare(r1104, r227));
    L184:
        r208.clear();
        this.f469623b.f464759a.add(r228);
        goto L3
    L178:
        r227 = aq.a.a(r226, r215, r112);
        goto L180
    L173:
        if (r224 > CollectionsKt.getLastIndex(r222)) goto L175;
        r225 = ListProtector.get(r222, r224);
        goto L175
    L170:
        r1104 = aq.a.a(r1102, r215, r112);
        goto L171
    L164:
        if (r224 > CollectionsKt.getLastIndex(r1100)) goto L166;
        r1101 = ListProtector.get(r1100, r224);
        goto L167
    L183:
        r228 = 0;
        goto L184
    L155:
        if (StringsKt.isBlank(r112) == true) goto L158;
        r102 = 0;
    L186:
        throw new IllegalArgumentException("params is null Or blank,params:" + r215 + ',' + r112);
    L148:
        if (StringsKt.isBlank(r215) == true) goto L151;
        r221 = false;
        goto L152
    L136:
        r215 = null;
        goto L137
    L188:
        throw new IllegalArgumentException("versionCompare needs two params but got " + r208.size());
    L189:
        cq.a r229 = this.f469624c.f469620a;
        int r230 = this.f469622a;
        this.f469622a = r230 + 1;
        byte r231 = r229.b(r230);
        c<Object> r232 = this.f469623b;
        int r233 = r232.f464759a.size();
        List<Object> r234 = r232.f464759a.subList(r233 - r231, r233);
        int r235 = aq.a.f15876a;
        HashMap r236 = new HashMap();
        Iterator<T> r237 = r234.iterator();
    L191:
        if (r237.hasNext() == false) goto L198;
        Object r238 = r237.next();
        if ((r238 instanceof Map) == true) goto L195;
        r238 = null;
    L195:
        Map r239 = (Map) r238;
        if (r239 == null) goto L191;
        r236.putAll(r239);
        goto L191
    L198:
        r234.clear();
        this.f469623b.f464759a.add(r236);
        goto L3
    L199:
        cq.a r240 = this.f469624c.f469620a;
        int r241 = this.f469622a;
        this.f469622a = r241 + 1;
        byte r242 = r240.b(r241);
        c<Object> r243 = this.f469623b;
        int r244 = r243.f464759a.size();
        List<Object> r245 = r243.f464759a.subList(r244 - r242, r244);
        int r246 = aq.a.f15876a;
        int r247 = r245.size() / 2;
        if (r247 >= 1) goto L202;
        r113 = MapsKt.emptyMap();
    L211:
        r245.clear();
        this.f469623b.f464759a.add((E) r113);
        goto L3
    L202:
        HashMap r248 = new HashMap();
    L203:
        if (r132 >= r247) goto L210;
        int r249 = r132 * 2;
        Object r250 = ListProtector.get(r245, r249);
        if ((r250 instanceof String) == true) goto L207;
        r250 = null;
    L207:
        String r251 = (String) r250;
        if (r251 == null) goto L211;
        r248.put(r251, ListProtector.get(r245, r249 + 1));
        r132 = r132 + 1;
        goto L203
    L210:
        r113 = r248;
        goto L211
    L212:
        cq.a r252 = this.f469624c.f469620a;
        int r253 = this.f469622a;
        this.f469622a = r253 + 1;
        byte r254 = r252.b(r253);
        c<Object> r255 = this.f469623b;
        int r256 = r255.f464759a.size();
        List<Object> r257 = r255.f464759a.subList(r256 - r254, r256);
        int r258 = aq.a.f15876a;
        ArrayList r259 = new ArrayList();
        Iterator<T> r260 = r257.iterator();
    L214:
        if (r260.hasNext() == false) goto L220;
        String r261 = cq.b.a(r260.next());
        if (r261 != null) goto L219;
        r261 = "";
    L219:
        r259.add(r261);
        goto L214
    L220:
        String r262 = CollectionsKt.joinToString$default(r259, "", null, null, 0, null, null, 62, null);
        r257.clear();
        this.f469623b.f464759a.add(r262);
        goto L3
    L221:
        cq.a r263 = this.f469624c.f469620a;
        int r264 = this.f469622a;
        this.f469622a = r264 + 1;
        byte r265 = r263.b(r264);
        c<Object> r266 = this.f469623b;
        int r267 = r266.f464759a.size();
        List<Object> r268 = r266.f464759a.subList(r267 - r265, r267);
        int r269 = aq.a.f15876a;
        if (r268.isEmpty() == true) goto L249;
        Object r270 = CollectionsKt.getOrNull(r268, 0);
        if (r270 == null) goto L249;
        int r271 = r268.size();
    L227:
        if (r102 >= r271) goto L248;
        Object r272 = ListProtector.get(r268, r102);
        if ((r272 instanceof String) == false) goto L237;
        if ((r270 instanceof Map) == true) goto L233;
        r270 = null;
    L233:
        Map r273 = (Map) r270;
        if (r273 == null) goto L249;
        r270 = r273.get(r272);
    L247:
        r102 = r102 + 1;
        goto L227
    L237:
        if ((r272 instanceof Number) == false) goto L249;
        int r274 = ((Number) r272).intValue();
        if ((r270 instanceof List) == false) goto L242;
        r270 = CollectionsKt.getOrNull((List) r270, r274);
        goto L247
    L242:
        if ((r270 instanceof Object[]) == false) goto L245;
        r270 = ArraysKt.getOrNull((Object[]) r270, r274);
        goto L247
    L245:
        if ((r270 instanceof String) == false) goto L249;
        r270 = cq.b.a(StringsKt.getOrNull((CharSequence) r270, r274));
        goto L247
    L248:
        r108 = r270;
    L249:
        r268.clear();
        this.f469623b.f464759a.add((E) r108);
        goto L3
    L250:
        cq.a r275 = this.f469624c.f469620a;
        int r276 = this.f469622a;
        this.f469622a = r276 + 1;
        byte r277 = r275.b(r276);
        c<Object> r278 = this.f469623b;
        int r279 = r278.f464759a.size();
        List<Object> r280 = r278.f464759a.subList(r279 - r277, r279);
        int r281 = aq.a.f15876a;
        Object r282 = CollectionsKt.getOrNull(r280, 0);
        if (r282 == null) goto L253;
        r132 = aq.a.b(r282);
    L253:
        r280.clear();
        this.f469623b.f464759a.add(Integer.valueOf(r132));
        goto L3
    L254:
        ArrayList<Object> r283 = this.f469623b.f464759a;
        Boolean r284 = Boolean.valueOf(aq.a.c(ListProtector.get(r283, r283.size() - 1)));
        ArrayList<Object> r285 = this.f469623b.f464759a;
        ListProtector.set(r285, r285.size() - 1, r284);
        goto L3
    L255:
        call(true);
        goto L3
    L256:
        call(false);
        goto L3
    L257:
        a(true);
        goto L3
    L258:
        a(false);
        goto L3
    L24:
        switch(r103) {
            case 61: goto L265;
            case 62: goto L264;
            case 63: goto L263;
            case 64: goto L262;
            case 65: goto L261;
            case 66: goto L260;
            case 67: goto L259;
            default: goto L25;
        };
    L259:
        ArrayList<Object> r286 = this.f469623b.f464759a;
        Object r287 = ListProtector.remove(r286, r286.size() - 1);
        ArrayList<Object> r288 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(aq.b.s(ListProtector.remove(r288, r288.size() - 1), r287));
        goto L3
    L260:
        ArrayList<Object> r289 = this.f469623b.f464759a;
        Object r290 = ListProtector.remove(r289, r289.size() - 1);
        ArrayList<Object> r291 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(aq.b.p(ListProtector.remove(r291, r291.size() - 1), r290));
        goto L3
    L261:
        ArrayList<Object> r292 = this.f469623b.f464759a;
        Object r293 = ListProtector.remove(r292, r292.size() - 1);
        ArrayList<Object> r294 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(aq.b.f(ListProtector.remove(r294, r294.size() - 1), r293));
        goto L3
    L262:
        ArrayList<Object> r295 = this.f469623b.f464759a;
        Object r296 = ListProtector.remove(r295, r295.size() - 1);
        ArrayList<Object> r297 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(aq.b.q(ListProtector.remove(r297, r297.size() - 1), r296));
        goto L3
    L263:
        ArrayList<Object> r298 = this.f469623b.f464759a;
        Object r299 = ListProtector.remove(r298, r298.size() - 1);
        ArrayList<Object> r300 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Double.valueOf(aq.b.t(ListProtector.remove(r300, r300.size() - 1), r299)));
        goto L3
    L264:
        ArrayList<Object> r301 = this.f469623b.f464759a;
        Object r302 = ListProtector.remove(r301, r301.size() - 1);
        ArrayList<Object> r303 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(aq.b.a(ListProtector.remove(r303, r303.size() - 1), r302));
        goto L3
    L265:
        ArrayList<Object> r304 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(aq.b.r(ListProtector.remove(r304, r304.size() - 1)));
        goto L3
    L25:
        switch(r103) {
            case 71: goto L270;
            case 72: goto L269;
            case 73: goto L268;
            case 74: goto L267;
            case 75: goto L266;
            default: goto L26;
        };
    L266:
        ArrayList<Object> r305 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Boolean.valueOf(!cq.b.b(ListProtector.remove(r305, r305.size() - 1))));
        goto L3
    L267:
        ArrayList<Object> r306 = this.f469623b.f464759a;
        Object r307 = ListProtector.remove(r306, r306.size() - 1);
        ArrayList<Object> r308 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Long.valueOf(aq.b.e(ListProtector.remove(r308, r308.size() - 1), r307)));
        goto L3
    L268:
        ArrayList<Object> r309 = this.f469623b.f464759a;
        Object r310 = ListProtector.remove(r309, r309.size() - 1);
        ArrayList<Object> r311 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Long.valueOf(aq.b.d(ListProtector.remove(r311, r311.size() - 1), r310)));
        goto L3
    L269:
        ArrayList<Object> r312 = this.f469623b.f464759a;
        Object r313 = ListProtector.remove(r312, r312.size() - 1);
        ArrayList<Object> r314 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Long.valueOf(aq.b.b(ListProtector.remove(r314, r314.size() - 1), r313)));
        goto L3
    L270:
        ArrayList<Object> r315 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Long.valueOf(aq.b.c(ListProtector.remove(r315, r315.size() - 1))));
        goto L3
    L26:
        switch(r103) {
            case 81: goto L276;
            case 82: goto L275;
            case 83: goto L274;
            case 84: goto L273;
            case 85: goto L272;
            case 86: goto L271;
            default: goto L27;
        };
    L271:
        ArrayList<Object> r316 = this.f469623b.f464759a;
        Object r317 = ListProtector.remove(r316, r316.size() - 1);
        ArrayList<Object> r318 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Boolean.valueOf(aq.b.o(ListProtector.remove(r318, r318.size() - 1), r317)));
        goto L3
    L272:
        ArrayList<Object> r319 = this.f469623b.f464759a;
        Object r320 = ListProtector.remove(r319, r319.size() - 1);
        ArrayList<Object> r321 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Boolean.valueOf(aq.b.n(ListProtector.remove(r321, r321.size() - 1), r320)));
        goto L3
    L273:
        ArrayList<Object> r322 = this.f469623b.f464759a;
        Object r323 = ListProtector.remove(r322, r322.size() - 1);
        ArrayList<Object> r324 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Boolean.valueOf(aq.b.k(ListProtector.remove(r324, r324.size() - 1), r323)));
        goto L3
    L274:
        ArrayList<Object> r325 = this.f469623b.f464759a;
        Object r326 = ListProtector.remove(r325, r325.size() - 1);
        ArrayList<Object> r327 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Boolean.valueOf(aq.b.j(ListProtector.remove(r327, r327.size() - 1), r326)));
        goto L3
    L275:
        ArrayList<Object> r328 = this.f469623b.f464759a;
        Object r329 = ListProtector.remove(r328, r328.size() - 1);
        ArrayList<Object> r330 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Boolean.valueOf(!aq.b.i(ListProtector.remove(r330, r330.size() - 1), r329)));
        goto L3
    L276:
        ArrayList<Object> r331 = this.f469623b.f464759a;
        Object r332 = ListProtector.remove(r331, r331.size() - 1);
        ArrayList<Object> r333 = this.f469623b.f464759a;
        this.f469623b.f464759a.add(Boolean.valueOf(aq.b.i(ListProtector.remove(r333, r333.size() - 1), r332)));
        goto L3
    L27:
        switch(r103) {
            case 96: goto L283;
            case 97: goto L279;
            case 98: goto L278;
            case 99: goto L277;
            default: goto L29;
        };
    L29:
        throw new SlcExprException("eval_invalid_opcode", "invalid opcode: " + r103);
    L278:
        this.f469622a += b();
        goto L3
    L279:
        ArrayList<Object> r334 = this.f469623b.f464759a;
        if (cq.b.b(ListProtector.get(r334, r334.size() - 1)) == false) goto L281;
        this.f469622a += 2;
        goto L3
    L281:
        this.f469622a += b();
        goto L3
    L283:
        ArrayList<Object> r335 = this.f469623b.f464759a;
        if (cq.b.b(ListProtector.get(r335, r335.size() - 1)) == true) goto L285;
        this.f469622a += 2;
        goto L3
    L285:
        this.f469622a += b();
        goto L3
    L277:
        ArrayList<Object> r336 = this.f469623b.f464759a;
        ListProtector.remove(r336, r336.size() - 1);
        goto L3
    L296:
        if (this.f469623b.f464759a.size() != 1) goto L300;
        ArrayList<Object> r337 = this.f469623b.f464759a;
        return ListProtector.remove(r337, r337.size() - 1);
    L300:
        throw new SlcExprException("eval_invalid_stack", "execute end, but stack size is not 1: " + this.f469623b.f464759a.size());
    }

    private final void call(boolean r100) {
        if (r100 == false) goto L4;
        Object r101 = c();
    L5:
        if (r101 == null) goto L9;
        cq.a r102 = this.f469624c.f469620a;
        int r103 = this.f469622a;
        this.f469622a = r103 + 1;
        byte r104 = r102.b(r103);
        c<Object> r105 = this.f469623b;
        int r106 = r105.f464759a.size();
        List<Object> r107 = r105.f464759a.subList(r106 - r104, r106);
        Object r108 = ((zp.b) r101).a(this.f469626e, r107);
        r107.clear();
        this.f469623b.f464759a.add(r108);
        return;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.ecom.arch.expr.ISlcExprFunc");
    L4:
        a r109 = this.f469624c;
        List<Object> r110 = r109.f469621b;
        cq.a r111 = r109.f469620a;
        int r112 = this.f469622a;
        this.f469622a = r112 + 1;
        r101 = ListProtector.get(r110, r111.b(r112));
        goto L5
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L5;
        int r101 = 2;
    L6:
        ArrayList<Object> r102 = this.f469623b.f464759a;
        Object r103 = ListProtector.get(r102, r102.size() - 1);
        if (r103 != null) goto L9;
        this.f469622a += r101;
        return;
    L9:
        if ((r103 instanceof Map) == true) goto L11;
        r103 = null;
    L11:
        Map r104 = (Map) r103;
        if (r104 == null) goto L17;
        if (r100 == false) goto L15;
        Object r105 = c();
    L16:
        Object r106 = r104.get(r105);
        ArrayList<Object> r107 = this.f469623b.f464759a;
        ListProtector.set(r107, r107.size() - 1, r106);
        return;
    L15:
        a r108 = this.f469624c;
        List<Object> r109 = r108.f469621b;
        cq.a r110 = r108.f469620a;
        int r111 = this.f469622a;
        this.f469622a = r111 + 1;
        r105 = ListProtector.get(r109, r110.b(r111));
        goto L16
    L17:
        this.f469622a += r101;
        ArrayList<Object> r112 = this.f469623b.f464759a;
        ListProtector.set(r112, r112.size() - 1, null);
        return;
    L5:
        r101 = 1;
        goto L6
    }

    public b(a r100, Map r101, d r102) {
        this.f469624c = r100;
        this.f469625d = r101;
        this.f469626e = r102;
        this.f469623b = new c();
    }
}
