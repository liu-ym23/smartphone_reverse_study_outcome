package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a {
    public a() {
    }

    public abstract String a();

    public abstract ModuleKey b();

    public String c() {
        return null;
    }

    public a d(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, "records");
        return this;
    }
}
