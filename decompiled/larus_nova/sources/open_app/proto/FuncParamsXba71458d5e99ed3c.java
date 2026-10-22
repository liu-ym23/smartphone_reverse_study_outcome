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
public final class FuncParamsXba71458d5e99ed3c extends Message<FuncParamsXba71458d5e99ed3c, Builder> {
    public static final ProtoAdapter<FuncParamsXba71458d5e99ed3c> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f524828id;

    public static final class Builder extends Message.Builder<FuncParamsXba71458d5e99ed3c, Builder> {
        public ByteString _molten_ctx;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f524829id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXba71458d5e99ed3c build() {
            String r100 = this.f524829id;
            if (r100 == null) goto L7;
            return new FuncParamsXba71458d5e99ed3c(this.f524829id, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
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

        public Builder id(String r100) {
            this.f524829id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXba71458d5e99ed3c extends ProtoAdapter<FuncParamsXba71458d5e99ed3c> {
        public ProtoAdapter_FuncParamsXba71458d5e99ed3c() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXba71458d5e99ed3c.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXba71458d5e99ed3c decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.f524829id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 255) goto L9;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXba71458d5e99ed3c r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f524828id);
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
        public /* bridge */ /* synthetic */ FuncParamsXba71458d5e99ed3c decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXba71458d5e99ed3c r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXba71458d5e99ed3c r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f524828id);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXba71458d5e99ed3c r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXba71458d5e99ed3c();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f524829id = this.f524828id;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXba71458d5e99ed3c.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXba71458d5e99ed3c(String r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsXba71458d5e99ed3c(String r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f524828id = r100;
        this._molten_ctx = r101;
    }
}
