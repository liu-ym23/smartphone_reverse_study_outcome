package com.enroll.audio.enroll.recorder;

import com.enroll.audio.enroll.vm.EnrollViewModel;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f273772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnrollViewModel f273773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f273774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ByteArrayOutputStream f273775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f273776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ct7.a f273777f;

    /* JADX INFO: renamed from: com.enroll.audio.enroll.recorder.a$a, reason: collision with other inner class name */
    public static final class C3829a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f273772a == r101.f273772a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f273773b, r101.f273773b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f273772a * 31) + this.f273773b.hashCode();
    }

    public final String toString() {
        return "RecordItem(index=" + this.f273772a + ", viewModel=" + this.f273773b + ')';
    }

    public a(int r100, EnrollViewModel r101) {
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        this.f273772a = r100;
        this.f273773b = r101;
        this.f273775d = new ByteArrayOutputStream();
        this.f273776e = new byte[0];
    }
}
