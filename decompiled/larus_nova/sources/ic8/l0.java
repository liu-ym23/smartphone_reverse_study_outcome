package ic8;

import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class l0 {
    public static final boolean a(List<Integer> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (AppHost.f326268a.isPlugin() == false) goto L8;
        return false;
    L8:
        PageType r101 = PageType.Chat;
        if (r100.contains(Integer.valueOf(r101.getType())) == false) goto L15;
        if (r100.contains(Integer.valueOf(PageType.AI_GENERATE.getType())) == false) goto L15;
        return !com.larus.platform.service.e0.f365731a.j();
    L15:
        if (r100.contains(Integer.valueOf(r101.getType())) == false) goto L21;
        if (r100.contains(Integer.valueOf(PageType.VIDEO.getType())) == false) goto L21;
        return SettingRepoDelegate.f307752b.q0();
    L21:
        if (r100.contains(Integer.valueOf(r101.getType())) == true) goto L23;
        return false;
    L23:
        if (r100.contains(Integer.valueOf(PageType.AWEME_FEED.getType())) == true) goto L25;
        return false;
    L25:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L27;
        return false;
    L27:
        if (SettingRepoDelegate.f307752b.q0() == false) goto L33;
        return true;
    L33:
        return false;
    }

    public static final boolean b(List<Integer> r100) {
        if (a(r100) == false) goto L6;
        return true;
    L6:
        if (r100 == null) goto L13;
        Integer r101 = (Integer) CollectionsKt.getOrNull(r100, 0);
        int r102 = PageType.Chat.getType();
        if (r101 == null) goto L13;
        if (r101.intValue() != r102) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L26;
        Integer r104 = (Integer) CollectionsKt.getOrNull(r100, 1);
        int r105 = PageType.IMAGE_TEMPLATE.getType();
        if (r104 != null) goto L19;
    L20:
        Integer r106 = (Integer) CollectionsKt.getOrNull(r100, 1);
        int r107 = PageType.MUSIC_TEMPLATE.getType();
        if (r106 == null) goto L26;
        if (r106.intValue() != r107) goto L26;
        return true;
    L19:
        if (r104.intValue() != r105) goto L20;
        return true;
    L26:
        return false;
    L13:
        r103 = false;
        goto L14
    }
}
