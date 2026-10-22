package com.bytedance.lark.pb.basic.v1;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CommonAIReply extends com.squareup.wire.Message<CommonAIReply, Builder> {
    public static final ProtoAdapter<CommonAIReply> ADAPTER = null;
    public static final String DEFAULT_AI_REPLY_ID = "";
    public static final String DEFAULT_COT_TEXT = "";
    public static final Integer DEFAULT_SEQUENCE_ID = null;
    public static final Status DEFAULT_STATUS = null;
    public static final String DEFAULT_TEXT_WITHOUT_CITATION = "";
    private static final long serialVersionUID = 0;
    public final String ai_reply_id;
    public final String cot_text;
    public final List<ReferenceItem> reference_list;
    public final RichText references;
    public final RichText rich_text;
    public final Integer sequence_id;
    public final Status status;
    public final String text_without_citation;

    public static final class Builder extends com.squareup.wire.Message.Builder<CommonAIReply, Builder> {
        public String ai_reply_id;
        public String cot_text;
        public List<ReferenceItem> reference_list;
        public RichText references;
        public RichText rich_text;
        public Integer sequence_id;
        public Status status;
        public String text_without_citation;

        @Override // com.squareup.wire.Message.Builder
        public CommonAIReply build() {
            return new CommonAIReply(this.status, this.sequence_id, this.rich_text, this.references, this.text_without_citation, this.cot_text, this.ai_reply_id, this.reference_list, super.buildUnknownFields());
        }

        public Builder() {
            this.reference_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder ai_reply_id(String r100) {
            this.ai_reply_id = r100;
            return this;
        }

        public Builder cot_text(String r100) {
            this.cot_text = r100;
            return this;
        }

        public Builder reference_list(List<ReferenceItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.reference_list = r100;
            return this;
        }

        public Builder references(RichText r100) {
            this.references = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder sequence_id(Integer r100) {
            this.sequence_id = r100;
            return this;
        }

        public Builder status(Status r100) {
            this.status = r100;
            return this;
        }

        public Builder text_without_citation(String r100) {
            this.text_without_citation = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CommonAIReply extends ProtoAdapter<CommonAIReply> {
        public ProtoAdapter_CommonAIReply() {
            super(FieldEncoding.LENGTH_DELIMITED, CommonAIReply.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CommonAIReply decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = Status.UNKNOWN_STATUS;
            r101.sequence_id = 0;
            r101.text_without_citation = "";
            r101.cot_text = "";
            r101.ai_reply_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 2: goto L20;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L6;
                case 10: goto L7;
                default: goto L6;
            };
        L20:
            r101.status = Status.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.reference_list.add(ReferenceItem.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.ai_reply_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.cot_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.text_without_citation = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.references = RichText.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.sequence_id = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CommonAIReply r100) {
            Status r101 = r100.status;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Status.ADAPTER.encodedSizeWithTag(2, r101);
        L6:
            Integer r104 = r100.sequence_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(3, r104);
        L10:
            int r106 = r103 + r105;
            RichText r107 = r100.rich_text;
            if (r107 == null) goto L13;
            int r108 = RichText.ADAPTER.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            RichText r110 = r100.references;
            if (r110 == null) goto L17;
            int r111 = RichText.ADAPTER.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.text_without_citation;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.cot_text;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(7, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.ai_reply_id;
            if (r119 == null) goto L30;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r119);
        L30:
            return ((r118 + r102) + ReferenceItem.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.reference_list)) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ CommonAIReply decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CommonAIReply r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CommonAIReply r101) throws IOException {
            Status r102 = r101.status;
            if (r102 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Integer r103 = r101.sequence_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            RichText r104 = r101.rich_text;
            if (r104 == null) goto L11;
            RichText.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            RichText r105 = r101.references;
            if (r105 == null) goto L14;
            RichText.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            String r106 = r101.text_without_citation;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r106);
        L17:
            String r107 = r101.cot_text;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r107);
        L20:
            String r108 = r101.ai_reply_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r108);
        L23:
            ReferenceItem.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.reference_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CommonAIReply r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ReferenceItem extends com.squareup.wire.Message<ReferenceItem, Builder> {
        public static final ProtoAdapter<ReferenceItem> ADAPTER = null;
        public static final ReferenceType DEFAULT_SRC_TYPE = null;
        public static final String DEFAULT_TITLE = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final ReferenceType src_type;
        public final String title;
        public final String url;

        public static final class Builder extends com.squareup.wire.Message.Builder<ReferenceItem, Builder> {
            public ReferenceType src_type;
            public String title;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public ReferenceItem build() {
                return new ReferenceItem(this.url, this.title, this.src_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder src_type(ReferenceType r100) {
                this.src_type = r100;
                return this;
            }

            public Builder title(String r100) {
                this.title = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ReferenceItem extends ProtoAdapter<ReferenceItem> {
            public ProtoAdapter_ReferenceItem() {
                super(FieldEncoding.LENGTH_DELIMITED, ReferenceItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReferenceItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.title = "";
                r101.src_type = ReferenceType.UNKNOWN_TYPE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.title = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.src_type = ReferenceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ReferenceItem r100) {
                String r101 = r100.url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.title;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ReferenceType r107 = r100.src_type;
                if (r107 == null) goto L14;
                r102 = ReferenceType.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ReferenceItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ReferenceItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ReferenceItem r101) throws IOException {
                String r102 = r101.url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.title;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                ReferenceType r104 = r101.src_type;
                if (r104 == null) goto L11;
                ReferenceType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReferenceItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReferenceItem();
            DEFAULT_SRC_TYPE = ReferenceType.UNKNOWN_TYPE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.title = this.title;
            r100.src_type = this.src_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ReferenceItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReferenceItem(String r100, String r101, ReferenceType r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ReferenceItem(String r100, String r101, ReferenceType r102, ByteString r103) {
            super(ADAPTER, r103);
            this.url = r100;
            this.title = r101;
            this.src_type = r102;
        }
    }

    public static final enum ReferenceType extends Enum<ReferenceType> implements WireEnum {
        private static final /* synthetic */ ReferenceType[] $VALUES = null;
        public static final ProtoAdapter<ReferenceType> ADAPTER = null;
        public static final ReferenceType COMMENT = null;
        public static final ReferenceType DOC = null;
        public static final ReferenceType HELPDESK = null;
        public static final ReferenceType LINGO = null;
        public static final ReferenceType MESSAGE = null;
        public static final ReferenceType MINUTES = null;
        public static final ReferenceType UNKNOWN_TYPE = null;
        public static final ReferenceType WEB = null;
        public static final ReferenceType WIKI = null;
        private final int value;

        static {
            ReferenceType r100 = new ReferenceType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            ReferenceType r101 = new ReferenceType("HELPDESK", 1, 1);
            HELPDESK = r101;
            ReferenceType r102 = new ReferenceType("WIKI", 2, 2);
            WIKI = r102;
            ReferenceType r103 = new ReferenceType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3, 3);
            DOC = r103;
            ReferenceType r104 = new ReferenceType("WEB", 4, 4);
            WEB = r104;
            ReferenceType r105 = new ReferenceType("LINGO", 5, 5);
            LINGO = r105;
            ReferenceType r110 = new ReferenceType("MESSAGE", 6, 6);
            MESSAGE = r110;
            ReferenceType r111 = new ReferenceType("COMMENT", 7, 7);
            COMMENT = r111;
            ReferenceType r112 = new ReferenceType("MINUTES", 8, 8);
            MINUTES = r112;
            $VALUES = new ReferenceType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
            ADAPTER = ProtoAdapter.newEnumAdapter(ReferenceType.class);
        }

        public static ReferenceType[] values() {
            return (ReferenceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ReferenceType fromValue(int r100) {
            switch(r100) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MINUTES;
        L8:
            return COMMENT;
        L10:
            return MESSAGE;
        L12:
            return LINGO;
        L14:
            return WEB;
        L16:
            return DOC;
        L18:
            return WIKI;
        L20:
            return HELPDESK;
        L22:
            return UNKNOWN_TYPE;
        }

        public static ReferenceType valueOf(String r100) {
            return (ReferenceType) a.a(ReferenceType.class, r100);
        }

        private ReferenceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status CLOSE = null;
        public static final Status FAILED = null;
        public static final Status NO_ANSWER = null;
        public static final Status NO_RECOMENDATION = null;
        public static final Status OVER = null;
        public static final Status START = null;
        public static final Status TRANSMIT = null;
        public static final Status UNKNOWN_STATUS = null;
        private final int value;

        static {
            Status r100 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r100;
            Status r101 = new Status(GXAnimation.STATE_START, 1, 1);
            START = r101;
            Status r102 = new Status("TRANSMIT", 2, 2);
            TRANSMIT = r102;
            Status r103 = new Status("OVER", 3, 3);
            OVER = r103;
            Status r104 = new Status("FAILED", 4, 4);
            FAILED = r104;
            Status r105 = new Status("NO_RECOMENDATION", 5, 5);
            NO_RECOMENDATION = r105;
            Status r110 = new Status("NO_ANSWER", 6, 6);
            NO_ANSWER = r110;
            Status r111 = new Status("CLOSE", 7, 7);
            CLOSE = r111;
            $VALUES = new Status[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return CLOSE;
        L8:
            return NO_ANSWER;
        L10:
            return NO_RECOMENDATION;
        L12:
            return FAILED;
        L14:
            return OVER;
        L16:
            return TRANSMIT;
        L18:
            return START;
        L20:
            return UNKNOWN_STATUS;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        private Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CommonAIReply();
        DEFAULT_STATUS = Status.UNKNOWN_STATUS;
        DEFAULT_SEQUENCE_ID = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.sequence_id = this.sequence_id;
        r100.rich_text = this.rich_text;
        r100.references = this.references;
        r100.text_without_citation = this.text_without_citation;
        r100.cot_text = this.cot_text;
        r100.ai_reply_id = this.ai_reply_id;
        r100.reference_list = Internal.copyOf("reference_list", this.reference_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CommonAIReply.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CommonAIReply(Status r110, Integer r111, RichText r112, RichText r113, String r114, String r115, String r116, List<ReferenceItem> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public CommonAIReply(Status r100, Integer r101, RichText r102, RichText r103, String r104, String r105, String r106, List<ReferenceItem> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.status = r100;
        this.sequence_id = r101;
        this.rich_text = r102;
        this.references = r103;
        this.text_without_citation = r104;
        this.cot_text = r105;
        this.ai_reply_id = r106;
        this.reference_list = Internal.immutableCopyOf("reference_list", r107);
    }
}
