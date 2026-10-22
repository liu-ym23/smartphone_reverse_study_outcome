package lark_markdown_render.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FontStyle extends Enum<FontStyle> implements WireEnum {
    private static final /* synthetic */ FontStyle[] $VALUES = null;
    public static final ProtoAdapter<FontStyle> ADAPTER = null;
    public static final FontStyle VAR_FONT_STYLE_ITALIC = null;
    public static final FontStyle VAR_FONT_STYLE_NORMAL = null;
    private final int value;

    static {
        FontStyle r100 = new FontStyle("VAR_FONT_STYLE_NORMAL", 0, 0);
        VAR_FONT_STYLE_NORMAL = r100;
        FontStyle r101 = new FontStyle("VAR_FONT_STYLE_ITALIC", 1, 1);
        VAR_FONT_STYLE_ITALIC = r101;
        $VALUES = new FontStyle[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(FontStyle.class);
    }

    public static FontStyle[] values() {
        return (FontStyle[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FontStyle fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_FONT_STYLE_ITALIC;
    L10:
        return VAR_FONT_STYLE_NORMAL;
    }

    public static FontStyle valueOf(String r100) {
        return (FontStyle) a.a(FontStyle.class, r100);
    }

    private FontStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
