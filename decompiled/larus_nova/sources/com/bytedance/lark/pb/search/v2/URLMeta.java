package com.bytedance.lark.pb.search.v2;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.UDIcon;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class URLMeta extends Message<URLMeta, Builder> {
    public static final ProtoAdapter<URLMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_MESSAGE_POSITION = null;
    public static final String DEFAULT_MESSAGE_SENDER_NAME = "";
    public static final String DEFAULT_PREVIEW_TOKEN = "";
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Long create_time;
    public final Map<Integer, MessageBehavior> disabled_action;
    public final String from_id;
    public final String icon_url;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253745id;
    public final ImageSet image_icon;
    public final Boolean is_restricted;
    public final String message_id;
    public final Integer message_position;
    public final String message_sender_name;
    public final String preview_token;
    public final Integer thread_chat_position;
    public final String thread_id;
    public final Integer thread_position;
    public final UDIcon ud_icon;
    public final String url;

    public static final class Builder extends Message.Builder<URLMeta, Builder> {
        public String chat_id;
        public Long create_time;
        public Map<Integer, MessageBehavior> disabled_action;
        public String from_id;
        public String icon_url;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253746id;
        public ImageSet image_icon;
        public Boolean is_restricted;
        public String message_id;
        public Integer message_position;
        public String message_sender_name;
        public String preview_token;
        public Integer thread_chat_position;
        public String thread_id;
        public Integer thread_position;
        public UDIcon ud_icon;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public URLMeta build() {
            String r100 = this.f253746id;
            if (r100 == null) goto L7;
            return new URLMeta(this.f253746id, this.create_time, this.message_id, this.message_position, this.chat_id, this.from_id, this.url, this.icon_url, this.thread_id, this.thread_position, this.thread_chat_position, this.is_restricted, this.disabled_action, this.ud_icon, this.image_icon, this.message_sender_name, this.preview_token, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "id"});
        }

        public Builder() {
            this.disabled_action = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder disabled_action(Map<Integer, MessageBehavior> r100) {
            Internal.checkElementsNotNull(r100);
            this.disabled_action = r100;
            return this;
        }

        public Builder from_id(String r100) {
            this.from_id = r100;
            return this;
        }

        public Builder icon_url(String r100) {
            this.icon_url = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253746id = r100;
            return this;
        }

        public Builder image_icon(ImageSet r100) {
            this.image_icon = r100;
            return this;
        }

        public Builder is_restricted(Boolean r100) {
            this.is_restricted = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder message_position(Integer r100) {
            this.message_position = r100;
            return this;
        }

        public Builder message_sender_name(String r100) {
            this.message_sender_name = r100;
            return this;
        }

        public Builder preview_token(String r100) {
            this.preview_token = r100;
            return this;
        }

        public Builder thread_chat_position(Integer r100) {
            this.thread_chat_position = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_position(Integer r100) {
            this.thread_position = r100;
            return this;
        }

        public Builder ud_icon(UDIcon r100) {
            this.ud_icon = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_URLMeta extends ProtoAdapter<URLMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> disabled_action;

        public ProtoAdapter_URLMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, URLMeta.class);
            this.disabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public URLMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253746id = "";
            r101.create_time = 0L;
            r101.message_id = "";
            r101.message_position = 0;
            r101.chat_id = "";
            r101.from_id = "";
            r101.url = "";
            r101.icon_url = "";
            r101.thread_id = "";
            r101.thread_position = 0;
            r101.thread_chat_position = 0;
            r101.is_restricted = Boolean.FALSE;
            r101.message_sender_name = "";
            r101.preview_token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            switch(r103) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L11;
                case 14: goto L10;
                case 15: goto L9;
                case 16: goto L8;
                case 17: goto L7;
                default: goto L6;
            };
        L7:
            r101.preview_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.message_sender_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.image_icon = ImageSet.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.ud_icon = UDIcon.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.disabled_action.putAll(this.disabled_action.decode(r100));
            goto L3
        L12:
            r101.is_restricted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.thread_chat_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.thread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.icon_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.message_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L21:
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L23:
            r101.f253746id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(URLMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253745id);
            Long r103 = r100.create_time;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.message_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.message_position;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.chat_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.from_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.url;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.icon_url;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.thread_id;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(9, r125);
        L34:
            int r127 = r124 + r126;
            Integer r128 = r100.thread_position;
            if (r128 == null) goto L37;
            int r129 = ProtoAdapter.INT32.encodedSizeWithTag(10, r128);
        L38:
            int r130 = r127 + r129;
            Integer r131 = r100.thread_chat_position;
            if (r131 == null) goto L41;
            int r132 = ProtoAdapter.INT32.encodedSizeWithTag(11, r131);
        L42:
            int r133 = r130 + r132;
            Boolean r134 = r100.is_restricted;
            if (r134 == null) goto L45;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r134);
        L46:
            int r136 = (r133 + r135) + this.disabled_action.encodedSizeWithTag(13, r100.disabled_action);
            UDIcon r137 = r100.ud_icon;
            if (r137 == null) goto L49;
            int r138 = UDIcon.ADAPTER.encodedSizeWithTag(14, r137);
        L50:
            int r139 = r136 + r138;
            ImageSet r140 = r100.image_icon;
            if (r140 == null) goto L53;
            int r141 = ImageSet.ADAPTER.encodedSizeWithTag(15, r140);
        L54:
            int r142 = r139 + r141;
            String r143 = r100.message_sender_name;
            if (r143 == null) goto L57;
            int r144 = r101.encodedSizeWithTag(16, r143);
        L58:
            int r145 = r142 + r144;
            String r146 = r100.preview_token;
            if (r146 == null) goto L62;
            r104 = r101.encodedSizeWithTag(17, r146);
        L62:
            return (r145 + r104) + r100.unknownFields().size();
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ URLMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(URLMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, URLMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253745id);
            Long r103 = r101.create_time;
            if (r103 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.message_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Integer r105 = r101.message_position;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.chat_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.from_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.url;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.icon_url;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            String r110 = r101.thread_id;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 9, r110);
        L26:
            Integer r111 = r101.thread_position;
            if (r111 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r111);
        L29:
            Integer r112 = r101.thread_chat_position;
            if (r112 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r112);
        L32:
            Boolean r113 = r101.is_restricted;
            if (r113 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r113);
        L35:
            this.disabled_action.encodeWithTag(r100, 13, r101.disabled_action);
            UDIcon r114 = r101.ud_icon;
            if (r114 == null) goto L38;
            UDIcon.ADAPTER.encodeWithTag(r100, 14, r114);
        L38:
            ImageSet r115 = r101.image_icon;
            if (r115 == null) goto L41;
            ImageSet.ADAPTER.encodeWithTag(r100, 15, r115);
        L41:
            String r116 = r101.message_sender_name;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 16, r116);
        L44:
            String r117 = r101.preview_token;
            if (r117 == null) goto L47;
            r102.encodeWithTag(r100, 17, r117);
        L47:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URLMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_URLMeta();
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_MESSAGE_POSITION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_IS_RESTRICTED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253746id = this.f253745id;
        r100.create_time = this.create_time;
        r100.message_id = this.message_id;
        r100.message_position = this.message_position;
        r100.chat_id = this.chat_id;
        r100.from_id = this.from_id;
        r100.url = this.url;
        r100.icon_url = this.icon_url;
        r100.thread_id = this.thread_id;
        r100.thread_position = this.thread_position;
        r100.thread_chat_position = this.thread_chat_position;
        r100.is_restricted = this.is_restricted;
        r100.disabled_action = Internal.copyOf("disabled_action", this.disabled_action);
        r100.ud_icon = this.ud_icon;
        r100.image_icon = this.image_icon;
        r100.message_sender_name = this.message_sender_name;
        r100.preview_token = this.preview_token;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return URLMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public URLMeta(String r210, Long r211, String r212, Integer r213, String r214, String r215, String r216, String r217, String r218, Integer r219, Integer r310, Boolean r311, Map<Integer, MessageBehavior> r312, UDIcon r313, ImageSet r314, String r315, String r316) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, ByteString.EMPTY);
    }

    public URLMeta(String r100, Long r101, String r102, Integer r103, String r104, String r105, String r110, String r111, String r112, Integer r113, Integer r114, Boolean r115, Map<Integer, MessageBehavior> r116, UDIcon r117, ImageSet r118, String r119, String r210, ByteString r211) {
        super(ADAPTER, r211);
        this.f253745id = r100;
        this.create_time = r101;
        this.message_id = r102;
        this.message_position = r103;
        this.chat_id = r104;
        this.from_id = r105;
        this.url = r110;
        this.icon_url = r111;
        this.thread_id = r112;
        this.thread_position = r113;
        this.thread_chat_position = r114;
        this.is_restricted = r115;
        this.disabled_action = Internal.immutableCopyOf("disabled_action", r116);
        this.ud_icon = r117;
        this.image_icon = r118;
        this.message_sender_name = r119;
        this.preview_token = r210;
    }
}
