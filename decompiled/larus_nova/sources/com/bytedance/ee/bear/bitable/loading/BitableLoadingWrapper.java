package com.bytedance.ee.bear.bitable.loading;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.document.loading.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import du4.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableLoadingWrapper implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f214586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.bitable.loading.a> f214587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadingLayout.c f214588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadingLayout.b f214589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LoadingState f214590e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/loading/BitableLoadingWrapper$LoadingState;", "", "<init>", "(Ljava/lang/String;I)V", "INITIALIZED", "LOADING", "FAIL", "SUC", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadingState extends Enum<LoadingState> {
        public static final LoadingState FAIL = null;
        public static final LoadingState INITIALIZED = null;
        public static final LoadingState LOADING = null;
        public static final LoadingState SUC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadingState[] f214591a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f214592b = null;

        public static EnumEntries<LoadingState> getEntries() {
            return f214592b;
        }

        static {
            LoadingState r100 = new LoadingState("INITIALIZED", 0);
            INITIALIZED = r100;
            LoadingState r101 = new LoadingState("LOADING", 1);
            LOADING = r101;
            LoadingState r102 = new LoadingState("FAIL", 2);
            FAIL = r102;
            LoadingState r103 = new LoadingState("SUC", 3);
            SUC = r103;
            LoadingState[] r104 = {r100, r101, r102, r103};
            f214591a = r104;
            f214592b = EnumEntriesKt.enumEntries(r104);
        }

        public static LoadingState[] values() {
            return (LoadingState[]) f214591a.clone();
        }

        public static LoadingState valueOf(String r100) {
            return (LoadingState) r27.a.a(LoadingState.class, r100);
        }

        public LoadingState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f214593a = null;

        static {
            int[] r100 = new int[LoadingState.values().length];
            r100[LoadingState.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[LoadingState.LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[LoadingState.SUC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[LoadingState.FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f214593a = r100;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((com.bytedance.ee.bear.bitable.loading.a) r100).getLoadingType().ordinal()), Integer.valueOf(((com.bytedance.ee.bear.bitable.loading.a) r101).getLoadingType().ordinal()));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void show() {
    }

    @Override // com.bytedance.ee.bear.document.loading.d
    public final void b() {
        tt5.a.h("BitableLoadingWrapper", "BitableLoadingWrapper show >>");
        if (c(LoadingState.LOADING) == true) goto L5;
        return;
    L5:
        ArrayList r100 = (ArrayList) this.f214587b;
        if (r100.size() <= 1) goto L8;
        CollectionsKt.sortWith(r100, new c());
    L8:
        Iterator r101 = ((ArrayList) this.f214587b).iterator();
    L10:
        if (r101.hasNext() == false) goto L14;
        com.bytedance.ee.bear.bitable.loading.a r102 = (com.bytedance.ee.bear.bitable.loading.a) r101.next();
        r102.aS(LoadingState.LOADING);
        r102.ZX();
        ELoadingType r103 = r102.getLoadingType();
        Map<ELoadingType, du4.d> r104 = e.f470041a;
        du4.d r105 = e.f470041a.get(r103);
        if (r105 == null) goto L10;
        r102.TQ(r105.a(this.f214586a));
        goto L10
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void hide() {
        tt5.a.h("BitableLoadingWrapper", "BitableLoadingWrapper hide >> success");
        if (c(LoadingState.SUC) == true) goto L5;
        return;
    L5:
        Iterator r100 = ((ArrayList) this.f214587b).iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        com.bytedance.ee.bear.bitable.loading.a r101 = (com.bytedance.ee.bear.bitable.loading.a) r100.next();
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.old.form.view.accelerate.v1") == true) goto L11;
        r101.aS(LoadingState.SUC);
        r101.ZX();
        goto L7
    L11:
        if (r101.A30() == true) goto L7;
        r101.Nr();
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.loading.d
    public final void reset() {
        tt5.a.h("BitableLoadingWrapper", "BitableLoadingWrapper reset >> reset");
        if (c(LoadingState.INITIALIZED) == true) goto L5;
        return;
    L5:
        Iterator r100 = ((ArrayList) this.f214587b).iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        KeyEvent.Callback r101 = ((com.bytedance.ee.bear.bitable.loading.a) r100.next()).getLoadingView();
        if ((r101 instanceof com.bytedance.ee.bear.document.loading.c) == false) goto L7;
        com.bytedance.ee.bear.document.loading.c r102 = (com.bytedance.ee.bear.document.loading.c) r101;
        r102.setOnRetryListener(null);
        r102.setOnBackSourceDocListener(null);
        goto L7
    }

    public final Context getContext() {
        return this.f214586a;
    }

    public BitableLoadingWrapper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f214586a = r100;
        tt5.a.h("BitableLoadingWrapper", "BitableLoadingWrapper init");
        this.f214587b = new ArrayList();
        this.f214590e = LoadingState.INITIALIZED;
    }

    public final boolean c(LoadingState r100) {
        LoadingState r101 = this.f214590e;
        int r102 = b.f214593a[r101.ordinal()];
        boolean r103 = true;
        if (r102 == 1) goto L25;
        if (r102 == 2) goto L25;
        if (r102 == 3) goto L20;
        if (r102 != 4) goto L18;
        if (r100 == LoadingState.INITIALIZED) goto L29;
        if (r100 == LoadingState.LOADING) goto L29;
        if (r100 == LoadingState.SUC) goto L29;
    L27:
        r103 = false;
    L29:
        if (r103 == true) goto L31;
        tt5.a.h("BitableLoadingWrapper", "error while transfer from " + r101.name() + " to " + r100.name());
    L32:
        return r103;
    L31:
        this.f214590e = r100;
        tt5.a.h("BitableLoadingWrapper", "change from " + r101.name() + " to " + this.f214590e.name());
        goto L32
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        if (r100 == LoadingState.FAIL) goto L29;
        if (r100 != LoadingState.INITIALIZED) goto L27;
    L25:
        if (this.f214590e.ordinal() > r100.ordinal()) goto L27;
        goto L27
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void setOnBackSourceDocListener(LoadingLayout.b r100) {
        this.f214589d = r100;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void setOnRetryListener(LoadingLayout.c r100) {
        this.f214588c = r100;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void a(int r100, String r101) {
        tt5.a.h("BitableLoadingWrapper", "BitableLoadingWrapper fail >> errorCode: " + r100 + " errMsg :" + r101);
        if (c(LoadingState.FAIL) == true) goto L5;
        return;
    L5:
        Iterator r102 = ((ArrayList) this.f214587b).iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        com.bytedance.ee.bear.bitable.loading.a r103 = (com.bytedance.ee.bear.bitable.loading.a) r102.next();
        r103.aS(LoadingState.FAIL);
        r103.ZX();
        du4.d r104 = e.f470041a.get(r103.getLoadingType());
        if (r104 == null) goto L7;
        View r105 = r104.b(this.f214586a, r100, r101);
        if (r105 != null) goto L13;
        r105 = null;
    L16:
        r103.xr(r105);
        goto L7
    L13:
        if ((r105 instanceof LoadingLayout) == false) goto L16;
        LoadingLayout r106 = (LoadingLayout) r105;
        r106.setOnRetryListener(this.f214588c);
        r106.setOnBackSourceDocListener(this.f214589d);
        goto L16
    }
}
