package com.bytedance.lark.pb.im.v1;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.lark.pb.basic.v1.Channel;
import com.bytedance.lark.pb.basic.v1.HongbaoContent;
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
public final class SendHongbaoRequest extends Message<SendHongbaoRequest, Builder> {
    public static final ProtoAdapter<SendHongbaoRequest> ADAPTER = null;
    public static final Long DEFAULT_COVER_ID = null;
    public static final String DEFAULT_SDK_CONFIG = "";
    public static final String DEFAULT_SUBJECT = "";
    public static final Long DEFAULT_TOTAL_AMOUNT = null;
    public static final Integer DEFAULT_TOTAL_NUM = null;
    public static final HongbaoContent.Type DEFAULT_TYPE = null;
    public static final ProtoAdapter_SendHongbaoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final Long cover_id;
    public final DeviceInfo device_info;
    public final List<Long> receive_user_ids;
    public final String sdk_config;
    public final String subject;
    public final Long total_amount;
    public final Integer total_num;
    public final HongbaoContent.Type type;

    public static final class Builder extends Message.Builder<SendHongbaoRequest, Builder> implements d<SendHongbaoRequest> {
        public Channel channel;
        public Long cover_id;
        public DeviceInfo device_info;
        public List<Long> receive_user_ids;
        public String sdk_config;
        public String subject;
        public Long total_amount;
        public Integer total_num;
        public HongbaoContent.Type type;

        @Override // com.squareup.wire.Message.Builder
        public SendHongbaoRequest build() {
            Long r100 = this.total_amount;
            if (r100 == null) goto L15;
            if (this.total_num == null) goto L15;
            if (this.subject == null) goto L15;
            if (this.type == null) goto L15;
            if (this.channel == null) goto L15;
            return new SendHongbaoRequest(this.total_amount, this.total_num, this.subject, this.type, this.channel, this.sdk_config, this.cover_id, this.device_info, this.receive_user_ids, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "total_amount", this.total_num, "total_num", this.subject, a.KEY_SUBJECT, this.type, "type", this.channel, "channel"});
        }

        public Builder() {
            this.receive_user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder cover_id(Long r100) {
            this.cover_id = r100;
            return this;
        }

        public Builder device_info(DeviceInfo r100) {
            this.device_info = r100;
            return this;
        }

        public Builder receive_user_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.receive_user_ids = r100;
            return this;
        }

        public Builder sdk_config(String r100) {
            this.sdk_config = r100;
            return this;
        }

        public Builder subject(String r100) {
            this.subject = r100;
            return this;
        }

        public Builder total_amount(Long r100) {
            this.total_amount = r100;
            return this;
        }

        public Builder total_num(Integer r100) {
            this.total_num = r100;
            return this;
        }

        public Builder type(HongbaoContent.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class DeviceInfo extends Message<DeviceInfo, Builder> {
        public static final ProtoAdapter<DeviceInfo> ADAPTER = null;
        public static final String DEFAULT_FINANCE_SDK_VERSION = "";
        private static final long serialVersionUID = 0;
        public final String finance_sdk_version;

        public static final class Builder extends Message.Builder<DeviceInfo, Builder> {
            public String finance_sdk_version;

            @Override // com.squareup.wire.Message.Builder
            public DeviceInfo build() {
                return new DeviceInfo(this.finance_sdk_version, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder finance_sdk_version(String r100) {
                this.finance_sdk_version = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DeviceInfo extends ProtoAdapter<DeviceInfo> {
            public ProtoAdapter_DeviceInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DeviceInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DeviceInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.finance_sdk_version = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.finance_sdk_version = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DeviceInfo r100) {
                String r101 = r100.finance_sdk_version;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DeviceInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DeviceInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DeviceInfo r101) throws IOException {
                String r102 = r101.finance_sdk_version;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeviceInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DeviceInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.finance_sdk_version = this.finance_sdk_version;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DeviceInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DeviceInfo(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public DeviceInfo(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.finance_sdk_version = r100;
        }
    }

    public static final class ProtoAdapter_SendHongbaoRequest extends ProtoAdapter<SendHongbaoRequest> implements c<SendHongbaoRequest> {
        public ProtoAdapter_SendHongbaoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendHongbaoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendHongbaoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.total_amount = 0L;
            r101.total_num = 0;
            r101.subject = "";
            r101.type = HongbaoContent.Type.UNKNOWN;
            r101.sdk_config = "";
            r101.cover_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L21;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L6;
                case 9: goto L6;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L21:
            r101.type = HongbaoContent.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.receive_user_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            r101.device_info = DeviceInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.cover_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            r101.sdk_config = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.subject = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.total_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.total_amount = ProtoAdapter.INT64.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendHongbaoRequest r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.total_amount) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.total_num);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            int r104 = ((r102 + r103.encodedSizeWithTag(3, r100.subject)) + HongbaoContent.Type.ADAPTER.encodedSizeWithTag(4, r100.type)) + Channel.ADAPTER.encodedSizeWithTag(5, r100.channel);
            String r105 = r100.sdk_config;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r103.encodedSizeWithTag(6, r105);
        L6:
            int r108 = r104 + r107;
            Long r109 = r100.cover_id;
            if (r109 == null) goto L9;
            int r110 = r101.encodedSizeWithTag(7, r109);
        L10:
            int r111 = r108 + r110;
            DeviceInfo r112 = r100.device_info;
            if (r112 == null) goto L14;
            r106 = DeviceInfo.ADAPTER.encodedSizeWithTag(10, r112);
        L14:
            return ((r111 + r106) + r101.asRepeated().encodedSizeWithTag(11, r100.receive_user_ids)) + r100.unknownFields().size();
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendHongbaoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendHongbaoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendHongbaoRequest r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.total_amount);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.total_num);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 3, r101.subject);
            HongbaoContent.Type.ADAPTER.encodeWithTag(r100, 4, r101.type);
            Channel.ADAPTER.encodeWithTag(r100, 5, r101.channel);
            String r104 = r101.sdk_config;
            if (r104 == null) goto L5;
            r103.encodeWithTag(r100, 6, r104);
        L5:
            Long r105 = r101.cover_id;
            if (r105 == null) goto L8;
            r102.encodeWithTag(r100, 7, r105);
        L8:
            DeviceInfo r106 = r101.device_info;
            if (r106 == null) goto L11;
            DeviceInfo.ADAPTER.encodeWithTag(r100, 10, r106);
        L11:
            r102.asRepeated().encodeWithTag(r100, 11, r101.receive_user_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendHongbaoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendHongbaoRequest r100 = new ProtoAdapter_SendHongbaoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TOTAL_AMOUNT = 0L;
        DEFAULT_TOTAL_NUM = 0;
        DEFAULT_TYPE = HongbaoContent.Type.UNKNOWN;
        DEFAULT_COVER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.total_amount = this.total_amount;
        r100.total_num = this.total_num;
        r100.subject = this.subject;
        r100.type = this.type;
        r100.channel = this.channel;
        r100.sdk_config = this.sdk_config;
        r100.cover_id = this.cover_id;
        r100.device_info = this.device_info;
        r100.receive_user_ids = Internal.copyOf("receive_user_ids", this.receive_user_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendHongbaoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendHongbaoRequest(Long r110, Integer r111, String r112, HongbaoContent.Type r113, Channel r114, String r115, Long r116, DeviceInfo r117, List<Long> r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, ByteString.EMPTY);
    }

    public SendHongbaoRequest(Long r100, Integer r101, String r102, HongbaoContent.Type r103, Channel r104, String r105, Long r106, DeviceInfo r107, List<Long> r110, ByteString r111) {
        super(ADAPTER, r111);
        this.total_amount = r100;
        this.total_num = r101;
        this.subject = r102;
        this.type = r103;
        this.channel = r104;
        this.sdk_config = r105;
        this.cover_id = r106;
        this.device_info = r107;
        this.receive_user_ids = Internal.immutableCopyOf("receive_user_ids", r110);
    }
}
