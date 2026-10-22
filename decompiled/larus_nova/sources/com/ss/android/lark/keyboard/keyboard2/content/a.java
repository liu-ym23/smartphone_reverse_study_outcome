package com.ss.android.lark.keyboard.keyboard2.content;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.keyboard.event.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IKeyboardContent.a f429526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IKeyboardContent.a f429527b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f429526a, r101.f429526a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f429527b, r101.f429527b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        IKeyboardContent.a r100 = this.f429526a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f429527b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "KeyboardContentChange(from=" + this.f429526a + ", to=" + this.f429527b + ')';
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        StringBuilder r100 = new StringBuilder("from=");
        IKeyboardContent.a r101 = this.f429526a;
        if (r101 == null) goto L5;
        String r102 = r101.getTag();
    L6:
        r100.append(r102);
        r100.append(",to=");
        r100.append(this.f429527b.getTag());
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public a(IKeyboardContent.a r100, IKeyboardContent.a r101) {
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        this.f429526a = r100;
        this.f429527b = r101;
    }
}
