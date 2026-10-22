package zdc;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements rcc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f571499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571500b;

    public f(SceneCoordinateRecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter("message_list_component", "tag");
        this.f571499a = r100;
        this.f571500b = "message_list_component";
    }

    @Override // rcc.d
    public final void a(int r100, int r101, int r102) {
        if (r101 != 0) goto L5;
        if (r102 != 0) goto L5;
        return;
    L5:
        if (r100 != r101) goto L7;
        return;
    L7:
        this.f571499a.post(new e(this, r101, r100));
    }
}
