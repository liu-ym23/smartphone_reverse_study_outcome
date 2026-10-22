package tv2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.expression.i;
import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.android.livesdk.model.h;
import com.bytedance.android.livesdk.widget.board.k;
import com.bytedance.android.livesdk.widget.ui.NewEmojiSelectPanelV3;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f547666b;

    /* JADX INFO: renamed from: tv2.a$a, reason: collision with other inner class name */
    public static final class C7780a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final void getPageCount() {
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final String getPageName() {
        return CameraParam.TYPE_SYSTEM_CAMERA;
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final ExpressionSection b() {
        return new c(this.f547666b);
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new NewEmojiSelectPanelV3(r100, this.f547666b);
    }

    public a(boolean r100, i r101) {
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f547665a = r100;
        this.f547666b = r101;
    }

    @Override // com.bytedance.android.livesdk.model.h
    public final k c(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageView");
        return new b(r101, this.f547665a);
    }
}
