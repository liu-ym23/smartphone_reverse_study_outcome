package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EngineEntity extends com.squareup.wire.Message<EngineEntity, Builder> {
    public static final ProtoAdapter<EngineEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DefaultEntity default_entity;
    public final UniversalCardEntity universal_card_entity;

    public static final class Builder extends com.squareup.wire.Message.Builder<EngineEntity, Builder> {
        public DefaultEntity default_entity;
        public UniversalCardEntity universal_card_entity;

        @Override // com.squareup.wire.Message.Builder
        public EngineEntity build() {
            return new EngineEntity(this.universal_card_entity, this.default_entity, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder default_entity(DefaultEntity r100) {
            this.default_entity = r100;
            this.universal_card_entity = null;
            return this;
        }

        public Builder universal_card_entity(UniversalCardEntity r100) {
            this.universal_card_entity = r100;
            this.default_entity = null;
            return this;
        }
    }

    public static final class DefaultEntity extends com.squareup.wire.Message<DefaultEntity, Builder> {
        public static final ProtoAdapter<DefaultEntity> ADAPTER = null;
        public static final ByteString DEFAULT_BODY = null;
        private static final long serialVersionUID = 0;
        public final ByteString body;

        public static final class Builder extends com.squareup.wire.Message.Builder<DefaultEntity, Builder> {
            public ByteString body;

            @Override // com.squareup.wire.Message.Builder
            public DefaultEntity build() {
                return new DefaultEntity(this.body, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder body(ByteString r100) {
                this.body = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DefaultEntity extends ProtoAdapter<DefaultEntity> {
            public ProtoAdapter_DefaultEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, DefaultEntity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DefaultEntity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.body = ByteString.EMPTY;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.body = ProtoAdapter.BYTES.decode(r100);
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
            public int encodedSize2(DefaultEntity r100) {
                ByteString r101 = r100.body;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DefaultEntity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DefaultEntity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DefaultEntity r101) throws IOException {
                ByteString r102 = r101.body;
                if (r102 == null) goto L5;
                ProtoAdapter.BYTES.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DefaultEntity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DefaultEntity();
            DEFAULT_BODY = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.body = this.body;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DefaultEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public DefaultEntity(ByteString r100) {
            this(r100, ByteString.EMPTY);
        }

        public DefaultEntity(ByteString r100, ByteString r101) {
            super(ADAPTER, r101);
            this.body = r100;
        }
    }

    public static final class ProtoAdapter_EngineEntity extends ProtoAdapter<EngineEntity> {
        public ProtoAdapter_EngineEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, EngineEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EngineEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.universal_card_entity(UniversalCardEntity.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 1000) goto L9;
            r101.default_entity(DefaultEntity.ADAPTER.decode(r100));
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
        public int encodedSize2(EngineEntity r100) {
            UniversalCardEntity r101 = r100.universal_card_entity;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = UniversalCardEntity.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DefaultEntity r104 = r100.default_entity;
            if (r104 == null) goto L10;
            r102 = DefaultEntity.ADAPTER.encodedSizeWithTag(1000, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EngineEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EngineEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EngineEntity r101) throws IOException {
            UniversalCardEntity r102 = r101.universal_card_entity;
            if (r102 == null) goto L5;
            UniversalCardEntity.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DefaultEntity r103 = r101.default_entity;
            if (r103 == null) goto L8;
            DefaultEntity.ADAPTER.encodeWithTag(r100, 1000, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EngineEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EngineEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.universal_card_entity = this.universal_card_entity;
        r100.default_entity = this.default_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EngineEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EngineEntity(UniversalCardEntity r100, DefaultEntity r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public EngineEntity(UniversalCardEntity r100, DefaultEntity r101, ByteString r102) {
        super(ADAPTER, r102);
        if (Internal.countNonNull(r100, r101) > 1) goto L7;
        this.universal_card_entity = r100;
        this.default_entity = r101;
        return;
    L7:
        throw new IllegalArgumentException("at most one of universal_card_entity, default_entity may be non-null");
    }
}
