package com.suite.lark.component.navroute.forseti;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.suite.lark.component.navroute.NavRouter;
import com.suite.lark.component.navroute.group.NavRouterProvider;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public interface g extends com.suite.lark.component.navroute.api.a<ForsetiNavOptions, ForsetiNavOptions.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f460343a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f460344a = null;

        static {
            f460344a = new a();
        }

        public a() {
        }

        @JvmStatic
        public static g a(Fragment r100, com.suite.lark.component.navroute.api.d r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            NavRouter.a r102 = NavRouter.f460191a;
            if (NavRouter.c(Reflection.getOrCreateKotlinClass(g.class)) == true) goto L5;
            com.suite.lark.component.navroute.api.a r103 = null;
        L7:
            return (g) r103;
        L5:
            NavRouterProvider r104 = NavRouter.f460192b;
            KClass r105 = Reflection.getOrCreateKotlinClass(g.class);
            r104.getClass();
            r103 = NavRouterProvider.a(r100, r105, r101);
            goto L7
        }
    }

    static {
        f460343a = a.f460344a;
    }
}
