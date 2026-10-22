package com.bytedance.ee.bear.orientation;

import com.bytedance.ee.bear.contract.d;
import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DocOrientationAnalytic {

    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType HORIZONTAL_SCREEN = null;
        public static final ActionType SYSTEM_AUTO_MATIC = null;
        public static final ActionType VERTICAL_SCREEN = null;
        public static final /* synthetic */ ActionType[] a = null;
        private String actionType;

        static {
            ActionType r0 = new ActionType("SYSTEM_AUTO_MATIC", 0, "system_automatic");
            SYSTEM_AUTO_MATIC = r0;
            ActionType r1 = new ActionType("HORIZONTAL_SCREEN", 1, "horizontal_screen");
            HORIZONTAL_SCREEN = r1;
            ActionType r2 = new ActionType("VERTICAL_SCREEN", 2, "vertical_screen");
            VERTICAL_SCREEN = r2;
            a = new ActionType[]{r0, r1, r2};
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        public String getActionType() {
            return this.actionType;
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r2, String r3) {
            super(r1, r2);
            this.actionType = r3;
        }
    }

    public static final enum ButtonLocation extends Enum<ButtonLocation> {
        public static final ButtonLocation FLOAT = null;
        public static final ButtonLocation TOP_BAR = null;
        public static final /* synthetic */ ButtonLocation[] a = null;
        private String location;

        static {
            ButtonLocation r0 = new ButtonLocation("TOP_BAR", 0, "topbar");
            TOP_BAR = r0;
            ButtonLocation r1 = new ButtonLocation("FLOAT", 1, "float");
            FLOAT = r1;
            a = new ButtonLocation[]{r0, r1};
        }

        public static ButtonLocation[] values() {
            return (ButtonLocation[]) a.clone();
        }

        public String getLocation() {
            return this.location;
        }

        public static ButtonLocation valueOf(String r1) {
            return (ButtonLocation) a.a(ButtonLocation.class, r1);
        }

        public ButtonLocation(String r1, int r2, String r3) {
            super(r1, r2);
            this.location = r3;
        }
    }

    public DocOrientationAnalytic() {
    }

    public static void a(String r3, String r4, HashMap r5, boolean r6) {
        HashMap r1 = new HashMap();
        if (r5 != null) goto L10;
    L5:
        r1.put("click", r4);     // Catch: Exception -> L7
        r1.put("target", "none");     // Catch: Exception -> L7
        r1.put("is_version", Boolean.valueOf(r6));     // Catch: Exception -> L7
        tt5.a.h("DocOrientationAnalytic", "event: " + r3 + " params: " + r1.toString());     // Catch: Exception -> L7
        ((d) org.koin.java.a.a(d.class)).n(r3, r1);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.l("DocOrientationAnalytic", "Failed to report preload, ", e);
        return;
    L10:
        r1.putAll(r5);     // Catch: Exception -> L7
        goto L5
    }

    public static void b(String r4, String r5, HashMap r6, boolean r7) {
        HashMap r2 = new HashMap();
        if (r6 != null) goto L10;
    L5:
        r2.put("click", r4);     // Catch: Exception -> L7
        r2.put("target", "none");     // Catch: Exception -> L7
        r2.put("button_location", r5);     // Catch: Exception -> L7
        r2.put("is_version", Boolean.valueOf(r7));     // Catch: Exception -> L7
        tt5.a.h("DocOrientationAnalytic", "event: ccm_doc_mobile_switch_vertical_click params: " + r2.toString());     // Catch: Exception -> L7
        ((d) org.koin.java.a.a(d.class)).n("ccm_doc_mobile_switch_vertical_click", r2);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.l("DocOrientationAnalytic", "Failed to report preload, ", e);
        return;
    L10:
        r2.putAll(r6);     // Catch: Exception -> L7
        goto L5
    }
}
