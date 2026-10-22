package yz6;

import android.net.Uri;
import com.lynx.tasm.LynxGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements com.bytedance.lynx.service.model.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxGroup f569543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f569544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f569545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f569546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f569547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f569548f;

    public a() {
        this(0);
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void d() {
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void e() {
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void f() {
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void h() {
    }

    public final int hashCode() {
        int r100 = 0;
        int r101 = 0 * 31;
        LynxGroup r102 = this.f569543a;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        int r104 = (r101 + r103) * 31;
        String r105 = this.f569544b;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        b r108 = this.f569545c;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (((r107 + r109) * 31) + 0) * 31;
        Uri r111 = this.f569546d;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f569547e;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f569548f;
        if (r117 == null) goto L26;
        r100 = r117.hashCode();
    L26:
        return r116 + r100;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void i() {
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void j() {
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void k() {
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void n() {
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void o() {
    }

    public final String toString() {
        return "LynxKitInitParams(initData=null, lynxGroup=" + this.f569543a + ", lynxGroupName=" + this.f569544b + ", resourceLoaderCallback=" + this.f569545c + ", kitBridgeService=null, loadUri=" + this.f569546d + ", presetHeightSpec=" + this.f569547e + ", presetWidthSpec=" + this.f569548f + ")";
    }

    @Override // com.bytedance.lynx.service.model.a
    public final Uri g() {
        return this.f569546d;
    }

    public a(int r100) {
        this.f569543a = null;
        this.f569544b = null;
        this.f569545c = null;
        this.f569546d = null;
        this.f569547e = null;
        this.f569548f = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f569543a, r101.f569543a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f569544b, r101.f569544b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f569545c, r101.f569545c) == false) goto L29;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f569546d, r101.f569546d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f569547e, r101.f569547e) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f569548f, r101.f569548f) == true) goto L34;
        return false;
    L34:
        return true;
    L29:
        return false;
    L22:
        return false;
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void l(Integer r100) {
        this.f569547e = r100;
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void m(Integer r100) {
        this.f569548f = r100;
    }

    @Override // com.bytedance.lynx.service.model.a
    public final void p(Uri r100) {
        this.f569546d = r100;
    }
}
