package xs8;

import android.content.Context;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.k0;
import com.larus.bmhome.actionbar.model.y1;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.TextListSelectorWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import wa8.a0;

/* JADX INFO: loaded from: classes26.dex */
public class o extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k0 f565034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f565035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f565036n;

    @Override // up8.b
    public int getType() {
        return 1;
    }

    @Override // up8.d
    public final boolean a() {
        k0 r100 = this.f565034l;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295266e, Boolean.TRUE);
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

    @Override // up8.d
    public final String g() {
        k0 r100 = this.f565034l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<y1> r102 = r100.f295264c;
        boolean r103 = false;
        if (r102 == null) goto L19;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        Integer r107 = ((y1) r106).f295583g;
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
        k0 r109 = this.f565034l;
        if (r109 == null) goto L32;
        if (r104 != null) goto L24;
    L27:
        boolean r110 = true;
    L28:
        if (r110 == false) goto L30;
        ArrayList r111 = null;
    L31:
        k0 r112 = k0.d(r109, r111);
    L33:
        if (r104 != null) goto L35;
    L36:
        r103 = true;
    L37:
        if (r103 == false) goto L44;
        k0 r113 = this.f565034l;
        if (r113 == null) goto L41;
        y1 r114 = r113.f295263b;
    L42:
        if (r114 != null) goto L44;
        return null;
    L41:
        r114 = null;
    L44:
        Gson r115 = (Gson) this.f551061a.getValue();
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L47
        Object r117 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(k0.Companion.serializer()), r112));     // Catch: Throwable -> L47
    L50:
        if (Result.m9455isFailureimpl(r117) == true) goto L53;
        r101 = r117;
    L53:
        String r118 = (String) r101;
        FLogger.f375446a.i(this.f565035m, "collectData, result=" + r118);
        return r118;
    L47:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L35:
        if (r104.isEmpty() == false) goto L37;
    L30:
        r111 = r104;
        goto L31
    L24:
        if (r104.isEmpty() == true) goto L27;
        r110 = false;
        goto L28
    L32:
        r112 = null;
        goto L33
    L19:
        r104 = null;
        goto L20
    }

    public o() {
        this.f565035m = "TextListSelectorController";
    }

    @Override // up8.b
    public final boolean j() {
        return this.f565036n;
    }

    @Override // up8.b
    public /* bridge */ /* synthetic */ AbsInstructionWidget e(Context r100) {
        return s(r100);
    }

    @Override // up8.b
    public final a0 n(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Gson r103 = (Gson) this.f551061a.getValue();
        List<y1> r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        k0 r106 = (k0) xt7.d.f565073b.c(kuc.a.d(k0.Companion.serializer()), r100);     // Catch: Throwable -> L21
        if (r106 != null) goto L16;
        r106 = null;
    L19:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 != null) goto L40;
        k0 r109 = (k0) r107;
        if (r109 == null) goto L28;
        r104 = r109.f295264c;
    L28:
        List<y1> r110 = r104;
        if (r110 != null) goto L31;
    L34:
        if (r101 == true) goto L36;
        this.f565034l = r109;
        return new a0(Boolean.TRUE, "");
    L36:
        return new a0(Boolean.FALSE, "text list option list is empty");
    L31:
        if (r110.isEmpty() == true) goto L34;
        r101 = false;
        goto L34
    L40:
        return new a0(Boolean.FALSE, r108.getMessage());
    L16:
        if (getType() != 13) goto L19;
        r106.f295265d = -1;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L11:
        return new a0(Boolean.FALSE, "text list selector is empty template");
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public TextListSelectorWidget s(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new TextListSelectorWidget(r100);
    }

    @Override // up8.b
    public final void k(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((k0) xt7.d.f565073b.c(k0.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L7:
        k0 r103 = null;
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        k0 r104 = (k0) r102;
        int r105 = -1;
        if (r104 != null) goto L13;
    L16:
        if (r103 != null) goto L18;
        return;
    L18:
        List<y1> r106 = r103.f295264c;
        if (r106 == null) goto L34;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L34;
        y1 r108 = (y1) r107.next();
        k0 r109 = this.f565034l;
        if (r109 == null) goto L22;
        List<y1> r111 = r109.f295264c;
        if (r111 == null) goto L22;
        Iterator<T> r112 = r111.iterator();
    L29:
        if (r112.hasNext() == false) goto L22;
        y1 r113 = (y1) r112.next();
        if (Intrinsics.areEqual(r113.f295577a, r108.f295577a) == true) goto L32;
        r113.f295583g = 0;
        goto L29
    L32:
        r113.f295583g = 1;
    L34:
        k0 r114 = this.f565034l;
        if (r114 == null) goto L51;
        List<y1> r115 = r114.f295264c;
        if (r115 == null) goto L51;
        Iterator<y1> r116 = r115.iterator();
        int r117 = 0;
    L40:
        if (r116.hasNext() == false) goto L51;
        Integer r118 = r116.next().f295583g;
        if (r118 != null) goto L45;
    L47:
        boolean r119 = false;
    L48:
        if (r119 == true) goto L49;
        r117 = r117 + 1;
        goto L40
    L49:
        r105 = r117;
        goto L51
    L45:
        if (r118.intValue() != 1) goto L47;
        r119 = true;
    L51:
        if (r105 < 0) goto L71;
        if (r110 == false) goto L72;
        this.f565036n = true;
        return;
    L72:
        return;
    L71:
        return;
    L13:
        if (getType() != 13) goto L15;
        r104.f295265d = -1;
    L15:
        r103 = r104;
    L5:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
