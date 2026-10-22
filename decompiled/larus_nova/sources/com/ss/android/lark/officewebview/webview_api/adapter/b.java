package com.ss.android.lark.officewebview.webview_api.adapter;

import com.ss.android.lark.officewebview.webview_api.bridge.Status;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f437575a = null;

    static {
        int[] r100 = new int[Status.values().length];
        r100[Status.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r100[Status.FAILURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r100[Status.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r100[Status.TIMEOUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r100[Status.PROGRESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        f437575a = r100;
    }
}
