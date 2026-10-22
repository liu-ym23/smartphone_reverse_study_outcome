package z15;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes16.dex */
@Singleton
public final class c implements d {
    @Inject
    public c() {
    }

    @Override // z15.d
    public final List<e> a() {
        return CollectionsKt.listOf(new a());
    }
}
