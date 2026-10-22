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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ThreadState;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATE", "OPEN", "CLOSED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ThreadState extends Enum<ThreadState> implements o0 {
    public static final ProtoAdapter<ThreadState> ADAPTER = null;
    public static final ThreadState CLOSED = null;
    public static final b Companion = null;
    public static final ThreadState OPEN = null;
    public static final ThreadState UNKNOWN_STATE = null;
    public static final /* synthetic */ ThreadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<ThreadState> getEntries() {
        return b;
    }

    static {
        final ThreadState r0 = new ThreadState("UNKNOWN_STATE", 0, 0);
        UNKNOWN_STATE = r0;
        ThreadState r1 = new ThreadState("OPEN", 1, 1);
        OPEN = r1;
        ThreadState r3 = new ThreadState("CLOSED", 2, 2);
        CLOSED = r3;
        ThreadState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(ThreadState.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static ThreadState[] values() {
        return (ThreadState[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ThreadState fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return null;
    L14:
        return CLOSED;
    L15:
        return OPEN;
    L12:
        return UNKNOWN_STATE;
    }

    public static ThreadState valueOf(String r1) {
        return (ThreadState) r27.a.a(ThreadState.class, r1);
    }

    public ThreadState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
