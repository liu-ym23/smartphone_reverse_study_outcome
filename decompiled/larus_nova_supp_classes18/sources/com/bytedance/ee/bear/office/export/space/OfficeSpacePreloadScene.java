package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadScene;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "OFFICE_SDK_READY", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadScene extends Enum<OfficeSpacePreloadScene> implements Serializable {
    public static final OfficeSpacePreloadScene OFFICE_SDK_READY = null;
    public static final /* synthetic */ OfficeSpacePreloadScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpacePreloadScene> getEntries() {
        return b;
    }

    static {
        OfficeSpacePreloadScene r0 = new OfficeSpacePreloadScene();
        OFFICE_SDK_READY = r0;
        OfficeSpacePreloadScene[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public OfficeSpacePreloadScene() {
        super("OFFICE_SDK_READY", 0);
    }

    public static OfficeSpacePreloadScene[] values() {
        return (OfficeSpacePreloadScene[]) a.clone();
    }

    public static OfficeSpacePreloadScene valueOf(String r1) {
        return (OfficeSpacePreloadScene) r27.a.a(OfficeSpacePreloadScene.class, r1);
    }
}
