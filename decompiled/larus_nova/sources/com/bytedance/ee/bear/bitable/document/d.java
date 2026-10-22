package com.bytedance.ee.bear.bitable.document;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginapi.RootBackPressAbility;
import com.ss.android.lark.chameleon.pluginapi.RootBackPressResult;
import com.ss.android.lark.chameleon.pluginapi.RootBackPressSource;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements hk5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedDocxContainerFragment f211111a;

    public static final class a implements RootBackPressAbility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedDocxContainerFragment f211112a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.document.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3031a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f211113a = null;

            static {
                int[] r100 = new int[RootBackPressSource.values().length];
                r100[RootBackPressSource.SYSTEM_BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[RootBackPressSource.TITLE_BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f211113a = r100;
            }
        }

        public a(LinkedDocxContainerFragment r100) {
            this.f211112a = r100;
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.RootBackPressAbility
        public final RootBackPressResult onRootBackPressed(RootBackPressSource r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            int r101 = C3031a.f211113a[r100.ordinal()];
            if (r101 == 1) goto L13;
            if (r101 != 2) goto L11;
            Function0<Unit> r102 = this.f211112a.f211102k;
            if (r102 == null) goto L14;
            r102.invoke();
        L14:
            return RootBackPressResult.CONSUMED;
        L11:
            throw new NoWhenBranchMatchedException();
        L13:
            return RootBackPressResult.PROPAGATE;
        }
    }

    @Override // hk5.a
    public final void onOpenFailedBeforeHost() {
        Function0<Unit> r100 = this.f211111a.f211102k;
        if (r100 == null) goto L6;
        r100.invoke();
        return;
    }

    public d(LinkedDocxContainerFragment r100) {
        this.f211111a = r100;
    }

    @Override // hk5.a
    public final void onAttachToHost(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        r100.registerHostAbility(new a(this.f211111a));
        r100.registerHostAbility(this.f211111a.f211103l);
        this.f211111a.S90();
    }
}
