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
public final class FuncParamsX4567d0cab517d6e9 extends Message<FuncParamsX4567d0cab517d6e9, Builder> {
    public static final ProtoAdapter<FuncParamsX4567d0cab517d6e9> ADAPTER = null;
    public static final RecordPermission DEFAULT_REQUIRE_PERMISSION = null;
    public static final String DEFAULT_TOKEN = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final RecordPermission require_permission;
    public final String token;

    public static final class Builder extends Message.Builder<FuncParamsX4567d0cab517d6e9, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public RecordPermission require_permission;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX4567d0cab517d6e9 build() {
            String r100 = this.token;
            if (r100 == null) goto L9;
            if (this.callback == null) goto L9;
            return new FuncParamsX4567d0cab517d6e9(this.token, this.require_permission, this.callback, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "token", this.callback, "callback"});
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

        public Builder require_permission(RecordPermission r100) {
            this.require_permission = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX4567d0cab517d6e9 extends ProtoAdapter<FuncParamsX4567d0cab517d6e9> {
        public ProtoAdapter_FuncParamsX4567d0cab517d6e9() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX4567d0cab517d6e9.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX4567d0cab517d6e9 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.require_permission = RecordPermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX4567d0cab517d6e9 r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.token);
            RecordPermission r102 = r100.require_permission;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = RecordPermission.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = (r101 + r104) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(3, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX4567d0cab517d6e9 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX4567d0cab517d6e9 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX4567d0cab517d6e9 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.token);
            RecordPermission r102 = r101.require_permission;
            if (r102 == null) goto L5;
            RecordPermission.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 3, r101.callback);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX4567d0cab517d6e9 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX4567d0cab517d6e9();
        DEFAULT_REQUIRE_PERMISSION = RecordPermission.VAR_RECORD_PERMISSION_READABLE;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.token = this.token;
        r100.require_permission = this.require_permission;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX4567d0cab517d6e9.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX4567d0cab517d6e9(String r100, RecordPermission r101, MoltenFfiInstanceMsg r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX4567d0cab517d6e9(String r100, RecordPermission r101, MoltenFfiInstanceMsg r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.token = r100;
        this.require_permission = r101;
        this.callback = r102;
        this._molten_ctx = r103;
    }
}
