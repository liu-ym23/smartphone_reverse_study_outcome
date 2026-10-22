package fd5;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends i {
    @Override // fd5.i
    public final void a() {
        if (NodeType.isShortcut(this.b.M1) == false) goto L5;
        int r0 = rbb.b.g();
    L9:
        this.c.setImageResource(r0);
        return;
    L5:
        Document r1 = this.b;
        if (FolderVersion.isShareFolder(r1.L1, r1.P1) == false) goto L8;
        r0 = rbb.b.g();
        goto L9
    L8:
        r0 = ua5.a.i(sbb.e.f.b);
        goto L9
    }

    public h(Context r1, Document r2, ImageView r3) {
        super(r1, r2, r3);
    }
}
