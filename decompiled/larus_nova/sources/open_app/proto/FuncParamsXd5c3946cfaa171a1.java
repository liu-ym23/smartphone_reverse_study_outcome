package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXd5c3946cfaa171a1 extends Message<FuncParamsXd5c3946cfaa171a1, Builder> {
    public static final ProtoAdapter<FuncParamsXd5c3946cfaa171a1> ADAPTER = null;
    public static final String DEFAULT_OPEN_ID = "";
    public static final String DEFAULT_PLATFORM_SESSION = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final String open_id;
    public final String platform_session;

    public static final class Builder extends Message.Builder<FuncParamsXd5c3946cfaa171a1, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public String open_id;
        public String platform_session;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXd5c3946cfaa171a1 build() {
            String r100 = this.open_id;
            if (r100 == null) goto L11;
            if (this.callback == null) goto L11;
            if (this.platform_session == null) goto L11;
            return new FuncParamsXd5c3946cfaa171a1(this.open_id, this.callback, this.platform_session, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, Constants.JumpUrlConstants.URL_KEY_OPENID, this.callback, "callback", this.platform_session, "platform_session"});
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

        public Builder open_id(String r100) {
            this.open_id = r100;
            return this;
        }

        public Builder platform_session(String r100) {
            this.platform_session = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXd5c3946cfaa171a1 extends ProtoAdapter<FuncParamsXd5c3946cfaa171a1> {
        public ProtoAdapter_FuncParamsXd5c3946cfaa171a1() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXd5c3946cfaa171a1.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXd5c3946cfaa171a1 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.open_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.platform_session = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsXd5c3946cfaa171a1 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.open_id) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(2, r100.callback)) + r101.encodedSizeWithTag(3, r100.platform_session);
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
        public /* bridge */ /* synthetic */ FuncParamsXd5c3946cfaa171a1 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXd5c3946cfaa171a1 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXd5c3946cfaa171a1 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.open_id);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 2, r101.callback);
            r102.encodeWithTag(r100, 3, r101.platform_session);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXd5c3946cfaa171a1 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXd5c3946cfaa171a1();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.open_id = this.open_id;
        r100.callback = this.callback;
        r100.platform_session = this.platform_session;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXd5c3946cfaa171a1.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXd5c3946cfaa171a1(String r100, MoltenFfiInstanceMsg r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXd5c3946cfaa171a1(String r100, MoltenFfiInstanceMsg r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.open_id = r100;
        this.callback = r101;
        this.platform_session = r102;
        this._molten_ctx = r103;
    }
}
