package com.larus.voicecall.impl.component.vlm.camera.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/camera/core/CameraOpenScene;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY_START", "RECOVERY_RETRY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CameraOpenScene extends Enum<CameraOpenScene> {
    public static final CameraOpenScene PRIMARY_START = null;
    public static final CameraOpenScene RECOVERY_RETRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraOpenScene[] f377921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377922b = null;

    public static EnumEntries<CameraOpenScene> getEntries() {
        return f377922b;
    }

    static {
        CameraOpenScene r100 = new CameraOpenScene("PRIMARY_START", 0);
        PRIMARY_START = r100;
        CameraOpenScene r101 = new CameraOpenScene("RECOVERY_RETRY", 1);
        RECOVERY_RETRY = r101;
        CameraOpenScene[] r102 = {r100, r101};
        f377921a = r102;
        f377922b = EnumEntriesKt.enumEntries(r102);
    }

    public static CameraOpenScene[] values() {
        return (CameraOpenScene[]) f377921a.clone();
    }

    public static CameraOpenScene valueOf(String r100) {
        return (CameraOpenScene) a.a(CameraOpenScene.class, r100);
    }

    public CameraOpenScene(String r100, int r101) {
        super(r100, r101);
    }
}
