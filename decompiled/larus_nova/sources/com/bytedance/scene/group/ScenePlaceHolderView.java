package com.bytedance.scene.group;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public final class ScenePlaceHolderView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f268663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f268664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f268665c;

    public com.bytedance.scene.h getSceneComponentFactory() {
        return null;
    }

    public void setSceneComponentFactory(com.bytedance.scene.h r100) {
    }

    public String getSceneName() {
        if (TextUtils.isEmpty(this.f268663a) == true) goto L7;
        return this.f268663a;
    L7:
        throw new IllegalArgumentException("ScenePlaceHolderView name is empty, invoke setSceneName first");
    }

    public String getSceneTag() {
        if (TextUtils.isEmpty(this.f268664b) == true) goto L7;
        return this.f268664b;
    L7:
        throw new IllegalArgumentException("ScenePlaceHolderView tag is empty, invoke setSceneTag first");
    }

    public Bundle getArguments() {
        return this.f268665c;
    }

    public void setArguments(Bundle r100) {
        this.f268665c = r100;
    }

    public void setSceneName(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f268663a = r100;
        return;
    L7:
        throw new IllegalArgumentException("ScenePlaceHolderView name can't be empty");
    }

    public void setSceneTag(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f268664b = r100;
        return;
    L7:
        throw new IllegalArgumentException("ScenePlaceHolderView tag can't be empty");
    }

    public ScenePlaceHolderView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getSuggestedMinimumWidth();
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 1073741824) goto L8;
        r102 = r104;
    L8:
        int r105 = getSuggestedMinimumHeight();
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r106 == Integer.MIN_VALUE) goto L13;
        if (r106 != 1073741824) goto L14;
        r105 = r107;
    L14:
        setMeasuredDimension(r102, r105);
        return;
    L13:
        r105 = Math.min(r105, r107);
        goto L14
    L7:
        r102 = Math.min(r102, r104);
        goto L8
    }

    public ScenePlaceHolderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.name, R.attr.tag}, 0, 0);
        this.f268663a = r103.getString(0);     // Catch: Throwable -> L6
        this.f268664b = r103.getString(1);     // Catch: Throwable -> L6
        r103.recycle();
        return;
    L6:
        th = move-exception;
        r103.recycle();
        throw th;
    }
}
