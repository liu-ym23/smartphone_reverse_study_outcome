package com.ss.android.ugc.tools.view.widget;

import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
public final class CukaieToast {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f455027a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f455028a = null;

        static {
            f455028a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, DownloadSettingKeys.KEY_HOOK, "getHook()Lcom/ss/android/ugc/tools/view/widget/CukaieToast$ToastHook;", 0))};
        }

        public a() {
        }
    }

    public interface b {
    }

    static {
        new a();
        Intrinsics.checkNotNullParameter(CukaieToast$Companion$hook$2.INSTANCE, "initializer");
        xhc.b r100 = xhc.b.f563918a;
    }
}
