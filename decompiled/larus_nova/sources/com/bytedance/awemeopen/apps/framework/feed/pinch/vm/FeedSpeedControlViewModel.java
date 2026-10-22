package com.bytedance.awemeopen.apps.framework.feed.pinch.vm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0019\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u00130\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/vm/FeedSpeedControlViewModel;", "", "Landroidx/lifecycle/ViewModel;", "", "awemeId", "", "fastSpeedMode", "", "setFastSpeedMode", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "fastSpeedModeEvent", "Landroidx/lifecycle/MutableLiveData;", "getFastSpeedModeEvent", "()Landroidx/lifecycle/MutableLiveData;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FeedSpeedControlViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String VIEW_MODEL_PREFIX = "FEED_CONTROL_";
    private final String eventType;
    private final MutableLiveData<Pair<String, Boolean>> fastSpeedModeEvent;
    private final LifecycleOwner lifecycleOwner;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static FeedSpeedControlViewModel a(LifecycleOwner r100, String r101) {
            if ((r100 instanceof ViewModelStoreOwner) == false) goto L5;
            ViewModelStoreOwner r102 = (ViewModelStoreOwner) r100;
        L6:
            if (r102 != null) goto L8;
            return null;
        L8:
            if (r101 != null) goto L11;
            r101 = "";
        L11:
            return (FeedSpeedControlViewModel) new ViewModelProvider(r102, new FeedControlViewModelFactory(r100, r101)).get(FeedSpeedControlViewModel.VIEW_MODEL_PREFIX + r100 + r101, FeedSpeedControlViewModel.class);
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final FeedSpeedControlViewModel create(LifecycleOwner r100, String r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    public final String getEventType() {
        return this.eventType;
    }

    public MutableLiveData<Pair<String, Boolean>> getFastSpeedModeEvent() {
        return this.fastSpeedModeEvent;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public FeedSpeedControlViewModel(LifecycleOwner r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.lifecycleOwner = r100;
        this.eventType = r101;
        this.fastSpeedModeEvent = new MutableLiveData();
    }

    public final void setFastSpeedMode(String r100, boolean r101) {
        if (b.b() == false) goto L5;
        getFastSpeedModeEvent().setValue(TuplesKt.to(r100, Boolean.valueOf(r101)));
        return;
    L5:
        getFastSpeedModeEvent().postValue(TuplesKt.to(r100, Boolean.valueOf(r101)));
    }
}
