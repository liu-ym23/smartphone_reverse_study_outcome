package d4a;

import com.larus.audio.call.mgr.AVKitCoreStates$Invalid;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.c1;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f466879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<Pair<Integer, Integer>> f466880b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableSharedFlow<Pair<Pair<MajorState, Integer>, Pair<MajorState, Integer>>> f466881c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final StateFlowImpl f466882d = null;

    public b() {
    }

    static {
        f466879a = new b();
        f466880b = SharedFlowKt.MutableSharedFlow$default(1, 1, null, 4, null);
        f466881c = SharedFlowKt.MutableSharedFlow$default(1, 1, null, 4, null);
        f466882d = j1.a(TuplesKt.to(new AVKitDuplexState(new AVKitCoreStates$Invalid(), new AVKitCoreStates$Invalid()), -1));
    }

    @Override // com.larus.audio.call.plugins.c1
    public final MutableSharedFlow W() {
        return f466881c;
    }

    @Override // com.larus.audio.call.plugins.c1
    public final MutableSharedFlow i1() {
        return f466880b;
    }

    @Override // com.larus.audio.call.plugins.c1
    public final i1<Pair<AVKitDuplexState, Integer>> y() {
        return f466882d;
    }
}
