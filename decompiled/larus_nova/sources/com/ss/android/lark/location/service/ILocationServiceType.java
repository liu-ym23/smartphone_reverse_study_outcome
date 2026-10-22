package com.ss.android.lark.location.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/location/service/ILocationServiceType;", "", "priority", "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "SERVICE_AMAP", "SERVICE_GOOGLE_BING", "SERVICE_GOOGLE", "SERVICE_BINGMAP", "location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ILocationServiceType extends Enum<ILocationServiceType> {
    public static final ILocationServiceType SERVICE_AMAP = null;
    public static final ILocationServiceType SERVICE_BINGMAP = null;
    public static final ILocationServiceType SERVICE_GOOGLE = null;
    public static final ILocationServiceType SERVICE_GOOGLE_BING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILocationServiceType[] f431190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431191b = null;
    private final int priority;

    public static EnumEntries<ILocationServiceType> getEntries() {
        return f431191b;
    }

    static {
        ILocationServiceType r100 = new ILocationServiceType("SERVICE_AMAP", 0, 10);
        SERVICE_AMAP = r100;
        ILocationServiceType r101 = new ILocationServiceType("SERVICE_GOOGLE_BING", 1, 20);
        SERVICE_GOOGLE_BING = r101;
        ILocationServiceType r102 = new ILocationServiceType("SERVICE_GOOGLE", 2, 30);
        SERVICE_GOOGLE = r102;
        ILocationServiceType r103 = new ILocationServiceType("SERVICE_BINGMAP", 3, 40);
        SERVICE_BINGMAP = r103;
        ILocationServiceType[] r104 = {r100, r101, r102, r103};
        f431190a = r104;
        f431191b = EnumEntriesKt.enumEntries(r104);
    }

    public static ILocationServiceType[] values() {
        return (ILocationServiceType[]) f431190a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public static ILocationServiceType valueOf(String r100) {
        return (ILocationServiceType) r27.a.a(ILocationServiceType.class, r100);
    }

    public ILocationServiceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
