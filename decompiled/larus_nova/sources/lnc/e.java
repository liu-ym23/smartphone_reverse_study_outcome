package lnc;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements com.suite.component.logger.api.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Map<String, String> f510080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile List<String> f510081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Regex> f510082c;

    public e(int r100) {
        this.f510080a = null;
        this.f510081b = null;
        this.f510082c = new ConcurrentHashMap();
    }

    @Override // com.suite.component.logger.api.d
    public final void a(com.suite.component.logger.api.d.a r100, com.suite.component.logger.b r101, com.suite.component.logger.c r102) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "entity");
        Map<String, String> r103 = this.f510080a;
        if (r103 == null) goto L20;
        String r104 = r103.get(r102.f460116b);
        if (r104 == null) goto L20;
        if (r104.length() != 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L19;
        ConcurrentHashMap<String, Regex> r106 = this.f510082c;
        Regex r107 = r106.get(r104);
        if (r107 != null) goto L18;
        r107 = new Regex(r104);
        Regex r108 = r106.putIfAbsent(r104, r107);
        if (r108 == null) goto L18;
        r107 = r108;
    L18:
        if (r107.containsMatchIn(r102.f460117c) == false) goto L20;
        return;
    L19:
        return;
    L9:
        r105 = false;
    L20:
        List<String> r109 = this.f510081b;
        if (r109 == null) goto L34;
        Iterator<T> r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L34;
        String r111 = (String) r110.next();
        ConcurrentHashMap<String, Regex> r112 = this.f510082c;
        Regex r113 = r112.get(r111);
        if (r113 != null) goto L32;
        r113 = new Regex(r111);
        Regex r114 = r112.putIfAbsent(r111, r113);
        if (r114 == null) goto L32;
        r113 = r114;
    L32:
        if (r113.containsMatchIn(r102.f460117c) == false) goto L24;
        return;
    L34:
        r100.a(r101, r102);
    }
}
