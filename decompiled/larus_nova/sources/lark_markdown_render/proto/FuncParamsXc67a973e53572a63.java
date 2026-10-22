package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXc67a973e53572a63 extends Message<FuncParamsXc67a973e53572a63, Builder> {
    public static final ProtoAdapter<FuncParamsXc67a973e53572a63> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PATH = "";
    public static final Integer DEFAULT_TTC_INDEX = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String name;
    public final String path;
    public final Integer ttc_index;

    public static final class Builder extends Message.Builder<FuncParamsXc67a973e53572a63, Builder> {
        public ByteString _molten_ctx;
        public String name;
        public String path;
        public Integer ttc_index;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXc67a973e53572a63 build() {
            String r100 = this.name;
            if (r100 == null) goto L11;
            if (this.path == null) goto L11;
            if (this.ttc_index == null) goto L11;
            return new FuncParamsXc67a973e53572a63(this.name, this.path, this.ttc_index, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "name", this.path, "path", this.ttc_index, "ttc_index"});
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

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder ttc_index(Integer r100) {
            this.ttc_index = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXc67a973e53572a63 extends ProtoAdapter<FuncParamsXc67a973e53572a63> {
        public ProtoAdapter_FuncParamsXc67a973e53572a63() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXc67a973e53572a63.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXc67a973e53572a63 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.ttc_index = ProtoAdapter.UINT32.decode(r100);
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
        public int encodedSize2(FuncParamsXc67a973e53572a63 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.name) + r101.encodedSizeWithTag(2, r100.path)) + ProtoAdapter.UINT32.encodedSizeWithTag(3, r100.ttc_index);
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
        public /* bridge */ /* synthetic */ FuncParamsXc67a973e53572a63 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXc67a973e53572a63 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXc67a973e53572a63 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.name);
            r102.encodeWithTag(r100, 2, r101.path);
            ProtoAdapter.UINT32.encodeWithTag(r100, 3, r101.ttc_index);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXc67a973e53572a63 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXc67a973e53572a63();
        DEFAULT_TTC_INDEX = 0;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.path = this.path;
        r100.ttc_index = this.ttc_index;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXc67a973e53572a63.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXc67a973e53572a63(String r100, String r101, Integer r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXc67a973e53572a63(String r100, String r101, Integer r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.name = r100;
        this.path = r101;
        this.ttc_index = r102;
        this._molten_ctx = r103;
    }
}
