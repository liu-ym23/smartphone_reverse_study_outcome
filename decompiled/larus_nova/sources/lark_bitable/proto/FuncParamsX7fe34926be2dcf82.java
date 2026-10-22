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
public final class FuncParamsX7fe34926be2dcf82 extends Message<FuncParamsX7fe34926be2dcf82, Builder> {
    public static final ProtoAdapter<FuncParamsX7fe34926be2dcf82> ADAPTER = null;
    public static final HomepageListType DEFAULT_LIST_TYPE = null;
    public static final String DEFAULT_SPACE_TOKEN = "";
    public static final Boolean DEFAULT_USE_CACHE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageListType list_type;
    public final String space_token;
    public final Boolean use_cache;

    public static final class Builder extends Message.Builder<FuncParamsX7fe34926be2dcf82, Builder> {
        public ByteString _molten_ctx;
        public HomepageListType list_type;
        public String space_token;
        public Boolean use_cache;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX7fe34926be2dcf82 build() {
            HomepageListType r100 = this.list_type;
            if (r100 == null) goto L9;
            if (this.use_cache == null) goto L9;
            return new FuncParamsX7fe34926be2dcf82(this.list_type, this.use_cache, this.space_token, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "list_type", this.use_cache, "use_cache"});
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

        public Builder space_token(String r100) {
            this.space_token = r100;
            return this;
        }

        public Builder use_cache(Boolean r100) {
            this.use_cache = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX7fe34926be2dcf82 extends ProtoAdapter<FuncParamsX7fe34926be2dcf82> {
        public ProtoAdapter_FuncParamsX7fe34926be2dcf82() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX7fe34926be2dcf82.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX7fe34926be2dcf82 decode2(ProtoReader r100) throws IOException {
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
            r101.use_cache = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(FuncParamsX7fe34926be2dcf82 r100) {
            int r101 = HomepageListType.ADAPTER.encodedSizeWithTag(1, r100.list_type) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.use_cache);
            String r102 = r100.space_token;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            ByteString r106 = r100._molten_ctx;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX7fe34926be2dcf82 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX7fe34926be2dcf82 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX7fe34926be2dcf82 r101) throws IOException {
            HomepageListType.ADAPTER.encodeWithTag(r100, 1, r101.list_type);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.use_cache);
            String r102 = r101.space_token;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX7fe34926be2dcf82 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX7fe34926be2dcf82();
        DEFAULT_LIST_TYPE = HomepageListType.VAR_HOMEPAGE_LIST_TYPE_RECENT;
        DEFAULT_USE_CACHE = Boolean.FALSE;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.list_type = this.list_type;
        r100.use_cache = this.use_cache;
        r100.space_token = this.space_token;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX7fe34926be2dcf82.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX7fe34926be2dcf82(HomepageListType r100, Boolean r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX7fe34926be2dcf82(HomepageListType r100, Boolean r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.list_type = r100;
        this.use_cache = r101;
        this.space_token = r102;
        this._molten_ctx = r103;
    }
}
