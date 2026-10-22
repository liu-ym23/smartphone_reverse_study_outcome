package rob;

import com.larus.nova.R;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SwitchActionItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f538817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f538819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SwitchActionItemId f538820d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f538817a == r101.f538817a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538818b, r101.f538818b) == true) goto L15;
        return false;
    L15:
        if (this.f538819c == r101.f538819c) goto L18;
        return false;
    L18:
        if (this.f538820d == r101.f538820d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f538817a * 31) + this.f538818b.hashCode()) * 31;
        if (this.f538819c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f538820d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SwitchActionData(iconRes=" + this.f538817a + ", title=" + this.f538818b + ", checked=" + this.f538819c + ", itemId=" + this.f538820d + ')';
    }

    public j(String r100, boolean r101, SwitchActionItemId r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "itemId");
        this.f538817a = R.drawable.ud_icon_orde_list_outlined;
        this.f538818b = r100;
        this.f538819c = r101;
        this.f538820d = r102;
    }
}
