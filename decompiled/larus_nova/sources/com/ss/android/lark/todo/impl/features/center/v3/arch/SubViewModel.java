package com.ss.android.lark.todo.impl.features.center.v3.arch;

import android.content.Intent;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.todo.impl.features.center.v3.arch.b;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00030\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0019\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0002\u0010\u001e*\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\"\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "SubState", "Lcom/larksuite/arch/jack/State;", "SubViewAction", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubViewAction;", "Lcom/larksuite/arch/jack/JackViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/IActionHandler;", "<init>", "()V", "subModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubModel;", "getSubModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubModel;", "computeThread", "Ljava/util/concurrent/ExecutorService;", "getComputeThread", "()Ljava/util/concurrent/ExecutorService;", "setComputeThread", "(Ljava/util/concurrent/ExecutorService;)V", "refreshViewState", "", "modifyModelData", "block", "Lkotlin/Function0;", "initViewModel", "viewEventStore", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubViewEventStore;", "getViewEventStore", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubViewEventStore;", "getSubViewEventStore", "SubViewEventStore", "registerActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPause", "onClear", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SubViewModel<SubState extends j, SubViewAction extends b> extends JackViewModel<SubState> {
    private ExecutorService computeThread;
    private final com.ss.android.lark.todo.impl.features.center.v3.arch.a subModel;
    private final c viewEventStore;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f441420a;

        public a(Function0<Unit> r100) {
            this.f441420a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f441420a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract /* synthetic */ void handleAction(b r100, Object r101);

    public void onClear() {
    }

    public void onPause() {
    }

    public void registerActivityResult(int r100, int r101, Intent r102) {
    }

    public void initViewModel() {
        initialize(new AnonymousClass1(this));
    }

    public final void refreshViewState() {
        ExecutorService r100 = this.computeThread;
        if (r100 == null) goto L5;
        r100.execute(new RunnableC121741(this));
        return;
    L5:
        setState(new C121752(this));
    }

    public <SubViewEventStore extends c> SubViewEventStore getSubViewEventStore() {
        SubViewEventStore r100 = (SubViewEventStore) getViewEventStore();
        if ((r100 instanceof c) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    public SubViewModel() {
    }

    public final ExecutorService getComputeThread() {
        return this.computeThread;
    }

    public com.ss.android.lark.todo.impl.features.center.v3.arch.a getSubModel() {
        return this.subModel;
    }

    public c getViewEventStore() {
        return this.viewEventStore;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larksuite.arch.jack.j] */
    public static final /* synthetic */ j access$defaultState(SubViewModel r100) {
        return r100.defaultState();
    }

    public final void modifyModelData(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        ExecutorService r101 = this.computeThread;
        if (r101 == null) goto L5;
        r101.execute(new a(r100));
        return;
    L5:
        withState(new AnonymousClass2(r100));
    }

    public final void setComputeThread(ExecutorService r100) {
        this.computeThread = r100;
    }

    public static final /* synthetic */ void access$setState(SubViewModel r100, Function1 r101) {
        r100.setState(r101);
    }
}
