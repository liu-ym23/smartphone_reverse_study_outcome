package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.entity.message.Message;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class j1<Key, Source, Target> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Key, m6b.k<Source, Target>> f416524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<Key, Source> f416525b;

    public interface a<Key, Source> {
        Message.Type a(Object r100);
    }

    public j1(a<Key, Source> r100) {
        this.f416524a = new HashMap();
        this.f416525b = r100;
    }

    public final void a(Message.Type r100, m6b.k r101) {
        ((HashMap) this.f416524a).put(r100, r101);
    }
}
