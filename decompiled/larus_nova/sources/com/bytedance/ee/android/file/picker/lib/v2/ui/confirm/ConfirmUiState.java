package com.bytedance.ee.android.file.picker.lib.v2.ui.confirm;

import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.larksuite.arch.jack.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class ConfirmUiState implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GroupEntity> f206094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f206095b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConfirmUiState) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f206094a, ((ConfirmUiState) r100).f206094a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f206094a.hashCode();
    }

    public final String toString() {
        return "ConfirmUiState(selectedFiles=" + this.f206094a + ')';
    }

    public ConfirmUiState(List<GroupEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedFiles");
        this.f206094a = r100;
        this.f206095b = LazyKt.lazy(new ConfirmUiState$title$2(this));
    }
}
