package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class KaInitConfig extends com.squareup.wire.Message<KaInitConfig, Builder> {
    public static final ProtoAdapter<KaInitConfig> ADAPTER = null;
    public static final String DEFAULT_CHANNEL = "";
    public static final ByteString DEFAULT_CONFIG_BYTES = null;
    public static final Boolean DEFAULT_IS_CUSTOMIZED_KA = null;
    public static final String DEFAULT_KA_INIT_CONFIG_PATH = "";
    private static final long serialVersionUID = 0;
    public final String channel;
    public final ByteString config_bytes;
    public final Boolean is_customized_ka;
    public final String ka_init_config_path;

    public static final class Builder extends com.squareup.wire.Message.Builder<KaInitConfig, Builder> {
        public String channel;
        public ByteString config_bytes;
        public Boolean is_customized_ka;
        public String ka_init_config_path;

        @Override // com.squareup.wire.Message.Builder
        public KaInitConfig build() {
            String r100 = this.channel;
            if (r100 == null) goto L7;
            return new KaInitConfig(this.channel, this.ka_init_config_path, this.is_customized_ka, this.config_bytes, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder channel(String r100) {
            this.channel = r100;
            return this;
        }

        public Builder config_bytes(ByteString r100) {
            this.config_bytes = r100;
            return this;
        }

        public Builder is_customized_ka(Boolean r100) {
            this.is_customized_ka = r100;
            return this;
        }

        public Builder ka_init_config_path(String r100) {
            this.ka_init_config_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_KaInitConfig extends ProtoAdapter<KaInitConfig> {
        public ProtoAdapter_KaInitConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, KaInitConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public KaInitConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.channel = "";
            r101.ka_init_config_path = "";
            r101.is_customized_ka = Boolean.FALSE;
            r101.config_bytes = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.channel = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ka_init_config_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_customized_ka = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.config_bytes = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(KaInitConfig r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.channel);
            String r103 = r100.ka_init_config_path;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_customized_ka;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            ByteString r110 = r100.config_bytes;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ KaInitConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(KaInitConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, KaInitConfig r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.channel);
            String r103 = r101.ka_init_config_path;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.is_customized_ka;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L8:
            ByteString r105 = r101.config_bytes;
            if (r105 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, KaInitConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_KaInitConfig();
        DEFAULT_IS_CUSTOMIZED_KA = Boolean.FALSE;
        DEFAULT_CONFIG_BYTES = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel = this.channel;
        r100.ka_init_config_path = this.ka_init_config_path;
        r100.is_customized_ka = this.is_customized_ka;
        r100.config_bytes = this.config_bytes;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return KaInitConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public KaInitConfig(String r100, String r101, Boolean r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public KaInitConfig(String r100, String r101, Boolean r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.channel = r100;
        this.ka_init_config_path = r101;
        this.is_customized_ka = r102;
        this.config_bytes = r103;
    }
}
