package com.larus.bmhome.taskskill;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f314301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f314302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f314303c;

    public i(String r100) {
        Set<String> r101 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f314301a = r100;
        this.f314302b = false;
        this.f314303c = r101;
    }
}
