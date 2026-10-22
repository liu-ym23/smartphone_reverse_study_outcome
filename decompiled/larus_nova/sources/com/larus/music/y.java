package com.larus.music;

import com.larus.account.base.api.IDouyinAuthService;
import com.larus.platform.api.i5;
import com.larus.platform.api.j5;
import com.larus.platform.api.p4;
import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: classes30.dex */
public final class y implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p4 f359610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j5 f359611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f359612c;

    public static final class a implements n38.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p4 f359613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f359614b;

        public a(p4 r100, x r101) {
            this.f359613a = r100;
            this.f359614b = r101;
        }

        @Override // n38.q
        public final void a(boolean r110, Integer r111, String r112, String r113, String r210, String r211) {
            p4 r100 = this.f359613a;
            String r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.f365227a;
        L6:
            String r103 = ar9.b.b(ThirdPartyMusicPlatform.LunaMusicType);
            p4 r104 = this.f359613a;
            if (r104 == null) goto L9;
            String r105 = r104.f365229c;
        L10:
            if (r104 == null) goto L12;
            String r106 = r104.f365233g;
        L13:
            if (r104 == null) goto L15;
            String r114 = r104.f365232f;
        L16:
            if (r104 == null) goto L18;
            String r115 = r104.f365230d;
        L19:
            if (r104 == null) goto L21;
            r101 = r104.f365228b;
        L21:
            w0.d(r102, r103, r105, r110 ? 1 : 0, null, r106, r101, null, r114, r115, null, 3216);
            this.f359614b.a(r110, false);
            return;
        L18:
            r115 = null;
            goto L19
        L15:
            r114 = null;
            goto L16
        L12:
            r106 = null;
            goto L13
        L9:
            r105 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    public y(p4 r100, j5 r101, x r102) {
        this.f359610a = r100;
        this.f359611b = r101;
        this.f359612c = r102;
    }

    @Override // com.larus.music.k
    public final void a(String r110, String r111, String r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "lunaClientKey");
        Intrinsics.checkNotNullParameter(r111, "lunaScope");
        Intrinsics.checkNotNullParameter(r112, "lunaState");
        Intrinsics.checkNotNullParameter(r113, "lunaTraceInfo");
        IDouyinAuthService r100 = (IDouyinAuthService) ServiceManager.get().getService(IDouyinAuthService.class);
        p4 r114 = this.f359610a;
        String r101 = null;
        if (r114 == null) goto L5;
        String r102 = r114.f365227a;
    L6:
        String r103 = ar9.b.b(ThirdPartyMusicPlatform.LunaMusicType);
        p4 r115 = this.f359610a;
        if (r115 == null) goto L9;
        String r104 = r115.f365229c;
    L10:
        if (r115 == null) goto L12;
        String r105 = r115.f365233g;
    L13:
        if (r115 == null) goto L15;
        String r106 = r115.f365232f;
    L16:
        if (r115 == null) goto L18;
        String r107 = r115.f365230d;
    L19:
        if (r115 == null) goto L21;
        r101 = r115.f365228b;
    L21:
        w0.f(r102, r103, r104, r105, r101, r106, r107, null, 384);
        if (r100 == null) goto L29;
        i5 r116 = this.f359611b.f365178h;
        if (r116 == null) goto L26;
        boolean r108 = r116.f365161j;
    L27:
        r100.b(r110, r111, r112, r108, new a(this.f359610a, this.f359612c));
        return;
    L26:
        r108 = false;
        goto L27
    L29:
        return;
    L18:
        r107 = null;
        goto L19
    L15:
        r106 = null;
        goto L16
    L12:
        r105 = null;
        goto L13
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
