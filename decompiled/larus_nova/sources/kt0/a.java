package kt0;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfilePoiInfo;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements jt0.a {
    public a() {
    }

    @Override // jt0.a
    public final void a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jt0.a
    public final List<ProfileTagContent> b(List<? extends ProfileTagContent> r100, NewProfileUser r101) {
        Intrinsics.checkNotNullParameter(r101, "user");
        ProfilePoiInfo r102 = r101.baseProfileInfo.poiInfo;
        if (r102 == null) goto L5;
        long r103 = r102.getPoiId();
    L7:
        if (r103 > 0) goto L9;
        return r100;
    L9:
        if (r100 == 0) goto L12;
        List<ProfileTagContent> r104 = CollectionsKt.toMutableList(r100);
        if (r104 == null) goto L12;
    L13:
        ProfileTagContent r105 = new ProfileTagContent();
        r105.tagType = ProfileTagContent.TAG_TYPE_POI;
        r105.tagName = AppletNaviType.POI;
        Unit r106 = Unit.INSTANCE;
        ListProtector.add(r104, 0, r105);
        return r104;
    L12:
        r104 = new ArrayList();
        goto L13
    L5:
        r103 = 0;
        goto L7
    }
}
