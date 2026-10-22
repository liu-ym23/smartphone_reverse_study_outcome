package xp8;

import com.larus.im.internal.delegate.c0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public aq8.d f564742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f564743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, Map<String, com.larus.bmhome.instruction.core.impl.base.e>> f564744c;

    public static final class a {
    }

    static {
    }

    public final Map<String, com.larus.bmhome.instruction.core.impl.base.e> a(String r100) {
        if (r100 != null) goto L6;
        Map<String, com.larus.bmhome.instruction.core.impl.base.e> r101 = (Map) CollectionsKt.lastOrNull(this.f564744c.values());
        if (r101 == null) goto L11;
        return r101;
    L11:
        return MapsKt.emptyMap();
    L6:
        Map<String, com.larus.bmhome.instruction.core.impl.base.e> r102 = this.f564744c.get(r100);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return MapsKt.emptyMap();
    }

    public final void b(String r100) {
        LinkedHashMap<String, Map<String, com.larus.bmhome.instruction.core.impl.base.e>> r101 = this.f564744c;
        if (r100 != null) goto L5;
        r101.clear();
    L6:
        c0.f348199b.i("ProcessorContext", "[removePanelControllers] panelId:" + r100 + ", panelCount:" + this.f564744c.size());
        return;
    L5:
        r101.remove(r100);
        goto L6
    }

    public j(aq8.d r100, CoroutineScope r101) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        Intrinsics.checkNotNullParameter(r101, "scope");
        this.f564742a = r100;
        this.f564743b = r101;
        this.f564744c = new LinkedHashMap();
    }
}
