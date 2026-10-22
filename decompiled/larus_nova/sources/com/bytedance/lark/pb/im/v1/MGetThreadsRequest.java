package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MGetThreadsRequest extends Message<MGetThreadsRequest, Builder> {
    public static final ProtoAdapter<MGetThreadsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FOR_NORMAL_CHAT_MESSAGE = null;
    public static final Boolean DEFAULT_SHOULD_AUTH = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_MGetThreadsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean for_normal_chat_message;
    public final Boolean should_auth;
    public final SyncDataStrategy strategy;
    public final List<String> thread_ids;

    public static final class Builder extends Message.Builder<MGetThreadsRequest, Builder> implements d<MGetThreadsRequest> {
        public Boolean for_normal_chat_message;
        public Boolean should_auth;
        public SyncDataStrategy strategy;
        public List<String> thread_ids;

        @Override // com.squareup.wire.Message.Builder
        public MGetThreadsRequest build() {
            return new MGetThreadsRequest(this.thread_ids, this.should_auth, this.strategy, this.for_normal_chat_message, super.buildUnknownFields());
        }

        public Builder() {
            this.thread_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder for_normal_chat_message(Boolean r100) {
            this.for_normal_chat_message = r100;
            return this;
        }

        public Builder should_auth(Boolean r100) {
            this.should_auth = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder thread_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.thread_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetThreadsRequest extends ProtoAdapter<MGetThreadsRequest> implements c<MGetThreadsRequest> {
        public ProtoAdapter_MGetThreadsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetThreadsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetThreadsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.should_auth = r102;
            r101.strategy = SyncDataStrategy.TRY_LOCAL;
            r101.for_normal_chat_message = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.thread_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.should_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.for_normal_chat_message = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MGetThreadsRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.thread_ids);
            Boolean r102 = r100.should_auth;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            SyncDataStrategy r106 = r100.strategy;
            if (r106 == null) goto L9;
            int r107 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.for_normal_chat_message;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetThreadsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetThreadsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetThreadsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.thread_ids);
            Boolean r102 = r101.should_auth;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            SyncDataStrategy r103 = r101.strategy;
            if (r103 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.for_normal_chat_message;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetThreadsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetThreadsRequest r100 = new ProtoAdapter_MGetThreadsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_SHOULD_AUTH = r101;
        DEFAULT_STRATEGY = SyncDataStrategy.TRY_LOCAL;
        DEFAULT_FOR_NORMAL_CHAT_MESSAGE = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.thread_ids = Internal.copyOf("thread_ids", this.thread_ids);
        r100.should_auth = this.should_auth;
        r100.strategy = this.strategy;
        r100.for_normal_chat_message = this.for_normal_chat_message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetThreadsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetThreadsRequest(List<String> r100, Boolean r101, SyncDataStrategy r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MGetThreadsRequest(List<String> r100, Boolean r101, SyncDataStrategy r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.thread_ids = Internal.immutableCopyOf("thread_ids", r100);
        this.should_auth = r101;
        this.strategy = r102;
        this.for_normal_chat_message = r103;
    }
}
