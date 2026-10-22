package com.ss.android.lark.image.impl.compress2;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes36.dex */
public interface IImageSource {
    String getPath();

    InputStream open() throws IOException;

    String uniqueKey();
}
