package com.bytedance.ee.bear.doc.follow.event;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface VcKeyboardChangeEventProducer {

    public static final enum OrientationSwitchMode extends Enum<OrientationSwitchMode> {
        public static final OrientationSwitchMode ADJUST_BY_KEYBOARD_EVENT = null;
        public static final OrientationSwitchMode ALWAYS_PORTRAIT = null;
        public static final OrientationSwitchMode NOT_LIMITED = null;
        public static final /* synthetic */ OrientationSwitchMode[] a = null;

        static {
            OrientationSwitchMode r0 = new OrientationSwitchMode("ALWAYS_PORTRAIT", 0);
            ALWAYS_PORTRAIT = r0;
            OrientationSwitchMode r1 = new OrientationSwitchMode("NOT_LIMITED", 1);
            NOT_LIMITED = r1;
            OrientationSwitchMode r3 = new OrientationSwitchMode("ADJUST_BY_KEYBOARD_EVENT", 2);
            ADJUST_BY_KEYBOARD_EVENT = r3;
            a = new OrientationSwitchMode[]{r0, r1, r3};
        }

        public static OrientationSwitchMode[] values() {
            return (OrientationSwitchMode[]) a.clone();
        }

        public static OrientationSwitchMode valueOf(String r1) {
            return (OrientationSwitchMode) a.a(OrientationSwitchMode.class, r1);
        }

        public OrientationSwitchMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum VcBottomBarPolicy extends Enum<VcBottomBarPolicy> {
        public static final VcBottomBarPolicy ADJUST_BY_KEYBOARD = null;
        public static final VcBottomBarPolicy ALWAYS_HIDE = null;
        public static final VcBottomBarPolicy ALWAYS_SHOW = null;
        public static final /* synthetic */ VcBottomBarPolicy[] a = null;

        static {
            VcBottomBarPolicy r0 = new VcBottomBarPolicy("ADJUST_BY_KEYBOARD", 0);
            ADJUST_BY_KEYBOARD = r0;
            VcBottomBarPolicy r1 = new VcBottomBarPolicy("ALWAYS_SHOW", 1);
            ALWAYS_SHOW = r1;
            VcBottomBarPolicy r3 = new VcBottomBarPolicy("ALWAYS_HIDE", 2);
            ALWAYS_HIDE = r3;
            a = new VcBottomBarPolicy[]{r0, r1, r3};
        }

        public static VcBottomBarPolicy[] values() {
            return (VcBottomBarPolicy[]) a.clone();
        }

        public static VcBottomBarPolicy valueOf(String r1) {
            return (VcBottomBarPolicy) a.a(VcBottomBarPolicy.class, r1);
        }

        public VcBottomBarPolicy(String r1, int r2) {
            super(r1, r2);
        }
    }

    OrientationSwitchMode getOrientationSwitchMode();

    VcBottomBarPolicy getVcBottomBarPolicy();
}
