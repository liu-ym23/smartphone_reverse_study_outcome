package g76;

import android.content.res.AssetFileDescriptor;
import com.bytedance.ies.xelement.audiott.bean.PlayModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f480241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AssetFileDescriptor f480242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PlayModel f480243e;

    public a() {
        this(null, null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f480239a, r101.f480239a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480240b, r101.f480240b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f480241c, r101.f480241c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f480242d, r101.f480242d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f480243e, r101.f480243e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f480239a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f480240b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f480241c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        AssetFileDescriptor r110 = this.f480242d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PlayModel r113 = this.f480243e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PlayerModel(playUrl=" + this.f480239a + ", localFilePath=" + this.f480240b + ", cacheKey=" + this.f480241c + ", assetFd=" + this.f480242d + ')';
    }

    public a(String r100, String r101, String r102, AssetFileDescriptor r103, PlayModel r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = null;
    L17:
        this.f480239a = r100;
        this.f480240b = r101;
        this.f480241c = r102;
        this.f480242d = r103;
        this.f480243e = r104;
    }
}
