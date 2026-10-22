package com.bytedance.creativex.mediaimport.view.internal.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.nova.R;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import ti4.q;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001;B9\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010'\u001a\u00020\u000fH\u0016J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u000fH\u0002J\b\u0010.\u001a\u00020\u000fH\u0002J\u0010\u0010/\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0010\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\tH\u0014J\u0010\u00105\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\tH\u0014J\b\u00106\u001a\u00020\u000fH\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u000208X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/main/BaseMediaSelectSelectAllView;", "DATA", "FOLDER", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectSelectAllView;", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", RootDescription.ROOT_ELEMENT, "Landroid/view/ViewGroup;", "selectAllViewModel", "Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectAllViewModel;", "viewConfigureBuilder", "Lkotlin/Function1;", "Lcom/bytedance/creativex/mediaimport/view/internal/main/BaseMediaSelectSelectAllView$ViewConfigure;", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/ViewGroup;Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectAllViewModel;Lkotlin/jvm/functions/Function1;)V", "getRoot", "()Landroid/view/ViewGroup;", "getSelectAllViewModel", "()Lcom/bytedance/creativex/mediaimport/view/internal/IMediaSelectAllViewModel;", "viewConfigure", "getViewConfigure", "()Lcom/bytedance/creativex/mediaimport/view/internal/main/BaseMediaSelectSelectAllView$ViewConfigure;", "isSelectAllAvailable", "", "selectAllTextView", "Landroid/widget/TextView;", "getSelectAllTextView", "()Landroid/widget/TextView;", "setSelectAllTextView", "(Landroid/widget/TextView;)V", "selectAllView", "Landroid/view/View;", "getSelectAllView", "()Landroid/view/View;", "setSelectAllView", "(Landroid/view/View;)V", "init", "initObserver", "currentSelectAllJob", "Lkotlinx/coroutines/Job;", "initSelectAllView", "handleSelectAllClick", "handleClearSelectClick", "initSelectAllTextView", "updateSelectAllTextView", "observeSelectAllEvent", "Lio/reactivex/Observable;", "Lcom/bytedance/creativex/mediaimport/view/internal/SelectAllEvent;", "provideSelectAllView", "content", "provideSelectAllTextView", LiveCommonConstants.REASON_ON_DEDTROY, "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "ViewConfigure", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseMediaSelectSelectAllView<DATA, FOLDER> implements LifecycleObserver, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f203891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f203892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f203893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f203894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f203895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f203896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f203897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f203898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f203899i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f203900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f203901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f203902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f203903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f203904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f203905f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function0<Unit> f203906g;

        public a() {
            throw null;
        }

        public a(wi4.a r100) {
            Intrinsics.checkNotNullParameter(r100, "cancelSelectAllTrigger");
            this.f203900a = R.color.tools_tPrimary2_dark;
            this.f203901b = R.color.tools_white;
            this.f203902c = R.string.larus_tools_media_select_all;
            this.f203903d = R.string.larus_tools_media_clear_all;
            this.f203904e = R.drawable.larus_tools_media_import_bg_select_all_select;
            this.f203905f = R.drawable.larus_tools_media_import_bg_select_all_cancel;
            this.f203906g = r100;
        }
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f203907a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f203907a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f203907a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f203907a.invoke(r100);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f203891a.getCoroutineContext();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
    }

    public final void a(boolean r100) {
        a r101 = this.f203895e;
        TextView r102 = this.f203897g;
        TextView r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
        r102 = null;
    L6:
        if (r100 == false) goto L8;
        int r104 = r101.f203904e;
    L9:
        r102.setBackgroundResource(r104);
        TextView r105 = this.f203897g;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
        r105 = null;
    L13:
        Context r106 = this.f203893c.getContext();
        if (r100 == false) goto L16;
        int r107 = r101.f203900a;
    L17:
        r105.setTextColor(ContextCompat.getColor(r106, r107));
        TextView r108 = this.f203897g;
        if (r108 == null) goto L20;
        r103 = r108;
    L21:
        if (r100 == false) goto L23;
        int r109 = r101.f203902c;
    L24:
        r103.setText(r109);
        return;
    L23:
        r109 = r101.f203903d;
        goto L24
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
        goto L21
    L16:
        r107 = r101.f203901b;
        goto L17
    L8:
        r104 = r101.f203905f;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [wi4.a] */
    public BaseMediaSelectSelectAllView(LifecycleOwner r100, ViewGroup r101, q r102, Function1<? super a, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        this.f203891a = CoroutineScopeKt.MainScope();
        this.f203892b = r100;
        this.f203893c = r101;
        this.f203894d = r102;
        a r104 = new a(new wi4.a(this));
        this.f203895e = r104;
        this.f203896f = true;
        if (r103 == null) goto L6;
        r103.invoke(r104);
        return;
    }
}
