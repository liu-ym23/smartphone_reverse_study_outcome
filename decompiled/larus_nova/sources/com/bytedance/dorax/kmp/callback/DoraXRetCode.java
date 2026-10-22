package com.bytedance.dorax.kmp.callback;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/dorax/kmp/callback/DoraXRetCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UnSupported", "BandwidthBusy", "PacketLoss", "NotSupport", "TimeOut", "InvalidAck", "Exception", "AckTimeOut", "UnConnected", CheckStatus.FAIL, "Success", "UnknowError", "Busy", "InterfaceUndefined", "FormatError", "ParameterError", "LackOfMemory", "Timeout", "CRCOK", "CRCError", "FrameError", "Companion", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DoraXRetCode extends Enum<DoraXRetCode> {
    public static final DoraXRetCode AckTimeOut = null;
    public static final DoraXRetCode BandwidthBusy = null;
    public static final DoraXRetCode Busy = null;
    public static final DoraXRetCode CRCError = null;
    public static final DoraXRetCode CRCOK = null;
    public static final a Companion = null;
    public static final DoraXRetCode Exception = null;
    public static final DoraXRetCode Fail = null;
    public static final DoraXRetCode FormatError = null;
    public static final DoraXRetCode FrameError = null;
    public static final DoraXRetCode InterfaceUndefined = null;
    public static final DoraXRetCode InvalidAck = null;
    public static final DoraXRetCode LackOfMemory = null;
    public static final DoraXRetCode NotSupport = null;
    public static final DoraXRetCode PacketLoss = null;
    public static final DoraXRetCode ParameterError = null;
    public static final DoraXRetCode Success = null;
    public static final DoraXRetCode TimeOut = null;
    public static final DoraXRetCode Timeout = null;
    public static final DoraXRetCode UnConnected = null;
    public static final DoraXRetCode UnSupported = null;
    public static final DoraXRetCode UnknowError = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraXRetCode[] f204763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f204764b = null;
    private final int code;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DoraXRetCode> getEntries() {
        return f204764b;
    }

    static {
        DoraXRetCode r100 = new DoraXRetCode("UnSupported", 0, -30);
        UnSupported = r100;
        DoraXRetCode r101 = new DoraXRetCode("BandwidthBusy", 1, -20);
        BandwidthBusy = r101;
        DoraXRetCode r102 = new DoraXRetCode("PacketLoss", 2, -8);
        PacketLoss = r102;
        DoraXRetCode r103 = new DoraXRetCode("NotSupport", 3, -7);
        NotSupport = r103;
        DoraXRetCode r104 = new DoraXRetCode("TimeOut", 4, -6);
        TimeOut = r104;
        DoraXRetCode r105 = new DoraXRetCode("InvalidAck", 5, -5);
        InvalidAck = r105;
        DoraXRetCode r110 = new DoraXRetCode("Exception", 6, -4);
        Exception = r110;
        DoraXRetCode r111 = new DoraXRetCode("AckTimeOut", 7, -3);
        AckTimeOut = r111;
        DoraXRetCode r112 = new DoraXRetCode("UnConnected", 8, -2);
        UnConnected = r112;
        DoraXRetCode r113 = new DoraXRetCode(CheckStatus.FAIL, 9, -1);
        Fail = r113;
        DoraXRetCode r106 = new DoraXRetCode("Success", 10, 0);
        Success = r106;
        DoraXRetCode r114 = new DoraXRetCode("UnknowError", 11, 1);
        UnknowError = r114;
        DoraXRetCode r115 = new DoraXRetCode("Busy", 12, 2);
        Busy = r115;
        DoraXRetCode r107 = new DoraXRetCode("InterfaceUndefined", 13, 3);
        InterfaceUndefined = r107;
        DoraXRetCode r108 = new DoraXRetCode("FormatError", 14, 4);
        FormatError = r108;
        DoraXRetCode r109 = new DoraXRetCode("ParameterError", 15, 5);
        ParameterError = r109;
        DoraXRetCode r116 = new DoraXRetCode("LackOfMemory", 16, 6);
        LackOfMemory = r116;
        DoraXRetCode r117 = new DoraXRetCode("Timeout", 17, 7);
        Timeout = r117;
        DoraXRetCode r118 = new DoraXRetCode("CRCOK", 18, 128);
        CRCOK = r118;
        DoraXRetCode r119 = new DoraXRetCode("CRCError", 19, 129);
        CRCError = r119;
        DoraXRetCode r120 = new DoraXRetCode("FrameError", 20, 130);
        FrameError = r120;
        DoraXRetCode[] r121 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r114, r115, r107, r108, r109, r116, r117, r118, r119, r120};
        f204763a = r121;
        f204764b = EnumEntriesKt.enumEntries(r121);
        Companion = new a();
    }

    public static DoraXRetCode[] values() {
        return (DoraXRetCode[]) f204763a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static DoraXRetCode valueOf(String r100) {
        return (DoraXRetCode) r27.a.a(DoraXRetCode.class, r100);
    }

    public DoraXRetCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
