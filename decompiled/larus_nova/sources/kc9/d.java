package kc9;

import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.platform.api.OfficeUrlPreviewHostCardType;
import com.larus.platform.api.OfficeUrlPreviewHostRenderResult;
import com.larus.platform.api.z0;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewRenderResult;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sza.a f502686a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f502687a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f502688b = null;

        static {
            int[] r100 = new int[OfficeUrlPreviewHostCardType.values().length];
            r100[OfficeUrlPreviewHostCardType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[OfficeUrlPreviewHostCardType.COMPACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            f502687a = r100;
            int[] r101 = new int[UrlPreviewRenderResult.values().length];
            r101[UrlPreviewRenderResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r101[UrlPreviewRenderResult.RENDER_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r101[UrlPreviewRenderResult.NO_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[UrlPreviewRenderResult.NO_RENDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            f502688b = r101;
        }
    }

    public d(sza.a r100) {
        this.f502686a = r100;
    }

    @Override // com.larus.platform.api.z0
    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        this.f502686a.s(r100);
    }

    @Override // com.larus.platform.api.z0
    public final void t(List<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "previewIds");
        this.f502686a.J(r100);
    }

    @Override // com.larus.platform.api.z0
    public final OfficeUrlPreviewHostRenderResult u(String r100, OfficeUrlPreviewHostCardType r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r101, "cardType");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        int r103 = a.f502687a[r101.ordinal()];
        if (r103 == 1) goto L8;
        if (r103 != 2) goto L7;
        UrlPreviewCardType r104 = UrlPreviewCardType.COMPACT;
    L9:
        UrlPreviewRenderResult r105 = this.f502686a.j0(r100, r104, r102);
        int r106 = a.f502688b[r105.ordinal()];
        if (r106 == 1) goto L22;
        if (r106 == 2) goto L25;
        if (r106 == 3) goto L24;
        if (r106 != 4) goto L18;
        return OfficeUrlPreviewHostRenderResult.NO_RENDER;
    L18:
        throw new NoWhenBranchMatchedException();
    L24:
        return OfficeUrlPreviewHostRenderResult.NO_DATA;
    L25:
        return OfficeUrlPreviewHostRenderResult.RENDER_FAILED;
    L22:
        return OfficeUrlPreviewHostRenderResult.SUCCESS;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r104 = UrlPreviewCardType.DEFAULT;
        goto L9
    }
}
