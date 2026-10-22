package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SubTranslateInfo extends com.squareup.wire.Message<SubTranslateInfo, Builder> {
    public static final ProtoAdapter<SubTranslateInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<SubMfTranslateInfo> sub_mf_translate_messages;
    public final Map<String, TranslateInfo> sub_translate_messages;

    public static final class Builder extends com.squareup.wire.Message.Builder<SubTranslateInfo, Builder> {
        public List<SubMfTranslateInfo> sub_mf_translate_messages;
        public Map<String, TranslateInfo> sub_translate_messages;

        @Override // com.squareup.wire.Message.Builder
        public SubTranslateInfo build() {
            return new SubTranslateInfo(this.sub_translate_messages, this.sub_mf_translate_messages, super.buildUnknownFields());
        }

        public Builder() {
            this.sub_translate_messages = Internal.newMutableMap();
            this.sub_mf_translate_messages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder sub_mf_translate_messages(List<SubMfTranslateInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_mf_translate_messages = r100;
            return this;
        }

        public Builder sub_translate_messages(Map<String, TranslateInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.sub_translate_messages = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubTranslateInfo extends ProtoAdapter<SubTranslateInfo> {
        private final ProtoAdapter<Map<String, TranslateInfo>> sub_translate_messages;

        public ProtoAdapter_SubTranslateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, SubTranslateInfo.class);
            this.sub_translate_messages = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TranslateInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubTranslateInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.sub_translate_messages.putAll(this.sub_translate_messages.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.sub_mf_translate_messages.add(SubMfTranslateInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(SubTranslateInfo r100) {
            return (this.sub_translate_messages.encodedSizeWithTag(1, r100.sub_translate_messages) + SubMfTranslateInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.sub_mf_translate_messages)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubTranslateInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubTranslateInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubTranslateInfo r101) throws IOException {
            this.sub_translate_messages.encodeWithTag(r100, 1, r101.sub_translate_messages);
            SubMfTranslateInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.sub_mf_translate_messages);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubTranslateInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SubMfTranslateInfo extends com.squareup.wire.Message<SubMfTranslateInfo, Builder> {
        public static final ProtoAdapter<SubMfTranslateInfo> ADAPTER = null;
        public static final String DEFAULT_SUB_MESSAGE_ID = "";
        private static final long serialVersionUID = 0;
        public final String sub_message_id;
        public final SubTranslateInfo sub_translate_messages;

        public static final class Builder extends com.squareup.wire.Message.Builder<SubMfTranslateInfo, Builder> {
            public String sub_message_id;
            public SubTranslateInfo sub_translate_messages;

            @Override // com.squareup.wire.Message.Builder
            public SubMfTranslateInfo build() {
                return new SubMfTranslateInfo(this.sub_message_id, this.sub_translate_messages, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder sub_message_id(String r100) {
                this.sub_message_id = r100;
                return this;
            }

            public Builder sub_translate_messages(SubTranslateInfo r100) {
                this.sub_translate_messages = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_SubMfTranslateInfo extends ProtoAdapter<SubMfTranslateInfo> {
            public ProtoAdapter_SubMfTranslateInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, SubMfTranslateInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SubMfTranslateInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.sub_message_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.sub_message_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.sub_translate_messages = SubTranslateInfo.ADAPTER.decode(r100);
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
            public int encodedSize2(SubMfTranslateInfo r100) {
                String r101 = r100.sub_message_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                SubTranslateInfo r104 = r100.sub_translate_messages;
                if (r104 == null) goto L10;
                r102 = SubTranslateInfo.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ SubMfTranslateInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SubMfTranslateInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SubMfTranslateInfo r101) throws IOException {
                String r102 = r101.sub_message_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                SubTranslateInfo r103 = r101.sub_translate_messages;
                if (r103 == null) goto L8;
                SubTranslateInfo.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubMfTranslateInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SubMfTranslateInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.sub_message_id = this.sub_message_id;
            r100.sub_translate_messages = this.sub_translate_messages;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SubMfTranslateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public SubMfTranslateInfo(String r100, SubTranslateInfo r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public SubMfTranslateInfo(String r100, SubTranslateInfo r101, ByteString r102) {
            super(ADAPTER, r102);
            this.sub_message_id = r100;
            this.sub_translate_messages = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubTranslateInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sub_translate_messages = Internal.copyOf("sub_translate_messages", this.sub_translate_messages);
        r100.sub_mf_translate_messages = Internal.copyOf("sub_mf_translate_messages", this.sub_mf_translate_messages);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubTranslateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubTranslateInfo(Map<String, TranslateInfo> r100, List<SubMfTranslateInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SubTranslateInfo(Map<String, TranslateInfo> r100, List<SubMfTranslateInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.sub_translate_messages = Internal.immutableCopyOf("sub_translate_messages", r100);
        this.sub_mf_translate_messages = Internal.immutableCopyOf("sub_mf_translate_messages", r101);
    }
}
