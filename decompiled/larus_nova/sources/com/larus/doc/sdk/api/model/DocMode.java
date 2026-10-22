package com.larus.doc.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/api/model/DocMode;", "", "<init>", "(Ljava/lang/String;I)V", "READ_ONLY", "NORMAL_EDIT", "AI_EDIT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocMode extends Enum<DocMode> {
    public static final DocMode AI_EDIT = null;
    public static final DocMode NORMAL_EDIT = null;
    public static final DocMode READ_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocMode[] f331607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331608b = null;

    public static EnumEntries<DocMode> getEntries() {
        return f331608b;
    }

    static {
        DocMode r100 = new DocMode("READ_ONLY", 0);
        READ_ONLY = r100;
        DocMode r101 = new DocMode("NORMAL_EDIT", 1);
        NORMAL_EDIT = r101;
        DocMode r102 = new DocMode("AI_EDIT", 2);
        AI_EDIT = r102;
        DocMode[] r103 = {r100, r101, r102};
        f331607a = r103;
        f331608b = EnumEntriesKt.enumEntries(r103);
    }

    public static DocMode[] values() {
        return (DocMode[]) f331607a.clone();
    }

    public static DocMode valueOf(String r100) {
        return (DocMode) a.a(DocMode.class, r100);
    }

    public DocMode(String r100, int r101) {
        super(r100, r101);
    }
}
