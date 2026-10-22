package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SendHongbaoRecord extends Message<SendHongbaoRecord, Builder> {
    public static final ProtoAdapter<SendHongbaoRecord> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Integer DEFAULT_GRAB_NUM = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_EXPIRED = null;
    public static final Boolean DEFAULT_IS_P2P = null;
    public static final String DEFAULT_RECEIVER_ID = "";
    public static final Long DEFAULT_TOTAL_AMOUNT = null;
    public static final Integer DEFAULT_TOTAL_NUM = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Long create_time;
    public final Integer grab_num;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253653id;
    public final Boolean is_expired;
    public final Boolean is_p2p;
    public final String receiver_id;
    public final Long total_amount;
    public final Integer total_num;

    public static final class Builder extends Message.Builder<SendHongbaoRecord, Builder> {
        public String chat_id;
        public Long create_time;
        public Integer grab_num;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253654id;
        public Boolean is_expired;
        public Boolean is_p2p;
        public String receiver_id;
        public Long total_amount;
        public Integer total_num;

        @Override // com.squareup.wire.Message.Builder
        public SendHongbaoRecord build() {
            String r100 = this.f253654id;
            if (r100 == null) goto L19;
            if (this.total_amount == null) goto L19;
            if (this.create_time == null) goto L19;
            if (this.total_num == null) goto L19;
            if (this.grab_num == null) goto L19;
            if (this.is_expired == null) goto L19;
            if (this.is_p2p == null) goto L19;
            return new SendHongbaoRecord(this.f253654id, this.total_amount, this.create_time, this.total_num, this.grab_num, this.is_expired, this.is_p2p, this.receiver_id, this.chat_id, super.buildUnknownFields());
        L19:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.total_amount, "total_amount", this.create_time, "create_time", this.total_num, "total_num", this.grab_num, "grab_num", this.is_expired, "is_expired", this.is_p2p, "is_p2p"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder grab_num(Integer r100) {
            this.grab_num = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253654id = r100;
            return this;
        }

        public Builder is_expired(Boolean r100) {
            this.is_expired = r100;
            return this;
        }

        public Builder is_p2p(Boolean r100) {
            this.is_p2p = r100;
            return this;
        }

        public Builder receiver_id(String r100) {
            this.receiver_id = r100;
            return this;
        }

        public Builder total_amount(Long r100) {
            this.total_amount = r100;
            return this;
        }

        public Builder total_num(Integer r100) {
            this.total_num = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendHongbaoRecord extends ProtoAdapter<SendHongbaoRecord> {
        public ProtoAdapter_SendHongbaoRecord() {
            super(FieldEncoding.LENGTH_DELIMITED, SendHongbaoRecord.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendHongbaoRecord decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253654id = "";
            r101.total_amount = 0L;
            r101.create_time = 0L;
            r101.total_num = 0;
            r101.grab_num = 0;
            Boolean r102 = Boolean.FALSE;
            r101.is_expired = r102;
            r101.is_p2p = r102;
            r101.receiver_id = "";
            r101.chat_id = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.receiver_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.is_p2p = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.is_expired = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.grab_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.total_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.total_amount = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.f253654id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendHongbaoRecord r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253653id);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            int r104 = (r102 + r103.encodedSizeWithTag(2, r100.total_amount)) + r103.encodedSizeWithTag(3, r100.create_time);
            ProtoAdapter<Integer> r105 = ProtoAdapter.INT32;
            int r106 = (r104 + r105.encodedSizeWithTag(4, r100.total_num)) + r105.encodedSizeWithTag(5, r100.grab_num);
            ProtoAdapter<Boolean> r107 = ProtoAdapter.BOOL;
            int r108 = (r106 + r107.encodedSizeWithTag(6, r100.is_expired)) + r107.encodedSizeWithTag(7, r100.is_p2p);
            String r109 = r100.receiver_id;
            int r110 = 0;
            if (r109 == null) goto L5;
            int r111 = r101.encodedSizeWithTag(8, r109);
        L6:
            int r112 = r108 + r111;
            String r113 = r100.chat_id;
            if (r113 == null) goto L10;
            r110 = r101.encodedSizeWithTag(9, r113);
        L10:
            return (r112 + r110) + r100.unknownFields().size();
        L5:
            r111 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendHongbaoRecord decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendHongbaoRecord r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendHongbaoRecord r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253653id);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 2, r101.total_amount);
            r103.encodeWithTag(r100, 3, r101.create_time);
            ProtoAdapter<Integer> r104 = ProtoAdapter.INT32;
            r104.encodeWithTag(r100, 4, r101.total_num);
            r104.encodeWithTag(r100, 5, r101.grab_num);
            ProtoAdapter<Boolean> r105 = ProtoAdapter.BOOL;
            r105.encodeWithTag(r100, 6, r101.is_expired);
            r105.encodeWithTag(r100, 7, r101.is_p2p);
            String r106 = r101.receiver_id;
            if (r106 == null) goto L5;
            r102.encodeWithTag(r100, 8, r106);
        L5:
            String r107 = r101.chat_id;
            if (r107 == null) goto L8;
            r102.encodeWithTag(r100, 9, r107);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendHongbaoRecord r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendHongbaoRecord();
        DEFAULT_TOTAL_AMOUNT = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_TOTAL_NUM = 0;
        DEFAULT_GRAB_NUM = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_EXPIRED = r100;
        DEFAULT_IS_P2P = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253654id = this.f253653id;
        r100.total_amount = this.total_amount;
        r100.create_time = this.create_time;
        r100.total_num = this.total_num;
        r100.grab_num = this.grab_num;
        r100.is_expired = this.is_expired;
        r100.is_p2p = this.is_p2p;
        r100.receiver_id = this.receiver_id;
        r100.chat_id = this.chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendHongbaoRecord.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendHongbaoRecord(String r110, Long r111, Long r112, Integer r113, Integer r114, Boolean r115, Boolean r116, String r117, String r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public SendHongbaoRecord(String r100, Long r101, Long r102, Integer r103, Integer r104, Boolean r105, Boolean r106, String r107, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.f253653id = r100;
        this.total_amount = r101;
        this.create_time = r102;
        this.total_num = r103;
        this.grab_num = r104;
        this.is_expired = r105;
        this.is_p2p = r106;
        this.receiver_id = r107;
        this.chat_id = r110;
    }
}
