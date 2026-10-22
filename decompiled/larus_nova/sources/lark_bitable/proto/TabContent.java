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
public final class TabContent extends Message<TabContent, Builder> {
    public static final ProtoAdapter<TabContent> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ContentModel main_content;
    public final StageModel stage_content;

    public static final class Builder extends Message.Builder<TabContent, Builder> {
        public ContentModel main_content;
        public StageModel stage_content;

        @Override // com.squareup.wire.Message.Builder
        public TabContent build() {
            return new TabContent(this.stage_content, this.main_content, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder main_content(ContentModel r100) {
            this.main_content = r100;
            this.stage_content = null;
            return this;
        }

        public Builder stage_content(StageModel r100) {
            this.stage_content = r100;
            this.main_content = null;
            return this;
        }
    }

    public static final class ProtoAdapter_TabContent extends ProtoAdapter<TabContent> {
        public ProtoAdapter_TabContent() {
            super(FieldEncoding.LENGTH_DELIMITED, TabContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public TabContent decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.stage_content(StageModel.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.main_content(ContentModel.ADAPTER.decode(r100));
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
        public int encodedSize2(TabContent r100) {
            StageModel r101 = r100.stage_content;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = StageModel.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ContentModel r104 = r100.main_content;
            if (r104 == null) goto L10;
            r102 = ContentModel.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TabContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TabContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TabContent r101) throws IOException {
            StageModel r102 = r101.stage_content;
            if (r102 == null) goto L5;
            StageModel.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ContentModel r103 = r101.main_content;
            if (r103 == null) goto L8;
            ContentModel.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TabContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TabContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.stage_content = this.stage_content;
        r100.main_content = this.main_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TabContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TabContent(StageModel r100, ContentModel r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TabContent(StageModel r100, ContentModel r101, ByteString r102) {
        super(ADAPTER, r102);
        if (Internal.countNonNull(r100, r101) > 1) goto L7;
        this.stage_content = r100;
        this.main_content = r101;
        return;
    L7:
        throw new IllegalArgumentException("at most one of stage_content, main_content may be non-null");
    }
}
