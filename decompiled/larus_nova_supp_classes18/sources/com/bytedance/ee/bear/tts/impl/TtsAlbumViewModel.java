package com.bytedance.ee.bear.tts.impl;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.tts.TtsMoreItemV3;
import com.bytedance.ee.bear.document.tts.TtsPlugin;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsAlbumViewModel implements mo5.a {
    public static final /* synthetic */ int j = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final b d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Deferred<TtsResult> h;
    public mo5.g i;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ TtsAlbumViewModel a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[IPlayer.State.values().length];
                r0[IPlayer.State.ENDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[IPlayer.State.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public b(TtsAlbumViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            IPlayer.State r10 = (IPlayer.State) r9;
            Intrinsics.checkNotNullParameter(r10, "it");
            tt5.a.h("TtsAlbumViewModel", "selectedItemStateObserver, selectedItem: " + this.a.i + ", newState: " + r10);
            int r11 = a.a[r10.ordinal()];
            if (r11 != 1) goto L5;
            TtsAlbumViewModel r12 = this.a;
            mo5.g r0 = r12.i;
            if (r0 != null) goto L44;
            tt5.a.k("TtsAlbumViewModel", "handleItemEnded, selectedItem is null.");
            return;
        L44:
            tt5.a.h("TtsAlbumViewModel", "handleItemEnded, selectedItem: " + r0);
            mo5.g r1 = r12.d(r0);
            if (r1 == null) goto L49;
            mo5.g r2 = r12.h(r1);
            if (r2 == null) goto L49;
            tt5.a.h("TtsAlbumViewModel", "handleItemEnded, ENDED, switch to next: " + r2);
            r2.p(TtsLoadScene.SWITCH_ITEM, new com.bytedance.ee.bear.tts.impl.a(r12));
            return;
        L49:
            tt5.a.h("TtsAlbumViewModel", "handleItemEnded, no more item, do nothing.");
            return;
        L5:
            if (r11 != 2) goto L59;
            TtsAlbumViewModel r13 = this.a;
            mo5.g r3 = r13.i;
            if (r3 == null) goto L17;
            TtsResult r4 = r3.l("TtsAlbumViewModel-handleTtsState(ERROR)");
            if (r4 == null) goto L17;
            if (r4.a() == false) goto L15;
            r4 = null;
        L15:
            if (r4 == null) goto L17;
        L18:
            r13.x(r4);
            mo5.i r5 = (mo5.i) ((MutableLiveData) r13.a.getValue()).getValue();
            if (r5 != null) goto L21;
            tt5.a.k("TtsAlbumViewModel", "handleItemError, albumItemSelection is null.");
            return;
        L21:
            mo5.g r6 = (mo5.g) r5.a;
            mo5.g r7 = (mo5.g) r5.b;
            if (r7 != null) goto L24;
            tt5.a.k("TtsAlbumViewModel", "handleItemError, currentItem is null.");
            return;
        L24:
            if (r6 == null) goto L26;
            int r8 = mo5.h.c(r13, r6);
        L27:
            int r14 = mo5.h.c(r13, r7);
            TtsLoadScene r15 = (TtsLoadScene) r7.n().getValue();
            if (r15 != null) goto L30;
            r15 = TtsLoadScene.DEFAULT;
        L30:
            tt5.a.h("TtsAlbumViewModel", "handleItemError, lastItem: " + r6 + ", lastItemIndex: " + r8 + ", currentItem: " + r7 + ", currentItemIndex: " + r14 + ", currentItemLoadScene: " + r15);
            if (r6 == null) goto L35;
            if (r8 < 0) goto L35;
            if (r8 >= r14) goto L35;
        L36:
            mo5.g r16 = r13.d(r7);
            if (r16 == null) goto L54;
            mo5.g r17 = r13.h(r16);
            if (r17 == null) goto L55;
            tt5.a.h("TtsAlbumViewModel", "handleTtsState, ERROR, switch to next: " + r17);
            r17.p(TtsLoadScene.SWITCH_ITEM, new com.bytedance.ee.bear.tts.impl.b(r13));
            return;
        L55:
            return;
        L54:
            return;
        L35:
            if (r15 == TtsLoadScene.DEFAULT) goto L36;
            return;
        L26:
            r8 = -1;
        L17:
            r4 = TtsResult.e;
            goto L18
        }
    }

    static {
    }

    @Override // mo5.a
    public final MutableLiveData b() {
        return (MutableLiveData) this.b.getValue();
    }

    @Override // mo5.a
    public final MutableLiveData e() {
        return (MutableLiveData) this.a.getValue();
    }

    @Override // mo5.a
    public final void j() {
        tt5.a.h("TtsAlbumViewModel", "destroyAlbum, selectedItem: " + this.i + ", itemList: " + u());
        z();
        t();
        List<mo5.c> r0 = v();
        monitor-enter(r0);
        v().clear();     // Catch: Throwable -> L14
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        List<mo5.d> r2 = w();
        monitor-enter(r2);
        w().clear();     // Catch: Throwable -> L11
        monitor-exit(r2);
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final MutableLiveData m() {
        return (MutableLiveData) this.c.getValue();
    }

    public final void t() {
        tt5.a.h("TtsAlbumViewModel", "destroyItemListSync, selectedItem: " + this.i + ", itemList: " + u());
        mo5.g r0 = this.i;
        if (r0 == null) goto L5;
        s(r0);
        this.i = null;
    L5:
        List<mo5.g> r1 = u();
        monitor-enter(r1);
        Iterator<mo5.g> r2 = u().iterator();     // Catch: Throwable -> L14
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().onDestroy();     // Catch: Throwable -> L14
        r2.remove();     // Catch: Throwable -> L14
        goto L9
    L11:
        ((MutableLiveData) this.b.getValue()).setValue(new ArrayList());     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r1);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final List<mo5.g> u() {
        return (List) this.e.getValue();
    }

    public final List<mo5.c> v() {
        return (List) this.f.getValue();
    }

    public final List<mo5.d> w() {
        return (List) this.g.getValue();
    }

    public final void z() {
        tt5.a.h("TtsAlbumViewModel", "saveItemListSync, selectedItem: " + this.i + ", itemList: " + u());
        List<mo5.g> r0 = u();
        monitor-enter(r0);
        Iterator<mo5.g> r1 = u().iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().d("TtsAlbumViewModel-saveVMList", null);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public TtsAlbumViewModel() {
        this.a = LazyKt.lazy(TtsAlbumViewModel$albumItemSelectionLiveData$2.INSTANCE);
        this.b = LazyKt.lazy(TtsAlbumViewModel$albumItemListLiveData$2.INSTANCE);
        this.c = LazyKt.lazy(TtsAlbumViewModel$albumItemUpdateLiveData$2.INSTANCE);
        this.d = new b(this);
        this.e = LazyKt.lazy(TtsAlbumViewModel$itemList$2.INSTANCE);
        this.f = LazyKt.lazy(TtsAlbumViewModel$resultHandlerList$2.INSTANCE);
        this.g = LazyKt.lazy(TtsAlbumViewModel$routerList$2.INSTANCE);
        SystemClock.elapsedRealtime();
    }

    @Override // mo5.a
    public final void a(mo5.g r8) {
        Intrinsics.checkNotNullParameter(r8, "itemVM");
        tt5.a.h("TtsAlbumViewModel", "notifyRouter, itemVM: " + r8);
        List<mo5.d> r0 = w();
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (w().isEmpty() == false) goto L7;
        w().add(new c());     // Catch: Throwable -> L18
    L7:
        Iterator<mo5.d> r1 = w().iterator();     // Catch: Throwable -> L18
    L9:
        if (r1.hasNext() == false) goto L15;
        mo5.d r2 = r1.next();     // Catch: Throwable -> L18
        tt5.a.h("TtsAlbumViewModel", "notifyRouter, eachRouter: " + r2);     // Catch: Throwable -> L18
        if (r2 == null) goto L9;
        boolean r3 = r2.a(r8);     // Catch: Throwable -> L18
        tt5.a.h("TtsAlbumViewModel", "notifyRouter, router: " + r2 + ", result: " + r3);     // Catch: Throwable -> L18
        if (r3 == false) goto L9;
    L15:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
    }

    @Override // mo5.a
    public final void c(mo5.c r5) {
        Intrinsics.checkNotNullParameter(r5, "resultHandler");
        List<mo5.c> r1 = v();
        monitor-enter(r1);
        v().remove(r5);     // Catch: Throwable -> L7
        tt5.a.h("TtsAlbumViewModel", "removeResultHandler, resultHandler removed: " + r5);     // Catch: Throwable -> L7
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g d(mo5.g r6) {
        Intrinsics.checkNotNullParameter(r6, "fromItemVM");
        tt5.a.h("TtsAlbumViewModel", "findNext");
        List<mo5.g> r3 = u();
        monitor-enter(r3);
        int r4 = u().indexOf(r6);     // Catch: Throwable -> L14
        if (r4 >= 0) goto L8;
        tt5.a.k("TtsAlbumViewModel", "findNext, fromItemVM isn't inside of itemList: " + r6);     // Catch: Throwable -> L14
    L10:
        mo5.g r7 = null;
    L12:
        monitor-exit(r3);
        return r7;
    L8:
        if (r4 != CollectionsKt.getLastIndex(u())) goto L11;
        tt5.a.k("TtsAlbumViewModel", "findNext, fromItemVM is the last item: " + r6);     // Catch: Throwable -> L14
        goto L10
    L11:
        int r5 = r4 + 1;     // Catch: Throwable -> L14
        r7 = (mo5.g) CollectionsKt.getOrNull(u(), r5);     // Catch: Throwable -> L14
        tt5.a.h("TtsAlbumViewModel", "findNext, found next item: " + r7 + ", at: " + r5);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g f(mo5.g r6) {
        Intrinsics.checkNotNullParameter(r6, "fromItemVM");
        tt5.a.h("TtsAlbumViewModel", "findPrevious");
        List<mo5.g> r3 = u();
        monitor-enter(r3);
        int r4 = u().indexOf(r6);     // Catch: Throwable -> L13
        if (r4 >= 0) goto L7;
        tt5.a.k("TtsAlbumViewModel", "findPrevious, fromItemVM isn't inside of itemList: " + r6);     // Catch: Throwable -> L13
    L9:
        mo5.g r7 = null;
    L11:
        monitor-exit(r3);
        return r7;
    L7:
        if (r4 != 0) goto L10;
        tt5.a.k("TtsAlbumViewModel", "findPrevious, fromItemVM is the first item: " + r6);     // Catch: Throwable -> L13
        goto L9
    L10:
        int r5 = r4 - 1;     // Catch: Throwable -> L13
        r7 = (mo5.g) CollectionsKt.getOrNull(u(), r5);     // Catch: Throwable -> L13
        tt5.a.h("TtsAlbumViewModel", "findPrevious, found previous item: " + r7 + ", at: " + r5);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final void g(TtsResult r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        tt5.a.h("TtsAlbumViewModel", "handleResult, result: " + r3);
        x(r3);
    }

    @Override // mo5.a
    public final mo5.g h(mo5.g r7) {
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        List<mo5.g> r0 = u();
        monitor-enter(r0);
        Iterator<T> r1 = u().iterator();     // Catch: Throwable -> L25
    L5:
        mo5.g r3 = null;
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(((mo5.g) r2).a(), r7.a()) == false) goto L5;
    L11:
        mo5.g r4 = (mo5.g) r2;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (r4 != null) goto L16;
        tt5.a.h("TtsAlbumViewModel", "selectItem, target not found, selectedItem: " + this.i + ", target: " + r7);
        return null;
    L16:
        mo5.g r5 = this.i;
        if (r5 != null) goto L19;
    L23:
        tt5.a.h("TtsAlbumViewModel", "selectItem, selectedItem: " + r4);
        this.i = r4;
        y(r3, r4);
        return r4;
    L19:
        if (Intrinsics.areEqual(r5.a(), r7.a()) == false) goto L22;
        tt5.a.h("TtsAlbumViewModel", "selectItem, target is already selected: " + r5);
        return r5;
    L22:
        tt5.a.h("TtsAlbumViewModel", "selectItem, target found, switch to it, selected: " + r5 + ", target: " + r7);
        s(r5);
        r3 = r5;
        goto L23
    L10:
        r2 = null;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final void i(TtsPlugin.b r5) {
        Intrinsics.checkNotNullParameter(r5, "ttsRouter");
        List<mo5.d> r2 = w();
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (w().contains(r5) == false) goto L9;
        tt5.a.h("TtsAlbumViewModel", "addRouter, ttsRouter already existed: " + r5);     // Catch: Throwable -> L12
        monitor-exit(r2);
        return;
    L9:
        w().add(0, r5);     // Catch: Throwable -> L12
        tt5.a.h("TtsAlbumViewModel", "addRouter, ttsRouter added: " + r5);     // Catch: Throwable -> L12
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r2);
    }

    @Override // mo5.a
    public final void k(TtsPlugin.b r5) {
        Intrinsics.checkNotNullParameter(r5, "ttsRouter");
        List<mo5.d> r1 = w();
        monitor-enter(r1);
        Boolean r2 = Boolean.valueOf(w().remove(r5));     // Catch: Throwable -> L12
        if (r2.booleanValue() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        r2.booleanValue();     // Catch: Throwable -> L12
        tt5.a.h("TtsAlbumViewModel", "removeRouter, ttsRouter removed: " + r5);     // Catch: Throwable -> L12
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final void l(mo5.c r5) {
        Intrinsics.checkNotNullParameter(r5, "resultHandler");
        List<mo5.c> r2 = v();
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (v().contains(r5) == false) goto L9;
        tt5.a.h("TtsAlbumViewModel", "addResultHandler, resultHandler already existed: " + r5);     // Catch: Throwable -> L12
        monitor-exit(r2);
        return;
    L9:
        v().add(0, r5);     // Catch: Throwable -> L12
        tt5.a.h("TtsAlbumViewModel", "addResultHandler, resultHandler added: " + r5);     // Catch: Throwable -> L12
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r2);
    }

    @Override // mo5.a
    public final void n(final TtsMoreItemV3.b.a r8) {
        tt5.a.h("TtsAlbumViewModel", "reloadAlbum, current itemList: " + u());
        final Deferred<TtsResult> r0 = this.h;
        if (r0 == null) goto L6;
        r0.invokeOnCompletion(new TtsAlbumViewModel$reloadAlbum$1$1(r8, r0));
        return;
    L6:
        final Deferred<TtsResult> r1 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TtsAlbumViewModel$reloadAlbum$2(false, this, null), 3, null);
        r1.invokeOnCompletion(new TtsAlbumViewModel$reloadAlbum$3$1(this, r8, r1));
        this.h = r1;
    }

    @Override // mo5.a
    public final mo5.g o(mo5.g r7) {
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        List<mo5.g> r0 = u();
        monitor-enter(r0);
        Iterator<T> r1 = u().iterator();     // Catch: Throwable -> L24
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(((mo5.g) r2).a(), r7.a()) == false) goto L6;
    L11:
        boolean r3 = false;
        if (((mo5.g) r2) != null) goto L14;
        tt5.a.h("TtsAlbumViewModel", "addItemSync: " + r7 + ", atFirst: true");     // Catch: Throwable -> L24
        u().add(0, r7);     // Catch: Throwable -> L24
        r3 = true;
    L15:
        monitor-exit(r0);
        Boolean r4 = Boolean.valueOf(r3);
        if (r4.booleanValue() == true) goto L20;
        r4 = null;
    L20:
        if (r4 == null) goto L23;
        r4.booleanValue();
        tt5.a.h("TtsAlbumViewModel", "addItem, viewModel added: " + r7);
        ((MutableLiveData) this.b.getValue()).setValue(new ArrayList(u()));
        return r7;
    L23:
        return null;
    L14:
        tt5.a.k("TtsAlbumViewModel", "addItemSync, viewModel existed: " + r7);     // Catch: Throwable -> L24
        goto L15
    L10:
        r2 = null;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g p(mo5.g r6) {
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        if (s(r6) == null) goto L5;
        tt5.a.h("TtsAlbumViewModel", "removeItem, viewModel deselected: " + r6);
    L5:
        List<mo5.g> r0 = u();
        monitor-enter(r0);
        Iterator<mo5.g> r1 = u().iterator();     // Catch: Throwable -> L26
    L9:
        if (r1.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r1.next().a(), r6.a()) == false) goto L9;
        tt5.a.k("TtsAlbumViewModel", "removeItemSync, viewModel found: " + r6);     // Catch: Throwable -> L26
        r1.remove();     // Catch: Throwable -> L26
        monitor-exit(r0);
        boolean r2 = true;
    L18:
        Boolean r3 = Boolean.valueOf(r2);
        if (r3.booleanValue() == true) goto L22;
        r3 = null;
    L22:
        if (r3 == null) goto L25;
        r3.booleanValue();
        tt5.a.h("TtsAlbumViewModel", "removeItem, viewModel removed: " + r6);
        ((MutableLiveData) this.b.getValue()).setValue(new ArrayList(u()));
        r6.e();
        r6.onDestroy();
        return r6;
    L25:
        return null;
    L15:
        tt5.a.k("TtsAlbumViewModel", "removeItemSync, viewModel not found: " + r6);     // Catch: Throwable -> L26
        monitor-exit(r0);
        r2 = false;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g q(String r6) {
        Intrinsics.checkNotNullParameter(r6, "docToken");
        tt5.a.h("TtsAlbumViewModel", "findItemByToken, docToken: " + du5.b.i(r6) + ", andSelect: false");
        List<mo5.g> r0 = u();
        monitor-enter(r0);
        Iterator<T> r1 = u().iterator();     // Catch: Throwable -> L17
    L5:
        mo5.g r3 = null;
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(mo5.h.a((mo5.g) r2), r6) == false) goto L5;
    L11:
        mo5.g r4 = (mo5.g) r2;     // Catch: Throwable -> L17
        if (r4 == null) goto L14;
        r3 = r4;
    L14:
        monitor-exit(r0);
        tt5.a.h("TtsAlbumViewModel", "findItemByToken, result: " + r3 + ", selected: false");
        return r3;
    L10:
        r2 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final mo5.g s(mo5.g r6) {
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        mo5.g r0 = this.i;
        if (r0 != null) goto L7;
        tt5.a.h("TtsAlbumViewModel", "deselectItem, selectedItem is null, viewModel: " + r6);
        return null;
    L7:
        if (Intrinsics.areEqual(r0.a(), r6.a()) == false) goto L9;
        mo5.g r3 = r0;
    L10:
        if (r3 == null) goto L13;
        tt5.a.h("TtsAlbumViewModel", "deselectItem, deselect viewModel: " + r3);
        r3.pause();
        r3.d("TtsAlbumViewModel-deselect", null);
        r3.q();
        this.i = null;
        y(r0, null);
        return r3;
    L13:
        tt5.a.h("TtsAlbumViewModel", "deselectItem, target is not selected, selected: " + this.i + ", target: " + r6);
        return null;
    L9:
        r3 = null;
        goto L10
    }

    public final void x(TtsResult r6) {
        if (r6 != null) goto L6;
        tt5.a.k("TtsAlbumViewModel", "notifyResult, result is null.");
        return;
    L6:
        tt5.a.h("TtsAlbumViewModel", "notifyResult, result: " + r6);
        Iterator<mo5.c> r1 = v().iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        mo5.c r2 = r1.next();
        tt5.a.h("TtsAlbumViewModel", "notifyResult, eachHandler: " + r2);
        if (r2 == null) goto L8;
        r2.a(r6);
        tt5.a.h("TtsAlbumViewModel", "notifyResult, handler: " + r2 + ", result: true");
        return;
    }

    public static final List r(TtsAlbumViewModel r7, List r8) {
        r7.getClass();
        if (r8.isEmpty() == true) goto L34;
        List<mo5.g> r0 = r7.u();
        monitor-enter(r0);
        List<mo5.g> r1 = r7.u();     // Catch: Throwable -> L22
        HashSet r2 = new HashSet();     // Catch: Throwable -> L22
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L22
    L9:
        if (r3.hasNext() == false) goto L11;
        r2.add(((mo5.g) r3.next()).a());     // Catch: Throwable -> L22
        goto L9
    L11:
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L22
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L22
    L13:
        if (r9.hasNext() == false) goto L18;
        mo5.g r5 = (mo5.g) r9.next();     // Catch: Throwable -> L22
        if (r2.add(r5.a()) == true) goto L16;
        tt5.a.k("TtsAlbumViewModel", "addItemListSync, viewModel existed: " + r5);     // Catch: Throwable -> L22
        goto L13
    L16:
        tt5.a.h("TtsAlbumViewModel", "addItemListSync, viewModel: " + r5 + ", atFirst: false");     // Catch: Throwable -> L22
        r4.add(r5);     // Catch: Throwable -> L22
        goto L13
    L18:
        r7.u().addAll(r4);     // Catch: Throwable -> L22
        monitor-exit(r0);
        return r4;
    L22:
        th = move-exception;
        throw th;
    L34:
        return CollectionsKt.emptyList();
    }

    public final void y(mo5.g r3, mo5.g r4) {
        if (r3 == null) goto L6;
        to5.a r0 = r3.m();
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (r4 == null) goto L10;
        to5.a r1 = r4.m();
        if (r1 == null) goto L10;
        r1.b();
    L10:
        if (r3 == null) goto L14;
        MutableLiveData r2 = r3.u();
        if (r2 == null) goto L14;
        r2.removeObserver(this.d);
    L14:
        if (r4 == null) goto L18;
        MutableLiveData r5 = r4.u();
        if (r5 == null) goto L18;
        r5.observeForever(this.d);
    L18:
        ((MutableLiveData) this.a.getValue()).setValue(new mo5.i(r3, r4));
    }
}
