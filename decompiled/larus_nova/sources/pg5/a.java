package pg5;

import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sbb.c;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    static {
    }

    public static void a(UDAvatar r100, UserInfo r101) {
        r100.setBorderStyle(0);
        if (TextUtils.isEmpty(r101.getAvatarUrl()) == true) goto L5;
    L7:
        ImageLoader.with(r100.getContext()).load(new BearGlideUrl(r101.getAvatarUrl())).placeholder(R.drawable.facade_common_avatar_place_holder).into(r100);
        return;
    L5:
        if (TextUtils.isEmpty(r101.getAvatarkey()) == true) goto L7;
        Intrinsics.checkNotNull(Glide.with(r100.getContext()).load(AvatarImage.Builder.obtain(r101.getAvatarkey(), r101.getId(), r100.getWidth(), r100.getHeight()).build()).placeholder(R.drawable.facade_common_avatar_place_holder).into(r100));
    }

    @JvmStatic
    public static final void b(UDAvatar r100, UserInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "avatar");
        Intrinsics.checkNotNullParameter(r101, "userInfo");
        boolean r102 = true;
        if (r101.getOwnerType() != 11) goto L5;
    L66:
        r100.setBorderStyle(1);
        r100.setImageResource(R.drawable.share_ic_sharefolder);
        return;
    L5:
        if (r101.getOwnerType() == 5) goto L66;
        if (r101.getOwnerType() != 8) goto L11;
        r100.setBorderStyle(0);
        r100.setImageResource(R.drawable.share_ic_link);
        return;
    L11:
        if (r101.getOwnerType() != 14) goto L14;
        r100.setBorderStyle(0);
        r100.setImageResource(R.drawable.share_ic_vc_follow);
        return;
    L14:
        if (r101.getOwnerType() != 16) goto L16;
    L65:
        r100.setBorderStyle(0);
        r100.setImageResource(R.drawable.perm_icon_wiki_avatar);
        return;
    L16:
        if (r101.getOwnerType() == 23) goto L65;
        if (r101.getOwnerType() == 24) goto L65;
        if (r101.getOwnerType() == 28) goto L65;
        if (r101.getOwnerType() != 18) goto L25;
    L64:
        r100.setBorderStyle(0);
        r100.setImageResource(R.drawable.icon_collaborator_organization);
        return;
    L25:
        if (r101.getOwnerType() == 111) goto L64;
        if (r101.getOwnerType() != 22) goto L30;
    L63:
        r100.setBorderStyle(0);
        r100.setImageResource(R.drawable.ic_icon_usergroup);
        return;
    L30:
        if (r101.getOwnerType() == 30) goto L63;
        if (r101.getOwnerType() != 29) goto L36;
        r100.setBorderStyle(0);
        r100.setImageResource(R.drawable.ic_icon_collaborator_email);
        return;
    L36:
        if (r101.getOwnerType() != 108) goto L44;
        if (TextUtils.isEmpty(r101.getAvatarUrl()) == true) goto L40;
    L42:
        a(r100, r101);
        return;
    L40:
        if (TextUtils.isEmpty(r101.getAvatarkey()) == false) goto L42;
        r100.setBorderStyle(0);
        r100.setImageResource(R.drawable.facade_common_avatar_place_holder);
        return;
    L44:
        if (r101.getOwnerType() != 110) goto L46;
    L54:
        r100.setBorderStyle(0);
        if (TextUtils.isEmpty(r101.getIconToken()) == true) goto L74;
        c r103 = c.f541290a;
        String r104 = r101.getIconToken();
        r103.getClass();
        obb.b r105 = c.c(null, r104);
        if (r105 != null) goto L59;
        a(r100, r101);
        return;
    L59:
        String r106 = r105.f522638b;
        if (r106 != null) goto L62;
        r106 = "";
    L62:
        mbb.c.g(r100, r106, r105.getType(), r101.getIconToken(), IconShape.CIRCLE, 32);
        return;
    L74:
        return;
    L46:
        if (r101.getOwnerType() == 46) goto L48;
    L50:
        r102 = false;
    L51:
        if (r102 == true) goto L54;
        a(r100, r101);
        return;
    L48:
        if (TextUtils.isEmpty(r101.getIconToken()) == true) goto L50;
        goto L50
    }
}
