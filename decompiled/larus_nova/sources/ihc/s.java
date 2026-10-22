package ihc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class s extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f489958b;

    public final int hashCode() {
        return Arrays.hashCode(new String[]{this.f489958b});
    }

    @Override // ihc.c
    public final String toString() {
        return this.f489932a + ":{destPageClassName = " + this.f489958b + '}';
    }

    public s(String r100) {
        super("SpecificDestPageMonitorMode");
        this.f489958b = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof s) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((s) r100).f489958b, this.f489958b) == false) goto L7;
        return true;
    }
}
