package com.larus.basic.experience.downgrade.api;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.flow.performance.thermal.SystemBatteryRecoder;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COLD_LAUNCH", "HOT_LAUNCH", "ENTER_BACKGROUND", "RETRY", "REFRESH", "LOAD_MORE", "NETWORK_CHANGE", "CLICK_ENTRANCE", "ENTER_CONVERSATION", "ENTER_CONVERSATION_LIST", "ENTER_PAGE", "AFTER_LAUNCH", "CMD", "POLLING", "SETTINGS_CHANGE", "CLICK_ACTION", "PRE_LOADING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DowngradeSource extends Enum<DowngradeSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DowngradeSource[] $VALUES = null;
    public static final DowngradeSource AFTER_LAUNCH = null;
    public static final DowngradeSource CLICK_ACTION = null;
    public static final DowngradeSource CLICK_ENTRANCE = null;
    public static final DowngradeSource CMD = null;
    public static final DowngradeSource COLD_LAUNCH = null;
    public static final DowngradeSource ENTER_BACKGROUND = null;
    public static final DowngradeSource ENTER_CONVERSATION = null;
    public static final DowngradeSource ENTER_CONVERSATION_LIST = null;
    public static final DowngradeSource ENTER_PAGE = null;
    public static final DowngradeSource HOT_LAUNCH = null;
    public static final DowngradeSource LOAD_MORE = null;
    public static final DowngradeSource NETWORK_CHANGE = null;
    public static final DowngradeSource POLLING = null;
    public static final DowngradeSource PRE_LOADING = null;
    public static final DowngradeSource REFRESH = null;
    public static final DowngradeSource RETRY = null;
    public static final DowngradeSource SETTINGS_CHANGE = null;
    private final String value;

    private static final /* synthetic */ DowngradeSource[] $values() {
        return new DowngradeSource[]{COLD_LAUNCH, HOT_LAUNCH, ENTER_BACKGROUND, RETRY, REFRESH, LOAD_MORE, NETWORK_CHANGE, CLICK_ENTRANCE, ENTER_CONVERSATION, ENTER_CONVERSATION_LIST, ENTER_PAGE, AFTER_LAUNCH, CMD, POLLING, SETTINGS_CHANGE, CLICK_ACTION, PRE_LOADING};
    }

    public static EnumEntries<DowngradeSource> getEntries() {
        return $ENTRIES;
    }

    static {
        COLD_LAUNCH = new DowngradeSource("COLD_LAUNCH", 0, BdpAppEventConstant.PARAMS_COLD_LAUNCH);
        HOT_LAUNCH = new DowngradeSource("HOT_LAUNCH", 1, "hot_launch");
        ENTER_BACKGROUND = new DowngradeSource("ENTER_BACKGROUND", 2, "enter_background");
        RETRY = new DowngradeSource("RETRY", 3, EventConstant.Value.RETRY);
        REFRESH = new DowngradeSource("REFRESH", 4, "refresh");
        LOAD_MORE = new DowngradeSource("LOAD_MORE", 5, GYLFetchType.LOAD_MORE);
        NETWORK_CHANGE = new DowngradeSource("NETWORK_CHANGE", 6, "network_change");
        CLICK_ENTRANCE = new DowngradeSource("CLICK_ENTRANCE", 7, "click_entrance");
        ENTER_CONVERSATION = new DowngradeSource("ENTER_CONVERSATION", 8, "enter_conversation");
        ENTER_CONVERSATION_LIST = new DowngradeSource("ENTER_CONVERSATION_LIST", 9, "enter_conversation_list");
        ENTER_PAGE = new DowngradeSource("ENTER_PAGE", 10, CheckPointType.ENTER_PAGE);
        AFTER_LAUNCH = new DowngradeSource("AFTER_LAUNCH", 11, "after_launch");
        CMD = new DowngradeSource("CMD", 12, "cmd");
        POLLING = new DowngradeSource("POLLING", 13, SystemBatteryRecoder.BatteryRecordReason.POLLING);
        SETTINGS_CHANGE = new DowngradeSource("SETTINGS_CHANGE", 14, "settings_change");
        CLICK_ACTION = new DowngradeSource("CLICK_ACTION", 15, "click_action");
        PRE_LOADING = new DowngradeSource("PRE_LOADING", 16, "pre_loading");
        DowngradeSource[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DowngradeSource[] values() {
        return (DowngradeSource[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DowngradeSource valueOf(String r100) {
        return (DowngradeSource) a.a(DowngradeSource.class, r100);
    }

    private DowngradeSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
