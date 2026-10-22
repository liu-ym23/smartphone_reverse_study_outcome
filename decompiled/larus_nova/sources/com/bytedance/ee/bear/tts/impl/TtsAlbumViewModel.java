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

/* JADX INFO: loaded from: classes18.dex */
public final class TtsAlbumViewModel implements mo5.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f239464j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f239465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f239466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f239467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f239468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f239469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f239470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f239471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Deferred<TtsResult> f239472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public mo5.g f239473i;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsAlbumViewModel f239474a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f239475a = null;

            static {
                int[] r100 = new int[IPlayer.State.values().length];
                r100[IPlayer.State.ENDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[IPlayer.State.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f239475a = r100;
            }
        }

        public b(TtsAlbumViewModel r100) {
            this.f239474a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IPlayer.State r101 = (IPlayer.State) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            tt5.a.h("TtsAlbumViewModel", "selectedItemStateObserver, selectedItem: " + this.f239474a.f239473i + ", newState: " + r101);
            int r102 = a.f239475a[r101.ordinal()];
            if (r102 != 1) goto L5;
            TtsAlbumViewModel r103 = this.f239474a;
            mo5.g r104 = r103.f239473i;
            if (r104 != null) goto L44;
            tt5.a.k("TtsAlbumViewModel", "handleItemEnded, selectedItem is null.");
            return;
        L44:
            tt5.a.h("TtsAlbumViewModel", "handleItemEnded, selectedItem: " + r104);
            mo5.g r105 = r103.d(r104);
            if (r105 == null) goto L49;
            mo5.g r106 = r103.h(r105);
            if (r106 == null) goto L49;
            tt5.a.h("TtsAlbumViewModel", "handleItemEnded, ENDED, switch to next: " + r106);
            r106.p(TtsLoadScene.SWITCH_ITEM, new com.bytedance.ee.bear.tts.impl.a(r103));
            return;
        L49:
            tt5.a.h("TtsAlbumViewModel", "handleItemEnded, no more item, do nothing.");
            return;
        L5:
            if (r102 != 2) goto L59;
            TtsAlbumViewModel r107 = this.f239474a;
            mo5.g r108 = r107.f239473i;
            if (r108 == null) goto L17;
            TtsResult r109 = r108.l("TtsAlbumViewModel-handleTtsState(ERROR)");
            if (r109 == null) goto L17;
            if (r109.a() == false) goto L15;
            r109 = null;
        L15:
            if (r109 == null) goto L17;
        L18:
            r107.x(r109);
            mo5.i r110 = (mo5.i) ((MutableLiveData) r107.f239465a.getValue()).getValue();
            if (r110 != null) goto L21;
            tt5.a.k("TtsAlbumViewModel", "handleItemError, albumItemSelection is null.");
            return;
        L21:
            mo5.g r111 = (mo5.g) r110.f514584a;
            mo5.g r112 = (mo5.g) r110.f514585b;
            if (r112 != null) goto L24;
            tt5.a.k("TtsAlbumViewModel", "handleItemError, currentItem is null.");
            return;
        L24:
            if (r111 == null) goto L26;
            int r113 = mo5.h.c(r107, r111);
        L27:
            int r114 = mo5.h.c(r107, r112);
            TtsLoadScene r115 = (TtsLoadScene) r112.n().getValue();
            if (r115 != null) goto L30;
            r115 = TtsLoadScene.DEFAULT;
        L30:
            tt5.a.h("TtsAlbumViewModel", "handleItemError, lastItem: " + r111 + ", lastItemIndex: " + r113 + ", currentItem: " + r112 + ", currentItemIndex: " + r114 + ", currentItemLoadScene: " + r115);
            if (r111 == null) goto L35;
            if (r113 < 0) goto L35;
            if (r113 >= r114) goto L35;
        L36:
            mo5.g r116 = r107.d(r112);
            if (r116 == null) goto L54;
            mo5.g r117 = r107.h(r116);
            if (r117 == null) goto L55;
            tt5.a.h("TtsAlbumViewModel", "handleTtsState, ERROR, switch to next: " + r117);
            r117.p(TtsLoadScene.SWITCH_ITEM, new com.bytedance.ee.bear.tts.impl.b(r107));
            return;
        L55:
            return;
        L54:
            return;
        L35:
            if (r115 == TtsLoadScene.DEFAULT) goto L36;
            return;
        L26:
            r113 = -1;
        L17:
            r109 = TtsResult.f239450e;
            goto L18
        }
    }

    static {
    }

    @Override // mo5.a
    public final MutableLiveData b() {
        return (MutableLiveData) this.f239466b.getValue();
    }

    @Override // mo5.a
    public final MutableLiveData e() {
        return (MutableLiveData) this.f239465a.getValue();
    }

    @Override // mo5.a
    public final void j() {
        tt5.a.h("TtsAlbumViewModel", "destroyAlbum, selectedItem: " + this.f239473i + ", itemList: " + u());
        z();
        t();
        List<mo5.c> r100 = v();
        monitor-enter(r100);
        v().clear();     // Catch: Throwable -> L14
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
        List<mo5.d> r102 = w();
        monitor-enter(r102);
        w().clear();     // Catch: Throwable -> L11
        monitor-exit(r102);
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
        return (MutableLiveData) this.f239467c.getValue();
    }

    public final void t() {
        tt5.a.h("TtsAlbumViewModel", "destroyItemListSync, selectedItem: " + this.f239473i + ", itemList: " + u());
        mo5.g r100 = this.f239473i;
        if (r100 == null) goto L5;
        s(r100);
        this.f239473i = null;
    L5:
        List<mo5.g> r101 = u();
        monitor-enter(r101);
        Iterator<mo5.g> r102 = u().iterator();     // Catch: Throwable -> L14
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().onDestroy();     // Catch: Throwable -> L14
        r102.remove();     // Catch: Throwable -> L14
        goto L9
    L11:
        ((MutableLiveData) this.f239466b.getValue()).setValue(new ArrayList());     // Catch: Throwable -> L14
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final List<mo5.g> u() {
        return (List) this.f239469e.getValue();
    }

    public final List<mo5.c> v() {
        return (List) this.f239470f.getValue();
    }

    public final List<mo5.d> w() {
        return (List) this.f239471g.getValue();
    }

    public final void z() {
        tt5.a.h("TtsAlbumViewModel", "saveItemListSync, selectedItem: " + this.f239473i + ", itemList: " + u());
        List<mo5.g> r100 = u();
        monitor-enter(r100);
        Iterator<mo5.g> r101 = u().iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().d("TtsAlbumViewModel-saveVMList", null);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public TtsAlbumViewModel() {
        this.f239465a = LazyKt.lazy(TtsAlbumViewModel$albumItemSelectionLiveData$2.INSTANCE);
        this.f239466b = LazyKt.lazy(TtsAlbumViewModel$albumItemListLiveData$2.INSTANCE);
        this.f239467c = LazyKt.lazy(TtsAlbumViewModel$albumItemUpdateLiveData$2.INSTANCE);
        this.f239468d = new b(this);
        this.f239469e = LazyKt.lazy(TtsAlbumViewModel$itemList$2.INSTANCE);
        this.f239470f = LazyKt.lazy(TtsAlbumViewModel$resultHandlerList$2.INSTANCE);
        this.f239471g = LazyKt.lazy(TtsAlbumViewModel$routerList$2.INSTANCE);
        SystemClock.elapsedRealtime();
    }

    @Override // mo5.a
    public final void a(mo5.g r100) {
        Intrinsics.checkNotNullParameter(r100, "itemVM");
        tt5.a.h("TtsAlbumViewModel", "notifyRouter, itemVM: " + r100);
        List<mo5.d> r101 = w();
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (w().isEmpty() == false) goto L7;
        w().add(new c());     // Catch: Throwable -> L18
    L7:
        Iterator<mo5.d> r102 = w().iterator();     // Catch: Throwable -> L18
    L9:
        if (r102.hasNext() == false) goto L15;
        mo5.d r103 = r102.next();     // Catch: Throwable -> L18
        tt5.a.h("TtsAlbumViewModel", "notifyRouter, eachRouter: " + r103);     // Catch: Throwable -> L18
        if (r103 == null) goto L9;
        boolean r104 = r103.a(r100);     // Catch: Throwable -> L18
        tt5.a.h("TtsAlbumViewModel", "notifyRouter, router: " + r103 + ", result: " + r104);     // Catch: Throwable -> L18
        if (r104 == false) goto L9;
    L15:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r101);
    }

    @Override // mo5.a
    public final void c(mo5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "resultHandler");
        List<mo5.c> r101 = v();
        monitor-enter(r101);
        v().remove(r100);     // Catch: Throwable -> L7
        tt5.a.h("TtsAlbumViewModel", "removeResultHandler, resultHandler removed: " + r100);     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g d(mo5.g r100) {
        Intrinsics.checkNotNullParameter(r100, "fromItemVM");
        tt5.a.h("TtsAlbumViewModel", "findNext");
        List<mo5.g> r101 = u();
        monitor-enter(r101);
        int r102 = u().indexOf(r100);     // Catch: Throwable -> L14
        if (r102 >= 0) goto L8;
        tt5.a.k("TtsAlbumViewModel", "findNext, fromItemVM isn't inside of itemList: " + r100);     // Catch: Throwable -> L14
    L10:
        mo5.g r103 = null;
    L12:
        monitor-exit(r101);
        return r103;
    L8:
        if (r102 != CollectionsKt.getLastIndex(u())) goto L11;
        tt5.a.k("TtsAlbumViewModel", "findNext, fromItemVM is the last item: " + r100);     // Catch: Throwable -> L14
        goto L10
    L11:
        int r104 = r102 + 1;     // Catch: Throwable -> L14
        r103 = (mo5.g) CollectionsKt.getOrNull(u(), r104);     // Catch: Throwable -> L14
        tt5.a.h("TtsAlbumViewModel", "findNext, found next item: " + r103 + ", at: " + r104);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g f(mo5.g r100) {
        Intrinsics.checkNotNullParameter(r100, "fromItemVM");
        tt5.a.h("TtsAlbumViewModel", "findPrevious");
        List<mo5.g> r101 = u();
        monitor-enter(r101);
        int r102 = u().indexOf(r100);     // Catch: Throwable -> L13
        if (r102 >= 0) goto L7;
        tt5.a.k("TtsAlbumViewModel", "findPrevious, fromItemVM isn't inside of itemList: " + r100);     // Catch: Throwable -> L13
    L9:
        mo5.g r103 = null;
    L11:
        monitor-exit(r101);
        return r103;
    L7:
        if (r102 != 0) goto L10;
        tt5.a.k("TtsAlbumViewModel", "findPrevious, fromItemVM is the first item: " + r100);     // Catch: Throwable -> L13
        goto L9
    L10:
        int r104 = r102 - 1;     // Catch: Throwable -> L13
        r103 = (mo5.g) CollectionsKt.getOrNull(u(), r104);     // Catch: Throwable -> L13
        tt5.a.h("TtsAlbumViewModel", "findPrevious, found previous item: " + r103 + ", at: " + r104);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final void g(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        tt5.a.h("TtsAlbumViewModel", "handleResult, result: " + r100);
        x(r100);
    }

    @Override // mo5.a
    public final mo5.g h(mo5.g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        List<mo5.g> r101 = u();
        monitor-enter(r101);
        Iterator<T> r102 = u().iterator();     // Catch: Throwable -> L25
    L5:
        mo5.g r103 = null;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();     // Catch: Throwable -> L25
        if (Intrinsics.areEqual(((mo5.g) r104).a(), r100.a()) == false) goto L5;
    L11:
        mo5.g r105 = (mo5.g) r104;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if (r105 != null) goto L16;
        tt5.a.h("TtsAlbumViewModel", "selectItem, target not found, selectedItem: " + this.f239473i + ", target: " + r100);
        return null;
    L16:
        mo5.g r106 = this.f239473i;
        if (r106 != null) goto L19;
    L23:
        tt5.a.h("TtsAlbumViewModel", "selectItem, selectedItem: " + r105);
        this.f239473i = r105;
        y(r103, r105);
        return r105;
    L19:
        if (Intrinsics.areEqual(r106.a(), r100.a()) == false) goto L22;
        tt5.a.h("TtsAlbumViewModel", "selectItem, target is already selected: " + r106);
        return r106;
    L22:
        tt5.a.h("TtsAlbumViewModel", "selectItem, target found, switch to it, selected: " + r106 + ", target: " + r100);
        s(r106);
        r103 = r106;
        goto L23
    L10:
        r104 = null;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final void i(TtsPlugin.b r100) {
        Intrinsics.checkNotNullParameter(r100, "ttsRouter");
        List<mo5.d> r101 = w();
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (w().contains(r100) == false) goto L9;
        tt5.a.h("TtsAlbumViewModel", "addRouter, ttsRouter already existed: " + r100);     // Catch: Throwable -> L12
        monitor-exit(r101);
        return;
    L9:
        w().add(0, r100);     // Catch: Throwable -> L12
        tt5.a.h("TtsAlbumViewModel", "addRouter, ttsRouter added: " + r100);     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
    }

    @Override // mo5.a
    public final void k(TtsPlugin.b r100) {
        Intrinsics.checkNotNullParameter(r100, "ttsRouter");
        List<mo5.d> r101 = w();
        monitor-enter(r101);
        Boolean r102 = Boolean.valueOf(w().remove(r100));     // Catch: Throwable -> L12
        if (r102.booleanValue() == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r102.booleanValue();     // Catch: Throwable -> L12
        tt5.a.h("TtsAlbumViewModel", "removeRouter, ttsRouter removed: " + r100);     // Catch: Throwable -> L12
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final void l(mo5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "resultHandler");
        List<mo5.c> r101 = v();
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (v().contains(r100) == false) goto L9;
        tt5.a.h("TtsAlbumViewModel", "addResultHandler, resultHandler already existed: " + r100);     // Catch: Throwable -> L12
        monitor-exit(r101);
        return;
    L9:
        v().add(0, r100);     // Catch: Throwable -> L12
        tt5.a.h("TtsAlbumViewModel", "addResultHandler, resultHandler added: " + r100);     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
    }

    @Override // mo5.a
    public final void n(final TtsMoreItemV3.b.a r100) {
        tt5.a.h("TtsAlbumViewModel", "reloadAlbum, current itemList: " + u());
        final Deferred<TtsResult> r101 = this.f239472h;
        if (r101 == null) goto L6;
        r101.invokeOnCompletion(new TtsAlbumViewModel$reloadAlbum$1$1(r100, r101));
        return;
    L6:
        final Deferred<TtsResult> r102 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TtsAlbumViewModel$reloadAlbum$2(false, this, null), 3, null);
        r102.invokeOnCompletion(new TtsAlbumViewModel$reloadAlbum$3$1(this, r100, r102));
        this.f239472h = r102;
    }

    @Override // mo5.a
    public final mo5.g o(mo5.g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        List<mo5.g> r101 = u();
        monitor-enter(r101);
        Iterator<T> r102 = u().iterator();     // Catch: Throwable -> L24
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(((mo5.g) r103).a(), r100.a()) == false) goto L6;
    L11:
        boolean r104 = false;
        if (((mo5.g) r103) != null) goto L14;
        tt5.a.h("TtsAlbumViewModel", "addItemSync: " + r100 + ", atFirst: true");     // Catch: Throwable -> L24
        u().add(0, r100);     // Catch: Throwable -> L24
        r104 = true;
    L15:
        monitor-exit(r101);
        Boolean r105 = Boolean.valueOf(r104);
        if (r105.booleanValue() == true) goto L20;
        r105 = null;
    L20:
        if (r105 == null) goto L23;
        r105.booleanValue();
        tt5.a.h("TtsAlbumViewModel", "addItem, viewModel added: " + r100);
        ((MutableLiveData) this.f239466b.getValue()).setValue(new ArrayList(u()));
        return r100;
    L23:
        return null;
    L14:
        tt5.a.k("TtsAlbumViewModel", "addItemSync, viewModel existed: " + r100);     // Catch: Throwable -> L24
        goto L15
    L10:
        r103 = null;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g p(mo5.g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        if (s(r100) == null) goto L5;
        tt5.a.h("TtsAlbumViewModel", "removeItem, viewModel deselected: " + r100);
    L5:
        List<mo5.g> r101 = u();
        monitor-enter(r101);
        Iterator<mo5.g> r102 = u().iterator();     // Catch: Throwable -> L26
    L9:
        if (r102.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r102.next().a(), r100.a()) == false) goto L9;
        tt5.a.k("TtsAlbumViewModel", "removeItemSync, viewModel found: " + r100);     // Catch: Throwable -> L26
        r102.remove();     // Catch: Throwable -> L26
        monitor-exit(r101);
        boolean r103 = true;
    L18:
        Boolean r104 = Boolean.valueOf(r103);
        if (r104.booleanValue() == true) goto L22;
        r104 = null;
    L22:
        if (r104 == null) goto L25;
        r104.booleanValue();
        tt5.a.h("TtsAlbumViewModel", "removeItem, viewModel removed: " + r100);
        ((MutableLiveData) this.f239466b.getValue()).setValue(new ArrayList(u()));
        r100.e();
        r100.onDestroy();
        return r100;
    L25:
        return null;
    L15:
        tt5.a.k("TtsAlbumViewModel", "removeItemSync, viewModel not found: " + r100);     // Catch: Throwable -> L26
        monitor-exit(r101);
        r103 = false;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // mo5.a
    public final mo5.g q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        tt5.a.h("TtsAlbumViewModel", "findItemByToken, docToken: " + du5.b.i(r100) + ", andSelect: false");
        List<mo5.g> r101 = u();
        monitor-enter(r101);
        Iterator<T> r102 = u().iterator();     // Catch: Throwable -> L17
    L5:
        mo5.g r103 = null;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(mo5.h.a((mo5.g) r104), r100) == false) goto L5;
    L11:
        mo5.g r105 = (mo5.g) r104;     // Catch: Throwable -> L17
        if (r105 == null) goto L14;
        r103 = r105;
    L14:
        monitor-exit(r101);
        tt5.a.h("TtsAlbumViewModel", "findItemByToken, result: " + r103 + ", selected: false");
        return r103;
    L10:
        r104 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final mo5.g s(mo5.g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        mo5.g r101 = this.f239473i;
        if (r101 != null) goto L7;
        tt5.a.h("TtsAlbumViewModel", "deselectItem, selectedItem is null, viewModel: " + r100);
        return null;
    L7:
        if (Intrinsics.areEqual(r101.a(), r100.a()) == false) goto L9;
        mo5.g r102 = r101;
    L10:
        if (r102 == null) goto L13;
        tt5.a.h("TtsAlbumViewModel", "deselectItem, deselect viewModel: " + r102);
        r102.pause();
        r102.d("TtsAlbumViewModel-deselect", null);
        r102.q();
        this.f239473i = null;
        y(r101, null);
        return r102;
    L13:
        tt5.a.h("TtsAlbumViewModel", "deselectItem, target is not selected, selected: " + this.f239473i + ", target: " + r100);
        return null;
    L9:
        r102 = null;
        goto L10
    }

    public final void x(TtsResult r100) {
        if (r100 != null) goto L6;
        tt5.a.k("TtsAlbumViewModel", "notifyResult, result is null.");
        return;
    L6:
        tt5.a.h("TtsAlbumViewModel", "notifyResult, result: " + r100);
        Iterator<mo5.c> r101 = v().iterator();
    L8:
        if (r101.hasNext() == false) goto L17;
        mo5.c r102 = r101.next();
        tt5.a.h("TtsAlbumViewModel", "notifyResult, eachHandler: " + r102);
        if (r102 == null) goto L8;
        r102.a(r100);
        tt5.a.h("TtsAlbumViewModel", "notifyResult, handler: " + r102 + ", result: true");
        return;
    }

    public static final List r(TtsAlbumViewModel r100, List r101) {
        r100.getClass();
        if (r101.isEmpty() == true) goto L34;
        List<mo5.g> r102 = r100.u();
        monitor-enter(r102);
        List<mo5.g> r103 = r100.u();     // Catch: Throwable -> L22
        HashSet r104 = new HashSet();     // Catch: Throwable -> L22
        Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L22
    L9:
        if (r105.hasNext() == false) goto L11;
        r104.add(((mo5.g) r105.next()).a());     // Catch: Throwable -> L22
        goto L9
    L11:
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L22
        Iterator r107 = r101.iterator();     // Catch: Throwable -> L22
    L13:
        if (r107.hasNext() == false) goto L18;
        mo5.g r108 = (mo5.g) r107.next();     // Catch: Throwable -> L22
        if (r104.add(r108.a()) == true) goto L16;
        tt5.a.k("TtsAlbumViewModel", "addItemListSync, viewModel existed: " + r108);     // Catch: Throwable -> L22
        goto L13
    L16:
        tt5.a.h("TtsAlbumViewModel", "addItemListSync, viewModel: " + r108 + ", atFirst: false");     // Catch: Throwable -> L22
        r106.add(r108);     // Catch: Throwable -> L22
        goto L13
    L18:
        r100.u().addAll(r106);     // Catch: Throwable -> L22
        monitor-exit(r102);
        return r106;
    L22:
        th = move-exception;
        throw th;
    L34:
        return CollectionsKt.emptyList();
    }

    public final void y(mo5.g r100, mo5.g r101) {
        if (r100 == null) goto L6;
        to5.a r102 = r100.m();
        if (r102 == null) goto L6;
        r102.a();
    L6:
        if (r101 == null) goto L10;
        to5.a r103 = r101.m();
        if (r103 == null) goto L10;
        r103.b();
    L10:
        if (r100 == null) goto L14;
        MutableLiveData r104 = r100.u();
        if (r104 == null) goto L14;
        r104.removeObserver(this.f239468d);
    L14:
        if (r101 == null) goto L18;
        MutableLiveData r105 = r101.u();
        if (r105 == null) goto L18;
        r105.observeForever(this.f239468d);
    L18:
        ((MutableLiveData) this.f239465a.getValue()).setValue(new mo5.i(r100, r101));
    }
}
