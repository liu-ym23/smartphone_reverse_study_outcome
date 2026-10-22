package com.ss.android.lark.search.doubao.api.request;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f439951a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f439951a == ((b) r100).f439951a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f439951a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "BotDslModel(includeUnTalkBot=" + this.f439951a + ')';
    }

    public b(boolean r100) {
        this.f439951a = r100;
    }
}
