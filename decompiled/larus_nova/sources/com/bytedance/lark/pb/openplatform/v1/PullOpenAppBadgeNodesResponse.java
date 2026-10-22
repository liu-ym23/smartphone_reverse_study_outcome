package com.bytedance.lark.pb.openplatform.v1;

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
public final class PullOpenAppBadgeNodesResponse extends Message<PullOpenAppBadgeNodesResponse, Builder> {
    public static final ProtoAdapter<PullOpenAppBadgeNodesResponse> ADAPTER = null;
    public static final ProtoAdapter_PullOpenAppBadgeNodesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<OpenAppBadgeNode> notice_nodes;

    public static final class Builder extends Message.Builder<PullOpenAppBadgeNodesResponse, Builder> implements d<PullOpenAppBadgeNodesResponse> {
        public List<OpenAppBadgeNode> notice_nodes;

        @Override // com.squareup.wire.Message.Builder
        public PullOpenAppBadgeNodesResponse build() {
            return new PullOpenAppBadgeNodesResponse(this.notice_nodes, super.buildUnknownFields());
        }

        public Builder() {
            this.notice_nodes = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder notice_nodes(List<OpenAppBadgeNode> r100) {
            Internal.checkElementsNotNull(r100);
            this.notice_nodes = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullOpenAppBadgeNodesResponse extends ProtoAdapter<PullOpenAppBadgeNodesResponse> implements c<PullOpenAppBadgeNodesResponse> {
        public ProtoAdapter_PullOpenAppBadgeNodesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullOpenAppBadgeNodesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullOpenAppBadgeNodesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.notice_nodes.add(OpenAppBadgeNode.ADAPTER.decode(r100));
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
        public int encodedSize2(PullOpenAppBadgeNodesResponse r100) {
            return OpenAppBadgeNode.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.notice_nodes) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullOpenAppBadgeNodesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullOpenAppBadgeNodesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullOpenAppBadgeNodesResponse r101) throws IOException {
            OpenAppBadgeNode.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.notice_nodes);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullOpenAppBadgeNodesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PullOpenAppBadgeNodesResponse r100 = new ProtoAdapter_PullOpenAppBadgeNodesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.notice_nodes = Internal.copyOf("notice_nodes", this.notice_nodes);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullOpenAppBadgeNodesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullOpenAppBadgeNodesResponse(List<OpenAppBadgeNode> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PullOpenAppBadgeNodesResponse(List<OpenAppBadgeNode> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.notice_nodes = Internal.immutableCopyOf("notice_nodes", r100);
    }
}
