package com.ss.android.ainote;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes34.dex */
public final class AINoteImageUploadCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f406511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<String> f406512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<String> f406513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile e f406514d;

    public interface a {
        void a(boolean r100, String r101);

        void onSuccess(String r100, String r101);
    }

    public static final class b {
    }

    public interface c {
        void a(long r100, String r101);

        void b(long r100, String r101, String r102, String r103);

        void c(long r100, String r101, boolean r102, String r103);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f406515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f406516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f406517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f406518d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f406519e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f406515a, r101.f406515a) == true) goto L12;
            return false;
        L12:
            if (this.f406516b == r101.f406516b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f406517c, r101.f406517c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f406518d, r101.f406518d) == true) goto L21;
            return false;
        L21:
            if (this.f406519e == r101.f406519e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f406515a.hashCode() * 31;
            long r101 = this.f406516b;
            return ((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f406517c.hashCode()) * 31) + this.f406518d.hashCode()) * 31) + this.f406519e;
        }

        public final String toString() {
            return "UploadRequest(meetingId=" + this.f406515a + ", noteId=" + this.f406516b + ", imageId=" + this.f406517c + ", localUri=" + this.f406518d + ", retryCount=" + this.f406519e + ')';
        }

        public d(String r100, long r101, String r102, String r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "meetingId");
            Intrinsics.checkNotNullParameter(r102, "imageId");
            Intrinsics.checkNotNullParameter(r103, "localUri");
            this.f406515a = r100;
            this.f406516b = r101;
            this.f406517c = r102;
            this.f406518d = r103;
            this.f406519e = r104;
        }
    }

    public interface e {
        void a(d r100, AINoteImageUploadCoordinator$startPendingUploads$1 r101);
    }

    static {
    }

    public final void a() {
        if ((!this.f406512b.isEmpty()) == false) goto L5;
        int r100 = t.f407207a;
        t.d("AINoteImageUploadCoordinator", "cancelAll, inFlightCount=" + this.f406512b.size());
    L5:
        this.f406513c.addAll(this.f406512b);
        this.f406512b.clear();
    }

    public AINoteImageUploadCoordinator() {
        this.f406511a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f406512b = new LinkedHashSet();
        this.f406513c = new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.ss.android.ainote.AINoteImageUploadCoordinator$startPendingUploads$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(final Function0<? extends List<j.f>> r210, final j r211, final c r212) {
        Intrinsics.checkNotNullParameter(r210, "taskProvider");
        Intrinsics.checkNotNullParameter(r211, "draftStore");
        Intrinsics.checkNotNullParameter(r212, "listener");
        e r110 = this.f406514d;
        if (r110 != 0) goto L5;
        return;
    L5:
        List<j.f> r100 = r210.invoke();
        if (r100.isEmpty() == false) goto L8;
        return;
    L8:
        Iterator<j.f> r111 = r100.iterator();
    L10:
        if (r111.hasNext() == false) goto L31;
        final j.f r101 = r111.next();
        if (this.f406512b.size() >= 1) goto L13;
        this.f406513c.remove(r101.f406817d);
        if (this.f406512b.add(r101.f406817d) == false) goto L10;
        j.a r102 = r211.p(r101.f406814a);
        xra.b r103 = null;
        Object r104 = null;
        r103 = null;
        if (r102 == null) goto L28;
        List<xra.b> r105 = r102.B;
        if (r105 == null) goto L28;
        Iterator<T> r106 = r105.iterator();
    L23:
        if (r106.hasNext() == false) goto L27;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((xra.b) r107).f564919a, r101.f406817d) == false) goto L23;
        r104 = r107;
    L27:
        r103 = (xra.b) r104;
    L28:
        if (r103 == null) goto L29;
        r212.a(r101.f406814a, r101.f406817d);
        r110.a(new d(r101.f406815b, r101.f406814a, r101.f406817d, r101.f406818e, r103.f564927i), new AINoteImageUploadCoordinator$startPendingUploads$1(this, r101, r212, r210, r211));
        goto L10
    L29:
        this.f406512b.remove(r101.f406817d);
        goto L10
    L13:
        return;
    }
}
