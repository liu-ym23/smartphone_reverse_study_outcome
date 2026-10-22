package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX0919def174cd15cf extends Message<FuncParamsX0919def174cd15cf, Builder> {
    public static final ProtoAdapter<FuncParamsX0919def174cd15cf> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final Map<String, String> params;

    public static final class Builder extends Message.Builder<FuncParamsX0919def174cd15cf, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public Map<String, String> params;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX0919def174cd15cf build() {
            MoltenFfiInstanceMsg r100 = this.callback;
            if (r100 == null) goto L7;
            return new FuncParamsX0919def174cd15cf(this.params, this.callback, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "callback"});
        }

        public Builder() {
            this.params = Internal.newMutableMap();
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

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX0919def174cd15cf extends ProtoAdapter<FuncParamsX0919def174cd15cf> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_FuncParamsX0919def174cd15cf() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX0919def174cd15cf.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX0919def174cd15cf decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.params.putAll(this.params.decode(r100));
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
        public int encodedSize2(FuncParamsX0919def174cd15cf r100) {
            int r101 = this.params.encodedSizeWithTag(1, r100.params) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(2, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX0919def174cd15cf decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX0919def174cd15cf r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX0919def174cd15cf r101) throws IOException {
            this.params.encodeWithTag(r100, 1, r101.params);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 2, r101.callback);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX0919def174cd15cf r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX0919def174cd15cf();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.params = Internal.copyOf("params", this.params);
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX0919def174cd15cf.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX0919def174cd15cf(Map<String, String> r100, MoltenFfiInstanceMsg r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX0919def174cd15cf(Map<String, String> r100, MoltenFfiInstanceMsg r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.params = Internal.immutableCopyOf("params", r100);
        this.callback = r101;
        this._molten_ctx = r102;
    }
}
