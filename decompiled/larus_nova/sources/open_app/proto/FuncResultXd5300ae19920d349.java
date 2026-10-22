package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncResultXd5300ae19920d349 extends Message<FuncResultXd5300ae19920d349, Builder> {
    public static final ProtoAdapter<FuncResultXd5300ae19920d349> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final FuncErrorX9757bb2a5952da86 err;
    public final FuncReturnX24f00c44e39a7f53 ret;

    public static final class Builder extends Message.Builder<FuncResultXd5300ae19920d349, Builder> {
        public ByteString _molten_ctx;
        public FuncErrorX9757bb2a5952da86 err;
        public FuncReturnX24f00c44e39a7f53 ret;

        @Override // com.squareup.wire.Message.Builder
        public FuncResultXd5300ae19920d349 build() {
            return new FuncResultXd5300ae19920d349(this.ret, this.err, this._molten_ctx, super.buildUnknownFields());
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

        public Builder err(FuncErrorX9757bb2a5952da86 r100) {
            this.err = r100;
            return this;
        }

        public Builder ret(FuncReturnX24f00c44e39a7f53 r100) {
            this.ret = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncResultXd5300ae19920d349 extends ProtoAdapter<FuncResultXd5300ae19920d349> {
        public ProtoAdapter_FuncResultXd5300ae19920d349() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncResultXd5300ae19920d349.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncResultXd5300ae19920d349 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.ret = FuncReturnX24f00c44e39a7f53.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.err = FuncErrorX9757bb2a5952da86.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncResultXd5300ae19920d349 r100) {
            FuncReturnX24f00c44e39a7f53 r101 = r100.ret;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FuncReturnX24f00c44e39a7f53.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            FuncErrorX9757bb2a5952da86 r104 = r100.err;
            if (r104 == null) goto L9;
            int r105 = FuncErrorX9757bb2a5952da86.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteString r107 = r100._molten_ctx;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncResultXd5300ae19920d349 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncResultXd5300ae19920d349 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncResultXd5300ae19920d349 r101) throws IOException {
            FuncReturnX24f00c44e39a7f53 r102 = r101.ret;
            if (r102 == null) goto L5;
            FuncReturnX24f00c44e39a7f53.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FuncErrorX9757bb2a5952da86 r103 = r101.err;
            if (r103 == null) goto L8;
            FuncErrorX9757bb2a5952da86.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncResultXd5300ae19920d349 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncResultXd5300ae19920d349();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ret = this.ret;
        r100.err = this.err;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncResultXd5300ae19920d349.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncResultXd5300ae19920d349(FuncReturnX24f00c44e39a7f53 r100, FuncErrorX9757bb2a5952da86 r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncResultXd5300ae19920d349(FuncReturnX24f00c44e39a7f53 r100, FuncErrorX9757bb2a5952da86 r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.ret = r100;
        this.err = r101;
        this._molten_ctx = r102;
    }
}
