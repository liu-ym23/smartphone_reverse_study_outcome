package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.MessageSource;
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
public final class TranslateMessagesV3Response extends Message<TranslateMessagesV3Response, Builder> {
    public static final ProtoAdapter<TranslateMessagesV3Response> ADAPTER = null;
    public static final ProtoAdapter_TranslateMessagesV3Response RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Entity entities;
    public final List<String> message_ids;
    public final List<MessageSource> message_sources;
    public final List<TranslateError> translate_errors;
    public final List<String> translated_message_ids;
    public final List<MessageSource> translated_message_sources;

    public static final class Builder extends Message.Builder<TranslateMessagesV3Response, Builder> implements d<TranslateMessagesV3Response> {
        public Entity entities;
        public List<String> message_ids;
        public List<MessageSource> message_sources;
        public List<TranslateError> translate_errors;
        public List<String> translated_message_ids;
        public List<MessageSource> translated_message_sources;

        @Override // com.squareup.wire.Message.Builder
        public TranslateMessagesV3Response build() {
            Entity r100 = this.entities;
            if (r100 == null) goto L7;
            return new TranslateMessagesV3Response(this.message_ids, this.message_sources, this.translated_message_ids, this.entities, this.translate_errors, this.translated_message_sources, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "entities"});
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
            this.message_sources = Internal.newMutableList();
            this.translated_message_ids = Internal.newMutableList();
            this.translate_errors = Internal.newMutableList();
            this.translated_message_sources = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entities(Entity r100) {
            this.entities = r100;
            return this;
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }

        public Builder message_sources(List<MessageSource> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_sources = r100;
            return this;
        }

        public Builder translate_errors(List<TranslateError> r100) {
            Internal.checkElementsNotNull(r100);
            this.translate_errors = r100;
            return this;
        }

        public Builder translated_message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.translated_message_ids = r100;
            return this;
        }

        public Builder translated_message_sources(List<MessageSource> r100) {
            Internal.checkElementsNotNull(r100);
            this.translated_message_sources = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TranslateMessagesV3Response extends ProtoAdapter<TranslateMessagesV3Response> implements c<TranslateMessagesV3Response> {
        public ProtoAdapter_TranslateMessagesV3Response() {
            super(FieldEncoding.LENGTH_DELIMITED, TranslateMessagesV3Response.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TranslateMessagesV3Response decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.translated_message_sources.add(MessageSource.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.translate_errors.add(TranslateError.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.entities = Entity.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.translated_message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.message_sources.add(MessageSource.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TranslateMessagesV3Response r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.message_ids);
            ProtoAdapter<MessageSource> r103 = MessageSource.ADAPTER;
            return (((((r102 + r103.asRepeated().encodedSizeWithTag(2, r100.message_sources)) + r101.asRepeated().encodedSizeWithTag(3, r100.translated_message_ids)) + Entity.ADAPTER.encodedSizeWithTag(4, r100.entities)) + TranslateError.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.translate_errors)) + r103.asRepeated().encodedSizeWithTag(6, r100.translated_message_sources)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TranslateMessagesV3Response decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TranslateMessagesV3Response r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TranslateMessagesV3Response r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.message_ids);
            ProtoAdapter<MessageSource> r103 = MessageSource.ADAPTER;
            r103.asRepeated().encodeWithTag(r100, 2, r101.message_sources);
            r102.asRepeated().encodeWithTag(r100, 3, r101.translated_message_ids);
            Entity.ADAPTER.encodeWithTag(r100, 4, r101.entities);
            TranslateError.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.translate_errors);
            r103.asRepeated().encodeWithTag(r100, 6, r101.translated_message_sources);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TranslateMessagesV3Response r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TranslateMessagesV3Response r100 = new ProtoAdapter_TranslateMessagesV3Response();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.message_sources = Internal.copyOf("message_sources", this.message_sources);
        r100.translated_message_ids = Internal.copyOf("translated_message_ids", this.translated_message_ids);
        r100.entities = this.entities;
        r100.translate_errors = Internal.copyOf("translate_errors", this.translate_errors);
        r100.translated_message_sources = Internal.copyOf("translated_message_sources", this.translated_message_sources);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TranslateMessagesV3Response.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TranslateMessagesV3Response(List<String> r100, List<MessageSource> r110, List<String> r111, Entity r112, List<TranslateError> r113, List<MessageSource> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public TranslateMessagesV3Response(List<String> r100, List<MessageSource> r101, List<String> r102, Entity r103, List<TranslateError> r104, List<MessageSource> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
        this.message_sources = Internal.immutableCopyOf("message_sources", r101);
        this.translated_message_ids = Internal.immutableCopyOf("translated_message_ids", r102);
        this.entities = r103;
        this.translate_errors = Internal.immutableCopyOf("translate_errors", r104);
        this.translated_message_sources = Internal.immutableCopyOf("translated_message_sources", r105);
    }
}
