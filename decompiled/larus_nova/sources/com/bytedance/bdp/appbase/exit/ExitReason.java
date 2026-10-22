package com.bytedance.bdp.appbase.exit;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/bdp/appbase/exit/ExitReason;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CAPSULE_BTN", "ANDROID_PHYSICAL_BACK_BTN", "TITLE_BAR_BACK_BTN", "API", "SLIDE", "ANCHOR_ADD", "ANDROID_SYSTEM_BTN", "FE_SHOW_ERROR_PAGE", "LAUNCH_ERROR", "X_SCREEN_CAPSULE_BTN", "X_SCREEN_TOUCH_OUTSIDE_AREA", "X_SCREEN_SLIDE", "RESTART", "JS_ENGINE_FAILURE", "UNDER_AGE", "REFUSE_AUTH", "NOT_LOGIN", "POPUP", "BEFORE_EXIT", "BACKGROUND_KILL", AccountType.OTHERS, "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final enum ExitReason extends Enum<ExitReason> {
    public static final ExitReason ANCHOR_ADD = null;
    public static final ExitReason ANDROID_PHYSICAL_BACK_BTN = null;
    public static final ExitReason ANDROID_SYSTEM_BTN = null;
    public static final ExitReason API = null;
    public static final ExitReason BACKGROUND_KILL = null;
    public static final ExitReason BEFORE_EXIT = null;
    public static final ExitReason CAPSULE_BTN = null;
    public static final ExitReason FE_SHOW_ERROR_PAGE = null;
    public static final ExitReason JS_ENGINE_FAILURE = null;
    public static final ExitReason LAUNCH_ERROR = null;
    public static final ExitReason NOT_LOGIN = null;
    public static final ExitReason OTHERS = null;
    public static final ExitReason POPUP = null;
    public static final ExitReason REFUSE_AUTH = null;
    public static final ExitReason RESTART = null;
    public static final ExitReason SLIDE = null;
    public static final ExitReason TITLE_BAR_BACK_BTN = null;
    public static final ExitReason UNDER_AGE = null;
    public static final ExitReason X_SCREEN_CAPSULE_BTN = null;
    public static final ExitReason X_SCREEN_SLIDE = null;
    public static final ExitReason X_SCREEN_TOUCH_OUTSIDE_AREA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExitReason[] f200797a = null;
    private final String value;

    public static ExitReason valueOf(String r100) {
        return (ExitReason) a.a(ExitReason.class, r100);
    }

    public static ExitReason[] values() {
        return (ExitReason[]) f200797a.clone();
    }

    static {
        ExitReason r100 = new ExitReason("CAPSULE_BTN", 0, "capsule_btn");
        CAPSULE_BTN = r100;
        ExitReason r101 = new ExitReason("ANDROID_PHYSICAL_BACK_BTN", 1, "android_physical_back_btn");
        ANDROID_PHYSICAL_BACK_BTN = r101;
        ExitReason r102 = new ExitReason("TITLE_BAR_BACK_BTN", 2, "title_bar_back");
        TITLE_BAR_BACK_BTN = r102;
        ExitReason r103 = new ExitReason("API", 3, "api");
        API = r103;
        ExitReason r104 = new ExitReason("SLIDE", 4, "slide");
        SLIDE = r104;
        ExitReason r105 = new ExitReason("ANCHOR_ADD", 5, "anchor_add");
        ANCHOR_ADD = r105;
        ExitReason r106 = new ExitReason("ANDROID_SYSTEM_BTN", 6, "android_system_btn");
        ANDROID_SYSTEM_BTN = r106;
        ExitReason r107 = new ExitReason("FE_SHOW_ERROR_PAGE", 7, "fe_show_error_page");
        FE_SHOW_ERROR_PAGE = r107;
        ExitReason r108 = new ExitReason("LAUNCH_ERROR", 8, "launch_error");
        LAUNCH_ERROR = r108;
        ExitReason r109 = new ExitReason("X_SCREEN_CAPSULE_BTN", 9, "x_screen_capsule_btn");
        X_SCREEN_CAPSULE_BTN = r109;
        ExitReason r110 = new ExitReason("X_SCREEN_TOUCH_OUTSIDE_AREA", 10, "x_screen_touch_outside_area");
        X_SCREEN_TOUCH_OUTSIDE_AREA = r110;
        ExitReason r111 = new ExitReason("X_SCREEN_SLIDE", 11, "x_screen_slide");
        X_SCREEN_SLIDE = r111;
        ExitReason r112 = new ExitReason("RESTART", 12, IPerformanceManager.MODULE_RESTART);
        RESTART = r112;
        ExitReason r113 = new ExitReason("JS_ENGINE_FAILURE", 13, "js_engine_failure");
        JS_ENGINE_FAILURE = r113;
        ExitReason r114 = new ExitReason("UNDER_AGE", 14, "teen_indulgence_prevention");
        UNDER_AGE = r114;
        ExitReason r115 = new ExitReason("REFUSE_AUTH", 15, "authentication_refused");
        REFUSE_AUTH = r115;
        ExitReason r116 = new ExitReason("NOT_LOGIN", 16, "not_login");
        NOT_LOGIN = r116;
        ExitReason r117 = new ExitReason("POPUP", 17, "popup");
        POPUP = r117;
        ExitReason r118 = new ExitReason("BEFORE_EXIT", 18, "onBeforeExit");
        BEFORE_EXIT = r118;
        ExitReason r119 = new ExitReason("BACKGROUND_KILL", 19, "background_kill");
        BACKGROUND_KILL = r119;
        ExitReason r120 = new ExitReason(AccountType.OTHERS, 20, "others");
        OTHERS = r120;
        f200797a = new ExitReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
    }

    public final String getValue() {
        return this.value;
    }

    public ExitReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
