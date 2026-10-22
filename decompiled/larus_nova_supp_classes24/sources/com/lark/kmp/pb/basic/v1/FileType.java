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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/FileType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "DOC", "PDF", "PPT", "XLS", "ZIP", "PSD", "AI", "SKETCH", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum FileType extends Enum<FileType> implements o0 {
    public static final ProtoAdapter<FileType> ADAPTER = null;
    public static final FileType AI = null;
    public static final b Companion = null;
    public static final FileType DEFAULT = null;
    public static final FileType DOC = null;
    public static final FileType PDF = null;
    public static final FileType PPT = null;
    public static final FileType PSD = null;
    public static final FileType SKETCH = null;
    public static final FileType XLS = null;
    public static final FileType ZIP = null;
    public static final /* synthetic */ FileType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static FileType a(int r0) {
            switch(r0) {
                case 1: goto L13;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                default: goto L3;
            };
        L3:
            return null;
        L15:
            return FileType.SKETCH;
        L16:
            return FileType.AI;
        L17:
            return FileType.PSD;
        L18:
            return FileType.ZIP;
        L19:
            return FileType.XLS;
        L20:
            return FileType.PPT;
        L21:
            return FileType.PDF;
        L22:
            return FileType.DOC;
        L13:
            return FileType.DEFAULT;
        }
    }

    @JvmStatic
    public static final FileType fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<FileType> getEntries() {
        return b;
    }

    static {
        FileType r0 = new FileType("DEFAULT", 0, 1);
        DEFAULT = r0;
        FileType r1 = new FileType("DOC", 1, 2);
        DOC = r1;
        FileType r4 = new FileType("PDF", 2, 3);
        PDF = r4;
        FileType r6 = new FileType("PPT", 3, 4);
        PPT = r6;
        FileType r8 = new FileType("XLS", 4, 5);
        XLS = r8;
        FileType r10 = new FileType("ZIP", 5, 6);
        ZIP = r10;
        FileType r12 = new FileType("PSD", 6, 7);
        PSD = r12;
        FileType r14 = new FileType("AI", 7, 8);
        AI = r14;
        FileType r13 = new FileType("SKETCH", 8, 9);
        SKETCH = r13;
        FileType[] r9 = {r0, r1, r4, r6, r8, r10, r12, r14, r13};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(FileType.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r3);
    }

    public static FileType[] values() {
        return (FileType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static FileType valueOf(String r1) {
        return (FileType) r27.a.a(FileType.class, r1);
    }

    public FileType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
