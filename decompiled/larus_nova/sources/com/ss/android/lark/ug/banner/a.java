package com.ss.android.lark.ug.banner;

import com.ss.android.lark.pb.ug_reach.BannerMaterial;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f444358a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.ug.banner.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5363a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444359a = null;

        static {
            int[] r100 = new int[BannerMaterial.BannerType.values().length];
            r100[BannerMaterial.BannerType.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BannerMaterial.BannerType.TEMPLATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BannerMaterial.BannerType.CUSTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f444359a = r100;
        }
    }

    static {
    }
}
