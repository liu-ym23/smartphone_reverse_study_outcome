package com.bytedance.creativex.mediaimport.preview.internal.main;

import androidx.lifecycle.LiveData;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import com.bytedance.creativex.mediaimport.repository.api.IGroupItem;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import com.larus.photopicker.impl.ui.m1;
import com.larus.utils.logger.FLogger;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class MaterialAndPreviewCombiner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<si4.a> f203456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ti4.v<ki4.r, IFolderItem>> f203457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ei4.c<ki4.r>> f203458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f203459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f203460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f203461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public State f203462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f203463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f203464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f203465j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/creativex/mediaimport/preview/internal/main/MaterialAndPreviewCombiner$State;", "", "<init>", "(Ljava/lang/String;I)V", "PREVIEW_SHOW", "MATERIAL_LIST_SHOW", "HIDE", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State HIDE = null;
        public static final State MATERIAL_LIST_SHOW = null;
        public static final State PREVIEW_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f203466a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f203467b = null;

        public static EnumEntries<State> getEntries() {
            return f203467b;
        }

        static {
            State r100 = new State("PREVIEW_SHOW", 0);
            PREVIEW_SHOW = r100;
            State r101 = new State("MATERIAL_LIST_SHOW", 1);
            MATERIAL_LIST_SHOW = r101;
            State r102 = new State("HIDE", 2);
            HIDE = r102;
            State[] r103 = {r100, r101, r102};
            f203466a = r103;
            f203467b = EnumEntriesKt.enumEntries(r103);
        }

        public static State[] values() {
            return (State[]) f203466a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f203468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f203469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f203470c;

        public a() {
            this.f203468a = false;
            this.f203469b = true;
            this.f203470c = true;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f203471a = null;

        static {
            int[] r100 = new int[State.values().length];
            r100[State.MATERIAL_LIST_SHOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[State.HIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f203471a = r100;
        }
    }

    public final void b() {
        if (this.f203462g == State.PREVIEW_SHOW) goto L5;
        return;
    L5:
        g(State.MATERIAL_LIST_SHOW, false);
    }

    public final si4.a c() {
        return (si4.a) this.f203464i.getValue();
    }

    public final void d() {
        g(State.HIDE, false);
    }

    public final boolean e() {
        if (this.f203462g != State.PREVIEW_SHOW) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f() {
        g(State.MATERIAL_LIST_SHOW, false);
    }

    public final boolean a(int r100) {
        FLogger.f375446a.i("effect_platform", "consumeExternalOnKeyDownEvent keyCode=" + r100 + ", state:" + this.f203462g);
        if (r100 == 4) goto L5;
    L8:
        return false;
    L5:
        if (this.f203462g != State.PREVIEW_SHOW) goto L8;
        g(State.MATERIAL_LIST_SHOW, false);
        return true;
    }

    public final void g(State r100, boolean r101) {
        State r102 = this.f203462g;
        FLogger.f375446a.d("effect_platform", "transformState originState=" + r102 + " toState=" + r100 + " fromGesture=" + r101);
        if (r102 != r100) goto L5;
        return;
    L5:
        int r103 = b.f203471a[r100.ordinal()];
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L11;
    L27:
        this.f203462g = r100;
        if (this.f203460e.f203468a == true) goto L30;
        State r104 = State.PREVIEW_SHOW;
        return;
    L30:
        State r105 = State.PREVIEW_SHOW;
        return;
    L11:
        if (r102 != State.PREVIEW_SHOW) goto L17;
        ei4.c r106 = (ei4.c) this.f203465j.getValue();
        if (r106 == null) goto L15;
        r106.exit();
    L15:
        c().hide();
    L17:
        if (r102 != State.MATERIAL_LIST_SHOW) goto L27;
        if (r101 == true) goto L27;
        c().hide();
        goto L27
    L21:
        if (r102 != State.PREVIEW_SHOW) goto L26;
        if (r101 == true) goto L27;
        ei4.c r107 = (ei4.c) this.f203465j.getValue();
        if (r107 == null) goto L27;
        r107.exit();
        goto L27
    L26:
        c().show();
        goto L27
    }

    public MaterialAndPreviewCombiner(com.larus.photopicker.impl.ui.q0 r100, com.larus.photopicker.impl.ui.b1 r101, m1 r102) {
        Intrinsics.checkNotNullParameter(r100, "materialSelectViewProvider");
        Intrinsics.checkNotNullParameter(r101, "viewModelProvider");
        this.f203456a = r100;
        this.f203457b = r101;
        this.f203458c = r102;
        this.f203459d = LazyKt.lazy(new com.bytedance.creativex.mediaimport.preview.internal.main.a(this));
        this.f203460e = new a();
        this.f203461f = new CompositeDisposable();
        this.f203462g = State.HIDE;
        this.f203463h = LazyKt.lazy(new com.bytedance.creativex.mediaimport.preview.internal.main.b(this));
        this.f203464i = LazyKt.lazy(new c(this));
        this.f203465j = LazyKt.lazy(new d(this));
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.bytedance.creativex.mediaimport.preview.internal.main.h] */
    public final void h(ki4.r r110, int r111, MaterialSelectedState r112, final ki4.a0 r113) {
        if (this.f203458c == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return;
    L8:
        if (((ei4.c) this.f203465j.getValue()) != null) goto L10;
        return;
    L10:
        if (r113 == null) goto L38;
        ti4.p r101 = ((ti4.v) this.f203463h.getValue()).f();
        if (r101 == null) goto L18;
        LiveData r102 = r101.getSelectedFolder();
        if (r102 == null) goto L18;
        Pair r103 = (Pair) r102.getValue();
        if (r103 == null) goto L18;
        IFolderItem r104 = (IFolderItem) r103.getFirst();
    L20:
        if (this.f203460e.f203469b == false) goto L29;
        if (r104 == null) goto L28;
        List r105 = IFolderItem.a.a(r104, r113, 2);
        if (r105 == null) goto L28;
        IGroupItem r106 = (IGroupItem) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L28;
        List<ki4.r> r107 = r106.x();
        if (r107 == null) goto L28;
    L43:
        List<ki4.r> r108 = r107;
    L45:
        if (r108 == null) goto L61;
        boolean r109 = this.f203460e.f203469b;
        if (r109 == true) goto L49;
        ki4.a0 r114 = null;
    L50:
        if (r113 == null) goto L53;
        if (r109 == true) goto L53;
        r111 = r108.indexOf(r110);
    L53:
        int r115 = r111;
        ?? r116 = new h(r113, this);
        ei4.c r117 = (ei4.c) this.f203465j.getValue();
        if (r117 != null) goto L56;
        return;
    L56:
        if (r117.b(new ei4.d(r110, r108, r115, r112, r114, r116)) == false) goto L63;
        g(State.PREVIEW_SHOW, false);
        return;
    L63:
        return;
    L49:
        r114 = r113;
        goto L50
    L61:
        return;
    L28:
        r107 = CollectionsKt.emptyList();
        goto L43
    L29:
        if (r104 == null) goto L37;
        List r118 = IFolderItem.a.a(r104, BuiltInMaterialType.IMAGE, 2);
        if (r118 == null) goto L37;
        IGroupItem r119 = (IGroupItem) CollectionsKt.firstOrNull(r118);
        if (r119 == null) goto L37;
        r107 = r119.x();
        if (r107 != null) goto L43;
    L37:
        r107 = CollectionsKt.emptyList();
    L18:
        r104 = null;
        goto L20
    L38:
        ti4.m r120 = ((ti4.v) this.f203463h.getValue()).b();
        if (r120 == null) goto L44;
        LiveData r121 = r120.getSelectedMaterials();
        if (r121 == null) goto L44;
        r107 = (List) r121.getValue();
    L44:
        r108 = null;
        goto L45
    L5:
        r100 = false;
        goto L6
    }
}
