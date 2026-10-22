package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class PushMeetingAISummaryData extends Message<PushMeetingAISummaryData, Builder> {
    public static final ProtoAdapter<PushMeetingAISummaryData> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Long DEFAULT_TIMESTAMP = null;
    private static final long serialVersionUID = 0;
    public final ActionType maction_type;
    public final String mmeeting_id;
    public final Long mtimestamp;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType NOTIFY_MANUAL_REFRESH_SUMMARY = null;
        public static final ActionType NOTIFY_NEW_SUMMARY = null;
        public static final ActionType UNKNOWN = null;
        private final int value;

        static {
            ActionType r100 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ActionType r101 = new ActionType("NOTIFY_NEW_SUMMARY", 1, 1);
            NOTIFY_NEW_SUMMARY = r101;
            ActionType r102 = new ActionType("NOTIFY_MANUAL_REFRESH_SUMMARY", 2, 2);
            NOTIFY_MANUAL_REFRESH_SUMMARY = r102;
            $VALUES = new ActionType[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return NOTIFY_MANUAL_REFRESH_SUMMARY;
        L12:
            return NOTIFY_NEW_SUMMARY;
        L14:
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

    public static final class Builder extends Message.Builder<PushMeetingAISummaryData, Builder> {
        public ActionType maction_type;
        public String mmeeting_id;
        public Long mtimestamp;

        @Override // com.squareup.wire.Message.Builder
        public PushMeetingAISummaryData build() {
            return new PushMeetingAISummaryData(this.mmeeting_id, this.mtimestamp, this.maction_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(ActionType r100) {
            this.maction_type = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder timestamp(Long r100) {
            this.mtimestamp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushMeetingAISummaryData extends ProtoAdapter<PushMeetingAISummaryData> {
        public ProtoAdapter_PushMeetingAISummaryData() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMeetingAISummaryData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushMeetingAISummaryData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.mtimestamp = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtimestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.maction_type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushMeetingAISummaryData r100) {
            String r101 = r100.mmeeting_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mtimestamp;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ActionType r107 = r100.maction_type;
            if (r107 == null) goto L14;
            r102 = ActionType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushMeetingAISummaryData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushMeetingAISummaryData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushMeetingAISummaryData r101) throws IOException {
            String r102 = r101.mmeeting_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mtimestamp;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ActionType r104 = r101.maction_type;
            if (r104 == null) goto L11;
            ActionType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushMeetingAISummaryData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushMeetingAISummaryData();
        DEFAULT_TIMESTAMP = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.mtimestamp = this.mtimestamp;
        r100.maction_type = this.maction_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushMeetingAISummaryData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushMeetingAISummaryData(String r100, Long r101, ActionType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushMeetingAISummaryData(String r100, Long r101, ActionType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mmeeting_id = r100;
        this.mtimestamp = r101;
        this.maction_type = r102;
    }
}
