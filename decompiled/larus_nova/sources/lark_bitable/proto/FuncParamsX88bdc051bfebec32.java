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
public final class FuncParamsX88bdc051bfebec32 extends Message<FuncParamsX88bdc051bfebec32, Builder> {
    public static final ProtoAdapter<FuncParamsX88bdc051bfebec32> ADAPTER = null;
    public static final HomepageListType DEFAULT_LIST_TYPE = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_SPACE_TOKEN = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageListType list_type;
    public final String name;
    public final String space_token;

    public static final class Builder extends Message.Builder<FuncParamsX88bdc051bfebec32, Builder> {
        public ByteString _molten_ctx;
        public HomepageListType list_type;
        public String name;
        public String space_token;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX88bdc051bfebec32 build() {
            HomepageListType r100 = this.list_type;
            if (r100 == null) goto L7;
            return new FuncParamsX88bdc051bfebec32(this.list_type, this.name, this.space_token, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "list_type"});
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

        public Builder list_type(HomepageListType r100) {
            this.list_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder space_token(String r100) {
            this.space_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX88bdc051bfebec32 extends ProtoAdapter<FuncParamsX88bdc051bfebec32> {
        public ProtoAdapter_FuncParamsX88bdc051bfebec32() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX88bdc051bfebec32.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX88bdc051bfebec32 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.list_type = HomepageListType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.space_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 255) goto L13;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX88bdc051bfebec32 r100) {
            int r101 = HomepageListType.ADAPTER.encodedSizeWithTag(1, r100.list_type);
            String r102 = r100.name;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            String r106 = r100.space_token;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.STRING.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            ByteString r109 = r100._molten_ctx;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX88bdc051bfebec32 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX88bdc051bfebec32 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX88bdc051bfebec32 r101) throws IOException {
            HomepageListType.ADAPTER.encodeWithTag(r100, 1, r101.list_type);
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            String r103 = r101.space_token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX88bdc051bfebec32 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX88bdc051bfebec32();
        DEFAULT_LIST_TYPE = HomepageListType.VAR_HOMEPAGE_LIST_TYPE_RECENT;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.list_type = this.list_type;
        r100.name = this.name;
        r100.space_token = this.space_token;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX88bdc051bfebec32.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX88bdc051bfebec32(HomepageListType r100, String r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX88bdc051bfebec32(HomepageListType r100, String r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.list_type = r100;
        this.name = r101;
        this.space_token = r102;
        this._molten_ctx = r103;
    }
}
