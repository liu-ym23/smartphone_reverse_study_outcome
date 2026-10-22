package com.bytedance.awemeopen.apps.photo.viewmodel;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u0011\u0010\u0017\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/viewmodel/SlidesDetailSizeVM;", "Landroidx/lifecycle/ViewModel;", "", "coordinatorHeight", "I", "getCoordinatorHeight", "()I", "setCoordinatorHeight", "(I)V", "Landroidx/lifecycle/MutableLiveData;", "", "mainListHeightDec", "Landroidx/lifecycle/MutableLiveData;", "getMainListHeightDec", "()Landroidx/lifecycle/MutableLiveData;", "value", "mainListHeight", "getMainListHeight", "setMainListHeight", "pageBottomDev", "getPageBottomDev", "setPageBottomDev", "getAppBarUpOffsetDev", "appBarUpOffsetDev", "<init>", "()V", "Companion", "a", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class SlidesDetailSizeVM extends ViewModel {
    public static final a Companion = null;
    private int coordinatorHeight;
    private int mainListHeight;
    private final MutableLiveData<Object> mainListHeightDec;
    private int pageBottomDev;

    public static final class a {
        public a() {
        }

        public static SlidesDetailSizeVM a(Context r2) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");     // Catch: Throwable -> L4
            ViewModelProviderFactory r1 = ViewModelProviderFactory.a;     // Catch: Throwable -> L4
            r1.getClass();     // Catch: Throwable -> L4
            Object r3 = Result.constructor-impl((SlidesDetailSizeVM) new ViewModelProvider((FragmentActivity) r2, r1).get(SlidesDetailSizeVM.class));     // Catch: Throwable -> L4
        L7:
            if (Result.isFailure-impl(r3) == false) goto L10;
            r3 = null;
        L10:
            return (SlidesDetailSizeVM) r3;
        L4:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    public final int getAppBarUpOffsetDev() {
        return RangesKt.coerceAtLeast((this.coordinatorHeight - this.mainListHeight) - this.pageBottomDev, 0);
    }

    public SlidesDetailSizeVM() {
        this.mainListHeightDec = new MutableLiveData();
    }

    public final int getCoordinatorHeight() {
        return this.coordinatorHeight;
    }

    public final int getMainListHeight() {
        return this.mainListHeight;
    }

    public final MutableLiveData<Object> getMainListHeightDec() {
        return this.mainListHeightDec;
    }

    public final int getPageBottomDev() {
        return this.pageBottomDev;
    }

    public final void setCoordinatorHeight(int r1) {
        this.coordinatorHeight = r1;
    }

    public final void setMainListHeight(int r2) {
        int r0 = this.mainListHeight;
        if (r0 != r2) goto L5;
        return;
    L5:
        this.mainListHeight = r2;
        if (r0 <= r2) goto L9;
        this.mainListHeightDec.setValue(Unit.INSTANCE);
        return;
    }

    public final void setPageBottomDev(int r1) {
        this.pageBottomDev = r1;
    }
}
