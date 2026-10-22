package com.larus.canvas.feature.component.logic;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class t0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f323490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GenImagePlannerComponent f323491b;

    public /* synthetic */ t0(String r100, GenImagePlannerComponent r101) {
        this.f323490a = r100;
        this.f323491b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f323490a;
        GenImagePlannerComponent r101 = this.f323491b;
        int r102 = GenImagePlannerComponent.W;
        FLogger.f375446a.d("GenImagePlannerComponent", "onListSubmitRunnable trigger, localId = " + r100);
        Iterator<T> r103 = ((ky8.g) r101.f323252m.getValue()).f506706a.values().iterator();
        int r104 = -1;
        int r105 = 0;
    L3:
        boolean r106 = true;
        if (r103.hasNext() == false) goto L17;
        Object r107 = r103.next();
        if (r105 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ky8.h r108 = (ky8.h) r107;
        if ((r108 instanceof ky8.f) == true) goto L11;
    L13:
        r106 = false;
    L14:
        if (r106 == false) goto L16;
        r104 = r105;
    L16:
        r105 = r105 + 1;
        goto L3
    L11:
        if (Intrinsics.areEqual(((ky8.f) r108).f506697a, r100) == false) goto L13;
    L17:
        if (r104 < 0) goto L27;
        FLogger.f375446a.d("GenImagePlannerComponent", "onListSubmitRunnable - ScrollToPosition, " + r104 + ", localId = " + r100);
        com.larus.canvas.feature.component.resultdisplay.image.r r109 = r101.Z3();
        if (r109 == null) goto L26;
        r109.yS(new com.larus.canvas.feature.component.resultdisplay.image.t.a(r104, true));
        return;
    L26:
        return;
    }
}
