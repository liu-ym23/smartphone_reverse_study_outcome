package hn1;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f486074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends is2.c> f486075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EndReason f486076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ls2.e f486077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, ? extends Object> f486078e;

    public final void a() {
        if (this.f486074a < this.f486075b.size()) goto L5;
        return;
    L5:
        is2.c r100 = (is2.c) ListProtector.get(this.f486075b, this.f486074a);
        int r101 = this.f486074a + 1;
        this.f486074a = r101;
        r100.sE(new a(r101, this.f486075b, this.f486076c, this.f486077d, this.f486078e));
    }

    public a(int r100, List<? extends is2.c> r101, EndReason r102, ls2.e r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        Intrinsics.checkNotNullParameter(r102, "endReason");
        this.f486074a = r100;
        this.f486075b = r101;
        this.f486076c = r102;
        this.f486077d = r103;
        this.f486078e = r104;
    }
}
