package io.ktor.client.plugins.cookies;

import io.ktor.http.Url;
import io.ktor.http.d;
import java.io.Closeable;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes41.dex */
public interface a extends Closeable {
    Object Mc(Url r100, d r101, Continuation<? super Unit> r102);

    Object fm(Url r100, Continuation<? super List<d>> r101);
}
