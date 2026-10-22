package px8;

import com.larus.camera.impl.entity.ResultBottomControlType;
import com.larus.camera.impl.entity.ResultSuggestType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResultBottomControlType f530953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResultSuggestType f530954b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f530953a == r101.f530953a) goto L12;
        return false;
    L12:
        if (this.f530954b == r101.f530954b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f530953a.hashCode() * 31;
        ResultSuggestType r101 = this.f530954b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResultBottomState(controlType=" + this.f530953a + ", suggestType=" + this.f530954b + ')';
    }

    public e(ResultBottomControlType r100, ResultSuggestType r101) {
        Intrinsics.checkNotNullParameter(r100, "controlType");
        this.f530953a = r100;
        this.f530954b = r101;
    }
}
