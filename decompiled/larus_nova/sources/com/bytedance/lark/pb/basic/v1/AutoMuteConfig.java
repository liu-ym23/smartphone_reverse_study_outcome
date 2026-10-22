package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class AutoMuteConfig extends com.squareup.wire.Message<AutoMuteConfig, Builder> {
    public static final ProtoAdapter<AutoMuteConfig> ADAPTER = null;
    public static final Long DEFAULT_BADGE_COUNT = null;
    public static final Boolean DEFAULT_IS_MUTE = null;
    public static final MuteWay DEFAULT_MUTE_WAY = null;
    public static final Long DEFAULT_POSITION = null;
    private static final long serialVersionUID = 0;
    public final Long badge_count;
    public final Boolean is_mute;
    public final MuteWay mute_way;
    public final Long position;

    public static final class Builder extends com.squareup.wire.Message.Builder<AutoMuteConfig, Builder> {
        public Long badge_count;
        public Boolean is_mute;
        public MuteWay mute_way;
        public Long position;

        @Override // com.squareup.wire.Message.Builder
        public AutoMuteConfig build() {
            return new AutoMuteConfig(this.is_mute, this.position, this.badge_count, this.mute_way, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder badge_count(Long r100) {
            this.badge_count = r100;
            return this;
        }

        public Builder is_mute(Boolean r100) {
            this.is_mute = r100;
            return this;
        }

        public Builder mute_way(MuteWay r100) {
            this.mute_way = r100;
            return this;
        }

        public Builder position(Long r100) {
            this.position = r100;
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
            r101.is_mute = Boolean.FALSE;
            r101.position = 0L;
            r101.badge_count = 0L;
            r101.mute_way = MuteWay.UNKNOWN_MUTE_WAY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.is_mute = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.position = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.badge_count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mute_way = MuteWay.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(AutoMuteConfig r100) {
            Boolean r101 = r100.is_mute;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.position;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.badge_count;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            MuteWay r110 = r100.mute_way;
            if (r110 == null) goto L18;
            r102 = MuteWay.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ AutoMuteConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AutoMuteConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AutoMuteConfig r101) throws IOException {
            Boolean r102 = r101.is_mute;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.position;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.badge_count;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            MuteWay r105 = r101.mute_way;
            if (r105 == null) goto L14;
            MuteWay.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
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
        DEFAULT_MUTE_WAY = MuteWay.UNKNOWN_MUTE_WAY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_mute = this.is_mute;
        r100.position = this.position;
        r100.badge_count = this.badge_count;
        r100.mute_way = this.mute_way;
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

    public AutoMuteConfig(Boolean r100, Long r101, Long r102, MuteWay r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AutoMuteConfig(Boolean r100, Long r101, Long r102, MuteWay r103, ByteString r104) {
        super(ADAPTER, r104);
        this.is_mute = r100;
        this.position = r101;
        this.badge_count = r102;
        this.mute_way = r103;
    }
}
