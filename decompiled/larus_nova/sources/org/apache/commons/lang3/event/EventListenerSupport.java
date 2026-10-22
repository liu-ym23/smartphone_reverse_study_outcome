package org.apache.commons.lang3.event;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
public class EventListenerSupport<L> implements Serializable {
    private static final long serialVersionUID = 3593265990380473632L;
    private List<L> listeners;
    private transient L[] prototypeArray;
    private transient L proxy;

    public class ProxyInvocationHandler implements InvocationHandler {
        final /* synthetic */ EventListenerSupport this$0;

        public ProxyInvocationHandler(EventListenerSupport r100) {
            this.this$0 = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            Iterator r103 = EventListenerSupport.access$000(this.this$0).iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r101.invoke(r103.next(), r102);
            goto L4
        L6:
            return null;
        }
    }

    public InvocationHandler createInvocationHandler() {
        return new ProxyInvocationHandler(this);
    }

    public int getListenerCount() {
        return this.listeners.size();
    }

    public L[] getListeners() {
        return (L[]) this.listeners.toArray(this.prototypeArray);
    }

    private EventListenerSupport() {
        this.listeners = new CopyOnWriteArrayList();
    }

    public L fire() {
        return this.proxy;
    }

    public EventListenerSupport(Class<L> r100) {
        this(r100, ThreadMethodProxy.currentThread().getContextClassLoader());
    }

    public static /* synthetic */ List access$000(EventListenerSupport r100) {
        return r100.listeners;
    }

    public static <T> EventListenerSupport<T> create(Class<T> r100) {
        return new EventListenerSupport(r100);
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        Object[] r101 = (Object[]) r100.readObject();
        this.listeners = new CopyOnWriteArrayList(r101);
        initializeTransientFields(r101.getClass().getComponentType(), ThreadMethodProxy.currentThread().getContextClassLoader());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        ArrayList r101 = new ArrayList();
        ObjectOutputStream r102 = new ObjectOutputStream(new ByteArrayOutputStream());
        Iterator<L> r103 = this.listeners.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        L r104 = r103.next();
        r102.writeObject(r104);     // Catch: IOException -> L8
        r101.add(r104);     // Catch: IOException -> L8
    L8:
        r102 = new ObjectOutputStream(new ByteArrayOutputStream());
        goto L4
    L9:
        r100.writeObject(r101.toArray(this.prototypeArray));
    }

    public void addListener(L r100) {
        addListener(r100, true);
    }

    public void removeListener(L r100) {
        Validate.notNull(r100, "Listener object cannot be null.", new Object[0]);
        this.listeners.remove(r100);
    }

    public EventListenerSupport(Class<L> r100, ClassLoader r101) {
        this();
        Validate.notNull(r100, "Listener interface cannot be null.", new Object[0]);
        Validate.notNull(r101, "ClassLoader cannot be null.", new Object[0]);
        Validate.isTrue(r100.isInterface(), "Class {0} is not an interface", new Object[]{r100.getName()});
        initializeTransientFields(r100, r101);
    }

    private void createProxy(Class<L> r100, ClassLoader r101) {
        this.proxy = r100.cast(Proxy.newProxyInstance(r101, new Class[]{r100}, createInvocationHandler()));
    }

    private void initializeTransientFields(Class<L> r100, ClassLoader r101) {
        this.prototypeArray = (L[]) ((Object[]) Array.newInstance(r100, 0));
        createProxy(r100, r101);
    }

    public void addListener(L r100, boolean r101) {
        Validate.notNull(r100, "Listener object cannot be null.", new Object[0]);
        if (r101 == false) goto L6;
        this.listeners.add(r100);
        return;
    L6:
        if (this.listeners.contains(r100) == true) goto L10;
        this.listeners.add(r100);
        return;
    }
}
