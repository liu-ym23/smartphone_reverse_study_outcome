package com.larus.init.task.firstframe;

import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.network.http.ServiceType;
import com.larus.utils.t0;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/larus/init/task/firstframe/InitLazyStartLaunchInfoTask;", "Lcom/larus/init/task/firstframe/IFirstFrameTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "initChatModel", "setting", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "initAsrLanguage", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitLazyStartLaunchInfoTask implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351289a;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f351290a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f351290a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f351290a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f351290a.invoke(r100);
        }
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        IChatRepoService r100 = zh8.a.f572196a;
        final ISettingRepoService r101 = zh8.a.f572198c;
        if (r101.V0() >= 0) goto L6;
        t0.e(new v(r101));
    L6:
        if (r101.r0().length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        t0.e(new u(r101));
        return;
    L12:
        return;
    L8:
        r102 = false;
        goto L9
    }

    public InitLazyStartLaunchInfoTask() {
        this.f351289a = ServiceType.BASIC_SERVICE;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351289a;
    }

    @Override // bg9.i, java.lang.Runnable
    public final void run() {
        bg9.i.a.a(this);
    }
}
