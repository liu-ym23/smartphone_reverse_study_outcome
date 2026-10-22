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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ThreadFollowStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATUS", "NOT_FOLLOWING", "FOLLOWING", "LOADING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ThreadFollowStatus extends Enum<ThreadFollowStatus> implements o0 {
    public static final ProtoAdapter<ThreadFollowStatus> ADAPTER = null;
    public static final b Companion = null;
    public static final ThreadFollowStatus FOLLOWING = null;
    public static final ThreadFollowStatus LOADING = null;
    public static final ThreadFollowStatus NOT_FOLLOWING = null;
    public static final ThreadFollowStatus UNKNOWN_STATUS = null;
    public static final /* synthetic */ ThreadFollowStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<ThreadFollowStatus> getEntries() {
        return b;
    }

    static {
        final ThreadFollowStatus r0 = new ThreadFollowStatus("UNKNOWN_STATUS", 0, 0);
        UNKNOWN_STATUS = r0;
        ThreadFollowStatus r1 = new ThreadFollowStatus("NOT_FOLLOWING", 1, 1);
        NOT_FOLLOWING = r1;
        ThreadFollowStatus r3 = new ThreadFollowStatus("FOLLOWING", 2, 2);
        FOLLOWING = r3;
        ThreadFollowStatus r5 = new ThreadFollowStatus("LOADING", 3, 3);
        LOADING = r5;
        ThreadFollowStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(ThreadFollowStatus.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static ThreadFollowStatus[] values() {
        return (ThreadFollowStatus[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ThreadFollowStatus fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return LOADING;
    L18:
        return FOLLOWING;
    L19:
        return NOT_FOLLOWING;
    L15:
        return UNKNOWN_STATUS;
    }

    public static ThreadFollowStatus valueOf(String r1) {
        return (ThreadFollowStatus) r27.a.a(ThreadFollowStatus.class, r1);
    }

    public ThreadFollowStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
