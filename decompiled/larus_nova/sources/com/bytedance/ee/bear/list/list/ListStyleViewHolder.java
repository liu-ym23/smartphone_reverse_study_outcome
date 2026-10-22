package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ListStyleViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SwipeMenuLayout f228499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f228500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SpaceTagTitleView f228501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f228502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f228503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f228504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f228505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f228506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f228507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f228508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f228509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SyncStateView f228510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f228511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f228512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AppCompatImageView f228513o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f228514p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f228515q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListStyleViewHolder f228516a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f228516a.T3(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ListStyleViewHolder r100) {
            this.f228516a = r100;
        }
    }

    public ListStyleViewHolder(View r100) {
        super(r100);
        this.f228515q = new a(this);
        this.f228499a = (SwipeMenuLayout) r100.findViewById(R.id.list_item);
        this.f228500b = (ConstraintLayout) r100.findViewById(R.id.item_content);
        this.f228501c = (SpaceTagTitleView) r100.findViewById(R.id.item_name);
        this.f228502d = (TextView) r100.findViewById(R.id.update_time);
        this.f228503e = r100.findViewById(R.id.padding_view);
        this.f228504f = (ImageView) r100.findViewById(R.id.item_icon);
        this.f228505g = (ImageView) r100.findViewById(R.id.item_shortcut);
        this.f228506h = (ImageView) r100.findViewById(R.id.swipe_menu_more);
        this.f228507i = (ImageView) r100.findViewById(R.id.swipe_menu_share);
        this.f228508j = (ImageView) r100.findViewById(R.id.swipe_menu_delete);
        this.f228510l = (SyncStateView) r100.findViewById(R.id.item_sync_state);
        this.f228511m = (TextView) r100.findViewById(R.id.list_item_sync_state_desc);
        this.f228512n = (TextView) r100.findViewById(R.id.list_item_security_desc);
        this.f228513o = (AppCompatImageView) r100.findViewById(R.id.item_external_notice);
        this.f228509k = (ImageView) r100.findViewById(R.id.list_pad_menu_more);
    }

    public final void T3(int r100) {
        tt5.a.h("ListStyleViewHolder", "setSyncState()...state = " + r100 + ", preState = " + this.f228514p + ", securityVisible = false");
        switch(r100) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        this.f228502d.setVisibility(0);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(8);
        this.f228511m.removeCallbacks(this.f228515q);
    L20:
        this.f228514p = r100;
        return;
    L5:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_List_OfflineDownloadFailed);
        goto L20
    L6:
        int r101 = this.f228514p;
        if (r101 != 5) goto L9;
    L12:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_List_OfflineDownloadSucceed);
        this.f228515q.getClass();
        this.f228511m.postDelayed(this.f228515q, 1000);
        goto L20
    L9:
        if (r101 == 6) goto L12;
        this.f228502d.setVisibility(0);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(8);
        goto L20
    L13:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_List_OfflineDownloading);
        goto L20
    L14:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_List_OfflineWaitDownload);
        goto L20
    L15:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_List_SyncFailed);
        goto L20
    L16:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_Normal_FinishSynchronizing);
        this.f228511m.postDelayed(this.f228515q, 1000);
        goto L20
    L17:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_List_Syncing);
        goto L20
    L18:
        this.f228502d.setVisibility(8);
        this.f228512n.setVisibility(8);
        this.f228511m.setVisibility(0);
        this.f228511m.setText(R.string.Doc_List_WaitingForSync);
        goto L20
    }
}
