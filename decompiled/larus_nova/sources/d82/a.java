package d82;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.StreamRecognitionResponse;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements ImageRecognitionBusiness {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness
    public final ScaleConfig getScaleConfig() {
        return s32.b.d(1);
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness
    public final void onInjectExtra(Context r100, ImageRecognitionEntry r101, StreamRecognitionResponse r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "entry");
        Intrinsics.checkNotNullParameter(r102, "res");
        Intrinsics.checkNotNullParameter(r103, "extra");
    }

    @Override // com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness
    public final ImageRecognitionButton provide(ImageRecognitionEntry r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        return new c(r100);
    }
}
