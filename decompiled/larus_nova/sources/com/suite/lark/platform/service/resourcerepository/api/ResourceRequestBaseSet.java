package com.suite.lark.platform.service.resourcerepository.api;

import java.util.HashMap;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public class ResourceRequestBaseSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f461381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f461382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f461383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f461384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteString f461385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f461386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f461387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f461388h;

    public static final enum Type extends Enum<Type> {
        public static final Type AVATAR = null;
        public static final Type BASE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f461389a = null;
        private int value;

        static {
            Type r100 = new Type("BASE", 0, 0);
            BASE = r100;
            Type r101 = new Type("AVATAR", 1, 1);
            AVATAR = r101;
            f461389a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f461389a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return BASE;
        L8:
            return AVATAR;
        L10:
            return BASE;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return forNumber(r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f461390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f461391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f461392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f461393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f461394e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, String> f461395f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f461396g;

        public a() {
            this.f461390a = 0;
            this.f461391b = 1;
            this.f461392c = "";
            this.f461393d = 0;
            this.f461394e = "";
            this.f461395f = new HashMap();
            this.f461396g = new HashMap();
        }
    }

    public ResourceRequestBaseSet() {
        throw null;
    }

    public Type getType() {
        return this.f461381a;
    }

    public ResourceRequestBaseSet(String r100, String r101, String r102, String r103) {
        this.f461382b = r100;
        this.f461383c = r101;
        this.f461386f = r102;
        this.f461387g = r103;
        this.f461381a = Type.BASE;
    }
}
