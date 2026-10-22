package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadSecureImageRequest extends Message<UploadSecureImageRequest, Builder> {
    public static final ProtoAdapter<UploadSecureImageRequest> ADAPTER = null;
    public static final Long DEFAULT_COMPRESSED_SIZE_KB = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final ByteString DEFAULT_IMAGE = null;
    public static final Boolean DEFAULT_IS_SECRET_CHAT_IMAGE = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_PATH = "";
    public static final Type DEFAULT_TYPE = null;
    public static final String DEFAULT_UPLOAD_ID = "";
    public static final Integer DEFAULT_WIDTH = null;
    public static final ProtoAdapter_UploadSecureImageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long compressed_size_kb;
    public final Integer height;
    public final ByteString image;
    public final Boolean is_secret_chat_image;
    public final String key;
    public final String path;
    public final Type type;
    public final String upload_id;
    public final Integer width;

    public static final class Builder extends Message.Builder<UploadSecureImageRequest, Builder> implements d<UploadSecureImageRequest> {
        public Long compressed_size_kb;
        public Integer height;
        public ByteString image;
        public Boolean is_secret_chat_image;
        public String key;
        public String path;
        public Type type;
        public String upload_id;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public UploadSecureImageRequest build() {
            ByteString r100 = this.image;
            if (r100 == null) goto L7;
            return new UploadSecureImageRequest(this.image, this.compressed_size_kb, this.key, this.is_secret_chat_image, this.width, this.height, this.type, this.path, this.upload_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "image"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder compressed_size_kb(Long r100) {
            this.compressed_size_kb = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder image(ByteString r100) {
            this.image = r100;
            return this;
        }

        public Builder is_secret_chat_image(Boolean r100) {
            this.is_secret_chat_image = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder upload_id(String r100) {
            this.upload_id = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadSecureImageRequest extends ProtoAdapter<UploadSecureImageRequest> implements c<UploadSecureImageRequest> {
        public ProtoAdapter_UploadSecureImageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadSecureImageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadSecureImageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.image = ByteString.EMPTY;
            r101.compressed_size_kb = 0L;
            r101.key = "";
            r101.is_secret_chat_image = Boolean.FALSE;
            r101.width = 0;
            r101.height = 0;
            r101.type = Type.NORMAL;
            r101.path = "";
            r101.upload_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L21;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.upload_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.is_secret_chat_image = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.compressed_size_kb = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            r101.image = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadSecureImageRequest r100) {
            int r101 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r100.image);
            Long r102 = r100.compressed_size_kb;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.key;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.is_secret_chat_image;
            if (r109 == null) goto L13;
            int r110 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            Integer r112 = r100.width;
            if (r112 == null) goto L17;
            int r113 = ProtoAdapter.INT32.encodedSizeWithTag(5, r112);
        L18:
            int r114 = r111 + r113;
            Integer r115 = r100.height;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.INT32.encodedSizeWithTag(6, r115);
        L22:
            int r117 = r114 + r116;
            Type r118 = r100.type;
            if (r118 == null) goto L25;
            int r119 = Type.ADAPTER.encodedSizeWithTag(7, r118);
        L26:
            int r120 = r117 + r119;
            String r121 = r100.path;
            if (r121 == null) goto L29;
            int r122 = ProtoAdapter.STRING.encodedSizeWithTag(8, r121);
        L30:
            int r123 = r120 + r122;
            String r124 = r100.upload_id;
            if (r124 == null) goto L34;
            r103 = ProtoAdapter.STRING.encodedSizeWithTag(9, r124);
        L34:
            return (r123 + r103) + r100.unknownFields().size();
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadSecureImageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadSecureImageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadSecureImageRequest r101) throws IOException {
            ProtoAdapter.BYTES.encodeWithTag(r100, 1, r101.image);
            Long r102 = r101.compressed_size_kb;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.is_secret_chat_image;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            Integer r105 = r101.width;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L14:
            Integer r106 = r101.height;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L17:
            Type r107 = r101.type;
            if (r107 == null) goto L20;
            Type.ADAPTER.encodeWithTag(r100, 7, r107);
        L20:
            String r108 = r101.path;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            String r109 = r101.upload_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadSecureImageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type NORMAL = null;
        public static final Type POST = null;
        private final int value;

        static {
            Type r100 = new Type(EffectConstants.NORMAL, 0, 1);
            NORMAL = r100;
            Type r101 = new Type("POST", 1, 2);
            POST = r101;
            $VALUES = new Type[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return POST;
        L11:
            return NORMAL;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_UploadSecureImageRequest r100 = new ProtoAdapter_UploadSecureImageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IMAGE = ByteString.EMPTY;
        DEFAULT_COMPRESSED_SIZE_KB = 0L;
        DEFAULT_IS_SECRET_CHAT_IMAGE = Boolean.FALSE;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_TYPE = Type.NORMAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.image = this.image;
        r100.compressed_size_kb = this.compressed_size_kb;
        r100.key = this.key;
        r100.is_secret_chat_image = this.is_secret_chat_image;
        r100.width = this.width;
        r100.height = this.height;
        r100.type = this.type;
        r100.path = this.path;
        r100.upload_id = this.upload_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadSecureImageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadSecureImageRequest(ByteString r110, Long r111, String r112, Boolean r113, Integer r114, Integer r115, Type r116, String r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public UploadSecureImageRequest(ByteString r100, Long r101, String r102, Boolean r103, Integer r104, Integer r105, Type r106, String r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.image = r100;
        this.compressed_size_kb = r101;
        this.key = r102;
        this.is_secret_chat_image = r103;
        this.width = r104;
        this.height = r105;
        this.type = r106;
        this.path = r107;
        this.upload_id = r110;
    }
}
