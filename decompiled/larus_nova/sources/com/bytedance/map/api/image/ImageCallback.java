package com.bytedance.map.api.image;

import android.graphics.Bitmap;
import com.bytedance.map.api.exception.BDMapException;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface ImageCallback {
    void onFail(BDMapException r100);

    void onSuccess(Bitmap r100);

    void onSuccess(List<Bitmap> r100);
}
