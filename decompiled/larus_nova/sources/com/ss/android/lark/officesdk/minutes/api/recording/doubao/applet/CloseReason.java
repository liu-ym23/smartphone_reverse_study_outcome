package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/CloseReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CLOSE", "RECORDING_END", "PARAMETER_INVALID", "WEBVIEW_CALLBACK_NORMAL", "WEBVIEW_CALLBACK_ERROR", "unexpectedError", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CloseReason extends Enum<CloseReason> {
    public static final CloseReason PARAMETER_INVALID = null;
    public static final CloseReason RECORDING_END = null;
    public static final CloseReason USER_CLOSE = null;
    public static final CloseReason WEBVIEW_CALLBACK_ERROR = null;
    public static final CloseReason WEBVIEW_CALLBACK_NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloseReason[] f433571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433572b = null;

    public static EnumEntries<CloseReason> getEntries() {
        return f433572b;
    }

    static {
        CloseReason r100 = new CloseReason("USER_CLOSE", 0);
        USER_CLOSE = r100;
        CloseReason r101 = new CloseReason("RECORDING_END", 1);
        RECORDING_END = r101;
        CloseReason r102 = new CloseReason("PARAMETER_INVALID", 2);
        PARAMETER_INVALID = r102;
        CloseReason r103 = new CloseReason("WEBVIEW_CALLBACK_NORMAL", 3);
        WEBVIEW_CALLBACK_NORMAL = r103;
        CloseReason r104 = new CloseReason("WEBVIEW_CALLBACK_ERROR", 4);
        WEBVIEW_CALLBACK_ERROR = r104;
        CloseReason[] r105 = {r100, r101, r102, r103, r104};
        f433571a = r105;
        f433572b = EnumEntriesKt.enumEntries(r105);
    }

    public static CloseReason[] values() {
        return (CloseReason[]) f433571a.clone();
    }

    public final boolean unexpectedError() {
        if (this != PARAMETER_INVALID) goto L5;
    L8:
        return true;
    L5:
        if (this == WEBVIEW_CALLBACK_ERROR) goto L8;
        return false;
    }

    public static CloseReason valueOf(String r100) {
        return (CloseReason) a.a(CloseReason.class, r100);
    }

    public CloseReason(String r100, int r101) {
        super(r100, r101);
    }
}
