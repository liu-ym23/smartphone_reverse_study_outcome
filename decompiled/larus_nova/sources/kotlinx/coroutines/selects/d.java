package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
public interface d<R> {
    <Q> void d(g<? extends Q> r100, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r101);
}
