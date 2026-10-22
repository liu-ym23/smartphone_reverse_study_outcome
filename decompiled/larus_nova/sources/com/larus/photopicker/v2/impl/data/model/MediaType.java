package com.larus.photopicker.v2.impl.data.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/photopicker/v2/impl/data/model/MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO", "IMAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaType extends Enum<MediaType> {
    public static final MediaType IMAGE = null;
    public static final MediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaType[] f364371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364372b = null;

    public static EnumEntries<MediaType> getEntries() {
        return f364372b;
    }

    static {
        MediaType r100 = new MediaType("VIDEO", 0);
        VIDEO = r100;
        MediaType r101 = new MediaType("IMAGE", 1);
        IMAGE = r101;
        MediaType[] r102 = {r100, r101};
        f364371a = r102;
        f364372b = EnumEntriesKt.enumEntries(r102);
    }

    public static MediaType[] values() {
        return (MediaType[]) f364371a.clone();
    }

    public static MediaType valueOf(String r100) {
        return (MediaType) a.a(MediaType.class, r100);
    }

    public MediaType(String r100, int r101) {
        super(r100, r101);
    }
}
