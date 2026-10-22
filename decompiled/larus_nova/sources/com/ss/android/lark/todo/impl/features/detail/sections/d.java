package com.ss.android.lark.todo.impl.features.detail.sections;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatar;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDTextAvatar;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends TaskUDAvatarList.a<c> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f443348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f443349f;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList.a
    public final void b(TaskUDTextAvatar r100) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        r100.setAvatarSize((int) UIHelper.sp2px(24.0f));
        r100.setAvatarTextSize((int) UIHelper.sp2px(14.0f));
        r100.setBorderWidth(Float.valueOf(new UDDimension.b(2.0f).toPixels(r100.getContext())));
    }

    @Override // com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList.a
    public final void a(TaskUDAvatar r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        r100.setBorderColor(UDColorUtils.getColor(r100.getContext(), this.f443348e));
        r100.setBorderWidth(Float.valueOf(new UDDimension.b(2.0f).toPixels(r100.getContext())));
        r100.setAvatarSize((int) UIHelper.sp2px(24.0f));
        c r102 = getItem(r101);
        if (r102 == null) goto L12;
        r100.setTag(R.id.tag_key_avatar_status_show, Boolean.valueOf(r102.f443344c));
        IRequestCreator r103 = ImageLoader.with(r100.getContext()).load(AvatarImage.Builder.obtain(r102.f443343b, r102.f443342a, r100.getAvatarSize(), r100.getAvatarSize()).build());
        if (this.f443349f == false) goto L10;
        r103.override(r100.getAvatarSize(), r100.getAvatarSize());
        float r104 = r100.getSoftwareClipCornerRadius();
        if (r104 <= 0.0f) goto L9;
        r103.transform(new RoundedCorners((int) r104));
        goto L10
    L9:
        r103.transform(new CircleCrop());
    L10:
        r103.into(r100);
        return;
    }

    public d(List r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = R.color.bg_body_overlay;
    L8:
        super(r100);
        this.f443348e = r101;
        this.f443349f = false;
    }
}
