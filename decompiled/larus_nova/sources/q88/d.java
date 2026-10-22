package q88;

import android.net.Uri;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadFilteredReason;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemStatus;
import com.larus.avatar.impl.upload.adapter.DigitalAvatarUploadItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DigitalAvatarUploadItemType f532037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DigitalAvatarUploadItemStatus f532038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f532039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f532040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f532041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f532042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DigitalAvatarUploadFilteredReason f532043g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f532037a == r101.f532037a) goto L12;
        return false;
    L12:
        if (this.f532038b == r101.f532038b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f532039c, r101.f532039c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f532040d, r101.f532040d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f532041e, r101.f532041e) == true) goto L24;
        return false;
    L24:
        if (this.f532042f == r101.f532042f) goto L27;
        return false;
    L27:
        if (this.f532043g == r101.f532043g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f532037a.hashCode() * 31) + this.f532038b.hashCode()) * 31;
        Uri r101 = this.f532039c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f532040d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f532041e.hashCode()) * 31;
        if (this.f532042f == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        DigitalAvatarUploadFilteredReason r110 = this.f532043g;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DigitalAvatarUploadItem(itemType=" + this.f532037a + ", uploadStatus=" + this.f532038b + ", imageUri=" + this.f532039c + ", imagePath=" + this.f532040d + ", imagePathKey=" + this.f532041e + ", isPreGenItem=" + this.f532042f + ", filteredReason=" + this.f532043g + ')';
    }

    public d(DigitalAvatarUploadItemType r100, DigitalAvatarUploadItemStatus r101, Uri r102, String r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r103 = "";
    L9:
        if ((r105 & 32) == 0) goto L11;
        r104 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Intrinsics.checkNotNullParameter(r101, "uploadStatus");
        Intrinsics.checkNotNullParameter(r103, "imagePathKey");
        this.f532037a = r100;
        this.f532038b = r101;
        this.f532039c = r102;
        this.f532040d = null;
        this.f532041e = r103;
        this.f532042f = r104;
        this.f532043g = null;
    }
}
