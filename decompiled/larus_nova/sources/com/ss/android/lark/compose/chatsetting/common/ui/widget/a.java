package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageVector f417422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Brush f417423b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f417422a, r101.f417422a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417423b, r101.f417423b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f417422a.hashCode() * 31) + this.f417423b.hashCode();
    }

    public final String toString() {
        return "SettingIcon(icon=" + this.f417422a + ", backgroundBrush=" + this.f417423b + ')';
    }

    public a(ImageVector r100, Brush r101) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        Intrinsics.checkNotNullParameter(r101, "backgroundBrush");
        this.f417422a = r100;
        this.f417423b = r101;
    }
}
