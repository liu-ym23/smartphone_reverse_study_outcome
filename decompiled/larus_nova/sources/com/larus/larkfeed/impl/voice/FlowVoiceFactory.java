package com.larus.larkfeed.impl.voice;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.larkfeed.impl.voice.service.record.FlowVoiceRecord;
import com.larus.larkfeed.impl.voice.view.FlowVoiceView;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.voiceinput.impl.component.VoiceComponent;
import com.ss.android.lark.voiceinput.impl.service.i;
import com.ss.android.lark.voiceinput.impl.service.j;
import com.ss.android.lark.voiceinput.impl.view.impl.CommonButtonVoiceViewImpl;
import dbc.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import lk9.g;
import rac.e;

/* JADX INFO: loaded from: classes30.dex */
@ClaymoreImpl(singleton = false, value = com.ss.android.lark.voiceinput.api.provider.b.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002JC\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/larus/larkfeed/impl/voice/FlowVoiceFactory;", "Lcom/ss/android/lark/voiceinput/api/provider/IVoiceComponentFactory;", "<init>", "()V", "createVoiceComponent", "Lcom/ss/android/lark/voiceinput/api/provider/DefaultVoiceComponentProvider;", "presentation", "Lcom/ss/android/lark/voiceinput/api/provider/VoicePresentation;", "createEngine", "Lcom/ss/android/lark/voiceinput/impl/service/VoiceEngine;", "config", "Lcom/ss/android/lark/voiceinput/api/data/config/VoiceConfig;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/voiceinput/api/data/context/VoiceContext;", "createServiceFactory", "Lcom/ss/android/lark/voiceinput/impl/service/VoiceServiceFactory;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "createVoiceView", "Lcom/ss/android/lark/voiceinput/api/view/IVoiceView;", "createVoiceTouch", "Lcom/ss/android/lark/voiceinput/api/action/IVoiceTouch;", "voiceView", "Lcom/ss/android/lark/voiceinput/api/view/IVoiceViewEventChannel;", "createCommonButtonVoiceView", "Lcom/ss/android/lark/voiceinput/api/view/impl/CommonButtonVoiceViewDelegate;", "Landroid/content/Context;", "buttonConfig", "Lcom/ss/android/lark/voiceinput/api/view/impl/CommonButtonVoiceConfig;", "iconRes", "", "iconContentDescription", "", "iconTint", "Landroidx/compose/ui/graphics/Color;", "countdownTextTemplate", "createCommonButtonVoiceView-jzV_Hc0", "(Landroid/content/Context;Lcom/ss/android/lark/voiceinput/api/view/impl/CommonButtonVoiceConfig;ILjava/lang/String;JLjava/lang/String;)Lcom/ss/android/lark/voiceinput/api/view/impl/CommonButtonVoiceViewDelegate;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowVoiceFactory implements com.ss.android.lark.voiceinput.api.provider.b {

    public static final class a implements v {
        public a() {
        }

        @Override // com.larus.media.v
        public final boolean b(g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            return true;
        }

        @Override // com.larus.media.v
        public final void e(g r100) {
            v.a.d(r100);
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(g r100, float r101) {
            v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(g r100, g r101) {
            v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(g r100, float r101) {
            v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(g r100, g r101) {
            v.a.e(r100, r101);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(g r100, g r101, int r102) {
            return v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(g r100, g r101, int r102) {
            return v.a.b(r100, r101);
        }
    }

    public FlowVoiceFactory() {
    }

    public static /* synthetic */ cbc.c a(FlowVoiceFactory r100, xac.a r101, Fragment r102, tac.a r103) {
        return createServiceFactory$lambda$0(r100, r101, r102, r103);
    }

    private final dbc.c createVoiceView(com.ss.android.lark.voiceinput.api.provider.c r100) {
        if ((r100 instanceof com.ss.android.lark.voiceinput.api.provider.c.b) == false) goto L6;
        return new FlowVoiceView(((com.ss.android.lark.voiceinput.api.provider.c.b) r100).f445045b.requireContext());
    L6:
        if ((r100 instanceof com.ss.android.lark.voiceinput.api.provider.c.a) == false) goto L10;
        return new FlowVoiceView(((com.ss.android.lark.voiceinput.api.provider.c.a) r100).f445041b.requireContext());
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.voiceinput.api.provider.b
    public com.ss.android.lark.voiceinput.api.provider.a createVoiceComponent(com.ss.android.lark.voiceinput.api.provider.c r110) {
        Intrinsics.checkNotNullParameter(r110, "presentation");
        xac.a r100 = r110.a();
        boolean r101 = r110 instanceof com.ss.android.lark.voiceinput.api.provider.c.a;
        if (r101 == false) goto L6;
        String r102 = "Advanced";
    L8:
        r100.c("voice_type", r102);
        dbc.c r103 = r110.b();
        if (r103 != null) goto L12;
        r103 = createVoiceView(r110);
    L12:
        if ((r103 instanceof f) == false) goto L14;
        f r104 = (f) r103;
    L15:
        ibc.a r105 = new ibc.a(createServiceFactory(r110.getFragment(), r110.a()), r110.getFragment(), r110.a());
        int r106 = VoiceComponent.f445048f;
        tac.a r107 = r110.getConfig();
        Intrinsics.checkNotNullParameter(r107, "voiceConfig");
        Intrinsics.checkNotNullParameter(r105, "voiceDependency");
        LinkedHashMap r108 = new LinkedHashMap();
        if (r101 == false) goto L18;
        com.ss.android.lark.voiceinput.api.provider.c.a r109 = (com.ss.android.lark.voiceinput.api.provider.c.a) r110;
    L18:
        e r111 = createVoiceTouch(r110, r104);
        Intrinsics.checkNotNullParameter(r111, "voiceTouch");
        if (r107 == null) goto L40;
        if (r111 == null) goto L38;
        VoiceComponent r112 = new VoiceComponent(r107, r105);
        Iterator r113 = r108.entrySet().iterator();     // Catch: Throwable -> L28
    L24:
        if (r113.hasNext() == false) goto L26;
        Map.Entry r114 = (Map.Entry) r113.next();     // Catch: Throwable -> L28
        Class r115 = (Class) r114.getKey();     // Catch: Throwable -> L28
        qac.a r116 = (qac.a) r114.getValue();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type java.lang.Class<com.ss.android.lark.voiceinput.api.ability.IVoiceAbility>");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r115, "clazz");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r116, "ability");     // Catch: Throwable -> L28
        hbc.b r117 = r112.f445051c;     // Catch: Throwable -> L28
        r117.getClass();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r115, "clazz");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r116, "ability");     // Catch: Throwable -> L28
        KClass<? extends qac.a> r118 = JvmClassMappingKt.getKotlinClass(r115);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r118, "type");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r116, "ability");     // Catch: Throwable -> L28
        r117.f484516a.put(r118, r116);     // Catch: Throwable -> L28
        goto L24
    L26:
        r112.q(r105.f489145b, r111, r103);     // Catch: Throwable -> L28
        return r112;
    L28:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L31
        r112.onDestroy();     // Catch: Throwable -> L31
        Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L48;
        th.addSuppressed(r121);
        throw th;
    L48:
        throw th;
    L31:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L38:
        throw new IllegalArgumentException("voiceTouch is required".toString());
    L40:
        throw new IllegalArgumentException("voiceConfig is required".toString());
    L14:
        r104 = null;
        goto L15
    L6:
        if ((r110 instanceof com.ss.android.lark.voiceinput.api.provider.c.b) == false) goto L42;
        r102 = "Immersive";
        goto L8
    L42:
        throw new NoWhenBranchMatchedException();
    }

    private final i createEngine(tac.a r100, xac.a r101) {
        i.a r102 = new i.a();
        FlowVoiceRecord r103 = new FlowVoiceRecord(r100.f545223a, r101);
        Intrinsics.checkNotNullParameter(r103, "voiceRecord");
        r102.f445122a = r103;
        com.larus.larkfeed.impl.voice.service.asr.f r104 = new com.larus.larkfeed.impl.voice.service.asr.f(r100, r101);
        Intrinsics.checkNotNullParameter(r104, "voiceAsr");
        return new i(r102.f445122a, r104);
    }

    private final j createServiceFactory(Fragment r100, xac.a r101) {
        return new com.larus.larkfeed.impl.voice.a(this, r101, r100);
    }

    private final e createVoiceTouch(com.ss.android.lark.voiceinput.api.provider.c r100, f r101) {
        if ((r100 instanceof com.ss.android.lark.voiceinput.api.provider.c.b) == true) goto L10;
        if ((r100 instanceof com.ss.android.lark.voiceinput.api.provider.c.a) == true) goto L10;
        throw new NoWhenBranchMatchedException();
    L10:
        return new FlowVoiceTouch(r101, r100.a(), r100.getConfig().f545224b);
    }

    private static final cbc.c createServiceFactory$lambda$0(FlowVoiceFactory r100, xac.a r101, Fragment r102, tac.a r103) {
        Intrinsics.checkNotNullParameter(r103, "config");
        return new ai9.a(r100.createEngine(r103, r101), r103, r101, new ai9.b(r102, new a()));
    }

    @Override // com.ss.android.lark.voiceinput.api.provider.b
    /* JADX INFO: renamed from: createCommonButtonVoiceView-jzV_Hc0, reason: not valid java name */
    public ebc.c mo8560createCommonButtonVoiceViewjzV_Hc0(Context r110, ebc.a r111, int r112, String r113, long r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "countdownTextTemplate");
        return new CommonButtonVoiceViewImpl(r110, r111, r112, r113, r114, r115);
    }
}
