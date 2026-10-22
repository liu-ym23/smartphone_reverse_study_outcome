package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncReturnX3ee2f825fb43f301 extends Message<FuncReturnX3ee2f825fb43f301, Builder> {
    public static final ProtoAdapter<FuncReturnX3ee2f825fb43f301> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final BitableAppInfo ret;

    public static final class Builder extends Message.Builder<FuncReturnX3ee2f825fb43f301, Builder> {
        public ByteString _molten_ctx;
        public BitableAppInfo ret;

        @Override // com.squareup.wire.Message.Builder
        public FuncReturnX3ee2f825fb43f301 build() {
            return new FuncReturnX3ee2f825fb43f301(this.ret, this._molten_ctx, super.buildUnknownFields());
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

        public Builder ret(BitableAppInfo r100) {
            this.ret = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncReturnX3ee2f825fb43f301 extends ProtoAdapter<FuncReturnX3ee2f825fb43f301> {
        public ProtoAdapter_FuncReturnX3ee2f825fb43f301() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncReturnX3ee2f825fb43f301.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncReturnX3ee2f825fb43f301 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.ret = BitableAppInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncReturnX3ee2f825fb43f301 r100) {
            BitableAppInfo r101 = r100.ret;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = BitableAppInfo.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100._molten_ctx;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncReturnX3ee2f825fb43f301 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncReturnX3ee2f825fb43f301 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncReturnX3ee2f825fb43f301 r101) throws IOException {
            BitableAppInfo r102 = r101.ret;
            if (r102 == null) goto L5;
            BitableAppInfo.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncReturnX3ee2f825fb43f301 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncReturnX3ee2f825fb43f301();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ret = this.ret;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncReturnX3ee2f825fb43f301.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncReturnX3ee2f825fb43f301(BitableAppInfo r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncReturnX3ee2f825fb43f301(BitableAppInfo r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.ret = r100;
        this._molten_ctx = r101;
    }
}
