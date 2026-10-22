package space.permission_sdk.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class GetCollaboratorsRequest extends Message<GetCollaboratorsRequest, Builder> {
    public static final ProtoAdapter<GetCollaboratorsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ALL_PAGES = null;
    public static final CollaboratorSource DEFAULT_SOURCE = null;
    public static final ProtoAdapter_GetCollaboratorsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean all_pages;
    public final DocID document;
    public final CollaboratorSource source;

    public static final class Builder extends Message.Builder<GetCollaboratorsRequest, Builder> implements d<GetCollaboratorsRequest> {
        public Boolean all_pages;
        public DocID document;
        public CollaboratorSource source;

        @Override // com.squareup.wire.Message.Builder
        public GetCollaboratorsRequest build() {
            DocID r100 = this.document;
            if (r100 == null) goto L9;
            if (this.source == null) goto L9;
            return new GetCollaboratorsRequest(this.document, this.source, this.all_pages, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "document", this.source, "source"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder all_pages(Boolean r100) {
            this.all_pages = r100;
            return this;
        }

        public Builder document(DocID r100) {
            this.document = r100;
            return this;
        }

        public Builder source(CollaboratorSource r100) {
            this.source = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetCollaboratorsRequest extends ProtoAdapter<GetCollaboratorsRequest> implements c<GetCollaboratorsRequest> {
        public ProtoAdapter_GetCollaboratorsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetCollaboratorsRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetCollaboratorsRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source = CollaboratorSource.default_source;
            r101.all_pages = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.document = DocID.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source = CollaboratorSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.all_pages = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetCollaboratorsRequest r100) {
            int r101 = DocID.ADAPTER.encodedSizeWithTag(1, r100.document) + CollaboratorSource.ADAPTER.encodedSizeWithTag(2, r100.source);
            Boolean r102 = r100.all_pages;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetCollaboratorsRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetCollaboratorsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetCollaboratorsRequest r101) throws IOException {
            DocID.ADAPTER.encodeWithTag(r100, 1, r101.document);
            CollaboratorSource.ADAPTER.encodeWithTag(r100, 2, r101.source);
            Boolean r102 = r101.all_pages;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetCollaboratorsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetCollaboratorsRequest r100 = new ProtoAdapter_GetCollaboratorsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE = CollaboratorSource.default_source;
        DEFAULT_ALL_PAGES = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.document = this.document;
        r100.source = this.source;
        r100.all_pages = this.all_pages;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetCollaboratorsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetCollaboratorsRequest(DocID r100, CollaboratorSource r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetCollaboratorsRequest(DocID r100, CollaboratorSource r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.document = r100;
        this.source = r101;
        this.all_pages = r102;
    }
}
