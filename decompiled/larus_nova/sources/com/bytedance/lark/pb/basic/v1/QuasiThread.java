package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class QuasiThread extends com.squareup.wire.Message<QuasiThread, Builder> {
    public static final ProtoAdapter<QuasiThread> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final String DEFAULT_TOPIC = "";
    private static final long serialVersionUID = 0;
    public final Channel channel;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253539id;
    public final Integer position;
    public final String topic;

    public static final class Builder extends com.squareup.wire.Message.Builder<QuasiThread, Builder> {
        public Channel channel;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253540id;
        public Integer position;
        public String topic;

        @Override // com.squareup.wire.Message.Builder
        public QuasiThread build() {
            String r100 = this.f253540id;
            if (r100 == null) goto L9;
            if (this.channel == null) goto L9;
            return new QuasiThread(this.f253540id, this.channel, this.topic, this.position, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.channel, "channel"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253540id = r100;
            return this;
        }

        public Builder position(Integer r100) {
            this.position = r100;
            return this;
        }

        public Builder topic(String r100) {
            this.topic = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_QuasiThread extends ProtoAdapter<QuasiThread> {
        public ProtoAdapter_QuasiThread() {
            super(FieldEncoding.LENGTH_DELIMITED, QuasiThread.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QuasiThread decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253540id = "";
            r101.topic = "";
            r101.position = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253540id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.topic = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.position = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(QuasiThread r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253539id) + Channel.ADAPTER.encodedSizeWithTag(2, r100.channel);
            String r103 = r100.topic;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.position;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ QuasiThread decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QuasiThread r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QuasiThread r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253539id);
            Channel.ADAPTER.encodeWithTag(r100, 2, r101.channel);
            String r103 = r101.topic;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            Integer r104 = r101.position;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QuasiThread r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuasiThread();
        DEFAULT_POSITION = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253540id = this.f253539id;
        r100.channel = this.channel;
        r100.topic = this.topic;
        r100.position = this.position;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QuasiThread.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public QuasiThread(String r100, Channel r101, String r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public QuasiThread(String r100, Channel r101, String r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.f253539id = r100;
        this.channel = r101;
        this.topic = r102;
        this.position = r103;
    }
}
