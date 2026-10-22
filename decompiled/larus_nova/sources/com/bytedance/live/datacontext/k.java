package com.bytedance.live.datacontext;

import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes19.dex */
public interface k<T> {
    EventMember.b a();

    EventMember.InterceptorSet b();

    PublishSubject onEvent();

    void post(T r100);
}
