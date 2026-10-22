package com.bytedance.lark.pb.knowledge_ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Identity extends Message<Identity, Builder> {
    public static final ProtoAdapter<Identity> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_BACKGROUND_IMAGE_KEY = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final String background_image_key;
    public final String description;
    public final Map<String, String> i18n_description;
    public final Map<String, String> i18n_name;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253669id;
    public final String name;
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<Identity, Builder> {
        public String avatar_key;
        public String background_image_key;
        public String description;
        public Map<String, String> i18n_description;
        public Map<String, String> i18n_name;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253670id;
        public String name;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public Identity build() {
            return new Identity(this.f253670id, this.name, this.i18n_name, this.avatar_key, this.update_time_ms, this.description, this.i18n_description, this.background_image_key, super.buildUnknownFields());
        }

        public Builder() {
            this.i18n_name = Internal.newMutableMap();
            this.i18n_description = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder background_image_key(String r100) {
            this.background_image_key = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder i18n_description(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_description = r100;
            return this;
        }

        public Builder i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_name = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253670id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Identity extends ProtoAdapter<Identity> {
        private final ProtoAdapter<Map<String, String>> i18n_description;
        private final ProtoAdapter<Map<String, String>> i18n_name;

        public ProtoAdapter_Identity() {
            super(FieldEncoding.LENGTH_DELIMITED, Identity.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_name = ProtoAdapter.newMapAdapter(r100, r100);
            this.i18n_description = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Identity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253670id = 0L;
            r101.name = "";
            r101.avatar_key = "";
            r101.update_time_ms = 0L;
            r101.description = "";
            r101.background_image_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r101.background_image_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.i18n_description.putAll(this.i18n_description.decode(r100));
            goto L3
        L9:
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.i18n_name.putAll(this.i18n_name.decode(r100));
            goto L3
        L13:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.f253670id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Identity r100) {
            Long r101 = r100.f253669id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + this.i18n_name.encodedSizeWithTag(3, r100.i18n_name);
            String r107 = r100.avatar_key;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.update_time_ms;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.description;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
        L22:
            int r115 = (r112 + r114) + this.i18n_description.encodedSizeWithTag(7, r100.i18n_description);
            String r116 = r100.background_image_key;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ Identity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Identity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Identity r101) throws IOException {
            Long r102 = r101.f253669id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            this.i18n_name.encodeWithTag(r100, 3, r101.i18n_name);
            String r104 = r101.avatar_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            Long r105 = r101.update_time_ms;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.description;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            this.i18n_description.encodeWithTag(r100, 7, r101.i18n_description);
            String r107 = r101.background_image_key;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Identity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Identity();
        DEFAULT_ID = 0L;
        DEFAULT_UPDATE_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253670id = this.f253669id;
        r100.name = this.name;
        r100.i18n_name = Internal.copyOf("i18n_name", this.i18n_name);
        r100.avatar_key = this.avatar_key;
        r100.update_time_ms = this.update_time_ms;
        r100.description = this.description;
        r100.i18n_description = Internal.copyOf("i18n_description", this.i18n_description);
        r100.background_image_key = this.background_image_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Identity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Identity(Long r110, String r111, Map<String, String> r112, String r113, Long r114, String r115, Map<String, String> r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public Identity(Long r100, String r101, Map<String, String> r102, String r103, Long r104, String r105, Map<String, String> r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.f253669id = r100;
        this.name = r101;
        this.i18n_name = Internal.immutableCopyOf("i18n_name", r102);
        this.avatar_key = r103;
        this.update_time_ms = r104;
        this.description = r105;
        this.i18n_description = Internal.immutableCopyOf("i18n_description", r106);
        this.background_image_key = r107;
    }
}
