package com.ss.android.lark.keyboard.biz.mention.inject;

import com.ss.android.lark.keyboard.event.q;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f428444a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f428444a == ((a) r100).f428444a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f428444a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "AtDoubaoSelectChange(selected=" + this.f428444a + ')';
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return com.ss.android.lark.keyboard.event.c.a.a(this);
    }

    public a(boolean r100) {
        this.f428444a = r100;
    }
}
