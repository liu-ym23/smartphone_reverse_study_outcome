package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FeatureSwitches extends com.squareup.wire.Message<FeatureSwitches, Builder> {
    public static final ProtoAdapter<FeatureSwitches> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Pairs> namespace2pairs;

    public static final class Builder extends com.squareup.wire.Message.Builder<FeatureSwitches, Builder> {
        public Map<String, Pairs> namespace2pairs;

        @Override // com.squareup.wire.Message.Builder
        public FeatureSwitches build() {
            return new FeatureSwitches(this.namespace2pairs, super.buildUnknownFields());
        }

        public Builder() {
            this.namespace2pairs = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder namespace2pairs(Map<String, Pairs> r100) {
            Internal.checkElementsNotNull(r100);
            this.namespace2pairs = r100;
            return this;
        }
    }

    public static final class Pairs extends com.squareup.wire.Message<Pairs, Builder> {
        public static final ProtoAdapter<Pairs> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, String> paris;

        public static final class Builder extends com.squareup.wire.Message.Builder<Pairs, Builder> {
            public Map<String, String> paris;

            @Override // com.squareup.wire.Message.Builder
            public Pairs build() {
                return new Pairs(this.paris, super.buildUnknownFields());
            }

            public Builder() {
                this.paris = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder paris(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.paris = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Pairs extends ProtoAdapter<Pairs> {
            private final ProtoAdapter<Map<String, String>> paris;

            public ProtoAdapter_Pairs() {
                super(FieldEncoding.LENGTH_DELIMITED, Pairs.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.paris = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Pairs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.paris.putAll(this.paris.decode(r100));
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
            public int encodedSize2(Pairs r100) {
                return this.paris.encodedSizeWithTag(1, r100.paris) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Pairs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Pairs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Pairs r101) throws IOException {
                this.paris.encodeWithTag(r100, 1, r101.paris);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Pairs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Pairs();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.paris = Internal.copyOf("paris", this.paris);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Pairs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Pairs(Map<String, String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public Pairs(Map<String, String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.paris = Internal.immutableCopyOf("paris", r100);
        }
    }

    public static final class ProtoAdapter_FeatureSwitches extends ProtoAdapter<FeatureSwitches> {
        private final ProtoAdapter<Map<String, Pairs>> namespace2pairs;

        public ProtoAdapter_FeatureSwitches() {
            super(FieldEncoding.LENGTH_DELIMITED, FeatureSwitches.class);
            this.namespace2pairs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Pairs.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeatureSwitches decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.namespace2pairs.putAll(this.namespace2pairs.decode(r100));
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
        public int encodedSize2(FeatureSwitches r100) {
            return this.namespace2pairs.encodedSizeWithTag(1, r100.namespace2pairs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeatureSwitches decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeatureSwitches r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeatureSwitches r101) throws IOException {
            this.namespace2pairs.encodeWithTag(r100, 1, r101.namespace2pairs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeatureSwitches r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeatureSwitches();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.namespace2pairs = Internal.copyOf("namespace2pairs", this.namespace2pairs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeatureSwitches.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeatureSwitches(Map<String, Pairs> r100) {
        this(r100, ByteString.EMPTY);
    }

    public FeatureSwitches(Map<String, Pairs> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.namespace2pairs = Internal.immutableCopyOf("namespace2pairs", r100);
    }
}
