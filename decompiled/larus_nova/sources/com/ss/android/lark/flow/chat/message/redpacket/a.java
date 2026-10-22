package com.ss.android.lark.flow.chat.message.redpacket;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDAvatarList;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends UDAvatarList.AvatarAdapter<ChatterInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ChatterInfo> f422666a;

    @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
    public final UDAvatar getMoreAvatar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return getAvatar(r100, getMaxCount() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, List<? extends ChatterInfo> r101) {
        Intrinsics.checkNotNullParameter(r101, "avatarList");
        super(r100, r101);
        this.f422666a = r101;
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
    public final UDAvatar getAvatar(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (getItem(r101) == null) goto L6;
        UDAvatar r102 = new UDAvatar(r100);
        r102.setBorderColor(UDColorUtils.getColor(r100, R.color.lkui_Y300));
        r102.setBorderWidth(Float.valueOf(UIUtils.dp2px(r100, 1.0f)));
        r102.setAvatarSize(getAvatarSize());
        r102.setBackgroundColor(UDColorUtils.getColor(r100, R.color.bg_filler));
        onItemCreated(r102, r101);
        return r102;
    L6:
        return null;
    }

    @Override // com.larksuite.component.universe_design.image.UDAvatarList.AvatarAdapter
    public final void onItemCreated(UDAvatar r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        ChatterInfo r102 = getItem(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        AvatarImage r103 = AvatarImage.Builder.obtain(r102.getAvatarKey(), r102.getId(), getAvatarSize(), getAvatarSize()).build();
        ImageLoader.with(r100.getContext()).load(r103).placeholder(new ColorDrawable(UIUtils.getColor(r100.getContext(), R.color.fill_tag))).override(getAvatarSize(), getAvatarSize()).into(r100);
    }
}
