package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PageParam extends Message<PageParam, Builder> {
    public static final ProtoAdapter<PageParam> ADAPTER = null;
    public static final Integer DEFAULT_PAGE_COUNT = null;
    public static final String DEFAULT_PAGE_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Integer page_count;
    public final String page_token;

    public static final class Builder extends Message.Builder<PageParam, Builder> {
        public Integer page_count;
        public String page_token;

        @Override // com.squareup.wire.Message.Builder
        public PageParam build() {
            return new PageParam(this.page_token, this.page_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder page_count(Integer r100) {
            this.page_count = r100;
            return this;
        }

        public Builder page_token(String r100) {
            this.page_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PageParam extends ProtoAdapter<PageParam> {
        public ProtoAdapter_PageParam() {
            super(FieldEncoding.LENGTH_DELIMITED, PageParam.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PageParam decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.page_token = "";
            r101.page_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.page_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.page_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(PageParam r100) {
            String r101 = r100.page_token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.page_count;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PageParam decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PageParam r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PageParam r101) throws IOException {
            String r102 = r101.page_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.page_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PageParam r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PageParam();
        DEFAULT_PAGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.page_token = this.page_token;
        r100.page_count = this.page_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PageParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PageParam(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PageParam(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.page_token = r100;
        this.page_count = r101;
    }
}
