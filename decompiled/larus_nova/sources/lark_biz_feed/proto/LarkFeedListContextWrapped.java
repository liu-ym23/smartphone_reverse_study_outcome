package lark_biz_feed.proto;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkFeedListContextWrapped extends Message<LarkFeedListContextWrapped, Builder> {
    public static final ProtoAdapter<LarkFeedListContextWrapped> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ForegroundUserContainerScope container_scope;
    public final LarkFeedListContext inner;

    public static final class Builder extends Message.Builder<LarkFeedListContextWrapped, Builder> {
        public ForegroundUserContainerScope container_scope;
        public LarkFeedListContext inner;

        @Override // com.squareup.wire.Message.Builder
        public LarkFeedListContextWrapped build() {
            LarkFeedListContext r100 = this.inner;
            if (r100 == null) goto L9;
            if (this.container_scope == null) goto L9;
            return new LarkFeedListContextWrapped(this.inner, this.container_scope, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, RNParamRegisterEventHandler.SRC_INNER, this.container_scope, "container_scope"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_scope(ForegroundUserContainerScope r100) {
            this.container_scope = r100;
            return this;
        }

        public Builder inner(LarkFeedListContext r100) {
            this.inner = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkFeedListContextWrapped extends ProtoAdapter<LarkFeedListContextWrapped> {
        public ProtoAdapter_LarkFeedListContextWrapped() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkFeedListContextWrapped.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkFeedListContextWrapped decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.inner = LarkFeedListContext.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.container_scope = ForegroundUserContainerScope.ADAPTER.decode(r100);
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
        public int encodedSize2(LarkFeedListContextWrapped r100) {
            return (LarkFeedListContext.ADAPTER.encodedSizeWithTag(1, r100.inner) + ForegroundUserContainerScope.ADAPTER.encodedSizeWithTag(2, r100.container_scope)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkFeedListContextWrapped decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkFeedListContextWrapped r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkFeedListContextWrapped r101) throws IOException {
            LarkFeedListContext.ADAPTER.encodeWithTag(r100, 1, r101.inner);
            ForegroundUserContainerScope.ADAPTER.encodeWithTag(r100, 2, r101.container_scope);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkFeedListContextWrapped r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkFeedListContextWrapped();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.inner = this.inner;
        r100.container_scope = this.container_scope;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkFeedListContextWrapped.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkFeedListContextWrapped(LarkFeedListContext r100, ForegroundUserContainerScope r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LarkFeedListContextWrapped(LarkFeedListContext r100, ForegroundUserContainerScope r101, ByteString r102) {
        super(ADAPTER, r102);
        this.inner = r100;
        this.container_scope = r101;
    }
}
