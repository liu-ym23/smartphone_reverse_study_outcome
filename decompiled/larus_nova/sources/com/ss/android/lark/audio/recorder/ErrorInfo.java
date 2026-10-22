package com.ss.android.lark.audio.recorder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/audio/recorder/ErrorInfo;", "", "errorCode", "", "errorMessage", "", "compatCode", "<init>", "(Ljava/lang/String;IILjava/lang/String;I)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getCompatCode", "ERR_INVALID_RECORD_TASK", "ERR_INIT_AUDIO_RECORD", "ERR_INIT_AUDIO_ENCODE", "ERR_PSDA_CHECK", "ERR_NO_PERMISSION", "ERR_OCCUR_EXCEPTION", "ERR_INTERRUPT_BY_PHONE", "ERR_INTERRUPT_BY_VC_MEETING", "ERR_PCM_SIZE_ZERO", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "Ljava/lang/Exception;", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorInfo extends Enum<ErrorInfo> {
    public static final ErrorInfo ERR_INIT_AUDIO_ENCODE = null;
    public static final ErrorInfo ERR_INIT_AUDIO_RECORD = null;
    public static final ErrorInfo ERR_INTERRUPT_BY_PHONE = null;
    public static final ErrorInfo ERR_INTERRUPT_BY_VC_MEETING = null;
    public static final ErrorInfo ERR_INVALID_RECORD_TASK = null;
    public static final ErrorInfo ERR_NO_PERMISSION = null;
    public static final ErrorInfo ERR_OCCUR_EXCEPTION = null;
    public static final ErrorInfo ERR_PCM_SIZE_ZERO = null;
    public static final ErrorInfo ERR_PSDA_CHECK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorInfo[] f409073a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409074b = null;
    private final int compatCode;
    private final int errorCode;
    private String errorMessage;

    public static EnumEntries<ErrorInfo> getEntries() {
        return f409074b;
    }

    static {
        ErrorInfo r100 = new ErrorInfo("ERR_INVALID_RECORD_TASK", 0, 10000, "", 2);
        ERR_INVALID_RECORD_TASK = r100;
        ErrorInfo r101 = new ErrorInfo("ERR_INIT_AUDIO_RECORD", 1, 10001, "init audio record device failed.", 2);
        ERR_INIT_AUDIO_RECORD = r101;
        ErrorInfo r102 = new ErrorInfo("ERR_INIT_AUDIO_ENCODE", 2, 10002, "init audio encoder failed.", 2);
        ERR_INIT_AUDIO_ENCODE = r102;
        ErrorInfo r103 = new ErrorInfo("ERR_PSDA_CHECK", 3, 10003, "psda check failed.", 4);
        ERR_PSDA_CHECK = r103;
        ErrorInfo r104 = new ErrorInfo("ERR_NO_PERMISSION", 4, 10004, "no permission on flyme ", 3);
        ERR_NO_PERMISSION = r104;
        ErrorInfo r105 = new ErrorInfo("ERR_OCCUR_EXCEPTION", 5, 11000, "occur exception", 2);
        ERR_OCCUR_EXCEPTION = r105;
        ErrorInfo r106 = new ErrorInfo("ERR_INTERRUPT_BY_PHONE", 6, 10005, "interrupt by phone", 0, 4, null);
        ERR_INTERRUPT_BY_PHONE = r106;
        ErrorInfo r107 = new ErrorInfo("ERR_INTERRUPT_BY_VC_MEETING", 7, 10006, "interrupt by vc meeting", 0, 4, null);
        ERR_INTERRUPT_BY_VC_MEETING = r107;
        ErrorInfo r110 = new ErrorInfo("ERR_PCM_SIZE_ZERO", 8, -8848, "pcm size is zero", 0, 4, null);
        ERR_PCM_SIZE_ZERO = r110;
        ErrorInfo[] r108 = {r100, r101, r102, r103, r104, r105, r106, r107, r110};
        f409073a = r108;
        f409074b = EnumEntriesKt.enumEntries(r108);
    }

    public static ErrorInfo[] values() {
        return (ErrorInfo[]) f409073a.clone();
    }

    public final int getCompatCode() {
        return this.compatCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public static ErrorInfo valueOf(String r100) {
        return (ErrorInfo) r27.a.a(ErrorInfo.class, r100);
    }

    public final ErrorInfo exception(Exception r100) {
        if (r100 == null) goto L4;
        this.errorMessage = r100.toString();
    L4:
        return this;
    }

    public final void setErrorMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorMessage = r100;
    }

    public ErrorInfo(String r100, int r101, int r102, String r103, int r104) {
        super(r100, r101);
        this.errorCode = r102;
        this.errorMessage = r103;
        this.compatCode = r104;
    }

    public /* synthetic */ ErrorInfo(String r100, int r101, int r102, String r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        int r103 = 2;
    L6:
        this(r100, r101, r102, r110, r103);
        return;
    L5:
        r103 = r111;
        goto L6
    }
}
