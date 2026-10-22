package com.larus.camera.api.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/camera/api/vlm/VLMSceneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TAKE_PICTURE", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VLMSceneType extends Enum<VLMSceneType> {
    public static final a Companion = null;
    public static final VLMSceneType TAKE_PICTURE = null;
    public static final VLMSceneType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VLMSceneType[] f321475a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321476b = null;
    private final int value;

    public static EnumEntries<VLMSceneType> getEntries() {
        return f321476b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.camera.api.vlm.VLMSceneType$a] */
    static {
        VLMSceneType r100 = new VLMSceneType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        VLMSceneType r101 = new VLMSceneType("TAKE_PICTURE", 1, 1);
        TAKE_PICTURE = r101;
        VLMSceneType[] r102 = {r100, r101};
        f321475a = r102;
        f321476b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static VLMSceneType[] values() {
        return (VLMSceneType[]) f321475a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static VLMSceneType valueOf(String r100) {
        return (VLMSceneType) r27.a.a(VLMSceneType.class, r100);
    }

    public VLMSceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
