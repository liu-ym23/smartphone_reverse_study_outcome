package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniProject;
import ee9.k0;
import ee9.l0;
import ee9.m0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniProjectDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniProjectObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "notifyChanged", "", "projects", "", "Lcom/larus/im/internal/jni/bean/OmniProject;", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniProjectDispatcher extends ObserverContainer<String, OmniProjectObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniProjectDispatcher";
    private static final Lazy<OmniProjectDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniProjectDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniProjectDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniProjectDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final OmniProjectDispatcher getInstance() {
            return (OmniProjectDispatcher) OmniProjectDispatcher.access$getInstance$delegate$cp().getValue();
        }

        @JvmStatic
        public final OmniProjectDispatcher getInst() {
            return getInstance();
        }
    }

    public static /* synthetic */ Unit a(List r100, OmniProjectObserver r101) {
        return notifyChanged$lambda$1(r100, r101);
    }

    public static /* synthetic */ OmniProjectDispatcher b() {
        return instance_delegate$lambda$2();
    }

    public static /* synthetic */ Unit c(List r100, OmniProjectObserver r101) {
        return notifyChanged$lambda$0(r100, r101);
    }

    @JvmStatic
    public static final OmniProjectDispatcher getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new m0());
    }

    private static final OmniProjectDispatcher instance_delegate$lambda$2() {
        return new OmniProjectDispatcher();
    }

    private OmniProjectDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void notifyChanged(final List<OmniProject> r100) {
        Intrinsics.checkNotNullParameter(r100, "projects");
        LinkedHashSet r101 = new LinkedHashSet(r100.size());
        Iterator<OmniProject> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next().projectId;
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L11:
        r104 = false;
        goto L12
    L14:
        Iterator r105 = r101.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        notify("notifyChanged", (String) r105.next(), new k0(r100));
        goto L16
    L18:
        notifyAll("notifyChanged", new l0(r100));
    }

    private static final Unit notifyChanged$lambda$0(List r100, OmniProjectObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notify");
        r101.onChanged(r100);
        return Unit.INSTANCE;
    }

    private static final Unit notifyChanged$lambda$1(List r100, OmniProjectObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notifyAll");
        r101.onChanged(r100);
        return Unit.INSTANCE;
    }
}
