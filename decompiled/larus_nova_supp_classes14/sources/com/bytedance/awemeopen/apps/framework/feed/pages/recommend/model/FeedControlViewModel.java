package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR+\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/FeedControlViewModel;", "Landroidx/lifecycle/ViewModel;", "", "awemeId", "", "fastSpeedMode", "", "setFastSpeedMode", "", "longPressSpeedDownX", "F", "getLongPressSpeedDownX", "()F", "setLongPressSpeedDownX", "(F)V", "longPressSpeedDownY", "getLongPressSpeedDownY", "setLongPressSpeedDownY", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "fastSpeedModeEvent", "Landroidx/lifecycle/MutableLiveData;", "getFastSpeedModeEvent", "()Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FeedControlViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String VIEW_MODEL_PREFIX = "FEED_CONTROL_";
    private final MutableLiveData<Pair<String, Boolean>> fastSpeedModeEvent;
    private float longPressSpeedDownX;
    private float longPressSpeedDownY;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FeedControlViewModel() {
        this.fastSpeedModeEvent = new MutableLiveData();
    }

    public final MutableLiveData<Pair<String, Boolean>> getFastSpeedModeEvent() {
        return this.fastSpeedModeEvent;
    }

    public final float getLongPressSpeedDownX() {
        return this.longPressSpeedDownX;
    }

    public final float getLongPressSpeedDownY() {
        return this.longPressSpeedDownY;
    }

    public final void setLongPressSpeedDownX(float r1) {
        this.longPressSpeedDownX = r1;
    }

    public final void setLongPressSpeedDownY(float r1) {
        this.longPressSpeedDownY = r1;
    }

    @JvmStatic
    public static final FeedControlViewModel create(ViewModelStoreOwner r3, String r4) {
        Companion.getClass();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        if (r3 == null) goto L7;
        ViewModelProviderFactory r1 = ViewModelProviderFactory.a;
        r1.getClass();
        return (FeedControlViewModel) new ViewModelProvider(r3, r1).get(VIEW_MODEL_PREFIX + r3 + r4, FeedControlViewModel.class);
    L7:
        return null;
    }

    public final void setFastSpeedMode(String r3, boolean r4) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.fastSpeedModeEvent.setValue(TuplesKt.to(r3, Boolean.valueOf(r4)));
        return;
    L8:
        this.fastSpeedModeEvent.postValue(TuplesKt.to(r3, Boolean.valueOf(r4)));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
