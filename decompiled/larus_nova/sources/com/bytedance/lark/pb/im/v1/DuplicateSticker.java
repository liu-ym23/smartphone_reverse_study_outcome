package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class DuplicateSticker extends Message<DuplicateSticker, Builder> {
    public static final ProtoAdapter<DuplicateSticker> ADAPTER = null;
    public static final String DEFAULT_DUPLICATE_KEY = "";
    public static final Type DEFAULT_DUPLICATE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String duplicate_key;
    public final Type duplicate_type;

    public static final class Builder extends Message.Builder<DuplicateSticker, Builder> {
        public String duplicate_key;
        public Type duplicate_type;

        @Override // com.squareup.wire.Message.Builder
        public DuplicateSticker build() {
            Type r100 = this.duplicate_type;
            if (r100 == null) goto L9;
            if (this.duplicate_key == null) goto L9;
            return new DuplicateSticker(this.duplicate_type, this.duplicate_key, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "duplicate_type", this.duplicate_key, "duplicate_key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder duplicate_key(String r100) {
            this.duplicate_key = r100;
            return this;
        }

        public Builder duplicate_type(Type r100) {
            this.duplicate_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DuplicateSticker extends ProtoAdapter<DuplicateSticker> {
        public ProtoAdapter_DuplicateSticker() {
            super(FieldEncoding.LENGTH_DELIMITED, DuplicateSticker.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DuplicateSticker decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.duplicate_type = Type.STICKER_ID;
            r101.duplicate_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.duplicate_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.duplicate_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DuplicateSticker r100) {
            return (Type.ADAPTER.encodedSizeWithTag(1, r100.duplicate_type) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.duplicate_key)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DuplicateSticker decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DuplicateSticker r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DuplicateSticker r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.duplicate_type);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.duplicate_key);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DuplicateSticker r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type STICKER_ID = null;
        public static final Type STICKER_KEY = null;
        private final int value;

        static {
            Type r100 = new Type("STICKER_ID", 0, 1);
            STICKER_ID = r100;
            Type r101 = new Type("STICKER_KEY", 1, 2);
            STICKER_KEY = r101;
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
            return STICKER_KEY;
        L11:
            return STICKER_ID;
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
        ADAPTER = new ProtoAdapter_DuplicateSticker();
        DEFAULT_DUPLICATE_TYPE = Type.STICKER_ID;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.duplicate_type = this.duplicate_type;
        r100.duplicate_key = this.duplicate_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DuplicateSticker.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DuplicateSticker(Type r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DuplicateSticker(Type r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.duplicate_type = r100;
        this.duplicate_key = r101;
    }
}
