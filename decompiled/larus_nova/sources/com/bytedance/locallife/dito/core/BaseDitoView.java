package com.bytedance.locallife.dito.core;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.amap.api.col.s.ce;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.baseview.RoundFrameLayout;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.DitoStyle;
import com.bytedance.locallife.dito.log.error.STYLE_BIND_ERROR;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001|B'\b\u0007\u0012\u0006\u0010v\u001a\u00020u\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010w\u0012\b\b\u0002\u0010y\u001a\u00020\t¢\u0006\u0004\bz\u0010{J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R.\u0010?\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010G\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010K\u001a\u0004\u0018\u00010@8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bH\u0010B\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\"\u0010O\u001a\u00020.8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bL\u00100\u001a\u0004\bM\u00102\"\u0004\bN\u00104R\"\u0010S\u001a\u00020.8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bP\u00100\u001a\u0004\bQ\u00102\"\u0004\bR\u00104R*\u0010[\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR!\u0010b\u001a\b\u0012\u0004\u0012\u00020]0\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR#\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010c0\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010_\u001a\u0004\be\u0010aR(\u0010l\u001a\u0004\u0018\u00010&2\b\u0010g\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0011\u0010n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bm\u0010\"R$\u0010o\u001a\u0004\u0018\u00018\u00008F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006}"}, d2 = {"Lcom/bytedance/locallife/dito/core/BaseDitoView;", "Lcom/bytedance/locallife/dito/model/BaseDitoModel;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/locallife/dito/baseview/RoundFrameLayout;", "Lcom/bytedance/locallife/dito/core/IDitoView;", "Lbq6/b;", "Landroid/view/View$OnLayoutChangeListener;", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "", "getPosition", "Lkotlin/Pair;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getStickViewPair", "getBackgroundContainer", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;", "ditoViewModel", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;", "getDitoViewModel", "()Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;", "setDitoViewModel", "(Lcom/bytedance/locallife/dito/core/viewmodel/DitoViewModel;)V", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter;", "d", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter;", "getDataCenter", "()Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter;", "setDataCenter", "(Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter;)V", "dataCenter", "f", "I", "getHolderPosition", "()I", "setHolderPosition", "(I)V", "holderPosition", "", RXScreenCaptureService.KEY_INDEX, "J", "getMStartTimestamps", "()J", "setMStartTimestamps", "(J)V", "mStartTimestamps", "", ce.f26395j, "Z", "getAutoDestroy", "()Z", "setAutoDestroy", "(Z)V", "autoDestroy", "", "", "", ce.f26396k, "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "params", "Lcom/bytedance/locallife/dito/core/g0;", "m", "Lcom/bytedance/locallife/dito/core/g0;", "getPresetWidth", "()Lcom/bytedance/locallife/dito/core/g0;", "setPresetWidth", "(Lcom/bytedance/locallife/dito/core/g0;)V", "presetWidth", OfficeSDKRequestTag.KEY_NEW_USER, "getPresetHeight", "setPresetHeight", "presetHeight", "o", "getNeedUsePresetSize", "setNeedUsePresetSize", "needUsePresetSize", "p", "getHasSetPresetSize", "setHasSetPresetSize", "hasSetPresetSize", "", "q", "Ljava/util/List;", "getParentMargin", "()Ljava/util/List;", "setParentMargin", "(Ljava/util/List;)V", "parentMargin", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/locallife/dito/data/u;", "r", "Lkotlin/Lazy;", "getStickScrollObserver", "()Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "stickScrollObserver", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$g;", "u", "getStickStateObserver", "stickStateObserver", "<set-?>", "x", "Ljava/lang/Long;", "getFcpTs", "()Ljava/lang/Long;", "fcpTs", "getTreeNodePosition", "treeNodePosition", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/locallife/dito/model/BaseDitoModel;", "getModel", "()Lcom/bytedance/locallife/dito/model/BaseDitoModel;", "setModel", "(Lcom/bytedance/locallife/dito/model/BaseDitoModel;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseDitoView<T extends BaseDitoModel<?>> extends RoundFrameLayout implements IDitoView, bq6.b, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DitoDataCenter f257749d;
    public DitoViewModel ditoViewModel;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseDitoModel<?> f257750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f257751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f257752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LifecycleRegistry f257753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f257754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f257755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, Object> f257756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f257757l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g0 f257758m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g0 f257759n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f257760o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f257761p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<Integer> f257762q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f257763r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Observer<com.bytedance.locallife.dito.data.u> f257764s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f257765t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f257766u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f257767v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f257768w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Long f257769x;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseDitoView<T> f257770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f257771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Drawable f257772c;

        public b(BaseDitoView<T> r100, View r101, Drawable r102) {
            this.f257770a = r100;
            this.f257771b = r101;
            this.f257772c = r102;
        }

        public final void a() {
            rq6.a r100 = rq6.a.f538927a;
            StringBuilder r101 = new StringBuilder("---backgroundResetRunnable:");
            BaseDitoModel r102 = this.f257770a.getModel();
            if (r102 == null) goto L7;
            com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
            if (r103 == null) goto L7;
            String r104 = r103.f258222b;
        L8:
            r101.append(r104);
            r100.c("dito_component", r101.toString());
            this.f257771b.setBackground(this.f257772c);
            return;
        L7:
            r104 = null;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseDitoView<T> f257773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f257774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f257775c;

        public c(BaseDitoView<T> r100, Drawable r101, long r102) {
            this.f257773a = r100;
            this.f257774b = r101;
            this.f257775c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f257773a.M(this.f257774b, this.f257775c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseDitoView<T> f257777a;

        public d(BaseDitoView<T> r100) {
            this.f257777a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.locallife.dito.data.t r101 = (com.bytedance.locallife.dito.data.t) r100;
            if (this.f257777a.getAutoDestroy() == false) goto L6;
            this.f257777a.onDestroy();
            return;
        }
    }

    public static final class e<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseDitoView<T> f257778a;

        public e(BaseDitoView<T> r100) {
            this.f257778a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            this.f257778a.Z();
        }
    }

    static {
    }

    public BaseDitoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseDitoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void H(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
    }

    public View getBackgroundContainer() {
        return this;
    }

    public Pair<View, ViewGroup> getStickViewPair() {
        return null;
    }

    public final void setModel(T r100) {
    }

    private final Observer<com.bytedance.locallife.dito.data.u> getStickScrollObserver() {
        return (Observer) this.f257763r.getValue();
    }

    private final Observer<DitoDataCenter.g> getStickStateObserver() {
        return (Observer) this.f257766u.getValue();
    }

    public final void F() {
        if (this.f257757l == false) goto L11;
        boolean r100 = com.bytedance.locallife.dito.utils.n.f258708a;
        Iterator r101 = com.bytedance.locallife.dito.utils.n.e(this).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((View) r101.next()).removeOnLayoutChangeListener(this);
        goto L6
    L8:
        this.f257757l = false;
        return;
    }

    public boolean L() {
        boolean r100 = com.bytedance.locallife.dito.utils.n.f258708a;
        Iterator r101 = com.bytedance.locallife.dito.utils.n.e(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        View r103 = (View) r102;
        if (r103.getWidth() > 0) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L4;
    L14:
        if (r102 == null) goto L22;
        return true;
    L22:
        return false;
    L8:
        if (r103.getHeight() <= 0) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    public final boolean V() {
        if (this.f257760o == true) goto L5;
        return false;
    L5:
        if (this.f257758m == null) goto L7;
    L10:
        boolean r100 = true;
    L11:
        if (r100 == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (this.f257759n != null) goto L10;
        r100 = false;
        goto L11
    }

    public final DitoDataCenter getDataCenter() {
        DitoDataCenter r100 = this.f257749d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
        return null;
    }

    public final DitoViewModel getDitoViewModel() {
        DitoViewModel r100 = this.ditoViewModel;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("ditoViewModel");
        return null;
    }

    public final T getModel() {
        T r100 = (T) this.f257750e;
        if ((r100 instanceof BaseDitoModel) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    public void J() {
        getDataCenter().j().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("completeShow: tag = ");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L7;
        String r104 = r103.f258222b;
    L8:
        r101.append(r104);
        r100.a("dito_component", r101.toString());
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final String K() {
        BaseDitoModel r100 = getModel();
        if (r100 == null) goto L8;
        com.bytedance.locallife.dito.data.m r101 = r100.f258493b;
        if (r101 == null) goto L8;
        String r102 = r101.f258222b;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    public final boolean O() {
        Pair<View, ViewGroup> r100 = getStickViewPair();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getFirst() != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (r100.getSecond() == null) goto L9;
        r101 = true;
        goto L10
    }

    public void P() {
        getDataCenter().h().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("onBindData: tag = ");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L7;
        String r104 = r103.f258222b;
    L8:
        r101.append(r104);
        r101.append(", pos: ");
        r101.append(this.f257751f);
        r100.a("dito_component", r101.toString());
        Z();
        return;
    L7:
        r104 = null;
        goto L8
    }

    public void Q() {
        getDataCenter().o().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("onPreload: tag = ");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L7;
        String r104 = r103.f258222b;
    L8:
        r101.append(r104);
        r100.a("dito_component", r101.toString());
        return;
    L7:
        r104 = null;
        goto L8
    }

    public void S() {
        getDataCenter().t().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("onUnBindData: tag = ");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L7;
        String r104 = r103.f258222b;
    L8:
        r101.append(r104);
        r101.append(", pos: ");
        r101.append(this.f257751f);
        r100.a("dito_component", r101.toString());
        return;
    L7:
        r104 = null;
        goto L8
    }

    public void Z() {
        int r100 = getDitoViewModel().f258035a.ca0(this);
        Dito r101 = Dito.f257280a;
        ViewGroup r102 = null;
        if (com.bytedance.locallife.dito.utils.l.k().getFixNegativeBottom() == true) goto L5;
    L59:
        rq6.a r103 = rq6.a.f538927a;
        StringBuilder r104 = new StringBuilder("updateCustomVisibility, ");
        r104.append(getVisibility());
        r104.append(" -> ");
        r104.append(r100);
        r104.append(", parent: ");
        Object r105 = getParent();
        if ((r105 instanceof View) == false) goto L62;
        View r106 = (View) r105;
    L63:
        if (r106 == null) goto L65;
        String r107 = Integer.valueOf(r106.getVisibility()).toString();
    L66:
        r104.append(r107);
        r104.append(" -> ");
        r104.append(r100);
        r104.append(", tag = ");
        BaseDitoModel r108 = getModel();
        if (r108 == null) goto L71;
        com.bytedance.locallife.dito.data.m r109 = r108.f258493b;
        if (r109 == null) goto L71;
        String r110 = r109.f258222b;
    L72:
        r104.append(r110);
        r103.a("dito_component", r104.toString());
        setVisibility(r100);
        ViewParent r111 = getParent();
        if ((r111 instanceof ViewGroup) == false) goto L75;
        r102 = (ViewGroup) r111;
    L75:
        if (r102 == null) goto L79;
        r102.setVisibility(r100);
        return;
    L79:
        return;
    L71:
        r110 = null;
        goto L72
    L65:
        r107 = null;
        goto L66
    L62:
        r106 = null;
        goto L63
    L5:
        if (getVisibility() != 8) goto L34;
        if (r100 != 0) goto L34;
        List<Integer> r112 = this.f257762q;
        if (r112 == null) goto L34;
        List r113 = CollectionsKt.toList(r112);
        if (r113 != null) goto L12;
        r113 = CollectionsKt.emptyList();
    L12:
        this.f257762q = null;
        if (r113.size() != 4) goto L59;
        ViewParent r114 = getParent();
        if ((r114 instanceof ViewGroup) == false) goto L17;
        ViewGroup r115 = (ViewGroup) r114;
    L18:
        if (r115 == null) goto L20;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
    L22:
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
    L25:
        if (r117 == null) goto L59;
        r117.setMargins(((Number) ListProtector.get(r113, 0)).intValue(), ((Number) ListProtector.get(r113, 1)).intValue(), ((Number) ListProtector.get(r113, 2)).intValue(), ((Number) ListProtector.get(r113, 3)).intValue());
        ViewParent r118 = getParent();
        if ((r118 instanceof ViewGroup) == false) goto L29;
        ViewGroup r119 = (ViewGroup) r118;
    L30:
        if (r119 == null) goto L59;
        r119.setLayoutParams(r117);
        goto L59
    L29:
        r119 = null;
        goto L30
    L24:
        r117 = null;
        goto L25
    L20:
        r116 = null;
        goto L22
    L17:
        r115 = null;
    L34:
        if (getVisibility() != 0) goto L59;
        if (r100 != 8) goto L59;
        if (com.bytedance.locallife.dito.utils.l.k().getFixSimpleHeadInfo() == true) goto L39;
    L40:
        ViewParent r120 = getParent();
        if ((r120 instanceof ViewGroup) == false) goto L43;
        ViewGroup r121 = (ViewGroup) r120;
    L44:
        if (r121 == null) goto L46;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L48:
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
    L51:
        if (r123 == null) goto L59;
        this.f257762q = CollectionsKt.listOf(new Integer[]{Integer.valueOf(r123.leftMargin), Integer.valueOf(r123.topMargin), Integer.valueOf(r123.rightMargin), Integer.valueOf(r123.bottomMargin)});
        r123.setMargins(0, 0, 0, 0);
        ViewParent r124 = getParent();
        if ((r124 instanceof ViewGroup) == false) goto L55;
        ViewGroup r125 = (ViewGroup) r124;
    L56:
        if (r125 == null) goto L59;
        r125.setLayoutParams(r123);
        goto L59
    L55:
        r125 = null;
        goto L56
    L50:
        r123 = null;
        goto L51
    L46:
        r122 = null;
        goto L48
    L43:
        r121 = null;
        goto L44
    L39:
        if (Intrinsics.areEqual(K(), "simple_head_info") == true) goto L59;
        goto L40
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final int getPosition() {
        BaseDitoModel r100 = getModel();
        if (r100 == null) goto L20;
        com.bytedance.locallife.dito.data.m r101 = r100.f258493b;
        if (r101 == null) goto L23;
        com.bytedance.locallife.dito.data.m r102 = r101.f258223c;
        if (r102 == null) goto L24;
        List<com.bytedance.locallife.dito.data.m> r103 = r102.f258224d;
        if (r103 == null) goto L25;
        IntRange r104 = CollectionsKt.getIndices(r103);
        if (r104 == null) goto L28;
        int r105 = r104.getFirst();
        int r106 = r104.getLast();
        if (r105 <= r106) goto L16;
        return 0;
    L16:
        if (Intrinsics.areEqual(ListProtector.get(r101.f258223c.f258224d, r105), r101) == true) goto L27;
        if (r105 == r106) goto L29;
        r105 = r105 + 1;
        goto L16
    L29:
        return 0;
    L27:
        return r105;
    L28:
        return 0;
    L25:
        return 0;
    L24:
        return 0;
    L23:
        return 0;
    L20:
        return 0;
    }

    public final int getTreeNodePosition() {
        return getPosition();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        onResume();
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("---onAttachedToWindow:");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L7;
        String r104 = r103.f258222b;
    L8:
        r101.append(r104);
        r100.a("dito_component", r101.toString());
        return;
    L7:
        r104 = null;
        goto L8
    }

    public void onCreate() {
        this.f257754i = SystemClock.elapsedRealtime();
        getDataCenter().k().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("onCreate: tag = ");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L7;
        String r104 = r103.f258222b;
    L8:
        r101.append(r104);
        r100.a("dito_component", r101.toString());
        this.f257753h.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f257753h.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.f257753h.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        getDataCenter().h0().observe(this, new d(this));
        getDataCenter().L0().observe(this, new e(this));
        return;
    L7:
        r104 = null;
        goto L8
    }

    public void onDestroy() {
        getDataCenter().l().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("onDestroy: tag = ");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L7;
        String r104 = r103.f258222b;
    L8:
        r101.append(r104);
        r100.a("dito_component", r101.toString());
        this.f257753h.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.f257753h.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.f257753h.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f257768w == null) goto L12;
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("---highlightDelayRunnable:");
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L9;
        com.bytedance.locallife.dito.data.m r103 = r102.f258493b;
        if (r103 == null) goto L9;
        String r104 = r103.f258222b;
    L10:
        r101.append(r104);
        r100.a("dito_component", r101.toString());
        removeCallbacks(this.f257768w);
        this.f257768w = null;
    L9:
        r104 = null;
    L12:
        if (this.f257767v == null) goto L20;
        rq6.a r105 = rq6.a.f538927a;
        StringBuilder r106 = new StringBuilder("---backgroundResetRunnable:");
        BaseDitoModel r107 = getModel();
        if (r107 == null) goto L18;
        com.bytedance.locallife.dito.data.m r108 = r107.f258493b;
        if (r108 == null) goto L18;
        String r109 = r108.f258222b;
    L19:
        r106.append(r109);
        r105.a("dito_component", r106.toString());
        removeCallbacks(this.f257767v);
        this.f257767v = null;
    L18:
        r109 = null;
    L20:
        onPause();
    }

    public void onPause() {
        BaseDitoModel r100 = getModel();
        if (r100 == null) goto L5;
        com.bytedance.locallife.dito.model.b r101 = r100.f258498g;
    L6:
        if (r101 == null) goto L9;
        r101.f258507g = getHeight();
    L9:
        getDataCenter().n().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r102 = rq6.a.f538927a;
        StringBuilder r103 = new StringBuilder("onPause: tag = ");
        BaseDitoModel r104 = getModel();
        if (r104 == null) goto L14;
        com.bytedance.locallife.dito.data.m r105 = r104.f258493b;
        if (r105 == null) goto L14;
        String r106 = r105.f258222b;
    L15:
        r103.append(r106);
        r102.a("dito_component", r103.toString());
        BaseDitoModel r107 = getModel();
        if (r107 == null) goto L22;
        DitoNode r108 = r107.f258493b.f258221a;
        if (r108 == null) goto L22;
        boolean r109 = true;
        if (r108.isStickNode() != true) goto L22;
    L23:
        if (r109 == false) goto L25;
        post(new com.bytedance.locallife.dito.core.d(this));
    L25:
        F();
        this.f257769x = null;
        return;
    L22:
        r109 = false;
    L14:
        r106 = null;
        goto L15
    L5:
        r101 = null;
        goto L6
    }

    public void onResume() {
        getDataCenter().p().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r100 = rq6.a.f538927a;
        StringBuilder r101 = new StringBuilder("onResume: tag = ");
        BaseDitoModel r102 = getModel();
        String r103 = null;
        if (r102 == null) goto L7;
        com.bytedance.locallife.dito.data.m r104 = r102.f258493b;
        if (r104 == null) goto L7;
        String r105 = r104.f258222b;
    L8:
        r101.append(r105);
        r100.a("dito_component", r101.toString());
        BaseDitoModel r106 = getModel();
        if (r106 == null) goto L15;
        DitoNode r107 = r106.f258493b.f258221a;
        if (r107 == null) goto L15;
        if (r107.isStickNode() != true) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L19;
        post(new com.bytedance.locallife.dito.core.b(this));
        getDataCenter().C0().observe(this, getStickStateObserver());
    L19:
        if (V() == true) goto L21;
        return;
    L21:
        if (L() == false) goto L28;
        StringBuilder r109 = new StringBuilder("====> preset listener set but child has size,  : tag = ");
        BaseDitoModel r110 = getModel();
        if (r110 == null) goto L27;
        com.bytedance.locallife.dito.data.m r111 = r110.f258493b;
        if (r111 == null) goto L27;
        r103 = r111.f258222b;
    L27:
        r109.append(r103);
        r100.d("dito_component", r109.toString());
        G(true);
        return;
    L28:
        StringBuilder r112 = new StringBuilder("====> preset listener set : tag = ");
        BaseDitoModel r113 = getModel();
        if (r113 == null) goto L33;
        com.bytedance.locallife.dito.data.m r114 = r113.f258493b;
        if (r114 == null) goto L33;
        String r115 = r114.f258222b;
    L34:
        r112.append(r115);
        r100.a("dito_component", r112.toString());
        boolean r116 = com.bytedance.locallife.dito.utils.n.f258708a;
        List r117 = com.bytedance.locallife.dito.utils.n.e(this);
        if ((!r117.isEmpty()) == true) goto L38;
        r117 = null;
    L38:
        if (r117 == null) goto L44;
        Iterator r118 = r117.iterator();
    L41:
        if (r118.hasNext() == false) goto L43;
        ((View) r118.next()).addOnLayoutChangeListener(this);
        goto L41
    L43:
        this.f257757l = true;
        Unit r119 = Unit.INSTANCE;
    L45:
        if (r119 != null) goto L56;
        rq6.a r120 = rq6.a.f538927a;
        StringBuilder r121 = new StringBuilder("====> preset listener set not container child,  : tag = ");
        BaseDitoModel r122 = getModel();
        if (r122 == null) goto L51;
        com.bytedance.locallife.dito.data.m r123 = r122.f258493b;
        if (r123 == null) goto L51;
        r103 = r123.f258222b;
    L51:
        r121.append(r103);
        r120.b("dito_component", r121.toString());
        return;
    L56:
        return;
    L44:
        r119 = null;
    L33:
        r115 = null;
    L15:
        r108 = false;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.locallife.dito.core.IDitoView
    public final DitoViewModel uP() {
        return getDitoViewModel();
    }

    public final boolean getAutoDestroy() {
        return this.f257755j;
    }

    public final Long getFcpTs() {
        return this.f257769x;
    }

    public final boolean getHasSetPresetSize() {
        return this.f257761p;
    }

    public final int getHolderPosition() {
        return this.f257751f;
    }

    @Override // com.bytedance.locallife.dito.core.DitoLifecycleOwner
    public LifecycleRegistry getLifecycleRegistry() {
        return this.f257753h;
    }

    public final long getMStartTimestamps() {
        return this.f257754i;
    }

    public final boolean getNeedUsePresetSize() {
        return this.f257760o;
    }

    public final Map<String, Object> getParams() {
        return this.f257756k;
    }

    public final List<Integer> getParentMargin() {
        return this.f257762q;
    }

    public final g0 getPresetHeight() {
        return this.f257759n;
    }

    public final g0 getPresetWidth() {
        return this.f257758m;
    }

    @Override // com.bytedance.locallife.dito.core.IDitoView
    public final BaseDitoModel<?> hm() {
        return this.f257750e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter$k] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.ViewGroup] */
    public static final DitoDataCenter.k C(BaseDitoView r100) {
        BaseDitoModel r101 = r100.getModel();
        Object r102 = null;
        if (r101 == null) goto L38;
        DitoNode r103 = r101.f258493b.f258221a;
        if (r103 == null) goto L38;
        BaseDitoModel r104 = r100.getModel();
        if (r104 == null) goto L11;
        String r105 = r104.f258493b.f258222b;
        if (r105 == null) goto L11;
    L12:
        String r106 = r105;
        if (r103.isChildViewStick() == false) goto L22;
        Pair<View, ViewGroup> r107 = r100.getStickViewPair();
        if (r107 == null) goto L17;
        View r108 = r107.getFirst();
    L18:
        if (r107 == null) goto L20;
        r102 = (ViewGroup) r107.getSecond();
    L20:
        r102 = new DitoDataCenter.k(r108, r102, r106, true, r100);
        goto L38
    L17:
        r108 = null;
        goto L18
    L22:
        if (r103.isComponentStick() == false) goto L25;
        r102 = new DitoDataCenter.k((View) CollectionsKt.firstOrNull(com.bytedance.locallife.dito.utils.n.e(r100)), null, r106, false, null);
        goto L38
    L25:
        if (r103.isStick() == false) goto L38;
        Pair<View, ViewGroup> r109 = r100.getStickViewPair();
        if (r109 == null) goto L29;
        View r110 = r109.getFirst();
    L30:
        if (r109 == null) goto L32;
        r102 = (ViewGroup) r109.getSecond();
    L32:
        ?? r111 = r102;
        if (r110 == null) goto L40;
        if (r111 == 0) goto L40;
        return new DitoDataCenter.k(r110, r111, r106, true, r100);
    L40:
        return new DitoDataCenter.k((View) CollectionsKt.firstOrNull(com.bytedance.locallife.dito.utils.n.e(r100)), null, r106, false, null);
    L29:
        r110 = null;
    L11:
        r105 = "";
    L38:
        return r102;
    }

    public static final /* synthetic */ Observer D(BaseDitoView r100) {
        return r100.getStickScrollObserver();
    }

    public void G(final boolean r100) {
        com.bytedance.locallife.dito.utils.j.o(getDitoViewModel(), new BaseDitoView$cancelPresetSizeSpecAndRelayoutIfNeed$1(r100, this));
    }

    public void T(int r100) {
        getDataCenter().q().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r101 = rq6.a.f538927a;
        StringBuilder r102 = new StringBuilder("onViewShow: showHeight = ");
        r102.append(r100);
        r102.append(" , tag = ");
        BaseDitoModel r103 = getModel();
        if (r103 == null) goto L7;
        com.bytedance.locallife.dito.data.m r104 = r103.f258493b;
        if (r104 == null) goto L7;
        String r105 = r104.f258222b;
    L8:
        r102.append(r105);
        r101.a("dito_component", r102.toString());
        return;
    L7:
        r105 = null;
        goto L8
    }

    public final void setAutoDestroy(boolean r100) {
        this.f257755j = r100;
    }

    public final void setDataCenter(DitoDataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f257749d = r100;
    }

    public final void setDitoViewModel(DitoViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ditoViewModel = r100;
    }

    public final void setHasSetPresetSize(boolean r100) {
        this.f257761p = r100;
    }

    public final void setHolderPosition(int r100) {
        this.f257751f = r100;
    }

    public final void setMStartTimestamps(long r100) {
        this.f257754i = r100;
    }

    public final void setNeedUsePresetSize(boolean r100) {
        this.f257760o = r100;
    }

    public final void setParams(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f257756k = r100;
    }

    public final void setParentMargin(List<Integer> r100) {
        this.f257762q = r100;
    }

    public final void setPresetHeight(g0 r100) {
        this.f257759n = r100;
    }

    public final void setPresetWidth(g0 r100) {
        this.f257758m = r100;
    }

    @Override // bq6.b
    public final void z(Object r100) {
        g0 r101 = null;
        this.f257758m = null;
        if (r100 == null) goto L5;
        r101 = new g0(r100);
    L5:
        this.f257759n = r101;
    }

    public final void E(BaseDitoModel<?> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        long r102 = System.currentTimeMillis();
        this.f257750e = r100;
        this.f257751f = r101;
        P();
        getDataCenter().i().setValue(new com.bytedance.locallife.dito.data.b(this, r100, this.f257756k));
        long r103 = System.currentTimeMillis() - r102;
        rq6.a.f538927a.a("dito_component", "bind: tag = " + r100.f258493b.f258222b + ", cost: " + r103 + " ms");
    }

    public final void M(Drawable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "highlightBg");
        rq6.a.f538927a.c("dito_component", "======= highLightSelf");
        View r102 = getBackgroundContainer();
        Drawable r103 = r102.getBackground();
        r102.setBackground(r100);
        b r104 = new b(this, r102, r103);
        this.f257767v = r104;
        postDelayed(r104, r101);
    }

    public void R(int r100, int r101) {
        BaseDitoModel r102 = getModel();
        if (r102 == null) goto L5;
        com.bytedance.locallife.dito.model.b r103 = r102.f258498g;
    L6:
        if (r103 == null) goto L10;
        r103.f258505e = r101;
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void W(DitoViewModel r100, BaseDitoModel<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        setDitoViewModel(r100);
        this.f257750e = r101;
        setDataCenter(getDitoViewModel().f258041g);
        onCreate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        Integer r100 = this.f257752g;
        DitoStyle r101 = null;
        if (r100 == null) goto L6;
        int r102 = r100.intValue();
    L29:
        if (r102 != 2) goto L33;
        super.onMeasure(r110, r111);
        return;
    L33:
        if (r102 != 1) goto L73;
        super.onMeasure(r110, r111);
        if (V() == true) goto L37;
    L70:
        this.f257761p = false;
        return;
    L37:
        if (L() == true) goto L70;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L57
        int r104 = View.MeasureSpec.getMode(r110);     // Catch: Throwable -> L57
        int r112 = View.MeasureSpec.getMode(r111);     // Catch: Throwable -> L57
        if (r104 != 1073741824) goto L43;
        if (r112 != 1073741824) goto L43;
        rq6.a.f538927a.d("dito_component", "onMeasure preset size useless, tag:".concat(K()));     // Catch: Throwable -> L57
        return;
    L43:
        if (r104 == 1073741824) goto L48;
        g0 r105 = this.f257758m;     // Catch: Throwable -> L57
        if (r105 == null) goto L47;
        int r106 = g0.a(r105, r110, r111);     // Catch: Throwable -> L57
    L49:
        if (r112 == 1073741824) goto L54;
        g0 r113 = this.f257759n;     // Catch: Throwable -> L57
        if (r113 == null) goto L53;
        int r107 = g0.a(r113, r110, r111);     // Catch: Throwable -> L57
    L55:
        rq6.a.f538927a.c("dito_component", "onMeasure use preset,width:" + r106 + ",height:" + r107 + ",node:" + K());     // Catch: Throwable -> L57
        setMeasuredDimension(r106, r107);     // Catch: Throwable -> L57
        this.f257761p = true;     // Catch: Throwable -> L57
        R(r106, r107);     // Catch: Throwable -> L57
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r108);
        if (r114 == null) goto L112;
        this.f257760o = false;
        DitoViewModel r109 = getDitoViewModel();
        STYLE_BIND_ERROR r115 = STYLE_BIND_ERROR.f258487a;
        String r116 = r114.getMessage();
        LinkedHashMap r117 = new LinkedHashMap();
        BaseDitoModel r118 = getModel();
        if (r118 == null) goto L69;
        com.bytedance.locallife.dito.data.m r119 = r118.f258493b;
        if (r119 == null) goto L69;
        DitoNode r120 = r119.f258221a;
        if (r120 == null) goto L69;
        r101 = r120.getStyle();
    L69:
        TuplesKt.to("style", r101);
        com.bytedance.locallife.dito.utils.j.j(r109, r115, r116, r117, r114, K());
        return;
    L112:
        return;
    L53:
        r107 = getMeasuredHeight();     // Catch: Throwable -> L57
        goto L55
    L54:
        r107 = getMeasuredHeight();     // Catch: Throwable -> L57
        goto L55
    L47:
        r106 = getMeasuredWidth();     // Catch: Throwable -> L57
        goto L49
    L48:
        r106 = getMeasuredWidth();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L59
    L73:
        if (V() == true) goto L75;
    L107:
        rq6.a.f538927a.c("dito_component", "onMeasure,node:" + K() + ",height:" + View.MeasureSpec.getSize(r111));
        this.f257761p = false;
        super.onMeasure(r110, r111);
        return;
    L75:
        if (L() == true) goto L107;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L95
        int r123 = View.MeasureSpec.getMode(r110);     // Catch: Throwable -> L95
        int r124 = View.MeasureSpec.getMode(r111);     // Catch: Throwable -> L95
        super.onMeasure(r110, r111);     // Catch: Throwable -> L95
        if (r123 != 1073741824) goto L81;
        if (r124 != 1073741824) goto L81;
        rq6.a.f538927a.d("dito_component", "onMeasure preset size useless, tag:".concat(K()));     // Catch: Throwable -> L95
        return;
    L81:
        if (r123 == 1073741824) goto L86;
        g0 r125 = this.f257758m;     // Catch: Throwable -> L95
        if (r125 == null) goto L85;
        int r126 = g0.a(r125, r110, r111);     // Catch: Throwable -> L95
    L87:
        if (r124 == 1073741824) goto L92;
        g0 r127 = this.f257759n;     // Catch: Throwable -> L95
        if (r127 == null) goto L91;
        int r128 = g0.a(r127, r110, r111);     // Catch: Throwable -> L95
    L93:
        rq6.a.f538927a.c("dito_component", "onMeasure use preset,width:" + r126 + ",height:" + r128 + ",node:" + K());     // Catch: Throwable -> L95
        setMeasuredDimension(r126, r128);     // Catch: Throwable -> L95
        this.f257761p = true;     // Catch: Throwable -> L95
        R(r126, r128);     // Catch: Throwable -> L95
        return;
    L91:
        r128 = getMeasuredHeight();     // Catch: Throwable -> L95
        goto L93
    L92:
        r128 = getMeasuredHeight();     // Catch: Throwable -> L95
        goto L93
    L85:
        r126 = getMeasuredWidth();     // Catch: Throwable -> L95
        goto L87
    L86:
        r126 = getMeasuredWidth();     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Throwable r130 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r130 == null) goto L107;
        this.f257760o = false;
        DitoViewModel r131 = getDitoViewModel();
        STYLE_BIND_ERROR r132 = STYLE_BIND_ERROR.f258487a;
        String r133 = r130.getMessage();
        LinkedHashMap r134 = new LinkedHashMap();
        BaseDitoModel r135 = getModel();
        if (r135 == null) goto L106;
        com.bytedance.locallife.dito.data.m r136 = r135.f258493b;
        if (r136 == null) goto L106;
        DitoNode r137 = r136.f258221a;
        if (r137 == null) goto L106;
        r101 = r137.getStyle();
    L106:
        TuplesKt.to("style", r101);
        com.bytedance.locallife.dito.utils.j.j(r131, r132, r133, r134, r130, K());
        goto L107
    L6:
        if (this.ditoViewModel == null) goto L27;
        Dito r138 = Dito.f257280a;
        com.bytedance.locallife.dito.config.j r139 = (com.bytedance.locallife.dito.config.j) Dito.a().a(com.bytedance.locallife.dito.config.j.class);
        if (r139 == null) goto L10;
        com.bytedance.locallife.dito.config.l r140 = r139.b(getDitoViewModel().f258038d);
    L11:
        if (r140 == null) goto L27;
        BaseDitoModel r141 = getModel();
        if (r141 == null) goto L15;
        String r142 = r141.f258493b.f258222b;
    L16:
        if (r142 == null) goto L25;
        List<String> r143 = r140.f257745b;
        if (r143 != null) goto L20;
    L22:
        boolean r144 = false;
    L23:
        if (r144 == false) goto L25;
        r102 = 0;
    L26:
        this.f257752g = Integer.valueOf(r102);
        goto L29
    L20:
        if (r143.contains(r142) != true) goto L22;
        r144 = true;
    L25:
        r102 = r140.f257744a;
        goto L26
    L15:
        r142 = null;
        goto L16
    L10:
        r140 = null;
    L27:
        r102 = 0;
        goto L29
    }

    public BaseDitoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f257751f = -1;
        this.f257753h = new LifecycleRegistry(this);
        this.f257755j = true;
        this.f257756k = new LinkedHashMap();
        this.f257760o = true;
        this.f257763r = LazyKt.lazy(new BaseDitoView$stickScrollObserver$2(this));
        this.f257765t = new Object();
        this.f257766u = LazyKt.lazy(new BaseDitoView$stickStateObserver$2(this));
    }

    public final void N(Drawable r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "highlightBg");
        rq6.a.f538927a.c("dito_component", "======= highLightSelf");
        if (r102 > 0) goto L5;
        M(r100, r101);
        return;
    L5:
        c r103 = new c(this, r100, r101);
        this.f257768w = r103;
        postDelayed(r103, r102);
    }

    public /* synthetic */ BaseDitoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.locallife.dito.baseview.RoundFrameLayout, android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        getDataCenter().r().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        rq6.a r104 = rq6.a.f538927a;
        StringBuilder r105 = new StringBuilder("onSizeChanged: tag = ");
        BaseDitoModel r106 = getModel();
        if (r106 == null) goto L7;
        com.bytedance.locallife.dito.data.m r107 = r106.f258493b;
        if (r107 == null) goto L7;
        String r108 = r107.f258222b;
    L8:
        r105.append(r108);
        r105.append(" , height = ");
        r105.append(r101);
        r104.a("dito_component", r105.toString());
        return;
    L7:
        r108 = null;
        goto L8
    }

    @Override // com.bytedance.locallife.dito.baseview.RoundFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f257769x == null) goto L5;
        return;
    L5:
        if ((r104 - r102) > getMinimumHeight()) goto L7;
        return;
    L7:
        if ((r103 - r101) <= getMinimumWidth()) goto L12;
        this.f257769x = Long.valueOf(System.currentTimeMillis());
        getDataCenter().m().setValue(new com.bytedance.locallife.dito.data.b(this, getModel(), this.f257756k));
        return;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        rq6.a r109 = rq6.a.f538927a;
        StringBuilder r110 = new StringBuilder("tag:");
        r110.append(K());
        r110.append(',');
        Integer r111 = null;
        if (r100 == null) goto L5;
        String r112 = r100.getClass().getSimpleName();
    L6:
        r110.append(r112);
        r110.append(", layout changed====> width:");
        if (r100 == null) goto L9;
        Integer r113 = Integer.valueOf(r100.getWidth());
    L10:
        r110.append(r113);
        r110.append(",height:");
        if (r100 == null) goto L13;
        r111 = Integer.valueOf(r100.getHeight());
    L13:
        r110.append(r111);
        r109.c("dito_component", r110.toString());
        if (L() == false) goto L17;
        G(false);
        return;
    L17:
        return;
    L9:
        r113 = null;
        goto L10
    L5:
        r112 = null;
        goto L6
    }
}
