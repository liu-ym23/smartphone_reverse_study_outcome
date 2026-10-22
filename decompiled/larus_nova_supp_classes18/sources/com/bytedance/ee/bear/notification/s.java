package com.bytedance.ee.bear.notification;

import io.reactivex.functions.Predicate;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements Predicate<List<String>> {
    public s() {
    }

    public final boolean test(Object r1) throws Exception {
        return !((List) r1).isEmpty();
    }
}
