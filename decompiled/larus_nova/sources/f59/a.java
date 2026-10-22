package f59;

import com.larus.avlink.api.model.QuickNoteAction;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteItemState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f475658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QuickNoteItemState f475659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f475660c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f475658a, r101.f475658a) == true) goto L12;
        return false;
    L12:
        if (this.f475659b == r101.f475659b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f475660c, r101.f475660c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f475658a.hashCode() * 31) + this.f475659b.hashCode()) * 31) + this.f475660c.hashCode();
    }

    public final String toString() {
        return "QuickNoteItemConfig(key=" + this.f475658a + ", state=" + this.f475659b + ", action=" + this.f475660c + ')';
    }

    public static a a(a r100, QuickNoteItemState r101) {
        String r102 = r100.f475658a;
        String r103 = r100.f475660c;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r103, "action");
        return new a(r102, r101, r103);
    }

    public a(String r100, QuickNoteItemState r101, @QuickNoteAction String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "action");
        this.f475658a = r100;
        this.f475659b = r101;
        this.f475660c = r102;
    }
}
