package com.bytedance.relax.ttml_profile_edit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r87.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/relax/ttml_profile_edit/SrcProfileeditRxPage;", "", "<init>", "()V", "Companion", "profile_edit_relax_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SrcProfileeditRxPage {
    public static final int $stable = 0;
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private static String f267192id;
    private static Function1<? super Long, Unit> task;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR5\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/relax/ttml_profile_edit/SrcProfileeditRxPage$Companion;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "task", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ptr", "", "getTask", "()Lkotlin/jvm/functions/Function1;", "setTask", "(Lkotlin/jvm/functions/Function1;)V", "profile_edit_relax_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final String getId() {
            return SrcProfileeditRxPage.access$getId$cp();
        }

        public final Function1<Long, Unit> getTask() {
            return SrcProfileeditRxPage.access$getTask$cp();
        }

        public final void setId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            SrcProfileeditRxPage.access$setId$cp(r100);
        }

        public final void setTask(Function1<? super Long, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            SrcProfileeditRxPage.access$setTask$cp(r100);
        }
    }

    public SrcProfileeditRxPage() {
    }

    public static /* synthetic */ Unit a(long r100) {
        return task$lambda$0(r100);
    }

    static {
        Companion = new Companion(null);
        f267192id = "com.bytedance.relax.ttml_profile_edit.SrcProfileeditRxPage";
        task = new a();
    }

    public static final /* synthetic */ String access$getId$cp() {
        return f267192id;
    }

    public static final /* synthetic */ Function1 access$getTask$cp() {
        return task;
    }

    public static final /* synthetic */ void access$setId$cp(String r100) {
        f267192id = r100;
    }

    public static final /* synthetic */ void access$setTask$cp(Function1 r100) {
        task = r100;
    }

    private static final Unit task$lambda$0(long r100) {
        SrcProfileeditRxPageKt.RenderEntry(r100);
        return Unit.INSTANCE;
    }
}
