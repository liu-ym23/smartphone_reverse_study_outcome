package qi9;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f533205d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f533206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f533207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f533208c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"containerID", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "containerIDs"});
    }

    public c() {
    }
}
