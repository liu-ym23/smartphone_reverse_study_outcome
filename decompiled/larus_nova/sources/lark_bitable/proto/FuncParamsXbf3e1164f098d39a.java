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
public final class FuncParamsXbf3e1164f098d39a extends Message<FuncParamsXbf3e1164f098d39a, Builder> {
    public static final ProtoAdapter<FuncParamsXbf3e1164f098d39a> ADAPTER = null;
    public static final HomepageAction DEFAULT_ACTION = null;
    public static final Long DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_TOKEN = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageAction action;
    public final Long error_code;
    public final String msg;
    public final String token;

    public static final class Builder extends Message.Builder<FuncParamsXbf3e1164f098d39a, Builder> {
        public ByteString _molten_ctx;
        public HomepageAction action;
        public Long error_code;
        public String msg;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXbf3e1164f098d39a build() {
            HomepageAction r100 = this.action;
            if (r100 == null) goto L13;
            if (this.token == null) goto L13;
            if (this.error_code == null) goto L13;
            if (this.msg == null) goto L13;
            return new FuncParamsXbf3e1164f098d39a(this.action, this.token, this.error_code, this.msg, this._molten_ctx, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "action", this.token, "token", this.error_code, "error_code", this.msg, "msg"});
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

        public Builder action(HomepageAction r100) {
            this.action = r100;
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

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXbf3e1164f098d39a extends ProtoAdapter<FuncParamsXbf3e1164f098d39a> {
        public ProtoAdapter_FuncParamsXbf3e1164f098d39a() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXbf3e1164f098d39a.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXbf3e1164f098d39a decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.action = HomepageAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.error_code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.msg = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 255) goto L15;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXbf3e1164f098d39a r100) {
            int r101 = HomepageAction.ADAPTER.encodedSizeWithTag(1, r100.action);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = ((r101 + r102.encodedSizeWithTag(2, r100.token)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r100.error_code)) + r102.encodedSizeWithTag(4, r100.msg);
            ByteString r104 = r100._molten_ctx;
            if (r104 == null) goto L5;
            int r105 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXbf3e1164f098d39a decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXbf3e1164f098d39a r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXbf3e1164f098d39a r101) throws IOException {
            HomepageAction.ADAPTER.encodeWithTag(r100, 1, r101.action);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.token);
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r101.error_code);
            r102.encodeWithTag(r100, 4, r101.msg);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXbf3e1164f098d39a r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXbf3e1164f098d39a();
        DEFAULT_ACTION = HomepageAction.VAR_HOMEPAGE_ACTION_REFRESH;
        DEFAULT_ERROR_CODE = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action = this.action;
        r100.token = this.token;
        r100.error_code = this.error_code;
        r100.msg = this.msg;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXbf3e1164f098d39a.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXbf3e1164f098d39a(HomepageAction r100, String r101, Long r110, String r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsXbf3e1164f098d39a(HomepageAction r100, String r101, Long r102, String r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.action = r100;
        this.token = r101;
        this.error_code = r102;
        this.msg = r103;
        this._molten_ctx = r104;
    }
}
