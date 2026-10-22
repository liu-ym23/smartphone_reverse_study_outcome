package com.suite.lark.component.navroute.activity;

import android.app.Activity;
import androidx.navigation.NavGraphBuilder;
import com.suite.lark.component.navroute.api.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public interface a<T> extends b<T> {

    /* JADX INFO: renamed from: com.suite.lark.component.navroute.activity.a$a, reason: collision with other inner class name */
    public static final class C5521a {
        public static void a(NavGraphBuilder r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "$receiver");
            Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
            a r102 = (a) r101;
            r100.addDestination(new ActivityNavDestination.Builder(r100.getProvider().getNavigator(ActivityNavigator.class), r102.getRoute(), r102.b()).a());
        }
    }

    KClass<? extends Activity> b();
}
