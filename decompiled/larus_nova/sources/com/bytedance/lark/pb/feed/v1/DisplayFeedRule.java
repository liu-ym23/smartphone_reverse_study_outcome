package com.bytedance.lark.pb.feed.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class DisplayFeedRule extends Message<DisplayFeedRule, Builder> {
    public static final ProtoAdapter<DisplayFeedRule> ADAPTER = null;
    public static final DisplayFeedMainRule DEFAULT_MAIN_RULE = null;
    private static final long serialVersionUID = 0;
    public final DisplayFeedMainRule main_rule;
    public final List<DisplayFeedMsgType> msg_types;

    public static final class Builder extends Message.Builder<DisplayFeedRule, Builder> {
        public DisplayFeedMainRule main_rule;
        public List<DisplayFeedMsgType> msg_types;

        @Override // com.squareup.wire.Message.Builder
        public DisplayFeedRule build() {
            return new DisplayFeedRule(this.main_rule, this.msg_types, super.buildUnknownFields());
        }

        public Builder() {
            this.msg_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder main_rule(DisplayFeedMainRule r100) {
            this.main_rule = r100;
            return this;
        }

        public Builder msg_types(List<DisplayFeedMsgType> r100) {
            Internal.checkElementsNotNull(r100);
            this.msg_types = r100;
            return this;
        }
    }

    public static final enum DisplayFeedMainRule extends Enum<DisplayFeedMainRule> implements WireEnum {
        private static final /* synthetic */ DisplayFeedMainRule[] $VALUES = null;
        public static final ProtoAdapter<DisplayFeedMainRule> ADAPTER = null;
        public static final DisplayFeedMainRule ALWAYS_DISPLAY = null;
        public static final DisplayFeedMainRule DISPLAY_WHEN_ANY_NEW_MSG = null;
        public static final DisplayFeedMainRule DISPLAY_WHEN_NEW_MSG = null;
        public static final DisplayFeedMainRule DISPLAY_WHEN_SPECIFIC_MSG = null;
        public static final DisplayFeedMainRule NEVER_DISPLAY = null;
        public static final DisplayFeedMainRule UNKNOWN_MAIN_RULE = null;
        private final int value;

        static {
            DisplayFeedMainRule r100 = new DisplayFeedMainRule("UNKNOWN_MAIN_RULE", 0, 0);
            UNKNOWN_MAIN_RULE = r100;
            DisplayFeedMainRule r101 = new DisplayFeedMainRule("ALWAYS_DISPLAY", 1, 1);
            ALWAYS_DISPLAY = r101;
            DisplayFeedMainRule r102 = new DisplayFeedMainRule("DISPLAY_WHEN_NEW_MSG", 2, 2);
            DISPLAY_WHEN_NEW_MSG = r102;
            DisplayFeedMainRule r103 = new DisplayFeedMainRule("NEVER_DISPLAY", 3, 3);
            NEVER_DISPLAY = r103;
            DisplayFeedMainRule r104 = new DisplayFeedMainRule("DISPLAY_WHEN_SPECIFIC_MSG", 4, 4);
            DISPLAY_WHEN_SPECIFIC_MSG = r104;
            DisplayFeedMainRule r105 = new DisplayFeedMainRule("DISPLAY_WHEN_ANY_NEW_MSG", 5, 5);
            DISPLAY_WHEN_ANY_NEW_MSG = r105;
            $VALUES = new DisplayFeedMainRule[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(DisplayFeedMainRule.class);
        }

        public static DisplayFeedMainRule[] values() {
            return (DisplayFeedMainRule[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DisplayFeedMainRule fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return DISPLAY_WHEN_ANY_NEW_MSG;
        L18:
            return DISPLAY_WHEN_SPECIFIC_MSG;
        L20:
            return NEVER_DISPLAY;
        L22:
            return DISPLAY_WHEN_NEW_MSG;
        L24:
            return ALWAYS_DISPLAY;
        L26:
            return UNKNOWN_MAIN_RULE;
        }

        public static DisplayFeedMainRule valueOf(String r100) {
            return (DisplayFeedMainRule) a.a(DisplayFeedMainRule.class, r100);
        }

        private DisplayFeedMainRule(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum DisplayFeedMsgType extends Enum<DisplayFeedMsgType> implements WireEnum {
        private static final /* synthetic */ DisplayFeedMsgType[] $VALUES = null;
        public static final ProtoAdapter<DisplayFeedMsgType> ADAPTER = null;
        public static final DisplayFeedMsgType ALL = null;
        public static final DisplayFeedMsgType AT_ALL = null;
        public static final DisplayFeedMsgType AT_ME = null;
        public static final DisplayFeedMsgType STAR_CONTACTS = null;
        public static final DisplayFeedMsgType UNKNOWN_MSG_TYPE = null;
        private final int value;

        static {
            DisplayFeedMsgType r100 = new DisplayFeedMsgType("UNKNOWN_MSG_TYPE", 0, 0);
            UNKNOWN_MSG_TYPE = r100;
            DisplayFeedMsgType r101 = new DisplayFeedMsgType(AccountType.ALL, 1, 1);
            ALL = r101;
            DisplayFeedMsgType r102 = new DisplayFeedMsgType("AT_ME", 2, 2);
            AT_ME = r102;
            DisplayFeedMsgType r103 = new DisplayFeedMsgType("AT_ALL", 3, 3);
            AT_ALL = r103;
            DisplayFeedMsgType r104 = new DisplayFeedMsgType("STAR_CONTACTS", 4, 4);
            STAR_CONTACTS = r104;
            $VALUES = new DisplayFeedMsgType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(DisplayFeedMsgType.class);
        }

        public static DisplayFeedMsgType[] values() {
            return (DisplayFeedMsgType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DisplayFeedMsgType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return STAR_CONTACTS;
        L16:
            return AT_ALL;
        L18:
            return AT_ME;
        L20:
            return ALL;
        L22:
            return UNKNOWN_MSG_TYPE;
        }

        public static DisplayFeedMsgType valueOf(String r100) {
            return (DisplayFeedMsgType) a.a(DisplayFeedMsgType.class, r100);
        }

        private DisplayFeedMsgType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_DisplayFeedRule extends ProtoAdapter<DisplayFeedRule> {
        public ProtoAdapter_DisplayFeedRule() {
            super(FieldEncoding.LENGTH_DELIMITED, DisplayFeedRule.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DisplayFeedRule decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.main_rule = DisplayFeedMainRule.UNKNOWN_MAIN_RULE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.main_rule = DisplayFeedMainRule.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.msg_types.add(DisplayFeedMsgType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DisplayFeedRule r100) {
            DisplayFeedMainRule r101 = r100.main_rule;
            if (r101 == null) goto L5;
            int r102 = DisplayFeedMainRule.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + DisplayFeedMsgType.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.msg_types)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DisplayFeedRule decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DisplayFeedRule r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DisplayFeedRule r101) throws IOException {
            DisplayFeedMainRule r102 = r101.main_rule;
            if (r102 == null) goto L5;
            DisplayFeedMainRule.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DisplayFeedMsgType.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.msg_types);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DisplayFeedRule r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DisplayFeedRule();
        DEFAULT_MAIN_RULE = DisplayFeedMainRule.UNKNOWN_MAIN_RULE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.main_rule = this.main_rule;
        r100.msg_types = Internal.copyOf("msg_types", this.msg_types);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DisplayFeedRule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DisplayFeedRule(DisplayFeedMainRule r100, List<DisplayFeedMsgType> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DisplayFeedRule(DisplayFeedMainRule r100, List<DisplayFeedMsgType> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.main_rule = r100;
        this.msg_types = Internal.immutableCopyOf("msg_types", r101);
    }
}
