package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TnsSystemBannedInfo extends com.squareup.wire.Message<TnsSystemBannedInfo, Builder> {
    public static final ProtoAdapter<TnsSystemBannedInfo> ADAPTER = null;
    public static final String DEFAULT_APPEAL_URL = "";
    public static final Long DEFAULT_EXPIRE_AT = null;
    public static final Boolean DEFAULT_IS_BANNED = null;
    public static final Boolean DEFAULT_IS_PERMANENT = null;
    private static final long serialVersionUID = 0;
    public final String appeal_url;
    public final Map<String, String> appeal_urls;
    public final List<TnsBlockedFeature> blocked_features;
    public final Long expire_at;
    public final Boolean is_banned;
    public final Boolean is_permanent;

    public static final class Builder extends com.squareup.wire.Message.Builder<TnsSystemBannedInfo, Builder> {
        public String appeal_url;
        public Map<String, String> appeal_urls;
        public List<TnsBlockedFeature> blocked_features;
        public Long expire_at;
        public Boolean is_banned;
        public Boolean is_permanent;

        @Override // com.squareup.wire.Message.Builder
        public TnsSystemBannedInfo build() {
            return new TnsSystemBannedInfo(this.is_banned, this.expire_at, this.appeal_urls, this.blocked_features, this.is_permanent, this.appeal_url, super.buildUnknownFields());
        }

        public Builder() {
            this.appeal_urls = Internal.newMutableMap();
            this.blocked_features = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder appeal_url(String r100) {
            this.appeal_url = r100;
            return this;
        }

        public Builder appeal_urls(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.appeal_urls = r100;
            return this;
        }

        public Builder blocked_features(List<TnsBlockedFeature> r100) {
            Internal.checkElementsNotNull(r100);
            this.blocked_features = r100;
            return this;
        }

        public Builder expire_at(Long r100) {
            this.expire_at = r100;
            return this;
        }

        public Builder is_banned(Boolean r100) {
            this.is_banned = r100;
            return this;
        }

        public Builder is_permanent(Boolean r100) {
            this.is_permanent = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TnsSystemBannedInfo extends ProtoAdapter<TnsSystemBannedInfo> {
        private final ProtoAdapter<Map<String, String>> appeal_urls;

        public ProtoAdapter_TnsSystemBannedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TnsSystemBannedInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.appeal_urls = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TnsSystemBannedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_banned = r102;
            r101.expire_at = 0L;
            r101.is_permanent = r102;
            r101.appeal_url = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L16;
            switch(r104) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L18;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r101.blocked_features.add(TnsBlockedFeature.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.appeal_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.is_permanent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.appeal_urls.putAll(this.appeal_urls.decode(r100));
            goto L3
        L14:
            r101.expire_at = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.is_banned = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L16:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TnsSystemBannedInfo r100) {
            Boolean r101 = r100.is_banned;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.expire_at;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = ((r103 + r105) + this.appeal_urls.encodedSizeWithTag(3, r100.appeal_urls)) + TnsBlockedFeature.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.blocked_features);
            Boolean r107 = r100.is_permanent;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.appeal_url;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r110);
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
        public /* bridge */ /* synthetic */ TnsSystemBannedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TnsSystemBannedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TnsSystemBannedInfo r101) throws IOException {
            Boolean r102 = r101.is_banned;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.expire_at;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            this.appeal_urls.encodeWithTag(r100, 3, r101.appeal_urls);
            TnsBlockedFeature.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.blocked_features);
            Boolean r104 = r101.is_permanent;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L11:
            String r105 = r101.appeal_url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TnsSystemBannedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TnsSystemBannedInfo();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_BANNED = r100;
        DEFAULT_EXPIRE_AT = 0L;
        DEFAULT_IS_PERMANENT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_banned = this.is_banned;
        r100.expire_at = this.expire_at;
        r100.appeal_urls = Internal.copyOf("appeal_urls", this.appeal_urls);
        r100.blocked_features = Internal.copyOf("blocked_features", this.blocked_features);
        r100.is_permanent = this.is_permanent;
        r100.appeal_url = this.appeal_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TnsSystemBannedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TnsSystemBannedInfo(Boolean r100, Long r110, Map<String, String> r111, List<TnsBlockedFeature> r112, Boolean r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public TnsSystemBannedInfo(Boolean r100, Long r101, Map<String, String> r102, List<TnsBlockedFeature> r103, Boolean r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.is_banned = r100;
        this.expire_at = r101;
        this.appeal_urls = Internal.immutableCopyOf("appeal_urls", r102);
        this.blocked_features = Internal.immutableCopyOf("blocked_features", r103);
        this.is_permanent = r104;
        this.appeal_url = r105;
    }
}
