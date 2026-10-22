package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ResourceCleanScene extends Enum<ResourceCleanScene> implements WireEnum {
    private static final /* synthetic */ ResourceCleanScene[] $VALUES = null;
    public static final ProtoAdapter<ResourceCleanScene> ADAPTER = null;
    public static final ResourceCleanScene CSAM_DELETE = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = null;
    public static final ResourceCleanScene UNKNOWN_RESOURCE_CLEAN_SCENE = null;
    private final int value;

    static {
        ResourceCleanScene r100 = new ResourceCleanScene("UNKNOWN_RESOURCE_CLEAN_SCENE", 0, 0);
        UNKNOWN_RESOURCE_CLEAN_SCENE = r100;
        ResourceCleanScene r101 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE", 1, 1);
        UNIFIED_STORAGE_REGULARLY_DELETE = r101;
        ResourceCleanScene r102 = new ResourceCleanScene("CSAM_DELETE", 2, 2);
        CSAM_DELETE = r102;
        ResourceCleanScene r103 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", 3, 3);
        UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = r103;
        $VALUES = new ResourceCleanScene[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResourceCleanScene.class);
    }

    public static ResourceCleanScene[] values() {
        return (ResourceCleanScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ResourceCleanScene fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER;
    L14:
        return CSAM_DELETE;
    L16:
        return UNIFIED_STORAGE_REGULARLY_DELETE;
    L18:
        return UNKNOWN_RESOURCE_CLEAN_SCENE;
    }

    public static ResourceCleanScene valueOf(String r100) {
        return (ResourceCleanScene) a.a(ResourceCleanScene.class, r100);
    }

    private ResourceCleanScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
