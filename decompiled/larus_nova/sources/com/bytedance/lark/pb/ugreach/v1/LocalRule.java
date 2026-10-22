package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class LocalRule extends Message<LocalRule, Builder> {
    public static final ProtoAdapter<LocalRule> ADAPTER = null;
    public static final Long DEFAULT_RULE_ID = null;
    private static final long serialVersionUID = 0;
    public final RuleExpression root_exp_node;
    public final Long rule_id;

    public static final class Builder extends Message.Builder<LocalRule, Builder> {
        public RuleExpression root_exp_node;
        public Long rule_id;

        @Override // com.squareup.wire.Message.Builder
        public LocalRule build() {
            return new LocalRule(this.rule_id, this.root_exp_node, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder root_exp_node(RuleExpression r100) {
            this.root_exp_node = r100;
            return this;
        }

        public Builder rule_id(Long r100) {
            this.rule_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LocalRule extends ProtoAdapter<LocalRule> {
        public ProtoAdapter_LocalRule() {
            super(FieldEncoding.LENGTH_DELIMITED, LocalRule.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LocalRule decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rule_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.rule_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.root_exp_node = RuleExpression.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LocalRule r100) {
            Long r101 = r100.rule_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            RuleExpression r104 = r100.root_exp_node;
            if (r104 == null) goto L10;
            r102 = RuleExpression.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocalRule decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LocalRule r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LocalRule r101) throws IOException {
            Long r102 = r101.rule_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            RuleExpression r103 = r101.root_exp_node;
            if (r103 == null) goto L8;
            RuleExpression.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LocalRule r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LocalRule();
        DEFAULT_RULE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rule_id = this.rule_id;
        r100.root_exp_node = this.root_exp_node;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LocalRule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LocalRule(Long r100, RuleExpression r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LocalRule(Long r100, RuleExpression r101, ByteString r102) {
        super(ADAPTER, r102);
        this.rule_id = r100;
        this.root_exp_node = r101;
    }
}
