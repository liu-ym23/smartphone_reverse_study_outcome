package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXf9c6ac1ffb03e79e extends Message<FuncParamsXf9c6ac1ffb03e79e, Builder> {
    public static final ProtoAdapter<FuncParamsXf9c6ac1ffb03e79e> ADAPTER = null;
    public static final HomepageAction DEFAULT_ACTION = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final HomepageAction action;
    public final Map<String, String> ext;
    public final String token;

    public static final class Builder extends Message.Builder<FuncParamsXf9c6ac1ffb03e79e, Builder> {
        public ByteString _molten_ctx;
        public HomepageAction action;
        public Map<String, String> ext;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXf9c6ac1ffb03e79e build() {
            HomepageAction r100 = this.action;
            if (r100 == null) goto L9;
            if (this.token == null) goto L9;
            return new FuncParamsXf9c6ac1ffb03e79e(this.action, this.token, this.ext, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "action", this.token, "token"});
        }

        public Builder() {
            this.ext = Internal.newMutableMap();
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

        public Builder ext(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ext = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXf9c6ac1ffb03e79e extends ProtoAdapter<FuncParamsXf9c6ac1ffb03e79e> {
        private final ProtoAdapter<Map<String, String>> ext;

        public ProtoAdapter_FuncParamsXf9c6ac1ffb03e79e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXf9c6ac1ffb03e79e.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.ext = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXf9c6ac1ffb03e79e decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.action = HomepageAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.ext.putAll(this.ext.decode(r100));
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
        public int encodedSize2(FuncParamsXf9c6ac1ffb03e79e r100) {
            int r101 = (HomepageAction.ADAPTER.encodedSizeWithTag(1, r100.action) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.token)) + this.ext.encodedSizeWithTag(3, r100.ext);
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
        public /* bridge */ /* synthetic */ FuncParamsXf9c6ac1ffb03e79e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXf9c6ac1ffb03e79e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXf9c6ac1ffb03e79e r101) throws IOException {
            HomepageAction.ADAPTER.encodeWithTag(r100, 1, r101.action);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.token);
            this.ext.encodeWithTag(r100, 3, r101.ext);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXf9c6ac1ffb03e79e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXf9c6ac1ffb03e79e();
        DEFAULT_ACTION = HomepageAction.VAR_HOMEPAGE_ACTION_REFRESH;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action = this.action;
        r100.token = this.token;
        r100.ext = Internal.copyOf("ext", this.ext);
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXf9c6ac1ffb03e79e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXf9c6ac1ffb03e79e(HomepageAction r100, String r101, Map<String, String> r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXf9c6ac1ffb03e79e(HomepageAction r100, String r101, Map<String, String> r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.action = r100;
        this.token = r101;
        this.ext = Internal.immutableCopyOf("ext", r102);
        this._molten_ctx = r103;
    }
}
