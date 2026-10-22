package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.api.container.IContainerHostDepend;
import com.bytedance.caijing.sdk.infra.base.api.container.IJsbService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements cd4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoaderProxy f202419a;

    @Override // cd4.m
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // cd4.m
    public final String getName() {
        return "openSchema";
    }

    @Override // cd4.m
    public final <T> void putDependency(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // cd4.m
    public final void release() {
    }

    public j(LoaderProxy r100) {
        this.f202419a = r100;
    }

    @Override // cd4.m
    public final void handle(Context r100, JSONObject r101, cd4.k r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        String r103 = r101.optString("schema");
        if (StringsKt.isBlank(r103) == false) goto L6;
        r102.onFailed("schema is blank", new JSONObject());
        return;
    L6:
        IJsbService r104 = (IJsbService) ve4.b.a(IJsbService.class);
        if (r104 == null) goto L9;
        cd4.g r105 = r104.getEventHelper();
    L10:
        if (r105 == null) goto L12;
        r105.b("cj_half_screen_popup_ready", this.f202419a.f202403f);
    L12:
        if (r105 == null) goto L14;
        r105.b("cj_half_screen_popup_closed", this.f202419a.f202403f);
    L14:
        IContainerHostDepend r106 = (IContainerHostDepend) ve4.b.a(IContainerHostDepend.class);
        if (r106 == null) goto L17;
        r106.openSchema(r103, this.f202419a.f202399b);
    L17:
        r102.onSuccess(new JSONObject());
        return;
    L9:
        r105 = null;
        goto L10
    }
}
