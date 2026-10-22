package fd5;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends i {
    @Override // fd5.i
    public final void a() {
        if (NodeType.isShortcut(this.f476528b.M1) == false) goto L5;
        int r100 = rbb.b.g();
    L9:
        this.f476529c.setImageResource(r100);
        return;
    L5:
        Document r101 = this.f476528b;
        if (FolderVersion.isShareFolder(r101.L1, r101.P1) == false) goto L8;
        r100 = rbb.b.g();
        goto L9
    L8:
        r100 = ua5.a.i(sbb.e.f541295f.f541317b);
        goto L9
    }

    public h(Context r100, Document r101, ImageView r102) {
        super(r100, r101, r102);
    }
}
