package fy8;

import com.larus.canvas.feature.component.instruction.model.UIInstructionTab;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<UIInstructionTab> f479306c;

    public e() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f479304a, r101.f479304a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479305b, r101.f479305b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479306c, r101.f479306c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f479304a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f479305b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.f479306c.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasEditorUIData(prompt=" + this.f479304a + ", hint=" + this.f479305b + ", uiInstructionTabList=" + this.f479306c + ')';
    }

    public e(String r100, List r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        Intrinsics.checkNotNullParameter(r101, "uiInstructionTabList");
        this.f479304a = r100;
        this.f479305b = null;
        this.f479306c = r101;
    }
}
