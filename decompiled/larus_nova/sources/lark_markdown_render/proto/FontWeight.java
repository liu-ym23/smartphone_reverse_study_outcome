package lark_markdown_render.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FontWeight extends Enum<FontWeight> implements WireEnum {
    private static final /* synthetic */ FontWeight[] $VALUES = null;
    public static final ProtoAdapter<FontWeight> ADAPTER = null;
    public static final FontWeight VAR_FONT_WEIGHT_BOLD = null;
    public static final FontWeight VAR_FONT_WEIGHT_REGULAR = null;
    private final int value;

    static {
        FontWeight r100 = new FontWeight("VAR_FONT_WEIGHT_REGULAR", 0, 0);
        VAR_FONT_WEIGHT_REGULAR = r100;
        FontWeight r101 = new FontWeight("VAR_FONT_WEIGHT_BOLD", 1, 1);
        VAR_FONT_WEIGHT_BOLD = r101;
        $VALUES = new FontWeight[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(FontWeight.class);
    }

    public static FontWeight[] values() {
        return (FontWeight[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FontWeight fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_FONT_WEIGHT_BOLD;
    L10:
        return VAR_FONT_WEIGHT_REGULAR;
    }

    public static FontWeight valueOf(String r100) {
        return (FontWeight) a.a(FontWeight.class, r100);
    }

    private FontWeight(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
