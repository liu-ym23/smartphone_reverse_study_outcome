package com.bytedance.android.shopping.store.tabkit.monitor;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\t\b\u0016¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\t\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/monitor/TabkitSwitchTabPref;", "Lcom/bytedance/android/shopping/store/tabkit/monitor/TabkitFramePref;", "", "reported", "Z", "getReported", "()Z", "setReported", "(Z)V", "<init>", "()V", "", "", "", "map", "(Ljava/util/Map;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabkitSwitchTabPref extends TabkitFramePref {
    public static final a Companion = null;
    public static final String T_PAGE_SHOW = "t_page_show";
    public static final String T_RENDER_TAB_END = "t_render_tab_end";
    public static final String T_TAB_CHECK_ENV_END_TIME = "t_tab_check_env_end_time";
    public static final String T_TAB_CHECK_ENV_START_TIME = "t_tab_check_env_start_time";
    public static final String T_TAB_CLICK_TIME = "t_tab_click_time";
    public static final String T_TAB_CONTAINER_INIT_END = "t_tab_container_init_end";
    public static final String T_TAB_CONTAINER_INIT_START = "t_tab_container_init_start";
    public static final String T_TAB_CONTAINER_LOAD_SUCCESS = "t_tab_container_load_success";
    public static final String T_TAB_CONTAINER_RUNTIME_READY = "t_tab_container_runtime_ready";
    public static final String T_TAB_INIT = "t_tab_init";
    public static final String T_TAB_NET_END_TIME = "t_tab_net_end_time";
    public static final String T_TAB_NET_START_TIME = "t_tab_net_start_time";
    public static final String T_TAB_REQUEST_END = "t_tab_request_end";
    public static final String T_TAB_REQUEST_START = "t_tab_request_start";
    public static final String T_TAB_UPDATE_END_TIME = "t_tab_update_end_time";
    public static final String T_TAB_UPDATE_START_TIME = "t_tab_update_start_time";
    private boolean reported;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TabkitSwitchTabPref() {
    }

    public final boolean getReported() {
        return this.reported;
    }

    public TabkitSwitchTabPref(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this();
        putAll(r2);
    }

    public final void setReported(boolean r1) {
        this.reported = r1;
    }
}
