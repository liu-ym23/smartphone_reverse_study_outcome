package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class TranslateMessagesV3Request extends Message<TranslateMessagesV3Request, Builder> {
    public static final ProtoAdapter<TranslateMessagesV3Request> ADAPTER = null;
    public static final Boolean DEFAULT_IS_FROM_MESSAGE_UPDATE = null;
    public static final Boolean DEFAULT_IS_TRANSLATE_BY_USER = null;
    public static final ProtoAdapter_TranslateMessagesV3Request RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_from_message_update;
    public final Boolean is_translate_by_user;
    public final List<TranslateMessageContext> translate_contexts;

    public static final class Builder extends Message.Builder<TranslateMessagesV3Request, Builder> implements d<TranslateMessagesV3Request> {
        public Boolean is_from_message_update;
        public Boolean is_translate_by_user;
        public List<TranslateMessageContext> translate_contexts;

        @Override // com.squareup.wire.Message.Builder
        public TranslateMessagesV3Request build() {
            Boolean r100 = this.is_translate_by_user;
            if (r100 == null) goto L7;
            return new TranslateMessagesV3Request(this.translate_contexts, this.is_translate_by_user, this.is_from_message_update, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_translate_by_user"});
        }

        public Builder() {
            this.translate_contexts = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_from_message_update(Boolean r100) {
            this.is_from_message_update = r100;
            return this;
        }

        public Builder is_translate_by_user(Boolean r100) {
            this.is_translate_by_user = r100;
            return this;
        }

        public Builder translate_contexts(List<TranslateMessageContext> r100) {
            Internal.checkElementsNotNull(r100);
            this.translate_contexts = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateMessagesV3Request extends ProtoAdapter<TranslateMessagesV3Request> implements c<TranslateMessagesV3Request> {
        public ProtoAdapter_TranslateMessagesV3Request() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateMessagesV3Request.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateMessagesV3Request decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_translate_by_user = r102;
            r101.is_from_message_update = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.translate_contexts.add(TranslateMessageContext.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_translate_by_user = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.is_from_message_update = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TranslateMessagesV3Request r100) {
            int r101 = TranslateMessageContext.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.translate_contexts);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.is_translate_by_user);
            Boolean r104 = r100.is_from_message_update;
            if (r104 == null) goto L5;
            int r105 = r102.encodedSizeWithTag(3, r104);
        L7:
            return (r103 + r105) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateMessagesV3Request decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateMessagesV3Request r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateMessagesV3Request r101) throws IOException {
            TranslateMessageContext.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.translate_contexts);
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 2, r101.is_translate_by_user);
            Boolean r103 = r101.is_from_message_update;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateMessagesV3Request r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TranslateMessagesV3Request r100 = new ProtoAdapter_TranslateMessagesV3Request();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_TRANSLATE_BY_USER = r101;
        DEFAULT_IS_FROM_MESSAGE_UPDATE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.translate_contexts = Internal.copyOf("translate_contexts", this.translate_contexts);
        r100.is_translate_by_user = this.is_translate_by_user;
        r100.is_from_message_update = this.is_from_message_update;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateMessagesV3Request.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateMessagesV3Request(List<TranslateMessageContext> r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TranslateMessagesV3Request(List<TranslateMessageContext> r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.translate_contexts = Internal.immutableCopyOf("translate_contexts", r100);
        this.is_translate_by_user = r101;
        this.is_from_message_update = r102;
    }
}
