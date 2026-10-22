package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetToolsByIDsResponse extends Message<GetToolsByIDsResponse, Builder> {
    public static final ProtoAdapter<GetToolsByIDsResponse> ADAPTER = null;
    public static final ProtoAdapter_GetToolsByIDsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ToolInfo> id2tool;

    public static final class Builder extends Message.Builder<GetToolsByIDsResponse, Builder> implements d<GetToolsByIDsResponse> {
        public Map<String, ToolInfo> id2tool;

        @Override // com.squareup.wire.Message.Builder
        public GetToolsByIDsResponse build() {
            return new GetToolsByIDsResponse(this.id2tool, super.buildUnknownFields());
        }

        public Builder() {
            this.id2tool = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id2tool(Map<String, ToolInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.id2tool = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetToolsByIDsResponse extends ProtoAdapter<GetToolsByIDsResponse> implements c<GetToolsByIDsResponse> {
        private final ProtoAdapter<Map<String, ToolInfo>> id2tool;

        public ProtoAdapter_GetToolsByIDsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetToolsByIDsResponse.class);
            this.id2tool = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ToolInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetToolsByIDsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.id2tool.putAll(this.id2tool.decode(r100));
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
        public int encodedSize2(GetToolsByIDsResponse r100) {
            return this.id2tool.encodedSizeWithTag(1, r100.id2tool) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetToolsByIDsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetToolsByIDsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetToolsByIDsResponse r101) throws IOException {
            this.id2tool.encodeWithTag(r100, 1, r101.id2tool);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetToolsByIDsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetToolsByIDsResponse r100 = new ProtoAdapter_GetToolsByIDsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.id2tool = Internal.copyOf("id2tool", this.id2tool);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetToolsByIDsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetToolsByIDsResponse(Map<String, ToolInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetToolsByIDsResponse(Map<String, ToolInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.id2tool = Internal.immutableCopyOf("id2tool", r100);
    }
}
