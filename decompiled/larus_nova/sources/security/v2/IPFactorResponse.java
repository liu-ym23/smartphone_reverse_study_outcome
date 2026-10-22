package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class IPFactorResponse extends Message<IPFactorResponse, Builder> {
    public static final ProtoAdapter<IPFactorResponse> ADAPTER = null;
    public static final String DEFAULT_SOURCE_IP = "";
    public static final String DEFAULT_SOURCE_IP_V4 = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_IPFactorResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String source_ip;
    public final String source_ip_v4;

    public static final class Builder extends Message.Builder<IPFactorResponse, Builder> implements d<IPFactorResponse> {
        public String source_ip;
        public String source_ip_v4;

        @Override // com.squareup.wire.Message.Builder
        public IPFactorResponse build() {
            return new IPFactorResponse(this.source_ip, this.source_ip_v4, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source_ip(String r100) {
            this.source_ip = r100;
            return this;
        }

        public Builder source_ip_v4(String r100) {
            this.source_ip_v4 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_IPFactorResponse extends ProtoAdapter<IPFactorResponse> implements c<IPFactorResponse> {
        public ProtoAdapter_IPFactorResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, IPFactorResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public IPFactorResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_ip = "";
            r101.source_ip_v4 = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.source_ip = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.source_ip_v4 = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(IPFactorResponse r100) {
            String r101 = r100.source_ip;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.source_ip_v4;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ IPFactorResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(IPFactorResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, IPFactorResponse r101) throws IOException {
            String r102 = r101.source_ip;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.source_ip_v4;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IPFactorResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_IPFactorResponse r100 = new ProtoAdapter_IPFactorResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_ip = this.source_ip;
        r100.source_ip_v4 = this.source_ip_v4;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return IPFactorResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public IPFactorResponse(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public IPFactorResponse(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.source_ip = r100;
        this.source_ip_v4 = r101;
    }
}
