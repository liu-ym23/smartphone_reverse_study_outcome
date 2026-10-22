package open_app.proto;

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
public final class FuncParamsX3330f779f3fa3298 extends Message<FuncParamsX3330f779f3fa3298, Builder> {
    public static final ProtoAdapter<FuncParamsX3330f779f3fa3298> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Map<String, String> result;

    public static final class Builder extends Message.Builder<FuncParamsX3330f779f3fa3298, Builder> {
        public ByteString _molten_ctx;
        public Map<String, String> result;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX3330f779f3fa3298 build() {
            return new FuncParamsX3330f779f3fa3298(this.result, this._molten_ctx, super.buildUnknownFields());
        }

        public Builder() {
            this.result = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder result(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX3330f779f3fa3298 extends ProtoAdapter<FuncParamsX3330f779f3fa3298> {
        private final ProtoAdapter<Map<String, String>> result;

        public ProtoAdapter_FuncParamsX3330f779f3fa3298() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX3330f779f3fa3298.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.result = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX3330f779f3fa3298 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.result.putAll(this.result.decode(r100));
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
        public int encodedSize2(FuncParamsX3330f779f3fa3298 r100) {
            int r101 = this.result.encodedSizeWithTag(1, r100.result);
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
        public /* bridge */ /* synthetic */ FuncParamsX3330f779f3fa3298 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX3330f779f3fa3298 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX3330f779f3fa3298 r101) throws IOException {
            this.result.encodeWithTag(r100, 1, r101.result);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX3330f779f3fa3298 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX3330f779f3fa3298();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result = Internal.copyOf("result", this.result);
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX3330f779f3fa3298.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX3330f779f3fa3298(Map<String, String> r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX3330f779f3fa3298(Map<String, String> r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.result = Internal.immutableCopyOf("result", r100);
        this._molten_ctx = r101;
    }
}
