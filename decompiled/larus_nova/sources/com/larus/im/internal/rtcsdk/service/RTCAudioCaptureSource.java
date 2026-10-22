package com.larus.im.internal.rtcsdk.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/internal/rtcsdk/service/RTCAudioCaptureSource;", "", "source", "", "<init>", "(Ljava/lang/String;II)V", "getSource", "()I", "DEFAULT", "VOICE_RECOGNITION", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCAudioCaptureSource extends Enum<RTCAudioCaptureSource> {
    public static final RTCAudioCaptureSource DEFAULT = null;
    public static final RTCAudioCaptureSource VOICE_RECOGNITION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTCAudioCaptureSource[] f350066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350067b = null;
    private final int source;

    public static EnumEntries<RTCAudioCaptureSource> getEntries() {
        return f350067b;
    }

    static {
        RTCAudioCaptureSource r100 = new RTCAudioCaptureSource("DEFAULT", 0, 0);
        DEFAULT = r100;
        RTCAudioCaptureSource r101 = new RTCAudioCaptureSource("VOICE_RECOGNITION", 1, 1);
        VOICE_RECOGNITION = r101;
        RTCAudioCaptureSource[] r102 = {r100, r101};
        f350066a = r102;
        f350067b = EnumEntriesKt.enumEntries(r102);
    }

    public static RTCAudioCaptureSource[] values() {
        return (RTCAudioCaptureSource[]) f350066a.clone();
    }

    public final int getSource() {
        return this.source;
    }

    public static RTCAudioCaptureSource valueOf(String r100) {
        return (RTCAudioCaptureSource) a.a(RTCAudioCaptureSource.class, r100);
    }

    public RTCAudioCaptureSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.source = r102;
    }
}
