package com.larus.bmhome.chat.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;", "", "<init>", "(Ljava/lang/String;I)V", "Attachment", "DirectSend", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImportedImageRouteMode extends Enum<ImportedImageRouteMode> {
    public static final ImportedImageRouteMode Attachment = null;
    public static final ImportedImageRouteMode DirectSend = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImportedImageRouteMode[] f307477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307478b = null;

    public static EnumEntries<ImportedImageRouteMode> getEntries() {
        return f307478b;
    }

    static {
        ImportedImageRouteMode r100 = new ImportedImageRouteMode("Attachment", 0);
        Attachment = r100;
        ImportedImageRouteMode r101 = new ImportedImageRouteMode("DirectSend", 1);
        DirectSend = r101;
        ImportedImageRouteMode[] r102 = {r100, r101};
        f307477a = r102;
        f307478b = EnumEntriesKt.enumEntries(r102);
    }

    public static ImportedImageRouteMode[] values() {
        return (ImportedImageRouteMode[]) f307477a.clone();
    }

    public static ImportedImageRouteMode valueOf(String r100) {
        return (ImportedImageRouteMode) r27.a.a(ImportedImageRouteMode.class, r100);
    }

    public ImportedImageRouteMode(String r100, int r101) {
        super(r100, r101);
    }
}
