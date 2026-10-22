package z61;

import com.bytedance.android.live.room.api.messagewindow.state.CardAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardAction f570441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.room.api.messagewindow.builder.card.b f570442b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f570441a, r101.f570441a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f570442b, r101.f570442b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        CardAction r100 = this.f570441a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r104 = this.f570442b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonCardEvent(action=" + this.f570441a + ", commonCard=" + this.f570442b + ")";
    }

    public a(CardAction r100, com.bytedance.android.live.room.api.messagewindow.builder.card.b r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "commonCard");
        this.f570441a = r100;
        this.f570442b = r101;
    }
}
