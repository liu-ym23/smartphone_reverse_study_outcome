package com.bytedance.locallife.pdp.container.view.lynx;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public interface LynxLoadDispatcher {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/pdp/container/view/lynx/LynxLoadDispatcher$LoadType;", "", "CACHE", EffectConstants.NORMAL, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType CACHE = null;
        public static final LoadType NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadType[] f261284a = null;

        public static LoadType valueOf(String r100) {
            return (LoadType) r27.a.a(LoadType.class, r100);
        }

        public static LoadType[] values() {
            return (LoadType[]) f261284a.clone();
        }

        static {
            LoadType r100 = new LoadType("CACHE", 0);
            CACHE = r100;
            LoadType r101 = new LoadType(EffectConstants.NORMAL, 1);
            NORMAL = r101;
            f261284a = new LoadType[]{r100, r101};
        }

        public LoadType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a();

        void b(Throwable r100);
    }

    void a(l r100);

    void release();

    void reset();
}
