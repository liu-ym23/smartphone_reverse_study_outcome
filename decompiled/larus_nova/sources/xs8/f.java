package xs8;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.DropdownListSelectorWidgetV2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
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

/* JADX INFO: loaded from: classes26.dex */
public final class f extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.i f565015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Keva f565016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<com.larus.bmhome.actionbar.model.h> f565017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f565018o;

    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.b
    public int getType() {
        return 2;
    }

    @Override // up8.d
    public final String g() {
        Object r100 = null;
        if (this.f565015l != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        com.larus.bmhome.actionbar.model.i r102 = this.f565015l;
        if (r102 == null) goto L35;
        List<com.larus.bmhome.actionbar.model.h> r103 = r102.f295193a;
        if (r103 == null) goto L35;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L35;
        com.larus.bmhome.actionbar.model.h r105 = (com.larus.bmhome.actionbar.model.h) r104.next();
        List<w> r106 = r105.f295167e;
        boolean r107 = false;
        if (r106 == null) goto L27;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r106.iterator();
    L16:
        if (r109.hasNext() == false) goto L26;
        Object r110 = r109.next();
        Integer r111 = ((w) r110).f295528s;
        if (r111 != null) goto L21;
    L23:
        boolean r112 = false;
    L24:
        if (r112 == false) goto L16;
        r108.add(r110);
        goto L16
    L21:
        if (r111.intValue() != 1) goto L23;
        r112 = true;
        goto L24
    L26:
        ArrayList r113 = r108;
    L28:
        if (r113 != null) goto L30;
    L32:
        if (r107 == false) goto L11;
        r101.add(com.larus.bmhome.actionbar.model.h.a(r105, null, null, null, r113, null, null, 4079));
        goto L11
    L30:
        if ((!r113.isEmpty()) != true) goto L32;
        r107 = true;
        goto L32
    L27:
        r113 = null;
    L35:
        if (r101.isEmpty() == false) goto L38;
        return null;
    L38:
        if (this.f565015l == null) goto L40;
        com.larus.bmhome.actionbar.model.i r114 = new com.larus.bmhome.actionbar.model.i(r101);
    L51:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L43
        Object r116 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.i.Companion.serializer()), r114));     // Catch: Throwable -> L43
    L46:
        if (Result.m9455isFailureimpl(r116) == true) goto L50;
        r100 = r116;
    L50:
        return (String) r100;
    L43:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L40:
        r114 = null;
        goto L51
    }

    public f() {
        this.f565016m = Keva.getRepo("default", 0);
        this.f565017n = new ArrayList();
    }

    @Override // up8.b
    public final boolean j() {
        return this.f565018o;
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new DropdownListSelectorWidgetV2(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        if ((r101 instanceof Map) == false) goto L5;
        Map r102 = (Map) r101;
    L6:
        com.larus.bmhome.actionbar.model.i r103 = this.f565015l;
        if (r103 == null) goto L40;
        List<com.larus.bmhome.actionbar.model.h> r104 = r103.f295193a;
        if (r104 == null) goto L53;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L54;
        com.larus.bmhome.actionbar.model.h r106 = (com.larus.bmhome.actionbar.model.h) r105.next();
        if (r102 == null) goto L17;
        Object r107 = r102.get(String.valueOf(r106.f295164b));
        if (r107 == null) goto L17;
    L21:
        if ((r107 instanceof Map) == false) goto L23;
        Map r108 = (Map) r107;
    L24:
        if (r108 == null) goto L28;
        Object r109 = r108.get("default_select_id");
        if (r109 == null) goto L28;
        String r110 = r109.toString();
    L30:
        if (o0.d(r110) == false) goto L12;
        FLogger.f375446a.d("DropdownListSelectorController", "onReStoreComponentStateByDefaultParams: select:" + r110);
        List<w> r111 = r106.f295167e;
        if (r111 == null) goto L12;
        Iterator<T> r112 = r111.iterator();
    L35:
        if (r112.hasNext() == false) goto L12;
        w r113 = (w) r112.next();
        if (Intrinsics.areEqual(String.valueOf(r113.f295510a), r110) == true) goto L38;
        r113.f295528s = 0;
        goto L35
    L38:
        r113.f295528s = 1;
    L28:
        r110 = null;
        goto L30
    L23:
        r108 = null;
    L17:
        if (r102 == null) goto L19;
        r107 = r102.get("match_all_id");
        goto L21
    L19:
        r107 = null;
        goto L21
    L54:
        return;
    L53:
        return;
    L40:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // up8.b
    public final a0 n(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        Object r111 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.i) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r111);
        if (r102 != null) goto L113;
        com.larus.bmhome.actionbar.model.i r112 = (com.larus.bmhome.actionbar.model.i) r111;
        List<com.larus.bmhome.actionbar.model.h> r103 = null;
        if (r112 == null) goto L21;
        List<com.larus.bmhome.actionbar.model.h> r104 = r112.f295193a;
    L22:
        List<com.larus.bmhome.actionbar.model.h> r105 = r104;
        if (r105 != null) goto L25;
    L28:
        boolean r106 = true;
    L29:
        if (r106 == true) goto L31;
        this.f565015l = r112;
        if (r112 == null) goto L107;
        List<com.larus.bmhome.actionbar.model.h> r113 = r112.f295193a;
        if (r113 == null) goto L107;
        Iterator<T> r114 = r113.iterator();
    L38:
        if (r114.hasNext() == false) goto L107;
        com.larus.bmhome.actionbar.model.h r107 = (com.larus.bmhome.actionbar.model.h) r114.next();
        if (Intrinsics.areEqual(r107.f295171i, Boolean.TRUE) == false) goto L50;
        Keva r108 = this.f565016m;
        StringBuilder r109 = new StringBuilder("dropbox_");
        com.larus.bmhome.view.actionbar.edit.c r115 = this.f551063c;
        if (r115 == null) goto L44;
        String r116 = r115.getActionBarType();
    L45:
        r109.append(r116);
        r109.append('_');
        u r117 = this.f551062b;
        if (r117 == null) goto L48;
        Integer r118 = r117.f295474a;
    L49:
        r109.append(r118);
        r109.append('_');
        r109.append(r107.f295164b);
        long r119 = r108.getLong(r109.toString(), -1);
    L52:
        if (r119 == (-1)) goto L71;
        List<w> r120 = r107.f295167e;
        if (r120 == null) goto L71;
        Iterator<T> r121 = r120.iterator();
    L57:
        if (r121.hasNext() == false) goto L67;
        Object r122 = r121.next();
        Long r123 = ((w) r122).f295510a;
        if (r123 != null) goto L62;
    L64:
        boolean r124 = false;
    L65:
        if (r124 == false) goto L57;
    L68:
        w r125 = (w) r122;
        if (r125 == null) goto L71;
        r125.f295528s = 1;
    L73:
        if (r125 == null) goto L75;
    L90:
        w r126 = null;
    L91:
        if (r126 != null) goto L106;
        if (r125 != null) goto L106;
        if (Intrinsics.areEqual(r107.f295170h, Boolean.TRUE) == true) goto L98;
        Integer r127 = r107.f295168f;
        if (r127 == null) goto L98;
        int r128 = r127.intValue();
    L99:
        if (r128 < 0) goto L106;
        List<w> r129 = r107.f295167e;
        if (r129 == null) goto L103;
        w r130 = (w) CollectionsKt.getOrNull(r129, r128);
    L104:
        if (r130 == null) goto L106;
        r130.f295528s = 1;
        goto L106
    L103:
        r130 = null;
    L98:
        r128 = -1;
    L106:
        FLogger.f375446a.i("DropdownListSelectorController", "draftSelectedItemId=" + r119 + ", draftSelectedItem=" + r125 + ", defaultSelectionIndex=" + r107.f295168f + ",selectedItemByDefaultId=" + r107.f295169g);
        goto L38
    L75:
        if (Intrinsics.areEqual(r107.f295170h, Boolean.TRUE) == true) goto L90;
        List<w> r131 = r107.f295167e;
        if (r131 == null) goto L88;
        Iterator<T> r132 = r131.iterator();
    L80:
        if (r132.hasNext() == false) goto L84;
        Object r133 = r132.next();
        if (Intrinsics.areEqual(((w) r133).f295510a, r107.f295169g) == false) goto L80;
    L85:
        r126 = (w) r133;
        if (r126 == null) goto L88;
        r126.f295528s = 1;
    L89:
        FLogger.f375446a.i("DropdownListSelectorController", "selectedItemByDefaultId=" + r107.f295169g);
        goto L91
    L84:
        r133 = null;
    L88:
        r126 = null;
        goto L89
    L62:
        if (r123.longValue() != r119) goto L64;
        r124 = true;
        goto L65
    L67:
        r122 = null;
    L71:
        r125 = null;
        goto L73
    L48:
        r118 = null;
        goto L49
    L44:
        r116 = null;
        goto L45
    L50:
        r119 = -1;
    L107:
        com.larus.bmhome.actionbar.model.i r134 = this.f565015l;
        if (r134 == null) goto L110;
        r103 = new com.larus.bmhome.actionbar.model.i(r134.f295193a).f295193a;
    L110:
        this.f565017n = r103;
        return new a0(Boolean.TRUE, "");
    L31:
        return new a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r105.isEmpty() == true) goto L28;
        r106 = false;
        goto L29
    L21:
        r104 = null;
        goto L22
    L113:
        return new a0(Boolean.FALSE, r102.getMessage());
    L14:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.i) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.i r104 = (com.larus.bmhome.actionbar.model.i) r103;
        if (r104 != null) goto L14;
        return;
    L14:
        if (r101 == false) goto L16;
        this.f565018o = true;
    L16:
        List<com.larus.bmhome.actionbar.model.h> r105 = r104.f295193a;
        if (r105 == null) goto L81;
        Iterator<T> r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L126;
        com.larus.bmhome.actionbar.model.h r107 = (com.larus.bmhome.actionbar.model.h) r106.next();
        if (o0.d(r107.f295163a) == true) goto L23;
        com.larus.bmhome.actionbar.model.i r108 = this.f565015l;
        if (r108 == null) goto L20;
        List<com.larus.bmhome.actionbar.model.h> r109 = r108.f295193a;
        if (r109 == null) goto L20;
        Iterator<T> r110 = r109.iterator();
    L58:
        if (r110.hasNext() == false) goto L62;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r111).f295164b, r107.f295164b) == false) goto L58;
    L63:
        com.larus.bmhome.actionbar.model.h r112 = (com.larus.bmhome.actionbar.model.h) r111;
        if (r112 == null) goto L20;
        List<w> r113 = r107.f295167e;
        if (r113 == null) goto L70;
        w r114 = (w) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L70;
        Long r115 = r114.f295510a;
    L71:
        if (r115 == null) goto L20;
        List<w> r116 = r112.f295167e;
        if (r116 == null) goto L20;
        Iterator<T> r117 = r116.iterator();
    L76:
        if (r117.hasNext() == false) goto L20;
        w r118 = (w) r117.next();
        if (Intrinsics.areEqual(r118.f295510a, r115) == true) goto L79;
        r118.f295528s = 0;
        goto L76
    L79:
        r118.f295528s = 1;
    L70:
        r115 = null;
        goto L71
    L62:
        r111 = null;
        goto L63
    L23:
        com.larus.bmhome.actionbar.model.i r119 = this.f565015l;
        if (r119 == null) goto L20;
        List<com.larus.bmhome.actionbar.model.h> r120 = r119.f295193a;
        if (r120 == null) goto L20;
        Iterator<T> r121 = r120.iterator();
    L29:
        if (r121.hasNext() == false) goto L33;
        Object r122 = r121.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r122).f295163a, r107.f295163a) == false) goto L29;
    L34:
        com.larus.bmhome.actionbar.model.h r123 = (com.larus.bmhome.actionbar.model.h) r122;
        if (r123 == null) goto L20;
        List<w> r124 = r107.f295167e;
        if (r124 == null) goto L41;
        w r125 = (w) CollectionsKt.firstOrNull(r124);
        if (r125 == null) goto L41;
        Long r126 = r125.f295510a;
    L42:
        if (r126 == null) goto L20;
        List<w> r127 = r123.f295167e;
        if (r127 == null) goto L20;
        Iterator<T> r128 = r127.iterator();
    L47:
        if (r128.hasNext() == false) goto L20;
        w r129 = (w) r128.next();
        if (Intrinsics.areEqual(r129.f295510a, r126) == true) goto L50;
        r129.f295528s = 0;
        goto L47
    L50:
        r129.f295528s = 1;
    L41:
        r126 = null;
        goto L42
    L33:
        r122 = null;
        goto L34
    L126:
        return;
    L81:
        return;
    L5:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
