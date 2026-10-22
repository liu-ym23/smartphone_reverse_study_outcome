package com.larus.agents.impl.network;

import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.experience.p;
import com.larus.agents.impl.experience.s;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes24.dex */
public interface m {
    Object a(p r100, Continuation<? super WorkExperienceMutationResult> r101);

    Object b(boolean r100, Continuation<? super WorkExperienceMutationResult> r101);

    Object c(String r100, Continuation<? super Result<com.larus.agents.impl.experience.n>> r101);

    Object d(int r100, String r101, Continuation<? super Result<s>> r102);

    Object delete(String r100, Continuation<? super WorkExperienceMutationResult> r101);

    Object e(Continuation<? super Result<Boolean>> r100);

    Object update(String r100, p r101, Continuation<? super WorkExperienceMutationResult> r102);
}
