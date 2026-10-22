package com.larus.init.task.firstframe;

import com.bytedance.kmp.launcher.KmpLaunchStage;
import com.larus.network.http.ServiceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/larus/init/task/firstframe/InitKmpBootFinishTask;", "Lcom/larus/init/task/firstframe/IFirstFrameTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitKmpBootFinishTask implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351268a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        List r100 = (List) hb6.d.f484489a.getValue();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((hb6.b) r103).a() != KmpLaunchStage.BOOT_FINISH) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        Iterator r105 = r101.iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        ((hb6.b) r105.next()).run();
        goto L13
    }

    public InitKmpBootFinishTask() {
        this.f351268a = ServiceType.BASIC_TEC;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351268a;
    }

    @Override // bg9.i, java.lang.Runnable
    public final void run() {
        bg9.i.a.a(this);
    }
}
