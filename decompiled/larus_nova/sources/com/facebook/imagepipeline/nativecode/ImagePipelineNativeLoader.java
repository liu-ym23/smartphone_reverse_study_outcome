package com.facebook.imagepipeline.nativecode;

import com.facebook.imageutils.FrescoSoLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePipelineNativeLoader {
    public static final List<String> DEPENDENCIES = null;
    public static final String DSO_NAME = "imagepipeline";

    public ImagePipelineNativeLoader() {
    }

    static {
        DEPENDENCIES = Collections.unmodifiableList(new ArrayList());
    }

    public static void load() {
        FrescoSoLoader.loadLibrary(DSO_NAME);
    }
}
