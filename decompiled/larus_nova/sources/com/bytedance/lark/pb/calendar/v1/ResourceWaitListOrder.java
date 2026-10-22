package com.bytedance.lark.pb.calendar.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class ResourceWaitListOrder extends Message<ResourceWaitListOrder, Builder> {
    public static final ProtoAdapter<ResourceWaitListOrder> ADAPTER = null;
    public static final String DEFAULT_BUILDING_LEVEL_ID = "";
    public static final Integer DEFAULT_CAPACITY = null;
    public static final String DEFAULT_CREATE_USER_ID = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final EquipmentRequireType DEFAULT_EQUIPMENT_REQUIREMENT = null;
    public static final Integer DEFAULT_LAST_WAIT_TIME_DURATION = null;
    public static final LastWaitTimeType DEFAULT_LAST_WAIT_TIME_TYPE = null;
    public static final Integer DEFAULT_MAX_CAPACITY = null;
    public static final WaitListStatus DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String building_level_id;
    public final List<String> building_zone_codes;
    public final Integer capacity;
    public final String create_user_id;
    public final String display_name;
    public final EquipmentRequireType equipment_requirement;
    public final Integer last_wait_time_duration;
    public final LastWaitTimeType last_wait_time_type;
    public final List<String> level_ids;
    public final Integer max_capacity;
    public final WaitListStatus status;

    public static final class Builder extends Message.Builder<ResourceWaitListOrder, Builder> {
        public String building_level_id;
        public List<String> building_zone_codes;
        public Integer capacity;
        public String create_user_id;
        public String display_name;
        public EquipmentRequireType equipment_requirement;
        public Integer last_wait_time_duration;
        public LastWaitTimeType last_wait_time_type;
        public List<String> level_ids;
        public Integer max_capacity;
        public WaitListStatus status;

        @Override // com.squareup.wire.Message.Builder
        public ResourceWaitListOrder build() {
            String r100 = this.building_level_id;
            if (r100 == null) goto L19;
            if (this.capacity == null) goto L19;
            if (this.equipment_requirement == null) goto L19;
            if (this.last_wait_time_type == null) goto L19;
            if (this.last_wait_time_duration == null) goto L19;
            if (this.status == null) goto L19;
            if (this.create_user_id == null) goto L19;
            return new ResourceWaitListOrder(this.building_level_id, this.level_ids, this.capacity, this.equipment_requirement, this.display_name, this.last_wait_time_type, this.last_wait_time_duration, this.status, this.create_user_id, this.max_capacity, this.building_zone_codes, super.buildUnknownFields());
        L19:
            throw Internal.missingRequiredFields(new Object[]{r100, "building_level_id", this.capacity, "capacity", this.equipment_requirement, "equipment_requirement", this.last_wait_time_type, "last_wait_time_type", this.last_wait_time_duration, "last_wait_time_duration", this.status, "status", this.create_user_id, "create_user_id"});
        }

        public Builder() {
            this.level_ids = Internal.newMutableList();
            this.building_zone_codes = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder building_level_id(String r100) {
            this.building_level_id = r100;
            return this;
        }

        public Builder building_zone_codes(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.building_zone_codes = r100;
            return this;
        }

        public Builder capacity(Integer r100) {
            this.capacity = r100;
            return this;
        }

        public Builder create_user_id(String r100) {
            this.create_user_id = r100;
            return this;
        }

        public Builder display_name(String r100) {
            this.display_name = r100;
            return this;
        }

        public Builder equipment_requirement(EquipmentRequireType r100) {
            this.equipment_requirement = r100;
            return this;
        }

        public Builder last_wait_time_duration(Integer r100) {
            this.last_wait_time_duration = r100;
            return this;
        }

        public Builder last_wait_time_type(LastWaitTimeType r100) {
            this.last_wait_time_type = r100;
            return this;
        }

        public Builder level_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.level_ids = r100;
            return this;
        }

        public Builder max_capacity(Integer r100) {
            this.max_capacity = r100;
            return this;
        }

        public Builder status(WaitListStatus r100) {
            this.status = r100;
            return this;
        }
    }

    public static final enum EquipmentRequireType extends Enum<EquipmentRequireType> implements WireEnum {
        private static final /* synthetic */ EquipmentRequireType[] $VALUES = null;
        public static final ProtoAdapter<EquipmentRequireType> ADAPTER = null;
        public static final EquipmentRequireType IncludeProjector = null;
        public static final EquipmentRequireType RequireNoneEquipment = null;
        private final int value;

        static {
            EquipmentRequireType r100 = new EquipmentRequireType("RequireNoneEquipment", 0, 0);
            RequireNoneEquipment = r100;
            EquipmentRequireType r101 = new EquipmentRequireType("IncludeProjector", 1, 1);
            IncludeProjector = r101;
            $VALUES = new EquipmentRequireType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(EquipmentRequireType.class);
        }

        public static EquipmentRequireType[] values() {
            return (EquipmentRequireType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EquipmentRequireType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return IncludeProjector;
        L10:
            return RequireNoneEquipment;
        }

        public static EquipmentRequireType valueOf(String r100) {
            return (EquipmentRequireType) a.a(EquipmentRequireType.class, r100);
        }

        private EquipmentRequireType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum LastWaitTimeType extends Enum<LastWaitTimeType> implements WireEnum {
        private static final /* synthetic */ LastWaitTimeType[] $VALUES = null;
        public static final ProtoAdapter<LastWaitTimeType> ADAPTER = null;
        public static final LastWaitTimeType AFTER_EVENT_START = null;
        public static final LastWaitTimeType BEFORE_EVENT_START = null;
        public static final LastWaitTimeType WHEN_EVENT_END = null;
        public static final LastWaitTimeType WHEN_EVENT_START = null;
        private final int value;

        static {
            LastWaitTimeType r100 = new LastWaitTimeType("BEFORE_EVENT_START", 0, 1);
            BEFORE_EVENT_START = r100;
            LastWaitTimeType r101 = new LastWaitTimeType("WHEN_EVENT_START", 1, 2);
            WHEN_EVENT_START = r101;
            LastWaitTimeType r102 = new LastWaitTimeType("AFTER_EVENT_START", 2, 3);
            AFTER_EVENT_START = r102;
            LastWaitTimeType r103 = new LastWaitTimeType("WHEN_EVENT_END", 3, 4);
            WHEN_EVENT_END = r103;
            $VALUES = new LastWaitTimeType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(LastWaitTimeType.class);
        }

        public static LastWaitTimeType[] values() {
            return (LastWaitTimeType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static LastWaitTimeType fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return WHEN_EVENT_END;
        L15:
            return AFTER_EVENT_START;
        L17:
            return WHEN_EVENT_START;
        L19:
            return BEFORE_EVENT_START;
        }

        public static LastWaitTimeType valueOf(String r100) {
            return (LastWaitTimeType) a.a(LastWaitTimeType.class, r100);
        }

        private LastWaitTimeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ResourceWaitListOrder extends ProtoAdapter<ResourceWaitListOrder> {
        public ProtoAdapter_ResourceWaitListOrder() {
            super(FieldEncoding.LENGTH_DELIMITED, ResourceWaitListOrder.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResourceWaitListOrder decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.building_level_id = "";
            r101.capacity = 0;
            r101.equipment_requirement = EquipmentRequireType.RequireNoneEquipment;
            r101.display_name = "";
            r101.last_wait_time_type = LastWaitTimeType.BEFORE_EVENT_START;
            r101.last_wait_time_duration = 0;
            r101.status = WaitListStatus.UNKNOWN;
            r101.create_user_id = "";
            r101.max_capacity = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            switch(r103) {
                case 1: goto L26;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L33;
                case 5: goto L19;
                case 6: goto L31;
                case 7: goto L14;
                case 8: goto L29;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L29:
            r101.status = WaitListStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L31:
            r101.last_wait_time_type = LastWaitTimeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L33:
            r101.equipment_requirement = EquipmentRequireType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.building_zone_codes.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.max_capacity = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            r101.create_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.last_wait_time_duration = ProtoAdapter.INT32.decode(r100);
            goto L3
        L19:
            r101.display_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.capacity = ProtoAdapter.INT32.decode(r100);
            goto L3
        L25:
            r101.level_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L26:
            r101.building_level_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResourceWaitListOrder r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.building_level_id) + r101.asRepeated().encodedSizeWithTag(2, r100.level_ids);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            int r104 = (r102 + r103.encodedSizeWithTag(3, r100.capacity)) + EquipmentRequireType.ADAPTER.encodedSizeWithTag(4, r100.equipment_requirement);
            String r105 = r100.display_name;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r101.encodedSizeWithTag(5, r105);
        L6:
            int r108 = ((((r104 + r107) + LastWaitTimeType.ADAPTER.encodedSizeWithTag(6, r100.last_wait_time_type)) + r103.encodedSizeWithTag(7, r100.last_wait_time_duration)) + WaitListStatus.ADAPTER.encodedSizeWithTag(8, r100.status)) + r101.encodedSizeWithTag(9, r100.create_user_id);
            Integer r109 = r100.max_capacity;
            if (r109 == null) goto L10;
            r106 = r103.encodedSizeWithTag(10, r109);
        L10:
            return ((r108 + r106) + r101.asRepeated().encodedSizeWithTag(11, r100.building_zone_codes)) + r100.unknownFields().size();
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResourceWaitListOrder decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResourceWaitListOrder r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ResourceWaitListOrder r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.building_level_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.level_ids);
            ProtoAdapter<Integer> r103 = ProtoAdapter.INT32;
            r103.encodeWithTag(r100, 3, r101.capacity);
            EquipmentRequireType.ADAPTER.encodeWithTag(r100, 4, r101.equipment_requirement);
            String r104 = r101.display_name;
            if (r104 == null) goto L5;
            r102.encodeWithTag(r100, 5, r104);
        L5:
            LastWaitTimeType.ADAPTER.encodeWithTag(r100, 6, r101.last_wait_time_type);
            r103.encodeWithTag(r100, 7, r101.last_wait_time_duration);
            WaitListStatus.ADAPTER.encodeWithTag(r100, 8, r101.status);
            r102.encodeWithTag(r100, 9, r101.create_user_id);
            Integer r105 = r101.max_capacity;
            if (r105 == null) goto L8;
            r103.encodeWithTag(r100, 10, r105);
        L8:
            r102.asRepeated().encodeWithTag(r100, 11, r101.building_zone_codes);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResourceWaitListOrder r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum WaitListStatus extends Enum<WaitListStatus> implements WireEnum {
        private static final /* synthetic */ WaitListStatus[] $VALUES = null;
        public static final ProtoAdapter<WaitListStatus> ADAPTER = null;
        public static final WaitListStatus FAILED = null;
        public static final WaitListStatus UNKNOWN = null;
        public static final WaitListStatus WAITING = null;
        private final int value;

        static {
            WaitListStatus r100 = new WaitListStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            WaitListStatus r101 = new WaitListStatus("WAITING", 1, 1);
            WAITING = r101;
            WaitListStatus r102 = new WaitListStatus("FAILED", 2, 2);
            FAILED = r102;
            $VALUES = new WaitListStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(WaitListStatus.class);
        }

        public static WaitListStatus[] values() {
            return (WaitListStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static WaitListStatus fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return FAILED;
        L12:
            return WAITING;
        L14:
            return UNKNOWN;
        }

        public static WaitListStatus valueOf(String r100) {
            return (WaitListStatus) a.a(WaitListStatus.class, r100);
        }

        private WaitListStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResourceWaitListOrder();
        DEFAULT_CAPACITY = 0;
        DEFAULT_EQUIPMENT_REQUIREMENT = EquipmentRequireType.RequireNoneEquipment;
        DEFAULT_LAST_WAIT_TIME_TYPE = LastWaitTimeType.BEFORE_EVENT_START;
        DEFAULT_LAST_WAIT_TIME_DURATION = 0;
        DEFAULT_STATUS = WaitListStatus.UNKNOWN;
        DEFAULT_MAX_CAPACITY = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.building_level_id = this.building_level_id;
        r100.level_ids = Internal.copyOf("level_ids", this.level_ids);
        r100.capacity = this.capacity;
        r100.equipment_requirement = this.equipment_requirement;
        r100.display_name = this.display_name;
        r100.last_wait_time_type = this.last_wait_time_type;
        r100.last_wait_time_duration = this.last_wait_time_duration;
        r100.status = this.status;
        r100.create_user_id = this.create_user_id;
        r100.max_capacity = this.max_capacity;
        r100.building_zone_codes = Internal.copyOf("building_zone_codes", this.building_zone_codes);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ResourceWaitListOrder.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ResourceWaitListOrder(String r110, List<String> r111, Integer r112, EquipmentRequireType r113, String r114, LastWaitTimeType r115, Integer r210, WaitListStatus r211, String r212, Integer r213, List<String> r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public ResourceWaitListOrder(String r100, List<String> r101, Integer r102, EquipmentRequireType r103, String r104, LastWaitTimeType r105, Integer r106, WaitListStatus r107, String r110, Integer r111, List<String> r112, ByteString r113) {
        super(ADAPTER, r113);
        this.building_level_id = r100;
        this.level_ids = Internal.immutableCopyOf("level_ids", r101);
        this.capacity = r102;
        this.equipment_requirement = r103;
        this.display_name = r104;
        this.last_wait_time_type = r105;
        this.last_wait_time_duration = r106;
        this.status = r107;
        this.create_user_id = r110;
        this.max_capacity = r111;
        this.building_zone_codes = Internal.immutableCopyOf("building_zone_codes", r112);
    }
}
