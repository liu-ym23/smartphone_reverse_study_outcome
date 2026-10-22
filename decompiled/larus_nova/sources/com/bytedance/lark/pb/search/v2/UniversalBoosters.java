package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UniversalBoosters extends Message<UniversalBoosters, Builder> {
    public static final ProtoAdapter<UniversalBoosters> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class BaikeCardBooster extends Message<BaikeCardBooster, Builder> {
        public static final ProtoAdapter<BaikeCardBooster> ADAPTER = null;
        public static final String DEFAULT_SELECTED_ENTITY_ID = "";
        private static final long serialVersionUID = 0;
        public final String selected_entity_id;

        public static final class Builder extends Message.Builder<BaikeCardBooster, Builder> {
            public String selected_entity_id;

            @Override // com.squareup.wire.Message.Builder
            public BaikeCardBooster build() {
                return new BaikeCardBooster(this.selected_entity_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder selected_entity_id(String r100) {
                this.selected_entity_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_BaikeCardBooster extends ProtoAdapter<BaikeCardBooster> {
            public ProtoAdapter_BaikeCardBooster() {
                super(FieldEncoding.LENGTH_DELIMITED, BaikeCardBooster.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public BaikeCardBooster decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.selected_entity_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.selected_entity_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(BaikeCardBooster r100) {
                String r101 = r100.selected_entity_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ BaikeCardBooster decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(BaikeCardBooster r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, BaikeCardBooster r101) throws IOException {
                String r102 = r101.selected_entity_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BaikeCardBooster r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BaikeCardBooster();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.selected_entity_id = this.selected_entity_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return BaikeCardBooster.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public BaikeCardBooster(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public BaikeCardBooster(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.selected_entity_id = r100;
        }
    }

    public static final class Builder extends Message.Builder<UniversalBoosters, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public UniversalBoosters build() {
            return new UniversalBoosters(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ProtoAdapter_UniversalBoosters extends ProtoAdapter<UniversalBoosters> {
        public ProtoAdapter_UniversalBoosters() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalBoosters.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UniversalBoosters decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UniversalBoosters r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniversalBoosters decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniversalBoosters r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniversalBoosters r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniversalBoosters r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalBoosters();
    }

    public UniversalBoosters() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniversalBoosters.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniversalBoosters(ByteString r100) {
        super(ADAPTER, r100);
    }
}
