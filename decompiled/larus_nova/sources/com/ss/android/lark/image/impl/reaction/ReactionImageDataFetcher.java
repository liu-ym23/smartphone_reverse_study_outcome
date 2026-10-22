package com.ss.android.lark.image.impl.reaction;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.entity.ReactionImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.a0;
import java.io.FileNotFoundException;
import java.io.InputStream;
import qpc.e;

/* JADX INFO: loaded from: classes36.dex */
public class ReactionImageDataFetcher extends ResourceImageDataFetcher<ReactionImage> {
    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "ReactionImageFetcher";
    }

    public ReactionImageDataFetcher(ReactionImage r100) {
        super(r100);
    }

    private String getReactionImagePath(ReactionImage r100) {
        e r101 = (e) ApiUtils.getApi(e.class);
        String r102 = a0.g(LarkContext.getApplication());
        return r101.getImageService().getReactionImage(r102, r100.getReactionKey());
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(ReactionImage r100) throws FileNotFoundException {
        String r101 = getReactionImagePath(r100);
        Log.i("ReactionImageFetcher", "load reaction image, key is:" + r100.getReactionKey() + ", path is:" + r101);
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return null;
    L7:
        return new PolarisFileInputStreamWrapper(r101);
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(ReactionImage r100) throws FileNotFoundException {
        return getResourceStream2(r100);
    }
}
