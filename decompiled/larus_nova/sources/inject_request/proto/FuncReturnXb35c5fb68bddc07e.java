package inject_request.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class FuncReturnXb35c5fb68bddc07e extends Message<FuncReturnXb35c5fb68bddc07e, Builder> {
    public static final ProtoAdapter<FuncReturnXb35c5fb68bddc07e> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Map<String, String> ret;

    public static final class Builder extends Message.Builder<FuncReturnXb35c5fb68bddc07e, Builder> {
        public ByteString _molten_ctx;
        public Map<String, String> ret;

        @Override // com.squareup.wire.Message.Builder
        public FuncReturnXb35c5fb68bddc07e build() {
            return new FuncReturnXb35c5fb68bddc07e(this.ret, this._molten_ctx, super.buildUnknownFields());
        }

        public Builder() {
            this.ret = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder ret(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ret = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncReturnXb35c5fb68bddc07e extends ProtoAdapter<FuncReturnXb35c5fb68bddc07e> {
        private final ProtoAdapter<Map<String, String>> ret;

        public ProtoAdapter_FuncReturnXb35c5fb68bddc07e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncReturnXb35c5fb68bddc07e.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.ret = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FuncReturnXb35c5fb68bddc07e decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.ret.putAll(this.ret.decode(r100));
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
        public int encodedSize2(FuncReturnXb35c5fb68bddc07e r100) {
            int r101 = this.ret.encodedSizeWithTag(1, r100.ret);
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
        public /* bridge */ /* synthetic */ FuncReturnXb35c5fb68bddc07e decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncReturnXb35c5fb68bddc07e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncReturnXb35c5fb68bddc07e r101) throws IOException {
            this.ret.encodeWithTag(r100, 1, r101.ret);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncReturnXb35c5fb68bddc07e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncReturnXb35c5fb68bddc07e();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ret = Internal.copyOf("ret", this.ret);
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncReturnXb35c5fb68bddc07e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncReturnXb35c5fb68bddc07e(Map<String, String> r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncReturnXb35c5fb68bddc07e(Map<String, String> r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.ret = Internal.immutableCopyOf("ret", r100);
        this._molten_ctx = r101;
    }
}
