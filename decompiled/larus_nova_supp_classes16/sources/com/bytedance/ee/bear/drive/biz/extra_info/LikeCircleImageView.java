package com.bytedance.ee.bear.drive.biz.extra_info;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.drive.view.widget.CircleImageView;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.Contexts;
import java.util.HashMap;
import java.util.List;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LikeCircleImageView extends FrameLayout {
    public CircleImageView a;
    public CircleImageView b;
    public FrameLayout c;
    public List<String> d;
    public HashMap<String, String> e;

    public final void b() {
        if (n.d == false) goto L5;
        FrameLayout.inflate(getContext(), 2131560203, this);
    L6:
        this.a = (CircleImageView) findViewById(2131370276);
        this.b = (CircleImageView) findViewById(2131370277);
        this.c = (FrameLayout) findViewById(2131370278);
        return;
    L5:
        FrameLayout.inflate(getContext(), 2131560202, this);
        goto L6
    }

    public List<String> getCurrentAvatarList() {
        return this.d;
    }

    public HashMap<String, String> getCurrentAvatarMap() {
        return this.e;
    }

    public LikeCircleImageView(Context r1) {
        super(r1);
        b();
    }

    public final int a(int r4) {
        int r0 = (int) j08.b.a(getContext(), 20.0f);
        int r1 = (int) j08.b.a(getContext(), -8.0f);
        if (r4 != 1) goto L5;
        return r0;
    L5:
        if (r4 == 2) goto L9;
        return 0;
    L9:
        return (r0 * 2) + r1;
    }

    public final void d(List<String> r10) {
        if (n.d == false) goto L13;
        if (r10 != null) goto L6;
        tt5.a.d("LikeCircleImageView", "setHeaderView avatarList is null");
        return;
    L6:
        this.d = r10;
        tt5.a.h("LikeCircleImageView", "avatarList.size = " + r10.size());
        int r0 = a(r10.size());
        FrameLayout r3 = this.c;
        g.c(r3, r3.getWidth(), r0).setDuration(150).start();
        if (hu5.a.d(r10) == false) goto L10;
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        return;
    L10:
        if (r10.size() != 1) goto L12;
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        c((String) ListProtector.get(r10, 0), this.a);
        return;
    L12:
        this.a.setVisibility(0);
        this.b.setVisibility(0);
        c((String) ListProtector.get(r10, 0), this.a);
        c((String) ListProtector.get(r10, 1), this.b);
        return;
    L13:
        if (r10 != null) goto L15;
        tt5.a.d("LikeCircleImageView", "setHeaderView avatarList is null");
        return;
    L15:
        this.d = r10;
        tt5.a.h("LikeCircleImageView", "avatarList.size = " + r10.size());
        int r1 = getResources().getDimensionPixelSize(2131166314);
        if (r10.size() != 0) goto L21;
        if (this.c.getWidth() != r1) goto L36;
        g.c(this.c, r1, 0).setDuration(150).start();
        return;
    L36:
        return;
    L21:
        if (r10.size() != 1) goto L27;
        if (this.c.getWidth() != 0) goto L25;
        g.c(this.c, 0, r1).setDuration(150).start();
    L25:
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        c((String) ListProtector.get(r10, 0), this.a);
        return;
    L27:
        if (this.c.getWidth() != 0) goto L29;
        g.c(this.c, 0, r1).setDuration(150).start();
    L29:
        this.a.setVisibility(0);
        this.b.setVisibility(0);
        c((String) ListProtector.get(r10, 0), this.a);
        c((String) ListProtector.get(r10, 1), this.b);
    }

    public LikeCircleImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        b();
    }

    public final void c(String r3, CircleImageView r4) {
        Activity r0 = Contexts.requireActivity(getContext());     // Catch: Throwable -> L7
        if (r0.isFinishing() == true) goto L6;
        if (r0.isDestroyed() == true) goto L13;
    L9:
        Glide.with(getContext()).load(new BearGlideUrl(r3)).dontAnimate().placeholder(2131235295).error(2131235295).listener(new e55.b()).into(r4);
        return;
    L13:
        return;
    L6:
        return;
    L7:
        th = move-exception;
        tt5.a.d("LikeCircleImageView", th.getMessage());
        goto L9
    }

    public LikeCircleImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        b();
    }
}
