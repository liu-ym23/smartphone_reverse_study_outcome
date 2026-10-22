package com.larus.music;

import com.google.gson.JsonObject;
import com.larus.platform.api.IAppletJsbEventService;
import com.larus.platform.api.h4;
import com.larus.platform.api.i5;
import com.larus.platform.api.j5;
import com.larus.platform.api.o4;
import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x implements h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f359608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j5 f359609b;

    public x(p r100, j5 r101) {
        this.f359608a = r100;
        this.f359609b = r101;
    }

    @Override // com.larus.platform.api.h4
    public final void a(boolean r110, boolean r111) {
        Function1<Boolean, Unit> r100 = this.f359608a;
        if (r100 == null) goto L5;
        r100.invoke(Boolean.valueOf(r110));
    L5:
        MusicAuthManager r101 = MusicAuthManager.f359456a;
        i5 r102 = this.f359609b.f365178h;
        if (r102 == null) goto L8;
        String r103 = r102.f365152a;
    L9:
        ThirdPartyMusicPlatform r104 = ThirdPartyMusicPlatform.LunaMusicType;
        Intrinsics.checkNotNullParameter(r104, "thirdPartyMusicPlatform");
        if (r103 == null) goto L13;
        JsonObject r105 = new JsonObject();
        r105.addProperty("id", r103);
        r105.addProperty("authTarget", r104.getValue());
        r105.addProperty("isAuthorized", Boolean.valueOf(r110));
        com.larus.platform.service.k.f365753a.a(IAppletJsbEventService.TriggeredEvent.AUTH_RESULT, r105);
    L13:
        i5 r106 = this.f359609b.f365178h;
        if (r106 == null) goto L18;
        Function4<? super Integer, ? super Boolean, ? super ThirdPartyMusicPlatform, ? super Integer, Unit> r107 = r106.f365162k;
        if (r107 == null) goto L18;
        r107.invoke(-2, Boolean.valueOf(r110), r104, null);
    L18:
        j5 r108 = this.f359609b;
        o4 r109 = new o4(r108.f365173c, r104, r108.f365172b, r110, r111, r108.f365174d);
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r109, "musicAuthResultData");     // Catch: Throwable -> L27
        Iterator r112 = new ArrayList(MusicAuthManager.f359459d).iterator();     // Catch: Throwable -> L27
    L22:
        if (r112.hasNext() == false) goto L25;
        ((com.larus.platform.api.x) r112.next()).a(r109);     // Catch: Throwable -> L27
        goto L22
    L25:
        monitor-exit(r101);
        return;
    L27:
        th = move-exception;
        throw th;
    L8:
        r103 = null;
        goto L9
    }
}
