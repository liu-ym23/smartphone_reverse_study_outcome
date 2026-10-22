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
public final class QuasiScheduleMessage extends com.squareup.wire.Message<QuasiScheduleMessage, Builder> {
    public static final ProtoAdapter<QuasiScheduleMessage> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_SCHEDULE_TIME = null;
    public static final QuasiScheduleMessageStatus DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String cid;
    public final Long schedule_time;
    public final QuasiScheduleMessageStatus status;

    public static final class Builder extends com.squareup.wire.Message.Builder<QuasiScheduleMessage, Builder> {
        public String cid;
        public Long schedule_time;
        public QuasiScheduleMessageStatus status;

        @Override // com.squareup.wire.Message.Builder
        public QuasiScheduleMessage build() {
            return new QuasiScheduleMessage(this.cid, this.status, this.schedule_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder schedule_time(Long r100) {
            this.schedule_time = r100;
            return this;
        }

        public Builder status(QuasiScheduleMessageStatus r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuasiScheduleMessage extends ProtoAdapter<QuasiScheduleMessage> {
        public ProtoAdapter_QuasiScheduleMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, QuasiScheduleMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuasiScheduleMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            r101.status = QuasiScheduleMessageStatus.UNKNOWN;
            r101.schedule_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.status = QuasiScheduleMessageStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.schedule_time = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(QuasiScheduleMessage r100) {
            String r101 = r100.cid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            QuasiScheduleMessageStatus r104 = r100.status;
            if (r104 == null) goto L9;
            int r105 = QuasiScheduleMessageStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.schedule_time;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ QuasiScheduleMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuasiScheduleMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuasiScheduleMessage r101) throws IOException {
            String r102 = r101.cid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            QuasiScheduleMessageStatus r103 = r101.status;
            if (r103 == null) goto L8;
            QuasiScheduleMessageStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.schedule_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuasiScheduleMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum QuasiScheduleMessageStatus extends Enum<QuasiScheduleMessageStatus> implements WireEnum {
        private static final /* synthetic */ QuasiScheduleMessageStatus[] $VALUES = null;
        public static final ProtoAdapter<QuasiScheduleMessageStatus> ADAPTER = null;
        public static final QuasiScheduleMessageStatus DELETE = null;
        public static final QuasiScheduleMessageStatus UNKNOWN = null;
        private final int value;

        static {
            QuasiScheduleMessageStatus r100 = new QuasiScheduleMessageStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            QuasiScheduleMessageStatus r101 = new QuasiScheduleMessageStatus("DELETE", 1, 3);
            DELETE = r101;
            $VALUES = new QuasiScheduleMessageStatus[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(QuasiScheduleMessageStatus.class);
        }

        public static QuasiScheduleMessageStatus[] values() {
            return (QuasiScheduleMessageStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static QuasiScheduleMessageStatus fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 3) goto L8;
            return null;
        L8:
            return DELETE;
        L10:
            return UNKNOWN;
        }

        public static QuasiScheduleMessageStatus valueOf(String r100) {
            return (QuasiScheduleMessageStatus) a.a(QuasiScheduleMessageStatus.class, r100);
        }

        private QuasiScheduleMessageStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuasiScheduleMessage();
        DEFAULT_STATUS = QuasiScheduleMessageStatus.UNKNOWN;
        DEFAULT_SCHEDULE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cid = this.cid;
        r100.status = this.status;
        r100.schedule_time = this.schedule_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuasiScheduleMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuasiScheduleMessage(String r100, QuasiScheduleMessageStatus r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public QuasiScheduleMessage(String r100, QuasiScheduleMessageStatus r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.cid = r100;
        this.status = r101;
        this.schedule_time = r102;
    }
}
