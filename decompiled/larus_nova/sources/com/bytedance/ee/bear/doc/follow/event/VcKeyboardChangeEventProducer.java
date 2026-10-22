package com.bytedance.ee.bear.doc.follow.event;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public interface VcKeyboardChangeEventProducer {

    public static final enum OrientationSwitchMode extends Enum<OrientationSwitchMode> {
        public static final OrientationSwitchMode ADJUST_BY_KEYBOARD_EVENT = null;
        public static final OrientationSwitchMode ALWAYS_PORTRAIT = null;
        public static final OrientationSwitchMode NOT_LIMITED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OrientationSwitchMode[] f217899a = null;

        static {
            OrientationSwitchMode r100 = new OrientationSwitchMode("ALWAYS_PORTRAIT", 0);
            ALWAYS_PORTRAIT = r100;
            OrientationSwitchMode r101 = new OrientationSwitchMode("NOT_LIMITED", 1);
            NOT_LIMITED = r101;
            OrientationSwitchMode r102 = new OrientationSwitchMode("ADJUST_BY_KEYBOARD_EVENT", 2);
            ADJUST_BY_KEYBOARD_EVENT = r102;
            f217899a = new OrientationSwitchMode[]{r100, r101, r102};
        }

        public static OrientationSwitchMode[] values() {
            return (OrientationSwitchMode[]) f217899a.clone();
        }

        public static OrientationSwitchMode valueOf(String r100) {
            return (OrientationSwitchMode) a.a(OrientationSwitchMode.class, r100);
        }

        public OrientationSwitchMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VcBottomBarPolicy extends Enum<VcBottomBarPolicy> {
        public static final VcBottomBarPolicy ADJUST_BY_KEYBOARD = null;
        public static final VcBottomBarPolicy ALWAYS_HIDE = null;
        public static final VcBottomBarPolicy ALWAYS_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VcBottomBarPolicy[] f217900a = null;

        static {
            VcBottomBarPolicy r100 = new VcBottomBarPolicy("ADJUST_BY_KEYBOARD", 0);
            ADJUST_BY_KEYBOARD = r100;
            VcBottomBarPolicy r101 = new VcBottomBarPolicy("ALWAYS_SHOW", 1);
            ALWAYS_SHOW = r101;
            VcBottomBarPolicy r102 = new VcBottomBarPolicy("ALWAYS_HIDE", 2);
            ALWAYS_HIDE = r102;
            f217900a = new VcBottomBarPolicy[]{r100, r101, r102};
        }

        public static VcBottomBarPolicy[] values() {
            return (VcBottomBarPolicy[]) f217900a.clone();
        }

        public static VcBottomBarPolicy valueOf(String r100) {
            return (VcBottomBarPolicy) a.a(VcBottomBarPolicy.class, r100);
        }

        public VcBottomBarPolicy(String r100, int r101) {
            super(r100, r101);
        }
    }

    OrientationSwitchMode getOrientationSwitchMode();

    VcBottomBarPolicy getVcBottomBarPolicy();
}
