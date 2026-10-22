package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.bytedance.lark.pb.todo.v1.TodoSource;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f443872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TodoSource f443873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f443874c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f443872a == r101.f443872a) goto L12;
        return false;
    L12:
        if (this.f443873b == r101.f443873b) goto L15;
        return false;
    L15:
        if (this.f443874c == r101.f443874c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f443872a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        TodoSource r103 = this.f443873b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f443874c == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DescriptionInfo(isComplete=" + this.f443872a + ", todoSource=" + this.f443873b + ", editable=" + this.f443874c + ')';
    }

    public e(boolean r100, TodoSource r101, boolean r102) {
        this.f443872a = r100;
        this.f443873b = r101;
        this.f443874c = r102;
    }
}
