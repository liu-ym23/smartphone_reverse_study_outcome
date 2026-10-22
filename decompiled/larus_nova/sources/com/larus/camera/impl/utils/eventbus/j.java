package com.larus.camera.impl.utils.eventbus;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f322757a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f322757a, ((j) r100).f322757a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f322757a.hashCode();
    }

    public final String toString() {
        return "InvokeSuggestedAction(actionKey=" + this.f322757a + ')';
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionKey");
        this.f322757a = r100;
    }
}
