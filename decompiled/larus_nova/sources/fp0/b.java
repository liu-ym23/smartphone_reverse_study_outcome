package fp0;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.AppPrivilege;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.nova.R;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final void a(TextView r110, HSImageView r111, View r112, View r113, View r114, View r115, Function2 r116, MiniAppEntranceCell r210, int r211) {
        String r100 = r210.title;
        if (r100 != null) goto L5;
    L12:
        r100 = "";
    L13:
        r110.setText(r100);
        GenericDraweeHierarchy r101 = r111.getHierarchy();
        r111.setActualImageResource(R.drawable.ttlive_mini_app_choose_list_icon_default);
        r101.setPlaceholderImage(R.drawable.ttlive_mini_app_choose_list_icon_default);
        r101.setFailureImage(R.drawable.ttlive_mini_app_choose_list_icon_default);
        r111.setHierarchy(r101);
        ImageModel r102 = r210.icon;
        if (r102 == null) goto L19;
        List<String> r103 = r102.getUrls();
        if (r103 == null) goto L19;
        String r104 = (String) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L19;
    L21:
        if (r104.length() <= 0) goto L23;
        boolean r105 = true;
    L24:
        if (r105 == true) goto L27;
        r104 = null;
    L27:
        if (r104 == null) goto L30;
        r111.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse(r104)).build());
    L30:
        if (Intrinsics.areEqual(((JSONObject) r210.f84118a.getValue()).optString("app_privilege", ""), AppPrivilege.BIND_SELF_MOUNT.getValue()) == false) goto L32;
        r114.setVisibility(0);
        r113.setVisibility(8);
        r112.setVisibility(8);
    L33:
        Object r106 = n80.a.f518238a;
        new n80.b(r115).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a(r116, r210, r211));
        return;
    L32:
        r114.setVisibility(8);
        r113.setVisibility(8);
        r112.setVisibility(8);
        goto L33
    L23:
        r105 = false;
    L19:
        r104 = "";
        goto L21
    L5:
        if (r210.groupId == 2) goto L7;
    L9:
        if (r100 != null) goto L13;
    L7:
        if (r100.length() <= 4) goto L9;
        r100 = r100.substring(0, 4) + "...";
        goto L9
    }
}
