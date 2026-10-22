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
public final class TranslateError extends Message<TranslateError, Builder> {
    public static final ProtoAdapter<TranslateError> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_ERROR_MSG = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Long error_code;
    public final String error_msg;
    public final String message_id;
    public final MessageSource message_source;

    public static final class Builder extends Message.Builder<TranslateError, Builder> {
        public String chat_id;
        public Long error_code;
        public String error_msg;
        public String message_id;
        public MessageSource message_source;

        @Override // com.squareup.wire.Message.Builder
        public TranslateError build() {
            String r100 = this.message_id;
            if (r100 == null) goto L11;
            if (this.message_source == null) goto L11;
            if (this.error_code == null) goto L11;
            return new TranslateError(this.message_id, this.message_source, this.chat_id, this.error_code, this.error_msg, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.message_source, "message_source", this.error_code, "error_code"});
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

        public Builder error_code(Long r100) {
            this.error_code = r100;
            return this;
        }

        public Builder error_msg(String r100) {
            this.error_msg = r100;
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

    public static final class ProtoAdapter_TranslateError extends ProtoAdapter<TranslateError> {
        public ProtoAdapter_TranslateError() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateError.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateError decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.chat_id = "";
            r101.error_code = 0L;
            r101.error_msg = "";
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
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.error_code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.error_msg = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(TranslateError r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.message_id) + MessageSource.ADAPTER.encodedSizeWithTag(2, r100.message_source);
            String r103 = r100.chat_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = (r102 + r105) + ProtoAdapter.INT64.encodedSizeWithTag(4, r100.error_code);
            String r107 = r100.error_msg;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(5, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateError decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateError r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateError r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            MessageSource.ADAPTER.encodeWithTag(r100, 2, r101.message_source);
            String r103 = r101.chat_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r101.error_code);
            String r104 = r101.error_msg;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateError r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TranslateError();
        DEFAULT_ERROR_CODE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.message_source = this.message_source;
        r100.chat_id = this.chat_id;
        r100.error_code = this.error_code;
        r100.error_msg = this.error_msg;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateError.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateError(String r100, MessageSource r101, String r110, Long r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TranslateError(String r100, MessageSource r101, String r102, Long r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.message_id = r100;
        this.message_source = r101;
        this.chat_id = r102;
        this.error_code = r103;
        this.error_msg = r104;
    }
}
