package org.apache.commons.net.util;

import java.io.Serializable;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes42.dex */
public class ListenerList implements Serializable, Iterable<EventListener> {
    private static final long serialVersionUID = -1934227607974228213L;
    private final CopyOnWriteArrayList<EventListener> __listeners;

    public int getListenerCount() {
        return this.__listeners.size();
    }

    @Override // java.lang.Iterable
    public Iterator<EventListener> iterator() {
        return this.__listeners.iterator();
    }

    public ListenerList() {
        this.__listeners = new CopyOnWriteArrayList();
    }

    public void addListener(EventListener r100) {
        this.__listeners.add(r100);
    }

    public void removeListener(EventListener r100) {
        this.__listeners.remove(r100);
    }
}
