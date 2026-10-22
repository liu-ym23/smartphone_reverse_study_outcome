package com.larus.bmhome.view.resourcebar.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FILE", "IMAGE", "VIDEO", "ADD", "AUDIO", "CUSTOM", "AVATAR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType ADD = null;
    public static final ResourceType AUDIO = null;
    public static final ResourceType AVATAR = null;
    public static final ResourceType CUSTOM = null;
    public static final ResourceType FILE = null;
    public static final ResourceType IMAGE = null;
    public static final ResourceType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceType[] f317155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f317156b = null;
    private final int value;

    public static EnumEntries<ResourceType> getEntries() {
        return f317156b;
    }

    static {
        ResourceType r100 = new ResourceType("FILE", 0, 0);
        FILE = r100;
        ResourceType r101 = new ResourceType("IMAGE", 1, 1);
        IMAGE = r101;
        ResourceType r102 = new ResourceType("VIDEO", 2, 2);
        VIDEO = r102;
        ResourceType r103 = new ResourceType("ADD", 3, 100);
        ADD = r103;
        ResourceType r104 = new ResourceType("AUDIO", 4, 3);
        AUDIO = r104;
        ResourceType r105 = new ResourceType("CUSTOM", 5, 101);
        CUSTOM = r105;
        ResourceType r110 = new ResourceType("AVATAR", 6, 200);
        AVATAR = r110;
        ResourceType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f317155a = r111;
        f317156b = EnumEntriesKt.enumEntries(r111);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) f317155a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceType valueOf(String r100) {
        return (ResourceType) a.a(ResourceType.class, r100);
    }

    public ResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
