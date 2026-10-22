package jt;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f500284c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f500282a, r101.f500282a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f500283b, r101.f500283b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f500284c, r101.f500284c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f500282a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f500283b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.f500284c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RowAttrProps(ID=" + this.f500282a + ", componentId=" + this.f500283b + ", attr=" + this.f500284c + ")";
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0, com.bytedance.ies.sve_list.a
    public int getType() {
        if (TextUtils.isEmpty(this.f500283b) == false) goto L6;
        return 100;
    L6:
        return d0.a.getType(this);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.d0
    public final String a() {
        return this.f500283b;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final String getId() {
        return this.f500282a;
    }

    @Override // com.bytedance.ies.sve_list.a
    public final boolean b(com.bytedance.ies.sve_list.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Intrinsics.areEqual(r100, this);
    }

    public b(String r100, String r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "ID");
        Intrinsics.checkNotNullParameter(r101, "componentId");
        this.f500282a = r100;
        this.f500283b = r101;
        this.f500284c = r102;
    }
}
