package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class FollowerSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f443248c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443249b;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FollowerSection f443250a;

        public b(FollowerSection r100) {
            this.f443250a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            List r111 = (List) r110;
            FollowerSection r100 = this.f443250a;
            Intrinsics.checkNotNull(r111);
            r100.getClass();
            int r101 = r111.size();
            if (r101 <= 0) goto L15;
            ((TextView) r100.f443249b.findViewById(R.id.text_add_follower)).setVisibility(8);
            ((LinearLayout) r100.f443249b.findViewById(R.id.detail_follower_container)).setClickable(false);
            r100.f443249b.findViewById(R.id.layout_follower).setVisibility(0);
            if (r111.size() <= 5) goto L7;
            r111 = r111.subList(0, 5);
        L7:
            TaskUDAvatarList r102 = (TaskUDAvatarList) r100.f443249b.findViewById(R.id.layout_follower).findViewById(R.id.avatar_list_view);
            ArrayList r103 = new ArrayList();
            Iterator<T> r104 = r111.iterator();
        L9:
            if (r104.hasNext() == false) goto L11;
            com.ss.android.lark.todo.impl.features.detail.viewmodel.i r105 = (com.ss.android.lark.todo.impl.features.detail.viewmodel.i) r104.next();
            r103.add(new c(r105.f443883a, r105.f443885c, false, 0));
            goto L9
        L11:
            r102.setAdapter(new d(r103, 0, 6));
            r102.setOverlapWidth(new UDDimension.Dp(4.0f));
            if (r101 != 1) goto L14;
            ((TextView) r100.f443249b.findViewById(R.id.layout_follower).findViewById(R.id.avatar_text)).setText(((com.ss.android.lark.todo.impl.features.detail.viewmodel.i) ListProtector.get(r111, 0)).f443884b);
            return;
        L14:
            ((TextView) r100.f443249b.findViewById(R.id.layout_follower).findViewById(R.id.avatar_text)).setText(UIHelper.getQuantityString(R.plurals.Todo_Task_NumFollower, r101));
            return;
        L15:
            ((TextView) r100.f443249b.findViewById(R.id.text_add_follower)).setVisibility(0);
            ((LinearLayout) r100.f443249b.findViewById(R.id.detail_follower_container)).setClickable(true);
            r100.f443249b.findViewById(R.id.layout_follower).setVisibility(8);
        }
    }

    static {
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
        View r100 = this.f443249b.findViewById(R.id.detail_follower_container);
        com.larksuite.framework.section.c r101 = b();
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a.m4 r102 = com.ss.android.lark.todo.impl.features.detail.viewmodel.a.m4.f443739a;
        com.larksuite.framework.section.utils.a.b(r100, r101, new com.ss.android.lark.todo.impl.features.detail.viewmodel.a[]{r102, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.c.f443674a});
        com.larksuite.framework.section.utils.a.b(this.f443249b.findViewById(R.id.layout_follower).findViewById(R.id.detail_owner_text_container), b(), new com.ss.android.lark.todo.impl.features.detail.viewmodel.a[]{r102, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.u1.f443777a});
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        e().getFollowers().observe(d(), new b(this));
        k(e().getUnFollowWarningDialog(), new FollowerSection$initViewObserver$2$1(this));
    }

    public FollowerSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443249b = r100;
    }
}
