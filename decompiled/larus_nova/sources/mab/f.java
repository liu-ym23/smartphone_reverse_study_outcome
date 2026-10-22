package mab;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f512747a;

    @Override // mab.a
    public final int getItemsCount() {
        return this.f512747a.size();
    }

    @Override // mab.a
    public final String a() {
        return UIHelper.getString(R.string.Calendar_TimeFormat_DaysMobile);
    }

    public f(List<String> r100) {
        this.f512747a = r100;
    }

    public final String b(int r100) {
        if (CollectionUtils.isNotEmpty(this.f512747a) == true) goto L5;
        return "";
    L5:
        if (r100 < getItemsCount()) goto L7;
        return "";
    L7:
        return (String) ListProtector.get(this.f512747a, r100);
    }

    @Override // mab.a
    public final /* bridge */ /* synthetic */ String getItem(int r100) {
        return b(r100);
    }

    @Override // mab.a
    public final int indexOf(String r100) {
        List<String> r101 = this.f512747a;
        return r101.indexOf(r100);
    }
}
