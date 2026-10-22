package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class CancelFetchRequest extends Message<CancelFetchRequest, Builder> {
    public static final ProtoAdapter<CancelFetchRequest> ADAPTER = null;
    public static final Long DEFAULT_REQUEST_ID = null;
    public static final ProtoAdapter_CancelFetchRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long request_id;
    public final List<String> request_ids;

    public static final class Builder extends Message.Builder<CancelFetchRequest, Builder> implements b<CancelFetchRequest> {
        public Long request_id;
        public List<String> request_ids;

        @Override // com.squareup.wire.Message.Builder
        public CancelFetchRequest build() {
            return new CancelFetchRequest(this.request_id, this.request_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.request_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder request_id(Long r100) {
            this.request_id = r100;
            return this;
        }

        public Builder request_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.request_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CancelFetchRequest extends ProtoAdapter<CancelFetchRequest> implements a<CancelFetchRequest> {
        public ProtoAdapter_CancelFetchRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CancelFetchRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CancelFetchRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.request_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.request_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.request_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(CancelFetchRequest r100) {
            Long r101 = r100.request_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.request_ids)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CancelFetchRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CancelFetchRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CancelFetchRequest r101) throws IOException {
            Long r102 = r101.request_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.request_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CancelFetchRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CancelFetchRequest r100 = new ProtoAdapter_CancelFetchRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_REQUEST_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.request_id = this.request_id;
        r100.request_ids = Internal.copyOf("request_ids", this.request_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CancelFetchRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CancelFetchRequest(Long r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CancelFetchRequest(Long r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.request_id = r100;
        this.request_ids = Internal.immutableCopyOf("request_ids", r101);
    }
}
