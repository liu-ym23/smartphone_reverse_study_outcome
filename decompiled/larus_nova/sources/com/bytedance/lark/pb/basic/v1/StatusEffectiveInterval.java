package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class StatusEffectiveInterval extends com.squareup.wire.Message<StatusEffectiveInterval, Builder> {
    public static final ProtoAdapter<StatusEffectiveInterval> ADAPTER = null;
    public static final Long DEFAULT_END_TIME = null;
    public static final Boolean DEFAULT_IS_OPEN_WITHOUT_END_TIME = null;
    public static final Boolean DEFAULT_IS_SHOW_END_TIME = null;
    public static final Long DEFAULT_START_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long end_time;
    public final Boolean is_open_without_end_time;
    public final Boolean is_show_end_time;
    public final Long start_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<StatusEffectiveInterval, Builder> {
        public Long end_time;
        public Boolean is_open_without_end_time;
        public Boolean is_show_end_time;
        public Long start_time;

        @Override // com.squareup.wire.Message.Builder
        public StatusEffectiveInterval build() {
            return new StatusEffectiveInterval(this.start_time, this.end_time, this.is_show_end_time, this.is_open_without_end_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder end_time(Long r100) {
            this.end_time = r100;
            return this;
        }

        public Builder is_open_without_end_time(Boolean r100) {
            this.is_open_without_end_time = r100;
            return this;
        }

        public Builder is_show_end_time(Boolean r100) {
            this.is_show_end_time = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.start_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_StatusEffectiveInterval extends ProtoAdapter<StatusEffectiveInterval> {
        public ProtoAdapter_StatusEffectiveInterval() {
            super(FieldEncoding.LENGTH_DELIMITED, StatusEffectiveInterval.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public StatusEffectiveInterval decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.start_time = 0L;
            r101.end_time = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.is_show_end_time = r102;
            r101.is_open_without_end_time = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.start_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.end_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.is_show_end_time = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.is_open_without_end_time = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(StatusEffectiveInterval r100) {
            Long r101 = r100.start_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.end_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_show_end_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_open_without_end_time;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ StatusEffectiveInterval decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StatusEffectiveInterval r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StatusEffectiveInterval r101) throws IOException {
            Long r102 = r101.start_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.end_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_show_end_time;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_open_without_end_time;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StatusEffectiveInterval r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StatusEffectiveInterval();
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_SHOW_END_TIME = r100;
        DEFAULT_IS_OPEN_WITHOUT_END_TIME = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.start_time = this.start_time;
        r100.end_time = this.end_time;
        r100.is_show_end_time = this.is_show_end_time;
        r100.is_open_without_end_time = this.is_open_without_end_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return StatusEffectiveInterval.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public StatusEffectiveInterval(Long r100, Long r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public StatusEffectiveInterval(Long r100, Long r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.start_time = r100;
        this.end_time = r101;
        this.is_show_end_time = r102;
        this.is_open_without_end_time = r103;
    }
}
