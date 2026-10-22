package xs8;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.collection.SieveCacheKt;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.f0;
import com.larus.bmhome.actionbar.model.g0;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.instruction.IInstructionSubCreator;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.MultiSelectorWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ouc.v;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class j extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b0 f565025l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.d f565026m;

    public static final class a {
    }

    static {
    }

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 8;
    }

    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f565025l != null) goto L5;
        return null;
    L5:
        List<up8.b> r101 = this.f551071k;
        if (r101 == null) goto L37;
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L37;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        up8.b r106 = (up8.b) r104;
        if (r106 == null) goto L22;
        b0 r107 = this.f565025l;
        if (r107 == null) goto L22;
        List<c0> r108 = r107.f294985a;
        if (r108 == null) goto L22;
        c0 r109 = (c0) ListProtector.get(r108, r103);
        if (r109 == null) goto L22;
        r109.f295033c = r106.g();
    L22:
        r103 = r105;
    L37:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L29
        v r111 = xt7.d.f565073b;     // Catch: Throwable -> L29
        juc.d r112 = kuc.a.d(b0.Companion.serializer());     // Catch: Throwable -> L29
        b0 r113 = this.f565025l;     // Catch: Throwable -> L29
        if (r113 == null) goto L26;
        b0 r114 = g0.a(r113);     // Catch: Throwable -> L29
    L27:
        Object r115 = Result.m9449constructorimpl(r111.a(r112, r114));     // Catch: Throwable -> L29
    L32:
        if (Result.m9455isFailureimpl(r115) == true) goto L36;
        r100 = r115;
    L36:
        return (String) r100;
    L26:
        r114 = null;
    L29:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    }

    public j() {
        this.f551071k = new ArrayList();
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new MultiSelectorWidget(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [T, up8.b] */
    @Override // up8.b
    public final a0 n(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        Object r102 = Result.m9449constructorimpl((b0) xt7.d.f565073b.c(b0.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 != null) goto L89;
        b0 r104 = (b0) r102;
        if (r104 == null) goto L21;
        List<c0> r105 = r104.f294985a;
    L22:
        List<c0> r106 = r105;
        if (r106 != null) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == true) goto L31;
        this.f565025l = r104;
        if (r104 == null) goto L87;
        List<c0> r108 = r104.f294985a;
        if (r108 == null) goto L87;
        Iterator<T> r109 = r108.iterator();
        int r111 = 0;
    L38:
        if (r109.hasNext() == false) goto L87;
        Object r112 = r109.next();
        int r113 = r111 + 1;
        if (r111 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        c0 r114 = (c0) r112;
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        Ref.ObjectRef r116 = new Ref.ObjectRef();
        Set<IInstructionSubCreator> r117 = rs8.m.f539133c;
        if (r117 == null) goto L61;
        Iterator<T> r118 = r117.iterator();
    L46:
        if (r118.hasNext() == false) goto L53;
        Object r119 = r118.next();
        if (((IInstructionSubCreator) r119).getMultiItemType() != r114.f295032b) goto L50;
        boolean r120 = true;
    L51:
        if (r120 == false) goto L46;
    L54:
        IInstructionSubCreator r121 = (IInstructionSubCreator) r119;
        if (r121 == null) goto L61;
        ?? r122 = r121.d();
        r122.f551064d = this.f551064d;
        r122.f551065e = this.f551065e;
        r122.f551067g = this.f551067g;
        ActivityResultLauncher<String> r123 = this.f551068h;
        ActivityResultLauncher<Intent> r124 = this.f551069i;
        r122.f551068h = r123;
        r122.f551069i = r124;
        r122.q(r114.f295031a);
        String r125 = r114.f295033c;
        if (r125 == null) goto L59;
        T r126 = r122.r(r125, this.f551063c, r122.f551062b, this.f565026m, this);
    L60:
        r116.element = r126;
        FLogger.f375446a.d("MultiSelectorController", "DROP_DOWN_BOX itemBuildResult=" + r116.element);
        r115.element = r122;
        goto L61
    L59:
        r126 = 0;
        goto L60
    L50:
        r120 = false;
        goto L51
    L53:
        r119 = null;
    L61:
        a0 r127 = (a0) r116.element;
        if (r127 == null) goto L64;
        boolean r128 = Intrinsics.areEqual(r127.f558831a, Boolean.TRUE);
    L65:
        if (r128 == false) goto L71;
        up8.b r129 = (up8.b) r115.element;
        if (r129 == null) goto L74;
        List<up8.b> r130 = this.f551071k;
        if (r130 == null) goto L74;
        r130.add(r129);
    L74:
        Pair[] r131 = new Pair[3];
        a0 r132 = (a0) r116.element;
        if (r132 == null) goto L77;
        boolean r133 = Intrinsics.areEqual(r132.f558831a, Boolean.TRUE);
    L78:
        if (r133 == false) goto L80;
        String r134 = "1";
    L81:
        r131[0] = TuplesKt.to("is_success", r134);
        a0 r135 = (a0) r116.element;
        if (r135 == null) goto L84;
        String r136 = r135.f558832b;
    L85:
        r131[1] = TuplesKt.to("fail_reason", r136);
        r131[2] = TuplesKt.to("instruction_multiselect_item_type", String.valueOf(r114.f295032b));
        com.larus.platform.service.o.f365780a.b("flow_instruction_decode_template", com.larus.utils.f.c(r131));
        r111 = r113;
        goto L38
    L84:
        r136 = null;
        goto L85
    L80:
        r134 = "0";
        goto L81
    L77:
        r133 = false;
        goto L78
    L71:
        List<up8.b> r137 = this.f551071k;
        if (r137 == null) goto L74;
        r137.add(null);
        goto L74
    L64:
        r128 = false;
    L87:
        return new a0(Boolean.TRUE, "");
    L31:
        return new a0(Boolean.FALSE, "multi option is empty");
    L25:
        if (r106.isEmpty() == true) goto L28;
        r107 = false;
        goto L29
    L21:
        r105 = null;
        goto L22
    L89:
        return new a0(Boolean.FALSE, r103.getMessage());
    L14:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "feature selector is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, "defaultStateTemplate");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl((b0) xt7.d.f565073b.c(b0.Companion.serializer(), r210));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        b0 r102 = (b0) r101;
        if (r102 != null) goto L13;
        return;
    L13:
        List<c0> r103 = r102.f294985a;
        if (r103 == null) goto L42;
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L42;
        c0 r105 = (c0) r104.next();
        b0 r106 = this.f565025l;
        if (r106 == null) goto L17;
        List<c0> r107 = r106.f294985a;
        if (r107 == null) goto L17;
        Iterator<c0> r108 = r107.iterator();
        int r109 = 0;
    L24:
        if (r108.hasNext() == false) goto L34;
        c0 r110 = r108.next();
        if (r110.f295032b == r105.f295032b) goto L28;
    L30:
        boolean r111 = false;
    L31:
        if (r111 == true) goto L35;
        r109 = r109 + 1;
    L35:
        String r112 = r105.f295033c;
        if (r112 == null) goto L17;
        List<up8.b> r113 = f();
        if (r113 == null) goto L17;
        up8.b r114 = (up8.b) CollectionsKt.getOrNull(r113, r109);
        if (r114 == null) goto L17;
        up8.b.l(r114, r112);
        goto L17
    L28:
        if (Intrinsics.areEqual(r110.f295031a, r105.f295031a) == false) goto L30;
        r111 = true;
        goto L31
    L34:
        r109 = -1;
    L42:
        List<c0> r115 = r102.f294985a;
        if (r115 != null) goto L45;
        r115 = CollectionsKt.emptyList();
    L45:
        List<c0> r116 = r115;
        b0 r117 = this.f565025l;
        if (r117 == null) goto L225;
        List<c0> r118 = r117.f294985a;
        if (r118 == null) goto L291;
        Iterator<T> r119 = r118.iterator();
        int r120 = 0;
    L51:
        if (r119.hasNext() == false) goto L292;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L56;
        CollectionsKt.throwIndexOverflow();
    L56:
        if (((c0) r121).f295032b != 9) goto L224;
        List<up8.b> r123 = f();
        if (r123 == null) goto L61;
        up8.b r124 = (up8.b) CollectionsKt.getOrNull(r123, r120);
    L63:
        if ((r124 instanceof d) == false) goto L65;
        d r125 = (d) r124;
    L66:
        if (r125 == null) goto L224;
        Intrinsics.checkNotNullParameter(r116, "defaultSelectorStates");
        com.larus.bmhome.actionbar.model.b r126 = r125.f565008m;
        if (r126 == null) goto L224;
        Integer r127 = r126.f294980b;
        if (r127 == null) goto L101;
        int r128 = r127.intValue();
        Iterator<T> r129 = r116.iterator();
    L74:
        if (r129.hasNext() == false) goto L86;
        Object r130 = r129.next();
        c0 r131 = (c0) r130;
        if (r131.f295032b != 3) goto L83;
        Integer r132 = r131.f295031a;
        if (r132 == null) goto L83;
        if (r132.intValue() != r128) goto L83;
        boolean r133 = true;
    L84:
        if (r133 == false) goto L74;
    L87:
        c0 r134 = (c0) r130;
        if (r134 == null) goto L101;
        com.larus.bmhome.actionbar.model.h r135 = d.u(r134);
        if (r135 == null) goto L101;
        Long r136 = d.E(r135);
        if (r136 == null) goto L101;
        String r137 = r136.toString();
        if (r137 == null) goto L101;
        Map<String, com.larus.bmhome.actionbar.model.a0> r138 = r126.f294979a;
        if (r138 != null) goto L99;
        r138 = MapsKt.emptyMap();
    L99:
        if (r138.containsKey(r137) == false) goto L101;
    L102:
        if (r137 == null) goto L104;
        r125.f565009n = r137;
    L104:
        com.larus.bmhome.actionbar.model.a0 r139 = r125.s();
        if (r139 == null) goto L107;
        List<f0> r140 = r139.f294961c;
    L108:
        if (r140 != null) goto L110;
        r140 = CollectionsKt.emptyList();
    L110:
        List<f0> r141 = r140;
        List<c0> r142 = r116;
        ArrayList r143 = new ArrayList();
        Iterator<T> r144 = r142.iterator();
    L112:
        if (r144.hasNext() == false) goto L119;
        Object r145 = r144.next();
        if (((c0) r145).f295032b != 3) goto L116;
        boolean r146 = true;
    L117:
        if (r146 == false) goto L112;
        r143.add(r145);
        goto L112
    L116:
        r146 = false;
        goto L117
    L119:
        ArrayList r147 = new ArrayList();
        Iterator r148 = r143.iterator();
    L121:
        if (r148.hasNext() == false) goto L131;
        c0 r149 = (c0) r148.next();
        Integer r150 = r149.f295031a;
        if (r150 == null) goto L128;
        int r151 = r150.intValue();
        com.larus.bmhome.actionbar.model.h r152 = d.u(r149);
        if (r152 == null) goto L128;
        Pair r153 = TuplesKt.to(Integer.valueOf(r151), r152);
    L129:
        if (r153 == null) goto L121;
        r147.add(r153);
    L128:
        r153 = null;
        goto L129
    L131:
        Map r154 = MapsKt.toMap(r147);
        ArrayList r155 = new ArrayList();
        Iterator r156 = r154.entrySet().iterator();
    L133:
        if (r156.hasNext() == false) goto L150;
        Map.Entry r157 = (Map.Entry) r156.next();
        int r158 = ((Number) r157.getKey()).intValue();
        Long r159 = d.E((com.larus.bmhome.actionbar.model.h) r157.getValue());
        if (r159 == null) goto L147;
        long r160 = r159.longValue();
        if (r160 >= SieveCacheKt.NodeMetaAndPreviousMask) goto L139;
    L141:
        boolean r161 = false;
    L142:
        if (r161 == true) goto L145;
        r159 = null;
    L145:
        if (r159 == null) goto L147;
        Pair r162 = TuplesKt.to(Integer.valueOf(r158), Integer.valueOf((int) r159.longValue()));
    L148:
        if (r162 == null) goto L133;
        r155.add(r162);
        goto L133
    L139:
        if (r160 > SieveCacheKt.NodeLinkMask) goto L141;
        r161 = true;
    L147:
        r162 = null;
        goto L148
    L150:
        Map r163 = MapsKt.toMap(r155);
        ArrayList r164 = new ArrayList();
        Iterator<T> r165 = r142.iterator();
    L152:
        if (r165.hasNext() == false) goto L159;
        Object r166 = r165.next();
        if (((c0) r166).f295032b != 10) goto L156;
        boolean r167 = true;
    L157:
        if (r167 == false) goto L152;
        r164.add(r166);
        goto L152
    L156:
        r167 = false;
        goto L157
    L159:
        ArrayList r168 = new ArrayList();
        Iterator r169 = r164.iterator();
    L161:
        if (r169.hasNext() == false) goto L184;
        c0 r170 = (c0) r169.next();
        Integer r171 = r170.f295031a;
        if (r171 == null) goto L181;
        int r172 = r171.intValue();
        Result.Companion r173 = Result.Companion;     // Catch: Throwable -> L170
        v r174 = xt7.d.f565073b;     // Catch: Throwable -> L170
        juc.d<com.larus.bmhome.actionbar.model.j> r175 = com.larus.bmhome.actionbar.model.j.Companion.serializer();     // Catch: Throwable -> L170
        String r176 = r170.f295033c;     // Catch: Throwable -> L170
        if (r176 != null) goto L168;
        r176 = "";
    L168:
        Object r177 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.j) r174.c(r175, r176));     // Catch: Throwable -> L170
    L173:
        if (Result.m9455isFailureimpl(r177) == false) goto L175;
        r177 = null;
    L175:
        com.larus.bmhome.actionbar.model.j r178 = (com.larus.bmhome.actionbar.model.j) r177;
        if (r178 == null) goto L181;
        Integer r179 = r178.f295213i;
        if (r179 == null) goto L181;
        Pair r180 = TuplesKt.to(Integer.valueOf(r172), Integer.valueOf(r179.intValue()));
    L182:
        if (r180 == null) goto L161;
        r168.add(r180);
    L170:
        th = move-exception;
        Result.Companion r181 = Result.Companion;
        r177 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L181:
        r180 = null;
        goto L182
    L184:
        Map r182 = MapsKt.plus(r163, MapsKt.toMap(r168));
        Iterator<T> r183 = r141.iterator();
        boolean r184 = false;
    L186:
        if (r183.hasNext() == false) goto L219;
        f0 r185 = (f0) r183.next();
        Integer r186 = r185.f();
        if (r186 == null) goto L186;
        int r187 = r186.intValue();
        com.larus.bmhome.actionbar.model.h r188 = r185.d();
        if (r188 == null) goto L205;
        com.larus.bmhome.actionbar.model.h r189 = (com.larus.bmhome.actionbar.model.h) r154.get(Integer.valueOf(r187));
        if (r189 == null) goto L194;
        Long r190 = d.E(r189);
        if (r190 == null) goto L205;
        if (d.w(r188, Long.valueOf(r190.longValue())) == true) goto L202;
        r190 = null;
    L202:
        if (r190 == null) goto L205;
        long r191 = r190.longValue();
        r125.f565010o.put(Integer.valueOf(r187), Long.valueOf(r191));
    L204:
        r184 = true;
        goto L205
    L194:
        if (Intrinsics.areEqual(r188.f295170h, Boolean.TRUE) == false) goto L205;
        r125.f565010o.put(Integer.valueOf(r187), null);
    L205:
        com.larus.bmhome.actionbar.model.j r192 = r185.e();
        if (r192 == null) goto L186;
        Integer r193 = (Integer) r182.get(Integer.valueOf(r187));
        if (r193 == null) goto L210;
        if (d.A(r192, Integer.valueOf(r193.intValue())) == true) goto L216;
        r193 = null;
    L216:
        if (r193 == null) goto L186;
        int r194 = r193.intValue();
        r125.f565011p.put(Integer.valueOf(r187), Integer.valueOf(r194));
    L218:
        r184 = true;
        goto L186
    L210:
        if (Intrinsics.areEqual(r192.f295214j, Boolean.TRUE) == false) goto L186;
        r125.f565011p.put(Integer.valueOf(r187), null);
        goto L218
    L219:
        if (r184 == true) goto L223;
        if (r137 == null) goto L224;
    L223:
        r125.B(false, true);
        r125.G();
        goto L224
    L107:
        r140 = null;
    L83:
        r133 = false;
        goto L84
    L86:
        r130 = null;
    L101:
        r137 = null;
        goto L102
    L65:
        r125 = null;
        goto L66
    L61:
        r124 = null;
    L224:
        r120 = r122;
        goto L51
    L292:
        return;
    L291:
        return;
    L225:
        return;
    L5:
        th = move-exception;
        Result.Companion r195 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // up8.b, up8.d
    public final a0 b(u r100, com.larus.bmhome.view.actionbar.edit.c r101, com.larus.bmhome.view.actionbar.edit.d r102, up8.b r103) {
        this.f565026m = r102;
        return super.b(r100, r101, r102, r103);
    }

    @Override // up8.b
    public final a0 r(String r100, com.larus.bmhome.view.actionbar.edit.c r101, u r102, com.larus.bmhome.view.actionbar.edit.d r103, up8.b r104) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        this.f565026m = r103;
        return super.r(r100, r101, r102, r103, r104);
    }
}
