package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CCMGetCopyHTMLToSegmentResponse extends Message<CCMGetCopyHTMLToSegmentResponse, Builder> {
    public static final ProtoAdapter<CCMGetCopyHTMLToSegmentResponse> ADAPTER = null;
    public static final String DEFAULT_HTML = "";
    public static final CCMCopyHtmlType DEFAULT_TYPE = null;
    public static final ProtoAdapter_CCMGetCopyHTMLToSegmentResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String html;
    public final List<SegmentData> segments;
    public final CCMCopyHtmlType type;

    public static final class Builder extends Message.Builder<CCMGetCopyHTMLToSegmentResponse, Builder> implements d<CCMGetCopyHTMLToSegmentResponse> {
        public String html;
        public List<SegmentData> segments;
        public CCMCopyHtmlType type;

        @Override // com.squareup.wire.Message.Builder
        public CCMGetCopyHTMLToSegmentResponse build() {
            return new CCMGetCopyHTMLToSegmentResponse(this.type, this.segments, this.html, super.buildUnknownFields());
        }

        public Builder() {
            this.segments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder html(String r100) {
            this.html = r100;
            return this;
        }

        public Builder segments(List<SegmentData> r100) {
            Internal.checkElementsNotNull(r100);
            this.segments = r100;
            return this;
        }

        public Builder type(CCMCopyHtmlType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMGetCopyHTMLToSegmentResponse extends ProtoAdapter<CCMGetCopyHTMLToSegmentResponse> implements c<CCMGetCopyHTMLToSegmentResponse> {
        public ProtoAdapter_CCMGetCopyHTMLToSegmentResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMGetCopyHTMLToSegmentResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMGetCopyHTMLToSegmentResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = CCMCopyHtmlType.Unknown;
            r101.html = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.type = CCMCopyHtmlType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.segments.add(SegmentData.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.html = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CCMGetCopyHTMLToSegmentResponse r100) {
            CCMCopyHtmlType r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CCMCopyHtmlType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + SegmentData.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.segments);
            String r105 = r100.html;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMGetCopyHTMLToSegmentResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMGetCopyHTMLToSegmentResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMGetCopyHTMLToSegmentResponse r101) throws IOException {
            CCMCopyHtmlType r102 = r101.type;
            if (r102 == null) goto L5;
            CCMCopyHtmlType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            SegmentData.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.segments);
            String r103 = r101.html;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMGetCopyHTMLToSegmentResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMGetCopyHTMLToSegmentResponse r100 = new ProtoAdapter_CCMGetCopyHTMLToSegmentResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = CCMCopyHtmlType.Unknown;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.segments = Internal.copyOf(DBDefinition.SEGMENT_TABLE_NAME, this.segments);
        r100.html = this.html;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMGetCopyHTMLToSegmentResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMGetCopyHTMLToSegmentResponse(CCMCopyHtmlType r100, List<SegmentData> r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CCMGetCopyHTMLToSegmentResponse(CCMCopyHtmlType r100, List<SegmentData> r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.type = r100;
        this.segments = Internal.immutableCopyOf(DBDefinition.SEGMENT_TABLE_NAME, r101);
        this.html = r102;
    }
}
