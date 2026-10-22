package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class RuleExpression extends Message<RuleExpression, Builder> {
    public static final ProtoAdapter<RuleExpression> ADAPTER = null;
    public static final ConditionOperator DEFAULT_COND_OPERATOR = null;
    public static final ExpressionOperator DEFAULT_EXP_OPERATOR = null;
    public static final String DEFAULT_RULE_ACTION = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final ConditionOperator cond_operator;
    public final ExpressionOperator exp_operator;
    public final RuleExpression left;
    public final RuleExpression right;
    public final String rule_action;
    public final String value;

    public static final class Builder extends Message.Builder<RuleExpression, Builder> {
        public ConditionOperator cond_operator;
        public ExpressionOperator exp_operator;
        public RuleExpression left;
        public RuleExpression right;
        public String rule_action;
        public String value;

        @Override // com.squareup.wire.Message.Builder
        public RuleExpression build() {
            return new RuleExpression(this.left, this.right, this.rule_action, this.value, this.exp_operator, this.cond_operator, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cond_operator(ConditionOperator r100) {
            this.cond_operator = r100;
            return this;
        }

        public Builder exp_operator(ExpressionOperator r100) {
            this.exp_operator = r100;
            return this;
        }

        public Builder left(RuleExpression r100) {
            this.left = r100;
            return this;
        }

        public Builder right(RuleExpression r100) {
            this.right = r100;
            return this;
        }

        public Builder rule_action(String r100) {
            this.rule_action = r100;
            return this;
        }

        public Builder value(String r100) {
            this.value = r100;
            return this;
        }
    }

    public static final enum ConditionOperator extends Enum<ConditionOperator> implements WireEnum {
        private static final /* synthetic */ ConditionOperator[] $VALUES = null;
        public static final ProtoAdapter<ConditionOperator> ADAPTER = null;
        public static final ConditionOperator AND = null;
        public static final ConditionOperator NOT = null;
        public static final ConditionOperator OR = null;
        public static final ConditionOperator UNKNOWN_CONDITION = null;
        private final int value;

        static {
            ConditionOperator r100 = new ConditionOperator("UNKNOWN_CONDITION", 0, 0);
            UNKNOWN_CONDITION = r100;
            ConditionOperator r101 = new ConditionOperator("AND", 1, 1);
            AND = r101;
            ConditionOperator r102 = new ConditionOperator("OR", 2, 2);
            OR = r102;
            ConditionOperator r103 = new ConditionOperator("NOT", 3, 3);
            NOT = r103;
            $VALUES = new ConditionOperator[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(ConditionOperator.class);
        }

        public static ConditionOperator[] values() {
            return (ConditionOperator[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ConditionOperator fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return NOT;
        L14:
            return OR;
        L16:
            return AND;
        L18:
            return UNKNOWN_CONDITION;
        }

        public static ConditionOperator valueOf(String r100) {
            return (ConditionOperator) a.a(ConditionOperator.class, r100);
        }

        private ConditionOperator(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ExpressionOperator extends Enum<ExpressionOperator> implements WireEnum {
        private static final /* synthetic */ ExpressionOperator[] $VALUES = null;
        public static final ProtoAdapter<ExpressionOperator> ADAPTER = null;
        public static final ExpressionOperator EQUAL = null;
        public static final ExpressionOperator GREATER_OR_EQUAL = null;
        public static final ExpressionOperator GREATER_THAN = null;
        public static final ExpressionOperator IN = null;
        public static final ExpressionOperator LESS_OR_EQUAL = null;
        public static final ExpressionOperator LESS_THAN = null;
        public static final ExpressionOperator NOT_EQUAL = null;
        public static final ExpressionOperator UNKNOWN_EXPRESSION = null;
        private final int value;

        static {
            ExpressionOperator r100 = new ExpressionOperator("UNKNOWN_EXPRESSION", 0, 0);
            UNKNOWN_EXPRESSION = r100;
            ExpressionOperator r101 = new ExpressionOperator("IN", 1, 1);
            IN = r101;
            ExpressionOperator r102 = new ExpressionOperator("EQUAL", 2, 2);
            EQUAL = r102;
            ExpressionOperator r103 = new ExpressionOperator("NOT_EQUAL", 3, 3);
            NOT_EQUAL = r103;
            ExpressionOperator r104 = new ExpressionOperator("LESS_OR_EQUAL", 4, 4);
            LESS_OR_EQUAL = r104;
            ExpressionOperator r105 = new ExpressionOperator("LESS_THAN", 5, 5);
            LESS_THAN = r105;
            ExpressionOperator r110 = new ExpressionOperator("GREATER_OR_EQUAL", 6, 6);
            GREATER_OR_EQUAL = r110;
            ExpressionOperator r111 = new ExpressionOperator("GREATER_THAN", 7, 7);
            GREATER_THAN = r111;
            $VALUES = new ExpressionOperator[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(ExpressionOperator.class);
        }

        public static ExpressionOperator[] values() {
            return (ExpressionOperator[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ExpressionOperator fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return GREATER_THAN;
        L8:
            return GREATER_OR_EQUAL;
        L10:
            return LESS_THAN;
        L12:
            return LESS_OR_EQUAL;
        L14:
            return NOT_EQUAL;
        L16:
            return EQUAL;
        L18:
            return IN;
        L20:
            return UNKNOWN_EXPRESSION;
        }

        public static ExpressionOperator valueOf(String r100) {
            return (ExpressionOperator) a.a(ExpressionOperator.class, r100);
        }

        private ExpressionOperator(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_RuleExpression extends ProtoAdapter<RuleExpression> {
        public ProtoAdapter_RuleExpression() {
            super(FieldEncoding.LENGTH_DELIMITED, RuleExpression.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RuleExpression decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rule_action = "";
            r101.value = "";
            r101.exp_operator = ExpressionOperator.UNKNOWN_EXPRESSION;
            r101.cond_operator = ConditionOperator.UNKNOWN_CONDITION;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L23;
                case 6: goto L21;
                default: goto L6;
            };
        L21:
            r101.cond_operator = ConditionOperator.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.exp_operator = ExpressionOperator.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.rule_action = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.right = RuleExpression.ADAPTER.decode(r100);
            goto L3
        L18:
            r101.left = RuleExpression.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RuleExpression r100) {
            RuleExpression r101 = r100.left;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = RuleExpression.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            RuleExpression r104 = r100.right;
            if (r104 == null) goto L9;
            int r105 = RuleExpression.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.rule_action;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.value;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ExpressionOperator r113 = r100.exp_operator;
            if (r113 == null) goto L21;
            int r114 = ExpressionOperator.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ConditionOperator r116 = r100.cond_operator;
            if (r116 == null) goto L26;
            r102 = ConditionOperator.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RuleExpression decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RuleExpression r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RuleExpression r101) throws IOException {
            RuleExpression r102 = r101.left;
            if (r102 == null) goto L5;
            RuleExpression.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            RuleExpression r103 = r101.right;
            if (r103 == null) goto L8;
            RuleExpression.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.rule_action;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.value;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            ExpressionOperator r106 = r101.exp_operator;
            if (r106 == null) goto L17;
            ExpressionOperator.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ConditionOperator r107 = r101.cond_operator;
            if (r107 == null) goto L20;
            ConditionOperator.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RuleExpression r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RuleExpression();
        DEFAULT_EXP_OPERATOR = ExpressionOperator.UNKNOWN_EXPRESSION;
        DEFAULT_COND_OPERATOR = ConditionOperator.UNKNOWN_CONDITION;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.left = this.left;
        r100.right = this.right;
        r100.rule_action = this.rule_action;
        r100.value = this.value;
        r100.exp_operator = this.exp_operator;
        r100.cond_operator = this.cond_operator;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RuleExpression.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RuleExpression(RuleExpression r100, RuleExpression r110, String r111, String r112, ExpressionOperator r113, ConditionOperator r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public RuleExpression(RuleExpression r100, RuleExpression r101, String r102, String r103, ExpressionOperator r104, ConditionOperator r105, ByteString r106) {
        super(ADAPTER, r106);
        this.left = r100;
        this.right = r101;
        this.rule_action = r102;
        this.value = r103;
        this.exp_operator = r104;
        this.cond_operator = r105;
    }
}
