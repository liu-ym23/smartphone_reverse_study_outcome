package e4c;

import com.larksuite.component.blockit.d;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.base.container.api.lifecycle.OPContainerLifecycleEventEnum;
import com.ss.android.lark.search.dto.info.SearchCustomizationInfo;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<SearchCustomizationInfo, a> f471036a;

    public final void a() {
        Iterator r100 = ((LinkedHashMap) this.f471036a).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        ((a) r100.next()).getClass();
        com.larksuite.component.blockit.b.a.f282974a.b();
        ((d) ApiUtils.getApi(d.class)).e();
        int r101 = sy7.a.f543894a;
        Intrinsics.checkNotNullParameter("fix_blockit_lifecycle_memory_leak_743_disable", "key");
        boolean r102 = FeatureGatingModule.getFeatureGatingService().isEnable("fix_blockit_lifecycle_memory_leak_743_disable");
        Log.d("BlockitFGHelper", "BlockitFGHelper isEnable key: fix_blockit_lifecycle_memory_leak_743_disable, isEnable: " + r102);
        if (r102 == true) goto L4;
        OPContainerLifecycleEventEnum r103 = OPContainerLifecycleEventEnum.ON_CREATE;
        ((d) ApiUtils.getApi(d.class)).h();
        goto L4
    }

    public b() {
        this.f471036a = new LinkedHashMap();
    }
}
