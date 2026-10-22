package com.zhpan.bannerview.provider;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
public class ScrollDurationManger extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f464568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f464569b;

    public class a extends LinearSmoothScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScrollDurationManger f464570a;

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateTimeForDeceleration(int r100) {
            return this.f464570a.f464569b;
        }

        public a(ScrollDurationManger r100, Context r101) {
            this.f464570a = r100;
            super(r101);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r103, boolean r104) {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.State r100, int[] r101) {
        Method r102 = this.f464568a.getClass().getDeclaredMethod("calculateExtraLayoutSpace", new Class[]{r100.getClass(), r101.getClass()});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 NoSuchMethodException -> L8
        r102.setAccessible(true);     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 NoSuchMethodException -> L8
        r102.invoke(this.f464568a, new Object[]{r100, r101});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6 NoSuchMethodException -> L8
    L15:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        e.getMessage();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        e.getMessage();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        e.getMessage();
    }

    public ScrollDurationManger(ViewPager2 r100, int r101, LinearLayoutManager r102) {
        super(r100.getContext(), r102.getOrientation(), false);
        this.f464569b = r101;
        this.f464568a = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler r100, RecyclerView.State r101, AccessibilityNodeInfoCompat r102) {
        this.f464568a.onInitializeAccessibilityNodeInfo(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        a r103 = new a(this, r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean performAccessibilityAction(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, Bundle r103) {
        return this.f464568a.performAccessibilityAction(r100, r101, r102, r103);
    }
}
