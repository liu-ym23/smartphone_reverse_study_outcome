package v19;

import android.content.Context;
import androidx.camera.core.processing.util.GLUtils;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.ss.ttm.player.C;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f552608a = 0;

    static {
    }

    public static String a(Context r100, long r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (com.larus.platform.api.f2.f365106a.h() == true) goto L27;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.CHINA.getLanguage()) == true) goto L27;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.JAPAN.getLanguage()) == true) goto L27;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.KOREA.getLanguage()) == true) goto L27;
        if (AppHost.f326268a.isOversea() == false) goto L27;
        if (r101 < 1000) goto L37;
        if (r101 >= 1000000) goto L21;
        String r102 = r100.getResources().getString(R.string.larus_botsComment_commentNum_K, new Object[]{b(r101, 1000)});
        Intrinsics.checkNotNull(r102);
        return r102;
    L21:
        if (r101 < C.NANOS_PER_SECOND) goto L23;
        String r103 = r100.getResources().getString(R.string.larus_botsComment_commentNum_billion, new Object[]{b(r101, C.NANOS_PER_SECOND)});
        Intrinsics.checkNotNull(r103);
        return r103;
    L23:
        String r104 = r100.getResources().getString(R.string.larus_botsComment_commentNum_million, new Object[]{b(r101, 1000000)});
        Intrinsics.checkNotNull(r104);
        return r104;
    L37:
        return String.valueOf(r101);
    L27:
        if (r101 < 10000) goto L33;
        if (r101 < 100000000) goto L31;
        String r105 = r100.getResources().getString(R.string.larus_botsComment_commentNum_10M, new Object[]{b(r101, 100000000)});
        Intrinsics.checkNotNull(r105);
        return r105;
    L31:
        String r106 = r100.getResources().getString(R.string.larus_botsComment_commentNum_10K, new Object[]{b(r101, 10000)});
        Intrinsics.checkNotNull(r106);
        return r106;
    L33:
        return String.valueOf(r101);
    }

    public static String b(long r100, long r101) {
        DecimalFormat r102 = new DecimalFormat(GLUtils.VERSION_UNKNOWN, new DecimalFormatSymbols(Locale.US));
        r102.setRoundingMode(RoundingMode.DOWN);
        return StringsKt.replace$default(r102.format(r100 / r101), ".0", "", false, 4, null);
    }
}
