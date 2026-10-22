package com.bytedance.lark.pb.feed.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ApplicationInFeedDisplay extends Message<ApplicationInFeedDisplay, Builder> {
    public static final ProtoAdapter<ApplicationInFeedDisplay> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final AppInFeedType DEFAULT_DISPLAY_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_APP_ID = null;
    public static final FieldOptions FIELD_OPTIONS_CALENDAR_CONTENT = null;
    public static final FieldOptions FIELD_OPTIONS_DISPLAY_TYPE = null;
    public static final FieldOptions FIELD_OPTIONS_MEETING_CONTENT = null;
    private static final long serialVersionUID = 0;
    public final Long app_id;
    public final CalendarContent calendar_content;
    public final AppInFeedType display_type;
    public final MeetingContent meeting_content;

    public static final class Builder extends Message.Builder<ApplicationInFeedDisplay, Builder> {
        public Long app_id;
        public CalendarContent calendar_content;
        public AppInFeedType display_type;
        public MeetingContent meeting_content;

        @Override // com.squareup.wire.Message.Builder
        public ApplicationInFeedDisplay build() {
            return new ApplicationInFeedDisplay(this.display_type, this.app_id, this.meeting_content, this.calendar_content, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(Long r100) {
            this.app_id = r100;
            return this;
        }

        public Builder calendar_content(CalendarContent r100) {
            this.calendar_content = r100;
            this.meeting_content = null;
            return this;
        }

        public Builder display_type(AppInFeedType r100) {
            this.display_type = r100;
            return this;
        }

        public Builder meeting_content(MeetingContent r100) {
            this.meeting_content = r100;
            this.calendar_content = null;
            return this;
        }
    }

    public static final class ProtoAdapter_ApplicationInFeedDisplay extends ProtoAdapter<ApplicationInFeedDisplay> {
        public ProtoAdapter_ApplicationInFeedDisplay() {
            super(FieldEncoding.LENGTH_DELIMITED, ApplicationInFeedDisplay.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ApplicationInFeedDisplay decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.display_type = AppInFeedType.Unkonwn;
            r101.app_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.display_type = AppInFeedType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.meeting_content(MeetingContent.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.calendar_content(CalendarContent.ADAPTER.decode(r100));
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
        public int encodedSize2(ApplicationInFeedDisplay r100) {
            AppInFeedType r101 = r100.display_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AppInFeedType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.app_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            MeetingContent r107 = r100.meeting_content;
            if (r107 == null) goto L13;
            int r108 = MeetingContent.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            CalendarContent r110 = r100.calendar_content;
            if (r110 == null) goto L18;
            r102 = CalendarContent.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ApplicationInFeedDisplay decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ApplicationInFeedDisplay r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ApplicationInFeedDisplay r101) throws IOException {
            AppInFeedType r102 = r101.display_type;
            if (r102 == null) goto L5;
            AppInFeedType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.app_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            MeetingContent r104 = r101.meeting_content;
            if (r104 == null) goto L11;
            MeetingContent.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            CalendarContent r105 = r101.calendar_content;
            if (r105 == null) goto L14;
            CalendarContent.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ApplicationInFeedDisplay r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ApplicationInFeedDisplay();
        FIELD_OPTIONS_DISPLAY_TYPE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_APP_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MEETING_CONTENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_CALENDAR_CONTENT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_DISPLAY_TYPE = AppInFeedType.Unkonwn;
        DEFAULT_APP_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.display_type = this.display_type;
        r100.app_id = this.app_id;
        r100.meeting_content = this.meeting_content;
        r100.calendar_content = this.calendar_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ApplicationInFeedDisplay.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ApplicationInFeedDisplay(AppInFeedType r100, Long r101, MeetingContent r102, CalendarContent r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ApplicationInFeedDisplay(AppInFeedType r100, Long r101, MeetingContent r102, CalendarContent r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r102, r103) > 1) goto L7;
        this.display_type = r100;
        this.app_id = r101;
        this.meeting_content = r102;
        this.calendar_content = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of meeting_content, calendar_content may be non-null");
    }
}
