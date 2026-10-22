package lark_markdown_render.proto;

import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX57675f1c0efe42b7 extends Message<FuncParamsX57675f1c0efe42b7, Builder> {
    public static final ProtoAdapter<FuncParamsX57675f1c0efe42b7> ADAPTER = null;
    public static final Integer DEFAULT_INSTANCE_ID = null;
    public static final String DEFAULT_PAYLOAD = "";
    public static final String DEFAULT_SCHEMA = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Integer instance_id;
    public final String payload;
    public final String schema;

    public static final class Builder extends Message.Builder<FuncParamsX57675f1c0efe42b7, Builder> {
        public ByteString _molten_ctx;
        public Integer instance_id;
        public String payload;
        public String schema;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX57675f1c0efe42b7 build() {
            Integer r100 = this.instance_id;
            if (r100 == null) goto L11;
            if (this.schema == null) goto L11;
            if (this.payload == null) goto L11;
            return new FuncParamsX57675f1c0efe42b7(this.instance_id, this.schema, this.payload, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "instance_id", this.schema, "schema", this.payload, WsConstants.KEY_PAYLOAD});
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

        public Builder instance_id(Integer r100) {
            this.instance_id = r100;
            return this;
        }

        public Builder payload(String r100) {
            this.payload = r100;
            return this;
        }

        public Builder schema(String r100) {
            this.schema = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX57675f1c0efe42b7 extends ProtoAdapter<FuncParamsX57675f1c0efe42b7> {
        public ProtoAdapter_FuncParamsX57675f1c0efe42b7() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX57675f1c0efe42b7.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX57675f1c0efe42b7 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.instance_id = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.schema = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.payload = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsX57675f1c0efe42b7 r100) {
            int r101 = ProtoAdapter.UINT32.encodedSizeWithTag(1, r100.instance_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.schema)) + r102.encodedSizeWithTag(3, r100.payload);
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
        public /* bridge */ /* synthetic */ FuncParamsX57675f1c0efe42b7 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX57675f1c0efe42b7 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX57675f1c0efe42b7 r101) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r101.instance_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.schema);
            r102.encodeWithTag(r100, 3, r101.payload);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX57675f1c0efe42b7 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX57675f1c0efe42b7();
        DEFAULT_INSTANCE_ID = 0;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.instance_id = this.instance_id;
        r100.schema = this.schema;
        r100.payload = this.payload;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX57675f1c0efe42b7.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX57675f1c0efe42b7(Integer r100, String r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX57675f1c0efe42b7(Integer r100, String r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.instance_id = r100;
        this.schema = r101;
        this.payload = r102;
        this._molten_ctx = r103;
    }
}
