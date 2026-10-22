package com.ivy.ivykit.api.bridge.core.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ivy/ivykit/api/bridge/core/model/IvyReadableType;", "", "Null", "Boolean", "Number", "Int", "String", "Map", "Array", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public final enum IvyReadableType extends Enum<IvyReadableType> {
    public static final IvyReadableType Array = null;
    public static final IvyReadableType Boolean = null;
    public static final IvyReadableType Int = null;
    public static final IvyReadableType Map = null;
    public static final IvyReadableType Null = null;
    public static final IvyReadableType Number = null;
    public static final IvyReadableType String = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IvyReadableType[] f278314a = null;

    public static IvyReadableType valueOf(String r100) {
        return (IvyReadableType) a.a(IvyReadableType.class, r100);
    }

    public static IvyReadableType[] values() {
        return (IvyReadableType[]) f278314a.clone();
    }

    static {
        IvyReadableType r100 = new IvyReadableType("Null", 0);
        Null = r100;
        IvyReadableType r101 = new IvyReadableType("Boolean", 1);
        Boolean = r101;
        IvyReadableType r102 = new IvyReadableType("Number", 2);
        Number = r102;
        IvyReadableType r103 = new IvyReadableType("Int", 3);
        Int = r103;
        IvyReadableType r104 = new IvyReadableType("String", 4);
        String = r104;
        IvyReadableType r105 = new IvyReadableType("Map", 5);
        Map = r105;
        IvyReadableType r110 = new IvyReadableType("Array", 6);
        Array = r110;
        f278314a = new IvyReadableType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public IvyReadableType(String r100, int r101) {
        super(r100, r101);
    }
}
