package pza;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f531143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f531144d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f531141a, r101.f531141a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f531142b, r101.f531142b) == true) goto L15;
        return false;
    L15:
        if (this.f531143c == r101.f531143c) goto L18;
        return false;
    L18:
        if (this.f531144d == r101.f531144d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f531141a.hashCode() * 31) + this.f531142b.hashCode()) * 31) + this.f531143c) * 31;
        if (this.f531144d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "HumansChatSettingsItem(id=" + this.f531141a + ", title=" + this.f531142b + ", iconRes=" + this.f531143c + ", enabled=" + this.f531144d + ')';
    }

    public b(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter("humans_chat_setting", "id");
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f531141a = "humans_chat_setting";
        this.f531142b = r100;
        this.f531143c = R.drawable.doubao_setting_human_chat;
        this.f531144d = r101;
    }
}
