package com.ss.android.lark.widget.cleanresource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/widget/cleanresource/ResourceType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "STICKER", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType FILE = null;
    public static final ResourceType IMAGE = null;
    public static final ResourceType STICKER = null;
    public static final ResourceType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceType[] f445657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445658b = null;

    public static EnumEntries<ResourceType> getEntries() {
        return f445658b;
    }

    static {
        ResourceType r100 = new ResourceType("IMAGE", 0);
        IMAGE = r100;
        ResourceType r101 = new ResourceType("VIDEO", 1);
        VIDEO = r101;
        ResourceType r102 = new ResourceType("FILE", 2);
        FILE = r102;
        ResourceType r103 = new ResourceType("STICKER", 3);
        STICKER = r103;
        ResourceType[] r104 = {r100, r101, r102, r103};
        f445657a = r104;
        f445658b = EnumEntriesKt.enumEntries(r104);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) f445657a.clone();
    }

    public static ResourceType valueOf(String r100) {
        return (ResourceType) a.a(ResourceType.class, r100);
    }

    public ResourceType(String r100, int r101) {
        super(r100, r101);
    }
}
