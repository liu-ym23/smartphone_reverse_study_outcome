package com.obric.assistant.task.skill;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.util.r2;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f393409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f393410b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AtomicReference<ReplyOption> f393411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile AtomicBoolean f393412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Set<String> f393413e;

    public interface a {
        void b5(boolean r100);
    }

    static {
        f393409a = new CopyOnWriteArraySet();
        f393410b = new AtomicBoolean(false);
        f393411c = new AtomicReference(null);
        f393412d = new AtomicBoolean(false);
        f393413e = SetsKt.emptySet();
    }

    public static void c() {
        boolean r100 = f393412d.get();
        FLogger.f375446a.i("ObricTaskSkillModeController", "exit: wasActive=" + r100 + ", selectedOption=" + f393411c.get());
        f393411c.set(null);
        if (r100 == true) goto L5;
        return;
    L5:
        if (f393412d.getAndSet(false) == false) goto L7;
        f393410b.set(false);
    L7:
        com.larus.bmhome.view.actionbar.api.a.b("obric_task_skill_mode_filter");
        e(false);
    }

    public static boolean d() {
        return f393412d.get();
    }

    public static boolean f() {
        if (f393412d.get() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(ObricInteractDelegate.f392884b.isAiKeyPressing(), Boolean.TRUE) == false) goto L7;
        return false;
    L7:
        if (f393410b.compareAndSet(false, true) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f393409a.add(r100);
        r100.b5(d());
    }

    public static void b(ReplyOption r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        boolean r101 = f393412d.get();
        FLogger.f375446a.i("ObricTaskSkillModeController", "enter: " + r100 + ", wasActive=" + r101 + ", selectedOption=" + f393411c.get());
        f393411c.set(r100);
        if (r101 == false) goto L5;
        return;
    L5:
        if (f393412d.getAndSet(true) == true) goto L7;
        f393410b.set(false);
    L7:
        CopyOnWriteArrayList<IActionBarFilter> r102 = com.larus.bmhome.view.actionbar.api.a.f315663a;
        com.larus.bmhome.view.actionbar.api.a.a(new g());
        e(true);
    }

    public static void e(boolean r100) {
        t1a.b r101 = r2.a();
        if (r101 == null) goto L7;
        ada.c r102 = (ada.c) r101.getAbility(ada.c.class);
        if (r102 == null) goto L7;
        r102.b5(r100);
    L7:
        Iterator<a> r103 = f393409a.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r103.next().b5(r100);
        goto L9
    }
}
