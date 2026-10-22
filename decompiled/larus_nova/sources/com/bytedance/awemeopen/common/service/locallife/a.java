package com.bytedance.awemeopen.common.service.locallife;

import android.app.Activity;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends k24.a {

    /* JADX INFO: renamed from: com.bytedance.awemeopen.common.service.locallife.a$a, reason: collision with other inner class name */
    public static final class C2848a {
        public static /* synthetic */ void a(a r100, Activity r101, String r110, Function0 r111, Function2 r112, String r113, Map r114) {
            r100.B1(r101, r110, r111, r112, r113, r114, ILocalLifeService$openLocalLifeDetail$1.INSTANCE);
        }
    }

    void B1(Activity r100, String r101, Function0<Unit> r102, Function2<? super Float, ? super Float, Unit> r103, String r104, Map<String, String> r105, Function1<? super Boolean, Unit> r106);

    boolean isAvailable();
}
