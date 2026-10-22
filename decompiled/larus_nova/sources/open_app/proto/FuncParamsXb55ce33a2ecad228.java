package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXb55ce33a2ecad228 extends Message<FuncParamsXb55ce33a2ecad228, Builder> {
    public static final ProtoAdapter<FuncParamsXb55ce33a2ecad228> ADAPTER = null;
    public static final String DEFAULT_SESSION_VALUE = "";
    public static final String DEFAULT_USER_ID = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final AppContext app_context;
    public final MoltenFfiInstanceMsg callback;
    public final List<IdRequestChatInfo> chat_infos;
    public final String session_value;
    public final String user_id;

    public static final class Builder extends Message.Builder<FuncParamsXb55ce33a2ecad228, Builder> {
        public ByteString _molten_ctx;
        public AppContext app_context;
        public MoltenFfiInstanceMsg callback;
        public List<IdRequestChatInfo> chat_infos;
        public String session_value;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXb55ce33a2ecad228 build() {
            String r100 = this.user_id;
            if (r100 == null) goto L13;
            if (this.app_context == null) goto L13;
            if (this.session_value == null) goto L13;
            if (this.callback == null) goto L13;
            return new FuncParamsXb55ce33a2ecad228(this.user_id, this.app_context, this.chat_infos, this.session_value, this.callback, this._molten_ctx, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.app_context, "app_context", this.session_value, "session_value", this.callback, "callback"});
        }

        public Builder() {
            this.chat_infos = Internal.newMutableList();
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

        public Builder callback(MoltenFfiInstanceMsg r100) {
            this.callback = r100;
            return this;
        }

        public Builder chat_infos(List<IdRequestChatInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_infos = r100;
            return this;
        }

        public Builder session_value(String r100) {
            this.session_value = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXb55ce33a2ecad228 extends ProtoAdapter<FuncParamsXb55ce33a2ecad228> {
        public ProtoAdapter_FuncParamsXb55ce33a2ecad228() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXb55ce33a2ecad228.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXb55ce33a2ecad228 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.app_context = AppContext.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.chat_infos.add(IdRequestChatInfo.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.session_value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L16:
            if (r103 != 255) goto L17;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXb55ce33a2ecad228 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (((r101.encodedSizeWithTag(1, r100.user_id) + AppContext.ADAPTER.encodedSizeWithTag(2, r100.app_context)) + IdRequestChatInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.chat_infos)) + r101.encodedSizeWithTag(4, r100.session_value)) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(5, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsXb55ce33a2ecad228 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXb55ce33a2ecad228 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXb55ce33a2ecad228 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.user_id);
            AppContext.ADAPTER.encodeWithTag(r100, 2, r101.app_context);
            IdRequestChatInfo.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.chat_infos);
            r102.encodeWithTag(r100, 4, r101.session_value);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 5, r101.callback);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXb55ce33a2ecad228 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXb55ce33a2ecad228();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.app_context = this.app_context;
        r100.chat_infos = Internal.copyOf("chat_infos", this.chat_infos);
        r100.session_value = this.session_value;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXb55ce33a2ecad228.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXb55ce33a2ecad228(String r100, AppContext r110, List<IdRequestChatInfo> r111, String r112, MoltenFfiInstanceMsg r113, ByteString r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FuncParamsXb55ce33a2ecad228(String r100, AppContext r101, List<IdRequestChatInfo> r102, String r103, MoltenFfiInstanceMsg r104, ByteString r105, ByteString r106) {
        super(ADAPTER, r106);
        this.user_id = r100;
        this.app_context = r101;
        this.chat_infos = Internal.immutableCopyOf("chat_infos", r102);
        this.session_value = r103;
        this.callback = r104;
        this._molten_ctx = r105;
    }
}
