package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/ArgusEventType;", "", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "ARGUS_SCENE_UPDATED_ON_HOST_DEEPLINK_SESSION_CALLBACK", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusEventType extends Enum<ArgusEventType> {
    public static final ArgusEventType ARGUS_SCENE_UPDATED_ON_HOST_DEEPLINK_SESSION_CALLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusEventType[] f245815a = null;
    private final String eventName;

    public static ArgusEventType valueOf(String r100) {
        return (ArgusEventType) r27.a.a(ArgusEventType.class, r100);
    }

    public static ArgusEventType[] values() {
        return (ArgusEventType[]) f245815a.clone();
    }

    static {
        ArgusEventType r100 = new ArgusEventType();
        ARGUS_SCENE_UPDATED_ON_HOST_DEEPLINK_SESSION_CALLBACK = r100;
        f245815a = new ArgusEventType[]{r100};
    }

    public ArgusEventType() {
        super("ARGUS_SCENE_UPDATED_ON_HOST_DEEPLINK_SESSION_CALLBACK", 0);
        this.eventName = "scene_updated_on_host_deeplink_session_callback";
    }

    public final String getEventName() {
        return this.eventName;
    }
}
