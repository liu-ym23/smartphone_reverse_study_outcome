package pg5;

import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sbb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    static {
    }

    public static void a(UDAvatar r5, UserInfo r6) {
        r5.setBorderStyle(0);
        if (TextUtils.isEmpty(r6.getAvatarUrl()) == true) goto L5;
    L7:
        ImageLoader.with(r5.getContext()).load(new BearGlideUrl(r6.getAvatarUrl())).placeholder(2131235295).into(r5);
        return;
    L5:
        if (TextUtils.isEmpty(r6.getAvatarkey()) == true) goto L7;
        Intrinsics.checkNotNull(Glide.with(r5.getContext()).load(AvatarImage.Builder.obtain(r6.getAvatarkey(), r6.getId(), r5.getWidth(), r5.getHeight()).build()).placeholder(2131235295).into(r5));
    }

    @JvmStatic
    public static final void b(UDAvatar r8, UserInfo r9) {
        Intrinsics.checkNotNullParameter(r8, "avatar");
        Intrinsics.checkNotNullParameter(r9, "userInfo");
        boolean r2 = true;
        if (r9.getOwnerType() != 11) goto L5;
    L66:
        r8.setBorderStyle(1);
        r8.setImageResource(2131247735);
        return;
    L5:
        if (r9.getOwnerType() == 5) goto L66;
        if (r9.getOwnerType() != 8) goto L11;
        r8.setBorderStyle(0);
        r8.setImageResource(2131247734);
        return;
    L11:
        if (r9.getOwnerType() != 14) goto L14;
        r8.setBorderStyle(0);
        r8.setImageResource(2131247736);
        return;
    L14:
        if (r9.getOwnerType() != 16) goto L16;
    L65:
        r8.setBorderStyle(0);
        r8.setImageResource(2131247190);
        return;
    L16:
        if (r9.getOwnerType() == 23) goto L65;
        if (r9.getOwnerType() == 24) goto L65;
        if (r9.getOwnerType() == 28) goto L65;
        if (r9.getOwnerType() != 18) goto L25;
    L64:
        r8.setBorderStyle(0);
        r8.setImageResource(2131237750);
        return;
    L25:
        if (r9.getOwnerType() == 111) goto L64;
        if (r9.getOwnerType() != 22) goto L30;
    L63:
        r8.setBorderStyle(0);
        r8.setImageResource(2131235952);
        return;
    L30:
        if (r9.getOwnerType() == 30) goto L63;
        if (r9.getOwnerType() != 29) goto L36;
        r8.setBorderStyle(0);
        r8.setImageResource(2131235931);
        return;
    L36:
        if (r9.getOwnerType() != 108) goto L44;
        if (TextUtils.isEmpty(r9.getAvatarUrl()) == true) goto L40;
    L42:
        a(r8, r9);
        return;
    L40:
        if (TextUtils.isEmpty(r9.getAvatarkey()) == false) goto L42;
        r8.setBorderStyle(0);
        r8.setImageResource(2131235295);
        return;
    L44:
        if (r9.getOwnerType() != 110) goto L46;
    L54:
        r8.setBorderStyle(0);
        if (TextUtils.isEmpty(r9.getIconToken()) == true) goto L74;
        c r0 = c.a;
        String r1 = r9.getIconToken();
        r0.getClass();
        obb.b r3 = c.c(null, r1);
        if (r3 != null) goto L59;
        a(r8, r9);
        return;
    L59:
        String r4 = r3.b;
        if (r4 != null) goto L62;
        r4 = "";
    L62:
        mbb.c.g(r8, r4, r3.getType(), r9.getIconToken(), IconShape.CIRCLE, 32);
        return;
    L74:
        return;
    L46:
        if (r9.getOwnerType() == 46) goto L48;
    L50:
        r2 = false;
    L51:
        if (r2 == true) goto L54;
        a(r8, r9);
        return;
    L48:
        if (TextUtils.isEmpty(r9.getIconToken()) == true) goto L50;
        goto L50
    }
}
