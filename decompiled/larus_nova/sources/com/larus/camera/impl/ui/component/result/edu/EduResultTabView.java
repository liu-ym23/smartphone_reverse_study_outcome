package com.larus.camera.impl.ui.component.result.edu;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.utils.w;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/edu/EduResultTabView;", "Lcom/google/android/material/tabs/TabLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentState", "Lcom/larus/camera/impl/entity/EduResultTabState;", "renderedModes", "", "Lcom/larus/camera/impl/entity/EduResultMode;", "tabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "tabNavigationReported", "", "suppressSelectionTracking", "bind", "", "viewModel", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", ChameleonOpenTracker.Stage.RENDER, "state", "renderTabs", "getSwitchModeShowType", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduResultTabView extends TabLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public px8.b f322127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends EduResultMode> f322128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f322129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f322130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f322131e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f322132a = null;

        static {
            int[] r100 = new int[EduResultMode.values().length];
            r100[EduResultMode.PHOTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[EduResultMode.SINGLE_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[EduResultMode.MULTI_QUESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[EduResultMode.HOMEWORK_CORRECTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f322132a = r100;
        }
    }

    public EduResultTabView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public EduResultTabView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static String b(EduResultMode r100) {
        int r101 = a.f322132a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "picture_mode";
    L5:
        if (r101 != 2) goto L7;
        return "single_question_mode";
    L7:
        if (r101 != 3) goto L9;
        return "multi_question_mode";
    L9:
        if (r101 != 4) goto L12;
        return "check_mode";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(CameraResultViewModel r100, CoroutineScope r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "scope");
        if (w.a() == true) goto L6;
        setVisibility(8);
        return;
    L6:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r100.getEduResultTabState(), new EduResultTabView$bind$1(this, r100, null)), CoroutineScopeKt.plus(r101, Dispatchers.getMain()));
    }

    public EduResultTabView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        px8.b r103 = px8.b.f530942e;
        this.f322127a = px8.b.f530942e;
        this.f322128b = CollectionsKt.emptyList();
        setVisibility(8);
    }

    public /* synthetic */ EduResultTabView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
