package iq5;

import com.bytedance.ee.bear.wikiv2.selector.FolderSelectFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements sa5.d {
    public final /* synthetic */ FolderSelectFragment a;

    public b(FolderSelectFragment r1) {
        this.a = r1;
    }

    public final boolean onBackPressed() {
        this.a.back();
        return true;
    }
}
