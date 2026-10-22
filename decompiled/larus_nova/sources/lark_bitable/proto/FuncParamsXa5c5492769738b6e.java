package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXa5c5492769738b6e extends Message<FuncParamsXa5c5492769738b6e, Builder> {
    public static final ProtoAdapter<FuncParamsXa5c5492769738b6e> ADAPTER = null;
    public static final Long DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_MSG = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageCreateBitableResult data;
    public final Long error_code;
    public final String msg;

    public static final class Builder extends Message.Builder<FuncParamsXa5c5492769738b6e, Builder> {
        public ByteString _molten_ctx;
        public HomepageCreateBitableResult data;
        public Long error_code;
        public String msg;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXa5c5492769738b6e build() {
            Long r100 = this.error_code;
            if (r100 == null) goto L9;
            if (this.msg == null) goto L9;
            return new FuncParamsXa5c5492769738b6e(this.data, this.error_code, this.msg, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "error_code", this.msg, "msg"});
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

        public Builder data(HomepageCreateBitableResult r100) {
            this.data = r100;
            return this;
        }

        public Builder error_code(Long r100) {
            this.error_code = r100;
            return this;
        }

        public Builder msg(String r100) {
            this.msg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXa5c5492769738b6e extends ProtoAdapter<FuncParamsXa5c5492769738b6e> {
        public ProtoAdapter_FuncParamsXa5c5492769738b6e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXa5c5492769738b6e.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXa5c5492769738b6e decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.data = HomepageCreateBitableResult.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.error_code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXa5c5492769738b6e r100) {
            HomepageCreateBitableResult r101 = r100.data;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = HomepageCreateBitableResult.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.error_code)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.msg);
            ByteString r105 = r100._molten_ctx;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXa5c5492769738b6e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXa5c5492769738b6e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXa5c5492769738b6e r101) throws IOException {
            HomepageCreateBitableResult r102 = r101.data;
            if (r102 == null) goto L5;
            HomepageCreateBitableResult.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.error_code);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.msg);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXa5c5492769738b6e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXa5c5492769738b6e();
        DEFAULT_ERROR_CODE = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data = this.data;
        r100.error_code = this.error_code;
        r100.msg = this.msg;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXa5c5492769738b6e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXa5c5492769738b6e(HomepageCreateBitableResult r100, Long r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXa5c5492769738b6e(HomepageCreateBitableResult r100, Long r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.data = r100;
        this.error_code = r101;
        this.msg = r102;
        this._molten_ctx = r103;
    }
}
