package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.ChattersAuthResult;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ExtendFields extends Message<ExtendFields, Builder> {
    public static final ProtoAdapter<ExtendFields> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ChattersAuthResult auth_result;
    public final List<String> chatters_deny_invite_same_chat;
    public final Map<String, Boolean> dep_has_lead_perm;
    public final Map<String, String> enterprise_emails;
    public final List<String> in_chat_chatter_ids;
    public final Map<Long, Boolean> selected_departs;
    public final Map<Long, Boolean> selected_users;
    public final Map<String, ProfileFields> user_profile_fields;

    public static final class Builder extends Message.Builder<ExtendFields, Builder> {
        public ChattersAuthResult auth_result;
        public List<String> chatters_deny_invite_same_chat;
        public Map<String, Boolean> dep_has_lead_perm;
        public Map<String, String> enterprise_emails;
        public List<String> in_chat_chatter_ids;
        public Map<Long, Boolean> selected_departs;
        public Map<Long, Boolean> selected_users;
        public Map<String, ProfileFields> user_profile_fields;

        @Override // com.squareup.wire.Message.Builder
        public ExtendFields build() {
            return new ExtendFields(this.in_chat_chatter_ids, this.chatters_deny_invite_same_chat, this.auth_result, this.dep_has_lead_perm, this.user_profile_fields, this.enterprise_emails, this.selected_users, this.selected_departs, super.buildUnknownFields());
        }

        public Builder() {
            this.in_chat_chatter_ids = Internal.newMutableList();
            this.chatters_deny_invite_same_chat = Internal.newMutableList();
            this.dep_has_lead_perm = Internal.newMutableMap();
            this.user_profile_fields = Internal.newMutableMap();
            this.enterprise_emails = Internal.newMutableMap();
            this.selected_users = Internal.newMutableMap();
            this.selected_departs = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auth_result(ChattersAuthResult r100) {
            this.auth_result = r100;
            return this;
        }

        public Builder chatters_deny_invite_same_chat(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters_deny_invite_same_chat = r100;
            return this;
        }

        public Builder dep_has_lead_perm(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.dep_has_lead_perm = r100;
            return this;
        }

        public Builder enterprise_emails(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.enterprise_emails = r100;
            return this;
        }

        public Builder in_chat_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.in_chat_chatter_ids = r100;
            return this;
        }

        public Builder selected_departs(Map<Long, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.selected_departs = r100;
            return this;
        }

        public Builder selected_users(Map<Long, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.selected_users = r100;
            return this;
        }

        public Builder user_profile_fields(Map<String, ProfileFields> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_profile_fields = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtendFields extends ProtoAdapter<ExtendFields> {
        private final ProtoAdapter<Map<String, Boolean>> dep_has_lead_perm;
        private final ProtoAdapter<Map<String, String>> enterprise_emails;
        private final ProtoAdapter<Map<Long, Boolean>> selected_departs;
        private final ProtoAdapter<Map<Long, Boolean>> selected_users;
        private final ProtoAdapter<Map<String, ProfileFields>> user_profile_fields;

        public ProtoAdapter_ExtendFields() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtendFields.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            this.dep_has_lead_perm = ProtoAdapter.newMapAdapter(r100, r101);
            this.user_profile_fields = ProtoAdapter.newMapAdapter(r100, ProfileFields.ADAPTER);
            this.enterprise_emails = ProtoAdapter.newMapAdapter(r100, r100);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            this.selected_users = ProtoAdapter.newMapAdapter(r102, r101);
            this.selected_departs = ProtoAdapter.newMapAdapter(r102, r101);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtendFields decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            switch(r103) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L6;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r101.selected_departs.putAll(this.selected_departs.decode(r100));
            goto L3
        L8:
            r101.selected_users.putAll(this.selected_users.decode(r100));
            goto L3
        L9:
            r101.enterprise_emails.putAll(this.enterprise_emails.decode(r100));
            goto L3
        L10:
            r101.user_profile_fields.putAll(this.user_profile_fields.decode(r100));
            goto L3
        L11:
            r101.dep_has_lead_perm.putAll(this.dep_has_lead_perm.decode(r100));
            goto L3
        L12:
            r101.auth_result = ChattersAuthResult.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.chatters_deny_invite_same_chat.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            r101.in_chat_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ExtendFields r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.in_chat_chatter_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.chatters_deny_invite_same_chat);
            ChattersAuthResult r103 = r100.auth_result;
            if (r103 == null) goto L5;
            int r104 = ChattersAuthResult.ADAPTER.encodedSizeWithTag(4, r103);
        L7:
            return ((((((r102 + r104) + this.dep_has_lead_perm.encodedSizeWithTag(5, r100.dep_has_lead_perm)) + this.user_profile_fields.encodedSizeWithTag(6, r100.user_profile_fields)) + this.enterprise_emails.encodedSizeWithTag(7, r100.enterprise_emails)) + this.selected_users.encodedSizeWithTag(8, r100.selected_users)) + this.selected_departs.encodedSizeWithTag(9, r100.selected_departs)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ExtendFields decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ExtendFields r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ExtendFields r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.in_chat_chatter_ids);
            r102.asRepeated().encodeWithTag(r100, 2, r101.chatters_deny_invite_same_chat);
            ChattersAuthResult r103 = r101.auth_result;
            if (r103 == null) goto L5;
            ChattersAuthResult.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            this.dep_has_lead_perm.encodeWithTag(r100, 5, r101.dep_has_lead_perm);
            this.user_profile_fields.encodeWithTag(r100, 6, r101.user_profile_fields);
            this.enterprise_emails.encodeWithTag(r100, 7, r101.enterprise_emails);
            this.selected_users.encodeWithTag(r100, 8, r101.selected_users);
            this.selected_departs.encodeWithTag(r100, 9, r101.selected_departs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ExtendFields r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtendFields();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.in_chat_chatter_ids = Internal.copyOf("in_chat_chatter_ids", this.in_chat_chatter_ids);
        r100.chatters_deny_invite_same_chat = Internal.copyOf("chatters_deny_invite_same_chat", this.chatters_deny_invite_same_chat);
        r100.auth_result = this.auth_result;
        r100.dep_has_lead_perm = Internal.copyOf("dep_has_lead_perm", this.dep_has_lead_perm);
        r100.user_profile_fields = Internal.copyOf("user_profile_fields", this.user_profile_fields);
        r100.enterprise_emails = Internal.copyOf("enterprise_emails", this.enterprise_emails);
        r100.selected_users = Internal.copyOf("selected_users", this.selected_users);
        r100.selected_departs = Internal.copyOf("selected_departs", this.selected_departs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ExtendFields.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ExtendFields(List<String> r110, List<String> r111, ChattersAuthResult r112, Map<String, Boolean> r113, Map<String, ProfileFields> r114, Map<String, String> r115, Map<Long, Boolean> r116, Map<Long, Boolean> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public ExtendFields(List<String> r100, List<String> r101, ChattersAuthResult r102, Map<String, Boolean> r103, Map<String, ProfileFields> r104, Map<String, String> r105, Map<Long, Boolean> r106, Map<Long, Boolean> r107, ByteString r110) {
        super(ADAPTER, r110);
        this.in_chat_chatter_ids = Internal.immutableCopyOf("in_chat_chatter_ids", r100);
        this.chatters_deny_invite_same_chat = Internal.immutableCopyOf("chatters_deny_invite_same_chat", r101);
        this.auth_result = r102;
        this.dep_has_lead_perm = Internal.immutableCopyOf("dep_has_lead_perm", r103);
        this.user_profile_fields = Internal.immutableCopyOf("user_profile_fields", r104);
        this.enterprise_emails = Internal.immutableCopyOf("enterprise_emails", r105);
        this.selected_users = Internal.immutableCopyOf("selected_users", r106);
        this.selected_departs = Internal.immutableCopyOf("selected_departs", r107);
    }
}
