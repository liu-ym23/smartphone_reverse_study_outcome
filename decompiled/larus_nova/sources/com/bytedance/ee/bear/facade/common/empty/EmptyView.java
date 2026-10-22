package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes16.dex */
public class EmptyView extends LinearLayout implements d, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f226416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpaceEmptyState f226417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Config f226418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f226419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f226420e;

    public interface a {
        void onFailedRetry();
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void a() {
        setIsLoadingView(false);
        this.f226417b.setImageRes((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(3));
        this.f226417b.setDesc((CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(3));
        setOnClickListener(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void hide() {
        setVisibility(4);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void show() {
        setVisibility(0);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showLoading() {
        setIsLoadingView(true);
        ((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(0)).intValue();
        CharSequence r100 = (CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(0);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoContent() {
        setIsLoadingView(false);
        int r100 = ((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(1)).intValue();
        CharSequence r101 = (CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(1);
        String r102 = getResources().getString(R.string.Doc_Facade_EmptyFolderTip);
        if (r101.toString().equals(r102) == true) goto L5;
    L7:
        this.f226417b.setImageRes(Integer.valueOf(r100));
        this.f226417b.setDesc(r101);
        this.f226417b.setOnClickListener(null);
        this.f226417b.setClickable(false);
        return;
    L5:
        if (TextUtils.equals(this.f226418c.f226408d, Locale.CHINESE.getLanguage()) == false) goto L7;
        StringBuilder r103 = new StringBuilder(r101);
        r103.insert(r101.length() / 2, "\n");
        r101 = r103.toString();
        goto L7
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoFound() {
        setIsLoadingView(false);
        this.f226417b.setImageRes((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(5));
        this.f226417b.setDesc((CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(5));
        this.f226417b.setOnClickListener(null);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoNetworkError() {
        setIsLoadingView(false);
        int r100 = ((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(4)).intValue();
        CharSequence r101 = (CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(4);
        this.f226417b.setImageRes(Integer.valueOf(r100));
        this.f226417b.setDesc(r101);
        this.f226417b.setOnClickListener(null);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoPermission() {
        setIsLoadingView(false);
        this.f226417b.setImageRes((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(99));
        this.f226417b.setDesc((CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(99));
        this.f226417b.setOnClickListener(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoSupport() {
        setIsLoadingView(false);
        this.f226417b.setImageRes((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(10));
        this.f226417b.setDesc((CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(10));
        this.f226417b.setOnClickListener(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showTimeout() {
        setIsLoadingView(false);
        this.f226417b.setImageRes((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(7));
        this.f226417b.setDesc((CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(7));
        this.f226417b.setOnClickListener(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showWikiDeleted() {
        setIsLoadingView(false);
        this.f226417b.setImageRes((Integer) ((LinkedHashMap) this.f226418c.f226406b).get(9));
        this.f226417b.setDesc((CharSequence) ((LinkedHashMap) this.f226418c.f226405a).get(9));
        this.f226417b.setOnClickListener(this);
    }

    public Config getConfig() {
        return this.f226418c;
    }

    public EmptyView(Context r100) {
        super(r100);
        b(r100, null);
    }

    private void setIsLoadingView(boolean r100) {
        LinearLayout r101 = this.f226416a;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        SpaceEmptyState r104 = this.f226417b;
        if (r100 == false) goto L9;
        int r105 = 8;
    L10:
        r104.setVisibility(r105);
        View r106 = this.f226417b.getImageView();
        if (r100 == false) goto L13;
        r102 = 8;
    L13:
        r106.setVisibility(r102);
        this.f226417b.showDescription(!r100);
        return;
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 8;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f226419d;
        if (r101 == null) goto L6;
        r101.onFailedRetry();
        return;
    }

    public void setConfig(Config r100) {
        this.f226418c = r100;
        int r101 = r100.f226407c;
        if (r101 <= 0) goto L6;
        this.f226416a.removeAllViews();
        View r102 = LayoutInflater.from(getContext()).inflate(r101, null);
        this.f226416a.addView(r102);
        return;
    }

    public void setLoadViewMarginTop(int r100) {
        if (this.f226420e != null) goto L5;
        this.f226420e = findViewById(R.id.lark_loading_view);
    L5:
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.f226420e.getLayoutParams();
        r101.topMargin = r100;
        this.f226420e.setLayoutParams(r101);
    }

    public void setOnRetryListener(a r100) {
        this.f226419d = r100;
    }

    public EmptyView(Context r100, AttributeSet r101) {
        super(r100, r101);
        b(r100, r101);
    }

    public final void b(Context r100, AttributeSet r101) {
        int r102 = R.layout.facade_common_empty;
        if (r101 == null) goto L5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.content});
        r102 = r103.getResourceId(0, R.layout.facade_common_empty);
        r103.recycle();
    L5:
        LayoutInflater.from(r100).inflate(r102, this);
        this.f226416a = (LinearLayout) findViewById(R.id.ll_loading);
        this.f226417b = (SpaceEmptyState) findViewById(R.id.facade_no_data_empty_state);
        this.f226418c = new DefaultConfig(r100).f226411b.invoke();
    }

    public EmptyView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b(r100, r101);
    }
}
