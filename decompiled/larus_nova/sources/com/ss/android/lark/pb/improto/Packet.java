package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Packet extends Message<Packet, Builder> {
    public static final ProtoAdapter<Packet> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final Integer DEFAULT_COMMAND = null;
    public static final Long DEFAULT_CURSOR = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_SID = "";
    public static final Integer DEFAULT_STATUS = null;
    public static final Integer DEFAULT_WAIT_RETRY_INTERVAL = null;
    private static final long serialVersionUID = 0;
    public final String mcid;
    public final Command mcmd;
    public final Integer mcommand;
    public final List<Long> mcompacted_sids;
    public final Long mcursor;
    public final ByteString mpayload;
    public final PayloadType mpayload_type;
    public final List<PipeEntity> mpipe_entities;
    public final PipeEntity mpipe_entity;
    public final String msid;
    public final Integer mstatus;
    public final List<VersionPayload> mversion_payloads;
    public final Integer mwait_retry_interval;

    public static final class Builder extends Message.Builder<Packet, Builder> {
        public String mcid;
        public Command mcmd;
        public Integer mcommand;
        public List<Long> mcompacted_sids;
        public Long mcursor;
        public ByteString mpayload;
        public PayloadType mpayload_type;
        public List<PipeEntity> mpipe_entities;
        public PipeEntity mpipe_entity;
        public String msid;
        public Integer mstatus;
        public List<VersionPayload> mversion_payloads;
        public Integer mwait_retry_interval;

        @Override // com.squareup.wire.Message.Builder
        public Packet build() {
            PayloadType r100 = this.mpayload_type;
            if (r100 == null) goto L9;
            if (this.mcmd == null) goto L9;
            return new Packet(this.msid, this.mpayload_type, this.mcmd, this.mstatus, this.mpayload, this.mcid, this.mpipe_entity, this.mversion_payloads, this.mpipe_entities, this.mwait_retry_interval, this.mcommand, this.mcursor, this.mcompacted_sids, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mpayload_type", this.mcmd, "mcmd"});
        }

        public Builder() {
            this.mversion_payloads = Internal.newMutableList();
            this.mpipe_entities = Internal.newMutableList();
            this.mcompacted_sids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.mcid = r100;
            return this;
        }

        public Builder cmd(Command r100) {
            this.mcmd = r100;
            return this;
        }

        public Builder command(Integer r100) {
            this.mcommand = r100;
            return this;
        }

        public Builder compacted_sids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcompacted_sids = r100;
            return this;
        }

        public Builder cursor(Long r100) {
            this.mcursor = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.mpayload = r100;
            return this;
        }

        public Builder payload_type(PayloadType r100) {
            this.mpayload_type = r100;
            return this;
        }

        public Builder pipe_entities(List<PipeEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpipe_entities = r100;
            return this;
        }

        public Builder pipe_entity(PipeEntity r100) {
            this.mpipe_entity = r100;
            return this;
        }

        public Builder sid(String r100) {
            this.msid = r100;
            return this;
        }

        public Builder status(Integer r100) {
            this.mstatus = r100;
            return this;
        }

        public Builder version_payloads(List<VersionPayload> r100) {
            Internal.checkElementsNotNull(r100);
            this.mversion_payloads = r100;
            return this;
        }

        public Builder wait_retry_interval(Integer r100) {
            this.mwait_retry_interval = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Packet extends ProtoAdapter<Packet> {
        public ProtoAdapter_Packet() {
            super(FieldEncoding.LENGTH_DELIMITED, Packet.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Packet decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msid = "";
            r101.mstatus = 200;
            r101.mpayload = ByteString.EMPTY;
            r101.mcid = "";
            r101.mwait_retry_interval = 0;
            r101.mcommand = 0;
            r101.mcursor = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L28;
                case 3: goto L30;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L28:
            r101.mpayload_type = PayloadType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.mcmd = Command.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mcompacted_sids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            r101.mcursor = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L9:
            r101.mcommand = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.mwait_retry_interval = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L11:
            r101.mpipe_entities.add(PipeEntity.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.mversion_payloads.add(VersionPayload.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mpipe_entity = PipeEntity.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.mcid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mpayload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L16:
            r101.mstatus = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L25:
            r101.msid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Packet r100) {
            String r101 = r100.msid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + PayloadType.ADAPTER.encodedSizeWithTag(2, r100.mpayload_type)) + Command.ADAPTER.encodedSizeWithTag(3, r100.mcmd);
            Integer r105 = r100.mstatus;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.UINT32.encodedSizeWithTag(4, r105);
        L10:
            int r107 = r104 + r106;
            ByteString r108 = r100.mpayload;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r108);
        L14:
            int r110 = r107 + r109;
            String r111 = r100.mcid;
            if (r111 == null) goto L17;
            int r112 = ProtoAdapter.STRING.encodedSizeWithTag(6, r111);
        L18:
            int r113 = r110 + r112;
            PipeEntity r114 = r100.mpipe_entity;
            if (r114 == null) goto L21;
            int r115 = PipeEntity.ADAPTER.encodedSizeWithTag(7, r114);
        L22:
            int r116 = ((r113 + r115) + VersionPayload.ADAPTER.asRepeated().encodedSizeWithTag(8, r100.mversion_payloads)) + PipeEntity.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.mpipe_entities);
            Integer r117 = r100.mwait_retry_interval;
            if (r117 == null) goto L25;
            int r118 = ProtoAdapter.UINT32.encodedSizeWithTag(10, r117);
        L26:
            int r119 = r116 + r118;
            Integer r120 = r100.mcommand;
            if (r120 == null) goto L29;
            int r121 = ProtoAdapter.INT32.encodedSizeWithTag(11, r120);
        L30:
            int r122 = r119 + r121;
            Long r123 = r100.mcursor;
            if (r123 == null) goto L34;
            r102 = ProtoAdapter.UINT64.encodedSizeWithTag(12, r123);
        L34:
            return ((r122 + r102) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(13, r100.mcompacted_sids)) + r100.unknownFields().size();
        L29:
            r121 = 0;
            goto L30
        L25:
            r118 = 0;
            goto L26
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Packet decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Packet r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Packet r101) throws IOException {
            String r102 = r101.msid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            PayloadType.ADAPTER.encodeWithTag(r100, 2, r101.mpayload_type);
            Command.ADAPTER.encodeWithTag(r100, 3, r101.mcmd);
            Integer r103 = r101.mstatus;
            if (r103 == null) goto L8;
            ProtoAdapter.UINT32.encodeWithTag(r100, 4, r103);
        L8:
            ByteString r104 = r101.mpayload;
            if (r104 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 5, r104);
        L11:
            String r105 = r101.mcid;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            PipeEntity r106 = r101.mpipe_entity;
            if (r106 == null) goto L17;
            PipeEntity.ADAPTER.encodeWithTag(r100, 7, r106);
        L17:
            VersionPayload.ADAPTER.asRepeated().encodeWithTag(r100, 8, r101.mversion_payloads);
            PipeEntity.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.mpipe_entities);
            Integer r107 = r101.mwait_retry_interval;
            if (r107 == null) goto L20;
            ProtoAdapter.UINT32.encodeWithTag(r100, 10, r107);
        L20:
            Integer r108 = r101.mcommand;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r108);
        L23:
            Long r109 = r101.mcursor;
            if (r109 == null) goto L26;
            ProtoAdapter.UINT64.encodeWithTag(r100, 12, r109);
        L26:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 13, r101.mcompacted_sids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Packet r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class VersionPayload extends Message<VersionPayload, Builder> {
        public static final ProtoAdapter<VersionPayload> ADAPTER = null;
        public static final ByteString DEFAULT_PAYLOAD = null;
        private static final long serialVersionUID = 0;
        public final ByteString mpayload;
        public final VersionRange mversion_range;

        public static final class Builder extends Message.Builder<VersionPayload, Builder> {
            public ByteString mpayload;
            public VersionRange mversion_range;

            @Override // com.squareup.wire.Message.Builder
            public VersionPayload build() {
                VersionRange r100 = this.mversion_range;
                if (r100 == null) goto L9;
                if (this.mpayload == null) goto L9;
                return new VersionPayload(this.mversion_range, this.mpayload, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mversion_range", this.mpayload, "mpayload"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder payload(ByteString r100) {
                this.mpayload = r100;
                return this;
            }

            public Builder version_range(VersionRange r100) {
                this.mversion_range = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_VersionPayload extends ProtoAdapter<VersionPayload> {
            public ProtoAdapter_VersionPayload() {
                super(FieldEncoding.LENGTH_DELIMITED, VersionPayload.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public VersionPayload decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mpayload = ByteString.EMPTY;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mversion_range = VersionRange.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mpayload = ProtoAdapter.BYTES.decode(r100);
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
            public int encodedSize2(VersionPayload r100) {
                return (VersionRange.ADAPTER.encodedSizeWithTag(1, r100.mversion_range) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r100.mpayload)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ VersionPayload decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(VersionPayload r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, VersionPayload r101) throws IOException {
                VersionRange.ADAPTER.encodeWithTag(r100, 1, r101.mversion_range);
                ProtoAdapter.BYTES.encodeWithTag(r100, 2, r101.mpayload);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VersionPayload r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_VersionPayload();
            DEFAULT_PAYLOAD = ByteString.EMPTY;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mversion_range = this.mversion_range;
            r100.mpayload = this.mpayload;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return VersionPayload.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public VersionPayload(VersionRange r100, ByteString r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public VersionPayload(VersionRange r100, ByteString r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mversion_range = r100;
            this.mpayload = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Packet();
        DEFAULT_STATUS = 200;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_WAIT_RETRY_INTERVAL = 0;
        DEFAULT_COMMAND = 0;
        DEFAULT_CURSOR = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msid = this.msid;
        r100.mpayload_type = this.mpayload_type;
        r100.mcmd = this.mcmd;
        r100.mstatus = this.mstatus;
        r100.mpayload = this.mpayload;
        r100.mcid = this.mcid;
        r100.mpipe_entity = this.mpipe_entity;
        r100.mversion_payloads = Internal.copyOf("mversion_payloads", this.mversion_payloads);
        r100.mpipe_entities = Internal.copyOf("mpipe_entities", this.mpipe_entities);
        r100.mwait_retry_interval = this.mwait_retry_interval;
        r100.mcommand = this.mcommand;
        r100.mcursor = this.mcursor;
        r100.mcompacted_sids = Internal.copyOf("mcompacted_sids", this.mcompacted_sids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Packet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Packet(String r110, PayloadType r111, Command r112, Integer r113, ByteString r210, String r211, PipeEntity r212, List<VersionPayload> r213, List<PipeEntity> r214, Integer r215, Integer r216, Long r217, List<Long> r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public Packet(String r100, PayloadType r101, Command r102, Integer r103, ByteString r104, String r105, PipeEntity r106, List<VersionPayload> r107, List<PipeEntity> r110, Integer r111, Integer r112, Long r113, List<Long> r114, ByteString r115) {
        super(ADAPTER, r115);
        this.msid = r100;
        this.mpayload_type = r101;
        this.mcmd = r102;
        this.mstatus = r103;
        this.mpayload = r104;
        this.mcid = r105;
        this.mpipe_entity = r106;
        this.mversion_payloads = Internal.immutableCopyOf("mversion_payloads", r107);
        this.mpipe_entities = Internal.immutableCopyOf("mpipe_entities", r110);
        this.mwait_retry_interval = r111;
        this.mcommand = r112;
        this.mcursor = r113;
        this.mcompacted_sids = Internal.immutableCopyOf("mcompacted_sids", r114);
    }
}
