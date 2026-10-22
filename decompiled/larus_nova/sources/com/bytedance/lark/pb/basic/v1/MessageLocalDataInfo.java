package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageLocalDataInfo extends com.squareup.wire.Message<MessageLocalDataInfo, Builder> {
    public static final ProtoAdapter<MessageLocalDataInfo> ADAPTER = null;
    public static final BusinessKey DEFAULT_BUSINESS_KEY = null;
    public static final Long DEFAULT_MESSAGE_ID = null;
    private static final long serialVersionUID = 0;
    public final BusinessKey business_key;
    public final MessageLocalData data;
    public final Long message_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageLocalDataInfo, Builder> {
        public BusinessKey business_key;
        public MessageLocalData data;
        public Long message_id;

        @Override // com.squareup.wire.Message.Builder
        public MessageLocalDataInfo build() {
            return new MessageLocalDataInfo(this.message_id, this.business_key, this.data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder business_key(BusinessKey r100) {
            this.business_key = r100;
            return this;
        }

        public Builder data(MessageLocalData r100) {
            this.data = r100;
            return this;
        }

        public Builder message_id(Long r100) {
            this.message_id = r100;
            return this;
        }
    }

    public static final enum BusinessKey extends Enum<BusinessKey> implements WireEnum {
        private static final /* synthetic */ BusinessKey[] $VALUES = null;
        public static final ProtoAdapter<BusinessKey> ADAPTER = null;
        public static final BusinessKey OPEN_PLATFORM_MESSAGE_CARD = null;
        public static final BusinessKey TNS_DETECTION_EXTRA = null;
        public static final BusinessKey UNKNOWN = null;
        private final int value;

        static {
            BusinessKey r100 = new BusinessKey("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            BusinessKey r101 = new BusinessKey("OPEN_PLATFORM_MESSAGE_CARD", 1, 1);
            OPEN_PLATFORM_MESSAGE_CARD = r101;
            BusinessKey r102 = new BusinessKey("TNS_DETECTION_EXTRA", 2, 2);
            TNS_DETECTION_EXTRA = r102;
            $VALUES = new BusinessKey[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(BusinessKey.class);
        }

        public static BusinessKey[] values() {
            return (BusinessKey[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static BusinessKey fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return TNS_DETECTION_EXTRA;
        L12:
            return OPEN_PLATFORM_MESSAGE_CARD;
        L14:
            return UNKNOWN;
        }

        public static BusinessKey valueOf(String r100) {
            return (BusinessKey) a.a(BusinessKey.class, r100);
        }

        private BusinessKey(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_MessageLocalDataInfo extends ProtoAdapter<MessageLocalDataInfo> {
        public ProtoAdapter_MessageLocalDataInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageLocalDataInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageLocalDataInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = 0L;
            r101.business_key = BusinessKey.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.business_key = BusinessKey.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.data = MessageLocalData.ADAPTER.decode(r100);
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
        public int encodedSize2(MessageLocalDataInfo r100) {
            Long r101 = r100.message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            BusinessKey r104 = r100.business_key;
            if (r104 == null) goto L9;
            int r105 = BusinessKey.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            MessageLocalData r107 = r100.data;
            if (r107 == null) goto L14;
            r102 = MessageLocalData.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ MessageLocalDataInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageLocalDataInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageLocalDataInfo r101) throws IOException {
            Long r102 = r101.message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            BusinessKey r103 = r101.business_key;
            if (r103 == null) goto L8;
            BusinessKey.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            MessageLocalData r104 = r101.data;
            if (r104 == null) goto L11;
            MessageLocalData.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageLocalDataInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageLocalDataInfo();
        DEFAULT_MESSAGE_ID = 0L;
        DEFAULT_BUSINESS_KEY = BusinessKey.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.business_key = this.business_key;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageLocalDataInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageLocalDataInfo(Long r100, BusinessKey r101, MessageLocalData r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MessageLocalDataInfo(Long r100, BusinessKey r101, MessageLocalData r102, ByteString r103) {
        super(ADAPTER, r103);
        this.message_id = r100;
        this.business_key = r101;
        this.data = r102;
    }
}
