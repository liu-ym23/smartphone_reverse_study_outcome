package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class NotificationSettingV2 extends Message<NotificationSettingV2, Builder> {
    public static final ProtoAdapter<NotificationSettingV2> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DriveNotificationSetting drive_notification_setting;
    public final MessengerNotificationSetting messenger_notification_setting;

    public static final class Builder extends Message.Builder<NotificationSettingV2, Builder> {
        public DriveNotificationSetting drive_notification_setting;
        public MessengerNotificationSetting messenger_notification_setting;

        @Override // com.squareup.wire.Message.Builder
        public NotificationSettingV2 build() {
            return new NotificationSettingV2(this.messenger_notification_setting, this.drive_notification_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder drive_notification_setting(DriveNotificationSetting r100) {
            this.drive_notification_setting = r100;
            return this;
        }

        public Builder messenger_notification_setting(MessengerNotificationSetting r100) {
            this.messenger_notification_setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NotificationSettingV2 extends ProtoAdapter<NotificationSettingV2> {
        public ProtoAdapter_NotificationSettingV2() {
            super(FieldEncoding.LENGTH_DELIMITED, NotificationSettingV2.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NotificationSettingV2 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.messenger_notification_setting = MessengerNotificationSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.drive_notification_setting = DriveNotificationSetting.ADAPTER.decode(r100);
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
        public int encodedSize2(NotificationSettingV2 r100) {
            MessengerNotificationSetting r101 = r100.messenger_notification_setting;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MessengerNotificationSetting.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            DriveNotificationSetting r104 = r100.drive_notification_setting;
            if (r104 == null) goto L10;
            r102 = DriveNotificationSetting.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NotificationSettingV2 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NotificationSettingV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NotificationSettingV2 r101) throws IOException {
            MessengerNotificationSetting r102 = r101.messenger_notification_setting;
            if (r102 == null) goto L5;
            MessengerNotificationSetting.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            DriveNotificationSetting r103 = r101.drive_notification_setting;
            if (r103 == null) goto L8;
            DriveNotificationSetting.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NotificationSettingV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NotificationSettingV2();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.messenger_notification_setting = this.messenger_notification_setting;
        r100.drive_notification_setting = this.drive_notification_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NotificationSettingV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NotificationSettingV2(MessengerNotificationSetting r100, DriveNotificationSetting r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public NotificationSettingV2(MessengerNotificationSetting r100, DriveNotificationSetting r101, ByteString r102) {
        super(ADAPTER, r102);
        this.messenger_notification_setting = r100;
        this.drive_notification_setting = r101;
    }
}
