package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageAnalysisConfig extends com.squareup.wire.Message<MessageAnalysisConfig, Builder> {
    public static final ProtoAdapter<MessageAnalysisConfig> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_HAS_CONFIG = null;
    private static final long serialVersionUID = 0;
    public final List<MessageAnalysisItem> analysis_items;
    public final MessageAnalysisContent content;
    public final String description;
    public final Boolean has_config;
    public final MessageAnalysisItem title_item;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageAnalysisConfig, Builder> {
        public List<MessageAnalysisItem> analysis_items;
        public MessageAnalysisContent content;
        public String description;
        public Boolean has_config;
        public MessageAnalysisItem title_item;

        @Override // com.squareup.wire.Message.Builder
        public MessageAnalysisConfig build() {
            return new MessageAnalysisConfig(this.title_item, this.description, this.analysis_items, this.has_config, this.content, super.buildUnknownFields());
        }

        public Builder() {
            this.analysis_items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder analysis_items(List<MessageAnalysisItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.analysis_items = r100;
            return this;
        }

        public Builder content(MessageAnalysisContent r100) {
            this.content = r100;
            return this;
        }

        public Builder description(String r100) {
            this.description = r100;
            return this;
        }

        public Builder has_config(Boolean r100) {
            this.has_config = r100;
            return this;
        }

        public Builder title_item(MessageAnalysisItem r100) {
            this.title_item = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageAnalysisConfig extends ProtoAdapter<MessageAnalysisConfig> {
        public ProtoAdapter_MessageAnalysisConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageAnalysisConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageAnalysisConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.description = "";
            r101.has_config = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.title_item = MessageAnalysisItem.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.description = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.analysis_items.add(MessageAnalysisItem.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.has_config = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.content = MessageAnalysisContent.ADAPTER.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MessageAnalysisConfig r100) {
            MessageAnalysisItem r101 = r100.title_item;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MessageAnalysisItem.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.description;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + MessageAnalysisItem.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.analysis_items);
            Boolean r107 = r100.has_config;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            MessageAnalysisContent r110 = r100.content;
            if (r110 == null) goto L18;
            r102 = MessageAnalysisContent.ADAPTER.encodedSizeWithTag(5, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageAnalysisConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageAnalysisConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageAnalysisConfig r101) throws IOException {
            MessageAnalysisItem r102 = r101.title_item;
            if (r102 == null) goto L5;
            MessageAnalysisItem.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.description;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            MessageAnalysisItem.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.analysis_items);
            Boolean r104 = r101.has_config;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            MessageAnalysisContent r105 = r101.content;
            if (r105 == null) goto L14;
            MessageAnalysisContent.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageAnalysisConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageAnalysisConfig();
        DEFAULT_HAS_CONFIG = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.title_item = this.title_item;
        r100.description = this.description;
        r100.analysis_items = Internal.copyOf("analysis_items", this.analysis_items);
        r100.has_config = this.has_config;
        r100.content = this.content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageAnalysisConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageAnalysisConfig(MessageAnalysisItem r100, String r101, List<MessageAnalysisItem> r110, Boolean r111, MessageAnalysisContent r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MessageAnalysisConfig(MessageAnalysisItem r100, String r101, List<MessageAnalysisItem> r102, Boolean r103, MessageAnalysisContent r104, ByteString r105) {
        super(ADAPTER, r105);
        this.title_item = r100;
        this.description = r101;
        this.analysis_items = Internal.immutableCopyOf("analysis_items", r102);
        this.has_config = r103;
        this.content = r104;
    }
}
