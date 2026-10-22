package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.api.model.FlowDoraVisionConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes27.dex */
public final class z implements qk4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VisionService f338022a;

    @Override // qk4.j
    public final /* synthetic */ void f(byte[] r100) {
    }

    public z(VisionService r100) {
        this.f338022a = r100;
    }

    @Override // qk4.j
    public final void c(byte[] r100) {
        this.f338022a.getClass();
        FlowDoraVideoRecordConfig r101 = VisionService.i(r100);
        if (r101 == null) goto L8;
        Iterator<h49.g> r102 = this.f338022a.f337989a.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        r102.next().a(r101);
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [h49.g] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    @Override // qk4.j
    public final void h(byte[] r110) {
        this.f338022a.getClass();
        if (r110 != null) goto L5;
    L18:
        ?? r100 = CollectionsKt.emptyList();
    L19:
        boolean r111 = !((Collection) r100).isEmpty();
        ?? r101 = r100;
        if (r111 == true) goto L23;
        r101 = 0;
    L23:
        if (r101 == 0) goto L28;
        Iterator<h49.g> r112 = this.f338022a.f337989a.iterator();
    L26:
        if (r112.hasNext() == false) goto L31;
        r112.next().b(r101);
        goto L26
    L31:
        return;
    L28:
        return;
    L5:
        if (r110.length != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L18;
        if ((r110.length % 12) != 0) goto L18;
        r100 = new ArrayList();
        int r103 = ProgressionUtilKt.getProgressionLastElement(0, r110.length - 1, 12);
        if (r103 < 0) goto L19;
        int r104 = 0;
    L15:
        byte r105 = r110[r104];
        int r106 = VisionService.o(new byte[]{r110[r104 + 1], r110[r104 + 2]});
        int r107 = VisionService.o(new byte[]{r110[r104 + 3], r110[r104 + 4]});
        byte r108 = r110[r104 + 5];
        byte r109 = r110[r104 + 6];
        byte r113 = r110[r104 + 7];
        byte r114 = r110[r104 + 8];
        byte r115 = r110[r104 + 9];
        FloatCompanionObject r116 = FloatCompanionObject.INSTANCE;
        r100.add(new FlowDoraVisionConfig(r105, r106, r107, r108, Float.intBitsToFloat((r109 & UByte.MAX_VALUE) | (((r113 & UByte.MAX_VALUE) << 8) | (((r114 & UByte.MAX_VALUE) << 16) | ((r115 & UByte.MAX_VALUE) << 24)))), r110[r104 + 10], r110[r104 + 11]));
        if (r104 == r103) goto L19;
        r104 = r104 + 12;
        goto L15
    L7:
        r102 = false;
        goto L8
    }
}
