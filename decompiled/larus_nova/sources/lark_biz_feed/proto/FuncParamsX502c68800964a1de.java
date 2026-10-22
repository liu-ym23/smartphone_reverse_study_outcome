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
public final class FuncParamsX502c68800964a1de extends Message<FuncParamsX502c68800964a1de, Builder> {
    public static final ProtoAdapter<FuncParamsX502c68800964a1de> ADAPTER = null;
    public static final LarkFeedListViewObjectLiveQueryFieldType DEFAULT_FIELD_TYPE = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final LarkFeedListViewObjectLiveQueryFieldType field_type;

    public static final class Builder extends Message.Builder<FuncParamsX502c68800964a1de, Builder> {
        public ByteString _molten_ctx;
        public LarkFeedListViewObjectLiveQueryFieldType field_type;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX502c68800964a1de build() {
            LarkFeedListViewObjectLiveQueryFieldType r100 = this.field_type;
            if (r100 == null) goto L7;
            return new FuncParamsX502c68800964a1de(this.field_type, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "field_type"});
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

        public Builder field_type(LarkFeedListViewObjectLiveQueryFieldType r100) {
            this.field_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX502c68800964a1de extends ProtoAdapter<FuncParamsX502c68800964a1de> {
        public ProtoAdapter_FuncParamsX502c68800964a1de() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX502c68800964a1de.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX502c68800964a1de decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.field_type = LarkFeedListViewObjectLiveQueryFieldType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 255) goto L9;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX502c68800964a1de r100) {
            int r101 = LarkFeedListViewObjectLiveQueryFieldType.ADAPTER.encodedSizeWithTag(1, r100.field_type);
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
        public /* bridge */ /* synthetic */ FuncParamsX502c68800964a1de decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX502c68800964a1de r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX502c68800964a1de r101) throws IOException {
            LarkFeedListViewObjectLiveQueryFieldType.ADAPTER.encodeWithTag(r100, 1, r101.field_type);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX502c68800964a1de r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX502c68800964a1de();
        DEFAULT_FIELD_TYPE = LarkFeedListViewObjectLiveQueryFieldType.VAR_LARK_FEED_LIST_VIEW_OBJECT_LIVE_QUERY_FIELD_TYPE_FEED_LIST;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_type = this.field_type;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX502c68800964a1de.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX502c68800964a1de(LarkFeedListViewObjectLiveQueryFieldType r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX502c68800964a1de(LarkFeedListViewObjectLiveQueryFieldType r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.field_type = r100;
        this._molten_ctx = r101;
    }
}
