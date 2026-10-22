package com.lynx.clay.embedding.engine.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: loaded from: classes32.dex */
public final class ClayAccessibilityBridge extends AccessibilityNodeProvider {

    public static final enum Action extends Enum<Action> {
        public static final Action LONG_PRESS = null;
        public static final Action SCROLL_DOWN = null;
        public static final Action SCROLL_LEFT = null;
        public static final Action SCROLL_RIGHT = null;
        public static final Action SCROLL_UP = null;
        public static final Action SHOW_ON_SCREEN = null;
        public static final Action TAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f380712a = null;
        public final int value;

        static {
            Action r100 = new Action("TAP", 0, 1);
            TAP = r100;
            Action r101 = new Action("LONG_PRESS", 1, 2);
            LONG_PRESS = r101;
            Action r102 = new Action("SCROLL_LEFT", 2, 4);
            SCROLL_LEFT = r102;
            Action r103 = new Action("SCROLL_RIGHT", 3, 8);
            SCROLL_RIGHT = r103;
            Action r104 = new Action("SCROLL_UP", 4, 16);
            SCROLL_UP = r104;
            Action r105 = new Action("SCROLL_DOWN", 5, 32);
            SCROLL_DOWN = r105;
            Action r110 = new Action("SHOW_ON_SCREEN", 6, 64);
            SHOW_ON_SCREEN = r110;
            f380712a = new Action[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static Action[] values() {
            return (Action[]) f380712a.clone();
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Flag extends Enum<Flag> {
        public static final Flag HAS_IMPLICIT_SCROLLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Flag[] f380713a = null;
        final int value;

        static {
            Flag r100 = new Flag();
            HAS_IMPLICIT_SCROLLING = r100;
            f380713a = new Flag[]{r100};
        }

        public Flag() {
            super("HAS_IMPLICIT_SCROLLING", 0);
            this.value = 1;
        }

        public static Flag[] values() {
            return (Flag[]) f380713a.clone();
        }

        public static Flag valueOf(String r100) {
            return (Flag) r27.a.a(Flag.class, r100);
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int r100) {
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int r100) {
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int r100, int r101, Bundle r102) {
        return false;
    }

    public ClayAccessibilityBridge() {
    }
}
