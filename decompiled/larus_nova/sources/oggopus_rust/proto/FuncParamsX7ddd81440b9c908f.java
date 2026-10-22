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
public final class FuncParamsX7ddd81440b9c908f extends Message<FuncParamsX7ddd81440b9c908f, Builder> {
    public static final ProtoAdapter<FuncParamsX7ddd81440b9c908f> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final ByteString data;

    public static final class Builder extends Message.Builder<FuncParamsX7ddd81440b9c908f, Builder> {
        public ByteString _molten_ctx;
        public ByteString data;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX7ddd81440b9c908f build() {
            ByteString r100 = this.data;
            if (r100 == null) goto L7;
            return new FuncParamsX7ddd81440b9c908f(this.data, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "data"});
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

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX7ddd81440b9c908f extends ProtoAdapter<FuncParamsX7ddd81440b9c908f> {
        public ProtoAdapter_FuncParamsX7ddd81440b9c908f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX7ddd81440b9c908f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX7ddd81440b9c908f decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.data = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsX7ddd81440b9c908f r100) {
            ProtoAdapter<ByteString> r101 = ProtoAdapter.BYTES;
            int r102 = r101.encodedSizeWithTag(1, r100.data);
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
        public /* bridge */ /* synthetic */ FuncParamsX7ddd81440b9c908f decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX7ddd81440b9c908f r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX7ddd81440b9c908f r101) throws IOException {
            ProtoAdapter<ByteString> r102 = ProtoAdapter.BYTES;
            r102.encodeWithTag(r100, 1, r101.data);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX7ddd81440b9c908f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX7ddd81440b9c908f();
        ByteString r100 = ByteString.EMPTY;
        DEFAULT_DATA = r100;
        DEFAULT__MOLTEN_CTX = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data = this.data;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX7ddd81440b9c908f.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX7ddd81440b9c908f(ByteString r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX7ddd81440b9c908f(ByteString r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.data = r100;
        this._molten_ctx = r101;
    }
}
