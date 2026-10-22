package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.android.ttcjpaysdk.kmp.common.container.biz.IKmpDyVerifyBizExtensionService;
import com.android.ttcjpaysdk.kmp.common.container.biz.KmpDyVerifyBizExtensionServiceImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.canvas.core.impl.CanvasSSEService;
import com.larus.kmp.voice_setting.voice.component.y7;
import com.larus.kmp.voice_setting.voice.service.UgcVoiceImpl;
import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.xmlpull.v1.XmlPullParser;
import xp8.e;
import yp8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitKmpSpiTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitKmpSpiTask extends d implements bg9.i {
    public final String a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        v0 r0 = v0.a;
        pd6.b r1 = pd6.c.a;
        Intrinsics.checkNotNullParameter(r0, "host");
        pd6.c.a = r0;
        pd6.c.c(Reflection.getOrCreateKotlinClass(IComponentRegistry.class), new e());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.a());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.b());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.c());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.d());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.e());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.f());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.g());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.h());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.i());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.j());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.k());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new l());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.f.class), new yp8.m());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.a());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.b());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.c());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.d());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.e());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.f());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.g());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.h());
        pd6.c.c(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.core.impl.base.g.class), new zp8.i());
        pd6.c.c(Reflection.getOrCreateKotlinClass(by8.a.class), new CanvasSSEService());
        pd6.c.c(Reflection.getOrCreateKotlinClass(IComponentRegistry.class), new com.bytedance.flow.search.kmp.impl.component.d());
        pd6.c.c(Reflection.getOrCreateKotlinClass(zv5.c.class), new dw5.a());
        pd6.c.c(Reflection.getOrCreateKotlinClass(il9.a.class), new com.larus.multitask_management.impl.k());
        pd6.c.c(Reflection.getOrCreateKotlinClass(il9.b.class), new com.larus.multitask_management.impl.l());
        pd6.c.c(Reflection.getOrCreateKotlinClass(ww5.a.class), new ex5.c());
        pd6.c.c(Reflection.getOrCreateKotlinClass(p2a.b.class), new zg9.b());
        pd6.c.c(Reflection.getOrCreateKotlinClass(p2a.c.class), new zg9.c());
        pd6.c.c(Reflection.getOrCreateKotlinClass(IComponentRegistry.class), new y7());
        pd6.c.c(Reflection.getOrCreateKotlinClass(p2a.f.class), new UgcVoiceImpl());
        pd6.c.c(Reflection.getOrCreateKotlinClass(sa8.b.class), new sa8.a());
        pd6.c.c(Reflection.getOrCreateKotlinClass(ra8.c.class), new ta8.a());
        pd6.c.c(Reflection.getOrCreateKotlinClass(IBlockProvider.class), new ua8.d());
        pd6.c.c(Reflection.getOrCreateKotlinClass(IBlockPipelineTask.class), new qb8.b());
        pd6.c.c(Reflection.getOrCreateKotlinClass(IBlockPipelineTask.class), new qb8.f());
        pd6.c.c(Reflection.getOrCreateKotlinClass(IComponentRegistry.class), new v0a.h());
        pd6.c.c(Reflection.getOrCreateKotlinClass(y88.f.class), new z88.e());
        pd6.c.c(Reflection.getOrCreateKotlinClass(y88.d.class), new com.larus.avlink.plugins.l());
        pd6.c.c(Reflection.getOrCreateKotlinClass(IKmpDyVerifyBizExtensionService.class), new KmpDyVerifyBizExtensionServiceImpl());
        r0.c(Reflection.getOrCreateKotlinClass(gb6.b.class), new hg9.b());
    }

    public InitKmpSpiTask() {
        this.a = "Infra";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
