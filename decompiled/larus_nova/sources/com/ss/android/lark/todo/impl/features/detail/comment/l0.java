package com.ss.android.lark.todo.impl.features.detail.comment;

import com.alibaba.fastjson.JSONObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l0 implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f442959a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f442959a, ((l0) r100).f442959a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f442959a.hashCode();
    }

    public final String toString() {
        return "CommentPushData(jsonObject=" + this.f442959a + ')';
    }

    public l0(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        this.f442959a = r100;
    }
}
