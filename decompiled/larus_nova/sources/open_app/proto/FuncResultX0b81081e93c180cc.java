package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncResultX0b81081e93c180cc extends Message<FuncResultX0b81081e93c180cc, Builder> {
    public static final ProtoAdapter<FuncResultX0b81081e93c180cc> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final FuncErrorX9757bb2a5952da86 err;

    public static final class Builder extends Message.Builder<FuncResultX0b81081e93c180cc, Builder> {
        public ByteString _molten_ctx;
        public FuncErrorX9757bb2a5952da86 err;

        @Override // com.squareup.wire.Message.Builder
        public FuncResultX0b81081e93c180cc build() {
            return new FuncResultX0b81081e93c180cc(this.err, this._molten_ctx, super.buildUnknownFields());
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
    }

    public static final class ProtoAdapter_FuncResultX0b81081e93c180cc extends ProtoAdapter<FuncResultX0b81081e93c180cc> {
        public ProtoAdapter_FuncResultX0b81081e93c180cc() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncResultX0b81081e93c180cc.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncResultX0b81081e93c180cc decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.err = FuncErrorX9757bb2a5952da86.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncResultX0b81081e93c180cc r100) {
            FuncErrorX9757bb2a5952da86 r101 = r100.err;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FuncErrorX9757bb2a5952da86.ADAPTER.encodedSizeWithTag(1, r101);
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
        public /* bridge */ /* synthetic */ FuncResultX0b81081e93c180cc decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncResultX0b81081e93c180cc r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncResultX0b81081e93c180cc r101) throws IOException {
            FuncErrorX9757bb2a5952da86 r102 = r101.err;
            if (r102 == null) goto L5;
            FuncErrorX9757bb2a5952da86.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncResultX0b81081e93c180cc r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncResultX0b81081e93c180cc();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.err = this.err;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncResultX0b81081e93c180cc.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncResultX0b81081e93c180cc(FuncErrorX9757bb2a5952da86 r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncResultX0b81081e93c180cc(FuncErrorX9757bb2a5952da86 r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.err = r100;
        this._molten_ctx = r101;
    }
}
