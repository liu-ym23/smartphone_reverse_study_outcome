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
public final class CCMGetSegmentToCopyHtmlRequest extends Message<CCMGetSegmentToCopyHtmlRequest, Builder> {
    public static final ProtoAdapter<CCMGetSegmentToCopyHtmlRequest> ADAPTER = null;
    public static final CCMBuildHtmlType DEFAULT_TYPE = null;
    public static final ProtoAdapter_CCMGetSegmentToCopyHtmlRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<SegmentData> segments;
    public final CCMBuildHtmlType type;

    public static final class Builder extends Message.Builder<CCMGetSegmentToCopyHtmlRequest, Builder> implements d<CCMGetSegmentToCopyHtmlRequest> {
        public List<SegmentData> segments;
        public CCMBuildHtmlType type;

        @Override // com.squareup.wire.Message.Builder
        public CCMGetSegmentToCopyHtmlRequest build() {
            return new CCMGetSegmentToCopyHtmlRequest(this.type, this.segments, super.buildUnknownFields());
        }

        public Builder() {
            this.segments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder segments(List<SegmentData> r100) {
            Internal.checkElementsNotNull(r100);
            this.segments = r100;
            return this;
        }

        public Builder type(CCMBuildHtmlType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMGetSegmentToCopyHtmlRequest extends ProtoAdapter<CCMGetSegmentToCopyHtmlRequest> implements c<CCMGetSegmentToCopyHtmlRequest> {
        public ProtoAdapter_CCMGetSegmentToCopyHtmlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMGetSegmentToCopyHtmlRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMGetSegmentToCopyHtmlRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = CCMBuildHtmlType.BaseAndSheet;
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
            r101.segments.add(SegmentData.ADAPTER.decode(r100));
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
        public int encodedSize2(CCMGetSegmentToCopyHtmlRequest r100) {
            CCMBuildHtmlType r101 = r100.type;
            if (r101 == null) goto L5;
            int r102 = CCMBuildHtmlType.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + SegmentData.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.segments)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMGetSegmentToCopyHtmlRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMGetSegmentToCopyHtmlRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMGetSegmentToCopyHtmlRequest r101) throws IOException {
            CCMBuildHtmlType r102 = r101.type;
            if (r102 == null) goto L5;
            CCMBuildHtmlType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            SegmentData.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.segments);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMGetSegmentToCopyHtmlRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMGetSegmentToCopyHtmlRequest r100 = new ProtoAdapter_CCMGetSegmentToCopyHtmlRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TYPE = CCMBuildHtmlType.BaseAndSheet;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.segments = Internal.copyOf(DBDefinition.SEGMENT_TABLE_NAME, this.segments);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMGetSegmentToCopyHtmlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMGetSegmentToCopyHtmlRequest(CCMBuildHtmlType r100, List<SegmentData> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CCMGetSegmentToCopyHtmlRequest(CCMBuildHtmlType r100, List<SegmentData> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.segments = Internal.immutableCopyOf(DBDefinition.SEGMENT_TABLE_NAME, r101);
    }
}
