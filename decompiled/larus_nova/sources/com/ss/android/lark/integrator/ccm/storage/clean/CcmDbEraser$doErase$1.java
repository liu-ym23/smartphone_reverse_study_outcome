package com.ss.android.lark.integrator.ccm.storage.clean;

import android.content.Context;
import ay4.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.suite.lark.platform.component.storage.clean.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/suite/lark/platform/component/storage/clean/ResourceEraser$EraserResult;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CcmDbEraser$doErase$1 extends Lambda implements Function0<m.a> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CcmDbResource $resource;

    public CcmDbEraser$doErase$1(CcmDbResource r100, Context r101) {
        this.$resource = r100;
        this.$context = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final m.a invoke() {
        CcmDbResource r100 = this.$resource;
        Context r101 = this.$context;
        String r102 = r100.getUseId() + "_encrypted_" + r100.getSourceName();
        String r103 = r100.getUseId() + '_' + r100.getSourceName();
        boolean r104 = true;
        String[] r105 = r101.databaseList();     // Catch: Throwable -> L24
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L24
        int r107 = r105.length;     // Catch: Throwable -> L24
        int r110 = 0;
    L4:
        if (r110 >= r107) goto L15;
        String r111 = r105[r110];     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L24
        if (StringsKt.contains$default(r111, r102, false, 2, null) == false) goto L8;
    L11:
        boolean r112 = true;
    L12:
        if (r112 == false) goto L14;
        r106.add(r111);     // Catch: Throwable -> L24
    L14:
        r110 = r110 + 1;     // Catch: Throwable -> L24
        goto L4
    L8:
        if (StringsKt.contains$default(r111, r103, false, 2, null) == true) goto L11;
        r112 = false;
        goto L12
    L15:
        Iterator r108 = r106.iterator();     // Catch: Throwable -> L24
    L16:
        if (r108.hasNext() == false) goto L26;
        String r109 = (String) r108.next();     // Catch: Throwable -> L24
        if (r101.deleteDatabase(r109) == true) goto L16;
        if (d.a().B(r101.getDatabasePath(r109)).exists() == false) goto L16;
        tt5.a.h("CcmDbEraser", "delete " + r100.getSourceName() + " failed!");     // Catch: Throwable -> L24
        r104 = false;
    L26:
        if (r104 == false) goto L29;
        int r113 = m.a.f460609h;
        String r114 = "ccm db eraser success: " + r100.getSourceName();
        Intrinsics.checkNotNullParameter(r114, "message");
        return new m.a(true, null, r114, 0, null, 120);
    L29:
        return new m.a(false, null, "ccm db eraser failed", 0, null, 122);
    L24:
        th = move-exception;
        tt5.a.j("CcmDbEraser", th);
        goto L26
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ m.a invoke() {
        return invoke();
    }
}
