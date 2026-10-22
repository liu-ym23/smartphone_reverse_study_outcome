package sp6;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f542883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f542884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f542885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f542886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f542887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Integer> f542888f;

    public c() {
        this.f542888f = new ArrayList();
    }

    public final void a(Canvas r110, Paint r111) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        int r100 = this.f542883a;
        int r101 = this.f542884b;
        float r102 = r100 + this.f542885c;
        float r103 = r101 + this.f542886d;
        int r104 = this.f542887e;
        r110.drawRoundRect(r100, r101, r102, r103, r104, r104, r111);
    }
}
