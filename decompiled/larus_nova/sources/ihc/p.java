package ihc;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f489949b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f489950c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f489951d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f489952e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f489953f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p f489954g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489955a;

    public static final class a {
    }

    static {
        f489949b = new p(PullConfiguration.PROCESS_NAME_MAIN);
        f489950c = new p("push");
        f489951d = new p("external");
        f489952e = new p("background");
        f489953f = new p(RNParamRegisterEventHandler.SRC_INNER);
        f489954g = new p("unknown");
    }

    public final int hashCode() {
        return this.f489955a.hashCode();
    }

    public final String toString() {
        return this.f489955a;
    }

    public p(String r100) {
        this.f489955a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof p) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f489955a, ((p) r100).f489955a) == false) goto L7;
        return true;
    }
}
