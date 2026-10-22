package wz9;

import android.content.Context;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.uaigc.music.template.MusicTemplateListSelectorWidgetV2;
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
import up8.b;
import wa8.a0;
import xt7.d;

/* JADX INFO: loaded from: classes31.dex */
public final class a extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d0 f561973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public bq8.a f561974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f561975n;

    @Override // up8.b
    public int getType() {
        return 10;
    }

    @Override // up8.d
    public final boolean a() {
        d0 r100 = this.f561973l;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295061c, Boolean.TRUE);
    L6:
        if (r101 == true) goto L8;
    L9:
        return true;
    L8:
        if (g() != null) goto L9;
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @Override // up8.b
    public final Long c() {
        bq8.a r100 = this.f561974m;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r100.f20048a);
    }

    @Override // up8.d
    public final String g() {
        d0 r100 = this.f561973l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295059a;
        boolean r103 = false;
        if (r102 == null) goto L19;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        Integer r107 = ((w) r106).f295528s;
        if (r107 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L9;
        r104.add(r106);
        goto L9
    L14:
        if (r107.intValue() != 1) goto L16;
        r108 = true;
    L20:
        if (r104 != null) goto L22;
    L23:
        r103 = true;
    L24:
        if (r103 == false) goto L26;
        return null;
    L26:
        d0 r109 = this.f561973l;
        if (r109 == null) goto L29;
        d0 r110 = d0.d(r109, r104, this.f561974m, 14);
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        Object r112 = Result.m9449constructorimpl(d.f565073b.a(kuc.a.d(d0.Companion.serializer()), r110));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r112) == true) goto L39;
        r101 = r112;
    L39:
        return (String) r101;
    L32:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L29:
        r110 = null;
        goto L40
    L22:
        if (r104.isEmpty() == false) goto L24;
    L19:
        r104 = null;
        goto L20
    }

    public a() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new MusicTemplateListSelectorWidgetV2(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        ArrayList r102 = null;
        if ((r101 instanceof Map) == false) goto L5;
        Map r103 = (Map) r101;
    L6:
        if (r103 == null) goto L9;
        Object r104 = r103.get(null);
        if (r104 == null) goto L9;
    L13:
        if ((r104 instanceof Map) == false) goto L15;
        Map r105 = (Map) r104;
    L16:
        if (r105 == null) goto L87;
        Object r106 = r105.get("default_select_id");
        if (r106 == null) goto L88;
        String r107 = r106.toString();
        if (r107 == null) goto L89;
        FLogger.f375446a.d("MusicTemplateListSelectorController", "onReStoreComponentStateByDefaultParams: select:".concat(r107));
        d0 r108 = this.f561973l;
        boolean r109 = false;
        if (r108 == null) goto L38;
        List<w> r110 = r108.f295059a;
        if (r110 == null) goto L38;
        Iterator<T> r111 = r110.iterator();
        int r112 = 0;
    L27:
        if (r111.hasNext() == false) goto L38;
        Object r113 = r111.next();
        int r114 = r112 + 1;
        if (r112 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        w r115 = (w) r113;
        if (Intrinsics.areEqual(String.valueOf(r115.f295510a), r107) == false) goto L36;
        r115.f295528s = 1;
        d0 r116 = this.f561973l;
        if (r116 == null) goto L37;
        r116.f295060b = Integer.valueOf(r112);
    L37:
        r112 = r114;
        goto L27
    L36:
        r115.f295528s = 0;
    L38:
        d0 r117 = this.f561973l;
        if (r117 == null) goto L41;
        bq8.a r118 = r117.f295063e;
    L42:
        this.f561974m = r118;
        if (r117 == null) goto L58;
        List<w> r119 = r117.f295059a;
        if (r119 == null) goto L58;
        r102 = new ArrayList();
        Iterator<T> r120 = r119.iterator();
    L48:
        if (r120.hasNext() == false) goto L58;
        Object r121 = r120.next();
        Integer r122 = ((w) r121).f295528s;
        if (r122 != null) goto L53;
    L55:
        boolean r123 = false;
    L56:
        if (r123 == false) goto L48;
        r102.add(r121);
        goto L48
    L53:
        if (r122.intValue() != 1) goto L55;
        r123 = true;
    L58:
        if (r102 != null) goto L60;
    L63:
        boolean r124 = true;
    L64:
        if (r124 == true) goto L90;
        u r125 = this.f551062b;
        if (r125 == null) goto L73;
        Integer r126 = r125.f295474a;
        if (r126 == null) goto L73;
        if (r126.intValue() != 1) goto L73;
        r109 = true;
    L73:
        if (r109 == false) goto L91;
        c r127 = this.f551063c;
        if (r127 == null) goto L92;
        r127.setImageStyleRadioSelected(true);
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L60:
        if (r102.isEmpty() == true) goto L63;
        r124 = false;
        goto L64
    L41:
        r118 = null;
        goto L42
    L89:
        return;
    L88:
        return;
    L87:
        return;
    L15:
        r105 = null;
    L9:
        if (r103 == null) goto L11;
        r104 = r103.get("match_all_id");
        goto L13
    L11:
        r104 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // up8.b
    public final a0 n(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl((d0) d.f565073b.c(d0.Companion.serializer(), r100));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 != null) goto L28;
        d0 r106 = (d0) r104;
        List<w> r107 = r106.f295062d;
        if (r107 == null) goto L25;
        w r108 = (w) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L25;
        if (r108.f295519j != true) goto L25;
        r101 = true;
    L25:
        this.f561975n = r101;
        this.f561973l = r106;
        this.f561974m = r106.f295063e;
        return new a0(Boolean.TRUE, "");
    L28:
        return new a0(Boolean.FALSE, r105.getMessage());
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new a0(Boolean.FALSE, "image list selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // up8.b
    public final void k(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "defaultStateTemplate");
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L5
        Object r113 = Result.m9449constructorimpl((d0) d.f565073b.c(d0.Companion.serializer(), r110));     // Catch: Throwable -> L5
    L7:
        ArrayList r100 = null;
        if (Result.m9455isFailureimpl(r113) == false) goto L10;
        r113 = null;
    L10:
        d0 r114 = (d0) r113;
        if (r114 != null) goto L13;
        return;
    L13:
        List<w> r115 = r114.f295059a;
        boolean r101 = false;
        if (r115 == null) goto L35;
        Iterator<T> r116 = r115.iterator();
    L17:
        if (r116.hasNext() == false) goto L35;
        w r102 = (w) r116.next();
        d0 r103 = this.f561973l;
        if (r103 == null) goto L17;
        List<w> r104 = r103.f295059a;
        if (r104 == null) goto L17;
        Iterator<T> r105 = r104.iterator();
        int r106 = 0;
    L24:
        if (r105.hasNext() == false) goto L17;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        w r109 = (w) r107;
        if (Intrinsics.areEqual(r109.f295510a, r102.f295510a) == false) goto L33;
        r109.f295528s = 1;
        d0 r117 = this.f561973l;
        if (r117 == null) goto L34;
        r117.f295060b = Integer.valueOf(r106);
    L34:
        r106 = r108;
        goto L24
    L33:
        r109.f295528s = 0;
    L35:
        bq8.a r118 = r114.f295063e;
        if (r118 == null) goto L38;
        this.f561974m = r118;
    L38:
        d0 r119 = this.f561973l;
        if (r119 == null) goto L54;
        List<w> r120 = r119.f295059a;
        if (r120 == null) goto L54;
        r100 = new ArrayList();
        Iterator<T> r121 = r120.iterator();
    L44:
        if (r121.hasNext() == false) goto L54;
        Object r122 = r121.next();
        Integer r123 = ((w) r122).f295528s;
        if (r123 != null) goto L49;
    L51:
        boolean r124 = false;
    L52:
        if (r124 == false) goto L44;
        r100.add(r122);
        goto L44
    L49:
        if (r123.intValue() != 1) goto L51;
        r124 = true;
    L54:
        if (r100 != null) goto L56;
    L59:
        boolean r125 = true;
    L60:
        if (r125 == true) goto L91;
        u r126 = this.f551062b;
        if (r126 == null) goto L69;
        Integer r127 = r126.f295474a;
        if (r127 == null) goto L69;
        if (r127.intValue() != 1) goto L69;
        r101 = true;
    L69:
        if (r101 == false) goto L92;
        c r128 = this.f551063c;
        if (r128 == null) goto L93;
        r128.setImageStyleRadioSelected(true);
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L56:
        if (r100.isEmpty() == true) goto L59;
        r125 = false;
    L5:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
