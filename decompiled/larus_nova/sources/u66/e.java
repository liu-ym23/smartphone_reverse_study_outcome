package u66;

import com.bytedance.ies.xbridge.t;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f548937d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f548938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f548939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f548940c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"key", "data", "biz"});
    }

    public e() {
    }
}
