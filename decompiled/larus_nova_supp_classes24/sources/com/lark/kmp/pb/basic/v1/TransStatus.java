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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TransStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PENDING", "ACCEPT", "REFUSE", "CANCEL", "ABORT_BY_SENDER", "ABORT_BY_RECEIVER", "TRANS_DONE", "OFFLINE_MODE", "CANCEL_BY_RECEIVER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TransStatus extends Enum<TransStatus> implements o0 {
    public static final TransStatus ABORT_BY_RECEIVER = null;
    public static final TransStatus ABORT_BY_SENDER = null;
    public static final TransStatus ACCEPT = null;
    public static final ProtoAdapter<TransStatus> ADAPTER = null;
    public static final TransStatus CANCEL = null;
    public static final TransStatus CANCEL_BY_RECEIVER = null;
    public static final b Companion = null;
    public static final TransStatus OFFLINE_MODE = null;
    public static final TransStatus PENDING = null;
    public static final TransStatus REFUSE = null;
    public static final TransStatus TRANS_DONE = null;
    public static final /* synthetic */ TransStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static TransStatus a(int r0) {
            switch(r0) {
                case 0: goto L13;
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L3;
            };
        L3:
            return null;
        L15:
            return TransStatus.CANCEL_BY_RECEIVER;
        L16:
            return TransStatus.OFFLINE_MODE;
        L17:
            return TransStatus.TRANS_DONE;
        L18:
            return TransStatus.ABORT_BY_RECEIVER;
        L19:
            return TransStatus.ABORT_BY_SENDER;
        L20:
            return TransStatus.CANCEL;
        L21:
            return TransStatus.REFUSE;
        L22:
            return TransStatus.ACCEPT;
        L13:
            return TransStatus.PENDING;
        }
    }

    @JvmStatic
    public static final TransStatus fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<TransStatus> getEntries() {
        return b;
    }

    static {
        final TransStatus r0 = new TransStatus("PENDING", 0, 0);
        PENDING = r0;
        TransStatus r1 = new TransStatus("ACCEPT", 1, 1);
        ACCEPT = r1;
        TransStatus r3 = new TransStatus("REFUSE", 2, 2);
        REFUSE = r3;
        TransStatus r5 = new TransStatus("CANCEL", 3, 3);
        CANCEL = r5;
        TransStatus r7 = new TransStatus("ABORT_BY_SENDER", 4, 4);
        ABORT_BY_SENDER = r7;
        TransStatus r9 = new TransStatus("ABORT_BY_RECEIVER", 5, 5);
        ABORT_BY_RECEIVER = r9;
        TransStatus r11 = new TransStatus("TRANS_DONE", 6, 6);
        TRANS_DONE = r11;
        TransStatus r13 = new TransStatus("OFFLINE_MODE", 7, 7);
        OFFLINE_MODE = r13;
        TransStatus r15 = new TransStatus("CANCEL_BY_RECEIVER", 8, 8);
        CANCEL_BY_RECEIVER = r15;
        TransStatus[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(TransStatus.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static TransStatus[] values() {
        return (TransStatus[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static TransStatus valueOf(String r1) {
        return (TransStatus) r27.a.a(TransStatus.class, r1);
    }

    public TransStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
