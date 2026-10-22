package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslateChatNameRequest extends Message<TranslateChatNameRequest, Builder> {
    public static final ProtoAdapter<TranslateChatNameRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Boolean DEFAULT_IS_MANUAL = null;
    public static final Boolean DEFAULT_IS_SWITCH_LANGUAGE = null;
    public static final String DEFAULT_TARGET_LANGUAGE = "";
    public static final ProtoAdapter_TranslateChatNameRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final Boolean is_manual;
    public final Boolean is_switch_language;
    public final String target_language;

    public static final class Builder extends Message.Builder<TranslateChatNameRequest, Builder> implements d<TranslateChatNameRequest> {
        public Long chat_id;
        public Boolean is_manual;
        public Boolean is_switch_language;
        public String target_language;

        @Override // com.squareup.wire.Message.Builder
        public TranslateChatNameRequest build() {
            return new TranslateChatNameRequest(this.chat_id, this.is_manual, this.target_language, this.is_switch_language, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder is_manual(Boolean r100) {
            this.is_manual = r100;
            return this;
        }

        public Builder is_switch_language(Boolean r100) {
            this.is_switch_language = r100;
            return this;
        }

        public Builder target_language(String r100) {
            this.target_language = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateChatNameRequest extends ProtoAdapter<TranslateChatNameRequest> implements c<TranslateChatNameRequest> {
        public ProtoAdapter_TranslateChatNameRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateChatNameRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateChatNameRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.is_manual = r102;
            r101.target_language = "";
            r101.is_switch_language = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_manual = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.target_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.is_switch_language = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TranslateChatNameRequest r100) {
            Long r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_manual;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.target_language;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_switch_language;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ TranslateChatNameRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateChatNameRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateChatNameRequest r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_manual;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.target_language;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_switch_language;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateChatNameRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TranslateChatNameRequest r100 = new ProtoAdapter_TranslateChatNameRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_ID = 0L;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_MANUAL = r101;
        DEFAULT_IS_SWITCH_LANGUAGE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.is_manual = this.is_manual;
        r100.target_language = this.target_language;
        r100.is_switch_language = this.is_switch_language;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateChatNameRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateChatNameRequest(Long r100, Boolean r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TranslateChatNameRequest(Long r100, Boolean r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_id = r100;
        this.is_manual = r101;
        this.target_language = r102;
        this.is_switch_language = r103;
    }
}
