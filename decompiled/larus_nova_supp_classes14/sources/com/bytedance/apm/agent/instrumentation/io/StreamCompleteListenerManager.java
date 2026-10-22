package com.bytedance.apm.agent.instrumentation.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
class StreamCompleteListenerManager {
    private boolean streamComplete;
    private ArrayList<StreamCompleteListener> streamCompleteListeners;

    private boolean checkComplete() {
        monitor-enter(this);
        boolean r0 = isComplete();     // Catch: Throwable -> L8
        if (r0 == true) goto L6;
        this.streamComplete = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isComplete() {
        monitor-enter(this);
        boolean r0 = this.streamComplete;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private List<StreamCompleteListener> getStreamCompleteListeners() {
        ArrayList<StreamCompleteListener> r0 = this.streamCompleteListeners;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.streamCompleteListeners);     // Catch: Throwable -> L7
        this.streamCompleteListeners.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public StreamCompleteListenerManager() {
        this.streamComplete = false;
        this.streamCompleteListeners = new ArrayList();
    }

    public void addStreamCompleteListener(StreamCompleteListener r3) {
        ArrayList<StreamCompleteListener> r0 = this.streamCompleteListeners;
        monitor-enter(r0);
        this.streamCompleteListeners.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyStreamComplete(StreamCompleteEvent r3) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r0 = getStreamCompleteListeners().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        r0.next().streamComplete(r3);
        goto L6
    L10:
        return;
    }

    public void notifyStreamError(StreamCompleteEvent r3) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r0 = getStreamCompleteListeners().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        r0.next().streamError(r3);
        goto L6
    L10:
        return;
    }

    public void removeStreamCompleteListener(StreamCompleteListener r3) {
        ArrayList<StreamCompleteListener> r0 = this.streamCompleteListeners;
        monitor-enter(r0);
        this.streamCompleteListeners.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
