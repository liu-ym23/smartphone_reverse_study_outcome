package open_pkm.proto;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX883a468efe0afc17 extends Message<FuncParamsX883a468efe0afc17, Builder> {
    public static final ProtoAdapter<FuncParamsX883a468efe0afc17> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final UniqueId unique_id;

    public static final class Builder extends Message.Builder<FuncParamsX883a468efe0afc17, Builder> {
        public ByteString _molten_ctx;
        public UniqueId unique_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX883a468efe0afc17 build() {
            UniqueId r100 = this.unique_id;
            if (r100 == null) goto L7;
            return new FuncParamsX883a468efe0afc17(this.unique_id, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, BdpAppEventConstant.PARAMS_UNIQUEID});
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

        public Builder unique_id(UniqueId r100) {
            this.unique_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX883a468efe0afc17 extends ProtoAdapter<FuncParamsX883a468efe0afc17> {
        public ProtoAdapter_FuncParamsX883a468efe0afc17() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX883a468efe0afc17.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX883a468efe0afc17 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.unique_id = UniqueId.ADAPTER.decode(r100);
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
        public int encodedSize2(FuncParamsX883a468efe0afc17 r100) {
            int r101 = UniqueId.ADAPTER.encodedSizeWithTag(1, r100.unique_id);
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
        public /* bridge */ /* synthetic */ FuncParamsX883a468efe0afc17 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX883a468efe0afc17 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX883a468efe0afc17 r101) throws IOException {
            UniqueId.ADAPTER.encodeWithTag(r100, 1, r101.unique_id);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX883a468efe0afc17 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX883a468efe0afc17();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_id = this.unique_id;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX883a468efe0afc17.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX883a468efe0afc17(UniqueId r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX883a468efe0afc17(UniqueId r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.unique_id = r100;
        this._molten_ctx = r101;
    }
}
