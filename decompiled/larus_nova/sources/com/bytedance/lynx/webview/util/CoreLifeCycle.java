package com.bytedance.lynx.webview.util;

import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final class CoreLifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONObject f265438a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f265439b;

    public static final enum Phase extends Enum<Phase> {
        public static final Phase HOOK = null;
        public static final Phase LOAD = null;
        public static final Phase PREPARE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Phase[] f265440a = null;

        static {
            Phase r100 = new Phase("PREPARE", 0);
            PREPARE = r100;
            Phase r101 = new Phase("HOOK", 1);
            HOOK = r101;
            Phase r102 = new Phase("LOAD", 2);
            LOAD = r102;
            f265440a = new Phase[]{r100, r101, r102};
        }

        public static Phase[] values() {
            return (Phase[]) f265440a.clone();
        }

        public static Phase valueOf(String r100) {
            return (Phase) a.a(Phase.class, r100);
        }

        public Phase(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f265438a = new JSONObject();
        f265439b = "";
    }
}
