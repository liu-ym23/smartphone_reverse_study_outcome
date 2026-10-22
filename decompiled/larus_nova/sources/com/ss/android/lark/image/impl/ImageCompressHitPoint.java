package com.ss.android.lark.image.impl;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q5c.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/image/impl/ImageCompressHitPoint;", "Lcom/ss/android/lark/statistics/base/BaseHitPoint;", "Lcom/ss/android/lark/statistics/base/IHitPoint;", "<init>", "()V", "Param", "Companion", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageCompressHitPoint extends a {
    public static final int $stable = 0;
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jt\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/image/impl/ImageCompressHitPoint$Companion;", "", "<init>", "()V", "TAG", "", "EVENT_NAME_COMPRESS", "sendImageCompress", "", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "scene", "Lcom/ss/android/lark/appreciablelib/Scene;", "totalCost", "isSuccess", "", "imageType", "resourceContentLength", "", "resourceWidth", "resourceHeight", "uploadContentLength", "uploadWidth", "uploadHeight", "resourceFrames", "errorCode", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final void sendImageCompress(Biz r100, Scene r101, String r102, boolean r110, String r111, long r112, long r113, long r114, long r115, long r210, long r211, long r212, long r213) {
            Intrinsics.checkNotNullParameter(r102, "totalCost");
            Intrinsics.checkNotNullParameter(r111, "imageType");
            JSONObject r103 = new JSONObject();
            if (r100 == null) goto L5;
            r103.put("biz", r100.getValue());
        L5:
            if (r101 == null) goto L7;
            r103.put("scene", r101.getValue());
        L7:
            r103.put("total_cost", r102).put("is_success", r110).put("error_code", r213).put("image_type", r111).put("resource_content_length", r112).put("resource_width", r113).put("resource_height", r114).put("resource_frames", r212).put("upload_content_length", r115).put("upload_width", r210).put("upload_height", r211);
            Log.d("ImageCompressHitPoint", r103.toString());
            Statistics.sendEvent("image_compress_dev", r103);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    @JvmStatic
    public static final void sendImageCompress(Biz r210, Scene r211, String r212, boolean r213, String r214, long r215, long r216, long r310, long r311, long r312, long r313, long r314, long r410) {
        Companion.sendImageCompress(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r410);
    }
}
