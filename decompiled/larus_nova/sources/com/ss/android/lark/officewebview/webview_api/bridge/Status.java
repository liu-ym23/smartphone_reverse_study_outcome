package com.ss.android.lark.officewebview.webview_api.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officewebview/webview_api/bridge/Status;", "", "status", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "SUCCESS", "FAILURE", "CANCEL", "TIMEOUT", "PROGRESS", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Status extends Enum<Status> {
    public static final Status CANCEL = null;
    public static final Status FAILURE = null;
    public static final Status PROGRESS = null;
    public static final Status SUCCESS = null;
    public static final Status TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f437577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437578b = null;
    private final String status;

    public static EnumEntries<Status> getEntries() {
        return f437578b;
    }

    static {
        Status r100 = new Status("SUCCESS", 0, "success");
        SUCCESS = r100;
        Status r101 = new Status("FAILURE", 1, "failure");
        FAILURE = r101;
        Status r102 = new Status("CANCEL", 2, "cancel");
        CANCEL = r102;
        Status r103 = new Status("TIMEOUT", 3, "timeout");
        TIMEOUT = r103;
        Status r104 = new Status("PROGRESS", 4, "progress");
        PROGRESS = r104;
        Status[] r105 = {r100, r101, r102, r103, r104};
        f437577a = r105;
        f437578b = EnumEntriesKt.enumEntries(r105);
    }

    public static Status[] values() {
        return (Status[]) f437577a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public static Status valueOf(String r100) {
        return (Status) a.a(Status.class, r100);
    }

    public Status(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
