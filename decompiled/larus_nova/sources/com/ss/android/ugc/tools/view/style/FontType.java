package com.ss.android.ugc.tools.view.style;

import com.lynx.canvas.KryptonCamera;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/FontType;", "", "", "FONT_NAME", "Ljava/lang/String;", "getFONT_NAME", "()Ljava/lang/String;", "", "VALUE", "I", "getVALUE", "()I", "REGULAR", "BOLD", "BOLD_ITALIC", "ITALIC", "LIGHT", "LIGHT_ITALIC", "MEDIUM", "MEDIUM_ITALIC", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final enum FontType extends Enum<FontType> {
    public static final FontType BOLD = null;
    public static final FontType BOLD_ITALIC = null;
    public static final FontType ITALIC = null;
    public static final FontType LIGHT = null;
    public static final FontType LIGHT_ITALIC = null;
    public static final FontType MEDIUM = null;
    public static final FontType MEDIUM_ITALIC = null;
    public static final FontType REGULAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FontType[] f454894a = null;
    private final String FONT_NAME;
    private final int VALUE;

    public static FontType valueOf(String r100) {
        return (FontType) r27.a.a(FontType.class, r100);
    }

    public static FontType[] values() {
        return (FontType[]) f454894a.clone();
    }

    static {
        FontType r100 = new FontType("REGULAR", 0, "regular", 1);
        REGULAR = r100;
        FontType r101 = new FontType("BOLD", 1, CommodityText.BOLD, 2);
        BOLD = r101;
        FontType r102 = new FontType("BOLD_ITALIC", 2, "boldItalic", 3);
        BOLD_ITALIC = r102;
        FontType r103 = new FontType("ITALIC", 3, "italic", 4);
        ITALIC = r103;
        FontType r104 = new FontType("LIGHT", 4, "light", 5);
        LIGHT = r104;
        FontType r105 = new FontType("LIGHT_ITALIC", 5, "lightItalic", 6);
        LIGHT_ITALIC = r105;
        FontType r106 = new FontType("MEDIUM", 6, KryptonCamera.Config.RESOLUTION_MEDIUM, 7);
        MEDIUM = r106;
        FontType r107 = new FontType("MEDIUM_ITALIC", 7, "mediumItalic", 8);
        MEDIUM_ITALIC = r107;
        f454894a = new FontType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getFONT_NAME() {
        return this.FONT_NAME;
    }

    public final int getVALUE() {
        return this.VALUE;
    }

    public FontType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.FONT_NAME = r102;
        this.VALUE = r103;
    }
}
