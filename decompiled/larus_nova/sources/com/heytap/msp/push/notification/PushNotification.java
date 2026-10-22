package com.heytap.msp.push.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.LocusId;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes23.dex */
public class PushNotification {

    public static class Builder extends Notification.Builder {
        private int autoDelete;
        private Icon icon;
        private int iconLevel;
        private int iconRes;
        private int importantLevel;
        private String messageId;
        private String statisticData;
        private int verifyNotifyId;

        public Builder(Context r100) {
            super(r100);
            this.verifyNotifyId = -1;
        }

        public Builder(Context r100, String r101) {
            super(r100, r101);
            this.verifyNotifyId = -1;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder addAction(int r100, CharSequence r101, PendingIntent r102) {
            return addAction(r100, r101, r102);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder addAction(Notification.Action r100) {
            return addAction(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder addAction(int r100, CharSequence r101, PendingIntent r102) {
            super.addAction(r100, r101, r102);
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder addAction(Notification.Action r100) {
            super.addAction(r100);
            return this;
        }

        public Builder addExtraAutoDelete(int r100) {
            this.autoDelete = r100;
            return this;
        }

        public Builder addExtraImportanceLevel(int r100) {
            this.importantLevel = r100;
            return this;
        }

        public Builder addExtraMessageId(String r100) {
            this.messageId = r100;
            return this;
        }

        public Builder addExtraStatisticData(String r100) {
            this.statisticData = r100;
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder addExtras(Bundle r100) {
            return addExtras(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder addExtras(Bundle r100) {
            super.addExtras(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder addPerson(Person r100) {
            return addPerson(r100);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder addPerson(String r100) {
            return addPerson(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder addPerson(Person r100) {
            super.addPerson(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder addPerson(String r100) {
            super.addPerson(r100);
            return this;
        }

        public Builder closeNotifyIdVerify() {
            this.verifyNotifyId = -1;
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder extend(Notification.Extender r100) {
            return extend(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder extend(Notification.Extender r100) {
            super.extend(r100);
            return this;
        }

        public int getAutoDelete() {
            return this.autoDelete;
        }

        public Icon getIcon() {
            return this.icon;
        }

        public int getIconLevel() {
            return this.iconLevel;
        }

        public int getIconRes() {
            return this.iconRes;
        }

        public int getImportantLevel() {
            return this.importantLevel;
        }

        public String getMessageId() {
            return this.messageId;
        }

        public String getStatisticData() {
            return this.statisticData;
        }

        public int getVerifyNotifyId() {
            return this.verifyNotifyId;
        }

        public Builder openNotifyIdVerify(int r100) {
            this.verifyNotifyId = r100;
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setActions(Notification.Action[] r100) {
            return setActions(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setActions(Notification.Action... r100) {
            super.setActions(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setAllowSystemGeneratedContextualActions(boolean r100) {
            return setAllowSystemGeneratedContextualActions(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setAllowSystemGeneratedContextualActions(boolean r100) {
            super.setAllowSystemGeneratedContextualActions(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setAutoCancel(boolean r100) {
            return setAutoCancel(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setAutoCancel(boolean r100) {
            super.setAutoCancel(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setBadgeIconType(int r100) {
            return setBadgeIconType(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setBadgeIconType(int r100) {
            super.setBadgeIconType(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setBubbleMetadata(Notification.BubbleMetadata r100) {
            return setBubbleMetadata(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setBubbleMetadata(Notification.BubbleMetadata r100) {
            super.setBubbleMetadata(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setCategory(String r100) {
            return setCategory(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setCategory(String r100) {
            super.setCategory(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setChannelId(String r100) {
            return setChannelId(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setChannelId(String r100) {
            super.setChannelId(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setChronometerCountDown(boolean r100) {
            return setChronometerCountDown(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setChronometerCountDown(boolean r100) {
            super.setChronometerCountDown(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setColor(int r100) {
            return setColor(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setColor(int r100) {
            super.setColor(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setColorized(boolean r100) {
            return setColorized(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setColorized(boolean r100) {
            super.setColorized(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setContent(RemoteViews r100) {
            return setContent(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setContent(RemoteViews r100) {
            super.setContent(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setContentInfo(CharSequence r100) {
            return setContentInfo(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setContentInfo(CharSequence r100) {
            super.setContentInfo(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setContentIntent(PendingIntent r100) {
            return setContentIntent(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setContentIntent(PendingIntent r100) {
            super.setContentIntent(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setContentText(CharSequence r100) {
            return setContentText(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setContentText(CharSequence r100) {
            super.setContentText(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setContentTitle(CharSequence r100) {
            return setContentTitle(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setContentTitle(CharSequence r100) {
            super.setContentTitle(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setCustomBigContentView(RemoteViews r100) {
            return setCustomBigContentView(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setCustomBigContentView(RemoteViews r100) {
            super.setCustomBigContentView(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setCustomContentView(RemoteViews r100) {
            return setCustomContentView(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setCustomContentView(RemoteViews r100) {
            super.setCustomContentView(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setCustomHeadsUpContentView(RemoteViews r100) {
            return setCustomHeadsUpContentView(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setCustomHeadsUpContentView(RemoteViews r100) {
            super.setCustomHeadsUpContentView(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setDefaults(int r100) {
            return setDefaults(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setDefaults(int r100) {
            super.setDefaults(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setDeleteIntent(PendingIntent r100) {
            return setDeleteIntent(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setDeleteIntent(PendingIntent r100) {
            super.setDeleteIntent(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setExtras(Bundle r100) {
            return setExtras(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setExtras(Bundle r100) {
            super.setExtras(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setFullScreenIntent(PendingIntent r100, boolean r101) {
            return setFullScreenIntent(r100, r101);
        }

        @Override // android.app.Notification.Builder
        public Builder setFullScreenIntent(PendingIntent r100, boolean r101) {
            super.setFullScreenIntent(r100, r101);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setGroup(String r100) {
            return setGroup(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setGroup(String r100) {
            super.setGroup(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setGroupAlertBehavior(int r100) {
            return setGroupAlertBehavior(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setGroupAlertBehavior(int r100) {
            super.setGroupAlertBehavior(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setGroupSummary(boolean r100) {
            return setGroupSummary(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setGroupSummary(boolean r100) {
            super.setGroupSummary(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setLargeIcon(Bitmap r100) {
            return setLargeIcon(r100);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setLargeIcon(Icon r100) {
            return setLargeIcon(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setLargeIcon(Bitmap r100) {
            super.setLargeIcon(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder setLargeIcon(Icon r100) {
            super.setLargeIcon(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setLights(int r100, int r101, int r102) {
            return setLights(r100, r101, r102);
        }

        @Override // android.app.Notification.Builder
        public Builder setLights(int r100, int r101, int r102) {
            super.setLights(r100, r101, r102);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setLocalOnly(boolean r100) {
            return setLocalOnly(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setLocalOnly(boolean r100) {
            super.setLocalOnly(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setLocusId(LocusId r100) {
            return setLocusId(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setLocusId(LocusId r100) {
            super.setLocusId(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setNumber(int r100) {
            return setNumber(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setNumber(int r100) {
            super.setNumber(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setOngoing(boolean r100) {
            return setOngoing(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setOngoing(boolean r100) {
            super.setOngoing(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setOnlyAlertOnce(boolean r100) {
            return setOnlyAlertOnce(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setOnlyAlertOnce(boolean r100) {
            super.setOnlyAlertOnce(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setPriority(int r100) {
            return setPriority(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setPriority(int r100) {
            super.setPriority(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setProgress(int r100, int r101, boolean r102) {
            return setProgress(r100, r101, r102);
        }

        @Override // android.app.Notification.Builder
        public Builder setProgress(int r100, int r101, boolean r102) {
            super.setProgress(r100, r101, r102);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setPublicVersion(Notification r100) {
            return setPublicVersion(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setPublicVersion(Notification r100) {
            super.setPublicVersion(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setRemoteInputHistory(CharSequence[] r100) {
            return setRemoteInputHistory(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setRemoteInputHistory(CharSequence[] r100) {
            super.setRemoteInputHistory(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSettingsText(CharSequence r100) {
            return setSettingsText(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setSettingsText(CharSequence r100) {
            super.setSettingsText(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setShortcutId(String r100) {
            return setShortcutId(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setShortcutId(String r100) {
            super.setShortcutId(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setShowWhen(boolean r100) {
            return setShowWhen(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setShowWhen(boolean r100) {
            super.setShowWhen(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSmallIcon(int r100) {
            return setSmallIcon(r100);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSmallIcon(int r100, int r101) {
            return setSmallIcon(r100, r101);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSmallIcon(Icon r100) {
            return setSmallIcon(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setSmallIcon(int r100) {
            super.setSmallIcon(r100);
            this.iconRes = r100;
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder setSmallIcon(int r100, int r101) {
            super.setSmallIcon(r100, r101);
            this.iconRes = r100;
            this.iconLevel = r101;
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder setSmallIcon(Icon r100) {
            super.setSmallIcon(r100);
            this.icon = r100;
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSortKey(String r100) {
            return setSortKey(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setSortKey(String r100) {
            super.setSortKey(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSound(Uri r100) {
            return setSound(r100);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSound(Uri r100, int r101) {
            return setSound(r100, r101);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSound(Uri r100, AudioAttributes r101) {
            return setSound(r100, r101);
        }

        @Override // android.app.Notification.Builder
        public Builder setSound(Uri r100) {
            super.setSound(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder setSound(Uri r100, int r101) {
            super.setSound(r100, r101);
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder setSound(Uri r100, AudioAttributes r101) {
            super.setSound(r100, r101);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setStyle(Notification.Style r100) {
            return setStyle(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setStyle(Notification.Style r100) {
            super.setStyle(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setSubText(CharSequence r100) {
            return setSubText(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setSubText(CharSequence r100) {
            super.setSubText(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setTicker(CharSequence r100) {
            return setTicker(r100);
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setTicker(CharSequence r100, RemoteViews r101) {
            return setTicker(r100, r101);
        }

        @Override // android.app.Notification.Builder
        public Builder setTicker(CharSequence r100) {
            super.setTicker(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public Builder setTicker(CharSequence r100, RemoteViews r101) {
            super.setTicker(r100, r101);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setTimeoutAfter(long r100) {
            return setTimeoutAfter(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setTimeoutAfter(long r100) {
            super.setTimeoutAfter(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setUsesChronometer(boolean r100) {
            return setUsesChronometer(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setUsesChronometer(boolean r100) {
            super.setUsesChronometer(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setVibrate(long[] r100) {
            return setVibrate(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setVibrate(long[] r100) {
            super.setVibrate(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setVisibility(int r100) {
            return setVisibility(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setVisibility(int r100) {
            super.setVisibility(r100);
            return this;
        }

        @Override // android.app.Notification.Builder
        public /* bridge */ /* synthetic */ Notification.Builder setWhen(long r100) {
            return setWhen(r100);
        }

        @Override // android.app.Notification.Builder
        public Builder setWhen(long r100) {
            super.setWhen(r100);
            return this;
        }
    }

    public PushNotification() {
    }
}
