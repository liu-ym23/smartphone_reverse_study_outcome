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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/FilePreviewStage;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UnknownStage", "Normal", "Encrypted", "NotSupportedType", "NotSupportedSize", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum FilePreviewStage extends Enum<FilePreviewStage> implements o0 {
    public static final ProtoAdapter<FilePreviewStage> ADAPTER = null;
    public static final b Companion = null;
    public static final FilePreviewStage Encrypted = null;
    public static final FilePreviewStage Normal = null;
    public static final FilePreviewStage NotSupportedSize = null;
    public static final FilePreviewStage NotSupportedType = null;
    public static final FilePreviewStage UnknownStage = null;
    public static final /* synthetic */ FilePreviewStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static FilePreviewStage a(int r1) {
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L22;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L19;
            return null;
        L19:
            return FilePreviewStage.NotSupportedSize;
        L20:
            return FilePreviewStage.NotSupportedType;
        L21:
            return FilePreviewStage.Encrypted;
        L22:
            return FilePreviewStage.Normal;
        L17:
            return FilePreviewStage.UnknownStage;
        }
    }

    @JvmStatic
    public static final FilePreviewStage fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<FilePreviewStage> getEntries() {
        return b;
    }

    static {
        final FilePreviewStage r0 = new FilePreviewStage("UnknownStage", 0, 0);
        UnknownStage = r0;
        FilePreviewStage r1 = new FilePreviewStage("Normal", 1, 1);
        Normal = r1;
        FilePreviewStage r3 = new FilePreviewStage("Encrypted", 2, 2);
        Encrypted = r3;
        FilePreviewStage r5 = new FilePreviewStage("NotSupportedType", 3, 3);
        NotSupportedType = r5;
        FilePreviewStage r7 = new FilePreviewStage("NotSupportedSize", 4, 4);
        NotSupportedSize = r7;
        FilePreviewStage[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(FilePreviewStage.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static FilePreviewStage[] values() {
        return (FilePreviewStage[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static FilePreviewStage valueOf(String r1) {
        return (FilePreviewStage) r27.a.a(FilePreviewStage.class, r1);
    }

    public FilePreviewStage(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
