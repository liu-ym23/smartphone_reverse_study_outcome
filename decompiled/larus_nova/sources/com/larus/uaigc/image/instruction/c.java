package com.larus.uaigc.image.instruction;

import android.content.Context;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
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

/* JADX INFO: loaded from: classes31.dex */
public final class c extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f373084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TemplateInfo$TemplateInfo f373085m;

    @Override // up8.b
    public int getType() {
        return 11;
    }

    @Override // up8.d
    public final boolean a() {
        n r100 = this.f373084l;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295325c, Boolean.TRUE);
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
        TemplateInfo$TemplateInfo r100 = this.f373085m;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r100.f365416a);
    }

    @Override // up8.d
    public final String g() {
        n r100 = this.f373084l;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<w> r102 = r100.f295323a;
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
        n r109 = this.f373084l;
        if (r109 == null) goto L29;
        n r110 = n.d(r109, r104, this.f373085m);
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L32
        Object r112 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(n.Companion.serializer()), r110));     // Catch: Throwable -> L32
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

    public c() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ImageListSelectorWithMoreTemplateWidget(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionDefaultParams");
        Object r101 = r100.get(String.valueOf(getType()));
        if ((r101 instanceof Map) == false) goto L5;
        Map r102 = (Map) r101;
    L6:
        if (r102 == null) goto L9;
        Object r103 = r102.get(null);
        if (r103 == null) goto L9;
    L13:
        if ((r103 instanceof Map) == false) goto L15;
        Map r104 = (Map) r103;
    L16:
        if (r104 == null) goto L37;
        Object r105 = r104.get("default_select_id");
        if (r105 == null) goto L44;
        FLogger.f375446a.d("ImageListSelectorWithMoreTemplateController", "onReStoreComponentStateByDefaultParams: select:" + r105);
        n r106 = this.f373084l;
        if (r106 == null) goto L45;
        List<w> r107 = r106.f295323a;
        if (r107 == null) goto L46;
        Iterator<T> r108 = r107.iterator();
    L25:
        if (r108.hasNext() == false) goto L47;
        w r109 = (w) r108.next();
        Long r110 = r109.f295510a;
        if (r110 == null) goto L29;
        String r111 = r110.toString();
    L31:
        if (Intrinsics.areEqual(r111, r105) == true) goto L32;
        r109.f295528s = 0;
        goto L25
    L32:
        r109.f295528s = 1;
        com.larus.bmhome.view.actionbar.edit.c r112 = this.f551063c;
        if (r112 == null) goto L35;
        r112.setImageStyleRadioSelected(true);
    L35:
        FLogger.f375446a.d("ImageListSelectorWithMoreTemplateController", "hit restore by default params option  id:" + ((String) r105) + ", option name:" + r109.f295511b);
        goto L25
    L29:
        r111 = null;
        goto L31
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L37:
        return;
    L15:
        r104 = null;
    L9:
        if (r102 == null) goto L11;
        r103 = r102.get("match_all_id");
        goto L13
    L11:
        r103 = null;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // up8.b
    public final a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((n) xt7.d.f565073b.c(n.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L24;
        n r105 = (n) r103;
        this.f373084l = r105;
        if (r105 == null) goto L20;
        TemplateInfo$TemplateInfo r106 = r105.f295327e;
    L21:
        this.f373085m = r106;
        return new a0(Boolean.TRUE, "");
    L20:
        r106 = null;
        goto L21
    L24:
        return new a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new a0(Boolean.FALSE, "image list selector is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // up8.b
    public final void k(String r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, "defaultStateTemplate");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl((n) xt7.d.f565073b.c(n.Companion.serializer(), r210));     // Catch: Throwable -> L5
    L7:
        String r102 = null;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        n r103 = (n) r101;
        if (r103 != null) goto L13;
        return;
    L13:
        com.larus.bmhome.view.actionbar.edit.c r104 = this.f551063c;
        if (r104 == null) goto L22;
        List<w> r105 = r103.f295323a;
        if (r105 == null) goto L20;
        w r106 = (w) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L20;
        Long r107 = r106.f295510a;
    L21:
        r104.setDefaultSelectedImageStyleId(r107);
    L20:
        r107 = null;
    L22:
        List<w> r108 = r103.f295323a;
        if (r108 == null) goto L41;
        Iterator<T> r109 = r108.iterator();
    L26:
        if (r109.hasNext() == false) goto L41;
        w r110 = (w) r109.next();
        n r111 = this.f373084l;
        if (r111 == null) goto L26;
        List<w> r112 = r111.f295323a;
        if (r112 == null) goto L26;
        Iterator<T> r113 = r112.iterator();
    L33:
        if (r113.hasNext() == false) goto L26;
        w r114 = (w) r113.next();
        if (Intrinsics.areEqual(r114.f295510a, r110.f295510a) == true) goto L36;
        r114.f295528s = 0;
        goto L33
    L36:
        r114.f295528s = 1;
        com.larus.bmhome.view.actionbar.edit.c r115 = this.f551063c;
        if (r115 == null) goto L39;
        r115.setImageStyleRadioSelected(true);
    L39:
        FLogger.f375446a.d("ImageListSelectorWithMoreTemplateController", "hit restore option id:" + r110.f295510a + ", option name:" + r114.f295511b);
    L41:
        TemplateInfo$TemplateInfo r116 = r103.f295327e;
        if (r116 == null) goto L79;
        long r117 = r116.f365416a;
        TemplateInfo$TemplateImage r118 = r116.f365420e;
        if (r118 == null) goto L46;
        String r119 = r118.f365410a;
    L47:
        long r120 = 0;
        if (r118 == null) goto L50;
        long r121 = r118.f365411b;
    L51:
        if (r118 == null) goto L53;
        long r122 = r118.f365412c;
    L54:
        TemplateInfo$TemplateImage r123 = new TemplateInfo$TemplateImage(r119, r121, r122);
        TemplateInfo$TemplateImage r124 = r116.f365419d;
        if (r124 == null) goto L57;
        r102 = r124.f365410a;
    L57:
        String r125 = r102;
        if (r124 == null) goto L60;
        long r126 = r124.f365411b;
    L61:
        if (r124 == null) goto L63;
        r120 = r124.f365412c;
    L63:
        this.f373085m = new TemplateInfo$TemplateInfo(r117, null, new TemplateInfo$TemplateImage(r125, r126, r120), r123, null, 0, 0, 0, null, 998);
        return;
    L60:
        r126 = 0;
        goto L61
    L53:
        r122 = 0;
        goto L54
    L50:
        r121 = 0;
        goto L51
    L46:
        r119 = null;
        goto L47
    L79:
        return;
    L5:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
