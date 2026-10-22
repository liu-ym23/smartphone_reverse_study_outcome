package com.oplus.ocs.base.common.api;

import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.constant.CommonStatusCodes;
import com.oplus.ocs.base.task.TaskImpl;

/* JADX INFO: loaded from: classes34.dex */
public class TaskListenerHolder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f404179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f404180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TaskImpl<T> f404181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f404182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SuccessNotifier<T> f404183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FailureNotifier<T> f404184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TaskListenerHolder<T>.TaskListenerHandler f404185g;

    public interface FailureNotifier<T> {
        void onNotifyListenerFailed(TaskImpl<T> r100, int r101, String r102);
    }

    public interface SuccessNotifier<T> {
        void notifyListener(TaskImpl<T> r100);
    }

    public class TaskListenerHandler extends com.oplus.ocs.base.common.a {
        final /* synthetic */ TaskListenerHolder this$0;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            super.handleMessage(r100);
            boolean r101 = true;
            if (r100.what == 1) goto L6;
            r101 = false;
        L6:
            if (r101 == false) goto L10;
            TaskListenerHolder.a(this.this$0, r100.arg1);
            return;
        L10:
            throw new IllegalArgumentException();
        }

        public TaskListenerHandler(TaskListenerHolder r100, Looper r101) {
            this.this$0 = r100;
            super(r101);
        }
    }

    public FailureNotifier<T> getFailureNotifier() {
        return this.f404184f;
    }

    public Looper getLooper() {
        return this.f404180b;
    }

    public SuccessNotifier getOnTaskSuccessListener() {
        return this.f404183e;
    }

    public TaskImpl<T> getTask() {
        return this.f404181c;
    }

    public void setErrorCode(int r100) {
        this.f404182d = r100;
        Message r101 = Message.obtain();
        r101.what = 1;
        r101.arg1 = this.f404182d;
        this.f404185g.sendMessage(r101);
    }

    public static /* synthetic */ void a(TaskListenerHolder r100, int r101) {
        if (r101 != 0) goto L7;
        SuccessNotifier<T> r102 = r100.f404183e;
        if (r102 == null) goto L11;
        r102.notifyListener(r100.f404181c);
        return;
    L11:
        return;
    L7:
        FailureNotifier<T> r103 = r100.f404184f;
        if (r103 == null) goto L12;
        r103.onNotifyListenerFailed(r100.f404181c, r101, CommonStatusCodes.getStatusCodeString(r101));
        return;
    }

    public TaskListenerHolder(Looper r100, TaskImpl<T> r101, SuccessNotifier<T> r102, FailureNotifier<T> r103) {
        this.f404179a = "TaskListenerHolder";
        this.f404180b = r100;
        this.f404181c = r101;
        this.f404183e = r102;
        this.f404184f = r103;
        this.f404185g = new TaskListenerHandler(this, this.f404180b);
    }
}
