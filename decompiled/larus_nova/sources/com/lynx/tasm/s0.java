package com.lynx.tasm;

import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f383716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f383717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f383718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TemplateBundle f383719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TemplateData f383720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TemplateData f383721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LynxLoadMode f383722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f383723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f383724i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f383725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f383726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TemplateBundle f383727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TemplateData f383728d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TemplateData f383729e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public LynxLoadMode f383730f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f383731g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ByteBuffer f383732h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f383733i;

        public final s0 b() {
            return new s0(this.f383725a, this.f383726b, this.f383732h, this.f383727c, this.f383728d, this.f383729e, this.f383730f, this.f383731g, this.f383733i);
        }

        public a() {
            this.f383731g = 0;
        }

        public final void a(LynxLoadOption r100) {
            int r101 = this.f383731g;
            this.f383731g = r100.id() | r101;
        }
    }

    public s0(String r100, byte[] r101, ByteBuffer r102, TemplateBundle r103, TemplateData r104, TemplateData r105, LynxLoadMode r106, int r107, Map r108) {
        this.f383716a = r100;
        this.f383717b = r101;
        this.f383718c = r102;
        this.f383719d = r103;
        this.f383720e = r104;
        this.f383721f = r105;
        this.f383722g = r106;
        this.f383723h = r107;
        this.f383724i = r108;
    }
}
