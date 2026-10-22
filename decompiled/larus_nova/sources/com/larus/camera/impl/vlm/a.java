package com.larus.camera.impl.vlm;

import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import ix8.g;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VLMIntentTrackSource f322821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ix8.a f322822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f322823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f322824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f322825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile g f322826f;

    /* JADX INFO: renamed from: com.larus.camera.impl.vlm.a$a, reason: collision with other inner class name */
    public static final class C4156a {
    }

    static {
    }

    public a(VLMIntentTrackSource r100, ix8.a r101) {
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f322821a = r100;
        this.f322822b = r101;
        this.f322823c = new AtomicBoolean(false);
        this.f322824d = System.currentTimeMillis();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(String r110, int r111, String r112, int r113, String r114) {
        VLMIntentTrackSource r100 = this.f322821a;
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (this.f322823c.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        long r102 = System.currentTimeMillis();
        Long r103 = Long.valueOf(this.f322825e);
        if (r103.longValue() <= 0) goto L12;
        r101 = true;
    L12:
        if (r101 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L17;
        Long r104 = Long.valueOf(r102 - r103.longValue());
    L18:
        JSONObject r105 = new JSONObject();
        r105.put("status", r110);
        r105.put("source", r100.getValue());
        r105.put("duration", r102 - this.f322824d);
        if (r104 == null) goto L21;
        r105.put("network_duration", r104.longValue());
    L21:
        r105.put("is_edu_intent", r111);
        g r106 = this.f322826f;
        if (r106 == null) goto L24;
        r105.put("pre_process_duration", r106.f496408a);
    L24:
        r105.put("error_type", r112);
        r105.put("error_code", r113);
        r105.put("error_msg", r114);
        r105.put("need_intent", this.f322822b.f496381d ? 1 : 0);
        r105.put("need_detection", this.f322822b.f496383f ? 1 : 0);
        r105.put("need_dewarp", this.f322822b.f496382e ? 1 : 0);
        FLogger.f375446a.i("VLMIntentDetectTracker", "[track] " + r105);
        o.f365780a.reportEvent("vlm_intent_detect", r105);
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("vlm_intent_detect", r105, null, null);
        return;
    L17:
        r104 = null;
        goto L18
    }
}
