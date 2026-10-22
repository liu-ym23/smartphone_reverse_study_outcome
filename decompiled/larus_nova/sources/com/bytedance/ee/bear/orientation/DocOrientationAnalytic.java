package com.bytedance.ee.bear.orientation;

import com.bytedance.ee.bear.contract.d;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final class DocOrientationAnalytic {

    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType HORIZONTAL_SCREEN = null;
        public static final ActionType SYSTEM_AUTO_MATIC = null;
        public static final ActionType VERTICAL_SCREEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f236225a = null;
        private String actionType;

        static {
            ActionType r100 = new ActionType("SYSTEM_AUTO_MATIC", 0, "system_automatic");
            SYSTEM_AUTO_MATIC = r100;
            ActionType r101 = new ActionType("HORIZONTAL_SCREEN", 1, "horizontal_screen");
            HORIZONTAL_SCREEN = r101;
            ActionType r102 = new ActionType("VERTICAL_SCREEN", 2, "vertical_screen");
            VERTICAL_SCREEN = r102;
            f236225a = new ActionType[]{r100, r101, r102};
        }

        public static ActionType[] values() {
            return (ActionType[]) f236225a.clone();
        }

        public String getActionType() {
            return this.actionType;
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        public ActionType(String r100, int r101, String r102) {
            super(r100, r101);
            this.actionType = r102;
        }
    }

    public static final enum ButtonLocation extends Enum<ButtonLocation> {
        public static final ButtonLocation FLOAT = null;
        public static final ButtonLocation TOP_BAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ButtonLocation[] f236226a = null;
        private String location;

        static {
            ButtonLocation r100 = new ButtonLocation("TOP_BAR", 0, "topbar");
            TOP_BAR = r100;
            ButtonLocation r101 = new ButtonLocation("FLOAT", 1, "float");
            FLOAT = r101;
            f236226a = new ButtonLocation[]{r100, r101};
        }

        public static ButtonLocation[] values() {
            return (ButtonLocation[]) f236226a.clone();
        }

        public String getLocation() {
            return this.location;
        }

        public static ButtonLocation valueOf(String r100) {
            return (ButtonLocation) a.a(ButtonLocation.class, r100);
        }

        public ButtonLocation(String r100, int r101, String r102) {
            super(r100, r101);
            this.location = r102;
        }
    }

    public DocOrientationAnalytic() {
    }

    public static void a(String r100, String r101, HashMap r102, boolean r103) {
        HashMap r104 = new HashMap();
        if (r102 != null) goto L10;
    L5:
        r104.put("click", r101);     // Catch: Exception -> L7
        r104.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L7
        r104.put("is_version", Boolean.valueOf(r103));     // Catch: Exception -> L7
        tt5.a.h("DocOrientationAnalytic", "event: " + r100 + " params: " + r104.toString());     // Catch: Exception -> L7
        ((d) org.koin.java.a.a(d.class)).n(r100, r104);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.l("DocOrientationAnalytic", "Failed to report preload, ", e);
        return;
    L10:
        r104.putAll(r102);     // Catch: Exception -> L7
        goto L5
    }

    public static void b(String r100, String r101, HashMap r102, boolean r103) {
        HashMap r104 = new HashMap();
        if (r102 != null) goto L10;
    L5:
        r104.put("click", r100);     // Catch: Exception -> L7
        r104.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L7
        r104.put("button_location", r101);     // Catch: Exception -> L7
        r104.put("is_version", Boolean.valueOf(r103));     // Catch: Exception -> L7
        tt5.a.h("DocOrientationAnalytic", "event: ccm_doc_mobile_switch_vertical_click params: " + r104.toString());     // Catch: Exception -> L7
        ((d) org.koin.java.a.a(d.class)).n("ccm_doc_mobile_switch_vertical_click", r104);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.l("DocOrientationAnalytic", "Failed to report preload, ", e);
        return;
    L10:
        r104.putAll(r102);     // Catch: Exception -> L7
        goto L5
    }
}
