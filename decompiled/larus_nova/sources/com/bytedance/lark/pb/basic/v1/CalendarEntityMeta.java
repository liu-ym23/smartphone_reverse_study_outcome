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
public final class CalendarEntityMeta extends com.squareup.wire.Message<CalendarEntityMeta, Builder> {
    public static final ProtoAdapter<CalendarEntityMeta> ADAPTER = null;
    public static final ActionType DEFAULT_ACTION_TYPE = null;
    public static final CalendarMonitorEntityType DEFAULT_MONITOR_ENTITY_TYPE = null;
    private static final long serialVersionUID = 0;
    public final ActionType action_type;
    public final CalendarMonitorEntityType monitor_entity_type;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType CREATE_EVENT = null;
        public static final ActionType UNKNOWN = null;
        private final int value;

        static {
            ActionType r100 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ActionType r101 = new ActionType("CREATE_EVENT", 1, 1);
            CREATE_EVENT = r101;
            $VALUES = new ActionType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ActionType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return CREATE_EVENT;
        L10:
            return UNKNOWN;
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        private ActionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<CalendarEntityMeta, Builder> {
        public ActionType action_type;
        public CalendarMonitorEntityType monitor_entity_type;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEntityMeta build() {
            return new CalendarEntityMeta(this.action_type, this.monitor_entity_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_type(ActionType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder monitor_entity_type(CalendarMonitorEntityType r100) {
            this.monitor_entity_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarEntityMeta extends ProtoAdapter<CalendarEntityMeta> {
        public ProtoAdapter_CalendarEntityMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEntityMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEntityMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.action_type = ActionType.UNKNOWN;
            r101.monitor_entity_type = CalendarMonitorEntityType.CALENDAR_MONITOR_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.action_type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.monitor_entity_type = CalendarMonitorEntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarEntityMeta r100) {
            ActionType r101 = r100.action_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ActionType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            CalendarMonitorEntityType r104 = r100.monitor_entity_type;
            if (r104 == null) goto L10;
            r102 = CalendarMonitorEntityType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarEntityMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEntityMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEntityMeta r101) throws IOException {
            ActionType r102 = r101.action_type;
            if (r102 == null) goto L5;
            ActionType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            CalendarMonitorEntityType r103 = r101.monitor_entity_type;
            if (r103 == null) goto L8;
            CalendarMonitorEntityType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEntityMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEntityMeta();
        DEFAULT_ACTION_TYPE = ActionType.UNKNOWN;
        DEFAULT_MONITOR_ENTITY_TYPE = CalendarMonitorEntityType.CALENDAR_MONITOR_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_type = this.action_type;
        r100.monitor_entity_type = this.monitor_entity_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEntityMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEntityMeta(ActionType r100, CalendarMonitorEntityType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CalendarEntityMeta(ActionType r100, CalendarMonitorEntityType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.action_type = r100;
        this.monitor_entity_type = r101;
    }
}
