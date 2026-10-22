package ai.v1;

import com.bytedance.lark.pb.basic.v1.RichText;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ContextItem extends Message<ContextItem, Builder> {
    public static final ProtoAdapter<ContextItem> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_MESSAGE_LANGUAGE = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final Long create_time;
    public final String from_id;
    public final String id;
    public final String message_language;
    public final RichText rich_text;
    public final com.bytedance.lark.pb.basic.v1.Message.Type type;

    public static final class Builder extends Message.Builder<ContextItem, Builder> {
        public String content;
        public Long create_time;
        public String from_id;
        public String id;
        public String message_language;
        public RichText rich_text;
        public com.bytedance.lark.pb.basic.v1.Message.Type type;

        public ContextItem build() {
            return new ContextItem(this.id, this.type, this.from_id, this.create_time, this.message_language, this.content, this.rich_text, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m7build() {
            return build();
        }

        public Builder content(String r1) {
            this.content = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.create_time = r1;
            return this;
        }

        public Builder from_id(String r1) {
            this.from_id = r1;
            return this;
        }

        public Builder id(String r1) {
            this.id = r1;
            return this;
        }

        public Builder message_language(String r1) {
            this.message_language = r1;
            return this;
        }

        public Builder rich_text(RichText r1) {
            this.rich_text = r1;
            return this;
        }

        public Builder type(com.bytedance.lark.pb.basic.v1.Message.Type r1) {
            this.type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ContextItem extends ProtoAdapter<ContextItem> {
        public ProtoAdapter_ContextItem() {
            super(FieldEncoding.LENGTH_DELIMITED, ContextItem.class);
        }

        public ContextItem decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.id = "";
            r0.type = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
            r0.from_id = "";
            r0.create_time = 0L;
            r0.message_language = "";
            r0.content = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.type = (com.bytedance.lark.pb.basic.v1.Message.Type) com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.rich_text = (RichText) RichText.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.content = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.message_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.create_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L11:
            r0.from_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(ContextItem r6) {
            String r0 = r6.id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            com.bytedance.lark.pb.basic.v1.Message.Type r3 = r6.type;
            if (r3 == null) goto L9;
            int r4 = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.from_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.create_time;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.message_language;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.content;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            RichText r19 = r6.rich_text;
            if (r19 == null) goto L30;
            r1 = RichText.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            return (r18 + r1) + r6.unknownFields().size();
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ContextItem) r1);
        }

        public void encode(ProtoWriter r4, ContextItem r5) throws IOException {
            String r0 = r5.id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            com.bytedance.lark.pb.basic.v1.Message.Type r1 = r5.type;
            if (r1 == null) goto L8;
            com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.from_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.create_time;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.message_language;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.content;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            RichText r8 = r5.rich_text;
            if (r8 == null) goto L23;
            RichText.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ContextItem) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContextItem();
        DEFAULT_TYPE = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
        DEFAULT_CREATE_TIME = 0L;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.id = this.id;
        r0.type = this.type;
        r0.from_id = this.from_id;
        r0.create_time = this.create_time;
        r0.message_language = this.message_language;
        r0.content = this.content;
        r0.rich_text = this.rich_text;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ContextItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m6newBuilder() {
        return newBuilder();
    }

    public ContextItem(String r10, com.bytedance.lark.pb.basic.v1.Message.Type r11, String r12, Long r13, String r14, String r15, RichText r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public ContextItem(String r2, com.bytedance.lark.pb.basic.v1.Message.Type r3, String r4, Long r5, String r6, String r7, RichText r8, ByteString r9) {
        super(ADAPTER, r9);
        this.id = r2;
        this.type = r3;
        this.from_id = r4;
        this.create_time = r5;
        this.message_language = r6;
        this.content = r7;
        this.rich_text = r8;
    }
}
