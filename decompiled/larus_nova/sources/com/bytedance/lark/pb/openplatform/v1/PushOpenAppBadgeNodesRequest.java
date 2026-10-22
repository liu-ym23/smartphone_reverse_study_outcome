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
public final class PushOpenAppBadgeNodesRequest extends Message<PushOpenAppBadgeNodesRequest, Builder> {
    public static final ProtoAdapter<PushOpenAppBadgeNodesRequest> ADAPTER = null;
    public static final String DEFAULT_SID = "";
    public static final ProtoAdapter_PushOpenAppBadgeNodesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<OpenAppBadgeNode> notice_nodes;
    public final String sid;

    public static final class Builder extends Message.Builder<PushOpenAppBadgeNodesRequest, Builder> implements d<PushOpenAppBadgeNodesRequest> {
        public List<OpenAppBadgeNode> notice_nodes;
        public String sid;

        @Override // com.squareup.wire.Message.Builder
        public PushOpenAppBadgeNodesRequest build() {
            return new PushOpenAppBadgeNodesRequest(this.notice_nodes, this.sid, super.buildUnknownFields());
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

        public Builder sid(String r100) {
            this.sid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushOpenAppBadgeNodesRequest extends ProtoAdapter<PushOpenAppBadgeNodesRequest> implements c<PushOpenAppBadgeNodesRequest> {
        public ProtoAdapter_PushOpenAppBadgeNodesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushOpenAppBadgeNodesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushOpenAppBadgeNodesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.notice_nodes.add(OpenAppBadgeNode.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PushOpenAppBadgeNodesRequest r100) {
            int r101 = OpenAppBadgeNode.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.notice_nodes);
            String r102 = r100.sid;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushOpenAppBadgeNodesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushOpenAppBadgeNodesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushOpenAppBadgeNodesRequest r101) throws IOException {
            OpenAppBadgeNode.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.notice_nodes);
            String r102 = r101.sid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushOpenAppBadgeNodesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushOpenAppBadgeNodesRequest r100 = new ProtoAdapter_PushOpenAppBadgeNodesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.notice_nodes = Internal.copyOf("notice_nodes", this.notice_nodes);
        r100.sid = this.sid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushOpenAppBadgeNodesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushOpenAppBadgeNodesRequest(List<OpenAppBadgeNode> r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushOpenAppBadgeNodesRequest(List<OpenAppBadgeNode> r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.notice_nodes = Internal.immutableCopyOf("notice_nodes", r100);
        this.sid = r101;
    }
}
