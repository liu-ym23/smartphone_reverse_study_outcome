package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.window.base.SyncType;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[WindowTabEventReporter.EventType.values().length];
        a = r0;
        r0[WindowTabEventReporter.EventType.SHOW.ordinal()] = 1;
        r0[WindowTabEventReporter.EventType.CLICK.ordinal()] = 2;
        int[] r1 = new int[ClickSeparatedTabSelectListener.ActionType.values().length];
        b = r1;
        r1[ClickSeparatedTabSelectListener.ActionType.SCROLL.ordinal()] = 1;
        r1[ClickSeparatedTabSelectListener.ActionType.CLICK.ordinal()] = 2;
        int[] r2 = new int[SyncType.values().length];
        c = r2;
        r2[SyncType.HISTORY_PRODUCT.ordinal()] = 1;
        r2[SyncType.STORE_PRODUCT.ordinal()] = 2;
    }
}
