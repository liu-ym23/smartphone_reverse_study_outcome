package sz7;

import android.content.Context;
import com.ss.android.lark.assembly.avatar.officesdk.OfficeInitAvatarLoaderTask;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f544031a = 0;

    public static final class a {
        @JvmStatic
        public static s a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            h r101 = v.f544034b;
            if (r101 == null) goto L12;
            OfficeInitAvatarLoaderTask.a r102 = (OfficeInitAvatarLoaderTask.a) r101;
            if (r102.f408959a != null) goto L10;
            Log.i("OfficeAvatar", String.format("fg, docIcon:%s, badgeTag:%s, threadBadge:%s", new Object[]{Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom")), Boolean.TRUE, Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("lark_feature_doc_icon_custom"))}));
            if (com.larksuite.framework.utils.z.e(r102.f408960b) == false) goto L9;
            r102.f408959a = new OfficeInitAvatarLoaderTask.g();
            goto L10
        L9:
            r102.f408959a = new OfficeInitAvatarLoaderTask.h();
        L10:
            j r103 = r102.f408959a;
            if (r103 == null) goto L12;
        L14:
            return new s(r100, r103);
        L12:
            r103 = v.f544036d;
            goto L14
        }
    }

    static {
    }
}
