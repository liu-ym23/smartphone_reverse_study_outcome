package com.bytedance.ee.bear.document.onboarding;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes16.dex */
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

        public CustomData(OnBoardingData r100) {
            this.this$0 = r100;
            this.confirmText = "";
            this.hideArrow = false;
            this.makeTextCenter = false;
        }
    }

    public static final enum Direction extends Enum<Direction> {
        public static final Direction DOWN = null;
        public static final Direction UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f220695a = null;

        static {
            Direction r100 = new Direction("UP", 0);
            UP = r100;
            Direction r101 = new Direction("DOWN", 1);
            DOWN = r101;
            f220695a = new Direction[]{r100, r101};
        }

        public static Direction[] values() {
            return (Direction[]) f220695a.clone();
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public Direction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum OnBoardingType extends Enum<OnBoardingType> {
        public static final OnBoardingType CARD = null;
        public static final OnBoardingType FLOW = null;
        public static final OnBoardingType TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OnBoardingType[] f220696a = null;

        static {
            OnBoardingType r100 = new OnBoardingType(CardAdapter.TEXT, 0);
            TEXT = r100;
            OnBoardingType r101 = new OnBoardingType("FLOW", 1);
            FLOW = r101;
            OnBoardingType r102 = new OnBoardingType("CARD", 2);
            CARD = r102;
            f220696a = new OnBoardingType[]{r100, r101, r102};
        }

        public static OnBoardingType[] values() {
            return (OnBoardingType[]) f220696a.clone();
        }

        public static OnBoardingType valueOf(String r100) {
            return (OnBoardingType) r27.a.a(OnBoardingType.class, r100);
        }

        public OnBoardingType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class Position implements NonProguard {
        public float height;
        public float width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public float f220697x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f220698y;

        public String toString() {
            return String.format("Position[%s,%s] width: %s, height: %s", new Object[]{Float.valueOf(this.f220697x), Float.valueOf(this.f220698y), Float.valueOf(this.width), Float.valueOf(this.height)});
        }

        public void transform() {
            float r100 = this.f220697x;
            if (r100 >= 0.0f) goto L5;
            this.width += r100;
            this.f220697x = 0.0f;
        L5:
            float r101 = this.f220698y;
            if (r101 >= 0.0f) goto L8;
            this.height += r101;
            this.f220698y = 0.0f;
        L8:
            this.f220697x = n.c(this.f220697x);
            this.f220698y = n.c(this.f220698y);
            this.width = n.c(this.width);
            this.height = n.c(this.height);
            if ((this.f220697x + this.width) <= n.v()) goto L12;
            this.width = n.v() - this.f220697x;
        L12:
            if ((this.f220698y + this.height) <= n.t()) goto L15;
            this.height = n.t() - this.f220698y;
            return;
        }

        public Position() {
            this.width = 0.0f;
            this.height = 0.0f;
        }
    }

    public String getAction() {
        String r100 = this.action;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String toString() {
        return "OnBoardingData{action='" + this.action + "', currentIndex=" + this.currentIndex + ", totalCount=" + this.totalCount + ", nextID='" + this.nextID + "', isLast=" + this.isLast + ", shouldCheckDependencies=" + this.shouldCheckDependencies + ", position=" + this.position + '}';
    }

    public void transformPositionsIfNeed() {
        Position r100 = this.position;
        if (r100 == null) goto L6;
        r100.transform();
        return;
    }

    public OnBoardingData() {
        this.shouldCheckDependencies = true;
    }
}
