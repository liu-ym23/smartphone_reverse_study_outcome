package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001a\u001b\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ActionInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ActionInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ActionInfo$Builder;Lokio/ByteString;)V", "i18n_text", "", "getI18n_text", "()Ljava/lang/String;", "operator_code", "Lcom/lark/kmp/pb/basic/v1/ActionInfo$ActionOperateCode;", "getOperator_code", "()Lcom/lark/kmp/pb/basic/v1/ActionInfo$ActionOperateCode;", "action_code", "Lcom/lark/kmp/pb/basic/v1/ActionInfo$ActionCode;", "getAction_code", "()Lcom/lark/kmp/pb/basic/v1/ActionInfo$ActionCode;", "extra", "Lcom/lark/kmp/pb/basic/v1/ActionExtraInfo;", "getExtra", "()Lcom/lark/kmp/pb/basic/v1/ActionExtraInfo;", "newBuilder", "toString", "Builder", "Companion", "ActionOperateCode", "ActionCode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ActionInfo extends com.lark.wire.Message<ActionInfo, a> {
    public static final ProtoAdapter<ActionInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ActionCode action_code;
    private final ActionExtraInfo extra;
    private final String i18n_text;
    private final ActionOperateCode operator_code;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ActionInfo$ActionCode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ACTION_NONE", "ACTION_CONTACT_ADMIN", "ACTION_APPLY_USE", "ACTION_APPLY_VISIBLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ActionCode extends Enum<ActionCode> implements o0 {
        public static final ActionCode ACTION_APPLY_USE = null;
        public static final ActionCode ACTION_APPLY_VISIBLE = null;
        public static final ActionCode ACTION_CONTACT_ADMIN = null;
        public static final ActionCode ACTION_NONE = null;
        public static final ProtoAdapter<ActionCode> ADAPTER = null;
        public static final b Companion = null;
        public static final ActionCode UNKNOWN = null;
        public static final /* synthetic */ ActionCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ActionCode> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ActionCode.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<ActionCode> r1, Syntax r2, ActionCode r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static ActionCode a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return ActionCode.ACTION_APPLY_VISIBLE;
            L20:
                return ActionCode.ACTION_APPLY_USE;
            L21:
                return ActionCode.ACTION_CONTACT_ADMIN;
            L22:
                return ActionCode.ACTION_NONE;
            L17:
                return ActionCode.UNKNOWN;
            }
        }

        @JvmStatic
        public static final ActionCode fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<ActionCode> getEntries() {
            return b;
        }

        static {
            ActionCode r0 = new ActionCode("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ActionCode r1 = new ActionCode("ACTION_NONE", 1, 1);
            ACTION_NONE = r1;
            ActionCode r3 = new ActionCode("ACTION_CONTACT_ADMIN", 2, 2);
            ACTION_CONTACT_ADMIN = r3;
            ActionCode r5 = new ActionCode("ACTION_APPLY_USE", 3, 3);
            ACTION_APPLY_USE = r5;
            ActionCode r7 = new ActionCode("ACTION_APPLY_VISIBLE", 4, 4);
            ACTION_APPLY_VISIBLE = r7;
            ActionCode[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ActionCode.class), Syntax.PROTO_2, r0);
        }

        public static ActionCode[] values() {
            return (ActionCode[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static ActionCode valueOf(String r1) {
            return (ActionCode) r27.a.a(ActionCode.class, r1);
        }

        public ActionCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ActionInfo$ActionOperateCode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_OP", "CLOSE_WINDOW", "CLOSE_APP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ActionOperateCode extends Enum<ActionOperateCode> implements o0 {
        public static final ProtoAdapter<ActionOperateCode> ADAPTER = null;
        public static final ActionOperateCode CLOSE_APP = null;
        public static final ActionOperateCode CLOSE_WINDOW = null;
        public static final b Companion = null;
        public static final ActionOperateCode UNKNOWN_OP = null;
        public static final /* synthetic */ ActionOperateCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ActionOperateCode> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ActionOperateCode.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return ActionOperateCode.CLOSE_APP;
            L15:
                return ActionOperateCode.CLOSE_WINDOW;
            L12:
                return ActionOperateCode.UNKNOWN_OP;
            }

            public a(KClass<ActionOperateCode> r1, Syntax r2, ActionOperateCode r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ActionOperateCode> getEntries() {
            return b;
        }

        static {
            ActionOperateCode r0 = new ActionOperateCode("UNKNOWN_OP", 0, 0);
            UNKNOWN_OP = r0;
            ActionOperateCode r1 = new ActionOperateCode("CLOSE_WINDOW", 1, 1);
            CLOSE_WINDOW = r1;
            ActionOperateCode r3 = new ActionOperateCode("CLOSE_APP", 2, 2);
            CLOSE_APP = r3;
            ActionOperateCode[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ActionOperateCode.class), Syntax.PROTO_2, r0);
        }

        public static ActionOperateCode[] values() {
            return (ActionOperateCode[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ActionOperateCode fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return CLOSE_APP;
        L15:
            return CLOSE_WINDOW;
        L12:
            return UNKNOWN_OP;
        }

        public static ActionOperateCode valueOf(String r1) {
            return (ActionOperateCode) r27.a.a(ActionOperateCode.class, r1);
        }

        public ActionOperateCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ActionInfo, a> {
        public String d;
        public ActionOperateCode e;
        public ActionCode f;
        public ActionExtraInfo g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ActionInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ActionInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final ActionInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L25;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = ActionOperateCode.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = ActionCode.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = ActionExtraInfo.ADAPTER.c(r10);
            goto L3
        L13:
            r10.j(r4);
            goto L3
        L25:
            return new ActionInfo(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ActionInfo r5) {
            ActionInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getI18n_text())) + ActionOperateCode.ADAPTER.l(2, r6.getOperator_code())) + ActionCode.ADAPTER.l(3, r6.getAction_code())) + ActionExtraInfo.ADAPTER.l(4, r6.getExtra());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ActionInfo r5) {
            ActionInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getI18n_text());
            ActionOperateCode.ADAPTER.i(r4, 2, r6.getOperator_code());
            ActionCode.ADAPTER.i(r4, 3, r6.getAction_code());
            ActionExtraInfo.ADAPTER.i(r4, 4, r6.getExtra());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ActionInfo r5) {
            ActionInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ActionExtraInfo.ADAPTER.j(r4, 4, r6.getExtra());
            ActionCode.ADAPTER.j(r4, 3, r6.getAction_code());
            ActionOperateCode.ADAPTER.j(r4, 2, r6.getOperator_code());
            ProtoAdapter.q.j(r4, 1, r6.getI18n_text());
        }

        public b(FieldEncoding r7, KClass<ActionInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ActionInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ActionInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ActionInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.i18n_text;
        r0.e = this.operator_code;
        r0.f = this.action_code;
        r0.g = this.extra;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ActionInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final ActionCode getAction_code() {
        return this.action_code;
    }

    public final ActionExtraInfo getExtra() {
        return this.extra;
    }

    public final String getI18n_text() {
        return this.i18n_text;
    }

    public final ActionOperateCode getOperator_code() {
        return this.operator_code;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ActionInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.i18n_text = r2.d;
        this.operator_code = r2.e;
        this.action_code = r2.f;
        this.extra = r2.g;
    }

    public /* synthetic */ ActionInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
