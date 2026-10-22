package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DatetimeFieldValue extends Message<DatetimeFieldValue, Builder> {
    public static final ProtoAdapter<DatetimeFieldValue> ADAPTER = null;
    public static final Long DEFAULT_VALUE = null;
    private static final long serialVersionUID = 0;
    public final Long value;

    public static final class Builder extends Message.Builder<DatetimeFieldValue, Builder> {
        public Long value;

        @Override // com.squareup.wire.Message.Builder
        public DatetimeFieldValue build() {
            return new DatetimeFieldValue(this.value, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder value(Long r100) {
            this.value = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DatetimeFieldValue extends ProtoAdapter<DatetimeFieldValue> {
        public ProtoAdapter_DatetimeFieldValue() {
            super(FieldEncoding.LENGTH_DELIMITED, DatetimeFieldValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DatetimeFieldValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.value = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.value = ProtoAdapter.INT64.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DatetimeFieldValue r100) {
            Long r101 = r100.value;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DatetimeFieldValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DatetimeFieldValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DatetimeFieldValue r101) throws IOException {
            Long r102 = r101.value;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatetimeFieldValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DatetimeFieldValue();
        DEFAULT_VALUE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.value = this.value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DatetimeFieldValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DatetimeFieldValue(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public DatetimeFieldValue(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.value = r100;
    }
}
