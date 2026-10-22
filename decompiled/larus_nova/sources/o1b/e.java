package o1b;

import com.bytedance.lark.pb.openplatform.v1.CommonEnum;
import com.bytedance.lark.pb.openplatform.v1.OpenAppBadgeNode;
import com.bytedance.lark.pb.openplatform.v1.PushOpenAppBadgeNodesRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyOpenAppBadgeNode;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyOpenAppFeatureType;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyPushOpenAppBadgeNodesRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f521734a = null;

        static {
            int[] r100 = new int[CommonEnum.OpenAppFeatureType.values().length];
            r100[CommonEnum.OpenAppFeatureType.MiniApp.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommonEnum.OpenAppFeatureType.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f521734a = r100;
        }
    }

    public static final MyPushOpenAppBadgeNodesRequest a(PushOpenAppBadgeNodesRequest r110) {
        Intrinsics.checkNotNullParameter(r110, "value");
        String r100 = r110.sid;
        List<OpenAppBadgeNode> r111 = r110.notice_nodes;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L21;
        OpenAppBadgeNode r102 = (OpenAppBadgeNode) r112.next();
        String r103 = r102.f253673id;
        String r104 = r102.app_id;
        CommonEnum.OpenAppFeatureType r105 = r102.feature;
        if (r105 != null) goto L8;
        int r106 = -1;
    L9:
        if (r106 != (-1)) goto L11;
        MyOpenAppFeatureType r107 = null;
    L19:
        r101.add(new MyOpenAppBadgeNode(r103, r104, r107, r102.need_show, r102.update_time, r102.badge_num.intValue(), r102.extra, r102.version));
        goto L4
    L11:
        if (r106 != 1) goto L13;
        r107 = MyOpenAppFeatureType.MiniApp;
        goto L19
    L13:
        if (r106 != 2) goto L16;
        r107 = MyOpenAppFeatureType.H5;
        goto L19
    L16:
        throw new NoWhenBranchMatchedException();
    L8:
        r106 = a.f521734a[r105.ordinal()];
        goto L9
    L21:
        return new MyPushOpenAppBadgeNodesRequest(r101, r100);
    }
}
