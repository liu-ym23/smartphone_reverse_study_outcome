package com.larus.camera.api.vlm;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/camera/api/vlm/VLMIntentTrackSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MAIN_CAMERA", "EDU_CAMERA_QA", "EDU_CAMERA_HOMEWORK", FlowDoraWifiScene.ALBUM, "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VLMIntentTrackSource extends Enum<VLMIntentTrackSource> {
    public static final VLMIntentTrackSource ALBUM = null;
    public static final VLMIntentTrackSource EDU_CAMERA_HOMEWORK = null;
    public static final VLMIntentTrackSource EDU_CAMERA_QA = null;
    public static final VLMIntentTrackSource MAIN_CAMERA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VLMIntentTrackSource[] f321473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321474b = null;
    private final String value;

    public static EnumEntries<VLMIntentTrackSource> getEntries() {
        return f321474b;
    }

    static {
        VLMIntentTrackSource r100 = new VLMIntentTrackSource("MAIN_CAMERA", 0, "main_camera");
        MAIN_CAMERA = r100;
        VLMIntentTrackSource r101 = new VLMIntentTrackSource("EDU_CAMERA_QA", 1, "edu_camera_qa");
        EDU_CAMERA_QA = r101;
        VLMIntentTrackSource r102 = new VLMIntentTrackSource("EDU_CAMERA_HOMEWORK", 2, "edu_camera_homework");
        EDU_CAMERA_HOMEWORK = r102;
        VLMIntentTrackSource r103 = new VLMIntentTrackSource(FlowDoraWifiScene.ALBUM, 3, "album");
        ALBUM = r103;
        VLMIntentTrackSource[] r104 = {r100, r101, r102, r103};
        f321473a = r104;
        f321474b = EnumEntriesKt.enumEntries(r104);
    }

    public static VLMIntentTrackSource[] values() {
        return (VLMIntentTrackSource[]) f321473a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static VLMIntentTrackSource valueOf(String r100) {
        return (VLMIntentTrackSource) a.a(VLMIntentTrackSource.class, r100);
    }

    public VLMIntentTrackSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
