package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/FilterType;", "", "", "value", "I", "getValue", "()I", "None", "Grayscale", "Blur", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FilterType extends Enum<FilterType> {
    public static final FilterType Blur = null;
    public static final FilterType Grayscale = null;
    public static final FilterType None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FilterType[] f404719a = null;
    private final int value;

    public static FilterType valueOf(String r100) {
        return (FilterType) r27.a.a(FilterType.class, r100);
    }

    public static FilterType[] values() {
        return (FilterType[]) f404719a.clone();
    }

    static {
        FilterType r100 = new FilterType("None", 0, 0);
        None = r100;
        FilterType r101 = new FilterType("Grayscale", 1, 1);
        Grayscale = r101;
        FilterType r102 = new FilterType("Blur", 2, 2);
        Blur = r102;
        f404719a = new FilterType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public FilterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
