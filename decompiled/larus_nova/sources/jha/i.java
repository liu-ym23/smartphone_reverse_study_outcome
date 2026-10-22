package jha;

import jha.o;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes33.dex */
public interface i<S extends o> {
    q<S> a();

    Object b(q<S> r100, Long r101, Continuation<? super Boolean> r102);

    void destroy();

    a1 getEvents();
}
