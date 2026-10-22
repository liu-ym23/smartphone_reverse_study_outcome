package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.texturerender.TextureRenderKeys;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class NetworkClientCertificate extends com.squareup.wire.Message<NetworkClientCertificate, Builder> {
    public static final ProtoAdapter<NetworkClientCertificate> ADAPTER = null;
    public static final ByteString DEFAULT_CERT = null;
    public static final ByteString DEFAULT_PRIVKEY = null;
    private static final long serialVersionUID = 0;
    public final ByteString cert;
    public final List<String> hosts;
    public final ByteString privkey;

    public static final class Builder extends com.squareup.wire.Message.Builder<NetworkClientCertificate, Builder> {
        public ByteString cert;
        public List<String> hosts;
        public ByteString privkey;

        @Override // com.squareup.wire.Message.Builder
        public NetworkClientCertificate build() {
            ByteString r100 = this.cert;
            if (r100 == null) goto L9;
            if (this.privkey == null) goto L9;
            return new NetworkClientCertificate(this.hosts, this.cert, this.privkey, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, TextureRenderKeys.KEY_IS_CERT, this.privkey, "privkey"});
        }

        public Builder() {
            this.hosts = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cert(ByteString r100) {
            this.cert = r100;
            return this;
        }

        public Builder hosts(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.hosts = r100;
            return this;
        }

        public Builder privkey(ByteString r100) {
            this.privkey = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NetworkClientCertificate extends ProtoAdapter<NetworkClientCertificate> {
        public ProtoAdapter_NetworkClientCertificate() {
            super(FieldEncoding.LENGTH_DELIMITED, NetworkClientCertificate.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NetworkClientCertificate decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            ByteString r102 = ByteString.EMPTY;
            r101.cert = r102;
            r101.privkey = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.hosts.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.cert = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.privkey = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NetworkClientCertificate r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.hosts);
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            return ((r101 + r102.encodedSizeWithTag(2, r100.cert)) + r102.encodedSizeWithTag(3, r100.privkey)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NetworkClientCertificate decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NetworkClientCertificate r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NetworkClientCertificate r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.hosts);
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 2, r101.cert);
            r102.encodeWithTag(r100, 3, r101.privkey);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NetworkClientCertificate r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NetworkClientCertificate();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_CERT = r100;
        DEFAULT_PRIVKEY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.hosts = Internal.copyOf("hosts", this.hosts);
        r100.cert = this.cert;
        r100.privkey = this.privkey;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NetworkClientCertificate.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public NetworkClientCertificate(List<String> r100, ByteString r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public NetworkClientCertificate(List<String> r100, ByteString r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.hosts = Internal.immutableCopyOf("hosts", r100);
        this.cert = r101;
        this.privkey = r102;
    }
}
