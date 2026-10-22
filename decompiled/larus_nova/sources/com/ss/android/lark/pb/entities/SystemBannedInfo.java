package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SystemBannedInfo extends com.squareup.wire.Message<SystemBannedInfo, Builder> {
    public static final ProtoAdapter<SystemBannedInfo> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_AT = null;
    public static final Boolean DEFAULT_IS_BANNED = null;
    public static final Boolean DEFAULT_IS_PERMANENT = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mappeal_urls;
    public final List<BlockedFeature> mblocked_features;
    public final Long mexpire_at;
    public final Boolean mis_banned;
    public final Boolean mis_permanent;

    public static final class Builder extends com.squareup.wire.Message.Builder<SystemBannedInfo, Builder> {
        public Map<String, String> mappeal_urls;
        public List<BlockedFeature> mblocked_features;
        public Long mexpire_at;
        public Boolean mis_banned;
        public Boolean mis_permanent;

        @Override // com.squareup.wire.Message.Builder
        public SystemBannedInfo build() {
            return new SystemBannedInfo(this.mis_banned, this.mexpire_at, this.mappeal_urls, this.mblocked_features, this.mis_permanent, super.buildUnknownFields());
        }

        public Builder() {
            this.mappeal_urls = Internal.newMutableMap();
            this.mblocked_features = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder appeal_urls(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mappeal_urls = r100;
            return this;
        }

        public Builder blocked_features(List<BlockedFeature> r100) {
            Internal.checkElementsNotNull(r100);
            this.mblocked_features = r100;
            return this;
        }

        public Builder expire_at(Long r100) {
            this.mexpire_at = r100;
            return this;
        }

        public Builder is_banned(Boolean r100) {
            this.mis_banned = r100;
            return this;
        }

        public Builder is_permanent(Boolean r100) {
            this.mis_permanent = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SystemBannedInfo extends ProtoAdapter<SystemBannedInfo> {
        private final ProtoAdapter<Map<String, String>> mappeal_urls;

        public ProtoAdapter_SystemBannedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SystemBannedInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mappeal_urls = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SystemBannedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mis_banned = r102;
            r101.mexpire_at = 0L;
            r101.mis_permanent = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L24;
            if (r104 != 1) goto L8;
            r101.mis_banned = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mexpire_at = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mappeal_urls.putAll(this.mappeal_urls.decode(r100));
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.mblocked_features.add(BlockedFeature.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.mis_permanent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SystemBannedInfo r100) {
            Boolean r101 = r100.mis_banned;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mexpire_at;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = ((r103 + r105) + this.mappeal_urls.encodedSizeWithTag(3, r100.mappeal_urls)) + BlockedFeature.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mblocked_features);
            Boolean r107 = r100.mis_permanent;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SystemBannedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SystemBannedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SystemBannedInfo r101) throws IOException {
            Boolean r102 = r101.mis_banned;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mexpire_at;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            this.mappeal_urls.encodeWithTag(r100, 3, r101.mappeal_urls);
            BlockedFeature.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mblocked_features);
            Boolean r104 = r101.mis_permanent;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SystemBannedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SystemBannedInfo();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_BANNED = r100;
        DEFAULT_EXPIRE_AT = 0L;
        DEFAULT_IS_PERMANENT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_banned = this.mis_banned;
        r100.mexpire_at = this.mexpire_at;
        r100.mappeal_urls = Internal.copyOf("mappeal_urls", this.mappeal_urls);
        r100.mblocked_features = Internal.copyOf("mblocked_features", this.mblocked_features);
        r100.mis_permanent = this.mis_permanent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SystemBannedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SystemBannedInfo(Boolean r100, Long r101, Map<String, String> r110, List<BlockedFeature> r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SystemBannedInfo(Boolean r100, Long r101, Map<String, String> r102, List<BlockedFeature> r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mis_banned = r100;
        this.mexpire_at = r101;
        this.mappeal_urls = Internal.immutableCopyOf("mappeal_urls", r102);
        this.mblocked_features = Internal.immutableCopyOf("mblocked_features", r103);
        this.mis_permanent = r104;
    }
}
