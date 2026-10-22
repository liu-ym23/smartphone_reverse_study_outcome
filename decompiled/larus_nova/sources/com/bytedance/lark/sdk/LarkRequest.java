package com.bytedance.lark.sdk;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class LarkRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f254053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f254054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f254055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Priority f254056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.bytedance.lark.sdk.a> f254057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f254058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f254059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f254060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f254061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f254062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f254063l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lark/sdk/LarkRequest$Alias;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "API", "FILE", DocTabPayload.VALUE_OPAI, "DRIVE", "DOCS", "MINA", "OPEN", "DOCS_API", "PASSPORT", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Alias extends Enum<Alias> {
        public static final Alias API = null;
        public static final Alias DOCS = null;
        public static final Alias DOCS_API = null;
        public static final Alias DRIVE = null;
        public static final Alias FILE = null;
        public static final Alias MINA = null;
        public static final Alias OAPI = null;
        public static final Alias OPEN = null;
        public static final Alias PASSPORT = null;
        public static final Alias UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Alias[] f254064a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254065b = null;

        public static EnumEntries<Alias> getEntries() {
            return f254065b;
        }

        static {
            Alias r100 = new Alias("UNKNOWN", 0);
            UNKNOWN = r100;
            Alias r101 = new Alias("API", 1);
            API = r101;
            Alias r102 = new Alias("FILE", 2);
            FILE = r102;
            Alias r103 = new Alias(DocTabPayload.VALUE_OPAI, 3);
            OAPI = r103;
            Alias r104 = new Alias("DRIVE", 4);
            DRIVE = r104;
            Alias r105 = new Alias("DOCS", 5);
            DOCS = r105;
            Alias r110 = new Alias("MINA", 6);
            MINA = r110;
            Alias r111 = new Alias("OPEN", 7);
            OPEN = r111;
            Alias r112 = new Alias("DOCS_API", 8);
            DOCS_API = r112;
            Alias r113 = new Alias("PASSPORT", 9);
            PASSPORT = r113;
            Alias[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f254064a = r114;
            f254065b = EnumEntriesKt.enumEntries(r114);
        }

        public static Alias[] values() {
            return (Alias[]) f254064a.clone();
        }

        public static Alias valueOf(String r100) {
            return (Alias) r27.a.a(Alias.class, r100);
        }

        public Alias(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/sdk/LarkRequest$Method;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Method extends Enum<Method> {
        public static final Method DELETE = null;
        public static final Method GET = null;
        public static final Method HEAD = null;
        public static final Method PATCH = null;
        public static final Method POST = null;
        public static final Method PUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Method[] f254066a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254067b = null;

        public static EnumEntries<Method> getEntries() {
            return f254067b;
        }

        static {
            Method r100 = new Method("GET", 0);
            GET = r100;
            Method r101 = new Method("POST", 1);
            POST = r101;
            Method r102 = new Method("PUT", 2);
            PUT = r102;
            Method r103 = new Method("DELETE", 3);
            DELETE = r103;
            Method r104 = new Method("PATCH", 4);
            PATCH = r104;
            Method r105 = new Method("HEAD", 5);
            HEAD = r105;
            Method[] r110 = {r100, r101, r102, r103, r104, r105};
            f254066a = r110;
            f254067b = EnumEntriesKt.enumEntries(r110);
        }

        public static Method[] values() {
            return (Method[]) f254066a.clone();
        }

        public static Method valueOf(String r100) {
            return (Method) r27.a.a(Method.class, r100);
        }

        public Method(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/sdk/LarkRequest$Priority;", "", "<init>", "(Ljava/lang/String;I)V", "HIGH", "MEDIUM", "LOW", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Priority extends Enum<Priority> {
        public static final Priority HIGH = null;
        public static final Priority LOW = null;
        public static final Priority MEDIUM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Priority[] f254068a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254069b = null;

        public static EnumEntries<Priority> getEntries() {
            return f254069b;
        }

        static {
            Priority r100 = new Priority("HIGH", 0);
            HIGH = r100;
            Priority r101 = new Priority("MEDIUM", 1);
            MEDIUM = r101;
            Priority r102 = new Priority("LOW", 2);
            LOW = r102;
            Priority[] r103 = {r100, r101, r102};
            f254068a = r103;
            f254069b = EnumEntriesKt.enumEntries(r103);
        }

        public static Priority[] values() {
            return (Priority[]) f254068a.clone();
        }

        public static Priority valueOf(String r100) {
            return (Priority) r27.a.a(Priority.class, r100);
        }

        public Priority(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f254070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f254071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f254072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f254073d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Priority f254074e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<com.bytedance.lark.sdk.a> f254075f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f254076g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f254077h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f254078i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Long f254079j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f254080k;

        public final void a(Alias r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
        }

        public final a delete() {
            return delete(new c(new byte[0]));
        }

        public a() {
            this.f254070a = "";
            this.f254071b = Method.GET;
            this.f254074e = Priority.MEDIUM;
            Alias r100 = Alias.UNKNOWN;
            this.f254075f = new ArrayList();
            this.f254080k = true;
        }

        public final a delete(c r100) {
            Intrinsics.checkNotNullParameter(r100, "larkRequestBody");
            this.f254071b = Method.DELETE;
            this.f254076g = r100;
            return this;
        }
    }

    public static final class b {
    }

    static {
    }

    public LarkRequest(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f254052a = "";
        this.f254053b = Method.GET;
        this.f254056e = Priority.MEDIUM;
        Alias r101 = Alias.UNKNOWN;
        this.f254057f = new ArrayList();
        AtomicLong r102 = ue6.a.f549807a;
        this.f254058g = ue6.a.C7870a.a();
        this.f254063l = true;
        this.f254052a = r100.f254070a;
        this.f254053b = r100.f254071b;
        this.f254054c = r100.f254072c;
        this.f254055d = r100.f254073d;
        this.f254056e = r100.f254074e;
        this.f254057f = r100.f254075f;
        this.f254059h = r100.f254076g;
        this.f254060i = r100.f254077h;
        this.f254061j = r100.f254078i;
        this.f254062k = r100.f254079j;
        this.f254063l = r100.f254080k;
    }
}
