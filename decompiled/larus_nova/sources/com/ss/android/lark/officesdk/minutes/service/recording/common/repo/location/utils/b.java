package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.h;
import com.ss.android.lark.location.service.k;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingLocationHelper f435025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<POIInfo, Unit> f435026b;

    @Override // com.ss.android.lark.location.service.h.b
    public final void a(k r100) {
        this.f435026b.invoke(null);
        lvb.a.e(this.f435025a.f435005b, "[getPOIInfo] onSearResultError, errorCode=" + r100.f431208b);
    }

    @Override // com.ss.android.lark.location.service.h.b
    public final void b(List<POIInfo> r100) {
        String r101 = this.f435025a.f435005b;
        StringBuilder r102 = new StringBuilder("[getPOIInfo] success list size=");
        POIInfo r103 = null;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.size());
    L6:
        r102.append(r104);
        r102.append(' ');
        lvb.a.e(r101, r102.toString());
        Function1<POIInfo, Unit> r105 = this.f435026b;
        if (r100 == null) goto L9;
        r103 = (POIInfo) CollectionsKt.firstOrNull(r100);
    L9:
        r105.invoke(r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(MmRecordingLocationHelper r100, Function1<? super POIInfo, Unit> r101) {
        this.f435025a = r100;
        this.f435026b = r101;
    }
}
