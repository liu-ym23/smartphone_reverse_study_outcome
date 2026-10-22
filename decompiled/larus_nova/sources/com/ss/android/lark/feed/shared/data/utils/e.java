package com.ss.android.lark.feed.shared.data.utils;

import android.graphics.drawable.Drawable;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements com.ss.android.lark.h.b, peb.b.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static e f421168b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Drawable> f421169a;

    public class a implements MemoryCallbackManager.MemoryCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f421170a;

        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onTrimMemory(int r100, int r101, int r102, int r103) {
        }

        @Override // com.ss.android.lark.monitor.callback.MemoryCallbackManager.MemoryCallback
        public final void onJavaMemoryReachTop() {
            if (((ConcurrentHashMap) this.f421170a.f421169a).size() <= 1000) goto L8;
            Map<Integer, Drawable> r100 = this.f421170a.f421169a;
            if (r100 == null) goto L9;
            ((ConcurrentHashMap) r100).clear();
            return;
        L9:
            return;
        }

        public a(e r100) {
            this.f421170a = r100;
        }
    }

    public e() {
        this.f421169a = new ConcurrentHashMap();
        peb.b r100 = heb.a.f484903a;
        r100.getSettingDependency().d();
        r100.getSettingDependency().c(this);
        MemoryCallbackManager.getInstance().registerMemoryCallback(new a(this));
    }

    public final void a(String r100, LarkNameTag r101, com.larksuite.component.ui.tag.d r102) {
        if (r100 == null) goto L7;
        if (r102 == null) goto L8;
        ((ConcurrentHashMap) this.f421169a).put(Integer.valueOf((r101.hashCode() * 31) + r100.hashCode()), r102);
        Log.d("FeedTagHelper", "setTagCache:" + r101.hashCode() + "/false");
        return;
    L8:
        return;
    }
}
