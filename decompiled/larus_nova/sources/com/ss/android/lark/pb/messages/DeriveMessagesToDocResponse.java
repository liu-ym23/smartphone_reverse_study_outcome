package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DeriveMessagesToDocResponse extends Message<DeriveMessagesToDocResponse, Builder> {
    public static final ProtoAdapter<DeriveMessagesToDocResponse> ADAPTER = null;
    public static final String DEFAULT_DOCUMENT_TOKEN = "";
    public static final String DEFAULT_DOC_TITLE = "";
    public static final String DEFAULT_DOC_URL = "";
    private static final long serialVersionUID = 0;
    public final List<Long> mderive_message_ids;
    public final String mdoc_title;
    public final String mdoc_url;
    public final String mdocument_token;
    public final List<Long> mrestricted_message_ids;

    public static final class Builder extends Message.Builder<DeriveMessagesToDocResponse, Builder> {
        public List<Long> mderive_message_ids;
        public String mdoc_title;
        public String mdoc_url;
        public String mdocument_token;
        public List<Long> mrestricted_message_ids;

        @Override // com.squareup.wire.Message.Builder
        public DeriveMessagesToDocResponse build() {
            return new DeriveMessagesToDocResponse(this.mdoc_url, this.mdoc_title, this.mdocument_token, this.mderive_message_ids, this.mrestricted_message_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mderive_message_ids = Internal.newMutableList();
            this.mrestricted_message_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder derive_message_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mderive_message_ids = r100;
            return this;
        }

        public Builder doc_title(String r100) {
            this.mdoc_title = r100;
            return this;
        }

        public Builder doc_url(String r100) {
            this.mdoc_url = r100;
            return this;
        }

        public Builder document_token(String r100) {
            this.mdocument_token = r100;
            return this;
        }

        public Builder restricted_message_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrestricted_message_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeriveMessagesToDocResponse extends ProtoAdapter<DeriveMessagesToDocResponse> {
        public ProtoAdapter_DeriveMessagesToDocResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DeriveMessagesToDocResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeriveMessagesToDocResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mdoc_url = "";
            r101.mdoc_title = "";
            r101.mdocument_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mdoc_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mdoc_title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mdocument_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mderive_message_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mrestricted_message_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeriveMessagesToDocResponse r100) {
            String r101 = r100.mdoc_url;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mdoc_title;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mdocument_token;
            if (r107 == null) goto L13;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L13:
            int r108 = r106 + r102;
            ProtoAdapter<Long> r109 = ProtoAdapter.INT64;
            return ((r108 + r109.asRepeated().encodedSizeWithTag(4, r100.mderive_message_ids)) + r109.asRepeated().encodedSizeWithTag(5, r100.mrestricted_message_ids)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeriveMessagesToDocResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeriveMessagesToDocResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeriveMessagesToDocResponse r101) throws IOException {
            String r102 = r101.mdoc_url;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mdoc_title;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mdocument_token;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ProtoAdapter<Long> r105 = ProtoAdapter.INT64;
            r105.asRepeated().encodeWithTag(r100, 4, r101.mderive_message_ids);
            r105.asRepeated().encodeWithTag(r100, 5, r101.mrestricted_message_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeriveMessagesToDocResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeriveMessagesToDocResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdoc_url = this.mdoc_url;
        r100.mdoc_title = this.mdoc_title;
        r100.mdocument_token = this.mdocument_token;
        r100.mderive_message_ids = Internal.copyOf("mderive_message_ids", this.mderive_message_ids);
        r100.mrestricted_message_ids = Internal.copyOf("mrestricted_message_ids", this.mrestricted_message_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeriveMessagesToDocResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeriveMessagesToDocResponse(String r100, String r101, String r110, List<Long> r111, List<Long> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public DeriveMessagesToDocResponse(String r100, String r101, String r102, List<Long> r103, List<Long> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mdoc_url = r100;
        this.mdoc_title = r101;
        this.mdocument_token = r102;
        this.mderive_message_ids = Internal.immutableCopyOf("mderive_message_ids", r103);
        this.mrestricted_message_ids = Internal.immutableCopyOf("mrestricted_message_ids", r104);
    }
}
