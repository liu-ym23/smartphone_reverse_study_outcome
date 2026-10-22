package com.ss.android.lark.reaction.widget.panel.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionPanel extends LinearLayout implements t2c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f439494a;

    public class FacePagerAdapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            throw null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            return super.getItemPosition(r100);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(View r100, int r101) {
            ViewPager r102 = (ViewPager) r100;
            throw null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(View r100, int r101, Object r102) {
            ViewPager r103 = (ViewPager) r100;
            throw null;
        }
    }

    public interface a {
    }

    public void setPageCount(int r100) {
    }

    public void setReactionSelectListener(t2c.a r100) {
    }

    public void setShowMoreBgColor(int r100) {
    }

    public void setWindowTokenProvider(a r100) {
    }

    public ReactionPanel(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.layout_reaction_display_panel, this, true);
        this.f439494a = findViewById(R.id.root);
        ViewPager r101 = (ViewPager) findViewById(R.id.frag_pager);
        ((LinearLayout) findViewById(R.id.frag_point)).setClickable(true);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        this.f439494a.setBackgroundColor(r100);
    }

    public ReactionPanel(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public ReactionPanel(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
