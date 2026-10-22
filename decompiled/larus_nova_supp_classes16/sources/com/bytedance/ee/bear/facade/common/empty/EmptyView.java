package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EmptyView extends LinearLayout implements d, View.OnClickListener {
    public LinearLayout a;
    public SpaceEmptyState b;
    public Config c;
    public a d;
    public View e;

    public interface a {
        void onFailedRetry();
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void a() {
        setIsLoadingView(false);
        this.b.setImageRes((Integer) ((LinkedHashMap) this.c.b).get(3));
        this.b.setDesc((CharSequence) ((LinkedHashMap) this.c.a).get(3));
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
        ((Integer) ((LinkedHashMap) this.c.b).get(0)).intValue();
        CharSequence r0 = (CharSequence) ((LinkedHashMap) this.c.a).get(0);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoContent() {
        setIsLoadingView(false);
        int r1 = ((Integer) ((LinkedHashMap) this.c.b).get(1)).intValue();
        CharSequence r2 = (CharSequence) ((LinkedHashMap) this.c.a).get(1);
        String r3 = getResources().getString(2131887752);
        if (r2.toString().equals(r3) == true) goto L5;
    L7:
        this.b.setImageRes(Integer.valueOf(r1));
        this.b.setDesc(r2);
        this.b.setOnClickListener(null);
        this.b.setClickable(false);
        return;
    L5:
        if (TextUtils.equals(this.c.d, Locale.CHINESE.getLanguage()) == false) goto L7;
        StringBuilder r4 = new StringBuilder(r2);
        r4.insert(r2.length() / 2, DocViewModel.ENTER_CHAR);
        r2 = r4.toString();
        goto L7
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoFound() {
        setIsLoadingView(false);
        this.b.setImageRes((Integer) ((LinkedHashMap) this.c.b).get(5));
        this.b.setDesc((CharSequence) ((LinkedHashMap) this.c.a).get(5));
        this.b.setOnClickListener(null);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoNetworkError() {
        setIsLoadingView(false);
        int r0 = ((Integer) ((LinkedHashMap) this.c.b).get(4)).intValue();
        CharSequence r1 = (CharSequence) ((LinkedHashMap) this.c.a).get(4);
        this.b.setImageRes(Integer.valueOf(r0));
        this.b.setDesc(r1);
        this.b.setOnClickListener(null);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoPermission() {
        setIsLoadingView(false);
        this.b.setImageRes((Integer) ((LinkedHashMap) this.c.b).get(99));
        this.b.setDesc((CharSequence) ((LinkedHashMap) this.c.a).get(99));
        this.b.setOnClickListener(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showNoSupport() {
        setIsLoadingView(false);
        this.b.setImageRes((Integer) ((LinkedHashMap) this.c.b).get(10));
        this.b.setDesc((CharSequence) ((LinkedHashMap) this.c.a).get(10));
        this.b.setOnClickListener(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showTimeout() {
        setIsLoadingView(false);
        this.b.setImageRes((Integer) ((LinkedHashMap) this.c.b).get(7));
        this.b.setDesc((CharSequence) ((LinkedHashMap) this.c.a).get(7));
        this.b.setOnClickListener(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.d
    public final void showWikiDeleted() {
        setIsLoadingView(false);
        this.b.setImageRes((Integer) ((LinkedHashMap) this.c.b).get(9));
        this.b.setDesc((CharSequence) ((LinkedHashMap) this.c.a).get(9));
        this.b.setOnClickListener(this);
    }

    public Config getConfig() {
        return this.c;
    }

    public EmptyView(Context r2) {
        super(r2);
        b(r2, null);
    }

    private void setIsLoadingView(boolean r5) {
        LinearLayout r0 = this.a;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        SpaceEmptyState r2 = this.b;
        if (r5 == false) goto L9;
        int r4 = 8;
    L10:
        r2.setVisibility(r4);
        View r6 = this.b.getImageView();
        if (r5 == false) goto L13;
        r1 = 8;
    L13:
        r6.setVisibility(r1);
        this.b.showDescription(!r5);
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 8;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        a r2 = this.d;
        if (r2 == null) goto L6;
        r2.onFailedRetry();
        return;
    }

    public void setConfig(Config r3) {
        this.c = r3;
        int r4 = r3.c;
        if (r4 <= 0) goto L6;
        this.a.removeAllViews();
        View r5 = LayoutInflater.from(getContext()).inflate(r4, null);
        this.a.addView(r5);
        return;
    }

    public void setLoadViewMarginTop(int r2) {
        if (this.e != null) goto L5;
        this.e = findViewById(2131377166);
    L5:
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        r0.topMargin = r2;
        this.e.setLayoutParams(r0);
    }

    public void setOnRetryListener(a r1) {
        this.d = r1;
    }

    public EmptyView(Context r1, AttributeSet r2) {
        super(r1, r2);
        b(r1, r2);
    }

    public final void b(Context r5, AttributeSet r6) {
        int r0 = 2131561087;
        if (r6 == null) goto L5;
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130969617});
        r0 = r7.getResourceId(0, 2131561087);
        r7.recycle();
    L5:
        LayoutInflater.from(r5).inflate(r0, this);
        this.a = (LinearLayout) findViewById(2131378741);
        this.b = findViewById(2131372043);
        this.c = (Config) new DefaultConfig(r5).b.invoke();
    }

    public EmptyView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        b(r1, r2);
    }
}
