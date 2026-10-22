package com.larus.camera.api.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/camera/api/vlm/VLMFileDataType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "IMAGE", "VIDEO", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VLMFileDataType extends Enum<VLMFileDataType> {
    public static final a Companion = null;
    public static final VLMFileDataType IMAGE = null;
    public static final VLMFileDataType UNKNOWN = null;
    public static final VLMFileDataType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VLMFileDataType[] f321467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321468b = null;
    private final int value;

    public static EnumEntries<VLMFileDataType> getEntries() {
        return f321468b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.camera.api.vlm.VLMFileDataType$a] */
    static {
        VLMFileDataType r100 = new VLMFileDataType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        VLMFileDataType r101 = new VLMFileDataType("IMAGE", 1, 1);
        IMAGE = r101;
        VLMFileDataType r102 = new VLMFileDataType("VIDEO", 2, 2);
        VIDEO = r102;
        VLMFileDataType[] r103 = {r100, r101, r102};
        f321467a = r103;
        f321468b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static VLMFileDataType[] values() {
        return (VLMFileDataType[]) f321467a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static VLMFileDataType valueOf(String r100) {
        return (VLMFileDataType) r27.a.a(VLMFileDataType.class, r100);
    }

    public VLMFileDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
