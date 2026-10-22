package oab;

import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.custom.repeat.ChooseRepeatFragment;
import com.ss.android.lark.custom.repeat.entity.RruleListItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class c implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f522588a;

    public c() {
        this.f522588a = 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        long r104 = SystemClock.uptimeMillis();
        if ((r104 - this.f522588a) <= 1000) goto L11;
        com.ss.android.lark.custom.repeat.f r105 = (com.ss.android.lark.custom.repeat.f) this;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "view");
        ChooseRepeatFragment r106 = r105.f420327b;
        if (r106.f420271e == r102) goto L9;
        r106.f420271e = r102;
        mab.e r107 = r106.f420272f;
        if (r107 == null) goto L9;
        r107.notifyDataSetChanged();
    L9:
        ChooseRepeatFragment r108 = r105.f420327b;
        ChooseRepeatFragment.S90(r108, ((RruleListItem) ListProtector.get(r108.f420273g, r108.f420271e)).getRrule());
        this.f522588a = r104;
        return;
    }
}
