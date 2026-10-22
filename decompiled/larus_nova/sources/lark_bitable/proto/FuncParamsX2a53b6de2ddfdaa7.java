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
public final class FuncParamsX2a53b6de2ddfdaa7 extends Message<FuncParamsX2a53b6de2ddfdaa7, Builder> {
    public static final ProtoAdapter<FuncParamsX2a53b6de2ddfdaa7> ADAPTER = null;
    public static final String DEFAULT_DOC_TOKEN = "";
    public static final Boolean DEFAULT_NEED_USER = null;
    public static final Integer DEFAULT_OBJ_TYPE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final String doc_token;
    public final Boolean need_user;
    public final Integer obj_type;

    public static final class Builder extends Message.Builder<FuncParamsX2a53b6de2ddfdaa7, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public String doc_token;
        public Boolean need_user;
        public Integer obj_type;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX2a53b6de2ddfdaa7 build() {
            String r100 = this.doc_token;
            if (r100 == null) goto L13;
            if (this.obj_type == null) goto L13;
            if (this.need_user == null) goto L13;
            if (this.callback == null) goto L13;
            return new FuncParamsX2a53b6de2ddfdaa7(this.doc_token, this.obj_type, this.need_user, this.callback, this._molten_ctx, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "doc_token", this.obj_type, "obj_type", this.need_user, "need_user", this.callback, "callback"});
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

        public Builder doc_token(String r100) {
            this.doc_token = r100;
            return this;
        }

        public Builder need_user(Boolean r100) {
            this.need_user = r100;
            return this;
        }

        public Builder obj_type(Integer r100) {
            this.obj_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX2a53b6de2ddfdaa7 extends ProtoAdapter<FuncParamsX2a53b6de2ddfdaa7> {
        public ProtoAdapter_FuncParamsX2a53b6de2ddfdaa7() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX2a53b6de2ddfdaa7.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX2a53b6de2ddfdaa7 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.doc_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.obj_type = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.need_user = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 255) goto L15;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX2a53b6de2ddfdaa7 r100) {
            int r101 = ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.doc_token) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.obj_type)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.need_user)) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(4, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX2a53b6de2ddfdaa7 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX2a53b6de2ddfdaa7 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX2a53b6de2ddfdaa7 r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.doc_token);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.obj_type);
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.need_user);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 4, r101.callback);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX2a53b6de2ddfdaa7 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX2a53b6de2ddfdaa7();
        DEFAULT_OBJ_TYPE = 0;
        DEFAULT_NEED_USER = Boolean.FALSE;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doc_token = this.doc_token;
        r100.obj_type = this.obj_type;
        r100.need_user = this.need_user;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX2a53b6de2ddfdaa7.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX2a53b6de2ddfdaa7(String r100, Integer r101, Boolean r110, MoltenFfiInstanceMsg r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsX2a53b6de2ddfdaa7(String r100, Integer r101, Boolean r102, MoltenFfiInstanceMsg r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.doc_token = r100;
        this.obj_type = r101;
        this.need_user = r102;
        this.callback = r103;
        this._molten_ctx = r104;
    }
}
