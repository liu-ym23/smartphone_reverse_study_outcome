package s32;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.StreamRecognitionResponse;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements ImageRecognitionBusiness {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageRecognitionBusiness f540447a;

    public static final class a implements ImageRecognitionButton {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f540448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f540449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f540450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageRecognitionButton f540451d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageRecognitionEntry f540452e;

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final boolean canShow() {
            return this.f540451d.canShow();
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final boolean canShowRedDot() {
            return this.f540451d.canShowRedDot();
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final void onHide() {
            this.f540451d.onHide();
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final void onShow() {
            this.f540451d.onShow();
            int r100 = e.f540453a;
            int r101 = this.f540448a;
            ImageRecognitionEntry r102 = this.f540452e;
            Intrinsics.checkNotNullParameter(r102, "entry");
            e.a("livesdk_identify_object_button_show", r101, r102);
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final int getDescRes() {
            return this.f540449b;
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final int getIconRes() {
            return this.f540450c;
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final int getScene() {
            return this.f540448a;
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final String getBtmToken(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            return this.f540451d.getBtmToken(r100);
        }

        @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            String r101 = this.f540451d.getBtmToken(r100);
            IImageRecognitionService r102 = (IImageRecognitionService) k.f(IImageRecognitionService.class);
            if (r102 == null) goto L5;
            r102.recognize(this.f540451d.getScene(), this.f540452e, r101);
        L5:
            this.f540451d.onClick(r100);
            int r103 = e.f540453a;
            int r104 = this.f540448a;
            ImageRecognitionEntry r105 = this.f540452e;
            Intrinsics.checkNotNullParameter(r105, "entry");
            e.a("livesdk_identify_object_button_click", r104, r105);
        }

        public a(ImageRecognitionButton r100, ImageRecognitionEntry r101) {
            Intrinsics.checkNotNullParameter(r100, "button");
            Intrinsics.checkNotNullParameter(r101, "entry");
            this.f540451d = r100;
            this.f540452e = r101;
            this.f540448a = r100.getScene();
            this.f540449b = r100.getDescRes();
            this.f540450c = r100.getIconRes();
        }
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness
    public final ScaleConfig getScaleConfig() {
        return this.f540447a.getScaleConfig();
    }

    public d(ImageRecognitionBusiness r100) {
        Intrinsics.checkNotNullParameter(r100, "business");
        this.f540447a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness
    public final ImageRecognitionButton provide(ImageRecognitionEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        ImageRecognitionButton r101 = this.f540447a.provide(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new a(r101, r100);
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness
    public final void onInjectExtra(Context r100, ImageRecognitionEntry r101, StreamRecognitionResponse r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "entry");
        Intrinsics.checkNotNullParameter(r102, "res");
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.f540447a.onInjectExtra(r100, r101, r102, r103);
    }
}
