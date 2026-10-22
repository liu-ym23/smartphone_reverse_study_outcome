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
public final class FuncParamsX256cc6eaadfe3438 extends Message<FuncParamsX256cc6eaadfe3438, Builder> {
    public static final ProtoAdapter<FuncParamsX256cc6eaadfe3438> ADAPTER = null;
    public static final String DEFAULT_UID = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final AppContext app_context;
    public final String uid;

    public static final class Builder extends Message.Builder<FuncParamsX256cc6eaadfe3438, Builder> {
        public ByteString _molten_ctx;
        public AppContext app_context;
        public String uid;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX256cc6eaadfe3438 build() {
            String r100 = this.uid;
            if (r100 == null) goto L9;
            if (this.app_context == null) goto L9;
            return new FuncParamsX256cc6eaadfe3438(this.uid, this.app_context, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "uid", this.app_context, "app_context"});
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

        public Builder app_context(AppContext r100) {
            this.app_context = r100;
            return this;
        }

        public Builder uid(String r100) {
            this.uid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX256cc6eaadfe3438 extends ProtoAdapter<FuncParamsX256cc6eaadfe3438> {
        public ProtoAdapter_FuncParamsX256cc6eaadfe3438() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX256cc6eaadfe3438.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX256cc6eaadfe3438 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.uid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.app_context = AppContext.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncParamsX256cc6eaadfe3438 r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.uid) + AppContext.ADAPTER.encodedSizeWithTag(2, r100.app_context);
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
        public /* bridge */ /* synthetic */ FuncParamsX256cc6eaadfe3438 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX256cc6eaadfe3438 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX256cc6eaadfe3438 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.uid);
            AppContext.ADAPTER.encodeWithTag(r100, 2, r101.app_context);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX256cc6eaadfe3438 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX256cc6eaadfe3438();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.uid = this.uid;
        r100.app_context = this.app_context;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX256cc6eaadfe3438.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX256cc6eaadfe3438(String r100, AppContext r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX256cc6eaadfe3438(String r100, AppContext r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.uid = r100;
        this.app_context = r101;
        this._molten_ctx = r102;
    }
}
