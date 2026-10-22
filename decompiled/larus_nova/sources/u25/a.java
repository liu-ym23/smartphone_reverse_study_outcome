package u25;

import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f548459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<SubBlockModel> f548460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f548461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f548462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<a, Unit> f548463g;

    @Override // u25.c
    public final int a() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f548457a, this.f548458b});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L17;
        a r101 = (a) r100;
        if (this.f548457a.equals(r101.f548457a) == true) goto L13;
    L15:
        return false;
    L13:
        if (this.f548458b.equals(r101.f548458b) == false) goto L15;
        return true;
    }

    public a(String r100, String r101, List<SubBlockModel> r102, int r103, Function1<a, Unit> r104) {
        this.f548457a = r100;
        this.f548458b = r101;
        this.f548460d = r102;
        this.f548459c = r103;
        this.f548461e = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f548462f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f548463g = r104;
    }
}
