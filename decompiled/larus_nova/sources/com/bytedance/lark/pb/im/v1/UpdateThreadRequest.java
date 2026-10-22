package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.ThreadState;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateThreadRequest extends Message<UpdateThreadRequest, Builder> {
    public static final ProtoAdapter<UpdateThreadRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_FOLLOW = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final ThreadState DEFAULT_THREAD_STATE = null;
    public static final String DEFAULT_TOPIC = "";
    public static final ProtoAdapter_UpdateThreadRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_follow;
    public final Boolean is_remind;
    public final String thread_id;
    public final ThreadState thread_state;
    public final String topic;

    public static final class Builder extends Message.Builder<UpdateThreadRequest, Builder> implements d<UpdateThreadRequest> {
        public Boolean is_follow;
        public Boolean is_remind;
        public String thread_id;
        public ThreadState thread_state;
        public String topic;

        @Override // com.squareup.wire.Message.Builder
        public UpdateThreadRequest build() {
            String r100 = this.thread_id;
            if (r100 == null) goto L7;
            return new UpdateThreadRequest(this.thread_id, this.topic, this.is_follow, this.thread_state, this.is_remind, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, CrashHianalyticsData.THREAD_ID});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_follow(Boolean r100) {
            this.is_follow = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }

        public Builder thread_state(ThreadState r100) {
            this.thread_state = r100;
            return this;
        }

        public Builder topic(String r100) {
            this.topic = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateThreadRequest extends ProtoAdapter<UpdateThreadRequest> implements c<UpdateThreadRequest> {
        public ProtoAdapter_UpdateThreadRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateThreadRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateThreadRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.thread_id = "";
            r101.topic = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_follow = r102;
            r101.thread_state = ThreadState.UNKNOWN_STATE;
            r101.is_remind = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L24;
            if (r104 != 1) goto L8;
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.topic = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.is_follow = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.thread_state = ThreadState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateThreadRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.thread_id);
            String r103 = r100.topic;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_follow;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            ThreadState r110 = r100.thread_state;
            if (r110 == null) goto L13;
            int r111 = ThreadState.ADAPTER.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_remind;
            if (r113 == null) goto L18;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ UpdateThreadRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateThreadRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateThreadRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.thread_id);
            String r103 = r101.topic;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.is_follow;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L8:
            ThreadState r105 = r101.thread_state;
            if (r105 == null) goto L11;
            ThreadState.ADAPTER.encodeWithTag(r100, 4, r105);
        L11:
            Boolean r106 = r101.is_remind;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateThreadRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateThreadRequest r100 = new ProtoAdapter_UpdateThreadRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_IS_FOLLOW = r101;
        DEFAULT_THREAD_STATE = ThreadState.UNKNOWN_STATE;
        DEFAULT_IS_REMIND = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.thread_id = this.thread_id;
        r100.topic = this.topic;
        r100.is_follow = this.is_follow;
        r100.thread_state = this.thread_state;
        r100.is_remind = this.is_remind;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateThreadRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateThreadRequest(String r100, String r101, Boolean r110, ThreadState r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UpdateThreadRequest(String r100, String r101, Boolean r102, ThreadState r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.thread_id = r100;
        this.topic = r101;
        this.is_follow = r102;
        this.thread_state = r103;
        this.is_remind = r104;
    }
}
