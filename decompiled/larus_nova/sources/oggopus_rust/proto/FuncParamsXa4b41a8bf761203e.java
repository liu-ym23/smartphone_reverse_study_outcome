package oggopus_rust.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXa4b41a8bf761203e extends Message<FuncParamsXa4b41a8bf761203e, Builder> {
    public static final ProtoAdapter<FuncParamsXa4b41a8bf761203e> ADAPTER = null;
    public static final ByteString DEFAULT_PCM_DATA = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final ByteString pcm_data;

    public static final class Builder extends Message.Builder<FuncParamsXa4b41a8bf761203e, Builder> {
        public ByteString _molten_ctx;
        public ByteString pcm_data;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXa4b41a8bf761203e build() {
            ByteString r100 = this.pcm_data;
            if (r100 == null) goto L7;
            return new FuncParamsXa4b41a8bf761203e(this.pcm_data, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "pcm_data"});
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

        public Builder pcm_data(ByteString r100) {
            this.pcm_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXa4b41a8bf761203e extends ProtoAdapter<FuncParamsXa4b41a8bf761203e> {
        public ProtoAdapter_FuncParamsXa4b41a8bf761203e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXa4b41a8bf761203e.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXa4b41a8bf761203e decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.pcm_data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L8:
            if (r103 != 255) goto L9;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsXa4b41a8bf761203e r100) {
            ProtoAdapter<ByteString> r101 = ProtoAdapter.BYTES;
            int r102 = r101.encodedSizeWithTag(1, r100.pcm_data);
            ByteString r103 = r100._molten_ctx;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(255, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXa4b41a8bf761203e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXa4b41a8bf761203e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXa4b41a8bf761203e r101) throws IOException {
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 1, r101.pcm_data);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXa4b41a8bf761203e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXa4b41a8bf761203e();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_PCM_DATA = r100;
        DEFAULT__MOLTEN_CTX = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pcm_data = this.pcm_data;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXa4b41a8bf761203e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXa4b41a8bf761203e(ByteString r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsXa4b41a8bf761203e(ByteString r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.pcm_data = r100;
        this._molten_ctx = r101;
    }
}
