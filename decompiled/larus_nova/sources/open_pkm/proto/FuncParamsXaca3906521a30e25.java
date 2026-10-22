package open_pkm.proto;

import com.bytedance.common.wschannel.WsConstants;
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
public final class FuncParamsXaca3906521a30e25 extends Message<FuncParamsXaca3906521a30e25, Builder> {
    public static final ProtoAdapter<FuncParamsXaca3906521a30e25> ADAPTER = null;
    public static final String DEFAULT_EVENT = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String event;
    public final Map<String, String> payload;

    public static final class Builder extends Message.Builder<FuncParamsXaca3906521a30e25, Builder> {
        public ByteString _molten_ctx;
        public String event;
        public Map<String, String> payload;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXaca3906521a30e25 build() {
            String r100 = this.event;
            if (r100 == null) goto L7;
            return new FuncParamsXaca3906521a30e25(this.event, this.payload, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "event"});
        }

        public Builder() {
            this.payload = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder event(String r100) {
            this.event = r100;
            return this;
        }

        public Builder payload(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.payload = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXaca3906521a30e25 extends ProtoAdapter<FuncParamsXaca3906521a30e25> {
        private final ProtoAdapter<Map<String, String>> payload;

        public ProtoAdapter_FuncParamsXaca3906521a30e25() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXaca3906521a30e25.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.payload = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXaca3906521a30e25 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.event = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.payload.putAll(this.payload.decode(r100));
            goto L3
        L10:
            if (r103 != 255) goto L11;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXaca3906521a30e25 r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.event) + this.payload.encodedSizeWithTag(2, r100.payload);
            ByteString r102 = r100._molten_ctx;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXaca3906521a30e25 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXaca3906521a30e25 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXaca3906521a30e25 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.event);
            this.payload.encodeWithTag(r100, 2, r101.payload);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXaca3906521a30e25 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXaca3906521a30e25();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.event = this.event;
        r100.payload = Internal.copyOf(WsConstants.KEY_PAYLOAD, this.payload);
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXaca3906521a30e25.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXaca3906521a30e25(String r100, Map<String, String> r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXaca3906521a30e25(String r100, Map<String, String> r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.event = r100;
        this.payload = Internal.immutableCopyOf(WsConstants.KEY_PAYLOAD, r101);
        this._molten_ctx = r102;
    }
}
