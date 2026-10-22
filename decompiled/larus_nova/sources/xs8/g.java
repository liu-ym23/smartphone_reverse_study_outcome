package xs8;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;
import wa8.k0;

/* JADX INFO: loaded from: classes26.dex */
public final class g extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.h f565019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Keva f565020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f565021n;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 2;
    }

    @Override // up8.b
    public final int i() {
        return 3;
    }

    @Override // up8.d
    public final String g() {
        com.larus.bmhome.actionbar.model.h r100 = this.f565019l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295167e;
        if (r102 == null) goto L20;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        Integer r106 = ((w) r105).f295528s;
        if (r106 == null) goto L16;
        boolean r107 = true;
        if (r106.intValue() != 1) goto L16;
    L17:
        if (r107 == false) goto L9;
        r103.add(r105);
    L16:
        r107 = false;
        goto L17
    L19:
        ArrayList r110 = r103;
    L21:
        com.larus.bmhome.actionbar.model.h r108 = this.f565019l;
        if (r108 == null) goto L24;
        com.larus.bmhome.actionbar.model.h r109 = com.larus.bmhome.actionbar.model.h.a(r108, null, null, null, r110, null, null, 4079);
    L35:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
        Object r112 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r109));     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r112) == true) goto L34;
        r101 = r112;
    L34:
        return (String) r101;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L24:
        r109 = null;
        goto L35
    L20:
        r110 = null;
        goto L21
    }

    public final Long s() {
        com.larus.bmhome.actionbar.model.h r100 = this.f565019l;
        if (r100 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.f295164b;
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L46:
        l r102 = null;
    L47:
        if (r102 != null) goto L49;
        return null;
    L49:
        long r103 = r102.f565029b;
        if (r102.f565030c == false) goto L54;
        com.larus.bmhome.view.actionbar.edit.c r104 = this.f551063c;
        if (r104 == null) goto L54;
        r104.syncVideoModel(r103);
    L54:
        List<w> r105 = r100.f295167e;
        if (r105 == null) goto L68;
        Iterator<T> r106 = r105.iterator();
    L58:
        if (r106.hasNext() == false) goto L68;
        w r107 = (w) r106.next();
        Long r108 = r107.f295510a;
        if (r108 != null) goto L63;
    L65:
        int r109 = 0;
    L66:
        r107.f295528s = r109;
        goto L58
    L63:
        if (r108.longValue() != r103) goto L65;
        r109 = 1;
    L68:
        if (Intrinsics.areEqual(r100.f295171i, Boolean.TRUE) == false) goto L70;
        this.f565020m.storeLong("dropbox_" + this.f565021n + '_' + r100.f295164b, r103);
    L70:
        Integer r110 = this.f551067g;
        if (r110 == null) goto L75;
        int r111 = r110.intValue();
        com.larus.bmhome.view.actionbar.edit.c r112 = this.f551063c;
        if (r112 == null) goto L75;
        r112.selectModel(r111, r103);
    L75:
        FLogger.f375446a.i("DropdownSelectorController", "fallback expired subscribed model, dropdownId=" + r100.f295164b + ", selectedId=" + r102.f565028a + ", fallbackId=" + r103);
        return Long.valueOf(r103);
    L14:
        if (r101.intValue() != 6) goto L46;
        boolean r113 = true;
    L16:
        List<w> r114 = r100.f295167e;
        if (r114 == null) goto L46;
        Iterator<T> r115 = r114.iterator();
    L20:
        if (r115.hasNext() == false) goto L30;
        Object r116 = r115.next();
        Integer r117 = ((w) r116).f295528s;
        if (r117 != null) goto L25;
    L27:
        boolean r118 = false;
    L28:
        if (r118 == false) goto L20;
    L31:
        w r119 = (w) r116;
        if (r119 == null) goto L46;
        Long r120 = r119.f295510a;
        if (r120 == null) goto L46;
        long r121 = r120.longValue();
        Long r122 = k0.b(r100, r121);
        if (r122 == null) goto L46;
        if (r122.longValue() == r121) goto L40;
        boolean r123 = true;
    L41:
        if (r123 == true) goto L44;
        r122 = null;
    L44:
        if (r122 == null) goto L46;
        r102 = new l(r121, r122.longValue(), r113);
        goto L47
    L40:
        r123 = false;
        goto L41
    L25:
        if (r117.intValue() != 1) goto L27;
        r118 = true;
        goto L28
    L30:
        r116 = null;
        goto L31
    L9:
        if (r101.intValue() != 30) goto L11;
        r113 = false;
        goto L16
    }

    public final boolean t() {
        com.larus.bmhome.view.actionbar.edit.c r100 = this.f551063c;
        if (r100 == null) goto L5;
        Integer r101 = r100.getInstructionType();
    L7:
        if (r101 != null) goto L10;
    L36:
        if (r101 != null) goto L39;
    L40:
        if (r101 != null) goto L43;
    L45:
        if (r101 != null) goto L48;
    L49:
        if (r101 != null) goto L52;
    L69:
        return false;
    L52:
        if (r101.intValue() != 24) goto L69;
    L53:
        com.larus.bmhome.actionbar.model.h r102 = this.f565019l;
        if (r102 == null) goto L69;
        Integer r103 = r102.f295164b;
        if (r103 == null) goto L69;
        if (r103.intValue() != 1) goto L69;
        return true;
    L48:
        if (r101.intValue() == 18) goto L53;
    L43:
        if (r101.intValue() != 4) goto L45;
    L61:
        com.larus.bmhome.actionbar.model.h r104 = this.f565019l;
        if (r104 == null) goto L69;
        Integer r105 = r104.f295164b;
        if (r105 == null) goto L69;
        if (r105.intValue() != 2) goto L69;
        return true;
    L39:
        if (r101.intValue() == 16) goto L61;
    L10:
        if (r101.intValue() != 28) goto L36;
        Integer r106 = this.f551067g;
        if (r106 != null) goto L15;
    L24:
        if (r106 == null) goto L69;
        if (r106.intValue() != 18) goto L69;
        com.larus.bmhome.actionbar.model.h r107 = this.f565019l;
        if (r107 == null) goto L69;
        Integer r108 = r107.f295164b;
        if (r108 == null) goto L69;
        if (r108.intValue() != 1) goto L69;
        return true;
    L15:
        if (r106.intValue() != 4) goto L24;
        com.larus.bmhome.actionbar.model.h r109 = this.f565019l;
        if (r109 == null) goto L69;
        Integer r110 = r109.f295164b;
        if (r110 == null) goto L69;
        if (r110.intValue() != 2) goto L69;
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public g() {
        this.f565020m = Keva.getRepo("drop_save", 0);
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new DropdownSelectorWidget(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        com.larus.bmhome.actionbar.model.h r101 = this.f565019l;
        if (r101 == null) goto L7;
        Integer r102 = r101.f295164b;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        Object r104 = r100.get(String.valueOf(getType()));
        if ((r104 instanceof Map) == false) goto L11;
        Map r105 = (Map) r104;
    L12:
        if (r105 == null) goto L15;
        Object r106 = r105.get(r103);
        if (r106 == null) goto L15;
    L19:
        if ((r106 instanceof Map) == false) goto L21;
        Map r107 = (Map) r106;
    L22:
        if (r107 == null) goto L73;
        Object r108 = r107.get("default_select_id");
        if (r108 == null) goto L74;
        FLogger.f375446a.d("DropdownSelectorController", "onReStoreComponentStateByDefaultParams: select:" + r108);
        com.larus.bmhome.actionbar.model.h r109 = this.f565019l;
        if (r109 == null) goto L41;
        List<w> r110 = r109.f295167e;
        if (r110 == null) goto L41;
        Iterator<T> r111 = r110.iterator();
    L31:
        if (r111.hasNext() == false) goto L39;
        Object r112 = r111.next();
        Long r113 = ((w) r112).f295510a;
        if (r113 == null) goto L35;
        String r114 = r113.toString();
    L37:
        if (Intrinsics.areEqual(r114, r108) == false) goto L31;
    L40:
        w r115 = (w) r112;
    L42:
        if (r115 == null) goto L64;
        FLogger.f375446a.i("DropdownSelectorController", "has onRestoreComponentStateByDefaultParams " + r108);
        com.larus.bmhome.actionbar.model.h r116 = this.f565019l;
        if (r116 == null) goto L64;
        List<w> r117 = r116.f295167e;
        if (r117 == null) goto L64;
        Iterator<T> r118 = r117.iterator();
        int r119 = 0;
    L49:
        if (r118.hasNext() == false) goto L64;
        Object r120 = r118.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        w r122 = (w) r120;
        Long r123 = r122.f295510a;
        if (r123 == null) goto L56;
        String r124 = r123.toString();
    L58:
        if (Intrinsics.areEqual(r124, r108) == false) goto L62;
        r122.f295528s = 1;
        com.larus.bmhome.actionbar.model.h r125 = this.f565019l;
        if (r125 == null) goto L63;
        r125.f295168f = Integer.valueOf(r119);
    L63:
        r119 = r121;
        goto L49
    L62:
        r122.f295528s = 0;
        goto L63
    L56:
        r124 = null;
    L64:
        s();
        return;
    L35:
        r114 = null;
        goto L37
    L39:
        r112 = null;
    L41:
        r115 = null;
        goto L42
    L74:
        return;
    L73:
        return;
    L21:
        r107 = null;
    L15:
        if (r105 == null) goto L17;
        r106 = r105.get("match_all_id");
        goto L19
    L17:
        r106 = null;
        goto L19
    L11:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // up8.b
    public final a0 n(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        Object r111 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r111);
        if (r103 != null) goto L199;
        com.larus.bmhome.actionbar.model.h r112 = (com.larus.bmhome.actionbar.model.h) r111;
        List<w> r104 = null;
        if (r112 == null) goto L21;
        List<w> r105 = r112.f295167e;
    L22:
        List<w> r106 = r105;
        if (r106 != null) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == true) goto L31;
        this.f565019l = r112;
        if (r112 == null) goto L50;
        List<w> r113 = r112.f295167e;
        if (r113 == null) goto L50;
        Iterator<T> r114 = r113.iterator();
    L38:
        if (r114.hasNext() == false) goto L48;
        Object r108 = r114.next();
        Integer r109 = ((w) r108).f295528s;
        if (r109 != null) goto L43;
    L45:
        boolean r115 = false;
    L46:
        if (r115 == false) goto L38;
    L49:
        w r116 = (w) r108;
    L52:
        if (t() == false) goto L59;
        com.larus.bmhome.actionbar.model.h r117 = this.f565019l;
        if (r117 == null) goto L56;
        boolean r118 = Intrinsics.areEqual(r117.f295170h, Boolean.TRUE);
    L57:
        if (r118 == false) goto L59;
        boolean r119 = true;
    L61:
        if (r116 != null) goto L81;
        com.larus.bmhome.actionbar.model.h r120 = this.f565019l;
        if (r120 == null) goto L66;
        boolean r121 = Intrinsics.areEqual(r120.f295171i, Boolean.TRUE);
    L67:
        if (r121 == false) goto L81;
        if (r119 == true) goto L81;
        if (this.f565021n != 4) goto L76;
        Keva r122 = this.f565020m;
        StringBuilder r123 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r124 = this.f565019l;
        if (r124 == null) goto L74;
        Integer r125 = r124.f295164b;
    L75:
        r123.append(r125);
        long r126 = r122.getLong(r123.toString(), -1);
    L83:
        if (r126 == (-1)) goto L104;
        com.larus.bmhome.actionbar.model.h r127 = this.f565019l;
        if (r127 == null) goto L104;
        List<w> r128 = r127.f295167e;
        if (r128 == null) goto L104;
        Iterator<T> r129 = r128.iterator();
    L90:
        if (r129.hasNext() == false) goto L100;
        Object r130 = r129.next();
        Long r131 = ((w) r130).f295510a;
        if (r131 != null) goto L95;
    L97:
        boolean r132 = false;
    L98:
        if (r132 == false) goto L90;
    L101:
        w r133 = (w) r130;
        if (r133 == null) goto L104;
        r133.f295528s = 1;
    L106:
        if (r133 != null) goto L132;
        if (r116 != null) goto L132;
        com.larus.bmhome.actionbar.model.h r134 = this.f565019l;
        if (r134 == null) goto L126;
        List<w> r135 = r134.f295167e;
        if (r135 == null) goto L126;
        Iterator<T> r136 = r135.iterator();
    L114:
        if (r136.hasNext() == false) goto L122;
        Object r137 = r136.next();
        Long r138 = ((w) r137).f295510a;
        com.larus.bmhome.actionbar.model.h r139 = this.f565019l;
        if (r139 == null) goto L118;
        Long r140 = r139.f295169g;
    L120:
        if (Intrinsics.areEqual(r138, r140) == false) goto L114;
    L123:
        w r141 = (w) r137;
        if (r141 == null) goto L126;
        r141.f295528s = 1;
    L127:
        FLogger r142 = FLogger.f375446a;
        StringBuilder r143 = new StringBuilder("selectedItemByDefaultId=");
        com.larus.bmhome.actionbar.model.h r144 = this.f565019l;
        if (r144 == null) goto L130;
        Long r145 = r144.f295169g;
    L131:
        r143.append(r145);
        r142.i("DropdownSelectorController", r143.toString());
    L133:
        if (r141 != null) goto L151;
        if (r133 != null) goto L151;
        if (r116 != null) goto L151;
        com.larus.bmhome.actionbar.model.h r146 = this.f565019l;
        if (r146 == null) goto L141;
        Integer r147 = r146.f295168f;
        if (r147 == null) goto L141;
        int r148 = r147.intValue();
    L142:
        if (r148 < 0) goto L151;
        com.larus.bmhome.actionbar.model.h r149 = this.f565019l;
        if (r149 == null) goto L148;
        List<w> r150 = r149.f295167e;
        if (r150 == null) goto L148;
        w r151 = (w) CollectionsKt.getOrNull(r150, r148);
    L149:
        if (r151 == null) goto L151;
        r151.f295528s = 1;
    L148:
        r151 = null;
    L141:
        r148 = -1;
    L151:
        if (r133 != null) goto L153;
    L157:
        FLogger r152 = FLogger.f375446a;
        StringBuilder r153 = new StringBuilder("currentBindData is ");
        r153.append(this.f565019l);
        r153.append(", isRatio=");
        r153.append(t());
        r153.append(", canBeEmpty=");
        com.larus.bmhome.actionbar.model.h r154 = this.f565019l;
        if (r154 == null) goto L160;
        Boolean r155 = r154.f295170h;
    L161:
        r153.append(r155);
        r153.append(", ignoreDraftSelection=");
        r153.append(r119);
        r153.append(", draftSelectedItemId=");
        r153.append(r126);
        r153.append(", selectedOption=");
        com.larus.bmhome.actionbar.model.h r156 = this.f565019l;
        if (r156 == null) goto L179;
        List<w> r157 = r156.f295167e;
        if (r157 == null) goto L179;
        Iterator<T> r158 = r157.iterator();
    L167:
        if (r158.hasNext() == false) goto L177;
        Object r159 = r158.next();
        Integer r160 = ((w) r159).f295528s;
        if (r160 != null) goto L172;
    L174:
        boolean r161 = false;
    L175:
        if (r161 == false) goto L167;
    L178:
        w r162 = (w) r159;
    L180:
        r153.append(r162);
        r152.i("DropdownSelectorController", r153.toString());
        if (t() == false) goto L196;
        com.larus.bmhome.view.actionbar.edit.c r163 = this.f551063c;
        if (r163 == null) goto L190;
        com.larus.bmhome.actionbar.model.h r164 = this.f565019l;
        if (r164 == null) goto L187;
        r104 = r164.f295167e;
    L187:
        if (r104 != null) goto L189;
        r104 = CollectionsKt.emptyList();
    L189:
        r163.setRatioOptionList(r104);
    L190:
        com.larus.bmhome.view.actionbar.edit.c r165 = this.f551063c;
        if (r165 == null) goto L196;
        com.larus.bmhome.actionbar.model.h r166 = this.f565019l;
        if (r166 == null) goto L195;
        r100 = Intrinsics.areEqual(r166.f295170h, Boolean.TRUE);
    L195:
        r165.setRatioCanBeEmpty(r100);
    L196:
        s();
        return new a0(Boolean.TRUE, "");
    L172:
        if (r160.intValue() != 1) goto L174;
        r161 = true;
        goto L175
    L177:
        r159 = null;
    L179:
        r162 = null;
        goto L180
    L160:
        r155 = null;
        goto L161
    L153:
        if (this.f565021n != 4) goto L157;
        com.larus.bmhome.view.actionbar.edit.c r167 = this.f551063c;
        if (r167 == null) goto L157;
        r167.setImageStyleRadioSelected(false);
        goto L157
    L130:
        r145 = null;
        goto L131
    L118:
        r140 = null;
        goto L120
    L122:
        r137 = null;
    L126:
        r141 = null;
    L132:
        r141 = null;
        goto L133
    L95:
        if (r131.longValue() != r126) goto L97;
        r132 = true;
        goto L98
    L100:
        r130 = null;
    L104:
        r133 = null;
        goto L106
    L74:
        r125 = null;
        goto L75
    L76:
        Keva r168 = this.f565020m;
        StringBuilder r169 = new StringBuilder("dropbox_");
        r169.append(this.f565021n);
        r169.append('_');
        com.larus.bmhome.actionbar.model.h r170 = this.f565019l;
        if (r170 == null) goto L79;
        Integer r171 = r170.f295164b;
    L80:
        r169.append(r171);
        r126 = r168.getLong(r169.toString(), -1);
        goto L83
    L79:
        r171 = null;
        goto L80
    L66:
        r121 = false;
    L81:
        r126 = -1;
        goto L83
    L56:
        r118 = false;
    L59:
        r119 = false;
        goto L61
    L43:
        if (r109.intValue() != 1) goto L45;
        r115 = true;
        goto L46
    L48:
        r108 = null;
    L50:
        r116 = null;
        goto L52
    L31:
        return new a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r106.isEmpty() == true) goto L28;
        r107 = false;
        goto L29
    L21:
        r105 = null;
        goto L22
    L199:
        return new a0(Boolean.FALSE, r103.getMessage());
    L14:
        th = move-exception;
        Result.Companion r172 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // up8.b
    public final void q(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L5:
        this.f565021n = r101;
        return;
    L4:
        r101 = 0;
        goto L5
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L7:
        Object r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r105 = (com.larus.bmhome.actionbar.model.h) r103;
        if (r105 != null) goto L13;
        return;
    L13:
        List<w> r106 = r105.f295167e;
        if (r106 == null) goto L18;
        w r107 = (w) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L18;
        Long r108 = r107.f295510a;
    L19:
        if (r108 == null) goto L43;
        com.larus.bmhome.actionbar.model.h r109 = this.f565019l;
        if (r109 == null) goto L31;
        List<w> r110 = r109.f295167e;
        if (r110 == null) goto L31;
        Iterator<T> r111 = r110.iterator();
    L26:
        if (r111.hasNext() == false) goto L30;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((w) r112).f295510a, r108) == false) goto L26;
        r104 = r112;
    L30:
        r104 = (w) r104;
    L31:
        if (r104 == null) goto L43;
        com.larus.bmhome.actionbar.model.h r113 = this.f565019l;
        if (r113 == null) goto L43;
        List<w> r114 = r113.f295167e;
        if (r114 == null) goto L43;
        Iterator<T> r115 = r114.iterator();
    L38:
        if (r115.hasNext() == false) goto L43;
        w r116 = (w) r115.next();
        if (Intrinsics.areEqual(r116.f295510a, r108) == true) goto L41;
        r116.f295528s = 0;
        goto L38
    L41:
        r116.f295528s = 1;
    L43:
        s();
        return;
    L18:
        r108 = null;
    L5:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
