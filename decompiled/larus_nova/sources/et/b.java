package et;

import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.component.c;
import com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.d;
import com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f473846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f473847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f473848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f473849k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f473846h, r101.f473846h) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f473847i, r101.f473847i) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f473848j, r101.f473848j) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473849k, r101.f473849k) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f473846h;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d r104 = this.f473847i;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.f473848j;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f473849k;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameBetaTestDownloadButtonItemProps(buttonID=" + this.f473846h + ", buttonData=" + this.f473847i + ", buttonStyle=" + this.f473848j + ", buttonCommonData=" + this.f473849k + ")";
    }

    public b(String r100, d r110, i r111, h r112) {
        Intrinsics.checkNotNullParameter(r100, "buttonID");
        super(r100, 22, r110, r111, r112, null);
        this.f473846h = r100;
        this.f473847i = r110;
        this.f473848j = r111;
        this.f473849k = r112;
    }
}
