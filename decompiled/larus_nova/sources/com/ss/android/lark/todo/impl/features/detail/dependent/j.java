package com.ss.android.lark.todo.impl.features.detail.dependent;

import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatar;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDTextAvatar;
import com.ss.android.lark.todo.impl.utils.m;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j extends TaskUDAvatarList.a<com.ss.android.lark.todo.impl.features.detail.sections.c> {
    public j(List<com.ss.android.lark.todo.impl.features.detail.sections.c> r100) {
        super(r100);
    }

    @Override // com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList.a
    public final void b(TaskUDTextAvatar r100) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        r100.setBorderColor(UDColorUtils.getColor(r100.getContext(), R.color.bg_body));
        r100.setBorderWidth(Float.valueOf(new UDDimension.Dp(2.0f).toPixels(r100.getContext())));
    }

    @Override // com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList.a
    public final void a(TaskUDAvatar r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        r100.setBorderColor(UDColorUtils.getColor(r100.getContext(), R.color.bg_body));
        r100.setBorderWidth(Float.valueOf(new UDDimension.Dp(2.0f).toPixels(r100.getContext())));
        com.ss.android.lark.todo.impl.features.detail.sections.c r102 = getItem(r101);
        if (r102 == null) goto L6;
        r100.setTag(R.id.tag_key_avatar_status_show, Boolean.valueOf(r102.f443344c));
        ImageLoader.with(r100.getContext()).load(AvatarImage.Builder.obtain(r102.f443343b, r102.f443342a, m.a(28), m.a(28)).build()).into(r100);
        return;
    }
}
