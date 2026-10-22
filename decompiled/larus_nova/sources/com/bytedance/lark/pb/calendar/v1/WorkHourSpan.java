package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class WorkHourSpan extends Message<WorkHourSpan, Builder> {
    public static final ProtoAdapter<WorkHourSpan> ADAPTER = null;
    public static final Integer DEFAULT_END_MINUTE = null;
    public static final Integer DEFAULT_START_MINUTE = null;
    private static final long serialVersionUID = 0;
    public final Integer end_minute;
    public final Integer start_minute;

    public static final class Builder extends Message.Builder<WorkHourSpan, Builder> {
        public Integer end_minute;
        public Integer start_minute;

        @Override // com.squareup.wire.Message.Builder
        public WorkHourSpan build() {
            Integer r100 = this.start_minute;
            if (r100 == null) goto L9;
            if (this.end_minute == null) goto L9;
            return new WorkHourSpan(this.start_minute, this.end_minute, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "start_minute", this.end_minute, "end_minute"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder end_minute(Integer r100) {
            this.end_minute = r100;
            return this;
        }

        public Builder start_minute(Integer r100) {
            this.start_minute = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkHourSpan extends ProtoAdapter<WorkHourSpan> {
        public ProtoAdapter_WorkHourSpan() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkHourSpan.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WorkHourSpan decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.start_minute = 0;
            r101.end_minute = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.start_minute = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.end_minute = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(WorkHourSpan r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return (r101.encodedSizeWithTag(1, r100.start_minute) + r101.encodedSizeWithTag(2, r100.end_minute)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WorkHourSpan decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WorkHourSpan r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WorkHourSpan r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.start_minute);
            r102.encodeWithTag(r100, 2, r101.end_minute);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WorkHourSpan r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkHourSpan();
        DEFAULT_START_MINUTE = 0;
        DEFAULT_END_MINUTE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.start_minute = this.start_minute;
        r100.end_minute = this.end_minute;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WorkHourSpan.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WorkHourSpan(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public WorkHourSpan(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.start_minute = r100;
        this.end_minute = r101;
    }
}
