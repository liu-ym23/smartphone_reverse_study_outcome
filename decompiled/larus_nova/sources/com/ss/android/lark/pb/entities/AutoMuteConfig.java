package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AutoMuteConfig extends com.squareup.wire.Message<AutoMuteConfig, Builder> {
    public static final ProtoAdapter<AutoMuteConfig> ADAPTER = null;
    public static final Long DEFAULT_BADGE_COUNT = null;
    public static final Boolean DEFAULT_IS_MUTE = null;
    public static final Long DEFAULT_OPEN_MUTE_TIME_MS = null;
    public static final Long DEFAULT_POSITION = null;
    private static final long serialVersionUID = 0;
    public final Long mbadge_count;
    public final Boolean mis_mute;
    public final MuteWay mmute_way;
    public final Long mopen_mute_time_ms;
    public final Long mposition;

    public static final class Builder extends com.squareup.wire.Message.Builder<AutoMuteConfig, Builder> {
        public Long mbadge_count;
        public Boolean mis_mute;
        public MuteWay mmute_way;
        public Long mopen_mute_time_ms;
        public Long mposition;

        @Override // com.squareup.wire.Message.Builder
        public AutoMuteConfig build() {
            return new AutoMuteConfig(this.mis_mute, this.mposition, this.mbadge_count, this.mmute_way, this.mopen_mute_time_ms, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder badge_count(Long r100) {
            this.mbadge_count = r100;
            return this;
        }

        public Builder is_mute(Boolean r100) {
            this.mis_mute = r100;
            return this;
        }

        public Builder mute_way(MuteWay r100) {
            this.mmute_way = r100;
            return this;
        }

        public Builder open_mute_time_ms(Long r100) {
            this.mopen_mute_time_ms = r100;
            return this;
        }

        public Builder position(Long r100) {
            this.mposition = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AutoMuteConfig extends ProtoAdapter<AutoMuteConfig> {
        public ProtoAdapter_AutoMuteConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, AutoMuteConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AutoMuteConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_mute = Boolean.FALSE;
            r101.mposition = 0L;
            r101.mbadge_count = 0L;
            r101.mopen_mute_time_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.mis_mute = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mposition = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mbadge_count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mmute_way = MuteWay.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mopen_mute_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AutoMuteConfig r100) {
            Boolean r101 = r100.mis_mute;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mposition;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.mbadge_count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            MuteWay r110 = r100.mmute_way;
            if (r110 == null) goto L17;
            int r111 = MuteWay.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.mopen_mute_time_ms;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ AutoMuteConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AutoMuteConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AutoMuteConfig r101) throws IOException {
            Boolean r102 = r101.mis_mute;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mposition;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.mbadge_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            MuteWay r105 = r101.mmute_way;
            if (r105 == null) goto L14;
            MuteWay.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.mopen_mute_time_ms;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AutoMuteConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AutoMuteConfig();
        DEFAULT_IS_MUTE = Boolean.FALSE;
        DEFAULT_POSITION = 0L;
        DEFAULT_BADGE_COUNT = 0L;
        DEFAULT_OPEN_MUTE_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_mute = this.mis_mute;
        r100.mposition = this.mposition;
        r100.mbadge_count = this.mbadge_count;
        r100.mmute_way = this.mmute_way;
        r100.mopen_mute_time_ms = this.mopen_mute_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AutoMuteConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AutoMuteConfig(Boolean r100, Long r101, Long r110, MuteWay r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AutoMuteConfig(Boolean r100, Long r101, Long r102, MuteWay r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mis_mute = r100;
        this.mposition = r101;
        this.mbadge_count = r102;
        this.mmute_way = r103;
        this.mopen_mute_time_ms = r104;
    }
}
