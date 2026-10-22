package com.bytedance.ies.argus.repository;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class i extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f246127b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f246128a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f246128a, ((i) r100).f246128a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f246128a.hashCode();
    }

    public final String toString() {
        return "GlobalConfigModel(data=" + this.f246128a + ')';
    }

    public i(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f246128a = r100;
    }
}
