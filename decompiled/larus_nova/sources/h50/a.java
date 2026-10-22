package h50;

import com.bytedance.android.live.core.gl.primitive.Axis;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements l50.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f483851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f483852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f483853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f483854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f483855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Axis f483856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f483857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f483858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f483859i;

    @Override // l50.b
    public final boolean isFinished() {
        return this.f483852b;
    }

    public a(Axis r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "axis");
        this.f483856f = r100;
        this.f483857g = r101;
        this.f483858h = r102;
        this.f483859i = 1000.0f;
    }

    @Override // l50.b
    public final boolean a(f r100, d r101, n50.b r102) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        Intrinsics.checkNotNullParameter(r101, "modelParams");
        Intrinsics.checkNotNullParameter(r102, "sceneParams");
        if (this.f483854d == true) goto L7;
        r101.f512077c.e(this.f483856f, this.f483857g);
        this.f483855e = r100.f501813d;
        this.f483854d = true;
    L7:
        if (this.f483852b == false) goto L9;
        return true;
    L9:
        long r103 = r100.f501813d;
        float r104 = (r103 - this.f483855e) / this.f483859i;
        if (r104 >= 1.0f) goto L12;
        float r105 = this.f483857g;
        this.f483853c = r105 + ((this.f483858h - r105) * r104);
    L17:
        r101.f512077c.e(this.f483856f, this.f483853c);
        return this.f483852b;
    L12:
        if (this.f483851a == false) goto L14;
        this.f483853c = this.f483857g;
    L15:
        this.f483855e = r103;
        goto L17
    L14:
        this.f483853c = this.f483858h;
        this.f483852b = true;
        goto L15
    }
}
