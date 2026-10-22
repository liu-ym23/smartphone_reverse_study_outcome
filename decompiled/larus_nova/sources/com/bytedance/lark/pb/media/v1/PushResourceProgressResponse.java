package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.download.api.config.HttpMethod;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushResourceProgressResponse extends Message<PushResourceProgressResponse, Builder> {
    public static final ProtoAdapter<PushResourceProgressResponse> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Link DEFAULT_LINK = null;
    public static final Integer DEFAULT_PROGRESS = null;
    public static final Long DEFAULT_TOTAL_SIZE = null;
    public static final Long DEFAULT_TRANSFERRED_SIZE = null;
    public static final ProtoAdapter_PushResourceProgressResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String key;
    public final Link link;
    public final Integer progress;
    public final Long total_size;
    public final Long transferred_size;

    public static final class Builder extends Message.Builder<PushResourceProgressResponse, Builder> implements d<PushResourceProgressResponse> {
        public String key;
        public Link link;
        public Integer progress;
        public Long total_size;
        public Long transferred_size;

        @Override // com.squareup.wire.Message.Builder
        public PushResourceProgressResponse build() {
            String r100 = this.key;
            if (r100 == null) goto L11;
            if (this.progress == null) goto L11;
            if (this.link == null) goto L11;
            return new PushResourceProgressResponse(this.key, this.progress, this.link, this.total_size, this.transferred_size, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.progress, "progress", this.link, "link"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder link(Link r100) {
            this.link = r100;
            return this;
        }

        public Builder progress(Integer r100) {
            this.progress = r100;
            return this;
        }

        public Builder total_size(Long r100) {
            this.total_size = r100;
            return this;
        }

        public Builder transferred_size(Long r100) {
            this.transferred_size = r100;
            return this;
        }
    }

    public static final enum Link extends Enum<Link> implements WireEnum {
        private static final /* synthetic */ Link[] $VALUES = null;
        public static final ProtoAdapter<Link> ADAPTER = null;
        public static final Link DOWNLOAD = null;
        public static final Link UPLOAD = null;
        private final int value;

        static {
            Link r100 = new Link("UPLOAD", 0, 1);
            UPLOAD = r100;
            Link r101 = new Link(HttpMethod.DOWNLOAD, 1, 2);
            DOWNLOAD = r101;
            $VALUES = new Link[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Link.class);
        }

        public static Link[] values() {
            return (Link[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Link fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return DOWNLOAD;
        L11:
            return UPLOAD;
        }

        public static Link valueOf(String r100) {
            return (Link) a.a(Link.class, r100);
        }

        private Link(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_PushResourceProgressResponse extends ProtoAdapter<PushResourceProgressResponse> implements c<PushResourceProgressResponse> {
        public ProtoAdapter_PushResourceProgressResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PushResourceProgressResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushResourceProgressResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.progress = 0;
            r101.link = Link.UPLOAD;
            r101.total_size = 0L;
            r101.transferred_size = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.progress = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.link = Link.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.total_size = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.transferred_size = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushResourceProgressResponse r100) {
            int r101 = (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + ProtoAdapter.UINT32.encodedSizeWithTag(2, r100.progress)) + Link.ADAPTER.encodedSizeWithTag(3, r100.link);
            Long r102 = r100.total_size;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.UINT64.encodedSizeWithTag(4, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.transferred_size;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.UINT64.encodedSizeWithTag(5, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushResourceProgressResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushResourceProgressResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushResourceProgressResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
            ProtoAdapter.UINT32.encodeWithTag(r100, 2, r101.progress);
            Link.ADAPTER.encodeWithTag(r100, 3, r101.link);
            Long r102 = r101.total_size;
            if (r102 == null) goto L5;
            ProtoAdapter.UINT64.encodeWithTag(r100, 4, r102);
        L5:
            Long r103 = r101.transferred_size;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT64.encodeWithTag(r100, 5, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushResourceProgressResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushResourceProgressResponse r100 = new ProtoAdapter_PushResourceProgressResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PROGRESS = 0;
        DEFAULT_LINK = Link.UPLOAD;
        DEFAULT_TOTAL_SIZE = 0L;
        DEFAULT_TRANSFERRED_SIZE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.progress = this.progress;
        r100.link = this.link;
        r100.total_size = this.total_size;
        r100.transferred_size = this.transferred_size;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushResourceProgressResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushResourceProgressResponse(String r100, Integer r101, Link r110, Long r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PushResourceProgressResponse(String r100, Integer r101, Link r102, Long r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.key = r100;
        this.progress = r101;
        this.link = r102;
        this.total_size = r103;
        this.transferred_size = r104;
    }
}
