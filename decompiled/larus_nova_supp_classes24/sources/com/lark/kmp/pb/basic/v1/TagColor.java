package com.lark.kmp.pb.basic.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TagColor;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BLUE", "GRAY", "INDIGO", "WATHET", "GREEN", "TURQUOISE", "YELLOW", "LIME", "RED", "ORANGE", "PURPLE", "VIOLET", "CARMINE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TagColor extends Enum<TagColor> implements o0 {
    public static final ProtoAdapter<TagColor> ADAPTER = null;
    public static final TagColor BLUE = null;
    public static final TagColor CARMINE = null;
    public static final b Companion = null;
    public static final TagColor GRAY = null;
    public static final TagColor GREEN = null;
    public static final TagColor INDIGO = null;
    public static final TagColor LIME = null;
    public static final TagColor ORANGE = null;
    public static final TagColor PURPLE = null;
    public static final TagColor RED = null;
    public static final TagColor TURQUOISE = null;
    public static final TagColor VIOLET = null;
    public static final TagColor WATHET = null;
    public static final TagColor YELLOW = null;
    public static final /* synthetic */ TagColor[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static TagColor a(int r0) {
            switch(r0) {
                case 0: goto L17;
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L28;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L21;
                case 11: goto L20;
                case 12: goto L19;
                default: goto L3;
            };
        L3:
            return null;
        L19:
            return TagColor.CARMINE;
        L20:
            return TagColor.VIOLET;
        L21:
            return TagColor.PURPLE;
        L22:
            return TagColor.ORANGE;
        L23:
            return TagColor.RED;
        L24:
            return TagColor.LIME;
        L25:
            return TagColor.YELLOW;
        L26:
            return TagColor.TURQUOISE;
        L27:
            return TagColor.GREEN;
        L28:
            return TagColor.WATHET;
        L29:
            return TagColor.INDIGO;
        L30:
            return TagColor.GRAY;
        L17:
            return TagColor.BLUE;
        }
    }

    @JvmStatic
    public static final TagColor fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<TagColor> getEntries() {
        return b;
    }

    static {
        final TagColor r0 = new TagColor("BLUE", 0, 0);
        BLUE = r0;
        TagColor r1 = new TagColor("GRAY", 1, 1);
        GRAY = r1;
        TagColor r3 = new TagColor("INDIGO", 2, 2);
        INDIGO = r3;
        TagColor r5 = new TagColor("WATHET", 3, 3);
        WATHET = r5;
        TagColor r7 = new TagColor("GREEN", 4, 4);
        GREEN = r7;
        TagColor r9 = new TagColor("TURQUOISE", 5, 5);
        TURQUOISE = r9;
        TagColor r11 = new TagColor("YELLOW", 6, 6);
        YELLOW = r11;
        TagColor r13 = new TagColor("LIME", 7, 7);
        LIME = r13;
        TagColor r15 = new TagColor("RED", 8, 8);
        RED = r15;
        TagColor r14 = new TagColor("ORANGE", 9, 9);
        ORANGE = r14;
        TagColor r12 = new TagColor("PURPLE", 10, 10);
        PURPLE = r12;
        TagColor r10 = new TagColor("VIOLET", 11, 11);
        VIOLET = r10;
        TagColor r8 = new TagColor("CARMINE", 12, 12);
        CARMINE = r8;
        TagColor[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(TagColor.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static TagColor[] values() {
        return (TagColor[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static TagColor valueOf(String r1) {
        return (TagColor) r27.a.a(TagColor.class, r1);
    }

    public TagColor(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
