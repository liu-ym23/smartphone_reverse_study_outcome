package oea;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f523046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f523047c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f523045a, r101.f523045a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523046b, r101.f523046b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f523047c, r101.f523047c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f523045a.hashCode() * 31;
        Boolean r101 = this.f523046b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f523047c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "GRUpdateActionTitleEvent(action=" + this.f523045a + ", disabled=" + this.f523046b + ", text=" + this.f523047c + ')';
    }

    public a(String r100, Boolean r101) {
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L5;
        String r102 = AppHost.f326268a.getApplication().getString(R.string.obric_phone_operation_pro_live_card_in_reply);
        Intrinsics.checkNotNull(r102);
    L6:
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r102, "text");
        this.f523045a = r100;
        this.f523046b = r101;
        this.f523047c = r102;
        return;
    L5:
        r102 = AppHost.f326268a.getApplication().getString(R.string.obric_phone_operation_pro_live_card_reply);
        Intrinsics.checkNotNull(r102);
        goto L6
    }
}
