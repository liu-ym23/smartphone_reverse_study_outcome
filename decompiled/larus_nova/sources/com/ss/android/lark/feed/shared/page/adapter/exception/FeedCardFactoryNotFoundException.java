package com.ss.android.lark.feed.shared.page.adapter.exception;

/* JADX INFO: loaded from: classes35.dex */
public class FeedCardFactoryNotFoundException extends RuntimeException {
    public FeedCardFactoryNotFoundException(Class<?> r100) {
        super("Do you have registered {className}.class to the feed card factory?".replace("{className}", r100.getSimpleName()));
    }
}
