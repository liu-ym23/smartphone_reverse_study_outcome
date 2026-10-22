package com.ss.android.lark.appcontext.timingdector;

/* JADX INFO: loaded from: classes34.dex */
public interface IMainPageDescriber {

    public static final enum ContentShowType extends Enum<ContentShowType> {
        public static final ContentShowType Activity = null;
        public static final ContentShowType Custom = null;
        public static final ContentShowType Fragment = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContentShowType[] f408909a = null;

        static {
            ContentShowType r100 = new ContentShowType("Fragment", 0);
            Fragment = r100;
            ContentShowType r101 = new ContentShowType("Activity", 1);
            Activity = r101;
            ContentShowType r102 = new ContentShowType("Custom", 2);
            Custom = r102;
            f408909a = new ContentShowType[]{r100, r101, r102};
        }

        public static ContentShowType[] values() {
            return (ContentShowType[]) f408909a.clone();
        }

        public static ContentShowType valueOf(String r100) {
            return (ContentShowType) r27.a.a(ContentShowType.class, r100);
        }

        public ContentShowType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {
    }

    a a();
}
