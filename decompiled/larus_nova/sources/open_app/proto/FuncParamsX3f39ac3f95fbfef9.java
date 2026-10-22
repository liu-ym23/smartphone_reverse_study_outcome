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
public final class FuncParamsX3f39ac3f95fbfef9 extends Message<FuncParamsX3f39ac3f95fbfef9, Builder> {
    public static final ProtoAdapter<FuncParamsX3f39ac3f95fbfef9> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Map<String, String> data;

    public static final class Builder extends Message.Builder<FuncParamsX3f39ac3f95fbfef9, Builder> {
        public ByteString _molten_ctx;
        public Map<String, String> data;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX3f39ac3f95fbfef9 build() {
            return new FuncParamsX3f39ac3f95fbfef9(this.data, this._molten_ctx, super.buildUnknownFields());
        }

        public Builder() {
            this.data = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder data(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX3f39ac3f95fbfef9 extends ProtoAdapter<FuncParamsX3f39ac3f95fbfef9> {
        private final ProtoAdapter<Map<String, String>> data;

        public ProtoAdapter_FuncParamsX3f39ac3f95fbfef9() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX3f39ac3f95fbfef9.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.data = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX3f39ac3f95fbfef9 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.data.putAll(this.data.decode(r100));
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
        public int encodedSize2(FuncParamsX3f39ac3f95fbfef9 r100) {
            int r101 = this.data.encodedSizeWithTag(1, r100.data);
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
        public /* bridge */ /* synthetic */ FuncParamsX3f39ac3f95fbfef9 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX3f39ac3f95fbfef9 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX3f39ac3f95fbfef9 r101) throws IOException {
            this.data.encodeWithTag(r100, 1, r101.data);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX3f39ac3f95fbfef9 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX3f39ac3f95fbfef9();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data = Internal.copyOf("data", this.data);
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX3f39ac3f95fbfef9.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX3f39ac3f95fbfef9(Map<String, String> r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX3f39ac3f95fbfef9(Map<String, String> r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.data = Internal.immutableCopyOf("data", r100);
        this._molten_ctx = r101;
    }
}
