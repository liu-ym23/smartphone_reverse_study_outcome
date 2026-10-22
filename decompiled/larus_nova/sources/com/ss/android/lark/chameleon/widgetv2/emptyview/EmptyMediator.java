package com.ss.android.lark.chameleon.widgetv2.emptyview;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: classes35.dex */
public class EmptyMediator {
    private static final String TAG = "EmptyViewMediator";
    private View mContentView;
    private EmptyStateSource mEmptyStateSource;
    private EmptyViewController mEmptyView;

    public EmptyStateSource getEmptyStateSource() {
        return this.mEmptyStateSource;
    }

    public void updateEmptyState(EmptyStateSource.EmptyState r100) {
        j.e(TAG, "updateEmptyState");
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getState();
        j.e(TAG, "emptyState.getState:" + r101);
        if (r101 != 0) goto L8;
    L55:
        this.mEmptyView.show();
        View r102 = this.mContentView;
        if (r102 == null) goto L58;
        r102.setVisibility(4);
    L58:
        this.mEmptyView.showLoading();
        return;
    L8:
        if (r101 != 1) goto L10;
        this.mEmptyView.show();
        View r103 = this.mContentView;
        if (r103 == null) goto L54;
        r103.setVisibility(4);
    L54:
        this.mEmptyView.showNoContent();
        return;
    L10:
        if (r101 != 2) goto L12;
        this.mEmptyView.hide();
        View r104 = this.mContentView;
        if (r104 == null) goto L68;
        r104.setVisibility(0);
        return;
    L68:
        return;
    L12:
        if (r101 == 3) goto L44;
        if (r101 != 4) goto L15;
        this.mEmptyView.show();
        View r105 = this.mContentView;
        if (r105 == null) goto L43;
        r105.setVisibility(4);
    L43:
        this.mEmptyView.showNoNetworkError();
        return;
    L15:
        if (r101 != 5) goto L17;
        this.mEmptyView.show();
        View r106 = this.mContentView;
        if (r106 == null) goto L39;
        r106.setVisibility(4);
    L39:
        this.mEmptyView.showNoFound();
        return;
    L17:
        if (r101 == 99) goto L32;
        switch(r101) {
            case 7: goto L28;
            case 8: goto L55;
            case 9: goto L24;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        j.b(TAG, "onChanged: unknown state = " + r101);
        return;
    L20:
        this.mEmptyView.show();
        View r107 = this.mContentView;
        if (r107 == null) goto L23;
        r107.setVisibility(4);
    L23:
        this.mEmptyView.showNoSupport();
        return;
    L24:
        this.mEmptyView.show();
        View r108 = this.mContentView;
        if (r108 == null) goto L27;
        r108.setVisibility(4);
    L27:
        this.mEmptyView.showWikiDeleted();
        return;
    L28:
        this.mEmptyView.show();
        View r109 = this.mContentView;
        if (r109 == null) goto L31;
        r109.setVisibility(4);
    L31:
        this.mEmptyView.showTimeout();
        return;
    L32:
        this.mEmptyView.show();
        View r110 = this.mContentView;
        if (r110 == null) goto L35;
        r110.setVisibility(4);
    L35:
        this.mEmptyView.showNoPermission();
        return;
    L44:
        this.mEmptyView.show();
        View r111 = this.mContentView;
        if (r111 == null) goto L47;
        r111.setVisibility(4);
    L47:
        this.mEmptyView.showLoadError(r100.getError());
    }

    public EmptyMediator(Context r100, EmptyViewController r101, View r102) {
        this.mEmptyView = r101;
        this.mContentView = r102;
    }

    public EmptyMediator(Context r100, LifecycleOwner r101, EmptyViewController r102, View r103) {
        this.mEmptyView = r102;
        this.mContentView = r103;
        EmptyStateSource r104 = new EmptyStateSource(r100);
        this.mEmptyStateSource = r104;
        r104.observe(r101, new AnonymousClass1(this));
    }
}
