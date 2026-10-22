package j86;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f497724a;

    @Override // j86.c
    public final int getItemsCount() {
        return this.f497724a.size();
    }

    public a(List<String> r100) {
        this.f497724a = r100;
    }

    @Override // j86.c
    public final String getItem(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        return "";
    L4:
        if (r100 >= this.f497724a.size()) goto L6;
        return (String) ListProtector.get(this.f497724a, r100);
    }
}
