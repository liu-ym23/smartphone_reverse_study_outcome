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
public final class FuncParamsXc14fa8054cee04ab extends Message<FuncParamsXc14fa8054cee04ab, Builder> {
    public static final ProtoAdapter<FuncParamsXc14fa8054cee04ab> ADAPTER = null;
    public static final String DEFAULT_TRIGGER = "";
    public static final String DEFAULT_UID = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String trigger;
    public final String uid;

    public static final class Builder extends Message.Builder<FuncParamsXc14fa8054cee04ab, Builder> {
        public ByteString _molten_ctx;
        public String trigger;
        public String uid;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXc14fa8054cee04ab build() {
            String r100 = this.uid;
            if (r100 == null) goto L9;
            if (this.trigger == null) goto L9;
            return new FuncParamsXc14fa8054cee04ab(this.uid, this.trigger, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "uid", this.trigger, "trigger"});
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

        public Builder trigger(String r100) {
            this.trigger = r100;
            return this;
        }

        public Builder uid(String r100) {
            this.uid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXc14fa8054cee04ab extends ProtoAdapter<FuncParamsXc14fa8054cee04ab> {
        public ProtoAdapter_FuncParamsXc14fa8054cee04ab() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXc14fa8054cee04ab.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXc14fa8054cee04ab decode2(ProtoReader r100) throws IOException {
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
            r101.trigger = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FuncParamsXc14fa8054cee04ab r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.uid) + r101.encodedSizeWithTag(2, r100.trigger);
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
        public /* bridge */ /* synthetic */ FuncParamsXc14fa8054cee04ab decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXc14fa8054cee04ab r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXc14fa8054cee04ab r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.uid);
            r102.encodeWithTag(r100, 2, r101.trigger);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXc14fa8054cee04ab r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXc14fa8054cee04ab();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.uid = this.uid;
        r100.trigger = this.trigger;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXc14fa8054cee04ab.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXc14fa8054cee04ab(String r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXc14fa8054cee04ab(String r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.uid = r100;
        this.trigger = r101;
        this._molten_ctx = r102;
    }
}
