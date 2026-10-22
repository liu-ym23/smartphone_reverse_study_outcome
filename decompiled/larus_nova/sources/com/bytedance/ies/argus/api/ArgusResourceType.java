package com.bytedance.ies.argus.api;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusResourceType;", "", "LYNX_MAIN_TEMPLATE", "LYNX_EXTERNAL_JS", "LYNX_COMPONENT", "LYNX_STATIC_RESOURCE", "LYNX_CHILD_RESOURCE", FlowDoraWifiScene.OTHER, "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusResourceType extends Enum<ArgusResourceType> {
    public static final ArgusResourceType LYNX_CHILD_RESOURCE = null;
    public static final ArgusResourceType LYNX_COMPONENT = null;
    public static final ArgusResourceType LYNX_EXTERNAL_JS = null;
    public static final ArgusResourceType LYNX_MAIN_TEMPLATE = null;
    public static final ArgusResourceType LYNX_STATIC_RESOURCE = null;
    public static final ArgusResourceType OTHER = null;
    public static final ArgusResourceType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusResourceType[] f245629a = null;

    public static ArgusResourceType valueOf(String r100) {
        return (ArgusResourceType) r27.a.a(ArgusResourceType.class, r100);
    }

    public static ArgusResourceType[] values() {
        return (ArgusResourceType[]) f245629a.clone();
    }

    static {
        ArgusResourceType r100 = new ArgusResourceType("LYNX_MAIN_TEMPLATE", 0);
        LYNX_MAIN_TEMPLATE = r100;
        ArgusResourceType r101 = new ArgusResourceType("LYNX_EXTERNAL_JS", 1);
        LYNX_EXTERNAL_JS = r101;
        ArgusResourceType r102 = new ArgusResourceType("LYNX_COMPONENT", 2);
        LYNX_COMPONENT = r102;
        ArgusResourceType r103 = new ArgusResourceType("LYNX_STATIC_RESOURCE", 3);
        LYNX_STATIC_RESOURCE = r103;
        ArgusResourceType r104 = new ArgusResourceType("LYNX_CHILD_RESOURCE", 4);
        LYNX_CHILD_RESOURCE = r104;
        ArgusResourceType r105 = new ArgusResourceType(FlowDoraWifiScene.OTHER, 5);
        OTHER = r105;
        ArgusResourceType r110 = new ArgusResourceType("UNKNOWN", 6);
        UNKNOWN = r110;
        f245629a = new ArgusResourceType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public ArgusResourceType(String r100, int r101) {
        super(r100, r101);
    }
}
