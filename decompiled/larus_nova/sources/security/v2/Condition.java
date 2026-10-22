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
public final class Condition extends Message<Condition, Builder> {
    public static final ProtoAdapter<Condition> ADAPTER = null;
    public static final String DEFAULT_RAW_EXPRESSION = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String raw_expression;

    public static final class Builder extends Message.Builder<Condition, Builder> {
        public String raw_expression;

        @Override // com.squareup.wire.Message.Builder
        public Condition build() {
            String r100 = this.raw_expression;
            if (r100 == null) goto L7;
            return new Condition(this.raw_expression, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "raw_expression"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder raw_expression(String r100) {
            this.raw_expression = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Condition extends ProtoAdapter<Condition> {
        public ProtoAdapter_Condition() {
            super(FieldEncoding.LENGTH_DELIMITED, Condition.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Condition decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.raw_expression = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.raw_expression = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Condition r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.raw_expression) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Condition decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Condition r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Condition r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.raw_expression);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Condition r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Condition();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.raw_expression = this.raw_expression;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Condition.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Condition(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public Condition(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.raw_expression = r100;
    }
}
