package com.larus.photopicker.v2.impl.data;

import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
public interface d {
    Object a(String r100, Continuation<? super mp9.c> r101);

    Object b(mp9.a r100, Continuation<? super Integer> r101);

    int c(long r100, MediaTab r101, long r102);

    Object d(mp9.a r100, Continuation<? super Boolean> r101);

    Object e(List<? extends MediaTab> r100, Continuation<? super List<mp9.b>> r101);

    Object f(int r100, int r101, List<? extends MediaTab> r102, Continuation<? super List<mp9.c>> r103);

    MutableLiveData g();

    List<mp9.b> h(mp9.c r100);

    Object i(int r100, int r101, mp9.a r102, Continuation<? super Unit> r103);
}
