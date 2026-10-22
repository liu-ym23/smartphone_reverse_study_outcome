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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ResponseTagTypeEnum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RELATION_TAG_UNSET", "RELATION_TAG_EXTERNAL", "RELATION_TAG_PARTNER", "RELATION_TAG_TENANT_NAME", "TENANT_ENTITY_TAG", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ResponseTagTypeEnum extends Enum<ResponseTagTypeEnum> implements o0 {
    public static final ProtoAdapter<ResponseTagTypeEnum> ADAPTER = null;
    public static final b Companion = null;
    public static final ResponseTagTypeEnum RELATION_TAG_EXTERNAL = null;
    public static final ResponseTagTypeEnum RELATION_TAG_PARTNER = null;
    public static final ResponseTagTypeEnum RELATION_TAG_TENANT_NAME = null;
    public static final ResponseTagTypeEnum RELATION_TAG_UNSET = null;
    public static final ResponseTagTypeEnum TENANT_ENTITY_TAG = null;
    public static final /* synthetic */ ResponseTagTypeEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static ResponseTagTypeEnum a(int r1) {
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L22;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L19;
            return null;
        L19:
            return ResponseTagTypeEnum.TENANT_ENTITY_TAG;
        L20:
            return ResponseTagTypeEnum.RELATION_TAG_TENANT_NAME;
        L21:
            return ResponseTagTypeEnum.RELATION_TAG_PARTNER;
        L22:
            return ResponseTagTypeEnum.RELATION_TAG_EXTERNAL;
        L17:
            return ResponseTagTypeEnum.RELATION_TAG_UNSET;
        }
    }

    @JvmStatic
    public static final ResponseTagTypeEnum fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<ResponseTagTypeEnum> getEntries() {
        return b;
    }

    static {
        final ResponseTagTypeEnum r0 = new ResponseTagTypeEnum("RELATION_TAG_UNSET", 0, 0);
        RELATION_TAG_UNSET = r0;
        ResponseTagTypeEnum r1 = new ResponseTagTypeEnum("RELATION_TAG_EXTERNAL", 1, 1);
        RELATION_TAG_EXTERNAL = r1;
        ResponseTagTypeEnum r3 = new ResponseTagTypeEnum("RELATION_TAG_PARTNER", 2, 2);
        RELATION_TAG_PARTNER = r3;
        ResponseTagTypeEnum r5 = new ResponseTagTypeEnum("RELATION_TAG_TENANT_NAME", 3, 3);
        RELATION_TAG_TENANT_NAME = r5;
        ResponseTagTypeEnum r7 = new ResponseTagTypeEnum("TENANT_ENTITY_TAG", 4, 4);
        TENANT_ENTITY_TAG = r7;
        ResponseTagTypeEnum[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(ResponseTagTypeEnum.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static ResponseTagTypeEnum[] values() {
        return (ResponseTagTypeEnum[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static ResponseTagTypeEnum valueOf(String r1) {
        return (ResponseTagTypeEnum) r27.a.a(ResponseTagTypeEnum.class, r1);
    }

    public ResponseTagTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
