package open_pkm.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXabcd86bb8f6789ba extends Message<FuncParamsXabcd86bb8f6789ba, Builder> {
    public static final ProtoAdapter<FuncParamsXabcd86bb8f6789ba> ADAPTER = null;
    public static final String DEFAULT_BIZ_TYPE = "";
    public static final String DEFAULT_RESOURCE_PATH = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String biz_type;
    public final String resource_path;

    public static final class Builder extends Message.Builder<FuncParamsXabcd86bb8f6789ba, Builder> {
        public ByteString _molten_ctx;
        public String biz_type;
        public String resource_path;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXabcd86bb8f6789ba build() {
            String r100 = this.biz_type;
            if (r100 == null) goto L9;
            if (this.resource_path == null) goto L9;
            return new FuncParamsXabcd86bb8f6789ba(this.biz_type, this.resource_path, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "biz_type", this.resource_path, "resource_path"});
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

        public Builder biz_type(String r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder resource_path(String r100) {
            this.resource_path = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXabcd86bb8f6789ba extends ProtoAdapter<FuncParamsXabcd86bb8f6789ba> {
        public ProtoAdapter_FuncParamsXabcd86bb8f6789ba() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXabcd86bb8f6789ba.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXabcd86bb8f6789ba decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.biz_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.resource_path = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsXabcd86bb8f6789ba r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.biz_type) + r101.encodedSizeWithTag(2, r100.resource_path);
            ByteString r103 = r100._molten_ctx;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXabcd86bb8f6789ba decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXabcd86bb8f6789ba r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXabcd86bb8f6789ba r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.biz_type);
            r102.encodeWithTag(r100, 2, r101.resource_path);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXabcd86bb8f6789ba r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXabcd86bb8f6789ba();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_type = this.biz_type;
        r100.resource_path = this.resource_path;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXabcd86bb8f6789ba.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXabcd86bb8f6789ba(String r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXabcd86bb8f6789ba(String r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.biz_type = r100;
        this.resource_path = r101;
        this._molten_ctx = r102;
    }
}
