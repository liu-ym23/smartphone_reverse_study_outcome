package wc1;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f559066a;

    public c() {
        this.f559066a = new ArrayList();
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        ((ArrayList) this.f559066a).add(r100);
    }
}
