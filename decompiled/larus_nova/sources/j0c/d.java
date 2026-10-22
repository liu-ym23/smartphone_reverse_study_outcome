package j0c;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0c.b f496849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f496850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f0c.b> f496851c;

    public /* synthetic */ d(f0c.b r100, a r101) {
        this(r100, r101, new ArrayList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(f0c.b r100, a r101, List<? extends f0c.b> r102) {
        Intrinsics.checkNotNullParameter(r100, "globalState");
        Intrinsics.checkNotNullParameter(r101, "taskResult");
        Intrinsics.checkNotNullParameter(r102, "backgroundStateList");
        this.f496849a = r100;
        this.f496850b = r101;
        this.f496851c = r102;
    }
}
