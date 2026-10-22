package iq5;

import com.bytedance.ee.bear.wikiv2.selector.FolderSelectFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements sa5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FolderSelectFragment f495343a;

    public b(FolderSelectFragment r100) {
        this.f495343a = r100;
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        this.f495343a.back();
        return true;
    }
}
