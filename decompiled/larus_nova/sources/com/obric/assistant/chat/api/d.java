package com.obric.assistant.chat.api;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, String> f386614a;

    public d() {
        this.f386614a = new LinkedHashMap();
    }

    public final void a(Iterable<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "aliasIds");
        Intrinsics.checkNotNullParameter(r101, "targetId");
        if (StringsKt.isBlank(r101) == false) goto L5;
        return;
    L5:
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        if (StringsKt.isBlank(r103) == true) goto L7;
        if (Intrinsics.areEqual(r103, r101) == true) goto L7;
        this.f386614a.remove(r103);
        this.f386614a.put(r103, r101);
    L15:
        if (this.f386614a.size() <= 200) goto L20;
        String r104 = (String) CollectionsKt.firstOrNull(this.f386614a.keySet());
        if (r104 == null) goto L18;
        this.f386614a.remove(r104);
        goto L15
    L18:
        return;
    }
}
