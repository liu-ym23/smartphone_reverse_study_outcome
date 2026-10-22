package nk4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<?> f519480a;

    @Override // nk4.b
    public final String a() {
        return "trigger";
    }

    public c(List<?> r100) {
        if (r100 != null) goto L5;
        this.f519480a = Collections.emptyList();
        return;
    L5:
        this.f519480a = Collections.unmodifiableList(new ArrayList(r100));
    }
}
