package com.larus.im.internal.network.link.impl.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/network/link/impl/rtc/RTCConnectionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Default", "TokenPoolWithRTCMerge", "useMultiToken", "", "Companion", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCConnectionType extends Enum<RTCConnectionType> {
    public static final a Companion = null;
    public static final RTCConnectionType Default = null;
    public static final RTCConnectionType TokenPoolWithRTCMerge = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCConnectionType[] f349226a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349227b = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<RTCConnectionType> getEntries() {
        return f349227b;
    }

    static {
        RTCConnectionType r100 = new RTCConnectionType("Default", 0, 0);
        Default = r100;
        RTCConnectionType r101 = new RTCConnectionType("TokenPoolWithRTCMerge", 1, 1);
        TokenPoolWithRTCMerge = r101;
        RTCConnectionType[] r102 = {r100, r101};
        f349226a = r102;
        f349227b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static RTCConnectionType[] values() {
        return (RTCConnectionType[]) f349226a.clone();
    }

    public final boolean useMultiToken() {
        if (this != TokenPoolWithRTCMerge) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getType() {
        return this.type;
    }

    public static RTCConnectionType valueOf(String r100) {
        return (RTCConnectionType) r27.a.a(RTCConnectionType.class, r100);
    }

    public RTCConnectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
