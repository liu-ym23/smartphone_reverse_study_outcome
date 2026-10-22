package com.obric.sva.framework.wrapper;

import android.app.TaskStackListener;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class TaskStackListenerWrapper {
    public TaskStackListener listener;

    public void onTaskStackChangedExt() {
    }

    public TaskStackListenerWrapper() {
        this.listener = new AnonymousClass1(this);
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return TaskStackListener.class;
    }
}
