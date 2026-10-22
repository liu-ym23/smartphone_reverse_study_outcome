package com.bytedance.ee.bear.drive.view.preview.archive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.view.preview.loadingview.LoadingAnimView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import f95.b;
import f95.c;
import f95.d;
import f95.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileTreeRvView extends FrameLayout implements FileDirNavigationView.b, FileNodeContentView.b {
    public FileDirNavigationView a;
    public FileNodeContentView b;
    public SpaceEmptyState c;
    public LoadingAnimView d;
    public b e;
    public a f;
    public f95.a g;
    public c h;
    public a95.a i;

    public class a {
        public e a;
        public d b;
        public boolean c;

        public a() {
        }
    }

    public b getDataProvider() {
        return this.e;
    }

    public FileTreeRvView(Context r1) {
        super(r1);
        b(r1);
    }

    private void setEmptyViewVisible(boolean r3) {
        if (r3 == false) goto L5;
        this.c.setVisibility(0);
        this.b.setVisibility(4);
        return;
    L5:
        this.c.setVisibility(4);
        this.b.setVisibility(0);
    }

    public final void b(Context r2) {
        LayoutInflater.from(r2).inflate(2131560192, this);
        this.a = (FileDirNavigationView) findViewById(2131384078);
        this.b = (FileNodeContentView) findViewById(2131384081);
        this.c = findViewById(2131391810);
        this.d = (LoadingAnimView) findViewById(2131372459);
    }

    public void setContentItemClickListener(f95.a r1) {
        this.g = r1;
    }

    public void setCurrentNodeP(e r2) {
        a r3 = a(r2, false);
        if (r3.c == false) goto L6;
        c(null, r3);
        return;
    }

    public void setDataProvider(b r3) {
        this.e = r3;
        e r4 = new e();
        ((ArrayList) r4.a).add(0);
        c(null, a(r4, true));
        this.a.setNavigationItemClickListener(this);
        this.b.setContentItemClickListener(this);
    }

    public void setNavigationItemClickListener(c r1) {
        this.h = r1;
    }

    public void setUserAbility(a95.a r1) {
        this.i = r1;
    }

    public FileTreeRvView(Context r1, AttributeSet r2) {
        super(r1, r2);
        b(r1);
    }

    public final a a(e r2, boolean r3) {
        a r0 = new a();
        r0.a = r2;
        if (r3 == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r0.c = r4;
        d r5 = this.e.a(r2);
        if (r5 != null) goto L13;
        r5 = new d();
    L13:
        r0.b = r5;
        return r0;
    L5:
        if (this.e.c(r2) == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void c(List<a> r8, a r9) {
        this.f = r9;
        if (this.e.b(r9.a) <= 0) goto L5;
        boolean r0 = true;
    L6:
        setEmptyViewVisible(!r0);
        ArrayList r2 = new ArrayList();
        if (r8 == null) goto L9;
        r2.addAll(r8);
        r2.add(r9);
    L19:
        FileDirNavigationView r10 = this.a;
        ((ArrayList) r10.b).clear();
        ((ArrayList) r10.b).addAll(r2);
        r10.a.notifyDataSetChanged();
        r10.scrollToPosition(r10.a.getItemCount() - 1);
        if (r0 == false) goto L38;
        ArrayList r11 = new ArrayList();
        int r1 = this.e.b(r9.a);
        int r3 = 0;
    L22:
        if (r3 >= r1) goto L29;
        e r4 = r9.a;
        if (r4 == null) goto L27;
        if (r3 < 0) goto L27;
        e r5 = new e();
        ((ArrayList) r5.a).addAll(r4.a);
        ((ArrayList) r5.a).add(Integer.valueOf(r3));
    L28:
        r11.add(a(r5, false));
        r3 = r3 + 1;
    L27:
        r5 = new e();
        ((ArrayList) r5.a).add(0);
        goto L28
    L29:
        FileNodeContentView r6 = this.b;
        ((ArrayList) r6.c).clear();
        ((ArrayList) r6.c).addAll(r11);
        r6.a.notifyDataSetChanged();
        this.b.scrollToPosition(0);
        int r12 = r9.a.b;
        if (r12 <= 0) goto L39;
        this.b.scrollBy(0, r12);
        return;
    L39:
        return;
    L38:
        return;
    L9:
        e r13 = r9.a;
        LinkedList r7 = new LinkedList();
        r7.offerLast(r9);
    L11:
        if (r13.a() == false) goto L13;
        r13 = null;
    L14:
        if (r13 == null) goto L17;
        r7.offerLast(a(r13, false));
    L17:
        if (r7.isEmpty() == true) goto L19;
        r2.add((a) r7.pollLast());
        goto L17
    L13:
        e r14 = new e();
        List<Integer> r16 = r14.a;
        ArrayList r17 = (ArrayList) r13.a;
        ((ArrayList) r16).addAll(r17.subList(0, r17.size() - 1));
        r13 = r14;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public FileTreeRvView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        b(r1);
    }
}
