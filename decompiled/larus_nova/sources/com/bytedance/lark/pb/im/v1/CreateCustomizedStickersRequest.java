package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CreateCustomizedStickersRequest extends Message<CreateCustomizedStickersRequest, Builder> {
    public static final ProtoAdapter<CreateCustomizedStickersRequest> ADAPTER = null;
    public static final Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_CreateCustomizedStickersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ImageKeyData> image_infos;
    public final List<String> image_keys;
    public final List<String> image_paths;
    public final List<Sticker> stickers;
    public final Type type;

    public static final class Builder extends Message.Builder<CreateCustomizedStickersRequest, Builder> implements d<CreateCustomizedStickersRequest> {
        public List<ImageKeyData> image_infos;
        public List<String> image_keys;
        public List<String> image_paths;
        public List<Sticker> stickers;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public CreateCustomizedStickersRequest build() {
            Type r100 = this.type;
            if (r100 == null) goto L7;
            return new CreateCustomizedStickersRequest(this.stickers, this.image_paths, this.type, this.image_keys, this.image_infos, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
            this.stickers = Internal.newMutableList();
            this.image_paths = Internal.newMutableList();
            this.image_keys = Internal.newMutableList();
            this.image_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder image_infos(List<ImageKeyData> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_infos = r100;
            return this;
        }

        public Builder image_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_keys = r100;
            return this;
        }

        public Builder image_paths(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_paths = r100;
            return this;
        }

        public Builder stickers(List<Sticker> r100) {
            Internal.checkElementsNotNull(r100);
            this.stickers = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateCustomizedStickersRequest extends ProtoAdapter<CreateCustomizedStickersRequest> implements c<CreateCustomizedStickersRequest> {
        public ProtoAdapter_CreateCustomizedStickersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateCustomizedStickersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CreateCustomizedStickersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.KEY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.stickers.add(Sticker.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.image_paths.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.image_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.image_infos.add(ImageKeyData.ADAPTER.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CreateCustomizedStickersRequest r100) {
            int r101 = Sticker.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.stickers);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((((r101 + r102.asRepeated().encodedSizeWithTag(2, r100.image_paths)) + Type.ADAPTER.encodedSizeWithTag(3, r100.type)) + r102.asRepeated().encodedSizeWithTag(4, r100.image_keys)) + ImageKeyData.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.image_infos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CreateCustomizedStickersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CreateCustomizedStickersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CreateCustomizedStickersRequest r101) throws IOException {
            Sticker.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.stickers);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 2, r101.image_paths);
            Type.ADAPTER.encodeWithTag(r100, 3, r101.type);
            r102.asRepeated().encodeWithTag(r100, 4, r101.image_keys);
            ImageKeyData.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.image_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CreateCustomizedStickersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type IMAGE_KEY = null;
        public static final Type IMAGE_KEY_V1 = null;
        public static final Type IMAGE_PATH = null;
        public static final Type KEY = null;
        private final int value;

        static {
            Type r100 = new Type("KEY", 0, 1);
            KEY = r100;
            Type r101 = new Type("IMAGE_PATH", 1, 2);
            IMAGE_PATH = r101;
            Type r102 = new Type("IMAGE_KEY", 2, 3);
            IMAGE_KEY = r102;
            Type r103 = new Type("IMAGE_KEY_V1", 3, 4);
            IMAGE_KEY_V1 = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
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
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return IMAGE_KEY_V1;
        L15:
            return IMAGE_KEY;
        L17:
            return IMAGE_PATH;
        L19:
            return KEY;
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
        ProtoAdapter_CreateCustomizedStickersRequest r100 = new ProtoAdapter_CreateCustomizedStickersRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = Type.KEY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.stickers = Internal.copyOf("stickers", this.stickers);
        r100.image_paths = Internal.copyOf("image_paths", this.image_paths);
        r100.type = this.type;
        r100.image_keys = Internal.copyOf("image_keys", this.image_keys);
        r100.image_infos = Internal.copyOf("image_infos", this.image_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CreateCustomizedStickersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CreateCustomizedStickersRequest(List<Sticker> r100, List<String> r101, Type r110, List<String> r111, List<ImageKeyData> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CreateCustomizedStickersRequest(List<Sticker> r100, List<String> r101, Type r102, List<String> r103, List<ImageKeyData> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.stickers = Internal.immutableCopyOf("stickers", r100);
        this.image_paths = Internal.immutableCopyOf("image_paths", r101);
        this.type = r102;
        this.image_keys = Internal.immutableCopyOf("image_keys", r103);
        this.image_infos = Internal.immutableCopyOf("image_infos", r104);
    }
}
