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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageSourceType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "COMMON_MESSAGE", "MERGE_FORWARD_MESSAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum MessageSourceType extends Enum<MessageSourceType> implements o0 {
    public static final ProtoAdapter<MessageSourceType> ADAPTER = null;
    public static final MessageSourceType COMMON_MESSAGE = null;
    public static final b Companion = null;
    public static final MessageSourceType MERGE_FORWARD_MESSAGE = null;
    public static final /* synthetic */ MessageSourceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<MessageSourceType> getEntries() {
        return b;
    }

    static {
        final MessageSourceType r0 = new MessageSourceType("COMMON_MESSAGE", 0, 0);
        COMMON_MESSAGE = r0;
        MessageSourceType r1 = new MessageSourceType("MERGE_FORWARD_MESSAGE", 1, 1);
        MERGE_FORWARD_MESSAGE = r1;
        MessageSourceType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(MessageSourceType.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static MessageSourceType[] values() {
        return (MessageSourceType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MessageSourceType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L11;
        return null;
    L11:
        return MERGE_FORWARD_MESSAGE;
    L9:
        return COMMON_MESSAGE;
    }

    public static MessageSourceType valueOf(String r1) {
        return (MessageSourceType) r27.a.a(MessageSourceType.class, r1);
    }

    public MessageSourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
