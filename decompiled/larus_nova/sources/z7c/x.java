package z7c;

import android.text.Editable;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.q0;

/* JADX INFO: loaded from: classes38.dex */
public final class x extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f570852a;

    public x(v r100) {
        this.f570852a = r100;
    }

    @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        v r101 = this.f570852a;
        String r102 = "";
        if (r100 == null) goto L6;
        String r103 = r100.toString();
        if (r103 == null) goto L6;
    L7:
        r101.f570848g = r103;
        u.a r104 = this.f570852a.f570842a;
        if (r104 == null) goto L15;
        if (r100 == null) goto L14;
        String r105 = r100.toString();
        if (r105 == null) goto L14;
        r102 = r105;
    L14:
        r104.b(r102);
    L15:
        RecyclerView r106 = this.f570852a.f570844c;
        if (r106 == null) goto L18;
        r106.setVisibility(8);
    L18:
        ViewGroup r107 = this.f570852a.f570847f;
        if (r107 == null) goto L21;
        r107.setVisibility(8);
    L21:
        this.f570852a.b(true);
        return;
    L6:
        r103 = "";
        goto L7
    }
}
