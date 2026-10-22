package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX310f8ba646d34cdb extends Message<FuncParamsX310f8ba646d34cdb, Builder> {
    public static final ProtoAdapter<FuncParamsX310f8ba646d34cdb> ADAPTER = null;
    public static final Integer DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_ERROR_MSG = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Integer error_code;
    public final String error_msg;

    public static final class Builder extends Message.Builder<FuncParamsX310f8ba646d34cdb, Builder> {
        public ByteString _molten_ctx;
        public Integer error_code;
        public String error_msg;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX310f8ba646d34cdb build() {
            Integer r100 = this.error_code;
            if (r100 == null) goto L9;
            if (this.error_msg == null) goto L9;
            return new FuncParamsX310f8ba646d34cdb(this.error_code, this.error_msg, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "error_code", this.error_msg, "error_msg"});
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

        public Builder error_code(Integer r100) {
            this.error_code = r100;
            return this;
        }

        public Builder error_msg(String r100) {
            this.error_msg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX310f8ba646d34cdb extends ProtoAdapter<FuncParamsX310f8ba646d34cdb> {
        public ProtoAdapter_FuncParamsX310f8ba646d34cdb() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX310f8ba646d34cdb.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX310f8ba646d34cdb decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.error_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.error_msg = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsX310f8ba646d34cdb r100) {
            int r101 = ProtoAdapter.INT32.encodedSizeWithTag(1, r100.error_code) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.error_msg);
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
        public /* bridge */ /* synthetic */ FuncParamsX310f8ba646d34cdb decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX310f8ba646d34cdb r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX310f8ba646d34cdb r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.error_code);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.error_msg);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX310f8ba646d34cdb r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX310f8ba646d34cdb();
        DEFAULT_ERROR_CODE = 0;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.error_code = this.error_code;
        r100.error_msg = this.error_msg;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX310f8ba646d34cdb.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX310f8ba646d34cdb(Integer r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX310f8ba646d34cdb(Integer r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.error_code = r100;
        this.error_msg = r101;
        this._molten_ctx = r102;
    }
}
