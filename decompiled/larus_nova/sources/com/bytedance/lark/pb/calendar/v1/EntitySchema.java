package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class EntitySchema extends Message<EntitySchema, Builder> {
    public static final ProtoAdapter<EntitySchema> ADAPTER = null;
    public static final String DEFAULT_APP_LINK = "";
    public static final IncompatibleLevel DEFAULT_INCOMPATIBLE_LEVEL = null;
    public static final ItemUILevel DEFAULT_UI_LEVEL = null;
    public static final String DEFAULT_UNIQUE_NAME = "";
    private static final long serialVersionUID = 0;
    public final String app_link;
    public final IncompatibleLevel incompatible_level;
    public final ItemUILevel ui_level;
    public final String unique_name;

    public static final class Builder extends Message.Builder<EntitySchema, Builder> {
        public String app_link;
        public IncompatibleLevel incompatible_level;
        public ItemUILevel ui_level;
        public String unique_name;

        @Override // com.squareup.wire.Message.Builder
        public EntitySchema build() {
            return new EntitySchema(this.unique_name, this.ui_level, this.app_link, this.incompatible_level, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_link(String r100) {
            this.app_link = r100;
            return this;
        }

        public Builder incompatible_level(IncompatibleLevel r100) {
            this.incompatible_level = r100;
            return this;
        }

        public Builder ui_level(ItemUILevel r100) {
            this.ui_level = r100;
            return this;
        }

        public Builder unique_name(String r100) {
            this.unique_name = r100;
            return this;
        }
    }

    public static final enum ItemUILevel extends Enum<ItemUILevel> implements WireEnum {
        private static final /* synthetic */ ItemUILevel[] $VALUES = null;
        public static final ProtoAdapter<ItemUILevel> ADAPTER = null;
        public static final ItemUILevel EDITABLE = null;
        public static final ItemUILevel HIDE = null;
        public static final ItemUILevel READONLY = null;
        private final int value;

        static {
            ItemUILevel r100 = new ItemUILevel("HIDE", 0, 1);
            HIDE = r100;
            ItemUILevel r101 = new ItemUILevel("READONLY", 1, 2);
            READONLY = r101;
            ItemUILevel r102 = new ItemUILevel("EDITABLE", 2, 3);
            EDITABLE = r102;
            $VALUES = new ItemUILevel[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ItemUILevel.class);
        }

        public static ItemUILevel[] values() {
            return (ItemUILevel[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ItemUILevel fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return EDITABLE;
        L13:
            return READONLY;
        L15:
            return HIDE;
        }

        public static ItemUILevel valueOf(String r100) {
            return (ItemUILevel) a.a(ItemUILevel.class, r100);
        }

        private ItemUILevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_EntitySchema extends ProtoAdapter<EntitySchema> {
        public ProtoAdapter_EntitySchema() {
            super(FieldEncoding.LENGTH_DELIMITED, EntitySchema.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EntitySchema decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.unique_name = "";
            r101.ui_level = ItemUILevel.HIDE;
            r101.app_link = "";
            r101.incompatible_level = IncompatibleLevel.SHOW_HINT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.unique_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ui_level = ItemUILevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.app_link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.incompatible_level = IncompatibleLevel.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EntitySchema r100) {
            String r101 = r100.unique_name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ItemUILevel r104 = r100.ui_level;
            if (r104 == null) goto L9;
            int r105 = ItemUILevel.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.app_link;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            IncompatibleLevel r110 = r100.incompatible_level;
            if (r110 == null) goto L18;
            r102 = IncompatibleLevel.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ EntitySchema decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EntitySchema r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EntitySchema r101) throws IOException {
            String r102 = r101.unique_name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ItemUILevel r103 = r101.ui_level;
            if (r103 == null) goto L8;
            ItemUILevel.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.app_link;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            IncompatibleLevel r105 = r101.incompatible_level;
            if (r105 == null) goto L14;
            IncompatibleLevel.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EntitySchema r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EntitySchema();
        DEFAULT_UI_LEVEL = ItemUILevel.HIDE;
        DEFAULT_INCOMPATIBLE_LEVEL = IncompatibleLevel.SHOW_HINT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_name = this.unique_name;
        r100.ui_level = this.ui_level;
        r100.app_link = this.app_link;
        r100.incompatible_level = this.incompatible_level;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EntitySchema.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EntitySchema(String r100, ItemUILevel r101, String r102, IncompatibleLevel r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public EntitySchema(String r100, ItemUILevel r101, String r102, IncompatibleLevel r103, ByteString r104) {
        super(ADAPTER, r104);
        this.unique_name = r100;
        this.ui_level = r101;
        this.app_link = r102;
        this.incompatible_level = r103;
    }
}
