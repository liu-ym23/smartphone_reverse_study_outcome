package oggopus_rust.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncResultXa6781d84def262ad extends Message<FuncResultXa6781d84def262ad, Builder> {
    public static final ProtoAdapter<FuncResultXa6781d84def262ad> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final FuncErrorX7cd250264a8c023a err;

    public static final class Builder extends Message.Builder<FuncResultXa6781d84def262ad, Builder> {
        public ByteString _molten_ctx;
        public FuncErrorX7cd250264a8c023a err;

        @Override // com.squareup.wire.Message.Builder
        public FuncResultXa6781d84def262ad build() {
            return new FuncResultXa6781d84def262ad(this.err, this._molten_ctx, super.buildUnknownFields());
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

        public Builder err(FuncErrorX7cd250264a8c023a r100) {
            this.err = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncResultXa6781d84def262ad extends ProtoAdapter<FuncResultXa6781d84def262ad> {
        public ProtoAdapter_FuncResultXa6781d84def262ad() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncResultXa6781d84def262ad.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncResultXa6781d84def262ad decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.err = FuncErrorX7cd250264a8c023a.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncResultXa6781d84def262ad r100) {
            FuncErrorX7cd250264a8c023a r101 = r100.err;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FuncErrorX7cd250264a8c023a.ADAPTER.encodedSizeWithTag(1, r101);
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
        public /* bridge */ /* synthetic */ FuncResultXa6781d84def262ad decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncResultXa6781d84def262ad r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncResultXa6781d84def262ad r101) throws IOException {
            FuncErrorX7cd250264a8c023a r102 = r101.err;
            if (r102 == null) goto L5;
            FuncErrorX7cd250264a8c023a.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncResultXa6781d84def262ad r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncResultXa6781d84def262ad();
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
        return FuncResultXa6781d84def262ad.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncResultXa6781d84def262ad(FuncErrorX7cd250264a8c023a r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncResultXa6781d84def262ad(FuncErrorX7cd250264a8c023a r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.err = r100;
        this._molten_ctx = r101;
    }
}
