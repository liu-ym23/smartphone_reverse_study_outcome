package com.bytedance.lark.pb.openplatform.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PullOpenAppBadgeNodesRequest extends Message<PullOpenAppBadgeNodesRequest, Builder> {
    public static final ProtoAdapter<PullOpenAppBadgeNodesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_MOBILE = null;
    public static final Boolean DEFAULT_NEED_TRIGGER_PUSH = null;
    public static final CommonEnum.LoadStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_PullOpenAppBadgeNodesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<IdFeaturePair> id_feature_pairs;
    public final Boolean is_mobile;
    public final Boolean need_trigger_push;
    public final CommonEnum.LoadStrategy strategy;

    public static final class Builder extends Message.Builder<PullOpenAppBadgeNodesRequest, Builder> implements d<PullOpenAppBadgeNodesRequest> {
        public List<IdFeaturePair> id_feature_pairs;
        public Boolean is_mobile;
        public Boolean need_trigger_push;
        public CommonEnum.LoadStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public PullOpenAppBadgeNodesRequest build() {
            Boolean r100 = this.is_mobile;
            if (r100 == null) goto L7;
            return new PullOpenAppBadgeNodesRequest(this.id_feature_pairs, this.is_mobile, this.strategy, this.need_trigger_push, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_mobile"});
        }

        public Builder() {
            this.id_feature_pairs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id_feature_pairs(List<IdFeaturePair> r100) {
            Internal.checkElementsNotNull(r100);
            this.id_feature_pairs = r100;
            return this;
        }

        public Builder is_mobile(Boolean r100) {
            this.is_mobile = r100;
            return this;
        }

        public Builder need_trigger_push(Boolean r100) {
            this.need_trigger_push = r100;
            return this;
        }

        public Builder strategy(CommonEnum.LoadStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class IdFeaturePair extends Message<IdFeaturePair, Builder> {
        public static final ProtoAdapter<IdFeaturePair> ADAPTER = null;
        public static final String DEFAULT_APP_ID = "";
        public static final CommonEnum.OpenAppFeatureType DEFAULT_FEATURE = null;
        private static final long serialVersionUID = 0;
        public final String app_id;
        public final CommonEnum.OpenAppFeatureType feature;

        public static final class Builder extends Message.Builder<IdFeaturePair, Builder> {
            public String app_id;
            public CommonEnum.OpenAppFeatureType feature;

            @Override // com.squareup.wire.Message.Builder
            public IdFeaturePair build() {
                String r100 = this.app_id;
                if (r100 == null) goto L7;
                return new IdFeaturePair(this.app_id, this.feature, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "app_id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder app_id(String r100) {
                this.app_id = r100;
                return this;
            }

            public Builder feature(CommonEnum.OpenAppFeatureType r100) {
                this.feature = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_IdFeaturePair extends ProtoAdapter<IdFeaturePair> {
            public ProtoAdapter_IdFeaturePair() {
                super(FieldEncoding.LENGTH_DELIMITED, IdFeaturePair.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public IdFeaturePair decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.app_id = "";
                r101.feature = CommonEnum.OpenAppFeatureType.MiniApp;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.app_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.feature = CommonEnum.OpenAppFeatureType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(IdFeaturePair r100) {
                int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.app_id);
                CommonEnum.OpenAppFeatureType r102 = r100.feature;
                if (r102 == null) goto L5;
                int r103 = CommonEnum.OpenAppFeatureType.ADAPTER.encodedSizeWithTag(2, r102);
            L7:
                return (r101 + r103) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ IdFeaturePair decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(IdFeaturePair r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, IdFeaturePair r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.app_id);
                CommonEnum.OpenAppFeatureType r102 = r101.feature;
                if (r102 == null) goto L5;
                CommonEnum.OpenAppFeatureType.ADAPTER.encodeWithTag(r100, 2, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, IdFeaturePair r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_IdFeaturePair();
            DEFAULT_FEATURE = CommonEnum.OpenAppFeatureType.MiniApp;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.app_id = this.app_id;
            r100.feature = this.feature;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return IdFeaturePair.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public IdFeaturePair(String r100, CommonEnum.OpenAppFeatureType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public IdFeaturePair(String r100, CommonEnum.OpenAppFeatureType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.app_id = r100;
            this.feature = r101;
        }
    }

    public static final class ProtoAdapter_PullOpenAppBadgeNodesRequest extends ProtoAdapter<PullOpenAppBadgeNodesRequest> implements c<PullOpenAppBadgeNodesRequest> {
        public ProtoAdapter_PullOpenAppBadgeNodesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullOpenAppBadgeNodesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullOpenAppBadgeNodesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_mobile = r102;
            r101.strategy = CommonEnum.LoadStrategy.Local;
            r101.need_trigger_push = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.id_feature_pairs.add(IdFeaturePair.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_mobile = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.strategy = CommonEnum.LoadStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.need_trigger_push = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullOpenAppBadgeNodesRequest r100) {
            int r101 = IdFeaturePair.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.id_feature_pairs);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.is_mobile);
            CommonEnum.LoadStrategy r104 = r100.strategy;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = CommonEnum.LoadStrategy.ADAPTER.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            Boolean r108 = r100.need_trigger_push;
            if (r108 == null) goto L10;
            r105 = r102.encodedSizeWithTag(4, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullOpenAppBadgeNodesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullOpenAppBadgeNodesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullOpenAppBadgeNodesRequest r101) throws IOException {
            IdFeaturePair.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.id_feature_pairs);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 2, r101.is_mobile);
            CommonEnum.LoadStrategy r103 = r101.strategy;
            if (r103 == null) goto L5;
            CommonEnum.LoadStrategy.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            Boolean r104 = r101.need_trigger_push;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullOpenAppBadgeNodesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PullOpenAppBadgeNodesRequest r100 = new ProtoAdapter_PullOpenAppBadgeNodesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_MOBILE = r101;
        DEFAULT_STRATEGY = CommonEnum.LoadStrategy.Local;
        DEFAULT_NEED_TRIGGER_PUSH = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.id_feature_pairs = Internal.copyOf("id_feature_pairs", this.id_feature_pairs);
        r100.is_mobile = this.is_mobile;
        r100.strategy = this.strategy;
        r100.need_trigger_push = this.need_trigger_push;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullOpenAppBadgeNodesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullOpenAppBadgeNodesRequest(List<IdFeaturePair> r100, Boolean r101, CommonEnum.LoadStrategy r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullOpenAppBadgeNodesRequest(List<IdFeaturePair> r100, Boolean r101, CommonEnum.LoadStrategy r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.id_feature_pairs = Internal.immutableCopyOf("id_feature_pairs", r100);
        this.is_mobile = r101;
        this.strategy = r102;
        this.need_trigger_push = r103;
    }
}
