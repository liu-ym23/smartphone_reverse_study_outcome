package com.bytedance.lark.pb.im.v1;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Transmit2ThreadTarget extends Message<Transmit2ThreadTarget, Builder> {
    public static final ProtoAdapter<Transmit2ThreadTarget> ADAPTER = null;
    public static final String DEFAULT_CHANNEL_ID = "";
    public static final String DEFAULT_THREAD_ID = "";
    private static final long serialVersionUID = 0;
    public final String channel_id;
    public final String thread_id;

    public static final class Builder extends Message.Builder<Transmit2ThreadTarget, Builder> {
        public String channel_id;
        public String thread_id;

        @Override // com.squareup.wire.Message.Builder
        public Transmit2ThreadTarget build() {
            String r100 = this.thread_id;
            if (r100 == null) goto L9;
            if (this.channel_id == null) goto L9;
            return new Transmit2ThreadTarget(this.thread_id, this.channel_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, CrashHianalyticsData.THREAD_ID, this.channel_id, "channel_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel_id(String r100) {
            this.channel_id = r100;
            return this;
        }

        public Builder thread_id(String r100) {
            this.thread_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Transmit2ThreadTarget extends ProtoAdapter<Transmit2ThreadTarget> {
        public ProtoAdapter_Transmit2ThreadTarget() {
            super(FieldEncoding.LENGTH_DELIMITED, Transmit2ThreadTarget.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Transmit2ThreadTarget decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.thread_id = "";
            r101.channel_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.thread_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.channel_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Transmit2ThreadTarget r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.thread_id) + r101.encodedSizeWithTag(2, r100.channel_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Transmit2ThreadTarget decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Transmit2ThreadTarget r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Transmit2ThreadTarget r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.thread_id);
            r102.encodeWithTag(r100, 2, r101.channel_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Transmit2ThreadTarget r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Transmit2ThreadTarget();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.thread_id = this.thread_id;
        r100.channel_id = this.channel_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Transmit2ThreadTarget.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Transmit2ThreadTarget(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Transmit2ThreadTarget(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.thread_id = r100;
        this.channel_id = r101;
    }
}
