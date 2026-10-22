package fs4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeFieldPropertyEditViewHolder;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeSource;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.ee.bear.bitable.panel.l;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ModifiedTimeFieldPropertyEditViewHolder f478658a;

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final /* synthetic */ void onExit() {
    }

    public a(ModifiedTimeFieldPropertyEditViewHolder r100) {
        this.f478658a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r100, "id");
        boolean r101 = TextUtils.equals(r100, "true");
        if (r101 == false) goto L5;
        String r102 = ModifiedTimeWatch.WATCH_TYPE_SPECIFIC;
    L6:
        ModifiedTimeFieldPropertyEditViewHolder r103 = this.f478658a;
        if (r103.f211474m != null) goto L9;
        r103.f211474m = new ModifiedTimeWatch();
    L9:
        ModifiedTimeWatch r104 = this.f478658a.f211474m;
        if (r104 == null) goto L12;
        r104.setType(r102);
    L12:
        ModifiedTimeSource r105 = null;
        if (r101 == false) goto L21;
        ModifiedTimeWatch r106 = this.f478658a.f211474m;
        if (r106 == null) goto L17;
        r105 = r106.getSource();
    L17:
        if (r105 != null) goto L24;
        ModifiedTimeWatch r107 = this.f478658a.f211474m;
        if (r107 == null) goto L24;
        ModifiedTimeSource r108 = new ModifiedTimeSource();
        r108.setFields(new ArrayList());
        r107.setSource(r108);
    L24:
        this.f478658a.B();
        return;
    L21:
        ModifiedTimeWatch r109 = this.f478658a.f211474m;
        if (r109 == null) goto L24;
        r109.setSource(null);
        goto L24
    L5:
        r102 = "all";
        goto L6
    }
}
