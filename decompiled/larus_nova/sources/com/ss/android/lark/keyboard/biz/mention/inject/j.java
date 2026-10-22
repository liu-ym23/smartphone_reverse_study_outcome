package com.ss.android.lark.keyboard.biz.mention.inject;

import com.ss.android.lark.keyboard.event.q;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f428465a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (this.f428465a == ((j) r100).f428465a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f428465a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "SetAtDoubaoTopSelected(selected=" + this.f428465a + ')';
    }

    public j() {
        this.f428465a = true;
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return com.ss.android.lark.keyboard.event.c.a.a(this);
    }
}
