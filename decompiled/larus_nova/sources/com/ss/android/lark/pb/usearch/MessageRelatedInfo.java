package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MessageRelatedInfo extends Message<MessageRelatedInfo, Builder> {
    public static final ProtoAdapter<MessageRelatedInfo> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_FROM_TENANT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Long mcreate_time;
    public final Map<Integer, MessageBehavior> mdisabled_action;
    public final String mfrom_id;
    public final String mfrom_tenant_id;
    public final String mid;
    public final Boolean mis_restricted;
    public final Integer mposition;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final Integer mthread_position;

    public static final class Builder extends Message.Builder<MessageRelatedInfo, Builder> {
        public String mchat_id;
        public Long mcreate_time;
        public Map<Integer, MessageBehavior> mdisabled_action;
        public String mfrom_id;
        public String mfrom_tenant_id;
        public String mid;
        public Boolean mis_restricted;
        public Integer mposition;
        public Integer mthread_chat_position;
        public String mthread_id;
        public Integer mthread_position;

        @Override // com.squareup.wire.Message.Builder
        public MessageRelatedInfo build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new MessageRelatedInfo(this.mid, this.mposition, this.mcreate_time, this.mthread_position, this.mthread_id, this.mthread_chat_position, this.mchat_id, this.mis_restricted, this.mdisabled_action, this.mfrom_id, this.mfrom_tenant_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mdisabled_action = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.mcreate_time = r100;
            return this;
        }

        public Builder disabled_action(Map<Integer, MessageBehavior> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdisabled_action = r100;
            return this;
        }

        public Builder from_id(String r100) {
            this.mfrom_id = r100;
            return this;
        }

        public Builder from_tenant_id(String r100) {
            this.mfrom_tenant_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_restricted(Boolean r100) {
            this.mis_restricted = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.mposition = r100;
            return this;
        }

        public Builder thread_chat_position(Integer r100) {
            this.mthread_chat_position = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.mthread_id = r100;
            return this;
        }

        public Builder thread_position(Integer r100) {
            this.mthread_position = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageRelatedInfo extends ProtoAdapter<MessageRelatedInfo> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> mdisabled_action;

        public ProtoAdapter_MessageRelatedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageRelatedInfo.class);
            this.mdisabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageRelatedInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mposition = 0;
            r101.mcreate_time = 0L;
            r101.mthread_position = 0;
            r101.mthread_id = "";
            r101.mthread_chat_position = 0;
            r101.mchat_id = "";
            r101.mis_restricted = Boolean.FALSE;
            r101.mfrom_id = "";
            r101.mfrom_tenant_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.mfrom_tenant_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mfrom_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mdisabled_action.putAll(this.mdisabled_action.decode(r100));
            goto L3
        L10:
            r101.mis_restricted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mthread_chat_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.mthread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mthread_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.mcreate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.mposition = ProtoAdapter.INT32.decode(r100);
            goto L3
        L17:
            r101.mid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MessageRelatedInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            Integer r103 = r100.mposition;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.mcreate_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.mthread_position;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.mthread_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.mthread_chat_position;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mchat_id;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            Boolean r122 = r100.mis_restricted;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L30:
            int r124 = (r121 + r123) + this.mdisabled_action.encodedSizeWithTag(9, r100.mdisabled_action);
            String r125 = r100.mfrom_id;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(10, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.mfrom_tenant_id;
            if (r128 == null) goto L38;
            r104 = r101.encodedSizeWithTag(11, r128);
        L38:
            return (r127 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ MessageRelatedInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageRelatedInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageRelatedInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            Integer r103 = r101.mposition;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.mcreate_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L8:
            Integer r105 = r101.mthread_position;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.mthread_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.mthread_chat_position;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.mchat_id;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            Boolean r109 = r101.mis_restricted;
            if (r109 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L23:
            this.mdisabled_action.encodeWithTag(r100, 9, r101.mdisabled_action);
            String r110 = r101.mfrom_id;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 10, r110);
        L26:
            String r111 = r101.mfrom_tenant_id;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 11, r111);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageRelatedInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageRelatedInfo();
        DEFAULT_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_IS_RESTRICTED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mposition = this.mposition;
        r100.mcreate_time = this.mcreate_time;
        r100.mthread_position = this.mthread_position;
        r100.mthread_id = this.mthread_id;
        r100.mthread_chat_position = this.mthread_chat_position;
        r100.mchat_id = this.mchat_id;
        r100.mis_restricted = this.mis_restricted;
        r100.mdisabled_action = Internal.copyOf("mdisabled_action", this.mdisabled_action);
        r100.mfrom_id = this.mfrom_id;
        r100.mfrom_tenant_id = this.mfrom_tenant_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageRelatedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageRelatedInfo(String r110, Integer r111, Long r112, Integer r113, String r114, Integer r115, String r210, Boolean r211, Map<Integer, MessageBehavior> r212, String r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public MessageRelatedInfo(String r100, Integer r101, Long r102, Integer r103, String r104, Integer r105, String r106, Boolean r107, Map<Integer, MessageBehavior> r110, String r111, String r112, ByteString r113) {
        super(ADAPTER, r113);
        this.mid = r100;
        this.mposition = r101;
        this.mcreate_time = r102;
        this.mthread_position = r103;
        this.mthread_id = r104;
        this.mthread_chat_position = r105;
        this.mchat_id = r106;
        this.mis_restricted = r107;
        this.mdisabled_action = Internal.immutableCopyOf("mdisabled_action", r110);
        this.mfrom_id = r111;
        this.mfrom_tenant_id = r112;
    }
}
