package com.bytedance.lark.pb.url.v1;

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
public final class MGetUrlPreviewResponse extends Message<MGetUrlPreviewResponse, Builder> {
    public static final ProtoAdapter<MGetUrlPreviewResponse> ADAPTER = null;
    public static final Long DEFAULT_NET_COST_MS = null;
    public static final ProtoAdapter_MGetUrlPreviewResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long net_cost_ms;
    public final List<GetUrlPreviewResponse> resps;

    public static final class Builder extends Message.Builder<MGetUrlPreviewResponse, Builder> implements d<MGetUrlPreviewResponse> {
        public Long net_cost_ms;
        public List<GetUrlPreviewResponse> resps;

        @Override // com.squareup.wire.Message.Builder
        public MGetUrlPreviewResponse build() {
            return new MGetUrlPreviewResponse(this.resps, this.net_cost_ms, super.buildUnknownFields());
        }

        public Builder() {
            this.resps = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder net_cost_ms(Long r100) {
            this.net_cost_ms = r100;
            return this;
        }

        public Builder resps(List<GetUrlPreviewResponse> r100) {
            Internal.checkElementsNotNull(r100);
            this.resps = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetUrlPreviewResponse extends ProtoAdapter<MGetUrlPreviewResponse> implements c<MGetUrlPreviewResponse> {
        public ProtoAdapter_MGetUrlPreviewResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetUrlPreviewResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetUrlPreviewResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.net_cost_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.resps.add(GetUrlPreviewResponse.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.net_cost_ms = ProtoAdapter.UINT64.decode(r100);
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
        public int encodedSize2(MGetUrlPreviewResponse r100) {
            int r101 = GetUrlPreviewResponse.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.resps);
            Long r102 = r100.net_cost_ms;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.UINT64.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetUrlPreviewResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetUrlPreviewResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetUrlPreviewResponse r101) throws IOException {
            GetUrlPreviewResponse.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.resps);
            Long r102 = r101.net_cost_ms;
            if (r102 == null) goto L5;
            ProtoAdapter.UINT64.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetUrlPreviewResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetUrlPreviewResponse r100 = new ProtoAdapter_MGetUrlPreviewResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NET_COST_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resps = Internal.copyOf("resps", this.resps);
        r100.net_cost_ms = this.net_cost_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetUrlPreviewResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetUrlPreviewResponse(List<GetUrlPreviewResponse> r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MGetUrlPreviewResponse(List<GetUrlPreviewResponse> r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.resps = Internal.immutableCopyOf("resps", r100);
        this.net_cost_ms = r101;
    }
}
