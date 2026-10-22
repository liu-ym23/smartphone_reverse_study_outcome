package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes23.dex */
public class Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f276740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f276741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f276742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f276743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f276744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f276745f;

    /* JADX INFO: renamed from: com.huawei.agconnect.core.Service$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Class<?> f276746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Class<?> f276747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f276748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f276749d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f276750e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f276751f;

        public Builder() {
        }

        public Service build() {
            Class<?> r100 = this.f276746a;
            if (r100 == null) goto L21;
            Class<?> r101 = this.f276747b;
            AnonymousClass1 r102 = null;
            if (r101 != null) goto L7;
            Object r103 = this.f276748c;
            if (r103 == null) goto L19;
            Service r104 = new Service(r100, r103, r102);
            Service.a(r104, this.f276749d);
            return r104;
        L19:
            throw new IllegalArgumentException("the clazz or object parameter must set one");
        L7:
            if (r101.isInterface() == true) goto L13;
            if (Modifier.isPublic(this.f276747b.getModifiers()) == false) goto L13;
            Service r105 = new Service(this.f276746a, this.f276747b, r102);
            Service.a(r105, this.f276749d);
            Service.b(r105, this.f276750e);
            Service.c(r105, this.f276751f);
            return r105;
        L13:
            throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
        L21:
            throw new IllegalArgumentException("the interface parameter cannot be NULL");
        }

        public Builder isAutoCreated(boolean r100) {
            this.f276751f = r100;
            return this;
        }

        public Builder isSharedInstance(boolean r100) {
            this.f276750e = r100;
            return this;
        }

        public Builder isSingleton(boolean r100) {
            this.f276749d = r100;
            return this;
        }

        public Builder setClass(Class<?> r100) {
            this.f276747b = r100;
            return this;
        }

        public Builder setInterface(Class<?> r100) {
            this.f276746a = r100;
            return this;
        }

        public Builder setObject(Object r100) {
            this.f276748c = r100;
            return this;
        }
    }

    private Service(Class<?> r100, Class<?> r101) {
        this.f276740a = r100;
        this.f276741b = r101;
        this.f276742c = null;
    }

    public /* synthetic */ Service(Class r100, Class r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    private Service(Class<?> r100, Object r101) {
        this.f276740a = r100;
        this.f276741b = null;
        this.f276742c = r101;
    }

    public /* synthetic */ Service(Class r100, Object r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    public static /* synthetic */ boolean a(Service r100, boolean r101) {
        r100.f276743d = r101;
        return r101;
    }

    public static /* synthetic */ boolean b(Service r100, boolean r101) {
        r100.f276744e = r101;
        return r101;
    }

    public static Builder builder(Class<?> r100) {
        return new Builder().setInterface(r100).setClass(r100).isSingleton(r100.isAnnotationPresent(Singleton.class)).isSharedInstance(r100.isAnnotationPresent(SharedInstance.class)).isAutoCreated(r100.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> r100, Class<?> r101) {
        return new Builder().setInterface(r100).setClass(r101).isSingleton(r101.isAnnotationPresent(Singleton.class)).isSharedInstance(r101.isAnnotationPresent(SharedInstance.class)).isAutoCreated(r101.isAnnotationPresent(AutoCreated.class));
    }

    public static Builder builder(Class<?> r100, Object r101) {
        return new Builder().setInterface(r100).setObject(r101).isSingleton(true).isSharedInstance(r100.isAnnotationPresent(SharedInstance.class)).isAutoCreated(r100.isAnnotationPresent(AutoCreated.class));
    }

    public static /* synthetic */ boolean c(Service r100, boolean r101) {
        r100.f276745f = r101;
        return r101;
    }

    public Object getInstance() {
        return this.f276742c;
    }

    public Class<?> getInterface() {
        return this.f276740a;
    }

    public Class<?> getType() {
        return this.f276741b;
    }

    public boolean isAutoCreated() {
        return this.f276745f;
    }

    public boolean isSharedInstance() {
        return this.f276744e;
    }

    public boolean isSingleton() {
        return this.f276743d;
    }
}
