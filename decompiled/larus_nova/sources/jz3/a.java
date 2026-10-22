package jz3;

import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.f;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;
import r14.c;
import s14.d;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f501173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f501174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f501175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f501176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f501177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f501178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f501179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f501180h;

    public a(c r100, f r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        this.f501173a = r100;
        this.f501174b = r101;
        this.f501175c = r102;
        this.f501176d = -1;
    }

    public /* synthetic */ a(c r100, f r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, null);
    }
}
