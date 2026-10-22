package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkFeedListContext extends Message<LarkFeedListContext, Builder> {
    public static final ProtoAdapter<LarkFeedListContext> ADAPTER = null;
    public static final Integer DEFAULT_FILTER_TYPE = null;
    private static final long serialVersionUID = 0;
    public final ForegroundUserContainerScope container_scope;
    public final Integer filter_type;

    public static final class Builder extends Message.Builder<LarkFeedListContext, Builder> {
        public ForegroundUserContainerScope container_scope;
        public Integer filter_type;

        @Override // com.squareup.wire.Message.Builder
        public LarkFeedListContext build() {
            Integer r100 = this.filter_type;
            if (r100 == null) goto L9;
            if (this.container_scope == null) goto L9;
            return new LarkFeedListContext(this.filter_type, this.container_scope, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, EffectConfiguration.KEY_FILTER_TYPE, this.container_scope, "container_scope"});
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

        public Builder filter_type(Integer r100) {
            this.filter_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkFeedListContext extends ProtoAdapter<LarkFeedListContext> {
        public ProtoAdapter_LarkFeedListContext() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkFeedListContext.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkFeedListContext decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.filter_type = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(LarkFeedListContext r100) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r100.filter_type) + ForegroundUserContainerScope.ADAPTER.encodedSizeWithTag(2, r100.container_scope)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkFeedListContext decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkFeedListContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkFeedListContext r101) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.filter_type);
            ForegroundUserContainerScope.ADAPTER.encodeWithTag(r100, 2, r101.container_scope);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkFeedListContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkFeedListContext();
        DEFAULT_FILTER_TYPE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.filter_type = this.filter_type;
        r100.container_scope = this.container_scope;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkFeedListContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkFeedListContext(Integer r100, ForegroundUserContainerScope r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LarkFeedListContext(Integer r100, ForegroundUserContainerScope r101, ByteString r102) {
        super(ADAPTER, r102);
        this.filter_type = r100;
        this.container_scope = r101;
    }
}
