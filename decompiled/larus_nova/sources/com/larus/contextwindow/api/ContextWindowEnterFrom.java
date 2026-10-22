package com.larus.contextwindow.api;

import com.larus.doc.sdk.api.VoiceInputFrom;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowEnterFrom;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "ACTION_BAR", "NATIVE", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowEnterFrom extends Enum<ContextWindowEnterFrom> {
    public static final ContextWindowEnterFrom ACTION_BAR = null;
    public static final ContextWindowEnterFrom NATIVE = null;
    public static final ContextWindowEnterFrom UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextWindowEnterFrom[] f330233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330234b = null;
    private final String wireValue;

    public static EnumEntries<ContextWindowEnterFrom> getEntries() {
        return f330234b;
    }

    static {
        ContextWindowEnterFrom r100 = new ContextWindowEnterFrom("ACTION_BAR", 0, VoiceInputFrom.ACTION_BAR);
        ACTION_BAR = r100;
        ContextWindowEnterFrom r101 = new ContextWindowEnterFrom("NATIVE", 1, "native");
        NATIVE = r101;
        ContextWindowEnterFrom r102 = new ContextWindowEnterFrom("UNKNOWN", 2, "unknown");
        UNKNOWN = r102;
        ContextWindowEnterFrom[] r103 = {r100, r101, r102};
        f330233a = r103;
        f330234b = EnumEntriesKt.enumEntries(r103);
    }

    public static ContextWindowEnterFrom[] values() {
        return (ContextWindowEnterFrom[]) f330233a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static ContextWindowEnterFrom valueOf(String r100) {
        return (ContextWindowEnterFrom) r27.a.a(ContextWindowEnterFrom.class, r100);
    }

    public ContextWindowEnterFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.wireValue = r102;
    }
}
