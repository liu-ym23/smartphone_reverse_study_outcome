package com.bytedance.lark.pb.im.v1;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
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
public final class GetUnreadAtMessagesRequest extends Message<GetUnreadAtMessagesRequest, Builder> {
    public static final ProtoAdapter<GetUnreadAtMessagesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IGNORE_BADGED = null;
    public static final Boolean DEFAULT_NEED_RESPONSE = null;
    public static final ProtoAdapter_GetUnreadAtMessagesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chat_ids;
    public final Boolean ignore_badged;
    public final Boolean need_response;
    public final List<Query> queries;

    public static final class Builder extends Message.Builder<GetUnreadAtMessagesRequest, Builder> implements d<GetUnreadAtMessagesRequest> {
        public List<String> chat_ids;
        public Boolean ignore_badged;
        public Boolean need_response;
        public List<Query> queries;

        @Override // com.squareup.wire.Message.Builder
        public GetUnreadAtMessagesRequest build() {
            return new GetUnreadAtMessagesRequest(this.chat_ids, this.ignore_badged, this.need_response, this.queries, super.buildUnknownFields());
        }

        public Builder() {
            this.chat_ids = Internal.newMutableList();
            this.queries = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_ids = r100;
            return this;
        }

        public Builder ignore_badged(Boolean r100) {
            this.ignore_badged = r100;
            return this;
        }

        public Builder need_response(Boolean r100) {
            this.need_response = r100;
            return this;
        }

        public Builder queries(List<Query> r100) {
            Internal.checkElementsNotNull(r100);
            this.queries = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUnreadAtMessagesRequest extends ProtoAdapter<GetUnreadAtMessagesRequest> implements c<GetUnreadAtMessagesRequest> {
        public ProtoAdapter_GetUnreadAtMessagesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUnreadAtMessagesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUnreadAtMessagesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.TRUE;
            r101.ignore_badged = r102;
            r101.need_response = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.ignore_badged = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.need_response = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.queries.add(Query.ADAPTER.decode(r100));
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUnreadAtMessagesRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.chat_ids);
            Boolean r102 = r100.ignore_badged;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.need_response;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return ((r105 + r103) + Query.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.queries)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUnreadAtMessagesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUnreadAtMessagesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUnreadAtMessagesRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.chat_ids);
            Boolean r102 = r101.ignore_badged;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.need_response;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Query.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.queries);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUnreadAtMessagesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Query extends Message<Query, Builder> {
        public static final ProtoAdapter<Query> ADAPTER = null;
        public static final AtType DEFAULT_AT_TYPE = null;
        public static final Long DEFAULT_CHAT_ID = null;
        public static final Long DEFAULT_THREAD_ID = null;
        private static final long serialVersionUID = 0;
        public final AtType at_type;
        public final Long chat_id;
        public final Long thread_id;

        public static final enum AtType extends Enum<AtType> implements WireEnum {
            private static final /* synthetic */ AtType[] $VALUES = null;
            public static final ProtoAdapter<AtType> ADAPTER = null;
            public static final AtType All = null;
            public static final AtType Default = null;
            public static final AtType Me = null;
            private final int value;

            static {
                AtType r100 = new AtType("Default", 0, 0);
                Default = r100;
                AtType r101 = new AtType(CancelRetainContactInfoFunctions.All, 1, 1);
                All = r101;
                AtType r102 = new AtType("Me", 2, 2);
                Me = r102;
                $VALUES = new AtType[]{r100, r101, r102};
                ADAPTER = ProtoAdapter.newEnumAdapter(AtType.class);
            }

            public static AtType[] values() {
                return (AtType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static AtType fromValue(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return Me;
            L12:
                return All;
            L14:
                return Default;
            }

            public static AtType valueOf(String r100) {
                return (AtType) a.a(AtType.class, r100);
            }

            private AtType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class Builder extends Message.Builder<Query, Builder> {
            public AtType at_type;
            public Long chat_id;
            public Long thread_id;

            @Override // com.squareup.wire.Message.Builder
            public Query build() {
                return new Query(this.chat_id, this.thread_id, this.at_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder at_type(AtType r100) {
                this.at_type = r100;
                return this;
            }

            public Builder chat_id(Long r100) {
                this.chat_id = r100;
                return this;
            }

            public Builder thread_id(Long r100) {
                this.thread_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Query extends ProtoAdapter<Query> {
            public ProtoAdapter_Query() {
                super(FieldEncoding.LENGTH_DELIMITED, Query.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Query decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.chat_id = 0L;
                r101.thread_id = 0L;
                r101.at_type = AtType.Default;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.chat_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.thread_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.at_type = AtType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
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
            public int encodedSize2(Query r100) {
                Long r101 = r100.chat_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.thread_id;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                AtType r107 = r100.at_type;
                if (r107 == null) goto L14;
                r102 = AtType.ADAPTER.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ Query decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Query r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Query r101) throws IOException {
                Long r102 = r101.chat_id;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.thread_id;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                AtType r104 = r101.at_type;
                if (r104 == null) goto L11;
                AtType.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Query r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Query();
            DEFAULT_CHAT_ID = 0L;
            DEFAULT_THREAD_ID = 0L;
            DEFAULT_AT_TYPE = AtType.Default;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.chat_id = this.chat_id;
            r100.thread_id = this.thread_id;
            r100.at_type = this.at_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Query.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Query(Long r100, Long r101, AtType r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Query(Long r100, Long r101, AtType r102, ByteString r103) {
            super(ADAPTER, r103);
            this.chat_id = r100;
            this.thread_id = r101;
            this.at_type = r102;
        }
    }

    static {
        ProtoAdapter_GetUnreadAtMessagesRequest r100 = new ProtoAdapter_GetUnreadAtMessagesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.TRUE;
        DEFAULT_IGNORE_BADGED = r101;
        DEFAULT_NEED_RESPONSE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
        r100.ignore_badged = this.ignore_badged;
        r100.need_response = this.need_response;
        r100.queries = Internal.copyOf("queries", this.queries);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUnreadAtMessagesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUnreadAtMessagesRequest(List<String> r100, Boolean r101, Boolean r102, List<Query> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetUnreadAtMessagesRequest(List<String> r100, Boolean r101, Boolean r102, List<Query> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_ids = Internal.immutableCopyOf("chat_ids", r100);
        this.ignore_badged = r101;
        this.need_response = r102;
        this.queries = Internal.immutableCopyOf("queries", r103);
    }
}
