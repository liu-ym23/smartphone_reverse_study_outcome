package nwb;

import com.ss.android.lark.chat.component.task.SetLoginChatterTask;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class c implements b {
    @Inject
    public c() {
    }

    @Override // nwb.b
    public final List<j0c.b> a() {
        j0c.b r100 = zoc.b.f573170b;
        j0c.b r101 = SetLoginChatterTask.f414712b;
        return CollectionsKt.listOf(new j0c.b[]{zoc.b.f573170b, SetLoginChatterTask.f414712b});
    }
}
