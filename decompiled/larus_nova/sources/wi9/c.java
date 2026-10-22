package wi9;

import com.bytedance.ies.xbridge.XReadableMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f559866e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f559867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f559868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f559869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public XReadableMap f559870d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"schema", "replace", "useSysBrowser", "extra"});
    }

    public c() {
    }
}
