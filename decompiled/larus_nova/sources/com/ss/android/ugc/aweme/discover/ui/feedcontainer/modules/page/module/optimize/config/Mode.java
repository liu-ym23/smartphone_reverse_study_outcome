package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/Mode;", "", "Companion", "ON_MAIN_THREAD", "ON_ASYNC_THREAD", "NO_PRELOAD", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Mode extends Enum<Mode> {
    public static final Companion Companion = null;
    public static final Mode NO_PRELOAD = null;
    public static final Mode ON_ASYNC_THREAD = null;
    public static final Mode ON_MAIN_THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Mode[] f450686a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/Mode$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Mode r100 = new Mode("ON_MAIN_THREAD", 0);
        ON_MAIN_THREAD = r100;
        Mode r101 = new Mode("ON_ASYNC_THREAD", 1);
        ON_ASYNC_THREAD = r101;
        Mode r102 = new Mode("NO_PRELOAD", 2);
        NO_PRELOAD = r102;
        f450686a = new Mode[]{r100, r101, r102};
        Companion = new Companion(0);
    }

    public static Mode valueOf(String r100) {
        return (Mode) a.a(Mode.class, r100);
    }

    public static Mode[] values() {
        return (Mode[]) f450686a.clone();
    }

    @JvmStatic
    public static final Mode valueOff(String r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        int r101 = r100.hashCode();
        if (r101 == 3343801) goto L11;
        if (r101 != 93127292) goto L14;
        if (r100.equals("async") == false) goto L14;
        return ON_ASYNC_THREAD;
    L14:
        return NO_PRELOAD;
    L11:
        if (r100.equals(PullConfiguration.PROCESS_NAME_MAIN) == false) goto L14;
        return ON_MAIN_THREAD;
    }

    public Mode(String r100, int r101) {
        super(r100, r101);
    }
}
