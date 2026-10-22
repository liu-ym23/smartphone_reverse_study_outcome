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
public final class ScheduleMessageItem extends com.squareup.wire.Message<ScheduleMessageItem, Builder> {
    public static final ProtoAdapter<ScheduleMessageItem> ADAPTER = null;
    public static final String DEFAULT_ITEM_ID = "";
    public static final ItemType DEFAULT_ITEM_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String item_id;
    public final ItemType item_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ScheduleMessageItem, Builder> {
        public String item_id;
        public ItemType item_type;

        @Override // com.squareup.wire.Message.Builder
        public ScheduleMessageItem build() {
            return new ScheduleMessageItem(this.item_id, this.item_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder item_id(String r100) {
            this.item_id = r100;
            return this;
        }

        public Builder item_type(ItemType r100) {
            this.item_type = r100;
            return this;
        }
    }

    public static final enum ItemType extends Enum<ItemType> implements WireEnum {
        private static final /* synthetic */ ItemType[] $VALUES = null;
        public static final ProtoAdapter<ItemType> ADAPTER = null;
        public static final ItemType QUASI_SCHEDULE_MESSAGE = null;
        public static final ItemType SCHEDULE_MESSAGE = null;
        private final int value;

        static {
            ItemType r100 = new ItemType("QUASI_SCHEDULE_MESSAGE", 0, 1);
            QUASI_SCHEDULE_MESSAGE = r100;
            ItemType r101 = new ItemType("SCHEDULE_MESSAGE", 1, 2);
            SCHEDULE_MESSAGE = r101;
            $VALUES = new ItemType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ItemType.class);
        }

        public static ItemType[] values() {
            return (ItemType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ItemType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return SCHEDULE_MESSAGE;
        L11:
            return QUASI_SCHEDULE_MESSAGE;
        }

        public static ItemType valueOf(String r100) {
            return (ItemType) a.a(ItemType.class, r100);
        }

        private ItemType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ScheduleMessageItem extends ProtoAdapter<ScheduleMessageItem> {
        public ProtoAdapter_ScheduleMessageItem() {
            super(FieldEncoding.LENGTH_DELIMITED, ScheduleMessageItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ScheduleMessageItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.item_id = "";
            r101.item_type = ItemType.QUASI_SCHEDULE_MESSAGE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.item_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.item_type = ItemType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(ScheduleMessageItem r100) {
            String r101 = r100.item_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ItemType r104 = r100.item_type;
            if (r104 == null) goto L10;
            r102 = ItemType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ScheduleMessageItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ScheduleMessageItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ScheduleMessageItem r101) throws IOException {
            String r102 = r101.item_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ItemType r103 = r101.item_type;
            if (r103 == null) goto L8;
            ItemType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ScheduleMessageItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ScheduleMessageItem();
        DEFAULT_ITEM_TYPE = ItemType.QUASI_SCHEDULE_MESSAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.item_id = this.item_id;
        r100.item_type = this.item_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ScheduleMessageItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ScheduleMessageItem(String r100, ItemType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ScheduleMessageItem(String r100, ItemType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.item_id = r100;
        this.item_type = r101;
    }
}
