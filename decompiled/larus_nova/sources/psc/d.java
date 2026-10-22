package psc;

import android.text.NoCopySpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements NoCopySpan, lw8.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f530599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f530600d;

    @Override // lw8.f
    public final String a() {
        return this.f530597a;
    }

    @Override // lw8.f
    public final String getCode() {
        return this.f530598b;
    }

    public d(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "codeInfo");
        Intrinsics.checkNotNullParameter(r101, "code");
        this.f530597a = r100;
        this.f530598b = r101;
        this.f530599c = r102;
        this.f530600d = r103;
    }
}
