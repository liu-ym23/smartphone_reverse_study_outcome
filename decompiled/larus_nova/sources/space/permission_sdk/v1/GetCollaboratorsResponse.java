package space.permission_sdk.v1;

import com.bytedance.android.ec.core.event.a;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes41.dex */
public final class GetCollaboratorsResponse extends Message<GetCollaboratorsResponse, Builder> {
    public static final ProtoAdapter<GetCollaboratorsResponse> ADAPTER = null;
    public static final Integer DEFAULT_TOTAL_COUNT = null;
    public static final ProtoAdapter_GetCollaboratorsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<OwnerMeta> owners;
    public final Integer total_count;

    public static final class Builder extends Message.Builder<GetCollaboratorsResponse, Builder> implements d<GetCollaboratorsResponse> {
        public List<OwnerMeta> owners;
        public Integer total_count;

        @Override // com.squareup.wire.Message.Builder
        public GetCollaboratorsResponse build() {
            Integer r100 = this.total_count;
            if (r100 == null) goto L7;
            return new GetCollaboratorsResponse(this.owners, this.total_count, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, a.KEY_TOTAL_COUNT});
        }

        public Builder() {
            this.owners = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder owners(List<OwnerMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.owners = r100;
            return this;
        }

        public Builder total_count(Integer r100) {
            this.total_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetCollaboratorsResponse extends ProtoAdapter<GetCollaboratorsResponse> implements c<GetCollaboratorsResponse> {
        public ProtoAdapter_GetCollaboratorsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetCollaboratorsResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetCollaboratorsResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.total_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.owners.add(OwnerMeta.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.total_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetCollaboratorsResponse r100) {
            return (OwnerMeta.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.owners) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.total_count)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetCollaboratorsResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetCollaboratorsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetCollaboratorsResponse r101) throws IOException {
            OwnerMeta.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.owners);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.total_count);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetCollaboratorsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetCollaboratorsResponse r100 = new ProtoAdapter_GetCollaboratorsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TOTAL_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.owners = Internal.copyOf("owners", this.owners);
        r100.total_count = this.total_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetCollaboratorsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetCollaboratorsResponse(List<OwnerMeta> r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetCollaboratorsResponse(List<OwnerMeta> r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.owners = Internal.immutableCopyOf("owners", r100);
        this.total_count = r101;
    }
}
