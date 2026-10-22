package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PageResult extends Message<PageResult, Builder> {
    public static final ProtoAdapter<PageResult> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_LAST_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Boolean has_more;
    public final String last_token;

    public static final class Builder extends Message.Builder<PageResult, Builder> {
        public Boolean has_more;
        public String last_token;

        @Override // com.squareup.wire.Message.Builder
        public PageResult build() {
            Boolean r100 = this.has_more;
            if (r100 == null) goto L7;
            return new PageResult(this.has_more, this.last_token, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "has_more"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder last_token(String r100) {
            this.last_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PageResult extends ProtoAdapter<PageResult> {
        public ProtoAdapter_PageResult() {
            super(FieldEncoding.LENGTH_DELIMITED, PageResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PageResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            r101.last_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.last_token = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PageResult r100) {
            int r101 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.has_more);
            String r102 = r100.last_token;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PageResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PageResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PageResult r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.has_more);
            String r102 = r101.last_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PageResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PageResult();
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.has_more = this.has_more;
        r100.last_token = this.last_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PageResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PageResult(Boolean r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PageResult(Boolean r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.has_more = r100;
        this.last_token = r101;
    }
}
