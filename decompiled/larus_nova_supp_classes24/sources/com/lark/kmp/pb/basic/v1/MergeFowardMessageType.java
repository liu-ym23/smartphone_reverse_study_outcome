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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MergeFowardMessageType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MERGE_MESSAGE", "MERGE_THREAD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum MergeFowardMessageType extends Enum<MergeFowardMessageType> implements o0 {
    public static final ProtoAdapter<MergeFowardMessageType> ADAPTER = null;
    public static final b Companion = null;
    public static final MergeFowardMessageType MERGE_MESSAGE = null;
    public static final MergeFowardMessageType MERGE_THREAD = null;
    public static final /* synthetic */ MergeFowardMessageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<MergeFowardMessageType> getEntries() {
        return b;
    }

    static {
        MergeFowardMessageType r0 = new MergeFowardMessageType("MERGE_MESSAGE", 0, 1);
        MERGE_MESSAGE = r0;
        MergeFowardMessageType r1 = new MergeFowardMessageType("MERGE_THREAD", 1, 2);
        MERGE_THREAD = r1;
        MergeFowardMessageType[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(MergeFowardMessageType.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r3);
    }

    public static MergeFowardMessageType[] values() {
        return (MergeFowardMessageType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MergeFowardMessageType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L11;
        return null;
    L11:
        return MERGE_THREAD;
    L9:
        return MERGE_MESSAGE;
    }

    public static MergeFowardMessageType valueOf(String r1) {
        return (MergeFowardMessageType) r27.a.a(MergeFowardMessageType.class, r1);
    }

    public MergeFowardMessageType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
