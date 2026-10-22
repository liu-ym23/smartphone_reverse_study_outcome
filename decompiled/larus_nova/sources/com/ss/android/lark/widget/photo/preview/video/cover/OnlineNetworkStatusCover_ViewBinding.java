package com.ss.android.lark.widget.photo.preview.video.cover;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class OnlineNetworkStatusCover_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnlineNetworkStatusCover f447161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f447162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f447163c;

    public class a extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnlineNetworkStatusCover f447164a;

        public a(OnlineNetworkStatusCover r100) {
            this.f447164a = r100;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public final void doClick(View r100) {
            this.f447164a.onCancelClick(r100);
        }
    }

    public class b extends DebouncingOnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnlineNetworkStatusCover f447165a;

        public b(OnlineNetworkStatusCover r100) {
            this.f447165a = r100;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public final void doClick(View r100) {
            this.f447165a.onContinueClick(r100);
        }
    }

    @Override // butterknife.Unbinder
    public final void unbind() {
        OnlineNetworkStatusCover r100 = this.f447161a;
        if (r100 == null) goto L7;
        this.f447161a = null;
        r100.mStatusTip = null;
        r100.mStatusCancel = null;
        r100.mStatusContinue = null;
        this.f447162b.setOnClickListener(null);
        this.f447162b = null;
        this.f447163c.setOnClickListener(null);
        this.f447163c = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public OnlineNetworkStatusCover_ViewBinding(OnlineNetworkStatusCover r100, View r101) {
        this.f447161a = r100;
        r100.mStatusTip = (TextView) Utils.findRequiredViewAsType(r101, R.id.status_tip, "field 'mStatusTip'", TextView.class);
        View r102 = Utils.findRequiredView(r101, R.id.status_cancel, "field 'mStatusCancel' and method 'onCancelClick'");
        r100.mStatusCancel = r102;
        this.f447162b = r102;
        r102.setOnClickListener(new a(r100));
        View r103 = Utils.findRequiredView(r101, R.id.status_continue, "field 'mStatusContinue' and method 'onContinueClick'");
        r100.mStatusContinue = r103;
        this.f447163c = r103;
        r103.setOnClickListener(new b(r100));
    }
}
