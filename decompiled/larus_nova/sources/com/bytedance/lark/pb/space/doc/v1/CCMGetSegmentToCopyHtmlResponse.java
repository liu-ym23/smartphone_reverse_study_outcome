package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CCMGetSegmentToCopyHtmlResponse extends Message<CCMGetSegmentToCopyHtmlResponse, Builder> {
    public static final ProtoAdapter<CCMGetSegmentToCopyHtmlResponse> ADAPTER = null;
    public static final String DEFAULT_HTML = "";
    public static final CCMBuildHtmlType DEFAULT_TYPE = null;
    public static final ProtoAdapter_CCMGetSegmentToCopyHtmlResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String html;
    public final CCMBuildHtmlType type;

    public static final class Builder extends Message.Builder<CCMGetSegmentToCopyHtmlResponse, Builder> implements d<CCMGetSegmentToCopyHtmlResponse> {
        public String html;
        public CCMBuildHtmlType type;

        @Override // com.squareup.wire.Message.Builder
        public CCMGetSegmentToCopyHtmlResponse build() {
            return new CCMGetSegmentToCopyHtmlResponse(this.type, this.html, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder html(String r100) {
            this.html = r100;
            return this;
        }

        public Builder type(CCMBuildHtmlType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMGetSegmentToCopyHtmlResponse extends ProtoAdapter<CCMGetSegmentToCopyHtmlResponse> implements c<CCMGetSegmentToCopyHtmlResponse> {
        public ProtoAdapter_CCMGetSegmentToCopyHtmlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMGetSegmentToCopyHtmlResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMGetSegmentToCopyHtmlResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = CCMBuildHtmlType.BaseAndSheet;
            r101.html = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = CCMBuildHtmlType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.html = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CCMGetSegmentToCopyHtmlResponse r100) {
            CCMBuildHtmlType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CCMBuildHtmlType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.html;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMGetSegmentToCopyHtmlResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMGetSegmentToCopyHtmlResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMGetSegmentToCopyHtmlResponse r101) throws IOException {
            CCMBuildHtmlType r102 = r101.type;
            if (r102 == null) goto L5;
            CCMBuildHtmlType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.html;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMGetSegmentToCopyHtmlResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMGetSegmentToCopyHtmlResponse r100 = new ProtoAdapter_CCMGetSegmentToCopyHtmlResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = CCMBuildHtmlType.BaseAndSheet;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.html = this.html;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMGetSegmentToCopyHtmlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMGetSegmentToCopyHtmlResponse(CCMBuildHtmlType r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CCMGetSegmentToCopyHtmlResponse(CCMBuildHtmlType r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.html = r101;
    }
}
