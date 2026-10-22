package com.larus.bmhome.upload.sdk.impl.spi;

import com.larus.bmhome.upload.sdk.api.ext.IImageUploadSdkBuilderFactory;
import hs8.b;
import kotlin.Metadata;
import ls8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/upload/sdk/impl/spi/ImageUploadSdkBuilderFactoryImpl;", "Lcom/larus/bmhome/upload/sdk/api/ext/IImageUploadSdkBuilderFactory;", "<init>", "()V", "createBuilder", "Lcom/larus/bmhome/upload/sdk/api/ext/ImageUploadSdkBuilder;", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadSdkBuilderFactoryImpl implements IImageUploadSdkBuilderFactory {
    public ImageUploadSdkBuilderFactoryImpl() {
    }

    @Override // com.larus.bmhome.upload.sdk.api.ext.IImageUploadSdkBuilderFactory
    public final b a() {
        return new a(new com.larus.bmhome.upload.sdk.impl.a());
    }
}
