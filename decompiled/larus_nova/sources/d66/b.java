package d66;

import com.bytedance.ies.xbridge.XReadableMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f467206c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f467207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public XReadableMap f467208b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"eventName", "params"});
    }

    public b() {
    }
}
