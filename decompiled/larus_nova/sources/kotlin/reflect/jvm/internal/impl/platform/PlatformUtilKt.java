package kotlin.reflect.jvm.internal.impl.platform;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class PlatformUtilKt {
    public static final String getPresentableDescription(TargetPlatform r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CollectionsKt.joinToString$default(r100.getComponentPlatforms(), HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
    }
}
