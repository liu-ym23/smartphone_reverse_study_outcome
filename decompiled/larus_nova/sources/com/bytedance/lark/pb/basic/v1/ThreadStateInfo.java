package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ThreadStateInfo extends com.squareup.wire.Message<ThreadStateInfo, Builder> {
    public static final ProtoAdapter<ThreadStateInfo> ADAPTER = null;
    public static final String DEFAULT_OPERATOR_ID = "";
    public static final ThreadState DEFAULT_STATE = null;
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;
    public final String operator_id;
    public final ThreadState state;
    public final Long update_time_ms;

    public static final class Builder extends com.squareup.wire.Message.Builder<ThreadStateInfo, Builder> {
        public String operator_id;
        public ThreadState state;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public ThreadStateInfo build() {
            return new ThreadStateInfo(this.state, this.operator_id, this.update_time_ms, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder operator_id(String r100) {
            this.operator_id = r100;
            return this;
        }

        public Builder state(ThreadState r100) {
            this.state = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ThreadStateInfo extends ProtoAdapter<ThreadStateInfo> {
        public ProtoAdapter_ThreadStateInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ThreadStateInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ThreadStateInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.state = ThreadState.UNKNOWN_STATE;
            r101.operator_id = "";
            r101.update_time_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.state = ThreadState.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.operator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.update_time_ms = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(ThreadStateInfo r100) {
            ThreadState r101 = r100.state;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ThreadState.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.operator_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.update_time_ms;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ ThreadStateInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ThreadStateInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ThreadStateInfo r101) throws IOException {
            ThreadState r102 = r101.state;
            if (r102 == null) goto L5;
            ThreadState.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.operator_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.update_time_ms;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ThreadStateInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ThreadStateInfo();
        DEFAULT_STATE = ThreadState.UNKNOWN_STATE;
        DEFAULT_UPDATE_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.state = this.state;
        r100.operator_id = this.operator_id;
        r100.update_time_ms = this.update_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ThreadStateInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ThreadStateInfo(ThreadState r100, String r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ThreadStateInfo(ThreadState r100, String r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.state = r100;
        this.operator_id = r101;
        this.update_time_ms = r102;
    }
}
