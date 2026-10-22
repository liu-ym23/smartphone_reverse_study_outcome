package com.bytedance.android.window.shop.repository.header.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/repository/header/utils/WindowHeaderStrategy;", "", "", "strategy", "I", "getStrategy", "()I", "ONLY_SHOW_IN_FULLSCREEN", "ALWAYS_SHOWING", "ONLY_SHOW_IN_SPLIT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowHeaderStrategy extends Enum<WindowHeaderStrategy> {
    public static final WindowHeaderStrategy ALWAYS_SHOWING = null;
    public static final WindowHeaderStrategy ONLY_SHOW_IN_FULLSCREEN = null;
    public static final WindowHeaderStrategy ONLY_SHOW_IN_SPLIT = null;
    public static final /* synthetic */ WindowHeaderStrategy[] a = null;
    private final int strategy;

    static {
        WindowHeaderStrategy r1 = new WindowHeaderStrategy("ONLY_SHOW_IN_FULLSCREEN", 0, 0);
        ONLY_SHOW_IN_FULLSCREEN = r1;
        WindowHeaderStrategy r2 = new WindowHeaderStrategy("ALWAYS_SHOWING", 1, 1);
        ALWAYS_SHOWING = r2;
        WindowHeaderStrategy r3 = new WindowHeaderStrategy("ONLY_SHOW_IN_SPLIT", 2, 2);
        ONLY_SHOW_IN_SPLIT = r3;
        a = new WindowHeaderStrategy[]{r1, r2, r3};
    }

    public static WindowHeaderStrategy valueOf(String r1) {
        return (WindowHeaderStrategy) a.a(WindowHeaderStrategy.class, r1);
    }

    public static WindowHeaderStrategy[] values() {
        return (WindowHeaderStrategy[]) a.clone();
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public WindowHeaderStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.strategy = r3;
    }
}
