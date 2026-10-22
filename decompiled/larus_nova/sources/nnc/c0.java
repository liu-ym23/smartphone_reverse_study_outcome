package nnc;

import android.app.Activity;
import androidx.navigation.NavGraphBuilder;
import com.suite.lark.component.navroute.activity.PlaceHolderRouteActivity;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
public final class c0 implements com.suite.lark.component.navroute.activity.a<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f519721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KClass<Unit> f519722b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KClass<? extends Activity> f519723c = null;

    public c0() {
    }

    @Override // com.suite.lark.component.navroute.api.b
    public final String getRoute() {
        return "place_holder_activity";
    }

    static {
        f519721a = new c0();
        f519722b = Reflection.getOrCreateKotlinClass(Unit.class);
        f519723c = Reflection.getOrCreateKotlinClass(PlaceHolderRouteActivity.class);
    }

    @Override // com.suite.lark.component.navroute.activity.a
    public final KClass<? extends Activity> b() {
        return f519723c;
    }

    @Override // com.suite.lark.component.navroute.api.b
    public final <D extends com.suite.lark.component.navroute.api.b<?>> void c(NavGraphBuilder r100, D r101) {
        com.suite.lark.component.navroute.activity.a.C5521a.a(r100, r101);
    }
}
