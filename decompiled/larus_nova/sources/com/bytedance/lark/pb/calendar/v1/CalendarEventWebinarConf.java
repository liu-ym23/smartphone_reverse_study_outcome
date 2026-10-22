package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarEventWebinarConf extends Message<CalendarEventWebinarConf, Builder> {
    public static final ProtoAdapter<CalendarEventWebinarConf> ADAPTER = null;
    public static final Boolean DEFAULT_AUDIENCE_CAN_INVITE_OTHERS = null;
    public static final Boolean DEFAULT_AUDIENCE_CAN_SEE_OTHER_AUDIENCES = null;
    public static final Boolean DEFAULT_AUDIENCE_CAN_SEE_OTHER_SPEAKERS = null;
    public static final Boolean DEFAULT_SPEAKER_CAN_INVITE_OTHERS = null;
    public static final Boolean DEFAULT_SPEAKER_CAN_SEE_OTHER_AUDIENCES = null;
    public static final Boolean DEFAULT_SPEAKER_CAN_SEE_OTHER_SPEAKERS = null;
    private static final long serialVersionUID = 0;
    public final Boolean audience_can_invite_others;
    public final Boolean audience_can_see_other_audiences;
    public final Boolean audience_can_see_other_speakers;
    public final Boolean speaker_can_invite_others;
    public final Boolean speaker_can_see_other_audiences;
    public final Boolean speaker_can_see_other_speakers;

    public static final class Builder extends Message.Builder<CalendarEventWebinarConf, Builder> {
        public Boolean audience_can_invite_others;
        public Boolean audience_can_see_other_audiences;
        public Boolean audience_can_see_other_speakers;
        public Boolean speaker_can_invite_others;
        public Boolean speaker_can_see_other_audiences;
        public Boolean speaker_can_see_other_speakers;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventWebinarConf build() {
            return new CalendarEventWebinarConf(this.speaker_can_see_other_speakers, this.speaker_can_invite_others, this.audience_can_see_other_speakers, this.audience_can_invite_others, this.speaker_can_see_other_audiences, this.audience_can_see_other_audiences, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder audience_can_invite_others(Boolean r100) {
            this.audience_can_invite_others = r100;
            return this;
        }

        public Builder audience_can_see_other_audiences(Boolean r100) {
            this.audience_can_see_other_audiences = r100;
            return this;
        }

        public Builder audience_can_see_other_speakers(Boolean r100) {
            this.audience_can_see_other_speakers = r100;
            return this;
        }

        public Builder speaker_can_invite_others(Boolean r100) {
            this.speaker_can_invite_others = r100;
            return this;
        }

        public Builder speaker_can_see_other_audiences(Boolean r100) {
            this.speaker_can_see_other_audiences = r100;
            return this;
        }

        public Builder speaker_can_see_other_speakers(Boolean r100) {
            this.speaker_can_see_other_speakers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarEventWebinarConf extends ProtoAdapter<CalendarEventWebinarConf> {
        public ProtoAdapter_CalendarEventWebinarConf() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventWebinarConf.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventWebinarConf decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.speaker_can_see_other_speakers = r102;
            r101.speaker_can_invite_others = r102;
            r101.audience_can_see_other_speakers = r102;
            r101.audience_can_invite_others = r102;
            r101.speaker_can_see_other_audiences = r102;
            r101.audience_can_see_other_audiences = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L13;
            switch(r104) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.audience_can_see_other_audiences = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.speaker_can_see_other_audiences = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.audience_can_invite_others = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.audience_can_see_other_speakers = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.speaker_can_invite_others = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.speaker_can_see_other_speakers = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarEventWebinarConf r100) {
            Boolean r101 = r100.speaker_can_see_other_speakers;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.speaker_can_invite_others;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.audience_can_see_other_speakers;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.audience_can_invite_others;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.speaker_can_see_other_audiences;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.audience_can_see_other_audiences;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
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
        public /* bridge */ /* synthetic */ CalendarEventWebinarConf decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventWebinarConf r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventWebinarConf r101) throws IOException {
            Boolean r102 = r101.speaker_can_see_other_speakers;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.speaker_can_invite_others;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.audience_can_see_other_speakers;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.audience_can_invite_others;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.speaker_can_see_other_audiences;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.audience_can_see_other_audiences;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventWebinarConf r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEventWebinarConf();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SPEAKER_CAN_SEE_OTHER_SPEAKERS = r100;
        DEFAULT_SPEAKER_CAN_INVITE_OTHERS = r100;
        DEFAULT_AUDIENCE_CAN_SEE_OTHER_SPEAKERS = r100;
        DEFAULT_AUDIENCE_CAN_INVITE_OTHERS = r100;
        DEFAULT_SPEAKER_CAN_SEE_OTHER_AUDIENCES = r100;
        DEFAULT_AUDIENCE_CAN_SEE_OTHER_AUDIENCES = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.speaker_can_see_other_speakers = this.speaker_can_see_other_speakers;
        r100.speaker_can_invite_others = this.speaker_can_invite_others;
        r100.audience_can_see_other_speakers = this.audience_can_see_other_speakers;
        r100.audience_can_invite_others = this.audience_can_invite_others;
        r100.speaker_can_see_other_audiences = this.speaker_can_see_other_audiences;
        r100.audience_can_see_other_audiences = this.audience_can_see_other_audiences;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventWebinarConf.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventWebinarConf(Boolean r100, Boolean r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public CalendarEventWebinarConf(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.speaker_can_see_other_speakers = r100;
        this.speaker_can_invite_others = r101;
        this.audience_can_see_other_speakers = r102;
        this.audience_can_invite_others = r103;
        this.speaker_can_see_other_audiences = r104;
        this.audience_can_see_other_audiences = r105;
    }
}
