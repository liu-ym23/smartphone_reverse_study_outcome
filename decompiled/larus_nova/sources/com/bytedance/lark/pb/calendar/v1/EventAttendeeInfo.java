package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EventAttendeeInfo extends Message<EventAttendeeInfo, Builder> {
    public static final ProtoAdapter<EventAttendeeInfo> ADAPTER = null;
    public static final Integer DEFAULT_ACCEPT_NO = null;
    public static final Boolean DEFAULT_ALL_INDIVIDUAL_ATTENDEE = null;
    public static final Integer DEFAULT_DECLINE_NO = null;
    public static final Integer DEFAULT_NEED_ACTION_NO = null;
    public static final String DEFAULT_SNAPSHOT_PAGE_TOKEN = "";
    public static final Integer DEFAULT_TENTATIVE_NO = null;
    public static final Integer DEFAULT_TOTAL_NO = null;
    private static final long serialVersionUID = 0;
    public final Integer accept_no;
    public final Boolean all_individual_attendee;
    public final Integer decline_no;
    public final Integer need_action_no;
    public final String snapshot_page_token;
    public final Integer tentative_no;
    public final Integer total_no;

    public static final class Builder extends Message.Builder<EventAttendeeInfo, Builder> {
        public Integer accept_no;
        public Boolean all_individual_attendee;
        public Integer decline_no;
        public Integer need_action_no;
        public String snapshot_page_token;
        public Integer tentative_no;
        public Integer total_no;

        @Override // com.squareup.wire.Message.Builder
        public EventAttendeeInfo build() {
            return new EventAttendeeInfo(this.total_no, this.accept_no, this.decline_no, this.tentative_no, this.need_action_no, this.all_individual_attendee, this.snapshot_page_token, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder accept_no(Integer r100) {
            this.accept_no = r100;
            return this;
        }

        public Builder all_individual_attendee(Boolean r100) {
            this.all_individual_attendee = r100;
            return this;
        }

        public Builder decline_no(Integer r100) {
            this.decline_no = r100;
            return this;
        }

        public Builder need_action_no(Integer r100) {
            this.need_action_no = r100;
            return this;
        }

        public Builder snapshot_page_token(String r100) {
            this.snapshot_page_token = r100;
            return this;
        }

        public Builder tentative_no(Integer r100) {
            this.tentative_no = r100;
            return this;
        }

        public Builder total_no(Integer r100) {
            this.total_no = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EventAttendeeInfo extends ProtoAdapter<EventAttendeeInfo> {
        public ProtoAdapter_EventAttendeeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EventAttendeeInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EventAttendeeInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.total_no = 0;
            r101.accept_no = 0;
            r101.decline_no = 0;
            r101.tentative_no = 0;
            r101.need_action_no = 0;
            r101.all_individual_attendee = Boolean.FALSE;
            r101.snapshot_page_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.snapshot_page_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.all_individual_attendee = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.need_action_no = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.tentative_no = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.decline_no = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.accept_no = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.total_no = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EventAttendeeInfo r100) {
            Integer r101 = r100.total_no;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.accept_no;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.decline_no;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.tentative_no;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.need_action_no;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.all_individual_attendee;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.snapshot_page_token;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ EventAttendeeInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EventAttendeeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EventAttendeeInfo r101) throws IOException {
            Integer r102 = r101.total_no;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.accept_no;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.decline_no;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.tentative_no;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Integer r106 = r101.need_action_no;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.all_individual_attendee;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.snapshot_page_token;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EventAttendeeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventAttendeeInfo();
        DEFAULT_TOTAL_NO = 0;
        DEFAULT_ACCEPT_NO = 0;
        DEFAULT_DECLINE_NO = 0;
        DEFAULT_TENTATIVE_NO = 0;
        DEFAULT_NEED_ACTION_NO = 0;
        DEFAULT_ALL_INDIVIDUAL_ATTENDEE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.total_no = this.total_no;
        r100.accept_no = this.accept_no;
        r100.decline_no = this.decline_no;
        r100.tentative_no = this.tentative_no;
        r100.need_action_no = this.need_action_no;
        r100.all_individual_attendee = this.all_individual_attendee;
        r100.snapshot_page_token = this.snapshot_page_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EventAttendeeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EventAttendeeInfo(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Boolean r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public EventAttendeeInfo(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Boolean r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.total_no = r100;
        this.accept_no = r101;
        this.decline_no = r102;
        this.tentative_no = r103;
        this.need_action_no = r104;
        this.all_individual_attendee = r105;
        this.snapshot_page_token = r106;
    }
}
