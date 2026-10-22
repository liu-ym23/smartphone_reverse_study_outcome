package com.bytedance.lark.pb.im.v1;

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
public final class GetMessageFoldFollowListRequest extends Message<GetMessageFoldFollowListRequest, Builder> {
    public static final ProtoAdapter<GetMessageFoldFollowListRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final Integer DEFAULT_LIMIT = null;
    public static final Long DEFAULT_START_TIME_MS = null;
    public static final ProtoAdapter_GetMessageFoldFollowListRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;
    public final Long fold_id;
    public final Integer limit;
    public final Long start_time_ms;

    public static final class Builder extends Message.Builder<GetMessageFoldFollowListRequest, Builder> implements d<GetMessageFoldFollowListRequest> {
        public Long chat_id;
        public Long fold_id;
        public Integer limit;
        public Long start_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public GetMessageFoldFollowListRequest build() {
            return new GetMessageFoldFollowListRequest(this.fold_id, this.start_time_ms, this.limit, this.chat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder fold_id(Long r100) {
            this.fold_id = r100;
            return this;
        }

        public Builder limit(Integer r100) {
            this.limit = r100;
            return this;
        }

        public Builder start_time_ms(Long r100) {
            this.start_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetMessageFoldFollowListRequest extends ProtoAdapter<GetMessageFoldFollowListRequest> implements c<GetMessageFoldFollowListRequest> {
        public ProtoAdapter_GetMessageFoldFollowListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetMessageFoldFollowListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetMessageFoldFollowListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.fold_id = 0L;
            r101.start_time_ms = 0L;
            r101.limit = 0;
            r101.chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.fold_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.start_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.limit = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetMessageFoldFollowListRequest r100) {
            Long r101 = r100.fold_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.start_time_ms;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.limit;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.chat_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetMessageFoldFollowListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetMessageFoldFollowListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetMessageFoldFollowListRequest r101) throws IOException {
            Long r102 = r101.fold_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.start_time_ms;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.limit;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.chat_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetMessageFoldFollowListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetMessageFoldFollowListRequest r100 = new ProtoAdapter_GetMessageFoldFollowListRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_START_TIME_MS = 0L;
        DEFAULT_LIMIT = 0;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fold_id = this.fold_id;
        r100.start_time_ms = this.start_time_ms;
        r100.limit = this.limit;
        r100.chat_id = this.chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetMessageFoldFollowListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetMessageFoldFollowListRequest(Long r100, Long r101, Integer r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetMessageFoldFollowListRequest(Long r100, Long r101, Integer r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.fold_id = r100;
        this.start_time_ms = r101;
        this.limit = r102;
        this.chat_id = r103;
    }
}
