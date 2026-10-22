package com.bytedance.reparo.secondary;

import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.model.PatchFetchInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f267474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f267475b = null;

    public class a implements v87.a {
        public a() {
        }

        @Override // v87.a
        public final void a(Event r100) {
            d r101 = c.f267474a;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }
    }

    static {
        f267475b = new a();
    }

    public static Event b(boolean r100) {
        Event r101 = new Event();
        r101.f267342a = "Reparo";
        r101.f267344c = "sdk_init";
        r101.f267355n = f267475b;
        if (r100 == false) goto L5;
        r101.f267343b = 0;
        r101.f267348g = true;
    L6:
        return r101;
    L5:
        r101.f267343b = 2;
        r101.f267348g = false;
        goto L6
    }

    public static Event c(boolean r100) {
        Event r101 = new Event();
        r101.f267342a = "PatchManager";
        r101.f267344c = "query_remote_patch_info";
        r101.f267355n = f267475b;
        if (r100 == false) goto L5;
        r101.f267343b = 0;
        r101.f267348g = true;
    L6:
        return r101;
    L5:
        r101.f267343b = 2;
        r101.f267348g = false;
        goto L6
    }

    public static Event a(PatchFetchInfo r100, boolean r101) {
        Event r102 = new Event();
        r102.f267342a = "PatchUpdateTask";
        r102.f267344c = "patch_download";
        r102.f267355n = f267475b;
        if (r101 == false) goto L5;
        r102.f267343b = 0;
        r102.f267348g = true;
    L6:
        r102.i("patch_version", String.valueOf(r100.getVersionCode()));
        r102.i("patch_id", String.valueOf(r100.getPatchId()));
        return r102;
    L5:
        r102.f267343b = 2;
        r102.f267348g = false;
        goto L6
    }
}
