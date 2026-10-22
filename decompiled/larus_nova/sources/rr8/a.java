package rr8;

import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f539034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IChatMessageShareAbility.ActionType f539035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f539036c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f539034a, r101.f539034a) == true) goto L12;
        return false;
    L12:
        if (this.f539035b == r101.f539035b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539036c, r101.f539036c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f539034a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f539035b.hashCode()) * 31;
        Map<String, Object> r104 = this.f539036c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MessageSelectStatus(selectMode=" + this.f539034a + ", action=" + this.f539035b + ", ext=" + this.f539036c + ')';
    }

    public a(Boolean r100, IChatMessageShareAbility.ActionType r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f539034a = r100;
        this.f539035b = r101;
        this.f539036c = r102;
    }
}
