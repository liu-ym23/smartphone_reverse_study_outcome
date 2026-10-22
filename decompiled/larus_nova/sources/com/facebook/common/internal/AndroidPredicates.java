package com.facebook.common.internal;

/* JADX INFO: loaded from: classes22.dex */
public class AndroidPredicates {
    private AndroidPredicates() {
    }

    public static <T> Predicate<T> False() {
        return new AnonymousClass2();
    }

    public static <T> Predicate<T> True() {
        return new AnonymousClass1();
    }
}
