package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Archive extends Message<Archive, Builder> {
    public static final ProtoAdapter<Archive> ADAPTER = null;
    public static final String DEFAULT_CHECKSUM = "";
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MIME = "";
    public static final Long DEFAULT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final String checksum;
    public final String key;
    public final String mime;
    public final Map<String, String> params;
    public final Long size;
    public final List<String> urls;

    public static final class Builder extends Message.Builder<Archive, Builder> {
        public String checksum;
        public String key;
        public String mime;
        public Map<String, String> params;
        public Long size;
        public List<String> urls;

        @Override // com.squareup.wire.Message.Builder
        public Archive build() {
            return new Archive(this.key, this.urls, this.size, this.checksum, this.mime, this.params, super.buildUnknownFields());
        }

        public Builder() {
            this.urls = Internal.newMutableList();
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder checksum(String r100) {
            this.checksum = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder mime(String r100) {
            this.mime = r100;
            return this;
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }

        public Builder size(Long r100) {
            this.size = r100;
            return this;
        }

        public Builder urls(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.urls = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Archive extends ProtoAdapter<Archive> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_Archive() {
            super(FieldEncoding.LENGTH_DELIMITED, Archive.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Archive decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.size = 0L;
            r101.checksum = "";
            r101.mime = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.params.putAll(this.params.decode(r100));
            goto L3
        L8:
            r101.mime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.checksum = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.size = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.urls.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Archive r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = r103 + r104.asRepeated().encodedSizeWithTag(2, r100.urls);
            Long r106 = r100.size;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.INT64.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            String r109 = r100.checksum;
            if (r109 == null) goto L13;
            int r110 = r104.encodedSizeWithTag(4, r109);
        L14:
            int r111 = r108 + r110;
            String r112 = r100.mime;
            if (r112 == null) goto L18;
            r102 = r104.encodedSizeWithTag(5, r112);
        L18:
            return ((r111 + r102) + this.params.encodedSizeWithTag(6, r100.params)) + r100.unknownFields().size();
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Archive decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Archive r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Archive r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 2, r101.urls);
            Long r104 = r101.size;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.checksum;
            if (r105 == null) goto L11;
            r103.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.mime;
            if (r106 == null) goto L14;
            r103.encodeWithTag(r100, 5, r106);
        L14:
            this.params.encodeWithTag(r100, 6, r101.params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Archive r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Archive();
        DEFAULT_SIZE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.urls = Internal.copyOf("urls", this.urls);
        r100.size = this.size;
        r100.checksum = this.checksum;
        r100.mime = this.mime;
        r100.params = Internal.copyOf("params", this.params);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Archive.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Archive(String r100, List<String> r110, Long r111, String r112, String r113, Map<String, String> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public Archive(String r100, List<String> r101, Long r102, String r103, String r104, Map<String, String> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.key = r100;
        this.urls = Internal.immutableCopyOf("urls", r101);
        this.size = r102;
        this.checksum = r103;
        this.mime = r104;
        this.params = Internal.immutableCopyOf("params", r105);
    }
}
