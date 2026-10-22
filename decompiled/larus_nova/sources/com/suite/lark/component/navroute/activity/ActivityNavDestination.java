package com.suite.lark.component.navroute.activity;

import android.app.Activity;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.Navigator;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007R\"\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/suite/lark/component/navroute/activity/ActivityNavDestination;", "Landroidx/navigation/NavDestination;", "navigator", "Landroidx/navigation/Navigator;", "<init>", "(Landroidx/navigation/Navigator;)V", "activityClass", "Lkotlin/reflect/KClass;", "Landroid/app/Activity;", "getActivityClass", "()Lkotlin/reflect/KClass;", "setActivityClass", "(Lkotlin/reflect/KClass;)V", "setTargetActivity", "", "clazz", "Builder", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityNavDestination extends NavDestination {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KClass<? extends Activity> f460227a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/suite/lark/component/navroute/activity/ActivityNavDestination$Builder;", "Landroidx/navigation/NavDestinationBuilder;", "Lcom/suite/lark/component/navroute/activity/ActivityNavDestination;", "navigator", "Landroidx/navigation/Navigator;", CloudControlInf.ROUTE, "", "activityClass", "Lkotlin/reflect/KClass;", "Landroid/app/Activity;", "<init>", "(Landroidx/navigation/Navigator;Ljava/lang/String;Lkotlin/reflect/KClass;)V", "build", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder extends NavDestinationBuilder<ActivityNavDestination> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KClass<? extends Activity> f460228a;

        public final ActivityNavDestination a() {
            ActivityNavDestination r100 = (ActivityNavDestination) super.build();
            KClass<? extends Activity> r101 = this.f460228a;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "clazz");
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f460227a = r101;
            return r100;
        }

        @Override // androidx.navigation.NavDestinationBuilder
        public final /* bridge */ /* synthetic */ NavDestination build() {
            return a();
        }

        public Builder(Navigator<? extends ActivityNavDestination> r100, String r101, KClass<? extends Activity> r102) {
            Intrinsics.checkNotNullParameter(r100, "navigator");
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
            Intrinsics.checkNotNullParameter(r102, "activityClass");
            super(r100, r101);
            this.f460228a = r102;
        }
    }

    public ActivityNavDestination(Navigator<? extends ActivityNavDestination> r100) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        super(r100);
    }
}
