package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/salamander/anniex/AccessLayerStringField;", "", "", "value", "I", "getValue", "()I", "CoreViewType", "Biz", "ClientComponent", "Schema", "TemplateResType", "ViewType", "ContainerType", "SdkVersion", "NativePage", "LynxVersion", "WebViewType", "WebEngineVersion", "Url", "GeckoId", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AccessLayerStringField extends Enum<AccessLayerStringField> {
    public static final AccessLayerStringField Biz = null;
    public static final AccessLayerStringField ClientComponent = null;
    public static final AccessLayerStringField ContainerType = null;
    public static final AccessLayerStringField CoreViewType = null;
    public static final AccessLayerStringField GeckoId = null;
    public static final AccessLayerStringField LynxVersion = null;
    public static final AccessLayerStringField NativePage = null;
    public static final AccessLayerStringField Schema = null;
    public static final AccessLayerStringField SdkVersion = null;
    public static final AccessLayerStringField TemplateResType = null;
    public static final AccessLayerStringField Url = null;
    public static final AccessLayerStringField ViewType = null;
    public static final AccessLayerStringField WebEngineVersion = null;
    public static final AccessLayerStringField WebViewType = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccessLayerStringField[] f267802a = null;
    private final int value;

    public static AccessLayerStringField valueOf(String r100) {
        return (AccessLayerStringField) r27.a.a(AccessLayerStringField.class, r100);
    }

    public static AccessLayerStringField[] values() {
        return (AccessLayerStringField[]) f267802a.clone();
    }

    static {
        AccessLayerStringField r100 = new AccessLayerStringField("CoreViewType", 0, 0);
        CoreViewType = r100;
        AccessLayerStringField r101 = new AccessLayerStringField("Biz", 1, 1);
        Biz = r101;
        AccessLayerStringField r102 = new AccessLayerStringField("ClientComponent", 2, 2);
        ClientComponent = r102;
        AccessLayerStringField r103 = new AccessLayerStringField("Schema", 3, 3);
        Schema = r103;
        AccessLayerStringField r104 = new AccessLayerStringField("TemplateResType", 4, 4);
        TemplateResType = r104;
        AccessLayerStringField r105 = new AccessLayerStringField("ViewType", 5, 5);
        ViewType = r105;
        AccessLayerStringField r110 = new AccessLayerStringField("ContainerType", 6, 6);
        ContainerType = r110;
        AccessLayerStringField r111 = new AccessLayerStringField("SdkVersion", 7, 7);
        SdkVersion = r111;
        AccessLayerStringField r112 = new AccessLayerStringField("NativePage", 8, 8);
        NativePage = r112;
        AccessLayerStringField r113 = new AccessLayerStringField("LynxVersion", 9, 9);
        LynxVersion = r113;
        AccessLayerStringField r114 = new AccessLayerStringField("WebViewType", 10, 10);
        WebViewType = r114;
        AccessLayerStringField r115 = new AccessLayerStringField("WebEngineVersion", 11, 11);
        WebEngineVersion = r115;
        AccessLayerStringField r106 = new AccessLayerStringField("Url", 12, 12);
        Url = r106;
        AccessLayerStringField r107 = new AccessLayerStringField("GeckoId", 13, 13);
        GeckoId = r107;
        f267802a = new AccessLayerStringField[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public AccessLayerStringField(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
