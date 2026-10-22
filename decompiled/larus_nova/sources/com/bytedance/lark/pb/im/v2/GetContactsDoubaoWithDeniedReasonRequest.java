package com.bytedance.lark.pb.im.v2;

import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
public final class GetContactsDoubaoWithDeniedReasonRequest extends Message<GetContactsDoubaoWithDeniedReasonRequest, Builder> {
    public static final ProtoAdapter<GetContactsDoubaoWithDeniedReasonRequest> ADAPTER = null;
    public static final ActionType DEFAULT_ACTION_TYPE = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetContactsDoubaoWithDeniedReasonRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ActionType action_type;
    public final Long chat_id;
    public final SyncDataStrategy strategy;

    public static final class Builder extends Message.Builder<GetContactsDoubaoWithDeniedReasonRequest, Builder> implements d<GetContactsDoubaoWithDeniedReasonRequest> {
        public ActionType action_type;
        public Long chat_id;
        public SyncDataStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetContactsDoubaoWithDeniedReasonRequest build() {
            return new GetContactsDoubaoWithDeniedReasonRequest(this.strategy, this.chat_id, this.action_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_type(ActionType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetContactsDoubaoWithDeniedReasonRequest extends ProtoAdapter<GetContactsDoubaoWithDeniedReasonRequest> implements c<GetContactsDoubaoWithDeniedReasonRequest> {
        public ProtoAdapter_GetContactsDoubaoWithDeniedReasonRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactsDoubaoWithDeniedReasonRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactsDoubaoWithDeniedReasonRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncDataStrategy.LOCAL;
            r101.chat_id = 0L;
            r101.action_type = ActionType.UNKNOWN_ACTION;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.action_type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetContactsDoubaoWithDeniedReasonRequest r100) {
            SyncDataStrategy r101 = r100.strategy;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.chat_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ActionType r107 = r100.action_type;
            if (r107 == null) goto L14;
            r102 = ActionType.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ GetContactsDoubaoWithDeniedReasonRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactsDoubaoWithDeniedReasonRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactsDoubaoWithDeniedReasonRequest r101) throws IOException {
            SyncDataStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.chat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ActionType r104 = r101.action_type;
            if (r104 == null) goto L11;
            ActionType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactsDoubaoWithDeniedReasonRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetContactsDoubaoWithDeniedReasonRequest r100 = new ProtoAdapter_GetContactsDoubaoWithDeniedReasonRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncDataStrategy.LOCAL;
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_ACTION_TYPE = ActionType.UNKNOWN_ACTION;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.strategy = this.strategy;
        r100.chat_id = this.chat_id;
        r100.action_type = this.action_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactsDoubaoWithDeniedReasonRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactsDoubaoWithDeniedReasonRequest(SyncDataStrategy r100, Long r101, ActionType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetContactsDoubaoWithDeniedReasonRequest(SyncDataStrategy r100, Long r101, ActionType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.strategy = r100;
        this.chat_id = r101;
        this.action_type = r102;
    }
}
