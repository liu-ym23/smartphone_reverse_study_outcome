package com.larus.bmhome.upload.sdk.api.ext;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hs8.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/ext/ImageUploadSdkBuilderFactoryDelegate;", "Lcom/larus/bmhome/upload/sdk/api/ext/IImageUploadSdkBuilderFactory;", "<init>", "()V", "createBuilder", "Lcom/larus/bmhome/upload/sdk/api/ext/ImageUploadSdkBuilder;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadSdkBuilderFactoryDelegate implements IImageUploadSdkBuilderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageUploadSdkBuilderFactoryDelegate f314807a = null;

    static {
        f314807a = new ImageUploadSdkBuilderFactoryDelegate();
    }

    private ImageUploadSdkBuilderFactoryDelegate() {
    }

    @Override // com.larus.bmhome.upload.sdk.api.ext.IImageUploadSdkBuilderFactory
    public final b a() {
        IImageUploadSdkBuilderFactory r100 = (IImageUploadSdkBuilderFactory) ServiceManager.get().getService(IImageUploadSdkBuilderFactory.class);
        if (r100 == null) goto L10;
        b r101 = r100.a();
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new IllegalStateException("IImageUploadSdkBuilderFactory#createBuilder returned null. Please ensure upload impl service wiring is correct.".toString());
    L10:
        throw new IllegalStateException("IImageUploadSdkBuilderFactory service is missing. Please ensure upload impl is included at runtime.".toString());
    }
}
