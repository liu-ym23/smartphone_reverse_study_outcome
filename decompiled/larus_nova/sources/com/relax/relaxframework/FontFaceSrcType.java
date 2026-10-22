package com.relax.relaxframework;

import com.amap.api.services.cloud.CloudSearch;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/FontFaceSrcType;", "", "", "value", "I", "getValue", "()I", "Url", CloudSearch.SearchBound.LOCAL_SHAPE, "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FontFaceSrcType extends Enum<FontFaceSrcType> {
    public static final FontFaceSrcType Local = null;
    public static final FontFaceSrcType Url = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FontFaceSrcType[] f404727a = null;
    private final int value;

    public static FontFaceSrcType valueOf(String r100) {
        return (FontFaceSrcType) r27.a.a(FontFaceSrcType.class, r100);
    }

    public static FontFaceSrcType[] values() {
        return (FontFaceSrcType[]) f404727a.clone();
    }

    static {
        FontFaceSrcType r100 = new FontFaceSrcType("Url", 0, 1);
        Url = r100;
        FontFaceSrcType r101 = new FontFaceSrcType(CloudSearch.SearchBound.LOCAL_SHAPE, 1, 2);
        Local = r101;
        f404727a = new FontFaceSrcType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public FontFaceSrcType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
