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
public final class ValidateResponse extends Message<ValidateResponse, Builder> {
    public static final ProtoAdapter<ValidateResponse> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_ValidateResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, EnforceResult> result_map;

    public static final class Builder extends Message.Builder<ValidateResponse, Builder> implements d<ValidateResponse> {
        public Map<String, EnforceResult> result_map;

        @Override // com.squareup.wire.Message.Builder
        public ValidateResponse build() {
            return new ValidateResponse(this.result_map, super.buildUnknownFields());
        }

        public Builder() {
            this.result_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder result_map(Map<String, EnforceResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.result_map = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ValidateResponse extends ProtoAdapter<ValidateResponse> implements c<ValidateResponse> {
        private final ProtoAdapter<Map<String, EnforceResult>> result_map;

        public ProtoAdapter_ValidateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ValidateResponse.class);
            this.result_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, EnforceResult.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ValidateResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.result_map.putAll(this.result_map.decode(r100));
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
        public int encodedSize2(ValidateResponse r100) {
            return this.result_map.encodedSizeWithTag(1, r100.result_map) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ValidateResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ValidateResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ValidateResponse r101) throws IOException {
            this.result_map.encodeWithTag(r100, 1, r101.result_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ValidateResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ValidateResponse r100 = new ProtoAdapter_ValidateResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result_map = Internal.copyOf("result_map", this.result_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ValidateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ValidateResponse(Map<String, EnforceResult> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ValidateResponse(Map<String, EnforceResult> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.result_map = Internal.immutableCopyOf("result_map", r100);
    }
}
