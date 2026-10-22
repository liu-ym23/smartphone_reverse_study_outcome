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
public final class FuncParamsX6c9c09bd3ecddfc3 extends Message<FuncParamsX6c9c09bd3ecddfc3, Builder> {
    public static final ProtoAdapter<FuncParamsX6c9c09bd3ecddfc3> ADAPTER = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final MetaInfo current_meta;
    public final UniqueId unique_id;

    public static final class Builder extends Message.Builder<FuncParamsX6c9c09bd3ecddfc3, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public MetaInfo current_meta;
        public UniqueId unique_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX6c9c09bd3ecddfc3 build() {
            UniqueId r100 = this.unique_id;
            if (r100 == null) goto L11;
            if (this.current_meta == null) goto L11;
            if (this.callback == null) goto L11;
            return new FuncParamsX6c9c09bd3ecddfc3(this.unique_id, this.current_meta, this.callback, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, BdpAppEventConstant.PARAMS_UNIQUEID, this.current_meta, "current_meta", this.callback, "callback"});
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

        public Builder current_meta(MetaInfo r100) {
            this.current_meta = r100;
            return this;
        }

        public Builder unique_id(UniqueId r100) {
            this.unique_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX6c9c09bd3ecddfc3 extends ProtoAdapter<FuncParamsX6c9c09bd3ecddfc3> {
        public ProtoAdapter_FuncParamsX6c9c09bd3ecddfc3() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX6c9c09bd3ecddfc3.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX6c9c09bd3ecddfc3 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.unique_id = UniqueId.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.current_meta = MetaInfo.ADAPTER.decode(r100);
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
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX6c9c09bd3ecddfc3 r100) {
            int r101 = (UniqueId.ADAPTER.encodedSizeWithTag(1, r100.unique_id) + MetaInfo.ADAPTER.encodedSizeWithTag(2, r100.current_meta)) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(3, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX6c9c09bd3ecddfc3 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX6c9c09bd3ecddfc3 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX6c9c09bd3ecddfc3 r101) throws IOException {
            UniqueId.ADAPTER.encodeWithTag(r100, 1, r101.unique_id);
            MetaInfo.ADAPTER.encodeWithTag(r100, 2, r101.current_meta);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 3, r101.callback);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX6c9c09bd3ecddfc3 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX6c9c09bd3ecddfc3();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_id = this.unique_id;
        r100.current_meta = this.current_meta;
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX6c9c09bd3ecddfc3.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX6c9c09bd3ecddfc3(UniqueId r100, MetaInfo r101, MoltenFfiInstanceMsg r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FuncParamsX6c9c09bd3ecddfc3(UniqueId r100, MetaInfo r101, MoltenFfiInstanceMsg r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.unique_id = r100;
        this.current_meta = r101;
        this.callback = r102;
        this._molten_ctx = r103;
    }
}
