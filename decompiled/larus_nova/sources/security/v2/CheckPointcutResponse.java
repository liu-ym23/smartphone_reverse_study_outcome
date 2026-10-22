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
public final class CheckPointcutResponse extends Message<CheckPointcutResponse, Builder> {
    public static final ProtoAdapter<CheckPointcutResponse> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_CheckPointcutResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> is_under_controlled;

    public static final class Builder extends Message.Builder<CheckPointcutResponse, Builder> implements d<CheckPointcutResponse> {
        public Map<String, Boolean> is_under_controlled;

        @Override // com.squareup.wire.Message.Builder
        public CheckPointcutResponse build() {
            return new CheckPointcutResponse(this.is_under_controlled, super.buildUnknownFields());
        }

        public Builder() {
            this.is_under_controlled = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_under_controlled(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.is_under_controlled = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckPointcutResponse extends ProtoAdapter<CheckPointcutResponse> implements c<CheckPointcutResponse> {
        private final ProtoAdapter<Map<String, Boolean>> is_under_controlled;

        public ProtoAdapter_CheckPointcutResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckPointcutResponse.class);
            this.is_under_controlled = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public CheckPointcutResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.is_under_controlled.putAll(this.is_under_controlled.decode(r100));
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
        public int encodedSize2(CheckPointcutResponse r100) {
            return this.is_under_controlled.encodedSizeWithTag(1, r100.is_under_controlled) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckPointcutResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckPointcutResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckPointcutResponse r101) throws IOException {
            this.is_under_controlled.encodeWithTag(r100, 1, r101.is_under_controlled);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckPointcutResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CheckPointcutResponse r100 = new ProtoAdapter_CheckPointcutResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_under_controlled = Internal.copyOf("is_under_controlled", this.is_under_controlled);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckPointcutResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckPointcutResponse(Map<String, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CheckPointcutResponse(Map<String, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.is_under_controlled = Internal.immutableCopyOf("is_under_controlled", r100);
    }
}
