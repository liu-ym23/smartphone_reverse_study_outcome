package com.bytedance.common.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes15.dex */
public class HoneyCombMR2V13Compat {
    static final BaseImpl IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.common.util.HoneyCombMR2V13Compat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public void getDisplaySize(Display r100, Point r101) {
            throw null;
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r100) {
            this();
        }
    }

    public static class HoneyCombMR2Impl extends BaseImpl {
        private HoneyCombMR2Impl() {
            super(null);
        }

        public /* synthetic */ HoneyCombMR2Impl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.common.util.HoneyCombMR2V13Compat.BaseImpl
        public void getDisplaySize(Display r100, Point r101) {
            r100.getSize(r101);
        }
    }

    static {
        IMPL = new HoneyCombMR2Impl(null);
    }

    public static void getDisplaySize(Context r100, Point r101) {
        getDisplaySize(((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay(), r101);
    }

    public static void getDisplaySize(Display r100, Point r101) {
        IMPL.getDisplaySize(r100, r101);
    }
}
