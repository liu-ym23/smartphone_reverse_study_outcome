package com.larus.drive.biz.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/drive/biz/api/DrivePreloadScene;", "", "<init>", "(Ljava/lang/String;I)V", "OFFICE_SDK_READY", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrivePreloadScene extends Enum<DrivePreloadScene> {
    public static final DrivePreloadScene OFFICE_SDK_READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrivePreloadScene[] f341015a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341016b = null;

    public static EnumEntries<DrivePreloadScene> getEntries() {
        return f341016b;
    }

    static {
        DrivePreloadScene r100 = new DrivePreloadScene();
        OFFICE_SDK_READY = r100;
        DrivePreloadScene[] r101 = {r100};
        f341015a = r101;
        f341016b = EnumEntriesKt.enumEntries(r101);
    }

    public DrivePreloadScene() {
        super("OFFICE_SDK_READY", 0);
    }

    public static DrivePreloadScene[] values() {
        return (DrivePreloadScene[]) f341015a.clone();
    }

    public static DrivePreloadScene valueOf(String r100) {
        return (DrivePreloadScene) a.a(DrivePreloadScene.class, r100);
    }
}
