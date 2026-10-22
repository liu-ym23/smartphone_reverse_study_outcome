package wz3;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.d;
import com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.anchor.BottomBarElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends BaseGroup<b, FrameLayout, tz3.a, jz3.a> {
    public final Activity j;
    public final o k;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b l;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ArrayList<BaseElement<?, ?, ?, jz3.a>> c() {
        return CollectionsKt.arrayListOf(new BaseElement[]{new com.bytedance.awemeopen.apps.framework.feed.ui.bottombar.mix.c(this.j, this.k), new BottomBarElement(this.j, this.k, this.l)});
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void h() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void j() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final d a() {
        return new b();
    }

    public final Activity getActivity() {
        return this.j;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ViewGroup b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ViewGroup.LayoutParams r0 = new ConstraintLayout.LayoutParams(-1, -2);
        ((ConstraintLayout.LayoutParams) r0).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r0).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r0).rightToRight = 0;
        FrameLayout r1 = new FrameLayout(r4);
        r1.setLayoutParams(r0);
        r1.setId(2131363067);
        return r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void g(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public c(Activity r2, o r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "pageOwner");
        super(r2);
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }
}
