package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class GeneratedCodeInfo extends com.squareup.wire.Message<GeneratedCodeInfo, Builder> {
    public static final ProtoAdapter<GeneratedCodeInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: annotation, reason: collision with root package name */
    public final List<Annotation> f275927annotation;

    public static final class Annotation extends com.squareup.wire.Message<Annotation, Builder> {
        public static final ProtoAdapter<Annotation> ADAPTER = null;
        public static final Integer DEFAULT_BEGIN = null;
        public static final Integer DEFAULT_END = null;
        public static final String DEFAULT_SOURCE_FILE = "";
        private static final long serialVersionUID = 0;
        public final Integer begin;
        public final Integer end;
        public final List<Integer> path;
        public final String source_file;

        public static final class Builder extends com.squareup.wire.Message.Builder<Annotation, Builder> {
            public Integer begin;
            public Integer end;
            public List<Integer> path;
            public String source_file;

            @Override // com.squareup.wire.Message.Builder
            public Annotation build() {
                return new Annotation(this.path, this.source_file, this.begin, this.end, super.buildUnknownFields());
            }

            public Builder() {
                this.path = com.squareup.wire.internal.Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder begin(Integer r100) {
                this.begin = r100;
                return this;
            }

            public Builder end(Integer r100) {
                this.end = r100;
                return this;
            }

            public Builder path(List<Integer> r100) {
                com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
                this.path = r100;
                return this;
            }

            public Builder source_file(String r100) {
                this.source_file = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Annotation extends ProtoAdapter<Annotation> {
            public ProtoAdapter_Annotation() {
                super(FieldEncoding.LENGTH_DELIMITED, Annotation.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Annotation decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.source_file = "";
                r101.begin = 0;
                r101.end = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.path.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.source_file = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.begin = ProtoAdapter.INT32.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.end = ProtoAdapter.INT32.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Annotation r100) {
                ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
                int r102 = r101.asPacked().encodedSizeWithTag(1, r100.path);
                String r103 = r100.source_file;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                Integer r107 = r100.begin;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(3, r107);
            L10:
                int r109 = r106 + r108;
                Integer r110 = r100.end;
                if (r110 == null) goto L14;
                r104 = r101.encodedSizeWithTag(4, r110);
            L14:
                return (r109 + r104) + r100.unknownFields().size();
            L9:
                r108 = 0;
                goto L10
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Annotation decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Annotation r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Annotation r101) throws IOException {
                ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
                r102.asPacked().encodeWithTag(r100, 1, r101.path);
                String r103 = r101.source_file;
                if (r103 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L5:
                Integer r104 = r101.begin;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 3, r104);
            L8:
                Integer r105 = r101.end;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 4, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Annotation r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Annotation();
            DEFAULT_BEGIN = 0;
            DEFAULT_END = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.path = com.squareup.wire.internal.Internal.copyOf("path", this.path);
            r100.source_file = this.source_file;
            r100.begin = this.begin;
            r100.end = this.end;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Annotation.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Annotation(List<Integer> r100, String r101, Integer r102, Integer r110) {
            this(r100, r101, r102, r110, okio.ByteString.EMPTY);
        }

        public Annotation(List<Integer> r100, String r101, Integer r102, Integer r103, okio.ByteString r104) {
            super(ADAPTER, r104);
            this.path = com.squareup.wire.internal.Internal.immutableCopyOf("path", r100);
            this.source_file = r101;
            this.begin = r102;
            this.end = r103;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<GeneratedCodeInfo, Builder> {

        /* JADX INFO: renamed from: annotation, reason: collision with root package name */
        public List<Annotation> f275928annotation;

        @Override // com.squareup.wire.Message.Builder
        public GeneratedCodeInfo build() {
            return new GeneratedCodeInfo(this.f275928annotation, super.buildUnknownFields());
        }

        public Builder() {
            this.f275928annotation = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder annotation(List<Annotation> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.f275928annotation = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GeneratedCodeInfo extends ProtoAdapter<GeneratedCodeInfo> {
        public ProtoAdapter_GeneratedCodeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, GeneratedCodeInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GeneratedCodeInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.f275928annotation.add(Annotation.ADAPTER.decode(r100));
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
        public int encodedSize2(GeneratedCodeInfo r100) {
            return Annotation.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.f275927annotation) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GeneratedCodeInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GeneratedCodeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GeneratedCodeInfo r101) throws IOException {
            Annotation.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.f275927annotation);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GeneratedCodeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GeneratedCodeInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f275928annotation = com.squareup.wire.internal.Internal.copyOf("annotation", this.f275927annotation);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GeneratedCodeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public GeneratedCodeInfo(List<Annotation> r100) {
        this(r100, okio.ByteString.EMPTY);
    }

    public GeneratedCodeInfo(List<Annotation> r100, okio.ByteString r101) {
        super(ADAPTER, r101);
        this.f275927annotation = com.squareup.wire.internal.Internal.immutableCopyOf("annotation", r100);
    }
}
