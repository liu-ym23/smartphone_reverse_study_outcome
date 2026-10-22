package com.lynx.tasm.event;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public class LynxEvent {
    private long mEventID;
    private String mName;
    private int mTag;
    private v6a.a mTarget;
    private long mTimestamp;
    private LynxEventType mType;

    public static final enum LynxEventType extends Enum<LynxEventType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxEventType[] f383318a = null;
        public static final LynxEventType kCustom = null;
        public static final LynxEventType kKeyboard = null;
        public static final LynxEventType kMouse = null;
        public static final LynxEventType kNone = null;
        public static final LynxEventType kTouch = null;
        public static final LynxEventType kWheel = null;

        static {
            LynxEventType r100 = new LynxEventType("kNone", 0);
            kNone = r100;
            LynxEventType r101 = new LynxEventType("kTouch", 1);
            kTouch = r101;
            LynxEventType r102 = new LynxEventType("kMouse", 2);
            kMouse = r102;
            LynxEventType r103 = new LynxEventType("kWheel", 3);
            kWheel = r103;
            LynxEventType r104 = new LynxEventType("kKeyboard", 4);
            kKeyboard = r104;
            LynxEventType r105 = new LynxEventType("kCustom", 5);
            kCustom = r105;
            f383318a = new LynxEventType[]{r100, r101, r102, r103, r104, r105};
        }

        public static LynxEventType[] values() {
            return (LynxEventType[]) f383318a.clone();
        }

        public static LynxEventType valueOf(String r100) {
            return (LynxEventType) r27.a.a(LynxEventType.class, r100);
        }

        public LynxEventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ArrayList<Object> getEventParams() {
        ArrayList<Object> r100 = new ArrayList();
        r100.add(this.mName);
        r100.add(Integer.valueOf(this.mType.ordinal()));
        r100.add(Integer.valueOf(this.mTag));
        r100.add(Long.valueOf(this.mTimestamp));
        r100.add(Long.valueOf(this.mEventID));
        return r100;
    }

    public long getEventID() {
        return this.mEventID;
    }

    public String getName() {
        return this.mName;
    }

    public int getTag() {
        return this.mTag;
    }

    public v6a.a getTarget() {
        return this.mTarget;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public LynxEventType getType() {
        return this.mType;
    }

    public void setEventID(long r100) {
        this.mEventID = r100;
    }

    public void setTarget(v6a.a r100) {
        this.mTarget = r100;
    }

    public void setTimestamp(long r100) {
        this.mTimestamp = r100;
    }

    public LynxEvent(int r100, String r101, LynxEventType r102) {
        this.mTag = -1;
        this.mName = "";
        LynxEventType r103 = LynxEventType.kNone;
        this.mTarget = null;
        this.mTimestamp = 0;
        this.mEventID = 0;
        this.mTag = r100;
        this.mName = r101;
        this.mType = r102;
        this.mTimestamp = System.currentTimeMillis();
    }
}
