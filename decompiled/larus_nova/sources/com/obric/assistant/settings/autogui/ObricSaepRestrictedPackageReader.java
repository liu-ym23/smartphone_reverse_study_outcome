package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.os.Build;
import com.bytedance.agentrobots.policy.RobotPolicyManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricSaepRestrictedPackageReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricSaepRestrictedPackageReader f391872a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricSaepRestrictedPackageReader$Source;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED_OR_UNSUPPORTED", "QUERY_SAEP_PACKAGES", "UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source DISABLED_OR_UNSUPPORTED = null;
        public static final Source QUERY_SAEP_PACKAGES = null;
        public static final Source UNAVAILABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f391873a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f391874b = null;

        public static EnumEntries<Source> getEntries() {
            return f391874b;
        }

        static {
            Source r100 = new Source("DISABLED_OR_UNSUPPORTED", 0);
            DISABLED_OR_UNSUPPORTED = r100;
            Source r101 = new Source("QUERY_SAEP_PACKAGES", 1);
            QUERY_SAEP_PACKAGES = r101;
            Source r102 = new Source("UNAVAILABLE", 2);
            UNAVAILABLE = r102;
            Source[] r103 = {r100, r101, r102};
            f391873a = r103;
            f391874b = EnumEntriesKt.enumEntries(r103);
        }

        public static Source[] values() {
            return (Source[]) f391873a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<String> f391875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f391876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f391877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Source f391878d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f391875a, r101.f391875a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f391876b, r101.f391876b) == true) goto L15;
            return false;
        L15:
            if (this.f391877c == r101.f391877c) goto L18;
            return false;
        L18:
            if (this.f391878d == r101.f391878d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Set<String> r100 = this.f391875a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Set<String> r104 = this.f391876b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            if (this.f391877c == false) goto L13;
            int r106 = 1231;
        L15:
            return ((r105 + r106) * 31) + this.f391878d.hashCode();
        L13:
            r106 = 1237;
            goto L15
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(restrictedPackages=" + this.f391875a + ", declaredPackages=" + this.f391876b + ", isComplete=" + this.f391877c + ", source=" + this.f391878d + ')';
        }

        public a(Set<String> r100, Set<String> r101, boolean r102, Source r103) {
            Intrinsics.checkNotNullParameter(r103, "source");
            this.f391875a = r100;
            this.f391876b = r101;
            this.f391877c = r102;
            this.f391878d = r103;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricSaepRestrictedPackageReader$query$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/autogui/ObricSaepRestrictedPackageReader$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricSaepRestrictedPackageReader$query$2", f = "ObricSaepRestrictedPackageReader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
        final /* synthetic */ Context $context;
        int label;

        public AnonymousClass2(Context r100, Continuation<? super AnonymousClass2> r101) {
            this.$context = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$context, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super a> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super a> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L43;
            ResultKt.throwOnFailure(r100);
            if (Build.VERSION.SDK_INT < 31) goto L7;
            Context r101 = this.$context.getApplicationContext();
        L40:
            e = move-exception;
            throw e;
        L35:
            e = move-exception;
            FLogger.f375446a.e("ObricSaepRestrictedPackageReader", "query failed", e);
            return new a(null, null, false, Source.UNAVAILABLE);
        L37:
            e = move-exception;
            FLogger.f375446a.e("ObricSaepRestrictedPackageReader", "query unavailable because SDK linkage failed", e);
            return new a(null, null, false, Source.UNAVAILABLE);
        L10:
            if (e2.a.a(r101) == true) goto L13;
            FLogger.f375446a.w("ObricSaepRestrictedPackageReader", "query unavailable because RobotsProtocol is not supported");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            return new a(SetsKt.emptySet(), SetsKt.emptySet(), true, Source.DISABLED_OR_UNSUPPORTED);
        L13:
            RobotPolicyManager r102 = RobotPolicyManager.c(r101);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r102 == null) goto L16;
            Map<String, List<String>> r103 = r102.d();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L17:
            if (r103 != null) goto L20;
            FLogger.f375446a.w("ObricSaepRestrictedPackageReader", "querySaepPackages returned unavailable result");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            return new a(null, null, false, Source.UNAVAILABLE);
        L20:
            ObricSaepRestrictedPackageReader r104 = ObricSaepRestrictedPackageReader.f391872a;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            Set r105 = ObricSaepRestrictedPackageReader.a(r103.get("restricted_packages"));     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r105 != null) goto L23;
            r105 = SetsKt.emptySet();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L23:
            Set r106 = ObricSaepRestrictedPackageReader.a(r103.get("saep_declared_packages"));     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r106 != null) goto L26;
            r106 = SetsKt.emptySet();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L26:
            a r107 = new a(r105, r106, true, Source.QUERY_SAEP_PACKAGES);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            FLogger r108 = FLogger.f375446a;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            StringBuilder r109 = new StringBuilder("querySaepPackages success, restricted=");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            Set<String> r110 = r107.f391875a;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            int r111 = -1;
            if (r110 == null) goto L29;
            int r112 = r110.size();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L30:
            r109.append(r112);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            r109.append(", declared=");     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            Set<String> r113 = r107.f391876b;     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            if (r113 == null) goto L33;
            r111 = r113.size();     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
        L33:
            r109.append(r111);     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            r108.i("ObricSaepRestrictedPackageReader", r109.toString());     // Catch: Exception -> L35 LinkageError -> L37 CancellationException -> L40
            return r107;
        L29:
            r112 = -1;
            goto L30
        L16:
            r103 = null;
            goto L17
        L7:
            return new a(SetsKt.emptySet(), SetsKt.emptySet(), true, Source.DISABLED_OR_UNSUPPORTED);
        L43:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f391872a = new ObricSaepRestrictedPackageReader();
    }

    public ObricSaepRestrictedPackageReader() {
    }

    public static final Set a(Object r100) {
        if ((r100 instanceof Iterable) == false) goto L5;
        Iterable r101 = (Iterable) r100;
    L6:
        if (r101 == null) goto L33;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L27;
        Object r104 = r103.next();
        if ((r104 instanceof String) == false) goto L13;
        String r105 = (String) r104;
    L14:
        if (r105 == null) goto L23;
        String r106 = StringsKt.trim(r105).toString();
        if (r106 == null) goto L23;
        if (r106.length() <= 0) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
    L24:
        if (r106 == null) goto L9;
        r102.add(r106);
        goto L9
    L20:
        r107 = false;
    L23:
        r106 = null;
        goto L24
    L13:
        r105 = null;
        goto L14
    L27:
        return CollectionsKt.toSet(r102);
    L33:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    public final Object query(Context r100, Continuation<? super a> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r100, null), r101);
    }
}
