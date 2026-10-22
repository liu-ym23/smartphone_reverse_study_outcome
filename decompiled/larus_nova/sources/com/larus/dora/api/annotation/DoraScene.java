package com.larus.dora.api.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/api/annotation/DoraScene;", "", "<init>", "(Ljava/lang/String;I)V", "OTA_TRANSFER_DATA", "OTA_PERIPHERAL_INSTALL", "FEEDBACK_SUBMITTING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraScene extends Enum<DoraScene> {
    public static final DoraScene FEEDBACK_SUBMITTING = null;
    public static final DoraScene OTA_PERIPHERAL_INSTALL = null;
    public static final DoraScene OTA_TRANSFER_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraScene[] f331732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331733b = null;

    public static EnumEntries<DoraScene> getEntries() {
        return f331733b;
    }

    static {
        DoraScene r100 = new DoraScene("OTA_TRANSFER_DATA", 0);
        OTA_TRANSFER_DATA = r100;
        DoraScene r101 = new DoraScene("OTA_PERIPHERAL_INSTALL", 1);
        OTA_PERIPHERAL_INSTALL = r101;
        DoraScene r102 = new DoraScene("FEEDBACK_SUBMITTING", 2);
        FEEDBACK_SUBMITTING = r102;
        DoraScene[] r103 = {r100, r101, r102};
        f331732a = r103;
        f331733b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraScene[] values() {
        return (DoraScene[]) f331732a.clone();
    }

    public static DoraScene valueOf(String r100) {
        return (DoraScene) a.a(DoraScene.class, r100);
    }

    public DoraScene(String r100, int r101) {
        super(r100, r101);
    }
}
