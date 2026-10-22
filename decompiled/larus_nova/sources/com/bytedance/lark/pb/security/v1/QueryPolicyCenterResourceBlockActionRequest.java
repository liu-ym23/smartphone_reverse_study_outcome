package com.bytedance.lark.pb.security.v1;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
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
public final class QueryPolicyCenterResourceBlockActionRequest extends Message<QueryPolicyCenterResourceBlockActionRequest, Builder> {
    public static final ProtoAdapter<QueryPolicyCenterResourceBlockActionRequest> ADAPTER = null;
    public static final String DEFAULT_SCOPE_ENTITY_DOMAIN = "";
    public static final String DEFAULT_SCOPE_ENTITY_TYPE = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_QueryPolicyCenterResourceBlockActionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final PolicyCenterMessageBlockActionKey message_block_action_key;
    public final String scope_entity_domain;
    public final String scope_entity_type;

    public static final class Builder extends Message.Builder<QueryPolicyCenterResourceBlockActionRequest, Builder> implements d<QueryPolicyCenterResourceBlockActionRequest> {
        public PolicyCenterMessageBlockActionKey message_block_action_key;
        public String scope_entity_domain;
        public String scope_entity_type;

        @Override // com.squareup.wire.Message.Builder
        public QueryPolicyCenterResourceBlockActionRequest build() {
            return new QueryPolicyCenterResourceBlockActionRequest(this.scope_entity_domain, this.scope_entity_type, this.message_block_action_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_block_action_key(PolicyCenterMessageBlockActionKey r100) {
            this.message_block_action_key = r100;
            return this;
        }

        public Builder scope_entity_domain(String r100) {
            this.scope_entity_domain = r100;
            return this;
        }

        public Builder scope_entity_type(String r100) {
            this.scope_entity_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QueryPolicyCenterResourceBlockActionRequest extends ProtoAdapter<QueryPolicyCenterResourceBlockActionRequest> implements c<QueryPolicyCenterResourceBlockActionRequest> {
        public ProtoAdapter_QueryPolicyCenterResourceBlockActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, QueryPolicyCenterResourceBlockActionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QueryPolicyCenterResourceBlockActionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scope_entity_domain = "";
            r101.scope_entity_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.scope_entity_domain = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.scope_entity_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.message_block_action_key = PolicyCenterMessageBlockActionKey.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QueryPolicyCenterResourceBlockActionRequest r100) {
            String r101 = r100.scope_entity_domain;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.scope_entity_type;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            PolicyCenterMessageBlockActionKey r107 = r100.message_block_action_key;
            if (r107 == null) goto L14;
            r102 = PolicyCenterMessageBlockActionKey.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ QueryPolicyCenterResourceBlockActionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QueryPolicyCenterResourceBlockActionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QueryPolicyCenterResourceBlockActionRequest r101) throws IOException {
            String r102 = r101.scope_entity_domain;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.scope_entity_type;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            PolicyCenterMessageBlockActionKey r104 = r101.message_block_action_key;
            if (r104 == null) goto L11;
            PolicyCenterMessageBlockActionKey.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QueryPolicyCenterResourceBlockActionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_QueryPolicyCenterResourceBlockActionRequest r100 = new ProtoAdapter_QueryPolicyCenterResourceBlockActionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scope_entity_domain = this.scope_entity_domain;
        r100.scope_entity_type = this.scope_entity_type;
        r100.message_block_action_key = this.message_block_action_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QueryPolicyCenterResourceBlockActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QueryPolicyCenterResourceBlockActionRequest(String r100, String r101, PolicyCenterMessageBlockActionKey r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public QueryPolicyCenterResourceBlockActionRequest(String r100, String r101, PolicyCenterMessageBlockActionKey r102, ByteString r103) {
        super(ADAPTER, r103);
        this.scope_entity_domain = r100;
        this.scope_entity_type = r101;
        this.message_block_action_key = r102;
    }
}
