package office_sdk_im.proto;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX81ee3b6540a0ad37 extends Message<FuncParamsX81ee3b6540a0ad37, Builder> {
    public static final ProtoAdapter<FuncParamsX81ee3b6540a0ad37> ADAPTER = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_SDK_SESSION = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final ByteString payload;
    public final Long sdk_session;

    public static final class Builder extends Message.Builder<FuncParamsX81ee3b6540a0ad37, Builder> {
        public ByteString _molten_ctx;
        public ByteString payload;
        public Long sdk_session;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX81ee3b6540a0ad37 build() {
            Long r100 = this.sdk_session;
            if (r100 == null) goto L9;
            if (this.payload == null) goto L9;
            return new FuncParamsX81ee3b6540a0ad37(this.sdk_session, this.payload, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "sdk_session", this.payload, WsConstants.KEY_PAYLOAD});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder sdk_session(Long r100) {
            this.sdk_session = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX81ee3b6540a0ad37 extends ProtoAdapter<FuncParamsX81ee3b6540a0ad37> {
        public ProtoAdapter_FuncParamsX81ee3b6540a0ad37() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX81ee3b6540a0ad37.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX81ee3b6540a0ad37 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.sdk_session = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsX81ee3b6540a0ad37 r100) {
            int r101 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.sdk_session);
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.payload);
            ByteString r104 = r100._molten_ctx;
            if (r104 == null) goto L5;
            int r105 = r102.encodedSizeWithTag(255, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX81ee3b6540a0ad37 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX81ee3b6540a0ad37 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX81ee3b6540a0ad37 r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.sdk_session);
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 2, r101.payload);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX81ee3b6540a0ad37 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX81ee3b6540a0ad37();
        DEFAULT_SDK_SESSION = 0L;
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_PAYLOAD = r100;
        DEFAULT__MOLTEN_CTX = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sdk_session = this.sdk_session;
        r100.payload = this.payload;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX81ee3b6540a0ad37.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX81ee3b6540a0ad37(Long r100, ByteString r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX81ee3b6540a0ad37(Long r100, ByteString r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.sdk_session = r100;
        this.payload = r101;
        this._molten_ctx = r102;
    }
}
