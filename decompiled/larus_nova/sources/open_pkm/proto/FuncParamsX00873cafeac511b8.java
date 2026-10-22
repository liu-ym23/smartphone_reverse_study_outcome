package open_pkm.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX00873cafeac511b8 extends Message<FuncParamsX00873cafeac511b8, Builder> {
    public static final ProtoAdapter<FuncParamsX00873cafeac511b8> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final PackageDownloadContext context;

    public static final class Builder extends Message.Builder<FuncParamsX00873cafeac511b8, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public PackageDownloadContext context;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX00873cafeac511b8 build() {
            PackageDownloadContext r100 = this.context;
            if (r100 == null) goto L9;
            if (this.callback == null) goto L9;
            return new FuncParamsX00873cafeac511b8(this.context, this.callback, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, PerfLog.PARAM_KEY_CONTEXT_ID, this.callback, "callback"});
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

        public Builder context(PackageDownloadContext r100) {
            this.context = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX00873cafeac511b8 extends ProtoAdapter<FuncParamsX00873cafeac511b8> {
        public ProtoAdapter_FuncParamsX00873cafeac511b8() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX00873cafeac511b8.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX00873cafeac511b8 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.context = PackageDownloadContext.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncParamsX00873cafeac511b8 r100) {
            int r101 = PackageDownloadContext.ADAPTER.encodedSizeWithTag(1, r100.context) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(2, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX00873cafeac511b8 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX00873cafeac511b8 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX00873cafeac511b8 r101) throws IOException {
            PackageDownloadContext.ADAPTER.encodeWithTag(r100, 1, r101.context);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 2, r101.callback);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX00873cafeac511b8 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX00873cafeac511b8();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.context = this.context;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX00873cafeac511b8.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX00873cafeac511b8(PackageDownloadContext r100, MoltenFfiInstanceMsg r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX00873cafeac511b8(PackageDownloadContext r100, MoltenFfiInstanceMsg r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.context = r100;
        this.callback = r101;
        this._molten_ctx = r102;
    }
}
