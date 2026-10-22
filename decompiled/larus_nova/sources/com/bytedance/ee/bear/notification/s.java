package com.bytedance.ee.bear.notification;

import io.reactivex.functions.Predicate;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements Predicate<List<String>> {
    public s() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(List<String> r100) throws Exception {
        return !r100.isEmpty();
    }
}
