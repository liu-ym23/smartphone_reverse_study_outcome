package mtb;

import com.ss.android.lark.officesdk.contact.api.model.DoubaoAddFriendSettingType;
import com.ss.android.lark.officesdk.contact.api.model.OfficeContactSettingsItemAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubaoAddFriendSettingType f515675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f515677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f515678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OfficeContactSettingsItemAction f515679e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f515675a == r101.f515675a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515676b, r101.f515676b) == true) goto L15;
        return false;
    L15:
        if (this.f515677c == r101.f515677c) goto L18;
        return false;
    L18:
        if (this.f515678d == r101.f515678d) goto L21;
        return false;
    L21:
        if (this.f515679e == r101.f515679e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f515675a.hashCode() * 31) + this.f515676b.hashCode()) * 31) + this.f515677c) * 31;
        if (this.f515678d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f515679e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeContactSettingsItem(id=" + this.f515675a + ", title=" + this.f515676b + ", iconName=" + this.f515677c + ", enabled=" + this.f515678d + ", action=" + this.f515679e + ')';
    }

    public f(DoubaoAddFriendSettingType r100, String r101, int r102, boolean r103, OfficeContactSettingsItemAction r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r104, "action");
        this.f515675a = r100;
        this.f515676b = r101;
        this.f515677c = r102;
        this.f515678d = r103;
        this.f515679e = r104;
    }
}
