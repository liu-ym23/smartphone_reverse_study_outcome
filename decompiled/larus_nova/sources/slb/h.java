package slb;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f542530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Function2<String, String, Unit> f542531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<m> f542532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f542533e;

    public h() {
        throw null;
    }

    public final String toString() {
        return "OperateButton(key='" + this.f542529a + "', text='" + this.f542530b + "', callback=" + this.f542531c + ", promptGroups=" + this.f542532d + ')';
    }

    public h(String r100, String r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f542529a = r100;
        this.f542530b = r101;
        this.f542531c = r102;
        this.f542532d = null;
        this.f542533e = false;
    }
}
