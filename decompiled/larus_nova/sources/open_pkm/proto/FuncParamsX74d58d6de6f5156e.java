package open_pkm.proto;

import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
public final class FuncParamsX74d58d6de6f5156e extends Message<FuncParamsX74d58d6de6f5156e, Builder> {
    public static final ProtoAdapter<FuncParamsX74d58d6de6f5156e> ADAPTER = null;
    public static final Boolean DEFAULT_IS_PREVIEW = null;
    public static final PkmStrategy DEFAULT_STRATEGY = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final MoltenFfiInstanceMsg callback;
    public final Map<String, String> ex_data;
    public final Boolean is_preview;
    public final PkmStrategy strategy;
    public final UniqueId unique_id;

    public static final class Builder extends Message.Builder<FuncParamsX74d58d6de6f5156e, Builder> {
        public ByteString _molten_ctx;
        public MoltenFfiInstanceMsg callback;
        public Map<String, String> ex_data;
        public Boolean is_preview;
        public PkmStrategy strategy;
        public UniqueId unique_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX74d58d6de6f5156e build() {
            UniqueId r100 = this.unique_id;
            if (r100 == null) goto L13;
            if (this.strategy == null) goto L13;
            if (this.is_preview == null) goto L13;
            if (this.callback == null) goto L13;
            return new FuncParamsX74d58d6de6f5156e(this.unique_id, this.strategy, this.is_preview, this.ex_data, this.callback, this._molten_ctx, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, BdpAppEventConstant.PARAMS_UNIQUEID, this.strategy, BdpAppEventConstant.PARAMS_STRATEGY_NAME, this.is_preview, VrBgLogData.KEY_IS_PREVIEW, this.callback, "callback"});
        }

        public Builder() {
            this.ex_data = Internal.newMutableMap();
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

        public Builder ex_data(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ex_data = r100;
            return this;
        }

        public Builder is_preview(Boolean r100) {
            this.is_preview = r100;
            return this;
        }

        public Builder strategy(PkmStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder unique_id(UniqueId r100) {
            this.unique_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX74d58d6de6f5156e extends ProtoAdapter<FuncParamsX74d58d6de6f5156e> {
        private final ProtoAdapter<Map<String, String>> ex_data;

        public ProtoAdapter_FuncParamsX74d58d6de6f5156e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX74d58d6de6f5156e.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.ex_data = ProtoAdapter.newMapAdapter(r100, r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX74d58d6de6f5156e decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.unique_id = UniqueId.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.strategy = PkmStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.ex_data.putAll(this.ex_data.decode(r100));
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
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX74d58d6de6f5156e r100) {
            int r101 = (((UniqueId.ADAPTER.encodedSizeWithTag(1, r100.unique_id) + PkmStrategy.ADAPTER.encodedSizeWithTag(2, r100.strategy)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r100.is_preview)) + this.ex_data.encodedSizeWithTag(4, r100.ex_data)) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(5, r100.callback);
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
        public /* bridge */ /* synthetic */ FuncParamsX74d58d6de6f5156e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX74d58d6de6f5156e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX74d58d6de6f5156e r101) throws IOException {
            UniqueId.ADAPTER.encodeWithTag(r100, 1, r101.unique_id);
            PkmStrategy.ADAPTER.encodeWithTag(r100, 2, r101.strategy);
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r101.is_preview);
            this.ex_data.encodeWithTag(r100, 4, r101.ex_data);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 5, r101.callback);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX74d58d6de6f5156e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX74d58d6de6f5156e();
        DEFAULT_STRATEGY = PkmStrategy.VAR_PKM_STRATEGY_TRY_REMOTE_AND_UPDATE_ASYNC;
        DEFAULT_IS_PREVIEW = Boolean.FALSE;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.unique_id = this.unique_id;
        r100.strategy = this.strategy;
        r100.is_preview = this.is_preview;
        r100.ex_data = Internal.copyOf("ex_data", this.ex_data);
        r100.callback = this.callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX74d58d6de6f5156e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX74d58d6de6f5156e(UniqueId r100, PkmStrategy r110, Boolean r111, Map<String, String> r112, MoltenFfiInstanceMsg r113, ByteString r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public FuncParamsX74d58d6de6f5156e(UniqueId r100, PkmStrategy r101, Boolean r102, Map<String, String> r103, MoltenFfiInstanceMsg r104, ByteString r105, ByteString r106) {
        super(ADAPTER, r106);
        this.unique_id = r100;
        this.strategy = r101;
        this.is_preview = r102;
        this.ex_data = Internal.immutableCopyOf("ex_data", r103);
        this.callback = r104;
        this._molten_ctx = r105;
    }
}
