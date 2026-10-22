package com.ss.android.lark.chatbase;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public interface l<E> {
    void a(Function1<? super E, ? extends E> r100);

    k filter(Function1 r100);

    l<E> query(String r100);

    List<E> toList();
}
