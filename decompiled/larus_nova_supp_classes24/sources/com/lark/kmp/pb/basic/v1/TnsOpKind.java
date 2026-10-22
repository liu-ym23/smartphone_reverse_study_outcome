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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TnsOpKind;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TNS_OP_NONE", "TNS_OP_BANNED", "TNS_OP_DISSOLVED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TnsOpKind extends Enum<TnsOpKind> implements o0 {
    public static final ProtoAdapter<TnsOpKind> ADAPTER = null;
    public static final b Companion = null;
    public static final TnsOpKind TNS_OP_BANNED = null;
    public static final TnsOpKind TNS_OP_DISSOLVED = null;
    public static final TnsOpKind TNS_OP_NONE = null;
    public static final /* synthetic */ TnsOpKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<TnsOpKind> getEntries() {
        return b;
    }

    static {
        final TnsOpKind r0 = new TnsOpKind("TNS_OP_NONE", 0, 0);
        TNS_OP_NONE = r0;
        TnsOpKind r1 = new TnsOpKind("TNS_OP_BANNED", 1, 1);
        TNS_OP_BANNED = r1;
        TnsOpKind r3 = new TnsOpKind("TNS_OP_DISSOLVED", 2, 2);
        TNS_OP_DISSOLVED = r3;
        TnsOpKind[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(TnsOpKind.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static TnsOpKind[] values() {
        return (TnsOpKind[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TnsOpKind fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return null;
    L14:
        return TNS_OP_DISSOLVED;
    L15:
        return TNS_OP_BANNED;
    L12:
        return TNS_OP_NONE;
    }

    public static TnsOpKind valueOf(String r1) {
        return (TnsOpKind) r27.a.a(TnsOpKind.class, r1);
    }

    public TnsOpKind(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
