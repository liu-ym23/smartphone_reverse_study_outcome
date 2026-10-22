package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.bmhome.chat.bubble.floating.ReachSpacerState;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import com.larus.bmhome.chat.list.cell.spacer.SpacerAnimationState;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements td8.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f554211b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f554212a;

    /* JADX INFO: renamed from: vd8.a$a, reason: collision with other inner class name */
    public static final class C7985a {
    }

    static {
        f554211b = new LinkedHashSet();
    }

    public a(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f554212a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        wc9.e r104 = this.f554212a.g();
        if (r104 == null) goto L40;
        String r105 = r104.f559198a;
        if (r105 == null) goto L42;
        List<? extends xc8.b> r106 = r103;
        if ((r106 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        if ((((xc8.b) r107.next()) instanceof com.larus.bmhome.chat.list.cell.spacer.j) == false) goto L14;
        boolean r108 = true;
    L19:
        if (r108 == true) goto L35;
        int r109 = o.f554234a;
        Intrinsics.checkNotNullParameter(r105, "conversationId");
        pc8.l r110 = pc8.k.f528602a;
        pc8.l r111 = pc8.k.f528602a;
        if (r111 == null) goto L23;
        pc8.m r112 = r111.a(r105);
    L24:
        if (r112 == null) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == true) goto L35;
        h.f554220a.getClass();
        Intrinsics.checkNotNullParameter(r105, "conversationId");
        int r114 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        Intrinsics.checkNotNullParameter(r105, "conversationId");
        IBubbleBannerRuntimeService r115 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r115 != null) goto L31;
    L33:
        boolean r116 = false;
    L34:
        if (r116 == true) goto L35;
        return false;
    L31:
        if (r115.c(r105) != true) goto L33;
        r116 = true;
        goto L34
    L26:
        r113 = false;
        goto L27
    L23:
        r112 = null;
    L35:
        return true;
    L18:
        r108 = false;
        goto L19
    L10:
        if (r106.isEmpty() == false) goto L12;
    L42:
        return false;
    L40:
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r210, xc8.b r211, xc8.b r212, List<xc8.b> r213) {
        Intrinsics.checkNotNullParameter(r212, "current");
        Intrinsics.checkNotNullParameter(r213, "input");
        wc9.e r100 = this.f554212a.g();
        if (r100 == null) goto L451;
        String r101 = r100.f559198a;
        if (r101 == null) goto L451;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r213.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if ((((xc8.b) r104) instanceof com.larus.bmhome.chat.list.cell.spacer.j) == true) goto L9;
        r102.add(r104);
        goto L9
    L13:
        List<xc8.b> r105 = CollectionsKt.toMutableList(r102);
        int r106 = o.f554234a;
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        pc8.l r107 = pc8.k.f528602a;
        pc8.l r108 = pc8.k.f528602a;
        if (r108 == null) goto L16;
        pc8.m r109 = r108.a(r101);
    L18:
        if (r109 == null) goto L20;
        boolean r110 = true;
    L22:
        if (r110 == false) goto L146;
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r105, "input");
        pc8.l r111 = pc8.k.f528602a;
        if (r111 == null) goto L268;
        pc8.m r112 = r111.a(r101);
        if (r112 == null) goto L268;
        Message r113 = c.c(r105);
        ReachSpacerState r114 = r112.f528610h;
        ReachSpacerState r115 = ReachSpacerState.WAITING;
        if (r114 == r115) goto L35;
        if (r112.f528606d == false) goto L268;
    L35:
        if (StringsKt.isBlank(r112.f528605c) == false) goto L37;
    L40:
        boolean r116 = true;
    L41:
        if (r116 == false) goto L45;
        if (r113 == null) goto L44;
        String r117 = c.d(r113);
    L46:
        if (r117 == null) goto L48;
        Message r214 = c.a(r105, r117);
    L49:
        if (r214 == null) goto L51;
        if (r113 == null) goto L58;
        Set r118 = c.j(r113);
    L59:
        if (r118 != null) goto L62;
        r118 = SetsKt.emptySet();
    L62:
        if (r112.f528610h != r115) goto L64;
    L98:
        Set r119 = c.j(r214);
        boolean r120 = c.f(r105, r119);
        boolean r121 = c.b(r105, r119);
        int r122 = r112.f528609g;
        if (r122 == 1) goto L103;
        if (r122 == 3) goto L102;
        boolean r123 = false;
    L104:
        if (r123 == false) goto L112;
        r111.c(r112.f528603a);
        if (r112.f528610h == ReachSpacerState.WAITING) goto L268;
        r112 = r111.a(r101);
        if (r112 == null) goto L268;
    L112:
        if (r112.f528610h != ReachSpacerState.WAITING) goto L122;
        int r124 = r112.f528608f;
        if (r124 == 1) goto L117;
        if (r124 == 3) goto L118;
        r120 = true;
    L118:
        if (r120 == false) goto L268;
        r111.h(r112.f528603a, r117);
        goto L122
    L117:
        r120 = r121;
    L122:
        if (r112.f528610h != ReachSpacerState.ENTERING) goto L124;
        r111.d(r112.f528603a);
    L124:
        String r125 = r112.f528603a;
        int r126 = r112.f528607e;
        int r127 = o.b.f554236a[r112.f528610h.ordinal()];
        if (r127 == 1) goto L134;
        if (r127 == 2) goto L133;
        if (r127 == 3) goto L133;
        if (r127 != 4) goto L132;
        SpacerAnimationState r128 = SpacerAnimationState.COLLAPSE;
    L135:
        SpacerAnimationState r215 = r128;
        Long r129 = Long.valueOf(r112.f528611i);
        if (r129.longValue() <= 0) goto L138;
        boolean r130 = true;
    L139:
        if (r130 == true) goto L142;
        r129 = null;
    L142:
        if (r129 == null) goto L144;
        long r131 = r129.longValue();
        com.larus.bmhome.chat.list.cell.spacer.a r216 = new com.larus.bmhome.chat.list.cell.spacer.a(r112.f528610h.name() + '_' + r112.f528603a + '_' + r131, r131, r112.f528612j);
    L145:
        p r132 = new p(r125, r126, r214, r215, r216, o.a.f554235a);
    L269:
        r105 = r105;
    L416:
        if (r132 != null) goto L418;
        return r105;
    L418:
        xc8.b r133 = (xc8.b) CollectionsKt.firstOrNull(r105);
        if (r133 == null) goto L421;
        Message r134 = r133.getMessage();
    L422:
        if (r134 == null) goto L426;
        boolean r135 = true;
        if (com.larus.bmhome.chat.bean.d.O0(r134) != true) goto L427;
        boolean r136 = true;
    L428:
        if (r136 == true) goto L436;
        if (r134 != null) goto L431;
    L433:
        boolean r137 = false;
    L434:
        if (r137 == true) goto L436;
        boolean r138 = true;
    L438:
        if (r132.f554240d == SpacerAnimationState.EXPAND) goto L440;
    L442:
        boolean r139 = false;
    L443:
        String r140 = r132.f554237a;
        int r141 = r132.f554238b;
        wc9.e r142 = this.f554212a.g();
        if (r142 == null) goto L446;
        String r143 = r142.f559198a;
    L447:
        if (r143 != null) goto L449;
        r143 = "";
    L449:
        com.larus.bmhome.chat.list.cell.spacer.j r144 = new com.larus.bmhome.chat.list.cell.spacer.j(r140, r141, r143, r132.f554239c, r132.f554240d, r139, r132.f554241e, r138, new b(r132));
        List<xc8.b> r145 = r105;
        ListProtector.add(r145, 0, r144);
        return r145;
    L446:
        r143 = null;
        goto L447
    L440:
        if (f554211b.contains(r132.f554237a) == false) goto L442;
        r139 = true;
        goto L443
    L431:
        if (com.larus.bmhome.chat.bean.d.E0(r134) != r135) goto L433;
        r137 = true;
    L436:
        r138 = false;
    L427:
        r136 = false;
        goto L428
    L426:
        r135 = true;
        goto L427
    L421:
        r134 = null;
        goto L422
    L144:
        r216 = null;
        goto L145
    L138:
        r130 = false;
        goto L139
    L132:
        throw new NoWhenBranchMatchedException();
    L133:
        r128 = SpacerAnimationState.EXPAND;
        goto L135
    L134:
        r128 = SpacerAnimationState.WAITING;
        goto L135
    L102:
        r123 = r120;
        goto L104
    L103:
        r123 = r121;
        goto L104
    L64:
        if ((!r118.isEmpty()) == false) goto L98;
        if (r118.contains(r117) == true) goto L98;
        Iterator<xc8.b> r146 = r105.iterator();
        int r147 = 0;
    L69:
        if (r146.hasNext() == false) goto L74;
        if (c.i(r146.next().getMessage(), r117) == true) goto L75;
        r147 = r147 + 1;
    L75:
        Iterator<xc8.b> r148 = r105.iterator();
        int r149 = 0;
    L77:
        if (r148.hasNext() == false) goto L93;
        xc8.b r150 = r148.next();
        Set r151 = r118;
        if ((r151 instanceof Collection) == true) goto L81;
    L83:
        Iterator r152 = r151.iterator();
    L85:
        if (r152.hasNext() == false) goto L89;
        if (c.i(r150.getMessage(), (String) r152.next()) == false) goto L85;
        boolean r153 = true;
    L90:
        if (r153 == true) goto L91;
        r149 = r149 + 1;
        goto L77
    L91:
        int r154 = r149;
    L94:
        if (r147 < 0) goto L98;
        if (r154 < 0) goto L98;
        if (r154 >= r147) goto L98;
        r111.b(r112.f528603a);
    L89:
        r153 = false;
        goto L90
    L81:
        if (r151.isEmpty() == false) goto L83;
    L93:
        r154 = -1;
        goto L94
    L74:
        r147 = -1;
        goto L75
    L58:
        r118 = null;
        goto L59
    L51:
        if (r112.f528610h != r115) goto L268;
        if (r116 == false) goto L55;
        if (r113 != null) goto L55;
        r111.g(r112.f528603a);
    L55:
        r111.b(r112.f528603a);
        goto L268
    L48:
        r214 = null;
        goto L49
    L44:
        r117 = null;
        goto L46
    L45:
        r117 = r112.f528605c;
        goto L46
    L37:
        if (Intrinsics.areEqual(r112.f528605c, "-1") == true) goto L40;
        r116 = false;
    L268:
        r132 = null;
        goto L269
    L146:
        h.f554220a.getClass();
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r105, "input");
        Message r155 = c.c(r105);
        int r156 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        IBubbleBannerRuntimeService r157 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r157 == null) goto L149;
        pc8.e r158 = r157.q(r101);
    L150:
        if (r158 == null) goto L212;
        if (r155 == null) goto L154;
        Set r159 = c.j(r155);
    L155:
        if (r159 != null) goto L158;
        r159 = SetsKt.emptySet();
    L158:
        if (r159.isEmpty() == true) goto L212;
        BubbleBannerState r160 = r158.f528578c;
        if (r160 == BubbleBannerState.EXITING) goto L212;
        pc8.f r161 = r158.f528579d;
        if (r161 == null) goto L165;
        String r162 = r161.f528589a;
    L166:
        if (r162 == null) goto L168;
    L174:
        boolean r163 = false;
    L175:
        if (r163 == false) goto L178;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r158.f528576a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L212
    L178:
        if (r159.contains(r158.b()) == true) goto L212;
        Iterator<xc8.b> r164 = r105.iterator();
        int r165 = 0;
    L182:
        if (r164.hasNext() == false) goto L187;
        if (c.i(r164.next().getMessage(), r158.b()) == true) goto L188;
        r165 = r165 + 1;
    L188:
        Iterator<xc8.b> r166 = r105.iterator();
        int r167 = 0;
    L190:
        if (r166.hasNext() == false) goto L207;
        xc8.b r168 = r166.next();
        Set r169 = r159;
        if ((r169 instanceof Collection) == true) goto L194;
    L196:
        Iterator r170 = r169.iterator();
    L198:
        if (r170.hasNext() == false) goto L203;
        if (c.i(r168.getMessage(), (String) r170.next()) == false) goto L198;
        boolean r171 = true;
    L204:
        if (r171 == true) goto L208;
        r167 = r167 + 1;
    L208:
        if (r165 < 0) goto L212;
        if (r167 < 0) goto L212;
        if (r167 >= r165) goto L212;
        int r172 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r158.f528576a, BubbleBannerDismissReason.NEW_MESSAGE);
    L203:
        r171 = false;
        goto L204
    L194:
        if (r169.isEmpty() == false) goto L196;
    L207:
        r167 = -1;
        goto L208
    L187:
        r165 = -1;
        goto L188
    L168:
        if (r160 != BubbleBannerState.RESOLVED) goto L170;
    L173:
        r163 = true;
        goto L175
    L170:
        if (r160 == BubbleBannerState.ENTERING) goto L173;
        if (r160 != BubbleBannerState.VISIBLE) goto L174;
    L165:
        r162 = null;
        goto L166
    L154:
        r159 = null;
    L212:
        if (r158 == null) goto L232;
        if (r155 == null) goto L216;
        Set r173 = c.j(r155);
    L217:
        if (r173 != null) goto L220;
        r173 = SetsKt.emptySet();
    L220:
        if (r173.isEmpty() == true) goto L232;
        if (c.b(r105, r173) == false) goto L232;
        if (r158.f528578c == BubbleBannerState.EXITING) goto L232;
        if (r158.f528577b.f528573f.f528593b != 1) goto L232;
        if (r173.contains(r158.b()) == false) goto L232;
        int r174 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r158.f528576a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L232
    L216:
        r173 = null;
    L232:
        if (r158 == null) goto L263;
        if (r155 == null) goto L236;
        Set r175 = c.j(r155);
    L237:
        if (r175 != null) goto L240;
        r175 = SetsKt.emptySet();
    L240:
        if (r175.isEmpty() == true) goto L263;
        List<xc8.b> r176 = r105;
        if ((r176 instanceof Collection) == true) goto L245;
    L247:
        Iterator<T> r177 = r176.iterator();
    L249:
        if (r177.hasNext() == false) goto L253;
        if (c.h(((xc8.b) r177.next()).getMessage(), r175) == false) goto L249;
        boolean r178 = true;
    L254:
        if (r178 == false) goto L263;
        if (r158.f528578c == BubbleBannerState.EXITING) goto L263;
        if (r158.f528577b.f528573f.f528593b != 3) goto L263;
        if (r175.contains(r158.b()) == false) goto L263;
        int r179 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r158.f528576a, BubbleBannerDismissReason.NEW_MESSAGE);
    L253:
        r178 = false;
        goto L254
    L245:
        if (r176.isEmpty() == false) goto L247;
    L236:
        r175 = null;
    L263:
        int r180 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        IBubbleBannerRuntimeService r181 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r181 == null) goto L266;
        pc8.e r182 = r181.q(r101);
    L267:
        if (r182 == null) goto L268;
        BubbleBannerState r183 = r182.f528578c;
        BubbleBannerState r184 = BubbleBannerState.ENTERING;
        if (r183 != r184) goto L273;
    L278:
        boolean r185 = true;
    L279:
        Intrinsics.checkNotNullParameter(r182, "<this>");
        pc8.f r186 = r182.f528579d;
        if (r186 != null) goto L282;
        boolean r187 = true;
    L283:
        if (r187 == false) goto L286;
        if (r155 == null) goto L288;
        String r188 = c.d(r155);
    L289:
        if (r188 == null) goto L291;
        p r189 = null;
        Message r190 = c.a(r105, r188);
        if (r190 != null) goto L320;
        if (r182.f528578c != BubbleBannerState.EXITING) goto L310;
        Intrinsics.checkNotNullParameter(r182, "<this>");
        pc8.f r191 = r182.f528579d;
        if (r191 == null) goto L306;
        Set<BubbleBannerRenderPart> r192 = r191.f528591c;
        if (r192 == null) goto L306;
        if (r192.contains(BubbleBannerRenderPart.SPACER) != true) goto L306;
        boolean r193 = true;
    L307:
        if (r193 == false) goto L310;
        h.a(r182);
    L383:
        r105 = r105;
        r132 = r189;
    L306:
        r193 = false;
    L310:
        if (pc8.g.a(r182.f528577b) == null) goto L312;
        boolean r194 = true;
    L313:
        if (r194 == false) goto L383;
        BubbleBannerState r195 = r182.f528578c;
        if (r195 == r184) goto L383;
        if (r195 == BubbleBannerState.VISIBLE) goto L383;
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r182.f528576a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L383
    L312:
        r194 = false;
        goto L313
    L320:
        if (r182.f528578c == BubbleBannerState.EXITING) goto L361;
        Set r196 = c.j(r190);
        if (r196.isEmpty() == false) goto L324;
    L360:
        com.larus.bmhome.chat.bubble.floating.runtime.k.a(r182.f528576a, BubbleBannerDismissReason.NEW_MESSAGE);
        goto L383
    L324:
        if (r196.contains(r188) == false) goto L360;
        if (r185 == true) goto L356;
        int r197 = r182.f528577b.f528573f.f528592a;
        if (r197 == 1) goto L332;
        if (r197 != 3) goto L352;
        boolean r198 = c.f(r105, c.j(r190));
    L354:
        if (r198 == true) goto L356;
        int r199 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.d(r182.f528576a, r188);
    L352:
        r198 = true;
        goto L354
    L332:
        Set r200 = c.j(r190);
        Iterator<T> r201 = r105.iterator();
    L334:
        if (r201.hasNext() == false) goto L345;
        Object r1100 = r201.next();
        Message r1101 = ((xc8.b) r1100).getMessage();
        if (c.g(r1101) == false) goto L338;
    L342:
        boolean r1102 = false;
    L343:
        if (r1102 == false) goto L334;
    L346:
        xc8.b r1103 = (xc8.b) r1100;
        if (r1103 == null) goto L353;
        Message r202 = r1103.getMessage();
        if (r202 == null) goto L353;
        if (c.e(r202) == true) goto L352;
    L353:
        r198 = false;
        goto L354
    L338:
        if (com.larus.bmhome.chat.bean.d.G0(r1101) == true) goto L342;
        if (CollectionsKt.contains(r200, r1101.getReplyId()) == false) goto L342;
        r1102 = true;
        goto L343
    L345:
        r1100 = null;
    L356:
        if (r185 == true) goto L361;
        int r203 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        com.larus.bmhome.chat.bubble.floating.runtime.k.d(r182.f528576a, r188);
        String r204 = r182.f528576a;
        BubbleBannerEnterTrigger r205 = BubbleBannerEnterTrigger.SPACER_READY;
        Intrinsics.checkNotNullParameter(r204, "promptId");
        Intrinsics.checkNotNullParameter(r205, "trigger");
        IBubbleBannerRuntimeService r206 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r206 == null) goto L361;
        r206.d(r204, r205);
    L361:
        int r207 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        pc8.e r208 = com.larus.bmhome.chat.bubble.floating.runtime.k.b(r182.f528576a);
        if (r208 == null) goto L365;
        r182 = r208;
    L365:
        BubbleBannerState r209 = r182.f528578c;
        if (r209 != BubbleBannerState.ENTERING) goto L368;
    L371:
        String r217 = r182.f528576a;
        Intrinsics.checkNotNullParameter(r217, "promptId");
        IBubbleBannerRuntimeService r218 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r218 == null) goto L374;
        r218.n(r217);
    L374:
        Intrinsics.checkNotNullParameter(r182, "<this>");
        pc8.f r219 = r182.f528579d;
        if (r219 == null) goto L381;
        Set<BubbleBannerRenderPart> r220 = r219.f528591c;
        if (r220 == null) goto L381;
        if (r220.contains(BubbleBannerRenderPart.SPACER) != true) goto L381;
        boolean r221 = true;
    L382:
        if (r221 == false) goto L383;
        String r1104 = r182.f528576a;
        int r1105 = c7.b(92);
        pc8.i r222 = r182.f528585j;
        if (r222 == null) goto L387;
        BubbleBannerTransitionType r223 = r222.getType();
    L388:
        if (r223 != null) goto L390;
        int r224 = -1;
    L392:
        if (r224 == (-1)) goto L400;
        if (r224 != 1) goto L395;
        SpacerAnimationState r225 = SpacerAnimationState.EXPAND;
    L411:
        pc8.i r226 = r182.f528585j;
        if (r226 != null) goto L414;
        com.larus.bmhome.chat.list.cell.spacer.a r1106 = null;
    L415:
        r132 = new p(r1104, r1105, r190, r225, r1106, h.a.f554221a);
        goto L416
    L414:
        r1106 = new com.larus.bmhome.chat.list.cell.spacer.a(r226.f528598a, r226.f528600c, r226.f528601d);
        goto L415
    L395:
        if (r224 != 2) goto L398;
        r225 = SpacerAnimationState.COLLAPSE;
        goto L411
    L398:
        throw new NoWhenBranchMatchedException();
    L400:
        int r227 = h.b.f554222a[r182.f528578c.ordinal()];
        if (r227 != 1) goto L403;
        r225 = SpacerAnimationState.WAITING;
        goto L411
    L403:
        if (r227 == 2) goto L409;
        if (r227 == 3) goto L409;
        if (r227 == 4) goto L408;
        r225 = SpacerAnimationState.NONE;
        goto L411
    L408:
        r225 = SpacerAnimationState.COLLAPSE;
    L409:
        r225 = SpacerAnimationState.EXPAND;
        goto L411
    L390:
        r224 = h.b.f554223b[r223.ordinal()];
        goto L392
    L387:
        r223 = null;
    L381:
        r221 = false;
        goto L382
    L368:
        if (r209 == BubbleBannerState.VISIBLE) goto L371;
        if (r209 != BubbleBannerState.EXITING) goto L374;
    L291:
        if (r182.f528578c == BubbleBannerState.EXITING) goto L294;
        if (r185 == true) goto L294;
        r189 = null;
        com.larus.bmhome.chat.bubble.floating.runtime.k.d(r182.f528576a, null);
    L294:
        r189 = null;
    L288:
        r188 = null;
        goto L289
    L286:
        if (r186 == null) goto L288;
        r188 = r186.f528589a;
        goto L289
    L282:
        r187 = false;
        goto L283
    L273:
        if (r183 == BubbleBannerState.VISIBLE) goto L278;
        if (r183 == BubbleBannerState.EXITING) goto L278;
        r185 = false;
        goto L279
    L266:
        r182 = null;
        goto L267
    L149:
        r158 = null;
        goto L150
    L20:
        r110 = false;
        goto L22
    L16:
        r109 = null;
    L451:
        return r213;
    }
}
