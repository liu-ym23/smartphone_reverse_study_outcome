package com.larus.platform.api.creation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/platform/api/creation/PreLoadScene;", "", "<init>", "(Ljava/lang/String;I)V", "DIGITAL_AVTAR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreLoadScene extends Enum<PreLoadScene> {
    public static final PreLoadScene DIGITAL_AVTAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreLoadScene[] f364946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364947b = null;

    public static EnumEntries<PreLoadScene> getEntries() {
        return f364947b;
    }

    static {
        PreLoadScene r100 = new PreLoadScene();
        DIGITAL_AVTAR = r100;
        PreLoadScene[] r101 = {r100};
        f364946a = r101;
        f364947b = EnumEntriesKt.enumEntries(r101);
    }

    public PreLoadScene() {
        super("DIGITAL_AVTAR", 0);
    }

    public static PreLoadScene[] values() {
        return (PreLoadScene[]) f364946a.clone();
    }

    public static PreLoadScene valueOf(String r100) {
        return (PreLoadScene) a.a(PreLoadScene.class, r100);
    }
}
