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
public final class MessageAnalysisContent extends com.squareup.wire.Message<MessageAnalysisContent, Builder> {
    public static final ProtoAdapter<MessageAnalysisContent> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Boolean DEFAULT_IS_CLOSED = null;
    public static final String DEFAULT_JUMP_URL = "";
    private static final long serialVersionUID = 0;
    public final List<Button> button;
    public final String content;
    public final Boolean is_closed;
    public final String jump_url;
    public final RichText rich_text;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageAnalysisContent, Builder> {
        public List<Button> button;
        public String content;
        public Boolean is_closed;
        public String jump_url;
        public RichText rich_text;

        @Override // com.squareup.wire.Message.Builder
        public MessageAnalysisContent build() {
            return new MessageAnalysisContent(this.content, this.jump_url, this.rich_text, this.button, this.is_closed, super.buildUnknownFields());
        }

        public Builder() {
            this.button = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder button(List<Button> r100) {
            Internal.checkElementsNotNull(r100);
            this.button = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder is_closed(Boolean r100) {
            this.is_closed = r100;
            return this;
        }

        public Builder jump_url(String r100) {
            this.jump_url = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageAnalysisContent extends ProtoAdapter<MessageAnalysisContent> {
        public ProtoAdapter_MessageAnalysisContent() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageAnalysisContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageAnalysisContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.content = "";
            r101.jump_url = "";
            r101.is_closed = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.jump_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.button.add(Button.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.is_closed = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(MessageAnalysisContent r100) {
            String r101 = r100.content;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.jump_url;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            RichText r107 = r100.rich_text;
            if (r107 == null) goto L13;
            int r108 = RichText.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + Button.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.button);
            Boolean r110 = r100.is_closed;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
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
        public /* bridge */ /* synthetic */ MessageAnalysisContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageAnalysisContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageAnalysisContent r101) throws IOException {
            String r102 = r101.content;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.jump_url;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            RichText r104 = r101.rich_text;
            if (r104 == null) goto L11;
            RichText.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Button.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.button);
            Boolean r105 = r101.is_closed;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageAnalysisContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageAnalysisContent();
        DEFAULT_IS_CLOSED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.content = this.content;
        r100.jump_url = this.jump_url;
        r100.rich_text = this.rich_text;
        r100.button = Internal.copyOf("button", this.button);
        r100.is_closed = this.is_closed;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageAnalysisContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageAnalysisContent(String r100, String r101, RichText r110, List<Button> r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MessageAnalysisContent(String r100, String r101, RichText r102, List<Button> r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.content = r100;
        this.jump_url = r101;
        this.rich_text = r102;
        this.button = Internal.immutableCopyOf("button", r103);
        this.is_closed = r104;
    }
}
