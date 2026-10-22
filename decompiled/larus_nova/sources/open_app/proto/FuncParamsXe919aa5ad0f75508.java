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
public final class FuncParamsXe919aa5ad0f75508 extends Message<FuncParamsXe919aa5ad0f75508, Builder> {
    public static final ProtoAdapter<FuncParamsXe919aa5ad0f75508> ADAPTER = null;
    public static final String DEFAULT_PLATFORM_SESSION = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final List<String> dep_ids;
    public final String platform_session;

    public static final class Builder extends Message.Builder<FuncParamsXe919aa5ad0f75508, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public List<String> dep_ids;
        public String platform_session;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXe919aa5ad0f75508 build() {
            MoltenFfiInstanceMsg r100 = this.callback;
            if (r100 == null) goto L9;
            if (this.platform_session == null) goto L9;
            return new FuncParamsXe919aa5ad0f75508(this.dep_ids, this.callback, this.platform_session, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "callback", this.platform_session, "platform_session"});
        }

        public Builder() {
            this.dep_ids = Internal.newMutableList();
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

        public Builder dep_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.dep_ids = r100;
            return this;
        }

        public Builder platform_session(String r100) {
            this.platform_session = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXe919aa5ad0f75508 extends ProtoAdapter<FuncParamsXe919aa5ad0f75508> {
        public ProtoAdapter_FuncParamsXe919aa5ad0f75508() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXe919aa5ad0f75508.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXe919aa5ad0f75508 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.dep_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(FuncParamsXe919aa5ad0f75508 r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.asRepeated().encodedSizeWithTag(1, r100.dep_ids) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(2, r100.callback)) + r101.encodedSizeWithTag(3, r100.platform_session);
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
        public /* bridge */ /* synthetic */ FuncParamsXe919aa5ad0f75508 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXe919aa5ad0f75508 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXe919aa5ad0f75508 r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.dep_ids);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 2, r101.callback);
            r102.encodeWithTag(r100, 3, r101.platform_session);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXe919aa5ad0f75508 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXe919aa5ad0f75508();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.dep_ids = Internal.copyOf("dep_ids", this.dep_ids);
        r100.callback = this.callback;
        r100.platform_session = this.platform_session;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXe919aa5ad0f75508.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXe919aa5ad0f75508(List<String> r100, MoltenFfiInstanceMsg r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsXe919aa5ad0f75508(List<String> r100, MoltenFfiInstanceMsg r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.dep_ids = Internal.immutableCopyOf("dep_ids", r100);
        this.callback = r101;
        this.platform_session = r102;
        this._molten_ctx = r103;
    }
}
