package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SmsPhoneUrgentSetting extends Message<SmsPhoneUrgentSetting, Builder> {
    public static final ProtoAdapter<SmsPhoneUrgentSetting> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT = null;
    public static final Boolean DEFAULT_CAN_MODIFY = null;
    public static final Boolean DEFAULT_CAN_SEND = null;
    public static final Boolean DEFAULT_NEED_CONFIRM = null;
    private static final long serialVersionUID = 0;
    public final Boolean accept;
    public final Boolean can_modify;
    public final Boolean can_send;
    public final Boolean need_confirm;

    public static final class Builder extends Message.Builder<SmsPhoneUrgentSetting, Builder> {
        public Boolean accept;
        public Boolean can_modify;
        public Boolean can_send;
        public Boolean need_confirm;

        @Override // com.squareup.wire.Message.Builder
        public SmsPhoneUrgentSetting build() {
            return new SmsPhoneUrgentSetting(this.accept, this.can_modify, this.need_confirm, this.can_send, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder accept(Boolean r100) {
            this.accept = r100;
            return this;
        }

        public Builder can_modify(Boolean r100) {
            this.can_modify = r100;
            return this;
        }

        public Builder can_send(Boolean r100) {
            this.can_send = r100;
            return this;
        }

        public Builder need_confirm(Boolean r100) {
            this.need_confirm = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SmsPhoneUrgentSetting extends ProtoAdapter<SmsPhoneUrgentSetting> {
        public ProtoAdapter_SmsPhoneUrgentSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SmsPhoneUrgentSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SmsPhoneUrgentSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.accept = r102;
            r101.can_modify = r102;
            r101.need_confirm = r102;
            r101.can_send = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.accept = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.can_modify = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.need_confirm = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.can_send = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SmsPhoneUrgentSetting r100) {
            Boolean r101 = r100.accept;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.can_modify;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.need_confirm;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.can_send;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ SmsPhoneUrgentSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SmsPhoneUrgentSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SmsPhoneUrgentSetting r101) throws IOException {
            Boolean r102 = r101.accept;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.can_modify;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.need_confirm;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.can_send;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SmsPhoneUrgentSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SmsPhoneUrgentSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ACCEPT = r100;
        DEFAULT_CAN_MODIFY = r100;
        DEFAULT_NEED_CONFIRM = r100;
        DEFAULT_CAN_SEND = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.accept = this.accept;
        r100.can_modify = this.can_modify;
        r100.need_confirm = this.need_confirm;
        r100.can_send = this.can_send;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SmsPhoneUrgentSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SmsPhoneUrgentSetting(Boolean r100, Boolean r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SmsPhoneUrgentSetting(Boolean r100, Boolean r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.accept = r100;
        this.can_modify = r101;
        this.need_confirm = r102;
        this.can_send = r103;
    }
}
