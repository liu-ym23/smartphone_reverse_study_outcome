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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/RequestTagTypeEnum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TAG_TYPE", "RELATION_TAG", "TENANT_TAG", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum RequestTagTypeEnum extends Enum<RequestTagTypeEnum> implements o0 {
    public static final ProtoAdapter<RequestTagTypeEnum> ADAPTER = null;
    public static final b Companion = null;
    public static final RequestTagTypeEnum RELATION_TAG = null;
    public static final RequestTagTypeEnum TENANT_TAG = null;
    public static final RequestTagTypeEnum UNKNOWN_TAG_TYPE = null;
    public static final /* synthetic */ RequestTagTypeEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<RequestTagTypeEnum> getEntries() {
        return b;
    }

    static {
        final RequestTagTypeEnum r0 = new RequestTagTypeEnum("UNKNOWN_TAG_TYPE", 0, 0);
        UNKNOWN_TAG_TYPE = r0;
        RequestTagTypeEnum r1 = new RequestTagTypeEnum("RELATION_TAG", 1, 1);
        RELATION_TAG = r1;
        RequestTagTypeEnum r3 = new RequestTagTypeEnum("TENANT_TAG", 2, 2);
        TENANT_TAG = r3;
        RequestTagTypeEnum[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(RequestTagTypeEnum.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static RequestTagTypeEnum[] values() {
        return (RequestTagTypeEnum[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final RequestTagTypeEnum fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return null;
    L14:
        return TENANT_TAG;
    L15:
        return RELATION_TAG;
    L12:
        return UNKNOWN_TAG_TYPE;
    }

    public static RequestTagTypeEnum valueOf(String r1) {
        return (RequestTagTypeEnum) r27.a.a(RequestTagTypeEnum.class, r1);
    }

    public RequestTagTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
