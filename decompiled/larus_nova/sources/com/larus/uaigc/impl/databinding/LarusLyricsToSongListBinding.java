package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.music.widget.NestedRecyclerView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusLyricsToSongListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f373243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f373244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedRecyclerView f373245c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373243a;
    }

    public LarusLyricsToSongListBinding(LinearLayout r100, TextView r101, NestedRecyclerView r102) {
        this.f373243a = r100;
        this.f373244b = r101;
        this.f373245c = r102;
    }
}
