package com.ss.android.lark.feed.shared.hitpoint;

import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.integrator.im.feed_shared.dependency.f;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.connect.common.Constants;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedHitPointNew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421188a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedClickSubType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Button", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedClickSubType extends Enum<FeedClickSubType> {
        public static final FeedClickSubType Button = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedClickSubType[] f421189a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421190b = null;
        private final String value;

        public static EnumEntries<FeedClickSubType> getEntries() {
            return f421190b;
        }

        static {
            FeedClickSubType r100 = new FeedClickSubType();
            Button = r100;
            FeedClickSubType[] r101 = {r100};
            f421189a = r101;
            f421190b = EnumEntriesKt.enumEntries(r101);
        }

        public FeedClickSubType() {
            super("Button", 0);
            this.value = "cta";
        }

        public static FeedClickSubType[] values() {
            return (FeedClickSubType[]) f421189a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static FeedClickSubType valueOf(String r100) {
            return (FeedClickSubType) r27.a.a(FeedClickSubType.class, r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedDelayedPopupClickParam;", "", "action", "", PickerReporterConstants.KEY.TARGET, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "ESC", "OPEN", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedDelayedPopupClickParam extends Enum<FeedDelayedPopupClickParam> {
        public static final FeedDelayedPopupClickParam ESC = null;
        public static final FeedDelayedPopupClickParam OPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedDelayedPopupClickParam[] f421191a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421192b = null;
        private final String action;
        private final String target;

        public static EnumEntries<FeedDelayedPopupClickParam> getEntries() {
            return f421192b;
        }

        static {
            FeedDelayedPopupClickParam r100 = new FeedDelayedPopupClickParam("ESC", 0, "esc", "feed_main_view");
            ESC = r100;
            FeedDelayedPopupClickParam r101 = new FeedDelayedPopupClickParam("OPEN", 1, "open", "feed_grouping_edit_view");
            OPEN = r101;
            FeedDelayedPopupClickParam[] r102 = {r100, r101};
            f421191a = r102;
            f421192b = EnumEntriesKt.enumEntries(r102);
        }

        public static FeedDelayedPopupClickParam[] values() {
            return (FeedDelayedPopupClickParam[]) f421191a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static FeedDelayedPopupClickParam valueOf(String r100) {
            return (FeedDelayedPopupClickParam) r27.a.a(FeedDelayedPopupClickParam.class, r100);
        }

        public FeedDelayedPopupClickParam(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.action = r102;
            this.target = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedGroupingEditClickParam;", "", "action", "", PickerReporterConstants.KEY.TARGET, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "FEED_GROUPING_EDIT_FILTER_TOGGLE", "FEED_GROUPING_EDIT_SAVE", "FEED_GROUPING_EDIT_CLOSE", "FEED_GROUPING_EDIT_MINUS", "FEED_GROUPING_EDIT_PLUS", "FEED_FILTER_TOGGLE", "FEED_MUTE_FILTER_TOGGLE", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedGroupingEditClickParam extends Enum<FeedGroupingEditClickParam> {
        public static final FeedGroupingEditClickParam FEED_FILTER_TOGGLE = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_CLOSE = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_FILTER_TOGGLE = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_MINUS = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_PLUS = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_SAVE = null;
        public static final FeedGroupingEditClickParam FEED_MUTE_FILTER_TOGGLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedGroupingEditClickParam[] f421193a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421194b = null;
        private final String action;
        private final String target;

        public static EnumEntries<FeedGroupingEditClickParam> getEntries() {
            return f421194b;
        }

        static {
            FeedGroupingEditClickParam r100 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_FILTER_TOGGLE", 0, "feed_grouping_edit_filter_toggle");
            FEED_GROUPING_EDIT_FILTER_TOGGLE = r100;
            FeedGroupingEditClickParam r101 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_SAVE", 1, "feed_grouping_edit_save");
            FEED_GROUPING_EDIT_SAVE = r101;
            FeedGroupingEditClickParam r102 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_CLOSE", 2, "feed_grouping_edit_close");
            FEED_GROUPING_EDIT_CLOSE = r102;
            FeedGroupingEditClickParam r103 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_MINUS", 3, "feed_grouping_edit_minus");
            FEED_GROUPING_EDIT_MINUS = r103;
            FeedGroupingEditClickParam r104 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_PLUS", 4, "feed_grouping_edit_plus");
            FEED_GROUPING_EDIT_PLUS = r104;
            FeedGroupingEditClickParam r105 = new FeedGroupingEditClickParam("FEED_FILTER_TOGGLE", 5, "efficiency_feed_grouping_edit_filter_toggle");
            FEED_FILTER_TOGGLE = r105;
            FeedGroupingEditClickParam r110 = new FeedGroupingEditClickParam("FEED_MUTE_FILTER_TOGGLE", 6, "efficiency_mute_toggle");
            FEED_MUTE_FILTER_TOGGLE = r110;
            FeedGroupingEditClickParam[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f421193a = r111;
            f421194b = EnumEntriesKt.enumEntries(r111);
        }

        public static FeedGroupingEditClickParam[] values() {
            return (FeedGroupingEditClickParam[]) f421193a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static FeedGroupingEditClickParam valueOf(String r100) {
            return (FeedGroupingEditClickParam) r27.a.a(FeedGroupingEditClickParam.class, r100);
        }

        public FeedGroupingEditClickParam(String r100, int r101, String r102) {
            super(r100, r101);
            this.action = r102;
            this.target = "none";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedMainClickParam;", "", "action", "", PickerReporterConstants.KEY.TARGET, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "FEED_GROUPING_TAB", "FEED_MORE_TAB_MOBILE", "FEED_LEFTCLICK_CHAT", "FEED_LEFTCLICK_DOC", "FEED_LEFTCLICK_APP_FEED", "FEED_LEFTSLIDE", "FEED_RIGHTSLIDE", "FEED_DONE_MOBILE", "MESSAGE_SETTING", "FEED_MORE_TAB_TO_SETTING", "FEED_MORE_TAB_TO_EDIT", "FEED_MORE_TAB_TO_CANCEL", "MSG_LEFTCLICK", "MSG_PRESS", "FEED_PRESS", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedMainClickParam extends Enum<FeedMainClickParam> {
        public static final FeedMainClickParam FEED_DONE_MOBILE = null;
        public static final FeedMainClickParam FEED_GROUPING_TAB = null;
        public static final FeedMainClickParam FEED_LEFTCLICK_APP_FEED = null;
        public static final FeedMainClickParam FEED_LEFTCLICK_CHAT = null;
        public static final FeedMainClickParam FEED_LEFTCLICK_DOC = null;
        public static final FeedMainClickParam FEED_LEFTSLIDE = null;
        public static final FeedMainClickParam FEED_MORE_TAB_MOBILE = null;
        public static final FeedMainClickParam FEED_MORE_TAB_TO_CANCEL = null;
        public static final FeedMainClickParam FEED_MORE_TAB_TO_EDIT = null;
        public static final FeedMainClickParam FEED_MORE_TAB_TO_SETTING = null;
        public static final FeedMainClickParam FEED_PRESS = null;
        public static final FeedMainClickParam FEED_RIGHTSLIDE = null;
        public static final FeedMainClickParam MESSAGE_SETTING = null;
        public static final FeedMainClickParam MSG_LEFTCLICK = null;
        public static final FeedMainClickParam MSG_PRESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedMainClickParam[] f421195a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421196b = null;
        private final String action;
        private final String target;

        public static EnumEntries<FeedMainClickParam> getEntries() {
            return f421196b;
        }

        static {
            FeedMainClickParam r100 = new FeedMainClickParam("FEED_GROUPING_TAB", 0, "feed_grouping_tab", "none");
            FEED_GROUPING_TAB = r100;
            FeedMainClickParam r101 = new FeedMainClickParam("FEED_MORE_TAB_MOBILE", 1, "feed_more_tab_mobile", "feed_grouping_edit_view");
            FEED_MORE_TAB_MOBILE = r101;
            FeedMainClickParam r102 = new FeedMainClickParam("FEED_LEFTCLICK_CHAT", 2, "feed_leftclick_chat", "im_chat_main_view");
            FEED_LEFTCLICK_CHAT = r102;
            FeedMainClickParam r103 = new FeedMainClickParam("FEED_LEFTCLICK_DOC", 3, "feed_leftclick_doc", "ccm_docs_page_view");
            FEED_LEFTCLICK_DOC = r103;
            FeedMainClickParam r104 = new FeedMainClickParam("FEED_LEFTCLICK_APP_FEED", 4, "leftclick_app_feed_card", "");
            FEED_LEFTCLICK_APP_FEED = r104;
            FeedMainClickParam r110 = new FeedMainClickParam("FEED_LEFTSLIDE", 5, "feed_leftslide", "feed_leftslide_detail_view");
            FEED_LEFTSLIDE = r110;
            FeedMainClickParam r111 = new FeedMainClickParam("FEED_RIGHTSLIDE", 6, "feed_rightslide", "feed_rightslide_detail_view");
            FEED_RIGHTSLIDE = r111;
            FeedMainClickParam r105 = new FeedMainClickParam("FEED_DONE_MOBILE", 7, "feed_done_mobile", "");
            FEED_DONE_MOBILE = r105;
            FeedMainClickParam r112 = new FeedMainClickParam("MESSAGE_SETTING", 8, "message_setting", "setting_main_view");
            MESSAGE_SETTING = r112;
            FeedMainClickParam r106 = new FeedMainClickParam("FEED_MORE_TAB_TO_SETTING", 9, "grouping_setting", "setting_detail_view");
            FEED_MORE_TAB_TO_SETTING = r106;
            FeedMainClickParam r107 = new FeedMainClickParam("FEED_MORE_TAB_TO_EDIT", 10, "feed_grouping_edit", "feed_grouping_edit_view");
            FEED_MORE_TAB_TO_EDIT = r107;
            FeedMainClickParam r108 = new FeedMainClickParam("FEED_MORE_TAB_TO_CANCEL", 11, "cancel", "none");
            FEED_MORE_TAB_TO_CANCEL = r108;
            FeedMainClickParam r109 = new FeedMainClickParam("MSG_LEFTCLICK", 12, "msg_leftclick", "im_chat_main_view");
            MSG_LEFTCLICK = r109;
            FeedMainClickParam r113 = new FeedMainClickParam("MSG_PRESS", 13, "msg_press", "feed_msg_press_view");
            MSG_PRESS = r113;
            FeedMainClickParam r114 = new FeedMainClickParam("FEED_PRESS", 14, "feed_press", "feed_press_view");
            FEED_PRESS = r114;
            FeedMainClickParam[] r115 = {r100, r101, r102, r103, r104, r110, r111, r105, r112, r106, r107, r108, r109, r113, r114};
            f421195a = r115;
            f421196b = EnumEntriesKt.enumEntries(r115);
        }

        public static FeedMainClickParam[] values() {
            return (FeedMainClickParam[]) f421195a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static FeedMainClickParam valueOf(String r100) {
            return (FeedMainClickParam) r27.a.a(FeedMainClickParam.class, r100);
        }

        public FeedMainClickParam(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.action = r102;
            this.target = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedStatusUpdateType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TITLE_UPDATE", "AVATAR_UPDATE", "BADGE_UPDATE", "DISPLAY_TIME_UPDATE", "RANK_TIME_UPDATE", "DONE", "CANCEL_DONE", "MUTE", "CANCEL_MUTE", "ON_TEMP_TOP", "CANCEL_TEMP_TOP", "BUTTON_UPDATE", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedStatusUpdateType extends Enum<FeedStatusUpdateType> {
        public static final FeedStatusUpdateType AVATAR_UPDATE = null;
        public static final FeedStatusUpdateType BADGE_UPDATE = null;
        public static final FeedStatusUpdateType BUTTON_UPDATE = null;
        public static final FeedStatusUpdateType CANCEL_DONE = null;
        public static final FeedStatusUpdateType CANCEL_MUTE = null;
        public static final FeedStatusUpdateType CANCEL_TEMP_TOP = null;
        public static final FeedStatusUpdateType DISPLAY_TIME_UPDATE = null;
        public static final FeedStatusUpdateType DONE = null;
        public static final FeedStatusUpdateType MUTE = null;
        public static final FeedStatusUpdateType ON_TEMP_TOP = null;
        public static final FeedStatusUpdateType RANK_TIME_UPDATE = null;
        public static final FeedStatusUpdateType TITLE_UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedStatusUpdateType[] f421197a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421198b = null;
        private final String value;

        public static EnumEntries<FeedStatusUpdateType> getEntries() {
            return f421198b;
        }

        static {
            FeedStatusUpdateType r100 = new FeedStatusUpdateType("TITLE_UPDATE", 0, "2");
            TITLE_UPDATE = r100;
            FeedStatusUpdateType r101 = new FeedStatusUpdateType("AVATAR_UPDATE", 1, "3");
            AVATAR_UPDATE = r101;
            FeedStatusUpdateType r102 = new FeedStatusUpdateType("BADGE_UPDATE", 2, "5");
            BADGE_UPDATE = r102;
            FeedStatusUpdateType r103 = new FeedStatusUpdateType("DISPLAY_TIME_UPDATE", 3, "6");
            DISPLAY_TIME_UPDATE = r103;
            FeedStatusUpdateType r104 = new FeedStatusUpdateType("RANK_TIME_UPDATE", 4, "7");
            RANK_TIME_UPDATE = r104;
            FeedStatusUpdateType r105 = new FeedStatusUpdateType("DONE", 5, "8");
            DONE = r105;
            FeedStatusUpdateType r110 = new FeedStatusUpdateType("CANCEL_DONE", 6, Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
            CANCEL_DONE = r110;
            FeedStatusUpdateType r111 = new FeedStatusUpdateType("MUTE", 7, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
            MUTE = r111;
            FeedStatusUpdateType r112 = new FeedStatusUpdateType("CANCEL_MUTE", 8, "11");
            CANCEL_MUTE = r112;
            FeedStatusUpdateType r113 = new FeedStatusUpdateType("ON_TEMP_TOP", 9, "12");
            ON_TEMP_TOP = r113;
            FeedStatusUpdateType r114 = new FeedStatusUpdateType("CANCEL_TEMP_TOP", 10, "13");
            CANCEL_TEMP_TOP = r114;
            FeedStatusUpdateType r106 = new FeedStatusUpdateType("BUTTON_UPDATE", 11, Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
            BUTTON_UPDATE = r106;
            FeedStatusUpdateType[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
            f421197a = r107;
            f421198b = EnumEntriesKt.enumEntries(r107);
        }

        public static FeedStatusUpdateType[] values() {
            return (FeedStatusUpdateType[]) f421197a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static FeedStatusUpdateType valueOf(String r100) {
            return (FeedStatusUpdateType) r27.a.a(FeedStatusUpdateType.class, r100);
        }

        public FeedStatusUpdateType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$NavigationTopClickParam;", "", "action", "", PickerReporterConstants.KEY.TARGET, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "SEARCH", "FEED_PLUS", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NavigationTopClickParam extends Enum<NavigationTopClickParam> {
        public static final NavigationTopClickParam FEED_PLUS = null;
        public static final NavigationTopClickParam SEARCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NavigationTopClickParam[] f421199a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421200b = null;
        private final String action;
        private final String target;

        public static EnumEntries<NavigationTopClickParam> getEntries() {
            return f421200b;
        }

        static {
            NavigationTopClickParam r100 = new NavigationTopClickParam("SEARCH", 0, "search", "search_main_view");
            SEARCH = r100;
            NavigationTopClickParam r101 = new NavigationTopClickParam("FEED_PLUS", 1, "feed_plus", "feed_plus_view");
            FEED_PLUS = r101;
            NavigationTopClickParam[] r102 = {r100, r101};
            f421199a = r102;
            f421200b = EnumEntriesKt.enumEntries(r102);
        }

        public static NavigationTopClickParam[] values() {
            return (NavigationTopClickParam[]) f421199a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static NavigationTopClickParam valueOf(String r100) {
            return (NavigationTopClickParam) r27.a.a(NavigationTopClickParam.class, r100);
        }

        public NavigationTopClickParam(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.action = r102;
            this.target = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$SettingDetailType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "LEFT_OFF", "RECENT_UNREAD", "TOGGLE_ON", "TOGGLE_OFF", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SettingDetailType extends Enum<SettingDetailType> {
        public static final SettingDetailType LEFT_OFF = null;
        public static final SettingDetailType RECENT_UNREAD = null;
        public static final SettingDetailType TOGGLE_OFF = null;
        public static final SettingDetailType TOGGLE_ON = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SettingDetailType[] f421201a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421202b = null;
        private final String type;

        public static EnumEntries<SettingDetailType> getEntries() {
            return f421202b;
        }

        static {
            SettingDetailType r100 = new SettingDetailType("LEFT_OFF", 0, "left_off");
            LEFT_OFF = r100;
            SettingDetailType r101 = new SettingDetailType("RECENT_UNREAD", 1, "most_recent_unread");
            RECENT_UNREAD = r101;
            SettingDetailType r102 = new SettingDetailType("TOGGLE_ON", 2, "on");
            TOGGLE_ON = r102;
            SettingDetailType r103 = new SettingDetailType("TOGGLE_OFF", 3, "off");
            TOGGLE_OFF = r103;
            SettingDetailType[] r104 = {r100, r101, r102, r103};
            f421201a = r104;
            f421202b = EnumEntriesKt.enumEntries(r104);
        }

        public static SettingDetailType[] values() {
            return (SettingDetailType[]) f421201a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static SettingDetailType valueOf(String r100) {
            return (SettingDetailType) r27.a.a(SettingDetailType.class, r100);
        }

        public SettingDetailType(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(FeedDelayedPopupClickParam r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Statistics.sendEvent("feed_delayed_popup_click", new JSONObject().put("click", r100.getAction()).put(PickerReporterConstants.KEY.TARGET, r100.getTarget()));
    }

    @JvmStatic
    public static final void b(FeedMainClickParam r100, Map<String, ? extends Object> r101, FeedFolder r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (r102 == null) goto L8;
        String r104 = r102.label();
        if (r104 == null) goto L8;
        String r105 = r104.toLowerCase(Locale.ROOT);
        if (r105 == null) goto L8;
    L9:
        peb.b r106 = heb.a.f484903a;
        ((f) r106.getFeedDependency()).getClass();
        FeedFolderCompat r107 = FeedFolderCompat.INSTANCE;
        if (r107.getMESSAGE_WITHOUT_DOUBAO().isSameFolderWith(r107.getEXPIRED_FOLD()) == false) goto L12;
        String r108 = "expired_fold";
    L14:
        if (r101 != null) goto L16;
        r101 = MapsKt.emptyMap();
    L16:
        Statistics.sendEvent("feed_main_click", new JSONObject(r101).put("click", r100.getAction()).put("belonged_tab", r108).put(PickerReporterConstants.KEY.TARGET, r100.getTarget()).put("is_important_top", r103 ? 1 : 0).put("target_tab", r105));
        return;
    L12:
        ((f) r106.getFeedDependency()).getClass();
        r108 = r107.getMESSAGE_WITHOUT_DOUBAO().label().toLowerCase(Locale.ROOT);
    L8:
        r105 = "";
        goto L9
    }

    public static void c(FeedMainClickParam r100, Map r101, boolean r102, int r103) {
        FeedFolder r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        ((f) heb.a.f484903a.getFeedDependency()).getClass();
        r104 = FeedFolderCompat.INSTANCE.getMESSAGE_WITHOUT_DOUBAO();
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = false;
    L11:
        b(r100, r101, r104, r102);
    }
}
