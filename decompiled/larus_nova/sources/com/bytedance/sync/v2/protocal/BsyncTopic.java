package com.bytedance.sync.v2.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class BsyncTopic extends Message<BsyncTopic, Builder> {
    public static final ProtoAdapter<BsyncTopic> ADAPTER = null;
    public static final Bucket DEFAULT_BUCKET = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final Flag DEFAULT_FLAG = null;
    public static final Long DEFAULT_NEW_CURSOR = null;
    public static final Long DEFAULT_REF_CURSOR = null;
    public static final String DEFAULT_REQ_ID = "";
    public static final Long DEFAULT_SYNC_ID = null;
    public static final TopicStatus DEFAULT_TOPIC_STATUS = null;
    public static final TopicType DEFAULT_TOPIC_TYPE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.Bucket#ADAPTER", tag = 2)
    public final Bucket bucket;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 9)
    public final Long expire_time;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.Flag#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final Flag flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    public final Long new_cursor;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.BsyncPacket#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<BsyncPacket> packets;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long ref_cursor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 255)
    public final String req_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long sync_id;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.TopicStatus#ADAPTER", tag = 8)
    public final TopicStatus topic_status;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.TopicType#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final TopicType topic_type;

    public static final class Builder extends Message.Builder<BsyncTopic, Builder> {
        public Bucket bucket;
        public Long expire_time;
        public Flag flag;
        public Long new_cursor;
        public List<BsyncPacket> packets;
        public Long ref_cursor;
        public String req_id;
        public Long sync_id;
        public TopicStatus topic_status;
        public TopicType topic_type;

        @Override // com.squareup.wire.Message.Builder
        public BsyncTopic build() {
            Flag r100 = this.flag;
            if (r100 == null) goto L9;
            if (this.topic_type == null) goto L9;
            return new BsyncTopic(this.flag, this.bucket, this.topic_type, this.sync_id, this.ref_cursor, this.new_cursor, this.packets, this.topic_status, this.expire_time, this.req_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, ForwardDependency$ForwardLocation.FLAG, this.topic_type, "topic_type"});
        }

        public Builder() {
            this.packets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bucket(Bucket r100) {
            this.bucket = r100;
            return this;
        }

        public Builder expire_time(Long r100) {
            this.expire_time = r100;
            return this;
        }

        public Builder flag(Flag r100) {
            this.flag = r100;
            return this;
        }

        public Builder new_cursor(Long r100) {
            this.new_cursor = r100;
            return this;
        }

        public Builder packets(List<BsyncPacket> r100) {
            Internal.checkElementsNotNull(r100);
            this.packets = r100;
            return this;
        }

        public Builder ref_cursor(Long r100) {
            this.ref_cursor = r100;
            return this;
        }

        public Builder req_id(String r100) {
            this.req_id = r100;
            return this;
        }

        public Builder sync_id(Long r100) {
            this.sync_id = r100;
            return this;
        }

        public Builder topic_status(TopicStatus r100) {
            this.topic_status = r100;
            return this;
        }

        public Builder topic_type(TopicType r100) {
            this.topic_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BsyncTopic extends ProtoAdapter<BsyncTopic> {
        public ProtoAdapter_BsyncTopic() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncTopic.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncTopic decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L31;
            if (r103 != 255) goto L7;
            r101.req_id(ProtoAdapter.STRING.decode(r100));
            goto L3
        L7:
            switch(r103) {
                case 1: goto L35;
                case 2: goto L37;
                case 3: goto L39;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L33;
                case 9: goto L9;
                default: goto L8;
            };
        L33:
            r101.topic_status(TopicStatus.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r101.flag(Flag.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L37:
            r101.bucket(Bucket.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r101.topic_type(TopicType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            r101.expire_time(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            r101.packets.add(BsyncPacket.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.new_cursor(ProtoAdapter.INT64.decode(r100));
            goto L3
        L16:
            r101.ref_cursor(ProtoAdapter.INT64.decode(r100));
            goto L3
        L17:
            r101.sync_id(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BsyncTopic r100) {
            int r101 = (Flag.ADAPTER.encodedSizeWithTag(1, r100.flag) + Bucket.ADAPTER.encodedSizeWithTag(2, r100.bucket)) + TopicType.ADAPTER.encodedSizeWithTag(3, r100.topic_type);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            return (((((((r101 + r102.encodedSizeWithTag(4, r100.sync_id)) + r102.encodedSizeWithTag(5, r100.ref_cursor)) + r102.encodedSizeWithTag(6, r100.new_cursor)) + BsyncPacket.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.packets)) + TopicStatus.ADAPTER.encodedSizeWithTag(8, r100.topic_status)) + r102.encodedSizeWithTag(9, r100.expire_time)) + ProtoAdapter.STRING.encodedSizeWithTag(255, r100.req_id)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public BsyncTopic redact2(BsyncTopic r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.packets, BsyncPacket.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncTopic decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BsyncTopic r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncTopic redact(BsyncTopic r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BsyncTopic r101) throws IOException {
            Flag.ADAPTER.encodeWithTag(r100, 1, r101.flag);
            Bucket.ADAPTER.encodeWithTag(r100, 2, r101.bucket);
            TopicType.ADAPTER.encodeWithTag(r100, 3, r101.topic_type);
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 4, r101.sync_id);
            r102.encodeWithTag(r100, 5, r101.ref_cursor);
            r102.encodeWithTag(r100, 6, r101.new_cursor);
            BsyncPacket.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.packets);
            TopicStatus.ADAPTER.encodeWithTag(r100, 8, r101.topic_status);
            r102.encodeWithTag(r100, 9, r101.expire_time);
            ProtoAdapter.STRING.encodeWithTag(r100, 255, r101.req_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BsyncTopic r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BsyncTopic();
        DEFAULT_FLAG = Flag.None;
        DEFAULT_BUCKET = Bucket.Device;
        DEFAULT_TOPIC_TYPE = TopicType.SpecTopic;
        DEFAULT_SYNC_ID = 0L;
        DEFAULT_REF_CURSOR = 0L;
        DEFAULT_NEW_CURSOR = 0L;
        DEFAULT_TOPIC_STATUS = TopicStatus.NotExist;
        DEFAULT_EXPIRE_TIME = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L33;
        int r101 = ((unknownFields().hashCode() * 37) + this.flag.hashCode()) * 37;
        Bucket r102 = this.bucket;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (((r101 + r104) * 37) + this.topic_type.hashCode()) * 37;
        Long r106 = this.sync_id;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.ref_cursor;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Long r112 = this.new_cursor;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (((r111 + r113) * 37) + this.packets.hashCode()) * 37;
        TopicStatus r115 = this.topic_status;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        Long r118 = this.expire_time;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        String r121 = this.req_id;
        if (r121 == null) goto L31;
        r103 = r121.hashCode();
    L31:
        int r122 = r120 + r103;
        this.hashCode = r122;
        return r122;
    L27:
        r119 = 0;
        goto L28
    L23:
        r116 = 0;
        goto L24
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L33:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.flag = this.flag;
        r100.bucket = this.bucket;
        r100.topic_type = this.topic_type;
        r100.sync_id = this.sync_id;
        r100.ref_cursor = this.ref_cursor;
        r100.new_cursor = this.new_cursor;
        r100.packets = Internal.copyOf("packets", this.packets);
        r100.topic_status = this.topic_status;
        r100.expire_time = this.expire_time;
        r100.req_id = this.req_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", flag=");
        r100.append(this.flag);
        if (this.bucket == null) goto L5;
        r100.append(", bucket=");
        r100.append(this.bucket);
    L5:
        r100.append(", topic_type=");
        r100.append(this.topic_type);
        if (this.sync_id == null) goto L9;
        r100.append(", sync_id=");
        r100.append(this.sync_id);
    L9:
        if (this.ref_cursor == null) goto L12;
        r100.append(", ref_cursor=");
        r100.append(this.ref_cursor);
    L12:
        if (this.new_cursor == null) goto L15;
        r100.append(", new_cursor=");
        r100.append(this.new_cursor);
    L15:
        if (this.packets.isEmpty() == true) goto L18;
        r100.append(", packets=");
        r100.append(this.packets);
    L18:
        if (this.topic_status == null) goto L21;
        r100.append(", topic_status=");
        r100.append(this.topic_status);
    L21:
        if (this.expire_time == null) goto L24;
        r100.append(", expire_time=");
        r100.append(this.expire_time);
    L24:
        if (this.req_id == null) goto L26;
        r100.append(", req_id=");
        r100.append(this.req_id);
    L26:
        StringBuilder r101 = r100.replace(0, 2, "BsyncTopic{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BsyncTopic) == true) goto L8;
        return false;
    L8:
        BsyncTopic r101 = (BsyncTopic) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L31:
        return false;
    L11:
        if (this.flag.equals(r101.flag) == false) goto L31;
        if (Internal.equals(this.bucket, r101.bucket) == false) goto L31;
        if (this.topic_type.equals(r101.topic_type) == false) goto L31;
        if (Internal.equals(this.sync_id, r101.sync_id) == false) goto L31;
        if (Internal.equals(this.ref_cursor, r101.ref_cursor) == false) goto L31;
        if (Internal.equals(this.new_cursor, r101.new_cursor) == false) goto L31;
        if (this.packets.equals(r101.packets) == false) goto L31;
        if (Internal.equals(this.topic_status, r101.topic_status) == false) goto L31;
        if (Internal.equals(this.expire_time, r101.expire_time) == false) goto L31;
        if (Internal.equals(this.req_id, r101.req_id) == false) goto L31;
        return true;
    }

    public BsyncTopic(Flag r110, Bucket r111, TopicType r112, Long r113, Long r114, Long r115, List<BsyncPacket> r116, TopicStatus r210, Long r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public BsyncTopic(Flag r100, Bucket r101, TopicType r102, Long r103, Long r104, Long r105, List<BsyncPacket> r106, TopicStatus r107, Long r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.flag = r100;
        this.bucket = r101;
        this.topic_type = r102;
        this.sync_id = r103;
        this.ref_cursor = r104;
        this.new_cursor = r105;
        this.packets = Internal.immutableCopyOf("packets", r106);
        this.topic_status = r107;
        this.expire_time = r110;
        this.req_id = r111;
    }
}
