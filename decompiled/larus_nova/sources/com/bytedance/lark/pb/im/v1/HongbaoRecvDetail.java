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
public final class HongbaoRecvDetail extends Message<HongbaoRecvDetail, Builder> {
    public static final ProtoAdapter<HongbaoRecvDetail> ADAPTER = null;
    public static final Long DEFAULT_AMOUNT = null;
    public static final HongbaoGrabStatus DEFAULT_RECEIVE_STATUS = null;
    public static final Long DEFAULT_TIME = null;
    public static final String DEFAULT_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final Long amount;
    public final HongbaoGrabStatus receive_status;
    public final Long time;
    public final String user_id;

    public static final class Builder extends Message.Builder<HongbaoRecvDetail, Builder> {
        public Long amount;
        public HongbaoGrabStatus receive_status;
        public Long time;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public HongbaoRecvDetail build() {
            String r100 = this.user_id;
            if (r100 == null) goto L11;
            if (this.amount == null) goto L11;
            if (this.time == null) goto L11;
            return new HongbaoRecvDetail(this.user_id, this.amount, this.time, this.receive_status, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.amount, "amount", this.time, "time"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder amount(Long r100) {
            this.amount = r100;
            return this;
        }

        public Builder receive_status(HongbaoGrabStatus r100) {
            this.receive_status = r100;
            return this;
        }

        public Builder time(Long r100) {
            this.time = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final enum HongbaoGrabStatus extends Enum<HongbaoGrabStatus> implements WireEnum {
        private static final /* synthetic */ HongbaoGrabStatus[] $VALUES = null;
        public static final ProtoAdapter<HongbaoGrabStatus> ADAPTER = null;
        public static final HongbaoGrabStatus GRABBED = null;
        public static final HongbaoGrabStatus UNGRABBED = null;
        public static final HongbaoGrabStatus UNKNOWN = null;
        private final int value;

        static {
            HongbaoGrabStatus r100 = new HongbaoGrabStatus("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            HongbaoGrabStatus r101 = new HongbaoGrabStatus("UNGRABBED", 1, 1);
            UNGRABBED = r101;
            HongbaoGrabStatus r102 = new HongbaoGrabStatus("GRABBED", 2, 2);
            GRABBED = r102;
            $VALUES = new HongbaoGrabStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(HongbaoGrabStatus.class);
        }

        public static HongbaoGrabStatus[] values() {
            return (HongbaoGrabStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static HongbaoGrabStatus fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return GRABBED;
        L12:
            return UNGRABBED;
        L14:
            return UNKNOWN;
        }

        public static HongbaoGrabStatus valueOf(String r100) {
            return (HongbaoGrabStatus) a.a(HongbaoGrabStatus.class, r100);
        }

        private HongbaoGrabStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_HongbaoRecvDetail extends ProtoAdapter<HongbaoRecvDetail> {
        public ProtoAdapter_HongbaoRecvDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, HongbaoRecvDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HongbaoRecvDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            r101.amount = 0L;
            r101.time = 0L;
            r101.receive_status = HongbaoGrabStatus.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.amount = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.receive_status = HongbaoGrabStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HongbaoRecvDetail r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.user_id);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.amount)) + r102.encodedSizeWithTag(3, r100.time);
            HongbaoGrabStatus r104 = r100.receive_status;
            if (r104 == null) goto L5;
            int r105 = HongbaoGrabStatus.ADAPTER.encodedSizeWithTag(4, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HongbaoRecvDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HongbaoRecvDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HongbaoRecvDetail r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.user_id);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 2, r101.amount);
            r102.encodeWithTag(r100, 3, r101.time);
            HongbaoGrabStatus r103 = r101.receive_status;
            if (r103 == null) goto L5;
            HongbaoGrabStatus.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HongbaoRecvDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HongbaoRecvDetail();
        DEFAULT_AMOUNT = 0L;
        DEFAULT_TIME = 0L;
        DEFAULT_RECEIVE_STATUS = HongbaoGrabStatus.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.amount = this.amount;
        r100.time = this.time;
        r100.receive_status = this.receive_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HongbaoRecvDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HongbaoRecvDetail(String r100, Long r101, Long r102, HongbaoGrabStatus r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public HongbaoRecvDetail(String r100, Long r101, Long r102, HongbaoGrabStatus r103, ByteString r104) {
        super(ADAPTER, r104);
        this.user_id = r100;
        this.amount = r101;
        this.time = r102;
        this.receive_status = r103;
    }
}
