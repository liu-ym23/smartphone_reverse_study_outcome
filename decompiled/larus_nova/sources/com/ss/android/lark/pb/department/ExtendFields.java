package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.misc.ChattersAuthResult;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ExtendFields extends Message<ExtendFields, Builder> {
    public static final ProtoAdapter<ExtendFields> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ChattersAuthResult mauth_result;
    public final List<String> mchatters_deny_invite_same_chat;
    public final List<String> mchatters_in_chat_id;
    public final Map<String, DenyReason> mdeny_chatters;
    public final Map<String, Boolean> mdep_has_lead_perm;
    public final Map<String, ProfileFields> musers_profile_fields;

    public static final class Builder extends Message.Builder<ExtendFields, Builder> {
        public ChattersAuthResult mauth_result;
        public List<String> mchatters_deny_invite_same_chat;
        public List<String> mchatters_in_chat_id;
        public Map<String, DenyReason> mdeny_chatters;
        public Map<String, Boolean> mdep_has_lead_perm;
        public Map<String, ProfileFields> musers_profile_fields;

        @Override // com.squareup.wire.Message.Builder
        public ExtendFields build() {
            return new ExtendFields(this.mchatters_in_chat_id, this.mchatters_deny_invite_same_chat, this.mdeny_chatters, this.mauth_result, this.mdep_has_lead_perm, this.musers_profile_fields, super.buildUnknownFields());
        }

        public Builder() {
            this.mchatters_in_chat_id = Internal.newMutableList();
            this.mchatters_deny_invite_same_chat = Internal.newMutableList();
            this.mdeny_chatters = Internal.newMutableMap();
            this.mdep_has_lead_perm = Internal.newMutableMap();
            this.musers_profile_fields = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auth_result(ChattersAuthResult r100) {
            this.mauth_result = r100;
            return this;
        }

        public Builder chatters_deny_invite_same_chat(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchatters_deny_invite_same_chat = r100;
            return this;
        }

        public Builder chatters_in_chat_id(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchatters_in_chat_id = r100;
            return this;
        }

        public Builder deny_chatters(Map<String, DenyReason> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdeny_chatters = r100;
            return this;
        }

        public Builder dep_has_lead_perm(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdep_has_lead_perm = r100;
            return this;
        }

        public Builder users_profile_fields(Map<String, ProfileFields> r100) {
            Internal.checkElementsNotNull(r100);
            this.musers_profile_fields = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtendFields extends ProtoAdapter<ExtendFields> {
        private final ProtoAdapter<Map<String, DenyReason>> mdeny_chatters;
        private final ProtoAdapter<Map<String, Boolean>> mdep_has_lead_perm;
        private final ProtoAdapter<Map<String, ProfileFields>> musers_profile_fields;

        public ProtoAdapter_ExtendFields() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtendFields.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mdeny_chatters = ProtoAdapter.newMapAdapter(r100, DenyReason.ADAPTER);
            this.mdep_has_lead_perm = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.BOOL);
            this.musers_profile_fields = ProtoAdapter.newMapAdapter(r100, ProfileFields.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ExtendFields decode(ProtoReader r100) throws IOException {
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
            r101.musers_profile_fields.putAll(this.musers_profile_fields.decode(r100));
            goto L3
        L8:
            r101.mdep_has_lead_perm.putAll(this.mdep_has_lead_perm.decode(r100));
            goto L3
        L9:
            r101.mauth_result = ChattersAuthResult.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.mdeny_chatters.putAll(this.mdeny_chatters.decode(r100));
            goto L3
        L11:
            r101.mchatters_deny_invite_same_chat.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.mchatters_in_chat_id.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(ExtendFields r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.asRepeated().encodedSizeWithTag(1, r100.mchatters_in_chat_id) + r101.asRepeated().encodedSizeWithTag(2, r100.mchatters_deny_invite_same_chat)) + this.mdeny_chatters.encodedSizeWithTag(3, r100.mdeny_chatters);
            ChattersAuthResult r103 = r100.mauth_result;
            if (r103 == null) goto L5;
            int r104 = ChattersAuthResult.ADAPTER.encodedSizeWithTag(4, r103);
        L7:
            return (((r102 + r104) + this.mdep_has_lead_perm.encodedSizeWithTag(5, r100.mdep_has_lead_perm)) + this.musers_profile_fields.encodedSizeWithTag(6, r100.musers_profile_fields)) + r100.unknownFields().size();
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
            r102.asRepeated().encodeWithTag(r100, 1, r101.mchatters_in_chat_id);
            r102.asRepeated().encodeWithTag(r100, 2, r101.mchatters_deny_invite_same_chat);
            this.mdeny_chatters.encodeWithTag(r100, 3, r101.mdeny_chatters);
            ChattersAuthResult r103 = r101.mauth_result;
            if (r103 == null) goto L5;
            ChattersAuthResult.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            this.mdep_has_lead_perm.encodeWithTag(r100, 5, r101.mdep_has_lead_perm);
            this.musers_profile_fields.encodeWithTag(r100, 6, r101.musers_profile_fields);
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
        r100.mchatters_in_chat_id = Internal.copyOf("mchatters_in_chat_id", this.mchatters_in_chat_id);
        r100.mchatters_deny_invite_same_chat = Internal.copyOf("mchatters_deny_invite_same_chat", this.mchatters_deny_invite_same_chat);
        r100.mdeny_chatters = Internal.copyOf("mdeny_chatters", this.mdeny_chatters);
        r100.mauth_result = this.mauth_result;
        r100.mdep_has_lead_perm = Internal.copyOf("mdep_has_lead_perm", this.mdep_has_lead_perm);
        r100.musers_profile_fields = Internal.copyOf("musers_profile_fields", this.musers_profile_fields);
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

    public ExtendFields(List<String> r100, List<String> r110, Map<String, DenyReason> r111, ChattersAuthResult r112, Map<String, Boolean> r113, Map<String, ProfileFields> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ExtendFields(List<String> r100, List<String> r101, Map<String, DenyReason> r102, ChattersAuthResult r103, Map<String, Boolean> r104, Map<String, ProfileFields> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mchatters_in_chat_id = Internal.immutableCopyOf("mchatters_in_chat_id", r100);
        this.mchatters_deny_invite_same_chat = Internal.immutableCopyOf("mchatters_deny_invite_same_chat", r101);
        this.mdeny_chatters = Internal.immutableCopyOf("mdeny_chatters", r102);
        this.mauth_result = r103;
        this.mdep_has_lead_perm = Internal.immutableCopyOf("mdep_has_lead_perm", r104);
        this.musers_profile_fields = Internal.immutableCopyOf("musers_profile_fields", r105);
    }
}
