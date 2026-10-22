package com.bytedance.ee.bear.atbottombar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bo4.c;
import com.bytedance.ee.bear.bean.MentionPanelType;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.larus.nova.R;
import java.util.List;
import ln4.h;
import ln4.m;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f206336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtFinderView f206337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f206338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MentionPanelType f206339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f206340e;

    public interface a {
    }

    public b(Context r100, m r101, c r102, AtBottomBar r103) {
        this.f206340e = null;
        View r104 = LayoutInflater.from(r100).inflate(R.layout.at_bar_viewpager_item, null);
        this.f206336a = r104;
        AtFinderView r105 = (AtFinderView) r104.findViewById(R.id.at_finder_view);
        this.f206337b = r105;
        r105.setAtFinderViewDelegate(r103);
        r105.setTitle(r101.f510024b);
        r105.setAtCommonConfig(r102);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mention.optimizing_authorizaiton") == false) goto L5;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105.getLayoutParams();
        r106.topMargin = 0;
        r106.height = -1;
        r105.setLayoutParams(r106);
    L5:
        this.f206338c = r101.f510025c;
        r105.setContentHeightChangeCallback(new h(this));
    }
}
