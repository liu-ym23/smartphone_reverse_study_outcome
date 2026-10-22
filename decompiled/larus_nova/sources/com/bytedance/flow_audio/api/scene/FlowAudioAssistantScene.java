package com.bytedance.flow_audio.api.scene;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017j\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/flow_audio/api/scene/FlowAudioAssistantScene;", "", "rawValue", "", "sceneInfo", "Lcom/bytedance/flow_audio/api/scene/FlowAudioSceneInfo;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/flow_audio/api/scene/FlowAudioSceneInfo;)V", "getRawValue", "()Ljava/lang/String;", "setRawValue", "(Ljava/lang/String;)V", "getSceneInfo", "()Lcom/bytedance/flow_audio/api/scene/FlowAudioSceneInfo;", "setSceneInfo", "(Lcom/bytedance/flow_audio/api/scene/FlowAudioSceneInfo;)V", "Im", "Other", "businessInfo", "getBusinessInfo", "business", "", "getBusiness", "()I", "Companion", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAudioAssistantScene extends Enum<FlowAudioAssistantScene> {
    public static final a Companion = null;
    public static final FlowAudioAssistantScene Im = null;
    public static final FlowAudioAssistantScene Other = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, vw5.a> f243722a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FlowAudioAssistantScene[] f243723b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243724c = null;
    private String rawValue;
    private vw5.a sceneInfo;

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f243725a = null;

        static {
            int[] r100 = new int[FlowAudioAssistantScene.values().length];
            r100[FlowAudioAssistantScene.Im.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FlowAudioAssistantScene.Other.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f243725a = r100;
        }
    }

    public static EnumEntries<FlowAudioAssistantScene> getEntries() {
        return f243724c;
    }

    public final vw5.a getSceneInfo() {
        return null;
    }

    public final void setSceneInfo(vw5.a r100) {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene$a] */
    static {
        FlowAudioAssistantScene r100 = new FlowAudioAssistantScene("Im", 0, "im");
        Im = r100;
        FlowAudioAssistantScene r101 = new FlowAudioAssistantScene("Other", 1, "other");
        Other = r101;
        FlowAudioAssistantScene[] r102 = {r100, r101};
        f243723b = r102;
        f243724c = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
        f243722a = new LinkedHashMap();
    }

    public static FlowAudioAssistantScene[] values() {
        return (FlowAudioAssistantScene[]) f243723b.clone();
    }

    public final int getBusiness() {
        int r100 = b.f243725a[ordinal()];
        return 1;
    }

    public final String getBusinessInfo() {
        int r100 = b.f243725a[ordinal()];
        if (r100 != 1) goto L5;
        return "flowV2";
    L5:
        if (r100 != 2) goto L8;
        return null;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Map access$getOtherSceneInfoMap$cp() {
        return f243722a;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public static FlowAudioAssistantScene valueOf(String r100) {
        return (FlowAudioAssistantScene) r27.a.a(FlowAudioAssistantScene.class, r100);
    }

    public final void setRawValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rawValue = r100;
    }

    public FlowAudioAssistantScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
