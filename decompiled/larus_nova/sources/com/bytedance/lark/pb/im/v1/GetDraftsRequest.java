package com.bytedance.lark.pb.im.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class GetDraftsRequest extends Message<GetDraftsRequest, Builder> {
    public static final ProtoAdapter<GetDraftsRequest> ADAPTER = null;
    public static final ProtoAdapter_GetDraftsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> draft_ids;

    public static final class Builder extends Message.Builder<GetDraftsRequest, Builder> implements d<GetDraftsRequest> {
        public List<String> draft_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetDraftsRequest build() {
            return new GetDraftsRequest(this.draft_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.draft_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder draft_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.draft_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDraftsRequest extends ProtoAdapter<GetDraftsRequest> implements c<GetDraftsRequest> {
        public ProtoAdapter_GetDraftsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDraftsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDraftsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.draft_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetDraftsRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.draft_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDraftsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDraftsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDraftsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.draft_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDraftsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDraftsRequest r100 = new ProtoAdapter_GetDraftsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.draft_ids = Internal.copyOf("draft_ids", this.draft_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDraftsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDraftsRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetDraftsRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.draft_ids = Internal.immutableCopyOf("draft_ids", r100);
    }
}
