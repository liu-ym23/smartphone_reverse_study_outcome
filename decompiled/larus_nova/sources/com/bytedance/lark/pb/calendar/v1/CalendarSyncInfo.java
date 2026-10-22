package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarSyncInfo extends Message<CalendarSyncInfo, Builder> {
    public static final ProtoAdapter<CalendarSyncInfo> ADAPTER = null;
    public static final String DEFAULT_CALENDAR_ID = "";
    public static final Boolean DEFAULT_IS_SYNCING = null;
    public static final Long DEFAULT_MAX_INSTANCE_CACHE_TIME = null;
    public static final Long DEFAULT_MIN_INSTANCE_CACHE_TIME = null;
    private static final long serialVersionUID = 0;
    public final String calendar_id;
    public final Boolean is_syncing;
    public final Long max_instance_cache_time;
    public final Long min_instance_cache_time;

    public static final class Builder extends Message.Builder<CalendarSyncInfo, Builder> {
        public String calendar_id;
        public Boolean is_syncing;
        public Long max_instance_cache_time;
        public Long min_instance_cache_time;

        @Override // com.squareup.wire.Message.Builder
        public CalendarSyncInfo build() {
            return new CalendarSyncInfo(this.calendar_id, this.is_syncing, this.min_instance_cache_time, this.max_instance_cache_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder calendar_id(String r100) {
            this.calendar_id = r100;
            return this;
        }

        public Builder is_syncing(Boolean r100) {
            this.is_syncing = r100;
            return this;
        }

        public Builder max_instance_cache_time(Long r100) {
            this.max_instance_cache_time = r100;
            return this;
        }

        public Builder min_instance_cache_time(Long r100) {
            this.min_instance_cache_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarSyncInfo extends ProtoAdapter<CalendarSyncInfo> {
        public ProtoAdapter_CalendarSyncInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarSyncInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarSyncInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.calendar_id = "";
            r101.is_syncing = Boolean.FALSE;
            r101.min_instance_cache_time = 0L;
            r101.max_instance_cache_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.calendar_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_syncing = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.min_instance_cache_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.max_instance_cache_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarSyncInfo r100) {
            String r101 = r100.calendar_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_syncing;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.min_instance_cache_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.max_instance_cache_time;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ CalendarSyncInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarSyncInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarSyncInfo r101) throws IOException {
            String r102 = r101.calendar_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_syncing;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.min_instance_cache_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.max_instance_cache_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarSyncInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarSyncInfo();
        DEFAULT_IS_SYNCING = Boolean.FALSE;
        DEFAULT_MIN_INSTANCE_CACHE_TIME = 0L;
        DEFAULT_MAX_INSTANCE_CACHE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.calendar_id = this.calendar_id;
        r100.is_syncing = this.is_syncing;
        r100.min_instance_cache_time = this.min_instance_cache_time;
        r100.max_instance_cache_time = this.max_instance_cache_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarSyncInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarSyncInfo(String r100, Boolean r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CalendarSyncInfo(String r100, Boolean r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.calendar_id = r100;
        this.is_syncing = r101;
        this.min_instance_cache_time = r102;
        this.max_instance_cache_time = r103;
    }
}
