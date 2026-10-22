package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class Item extends com.squareup.wire.Message<Item, Builder> {
    public static final ProtoAdapter<Item> ADAPTER = null;
    public static final String DEFAULT_ENTITY_ID = "";
    public static final Type DEFAULT_ENTITY_TYPE = null;
    public static final Long DEFAULT_ID = null;
    public static final Boolean DEFAULT_IS_HIDDEN = null;
    public static final String DEFAULT_NAME_WEIGHT = "";
    public static final Long DEFAULT_ORDER_WEIGHT = null;
    public static final Long DEFAULT_PARENT_ID = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final String entity_id;
    public final Type entity_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253507id;
    public final Boolean is_hidden;
    public final String name_weight;
    public final Long order_weight;
    public final Long parent_id;
    public final Long version;

    public static final class Builder extends com.squareup.wire.Message.Builder<Item, Builder> {
        public String entity_id;
        public Type entity_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253508id;
        public Boolean is_hidden;
        public String name_weight;
        public Long order_weight;
        public Long parent_id;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public Item build() {
            return new Item(this.f253508id, this.entity_id, this.entity_type, this.parent_id, this.order_weight, this.name_weight, this.version, this.is_hidden, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder entity_id(String r100) {
            this.entity_id = r100;
            return this;
        }

        public Builder entity_type(Type r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder id(Long r100) {
            this.f253508id = r100;
            return this;
        }

        public Builder is_hidden(Boolean r100) {
            this.is_hidden = r100;
            return this;
        }

        public Builder name_weight(String r100) {
            this.name_weight = r100;
            return this;
        }

        public Builder order_weight(Long r100) {
            this.order_weight = r100;
            return this;
        }

        public Builder parent_id(Long r100) {
            this.parent_id = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Item extends ProtoAdapter<Item> {
        public ProtoAdapter_Item() {
            super(FieldEncoding.LENGTH_DELIMITED, Item.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Item decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253508id = 0L;
            r101.entity_id = "";
            r101.entity_type = Type.UNKNOWN;
            r101.parent_id = 0L;
            r101.order_weight = 0L;
            r101.name_weight = "";
            r101.version = 0L;
            r101.is_hidden = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L20;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.entity_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.is_hidden = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.name_weight = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.order_weight = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.parent_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.entity_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.f253508id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Item r100) {
            Long r101 = r100.f253507id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.entity_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Type r107 = r100.entity_type;
            if (r107 == null) goto L13;
            int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.parent_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.order_weight;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.name_weight;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            Long r119 = r100.version;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT64.encodedSizeWithTag(6, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_hidden;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ Item decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Item r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Item r101) throws IOException {
            Long r102 = r101.f253507id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.entity_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Type r104 = r101.entity_type;
            if (r104 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.parent_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.order_weight;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.name_weight;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            Long r108 = r101.version;
            if (r108 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r108);
        L23:
            Boolean r109 = r101.is_hidden;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Item r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CHAT = null;
        public static final Type TEAM = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("CHAT", 1, 1);
            CHAT = r101;
            Type r102 = new Type("TEAM", 2, 2);
            TEAM = r102;
            $VALUES = new Type[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return TEAM;
        L12:
            return CHAT;
        L14:
            return UNKNOWN;
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
        ADAPTER = new ProtoAdapter_Item();
        DEFAULT_ID = 0L;
        DEFAULT_ENTITY_TYPE = Type.UNKNOWN;
        DEFAULT_PARENT_ID = 0L;
        DEFAULT_ORDER_WEIGHT = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_IS_HIDDEN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253508id = this.f253507id;
        r100.entity_id = this.entity_id;
        r100.entity_type = this.entity_type;
        r100.parent_id = this.parent_id;
        r100.order_weight = this.order_weight;
        r100.name_weight = this.name_weight;
        r100.version = this.version;
        r100.is_hidden = this.is_hidden;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Item.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Item(Long r110, String r111, Type r112, Long r113, Long r114, String r115, Long r116, Boolean r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public Item(Long r100, String r101, Type r102, Long r103, Long r104, String r105, Long r106, Boolean r107, ByteString r110) {
        super(ADAPTER, r110);
        this.f253507id = r100;
        this.entity_id = r101;
        this.entity_type = r102;
        this.parent_id = r103;
        this.order_weight = r104;
        this.name_weight = r105;
        this.version = r106;
        this.is_hidden = r107;
    }
}
