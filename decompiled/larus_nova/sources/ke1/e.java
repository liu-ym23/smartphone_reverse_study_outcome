package ke1;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f503006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f503007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f503008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f503009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f503010e;

    public e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f503008c = r100;
        this.f503009d = r101;
        this.f503010e = r102;
        this.f503006a = new ArrayList();
    }
}
