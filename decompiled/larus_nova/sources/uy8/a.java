package uy8;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f552153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f552154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f552155c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f552153a, r101.f552153a) == true) goto L12;
        return false;
    L12:
        if (this.f552154b == r101.f552154b) goto L15;
        return false;
    L15:
        if (this.f552155c == r101.f552155c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f552153a.hashCode() * 31;
        int r101 = 1231;
        if (this.f552154b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f552155c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MobileAlbumFastInputExperimentConfig(enabledEntries=" + this.f552153a + ", quickInputAttachmentAddEnabled=" + this.f552154b + ", quickInputDataProtocolEnabled=" + this.f552155c + ')';
    }

    public a() {
        this(SetsKt.emptySet(), false, false);
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        if (this.f552155c == true) goto L5;
    L9:
        return false;
    L5:
        if (c.f552157a.contains(r100) == false) goto L9;
        if (this.f552153a.contains(r100) == false) goto L9;
        return true;
    }

    public a(Set<String> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "enabledEntries");
        this.f552153a = r100;
        this.f552154b = r101;
        this.f552155c = r102;
    }
}
