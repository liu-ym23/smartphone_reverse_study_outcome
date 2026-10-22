package com.bytedance.ee.bear.drive.view.preview.archive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.view.preview.loadingview.LoadingAnimView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import f95.b;
import f95.c;
import f95.d;
import f95.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class FileTreeRvView extends FrameLayout implements FileDirNavigationView.b, FileNodeContentView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FileDirNavigationView f224729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileNodeContentView f224730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpaceEmptyState f224731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadingAnimView f224732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f224733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f224734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f95.a f224735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f224736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a95.a f224737i;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f224738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f224739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f224740c;

        public a() {
        }
    }

    public b getDataProvider() {
        return this.f224733e;
    }

    public FileTreeRvView(Context r100) {
        super(r100);
        b(r100);
    }

    private void setEmptyViewVisible(boolean r100) {
        if (r100 == false) goto L5;
        this.f224731c.setVisibility(0);
        this.f224730b.setVisibility(4);
        return;
    L5:
        this.f224731c.setVisibility(4);
        this.f224730b.setVisibility(0);
    }

    public final void b(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.drive_filetreervview, this);
        this.f224729a = (FileDirNavigationView) findViewById(R.id.recycler_view_horizontal);
        this.f224730b = (FileNodeContentView) findViewById(R.id.recycler_view_vertical);
        this.f224731c = (SpaceEmptyState) findViewById(R.id.ud_empty_state_view);
        this.f224732d = (LoadingAnimView) findViewById(R.id.file_tree_loading);
    }

    public void setContentItemClickListener(f95.a r100) {
        this.f224735g = r100;
    }

    public void setCurrentNodeP(e r100) {
        a r101 = a(r100, false);
        if (r101.f224740c == false) goto L6;
        c(null, r101);
        return;
    }

    public void setDataProvider(b r100) {
        this.f224733e = r100;
        e r101 = new e();
        ((ArrayList) r101.f475969a).add(0);
        c(null, a(r101, true));
        this.f224729a.setNavigationItemClickListener(this);
        this.f224730b.setContentItemClickListener(this);
    }

    public void setNavigationItemClickListener(c r100) {
        this.f224736h = r100;
    }

    public void setUserAbility(a95.a r100) {
        this.f224737i = r100;
    }

    public FileTreeRvView(Context r100, AttributeSet r101) {
        super(r100, r101);
        b(r100);
    }

    public final a a(e r100, boolean r101) {
        a r102 = new a();
        r102.f224738a = r100;
        if (r101 == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        r102.f224740c = r103;
        d r104 = this.f224733e.a(r100);
        if (r104 != null) goto L13;
        r104 = new d();
    L13:
        r102.f224739b = r104;
        return r102;
    L5:
        if (this.f224733e.c(r100) == true) goto L8;
        r103 = false;
        goto L9
    }

    public final void c(List<a> r100, a r101) {
        this.f224734f = r101;
        if (this.f224733e.b(r101.f224738a) <= 0) goto L5;
        boolean r102 = true;
    L6:
        setEmptyViewVisible(!r102);
        ArrayList r103 = new ArrayList();
        if (r100 == null) goto L9;
        r103.addAll(r100);
        r103.add(r101);
    L19:
        FileDirNavigationView r104 = this.f224729a;
        ((ArrayList) r104.f224711b).clear();
        ((ArrayList) r104.f224711b).addAll(r103);
        r104.f224710a.notifyDataSetChanged();
        r104.scrollToPosition(r104.f224710a.getItemCount() - 1);
        if (r102 == false) goto L38;
        ArrayList r105 = new ArrayList();
        int r106 = this.f224733e.b(r101.f224738a);
        int r107 = 0;
    L22:
        if (r107 >= r106) goto L29;
        e r108 = r101.f224738a;
        if (r108 == null) goto L27;
        if (r107 < 0) goto L27;
        e r109 = new e();
        ((ArrayList) r109.f475969a).addAll(r108.f475969a);
        ((ArrayList) r109.f475969a).add(Integer.valueOf(r107));
    L28:
        r105.add(a(r109, false));
        r107 = r107 + 1;
    L27:
        r109 = new e();
        ((ArrayList) r109.f475969a).add(0);
        goto L28
    L29:
        FileNodeContentView r110 = this.f224730b;
        ((ArrayList) r110.f224718c).clear();
        ((ArrayList) r110.f224718c).addAll(r105);
        r110.f224716a.notifyDataSetChanged();
        this.f224730b.scrollToPosition(0);
        int r111 = r101.f224738a.f475970b;
        if (r111 <= 0) goto L39;
        this.f224730b.scrollBy(0, r111);
        return;
    L39:
        return;
    L38:
        return;
    L9:
        e r112 = r101.f224738a;
        LinkedList r113 = new LinkedList();
        r113.offerLast(r101);
    L11:
        if (r112.a() == false) goto L13;
        r112 = null;
    L14:
        if (r112 == null) goto L17;
        r113.offerLast(a(r112, false));
    L17:
        if (r113.isEmpty() == true) goto L19;
        r103.add((a) r113.pollLast());
        goto L17
    L13:
        e r114 = new e();
        List<Integer> r115 = r114.f475969a;
        ArrayList r116 = (ArrayList) r112.f475969a;
        ((ArrayList) r115).addAll(r116.subList(0, r116.size() - 1));
        r112 = r114;
        goto L14
    L5:
        r102 = false;
        goto L6
    }

    public FileTreeRvView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b(r100);
    }
}
