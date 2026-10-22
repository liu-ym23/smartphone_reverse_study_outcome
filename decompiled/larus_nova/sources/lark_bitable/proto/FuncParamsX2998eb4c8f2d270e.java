package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX2998eb4c8f2d270e extends Message<FuncParamsX2998eb4c8f2d270e, Builder> {
    public static final ProtoAdapter<FuncParamsX2998eb4c8f2d270e> ADAPTER = null;
    public static final Integer DEFAULT_FEED_TAB_COUNT = null;
    public static final Integer DEFAULT_HOMEPAGE_TAB_COUNT = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Integer feed_tab_count;
    public final Integer homepage_tab_count;

    public static final class Builder extends Message.Builder<FuncParamsX2998eb4c8f2d270e, Builder> {
        public ByteString _molten_ctx;
        public Integer feed_tab_count;
        public Integer homepage_tab_count;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX2998eb4c8f2d270e build() {
            Integer r100 = this.homepage_tab_count;
            if (r100 == null) goto L9;
            if (this.feed_tab_count == null) goto L9;
            return new FuncParamsX2998eb4c8f2d270e(this.homepage_tab_count, this.feed_tab_count, this._molten_ctx, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "homepage_tab_count", this.feed_tab_count, "feed_tab_count"});
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

        public Builder feed_tab_count(Integer r100) {
            this.feed_tab_count = r100;
            return this;
        }

        public Builder homepage_tab_count(Integer r100) {
            this.homepage_tab_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX2998eb4c8f2d270e extends ProtoAdapter<FuncParamsX2998eb4c8f2d270e> {
        public ProtoAdapter_FuncParamsX2998eb4c8f2d270e() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX2998eb4c8f2d270e.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX2998eb4c8f2d270e decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.homepage_tab_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.feed_tab_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(FuncParamsX2998eb4c8f2d270e r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            int r102 = r101.encodedSizeWithTag(1, r100.homepage_tab_count) + r101.encodedSizeWithTag(2, r100.feed_tab_count);
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
        public /* bridge */ /* synthetic */ FuncParamsX2998eb4c8f2d270e decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX2998eb4c8f2d270e r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX2998eb4c8f2d270e r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.homepage_tab_count);
            r102.encodeWithTag(r100, 2, r101.feed_tab_count);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX2998eb4c8f2d270e r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX2998eb4c8f2d270e();
        DEFAULT_HOMEPAGE_TAB_COUNT = 0;
        DEFAULT_FEED_TAB_COUNT = 0;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.homepage_tab_count = this.homepage_tab_count;
        r100.feed_tab_count = this.feed_tab_count;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX2998eb4c8f2d270e.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX2998eb4c8f2d270e(Integer r100, Integer r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsX2998eb4c8f2d270e(Integer r100, Integer r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.homepage_tab_count = r100;
        this.feed_tab_count = r101;
        this._molten_ctx = r102;
    }
}
