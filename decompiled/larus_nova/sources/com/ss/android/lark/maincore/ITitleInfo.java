package com.ss.android.lark.maincore;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public interface ITitleInfo {

    public static final enum IconStyle extends Enum<IconStyle> {
        public static final IconStyle Down = null;
        public static final IconStyle Hide = null;
        public static final IconStyle Up = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IconStyle[] f431575a = null;
        private int value;

        static {
            IconStyle r100 = new IconStyle("Hide", 0, 0);
            Hide = r100;
            IconStyle r101 = new IconStyle("Up", 1, 1);
            Up = r101;
            IconStyle r102 = new IconStyle("Down", 2, 2);
            Down = r102;
            f431575a = new IconStyle[]{r100, r101, r102};
        }

        public static IconStyle[] values() {
            return (IconStyle[]) f431575a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static IconStyle forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return Down;
        L12:
            return Up;
        L14:
            return Hide;
        }

        public static IconStyle valueOf(String r100) {
            return (IconStyle) a.a(IconStyle.class, r100);
        }

        public static IconStyle valueOf(int r100) {
            return forNumber(r100);
        }

        public IconStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status Loading = null;
        public static final Status Normal = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f431576a = null;
        private int value;

        static {
            Status r100 = new Status("Normal", 0, 0);
            Normal = r100;
            Status r101 = new Status("Loading", 1, 1);
            Loading = r101;
            f431576a = new Status[]{r100, r101};
        }

        public static Status[] values() {
            return (Status[]) f431576a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return Loading;
        L10:
            return Normal;
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public static Status valueOf(int r100) {
            return forNumber(r100);
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
