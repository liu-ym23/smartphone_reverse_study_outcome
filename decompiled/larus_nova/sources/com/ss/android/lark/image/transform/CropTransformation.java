package com.ss.android.lark.image.transform;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final class CropTransformation {

    public static final enum CropType extends Enum<CropType> {
        public static final CropType BOTTOM = null;
        public static final CropType CENTER = null;
        public static final CropType TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CropType[] f426368a = null;
        private int value;

        static {
            CropType r100 = new CropType("TOP", 0, 1);
            TOP = r100;
            CropType r101 = new CropType("CENTER", 1, 2);
            CENTER = r101;
            CropType r102 = new CropType("BOTTOM", 2, 3);
            BOTTOM = r102;
            f426368a = new CropType[]{r100, r101, r102};
        }

        public static CropType[] values() {
            return (CropType[]) f426368a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CropType forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return BOTTOM;
        L13:
            return CENTER;
        L15:
            return TOP;
        }

        public static CropType valueOf(String r100) {
            return (CropType) a.a(CropType.class, r100);
        }

        public static CropType valueOf(int r100) {
            return forNumber(r100);
        }

        public CropType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
