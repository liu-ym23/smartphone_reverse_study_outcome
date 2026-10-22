package im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class AnswerReference extends Message<AnswerReference, Builder> {
    public static final ProtoAdapter<AnswerReference> ADAPTER = null;
    public static final Long DEFAULT_PASSAGE_SOURCE = null;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Long passage_source;
    public final String title;
    public final String url;

    public static final class Builder extends Message.Builder<AnswerReference, Builder> {
        public Long passage_source;
        public String title;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public AnswerReference build() {
            return new AnswerReference(this.url, this.title, this.passage_source, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder passage_source(Long r100) {
            this.passage_source = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AnswerReference extends ProtoAdapter<AnswerReference> {
        public ProtoAdapter_AnswerReference() {
            super(FieldEncoding.LENGTH_DELIMITED, AnswerReference.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AnswerReference decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.title = "";
            r101.passage_source = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.passage_source = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(AnswerReference r100) {
            String r101 = r100.url;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.title;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.passage_source;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ AnswerReference decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AnswerReference r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AnswerReference r101) throws IOException {
            String r102 = r101.url;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.title;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.passage_source;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AnswerReference r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AnswerReference();
        DEFAULT_PASSAGE_SOURCE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.title = this.title;
        r100.passage_source = this.passage_source;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AnswerReference.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AnswerReference(String r100, String r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public AnswerReference(String r100, String r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.url = r100;
        this.title = r101;
        this.passage_source = r102;
    }
}
