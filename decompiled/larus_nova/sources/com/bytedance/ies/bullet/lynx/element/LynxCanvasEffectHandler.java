package com.bytedance.ies.bullet.lynx.element;

import com.bytedance.ies.bullet.core.h;
import com.heytap.mcssdk.constant.b;
import com.lynx.canvas.KryptonEffectConfigService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasEffectHandler;", "Lcom/lynx/canvas/KryptonEffectConfigService;", "", "effectHost", b.f276371u, "accessKey", "effectResourcePath", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class LynxCanvasEffectHandler extends KryptonEffectConfigService {
    public static final a Companion = null;
    private static volatile LynxCanvasEffectHandler instance;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String accessKey() {
        return "68d32050064f11e891efe7cc07299bc5";
    }

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String effectHost() {
        return "https://effect.snssdk.com/";
    }

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String effectResourcePath() {
        return "https://lf3-developer.bytemastatic.com/obj/developer/misc/EffectFaceResource.zip";
    }

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String appID() {
        h r100 = h.f246501h;
        String r101 = h.f246501h.f246505d;
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public LynxCanvasEffectHandler() {
    }

    public static final /* synthetic */ LynxCanvasEffectHandler access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ void access$setInstance$cp(LynxCanvasEffectHandler r100) {
        instance = r100;
    }
}
