package com.ss.android.lark.feed.shared.page.binder2;

import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedCommonViewHolder f421367a;

    public i(FeedCommonViewHolder r100) {
        this.f421367a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Intrinsics.checkNotNullParameter((FeedSlideActionSetting) r100, "it");
        FeedCommonViewHolder r101 = this.f421367a;
        r101.f421329w = false;
        r101.f421330x = true;
    }
}
