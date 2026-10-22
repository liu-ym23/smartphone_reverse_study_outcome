package com.bytedance.ee.drive.preview;

import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface e extends d {
    boolean B1();

    int c3(String r1);

    Class<? extends AbsPreviewView> ca(int r1, z r2);

    Class<? extends AbsLoadingView> f4(int r1, z r2);

    Map<String, String> oc(String r1);

    boolean pa();
}
