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
public final class FuncParamsX8f81da39e50895ee extends Message<FuncParamsX8f81da39e50895ee, Builder> {
    public static final ProtoAdapter<FuncParamsX8f81da39e50895ee> ADAPTER = null;
    public static final HomepageListType DEFAULT_LIST_TYPE = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_SPACE_TOKEN = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageListType list_type;
    public final String name;
    public final String space_token;

    public static final class Builder extends Message.Builder<FuncParamsX8f81da39e50895ee, Builder> {
        public ByteString _molten_ctx;
        public HomepageListType list_type;
        public String name;
        public String space_token;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX8f81da39e50895ee build() {
            HomepageListType r100 = this.list_type;
            if (r100 == null) goto L9;
            if (this.name == null) goto L9;
            return new FuncParamsX8f81da39e50895ee(this.list_type, this.name, this.space_token, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "list_type", this.name, "name"});
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

    public static final class ProtoAdapter_FuncParamsX8f81da39e50895ee extends ProtoAdapter<FuncParamsX8f81da39e50895ee> {
        public ProtoAdapter_FuncParamsX8f81da39e50895ee() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX8f81da39e50895ee.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX8f81da39e50895ee decode2(ProtoReader r100) throws IOException {
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
        public int encodedSize2(FuncParamsX8f81da39e50895ee r100) {
            int r101 = HomepageListType.ADAPTER.encodedSizeWithTag(1, r100.list_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.name);
            String r104 = r100.space_token;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            ByteString r108 = r100._molten_ctx;
            if (r108 == null) goto L10;
            r105 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX8f81da39e50895ee decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX8f81da39e50895ee r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX8f81da39e50895ee r101) throws IOException {
            HomepageListType.ADAPTER.encodeWithTag(r100, 1, r101.list_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.name);
            String r103 = r101.space_token;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            ByteString r104 = r101._molten_ctx;
            if (r104 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX8f81da39e50895ee r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX8f81da39e50895ee();
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
        return FuncParamsX8f81da39e50895ee.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX8f81da39e50895ee(HomepageListType r100, String r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX8f81da39e50895ee(HomepageListType r100, String r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.list_type = r100;
        this.name = r101;
        this.space_token = r102;
        this._molten_ctx = r103;
    }
}
