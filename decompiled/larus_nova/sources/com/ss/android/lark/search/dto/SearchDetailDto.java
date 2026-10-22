package com.ss.android.lark.search.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class SearchDetailDto implements Serializable {
    private static final long serialVersionUID = -2300030951015274777L;
    public final String bitmapKey;
    public final int fromType;
    public final int resultType;
    public final Scene.Type sceneType;
    public final int translateY;

    public static /* synthetic */ class a {
    }

    public static final class b {
        public b() {
        }
    }

    public static b newBuilder() {
        return new b();
    }

    public SearchDetailDto(b r100, a r101) {
        r100.getClass();
        this.translateY = 0;
        this.sceneType = null;
        this.bitmapKey = null;
        this.fromType = 1;
        this.resultType = 0;
    }
}
