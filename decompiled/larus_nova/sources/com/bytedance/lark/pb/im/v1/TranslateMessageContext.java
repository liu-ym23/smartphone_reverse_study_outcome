package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslateMessageContext extends Message<TranslateMessageContext, Builder> {
    public static final ProtoAdapter<TranslateMessageContext> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_MANUAL_TARGET_LANGUAGE = "";
    public static final Integer DEFAULT_MESSAGE_CONTENT_VERSION = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final String manual_target_language;
    public final Integer message_content_version;
    public final String message_id;
    public final MessageSource message_source;

    public static final class Builder extends Message.Builder<TranslateMessageContext, Builder> {
        public String chat_id;
        public String manual_target_language;
        public Integer message_content_version;
        public String message_id;
        public MessageSource message_source;

        @Override // com.squareup.wire.Message.Builder
        public TranslateMessageContext build() {
            String r100 = this.message_id;
            if (r100 == null) goto L9;
            if (this.chat_id == null) goto L9;
            return new TranslateMessageContext(this.message_id, this.message_source, this.manual_target_language, this.chat_id, this.message_content_version, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.chat_id, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder manual_target_language(String r100) {
            this.manual_target_language = r100;
            return this;
        }

        public Builder message_content_version(Integer r100) {
            this.message_content_version = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder message_source(MessageSource r100) {
            this.message_source = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateMessageContext extends ProtoAdapter<TranslateMessageContext> {
        public ProtoAdapter_TranslateMessageContext() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateMessageContext.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateMessageContext decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.manual_target_language = "";
            r101.chat_id = "";
            r101.message_content_version = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.message_source = MessageSource.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.manual_target_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.message_content_version = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(TranslateMessageContext r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.message_id);
            MessageSource r103 = r100.message_source;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = MessageSource.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.manual_target_language;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = (r106 + r108) + r101.encodedSizeWithTag(4, r100.chat_id);
            Integer r110 = r100.message_content_version;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateMessageContext decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateMessageContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateMessageContext r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            MessageSource r103 = r101.message_source;
            if (r103 == null) goto L5;
            MessageSource.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.manual_target_language;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r102.encodeWithTag(r100, 4, r101.chat_id);
            Integer r105 = r101.message_content_version;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateMessageContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TranslateMessageContext();
        DEFAULT_MESSAGE_CONTENT_VERSION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.message_source = this.message_source;
        r100.manual_target_language = this.manual_target_language;
        r100.chat_id = this.chat_id;
        r100.message_content_version = this.message_content_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateMessageContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateMessageContext(String r100, MessageSource r101, String r110, String r111, Integer r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TranslateMessageContext(String r100, MessageSource r101, String r102, String r103, Integer r104, ByteString r105) {
        super(ADAPTER, r105);
        this.message_id = r100;
        this.message_source = r101;
        this.manual_target_language = r102;
        this.chat_id = r103;
        this.message_content_version = r104;
    }
}
