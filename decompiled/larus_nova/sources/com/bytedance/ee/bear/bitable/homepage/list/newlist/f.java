package com.bytedance.ee.bear.bitable.homepage.list.newlist;

import com.bytedance.lark.lark_bitable_android.HomepageListType;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f212840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f212841b = null;

    static {
        int[] r100 = new int[HomepageListType.values().length];
        r100[HomepageListType.Recent.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L20:
        r100[HomepageListType.Pin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
    L26:
        r100[HomepageListType.Workspace.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
    L8:
        f212840a = r100;
        int[] r101 = new int[com.bytedance.ee.bear.workspace.HomepageListType.values().length];
        r101[com.bytedance.ee.bear.workspace.HomepageListType.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
    L22:
        r101[com.bytedance.ee.bear.workspace.HomepageListType.PINNED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
    L28:
        r101[com.bytedance.ee.bear.workspace.HomepageListType.WORK_SPACE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
    L12:
        f212841b = r101;
    }
}
