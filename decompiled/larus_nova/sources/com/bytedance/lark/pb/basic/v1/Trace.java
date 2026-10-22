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
public final class Trace extends com.squareup.wire.Message<Trace, Builder> {
    public static final ProtoAdapter<Trace> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Span> spans;

    public static final class Builder extends com.squareup.wire.Message.Builder<Trace, Builder> {
        public List<Span> spans;

        @Override // com.squareup.wire.Message.Builder
        public Trace build() {
            return new Trace(this.spans, super.buildUnknownFields());
        }

        public Builder() {
            this.spans = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder spans(List<Span> r100) {
            Internal.checkElementsNotNull(r100);
            this.spans = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Trace extends ProtoAdapter<Trace> {
        public ProtoAdapter_Trace() {
            super(FieldEncoding.LENGTH_DELIMITED, Trace.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Trace decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.spans.add(Span.ADAPTER.decode(r100));
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
        public int encodedSize2(Trace r100) {
            return Span.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.spans) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Trace decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Trace r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Trace r101) throws IOException {
            Span.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.spans);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Trace r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Span extends com.squareup.wire.Message<Span, Builder> {
        public static final ProtoAdapter<Span> ADAPTER = null;
        public static final Long DEFAULT_DURATION_MILLIS = null;
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final Map<String, String> attributes;
        public final Long duration_millis;
        public final String name;

        public static final class Builder extends com.squareup.wire.Message.Builder<Span, Builder> {
            public Map<String, String> attributes;
            public Long duration_millis;
            public String name;

            @Override // com.squareup.wire.Message.Builder
            public Span build() {
                return new Span(this.name, this.duration_millis, this.attributes, super.buildUnknownFields());
            }

            public Builder() {
                this.attributes = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder attributes(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.attributes = r100;
                return this;
            }

            public Builder duration_millis(Long r100) {
                this.duration_millis = r100;
                return this;
            }

            public Builder name(String r100) {
                this.name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Span extends ProtoAdapter<Span> {
            private final ProtoAdapter<Map<String, String>> attributes;

            public ProtoAdapter_Span() {
                super(FieldEncoding.LENGTH_DELIMITED, Span.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.attributes = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Span decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.name = "";
                r101.duration_millis = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.duration_millis = ProtoAdapter.UINT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.attributes.putAll(this.attributes.decode(r100));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Span r100) {
                String r101 = r100.name;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.duration_millis;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.UINT64.encodedSizeWithTag(2, r104);
            L10:
                return ((r103 + r102) + this.attributes.encodedSizeWithTag(3, r100.attributes)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Span decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Span r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Span r101) throws IOException {
                String r102 = r101.name;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.duration_millis;
                if (r103 == null) goto L8;
                ProtoAdapter.UINT64.encodeWithTag(r100, 2, r103);
            L8:
                this.attributes.encodeWithTag(r100, 3, r101.attributes);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Span r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Span();
            DEFAULT_DURATION_MILLIS = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.name = this.name;
            r100.duration_millis = this.duration_millis;
            r100.attributes = Internal.copyOf("attributes", this.attributes);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Span.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Span(String r100, Long r101, Map<String, String> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Span(String r100, Long r101, Map<String, String> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.name = r100;
            this.duration_millis = r101;
            this.attributes = Internal.immutableCopyOf("attributes", r102);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Trace();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.spans = Internal.copyOf("spans", this.spans);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Trace.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Trace(List<Span> r100) {
        this(r100, ByteString.EMPTY);
    }

    public Trace(List<Span> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.spans = Internal.immutableCopyOf("spans", r100);
    }
}
