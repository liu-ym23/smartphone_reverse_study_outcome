package n7c;

import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f518234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OperationToastHelper.ToastType f518235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f518236c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f518234a == r101.f518234a) goto L12;
        return false;
    L12:
        if (this.f518235b == r101.f518235b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f518236c, r101.f518236c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f518234a * 31) + this.f518235b.hashCode()) * 31;
        String r101 = this.f518236c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TodoListToastUnit(stringId=" + this.f518234a + ", type=" + this.f518235b + ", toastStr=" + this.f518236c + ')';
    }

    public final OperationToastHelper.ToastType getType() {
        return this.f518235b;
    }

    public a(int r100, OperationToastHelper.ToastType r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f518234a = r100;
        this.f518235b = r101;
        this.f518236c = r102;
    }
}
