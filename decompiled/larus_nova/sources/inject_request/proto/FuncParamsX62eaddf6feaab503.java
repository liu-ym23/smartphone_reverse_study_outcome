package inject_request.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class FuncParamsX62eaddf6feaab503 extends Message<FuncParamsX62eaddf6feaab503, Builder> {
    public static final ProtoAdapter<FuncParamsX62eaddf6feaab503> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg info_callback;
    public final InjectRequest request;
    public final MoltenFfiInstanceMsg response_callback;

    public static final class Builder extends Message.Builder<FuncParamsX62eaddf6feaab503, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg info_callback;
        public InjectRequest request;
        public MoltenFfiInstanceMsg response_callback;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX62eaddf6feaab503 build() {
            InjectRequest r100 = this.request;
            if (r100 == null) goto L11;
            if (this.response_callback == null) goto L11;
            if (this.info_callback == null) goto L11;
            return new FuncParamsX62eaddf6feaab503(this.request, this.response_callback, this.info_callback, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "request", this.response_callback, "response_callback", this.info_callback, "info_callback"});
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

        public Builder info_callback(MoltenFfiInstanceMsg r100) {
            this.info_callback = r100;
            return this;
        }

        public Builder request(InjectRequest r100) {
            this.request = r100;
            return this;
        }

        public Builder response_callback(MoltenFfiInstanceMsg r100) {
            this.response_callback = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX62eaddf6feaab503 extends ProtoAdapter<FuncParamsX62eaddf6feaab503> {
        public ProtoAdapter_FuncParamsX62eaddf6feaab503() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX62eaddf6feaab503.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FuncParamsX62eaddf6feaab503 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.request = InjectRequest.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.response_callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.info_callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX62eaddf6feaab503 r100) {
            int r101 = InjectRequest.ADAPTER.encodedSizeWithTag(1, r100.request);
            ProtoAdapter<MoltenFfiInstanceMsg> r102 = MoltenFfiInstanceMsg.ADAPTER;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.response_callback)) + r102.encodedSizeWithTag(3, r100.info_callback);
            ByteString r104 = r100._molten_ctx;
            if (r104 == null) goto L5;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX62eaddf6feaab503 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX62eaddf6feaab503 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX62eaddf6feaab503 r101) throws IOException {
            InjectRequest.ADAPTER.encodeWithTag(r100, 1, r101.request);
            ProtoAdapter<MoltenFfiInstanceMsg> r102 = MoltenFfiInstanceMsg.ADAPTER;
            r102.encodeWithTag(r100, 2, r101.response_callback);
            r102.encodeWithTag(r100, 3, r101.info_callback);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX62eaddf6feaab503 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX62eaddf6feaab503();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.request = this.request;
        r100.response_callback = this.response_callback;
        r100.info_callback = this.info_callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX62eaddf6feaab503.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX62eaddf6feaab503(InjectRequest r100, MoltenFfiInstanceMsg r101, MoltenFfiInstanceMsg r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX62eaddf6feaab503(InjectRequest r100, MoltenFfiInstanceMsg r101, MoltenFfiInstanceMsg r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.request = r100;
        this.response_callback = r101;
        this.info_callback = r102;
        this._molten_ctx = r103;
    }
}
