package com.relax.relaxreact.prewarm.page;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/relax/relaxreact/prewarm/page/SrcPrewarmPageRxPage;", "", "()V", "Companion", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class SrcPrewarmPageRxPage {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private static String f405559id;
    private static Function1<? super Long, Unit> task;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxreact/prewarm/page/SrcPrewarmPageRxPage$Companion;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "task", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ptr", "", "getTask", "()Lkotlin/jvm/functions/Function1;", "setTask", "(Lkotlin/jvm/functions/Function1;)V", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getId() {
            return SrcPrewarmPageRxPage.access$getId$cp();
        }

        public final Function1<Long, Unit> getTask() {
            return SrcPrewarmPageRxPage.access$getTask$cp();
        }

        public final void setId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            SrcPrewarmPageRxPage.access$setId$cp(r100);
        }

        public final void setTask(Function1<? super Long, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            SrcPrewarmPageRxPage.access$setTask$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
        f405559id = "com.relax.relaxreact.prewarm.page.SrcPrewarmPageRxPage";
        task = SrcPrewarmPageRxPage$Companion$task$1.INSTANCE;
    }

    public SrcPrewarmPageRxPage() {
    }

    public static final /* synthetic */ String access$getId$cp() {
        return f405559id;
    }

    public static final /* synthetic */ Function1 access$getTask$cp() {
        return task;
    }

    public static final /* synthetic */ void access$setId$cp(String r100) {
        f405559id = r100;
    }

    public static final /* synthetic */ void access$setTask$cp(Function1 r100) {
        task = r100;
    }
}
