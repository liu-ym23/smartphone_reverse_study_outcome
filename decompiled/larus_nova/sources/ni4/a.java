package ni4;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a<DATA, REGROUP_PARAM> extends com.ss.android.ugc.tools.repository.internal.fetcher.a<DATA, ki4.b0, Unit> implements ki4.j<DATA, REGROUP_PARAM> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<Object>, Function0<Object>> f519251d;

    public a(j r100, Map r101, ki4.b0 r102) {
        Intrinsics.checkNotNullParameter(r100, "broadcastSource");
        Intrinsics.checkNotNullParameter(r101, "processorProvider");
        Intrinsics.checkNotNullParameter(r102, "startCursor");
        super(r102);
        this.f519251d = r101;
        new LinkedHashMap();
    }
}
