package com.ss.android.lark.resource.service.impl;

import com.ss.android.download.api.config.HttpMethod;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes37.dex */
public final class ResourcePush {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<qpc.c> f439535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<qpc.d> f439536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<qpc.b> f439537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f439538d;

    public static final enum Link extends Enum<Link> {
        public static final Link DOWNLOAD = null;
        public static final Link UNKNOWN = null;
        public static final Link UPLOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Link[] f439539a = null;
        private int value;

        static {
            Link r100 = new Link("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            Link r101 = new Link("UPLOAD", 1, 1);
            UPLOAD = r101;
            Link r102 = new Link(HttpMethod.DOWNLOAD, 2, 2);
            DOWNLOAD = r102;
            f439539a = new Link[]{r100, r101, r102};
        }

        public static Link[] values() {
            return (Link[]) f439539a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Link forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN;
        L9:
            return DOWNLOAD;
        L11:
            return UPLOAD;
        }

        public static Link valueOf(String r100) {
            return (Link) r27.a.a(Link.class, r100);
        }

        public static Link valueOf(int r100) {
            return forNumber(r100);
        }

        public Link(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ResourcePush f439540a = null;

        static {
            f439540a = new ResourcePush();
        }
    }

    public ResourcePush() {
        this.f439535a = new CopyOnWriteArrayList();
        this.f439536b = new CopyOnWriteArrayList();
        this.f439537c = new CopyOnWriteArrayList();
        this.f439538d = new CopyOnWriteArrayList();
    }
}
