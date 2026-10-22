package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DocSecLabel extends Message<DocSecLabel, Builder> {
    public static final ProtoAdapter<DocSecLabel> ADAPTER = null;
    public static final String DEFAULT_LABELID = "";
    public static final String DEFAULT_LABELNAMECN = "";
    public static final String DEFAULT_LABELNAMEEN = "";
    private static final long serialVersionUID = 0;
    public final String mLabelID;
    public final String mLabelNameCN;
    public final String mLabelNameEN;

    public static final class Builder extends Message.Builder<DocSecLabel, Builder> {
        public String mLabelID;
        public String mLabelNameCN;
        public String mLabelNameEN;

        @Override // com.squareup.wire.Message.Builder
        public DocSecLabel build() {
            return new DocSecLabel(this.mLabelID, this.mLabelNameCN, this.mLabelNameEN, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder LabelID(String r100) {
            this.mLabelID = r100;
            return this;
        }

        public Builder LabelNameCN(String r100) {
            this.mLabelNameCN = r100;
            return this;
        }

        public Builder LabelNameEN(String r100) {
            this.mLabelNameEN = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DocSecLabel extends ProtoAdapter<DocSecLabel> {
        public ProtoAdapter_DocSecLabel() {
            super(FieldEncoding.LENGTH_DELIMITED, DocSecLabel.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocSecLabel decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mLabelID = "";
            r101.mLabelNameCN = "";
            r101.mLabelNameEN = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mLabelID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mLabelNameCN = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mLabelNameEN = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocSecLabel r100) {
            String r101 = r100.mLabelID;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mLabelNameCN;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mLabelNameEN;
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
        public /* bridge */ /* synthetic */ DocSecLabel decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocSecLabel r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocSecLabel r101) throws IOException {
            String r102 = r101.mLabelID;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mLabelNameCN;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mLabelNameEN;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocSecLabel r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocSecLabel();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mLabelID = this.mLabelID;
        r100.mLabelNameCN = this.mLabelNameCN;
        r100.mLabelNameEN = this.mLabelNameEN;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocSecLabel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocSecLabel(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DocSecLabel(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mLabelID = r100;
        this.mLabelNameCN = r101;
        this.mLabelNameEN = r102;
    }
}
