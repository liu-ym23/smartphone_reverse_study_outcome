package com.larus.camera.impl.utils.eventbus;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final op8.i.a f322756a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f322756a, ((i) r100).f322756a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f322756a.hashCode();
    }

    public final String toString() {
        return "InputStopped(inputType=" + this.f322756a + ')';
    }

    public i(op8.i.a r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.INPUT_TYPE);
        this.f322756a = r100;
    }
}
