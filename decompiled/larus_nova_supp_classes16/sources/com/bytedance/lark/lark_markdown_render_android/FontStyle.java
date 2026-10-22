package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "", "(Ljava/lang/String;I)V", "into", "Llark_markdown_render/proto/FontStyle;", "intoInt", "", "Normal", "Italic", "Companion", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FontStyle extends Enum<FontStyle> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FontStyle[] $VALUES = null;
    public static final Companion Companion = null;
    public static final FontStyle Italic = null;
    public static final FontStyle Normal = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/FontStyle$Companion;", "", "()V", "fromInt", "Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "value", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final FontStyle fromInt(int r2) {
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L7;
            return FontStyle.Italic;
        L7:
            throw new RuntimeException("Unmatched primitive enum value: FontStyle with ");
        L9:
            return FontStyle.Normal;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FontStyle.values().length];
            r0[FontStyle.Normal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FontStyle.Italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final /* synthetic */ FontStyle[] $values() {
        return new FontStyle[]{Normal, Italic};
    }

    @JvmStatic
    public static final FontStyle fromInt(int r1) {
        return Companion.fromInt(r1);
    }

    public static EnumEntries<FontStyle> getEntries() {
        return $ENTRIES;
    }

    public static FontStyle valueOf(String r1) {
        return (FontStyle) a.a(FontStyle.class, r1);
    }

    public static FontStyle[] values() {
        return (FontStyle[]) $VALUES.clone();
    }

    static {
        Normal = new FontStyle("Normal", 0);
        Italic = new FontStyle("Italic", 1);
        FontStyle[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public final lark_markdown_render.proto.FontStyle into() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return lark_markdown_render.proto.FontStyle.VAR_FONT_STYLE_ITALIC;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_markdown_render.proto.FontStyle.VAR_FONT_STYLE_NORMAL;
    }

    public final int intoInt() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 != 1) goto L5;
        return 0;
    L5:
        if (r0 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private FontStyle(String r1, int r2) {
        super(r1, r2);
    }
}
