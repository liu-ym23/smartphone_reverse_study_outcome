package com.bytedance.lynx.webview.util;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum DeleteReason extends Enum<DeleteReason> {
    public static final DeleteReason DELETE_BY_ACTIVE = null;
    public static final DeleteReason DELETE_BY_AUTO_CLEAR = null;
    public static final DeleteReason DELETE_BY_AUTO_CLEAR_SENSITIVE = null;
    public static final DeleteReason DELETE_BY_CLIENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeleteReason[] f265441a = null;
    private final String mDescription;

    static {
        DeleteReason r100 = new DeleteReason("DELETE_BY_CLIENT", 0, "TTWebView is deleted by client invoking TTWebSdk.ClearTTWebView().");
        DELETE_BY_CLIENT = r100;
        DeleteReason r101 = new DeleteReason("DELETE_BY_AUTO_CLEAR", 1, "TTWebView is deleted because the user has not used it for a long time.");
        DELETE_BY_AUTO_CLEAR = r101;
        DeleteReason r102 = new DeleteReason("DELETE_BY_AUTO_CLEAR_SENSITIVE", 2, "TTWebView is deleted because the user has not used it for a long time (Sensitive).");
        DELETE_BY_AUTO_CLEAR_SENSITIVE = r102;
        DeleteReason r103 = new DeleteReason("DELETE_BY_ACTIVE", 3, "TTWebView is actively deleted.");
        DELETE_BY_ACTIVE = r103;
        f265441a = new DeleteReason[]{r100, r101, r102, r103};
    }

    public static DeleteReason[] values() {
        return (DeleteReason[]) f265441a.clone();
    }

    public String getDescription() {
        return this.mDescription;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mDescription;
    }

    public static DeleteReason valueOf(String r100) {
        return (DeleteReason) a.a(DeleteReason.class, r100);
    }

    public DeleteReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.mDescription = r102;
    }
}
