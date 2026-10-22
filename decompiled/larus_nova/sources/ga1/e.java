package ga1;

import android.os.Parcelable;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.livesdkapi.app.AppConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public e() {
    }

    public final Parcelable a(ia1.b r110, boolean r111) {
        ja1.a r100 = r110.f488846d;
        if (r100 != null) goto L5;
        r100 = new ja1.a(r110.f488844b, r110.f488843a, r110.f488845c);
    L5:
        if (r111 == false) goto L8;
        BaseHybridParamVo r112 = null;
    L7:
        BaseHybridParamVo r101 = r112;
        BaseHybridParamVo.HybridType r113 = BaseHybridParamVo.HybridType.LYNX;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r101.f100519a = r113;
    L12:
        String r114 = (String) r100.a("fallback_url", "");
        boolean r102 = false;
        if (((Number) r100.a(AppConstants.ARG_ABANDON_COORDINATE, 0)).intValue() != 1) goto L15;
        boolean r103 = true;
    L17:
        if (((Number) r100.a(AppConstants.BUNDLE_IS_SLIDE_CENTER, 0)).intValue() != 1) goto L19;
        boolean r104 = true;
    L20:
        String r115 = (String) r100.a(AppConstants.BUNDLE_FALLBACK_URL, "");
        int r105 = ((Number) r100.a("lynx_thread", 0)).intValue();
        if (((Number) r100.a("enable_lynx_bg", 0)).intValue() != 1) goto L23;
        boolean r106 = true;
    L25:
        if (r114.length() != 0) goto L27;
        r102 = true;
    L27:
        if (r102 == false) goto L29;
        String r107 = r115;
    L31:
        return new LynxHybridParamVo(r107, r105, r106, r103, r104, r101, 8);
    L29:
        r107 = r114;
        goto L31
    L23:
        r106 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L15:
        r103 = false;
        goto L17
    L8:
        r112 = com.bytedance.android.live.schema.helper.a.a(r110.f488843a, r110.f488844b, r110.f488845c, r100);
        goto L7
    }
}
