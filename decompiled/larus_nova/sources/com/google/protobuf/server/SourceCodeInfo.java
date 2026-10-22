package com.google.protobuf.server;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes23.dex */
public final class SourceCodeInfo extends Message<SourceCodeInfo, Builder> {
    public static final ProtoAdapter<SourceCodeInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Location> mlocation;

    public static final class Builder extends Message.Builder<SourceCodeInfo, Builder> {
        public List<Location> mlocation;

        @Override // com.squareup.wire.Message.Builder
        public SourceCodeInfo build() {
            return new SourceCodeInfo(this.mlocation, super.buildUnknownFields());
        }

        public Builder() {
            this.mlocation = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder location(List<Location> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlocation = r100;
            return this;
        }
    }

    public static final class Location extends Message<Location, Builder> {
        public static final ProtoAdapter<Location> ADAPTER = null;
        public static final String DEFAULT_LEADING_COMMENTS = "";
        public static final String DEFAULT_TRAILING_COMMENTS = "";
        private static final long serialVersionUID = 0;
        public final String mleading_comments;
        public final List<String> mleading_detached_comments;
        public final List<Integer> mpath;
        public final List<Integer> mspan;
        public final String mtrailing_comments;

        public static final class Builder extends Message.Builder<Location, Builder> {
            public String mleading_comments;
            public List<String> mleading_detached_comments;
            public List<Integer> mpath;
            public List<Integer> mspan;
            public String mtrailing_comments;

            @Override // com.squareup.wire.Message.Builder
            public Location build() {
                return new Location(this.mpath, this.mspan, this.mleading_comments, this.mtrailing_comments, this.mleading_detached_comments, super.buildUnknownFields());
            }

            public Builder() {
                this.mpath = Internal.newMutableList();
                this.mspan = Internal.newMutableList();
                this.mleading_detached_comments = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder leading_comments(String r100) {
                this.mleading_comments = r100;
                return this;
            }

            public Builder leading_detached_comments(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mleading_detached_comments = r100;
                return this;
            }

            public Builder path(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.mpath = r100;
                return this;
            }

            public Builder span(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.mspan = r100;
                return this;
            }

            public Builder trailing_comments(String r100) {
                this.mtrailing_comments = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Location extends ProtoAdapter<Location> {
            public ProtoAdapter_Location() {
                super(FieldEncoding.LENGTH_DELIMITED, Location.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Location decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mleading_comments = "";
                r101.mtrailing_comments = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.mpath.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mspan.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mleading_comments = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L14;
                r101.mtrailing_comments = ProtoAdapter.STRING.decode(r100);
                goto L3
            L14:
                if (r103 != 6) goto L15;
                r101.mleading_detached_comments.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L15:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Location r100) {
                ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
                int r102 = r101.asPacked().encodedSizeWithTag(1, r100.mpath) + r101.asPacked().encodedSizeWithTag(2, r100.mspan);
                String r103 = r100.mleading_comments;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(3, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.mtrailing_comments;
                if (r107 == null) goto L10;
                r104 = ProtoAdapter.STRING.encodedSizeWithTag(4, r107);
            L10:
                return ((r106 + r104) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(6, r100.mleading_detached_comments)) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Location decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Location r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Location r101) throws IOException {
                ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
                r102.asPacked().encodeWithTag(r100, 1, r101.mpath);
                r102.asPacked().encodeWithTag(r100, 2, r101.mspan);
                String r103 = r101.mleading_comments;
                if (r103 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
            L5:
                String r104 = r101.mtrailing_comments;
                if (r104 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
            L8:
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 6, r101.mleading_detached_comments);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Location r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Location();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mpath = Internal.copyOf("mpath", this.mpath);
            r100.mspan = Internal.copyOf("mspan", this.mspan);
            r100.mleading_comments = this.mleading_comments;
            r100.mtrailing_comments = this.mtrailing_comments;
            r100.mleading_detached_comments = Internal.copyOf("mleading_detached_comments", this.mleading_detached_comments);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Location.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Location(List<Integer> r100, List<Integer> r101, String r110, String r111, List<String> r112) {
            this(r100, r101, r110, r111, r112, ByteString.EMPTY);
        }

        public Location(List<Integer> r100, List<Integer> r101, String r102, String r103, List<String> r104, ByteString r105) {
            super(ADAPTER, r105);
            this.mpath = Internal.immutableCopyOf("mpath", r100);
            this.mspan = Internal.immutableCopyOf("mspan", r101);
            this.mleading_comments = r102;
            this.mtrailing_comments = r103;
            this.mleading_detached_comments = Internal.immutableCopyOf("mleading_detached_comments", r104);
        }
    }

    public static final class ProtoAdapter_SourceCodeInfo extends ProtoAdapter<SourceCodeInfo> {
        public ProtoAdapter_SourceCodeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SourceCodeInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SourceCodeInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mlocation.add(Location.ADAPTER.decode(r100));
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
        public int encodedSize2(SourceCodeInfo r100) {
            return Location.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mlocation) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SourceCodeInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SourceCodeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SourceCodeInfo r101) throws IOException {
            Location.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mlocation);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SourceCodeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SourceCodeInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlocation = Internal.copyOf("mlocation", this.mlocation);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SourceCodeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SourceCodeInfo(List<Location> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SourceCodeInfo(List<Location> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mlocation = Internal.immutableCopyOf("mlocation", r100);
    }
}
