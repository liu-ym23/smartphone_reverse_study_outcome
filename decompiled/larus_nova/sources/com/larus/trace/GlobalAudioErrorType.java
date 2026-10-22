package com.larus.trace;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/trace/GlobalAudioErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SDK", HTTP.HOST, "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GlobalAudioErrorType extends Enum<GlobalAudioErrorType> {
    public static final GlobalAudioErrorType HOST = null;
    public static final GlobalAudioErrorType SDK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GlobalAudioErrorType[] f370141a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370142b = null;
    private final String value;

    public static EnumEntries<GlobalAudioErrorType> getEntries() {
        return f370142b;
    }

    static {
        GlobalAudioErrorType r100 = new GlobalAudioErrorType("SDK", 0, "sdk");
        SDK = r100;
        GlobalAudioErrorType r101 = new GlobalAudioErrorType(HTTP.HOST, 1, "host");
        HOST = r101;
        GlobalAudioErrorType[] r102 = {r100, r101};
        f370141a = r102;
        f370142b = EnumEntriesKt.enumEntries(r102);
    }

    public static GlobalAudioErrorType[] values() {
        return (GlobalAudioErrorType[]) f370141a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static GlobalAudioErrorType valueOf(String r100) {
        return (GlobalAudioErrorType) a.a(GlobalAudioErrorType.class, r100);
    }

    public GlobalAudioErrorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
