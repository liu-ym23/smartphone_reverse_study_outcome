package jr8;

import com.larus.bmhome.music.player.j;
import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f500139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MusicCreationContent f500140b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f500139a, r101.f500139a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500140b, r101.f500140b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f500139a.hashCode() * 31) + this.f500140b.hashCode();
    }

    public final String toString() {
        return "MusicContent(playerData=" + this.f500139a + ", creationContent=" + this.f500140b + ')';
    }

    public a(j r100, MusicCreationContent r101) {
        Intrinsics.checkNotNullParameter(r100, "playerData");
        Intrinsics.checkNotNullParameter(r101, "creationContent");
        this.f500139a = r100;
        this.f500140b = r101;
    }
}
