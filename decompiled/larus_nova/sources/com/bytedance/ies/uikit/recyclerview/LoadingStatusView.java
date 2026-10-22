package com.bytedance.ies.uikit.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class LoadingStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f249100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f249101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f249102c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f249103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f249104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f249105c;

        public a(Context r100) {
            if (r100 == null) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("LoadingStatusView.Builder:Context can not be null");
        }
    }

    public LoadingStatusView(Context r100) {
        this(r100, null);
    }

    private void setStatus(int r100) {
        int r101 = this.f249102c;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 < 0) goto L8;
        ((View) ListProtector.get(this.f249101b, r101)).setVisibility(4);
    L8:
        if (((View) ListProtector.get(this.f249101b, r100)) != null) goto L10;
        return;
    L10:
        ((View) ListProtector.get(this.f249101b, r100)).setVisibility(0);
        this.f249102c = r100;
        Logger.d(this.f249100a, "setStatus    " + r100);
    }

    public void setBuilder(a r100) {
        if (r100 != null) goto L4;
        Context r101 = getContext();
        a r102 = new a(r101);
        TextView r103 = (TextView) LayoutInflater.from(r101).inflate(R.layout.view_default_empty_list, null);
        r103.setText(R.string.load_status_empty);
        r102.f249104b = r103;
        TextView r104 = (TextView) LayoutInflater.from(r101).inflate(R.layout.load_status_item_view, null);
        r104.setText(R.string.load_status_loading);
        r102.f249103a = r104;
        TextView r105 = (TextView) LayoutInflater.from(r101).inflate(R.layout.load_status_item_view, null);
        r105.setText(R.string.load_status_error);
        r105.setOnClickListener(null);
        r102.f249105c = r105;
        r100 = r102;
    L4:
        ((ArrayList) this.f249101b).clear();
        List<View> r106 = this.f249101b;
        ArrayList r107 = (ArrayList) r106;
        r107.add(r100.f249103a);
        List<View> r108 = this.f249101b;
        ArrayList r109 = (ArrayList) r108;
        r109.add(r100.f249104b);
        List<View> r110 = this.f249101b;
        ArrayList r111 = (ArrayList) r110;
        r111.add(r100.f249105c);
        removeAllViews();
        int r112 = 0;
    L6:
        if (r112 >= ((ArrayList) this.f249101b).size()) goto L15;
        View r113 = (View) ListProtector.get(this.f249101b, r112);
        if (r113 == null) goto L14;
        r113.setVisibility(4);
        if (r113.getParent() == null) goto L13;
        ((ViewGroup) r113.getParent()).removeView(r113);
    L13:
        addView(r113);
    L14:
        r112 = r112 + 1;
        goto L6
    }

    public LoadingStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LoadingStatusView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f249100a = "LoadingStatusView";
        this.f249101b = new ArrayList(3);
        this.f249102c = -1;
        setBuilder(null);
    }
}
