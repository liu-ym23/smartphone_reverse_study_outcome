package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class Rule extends Message<Rule, Builder> {
    public static final ProtoAdapter<Rule> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final Condition condition;
    public final Decision decision;

    public static final class Builder extends Message.Builder<Rule, Builder> {
        public Condition condition;
        public Decision decision;

        @Override // com.squareup.wire.Message.Builder
        public Rule build() {
            Condition r100 = this.condition;
            if (r100 == null) goto L9;
            if (this.decision == null) goto L9;
            return new Rule(this.condition, this.decision, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "condition", this.decision, "decision"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder condition(Condition r100) {
            this.condition = r100;
            return this;
        }

        public Builder decision(Decision r100) {
            this.decision = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Rule extends ProtoAdapter<Rule> {
        public ProtoAdapter_Rule() {
            super(FieldEncoding.LENGTH_DELIMITED, Rule.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Rule decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.condition = Condition.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.decision = Decision.ADAPTER.decode(r100);
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
        public int encodedSize2(Rule r100) {
            return (Condition.ADAPTER.encodedSizeWithTag(1, r100.condition) + Decision.ADAPTER.encodedSizeWithTag(2, r100.decision)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Rule decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Rule r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Rule r101) throws IOException {
            Condition.ADAPTER.encodeWithTag(r100, 1, r101.condition);
            Decision.ADAPTER.encodeWithTag(r100, 2, r101.decision);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Rule r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Rule();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.condition = this.condition;
        r100.decision = this.decision;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Rule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Rule(Condition r100, Decision r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Rule(Condition r100, Decision r101, ByteString r102) {
        super(ADAPTER, r102);
        this.condition = r100;
        this.decision = r101;
    }
}
