package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsXec0d742cb23d6d18 extends Message<FuncParamsXec0d742cb23d6d18, Builder> {
    public static final ProtoAdapter<FuncParamsXec0d742cb23d6d18> ADAPTER = null;
    public static final LarkFeedListViewObjectFieldType DEFAULT_FIELD_TYPE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final LarkFeedListViewObjectFieldType field_type;
    public final MoltenFfiInstanceMsg notifier;

    public static final class Builder extends Message.Builder<FuncParamsXec0d742cb23d6d18, Builder> {
        public ByteString _molten_ctx;
        public LarkFeedListViewObjectFieldType field_type;
        public MoltenFfiInstanceMsg notifier;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXec0d742cb23d6d18 build() {
            LarkFeedListViewObjectFieldType r100 = this.field_type;
            if (r100 == null) goto L9;
            if (this.notifier == null) goto L9;
            return new FuncParamsXec0d742cb23d6d18(this.field_type, this.notifier, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "field_type", this.notifier, "notifier"});
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

        public Builder field_type(LarkFeedListViewObjectFieldType r100) {
            this.field_type = r100;
            return this;
        }

        public Builder notifier(MoltenFfiInstanceMsg r100) {
            this.notifier = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXec0d742cb23d6d18 extends ProtoAdapter<FuncParamsXec0d742cb23d6d18> {
        public ProtoAdapter_FuncParamsXec0d742cb23d6d18() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXec0d742cb23d6d18.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsXec0d742cb23d6d18 decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.field_type = LarkFeedListViewObjectFieldType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.notifier = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 255) goto L11;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXec0d742cb23d6d18 r100) {
            int r101 = LarkFeedListViewObjectFieldType.ADAPTER.encodedSizeWithTag(1, r100.field_type) + MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(2, r100.notifier);
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
        public /* bridge */ /* synthetic */ FuncParamsXec0d742cb23d6d18 decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXec0d742cb23d6d18 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXec0d742cb23d6d18 r101) throws IOException {
            LarkFeedListViewObjectFieldType.ADAPTER.encodeWithTag(r100, 1, r101.field_type);
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 2, r101.notifier);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXec0d742cb23d6d18 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXec0d742cb23d6d18();
        DEFAULT_FIELD_TYPE = LarkFeedListViewObjectFieldType.VAR_LARK_FEED_LIST_VIEW_OBJECT_FIELD_TYPE_LOAD_STATUS;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_type = this.field_type;
        r100.notifier = this.notifier;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXec0d742cb23d6d18.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXec0d742cb23d6d18(LarkFeedListViewObjectFieldType r100, MoltenFfiInstanceMsg r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXec0d742cb23d6d18(LarkFeedListViewObjectFieldType r100, MoltenFfiInstanceMsg r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.field_type = r100;
        this.notifier = r101;
        this._molten_ctx = r102;
    }
}
