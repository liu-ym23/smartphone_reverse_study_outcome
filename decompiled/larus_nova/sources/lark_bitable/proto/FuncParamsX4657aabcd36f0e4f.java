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
public final class FuncParamsX4657aabcd36f0e4f extends Message<FuncParamsX4657aabcd36f0e4f, Builder> {
    public static final ProtoAdapter<FuncParamsX4657aabcd36f0e4f> ADAPTER = null;
    public static final HomepageAction DEFAULT_ACTION = null;
    public static final Long DEFAULT_ERROR_CODE = null;
    public static final HomepageListType DEFAULT_LIST_TYPE = null;
    public static final String DEFAULT_MSG = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageAction action;
    public final Long error_code;
    public final HomepageListType list_type;
    public final String msg;

    public static final class Builder extends Message.Builder<FuncParamsX4657aabcd36f0e4f, Builder> {
        public ByteString _molten_ctx;
        public HomepageAction action;
        public Long error_code;
        public HomepageListType list_type;
        public String msg;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX4657aabcd36f0e4f build() {
            HomepageListType r100 = this.list_type;
            if (r100 == null) goto L13;
            if (this.action == null) goto L13;
            if (this.error_code == null) goto L13;
            if (this.msg == null) goto L13;
            return new FuncParamsX4657aabcd36f0e4f(this.list_type, this.action, this.error_code, this.msg, this._molten_ctx, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "list_type", this.action, "action", this.error_code, "error_code", this.msg, "msg"});
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

        public Builder list_type(HomepageListType r100) {
            this.list_type = r100;
            return this;
        }

        public Builder msg(String r100) {
            this.msg = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX4657aabcd36f0e4f extends ProtoAdapter<FuncParamsX4657aabcd36f0e4f> {
        public ProtoAdapter_FuncParamsX4657aabcd36f0e4f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX4657aabcd36f0e4f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX4657aabcd36f0e4f decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.list_type = HomepageListType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.action = HomepageAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX4657aabcd36f0e4f r100) {
            int r101 = ((HomepageListType.ADAPTER.encodedSizeWithTag(1, r100.list_type) + HomepageAction.ADAPTER.encodedSizeWithTag(2, r100.action)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r100.error_code)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r100.msg);
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
        public /* bridge */ /* synthetic */ FuncParamsX4657aabcd36f0e4f decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX4657aabcd36f0e4f r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX4657aabcd36f0e4f r101) throws IOException {
            HomepageListType.ADAPTER.encodeWithTag(r100, 1, r101.list_type);
            HomepageAction.ADAPTER.encodeWithTag(r100, 2, r101.action);
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r101.error_code);
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r101.msg);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX4657aabcd36f0e4f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX4657aabcd36f0e4f();
        DEFAULT_LIST_TYPE = HomepageListType.VAR_HOMEPAGE_LIST_TYPE_RECENT;
        DEFAULT_ACTION = HomepageAction.VAR_HOMEPAGE_ACTION_REFRESH;
        DEFAULT_ERROR_CODE = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.list_type = this.list_type;
        r100.action = this.action;
        r100.error_code = this.error_code;
        r100.msg = this.msg;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX4657aabcd36f0e4f.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX4657aabcd36f0e4f(HomepageListType r100, HomepageAction r101, Long r110, String r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsX4657aabcd36f0e4f(HomepageListType r100, HomepageAction r101, Long r102, String r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.list_type = r100;
        this.action = r101;
        this.error_code = r102;
        this.msg = r103;
        this._molten_ctx = r104;
    }
}
