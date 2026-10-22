package com.bytedance.ee.bear.appsetting;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class EmergencyFixConfigHandler extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EmergencyFixConfigHandler f206231i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final BehaviorSubject<EmergencyFixConfig> f206232j = null;

    @AppSettingPlugin
    public static final class a implements npb.a {
        public a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            return SetsKt.mutableSetOf(new EmergencyFixConfigHandler[]{EmergencyFixConfigHandler.f206231i});
        }

        @Override // npb.a
        public final String getTag() {
            return "EmergencyFixConfigHandler";
        }
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return EmergencyFixConfig.SETTING_KEY;
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "EmergencyFixConfigHandler";
    }

    static {
        EmergencyFixConfigHandler r100 = new EmergencyFixConfigHandler();
        f206231i = r100;
        AbstractBaseSettingHandler.a r101 = r100.f431105d;
        r101.c(AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f431107f = r101;
        f206232j = BehaviorSubject.create();
    }

    public EmergencyFixConfigHandler() {
    }

    public static final void j(EmergencyFixConfigHandler r100, String r101) {
        r100.getClass();
        tt5.a.h("EmergencyFixConfigHandler", "handleConfig: " + r101);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L17;
        int r103 = mu5.a.f515754a;
        EmergencyFixConfig r104 = (EmergencyFixConfig) mu5.a.a(r100.g(), EmergencyFixConfig.class);
        if (r104 != null) goto L14;
        tt5.a.k("EmergencyFixConfigHandler", "parse fixConfig return null");
        return;
    L14:
        f206232j.onNext(r104);
        return;
    L17:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
