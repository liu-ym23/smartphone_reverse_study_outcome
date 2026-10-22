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
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class ValidateRequest extends Message<ValidateRequest, Builder> {
    public static final ProtoAdapter<ValidateRequest> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_ValidateRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ValidateContext> params;

    public static final class Builder extends Message.Builder<ValidateRequest, Builder> implements d<ValidateRequest> {
        public Map<String, ValidateContext> params;

        @Override // com.squareup.wire.Message.Builder
        public ValidateRequest build() {
            return new ValidateRequest(this.params, super.buildUnknownFields());
        }

        public Builder() {
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder params(Map<String, ValidateContext> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ValidateRequest extends ProtoAdapter<ValidateRequest> implements c<ValidateRequest> {
        private final ProtoAdapter<Map<String, ValidateContext>> params;

        public ProtoAdapter_ValidateRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ValidateRequest.class);
            this.params = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ValidateContext.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ValidateRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.params.putAll(this.params.decode(r100));
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
        public int encodedSize2(ValidateRequest r100) {
            return this.params.encodedSizeWithTag(1, r100.params) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ValidateRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ValidateRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ValidateRequest r101) throws IOException {
            this.params.encodeWithTag(r100, 1, r101.params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ValidateRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ValidateRequest r100 = new ProtoAdapter_ValidateRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.params = Internal.copyOf("params", this.params);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ValidateRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ValidateRequest(Map<String, ValidateContext> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ValidateRequest(Map<String, ValidateContext> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.params = Internal.immutableCopyOf("params", r100);
    }
}
