package com.larus.camera.api.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/api/vlm/VLMIntentScene;", "", "<init>", "(Ljava/lang/String;I)V", "COMMON", "QUESTION_SOLVING", "HOMEWORK_CORRECTION", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VLMIntentScene extends Enum<VLMIntentScene> {
    public static final VLMIntentScene COMMON = null;
    public static final VLMIntentScene HOMEWORK_CORRECTION = null;
    public static final VLMIntentScene QUESTION_SOLVING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VLMIntentScene[] f321471a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321472b = null;

    public static EnumEntries<VLMIntentScene> getEntries() {
        return f321472b;
    }

    static {
        VLMIntentScene r100 = new VLMIntentScene("COMMON", 0);
        COMMON = r100;
        VLMIntentScene r101 = new VLMIntentScene("QUESTION_SOLVING", 1);
        QUESTION_SOLVING = r101;
        VLMIntentScene r102 = new VLMIntentScene("HOMEWORK_CORRECTION", 2);
        HOMEWORK_CORRECTION = r102;
        VLMIntentScene[] r103 = {r100, r101, r102};
        f321471a = r103;
        f321472b = EnumEntriesKt.enumEntries(r103);
    }

    public static VLMIntentScene[] values() {
        return (VLMIntentScene[]) f321471a.clone();
    }

    public static VLMIntentScene valueOf(String r100) {
        return (VLMIntentScene) a.a(VLMIntentScene.class, r100);
    }

    public VLMIntentScene(String r100, int r101) {
        super(r100, r101);
    }
}
