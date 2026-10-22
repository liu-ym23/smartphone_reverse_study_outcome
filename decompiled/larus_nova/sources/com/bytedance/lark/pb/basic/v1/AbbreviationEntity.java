package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AbbreviationEntity extends com.squareup.wire.Message<AbbreviationEntity, Builder> {
    public static final ProtoAdapter<AbbreviationEntity> ADAPTER = null;
    public static final String DEFAULT_FULL_NAME = "";
    public static final String DEFAULT_I18N_DESC = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String full_name;
    public final String i18n_desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253437id;
    public final Map<String, String> metadata;
    public final String name;
    public final Integer version;

    public static final class Builder extends com.squareup.wire.Message.Builder<AbbreviationEntity, Builder> {
        public String full_name;
        public String i18n_desc;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253438id;
        public Map<String, String> metadata;
        public String name;
        public Integer version;

        @Override // com.squareup.wire.Message.Builder
        public AbbreviationEntity build() {
            String r100 = this.f253438id;
            if (r100 == null) goto L13;
            if (this.name == null) goto L13;
            if (this.version == null) goto L13;
            if (this.full_name == null) goto L13;
            return new AbbreviationEntity(this.f253438id, this.name, this.version, this.full_name, this.i18n_desc, this.metadata, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.name, "name", this.version, "version", this.full_name, "full_name"});
        }

        public Builder() {
            this.metadata = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder full_name(String r100) {
            this.full_name = r100;
            return this;
        }

        public Builder i18n_desc(String r100) {
            this.i18n_desc = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253438id = r100;
            return this;
        }

        public Builder metadata(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.metadata = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder version(Integer r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AbbreviationEntity extends ProtoAdapter<AbbreviationEntity> {
        private final ProtoAdapter<Map<String, String>> metadata;

        public ProtoAdapter_AbbreviationEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, AbbreviationEntity.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.metadata = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AbbreviationEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253438id = "";
            r101.name = "";
            r101.version = 0;
            r101.full_name = "";
            r101.i18n_desc = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.metadata.putAll(this.metadata.decode(r100));
            goto L3
        L8:
            r101.i18n_desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.full_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.f253438id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AbbreviationEntity r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.f253437id) + r101.encodedSizeWithTag(2, r100.name)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r100.version)) + r101.encodedSizeWithTag(4, r100.full_name);
            String r103 = r100.i18n_desc;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(5, r103);
        L7:
            return ((r102 + r104) + this.metadata.encodedSizeWithTag(6, r100.metadata)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AbbreviationEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AbbreviationEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AbbreviationEntity r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253437id);
            r102.encodeWithTag(r100, 2, r101.name);
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r101.version);
            r102.encodeWithTag(r100, 4, r101.full_name);
            String r103 = r101.i18n_desc;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 5, r103);
        L5:
            this.metadata.encodeWithTag(r100, 6, r101.metadata);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AbbreviationEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AbbreviationEntity();
        DEFAULT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253438id = this.f253437id;
        r100.name = this.name;
        r100.version = this.version;
        r100.full_name = this.full_name;
        r100.i18n_desc = this.i18n_desc;
        r100.metadata = Internal.copyOf("metadata", this.metadata);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AbbreviationEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AbbreviationEntity(String r100, String r110, Integer r111, String r112, String r113, Map<String, String> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public AbbreviationEntity(String r100, String r101, Integer r102, String r103, String r104, Map<String, String> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.f253437id = r100;
        this.name = r101;
        this.version = r102;
        this.full_name = r103;
        this.i18n_desc = r104;
        this.metadata = Internal.immutableCopyOf("metadata", r105);
    }
}
