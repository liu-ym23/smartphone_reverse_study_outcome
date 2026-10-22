package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncResultX76bca2677fbfb90f extends Message<FuncResultX76bca2677fbfb90f, Builder> {
    public static final ProtoAdapter<FuncResultX76bca2677fbfb90f> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final FuncErrorX529049160a731337 err;
    public final FuncReturnXa1695a77bb652ea9 ret;

    public static final class Builder extends Message.Builder<FuncResultX76bca2677fbfb90f, Builder> {
        public ByteString _molten_ctx;
        public FuncErrorX529049160a731337 err;
        public FuncReturnXa1695a77bb652ea9 ret;

        @Override // com.squareup.wire.Message.Builder
        public FuncResultX76bca2677fbfb90f build() {
            return new FuncResultX76bca2677fbfb90f(this.ret, this.err, this._molten_ctx, super.buildUnknownFields());
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

        public Builder err(FuncErrorX529049160a731337 r100) {
            this.err = r100;
            return this;
        }

        public Builder ret(FuncReturnXa1695a77bb652ea9 r100) {
            this.ret = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncResultX76bca2677fbfb90f extends ProtoAdapter<FuncResultX76bca2677fbfb90f> {
        public ProtoAdapter_FuncResultX76bca2677fbfb90f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncResultX76bca2677fbfb90f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncResultX76bca2677fbfb90f decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.ret = FuncReturnXa1695a77bb652ea9.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.err = FuncErrorX529049160a731337.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncResultX76bca2677fbfb90f r100) {
            FuncReturnXa1695a77bb652ea9 r101 = r100.ret;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FuncReturnXa1695a77bb652ea9.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            FuncErrorX529049160a731337 r104 = r100.err;
            if (r104 == null) goto L9;
            int r105 = FuncErrorX529049160a731337.ADAPTER.encodedSizeWithTag(2, r104);
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
        public /* bridge */ /* synthetic */ FuncResultX76bca2677fbfb90f decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncResultX76bca2677fbfb90f r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncResultX76bca2677fbfb90f r101) throws IOException {
            FuncReturnXa1695a77bb652ea9 r102 = r101.ret;
            if (r102 == null) goto L5;
            FuncReturnXa1695a77bb652ea9.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FuncErrorX529049160a731337 r103 = r101.err;
            if (r103 == null) goto L8;
            FuncErrorX529049160a731337.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncResultX76bca2677fbfb90f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncResultX76bca2677fbfb90f();
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
        return FuncResultX76bca2677fbfb90f.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncResultX76bca2677fbfb90f(FuncReturnXa1695a77bb652ea9 r100, FuncErrorX529049160a731337 r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncResultX76bca2677fbfb90f(FuncReturnXa1695a77bb652ea9 r100, FuncErrorX529049160a731337 r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.ret = r100;
        this.err = r101;
        this._molten_ctx = r102;
    }
}
