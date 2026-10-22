package ui9;

import com.bytedance.ies.xbridge.XReadableMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f550218b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public XReadableMap f550219a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{PerfLog.PARAM_KEY_CONTEXT_ID, "keepOpen"});
    }

    public c() {
    }

    public final XReadableMap getContext() {
        return this.f550219a;
    }
}
