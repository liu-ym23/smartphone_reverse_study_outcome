package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
public interface l0 {
    Object c(h0 r100, Continuation<? super g> r101);

    ResourcePhase d();

    boolean e(h0 r100);

    List<String> f();

    ResourceNodeCompletionMode g();

    String getKey();

    boolean h();
}
