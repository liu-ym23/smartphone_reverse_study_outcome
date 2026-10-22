package com.ss.android.lark.chameleon;

import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.k.b;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.media.MediaScene;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005¢\u0006\u0002\u0010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules;", "", "<init>", "()V", "BASE", "", "buildValue", "parts", "", "([Ljava/lang/String;)Ljava/lang/String;", "getAllValue", "", "Domain", "BizSubDomain", "App", "Passport", "System", "UI", "Webview", "Widget", "Internal", "Biz", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKAPIModules {
    private static final String BASE = "LarkAPI.";
    public static final LKAPIModules INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$App;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetLarkletConfig", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum App extends Enum<App> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ App[] $VALUES = null;
        public static final App GetLarkletConfig = null;
        private final String value;

        private static final /* synthetic */ App[] $values() {
            return new App[]{GetLarkletConfig};
        }

        public static EnumEntries<App> getEntries() {
            return $ENTRIES;
        }

        static {
            GetLarkletConfig = new App("GetLarkletConfig", 0, "getLarkletConfig");
            App[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static App[] values() {
            return (App[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static App valueOf(String r100) {
            return (App) a.a(App.class, r100);
        }

        private App(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.APP.getValue(), r102});
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0006\u0007\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz;", "", "<init>", "()V", "BIZ_DOMAIN", "", "Chat", "Profile", "Todo", "Statistics", "Workplace", "Mail", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Biz {
        private static final String BIZ_DOMAIN = null;
        public static final Biz INSTANCE = null;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Chat;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SelectMessages", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Chat extends Enum<Chat> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Chat[] $VALUES = null;
            public static final Chat SelectMessages = null;
            private final String value;

            private static final /* synthetic */ Chat[] $values() {
                return new Chat[]{SelectMessages};
            }

            public static EnumEntries<Chat> getEntries() {
                return $ENTRIES;
            }

            static {
                SelectMessages = new Chat("SelectMessages", 0, "selectMessages");
                Chat[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Chat[] values() {
                return (Chat[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Chat valueOf(String r100) {
                return (Chat) a.a(Chat.class, r100);
            }

            private Chat(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.CHAT.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001d\b\u0002\u0012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\r\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Mail;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "path", "", "", "<init>", "(Ljava/lang/String;I[Ljava/lang/String;)V", "ChangeSize", "WebViewWindowClose", "JumpToSystemBrowser", "SetTapOutsideToDismiss", "OnDataReady", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Mail extends Enum<Mail> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Mail[] $VALUES = null;
            public static final Mail ChangeSize = null;
            public static final Mail JumpToSystemBrowser = null;
            public static final Mail OnDataReady = null;
            public static final Mail SetTapOutsideToDismiss = null;
            public static final Mail WebViewWindowClose = null;
            private final String value;

            private static final /* synthetic */ Mail[] $values() {
                return new Mail[]{ChangeSize, WebViewWindowClose, JumpToSystemBrowser, SetTapOutsideToDismiss, OnDataReady};
            }

            public static EnumEntries<Mail> getEntries() {
                return $ENTRIES;
            }

            static {
                ChangeSize = new Mail("ChangeSize", 0, new String[]{"changeSize"});
                WebViewWindowClose = new Mail("WebViewWindowClose", 1, new String[]{"webViewWindow", "close"});
                JumpToSystemBrowser = new Mail("JumpToSystemBrowser", 2, new String[]{Notice.CLICK_TYPE_JUMP, "system_browser"});
                SetTapOutsideToDismiss = new Mail("SetTapOutsideToDismiss", 3, new String[]{"setTapOutsideToDismiss"});
                OnDataReady = new Mail("OnDataReady", 4, new String[]{"onDataReady"});
                Mail[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Mail[] values() {
                return (Mail[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Mail valueOf(String r100) {
                return (Mail) a.a(Mail.class, r100);
            }

            private Mail(String r100, int r101, String... r102) {
                super(r100, r101);
                LKAPIModules r103 = LKAPIModules.INSTANCE;
                SpreadBuilder r104 = new SpreadBuilder(3);
                r104.add(Biz.access$getBIZ_DOMAIN$p());
                r104.add(BizSubDomain.MAIL.getValue());
                r104.addSpread(r102);
                this.value = r103.buildValue((String[]) r104.toArray(new String[r104.size()]));
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Profile;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "OpenProfile", "NotifySelectDepartment", "NotifySubTabChange", "GetManageDepartmentList", "ShowManagedDepartmentPanel", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Profile extends Enum<Profile> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Profile[] $VALUES = null;
            public static final Profile GetManageDepartmentList = null;
            public static final Profile NotifySelectDepartment = null;
            public static final Profile NotifySubTabChange = null;
            public static final Profile OpenProfile = null;
            public static final Profile ShowManagedDepartmentPanel = null;
            private final String value;

            private static final /* synthetic */ Profile[] $values() {
                return new Profile[]{OpenProfile, NotifySelectDepartment, NotifySubTabChange, GetManageDepartmentList, ShowManagedDepartmentPanel};
            }

            public static EnumEntries<Profile> getEntries() {
                return $ENTRIES;
            }

            static {
                OpenProfile = new Profile("OpenProfile", 0, "openProfile");
                NotifySelectDepartment = new Profile("NotifySelectDepartment", 1, "notifySelectDepartment");
                NotifySubTabChange = new Profile("NotifySubTabChange", 2, "notifySubTabChange");
                GetManageDepartmentList = new Profile("GetManageDepartmentList", 3, "getManageDepartmentList");
                ShowManagedDepartmentPanel = new Profile("ShowManagedDepartmentPanel", 4, "showManagedDepartmentPanel");
                Profile[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Profile[] values() {
                return (Profile[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Profile valueOf(String r100) {
                return (Profile) a.a(Profile.class, r100);
            }

            private Profile(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.PROFILE.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Statistics;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SendEvent", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Statistics extends Enum<Statistics> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Statistics[] $VALUES = null;
            public static final Statistics SendEvent = null;
            private final String value;

            private static final /* synthetic */ Statistics[] $values() {
                return new Statistics[]{SendEvent};
            }

            public static EnumEntries<Statistics> getEntries() {
                return $ENTRIES;
            }

            static {
                SendEvent = new Statistics("SendEvent", 0, "sendEvent");
                Statistics[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Statistics[] values() {
                return (Statistics[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Statistics valueOf(String r100) {
                return (Statistics) a.a(Statistics.class, r100);
            }

            private Statistics(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.STATISTICS.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010&\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Todo;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PreviewFile", "DownloadFile", "PreviewImage", "OpenChat", "OpenThread", "ShowContactPicker", "ShareTaskDetail", "ShareTaskList", "GetIs24HourStyle", "StartChooseRepeat", "GetParsedRRuleText", "GenerateMergeForwardInfo", "StartMergeMessagePage", "GetInitialRefResourceForChatCreating", "GetInitialRichSummaryForChatCreating", "ShareCreatedTaskToLark", "OpenTaskActivitiesPage", "OpenCommunicableNativeSubPage", "CommunicableSubPageTransData", "GetChatById", "WebCanGoBack", "ShowActionSheet", "ShowDialog", "GetZoomLevel", "GetEmojiEntity", "GetStatisticsInfo", "GetSafeArea", "UpdateBadge", "GetKeyboardStatus", "GetIsFoldDisplay", "GetAuthHeaders", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Todo extends Enum<Todo> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Todo[] $VALUES = null;
            public static final Todo CommunicableSubPageTransData = null;
            public static final Todo DownloadFile = null;
            public static final Todo GenerateMergeForwardInfo = null;
            public static final Todo GetAuthHeaders = null;
            public static final Todo GetChatById = null;
            public static final Todo GetEmojiEntity = null;
            public static final Todo GetInitialRefResourceForChatCreating = null;
            public static final Todo GetInitialRichSummaryForChatCreating = null;
            public static final Todo GetIs24HourStyle = null;
            public static final Todo GetIsFoldDisplay = null;
            public static final Todo GetKeyboardStatus = null;
            public static final Todo GetParsedRRuleText = null;
            public static final Todo GetSafeArea = null;
            public static final Todo GetStatisticsInfo = null;
            public static final Todo GetZoomLevel = null;
            public static final Todo OpenChat = null;
            public static final Todo OpenCommunicableNativeSubPage = null;
            public static final Todo OpenTaskActivitiesPage = null;
            public static final Todo OpenThread = null;
            public static final Todo PreviewFile = null;
            public static final Todo PreviewImage = null;
            public static final Todo ShareCreatedTaskToLark = null;
            public static final Todo ShareTaskDetail = null;
            public static final Todo ShareTaskList = null;
            public static final Todo ShowActionSheet = null;
            public static final Todo ShowContactPicker = null;
            public static final Todo ShowDialog = null;
            public static final Todo StartChooseRepeat = null;
            public static final Todo StartMergeMessagePage = null;
            public static final Todo UpdateBadge = null;
            public static final Todo WebCanGoBack = null;
            private final String value;

            private static final /* synthetic */ Todo[] $values() {
                return new Todo[]{PreviewFile, DownloadFile, PreviewImage, OpenChat, OpenThread, ShowContactPicker, ShareTaskDetail, ShareTaskList, GetIs24HourStyle, StartChooseRepeat, GetParsedRRuleText, GenerateMergeForwardInfo, StartMergeMessagePage, GetInitialRefResourceForChatCreating, GetInitialRichSummaryForChatCreating, ShareCreatedTaskToLark, OpenTaskActivitiesPage, OpenCommunicableNativeSubPage, CommunicableSubPageTransData, GetChatById, WebCanGoBack, ShowActionSheet, ShowDialog, GetZoomLevel, GetEmojiEntity, GetStatisticsInfo, GetSafeArea, UpdateBadge, GetKeyboardStatus, GetIsFoldDisplay, GetAuthHeaders};
            }

            public static EnumEntries<Todo> getEntries() {
                return $ENTRIES;
            }

            static {
                PreviewFile = new Todo("PreviewFile", 0, "previewFile");
                DownloadFile = new Todo("DownloadFile", 1, "downloadFile");
                PreviewImage = new Todo("PreviewImage", 2, "previewImage");
                OpenChat = new Todo("OpenChat", 3, "openChat");
                OpenThread = new Todo("OpenThread", 4, "openThread");
                ShowContactPicker = new Todo("ShowContactPicker", 5, "showContactPicker");
                ShareTaskDetail = new Todo("ShareTaskDetail", 6, "shareTaskDetail");
                ShareTaskList = new Todo("ShareTaskList", 7, "shareTaskList");
                GetIs24HourStyle = new Todo("GetIs24HourStyle", 8, "getIs24HourStyle");
                StartChooseRepeat = new Todo("StartChooseRepeat", 9, "startChooseRepeat");
                GetParsedRRuleText = new Todo("GetParsedRRuleText", 10, "getParsedRRuleText");
                GenerateMergeForwardInfo = new Todo("GenerateMergeForwardInfo", 11, "generateMergeForwardInfo");
                StartMergeMessagePage = new Todo("StartMergeMessagePage", 12, "startMergeMessagePage");
                GetInitialRefResourceForChatCreating = new Todo("GetInitialRefResourceForChatCreating", 13, "getInitialRefResourceForChatCreating");
                GetInitialRichSummaryForChatCreating = new Todo("GetInitialRichSummaryForChatCreating", 14, "getInitialRichSummaryForChatCreating");
                ShareCreatedTaskToLark = new Todo("ShareCreatedTaskToLark", 15, "shareCreatedTaskToLark");
                OpenTaskActivitiesPage = new Todo("OpenTaskActivitiesPage", 16, "openTaskActivitiesPage");
                OpenCommunicableNativeSubPage = new Todo("OpenCommunicableNativeSubPage", 17, "openCommunicableNativeSubPage");
                CommunicableSubPageTransData = new Todo("CommunicableSubPageTransData", 18, "communicableSubPageTransData");
                GetChatById = new Todo("GetChatById", 19, "getChatById");
                WebCanGoBack = new Todo("WebCanGoBack", 20, "webCanGoBack");
                ShowActionSheet = new Todo("ShowActionSheet", 21, "showActionSheet");
                ShowDialog = new Todo("ShowDialog", 22, "showDialog");
                GetZoomLevel = new Todo("GetZoomLevel", 23, "getZoomLevel");
                GetEmojiEntity = new Todo("GetEmojiEntity", 24, "getEmojiEntity");
                GetStatisticsInfo = new Todo("GetStatisticsInfo", 25, "getStatisticsInfo");
                GetSafeArea = new Todo("GetSafeArea", 26, "getSafeArea");
                UpdateBadge = new Todo("UpdateBadge", 27, "updateBadge");
                GetKeyboardStatus = new Todo("GetKeyboardStatus", 28, "getKeyboardStatus");
                GetIsFoldDisplay = new Todo("GetIsFoldDisplay", 29, "getIsFoldDisplay");
                GetAuthHeaders = new Todo("GetAuthHeaders", 30, "getAuthHeaders");
                Todo[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Todo[] values() {
                return (Todo[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Todo valueOf(String r100) {
                return (Todo) a.a(Todo.class, r100);
            }

            private Todo(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.TODO.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bj\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Workplace;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetCurrentTemplateId", "OnSwitchTemplate", "OnUpdateTemplate", "NavigateTo", "UpdateBadge", "GetInnerSize", "GetScreenMode", "PreloadSuccess", "ShowDialog", "SetTemplateList", "SetTplTitleButton", "Ready", "OpenApp", "ShowNotInterestedSelect", "HideNotInterestedSelect", "ShowItemMenu", "HideItemMenu", "ShowSortApp", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Workplace extends Enum<Workplace> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Workplace[] $VALUES = null;
            public static final Workplace GetCurrentTemplateId = null;
            public static final Workplace GetInnerSize = null;
            public static final Workplace GetScreenMode = null;
            public static final Workplace HideItemMenu = null;
            public static final Workplace HideNotInterestedSelect = null;
            public static final Workplace NavigateTo = null;
            public static final Workplace OnSwitchTemplate = null;
            public static final Workplace OnUpdateTemplate = null;
            public static final Workplace OpenApp = null;
            public static final Workplace PreloadSuccess = null;
            public static final Workplace Ready = null;
            public static final Workplace SetTemplateList = null;
            public static final Workplace SetTplTitleButton = null;
            public static final Workplace ShowDialog = null;
            public static final Workplace ShowItemMenu = null;
            public static final Workplace ShowNotInterestedSelect = null;
            public static final Workplace ShowSortApp = null;
            public static final Workplace UpdateBadge = null;
            private final String value;

            private static final /* synthetic */ Workplace[] $values() {
                return new Workplace[]{GetCurrentTemplateId, OnSwitchTemplate, OnUpdateTemplate, NavigateTo, UpdateBadge, GetInnerSize, GetScreenMode, PreloadSuccess, ShowDialog, SetTemplateList, SetTplTitleButton, Ready, OpenApp, ShowNotInterestedSelect, HideNotInterestedSelect, ShowItemMenu, HideItemMenu, ShowSortApp};
            }

            public static EnumEntries<Workplace> getEntries() {
                return $ENTRIES;
            }

            static {
                GetCurrentTemplateId = new Workplace("GetCurrentTemplateId", 0, "getCurrentTemplateId");
                OnSwitchTemplate = new Workplace("OnSwitchTemplate", 1, "onSwitchTemplate");
                OnUpdateTemplate = new Workplace("OnUpdateTemplate", 2, "onUpdateTemplate");
                NavigateTo = new Workplace("NavigateTo", 3, "navigateTo");
                UpdateBadge = new Workplace("UpdateBadge", 4, "updateBadge");
                GetInnerSize = new Workplace("GetInnerSize", 5, "getInnerSize");
                GetScreenMode = new Workplace("GetScreenMode", 6, "getScreenMode");
                PreloadSuccess = new Workplace("PreloadSuccess", 7, "preloadSuccess");
                ShowDialog = new Workplace("ShowDialog", 8, "showDialog");
                SetTemplateList = new Workplace("SetTemplateList", 9, "setTemplateList");
                SetTplTitleButton = new Workplace("SetTplTitleButton", 10, "setTplTitleButton");
                Ready = new Workplace("Ready", 11, "ready");
                OpenApp = new Workplace("OpenApp", 12, "openApp");
                ShowNotInterestedSelect = new Workplace("ShowNotInterestedSelect", 13, "showNotInterestedSelect");
                HideNotInterestedSelect = new Workplace("HideNotInterestedSelect", 14, "hideNotInterestedSelect");
                ShowItemMenu = new Workplace("ShowItemMenu", 15, "showItemMenu");
                HideItemMenu = new Workplace("HideItemMenu", 16, "hideItemMenu");
                ShowSortApp = new Workplace("ShowSortApp", 17, "showSortApp");
                Workplace[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Workplace[] values() {
                return (Workplace[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Workplace valueOf(String r100) {
                return (Workplace) a.a(Workplace.class, r100);
            }

            private Workplace(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.WORKPLACE.getValue(), r102});
            }
        }

        private Biz() {
        }

        static {
            INSTANCE = new Biz();
            BIZ_DOMAIN = Domain.BIZ.getValue();
        }

        public static final /* synthetic */ String access$getBIZ_DOMAIN$p() {
            return BIZ_DOMAIN;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$BizSubDomain;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT", "MAIL", "PROFILE", AlarmSessionType.TODO, "STATISTICS", "WORKPLACE", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BizSubDomain extends Enum<BizSubDomain> implements NonProguard {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ BizSubDomain[] $VALUES = null;
        public static final BizSubDomain CHAT = null;
        public static final BizSubDomain MAIL = null;
        public static final BizSubDomain PROFILE = null;
        public static final BizSubDomain STATISTICS = null;
        public static final BizSubDomain TODO = null;
        public static final BizSubDomain WORKPLACE = null;
        private final String value;

        private static final /* synthetic */ BizSubDomain[] $values() {
            return new BizSubDomain[]{CHAT, MAIL, PROFILE, TODO, STATISTICS, WORKPLACE};
        }

        public static EnumEntries<BizSubDomain> getEntries() {
            return $ENTRIES;
        }

        static {
            CHAT = new BizSubDomain("CHAT", 0, "chat");
            MAIL = new BizSubDomain("MAIL", 1, IOfflineExtraParser.ParserType.MAIL);
            PROFILE = new BizSubDomain("PROFILE", 2, "profile");
            TODO = new BizSubDomain(AlarmSessionType.TODO, 3, IOfflineExtraParser.ParserType.TODO);
            STATISTICS = new BizSubDomain("STATISTICS", 4, "statistics");
            WORKPLACE = new BizSubDomain("WORKPLACE", 5, "workplace");
            BizSubDomain[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static BizSubDomain[] values() {
            return (BizSubDomain[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static BizSubDomain valueOf(String r100) {
            return (BizSubDomain) a.a(BizSubDomain.class, r100);
        }

        private BizSubDomain(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Domain;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP", "APP_CONFIG", "LOG", "NET", "PASSPORT", "RESOURCE", "SLARDAR", "STORAGE", MediaScene.SYSTEM, "TEA", "TRANSPORT", "UI", "WEBVIEW", "WIDGET", "INTERNAL", "BIZ", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Domain extends Enum<Domain> implements NonProguard {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Domain[] $VALUES = null;
        public static final Domain APP = null;
        public static final Domain APP_CONFIG = null;
        public static final Domain BIZ = null;
        public static final Domain INTERNAL = null;
        public static final Domain LOG = null;
        public static final Domain NET = null;
        public static final Domain PASSPORT = null;
        public static final Domain RESOURCE = null;
        public static final Domain SLARDAR = null;
        public static final Domain STORAGE = null;
        public static final Domain SYSTEM = null;
        public static final Domain TEA = null;
        public static final Domain TRANSPORT = null;
        public static final Domain UI = null;
        public static final Domain WEBVIEW = null;
        public static final Domain WIDGET = null;
        private final String value;

        private static final /* synthetic */ Domain[] $values() {
            return new Domain[]{APP, APP_CONFIG, LOG, NET, PASSPORT, RESOURCE, SLARDAR, STORAGE, SYSTEM, TEA, TRANSPORT, UI, WEBVIEW, WIDGET, INTERNAL, BIZ};
        }

        public static EnumEntries<Domain> getEntries() {
            return $ENTRIES;
        }

        static {
            APP = new Domain("APP", 0, "app");
            APP_CONFIG = new Domain("APP_CONFIG", 1, "appConfig");
            LOG = new Domain("LOG", 2, "log");
            NET = new Domain("NET", 3, b.f25406k);
            PASSPORT = new Domain("PASSPORT", 4, "passport");
            RESOURCE = new Domain("RESOURCE", 5, "resource");
            SLARDAR = new Domain("SLARDAR", 6, "slardar");
            STORAGE = new Domain("STORAGE", 7, "storage");
            SYSTEM = new Domain(MediaScene.SYSTEM, 8, CameraParam.TYPE_SYSTEM_CAMERA);
            TEA = new Domain("TEA", 9, "tea");
            TRANSPORT = new Domain("TRANSPORT", 10, NotificationCompat.CATEGORY_TRANSPORT);
            UI = new Domain("UI", 11, "ui");
            WEBVIEW = new Domain("WEBVIEW", 12, "webview");
            WIDGET = new Domain("WIDGET", 13, "widget");
            INTERNAL = new Domain("INTERNAL", 14, "internal");
            BIZ = new Domain("BIZ", 15, "biz");
            Domain[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Domain[] values() {
            return (Domain[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Domain valueOf(String r100) {
            return (Domain) a.a(Domain.class, r100);
        }

        private Domain(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u000b\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal;", "", "<init>", "()V", "INTERNAL_DOMAIN", "", "AppConfig", "Log", "Net", "Resource", "Storage", "Slardar", "System", "Tea", "Transport", "Webview", "Widget", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Internal {
        public static final Internal INSTANCE = null;
        private static final String INTERNAL_DOMAIN = null;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$AppConfig;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetKeys", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum AppConfig extends Enum<AppConfig> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ AppConfig[] $VALUES = null;
            public static final AppConfig GetKeys = null;
            private final String value;

            private static final /* synthetic */ AppConfig[] $values() {
                return new AppConfig[]{GetKeys};
            }

            public static EnumEntries<AppConfig> getEntries() {
                return $ENTRIES;
            }

            static {
                GetKeys = new AppConfig("GetKeys", 0, "getKeys");
                AppConfig[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static AppConfig[] values() {
                return (AppConfig[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static AppConfig valueOf(String r100) {
                return (AppConfig) a.a(AppConfig.class, r100);
            }

            private AppConfig(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.APP_CONFIG.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Log;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LogNoReturn", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Log extends Enum<Log> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Log[] $VALUES = null;
            public static final Log LogNoReturn = null;
            private final String value;

            private static final /* synthetic */ Log[] $values() {
                return new Log[]{LogNoReturn};
            }

            public static EnumEntries<Log> getEntries() {
                return $ENTRIES;
            }

            static {
                LogNoReturn = new Log("LogNoReturn", 0, "logNoReturn");
                Log[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Log[] values() {
                return (Log[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Log valueOf(String r100) {
                return (Log) a.a(Log.class, r100);
            }

            private Log(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.LOG.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Net;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Fetch", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Net extends Enum<Net> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Net[] $VALUES = null;
            public static final Net Fetch = null;
            private final String value;

            private static final /* synthetic */ Net[] $values() {
                return new Net[]{Fetch};
            }

            public static EnumEntries<Net> getEntries() {
                return $ENTRIES;
            }

            static {
                Fetch = new Net("Fetch", 0, "fetch");
                Net[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Net[] values() {
                return (Net[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Net valueOf(String r100) {
                return (Net) a.a(Net.class, r100);
            }

            private Net(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.NET.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Resource;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Upload", "CancelUpload", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Resource extends Enum<Resource> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Resource[] $VALUES = null;
            public static final Resource CancelUpload = null;
            public static final Resource Upload = null;
            private final String value;

            private static final /* synthetic */ Resource[] $values() {
                return new Resource[]{Upload, CancelUpload};
            }

            public static EnumEntries<Resource> getEntries() {
                return $ENTRIES;
            }

            static {
                Upload = new Resource("Upload", 0, "upload");
                CancelUpload = new Resource("CancelUpload", 1, "cancelUpload");
                Resource[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Resource[] values() {
                return (Resource[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Resource valueOf(String r100) {
                return (Resource) a.a(Resource.class, r100);
            }

            private Resource(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.RESOURCE.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Slardar;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SendEvents", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Slardar extends Enum<Slardar> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Slardar[] $VALUES = null;
            public static final Slardar SendEvents = null;
            private final String value;

            private static final /* synthetic */ Slardar[] $values() {
                return new Slardar[]{SendEvents};
            }

            public static EnumEntries<Slardar> getEntries() {
                return $ENTRIES;
            }

            static {
                SendEvents = new Slardar("SendEvents", 0, "sendEvents");
                Slardar[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Slardar[] values() {
                return (Slardar[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Slardar valueOf(String r100) {
                return (Slardar) a.a(Slardar.class, r100);
            }

            private Slardar(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.SLARDAR.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Storage;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CreatePersistentStorage", "GetPersistentStorageId", "GetPersistentKeys", "GetPersistentItems", "SetPersistentItems", "HasPersistentItems", "RemovePersistentItems", "ClearPersistentItems", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Storage extends Enum<Storage> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Storage[] $VALUES = null;
            public static final Storage ClearPersistentItems = null;
            public static final Storage CreatePersistentStorage = null;
            public static final Storage GetPersistentItems = null;
            public static final Storage GetPersistentKeys = null;
            public static final Storage GetPersistentStorageId = null;
            public static final Storage HasPersistentItems = null;
            public static final Storage RemovePersistentItems = null;
            public static final Storage SetPersistentItems = null;
            private final String value;

            private static final /* synthetic */ Storage[] $values() {
                return new Storage[]{CreatePersistentStorage, GetPersistentStorageId, GetPersistentKeys, GetPersistentItems, SetPersistentItems, HasPersistentItems, RemovePersistentItems, ClearPersistentItems};
            }

            public static EnumEntries<Storage> getEntries() {
                return $ENTRIES;
            }

            static {
                CreatePersistentStorage = new Storage("CreatePersistentStorage", 0, "createPersistentStorage");
                GetPersistentStorageId = new Storage("GetPersistentStorageId", 1, "getPersistentStorageId");
                GetPersistentKeys = new Storage("GetPersistentKeys", 2, "getPersistentKeys");
                GetPersistentItems = new Storage("GetPersistentItems", 3, "getPersistentItems");
                SetPersistentItems = new Storage("SetPersistentItems", 4, "setPersistentItems");
                HasPersistentItems = new Storage("HasPersistentItems", 5, "hasPersistentItems");
                RemovePersistentItems = new Storage("RemovePersistentItems", 6, "removePersistentItems");
                ClearPersistentItems = new Storage("ClearPersistentItems", 7, "clearPersistentItems");
                Storage[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Storage[] values() {
                return (Storage[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Storage valueOf(String r100) {
                return (Storage) a.a(Storage.class, r100);
            }

            private Storage(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.STORAGE.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$System;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetStatusBarHeight", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum System extends Enum<System> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ System[] $VALUES = null;
            public static final System GetStatusBarHeight = null;
            private final String value;

            private static final /* synthetic */ System[] $values() {
                return new System[]{GetStatusBarHeight};
            }

            public static EnumEntries<System> getEntries() {
                return $ENTRIES;
            }

            static {
                GetStatusBarHeight = new System("GetStatusBarHeight", 0, "getStatusBarHeight");
                System[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static System[] values() {
                return (System[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static System valueOf(String r100) {
                return (System) a.a(System.class, r100);
            }

            private System(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.SYSTEM.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Tea;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "TrackNoReturn", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Tea extends Enum<Tea> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Tea[] $VALUES = null;
            public static final Tea TrackNoReturn = null;
            private final String value;

            private static final /* synthetic */ Tea[] $values() {
                return new Tea[]{TrackNoReturn};
            }

            public static EnumEntries<Tea> getEntries() {
                return $ENTRIES;
            }

            static {
                TrackNoReturn = new Tea("TrackNoReturn", 0, "trackNoReturn");
                Tea[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Tea[] values() {
                return (Tea[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Tea valueOf(String r100) {
                return (Tea) a.a(Tea.class, r100);
            }

            private Tea(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.TEA.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Transport;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CallRustApi", "SubscribeRustPush", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Transport extends Enum<Transport> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Transport[] $VALUES = null;
            public static final Transport CallRustApi = null;
            public static final Transport SubscribeRustPush = null;
            private final String value;

            private static final /* synthetic */ Transport[] $values() {
                return new Transport[]{CallRustApi, SubscribeRustPush};
            }

            public static EnumEntries<Transport> getEntries() {
                return $ENTRIES;
            }

            static {
                CallRustApi = new Transport("CallRustApi", 0, "callRustApi");
                SubscribeRustPush = new Transport("SubscribeRustPush", 1, "subscribeRustPush");
                Transport[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Transport[] values() {
                return (Transport[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Transport valueOf(String r100) {
                return (Transport) a.a(Transport.class, r100);
            }

            private Transport(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.TRANSPORT.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Webview;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Close", "GetState", "GetRouterState", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Webview extends Enum<Webview> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Webview[] $VALUES = null;
            public static final Webview Close = null;
            public static final Webview GetRouterState = null;
            public static final Webview GetState = null;
            private final String value;

            private static final /* synthetic */ Webview[] $values() {
                return new Webview[]{Close, GetState, GetRouterState};
            }

            public static EnumEntries<Webview> getEntries() {
                return $ENTRIES;
            }

            static {
                Close = new Webview("Close", 0, "close");
                GetState = new Webview("GetState", 1, "getState");
                GetRouterState = new Webview("GetRouterState", 2, "getRouterState");
                Webview[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Webview[] values() {
                return (Webview[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Webview valueOf(String r100) {
                return (Webview) a.a(Webview.class, r100);
            }

            private Webview(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.WEBVIEW.getValue(), r102});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Widget;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ShowToast", "ShowConfirmDialog", "CloseConfirmDialog", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Widget extends Enum<Widget> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Widget[] $VALUES = null;
            public static final Widget CloseConfirmDialog = null;
            public static final Widget ShowConfirmDialog = null;
            public static final Widget ShowToast = null;
            private final String value;

            private static final /* synthetic */ Widget[] $values() {
                return new Widget[]{ShowToast, ShowConfirmDialog, CloseConfirmDialog};
            }

            public static EnumEntries<Widget> getEntries() {
                return $ENTRIES;
            }

            static {
                ShowToast = new Widget("ShowToast", 0, "showToast");
                ShowConfirmDialog = new Widget("ShowConfirmDialog", 1, "showConfirmDialog");
                CloseConfirmDialog = new Widget("CloseConfirmDialog", 2, "closeConfirmDialog");
                Widget[] r100 = $values();
                $VALUES = r100;
                $ENTRIES = EnumEntriesKt.enumEntries(r100);
            }

            public static Widget[] values() {
                return (Widget[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Widget valueOf(String r100) {
                return (Widget) a.a(Widget.class, r100);
            }

            private Widget(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.WIDGET.getValue(), r102});
            }
        }

        private Internal() {
        }

        static {
            INSTANCE = new Internal();
            INTERNAL_DOMAIN = Domain.INTERNAL.getValue();
        }

        public static final /* synthetic */ String access$getINTERNAL_DOMAIN$p() {
            return INTERNAL_DOMAIN;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Passport;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetCurrentUserInfo", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Passport extends Enum<Passport> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Passport[] $VALUES = null;
        public static final Passport GetCurrentUserInfo = null;
        private final String value;

        private static final /* synthetic */ Passport[] $values() {
            return new Passport[]{GetCurrentUserInfo};
        }

        public static EnumEntries<Passport> getEntries() {
            return $ENTRIES;
        }

        static {
            GetCurrentUserInfo = new Passport("GetCurrentUserInfo", 0, "getCurrentUserInfo");
            Passport[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Passport[] values() {
            return (Passport[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static Passport valueOf(String r100) {
            return (Passport) a.a(Passport.class, r100);
        }

        private Passport(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.PASSPORT.getValue(), r102});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$System;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DeviceVibrate", "GetInputDevice", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum System extends Enum<System> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ System[] $VALUES = null;
        public static final System DeviceVibrate = null;
        public static final System GetInputDevice = null;
        private final String value;

        private static final /* synthetic */ System[] $values() {
            return new System[]{DeviceVibrate, GetInputDevice};
        }

        public static EnumEntries<System> getEntries() {
            return $ENTRIES;
        }

        static {
            DeviceVibrate = new System("DeviceVibrate", 0, "deviceVibrate");
            GetInputDevice = new System("GetInputDevice", 1, "getInputDevice");
            System[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static System[] values() {
            return (System[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static System valueOf(String r100) {
            return (System) a.a(System.class, r100);
        }

        private System(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.SYSTEM.getValue(), r102});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$UI;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetAppThemeInfo", "GetZoomLevel", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UI extends Enum<UI> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ UI[] $VALUES = null;
        public static final UI GetAppThemeInfo = null;
        public static final UI GetZoomLevel = null;
        private final String value;

        private static final /* synthetic */ UI[] $values() {
            return new UI[]{GetAppThemeInfo, GetZoomLevel};
        }

        public static EnumEntries<UI> getEntries() {
            return $ENTRIES;
        }

        static {
            GetAppThemeInfo = new UI("GetAppThemeInfo", 0, "getAppThemeInfo");
            GetZoomLevel = new UI("GetZoomLevel", 1, "getZoomLevel");
            UI[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static UI[] values() {
            return (UI[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static UI valueOf(String r100) {
            return (UI) a.a(UI.class, r100);
        }

        private UI(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.UI.getValue(), r102});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Webview;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LoadFinish", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Webview extends Enum<Webview> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Webview[] $VALUES = null;
        public static final Webview LoadFinish = null;
        private final String value;

        private static final /* synthetic */ Webview[] $values() {
            return new Webview[]{LoadFinish};
        }

        public static EnumEntries<Webview> getEntries() {
            return $ENTRIES;
        }

        static {
            LoadFinish = new Webview("LoadFinish", 0, "loadFinish");
            Webview[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Webview[] values() {
            return (Webview[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static Webview valueOf(String r100) {
            return (Webview) a.a(Webview.class, r100);
        }

        private Webview(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.WEBVIEW.getValue(), r102});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Widget;", "Lcom/ss/android/lark/chameleon/IAPIModule;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ShowFilePicker", "ShowMediaPicker", "ShowPanel", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Widget extends Enum<Widget> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Widget[] $VALUES = null;
        public static final Widget ShowFilePicker = null;
        public static final Widget ShowMediaPicker = null;
        public static final Widget ShowPanel = null;
        private final String value;

        private static final /* synthetic */ Widget[] $values() {
            return new Widget[]{ShowFilePicker, ShowMediaPicker, ShowPanel};
        }

        public static EnumEntries<Widget> getEntries() {
            return $ENTRIES;
        }

        static {
            ShowFilePicker = new Widget("ShowFilePicker", 0, "showFilePicker");
            ShowMediaPicker = new Widget("ShowMediaPicker", 1, "showMediaPicker");
            ShowPanel = new Widget("ShowPanel", 2, "showPanel");
            Widget[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Widget[] values() {
            return (Widget[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static Widget valueOf(String r100) {
            return (Widget) a.a(Widget.class, r100);
        }

        private Widget(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.WIDGET.getValue(), r102});
        }
    }

    static {
        INSTANCE = new LKAPIModules();
    }

    private LKAPIModules() {
    }

    public final List<String> getAllValue() {
        List[] r100 = new List[23];
        App[] r101 = App.values();
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r102.add(r101[r105].getValue());
        r105 = r105 + 1;
        goto L3
    L5:
        r100[0] = r102;
        Passport[] r106 = Passport.values();
        ArrayList r107 = new ArrayList(r106.length);
        int r108 = r106.length;
        int r109 = 0;
    L6:
        if (r109 >= r108) goto L8;
        r107.add(r106[r109].getValue());
        r109 = r109 + 1;
        goto L6
    L8:
        r100[1] = r107;
        System[] r110 = System.values();
        ArrayList r111 = new ArrayList(r110.length);
        int r112 = r110.length;
        int r113 = 0;
    L9:
        if (r113 >= r112) goto L11;
        r111.add(r110[r113].getValue());
        r113 = r113 + 1;
        goto L9
    L11:
        r100[2] = r111;
        UI[] r114 = UI.values();
        ArrayList r115 = new ArrayList(r114.length);
        int r116 = r114.length;
        int r117 = 0;
    L12:
        if (r117 >= r116) goto L14;
        r115.add(r114[r117].getValue());
        r117 = r117 + 1;
        goto L12
    L14:
        r100[3] = r115;
        Webview[] r118 = Webview.values();
        ArrayList r119 = new ArrayList(r118.length);
        int r120 = r118.length;
        int r121 = 0;
    L15:
        if (r121 >= r120) goto L17;
        r119.add(r118[r121].getValue());
        r121 = r121 + 1;
        goto L15
    L17:
        r100[4] = r119;
        Widget[] r122 = Widget.values();
        ArrayList r123 = new ArrayList(r122.length);
        int r124 = r122.length;
        int r125 = 0;
    L18:
        if (r125 >= r124) goto L20;
        r123.add(r122[r125].getValue());
        r125 = r125 + 1;
        goto L18
    L20:
        r100[5] = r123;
        Internal.AppConfig[] r126 = Internal.AppConfig.values();
        ArrayList r127 = new ArrayList(r126.length);
        int r128 = r126.length;
        int r129 = 0;
    L21:
        if (r129 >= r128) goto L23;
        r127.add(r126[r129].getValue());
        r129 = r129 + 1;
        goto L21
    L23:
        r100[6] = r127;
        Internal.Log[] r130 = Internal.Log.values();
        ArrayList r131 = new ArrayList(r130.length);
        int r132 = r130.length;
        int r133 = 0;
    L24:
        if (r133 >= r132) goto L26;
        r131.add(r130[r133].getValue());
        r133 = r133 + 1;
        goto L24
    L26:
        r100[7] = r131;
        Internal.Net[] r134 = Internal.Net.values();
        ArrayList r135 = new ArrayList(r134.length);
        int r136 = r134.length;
        int r137 = 0;
    L27:
        if (r137 >= r136) goto L29;
        r135.add(r134[r137].getValue());
        r137 = r137 + 1;
        goto L27
    L29:
        r100[8] = r135;
        Internal.Resource[] r138 = Internal.Resource.values();
        ArrayList r139 = new ArrayList(r138.length);
        int r140 = r138.length;
        int r141 = 0;
    L30:
        if (r141 >= r140) goto L32;
        r139.add(r138[r141].getValue());
        r141 = r141 + 1;
        goto L30
    L32:
        r100[9] = r139;
        Internal.Storage[] r142 = Internal.Storage.values();
        ArrayList r143 = new ArrayList(r142.length);
        int r144 = r142.length;
        int r145 = 0;
    L33:
        if (r145 >= r144) goto L35;
        r143.add(r142[r145].getValue());
        r145 = r145 + 1;
        goto L33
    L35:
        r100[10] = r143;
        Internal.Slardar[] r146 = Internal.Slardar.values();
        ArrayList r147 = new ArrayList(r146.length);
        int r148 = r146.length;
        int r149 = 0;
    L36:
        if (r149 >= r148) goto L38;
        r147.add(r146[r149].getValue());
        r149 = r149 + 1;
        goto L36
    L38:
        r100[11] = r147;
        Internal.System[] r150 = Internal.System.values();
        ArrayList r151 = new ArrayList(r150.length);
        int r152 = r150.length;
        int r153 = 0;
    L39:
        if (r153 >= r152) goto L41;
        r151.add(r150[r153].getValue());
        r153 = r153 + 1;
        goto L39
    L41:
        r100[12] = r151;
        Internal.Tea[] r154 = Internal.Tea.values();
        ArrayList r155 = new ArrayList(r154.length);
        int r156 = r154.length;
        int r157 = 0;
    L42:
        if (r157 >= r156) goto L44;
        r155.add(r154[r157].getValue());
        r157 = r157 + 1;
        goto L42
    L44:
        r100[13] = r155;
        Internal.Transport[] r158 = Internal.Transport.values();
        ArrayList r159 = new ArrayList(r158.length);
        int r160 = r158.length;
        int r161 = 0;
    L45:
        if (r161 >= r160) goto L47;
        r159.add(r158[r161].getValue());
        r161 = r161 + 1;
        goto L45
    L47:
        r100[14] = r159;
        Internal.Webview[] r162 = Internal.Webview.values();
        ArrayList r163 = new ArrayList(r162.length);
        int r164 = r162.length;
        int r165 = 0;
    L48:
        if (r165 >= r164) goto L50;
        r163.add(r162[r165].getValue());
        r165 = r165 + 1;
        goto L48
    L50:
        r100[15] = r163;
        Internal.Widget[] r166 = Internal.Widget.values();
        ArrayList r167 = new ArrayList(r166.length);
        int r168 = r166.length;
        int r169 = 0;
    L51:
        if (r169 >= r168) goto L53;
        r167.add(r166[r169].getValue());
        r169 = r169 + 1;
        goto L51
    L53:
        r100[16] = r167;
        Biz.Profile[] r170 = Biz.Profile.values();
        ArrayList r171 = new ArrayList(r170.length);
        int r172 = r170.length;
        int r173 = 0;
    L54:
        if (r173 >= r172) goto L56;
        r171.add(r170[r173].getValue());
        r173 = r173 + 1;
        goto L54
    L56:
        r100[17] = r171;
        Biz.Chat[] r174 = Biz.Chat.values();
        ArrayList r175 = new ArrayList(r174.length);
        int r176 = r174.length;
        int r177 = 0;
    L57:
        if (r177 >= r176) goto L59;
        r175.add(r174[r177].getValue());
        r177 = r177 + 1;
        goto L57
    L59:
        r100[18] = r175;
        Biz.Todo[] r178 = Biz.Todo.values();
        ArrayList r179 = new ArrayList(r178.length);
        int r180 = r178.length;
        int r181 = 0;
    L60:
        if (r181 >= r180) goto L62;
        r179.add(r178[r181].getValue());
        r181 = r181 + 1;
        goto L60
    L62:
        r100[19] = r179;
        Biz.Statistics[] r182 = Biz.Statistics.values();
        ArrayList r183 = new ArrayList(r182.length);
        int r184 = r182.length;
        int r185 = 0;
    L63:
        if (r185 >= r184) goto L65;
        r183.add(r182[r185].getValue());
        r185 = r185 + 1;
        goto L63
    L65:
        r100[20] = r183;
        Biz.Workplace[] r186 = Biz.Workplace.values();
        ArrayList r187 = new ArrayList(r186.length);
        int r188 = r186.length;
        int r189 = 0;
    L66:
        if (r189 >= r188) goto L68;
        r187.add(r186[r189].getValue());
        r189 = r189 + 1;
        goto L66
    L68:
        r100[21] = r187;
        Biz.Mail[] r190 = Biz.Mail.values();
        ArrayList r191 = new ArrayList(r190.length);
        int r192 = r190.length;
    L69:
        if (r104 >= r192) goto L71;
        r191.add(r190[r104].getValue());
        r104 = r104 + 1;
        goto L69
    L71:
        r100[22] = r191;
        return CollectionsKt.flatten(CollectionsKt.listOf(r100));
    }

    public final String buildValue(String... r110) {
        Intrinsics.checkNotNullParameter(r110, "parts");
        return BASE + ArraysKt.joinToString$default(r110, ".", null, null, 0, null, null, 62, null);
    }
}
