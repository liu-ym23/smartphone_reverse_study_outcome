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
public final class FuncParamsX3740a52db2e4f4f6 extends Message<FuncParamsX3740a52db2e4f4f6, Builder> {
    public static final ProtoAdapter<FuncParamsX3740a52db2e4f4f6> ADAPTER = null;
    public static final FetchInfoType DEFAULT_INFO_TYPE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Map<String, String> fetch_info_param;
    public final FetchInfoType info_type;

    public static final class Builder extends Message.Builder<FuncParamsX3740a52db2e4f4f6, Builder> {
        public ByteString _molten_ctx;
        public Map<String, String> fetch_info_param;
        public FetchInfoType info_type;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX3740a52db2e4f4f6 build() {
            FetchInfoType r100 = this.info_type;
            if (r100 == null) goto L7;
            return new FuncParamsX3740a52db2e4f4f6(this.info_type, this.fetch_info_param, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "info_type"});
        }

        public Builder() {
            this.fetch_info_param = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder fetch_info_param(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.fetch_info_param = r100;
            return this;
        }

        public Builder info_type(FetchInfoType r100) {
            this.info_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX3740a52db2e4f4f6 extends ProtoAdapter<FuncParamsX3740a52db2e4f4f6> {
        private final ProtoAdapter<Map<String, String>> fetch_info_param;

        public ProtoAdapter_FuncParamsX3740a52db2e4f4f6() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX3740a52db2e4f4f6.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.fetch_info_param = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FuncParamsX3740a52db2e4f4f6 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.info_type = FetchInfoType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.fetch_info_param.putAll(this.fetch_info_param.decode(r100));
            goto L3
        L10:
            if (r103 != 255) goto L11;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX3740a52db2e4f4f6 r100) {
            int r101 = FetchInfoType.ADAPTER.encodedSizeWithTag(1, r100.info_type) + this.fetch_info_param.encodedSizeWithTag(2, r100.fetch_info_param);
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
        public /* bridge */ /* synthetic */ FuncParamsX3740a52db2e4f4f6 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX3740a52db2e4f4f6 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX3740a52db2e4f4f6 r101) throws IOException {
            FetchInfoType.ADAPTER.encodeWithTag(r100, 1, r101.info_type);
            this.fetch_info_param.encodeWithTag(r100, 2, r101.fetch_info_param);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX3740a52db2e4f4f6 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX3740a52db2e4f4f6();
        DEFAULT_INFO_TYPE = FetchInfoType.VAR_FETCH_INFO_TYPE_COOKIE;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.info_type = this.info_type;
        r100.fetch_info_param = Internal.copyOf("fetch_info_param", this.fetch_info_param);
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX3740a52db2e4f4f6.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX3740a52db2e4f4f6(FetchInfoType r100, Map<String, String> r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX3740a52db2e4f4f6(FetchInfoType r100, Map<String, String> r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.info_type = r100;
        this.fetch_info_param = Internal.immutableCopyOf("fetch_info_param", r101);
        this._molten_ctx = r102;
    }
}
