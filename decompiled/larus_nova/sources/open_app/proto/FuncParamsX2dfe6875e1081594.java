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
public final class FuncParamsX2dfe6875e1081594 extends Message<FuncParamsX2dfe6875e1081594, Builder> {
    public static final ProtoAdapter<FuncParamsX2dfe6875e1081594> ADAPTER = null;
    public static final String DEFAULT_OPEN_THREAD_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final String open_thread_id;
    public final String user_id;

    public static final class Builder extends Message.Builder<FuncParamsX2dfe6875e1081594, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public String open_thread_id;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX2dfe6875e1081594 build() {
            String r100 = this.user_id;
            if (r100 == null) goto L11;
            if (this.open_thread_id == null) goto L11;
            if (this.callback == null) goto L11;
            return new FuncParamsX2dfe6875e1081594(this.user_id, this.open_thread_id, this.callback, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.open_thread_id, "open_thread_id", this.callback, "callback"});
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

        public Builder callback(MoltenFfiInstanceMsg r100) {
            this.callback = r100;
            return this;
        }

        public Builder open_thread_id(String r100) {
            this.open_thread_id = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX2dfe6875e1081594 extends ProtoAdapter<FuncParamsX2dfe6875e1081594> {
        public ProtoAdapter_FuncParamsX2dfe6875e1081594() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX2dfe6875e1081594.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX2dfe6875e1081594 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.open_thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncParamsX2dfe6875e1081594 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.user_id) + r101.encodedSizeWithTag(2, r100.open_thread_id)) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(3, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX2dfe6875e1081594 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX2dfe6875e1081594 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX2dfe6875e1081594 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.user_id);
            r102.encodeWithTag(r100, 2, r101.open_thread_id);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 3, r101.callback);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX2dfe6875e1081594 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX2dfe6875e1081594();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.open_thread_id = this.open_thread_id;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX2dfe6875e1081594.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX2dfe6875e1081594(String r100, String r101, MoltenFfiInstanceMsg r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX2dfe6875e1081594(String r100, String r101, MoltenFfiInstanceMsg r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.user_id = r100;
        this.open_thread_id = r101;
        this.callback = r102;
        this._molten_ctx = r103;
    }
}
