package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DoubaoSearchQueryMeta extends Message<DoubaoSearchQueryMeta, Builder> {
    public static final ProtoAdapter<DoubaoSearchQueryMeta> ADAPTER = null;
    public static final String DEFAULT_DIGEST = "";
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String mdigest;
    public final String mquery;

    public static final class Builder extends Message.Builder<DoubaoSearchQueryMeta, Builder> {
        public String mdigest;
        public String mquery;

        @Override // com.squareup.wire.Message.Builder
        public DoubaoSearchQueryMeta build() {
            return new DoubaoSearchQueryMeta(this.mdigest, this.mquery, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder digest(String r100) {
            this.mdigest = r100;
            return this;
        }

        public Builder query(String r100) {
            this.mquery = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoSearchQueryMeta extends ProtoAdapter<DoubaoSearchQueryMeta> {
        public ProtoAdapter_DoubaoSearchQueryMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoSearchQueryMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DoubaoSearchQueryMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mdigest = "";
            r101.mquery = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mdigest = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mquery = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DoubaoSearchQueryMeta r100) {
            String r101 = r100.mdigest;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mquery;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DoubaoSearchQueryMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DoubaoSearchQueryMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DoubaoSearchQueryMeta r101) throws IOException {
            String r102 = r101.mdigest;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mquery;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoSearchQueryMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoSearchQueryMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdigest = this.mdigest;
        r100.mquery = this.mquery;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DoubaoSearchQueryMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DoubaoSearchQueryMeta(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DoubaoSearchQueryMeta(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mdigest = r100;
        this.mquery = r101;
    }
}
