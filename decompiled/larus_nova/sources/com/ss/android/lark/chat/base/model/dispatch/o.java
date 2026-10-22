package com.ss.android.lark.chat.base.model.dispatch;

/* JADX INFO: loaded from: classes35.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f411794a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411795a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ResourceType.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ResourceType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f411795a = r100;
        }
    }

    static {
    }
}
