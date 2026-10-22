package com.ss.android.lark.widget.tab;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends CustomTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f448889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f448890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NavigationTabItemView f448891c;

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable r100) {
        NavigationTabItemView r101 = this.f448891c;
        if (r101.f448878d == false) goto L10;
        StringBuilder r102 = new StringBuilder("setRemoteDrawable() skipped due to external icon lock onLoadCleared, title=");
        TextView r103 = this.f448891c.f448879e;
        if (r103 != null) goto L7;
        CharSequence r104 = "";
    L8:
        r102.append(r104);
        Log.i("NavigationTabItemView", r102.toString());
        return;
    L7:
        r104 = r103.getText();
        goto L8
    L10:
        r101.f448877c.setImageDrawable(r100);
        Log.i("NavigationTabItemView", "setRemoteDrawable() cleared with: remoteDrawable = [" + this.f448890b + "]");
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public final void onLoadFailed(Drawable r100) {
        NavigationTabItemView r101 = this.f448891c;
        if (r101.f448878d == false) goto L10;
        StringBuilder r102 = new StringBuilder("setRemoteDrawable() skipped due to external icon lock onLoadFailed, title=");
        TextView r103 = this.f448891c.f448879e;
        if (r103 != null) goto L7;
        CharSequence r104 = "";
    L8:
        r102.append(r104);
        Log.i("NavigationTabItemView", r102.toString());
        return;
    L7:
        r104 = r103.getText();
        goto L8
    L10:
        r101.f448877c.setImageDrawable(r100);
        Log.i("NavigationTabItemView", "setRemoteDrawable() failed with: remoteDrawable = [" + this.f448890b + "]");
    }

    public b(NavigationTabItemView r100, d r101) {
        this.f448891c = r100;
        this.f448889a = false;
        this.f448890b = r101;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object r100, Transition r101) {
        Drawable r102 = (Drawable) r100;
        if (this.f448891c.f448878d == false) goto L10;
        StringBuilder r103 = new StringBuilder("setRemoteDrawable() skipped due to external icon lock onResourceReady, title=");
        TextView r104 = this.f448891c.f448879e;
        if (r104 != null) goto L7;
        CharSequence r105 = "";
    L8:
        r103.append(r105);
        Log.i("NavigationTabItemView", r103.toString());
        return;
    L7:
        r105 = r104.getText();
        goto L8
    L10:
        if (this.f448889a == false) goto L12;
        r102 = r102.mutate();
        r102.setTint(UIUtils.getColor(this.f448891c.getContext(), R.color.colorful_blue));
    L12:
        this.f448891c.f448877c.setImageDrawable(r102);
        Log.i("NavigationTabItemView", "setRemoteDrawable() success with: remoteDrawable = [" + this.f448890b + "]");
    }
}
