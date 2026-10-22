package iy6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Liy6/e;", "", "", "", "photos", "Ljava/util/List;", "b", "()Ljava/util/List;", "musicUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("music_url")
    private final String musicUrl;

    @SerializedName("photos")
    private final List<String> photos;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.photos, r101.photos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.musicUrl, r101.musicUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.photos;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.musicUrl;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiAlbum(photos=" + this.photos + ", musicUrl=" + this.musicUrl + ')';
    }

    public e() {
        this.photos = null;
        this.musicUrl = null;
    }

    public final String a() {
        return this.musicUrl;
    }

    public final List<String> b() {
        return this.photos;
    }
}
