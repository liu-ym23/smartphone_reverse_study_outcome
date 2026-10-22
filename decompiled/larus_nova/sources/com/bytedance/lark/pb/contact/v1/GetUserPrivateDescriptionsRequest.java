package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserPrivateDescriptionsRequest extends Message<GetUserPrivateDescriptionsRequest, Builder> {
    public static final ProtoAdapter<GetUserPrivateDescriptionsRequest> ADAPTER = null;
    public static final Source DEFAULT_SOURCE = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetUserPrivateDescriptionsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Source source;
    public final SyncDataStrategy sync_data_strategy;
    public final List<Long> user_ids;

    public static final class Builder extends Message.Builder<GetUserPrivateDescriptionsRequest, Builder> implements d<GetUserPrivateDescriptionsRequest> {
        public Source source;
        public SyncDataStrategy sync_data_strategy;
        public List<Long> user_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetUserPrivateDescriptionsRequest build() {
            SyncDataStrategy r100 = this.sync_data_strategy;
            if (r100 == null) goto L7;
            return new GetUserPrivateDescriptionsRequest(this.user_ids, this.source, this.sync_data_strategy, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "sync_data_strategy"});
        }

        public Builder() {
            this.user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source(Source r100) {
            this.source = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }

        public Builder user_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserPrivateDescriptionsRequest extends ProtoAdapter<GetUserPrivateDescriptionsRequest> implements c<GetUserPrivateDescriptionsRequest> {
        public ProtoAdapter_GetUserPrivateDescriptionsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserPrivateDescriptionsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserPrivateDescriptionsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source = Source.UNKNOWN_SOURCE;
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.user_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
        public int encodedSize2(GetUserPrivateDescriptionsRequest r100) {
            int r101 = ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.user_ids);
            Source r102 = r100.source;
            if (r102 == null) goto L5;
            int r103 = Source.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return ((r101 + r103) + SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r100.sync_data_strategy)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserPrivateDescriptionsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserPrivateDescriptionsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserPrivateDescriptionsRequest r101) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.user_ids);
            Source r102 = r101.source;
            if (r102 == null) goto L5;
            Source.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r101.sync_data_strategy);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserPrivateDescriptionsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source CHAT_MEMBER = null;
        public static final Source CHAT_MESSAGE = null;
        public static final Source CONTACT_IN_ORGANIZATION = null;
        public static final Source MENTION = null;
        public static final Source P2P_CHAT_SUBTITLE = null;
        public static final Source PICKER = null;
        public static final Source PROFILE_CARD = null;
        public static final Source UNKNOWN_SOURCE = null;
        private final int value;

        static {
            Source r100 = new Source("UNKNOWN_SOURCE", 0, 0);
            UNKNOWN_SOURCE = r100;
            Source r101 = new Source("CHAT_MESSAGE", 1, 1);
            CHAT_MESSAGE = r101;
            Source r102 = new Source("P2P_CHAT_SUBTITLE", 2, 2);
            P2P_CHAT_SUBTITLE = r102;
            Source r103 = new Source("PROFILE_CARD", 3, 3);
            PROFILE_CARD = r103;
            Source r104 = new Source("MENTION", 4, 4);
            MENTION = r104;
            Source r105 = new Source("PICKER", 5, 5);
            PICKER = r105;
            Source r110 = new Source("CHAT_MEMBER", 6, 6);
            CHAT_MEMBER = r110;
            Source r111 = new Source("CONTACT_IN_ORGANIZATION", 7, 7);
            CONTACT_IN_ORGANIZATION = r111;
            $VALUES = new Source[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r100) {
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
            return CONTACT_IN_ORGANIZATION;
        L8:
            return CHAT_MEMBER;
        L10:
            return PICKER;
        L12:
            return MENTION;
        L14:
            return PROFILE_CARD;
        L16:
            return P2P_CHAT_SUBTITLE;
        L18:
            return CHAT_MESSAGE;
        L20:
            return UNKNOWN_SOURCE;
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetUserPrivateDescriptionsRequest r100 = new ProtoAdapter_GetUserPrivateDescriptionsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SOURCE = Source.UNKNOWN_SOURCE;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_ids = Internal.copyOf("user_ids", this.user_ids);
        r100.source = this.source;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserPrivateDescriptionsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserPrivateDescriptionsRequest(List<Long> r100, Source r101, SyncDataStrategy r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetUserPrivateDescriptionsRequest(List<Long> r100, Source r101, SyncDataStrategy r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_ids = Internal.immutableCopyOf("user_ids", r100);
        this.source = r101;
        this.sync_data_strategy = r102;
    }
}
