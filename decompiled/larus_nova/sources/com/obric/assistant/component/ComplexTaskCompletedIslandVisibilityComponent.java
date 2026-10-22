package com.obric.assistant.component;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.island.ComplexTaskQueueingAndCompletionIslandMonitor;
import com.obric.livecard.api.entity.IslandSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/component/ComplexTaskCompletedIslandVisibilityComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "messageVisibilityAbility", "Lcom/obric/assistant/ability/IObricMessageVisibilityAbility;", "getMessageVisibilityAbility", "()Lcom/obric/assistant/ability/IObricMessageVisibilityAbility;", "messageVisibilityAbility$delegate", "Lkotlin/Lazy;", "visibilitySubscription", "Lcom/obric/assistant/ability/ObricMessageVisibilitySubscription;", "onParentViewCreated", "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "ensureVisibilityObserver", "handleMessageVisibleFor", "event", "Lcom/obric/assistant/ability/ObricMessageVisibilityEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskCompletedIslandVisibilityComponent extends ComponentFeature {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f387943j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f387944h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public laa.r f387945i;

    public static final class a {
    }

    public static final class b implements laa.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComplexTaskCompletedIslandVisibilityComponent f387946a;

        public b(ComplexTaskCompletedIslandVisibilityComponent r100) {
            this.f387946a = r100;
        }

        @Override // laa.q
        public final void a(laa.p r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

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
        @Override // laa.q
        public final void b(laa.p r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            ComplexTaskCompletedIslandVisibilityComponent r100 = this.f387946a;
            int r101 = ComplexTaskCompletedIslandVisibilityComponent.f387943j;
            r100.getClass();
            List r102 = CollectionsKt.filterNotNull(SetsKt.linkedSetOf(new String[]{r110.f508228a.getMessageId(), r110.f508228a.getLocalMessageId(), r110.f508229b}));
            ArrayList r103 = new ArrayList();
            Iterator r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L9;
            Object r105 = r104.next();
            if ((!StringsKt.isBlank((String) r105)) == false) goto L4;
            r103.add(r105);
            goto L4
        L9:
            if (r103.isEmpty() == true) goto L76;
            Iterator r106 = r103.iterator();
        L12:
            Object r107 = null;
            String r108 = null;
            r108 = null;
            if (r106.hasNext() == false) goto L56;
            Object r109 = r106.next();
            String r111 = (String) r109;
            ComplexTaskQueueingAndCompletionIslandMonitor.f390088a.getClass();
            Intrinsics.checkNotNullParameter(r111, "replyMessageId");
            com.obric.assistant.live.island.g r112 = ComplexTaskQueueingAndCompletionIslandMonitor.f390090c;
            r112.getClass();
            Intrinsics.checkNotNullParameter(r111, "replyMessageId");
            if ((!StringsKt.isBlank(r111)) == true) goto L18;
            r111 = null;
        L18:
            if (r111 == null) goto L38;
            com.obric.assistant.live.island.i r113 = r112.f390114d;
            r113.getClass();
            Intrinsics.checkNotNullParameter(r111, "targetMessageId");
            Object r114 = r113.f390119b;
            monitor-enter(r114);
            Iterator<IslandSession> r115 = r113.f390120c.iterator();     // Catch: Throwable -> L53
        L24:
            if (r115.hasNext() == false) goto L34;
            IslandSession r116 = r115.next();     // Catch: Throwable -> L53
            IslandSession r117 = r116;     // Catch: Throwable -> L53
            Intrinsics.checkNotNull(r117);     // Catch: Throwable -> L53
            JsonObject r118 = r117.getExt();     // Catch: Throwable -> L53
            if (r118 == null) goto L30;
            JsonElement r119 = r118.get("ext_target_message_id");     // Catch: Throwable -> L53
            if (r119 == null) goto L30;
            String r120 = r119.getAsString();     // Catch: Throwable -> L53
        L32:
            if (Intrinsics.areEqual(r120, r111) == false) goto L24;
        L35:
            IslandSession r121 = r116;     // Catch: Throwable -> L53
            monitor-exit(r114);
            if (r121 == null) goto L38;
            JsonObject r122 = r121.getExt();
            if (r122 == null) goto L44;
            JsonElement r123 = r122.get("ext_task_id");
            if (r123 == null) goto L44;
            r108 = r123.getAsString();
        L44:
            FLogger.f375446a.i("ComplexTaskCompletedIslandModule", "dismissCompletedCardByReplyMessageId, taskId=" + r108 + ", replyMessageId=" + r111);
            if (r108 == null) goto L47;
            r112.c(r108);
        L47:
            IslandSession r124 = r112.f390114d.c(r108, r121);
            if (r124 == null) goto L50;
            int r125 = com.obric.assistant.live.island.j.f390122a;
            com.obric.assistant.live.island.j.f(r124);
        L50:
            boolean r126 = true;
        L51:
            if (r126 == false) goto L12;
            r107 = r109;
        L30:
            r120 = null;
            goto L32
        L34:
            r116 = null;
        L53:
            th = move-exception;
            throw th;
        L38:
            r126 = false;
        L56:
            String r127 = (String) r107;
            if (r127 == null) goto L75;
            FLogger.f375446a.i("CompletedIslandVisibility", "dismiss completed island after message visible, messageId=" + r127 + ", visibleDurationMs=" + r110.f508232e);
            return;
        L75:
            return;
        }

        @Override // laa.q
        public final void c(laa.p r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }
    }

    public static final class c implements Function0<laa.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f387947a;

        public c(AttachReceiver r100) {
            this.f387947a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.g invoke() {
            AttachReceiver r100 = this.f387947a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.g.class));
        }
    }

    static {
    }

    public final void F2() {
        if (this.f387945i == null) goto L5;
        return;
    L5:
        laa.g r100 = (laa.g) this.f387944h.getValue();
        if (r100 != null) goto L8;
        return;
    L8:
        this.f387945i = r100.tt(new laa.o(0.1f, 1000L), new b(this));
        FLogger.f375446a.i("CompletedIslandVisibility", "ensureVisibilityObserver, visibleDurationMs=1000, minVisibleRatio=0.1");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        laa.r r100 = this.f387945i;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f387945i = null;
    }

    public ComplexTaskCompletedIslandVisibilityComponent() {
        this.f387944h = LazyKt.lazy(new c(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        F2();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        F2();
    }
}
