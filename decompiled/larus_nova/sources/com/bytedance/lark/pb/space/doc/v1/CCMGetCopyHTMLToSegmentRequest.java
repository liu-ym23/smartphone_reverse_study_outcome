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
public final class CCMGetCopyHTMLToSegmentRequest extends Message<CCMGetCopyHTMLToSegmentRequest, Builder> {
    public static final ProtoAdapter<CCMGetCopyHTMLToSegmentRequest> ADAPTER = null;
    public static final String DEFAULT_HTML = "";
    public static final CCMCopyHtmlType DEFAULT_TYPE = null;
    public static final ProtoAdapter_CCMGetCopyHTMLToSegmentRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String html;
    public final CCMCopyHtmlType type;

    public static final class Builder extends Message.Builder<CCMGetCopyHTMLToSegmentRequest, Builder> implements d<CCMGetCopyHTMLToSegmentRequest> {
        public String html;
        public CCMCopyHtmlType type;

        @Override // com.squareup.wire.Message.Builder
        public CCMGetCopyHTMLToSegmentRequest build() {
            return new CCMGetCopyHTMLToSegmentRequest(this.type, this.html, super.buildUnknownFields());
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

        public Builder type(CCMCopyHtmlType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMGetCopyHTMLToSegmentRequest extends ProtoAdapter<CCMGetCopyHTMLToSegmentRequest> implements c<CCMGetCopyHTMLToSegmentRequest> {
        public ProtoAdapter_CCMGetCopyHTMLToSegmentRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMGetCopyHTMLToSegmentRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMGetCopyHTMLToSegmentRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = CCMCopyHtmlType.Unknown;
            r101.html = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = CCMCopyHtmlType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
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
        public int encodedSize2(CCMGetCopyHTMLToSegmentRequest r100) {
            CCMCopyHtmlType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CCMCopyHtmlType.ADAPTER.encodedSizeWithTag(1, r101);
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
        public /* bridge */ /* synthetic */ CCMGetCopyHTMLToSegmentRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMGetCopyHTMLToSegmentRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMGetCopyHTMLToSegmentRequest r101) throws IOException {
            CCMCopyHtmlType r102 = r101.type;
            if (r102 == null) goto L5;
            CCMCopyHtmlType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.html;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMGetCopyHTMLToSegmentRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMGetCopyHTMLToSegmentRequest r100 = new ProtoAdapter_CCMGetCopyHTMLToSegmentRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = CCMCopyHtmlType.Unknown;
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
        return CCMGetCopyHTMLToSegmentRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMGetCopyHTMLToSegmentRequest(CCMCopyHtmlType r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CCMGetCopyHTMLToSegmentRequest(CCMCopyHtmlType r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.html = r101;
    }
}
