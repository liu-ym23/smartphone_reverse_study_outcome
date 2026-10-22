package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class OpenSearchFilter extends Message<OpenSearchFilter, Builder> {
    public static final ProtoAdapter<OpenSearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<OpenSearchFilter, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public OpenSearchFilter build() {
            return new OpenSearchFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class OpenSearchSortFilter extends Message<OpenSearchSortFilter, Builder> {
        public static final ProtoAdapter<OpenSearchSortFilter> ADAPTER = null;
        public static final String DEFAULT_CHECKED_ID = "";
        public static final String DEFAULT_CUSTOM_FILTER_ID = "";
        private static final long serialVersionUID = 0;
        public final String mchecked_id;
        public final String mcustom_filter_id;

        public static final class Builder extends Message.Builder<OpenSearchSortFilter, Builder> {
            public String mchecked_id;
            public String mcustom_filter_id;

            @Override // com.squareup.wire.Message.Builder
            public OpenSearchSortFilter build() {
                return new OpenSearchSortFilter(this.mcustom_filter_id, this.mchecked_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder checked_id(String r100) {
                this.mchecked_id = r100;
                return this;
            }

            public Builder custom_filter_id(String r100) {
                this.mcustom_filter_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenSearchSortFilter extends ProtoAdapter<OpenSearchSortFilter> {
            public ProtoAdapter_OpenSearchSortFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenSearchSortFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OpenSearchSortFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mcustom_filter_id = "";
                r101.mchecked_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mcustom_filter_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mchecked_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(OpenSearchSortFilter r100) {
                String r101 = r100.mcustom_filter_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mchecked_id;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OpenSearchSortFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OpenSearchSortFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OpenSearchSortFilter r101) throws IOException {
                String r102 = r101.mcustom_filter_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mchecked_id;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenSearchSortFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenSearchSortFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mcustom_filter_id = this.mcustom_filter_id;
            r100.mchecked_id = this.mchecked_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OpenSearchSortFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OpenSearchSortFilter(String r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public OpenSearchSortFilter(String r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mcustom_filter_id = r100;
            this.mchecked_id = r101;
        }
    }

    public static final class ProtoAdapter_OpenSearchFilter extends ProtoAdapter<OpenSearchFilter> {
        public ProtoAdapter_OpenSearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenSearchFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OpenSearchFilter decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(OpenSearchFilter r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OpenSearchFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OpenSearchFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OpenSearchFilter r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OpenSearchFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenSearchFilter();
    }

    public OpenSearchFilter() {
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
        return OpenSearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OpenSearchFilter(ByteString r100) {
        super(ADAPTER, r100);
    }
}
