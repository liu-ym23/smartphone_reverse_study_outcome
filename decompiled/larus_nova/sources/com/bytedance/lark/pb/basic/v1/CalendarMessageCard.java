package com.bytedance.lark.pb.basic.v1;

import com.bytedance.lark.pb.calendar.v1.Calendar;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarMessageCard extends com.squareup.wire.Message<CalendarMessageCard, Builder> {
    public static final ProtoAdapter<CalendarMessageCard> ADAPTER = null;
    public static final String DEFAULT_CALENDAR_ID = "";
    public static final String DEFAULT_INVITER_USER_ID = "";
    public static final Boolean DEFAULT_IS_PRIMARY = null;
    public static final Calendar.AccessRole DEFAULT_SELF_ACCESS_ROLE = null;
    public static final String DEFAULT_SUMMARY = "";
    public static final Integer DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String calendar_id;
    public final String inviter_user_id;
    public final Boolean is_primary;
    public final Calendar.AccessRole self_access_role;
    public final String summary;
    public final Integer type;

    public static final class Builder extends com.squareup.wire.Message.Builder<CalendarMessageCard, Builder> {
        public String calendar_id;
        public String inviter_user_id;
        public Boolean is_primary;
        public Calendar.AccessRole self_access_role;
        public String summary;
        public Integer type;

        @Override // com.squareup.wire.Message.Builder
        public CalendarMessageCard build() {
            return new CalendarMessageCard(this.calendar_id, this.inviter_user_id, this.summary, this.type, this.is_primary, this.self_access_role, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder calendar_id(String r100) {
            this.calendar_id = r100;
            return this;
        }

        public Builder inviter_user_id(String r100) {
            this.inviter_user_id = r100;
            return this;
        }

        public Builder is_primary(Boolean r100) {
            this.is_primary = r100;
            return this;
        }

        public Builder self_access_role(Calendar.AccessRole r100) {
            this.self_access_role = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }

        public Builder type(Integer r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarMessageCard extends ProtoAdapter<CalendarMessageCard> {
        public ProtoAdapter_CalendarMessageCard() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarMessageCard.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarMessageCard decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.calendar_id = "";
            r101.inviter_user_id = "";
            r101.summary = "";
            r101.type = 1;
            r101.is_primary = Boolean.FALSE;
            r101.self_access_role = Calendar.AccessRole.UNKNOWN_ACCESS_ROLE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L18;
                default: goto L6;
            };
        L18:
            r101.self_access_role = Calendar.AccessRole.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.is_primary = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.inviter_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarMessageCard r100) {
            String r101 = r100.calendar_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.inviter_user_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.summary;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.type;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_primary;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Calendar.AccessRole r116 = r100.self_access_role;
            if (r116 == null) goto L26;
            r102 = Calendar.AccessRole.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ CalendarMessageCard decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarMessageCard r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarMessageCard r101) throws IOException {
            String r102 = r101.calendar_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.inviter_user_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.summary;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.type;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_primary;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Calendar.AccessRole r107 = r101.self_access_role;
            if (r107 == null) goto L20;
            Calendar.AccessRole.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarMessageCard r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarMessageCard();
        DEFAULT_TYPE = 1;
        DEFAULT_IS_PRIMARY = Boolean.FALSE;
        DEFAULT_SELF_ACCESS_ROLE = Calendar.AccessRole.UNKNOWN_ACCESS_ROLE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.calendar_id = this.calendar_id;
        r100.inviter_user_id = this.inviter_user_id;
        r100.summary = this.summary;
        r100.type = this.type;
        r100.is_primary = this.is_primary;
        r100.self_access_role = this.self_access_role;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarMessageCard.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarMessageCard(String r100, String r110, String r111, Integer r112, Boolean r113, Calendar.AccessRole r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public CalendarMessageCard(String r100, String r101, String r102, Integer r103, Boolean r104, Calendar.AccessRole r105, ByteString r106) {
        super(ADAPTER, r106);
        this.calendar_id = r100;
        this.inviter_user_id = r101;
        this.summary = r102;
        this.type = r103;
        this.is_primary = r104;
        this.self_access_role = r105;
    }
}
