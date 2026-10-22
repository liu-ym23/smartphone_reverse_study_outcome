package q66;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f531804b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f531805a;

    /* JADX INFO: renamed from: q66.a$a, reason: collision with other inner class name */
    public static final class C7285a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"containerID", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "containerIDs"});
    }

    public a() {
    }
}
