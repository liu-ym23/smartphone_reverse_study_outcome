package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "", "(Ljava/lang/String;I)V", "into", "Llark_markdown_render/proto/FontWeight;", "intoInt", "", "Regular", "Bold", "Companion", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FontWeight extends Enum<FontWeight> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FontWeight[] $VALUES = null;
    public static final FontWeight Bold = null;
    public static final Companion Companion = null;
    public static final FontWeight Regular = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/FontWeight$Companion;", "", "()V", "fromInt", "Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "value", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final FontWeight fromInt(int r2) {
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L7;
            return FontWeight.Bold;
        L7:
            throw new RuntimeException("Unmatched primitive enum value: FontWeight with ");
        L9:
            return FontWeight.Regular;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FontWeight.values().length];
            r0[FontWeight.Regular.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FontWeight.Bold.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final /* synthetic */ FontWeight[] $values() {
        return new FontWeight[]{Regular, Bold};
    }

    @JvmStatic
    public static final FontWeight fromInt(int r1) {
        return Companion.fromInt(r1);
    }

    public static EnumEntries<FontWeight> getEntries() {
        return $ENTRIES;
    }

    public static FontWeight valueOf(String r1) {
        return (FontWeight) a.a(FontWeight.class, r1);
    }

    public static FontWeight[] values() {
        return (FontWeight[]) $VALUES.clone();
    }

    static {
        Regular = new FontWeight("Regular", 0);
        Bold = new FontWeight("Bold", 1);
        FontWeight[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public final lark_markdown_render.proto.FontWeight into() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return lark_markdown_render.proto.FontWeight.VAR_FONT_WEIGHT_BOLD;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return lark_markdown_render.proto.FontWeight.VAR_FONT_WEIGHT_REGULAR;
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

    private FontWeight(String r1, int r2) {
        super(r1, r2);
    }
}
