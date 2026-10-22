package lja;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f509511c;

    public a() {
        this.f509511c = "BasicRoundCornerImpl";
    }

    @Override // lja.d
    public String getType() {
        return this.f509511c;
    }

    @Override // lja.d
    public final Path a(float r100, float r101, float r102, float r103, float r104) {
        return d.b(r100, r101, r102, r103, r104);
    }

    @Override // lja.d
    public final void d(Canvas r100, Paint r110, float r111, float r112, float r113, float r114, float r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "paint");
        r100.drawRoundRect(r111, r112, r113, r114, r115, r115, r110);
    }
}
