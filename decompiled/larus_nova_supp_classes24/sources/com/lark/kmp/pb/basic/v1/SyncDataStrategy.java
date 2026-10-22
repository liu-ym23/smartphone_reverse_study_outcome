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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SyncDataStrategy;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOCAL", "TRY_LOCAL", "FORCE_SERVER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum SyncDataStrategy extends Enum<SyncDataStrategy> implements o0 {
    public static final ProtoAdapter<SyncDataStrategy> ADAPTER = null;
    public static final b Companion = null;
    public static final SyncDataStrategy FORCE_SERVER = null;
    public static final SyncDataStrategy LOCAL = null;
    public static final SyncDataStrategy TRY_LOCAL = null;
    public static final /* synthetic */ SyncDataStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<SyncDataStrategy> getEntries() {
        return b;
    }

    static {
        SyncDataStrategy r0 = new SyncDataStrategy("LOCAL", 0, 1);
        LOCAL = r0;
        SyncDataStrategy r1 = new SyncDataStrategy("TRY_LOCAL", 1, 2);
        TRY_LOCAL = r1;
        SyncDataStrategy r4 = new SyncDataStrategy("FORCE_SERVER", 2, 3);
        FORCE_SERVER = r4;
        SyncDataStrategy[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(SyncDataStrategy.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r3);
    }

    public static SyncDataStrategy[] values() {
        return (SyncDataStrategy[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final SyncDataStrategy fromValue(int r1) {
        Companion.getClass();
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L14;
        return null;
    L14:
        return FORCE_SERVER;
    L15:
        return TRY_LOCAL;
    L12:
        return LOCAL;
    }

    public static SyncDataStrategy valueOf(String r1) {
        return (SyncDataStrategy) r27.a.a(SyncDataStrategy.class, r1);
    }

    public SyncDataStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
