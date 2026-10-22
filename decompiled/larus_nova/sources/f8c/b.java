package f8c;

import com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends AtBean {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f475947c;

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtBean
    public int getType() {
        return 0;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtBean
    public final String a() {
        return this.f475947c;
    }

    public b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "label");
        super(r101);
        this.f475946b = r100;
        this.f475947c = r100;
    }
}
