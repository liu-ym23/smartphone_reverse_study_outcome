package com.bytedance.lark.pb.openplatform.v1;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
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
public final class UniversalCardEntityAddedNotify extends Message<UniversalCardEntityAddedNotify, Builder> {
    public static final ProtoAdapter<UniversalCardEntityAddedNotify> ADAPTER = null;
    public static final ProtoAdapter_UniversalCardEntityAddedNotify RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UniversalCardEntityInfo> universal_card_entity_infos;

    public static final class Builder extends Message.Builder<UniversalCardEntityAddedNotify, Builder> implements d<UniversalCardEntityAddedNotify> {
        public List<UniversalCardEntityInfo> universal_card_entity_infos;

        @Override // com.squareup.wire.Message.Builder
        public UniversalCardEntityAddedNotify build() {
            return new UniversalCardEntityAddedNotify(this.universal_card_entity_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.universal_card_entity_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder universal_card_entity_infos(List<UniversalCardEntityInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.universal_card_entity_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UniversalCardEntityAddedNotify extends ProtoAdapter<UniversalCardEntityAddedNotify> implements c<UniversalCardEntityAddedNotify> {
        public ProtoAdapter_UniversalCardEntityAddedNotify() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalCardEntityAddedNotify.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalCardEntityAddedNotify decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.universal_card_entity_infos.add(UniversalCardEntityInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(UniversalCardEntityAddedNotify r100) {
            return UniversalCardEntityInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.universal_card_entity_infos) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalCardEntityAddedNotify decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalCardEntityAddedNotify r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalCardEntityAddedNotify r101) throws IOException {
            UniversalCardEntityInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.universal_card_entity_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalCardEntityAddedNotify r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class UniversalCardEntityInfo extends Message<UniversalCardEntityInfo, Builder> {
        public static final ProtoAdapter<UniversalCardEntityInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final UniversalCardBizParam biz_param;
        public final UniversalCardEntity entity;

        public static final class Builder extends Message.Builder<UniversalCardEntityInfo, Builder> {
            public UniversalCardBizParam biz_param;
            public UniversalCardEntity entity;

            @Override // com.squareup.wire.Message.Builder
            public UniversalCardEntityInfo build() {
                UniversalCardEntity r100 = this.entity;
                if (r100 == null) goto L7;
                return new UniversalCardEntityInfo(this.biz_param, this.entity, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "entity"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder biz_param(UniversalCardBizParam r100) {
                this.biz_param = r100;
                return this;
            }

            public Builder entity(UniversalCardEntity r100) {
                this.entity = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UniversalCardEntityInfo extends ProtoAdapter<UniversalCardEntityInfo> {
            public ProtoAdapter_UniversalCardEntityInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, UniversalCardEntityInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UniversalCardEntityInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.biz_param = UniversalCardBizParam.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.entity = UniversalCardEntity.ADAPTER.decode(r100);
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
            public int encodedSize2(UniversalCardEntityInfo r100) {
                UniversalCardBizParam r101 = r100.biz_param;
                if (r101 == null) goto L5;
                int r102 = UniversalCardBizParam.ADAPTER.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + UniversalCardEntity.ADAPTER.encodedSizeWithTag(2, r100.entity)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UniversalCardEntityInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UniversalCardEntityInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UniversalCardEntityInfo r101) throws IOException {
                UniversalCardBizParam r102 = r101.biz_param;
                if (r102 == null) goto L5;
                UniversalCardBizParam.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                UniversalCardEntity.ADAPTER.encodeWithTag(r100, 2, r101.entity);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalCardEntityInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UniversalCardEntityInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.biz_param = this.biz_param;
            r100.entity = this.entity;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UniversalCardEntityInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UniversalCardEntityInfo(UniversalCardBizParam r100, UniversalCardEntity r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public UniversalCardEntityInfo(UniversalCardBizParam r100, UniversalCardEntity r101, ByteString r102) {
            super(ADAPTER, r102);
            this.biz_param = r100;
            this.entity = r101;
        }
    }

    static {
        ProtoAdapter_UniversalCardEntityAddedNotify r100 = new ProtoAdapter_UniversalCardEntityAddedNotify();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.universal_card_entity_infos = Internal.copyOf("universal_card_entity_infos", this.universal_card_entity_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalCardEntityAddedNotify.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalCardEntityAddedNotify(List<UniversalCardEntityInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public UniversalCardEntityAddedNotify(List<UniversalCardEntityInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.universal_card_entity_infos = Internal.immutableCopyOf("universal_card_entity_infos", r100);
    }
}
