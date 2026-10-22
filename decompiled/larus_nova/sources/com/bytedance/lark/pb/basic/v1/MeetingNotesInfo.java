package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MeetingNotesInfo extends com.squareup.wire.Message<MeetingNotesInfo, Builder> {
    public static final ProtoAdapter<MeetingNotesInfo> ADAPTER = null;
    public static final String DEFAULT_DOCURL = "";
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final Doc.Type DEFAULT_DOC_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String docUrl;
    public final String doc_token;
    public final Doc.Type doc_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<MeetingNotesInfo, Builder> {
        public String docUrl;
        public String doc_token;
        public Doc.Type doc_type;

        @Override // com.squareup.wire.Message.Builder
        public MeetingNotesInfo build() {
            return new MeetingNotesInfo(this.doc_token, this.doc_type, this.docUrl, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder docUrl(String r100) {
            this.docUrl = r100;
            return this;
        }

        public Builder doc_token(String r100) {
            this.doc_token = r100;
            return this;
        }

        public Builder doc_type(Doc.Type r100) {
            this.doc_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingNotesInfo extends ProtoAdapter<MeetingNotesInfo> {
        public ProtoAdapter_MeetingNotesInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingNotesInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingNotesInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.doc_token = "";
            r101.doc_type = Doc.Type.UNKNOWN;
            r101.docUrl = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.doc_type = Doc.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.docUrl = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MeetingNotesInfo r100) {
            String r101 = r100.doc_token;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Doc.Type r104 = r100.doc_type;
            if (r104 == null) goto L9;
            int r105 = Doc.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.docUrl;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MeetingNotesInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingNotesInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingNotesInfo r101) throws IOException {
            String r102 = r101.doc_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Doc.Type r103 = r101.doc_type;
            if (r103 == null) goto L8;
            Doc.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.docUrl;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingNotesInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingNotesInfo();
        DEFAULT_DOC_TYPE = Doc.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doc_token = this.doc_token;
        r100.doc_type = this.doc_type;
        r100.docUrl = this.docUrl;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingNotesInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingNotesInfo(String r100, Doc.Type r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MeetingNotesInfo(String r100, Doc.Type r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.doc_token = r100;
        this.doc_type = r101;
        this.docUrl = r102;
    }
}
