package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.HongbaoCover;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.ss.android.lark.image.entity.PassThroughImage;

/* JADX INFO: loaded from: classes37.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437637a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f437638a = null;

        static {
            int[] r100 = new int[HongbaoCover.CoverType.values().length];
            r100[HongbaoCover.CoverType.CUSTOMIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[HongbaoCover.CoverType.TEMPLATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f437638a = r100;
        }
    }

    static {
    }

    public static PassThroughImage a(ImageSetPassThrough r100) {
        return new PassThroughImage(r100.key, r100.fs_unit, r100.crypto);
    }
}
