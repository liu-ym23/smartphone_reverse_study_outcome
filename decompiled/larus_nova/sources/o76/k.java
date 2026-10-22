package o76;

import android.content.res.AssetFileDescriptor;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.common.PlayModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AssetFileDescriptor f522277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PlayModel f522278e;

    public k() {
        this(null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f522274a, r101.f522274a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522275b, r101.f522275b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522276c, r101.f522276c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f522277d, r101.f522277d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522278e, r101.f522278e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f522274a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f522275b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f522276c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        AssetFileDescriptor r110 = this.f522277d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PlayModel r113 = this.f522278e;
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
        return "PlayerModel(playUrl=" + this.f522274a + ", localFilePath=" + this.f522275b + ", cacheKey=" + this.f522276c + ", assetFd=" + this.f522277d + ')';
    }

    public k(String r100, String r101, PlayModel r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 16) == 0) goto L11;
        r102 = null;
    L11:
        this.f522274a = r100;
        this.f522275b = r101;
        this.f522276c = null;
        this.f522277d = null;
        this.f522278e = r102;
    }
}
