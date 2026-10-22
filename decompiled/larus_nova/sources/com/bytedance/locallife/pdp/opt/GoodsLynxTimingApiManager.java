package com.bytedance.locallife.pdp.opt;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class GoodsLynxTimingApiManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f261615a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/pdp/opt/GoodsLynxTimingApiManager$FLAG;", "", "COMMON", "PRELOAD", "DEFAULT_VIEW_RENDER", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum FLAG extends Enum<FLAG> {
        public static final FLAG COMMON = null;
        public static final FLAG DEFAULT_VIEW_RENDER = null;
        public static final FLAG PRELOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FLAG[] f261616a = null;

        public static FLAG valueOf(String r100) {
            return (FLAG) r27.a.a(FLAG.class, r100);
        }

        public static FLAG[] values() {
            return (FLAG[]) f261616a.clone();
        }

        static {
            FLAG r100 = new FLAG("COMMON", 0);
            COMMON = r100;
            FLAG r101 = new FLAG("PRELOAD", 1);
            PRELOAD = r101;
            FLAG r102 = new FLAG("DEFAULT_VIEW_RENDER", 2);
            DEFAULT_VIEW_RENDER = r102;
            f261616a = new FLAG[]{r100, r101, r102};
        }

        public FLAG(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f261617a = null;

        static {
            int[] r100 = new int[FLAG.values().length];
            r100[FLAG.PRELOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FLAG.DEFAULT_VIEW_RENDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f261617a = r100;
        }
    }

    static {
    }

    public GoodsLynxTimingApiManager() {
    }

    public static void a(Map r100, FLAG r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, ForwardDependency$ForwardLocation.FLAG);
        int r102 = a.f261617a[r101.ordinal()];
        if (r102 != 1) goto L5;
        r100.put("__lynx_timing_flag", "__lynx_preload_actual_fmp");
        return;
    L5:
        if (r102 == 2) goto L7;
        r100.put("__lynx_timing_flag", "__lynx_timing_actual_fmp");
        return;
    L7:
        r100.put("__lynx_timing_flag", "__lynx_default_view_render_actual_fmp");
    }
}
