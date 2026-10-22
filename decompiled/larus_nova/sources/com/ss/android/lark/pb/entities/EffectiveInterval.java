package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class EffectiveInterval extends com.squareup.wire.Message<EffectiveInterval, Builder> {
    public static final ProtoAdapter<EffectiveInterval> ADAPTER = null;
    public static final Long DEFAULT_END_TIME = null;
    public static final Boolean DEFAULT_IS_OPEN_WITHOUT_END_TIME = null;
    public static final Boolean DEFAULT_IS_SHOW_END_TIME = null;
    public static final Long DEFAULT_START_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long mend_time;
    public final Boolean mis_open_without_end_time;
    public final Boolean mis_show_end_time;
    public final Long mstart_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<EffectiveInterval, Builder> {
        public Long mend_time;
        public Boolean mis_open_without_end_time;
        public Boolean mis_show_end_time;
        public Long mstart_time;

        @Override // com.squareup.wire.Message.Builder
        public EffectiveInterval build() {
            return new EffectiveInterval(this.mstart_time, this.mend_time, this.mis_show_end_time, this.mis_open_without_end_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder end_time(Long r100) {
            this.mend_time = r100;
            return this;
        }

        public Builder is_open_without_end_time(Boolean r100) {
            this.mis_open_without_end_time = r100;
            return this;
        }

        public Builder is_show_end_time(Boolean r100) {
            this.mis_show_end_time = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.mstart_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EffectiveInterval extends ProtoAdapter<EffectiveInterval> {
        public ProtoAdapter_EffectiveInterval() {
            super(FieldEncoding.LENGTH_DELIMITED, EffectiveInterval.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EffectiveInterval decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstart_time = 0L;
            r101.mend_time = 0L;
            r101.mis_show_end_time = Boolean.TRUE;
            r101.mis_open_without_end_time = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mstart_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mend_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mis_show_end_time = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mis_open_without_end_time = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(EffectiveInterval r100) {
            Long r101 = r100.mstart_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mend_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mis_show_end_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mis_open_without_end_time;
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
        public /* bridge */ /* synthetic */ EffectiveInterval decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EffectiveInterval r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EffectiveInterval r101) throws IOException {
            Long r102 = r101.mstart_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mend_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mis_show_end_time;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mis_open_without_end_time;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EffectiveInterval r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EffectiveInterval();
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
        DEFAULT_IS_SHOW_END_TIME = Boolean.TRUE;
        DEFAULT_IS_OPEN_WITHOUT_END_TIME = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstart_time = this.mstart_time;
        r100.mend_time = this.mend_time;
        r100.mis_show_end_time = this.mis_show_end_time;
        r100.mis_open_without_end_time = this.mis_open_without_end_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EffectiveInterval.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EffectiveInterval(Long r100, Long r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public EffectiveInterval(Long r100, Long r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mstart_time = r100;
        this.mend_time = r101;
        this.mis_show_end_time = r102;
        this.mis_open_without_end_time = r103;
    }
}
