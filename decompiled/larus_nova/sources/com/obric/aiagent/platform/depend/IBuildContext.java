package com.obric.aiagent.platform.depend;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import s9a.b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/platform/depend/IBuildContext;", "", "getBuildId", "", "getBuildTime", "", "getBranchId", "getCommitId", "getBuildVariant", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBuildContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f384980a = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/platform/depend/IBuildContext$Companion;", "Lcom/obric/aiagent/platform/depend/IBuildContext;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/IBuildContext;", "impl$delegate", "Lkotlin/Lazy;", "getBuildId", "", "getBuildTime", "", "getBranchId", "getCommitId", "getBuildVariant", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBuildContext {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f384981b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IBuildContext> f384982c = null;

        private Companion() {
        }

        static {
            f384981b = new Companion();
            f384982c = LazyKt.lazy(new b());
        }

        @Override // com.obric.aiagent.platform.depend.IBuildContext
        public final String a() {
            IBuildContext r100 = f384982c.getValue();
            if (r100 == null) goto L5;
            String r101 = r100.a();
        L6:
            if (r101 != null) goto L9;
            return "";
        L9:
            return r101;
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
        f384980a = Companion.f384981b;
    }

    String a();
}
