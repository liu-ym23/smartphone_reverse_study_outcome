package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class EncryptedInfo extends com.squareup.wire.Message<EncryptedInfo, Builder> {
    public static final ProtoAdapter<EncryptedInfo> ADAPTER = null;
    public static final ByteString DEFAULT_DATA_SECRET = null;
    public static final ByteString DEFAULT_ENCRYPTED_DATA = null;
    public static final ByteString DEFAULT_ENCRYPTED_DATA_SECRET = null;
    public static final Boolean DEFAULT_IS_TRANSMIT = null;
    private static final long serialVersionUID = 0;
    public final ByteString mdata_secret;
    public final ByteString mencrypted_data;
    public final ByteString mencrypted_data_secret;
    public final Map<String, String> mfile_keys;
    public final Map<String, String> mimage_keys;
    public final Boolean mis_transmit;
    public final ResCryptoType mres_crypto_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<EncryptedInfo, Builder> {
        public ByteString mdata_secret;
        public ByteString mencrypted_data;
        public ByteString mencrypted_data_secret;
        public Map<String, String> mfile_keys;
        public Map<String, String> mimage_keys;
        public Boolean mis_transmit;
        public ResCryptoType mres_crypto_type;

        @Override // com.squareup.wire.Message.Builder
        public EncryptedInfo build() {
            return new EncryptedInfo(this.mdata_secret, this.mencrypted_data_secret, this.mencrypted_data, this.mimage_keys, this.mfile_keys, this.mis_transmit, this.mres_crypto_type, super.buildUnknownFields());
        }

        public Builder() {
            this.mimage_keys = Internal.newMutableMap();
            this.mfile_keys = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder data_secret(ByteString r100) {
            this.mdata_secret = r100;
            return this;
        }

        public Builder encrypted_data(ByteString r100) {
            this.mencrypted_data = r100;
            return this;
        }

        public Builder encrypted_data_secret(ByteString r100) {
            this.mencrypted_data_secret = r100;
            return this;
        }

        public Builder file_keys(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfile_keys = r100;
            return this;
        }

        public Builder image_keys(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mimage_keys = r100;
            return this;
        }

        public Builder is_transmit(Boolean r100) {
            this.mis_transmit = r100;
            return this;
        }

        public Builder res_crypto_type(ResCryptoType r100) {
            this.mres_crypto_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EncryptedInfo extends ProtoAdapter<EncryptedInfo> {
        private final ProtoAdapter<Map<String, String>> mfile_keys;
        private final ProtoAdapter<Map<String, String>> mimage_keys;

        public ProtoAdapter_EncryptedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EncryptedInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mimage_keys = ProtoAdapter.newMapAdapter(r100, r100);
            this.mfile_keys = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EncryptedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            ByteString r102 = ByteString.EMPTY;
            r101.mdata_secret = r102;
            r101.mencrypted_data_secret = r102;
            r101.mencrypted_data = r102;
            r101.mis_transmit = Boolean.FALSE;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L19;
                default: goto L6;
            };
        L19:
            r101.mres_crypto_type = ResCryptoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mis_transmit = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.mfile_keys.putAll(this.mfile_keys.decode(r100));
            goto L3
        L13:
            r101.mimage_keys.putAll(this.mimage_keys.decode(r100));
            goto L3
        L14:
            r101.mencrypted_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            r101.mencrypted_data_secret = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L16:
            r101.mdata_secret = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EncryptedInfo r100) {
            ByteString r101 = r100.mdata_secret;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.mencrypted_data_secret;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100.mencrypted_data;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BYTES.encodedSizeWithTag(3, r107);
        L14:
            int r109 = ((r106 + r108) + this.mimage_keys.encodedSizeWithTag(4, r100.mimage_keys)) + this.mfile_keys.encodedSizeWithTag(5, r100.mfile_keys);
            Boolean r110 = r100.mis_transmit;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r110);
        L18:
            int r112 = r109 + r111;
            ResCryptoType r113 = r100.mres_crypto_type;
            if (r113 == null) goto L22;
            r102 = ResCryptoType.ADAPTER.encodedSizeWithTag(7, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ EncryptedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EncryptedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EncryptedInfo r101) throws IOException {
            ByteString r102 = r101.mdata_secret;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.mencrypted_data_secret;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101.mencrypted_data;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r104);
        L11:
            this.mimage_keys.encodeWithTag(r100, 4, r101.mimage_keys);
            this.mfile_keys.encodeWithTag(r100, 5, r101.mfile_keys);
            Boolean r105 = r101.mis_transmit;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L14:
            ResCryptoType r106 = r101.mres_crypto_type;
            if (r106 == null) goto L17;
            ResCryptoType.ADAPTER.encodeWithTag(r100, 7, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EncryptedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EncryptedInfo();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_DATA_SECRET = r100;
        DEFAULT_ENCRYPTED_DATA_SECRET = r100;
        DEFAULT_ENCRYPTED_DATA = r100;
        DEFAULT_IS_TRANSMIT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdata_secret = this.mdata_secret;
        r100.mencrypted_data_secret = this.mencrypted_data_secret;
        r100.mencrypted_data = this.mencrypted_data;
        r100.mimage_keys = Internal.copyOf("mimage_keys", this.mimage_keys);
        r100.mfile_keys = Internal.copyOf("mfile_keys", this.mfile_keys);
        r100.mis_transmit = this.mis_transmit;
        r100.mres_crypto_type = this.mres_crypto_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EncryptedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EncryptedInfo(ByteString r110, ByteString r111, ByteString r112, Map<String, String> r113, Map<String, String> r114, Boolean r115, ResCryptoType r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public EncryptedInfo(ByteString r100, ByteString r101, ByteString r102, Map<String, String> r103, Map<String, String> r104, Boolean r105, ResCryptoType r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mdata_secret = r100;
        this.mencrypted_data_secret = r101;
        this.mencrypted_data = r102;
        this.mimage_keys = Internal.immutableCopyOf("mimage_keys", r103);
        this.mfile_keys = Internal.immutableCopyOf("mfile_keys", r104);
        this.mis_transmit = r105;
        this.mres_crypto_type = r106;
    }
}
