package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class GetOpenChatByChatIdResponse extends Message<GetOpenChatByChatIdResponse, Builder> {
    public static final ProtoAdapter<GetOpenChatByChatIdResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, OpenChatInfo> open_chat_ids;

    public static final class Builder extends Message.Builder<GetOpenChatByChatIdResponse, Builder> {
        public Map<String, OpenChatInfo> open_chat_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetOpenChatByChatIdResponse build() {
            return new GetOpenChatByChatIdResponse(this.open_chat_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.open_chat_ids = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder open_chat_ids(Map<String, OpenChatInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.open_chat_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetOpenChatByChatIdResponse extends ProtoAdapter<GetOpenChatByChatIdResponse> {
        private final ProtoAdapter<Map<String, OpenChatInfo>> open_chat_ids;

        public ProtoAdapter_GetOpenChatByChatIdResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetOpenChatByChatIdResponse.class);
            this.open_chat_ids = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, OpenChatInfo.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetOpenChatByChatIdResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.open_chat_ids.putAll(this.open_chat_ids.decode(r100));
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
        public int encodedSize2(GetOpenChatByChatIdResponse r100) {
            return this.open_chat_ids.encodedSizeWithTag(1, r100.open_chat_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetOpenChatByChatIdResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetOpenChatByChatIdResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetOpenChatByChatIdResponse r101) throws IOException {
            this.open_chat_ids.encodeWithTag(r100, 1, r101.open_chat_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetOpenChatByChatIdResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetOpenChatByChatIdResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.open_chat_ids = Internal.copyOf("open_chat_ids", this.open_chat_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetOpenChatByChatIdResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetOpenChatByChatIdResponse(Map<String, OpenChatInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetOpenChatByChatIdResponse(Map<String, OpenChatInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.open_chat_ids = Internal.immutableCopyOf("open_chat_ids", r100);
    }
}
