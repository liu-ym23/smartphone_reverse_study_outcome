package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DataTypeStartTime extends Message<DataTypeStartTime, Builder> {
    public static final ProtoAdapter<DataTypeStartTime> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ALL_DAY = null;
    public static final Long DEFAULT_START_TIME = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_all_day;
    public final Long start_time;

    public static final class Builder extends Message.Builder<DataTypeStartTime, Builder> {
        public Boolean is_all_day;
        public Long start_time;

        @Override // com.squareup.wire.Message.Builder
        public DataTypeStartTime build() {
            return new DataTypeStartTime(this.start_time, this.is_all_day, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_all_day(Boolean r100) {
            this.is_all_day = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.start_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DataTypeStartTime extends ProtoAdapter<DataTypeStartTime> {
        public ProtoAdapter_DataTypeStartTime() {
            super(FieldEncoding.LENGTH_DELIMITED, DataTypeStartTime.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DataTypeStartTime decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.start_time = 0L;
            r101.is_all_day = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.start_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DataTypeStartTime r100) {
            Long r101 = r100.start_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_all_day;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DataTypeStartTime decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DataTypeStartTime r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DataTypeStartTime r101) throws IOException {
            Long r102 = r101.start_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_all_day;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DataTypeStartTime r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DataTypeStartTime();
        DEFAULT_START_TIME = 0L;
        DEFAULT_IS_ALL_DAY = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.start_time = this.start_time;
        r100.is_all_day = this.is_all_day;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DataTypeStartTime.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DataTypeStartTime(Long r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DataTypeStartTime(Long r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.start_time = r100;
        this.is_all_day = r101;
    }
}
