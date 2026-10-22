package com.larus.avlink.update;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/update/UpdateSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT", "SETTING", "APPFOREGROUND", FlowDoraWifiScene.OTHER, "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateSource extends Enum<UpdateSource> {
    public static final UpdateSource APPFOREGROUND = null;
    public static final UpdateSource CHAT = null;
    public static final UpdateSource OTHER = null;
    public static final UpdateSource SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateSource[] f294702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294703b = null;
    private final int value;

    public static EnumEntries<UpdateSource> getEntries() {
        return f294703b;
    }

    static {
        UpdateSource r100 = new UpdateSource("CHAT", 0, 0);
        CHAT = r100;
        UpdateSource r101 = new UpdateSource("SETTING", 1, 1);
        SETTING = r101;
        UpdateSource r102 = new UpdateSource("APPFOREGROUND", 2, 2);
        APPFOREGROUND = r102;
        UpdateSource r103 = new UpdateSource(FlowDoraWifiScene.OTHER, 3, 3);
        OTHER = r103;
        UpdateSource[] r104 = {r100, r101, r102, r103};
        f294702a = r104;
        f294703b = EnumEntriesKt.enumEntries(r104);
    }

    public static UpdateSource[] values() {
        return (UpdateSource[]) f294702a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UpdateSource valueOf(String r100) {
        return (UpdateSource) r27.a.a(UpdateSource.class, r100);
    }

    public UpdateSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
