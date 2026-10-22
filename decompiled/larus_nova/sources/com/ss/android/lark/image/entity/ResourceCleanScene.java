package com.ss.android.lark.image.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_RESOURCE_CLEAN_SCENE", "UNIFIED_STORAGE_REGULARLY_DELETE", "CSAM_DELETE", "UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", "isCSAMDelete", "", "isPersonalDelete", "isUnifiedRegularDelete", "Companion", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceCleanScene extends Enum<ResourceCleanScene> {
    public static final ResourceCleanScene CSAM_DELETE = null;
    public static final a Companion = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = null;
    public static final ResourceCleanScene UNKNOWN_RESOURCE_CLEAN_SCENE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceCleanScene[] f426343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426344b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static ResourceCleanScene a(com.bytedance.lark.pb.basic.v1.ResourceCleanScene r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            int r101 = r100.clean_resource_scene.getValue();
            ResourceCleanScene r102 = ResourceCleanScene.UNKNOWN_RESOURCE_CLEAN_SCENE;
            if (r101 == r102.getValue()) goto L19;
            ResourceCleanScene r103 = ResourceCleanScene.UNIFIED_STORAGE_REGULARLY_DELETE;
            if (r101 == r103.getValue()) goto L17;
            r103 = ResourceCleanScene.CSAM_DELETE;
            if (r101 == r103.getValue()) goto L17;
            r103 = ResourceCleanScene.UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER;
            if (r101 == r103.getValue()) goto L17;
            return r102;
        L17:
            return r103;
        L19:
            return r102;
        }

        public static HashMap b(Map r100) {
            if (r100 == null) goto L4;
            HashMap r101 = new HashMap();
            Iterator r102 = r100.entrySet().iterator();
        L7:
            if (r102.hasNext() == false) goto L11;
            Map.Entry r103 = (Map.Entry) r102.next();
            a r104 = ResourceCleanScene.Companion;
            com.bytedance.lark.pb.basic.v1.ResourceCleanScene r105 = (com.bytedance.lark.pb.basic.v1.ResourceCleanScene) r103.getValue();
            r104.getClass();
            ResourceCleanScene r106 = a(r105);
            if (r106 == null) goto L7;
            r101.put(r103.getKey(), r106);
            goto L7
        L11:
            return r101;
        L4:
            return new HashMap();
        }
    }

    public static EnumEntries<ResourceCleanScene> getEntries() {
        return f426344b;
    }

    static {
        ResourceCleanScene r100 = new ResourceCleanScene("UNKNOWN_RESOURCE_CLEAN_SCENE", 0, 0);
        UNKNOWN_RESOURCE_CLEAN_SCENE = r100;
        ResourceCleanScene r101 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE", 1, 1);
        UNIFIED_STORAGE_REGULARLY_DELETE = r101;
        ResourceCleanScene r102 = new ResourceCleanScene("CSAM_DELETE", 2, 2);
        CSAM_DELETE = r102;
        ResourceCleanScene r103 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", 3, 3);
        UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = r103;
        ResourceCleanScene[] r104 = {r100, r101, r102, r103};
        f426343a = r104;
        f426344b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static ResourceCleanScene[] values() {
        return (ResourceCleanScene[]) f426343a.clone();
    }

    public final boolean isCSAMDelete() {
        if (this.value != CSAM_DELETE.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPersonalDelete() {
        if (this.value != UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isUnifiedRegularDelete() {
        int r100 = this.value;
        if (r100 >= CSAM_DELETE.value) goto L5;
    L8:
        return true;
    L5:
        if (r100 == UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER.value) goto L8;
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceCleanScene valueOf(String r100) {
        return (ResourceCleanScene) r27.a.a(ResourceCleanScene.class, r100);
    }

    public ResourceCleanScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
