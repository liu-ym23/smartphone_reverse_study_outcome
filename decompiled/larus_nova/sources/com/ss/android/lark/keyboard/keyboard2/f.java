package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f429545a = null;

    public static final class a implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f429546b = null;

        static {
            f429546b = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.f
        public final void a(KBMenuContainerView r100, List<? extends View> r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r101, "visibleChildViews");
            int r102 = UIUtils.dp2px(r100.getContext(), 6.0f);
            Iterator<T> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L10;
            View r104 = (View) r103.next();
            ViewGroup.LayoutParams r105 = r104.getLayoutParams();
            if (r105 == null) goto L9;
            ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
            r106.rightMargin = r102;
            r104.setLayoutParams(r106);
            goto L4
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    static {
        f429545a = a.f429546b;
    }

    void a(KBMenuContainerView r100, List<? extends View> r101);
}
