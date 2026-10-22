package com.bytedance.ee.bear.document.onboarding;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OnBoardingData implements NonProguard {
    public String action;
    public Integer currentIndex;
    public CustomData customData;
    public boolean isLast;
    public String nextID;
    public Position position;
    public boolean shouldCheckDependencies;
    public Integer totalCount;

    public class CustomData implements NonProguard {
        public String body;
        public String confirmText;
        public boolean hideArrow;
        public String imgRes;
        public boolean makeTextCenter;
        public String onboardingViewTag;
        public Direction suggestedDirection;
        final /* synthetic */ OnBoardingData this$0;
        public String title;
        public OnBoardingType type;

        public CustomData(OnBoardingData r1) {
            this.this$0 = r1;
            this.confirmText = "";
            this.hideArrow = false;
            this.makeTextCenter = false;
        }
    }

    public static final enum Direction extends Enum<Direction> {
        public static final Direction DOWN = null;
        public static final Direction UP = null;
        public static final /* synthetic */ Direction[] a = null;

        static {
            Direction r0 = new Direction("UP", 0);
            UP = r0;
            Direction r1 = new Direction("DOWN", 1);
            DOWN = r1;
            a = new Direction[]{r0, r1};
        }

        public static Direction[] values() {
            return (Direction[]) a.clone();
        }

        public static Direction valueOf(String r1) {
            return (Direction) r27.a.a(Direction.class, r1);
        }

        public Direction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum OnBoardingType extends Enum<OnBoardingType> {
        public static final OnBoardingType CARD = null;
        public static final OnBoardingType FLOW = null;
        public static final OnBoardingType TEXT = null;
        public static final /* synthetic */ OnBoardingType[] a = null;

        static {
            OnBoardingType r0 = new OnBoardingType("TEXT", 0);
            TEXT = r0;
            OnBoardingType r1 = new OnBoardingType("FLOW", 1);
            FLOW = r1;
            OnBoardingType r3 = new OnBoardingType("CARD", 2);
            CARD = r3;
            a = new OnBoardingType[]{r0, r1, r3};
        }

        public static OnBoardingType[] values() {
            return (OnBoardingType[]) a.clone();
        }

        public static OnBoardingType valueOf(String r1) {
            return (OnBoardingType) r27.a.a(OnBoardingType.class, r1);
        }

        public OnBoardingType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class Position implements NonProguard {
        public float height;
        public float width;
        public float x;
        public float y;

        public String toString() {
            return String.format("Position[%s,%s] width: %s, height: %s", new Object[]{Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.width), Float.valueOf(this.height)});
        }

        public void transform() {
            float r0 = this.x;
            if (r0 >= 0.0f) goto L5;
            this.width += r0;
            this.x = 0.0f;
        L5:
            float r1 = this.y;
            if (r1 >= 0.0f) goto L8;
            this.height += r1;
            this.y = 0.0f;
        L8:
            this.x = n.c(this.x);
            this.y = n.c(this.y);
            this.width = n.c(this.width);
            this.height = n.c(this.height);
            if ((this.x + this.width) <= n.v()) goto L12;
            this.width = n.v() - this.x;
        L12:
            if ((this.y + this.height) <= n.t()) goto L15;
            this.height = n.t() - this.y;
            return;
        }

        public Position() {
            this.width = 0.0f;
            this.height = 0.0f;
        }
    }

    public String getAction() {
        String r0 = this.action;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String toString() {
        return "OnBoardingData{action='" + this.action + "', currentIndex=" + this.currentIndex + ", totalCount=" + this.totalCount + ", nextID='" + this.nextID + "', isLast=" + this.isLast + ", shouldCheckDependencies=" + this.shouldCheckDependencies + ", position=" + this.position + '}';
    }

    public void transformPositionsIfNeed() {
        Position r0 = this.position;
        if (r0 == null) goto L6;
        r0.transform();
        return;
    }

    public OnBoardingData() {
        this.shouldCheckDependencies = true;
    }
}
